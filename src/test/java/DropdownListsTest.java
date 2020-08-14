import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import businessObject.Locale;
import pageObject.HomePage;

public class DropdownListsTest extends BaseForAllTests {

    public DropdownListsTest() throws Exception {
        super();
    }

    @Test(description = "verify that current location was changed after changed the country",
            dataProvider = "locationDataProvider")
    public void verifyCurrentLocation(String country, String expectedLocation) throws Exception {
        Locale locale = new Locale();
        HomePage homePage = new HomePage().hoverToChangeLocaleBtn();
        locale.setCountry(country);
        homePage.clickToCountry(locale.getCountry());
        Assert.assertEquals(homePage.getCurrentLocale().getText(), expectedLocation, "current location wasn't change");
    }

    @DataProvider(name = "locationDataProvider", parallel = false)
    public Object[][] locationProvider() {
        return new Object[][]{
                {"Belarus", "Минск"},
                {"Kazakhstan", "Нур-Султан"},
                {"Armenia", "Ереван"}
        };
    }
}
