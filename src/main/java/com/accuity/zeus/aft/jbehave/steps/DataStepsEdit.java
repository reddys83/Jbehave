package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataStepsEdit extends AbstractSteps {
	@Autowired
	com.accuity.zeus.aft.io.ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user clicks on the update link")
	public void clickOnUpdateCurrencyLink() {
		getDataPage().clickOnUpdateCurrencyLink();
	}

	@When("the user clicks on the save button")
	public void clickOnSaveButton() {
		getDataPage().clickOnSaveButton();
	}

	@Then("the user should see the save confirmation modal")
	public void verifySaveConfirmationModal() {
		getDataPage().verifySaveConfirmationModal();
	}

	@When("the user clicks on the confirm button")
	public void clickOnConfirmButton() {
		getDataPage().clickOnConfirmButton();
	}

	@Then("the user reverts the changes to the document")
	public void revertChangesToCurrency() {
		getDataPage().revertChangesToDocument();
	}

	@Then("the user should see the cancel update confirmation modal")
	public void verifyCountryCancelUpdateConfirmationModal() {
		getDataPage().verifyCancelUpdateConfirmationModal();
	}

	@When("the user clicks on the cancel no button")
	public void clickOnCancelNoButton() {
		getDataPage().clickOnCancelNoButton();
	}

	@When("the user clicks on the cancel yes button")
	public void clickOnCancelYesButton() {
		getDataPage().clickOnCancelYesButton();
	}

	@Then("the user should see the below summary changes in confirmation modal $Summary")
	public void verifySummaryConfirmationModal(ExamplesTable Summary) {
		getDataPage().verifySummaryConfirmationModal(Summary);
	}

	@When("the user clicks on the return button")
	public void clickOnReturnButton() {
		getDataPage().clickOnReturnButton();
	}

	@Then("the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved")
	public void verifyErrorMessageAtTopOfThePage() {
		getDataPage().verifyErrorMessageAtTopOfThePage();
	}

	@When("the user clicks on the no button in the delete row confirmation modal in the $pagename page")
	public void clickOnNoButtonInDeleteConfirmationModal() {
		getDataPage().clickOnNoButtonInDeleteConfirmationModal();
	}

	@When("the user clicks on the yes button in the delete row confirmation modal in the $pagename page")
	public void clickOnYesButtonInDeleteConfirmationModal() {
		getDataPage().clickOnYesButtonInDeleteConfirmationModal();
	}

	@Then("the user should see the error $startDateErrorMsg for chartered date")
	public void verifyStartDateErrorMessage(@Named("startDateErrorMsg") String startDateErrorMsg) {
		getEditLegalEntityPage().verifyErrorMessageCharteredDate(startDateErrorMsg);
	}

	@Then("the user should see the delete row confirmation modal in the $pagename page")
	public void verifyDeleteConfirmationModal() {
		getDataPage().verifyDeleteConfirmationModal();
	}

}
