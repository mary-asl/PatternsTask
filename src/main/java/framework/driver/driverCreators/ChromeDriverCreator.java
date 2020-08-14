package framework.driver.driverCreators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements DriverCreator {

    @Override
    public WebDriver factoryMethod() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
