package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditOfficeSteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    @When("the user updates office Opened <day> <month> <year>")
    public void updateOfficeOpenedDate(@Named("day") String day,@Named("month") String month,@Named("year") String year)
    {getEditOfficePage().updateOfficeOpenedDate(day,month,year);}

    @When("the user gets the document with $xqueryName with the <officeFid> from the database")
    public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("officeFid") String officeFid) {
        getDataPage().getDocument(xqueryName, "fid",officeFid);

    }

    @Then("the user should see the error $openedDateErrorMsg for opened date")
    public void verifyOpenedDateErrorMessage(@Named("openedDateErrorMsg") String openedDateErrorMsg) {
        getEditOfficePage().verifyOpenedDateErrorMessage(openedDateErrorMsg);
    }
    @When("the user clicks on the office update link")
    public void clickOnUpdateCurrencyLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editOfficePage==null){
            editOfficePage = getOfficesPage().createEditOfficePage();
        }}

    @Then("the user verifies office opened date from $source document <officeFid> <day> <month> <year>")
    public void verifyUpdatedOfficeOpenedDate(@Named("officeFid") String officeFid,@Named("day") String day,@Named("month") String month,@Named("year") String year,@Named("source") String source){getEditOfficePage().verifyUpdatedOfficeOpenedDate(officeFid,day,month,year,source);}


    @When("the user selects lead location value <leadLocationflag> in the basicinfo office page")
    public void selectOfficeLeadLocationFlag(@Named("leadLocationflag") String leadLocationflag){
        getEditOfficePage().selectOfficeLeadLocationFlag(leadLocationflag);
    }

    @Then("the user should see leadLocation value as <leadLocationflag> for fid <officeFid> in $source document and in zeus UI")
    public void getDocumentLeadLocation(@Named("leadLocationflag") String leadLocationflag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyLeadLocationValuefromZeusDocumentAndUI(leadLocationflag,officeFid,source);
    }


    @When("the user selects lead location value other than default value in the basicinfo office page")
    public void changeOfficeLeadLocationFlag() {
        getEditOfficePage().changeAlternateRadioButtonValue("office_leadlocation_radio_options_xpath");
    }

    @When("the user selects foreign office value <foreignOfficeflag> in the basicinfo office page")
    public void selectForeignOfficeFlag(@Named("foreignOfficeflag") String foreignOfficeflag){
        getEditOfficePage().selectForeignOfficeFlag(foreignOfficeflag);
    }

    @Then("the user should see foreignOffice value as <foreignOfficeflag> for fid <officeFid> in $source document and in zeus UI")
    public void verifyForeignOfficeValuefromZeusDocumentandUI(@Named("foreignOfficeflag") String foreignOfficeflag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyForeignOfficeValuefromZeusDocumentandUI(foreignOfficeflag,officeFid,source);
    }


    @When("the user selects foreign office value other than default value in the basicinfo office page")
    public void changeForeignOfficeFlag() {
        getEditOfficePage().changeAlternateRadioButtonValue("office_foreignoffice_radio_options_xpath");
    }

    @Then("the user should return to edit office page mode")
    public void verifyOfficeEditPageMode(){
        getEditOfficePage().verifyOfficeEditPageMode();
    }
    @When("the user enters the <additionalInfoText> in the office additional info text area")
    public void enterOfficeAdditionalInfo(@Named("additionalInfoText") String additionalInfoText)
    {
        getEditOfficePage().enterOfficeAdditionalInfo(additionalInfoText);
    }

    @Then("the user should see office additional info text value as <additionalInfoText> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(@Named("additionalInfoText") String additionalInfoText,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(additionalInfoText,officeFid,source);
    }

    @Then("the user should see the office additional info text area field length as 10000")
    public void verifyOfficeAdditionalInfoTextAreaLength(@Named("officeFid") String officeFid) {
        getEditOfficePage().verifyOfficeAdditionalInfoTextAreaLength(officeFid);
    }


    @When("the user enters 10000 characters in the office additional info text area")
    public void enter10000CharactersInOfficeAdditionalInfo(@Named("officeFid") String officeFid) {
        getEditOfficePage().enter10000CharactersInOfficeAdditionalInfo(officeFid);
    }


    @Then("the user should see the office additional info text value with 10000 characters for fid <officeFid> in $source document")
    public void verifyAdditionalInfoValueWithMaxLengthFromDB(@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyAdditionalInfoValueWithMaxLengthFromZeus("additionalInfo",officeFid,source);
    }
    
    @Then("the user should see the office's identifier values same as in $source document")
	public void verifyOfficeIdentifierValuesFromTrustedDB(@Named("source") String source, @Named("officeFid") String officeFid) { 		 

    	getEditOfficePage().verifyOfficeIdentifierValuesFromTrustedDB(source, officeFid);
	}
    
    @When("the user clicks on the add new identifier button in the office identifier page")
    public void clickOnOfficeAddNewIdentifierButton() {
    	getEditOfficePage().clickOnOfficeAddNewIdentifierButton();
	} 
    
    @Then("the user should see the office identifier types from lookup THIRD_PARTY_IDENTIFIER_OFFICE")
	public void verifyOfficeIdentifierTypesList() {
    	getEditOfficePage().verifyOfficeIdentifierTypesList();
	}
    
    @Then("the user should see the office identifier status from lookup STATUS")
	public void verifyOfficeIdentifierStatusList() {
    	getEditOfficePage().verifyOfficeIdentifierStatusList();
	}
    
    @When("the user deletes the existing office identifier rows")
    public void deleteAllOfficeIdentifiers() {
    	getEditOfficePage().deleteAllOfficeIdentifierRows();
	} 
    
    @When("the user enters identifier type as <identifierType> in the office identifier page")
	public void enterOfficeIdentifierType(@Named("identifierType") String identifierType) {
    	getEditOfficePage().enterOfficeIdentifierType(identifierType, 1);
	}
    
    @When("the user enters identifier value as <identifierValue> in the office identifier page")
	public void enterOfficeIdentifierValue(@Named("identifierValue") String identifierValue) {
    	getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 1);
	}
    
    @When("the user enters identifier status as <identifierStatus> in the office identifier page")
	public void enterOfficeIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
    	getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 1);
	}
    
    @Then("the user verifies that previously selected <identifierType> is not present in the new office identifier row")
	public void verifySelectedOfficeIdentifierTypeNotInNewRow(@Named("identifierType") String identifierType) {
    	getEditOfficePage().verifySelectedOfficeIdentifierTypeNotInNewRow(identifierType, 2);
	}
    
    @When("the user enters identifier type as <identifierType2> in the office identifier page")
	public void enterOfficeIdentifierType2(@Named("identifierType2") String identifierType) {
    	getEditOfficePage().enterOfficeIdentifierType(identifierType, 2);
	}
    
    @When("the user enters identifier value as <identifierValue2> in the office identifier page")
	public void enterAreaIdentifierValues2(@Named("identifierValue2") String identifierValue) {
    	getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 2);
	}
    
    @When("the user enters identifier status as <identifierStatus2> in the office identifier page")
	public void enterAreaIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
    	getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 2);
	}
    
    @Then("the user should see the successful update message at top of the office page")
	public void verifySuccessfulUpdatedMessage() {
    	getEditOfficePage().verifySuccessfulUpdatedMessage();
	}
    
    @Then("the user verifies that the identifiers parameters are entered in the office identifiers page")
	public void verifyOfficeIdentifierParametersInUI( @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {
		
		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };
		
		getEditOfficePage().verifyOfficeIdentifierParametersInUI(identifierTypes, identifierValues, identifierStatusValues);
	}
    
    @Then("the user should see the office identifier values as in $source document")
	public void verifyOfficeIdentifierValuesFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid,
	        @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {
 
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();		
		identifierTypes.add(identifierType);		
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);		
		identifierTypes.add(identifierType2);
		identifierValues.add(identifierValue2);
		identifierStatusValues.add(identifierStatus2);
		
		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}
    
    @Then("the user should not see the <ConfirmationSummary> changes in confirmation modal in the office identifiers page")
	public void verifyNoChangeConfirmationMsg(@Named("ConfirmationSummary") String ConfirmationSummary) {
    	getEditOfficePage().verifyNoSummaryConfirmationModal(ConfirmationSummary);
	}
    
    @Then("the user should not see the newly added identifier row in the office identifiers page")
    @Alias("the user should not see the identifier row in the office identifiers page")
	public void verifyNewlyAddedAreaIdentifierRowIsNotDisplayed() throws Exception {
    	getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed();
	}
    
    @Then("the user verifies that no values are entered in $source document for office identifiers")
    @Alias("the user verifies that the row values for office identifier entered exists in $source document")
    public void verifyOfficeIdentifierRowValuesFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid,
	        @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus) {
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);		
		identifierValues.add(identifierValue);		
		identifierStatusValues.add(identifierStatus);
		
		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}	
    
    @Then("the user should see maximum length of office identifier value is limited to $maxLength")
	public void verifyMaxLengthInOfficeIdentifierValue(@Named("maxLength") String maxLength) {
    	getEditOfficePage().verifyMaxLengthInOfficeIdentifierValue(maxLength);
	}
    
    @Then("the user should see the error message $errMsg for identifier type field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierType(@Named("errMsg") String errMsg) {
    	getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierType(errMsg);
	}
    
    @Then("the user should see the error message $errMsg for identifier value field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierValue(@Named("errMsg") String errMsg) {
    	getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierValue(errMsg);
	}
    
    @Then("the user should see the error message $errMsg for identifier status field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierStatus(@Named("errMsg") String errMsg) {
    	getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierStatus(errMsg);
	}
    
    @Then("the user verifies that the deleted row for office identifier does not exist in $source document")
	public void verifyOfficeIdentifierRowNotPresentInZeusDB(@Named("source") String source, @Named("officeFid") String officeFid) {
    	getEditOfficePage().verifyIdentifierRowNotPresentInZeusDB(source, officeFid);
	}
    
    @When("the user clicks on the delete identifier row button in the office identifiers page")
	public void clickOnDeleteNewOfficeIdentifierRowButton() {
    	getEditOfficePage().clickOnDeleteNewOfficeIdentifierRowButton();
	}
    
    @Then("the user should see delete row confirmation modal in the office identifiers page")
	public void verifyDeleteConfirmationModal() {
    	getEditOfficePage().verifyOfficeIdentifierRowDeleteConfirmationModal();
	}
    
    @When("the user clicks on the No button to cancel the deletion of row in the office identifiers page")
	public void pressNoButtonInDeleteConfirmationModalForOfficeIdentifiers() {
    	getEditOfficePage().pressNoButtonInDeleteConfirmationModalForOfficeIdentifiers();
	}
    
    @Then("the user verifies that the newly added identifier row values exists in the office identifiers page")
	public void verifyNewlyAddedOfficeIdentifierRowExists() {
    	getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowExists();
	}
    
    @When("the user clicks on the Yes button to delete the row in the office identifiers page")
	public void pressEnterButtonInDeleteConfirmationModalForOfficeIdentifiers() {
    	getEditOfficePage().pressEnterButtonInDeleteConfirmationModalForOfficeIdentifiers();
	}
}



