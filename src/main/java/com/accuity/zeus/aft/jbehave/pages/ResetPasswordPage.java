package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ResetPasswordPage extends AbstractPage {

    private static final String PAGE_URI = "/#forgotPassword";
    private By reset_password_instruction_xpath = By.xpath("//p[@class='info-message']");
    private By reset_password_text_xpath = By.xpath("//*[@id='content']//legend");
    private By username_field_name = By.name("userName");
    private By email_field_name = By.name("emailAddress");
    private By submit_button_id = By.id("forgot-password-submit-button");
    private By reset_password_request_confirm_msg_xpath = By.xpath("//div[@class='success-section']");
    private By error_message_xpath = By.xpath("//div[@class='error-section']");
    private By return_to_login_linkText = By.linkText("Return to Login");

    public ResetPasswordPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
            StringBuilder sb = new StringBuilder();
            sb.append(getUrlPrefix());
            sb.append(PAGE_URI);
            return sb.toString();
    }

    public void verifyResetPasswordPage(){
        assertEquals(getDriver().findElement(reset_password_text_xpath).getText(), "RESET PASSWORD:");
    }

    public void verifyResetInstruction() {
        assertEquals(getDriver().findElement(reset_password_instruction_xpath).getText(), "Please provide your username and email so we can send you instructions for resetting your password.");
    }

    public void enterUsername(String username) {
        getDriver().findElement(username_field_name).sendKeys(username);
    }

    public void enterEmailId(String emailId) {
        getDriver().findElement(email_field_name).sendKeys(emailId);
    }

    public void clickOnSubmitButton() {
        getDriver().findElement(submit_button_id).click();
    }

    public void verifyPasswordResetConfirmationMsg() {
        assertEquals("We have received your request for a password reset.It may take a few minutes for the password reset instructions to arrive in your email." +
                "If you don't receive the email within a few minutes, please check your Junk/Spam email folder." +
                "The password reset link will expire after 48 hours.Return to Login", getTextOnPage(reset_password_request_confirm_msg_xpath).replace("\n","").trim());
    }


    public void verifyErrorMsgEmailDoesNotExist() {
        assertEquals("The email address provided does not match the email address " +
                "we have on file for your username. Please correct and try again.", getTextOnPage(error_message_xpath));
    }

    public void verifyErrorMsgInvalidUsername() {
        assertEquals("Please enter a valid username.", getTextOnPage(error_message_xpath));
    }

    public LoginPage clickOnReturnToLoginLink() {
        getDriver().findElement(return_to_login_linkText).click();
        return new LoginPage(getDriver(), getUrlPrefix());
    }

    public void verifyErrorMsgEnterValidEmailAddress() {
        assertEquals("Please enter a valid email address.", getTextOnPage(error_message_xpath));
    }


    public void refreshPage(){
        getDriver().navigate().refresh();
    }
}
