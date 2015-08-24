package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.commons.XqueryMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.pages.LoginPage;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@Component
public class LoginSteps extends AbstractSteps {

    private LoginPage loginPage;

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    @Value("${data.management.webapp.aft.uid}")
    private String username;

    @Value("${data.management.webapp.aft.pwd}")
    private String password;

    @Given("user is on the login page")
    public void givenUserOpensLoginPage(){
        loginPage = new LoginPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
        loginPage.open();
    }

    @Given("the user excecutes the xquery to get $xqueryName")
    public void executeXquery(String xqueryName){
        ArrayList<String> myList = new ArrayList<>();
        XqueryMap xqueryMap = new XqueryMap();
        database.setScheme("http");
        database.setHost("localhost");
        database.setPort("8003");
        database.setUsername("addn-reader");
        database.setPassword("password1");
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, xqueryMap.getXquery(xqueryName));
        for (int i=0;i<=document.getElementsByTagName("a").getLength();i++){
            myList.add(document.getElementsByTagName("result").item(i).getTextContent());
        }
    }

    @When("the user enters a valid username on the login page")
    public void whenUserEntersUserName(){
        loginPage.enterUserName(username);
    }

    @When("the user enters a valid password on the login page")
    public void whenUserEntersPassword(){
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username on the login page")
    public void whenUserEntersInvalidUserName(){
        loginPage.enterUserName("NotAValidUsername");
    }

    @When("the user enters an invalid password on the login page")
    public void whenUserEntersInvalidPassword(){
        loginPage.enterPassword("NotAValidPassword");
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
