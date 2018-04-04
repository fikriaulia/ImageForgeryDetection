import feature.AutocolorCorrelogram;
import model.Image;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args)
    {
        BufferedImage originalImage = IO.readImage("image/015_F.png"); //user input
        Praprocessor.setAffineType("type1"); //user input
        Praprocessor.setBlockSize(10); //user input
        Praprocessor.setFeature(new AutocolorCorrelogram());
        Image image = Praprocessor.generateImage(originalImage);
        Detector.setDetectionType("type1"); //user input
        Detector.setSimilarityTreshold(12);//user input
        BufferedImage result = Detector.detect(image);
        IO.writeImage(result, "result/015_F_result.png", "png");
    }
}
