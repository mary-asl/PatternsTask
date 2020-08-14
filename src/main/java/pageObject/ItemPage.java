package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ItemPage extends AbstractPage {

    private static final By READ_ALL_INFORM_BTN_LOCATOR = By.xpath("//span//div[@class='for-link']/div[@class='c-link-in3-v1']");
    private static final By FAVORITES_BTN_LOCATOR = By.xpath("//div[@class='order']/button");
    private static final By ACTUAL_ITEM_CATEGORY = By.xpath("//div[@class='params']//div//span[b='Жанры/тематика']/following::span[1]");
    private static final By ITEMS_SIZE_LOCATOR = By.xpath("//label[@data-size-name]");
    private static final By ITEMS_SKU_LOCATOR = By.xpath("//span[@class='j-article']");

    public ItemPage() throws Exception {
    }

    public SignInPage addToFavorites() throws Exception {
        driver.findElement(FAVORITES_BTN_LOCATOR).click();
        return new SignInPage();
    }

    public String getCategory() {
        String actualCategory = driver.findElement(ACTUAL_ITEM_CATEGORY).getText();
        return actualCategory;
    }

    public void selectSize() {
        if (driver.findElement(ITEMS_SIZE_LOCATOR).isDisplayed())
            driver.findElement(ITEMS_SIZE_LOCATOR).click();
    }

    public ItemPage readAllInformation() {
        int elementPosition = driver.findElement(READ_ALL_INFORM_BTN_LOCATOR).getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        waitForElementVisible(READ_ALL_INFORM_BTN_LOCATOR);
        ((JavascriptExecutor) driver).executeScript(js);
        driver.findElement(READ_ALL_INFORM_BTN_LOCATOR).click();
        return this;
    }

    public String getItemsNumber(){
        return driver.findElement(ITEMS_SKU_LOCATOR).getText();
    }

}
