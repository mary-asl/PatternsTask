package steps;

import framework.driver.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import businessObject.Item;
import pageObject.CategoryPage;
import pageObject.EksmoPage;
import pageObject.HomePage;
import pageObject.ItemPage;

import java.util.*;

public class EksmoPageTest {

    private static final String HOME_PAGE_LINK = "https://www.wildberries.kz/";
    private Item item = new Item();

    public EksmoPageTest() throws Exception {
        super();
    }

    @Given("I open home page, scroll down and click to brand logo")
    public void go_to_brand_page() throws Exception {
        DriverSingleton.getWebDriver().navigate().to(HOME_PAGE_LINK);
        EksmoPage eksmoPage = new HomePage().clickBrandLogo();
    }

    @When("categories are displayed on brand page")
    public void are_categories_displayed() throws Exception {
        EksmoPage eksmoPage = new EksmoPage();
        Assert.assertTrue(eksmoPage.findCategoryBanners().isDisplayed(), "there are no categories on the shop's page");
    }

    @And("I click {string} category on brand page")
    public void select_category(String category) throws Exception {
        CategoryPage categoryPage = new EksmoPage().selectCategory(category);
    }

    @And("filter displayed items by discount")
    public void filter_by_discount() throws Exception {
        new CategoryPage().filterByDiscount();
    }

    @Then("items filtered by discount  correctly")
    public void is_items_filtered_by_discount() throws Exception {
        CategoryPage categoryPage = new CategoryPage();
        List<Double> doubleDiscounts = categoryPage.getItemsDiscount();
        List<Double> sortedDoubleDiscounts = new ArrayList<>(doubleDiscounts);
        Collections.sort(sortedDoubleDiscounts);
        Assert.assertEquals(doubleDiscounts, sortedDoubleDiscounts, "filter by discount does not sort items correctly");
    }

    @When("filter displayed items by rate")
    public void filter_by_rate() throws Exception {
        new CategoryPage().filterByRate();
    }

    @Then("items filtered by rate  correctly")
    public void is_items_filtered_by_rate() throws Exception {
        CategoryPage categoryPage = new CategoryPage();
        List<Integer> integerRates = categoryPage.getItemsRate();
        List<Integer> sortedIntegerRates = new ArrayList<>(integerRates);
        Collections.sort(sortedIntegerRates, Collections.reverseOrder());
        Assert.assertEquals(integerRates, sortedIntegerRates, "filter by rate does not sort items correctly");
    }

    @When("filter displayed items by price")
    public void filter_by_price() throws Exception {
        new CategoryPage().filterByPrice();
    }

    @Then("items filtered by price  correctly")
    public void is_items_filtered_by_price() throws Exception {
        CategoryPage categoryPage = new CategoryPage();
        List<Integer> integerPrices = categoryPage.getItemsPrice();
        List<Integer> sortedIntegerPrices = new ArrayList<>(integerPrices);
        Collections.sort(sortedIntegerPrices);
        Assert.assertEquals(integerPrices, sortedIntegerPrices, "filter by price does not sort items correctly");
    }

    @When("I select category {string} and click to item with genre {string}")
    public void select_product(String category, String expected) throws Exception {
        item.setCategory(expected);
        CategoryPage categoryPage = new EksmoPage().selectCategory(category);
        ItemPage itemPage = categoryPage.selectItem();
    }

    @And("click button read all information")
    public void read_all_info() throws Exception {
        new ItemPage().readAllInformation();
    }

    @Then("item matches selected category")
    public void is_items_category_correct() throws Exception {
        ItemPage itemPage = new ItemPage();
        Assert.assertEquals(itemPage.getCategory(), item.getCategory(), "the item category does not match the selected category");
    }

}