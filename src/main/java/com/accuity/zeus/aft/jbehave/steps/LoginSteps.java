package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.LoginPage;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

@Component
public class LoginSteps extends AbstractSteps {

    private LoginPage loginPage;

    @Given("user is on the login page")
    public void givenUserOpensLoginPage(){
        loginPage = new LoginPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
        loginPage.open();
    }

    @When("the user enters username as <username>")
    public void whenUserEntersUserName(@Named("username") String username){
        loginPage.enterUserName(username);
    }

    @When("the user enters password as <password>")
    public void whenUserEntersPassword(@Named("password") String password){
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void whenUserClicksOnLoginButton(){
        setSearchPage(loginPage.clickOnLoginButton());
    }

    @Then("the user should see the search page")
    public void thenUserShouldSeeSearchPage(){
        getSearchPage().validatePage();
    }

    @Then("the user should see the error message please enter a valid username/password combination")
    public void thenUserShouldSeeInvalidCombinationErrorMessage(){
        loginPage.verifyInvalidCombinationErrorMessage();
    }

    @Then("the user should see the error message all fields are required")
    public void thenUserShouldSeeAllFieldsRequiredErrorMessage(){
        loginPage.verifyAllFieldsAreRequiredErrorMessage();
    }

    @When("the user clicks on the forgot password link on login screen")
    public void whenUserClicksOnForgotPasswordLink(){
        setResetPasswordPage(loginPage.clickOnForgotPasswordLink());
    }

    @Then("the user should see the login page")
    @Aliases (values={"the user is successfully logged out",
                      "the user is still logged out"})
    public void thenTheUserShouldSeeLoginPage(){
        getLoginPage().verifyLoginPage();
    }

    @When("I click the back button on the browser")
    public void whenIClickBackButton(){
        loginPage.clickBackButton();
    }

}
