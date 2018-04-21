package feature;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AutocolorCorrelogram implements Feature {

    private float[][] correlogramR;
    private float[][] correlogramG;
    private float[][] correlogramB;
    private int maxFeatureValue;
    private int[] distanceSet;

    public AutocolorCorrelogram() {
        this.maxFeatureValue = 256;
        this.distanceSet = new int[4];
        this.distanceSet[0] = 1;
        this.distanceSet[1] = 2;
        this.distanceSet[2] = 3;
        this.distanceSet[3] = 4;
    }

    public float[][] getCorrelogramR() {
        return correlogramR;
    }

    public float[][] getCorrelogramG() {
        return correlogramG;
    }

    public float[][] getCorrelogramB() {
        return correlogramB;
    }

    @Override
    public void extract(BufferedImage image) {
        int[] histogramR = new int[maxFeatureValue];
        int[] histogramG = new int[maxFeatureValue];
        int[] histogramB = new int[maxFeatureValue];
        this.correlogramR = new float[maxFeatureValue][distanceSet.length];
        this.correlogramG = new float[maxFeatureValue][distanceSet.length];
        this.correlogramB = new float[maxFeatureValue][distanceSet.length];

        final int H = image.getHeight();
        final int W = image.getWidth();

        int N_DIST = distanceSet.length;
        for (int di = 0; di < N_DIST; ++di) {
            int d = distanceSet[di];
            //for each pixel $p$
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    Color c = new Color(image.getRGB(x,y));
                    histogramR[c.getRed()]++;
                    histogramG[c.getGreen()]++;
                    histogramB[c.getBlue()]++;

                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y - d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && (new Color(image.getRGB(dy, dx)).equals(c))) {
                            this.correlogramR[c.getRed()][di]++;
                            this.correlogramG[c.getGreen()][di]++;
                            this.correlogramB[c.getBlue()][di]++;
                        }
                    }

                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y + d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && (new Color(image.getRGB(dy, dx)).equals(c))) {
                            this.correlogramR[c.getRed()][di]++;
                            this.correlogramG[c.getGreen()][di]++;
                            this.correlogramB[c.getBlue()][di]++;
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x - d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && (new Color(image.getRGB(dy, dx)).equals(c))) {
                            this.correlogramR[c.getRed()][di]++;
                            this.correlogramG[c.getGreen()][di]++;
                            this.correlogramB[c.getBlue()][di]++;
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x + d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && (new Color(image.getRGB(dy, dx)).equals(c))) {
                            this.correlogramR[c.getRed()][di]++;
                            this.correlogramG[c.getGreen()][di]++;
                            this.correlogramB[c.getBlue()][di]++;
                        }
                    }
                }
            }

            for (int i = 0; i < maxFeatureValue; i++)
                if (histogramR[i] > 0)
                    this.correlogramR[i][di] = (this.correlogramR[i][di] / histogramR[i]);
            for (int i = 0; i < maxFeatureValue; i++)
                if (histogramG[i] > 0)
                    this.correlogramG[i][di] = (this.correlogramG[i][di] / histogramG[i]);
            for (int i = 0; i < maxFeatureValue; i++)
                if (histogramB[i] > 0)
                    this.correlogramB[i][di] = (this.correlogramB[i][di] / histogramB[i]);
        }
    }

    @Override
    public double getDistance(Feature feature) {
        AutocolorCorrelogram autocolorCorrelogram = (AutocolorCorrelogram) feature;
        float[][] otherCorrelogramR = autocolorCorrelogram.getCorrelogramR();
        float[][] otherCorrelogramG = autocolorCorrelogram.getCorrelogramG();
        float[][] otherCorrelogramB = autocolorCorrelogram.getCorrelogramB();
        double distanceR = 0;
        double distanceG = 0;
        double distanceB = 0;
        double distance;
        for (int i=0; i<otherCorrelogramR.length; i++) {
            for (int j=0; j<otherCorrelogramR[0].length; j++) {
                distanceR+=(Math.abs(otherCorrelogramR[i][j] - this.correlogramR[i][j]) / (1 + otherCorrelogramR[i][j] + this.correlogramR[i][j]));
            }
        }
        for (int i=0; i<otherCorrelogramG.length; i++) {
            for (int j=0; j<otherCorrelogramG[0].length; j++) {
                distanceG+=(Math.abs(otherCorrelogramG[i][j] - this.correlogramG[i][j]) / (1 + otherCorrelogramG[i][j] + this.correlogramG[i][j]));
            }
        }
        for (int i=0; i<otherCorrelogramB.length; i++) {
            for (int j=0; j<otherCorrelogramB[0].length; j++) {
                distanceB+=(Math.abs(otherCorrelogramB[i][j] - this.correlogramB[i][j]) / (1 + otherCorrelogramB[i][j] + this.correlogramB[i][j]));
            }
        }
        distance = (distanceR + distanceG + distanceB) / 3;
        return distance;
    }
}
