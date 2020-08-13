package framework.driver;

import framework.exception.UnknownDriverTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriverTypes defaultDriverType = WebDriverTypes.FIREFOX;

    private static WebDriver driver;

    private Driver(WebDriver driver) {
        this.driver = driver;
    }

    public static Logger logger = LogManager.getLogger();

    public static WebDriver getWebDriver(WebDriverTypes type) throws Exception {
        switch (type) {
            case FIREFOX: {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            default:
                throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getWebDriver() throws Exception {
        return getWebDriver(defaultDriverType);
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

    public static void closeBrowser(WebDriver driver) {
        try {
            driver.quit();
        } catch (Exception e) {
            logger.error("Cannot close browser");
        }
    }
}
