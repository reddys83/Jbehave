package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.eclipse.jetty.util.annotation.Name;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditCitySteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user clicks on the city update link")
    public void clickOnUpdateCurrencyLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editCityPage==null){
            editCityPage = getDataPage().createEditCityPage();
        }}
    
    @When("the user enters the <addInfoText> in the add info text area")
    public void enterCityAddInfo(@Named("addInfoText") String addInfoText) {
    	getEditCityPage().enterTextCityAddInfo(addInfoText);
    }
    
    @When("the user enters the <addDifferentInfoText> in the add info text area")
    public void enterDifferentCityAddInfo(@Named("addDifferentInfoText") String addDifferentInfoText) {
    	getEditCityPage().enterDifferentCityAddInfo(addDifferentInfoText);
    }
    
    @When("the user enters values which is beyond 500 unicode characters in the add info field")
    public void enterInvalidCharactersInCityAddInfo() {
    	getEditCityPage().enterInvalidCharactersInCityAddInfo();
    }
    @Then("the user should see the successful update message at top of the page")
    public void verifySuccessfulUpdatedMessage()
    {
    	getEditCityPage().verifySuccessfulUpdatedMessage();
    }
    
    @Then("the user should be able to verify the values are entered in the add info field")
    public void verifyTextInAddInfo(@Named("addInfoText") String addInfoText) {
    	getEditCityPage().verifyTextInAddInfo(addInfoText);
    }
    
    @Then("the user should be able to view the error message 'Enter up to 500 valid characters'")
    public void verifyErrorMessageInCityAddInfo() {
    	getEditCityPage().verifyErrorMessageInCityAddInfo();
    }
}