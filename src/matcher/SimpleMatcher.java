package matcher;

import feature.Feature;
import java.awt.Color;
import java.awt.Graphics2D;
import model.BlockImage;
import model.Image;

public class SimpleMatcher implements Matcher {

    @Override
    public Graphics2D detectDuplicatedBlocks(Image image, Graphics2D g, double treshold) {
        BlockImage[][] blockImages = image.getBlockImages();
        double tempDistance = Double.MAX_VALUE;
        int blockSize = image.getBlockSize();
        for (int i=0; i<(blockImages.length * blockImages[0].length); i++) {
            int x1 = i % blockImages[0].length;
            int y1 = i / blockImages.length;
            if ((i % 100) == 0)
                System.out.println("compared "+i+" images from "+(blockImages.length * blockImages[0].length)+" images");
            for (int j=0; j<(blockImages.length * blockImages[0].length); j++) {
//            for (int j=(i+1); j<(blockImages.length * blockImages[0].length); j++) {

                if (i != j) {
                    int x2 = j % blockImages[0].length;
                    int y2 = j / blockImages.length;
                    double distance = blockImages[y1][x1].similarity(blockImages[y2][x2]);
                    if (distance < tempDistance) {
                        if (distance != 0) {
                            tempDistance = distance;
                            System.out.println(tempDistance);
                        }
                    }
                    if (distance <= treshold) {
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
        }
        return g;
    }

    @Override
    public void setFeatureType(String feature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
