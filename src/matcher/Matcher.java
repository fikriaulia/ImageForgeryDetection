package matcher;

import feature.Feature;
import java.awt.Graphics2D;
import model.Image;

public interface Matcher {
    public Graphics2D detectDuplicatedBlocks(Image image, Graphics2D g, double treshold);
    
    public void setFeatureType(String featureType);
}
