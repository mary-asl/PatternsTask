package framework.util;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Screenshoter {

    private static final String SCREENSHOTS_NAME_TPL = "./src/screenshots/screen";
    private static Logger logger = LogManager.getLogger();
    private static String screenName = SCREENSHOTS_NAME_TPL + System.nanoTime();

    public static void makeScreenshot(WebDriver driver) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File copy = new File(screenName + ".png");
            FileUtils.copyFile(screenshot, copy);
        } catch (IOException e) {
            logger.error("Failed to make screenshot");
        }
    }

    public static void makeFullPageScreenshot(WebDriver driver) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        try {
            Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1500)).takeScreenshot(augmentedDriver);
            ImageIO.write(screenshot.getImage(),"PNG",new File(screenName + ".png"));
        }
        catch(IOException e) {
            logger.error("Failed to make screenshot");
        }
    }
}
