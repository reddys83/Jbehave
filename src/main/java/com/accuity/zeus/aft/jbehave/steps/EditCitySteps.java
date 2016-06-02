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

	@When("the user clicks on the city update link")
	public void clickOnUpdateCurrencyLink() {
		getDataPage().clickOnUpdateCurrencyLink();
		if (editCityPage == null)
			setEditCityPage(getDataPage().createEditCityPage());

	}

	@When("the user clicks on the Status drop-down in the basicinfo city page")
	public void clickOnCityStatusDropDown() {
		getEditCityPage().clickOnCityStatusDropDown();
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
}