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
        waitForElementVisible(CHANGE_LOCALE_BTN_LOCATOR);
        new Actions(driver).moveToElement(driver.findElement(CHANGE_LOCALE_BTN_LOCATOR)).perform();
        return this;
    }

    public HomePage clickToCountry(String country) {
        switch (country) {
            case ("Belarus"):
                driver.findElement(By.xpath("//span[@class='c-flag-by']/../a")).click();
                break;
            case ("Россия"):
                driver.findElement(By.xpath("//span[@class='c-flag-ru']/../a")).click();
                break;
            case ("Kazakhstan"):
                driver.findElement(By.xpath("//span[@class='c-flag-kz']/../a")).click();
                break;
            case ("Armenia"):
                driver.findElement(By.xpath("//span[@class='c-flag-am']/../a")).click();
                break;
            case ("Kyrgyzstan"):
                driver.findElement(By.xpath("//span[@class='c-flag-kg']/../a")).click();
                break;
            case ("Poland"):
                driver.findElement(By.xpath("//span[@class='c-flag-pl']/../a")).click();
                break;
            case ("Slovakia"):
                driver.findElement(By.xpath("//span[@class='c-flag-sk']/../a")).click();
                break;
        }
        return this;
    }

    public WebElement getCurrentLocale() {
        waitForElementVisible(GEO_LOCATION_TEXT_LOCATOR);
        return driver.findElement(GEO_LOCATION_TEXT_LOCATOR);
    }

    public HomePage cleanInputSearch() {
        driver.findElement(SEARCH_INPUT_LOCATOR).clear();
        return this;
    }

    public CategoryPage searchForItem(String item) throws Exception {
        waitForElementVisible(SEARCH_INPUT_LOCATOR);
        WebElement input = driver.findElement(SEARCH_INPUT_LOCATOR);
        new Actions(driver).sendKeys(input, item).build().perform();
        waitForElementVisible(SEARCH_BTN_LOCATOR);
        driver.findElement(SEARCH_BTN_LOCATOR).click();
        return new CategoryPage();
    }

    public EksmoPage clickBrandLogo() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4700)");
        WebElement buttonNext = driver.findElement(BUTTON_NEXT_BRAND_LOCATOR);
        waitForElementVisible(BUTTON_NEXT_BRAND_LOCATOR);
        String js = String.format("window.scroll(0, %s)", buttonNext.getLocation().getY());
        ((JavascriptExecutor) driver).executeScript(js);
        waitForElementEnabled(BUTTON_NEXT_BRAND_LOCATOR);
        do {
            buttonNext.click();
        }
        while (!driver.findElement(EKSMO_LOGO_LOCATOR).isDisplayed());
        driver.findElement(EKSMO_LOGO_LOCATOR).click();
        return new EksmoPage();
    }
}
