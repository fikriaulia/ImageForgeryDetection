package model;

import model.BlockImage;
import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage originalImage;
    private BlockImage[][] blockImages;
    private int blockSize;

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public BlockImage getBlockImage(int x, int y) {
        return this.blockImages[x][y];
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BlockImage[][] getBlockImages() {
        return blockImages;
    }

    public void setBlockImages(BlockImage[][] blockImages) {
        this.blockImages = blockImages;
    }
}
