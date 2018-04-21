package imageforgerydetection;
import model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import matcher.Matcher;
import matcher.RelevanceFeedbackMatcher;
import matcher.SimpleMatcher;

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
        Matcher matcher;
        if (detectionType.equals("Relevance Feedback Matcher")) {
            matcher = new RelevanceFeedbackMatcher();
            matcher.setFeatureType("Autocolor Correlogram");
        } else {
            matcher = new SimpleMatcher();
        }
        System.out.println(detectionType);
        BufferedImage bufferedImage = image.getOriginalImage();
        Graphics2D g = bufferedImage.createGraphics();
        g = matcher.detectDuplicatedBlocks(image, g, similarityTreshold);
        g.dispose();
        return bufferedImage;
    }
}
