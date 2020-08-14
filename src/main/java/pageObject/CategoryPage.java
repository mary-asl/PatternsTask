package pageObject;

import framework.util.Screenshoter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends AbstractPage {

    private static final By ITEM_FROM_LIST_LOCATOR = By.xpath("//div[@class='dtList-inner']");
    private static final By FILTER_BY_RATE_LOCATOR = By.cssSelector("#rate");
    private static final By ITEMS_RATE_LOCATOR = By.xpath("//span[@class='dtList-comments-count c-text-sm']");
    private static final By FILTER_BY_PRICE_BTN_LOCATOR = By.cssSelector("#price");
    private static final By ITEMS_PRICE_LOCATOR = By.xpath("//span[@class='price']/ins[@class='lower-price']");
    private static final By FILTER_BY_DISCOUNT_BTN_LOCATOR = By.xpath("//div/a[@id='sale']/span");
    private static final By ITEMS_DISCOUNTS_LOCATOR = By.xpath("//span[@class='price-sale active']");
    private static final By ITEMS_NAME_LOCATOR = By.xpath("//span[@class='goods-name c-text-sm']");
    private static final By SEARCH_INPUT_LOCATOR = By.id("tbSrch");

    public CategoryPage() throws Exception {
    }

    public ItemPage selectItem() throws Exception {
        waitForElementVisible(ITEM_FROM_LIST_LOCATOR);
        driver.findElement(ITEM_FROM_LIST_LOCATOR).click();
        return new ItemPage();
    }

    public String getSearchingItemName() {
        waitForElementVisible(ITEMS_NAME_LOCATOR);
        return driver.findElement(ITEMS_NAME_LOCATOR).getText();
    }

    public String getInputValue() {
        waitForElementVisible(SEARCH_INPUT_LOCATOR);
        return driver.findElement(SEARCH_INPUT_LOCATOR).getAttribute("value");
    }

    public List<WebElement> getItemsRate() {
        waitForElementVisible(ITEMS_RATE_LOCATOR);
        return driver.findElements(ITEMS_RATE_LOCATOR);
    }

    public List<WebElement> getItemsPrice() {
        driver.navigate().refresh();
        waitForElementPresent(ITEMS_PRICE_LOCATOR);
        return driver.findElements(ITEMS_PRICE_LOCATOR);
    }

    public List<WebElement> getItemsDiscount() {
        driver.navigate().refresh();
        waitForElementPresent(ITEMS_DISCOUNTS_LOCATOR);
        return driver.findElements(ITEMS_DISCOUNTS_LOCATOR);
    }

    public CategoryPage filterByRate() {
        waitForElementVisible(FILTER_BY_RATE_LOCATOR);
        highlightElement(FILTER_BY_RATE_LOCATOR);
        driver.findElement(FILTER_BY_RATE_LOCATOR).click();
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_RATE_LOCATOR);
        return this;
    }

    public CategoryPage filterByPrice() {
        waitForElementVisible(FILTER_BY_PRICE_BTN_LOCATOR);
        highlightElement(FILTER_BY_PRICE_BTN_LOCATOR);
        driver.findElement(FILTER_BY_PRICE_BTN_LOCATOR).click();
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_PRICE_BTN_LOCATOR);
        return this;
    }

    public CategoryPage filterByDiscount() {
        waitForElementVisible(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        highlightElement(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        driver.findElement(FILTER_BY_DISCOUNT_BTN_LOCATOR).click();
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        return this;
    }

}