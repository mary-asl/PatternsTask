package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.businessObject.Locale;
import tests.pageObject.HomePage;

public class DropdownListsTest extends BaseForAllTests {
    @Test(description = "verify that current location was changed after changed the country", dataProvider = "locationDataProvider")
    public void verifyCurrentLocation(String country, String expectedLocation){
        Locale locale = new Locale(driver);
        HomePage homePage = new HomePage(driver).hoverToChangeLocaleBtn();
        homePage.clickToCountry(country);
        Assert.assertEquals(locale.getCurrentLocale().getText(), expectedLocation, "current location wasn't change");
    }

    @DataProvider(name = "locationDataProvider", parallel = false)
      public Object[][] locationProvider(){
        return new Object[][]{
                {"Belarus", "Минск"},
                {"Kazakhstan", "Нур-Султан"},
                {"Armenia", "Ереван"}
        };
    }
}
