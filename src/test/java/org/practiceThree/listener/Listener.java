package org.practiceThree.listener;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.practiceThree.screenshot.Screenshot;

import java.awt.*;

public class Listener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            Screenshot.saveScreenshot(robot.createScreenCapture(screenRect));
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
