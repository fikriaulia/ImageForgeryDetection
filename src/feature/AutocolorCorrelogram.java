package feature;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AutocolorCorrelogram implements Feature {

    private float[][] correlogram;
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

    public float[][] getCorrelogram() {
        return correlogram;
    }

    @Override
    public void extract(BufferedImage image) {
        int[][] img = generateMatrixIntImage(image);

        int[] histogram = new int[maxFeatureValue];
        this.correlogram = new float[maxFeatureValue][distanceSet.length];

        final int H = img.length;
        final int W = img[0].length;

        int N_DIST = distanceSet.length;
        for (int di = 0; di < N_DIST; ++di) {
            int d = distanceSet[di];
            //for each pixel $p$
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    int c = img[x][y];
                    histogram[c]++;

                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y - d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && img[dy][dx] == c) {
                            this.correlogram[c][di]++;
                        }
                    }

                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y + d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && img[dy][dx] == c) {
                            this.correlogram[c][di]++;
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x - d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && img[dy][dx] == c) {
                            this.correlogram[c][di]++;
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x + d;
                        if (dx >= 0 && dx < W && dy >= 0 && dy < H && img[dy][dx] == c) {
                            this.correlogram[c][di]++;
                        }
                    }
                }
            }

            for (int c = 0; c < maxFeatureValue; ++c)
                if (histogram[c] > 0)
                    this.correlogram[c][di] = (this.correlogram[c][di] / histogram[c]);
        }
    }

    private int[][] generateMatrixIntImage(BufferedImage image) {
        int[][] matrixIntImage = new int[image.getHeight()][image.getWidth()];
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int greyColor = RGBtoGrey(image.getRGB(i, j));
                matrixIntImage[i][j] = greyColor;
            }
        }
        return matrixIntImage;
    }

    private int RGBtoGrey(int RGB) {
        Color c = new Color(RGB);
        int red = (int)(c.getRed() * 0.299);
        int green = (int)(c.getGreen() * 0.587);
        int blue = (int)(c.getBlue() *0.114);
        int grey = red+green+blue;
        return grey;
    }

    @Override
    public double getDistance(Feature feature) {
        AutocolorCorrelogram autocolorCorrelogram = (AutocolorCorrelogram) feature;
        float[][] otherCorrelogram = autocolorCorrelogram.getCorrelogram();
        double distance = 0;
        for (int i=0; i<otherCorrelogram.length; i++) {
            for (int j=0; j<otherCorrelogram[0].length; j++) {
                distance+=(Math.abs(otherCorrelogram[i][j] - this.correlogram[i][j]) / (1 + otherCorrelogram[i][j] + this.correlogram[i][j]));
            }
        }
        return distance;
    }
}
