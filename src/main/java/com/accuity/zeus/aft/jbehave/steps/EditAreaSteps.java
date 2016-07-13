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
public class EditAreaSteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user clicks on the Status drop-down in the basicinfo area page")
	public void clickOnCityStatusDropDown() {
		getEditAreaPage().clickOnAreaStatusDropDown();
	}

	@Then("the user should see the area status values from lookup AREA")
	public void verifyCityStatusList() {
		getEditAreaPage().verifyAreaStatusList();
	}

	@When("the user clicks on the area update link")
	public void clickOnUpdate() {
		getEditAreaPage().clickOnUpdate();
	}

	@When("the user gets the document with $xqueryName with the <area> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("Area") String param) {
		getDataPage().getDocument(xqueryName, param);

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
	public void verifyStatusValueFromZeusDB(@Named("country") String country, @Named("Area") String area,
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

	@When("the user enters the <Area> in the type-ahead box")
	public void enterAreaInTypeAhead(@Named("Area") String area) {
		getDataPage().enterAreaInTypeAhead(area);
	}

	@Then("the user should see the status value in area page is same as in $source document")
	public void verifyCityBeganDateValueFromDB(@Named("country") String country, @Named("Area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyAreaFromTrustedDB(country, area, "status", source);
	}

	@When("the user selects value as <status2> from Status drop-down in the area basicinfo page")
	public void selectAreaStatusValue2(@Named("status2") String status) {
		getEditAreaPage().selectAreaStatusValue(status);
	}
}
