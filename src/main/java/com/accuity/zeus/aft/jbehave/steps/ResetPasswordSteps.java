package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordSteps extends AbstractSteps{

    @Value("${data.management.webapp.aft.uid}")
    private String username;

    @Value("${data.management.webapp.aft.email}")
    private String emailAddress;

    @Then("the user should see the reset password page")
    public void thenTheUserShouldSeeResetPwdPage(){
        getResetPasswordPage().verifyResetPasswordPage();
    }

    @Then("the user should see the instructions to provide username and email id in the reset password page")
    public void thenUserShouldSeeProvideUidEmailMsg(){
        getResetPasswordPage().verifyResetInstruction();
    }

    @When("the user enters a valid username in the reset password page")
    public void whenUserEntersUsername(){
        getResetPasswordPage().enterUsername(username);
    }

    @When("the user enters a valid email address in the reset password page")
    public void whenUserEntersEmailId(){
        getResetPasswordPage().enterEmailId(emailAddress);
    }

    @When("the user enters an invalid username $invalidUsername in the reset password page")
    public void whenUserEntersUsername(String invalidUsername){
        getResetPasswordPage().enterUsername(invalidUsername);
    }

    @When("the user enters an invalid email address $invalidEmail in the reset password page")
    public void whenUserEntersEmailId(String invalidEmail){
        getResetPasswordPage().enterEmailId(invalidEmail);
    }

    @When("the user clicks on the submit button in the reset password page")
    public void whenUserClicksOnSubmitButton(){
        getResetPasswordPage().clickOnSubmitButton();
    }

    @Then("the user should see the password reset request confirmation message in the reset password page")
    public void thenUserShouldSeePasswordResetRequestConfirmationMsg(){
        getResetPasswordPage().verifyPasswordResetConfirmationMsg();
    }

    @Then("the user should see the error message that says email does not match with the ID")
    public void thenUserShouldSeeEmailDoesNotExistErrMsg(){
        getResetPasswordPage().verifyErrorMsgEmailDoesNotExist();
    }

    @When("the user refreshes the reset password page")
    public void userRefreshesPasswordResetPage(){
        getResetPasswordPage().refreshPage();
    }

    @Then("the user should see the error message for invalid username in the reset password page")
    public void thenUserShouldSeeInvalidUsernameErrMsg(){
        getResetPasswordPage().verifyErrorMsgInvalidUsername();
    }

    @Then("the user should see the error message that all fields are required")
    public void thenUserShouldSeeAllFieldsRequiredErrMsg(){
        getResetPasswordPage().verifyErrorMsgAllFieldsRequired();
    }

    @Then("the user should see the error message to enter a valid email address")
    public void thenUserShouldSeeAllFieldsAreRequiredErrMsg(){
        getResetPasswordPage().verifyErrorMsgEnterValidEmailAddress();
    }

    @When("the user clicks on return to login link in the reset password page")
    public void whenUserClicksOnReturnToLoginLink(){
        setLoginPage(getResetPasswordPage().clickOnReturnToLoginLink());
    }
}
