package com.epam.task5.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.task5.tests.businessObject.Item;
import com.epam.task5.tests.pageObject.CategoryPage;
import com.epam.task5.tests.pageObject.EksmoPage;
import com.epam.task5.tests.pageObject.HomePage;
import com.epam.task5.tests.pageObject.ItemPage;

import java.util.List;


public class EksmoPageTest extends BaseForAllTests {

    private static final String EKSMO_PAGE_LINK = "https://www.wildberries.kz/brands/eksmo";

    public EksmoPageTest() throws Exception {
    }

    @Test(description = "verify that items filtered by discount")
    @Parameters({"category"})
    public void filterByDiscount(@Optional(value = "Psychology") String category) {
        boolean actual = false;
        CategoryPage categoryPage = new HomePage(driver).clickBrandLogo().selectCategory(category).filterByDiscount();
        List<Double> doubleDiscounts = categoryPage.parseDoubleDiscount();
        outerloop:
        for (int i = 0; i < doubleDiscounts.size(); i++) {
            for (int j = i + 1; j < doubleDiscounts.size(); j++) {
                if (doubleDiscounts.get(i) > doubleDiscounts.get(j)) {
                    actual = false;
                    break outerloop;
                } else
                    actual = true;
            }
        }
        Assert.assertTrue(actual, "filter by discount does not sort items correctly");
    }

    @Test(description = "verify that items filtered by rate")
    public void filterByRate() {
        CategoryPage categoryPage = new CategoryPage(driver).filterByRate();
        boolean actual = false;
        List<Integer> integerRates = categoryPage.parseIntRates();
        outerloop:
        for (int i = 0; i < integerRates.size(); i++) {
            for (int j = i + 1; j < integerRates.size(); j++) {
                if (integerRates.get(i) < integerRates.get(j)) {
                    actual = false;
                    break outerloop;
                } else
                    actual = true;
            }
        }
        Assert.assertTrue(actual, "filter by rate does not sort items correctly");
    }

    @Test(description = "verify that items filtered by price")
    public void filterByPrice() {
        boolean actual = false;
        CategoryPage categoryPage = new CategoryPage(driver).filterByPrice();
        List<Integer> integerPrices = categoryPage.parseIntPrices();
        outerloop:
        for (int i = 0; i < integerPrices.size(); i++) {
            for (int j = i + 1; j < integerPrices.size(); j++) {
                if (integerPrices.get(i) > integerPrices.get(j)) {
                    actual = false;
                    break outerloop;
                } else actual = true;
            }
        }
        Assert.assertTrue(actual, "filter by price does not sort items correctly");
    }

    @Test(description = "Verify that categories are displayed on the page")
    public void verifyDisplayedCategory() {
        driver.navigate().to(EKSMO_PAGE_LINK);
        EksmoPage eksmoPage = new EksmoPage(driver);
        Assert.assertTrue(eksmoPage.findCategoryBanners().isDisplayed(), "there are no categories on the shop's page");
    }

    @Test(description = "verify that displayed item corresponds to the selected category",
            dataProvider = "bookCategories")
    public void isCategoryCorrect(String category, String expected) {
        Item item = new Item(driver);
        driver.navigate().to(EKSMO_PAGE_LINK);
        CategoryPage categoryPage = new EksmoPage(driver).selectCategory(category);
        ItemPage itemPage = categoryPage.selectItem();
        itemPage.readAllInformation();
        Assert.assertEquals(item.getCategory(), expected, "the item category does not match the selected category");
    }

    @DataProvider(name = "bookCategories", parallel = false)
    public Object[][] bookCategories() {
        return new Object[][]{
                {"Psychology", "Психология"},
                {"Cooking", "Кулинария"}
        };
    }
}