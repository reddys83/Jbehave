package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginPage extends AbstractPage {

    private ResetPasswordPage resetPasswordPage;

    private By username_field_name = By.name("username");
    private By password_field_name = By.name("password");
    private By login_button_name = By.name("login");
    private By invalid_combination_error_msg_id = By.id("login-error1");
    private By all_fields_required_error_msg_id = By.id("login-error2");
    private By forgot_password_link_linkText = By.linkText("Forgot password?");

    public LoginPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return getDriver().getCurrentUrl() ;
    }

    public void enterUserName(String username) {
        getDriver().findElement(username_field_name).sendKeys(username);
    }

    public void enterPassword(String password) {
        getDriver().findElement(password_field_name).sendKeys(password);
    }

    public SearchPage clickOnLoginButton() {
        getDriver().findElement(login_button_name).click();
        SearchPage searchPage = new SearchPage(getDriver(), getUrlPrefix());
        return searchPage;
    }

    public void verifyInvalidCombinationErrorMessage() {
        assertEquals(getDriver().findElement(invalid_combination_error_msg_id).getText(),"Please enter a valid username/password combination.");
    }

    public void verifyAllFieldsAreRequiredErrorMessage() {
        assertEquals(getDriver().findElement(all_fields_required_error_msg_id).getText(),"All fields are required.");
    }

    public ResetPasswordPage clickOnForgotPasswordLink() {
        getDriver().findElement(forgot_password_link_linkText).click();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(getDriver(), getUrlPrefix());
        return resetPasswordPage;
    }

    public void verifyLoginPage() {
        assertEquals(getPageUrl(),"");
    }
}
