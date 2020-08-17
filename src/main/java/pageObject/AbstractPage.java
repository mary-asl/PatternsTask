package pageObject;

import framework.driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    private static final int WAIT_FOR_ELEMENT_SECONDS = 10;
    protected WebDriver driver = DriverSingleton.getWebDriver();

    protected AbstractPage() throws Exception {
    }

    public boolean isElementPresent(By locator) {
        return !getWebElements(locator).isEmpty();
    }

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By by) {
        waitForElementVisible(by);
        return driver.findElement(by).getText();
    }

    public WebElement getWebElement(By by) {
        waitForElementVisible(by);
        return driver.findElement(by);
    }

    public List<WebElement> getWebElements(By by) {
        waitForElementVisible(by);
        return driver.findElements(by);
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void redrawElement(By locator) {
        new  WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.
                refreshed(ExpectedConditions.stalenessOf(getWebElement(locator))));
    }

    public void highlightElement(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", getWebElement(locator));
    }

    public void unHighlightElement(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + "none" + "'",  getWebElement(locator));
    }

}
