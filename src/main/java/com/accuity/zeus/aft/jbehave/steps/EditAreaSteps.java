package com.accuity.zeus.aft.jbehave.steps;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

@Component
public class EditAreaSteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@Then("the user should see area end date value same as in $source document")
	public void verifyAreaEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		setEditAreaPage(getDataPage().createEditAreaPage());
		getEditAreaPage().verifyAreaEndDateFromTrustedDB(country, area, "EndDate", source);

	}

	@Then("the user verifies whether all the months in the drop down option for End date are in MMM format & are sorted in the chronological order")
	public void verifyEndDateMonthChronologicalOrder() {
		getEditAreaPage().verifyMonthInChronologicalOrder();
	}


	@When("the user gets the document with $xqueryName with the <area> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("area") String param) {
		getDataPage().getDocument(xqueryName, param);
	}

	@When("the user enters began date day <day> in the edit basic info area page")
	public void enterDayInBeganDate(@Named("day") String day) {
		getEditAreaPage().enterDayInBeganDate(day);
	}

	@When("the user enters began date month <month> in the edit basic info area page")
	public void enterMonthInBeganDate(@Named("month") String month) {
		getEditAreaPage().enterMonthInBeganDate(month);
	}

	@When("the user enters began date year <year> in the edit basic info area page")
	public void enterYearInBeganDate(@Named("year") String year) {
		getEditAreaPage().enterYearInBeganDate(year);
	}

	@When("the user enters end date day <day> in the edit basic info area page")
	public void enterDayInEndDate(@Named("day") String day) {
		getEditAreaPage().enterDayInEndDate(day);
	}

	@When("the user enters end date month <month> in the edit basic info area page")
	public void enterMonthInEndDate(@Named("month") String month) {
		getEditAreaPage().enterMonthInEndDate(month);
	}

	@When("the user enters end date year <year> in the edit basic info area page")
	public void enterYearInEndDate(@Named("year") String year) {
		getEditAreaPage().enterYearInEndDate(year);
	}

	@Then("the user should see the error $endDateErrorMsg for area end date")
	public void verifyErrorMessageEndDate(@Named("endDateErrorMsg") String endDateErrorMsg) {
		getEditAreaPage().verifyErrorMessageEndDate(endDateErrorMsg);
	}

	@When("the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page")
	public void enterBeganDate(@Named("beganDay1") String beganDay1, @Named("beganMonth1") String beganMonth1, @Named("beganYear1") String beganYear1) {
		enterDayInBeganDate(beganDay1);
		enterMonthInBeganDate(beganMonth1);
		enterYearInBeganDate(beganYear1);
	}

	@When("the user enters <endDay1> <endMonth1> <endYear1> End Date in the edit basic info area page")
	public void enterEndDate(@Named("endDay1") String endDay1, @Named("endMonth1") String endMonth1, @Named("endYear1") String endYear1) {
		enterDayInEndDate(endDay1);
		enterMonthInEndDate(endMonth1);
		enterYearInEndDate(endYear1);
	}


	@Then("the user should see the entered end date <day> <month> <year> in area page")
	public void verifyEndDateInAreaPage(@Named("day") String day, @Named("month") String month,
			@Named("year") String year) {
		getEditAreaPage().verifyEndDateInAreaPage(day, month, year);
	}

	@Then("the user should see the area end date <day> <month> <year> value in $source document")
	public void verifyAreaEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("day") String day,
			@Named("month") String month, @Named("year") String year) {
		getEditAreaPage().verifyAreaEndDateFromZeusDB(country, area, "EndDate", source, day, month, year);
	}

	@Then("the user should see area began date value same as in $source document")
	public void verifyAreaBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		setEditAreaPage(getDataPage().createEditAreaPage());
		getEditAreaPage().verifyAreaBeganDateFromTrustedDB(country, area, "BeganDate", source);

	}

	@Then("the user verifies whether all the months in the drop down option for area are in MMM format & are sorted in the chronological order")
	public void verifyBeganDateMonthChronologicalOrder() {
		getEditAreaPage().verifyMonthInChronologicalOrder();
	}


	@Then("the user should see the error $beganDateErrorMsg for area began date")
	public void verifyErrorMessageBeganDate(@Named("beganDateErrorMsg") String beganDateErrorMsg) {
		getEditAreaPage().verifyErrorMessageBeganDate(beganDateErrorMsg);
	}

	@When("the user enters <day2> <month2> <year2> Began Date in the edit basic info area page")
	public void enterBeganDates(@Named("day2") String day2, @Named("month2") String month2, @Named("year2") String year2) {
		enterDayInBeganDate(day2);
		enterMonthInBeganDate(month2);
		enterYearInBeganDate(year2);
	}

	@Then("the user should see the entered <day> <month> <year> in area page")
	public void verifyDayMonthYearInAreaPage(@Named("day") String day, @Named("month") String month,
			@Named("year") String year) {
		getEditAreaPage().verifyDayMonthYearInAreaPage(day, month, year);
	}

	@Then("the user should see the area began date <day> <month> <year> value in $source document")
	public void verifyAreaBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("day") String day,
			@Named("month") String month, @Named("year") String year) {
		getEditAreaPage().verifyAreaBeganDateFromZeusDB(country, area, "BeganDate", source, day, month, year);
	}

	@Then("the user should not see the <ConfirmationSummary> changes in confirmation modal for area")
	public void verifyNoChangeConfirmationMsg(@Named("ConfirmationSummary") String ConfirmationSummary) {
		getDataPage().verifyNoSummaryConfirmationModal(ConfirmationSummary);
	}

	@When("the user clicks on the Status drop-down in the basicinfo area page")
	public void clickOnCityStatusDropDown() {
		getEditAreaPage().clickOnAreaStatusDropDown();
	}

	@Then("the user should see the area status values from lookup AREA")
	public void verifyCityStatusList() {
		getEditAreaPage().verifyAreaStatusList();
	}

	@When("the user selects value as <status> from Status drop-down in the area basicinfo page")
	public void selectAreaStatusValue(@Named("status") String status) {
		getEditAreaPage().selectAreaStatusValue(status);
	}

	@Then("the user should see the successful update message at top of the area page")
	public void verifySuccessfulUpdatedMessage() {
		getEditAreaPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user should see the updated <status> in area web page")
	public void verifyStatusInAreaPage(@Named("status") String status) {
		getEditAreaPage().verifyStatusInAreaPage(status);
	}

	@Then("the user should see status value in area page as in $source document")
	public void verifyStatusValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("status") String status) {
		getEditAreaPage().verifyAreaStatusFromZeusDB(country, area, "status", source, status);
	}

	@When("the user starts typing the name of a status as $word in the Area Status drop-down")
	public void enterValueInStatusDropdown(String word) {
		getEditAreaPage().enterValueInStatusDropdown(word);

	}

	@Then("the user should see the selected status in the Area Status drop-down as $status")
	public void verifyAreaStatusInDropdown(String status) {
		getEditAreaPage().verifyAreaStatusInDropdown(status);
	}

	@When("the user enters the <area> in the type-ahead box")
	public void enterAreaInTypeAhead(@Named("area") String area) {
		getDataPage().enterAreaInTypeAhead(area);
	}

	@Then("the user should see the status value in area page is same as in $source document")
	public void verifyCityBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyAreaFromTrustedDB(country, area, "status", source);
	}

	@When("the user selects value as <status2> from Status drop-down in the area basicinfo page")
	public void selectAreaStatusValue2(@Named("status2") String status) {
		getEditAreaPage().selectAreaStatusValue(status);
	}
	
	@Then("the user should see the $nameType type is from PLACE_NAME_TYPE lookup")
	public void verifyAreaNameTypeFromLookup(@Named("nameType") String nameType) {
		getEditAreaPage().verifyAreaNameTypeFromLookup(nameType);
	}
	
	@Then("the user should see the $nameType value in area page is same as in $source document")
	public void verifyAreaNameValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("nameType") String nameType) {
		getEditAreaPage().verifyAreaNameFromTrustedDB(country, area, nameType, source);
	}
	
	@Then("the user should see the $nameType is not editable")
	public void verifyFixedNameNotEditable(@Named("nameType") String nameType) {
		getEditAreaPage().verifyFixedNameTypeNotEditable(nameType);
	}
	
	@Then("the user enters the name <value> in the $nameType field")
	public void enterValueInNameField(@Named("value") String nameValue, @Named("nameType") String nameType) {
		getEditAreaPage().enterValueInNameField(nameType, nameValue);
	}
	
	@Then("the user should see the $nameType <value> in $source document")
	public void verifyUpdatedAreaNameValueInDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("nameType") String nameType, @Named("value") String nameValue) {
		getEditAreaPage().verifyUpdatedAreaNameInDB(country, area, nameType, source, nameValue);
	}
	
	@Then("the user should be able see the <value> is updated in $nameType value field")
	public void verifyTextInNameValue(@Named("value") String nameValue, @Named("nameType") String nameType) {
		getEditAreaPage().verifyTextInNameValue(nameValue, nameType);
	}
	
	@When("the user clicks on the add names button in the area basic info page")
	public void clickOnAddNewNameButton() {
		getEditAreaPage().clickOnAddNewNameButton();
	}
	
	@Then("the user should see the area name types from lookup PLACE_NAME_TYPE")
	public void verifyNewRowAreaNameTypesList() {
		getEditAreaPage().verifyNewRowAreaNameTypesList();
	}
	
	@When("the user enters name type as <type> in the area basic info page")
	public void enterNameType(@Named("type") String newNameType) {
		getEditAreaPage().enterNameType(newNameType, 0);
	}
	
	@When("the user enters name value as <value> in the area basic info page")
	public void enterNameValue(@Named("value") String newNameValue) {
		getEditAreaPage().enterNameValue(newNameValue);
	}
	
	@Then("the user should see the area name type and value updated in the area basic info page")
	public void verityAreaNameTypeAndValue(@Named("type") String newNameType, 
										   @Named("value") String newNameValue) {
		getEditAreaPage().verifyNameTypeAndValueInViewMode(newNameType, newNameValue);
	}
	
	@Then("the user should see the area name type and value in the edit area basic info page")
	public void verityAreaNameTypeAndValueInEditMode(@Named("type") String newNameType, 
										   @Named("value") String newNameValue) {		
		getEditAreaPage().verifyNameValueInEditMode(newNameType, newNameValue);
	}
	
	@Then("the user should not see the <type> <value> in $source document")
	public void verifyAreaNameValueNotUpdatedInDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("type") String nameType, @Named("value") String nameValue) {
		getEditAreaPage().verifyAreaNameValueNotUpdatedInDB(country, area, nameType, source, nameValue);
	}
	
	@Then("the user should not see the area name type and value updated in the area basic info page")
	public void verityAreaNameTypeAndValueNotPresent(@Named("type") String newNameType, 
										   @Named("value") String newNameValue) {
		getEditAreaPage().verifyNameTypeNotPresent(newNameType, newNameValue);
	}
	
	@When("the user deletes the existing area names rows")
	public void deleteAllAreaNameRows() {
		getEditAreaPage().deleteAllAreaNameRows();
	}
	
	@Then("the user should see the error message $errorMessage for the required name type field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaNameType(@Named("errorMessage") String errorMessage) {
		getEditAreaPage().verifyErrorMessageRequiredForAreaNameType(errorMessage);
	}
	
	@Then("the user should see the error message $errorMessage for the required name value field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaNameValue(@Named("errorMessage") String errorMessage) {
		getEditAreaPage().verifyErrorMessageForRequiredAreaNameValue(errorMessage);
	}
	
	@When("the user clicks on the delete name row button in the area basic info page")
	public void clickOnDeleteNameRowButton() {
		getEditAreaPage().clickOnDeleteNameRowButton();
	}
	
	@Then("the user should not see delete row button against <type>")
	public void checkDeleteRowButtonNotExist(@Named("type") String nameType) {
		getEditAreaPage().checkDeleteRowButtonNotExist(nameType);
	}
	
	@When("the user enters second name type as <type> in the area basic info page")
	public void enterSecondNameType(@Named("type") String newNameType) {
		getEditAreaPage().enterNameType(newNameType, 1);
	}
	
	@When("the user enters second name value as <value2> in the area basic info page")
	public void enterSecondNameValue(@Named("value2") String newNameValue) {
		getEditAreaPage().enterSecondNameValue(newNameValue);
	}
	
	@Then("the user should see the $nameType <value> and <value2> in $source document")
	public void verifyUpdatedMultipleAreaNameValuesInDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("nameType") String nameType, @Named("value") String nameValue, @Named("value2") String nameValue2) {
		getEditAreaPage().verifyUpdatedMultipleAreaNamesInDB(country, area, nameType, source, nameValue, nameValue2);
	}
	
	@Then("the user should see the second area name type and value updated in the area basic info page")
	public void veritySecondAreaNameTypeAndValue(@Named("type") String newNameType, 
			@Named("value2") String newNameValue) {
		getEditAreaPage().verifyNameTypeAndValueInViewMode(newNameType, newNameValue);
	}
	
	@Then("the user should not see the second area name type and value updated in the area basic info page")
	public void veritySecondAreaNameTypeAndValueNotPresent(@Named("type") String newNameType, 
			@Named("value2") String newNameValue) {
		getEditAreaPage().verifyDuplicateNameTypeNotPresent(newNameType, newNameValue);
	}

	@When("the user enters the <addInfoText> in the area add info text area")
	public void enterTextAreaAddInfo(@Named("addInfoText") String addInfoText) {
		getEditAreaPage().enterTextAreaAddInfo(addInfoText);
	}
	
	@Then("the user should be able to verify the values are entered in the area add info field")
	public void verifyAreaTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditAreaPage().verifyAreaTextInAddInfo(addInfoText);
	}
	
	@When("the user enters values which is beyond 500 unicode characters in the area add info field")
	public void enterInvalidCharactersInAreaAddInfo() {
		getEditAreaPage().enterInvalidCharactersInAreaAddInfo();
	}
	
	@Then("the user should be able to view that only 500 unicode characters are saved in area add info")
	public void viewValidCharacterLength() {
		getEditAreaPage().viewValidCharacterLength();
	}
	
	@Then("the user should be able to verify the maximum values are entered in the area add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditAreaPage().verifyMaximumChracterEnteredInAddInfo();
	}
	
	@Then("the user should see the area addInfoText value same as in $source document")
	public void verifyAreaAddInfoValueFromDB(@Named("country") String country, @Named("area") String area, @Named("source") String source) {
		getEditAreaPage().verifyAreaAddInfoValueFromTrusted(country, area, "AdditionalInfo", source);
	}
	
	@Then("the user should see the area addinfo value $addInfoText as in $source document")
	public void verifyAreaAddInfoFromDB(@Named("country") String country, @Named("area") String area, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditAreaPage().verifyAreaAddInfoValueFromZeus(country, area, "AdditionalInfo", source,addInfoText);
	}
	
	@When("the user enters the <addInfoDiffText> in the area add info text area")
	public void enterTextAreaAddInfo2(@Named("addInfoDiffText") String addInfoDiffText) {
		getEditAreaPage().enterTextAreaAddInfo(addInfoDiffText);
	}
	
	@When("the user clicks on the add new identifier button in the basic info area page")
	public void clickOnAreaAddNewIdentifierButton() {
		getEditAreaPage().clickOnAreaAddNewIdentifierButton();
	}
	
	@Then("the user should see the area identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO")
	public void verifyAreaIdentifierTypesList() {
		getEditAreaPage().verifyAreaIdentifierTypesList();
	}
	
	@Then("the user should see the area identifier status from lookup STATUS")
	public void verifyAreaIdentifierStatusList() {
		getEditAreaPage().verifyAreaIdentifierStatusList();
	}
	
	@When("the user deletes the existing area identifier rows")
	public void deleteAllAreaIdentifiers() {
		getEditAreaPage().deleteAllAreaIdentifierRows();
	}
	
	@Then("the user should see the identifier values same as in $source document")
	public void verifyAreaIdentifierValuesFromTrustedDB(@Named("country") String country, @Named("area") String area, @Named("source") String source) { 		 

		getEditAreaPage().verifyAreaIdentifierValuesFromTrustedDB(country, area, source);
	}
	
	@When("the user enters identifier type as <identifierType> in the basic info area page")
	public void enterAreaIdentifierType(@Named("identifierType") String identifierType) {
		getEditAreaPage().enterAreaIdentifierType(identifierType, 1);
	}
	
	@When("the user enters identifier value as <identifierValue> in the basic info area page")
	public void enterAreaIdentifierValue(@Named("identifierValue") String identifierValue) {
		getEditAreaPage().enterAreaIdentifierValue(identifierValue, 1);
	}
	
	@When("the user enters identifier status as <identifierStatus> in the basic info area page")
	public void enterAreaIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
		getEditAreaPage().enterAreaIdentifierStatus(identifierStatus, 1);
	}
	
	@When("the user enters identifier type as <identifierType2> in the basic info area page")
	public void enterAreaIdentifierType2(@Named("identifierType2") String identifierType) {
		getEditAreaPage().enterAreaIdentifierType(identifierType, 2);
	}
	
	@When("the user enters identifier value as <identifierValue2> in the basic info area page")
	public void enterAreaIdentifierValues2(@Named("identifierValue2") String identifierValue) {
		getEditAreaPage().enterAreaIdentifierValue(identifierValue, 2);
	}
	
	@When("the user enters identifier status as <identifierStatus2> in the basic info area page")
	public void enterAreaIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
		getEditAreaPage().enterAreaIdentifierStatus(identifierStatus, 2);
	}
	
	@Then("the user should see the area identifier values as in $source document")
	public void verifyAreaIdentifierValuesFromZeusDB(@Named("country") String country, @Named("area") String area,
	        @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2, @Named("source") String source) {
 
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();		
		identifierTypes.add(identifierType);		
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);		
		identifierTypes.add(identifierType2);
		identifierValues.add(identifierValue2);
		identifierStatusValues.add(identifierStatus2);
		
		getEditAreaPage().verifyAreaIdentifierValuesFromDB(country, area, identifierTypes, identifierValues,
				identifierStatusValues, source);
	}
	
	@When("the user clicks on the delete identifier row button in the basic info area page")
	public void clickOnDeleteNewAreaIdentifierRowButton() {
		getEditAreaPage().clickOnDeleteNewAreaIdentifierRowButton();
	}
	
	@Then("the user should see delete row confirmation modal in the area page")
	public void verifyDeleteConfirmationModal() {
		getEditAreaPage().verifyDeleteConfirmationModal();
	}
	
	@When("the user clicks on the Yes button to delete the row in basic info area page")
	public void pressEnterButtonInDeleteConfirmationModalForArea() {
		getEditAreaPage().pressEnterButtonInDeleteConfirmationModalForArea();
	}
	
	@Then("the user should not see the newly added identifier row in the basic info area page")
	@Alias("the user should not see the identifier row in the basic info area page")
	public void verifyNewlyAddedAreaIdentifierRowIsNotDisplayed() throws Exception {
		getEditAreaPage().verifyNewlyAddedAreaIdentifierRowIsNotDisplayed();
	}
	
	@When("the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info area page")
	public void enterIncorrectAreaIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
		getEditAreaPage().enterAreaIdentifierValue(incorrectIdentifierValue, 1);
	}
	
	@Then("the user should see maximum length of area identifier value is limited to $maxLength")
	public void verifyMaxLengthInAreaIdentifierValue(@Named("maxLength") String maxLength) {
		getEditAreaPage().verifyMaxLengthInAreaIdentifierValue(maxLength);
	}
	
	@Then("the user should see the error message $errMsg for identifier value field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaIdentifierValue(@Named("errMsg") String errMsg) {
		getEditAreaPage().verifyErrorMessageForRequiredAreaIdentifierValue(errMsg);
	}
	
	@Then("the user should see the error message $errMsg for identifier status field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaIdentifierStatus(@Named("errMsg") String errMsg) {
		getEditAreaPage().verifyErrorMessageForRequiredAreaIdentifierStatus(errMsg);
	}
		
	@Then("the user verifies that the row values for area identifier entered exists in $source document")
	@Alias("the user verifies that no values are entered in $source document")
	public void verifyAreaIdentifierRowValuesFromZeusDB(@Named("country") String country, @Named("area") String area,
	        @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus, @Named("source") String source) {
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);		
		identifierValues.add(identifierValue);		
		identifierStatusValues.add(identifierStatus);
		
		getEditAreaPage().verifyAreaIdentifierValuesFromDB(country, area, identifierTypes, identifierValues,
				identifierStatusValues, source);
	}	
	
	@When("the user clicks on the No button to cancel the deletion of row in basic info area page")
	public void pressNoButtonInDeleteConfirmationModalForArea() {
		getEditAreaPage().pressNoButtonInDeleteConfirmationModalForArea();
	}
	
	@Then("the user should see the newly added identifier row in the basic info area page")
	public void verifyNewlyAddedAreaIdentifierRowIsDisplayed() throws Exception {
		getEditAreaPage().verifyNewlyAddedAreaIdentifierRowIsDisplayed();
	}
	
	@Then("the user verifies that the deleted row for area identifier does not exist in $source document")
	public void verifyAreaIdentifierRowNotPresentInZeusDB(@Named("country") String country, @Named("area") String area, @Named("source") String source) {
		getEditAreaPage().verifyIdentifierRowNotPresentInZeusDB(country, area, source);
	}
	
	@Then("the user should see the error message $errMsg for identifier type field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaIdentifierType(@Named("errMsg") String errMsg) {
		getEditAreaPage().verifyErrorMessageForRequiredAreaIdentifierType(errMsg);
	}
	
	@Then("the user verifies that the area identifiers parameters are entered in the basic info area page")
	public void verifyAreaIdentifierParametersInUI( @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {
		
		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };
		
		getEditAreaPage().verifyAreaIdentifierParametersInUI(identifierTypes, identifierValues, identifierStatusValues);
	}
	
	@Then("the user verifies that previously selected <identifierType> is not present in the new identifier row")
	public void verifySelectedIdentifierTypeNotInNewRow(@Named("identifierType") String identifierType) {
		getEditAreaPage().verifySelectedIdentifierTypeNotInNewRow(identifierType, 2);
	}
	
	@Then("the user verifies that the newly added identifier row values exists in the basic info area page")
	public void verifyNewlyAddedAreaIdentifierRowExists() {
		getEditAreaPage().verifyNewlyAddedAreaIdentifierRowExists();
	}

	@Then("the user should see delete row confirmation modal in the area basic page")
	public void verifyDeleteConfirmationModals() {
		getEditAreaPage().verifyDeleteConfirmationModal();
	}
	
	@Then("the user should see the timezone values from TIME_ZONE lookup")
	public void verifyTimeZoneDropdownListMatchesWithLookup() throws InterruptedException {
		getEditAreaPage().verifyTimeZoneDropdownListMatchesWithLookup();
	}

	@Then("the user should see the timezone values same as in $source document")
	public void userVerifyTimeZoneDropDownDefaultValueFromTrusted(@Named("country") String country,
			@Named("area") String area, @Named("source") String source) {
		getEditAreaPage().verifyTimeZoneDefaultValueFromTrusted(country, area, "summary", source);
	}	 

	@Then("the user clicks on add new timezone button")
	public void userClickOnAddNewTimeZoneButton() {
		getEditAreaPage().clickOnAddNewTimeZoneButton();
	}

	@Then("user verifies whether default value for timezone is blank")
	public void userVerifiesTimeZoneDefaultValueIsBlank() {
		getEditAreaPage().verifiesTimeZoneDefaultValueIsBlank();
	}

	@Then("user verifies whether timezone dropdown displays time zone's except selected timezone <timeZone>")
	public void verifyTimeZoneDropDownListDisplaysUnSelectedTimeZones(@Named("timeZone") String timeZone) {
		getEditAreaPage().verifyTimeZoneDropDownIsNotHavingSelectedTimeZone(timeZone);
	}

	@Then("user selects the timezone <timeZone> in the timezone dropdown of area basic page")
	public void userSelectsTimeZoneDropDownValue(@Named("timeZone") String timeZone) throws InterruptedException {
		getEditAreaPage().selectsTimeZoneDropDownValue(timeZone, 1);
	}

	@Then("user selects the timezone <timeZone1> in the timezone dropdown of area basic page")
	public void userSelectsTimeZoneDropDownValues(@Named("timeZone1") String timeZone1) throws InterruptedException {
		getEditAreaPage().selectsTimeZoneDropDownValue(timeZone1, 2);
	}

	@Then("user changes the <timeZone1> in the timezone dropdown of area basic page")
	public void userSelectTimeZoneValue(@Named("timeZone1") String timeZone1) throws InterruptedException {
		getEditAreaPage().selectsTimeZoneDropDownValue(timeZone1, 1);
	}

	@Then("the user enters the summary as <summary>")
	public void userEntersSummaryValue(@Named("summary") String summary) throws InterruptedException {
		getEditAreaPage().entersSummaryValue(summary);
	}

	@Then("the user enters the summary as <summary1>")
	public void userEnterSummaryValue(@Named("summary1") String summary1) throws InterruptedException {
		getEditAreaPage().entersSummaryValue(summary1);
	}

	@When("the user clicks on the delete timezone row button in the basic info area page")
	public void clickOnDeleteAreaTimeZoneRowButton() {
		getEditAreaPage().clickOnDeleteAreaTimeZoneRowButton();
	}

	@Then("the user should see the newly added timezone row in the basic info area page")
	public void verifyNewlyAddedAreaTimeZoneRowIsDisplayed(@Named("timeZone1") String timeZone1) throws Exception {
		getEditAreaPage().verifyNewlyAddedAreaTimeZoneRowIsDisplayed(timeZone1);
	}

	@Then("the user verifies that the newly added timezone row values exists in the basic info area page")
	public void verifyNewlyAddedAreaTimeZoneRowExists() {
		getEditAreaPage().verifyNewlyAddedAreaTimeZoneRowExists();
	}

	@Then("the user should not see the newly added timezone row in the basic info area page")
	@Alias("the user should not see the timezone row in the basic info area page")
	public void verifyNewlyAddedAreaTimeZoneRowIsNotDisplayed() throws Exception {
		getEditAreaPage().verifyNewlyAddedAreaTimeZoneRowIsNotDisplayed();
	}
	 
	@Then("user verifies newly added timezone summary is updated in $source document")
	public void verifyAreaSummaryValuesFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("summary") String summary) {
		getEditAreaPage().verifyAreaSummaryValuesFromZeusDB(country, area, "summary", source, summary);
	}
	
	@Then("the user verifies the $source document whether the area is updated with the newly updated summary")
	public void verifyAreaSummaryValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("summary1") String summary1) {
		getEditAreaPage().verifyAreaSummaryValuesFromZeusDB(country, area, "summary", source, summary1);
	}
 
	@Then("the user verifies the area page is updated with the new timezone summary")
	public void verifyAreaSummary1ValueInUI(@Named("summary1") String summary1) throws InterruptedException {
		getEditAreaPage().verifyAreaSummaryValueInUI(summary1);
	}

	@Then("the user verifies the Area page is updated with the timezone summary")
	public void verifyAreaSummaryValueInUI(@Named("summary") String summary) throws InterruptedException {
		getEditAreaPage().verifyAreaSummaryValueInUI(summary);
	}

	@Then("the user verifies whether the Area is updated with the newly updated timezone")
	public void verifyAreaTimeZoneValueInUI(@Named("timeZone1") String timeZone1) throws InterruptedException {
		getEditAreaPage().verifyAreaTimeZoneValueInUI(timeZone1);
	}

	@Then("the user verifies area page is not updated with Null time zone")
	public void verifyAreaTimeZoneValueNotUpdatedInUI() throws InterruptedException {
		getEditAreaPage().verifyAreaTimeZoneValueNotUpdatedInUI();
	}

	@Then("the user verifies summary max length attribute is $maxLength")
	public void verifyAreaTimeZoneSummaryMaxLenghtAttribute(@Named("maxLength") String maxLength) {
		getEditAreaPage().verifyAreaTimeZoneSummaryMaxLenghtAttribute(maxLength);
	}

	@Then("the user verifies that the area timezone values are updated in the basic info area page")
	public void verifyAreaTimeZoneInUI(@Named("timeZone") String timeZone, @Named("timeZone1") String timeZone1) {
		String[] timeZoneValues = { timeZone, timeZone1 };
		getEditAreaPage().verifyAreaTimeZoneValuesInUI(timeZoneValues);
	}

	@Then("the user should see the area timezone values as in $source document")
	public void verifyAreaTimeZoneValuesFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("timeZone") String timeZone, @Named("timeZone1") String timeZone1, @Named("source") String source) {
		List<String> timeZoneValues = new ArrayList<>();
		timeZoneValues.add(timeZone);
		timeZoneValues.add(timeZone1);
		getEditAreaPage().verifyAreaTimeZoneValuesFromDB(country, area, timeZoneValues, source);
	}

	@Then("the user should see the area timezone value as in $source document")
	public void verifyAreaTimeZoneValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("timeZone1") String timeZone1, @Named("source") String source) {
		List<String> timeZoneValue = new ArrayList<>();
		timeZoneValue.add(timeZone1);
		getEditAreaPage().verifyAreaTimeZoneValuesFromDB(country, area, timeZoneValue, source);
	}

	@When("the user deletes the existing area timezone rows")
	public void deleteAllAreaTimeZoneRows() {
		getEditAreaPage().deleteAllAreaTimeZoneRows();
	}

	@Then("the user verifies timezone is not updated in $source document")
	@Alias("the user verifies the deleted timezone does not exist in $source document")
	public void verifyAreasTimeZoneValueNotUpdatedInZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyAreaTimeZoneValueIsNullFromDB(country, area, source);
	}

	@When("the user enters <interestRate> value in area page")
	public void enterAreaInterestRate(@Named("interestRate") String interestRate) {
		getEditAreaPage().enterAreaInterestRate(interestRate);
	}

	@When("the user enters <interestRateOld> value in area page")
	public void enterAreaInterestRateNew(@Named("interestRateOld") String interestRateNew) {
		getEditAreaPage().enterAreaInterestRate(interestRateNew);
	}

	@Then("the user should see the entered <interestRate> in area page")
	public void verifyAreaInterestRate(@Named("interestRate") String interestRate) {
		getEditAreaPage().verifyAreaInterestRate(interestRate);
	}

	@Then("the user should see the entered <interestRateOld> in area page")
	public void verifyAreaInterestRateOld(@Named("interestRateOld") String interestRate) {
		getEditAreaPage().verifyAreaInterestRate(interestRate);
	}

	@Then("the user should see the entered <interestRate> in $source document")
	public void enterAreaInterestRateNew(@Named("country") String country, @Named("area") String area,
			@Named("interestRate") String interestRate, @Named("source") String source) {
		getEditAreaPage().verifyAreaInterestRateZeus(country, area, "areaInterestRate", source, interestRate);
	}

	@When("the user enters values which is beyond 256 unicode characters in the area Interest Rate field")
	public void enterInvalidCharactersInAreaInterestRate() {
		getEditAreaPage().enterInvalidCharactersInAreaInterestRate();
	}

	@Then("the user should be able to view that only 256 unicode characters are saved in area Interest Rate field")
	public void viewValidCharacterLengthInterestRate() {
		getEditAreaPage().viewValidCharacterLengthInterestRate();
	}

	@Then("the user should be able to verify the maximum values are entered in the area Interest Rate field")
	public void verifyMaximumTextInInterestRate() {
		getEditAreaPage().verifyMaximumTextInInterestRate();
	}

	@Then("the user should see the Interest Rate value in area page is same as per $source document")
	public void verifyAreaInterestRateFromTrustedDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyAreaInterestRateFromTrustedDB(country, area, "areaInterestRate", source);
	}
	
	@Then("the user should see maximum length of interest rate value is limited to $maxLength")
	public void verifyMaxLengthInterestRate(@Named("maxLength") String maxLength) {
		getEditAreaPage().verifyMaxLengthInterestRate(maxLength);
	}
	
	@When("the user clicks on <useInAddressOld> option for Area Use in Address")
	public void selectUseInAddressOld(@Named("useInAddressOld") String useInAddressOld) {
		getEditAreaPage().selectUseInAddress(useInAddressOld);
	}
	
	@When("the user clicks on <useInAddress> option for Area Use in Address")
	public void selectUseInAddress(@Named("useInAddress") String useInAddress) {
		getEditAreaPage().selectUseInAddress(useInAddress);
	}

	@Then("the user should see the updated <useInAddress> in area web page")
	public void verifyUseInAddressInAreaPage(@Named("useInAddress") String useInAddress) {
		getEditAreaPage().verifyUseInAddressInAreaPage(useInAddress);
	}

	@Then("the user should see updated Use in address value in $source document")
	public void verifyUseInAddressAreaFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyUseInAddressAreaFromZeusDB(country, area, "areaUseInAddress", source);
	}

	@Then("the user should see Use in address value is retrieved from $source document")
	public void verifyUseInAddressAreaFromTrustedDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyUseInAddressAreaFromTrustedDB(country, area, "areaUseInAddress", source);
	}
}