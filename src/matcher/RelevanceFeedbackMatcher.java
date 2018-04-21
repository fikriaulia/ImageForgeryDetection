package matcher;

import feature.ApproximateColorCorrelogram;
import feature.AutocolorCorrelogram;
import feature.Feature;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.BlockImage;
import model.Image;

public class RelevanceFeedbackMatcher implements Matcher {
    
    private String featureType;

    @Override
    public Graphics2D detectDuplicatedBlocks(Image image, Graphics2D g, double originalTreshold) {
        BlockImage[][] blockImages = image.getBlockImages();
        double tempDistance = Double.MAX_VALUE;
        int blockSize = image.getBlockSize();
        for (int i=0; i<(blockImages.length * blockImages[0].length); i++) {
            int x1 = i % blockImages[0].length;
            int y1 = i / blockImages.length;
            double treshold = generateTreshold(image, x1, y1);
            if ((i % 100) == 0)
                System.out.println("compared "+i+" images from "+(blockImages.length * blockImages[0].length)+" images");
            for (int j=(i+1); j<(blockImages.length * blockImages[0].length); j++) {
                int x2 = j % blockImages[0].length;
                int y2 = j / blockImages.length;
                double distance = blockImages[y1][x1].similarity(blockImages[y2][x2]);
                if (distance < tempDistance) {
                    tempDistance = distance;
                    System.out.println(tempDistance);
                }
                if (distance < treshold) {
                    int blockCenterDiff = blockSize / 2;
                    g.setColor(new Color(0x1EEC20));
                    g.drawLine(
                            y1 * blockSize + blockCenterDiff,
                            x1 * blockSize + blockCenterDiff,
                            y2 * blockSize + blockCenterDiff,
                            x2 * blockSize + blockCenterDiff);
                }
            }
        }
        return g;
    }

    private double generateTreshold(Image image, int x, int y) {
        double tresholdTransformParameter = 0.5;
        Feature[] features = generateTransformFeature(image, x, y);
        Feature baseFeature = generateFeature(image.getBlockImage(x, y).getImage());
        double distance = 0;
        for (int i = 0; i < features.length; i++) {
            double similarity = baseFeature.getDistance(features[i]);
            distance += (similarity * tresholdTransformParameter);
        }
        return distance/features.length;
    }

    private  Feature[] generateTransformFeature(Image image, int x, int y) {
        BufferedImage[] bufferedImages = generateBufferedImageFromBasePoint(image.getOriginalImage(), x, y, image.getBlockSize());

        Feature[] features = new Feature[bufferedImages.length];
        for (int i = 0; i < bufferedImages.length; i++) {
            Feature feature = generateFeature(bufferedImages[i]);
            features[i] = feature;
        }
        return features;
    }
    
    private BufferedImage[] generateBufferedImageFromBasePoint(BufferedImage image, int x, int y, int blockSize) {
        int transformParameter = 1;
        ArrayList<BufferedImage> bufferedImageArrayList = new ArrayList<BufferedImage>();
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i != 0) && (j != 0)) {
                    int transX = x*blockSize + i*transformParameter;
                    int transY = y*blockSize + j*transformParameter;
                    if ((transX >= 0) && (transY >= 0)) {
                        BufferedImage bufferedImage = generateSingleBufferedImageFromBasePoint(image, transX, transY, blockSize);
                        if (bufferedImage != null) {
                            bufferedImageArrayList.add(bufferedImage);
                        }
                    }
                }
            }
        }
        BufferedImage[] bufferedImages = new BufferedImage[bufferedImageArrayList.size()];
        for (int i = 0; i < bufferedImages.length; i++) {
            bufferedImages[i] = bufferedImageArrayList.get(i);
        }
        return bufferedImages;
    }
    
    private BufferedImage generateSingleBufferedImageFromBasePoint(BufferedImage image, int x, int y, int blockSize) {
        BufferedImage blockImage = new BufferedImage(blockSize, blockSize, image.getType());
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                if (((x + i) >= image.getWidth()) || ((y + j) >= image.getHeight())) {
                    return null;
                } else {
                    blockImage.setRGB(i, j, image.getRGB(x + i, y + j));
                }
            }
        }
        return blockImage;
    }
    
    private Feature generateFeature(BufferedImage image) {
        Feature feature;
        if (this.featureType.equals("Autocolor Correlogram")) {
            feature = new AutocolorCorrelogram();
        } else {
            feature = new ApproximateColorCorrelogram();
        }
        feature.extract(image);
        return feature;
    }

    @Override
    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }
}
