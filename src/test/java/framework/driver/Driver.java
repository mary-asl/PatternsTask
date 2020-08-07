package framework.driver;

import framework.exception.UnknownDriverTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";

    private static WebDriverTypes defaultDriverType = WebDriverTypes.FIREFOX;

    private static HashMap<String, WebDriver> instances;

    private static WebDriver driver;

    public static Logger logger = LogManager.getLogger();

    static {
        instances = new HashMap<String, WebDriver>();
    }

    public static WebDriver getWebDriver(String name, WebDriverTypes type) throws Exception {
        if (!instances.containsKey(name)) {
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
            instances.put(name, driver);
        } else {
            driver = instances.get(name);
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getWebDriver(String name) throws Exception {
        return getWebDriver(name, defaultDriverType);
    }

    public static WebDriver getWebDriver() throws Exception {
        return getWebDriver(DEFAULT_WEB_DRIVER, defaultDriverType);
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

    public static void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            logger.error("Cannot close browser");
        }
    }
}
