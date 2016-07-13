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
	
	@Then("the user should see the error $beganDateErrorMsg for area began date")
	public void verifyErrorMessageBeganDate(@Named("beganDateErrorMsg") String beganDateErrorMsg) {
		getEditAreaPage().verifyErrorMessageBeganDate(beganDateErrorMsg);
	}
	
	@When("the user enters <day2> <month2> <year2> Began Date in the edit basic info area page")
	public void enterBeganDate(@Named("day2") String day2, @Named("month2") String month2, @Named("year2") String year2) {
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
}
