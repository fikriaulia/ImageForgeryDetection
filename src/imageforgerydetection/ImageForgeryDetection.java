/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageforgerydetection;

import feature.AutocolorCorrelogram;
import model.Image;
import java.awt.image.BufferedImage;

import static java.lang.System.exit;


/**
 *
 * @author fikriaulia
 */
public class ImageForgeryDetection {

    /**
     * @param args the command line argumentsxw
     */
    public static void main(String[] args) {
        String name = "1_m.png";
        BufferedImage originalImage = IO.readImage("image/"+name); //user input
        long start = System.currentTimeMillis();
        Praprocessor.setBlockSize(8); //user input
        Praprocessor.setFeatureType("Autocolor Correlogram");
        Image image = Praprocessor.generateImage(originalImage);
        long now = System.currentTimeMillis();
        System.out.println((now - start)/1000.0);
        Detector.setDetectionType("Relevance Feedback Matcher"); //user input
//        Detector.setDetectionType("Simple Matcher"); //user input
        Detector.setSimilarityTreshold(4);//user input
        BufferedImage result = Detector.detect(image);
        System.out.println("test");
        IO.writeImage(result, "result/"+name, "png");
    }
    
}
