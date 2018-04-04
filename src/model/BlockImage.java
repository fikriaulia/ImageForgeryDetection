package model;

import feature.Feature;

import java.awt.image.BufferedImage;

public class BlockImage {
    private BufferedImage image;
    private BlockAffine[] blockAffines;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BlockAffine[] getBlockAffines() {
        return blockAffines;
    }

    public void setBlockAffines(BlockAffine[] blockAffines) {
        this.blockAffines = blockAffines;
    }

    public double similarity(BlockImage blockImage) {
        double minimumDistance = Double.MAX_VALUE;
        for (BlockAffine baseBlockAffine: blockAffines
             ) {
            for (BlockAffine comparedBlockAffine: blockImage.getBlockAffines()
                 ) {
                Feature baseAffineFeature = baseBlockAffine.getFeature();
                Feature comparedAffineFeature = comparedBlockAffine.getFeature();
                double distance = baseAffineFeature.getDistance(comparedAffineFeature);
                if (distance < minimumDistance) {
                    minimumDistance = distance;
                }
            }
        }
        return minimumDistance;
    }
}
