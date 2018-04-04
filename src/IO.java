import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class IO {

    private IO() {}

    public static BufferedImage readImage(String imageUrl){
        File original_f = new File(imageUrl);
        BufferedImage image = null;
        try {
            image = ImageIO.read(original_f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void writeImage(BufferedImage image, String filename, String extention) {
        File file = new File(filename);
        try {
            ImageIO.write(image, extention, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
