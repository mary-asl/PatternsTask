package steps;

import framework.driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import pageObject.CategoryPage;
import pageObject.HomePage;
import pageObject.ItemPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TextSearchTest {

    @Given("^I search for product \"([^\"]*)\"$")
    public void search_for_product(String searchingItem) throws Exception {
        DriverSingleton.getWebDriver().navigate().refresh();
        new HomePage().cleanInputSearch().setTextSearch(searchingItem);
    }

    @When("^I click search button")
    public void click_search_buttton() throws Exception {
        CategoryPage categoryPage = new HomePage().clickSearchButton();
    }

    @Then("found item('s) name contains key words")
    public void is_item_found() throws Exception {
        CategoryPage categoryPage = new CategoryPage();
        String searchingItemActualName = categoryPage.getSearchingItemName();
        List<String> keyWords = Arrays.asList(categoryPage.getInputValue().split("\\s"));
        boolean asMatch = keyWords.stream().allMatch(keyWord -> searchingItemActualName.isEmpty() ?
                false : StringUtils.containsIgnoreCase(searchingItemActualName, keyWord));

        Assert.assertTrue(asMatch, "expected item is not found");
    }

    @Then("^page title changed to \"([^\"]*)\"$")
    public void verifyPageTitle(String searchingItem) throws Exception {
        DriverSingleton.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(DriverSingleton.getWebDriver().getTitle(), searchingItem.toLowerCase(), "incorrect page title");
    }

    @When("^I search for numbers? \"([a-z]+|\\d+)\"$")
    public void search_for_six_numbers(String numbers) throws Exception {
        new HomePage().cleanInputSearch().setTextSearch(numbers).clickSearchButton();
    }

    @Then("the item numbers? match the \"([a-z]+|\\d+)\"$")
    public void is_searching_for_numbers_correct(String numbers) throws Exception {
        ItemPage itemPage = new ItemPage();
        String actualItemsNumber = itemPage.getItemsNumber();
        Assert.assertEquals(actualItemsNumber, numbers, "the item number doesn't match the number which was requested in the search");
    }
}
