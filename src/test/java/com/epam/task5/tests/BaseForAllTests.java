package com.epam.task5.tests;

import com.epam.task5.framework.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseForAllTests {

    private static final String BASE_URL = "https://www.wildberries.kz";
    public Logger logger = LogManager.getLogger();

    WebDriver driver;

    public BaseForAllTests() throws Exception {
        this.driver = Driver.getWebDriver();
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
        Driver.closeBrowser(driver);
    }

}
