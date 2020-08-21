package pageObject;

import businessObject.Locale;
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

    public HomePage clickToCountry(Locale locale) {
        click(By.xpath("//span[@class='c-flag-" + locale.getCountryCode() + "']/../a"));
        return this;
    }

    public String getCurrentLocale() {
        return getText(GEO_LOCATION_TEXT_LOCATOR);
    }

    public HomePage cleanInputSearch() {
        getWebElement(SEARCH_INPUT_LOCATOR).clear();
        return this;
    }

    public HomePage setTextSearch(String item) throws Exception {
        WebElement input = getWebElement(SEARCH_INPUT_LOCATOR);
        new Actions(driver).sendKeys(input, item).build().perform();
        return new HomePage();
    }

    public CategoryPage clickSearchButton() throws Exception {
        click(SEARCH_BTN_LOCATOR);
        return new CategoryPage();
    }

    public EksmoPage clickBrandLogo() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4900)");
        WebElement buttonNext = getWebElement(BUTTON_NEXT_BRAND_LOCATOR);
        String js = String.format("window.scroll(0, %s)", buttonNext.getLocation().getY());
        ((JavascriptExecutor) driver).executeScript(js);
        waitForElementEnabled(BUTTON_NEXT_BRAND_LOCATOR);
        do {
            buttonNext.click();
        }
        while (!driver.findElement(EKSMO_LOGO_LOCATOR).isDisplayed());
        click(EKSMO_LOGO_LOCATOR);
        return new EksmoPage();
    }
}
