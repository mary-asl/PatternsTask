package tests.businessObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Item {

    WebDriver driver;
    private static final By ACTUAL_ITEM_CATEGORY = By.xpath("//div[@class='params']//div//span[b='Жанры/тематика']/following::span[1]");
    private static final By ITEMS_SIZE_LOCATOR = By.xpath("//label[@data-size-name]");

    public Item(WebDriver driver) {
        this.driver = driver;
    }

    public String getCategory() {
        String actualCategory = driver.findElement(ACTUAL_ITEM_CATEGORY).getText();
        return actualCategory;
    }

    public void selectSize() {
        if (driver.findElement(ITEMS_SIZE_LOCATOR).isDisplayed())
            driver.findElement(ITEMS_SIZE_LOCATOR).click();
    }

}
