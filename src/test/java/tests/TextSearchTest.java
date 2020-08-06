package tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.pageObject.CategoryPage;
import tests.pageObject.HomePage;

import java.util.concurrent.TimeUnit;

public class TextSearchTest extends BaseForAllTests {

    @Test(description = "verify that found item's name contains words from text search",
            dataProvider = "searchingItems")
    public void isItemFound(String searchingItem) {
        CategoryPage categoryPage = new HomePage(driver).cleanInputSearch().searchForItem(searchingItem);
        boolean actual = false;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String[] subStr = categoryPage.getInputValue().split(" ");
        for (int i = 0; i < subStr.length; i++) {
            if (!StringUtils.containsIgnoreCase(categoryPage.getSearchingItemName(), subStr[i])) {
                actual = false;
                break;
            } else
                actual = true;
        }
        Assert.assertTrue(actual, "expected item is not found");
    }

    @Test(description = "verify that page title changed to searching item's name",
            dataProvider = "searchingItems")
    @Parameters({"searchingItem"})
    public void verifyPageTitle(String searchingItem) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new HomePage(driver).cleanInputSearch().searchForItem(searchingItem);
        Assert.assertEquals(driver.getTitle(), searchingItem.toLowerCase(), "incorrect page title");
    }

    @DataProvider(name = "searchingItems", parallel = false)
    public Object[][] serchingItems() {
        return new Object[][]{
                {"funko pop star wars"},
                {"носки с авокадо"},
                {"POLO SHIRT"}
        };

    }
}
