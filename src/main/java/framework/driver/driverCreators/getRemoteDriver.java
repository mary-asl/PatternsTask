package framework.driver.driverCreators;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface getRemoteDriver {

    WebDriver getRemoteDriver() throws MalformedURLException;
}
