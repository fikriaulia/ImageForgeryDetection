package imageforgerydetection;

import feature.ApproximateColorCorrelogram;
import feature.AutocolorCorrelogram;
import feature.ColorCorrelation;
import feature.Feature;
import model.BlockAffine;
import model.BlockImage;
import model.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.System.exit;


public final class Praprocessor {


    private static int blockSize;
    private static String featureType;

    public static void setBlockSize(int blockSize) {
        Praprocessor.blockSize = blockSize;
    }

    public static void setFeatureType(String featureType) {
        Praprocessor.featureType = featureType;
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
                BufferedImage blockBufferedImage = generateBlockBufferedImage(originalImage, x, y);
                BlockAffine[] blockAffines = generateTransformBlockAffine(originalImage, x, y);
                BlockImage blockImage = new BlockImage();
                blockImage.setImage(blockBufferedImage);
                blockImage.setBlockAffines(blockAffines);
                blockImages[x][y] = blockImage;
            }
        }
        return blockImages;
    }

    private static BufferedImage generateBlockBufferedImage(BufferedImage originalImage, int x, int y) {
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

    private static BufferedImage generateBlockTransformImage(BufferedImage originalImage, int x, int y) {
        BufferedImage blockImage = new BufferedImage(blockSize, blockSize, originalImage.getType());
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                if (((x + i) >= originalImage.getHeight()) || ((y + j) >= originalImage.getWidth())) {
                    blockImage.setRGB(i, j, 0);
                } else {
                    blockImage.setRGB(i, j, originalImage.getRGB(x + i, y + j));
                }
            }
        }
        return blockImage;
    }
    
    private static BlockAffine[] generateTransformBlockAffine(BufferedImage originalImage, int x, int y) {
        ArrayList<BlockAffine> blockAffines = new ArrayList<BlockAffine>();
        ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
        for (int i = (-1 * (blockSize/2)); i<(blockSize/2); i+=2) {
            for (int j = (-1 * (blockSize/2)); j<(blockSize/2); j+=2) {
                if (((x*blockSize+i) >= 0) && ((y*blockSize+j) >= 0)) {
                    BufferedImage transformedImage = generateBlockTransformImage(originalImage, x*blockSize+i, y*blockSize+j);
                    if ((i == 0) && (j == 0)) {
                        bufferedImages.add(0, transformedImage);
                    } else {
                        bufferedImages.add(transformedImage);
                    }
                }
            }
        }
        for (BufferedImage bufferedImage: bufferedImages
             ) {
            BlockAffine blockAffine = new BlockAffine();
            Feature feature;
            switch (featureType) {
                case "Autocolor Correlogram":
                    feature = new AutocolorCorrelogram();
                    break;
                case "Color Correlation":
                    feature = new ColorCorrelation();
                    break;
                default:
                    feature = new ApproximateColorCorrelogram();
                    break;
            }
            feature.extract(bufferedImage);
            blockAffine.setImage(bufferedImage);
            blockAffine.setFeature(feature);
            blockAffines.add(blockAffine);
        }
        BlockAffine[] result = new BlockAffine[blockAffines.size()];
        for (int i = 0; i<result.length; i++) {
            result[i] = blockAffines.get(i);
        }
        return result;
    }
}
