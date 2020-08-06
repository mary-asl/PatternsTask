package tests.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ItemPage extends AbstractPage {

    private static final By READ_ALL_INFORM_BTN = By.xpath("//span//div[@class='for-link']/div[@class='c-link-in3-v1']");
    private static final By FAVORITES_BTN_LOCATOR = By.xpath("//div[@class='order']/button");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage addToFavorites() {
        getDriver().findElement(FAVORITES_BTN_LOCATOR).click();
        return new SignInPage(getDriver());
    }

    public ItemPage readAllInformation() {
        int elementPosition = getDriver().findElement(READ_ALL_INFORM_BTN).getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        waitForElementVisible(READ_ALL_INFORM_BTN);
        ((JavascriptExecutor) getDriver()).executeScript(js);
        getDriver().findElement(READ_ALL_INFORM_BTN).click();
        return this;
    }

}
