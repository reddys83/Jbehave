package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.*;
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

	
	@When("the user enters the <value> in the population field")
	public void entervalueInPopulationField(@Named("value") String value) {
		getEditCityPage().entervalueInPopulationField(value);
	}

	@Then("the user should be able to verify the values are entered in the population field")
	public void verifyValueInPopulation() {
		getEditCityPage().verifyTextInPopulation();
	}

	@When("the user enters values which is beyond $limit unicode characters in the population field")
	public void enterCharactersBeyondThelimitInCityPopulation(int limit) {
		getEditCityPage().enterCharactersBeyondThelimitInCityPopulation(limit);
	}

	@When("the user enters values which is $limit unicode characters in the population field")
	public void enterCharactersInCityPopulation(int limit) {
		getEditCityPage().enterCharactersInCityPopulation(limit);
	}
	
	@Then("the user should be able to view the error message 'Enter up to 50 valid characters'")
	public void verifyErrorMessageInCityPopulation() {
		getEditCityPage().verifyErrorMessageInCityPopulation();
	}

	@Then("the user should see the population value same as in $source document")
	public void verifyCityPopulationValueFromTrusted(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityPopulationValueFromTrusted(country, area, city, "population", source);
	}

	@Then("the user should see the population $value as in $source document")
	public void verifyCityPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("value") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@Then("the user should see the population <previousValue> should be same in $source document")
	public void verifyCityExpectedPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("previousValue") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@When("the user clicks on the save button in city page")
	public void clickOnSaveButton() {
		getDataPage().clickOnSaveButton();
	}
	
	@Then("the user should see the new population <value> in City page")
	public void verifyPopulationValueCityPage(@Named("value") String value) {
		getEditCityPage().verifyPopulationValueCityPage(value);
	}

	@When("the user clicks on the add new identifier button in the basic info city page")
	public void clickOnAddNewIdentifierButton() {
		getEditCityPage().clickOnAddNewIdentifierButton();
	}

	@When("the user enters identifier type as <identifierType> in the basic info city page")
	public void enterIdentifierType(@Named("identifierType") String identifierType) {
		getEditCityPage().enterIdentifierType(identifierType);
	}

	@When("the user enters identifier type as <identifierType2> in the basic info city page")
	public void enterIdentifierType2(@Named("identifierType2") String identifierType) {
		getEditCityPage().enterIdentifierType_Row(identifierType, 2);
	}

	@When("the user enters identifier status as <identifierStatus> in the basic info city page")
	public void enterIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
		getEditCityPage().enterIdentifierStatus(identifierStatus);

	}

	@When("the user enters identifier status as <identifierStatus2> in the basic info city page")
	public void enterIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
		getEditCityPage().enterIdentifierStatus_Row(identifierStatus, 2);

	}
	
	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@When("the user clicks on the delete identifier row button in the basic info city page")
	public void clickOnDeleteNewIdentifierRowButtonCity() {
		getEditCityPage().clickOnDeleteNewIdentifierRowButtonCity();
	}

	@Then("the user should not see the newly added identifier row in the basic info city page")
	public void verifyNewlyAddedIdentifierRowIsNotDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedIdentifierRowIsNotDisplayed();
	}
	
	@Then("the user should see the newly added identifier row in the basic info city page")
	public void verifyNewlyAddedIdentifierRowIsDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedIdentifierRowIsDisplayed();
	}
	

	@Then("the user should see delete row confirmation modal in the city page")
	public void verifyDeleteConfirmationModal() {
		getEditCityPage().verifyDeleteConfirmationModal();
	}

	@When("the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page")
	public void enterIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
		getEditCityPage().enterIdentifierValue(incorrectIdentifierValue);
	}

	@When("the user clears identifier value in the basic info city page")
	public void clearCityIdentifierValue() {
		getEditCityPage().clearCityIdentifierValue();
	}

	@When("the user enters identifier value as <identifierValue> in the basic info city page")
	public void enterIdentifierValues(@Named("identifierValue") String identifierValue) {
		getEditCityPage().enterIdentifierValue(identifierValue);
	}

	@When("the user enters identifier value as <identifierValue2> in the basic info city page")
	public void enterIdentifierValues2(@Named("identifierValue2") String identifierValue) {
		getEditCityPage().enterIdentifierValue_Row(identifierValue, 2);
	}

	@When("the user clicks on the confirm button in city page")
	public void clickOnConfirmButtonCity() throws Exception {
		getEditCityPage().clickOnConfirmButtonCity();
	}

	@Then("the user should see the updated identifiers in the City page as $identifierType $identifierValue $identifierStatus")
	public void verifyUpdateSuccessMessage(@Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus)
			throws Exception {
		getEditCityPage().verifyUpdateSuccessIdentifiers(identifierType, identifierValue, identifierStatus);
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
	public void pressEnterButtonInDeleteConfirmationModalForCity() {
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
	public void verifyDeleteConfirmationModalIsNotDisplayed() {
		getEditCityPage().verifyDeleteConfirmationModalIsNotDisplayed();
	}
	
	@Then("the user should see the identifier <value> as in zeus document $identifierType $identifierValue $identifierStatus and $identifierType2 $identifierValue2 $identifierStatus2")
	public void verifyCityIdentifierValuesFromTrusted(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {

		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };

		getEditCityPage().verifyCityIdentifierValuesFromTrusted(country, area, city, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@When("the user clicks on the city Identifier type drop-down")
	public void clickOnCityIdentifierType() {
		getEditCityPage().clickOnCityIdentifierType();
	}

	@When("the user clicks on the city Identifier status drop-down")
	public void clickOnCityIdentifierStatus() {
		getEditCityPage().clickOnCityIdentifierStatus();
	}

	@Then("the user should see the city identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO")
	public void verifyCityIdentifierTypesList() {
		getEditCityPage().verifyCityIdentifierTypesList_forOneRow();
	}

	@Then("the user should see the city identifier status from lookup STATUS")
	public void verifyCityIdentifierStatusList() {
		getEditCityPage().verifyCityIdentifierStatusList();
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);
	}
	
	@When("the user deletes the existing identifier rows")
	public void deleteAllIdentifiers()
	{
		getEditCityPage().deleteAllIdentifierRows();
	}

}



