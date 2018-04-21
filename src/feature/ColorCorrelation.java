/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feature;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author fikriaulia
 */
public class ColorCorrelation implements Feature{
    
    private int[][]correlogramR;
    private int[][]correlogramG;
    private int[][]correlogramB;
    private int maxFeatureValue;
    private int[] distanceSet;

    public ColorCorrelation() {
        this.maxFeatureValue = 256;
        this.distanceSet = new int[4];
        this.distanceSet[0] = 1;
        this.distanceSet[1] = 2;
        this.distanceSet[2] = 3;
        this.distanceSet[3] = 4;
    }
    
    public int[][] getCorrelogramR() {
        return this.correlogramR;
    }
    
    public int[][] getCorrelogramG() {
        return this.correlogramG;
    }
    
    public int[][] getCorrelogramB() {
        return this.correlogramB;
    }
    
    @Override
    public void extract(BufferedImage image) {
//        this.correlogram = new Color[image.getHeight()][image.getWidth()][distanceSet.length];
        correlogramR = new int[maxFeatureValue][distanceSet.length];
        correlogramG = new int[maxFeatureValue][distanceSet.length];
        correlogramB = new int[maxFeatureValue][distanceSet.length];
        final int imageHeight = image.getHeight();
        final int imageWidth = image.getWidth();

        int N_DIST = distanceSet.length;
        for (int di = 0; di < N_DIST; ++di) {
            int countPixel = 0;
            int d = distanceSet[di];
            //for each pixel $p$
            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    Color currentPixelColor = new Color(image.getRGB(x, y));
                    int currentPixelR = currentPixelColor.getRed();
                    int currentPixelG = currentPixelColor.getGreen();
                    int currentPixelB = currentPixelColor.getBlue();
                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y - d;
                        if (dx >= 0 && dx < imageWidth && dy >= 0 && dy < imageHeight ) {
                            Color neighborPixelColor = new Color(image.getRGB(dy, dx));
                            if (!currentPixelColor.equals(neighborPixelColor)) {
                                correlogramR[currentPixelR][di] += neighborPixelColor.getRed();
                                correlogramG[currentPixelG][di] += neighborPixelColor.getGreen();
                                correlogramB[currentPixelB][di] += neighborPixelColor.getBlue();
                                countPixel++;
                            }
                        }
                    }

                    for (int dx = (x - d); dx <= (x+d); dx++) {
                        int dy = y + d;
                        if (dx >= 0 && dx < imageWidth && dy >= 0 && dy < imageHeight) {
                            Color neighborPixelColor = new Color(image.getRGB(dy, dx));
                            if (!currentPixelColor.equals(neighborPixelColor)) {
                                correlogramR[currentPixelR][di] += neighborPixelColor.getRed();
                                correlogramG[currentPixelG][di] += neighborPixelColor.getGreen();
                                correlogramB[currentPixelB][di] += neighborPixelColor.getBlue();
                                countPixel++;
                            }
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x - d;
                        if (dx >= 0 && dx < imageWidth && dy >= 0 && dy < imageHeight) {
                            Color neighborPixelColor = new Color(image.getRGB(dy, dx));
                            if (!currentPixelColor.equals(neighborPixelColor)) {
                                correlogramR[currentPixelR][di] += neighborPixelColor.getRed();
                                correlogramG[currentPixelG][di] += neighborPixelColor.getGreen();
                                correlogramB[currentPixelB][di] += neighborPixelColor.getBlue();
                                countPixel++;
                            }
                        }
                    }

                    for (int dy = (y - d + 1); dy <= ( y + d - 1); dy++) {
                        int dx = x + d;
                        if (dx >= 0 && dx < imageWidth && dy >= 0 && dy < imageHeight) {
                            Color neighborPixelColor = new Color(image.getRGB(dy, dx));
                            if (currentPixelColor.equals(neighborPixelColor)) {
                                correlogramR[currentPixelR][di] += neighborPixelColor.getRed();
                                correlogramG[currentPixelG][di] += neighborPixelColor.getGreen();
                                correlogramB[currentPixelB][di] += neighborPixelColor.getBlue();
                                countPixel++;
                            }
                        }
                    }
                    if (countPixel > 0) {
                        correlogramR[currentPixelR][di] = correlogramR[currentPixelR][di] / countPixel;
                        correlogramG[currentPixelG][di] = correlogramG[currentPixelG][di] / countPixel;
                        correlogramB[currentPixelB][di] = correlogramB[currentPixelB][di] / countPixel;
                    }
                }
            }
        }
    }

    @Override
    public double getDistance(Feature feature) {
        ColorCorrelation colorCorrelation = (ColorCorrelation) feature;
        int[][] otherCorrelogramR = colorCorrelation.getCorrelogramR();
        int[][] otherCorrelogramG = colorCorrelation.getCorrelogramG();
        int[][] otherCorrelogramB = colorCorrelation.getCorrelogramB();
        
        double distanceR = 0;
        double distanceG = 0;
        double distanceB = 0;
        
        for (int i = 0; i < otherCorrelogramR.length; i++) {
            for (int j = 0; j < otherCorrelogramR[0].length; j++) {
                distanceR+= (double) Math.abs(otherCorrelogramR[i][j] - this.correlogramR[i][j]) / (1 + otherCorrelogramR[i][j] + this.correlogramR[i][j]);
            }
        }
        
        for (int i = 0; i < otherCorrelogramG.length; i++) {
            for (int j = 0; j < otherCorrelogramG[0].length; j++) {
                distanceG+= (double) Math.abs(otherCorrelogramG[i][j] - this.correlogramG[i][j]) / (1 + otherCorrelogramG[i][j] + this.correlogramG[i][j]);
            }
        }
        
        for (int i = 0; i < otherCorrelogramB.length; i++) {
            for (int j = 0; j < otherCorrelogramB[0].length; j++) {
                distanceB+= (double) Math.abs(otherCorrelogramB[i][j] - this.correlogramB[i][j]) / (1 + otherCorrelogramB[i][j] + this.correlogramB[i][j]);
            }
        }

        double distance = (distanceR + distanceG + distanceB) / 3;

        return distance;
    }
    
}
