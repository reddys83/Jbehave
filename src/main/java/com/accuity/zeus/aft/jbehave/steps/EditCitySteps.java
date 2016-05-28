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

	@When("the user enters the <addInfoText> in the add info text area")
	public void enterTextCityAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().enterTextCityAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the values are entered in the add info field")
	public void verifyTextInAddInfo() {
		getEditCityPage().verifyTextInAddInfo();
	}

	@When("the user enters the <addDifferentInfoText> in the add info text area")
	public void enterDifferentTextInCityAddInfo(@Named("addDifferentInfoText") String addDifferentInfoText) {
		getEditCityPage().enterDifferentTextInCityAddInfo(addDifferentInfoText);
	}

	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@When("the user enters values which is beyond 500 unicode characters in the add info field")
	public void enterInvalidCharactersInCityAddInfo() {
		getEditCityPage().enterInvalidCharactersInCityAddInfo();
	}

	@Then("the user should be able to view the error message 'Enter up to 500 valid characters'")
	public void verifyErrorMessageInCityAddInfo() {
		getEditCityPage().verifyErrorMessageInCityAddInfo();
	}
	
	@Then("the user should see the add info value as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddInfoValueFromTrusted(country, area, city, "status", source);
	}
}
