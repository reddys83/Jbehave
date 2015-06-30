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

    @When("the user enters username as <username> in the login page")
    public void whenUserEntersUserName(@Named("username") String username){
        loginPage.enterUserName(username);
    }

    @When("the user enters password as <password> in the login page")
    public void whenUserEntersPassword(@Named("password") String password){
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the login button in the login page")
    public void whenUserClicksOnLoginButton(){
        setSearchPage(loginPage.clickOnLoginButton());
    }

    @Then("the user should see the search page")
    public void thenUserShouldSeeSearchPage(){
        getSearchPage().validatePage();
    }

    @Then("the user should see the error message please enter a valid username/password combination in the login page")
    public void thenUserShouldSeeInvalidCombinationErrorMessage(){
        loginPage.verifyInvalidCombinationErrorMessage();
    }

    @Then("the user should see the error message all fields are required in the login page")
    public void thenUserShouldSeeAllFieldsRequiredErrorMessage(){
        loginPage.verifyAllFieldsAreRequiredErrorMessage();
    }

    @When("the user clicks on the forgot password link in the login page")
    public void whenUserClicksOnForgotPasswordLink(){
        setResetPasswordPage(loginPage.clickOnForgotPasswordLink());
    }

    @Then("the user should see the login page")
    @Aliases (values={"the user is successfully logged out",
                      "the user is still logged out",
                      "the user should see the login page without any errors"})
    public void thenTheUserShouldSeeLoginPage(){
        getLoginPage().verifyLoginPage();
    }

    @When("the user clicks on the browser navigate back button")
    public void whenUserClickBackButton(){
        loginPage.clickBackButton();
    }

    @When("the user refreshes the login page")
    public void whenTheUserRefreshsesLoginPage(){
        loginPage.refreshPage();
    }

}
