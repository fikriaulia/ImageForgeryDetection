package model;

import feature.Feature;
import java.awt.image.BufferedImage;

public class BlockAffine {
    private BufferedImage image;
    private Feature feature;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
