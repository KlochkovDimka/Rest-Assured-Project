package org.practiceThree.screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    private static int nameScreenshot = 0;

    public static void saveScreenshot(BufferedImage image) {
        nameScreenshot++;
        try {
            ImageIO.write(image, "png",
                    new File("screenshot/scr" + nameScreenshot + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
