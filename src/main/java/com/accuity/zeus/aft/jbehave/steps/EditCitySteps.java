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

	@When("the user clicks on the city tab update link")
	public void clickOnUpdateCurrencyLink() {
		getDataPage().clickOnUpdateCurrencyLink();
		if (editCityPage == null)
			setEditCityPage(getDataPage().createEditCityPage());
	}
	
	@When("the user clicks on the add new identifier button in the basic info city page")
	public void clickOnAddNewIdentifierButton() {
		getEditCityPage().clickOnAddNewIdentifierButton();
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
	 
	 @When("the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page")
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
	 
	 @Then("the user should see the error message for the required identifier value field in the city basic info page")
	    public void verifyErrorMessageForRequiredCityIdentifierValue() {
	        getEditCityPage().verifyErrorMessageForRequiredCityIdentifierValue();
	    }
	 
	 @Then("the user should see the error message for the required identifier type field in the city basic info page")
	    public void verifyErrorMessageForRequiredCityIdentifierType() {
	        getEditCityPage().verifyErrorMessageForRequiredCityIdentifierType();
	    }
	 
	 @Then("the user should see the error message for the required identifier status field in the city basic info page")
	    public void verifyErrorMessageForRequiredCityIdentifierStatus() {
		 getEditCityPage().verifyErrorMessageForRequiredCityIdentifierStatus();
	 }
	 
	 @Then("the user should see the Enter up to 50 valid characters error message for the identifier value field in the city basic info page")
	    public void verifyErrorMessageForLongCityIdentifierValue() {
	        getEditCityPage().verifyErrorMessageForLongCityIdentifierValue();
	    }
	 
	 @When("the user presses enter button to delete row in city basic info page")
	    public void pressEnterButtonInDeleteConfirmationModalForCity(){
	        getEditCityPage().pressEnterButtonInDeleteConfirmationModalForCity();
	    }
	 
	 @When("the user clicks on the No button to cancel the deletion of row")
	 public void clickNoButtonInDeleteConfirmationModalForCity() {
		 getEditCityPage().clickNoButtonInDeleteConfirmationModalForCity();
	 }
	 
	 @When("the user clicks on the Yes button to cancel the deletion of row")
	 public void clickYesButtonInDeleteConfirmationModalForCity() {
		 getEditCityPage().clickYesButtonInDeleteConfirmationModalForCity();
	 }
	 
	 @Then("the user should not see delete row confirmation modal in the city page")
	 public void verifyNoDeleteConfirmationModal(){
		 getEditCityPage().verifyNoDeleteConfirmationModal();
	    }
}