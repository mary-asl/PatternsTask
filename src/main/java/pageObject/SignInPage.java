package pageObject;

import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {

    private static final By SIGN_IN_FORM_LOCATOR = By.cssSelector(".signIn");

    public SignInPage() throws Exception {
    }

    public Boolean signInByPhoneNum() {
        return getWebElement(SIGN_IN_FORM_LOCATOR).isDisplayed();
    }

}