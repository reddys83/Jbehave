package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordSteps extends AbstractSteps{

    @Then("the user should see the reset password page")
    public void thenTheUserShouldSeeResetPwdPage(){
        getResetPasswordPage().verifyResetPasswordPage();
    }

    @Then("the user should see the instructions to provide username and email id in the reset password page")
    public void thenUserShouldSeeProvideUidEmailMsg(){
        getResetPasswordPage().verifyResetInstruction();
    }

    @When("the user enters username as <username> in the reset password page")
    public void whenUserEntersUsername(@Named("username") String username){
        getResetPasswordPage().enterUsername(username);
    }

    @When("the user enters email id as <emailId> in the reset password page")
    public void whenUserEntersEmailId(@Named("emailId") String emailId){
        getResetPasswordPage().enterEmailId(emailId);
    }

    @When("the user clicks on the submit button in the reset password page")
    public void whenUserClicksOnSubmitButton(){
        getResetPasswordPage().clickOnSubmitButton();
    }

    @Then("the user should see the password reset request confirmation message in the reset password page")
    public void thenUserShouldSeePasswordResetRequestConfirmationMsg(){
        getResetPasswordPage().verifyPasswordResetConfirmationMsg();
    }

    @Then("the user should see the error message for email does not match in the reset password page")
    public void thenUserShouldSeeEmailDoesNotExistErrMsg(){
        getResetPasswordPage().verifyErrorMsgEmailDoesNotExist();
    }

    @Then("the user should see the error message for invalid username in the reset password page")
    public void thenUserShouldSeeInvalidUsernameErrMsg(){
        getResetPasswordPage().verifyErrorMsgInvalidUsername();
    }

    @Then("the user should see the error message for all fields are required in the reset password page")
    public void thenUserShouldSeeAllFieldsAreRequiredErrMsg(){
        getResetPasswordPage().verifyErrorMsgAllFieldsAreRequired();
    }

    @When("the user clicks on return to login link in the reset password page")
    public void whenUserClicksOnReturnToLoginLink(){
        setLoginPage(getResetPasswordPage().clickOnReturnToLoginLink());
    }
}
