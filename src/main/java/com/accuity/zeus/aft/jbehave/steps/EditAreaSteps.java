package com.accuity.zeus.aft.jbehave.steps;

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
	
	@Then("the user should see the area name type and value updated in in the area basic info page")
	public void verityCityNameTypeAndValue(@Named("type") String newNameType, 
										   @Named("value") String newNameValue) {
		getEditAreaPage().verifyNameType(newNameType, 0);
		getEditAreaPage().verifyNameValue(newNameType, newNameValue, 0);
	}
	
	@Then("the user should not see the <type> <value> in $source document")
	public void verifyAreaNameValueNotUpdatedInDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("type") String nameType, @Named("value") String nameValue) {
		getEditAreaPage().verifyAreaNameValueNotUpdatedInDB(country, area, nameType, source, nameValue);
	}
	
	@Then("the user should see not the area name type and value updated in the area basic info page")
	public void verityNoBlankCityNameTypeAndValue(@Named("type") String newNameType, 
										   @Named("value") String newNameValue) {
		getEditAreaPage().verifyNameTypeNotPresent(newNameType);
	}
	
	@Then("the user should see the error message for the required name type field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaNameType() {
		getEditAreaPage().verifyErrorMessageRequiredForAreaNameType();
	}
	
	@Then("the user should see the error message for the required name value field in the area basic info page")
	public void verifyErrorMessageForRequiredAreaNameValue() {
		getEditAreaPage().verifyErrorMessageForRequiredAreaNameValue();
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
	
	@Then("the user should see the second area name type and value updated in in the area basic info page")
	public void veritySecondCityNameTypeAndValue(@Named("type") String newNameType, 
										   @Named("value2") String newNameValue) {
		getEditAreaPage().verifyNameType(newNameType, 1);
		getEditAreaPage().verifyNameValue(newNameType, newNameValue, 1);
	}
}

