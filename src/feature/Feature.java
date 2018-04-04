package feature;

import java.awt.image.BufferedImage;

public interface Feature {
    void extract(BufferedImage image);

    double getDistance(Feature feature);
}
