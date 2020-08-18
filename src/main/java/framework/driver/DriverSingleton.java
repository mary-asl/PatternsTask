package framework.driver;

import framework.driver.driverCreators.ChromeDriverCreator;
import framework.driver.driverCreators.FirefoxDriverCreator;
import framework.exception.UnknownDriverTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static Logger logger = LogManager.getLogger();

    public static WebDriver getWebDriver(String type) throws Exception {
        if (driver == null) {

            switch (type) {
                case ("FIREFOX") : {
                    driver = new FirefoxDriverCreator().getDriver();
                    break;
                }
                case ("CHROME"): {
                    driver = new ChromeDriverCreator().getDriver();
                    break;
                }
                default:
                    throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
            }
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getWebDriver() throws Exception {
        FileInputStream propertiesFile = new FileInputStream("./src/main/java/framework/config/wildberries.properties");
        Properties properties = new Properties();
        properties.load(propertiesFile);
        return getWebDriver(properties.getProperty("defaultDriverType"));
    }

    public static void closeBrowser(WebDriver driver) {
        try {
            driver.quit();
        } catch (Exception e) {
            logger.error("Cannot close browser");
        }
    }
}
