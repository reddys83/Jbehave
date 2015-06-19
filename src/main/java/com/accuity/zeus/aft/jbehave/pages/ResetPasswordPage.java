package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by sahug on 6/19/2015.
 */
public class ResetPasswordPage extends AbstractPage {

    private By reset_password_instruction_id = By.id("forgot-dialog1");
    private By username_field_name = By.name("username");
    private By email_field_name = By.name("email");
    private By submit_button_name = By.name("submit");
    private By reset_password_request_confirm_msg_id = By.id("forgot-dialog2");
    private By email_does_not_exist_err_msg_id = By.id("forgot-error1");
    private By invalid_username_err_msg_id = By.id("forgot-error2");
    private By all_fields_are_required_err_msg_id = By.id("forgot-error3");
    private By return_to_login_linkText = By.linkText("Return to Login");

    public ResetPasswordPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return getDriver().getCurrentUrl();
    }

    public void verifyResetPasswordPage(){
        assertEquals(getPageUrl(),"");
    }

    public void verifyResetInstruction() {
        assertEquals(getDriver().findElement(reset_password_instruction_id).getText(), "Please provide your username and email so we can send you instructions for resetting your password.");
    }

    public void enterUsername(String username) {
        getDriver().findElement(username_field_name).sendKeys(username);
    }

    public void enterEmailId(String emailId) {
        getDriver().findElement(email_field_name).sendKeys(emailId);
    }

    public void clickOnSubmitButton() {
        getDriver().findElement(submit_button_name).click();
    }

    public void verifyPasswordResetConfirmationMsg() {
        assertEquals(getDriver().findElement(reset_password_request_confirm_msg_id).getText(), " We have received your request for a password reset.\n" +
                "It may take a few minutes for the password reset instructions to arrive in your email.\n" +
                "If you don't receive the email within a few minutes, please check your Junk/Spam email folder.\n" +
                "The password reset link will expire after 48 hours.\n" +
                "Return to Login ");
    }


    public void verifyErrorMsgEmailDoesNotExist() {
        assertEquals(getDriver().findElement(email_does_not_exist_err_msg_id).getText(), "The email address provided does not match the email address " +
                "we have on file for your username. Please correct and try again.");
    }

    public void verifyErrorMsgInvalidUsername() {
        assertEquals(getDriver().findElement(invalid_username_err_msg_id).getText(), "Please enter a valid username.");
    }

    public void verifyErrorMsgAllFieldsAreRequired() {
        assertEquals(getDriver().findElement(all_fields_are_required_err_msg_id).getText(), "All fields are required.");
    }

    public LoginPage clickOnReturnToLoginLink() {
        getDriver().findElement(return_to_login_linkText).click();
        LoginPage loginPage = new LoginPage(getDriver(), getUrlPrefix());
        return loginPage;
    }
}
