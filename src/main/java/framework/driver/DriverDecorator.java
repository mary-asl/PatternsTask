package framework.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class DriverDecorator implements WebDriver {
    protected WebDriver driver;
    private Logger logger = LogManager.getLogger();

    public DriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        logger.info("Current title: " + driver.getTitle() + " current URL: " + driver.getCurrentUrl());
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        logger.info("Finding elements: " + by.toString() + " current URL:" + driver.getCurrentUrl());
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        logger.info("Finding element: " + by.toString() + " current URL:" + driver.getCurrentUrl());
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        logger.info("Browser will be closed now...");
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }
}
