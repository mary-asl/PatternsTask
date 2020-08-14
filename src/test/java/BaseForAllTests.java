import framework.driver.DriverDecorator;
import framework.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public abstract class BaseForAllTests {

    private static final String BASE_URL = "https://www.wildberries.kz";
    private Logger logger = LogManager.getLogger();

    WebDriver driver;

    public BaseForAllTests() throws Exception {
        this.driver = DriverSingleton.getWebDriver();
    }

    @BeforeClass
    public void wrapWebDriver(){
        driver = new DriverDecorator(driver);
    }

    @BeforeClass
    public void openWebDriver() {
        try {
            driver.get(BASE_URL);
        } catch (WebDriverException e) {
            logger.error("WebDriverException occured");
        }
    }

    @AfterSuite
    public void quit() {
        DriverSingleton.closeBrowser(driver);
    }

}
