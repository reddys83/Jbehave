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

	@When("the user enters the <value> in the population field")
	public void entervalueInPopulationField(@Named("value") String value) {
		getEditCityPage().entervalueInPopulationField(value);
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

	@Then("the user should see no summary changes in the city save confirmation modal")
	public void verifyNoSummaryInConfirmationModal(@Named("Summary") String summaryText) {
		getEditCityPage().verifyNoSummaryConfirmationModal(summaryText);

	}	
	
	@Then("the user should see the city $status value as in $source document")
	public void verifyCityStatusValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("status") String status) {
		getEditCityPage().verifyCityInfoFromZeusDB(country, area, city, "status", source, status);
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

	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}	

	@When("the user clicks on the confirm button in city page")
	public void clickOnConfirmButtonCity() throws Exception {
		getEditCityPage().clickOnConfirmButtonCity();
	}	
	
}
