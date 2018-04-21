package model;

import feature.Feature;
import imageforgerydetection.IO;
import sun.jvm.hotspot.opto.Block;

import java.awt.image.BufferedImage;

import static java.lang.System.exit;

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
        BlockAffine baseBlockAffine = blockAffines[0];
        for (BlockAffine comparedBlockAffine: blockImage.getBlockAffines()
                ) {
            Feature baseAffineFeature = baseBlockAffine.getFeature();
            Feature comparedAffineFeature = comparedBlockAffine.getFeature();
            double distance = baseAffineFeature.getDistance(comparedAffineFeature);
            if (distance < minimumDistance) {
                minimumDistance = distance;
            }
        }

        return minimumDistance;
    }

    public void printAffine() {
        System.out.println("===> "+blockAffines.length);
        IO.writeImage(this.image,"result/base_image.png", "png");
        int i = 0;
        for (BlockAffine blockAffine: blockAffines
             ) {
            i++;
            System.out.println(i);
            IO.writeImage(blockAffine.getImage(),"result/image"+i+".png", "png");
        }
        exit(1);
    }
}
