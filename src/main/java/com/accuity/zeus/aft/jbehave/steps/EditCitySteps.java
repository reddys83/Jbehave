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

	@When("the user clicks on the add new identifier button in the basic info city page")
	public void clickOnAddNewIdentifirButton() {
		getEditCityPage().clickOnAddNewIdentifirButton();
	}

	 @When("the user enters identifier type as <identifierType> in the basic info city page")
	    public void enterIdentifierType(@Named("identifierType") String identifierType) {
	    	getEditCityPage().enterIdentifierType(identifierType);
	    }
	 
	 @When("the user enters identifier status as <identifierStatus> in the basic info city page")
	    public void enterIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
		 getEditCityPage().enterIdentifierStatus(identifierStatus);
	        
	    }
	 
	 @When("the user clicks on the delete identifier row button in the basic info city page")
	    public void clickOnDeleteNewIdentifierRowButtonCity(){
		 getEditCityPage().clickOnDeleteNewIdentifierRowButtonCity();
	    }
	 
	 @Then("the user should not see the newly added identifier row in the basic info city page")
	    public void verifyNewlyAdedIdentifierRowIsNotDisplayed() {
		 getEditCityPage().verifyNewlyAdedIdentifierRowIsNotDisplayed();
	    }
	 
	   @Then("the user should see delete row confirmation modal in the city page")
	    public void verifyDeleteConfirmationModal(){
		 getEditCityPage().verifyDeleteConfirmationModal();
	    }
	 
	 @When("the user enters identifier value as <identifierValueIncorrect> in the basic info city page")
	    public void enterIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
		 getEditCityPage().enterIdentifierValue(incorrectIdentifierValue);
	    }
	 
	 @When("the user clears identifier value in the basic info city page")
	    public void clearCityIdentifierValue(){
		 getEditCityPage().clearCityIdentifierValue();
	    }
	 
	 @When("the user enters identifier value as <identifierValue> in the basic info city page")
	    public void enterIdentifierValues(@Named("identifierValue") String identifierValue) {
		 getEditCityPage().enterIdentifierValue(identifierValue);
	    }
	 
	 @When("the user clicks on the confirm button in city page")
	    public void clickOnConfirmButtonCity() throws Exception {
		 getEditCityPage().clickOnConfirmButtonCity();
	    }
	 
	  	 
	 @Then("the user should see the updated identifiers in the City page as $identifierType $identifierValue $identifierStatus")
	    public void verifyUpdateSuccessMessage(@Named("identifierType") String identifierType,@Named("identifierValue") String identifierValue,@Named("identifierStatus") String identifierStatus) throws Exception {
		  getEditCityPage().verifyUpdateSuccessIdentifiers(identifierType,identifierValue,identifierStatus);
	    }
	 
}