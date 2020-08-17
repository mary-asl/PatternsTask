package pageObject;

import framework.util.Screenshoter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        click(ITEM_FROM_LIST_LOCATOR);
        return new ItemPage();
    }

    public String getSearchingItemName() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        return getText(ITEMS_NAME_LOCATOR);
    }

    public String getInputValue() {
        return getWebElement(SEARCH_INPUT_LOCATOR).getAttribute("value");
    }

    public List<WebElement> getItemsRate() {
        return getWebElements(ITEMS_RATE_LOCATOR);
    }

    public List<WebElement> getItemsPrice() {
        refresh();
        return getWebElements(ITEMS_PRICE_LOCATOR);
    }

    public List<WebElement> getItemsDiscount() {
        refresh();
        return getWebElements(ITEMS_DISCOUNTS_LOCATOR);
    }

    public CategoryPage filterByRate() {
        highlightElement(FILTER_BY_RATE_LOCATOR);
        click(FILTER_BY_RATE_LOCATOR);
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_RATE_LOCATOR);
        return this;
    }

    public CategoryPage filterByPrice() {
        highlightElement(FILTER_BY_PRICE_BTN_LOCATOR);
        click(FILTER_BY_PRICE_BTN_LOCATOR);
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_PRICE_BTN_LOCATOR);
        return this;
    }

    public CategoryPage filterByDiscount() {
        highlightElement(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        click(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        Screenshoter.makeFullPageScreenshot(driver);
        unHighlightElement(FILTER_BY_DISCOUNT_BTN_LOCATOR);
        return this;
    }

}