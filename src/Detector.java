import model.BlockImage;
import model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class Detector {

    private static double similarityTreshold;
    private static String detectionType;

    private Detector(){}

    public static void setSimilarityTreshold(double similarityTreshold) {
        Detector.similarityTreshold = similarityTreshold;
    }

    public static void setDetectionType(String detectionType) {
        Detector.detectionType = detectionType;
    }

    public static BufferedImage detect(Image image) {
        BufferedImage bufferedImage = image.getOriginalImage();
        Graphics2D g = bufferedImage.createGraphics();
        g = detectDuplicatedBlocks(image, g);
        g.dispose();
        return bufferedImage;
    }

    private static Graphics2D detectDuplicatedBlocks(Image image, Graphics2D g) {
        BlockImage[][] blockImages = image.getBlockImages();
        int blockSize = image.getBlockSize();
        for (int i=0; i<(blockImages.length * blockImages[0].length); i++) {
            if ((i % 100) == 0)
                System.out.println("compared "+i+" images from "+(blockImages.length * blockImages[0].length)+" images");
            for (int j=(i+1); j<(blockImages.length * blockImages[0].length); j++) {
                int x1 = i % blockImages[0].length;
                int y1 = i / blockImages.length;
                int x2 = j % blockImages[0].length;
                int y2 = j / blockImages.length;
                if (blockImages[y1][x1].similarity(blockImages[y2][x2]) < similarityTreshold) {
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
}
