package pageObject;

import framework.driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final int WAIT_FOR_ELEMENT_SECONDS = 30;
    protected WebDriver driver = DriverSingleton.getWebDriver();

    protected AbstractPage() throws Exception {
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void redrawElement(By locator) {
        new  WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.
                refreshed(ExpectedConditions.stalenessOf(driver.findElement(locator))));
    }

    public void highlightElement(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", driver.findElement(locator));
    }

    public void unHighlightElement(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + "none" + "'",  driver.findElement(locator));
    }

}
