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
	public void enterTextInCityAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().enterTextCityAddInfo(addInfoText);
	}

	@Then("the user reverts the changes to the add info text area")
	public void clearAddInfoTextArea() {
		getEditCityPage().clearAddInfoTextArea();
	}

	@Then("the user should be able to verify the values are entered in the add info field")
	public void verifyTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyTextInAddInfo(addInfoText);
	}
	
	@Then("the user should be able to verify the maximum values are entered in the add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditCityPage().verifyMaximumChracterEnteredInAddInfo();
	}

	@Then("the user should verify that same <addInfoText> has been entered in the text area")
	public void verifySameTextInTextArea(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifySameTextInTextArea(addInfoText);
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

	@Then("the user should see the addInfoText value same as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddInfoValueFromTrusted(country, area, city, "additionalinfo", source);
	}

	@Then("the user should see the $addInfoText value as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "additionalinfo", source, addInfoText);
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);

	}

	@When("the user gets the value already present in the text box")
	public void getTextInTextArea() {
		getEditCityPage().getTextInTextArea();
	}

	@When("the user clicks on the save button in city page")
	public void clickOnSaveButton() {
		getEditCityPage().clickOnSaveButton();
	}

	@Then("the user verifies whether the new value <addInfoText> is different from previous value")
	public void newValueCheck(@Named("addInfoText") String addInfoText) {
		getEditCityPage().newValueCheck(addInfoText);
	}

	@Then("the user should see no summary changes in the city save confirmation modal")
	public void verifyNoSummaryInConfirmationModal(@Named("Summary") String summaryText) {
		getEditCityPage().verifyNoSummaryConfirmationModal(summaryText);
	}

	@Then("the user should be able to view that only 500 unicode characters are saved")
	public void viewValidCharacterLength() {
		getEditCityPage().viewValidCharacterLength();
	}

}
