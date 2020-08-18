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
    public void verifyCurrentLocation(Locale locale) throws Exception {
        HomePage homePage = new HomePage().hoverToChangeLocaleBtn();
        homePage.clickToCountry(locale.getCountry());
        Assert.assertEquals(homePage.getCurrentLocale(), locale.getLocation(), "current location wasn't change");
    }

    @DataProvider(name = "locationDataProvider", parallel = false)
    public Object[][] locationProvider() {
        return new Object[][]{
                {new Locale().setCountry("Belarus").setLocation("Минск")},
                {new Locale().setCountry("Kazakhstan").setLocation("Нур-Султан")},
                {new Locale().setCountry("Armenia").setLocation("Ереван")}
        };
    }
}
