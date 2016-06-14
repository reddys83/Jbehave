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

	@Then("the user should see no summary changes in the city save confirmation modal")
	public void verifyNoSummaryInConfirmationModal(@Named("Summary") String summaryText) {
		getEditCityPage().verifyNoSummaryConfirmationModal(summaryText);
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);

	}
	
	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}
	
	
	@Then("the user should see city end date value same as in $source document")
	public void verifyCityEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifyCityEndDateValueFromTrusted(country, area, city, "EndDate", source);
	}
	
	@When("the user enters the day <beganDay> in the text box for Began Date")
	public void enterDayInBeganDate(@Named("beganDay") String day) {
		getEditCityPage().enterDayInBeganDate(day);
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
