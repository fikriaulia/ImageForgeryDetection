import feature.AutocolorCorrelogram;
import feature.Feature;
import model.BlockAffine;
import model.BlockImage;
import model.Image;

import java.awt.image.BufferedImage;

public final class Praprocessor {


    private static int blockSize;
    private static String affineType;
    private static Feature feature;

    public static void setBlockSize(int blockSize) {
        Praprocessor.blockSize = blockSize;
    }

    public static void setAffineType(String affineType) {
        Praprocessor.affineType = affineType;
    }

    public static void setFeature(Feature feature) {
        Praprocessor.feature = feature;
    }

    private Praprocessor() {
    }

    public static Image generateImage(BufferedImage originalImage) {
        BlockImage[][] blockImages = generateBlockImage(originalImage);
        Image image = new Image();
        image.setBlockImages(blockImages);
        image.setOriginalImage(originalImage);
        image.setBlockSize(blockSize);
        return image;
    }

    private static BlockImage[][] generateBlockImage(BufferedImage originalImage) {
        int imageHeight = originalImage.getHeight();
        int imageWidth = originalImage.getWidth();
        BlockImage[][] blockImages = new BlockImage[imageWidth / blockSize][imageHeight / blockSize];
        for (int x = 0; x < (blockImages.length); x++) {
            for (int y = 0; y < (blockImages[0].length); y++) {
                BufferedImage blockBufferedImage = generateBLockBufferedImage(originalImage, x, y);
                BlockAffine[] blockAffines = generateBlockAffines(blockBufferedImage);
                BlockImage blockImage = new BlockImage();
                blockImage.setImage(blockBufferedImage);
                blockImage.setBlockAffines(blockAffines);
                blockImages[x][y] = blockImage;
            }
        }
        return blockImages;
    }

    private static BufferedImage generateBLockBufferedImage(BufferedImage originalImage, int x, int y) {
        BufferedImage blockImage = new BufferedImage(blockSize, blockSize, originalImage.getType());
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                if (((x * blockSize + i) >= originalImage.getHeight()) || ((y * blockSize + j) >= originalImage.getWidth())) {
                    blockImage.setRGB(i, j, 0);
                } else {
                    blockImage.setRGB(i, j, originalImage.getRGB(x * blockSize + i, y * blockSize + j));
                }
            }
        }
        return blockImage;
    }

    private static BlockAffine[] generateBlockAffines(BufferedImage blockBufferedImage) {
        BlockAffine[] blockAffines = new BlockAffine[1];
        for (int i = 0; i<1; i++) {
            BlockAffine blockAffine = new BlockAffine();
            Feature feature = new AutocolorCorrelogram();
            feature.extract(blockBufferedImage);
            blockAffine.setImage(blockBufferedImage);
            blockAffine.setFeature(feature);
            blockAffines[i] = blockAffine;
        }
        return blockAffines;
    }
}
