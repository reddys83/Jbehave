package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginPage extends AbstractPage {

    private ResetPasswordPage resetPasswordPage;
    private static final String PAGE_URI = "";
    private By username_field_name = By.name("username");
    private By password_field_name = By.name("password");
    private By login_button_name = By.name("login");
    private By invalid_combination_error_msg_id = By.id("login-error1");
    private By all_fields_required_error_msg_id = By.id("login-error2");
    private By forgot_password_link_linkText = By.linkText("Forgot password?");
    private By error_message_css = By.cssSelector(".login-error>p");


    public LoginPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return getUrlPrefix() + PAGE_URI;
    }

    public void enterUserName(String username) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(username_field_name).sendKeys(username);
    }

    public void enterPassword(String password) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(password_field_name).sendKeys(password);
    }

    public SearchPage clickOnLoginButton() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(login_button_name).click();
        SearchPage searchPage = new SearchPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
        return searchPage;
    }

    public void verifyInvalidCombinationErrorMessage() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDriver().findElement(invalid_combination_error_msg_id).getText(), "Please enter a valid username/password combination.");
    }

    public void verifyAllFieldsAreRequiredErrorMessage() {
        assertEquals(getDriver().findElement(all_fields_required_error_msg_id).getText(),"All fields are required.");
    }

    public ResetPasswordPage clickOnForgotPasswordLink() {
        getDriver().findElement(forgot_password_link_linkText).click();
        resetPasswordPage = new ResetPasswordPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
        return resetPasswordPage;
    }

    public void verifyLoginPage() {
        validatePage(username_field_name);
        assertTrue(getDriver().findElement(username_field_name).isDisplayed());
        assertFalse(getDriver().findElement(error_message_css).isDisplayed());
    }

    public void clickBackButton() {
        getDriver().navigate().back();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }
}
