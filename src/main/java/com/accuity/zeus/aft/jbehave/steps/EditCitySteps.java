package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

import java.text.ParseException;

import org.jbehave.core.annotations.*;
import java.lang.StringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditCitySteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user enters the <value> in the population field")
	public void entervalueInPopulationField(@Named("value") String value) {
		getEditCityPage().entervalueInPopulationField(value);
	}

	@When("the user enters the <addInfoText> in the add info text area")
	public void enterTextInCityAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().enterTextCityAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the values are entered in the add info field")
	public void verifyTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyTextInAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the maximum values are entered in the add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditCityPage().verifyMaximumChracterEnteredInAddInfo();
	}

	@When("the user clicks on the Status drop-down in the basicinfo city page")
	public void clickOnCityStatusDropDown() {
		getEditCityPage().clickOnCityStatusDropDown();
	}

	@Then("the user should be able to view the error message 'Enter up to 50 valid numbers'")
	public void verifyErrorMessageInCityPopulation() {
		getEditCityPage().verifyErrorMessageInCityPopulation();
	}

	@Then("the user should see maximum length of population is limited to $maxLength")
	public void verifyMaxLengthInCityPopulation(String maxLength) {
		getEditCityPage().verifyMaxLengthInCityPopulation(maxLength);
	}

	@Then("the user should see the population $value as in $source document")
	public void verifyCityPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("value") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@Then("the user should see the city addinfo value $addInfoText as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "additionalinfo", source, addInfoText);
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
	public void verifyCityStatusInDropdown(String status) {
		getEditCityPage().verifyCityStatusInDropdown(status);
	}

	@Then("the user should return to edit city page mode")
	public void verifyCityEditPageMode() {
		getEditCityPage().verifyCityEditPageMode();
	}

	@Then("the user should see the city status value same as in $source document")
	public void verifyCityStatusInfoFromTrustedDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityStatusInfoFromTrustedDB(country, area, city, "status", source);
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
		getEditCityPage().verifyNoSummaryConfirmationModal(ConfirmationSummary);
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
		getEditCityPage().verifyErrorMessageForRequiredCityIdentifierValue();
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

	@When("the user enters values which is beyond 500 unicode characters in the add info field")
	public void enterInvalidCharactersInCityAddInfo() {
		getEditCityPage().enterInvalidCharactersInCityAddInfo();
	}

	@Then("the user should see the addInfoText value same as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddInfoValueFromTrusted(country, area, city, "additionalinfo", source);
	}

	@When("the user enters the day <beganDay> in the text box for Began Date")
	public void enterDayInBeganDate(@Named("beganDay") String beganDay) {
		getEditCityPage().enterDayInBeganDate(beganDay);
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

	@Then("the user should see the $endDay2 $endMonth2 $endYear2 value as in $source document")
	public void verifyCityEndDate2ValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("endDay2") String day2,
			@Named("endMonth2") String month2, @Named("endYear2") String year2) {
		String endDate = day2 + " " + month2 + " " + year2;
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "EndDate", source, endDate);
	}

	@Then("the user verifies whether error message $errMsg is displayed for End Date")
	public void verifyErrorMessageForEndDate(@Named("errMsg") String errMsg) {
		getEditCityPage().verifyErrorMessageForEndDate(errMsg);
	}

	@When("the user enters $endDay2 $endMonth2 $endYear2 for End Date values")
	public void enterEndDate(@Named("endDay2") String endDay2, @Named("endMonth2") String endMonth2,
			@Named("endYear2") String endYear2) {
		getEditCityPage().enterEndDate(endDay2, endMonth2, endYear2);
	}

	@When("the user enters the future date in the text box for End Date")
	public void enterDateLaterThanToday() throws ParseException {
		getEditCityPage().enterDateLaterThanToday();
	}

	@When("the user clears the day, month and year values for Began Date")
	public void clearBeganDate() {
		getEditCityPage().clearBeganDate();
	}

	@Then("the user should see city end date value same as in $source document")
	public void verifyCityEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifyCityEndDateFromTrustedDB(country, area, city, "EndDate", source);

	}

	@When("the user clicks on True option for Use in Address")
	public void selectTrueForUseInAddress() {
		getEditCityPage().selectTrueForUseInAddress();
	}

	@When("the user clicks on False option for Use in Address")
	public void selectFalseForUseInAddress() {
		getEditCityPage().selectFalseForUseInAddress();
	}

	@Then("the user should see the address flag value same as in $source document")
	public void verifyCityAddressFlagFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddressFlagFromZeusDB(country, area, city, "addressFlag", source);
	}

	@When("the user clicks on the city credit rating link in the navigation bar")
	public void clickOnCityCreditRating() {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().clickOnCityCreditRating();
	}

	@Then("the user should see the error message enter a day/month/year for applied date in the credit rating city page")
	public void verifyErrorMessageEnterYearMonthDayForAppliedDate() {
		getEditCityPage().verifyErrorMessageEnterYearMonthDayForAppliedDate();
	}

	@Then("the user should see the error message enter a day/month/year for confirmed date in the credit rating city page")
	public void verifyErrorMessageEnterYearMonthDayForConfirmedDate() {
		getEditCityPage().verifyErrorMessageEnterYearMonthDayForConfirmedDate();
	}

	@When("the user clicks on add new credit rating button in the credit rating city page")
	public void clickOnAddButton() {
		getEditCityPage().clickAddRowButton();
	}

	@When("the user clicks on the Agency names drop-down in the basicinfo city page")
	public void clickOnCityAgencyDropDown() {
		getEditCityPage().clickOnAgencyDropDown();
	}

	@Then("the user should see the city Agency names from look up $LookUpName in existing creditRating row $rowNumber")
	public void verifyCityAgencyListExistingRow(@Named("rowNumber") int rowNumber) {
		getEditCityPage().verifyCityAgencyListFromLookup(rowNumber);
	}

	@Then("the user should see the city Agency types from look up $LookUpName in existing creditRating row $rowNumber")
	public void verifyCityAgencyTypListExistingRow(@Named("rowNumber") int rowNumber) {
		getEditCityPage().verifyCityCreditRatingTypeList(rowNumber);
	}

	@Then("the user should see the city Agency names from look up $LookUpName in new creditRating row $rowNumber")
	public void verifyCityAgencyList(@Named("rowNumber") int rowNumber) {
		getEditCityPage().verifyCityAgencyListFromLookup(rowNumber);
	}

	@Then("the user should see the city Agency types from look up $LookUpName in new creditRating row $rowNumber")
	public void verifyCityAgencyTypList(@Named("rowNumber") int rowNumber) {
		getEditCityPage().verifyCityCreditRatingTypeList(rowNumber);
	}

	@When("the user enters applied date day $appliedDay $appliedMonth $appliedYear in the credit rating city page")
	public void enterCityCreditRatingAppliedDateDay(@Named("appliedDay") String appliedDay,
			@Named("appliedMonth") String appliedMonth, @Named("appliedYear") String appliedYear,
			@Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingAppliedDateDay(appliedDay, row);
		getEditCityPage().enterCityCreditRatingAppliedDateMonth(appliedMonth, row);
		getEditCityPage().enterCreditRatingAppliedYear(appliedYear, row);
	}

	@When("the user enters confirmed date day $confirmedDay $confirmedMonth $confirmedYear in the credit rating city page")
	public void enterCityCreditRatingConfirmedDateDay(@Named("confirmedDay") String confirmedDay,
			@Named("confirmedMonth") String confirmedMonth, @Named("confirmedYear") String confirmedYear,
			@Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingConfirmedDateDay(confirmedDay, row);
		getEditCityPage().enterCityCreditRatingConfirmedDateMonth(confirmedMonth, row);
		getEditCityPage().enterCreditRatingConfirmedYear(confirmedYear, row);
	}

	@When("the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page")
	public void enterCreditRatingType(@Named("type") String creditRatingType, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingType(creditRatingType, row);
	}

	@When("the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page")
	public void enterCreditRatingAgency(@Named("agency") String agency, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingAgency(agency, row);
	}

	@When("the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page")
	public void enterCityCreditRatingValue(@Named("value") String value, @Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingValue(value, row);
	}

	@When("the user enters credit rating type as <type2> in credit rating row $rowNumber in the basic info city page")
	public void enterCreditRatingType2(@Named("type2") String creditRatingType, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingType(creditRatingType, row);
	}

	@When("the user enters credit rating agency as <agency2> in credit rating row $rowNumber in the basic info city page")
	public void enterCreditRatingAgency2(@Named("agency2") String agency, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingAgency(agency, row);
	}

	@When("the user enters credit rating <value2> in credit rating row $rowNumber in the basic info city page")
	public void enterCityCreditRatingValue2(@Named("value2") String value, @Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingValue(value, row);
	}

	@Then("the user should see the city credit rating values same as in $source document")
	public void verifyCityCreditRatingValueFromTrustedDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityCreditRatingValuesFromTrustedDB(country, area, city, source);
	}

	@Then("the user should see the city credit rating values as in $source document")
	public void verifyCityCreditRatingValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("agency") String agency,
			@Named("type") String type, @Named("value") String value, @Named("appliedDay") String appliedDay,
			@Named("appliedMonth") String appliedMonth, @Named("appliedYear") String appliedYear,
			@Named("confirmedDay") String confirmedDay, @Named("confirmedMonth") String confirmedMonth,
			@Named("confirmedYear") String confirmedYear, @Named("rowNumber") int row) {

		String appliedDate = appliedDay + " " + appliedMonth + " " + appliedYear;
		String confirmedDate = confirmedDay + " " + confirmedMonth + " " + confirmedYear;
		getEditCityPage().verifyCityCreditRatingValuesFromDB(country, area, city, source, agency, type, value,
				appliedDate, confirmedDate, row);
	}

	@Then("the user should see the updated city credit rating values as in $source document")
	public void verifyCityCreditRatingUpdatedValuesFromZeusDB(@Named("country") String country,
			@Named("area") String area, @Named("city") String city, @Named("source") String source,
			@Named("agency2") String agency, @Named("type2") String type, @Named("value2") String value,
			@Named("appliedDay") String appliedDay, @Named("appliedMonth") String appliedMonth,
			@Named("appliedYear") String appliedYear, @Named("confirmedDay") String confirmedDay,
			@Named("confirmedMonth") String confirmedMonth, @Named("confirmedYear") String confirmedYear,
			@Named("rowNumber") int row) {

		String appliedDate = appliedDay + " " + appliedMonth + " " + appliedYear;
		String confirmedDate = confirmedDay + " " + confirmedMonth + " " + confirmedYear;
		getEditCityPage().verifyCityCreditRatingValuesFromDB(country, area, city, source, agency, type, value,
				appliedDate, confirmedDate, row);
	}

	@When("the user enters applied date day <appliedDay> in the credit rating city page")
	public void enterCityCreditRatingAppliedDay(@Named("appliedDay") String appliedDay, @Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingAppliedDateDay(appliedDay, row);
	}

	@When("the user selects applied date month <appliedMonth> in the credit rating city page")
	public void enterCityCreditRatingAppliedDateMonth(@Named("appliedMonth") String appliedMonth,
			@Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingAppliedDateMonth(appliedMonth, row);
	}

	@When("the user enters applied date year <appliedYear> in the credit rating city page")
	public void enterCreditRatingAppliedYear(@Named("appliedYear") String appliedYear, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingAppliedYear(appliedYear, row);
	}

	@When("the user enters confirmed date day <confirmedDay> in the credit rating city page")
	public void enterCityCreditRatingConfirmedDateDay(@Named("confirmedDay") String confirmedDay,
			@Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingConfirmedDateDay(confirmedDay, row);
	}

	@When("the user selects confirmed date month <confirmedMonth> in the credit rating city page")
	public void enterCityCreditRatingConfirmedDateMonth(@Named("confirmedMonth") String confirmedMonth,
			@Named("rowNumber") int row) {
		getEditCityPage().enterCityCreditRatingConfirmedDateMonth(confirmedMonth, row);
	}

	@When("the user enters confirmed date year <confirmedYear> in the credit rating city page")
	public void enterConfirmedYear(@Named("confirmedYear") String confirmedYear, @Named("rowNumber") int row) {
		getEditCityPage().enterCreditRatingConfirmedYear(confirmedYear, row);
	}

	@When("the user deletes the existing credit rating rows")
	public void deleteExistingCreditRatingRows() {
		getEditCityPage().deleteExistingCreditRatingRows();
	}

	@Then("user should see Required error message in credit rating agency field")
	public void verifyErrorMessageForRequiredCityCreditRatingAgency() {
		getEditCityPage().verifyErrorMessageForRequiredCityCreditRatingAgency();
	}

	@Then("user should see Required error message in credit rating type field")
	public void verifyErrorMessageForRequiredCityCreditRatingType() {
		getEditCityPage().verifyErrorMessageForRequiredCityCreditRatingType();
	}

	@Then("the user should be able to view the error message $errorMsg in credit rating value")
	public void verifyErrorMessageInCityCreditRatingValue(@Named("errorMsg") String errorMsg) {
		getEditCityPage().verifyErrorMessageInCityCreditRatingValue(errorMsg);
	}

	@When("the user clicks on the delete credit rating row button in the basic info city page")
	public void clickOnDeleteNewCreditRatingRowButtonCity() {
		getEditCityPage().clickOnDeleteNewCreditRatingRowButtonCity();
	}

	@Then("the user should not see the newly added credit rating row in the basic info city page")
	public void verifyNewlyAddedCreditRatingRowIsNotDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedCreditRatingRowIsNotDisplayed();
	}

	@Then("the user should see the newly added credit rating row in the basic info city page")
	public void verifyNewlyAddedCreditRatingRowIsDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedCreditRatingRowIsDisplayed();
	}

	@Then("the user should see delete row confirmation modal in credit rating")
	public void verifyDeleteConfirmationModalCreditRating() {
		getEditCityPage().verifyCreditRatingDeleteConfirmationModal();
	}

	@Then("the user should not see the city credit rating values in $source document")
	public void verifyCityCreditRatingValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("rowNumber") int row) {
		getEditCityPage().verifyCityCreditRatingValuesAreNullFromDB(country, area, city, source, row);
	}

	@Then("the user should see the entered city credit rating values are saved in UI in the row number $rowNumber")
	public void verifyCityCreditRatingValueFromUI(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("agency") String agency, @Named("type") String type,
			@Named("value") String value, @Named("appliedDay") String appliedDay,
			@Named("appliedMonth") String appliedMonth, @Named("appliedYear") String appliedYear,
			@Named("confirmedDay") String confirmedDay, @Named("confirmedMonth") String confirmedMonth,
			@Named("confirmedYear") String confirmedYear, @Named("rowNumber") int row) {

		String appliedDate = appliedDay + " " + appliedMonth + " " + appliedYear;
		String confirmedDate = confirmedDay + " " + confirmedMonth + " " + confirmedYear;
		getEditCityPage().verifyCityCreditRatingValuesFromUI(country, area, city, agency, type, value, appliedDate,
				confirmedDate, row);
	}

	@Then("the user should see the entered city credit rating values are updated in UI in the row number $rowNumber")
	public void verifyCityCreditRatingUpdatedValueFromUI(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("agency2") String agency, @Named("type2") String type,
			@Named("value2") String value, @Named("appliedDay") String appliedDay,
			@Named("appliedMonth") String appliedMonth, @Named("appliedYear") String appliedYear,
			@Named("confirmedDay") String confirmedDay, @Named("confirmedMonth") String confirmedMonth,
			@Named("confirmedYear") String confirmedYear, @Named("rowNumber") int row) {

		String appliedDate = appliedDay + " " + appliedMonth + " " + appliedYear;
		String confirmedDate = confirmedDay + " " + confirmedMonth + " " + confirmedYear;
		getEditCityPage().verifyCityCreditRatingValuesFromUI(country, area, city, agency, type, value, appliedDate,
				confirmedDate, row);
	}

	@When("the user enters applied date that is later than today")
	public void enterAppliedDateLaterThanToday(@Named("row") int row) {
		getEditCityPage().enterAppliedDateLaterThanToday(row);
	}

	@When("the user enters confirmed date that is later than today")
	public void enterConfirmedDateLaterThanToday(@Named("row") int row) {
		getEditCityPage().enterConfirmedDateLaterThanToday(row);
	}

	@Then("the user should see the error text $appliedDateErrorMsg for applied date in the credit rating city page")
	public void verifyErrorMessageForAppliedDate(@Named("appliedDateErrorMsg") String appliedDateErrorMsg) {
		getEditCityPage().verifyErrorMessageForAppliedDate(appliedDateErrorMsg);
	}

	@Then("the user should see the error text $confirmedDateErrorMsg for confirmed date in the credit rating city page")
	public void verifyInvalidDateErrorMessageForConfirmedDate(
			@Named("confirmedDateErrorMsg ") String confirmedDateErrorMsg) {
		getEditCityPage().verifyErrorMessageForConfirmedDate(confirmedDateErrorMsg);
	}

}
