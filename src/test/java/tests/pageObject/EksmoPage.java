package tests.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EksmoPage extends AbstractPage {

    private static final By CATEGORIES_LOCATOR = By.id("newsSmallBanners");
    private static final By PSYCHOLOGY_CATEGORY_LOCATOR = By.xpath("//div[@class='small-banners']/div[@class='number-5']");
    private static final By COOKING_CATEGORY_LOCATOR = By.xpath("//div[@class='small-banners']/div[@class='number-4']");

    public EksmoPage(WebDriver driver) {
        super(driver);
    }

    public WebElement findCategoryBanners() {
        waitForElementVisible(CATEGORIES_LOCATOR);
        return getDriver().findElement(CATEGORIES_LOCATOR);
    }

    public CategoryPage selectCategory(String category) {
        switch (category){
            case("Psychology"):
                waitForElementEnabled(PSYCHOLOGY_CATEGORY_LOCATOR);
                getDriver().findElement(PSYCHOLOGY_CATEGORY_LOCATOR).click();
                break;
            case("Cooking"):
                waitForElementEnabled(COOKING_CATEGORY_LOCATOR);
                getDriver().findElement(COOKING_CATEGORY_LOCATOR).click();
                break;
        }
        return new CategoryPage(getDriver());
    }
}
