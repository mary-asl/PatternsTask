package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends AbstractPage {

    private static final By EKSMO_LOGO_LOCATOR = By.xpath("//a[@href='/brands/eksmo']");
    private static final By BUTTON_NEXT_BRAND_LOCATOR = By.xpath("//div[@class='brands-pane j-brands-slider-wrapper i-slider-brand-pane']//a[@class='lSNext']/button");
    private static final By SEARCH_INPUT_LOCATOR = By.id("tbSrch");
    private static final By SEARCH_BTN_LOCATOR = By.id("btnSrch");
    private static final By CHANGE_LOCALE_BTN_LOCATOR = By.xpath("//li[@class = 'item change-locale']/span");
    private static final By GEO_LOCATION_TEXT_LOCATOR = By.xpath("//span[@class='geo j-geocity-text']");

    public HomePage() throws Exception {
    }

    public HomePage hoverToChangeLocaleBtn(){
        new Actions(driver).moveToElement(getWebElement(CHANGE_LOCALE_BTN_LOCATOR)).perform();
        return this;
    }

    public HomePage clickToCountry(String country) {
        switch (country) {
            case ("Belarus"):
                getWebElement(By.xpath("//span[@class='c-flag-by']/../a")).click();
                break;
            case ("Россия"):
                getWebElement(By.xpath("//span[@class='c-flag-ru']/../a")).click();
                break;
            case ("Kazakhstan"):
                getWebElement(By.xpath("//span[@class='c-flag-kz']/../a")).click();
                break;
            case ("Armenia"):
                getWebElement(By.xpath("//span[@class='c-flag-am']/../a")).click();
                break;
            case ("Kyrgyzstan"):
                getWebElement(By.xpath("//span[@class='c-flag-kg']/../a")).click();
                break;
            case ("Poland"):
                getWebElement(By.xpath("//span[@class='c-flag-pl']/../a")).click();
                break;
            case ("Slovakia"):
                getWebElement(By.xpath("//span[@class='c-flag-sk']/../a")).click();
                break;
        }
        return this;
    }

    public WebElement getCurrentLocale() {
        return getWebElement(GEO_LOCATION_TEXT_LOCATOR);
    }

    public HomePage cleanInputSearch() {
        getWebElement(SEARCH_INPUT_LOCATOR).clear();
        return this;
    }

    public CategoryPage searchForItem(String item) throws Exception {
        WebElement input = getWebElement(SEARCH_INPUT_LOCATOR);
        new Actions(driver).sendKeys(input, item).build().perform();
        getWebElement(SEARCH_BTN_LOCATOR).click();
        return new CategoryPage();
    }

    public EksmoPage clickBrandLogo() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4700)");
        WebElement buttonNext = getWebElement(BUTTON_NEXT_BRAND_LOCATOR);
        waitForElementVisible(BUTTON_NEXT_BRAND_LOCATOR);
        String js = String.format("window.scroll(0, %s)", buttonNext.getLocation().getY());
        ((JavascriptExecutor) driver).executeScript(js);
        waitForElementEnabled(BUTTON_NEXT_BRAND_LOCATOR);
        do {
            buttonNext.click();
        }
        while (!getWebElement(EKSMO_LOGO_LOCATOR).isDisplayed());
        getWebElement(EKSMO_LOGO_LOCATOR).click();
        return new EksmoPage();
    }
}
