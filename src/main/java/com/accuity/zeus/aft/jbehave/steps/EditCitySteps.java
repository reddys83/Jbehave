package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

import java.text.ParseException;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditCitySteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user enters the <addInfoText> in the add info text area")
	public void enterTextInCityAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().enterTextCityAddInfo(addInfoText);
	}

	@Then("the user reverts the changes to the add info text area")
	public void clearAddInfoTextArea() {
		getEditCityPage().clearAddInfoTextArea();
	}

	@Then("the user should be able to verify the values are entered in the add info field")
	public void verifyTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyTextInAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the maximum values are entered in the add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditCityPage().verifyMaximumChracterEnteredInAddInfo();
	}

	@Then("the user should verify that same <addInfoText> has been entered in the text area")
	public void verifySameTextInTextArea(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifySameTextInTextArea(addInfoText);
	}

	@When("the user clicks on the Status drop-down in the basicinfo city page")
	public void clickOnCityStatusDropDown() {
		getEditCityPage().clickOnCityStatusDropDown();
	}

	@When("the user enters values which is beyond 500 unicode characters in the add info field")
	public void enterInvalidCharactersInCityAddInfo() {
		getEditCityPage().enterInvalidCharactersInCityAddInfo();
	}

	@Then("the user should be able to view the error message 'Enter up to 500 valid characters'")
	public void verifyErrorMessageInCityAddInfo() {
		getEditCityPage().verifyErrorMessageInCityAddInfo();
	}

	@Then("the user should see the addInfoText value same as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddInfoValueFromTrusted(country, area, city, "additionalinfo", source);
	}

	@Then("the user should see the city addinfo value $addInfoText as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "additionalinfo", source, addInfoText);
	}

	@When("the user gets the value already present in the text box")
	public void getTextInTextArea() {
		getEditCityPage().getTextInTextArea();
	}

	@Then("the user verifies whether the new value <addInfoText> is different from previous value")
	public void newValueCheck(@Named("addInfoText") String addInfoText) {
		getEditCityPage().newValueCheck(addInfoText);
	}

	@Then("the user should see no summary changes in the city save confirmation modal")
	public void verifyNoSummaryInConfirmationModal(@Named("Summary") String summaryText) {
		getEditCityPage().verifyNoSummaryConfirmationModal(summaryText);
	}

	@Then("the user should be able to view that only 500 unicode characters are saved")
	public void viewValidCharacterLength() {
		getEditCityPage().viewValidCharacterLength();
	}

	@Then("the user should see the status values from City Status dropdown")
	public void verifyCityStatusList() {
		getEditCityPage().verifyCityStatusList();
	}

	@When("the user starts typing the name of a status as $word in the City Status drop-down")
	public void enterValueInStatusDropdown(String word) {
		getEditCityPage().enterValueInStatusDropdown(word);

	}

	@Then("the user should see the selected status in the City Status drop-down as $status")
	public void verifyStatusInDropdown(String status) {
		getEditCityPage().verifyStatusInDropdown(status);
	}

	@Then("the user should return to edit city page mode")
	public void verifyCityEditPageMode() {
		getEditCityPage().verifyCityEditPageMode();
	}

	@Then("the user should see the city status value same as in $source document")
	public void verifyCityStatusValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityInfoFromTrustedDB(country, area, city, "status", source);
	}

	@Then("the user should see the city $status value as in $source document")
	public void verifyCityStatusValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("status") String status) {
		getEditCityPage().verifyCityInfoFromZeusDB(country, area, city, "status", source, status);
	}

	@When("the user selects value as $status from Status drop-down in the city basicinfo page")
	public void selectCityStatusValue(@Named("status") String status) {
		getEditCityPage().selectCityStatusValue(status);
	}

	@When("the user clicks on the save button in city page")
	public void clickOnSaveButton() {
		getEditCityPage().clickOnSaveButton();
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);

	}

	@Then("the user should not see the <ConfirmationSummary> changes in confirmation modal")
	public void verifyNoChangeConfirmationMsg(@Named("ConfirmationSummary") String ConfirmationSummary) {
		getEditCityPage().verifyNoChangeConfirmationMsg(ConfirmationSummary);
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

	@When("the user deletes the existing identifier rows")
	public void deleteAllIdentifiers() {
		getEditCityPage().deleteAllIdentifierRows();
	}

	@When("the user enters the month <beganMonth> in the drop down box for Began Date")
	public void enterMonthInBeganDate(@Named("beganMonth") String month) {
		getEditCityPage().enterMonthInBeganDate(month);
	}

	@When("the user enters the year <beganYear> in the text box for Began Date")
	public void enterYearInBeganDate(@Named("beganYear") String year) {
		getEditCityPage().enterYearInBeganDate(year);
	}
	
	@When("the user enters the day <endDay> in the text box for End Date")
	public void enterDayInEndDate(@Named("endDay") String day) {
		getEditCityPage().enterDayInEndDate(day);
	}

	@When("the user enters the month <endMonth> in the drop down box for End Date")
	public void enterMonthInEndDate(@Named("endMonth") String month) {
		getEditCityPage().enterMonthInEndDate(month);
	}

	@When("the user enters the year <endYear> in the text box for End Date")
	public void enterYearInEndDate(@Named("endYear") String year) {
		getEditCityPage().enterYearInEndDate(year);
	}
	
	@Then("the user verifies whether all the months in the drop down option are present in chronological order")
	public void verifyMonthInChronologicalOrder() {
		getEditCityPage().verifyMonthInChronologicalOrder();
	}
	
	@Then("the user should see the <endDate> value as in $source document")
	public void verifyCityEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("endDate") String endDate) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "EndDate", source, endDate);
	}
	
	@When("the user verifies that the <endDay>, <endMonth> and <endYear> is in Gregorian Calendar format")
	public void verifyGregorianCalendarFormat(@Named("endDay") String day, @Named("endMonth") String month,
			@Named("endYear") String year) {
		getEditCityPage().verifyGregorianCalendarFormat(day, month, year);
	}
	
	@When("the user verifies that the <endDay>, <endMonth> and <endYear> is not later than today")
	public void verifyBeganDateIsBeforeToday(@Named("endDay") String day, @Named("endMonth") String month,
			@Named("endYear") String year) throws ParseException {
		getEditCityPage().verifyDateIsBeforeToday(day, month, year);
	}
	
	@Then("the user verifies whether error message <errMsg> is displayed for End Date")
	public void verifyErrorMessageForEndDate(@Named("errMsg") String errMsg) {
		getEditCityPage().verifyErrorMessageForEndDate(errMsg);
	}
	
	@When("the user enters the day <endDay2> in the text box for End Date")
	public void enterDayInEndDate2(@Named("endDay2") String day) {
		getEditCityPage().enterDayInEndDate(day);
	}

	@When("the user enters the month <endMonth2> in the drop down box for End Date")
	public void enterMonthInEndDate2(@Named("endMonth2") String month) {
		getEditCityPage().enterMonthInEndDate(month);
	}

	@When("the user enters the year <endYear2> in the text box for End Date")
	public void enterYearInEndDate2(@Named("endYear2") String year) {
		getEditCityPage().enterYearInEndDate(year);
	}
	
	@When("the user enters the future date in the text box for End Date")
	public void enterDateLaterThanToday() throws ParseException {
		getEditCityPage().enterDateLaterThanToday();
	}
	
	@When("the user clears the day, month and year values for Began Date")
	public void clearBeganDate() {
		getEditCityPage().clearBeganDate();
	}
	

}
