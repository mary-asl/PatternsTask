import framework.driver.DriverDecorator;
import framework.driver.DriverSingleton;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {

                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report",
        },
        features = "./src/test/resources/features/",
        glue = "steps"
)

public class Runner extends AbstractTestNGCucumberTests {

        private static final String BASE_URL = "https://www.wildberries.kz";
        private Logger logger = LogManager.getLogger();

        WebDriver driver;

        public Runner() throws Exception {
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

        @AfterClass
        public void quit() {
                DriverSingleton.closeBrowser(driver);
        }

}
