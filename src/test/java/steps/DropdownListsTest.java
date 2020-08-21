package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import businessObject.Locale;
import pageObject.HomePage;

public class DropdownListsTest {

    private Locale locale = new Locale();

    @Given("^I hover to change country button")
    public void hover_to_country() throws Exception {
        new HomePage().hoverToChangeLocaleBtn();
    }

    @When("I click {string} with {string} and {string}")
    public void click_to_country(String country, String city, String code) throws Exception {
        HomePage homePage = new HomePage().hoverToChangeLocaleBtn();
        locale.setCountry(country).setLocation(city).setCountryCode(code);
        homePage.clickToCountry(locale);
        Assert.assertEquals(homePage.getCurrentLocale(), locale.getLocation(), "current location wasn't change");
    }

    @Then("current {string} change")
    public void is_current_locale_changed(String location) throws Exception {
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getCurrentLocale(), locale.getLocation(), "current location wasn't change");
    }

}
