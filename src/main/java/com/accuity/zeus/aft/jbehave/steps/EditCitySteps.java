package com.accuity.zeus.aft.jbehave.steps;

import java.text.ParseException;
import java.util.Map;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

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
		String endDate = day2 +" " + month2 + " " + year2;
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "EndDate", source, endDate);
	}

	@Then("the user verifies whether error message $errMsg is displayed for End Date")
	public void verifyErrorMessageForEndDate(@Named("errMsg") String errMsg) {
		getEditCityPage().verifyErrorMessageForEndDate(errMsg);
	}

	@When("the user enters $endDay2 $endMonth2 $endYear2 for End Date values")
	public void enterEndDate(@Named("endDay2") String endDay2, @Named("endMonth2") String endMonth2,@Named("endYear2") String endYear2) {
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

	// Suresh TODO: Start of city names
	@Then("the user should see city name value same as in $source document")
	public void verifyCityNameTypeAndValueFromDB(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
												 @Named("source") String source) {
		setEditCityPage(getDataPage().createEditCityPage());
		Map<String, String> cityNameValueMap = getEditCityPage().getCityNameValueMapFromDB(country, area, city, source);
		getEditCityPage().verifyCityNameTypeAndValueFromDB(cityNameValueMap, "Full Name");
	}
	
	@When("the user should see the full name is not editable")
	public void verifyFullNameFieldNotEditable() {
		getEditCityPage().verifyFullNameFieldNotEditable();
	}

	@When("the user enters the <newNameValue> in the full name field")
	public void enterValueInFullTypeNameField(@Named("newNameValue") String newNameValue) {
		getEditCityPage().enterValueInFullTypeNameField(newNameValue);
	}
	
	@Then("the user should see the full name <newNameValue> as in $source document")
	public void verifyCityFullNameValueFromDB(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
											  @Named("source") String source, @Named("newNameValue") String fullNameValue) {
		Map<String, String> cityNameValueMap = getEditCityPage().getCityNameValueMapFromDB(country, area, fullNameValue, source);
		getEditCityPage().verifyNameValueInDB(cityNameValueMap, "Full Name", fullNameValue);
	}
	
	@Then("the user should see the value updated in $source document")
	public void verifyCityValueFromDB(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
									  @Named("source") String source, @Named("newNameType") String newNameType, 
									  @Named("newNameValue") String newNameValue) {
		Map<String, String> cityNameValueMap = getEditCityPage().getCityNameValueMapFromDB(country, area, city, source);
		getEditCityPage().verifyNameValueInDB(cityNameValueMap, newNameType, newNameValue);
	}
	
	@Then("the user should see the value not present in $source document")
	public void verifyCityValueDeletedFromDB(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
											 @Named("source") String source, @Named("newNameType") String newNameType, 
											 @Named("newNameValue") String newNameValue) {
		Map<String, String> cityNameValueMap = getEditCityPage().getCityNameValueMapFromDB(country, area, city, source);
		getEditCityPage().verifyCityValueDeletedFromDB(cityNameValueMap, newNameType);
	}
	
	@Then("the user should see the value newly updated in $source document")
	public void verifyNewlyEnteredCityValueFromDB(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
												  @Named("source") String source, @Named("newNameType") String newNameType, 
												  @Named("newNameValue2") String newNameValue2) {
		Map<String, String> cityNameValueMap = getEditCityPage().getCityNameValueMapFromDB(country, area, city, source);
		getEditCityPage().verifyNameValueInDB(cityNameValueMap, newNameType, newNameValue2);
	}
	
	@When("the user clicks on the add new name button in the basic info city page")
	public void clickOnAddNewNameButton() {
		getEditCityPage().clickOnAddNewNameButton();
	}
	
	@When("the user clicks on the city name type drop-down")
	public void clickOnCityNameType() {
		getEditCityPage().clickOnCityNameType();
	}

	@Then("the user should see the city name types from lookup PLACE_NAME_TYPE")
	public void verifyCityNameTypesList() {
		getEditCityPage().verifyCityNameTypesList();
	}

	@Then("the user should be able to verify the <newNameValue> is updated in full name value field")
	public void verifyTextInNameValue(@Named("newNameValue") String newNameValue) {
		getEditCityPage().verifyTextInFullNameValue(newNameValue);
	}
	
	@Then("the user should see the city name type and value updated in UI")
	public void verityCityNameTypeAndValue(@Named("newNameType") String newNameType, 
										   @Named("newNameValue") String newNameValue) {
		getEditCityPage().verifyNameType(newNameType);
		getEditCityPage().verifyNameValue(newNameType, newNameValue);
	}
	
	@Then("the user should be able to verify empty rows not added in $source document")
	public void verifyNamesEmptyRow(@Named("country") String country, @Named("area") String area, @Named("city") String city, 
									@Named("source") String source) {
		getEditCityPage().verifyNamesEmptyRow(country, area, city, source);
	}

	@When("the user enters name type as <newNameType> in the basic info city page")
	public void enterNameType(@Named("newNameType") String newNameType) {
		getEditCityPage().enterNameType(newNameType);
	}

	@When("the user enters name value as <newNameValue> in the basic info city page")
	public void enterNameValue(@Named("newNameValue") String newNameValue) {
		getEditCityPage().enterNameValue(newNameValue);
	}
	
	@When("the user enters name value as <newNameValue2> in the basic info city page")
	public void enterNameValue2(@Named("newNameValue2") String newNameValue2) {
		getEditCityPage().enterNameValue(newNameValue2);
	}
	
	@Then("the user should see the error message for the required name type field in the city basic info page")
	public void verifyErrorMessageForRequiredCityNameType() {
		getEditCityPage().verifyErrorMessageForRequiredCityNameType();
	}	
	
	@Then("the user should see the error message for the required name value field in the city basic info page")
	public void verifyErrorMessageForRequiredCityNameValue() {
		getEditCityPage().verifyErrorMessageForRequiredCityNameValue();
	}
	
	@When("the user clicks on the delete name row button in the basic info city page")
	public void clickOnDeleteNameRowButtonCity() {
		getEditCityPage().clickOnDeleteNameRowButtonCity();
	}

	@Then("the user should see delete names row confirmation modal in the city page")
	public void verifyNamesDeleteConfirmationModal() {
		getEditCityPage().verifyNamesDeleteConfirmationModal();
	}
	
	@Then("the user checks whether the newly added row does not contain already selected name type")
	public void verifyCityNameTypeInNewlyAddedRow(@Named("newNameType") String newNameType) {
		getEditCityPage().verifyCityNameTypeInNewlyAddedRow(newNameType);
	}
	// Suresh TODO: End of city names
}