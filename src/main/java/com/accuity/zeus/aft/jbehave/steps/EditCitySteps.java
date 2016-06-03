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

	@When("the user enters the <value> in the population field")
	public void entervalueInPopulationField(@Named("value") String value) {
		getEditCityPage().entervalueInPopulationField(value);
	}

	@Then("the user should be able to verify the values are entered in the population field")
	public void verifyValueInPopulation() {
		getEditCityPage().verifyTextInPopulation();
	}

	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@When("the user enters values which is beyond $limit unicode characters in the population field")
	public void enterCharactersBeyondThelimitInCityPopulation(int limit) {
		getEditCityPage().enterCharactersBeyondThelimitInCityPopulation(limit);
	}

	@When("the user enters values which is $limit unicode characters in the population field")
	public void enterCharactersInCityPopulation(int limit) {
		getEditCityPage().enterCharactersInCityPopulation(limit);
	}
	
	@Then("the user should be able to view the error message 'Enter up to 50 valid characters'")
	public void verifyErrorMessageInCityPopulation() {
		getEditCityPage().verifyErrorMessageInCityPopulation();
	}

	@Then("the user should see the population value same as in $source document")
	public void verifyCityPopulationValueFromTrusted(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityPopulationValueFromTrusted(country, area, city, "population", source);
	}

	@Then("the user should see the population $value as in $source document")
	public void verifyCityPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("value") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@Then("the user should see the population <previousValue> should be same in $source document")
	public void verifyCityExpectedPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("previousValue") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);
	}

	@When("the user clicks on the save button in city page")
	public void clickOnSaveButton() {
		getDataPage().clickOnSaveButton();
	}
	
	@Then("the user should see the new population <value> in City page")
	public void verifyPopulationValueCityPage(@Named("value") String value) {
		getEditCityPage().verifyPopulationValueCityPage(value);
	}

}
