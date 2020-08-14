package framework.driver.driverCreators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements DriverCreator {
    @Override
    public WebDriver factoryMethod() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/geckodriver.exe");
        return new FirefoxDriver();
    }
}
