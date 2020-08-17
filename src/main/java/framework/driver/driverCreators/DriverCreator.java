package framework.driver.driverCreators;

import org.openqa.selenium.WebDriver;

public interface DriverCreator {

    WebDriver getDriver();
    WebDriver getRemoteDriver();
}
