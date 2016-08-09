package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
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
    @When("the user enters the office prefix value as <prefix>")
    public void enterOfficePrefixValue(@Named("prefix") String prefix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_prefix_xpath",prefix);
    }
    @When("the user enters the office suffix value as <suffix>")
    public void enterOfficeSuffixValue(@Named("suffix") String suffix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_suffix_xpath",suffix);
    }
    @When("the user enters the office override value as <override>")
    public void enterOfficeOverrideValue(@Named("override") String override)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_override_xpath",override);
    }
    @Then("the user should verify the prefix,suffix and override values for fid <officeFid> as:$values")
    public void verifyPrefixSuffixAndOverrideValuesFromZeus(@Named("officeFid") String officeFid, @Named("values")ExamplesTable values)
    {
        getEditOfficePage().verifyPrefixSuffixAndOverrideValuesFromZeus(officeFid,values);
    }

    @Then("the user should see the maxlength of prefix field set to $maxlength")
    public void verifyPrefixMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_prefix_xpath",maxlength);
    }
    @Then("the user should see the maxlength of suffix field set to $maxlength")
    public void verifySuffixMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_suffix_xpath",maxlength);
    }
    @Then("the user should see the maxlength of override field set to $maxlength")
    public void verifyOverrideMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_override_xpath",maxlength);
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
    @When("the user clicks on the $officetype_dropdown in the basicinfo office page")
    public void clickOnNewOfficeTypeDropDown(String officetype_dropdown ){
        getEditOfficePage().clickOnNewOfficeTypeDropDown(officetype_dropdown);
    }

    @Then("the user should see the $dropdown values from lookup $fid except the values that are selected already in office")
    public void verifyOfficeTypeListFromLookup(String dropdown,String fid){
        getEditOfficePage().verifyOfficeTypeListFromLookup(fid,dropdown);
    }


    @When("the user clicks on the add new office type button")
    public void clickOnAddNewOfficeTypeButton()
    {
        getEditOfficePage().clickOnAddNewOfficeTypeButton();
    }

    @Then("the user should see the officeType value as in $source document with fid <officeFid>")
    public void verifyEditOfficesOfficeTypeValueFromTrusted(@Named("officeFid") String officeFid,@Named("source") String source){
        getEditOfficePage().verifyEditOfficesOfficeTypeValueFromTrusted(officeFid,"type",source);
    }

    @When("the user selects office type value as <officeTypeValue> from $rowIdentifier in the basicinfo office page")
    public void selectOfficeType(@Named("officeTypeValue") String officeTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getEditOfficePage().selectOfficeType(officeTypeValue,rowIdentifier);
    }

    @Then("the user should see officeType value as <officeTypeValue> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficesOfficeTypeValueFromZeusAndInUI(@Named("officeTypeValue") String officeTypeValue,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficesOfficeTypeValueFromZeusAndInUI(officeTypeValue, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should not see the deleted office type value $officeTypeValue in the $source document and in UI for fid <officeFid>")
    public void verifyOfficeTypeNotPresentInZeusAndInUI(@Named("officeTypeValue") String officeTypeValue,@Named("source") String source,@Named("officeFid") String officeFid)
    {
        getEditOfficePage().verifyOfficeTypeNotPresentInZeusAndInUI(source,officeFid,"type",officeTypeValue);
    }


    @Then("the user should see the $delete_button in disabled state in office types section")
    public void verifyDeleteOfficeTypeButtonStatus(@Named("delete_button") String delete_button)
    {
        getEditOfficePage().verifyDeleteOfficeTypeButtonStatus(delete_button);
    }

    @When("the user clicks on the $deletebutton in office types section")
    public void clickonDeleteOfficeTypeRowButton(String deletebutton)
    {
        getEditOfficePage().clickonDeleteOfficeTypeRowButton(deletebutton);
    }

    @Then("the user should still see the office $dropdown with value $dropdownvalue in office type in office page")
    public void verifyExistingOfficeTypeRow(String dropdown,String dropdownvalue)
    {
        getEditOfficePage().verifyExistingOfficeTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should not see the office $dropdown with value $dropdownvalue in office type in office page")
    public void verifyNoExistingOfficeTypeRow(String dropdown,String dropdownvalue)
    {
        getEditOfficePage().verifyNoExistingOfficeTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should still see the office $dropdown in the new office type row")
    public void verifyNewOfficeTypeRow(String dropdown)
    {
        getEditOfficePage().verifyNewOfficeTypeRow(dropdown);
    }

    @Then("the user should not see the office $dropdown in the new office type row")
    public void verifyNoNewOfficeTypeRow(String dropdown)
    {
        getEditOfficePage().verifyNoNewOfficeTypeRow(dropdown);
    }

    @When("the user selects to delete all the office type rows except the first one in office types")
    public void deleteAllOfficeTypeRowsExceptRow1()
    {
        getEditOfficePage().deleteAllOfficeTypeRowsExceptRow1();
    }

    @Then("the user should see the error message for the required office type field in the basic info office page")
    public void verifyErrorMsgRequiredForOfficeType(){
        getEditOfficePage().verifyErrorMsgRequiredForOfficeType();
    }

    @When("the user enters null value for all the office type rows")
    public void enterNullValueForAllOfficeTypeRows()
    {
        getEditOfficePage().enterNullValueForAllOfficeTypeRows();
    }

    @Then("the user should see the $office_rowIdentifier values in office's section from lookup $lookup")
    public void verifyOfficesNameTypesFromLookup(@Named("offices_rowIdentifier") String offices_rowIdentifier,@Named("lookup") String lookup) {
        getEditOfficePage().verifyOfficesNameTypesFromLookup(offices_rowIdentifier,lookup);
    }

    @When("the user clicks on add new office name button in the office name page")
    public void clickOnAddButton(){
        getEditOfficePage().clickAddRowButton();
    }

    @Then("the user should see the office name values as in $source document with fid <officeFid>")
    public void verifyEditOfficeNameValuesFromTrusted(@Named("officeFid") String officeFid,@Named("source") String source){
        getEditOfficePage().verifyEditOfficeNameValuesFromTrusted(officeFid,source);
    }

    @When("the user selects office name type $officeNameTypeRowIdentifier value as <type>")
    public void selectOfficeNameType(@Named("officeNameTypeRowIdentifier") String officeNameTypeRowIdentifier,@Named("type") String type1)
    {
        getEditOfficePage().selectOfficeNameType(officeNameTypeRowIdentifier,type1);
    }

    @When("the user enters office name value $officeNameValueRowIdentifier as <value>")
    public void enterOfficeNameValue(@Named("officeNameValueRowIdentifier") String officeNameValueRowIdentifier,@Named("value") String value1)
    {
        getEditOfficePage().enterOfficeNameValue(officeNameValueRowIdentifier,value1);
    }

    @Then("the user should see officename values as <type><value> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeNameValuesExistInZeusandinUI(@Named("type") String type,@Named("value") String value,@Named("officeFid") String officeFid,@Named("source") String source){

        getEditOfficePage().verifyEditOfficeNameValuesExistInZeusandinUI(type,value,officeFid,source);
    }


    @When("the user clicks on delete office names row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeNamesRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeNamesRowButton(deletebutton_Row);
    }
    @Then("the user should see the error message $errorMsg for the office name value field")
    public void verifyOfficeNameValueErrorMessage(@Named("errorMsg") String errorMsg)
    {
        getEditOfficePage().verifyOfficeNameValueErrorMessage("office_name_value_error_msg_xpath",errorMsg);
    }

    @Then("the user should not see officename values for fid <officeFid> in $source document as: $names")
    public void verifyEditOfficeNameValuesNotExistInZeus(@Named("officeFid") String officeFid,@Named("source") String source,@Named("names") ExamplesTable names)
    {
        getEditOfficePage().verifyEditOfficeNameValuesNotExistInZeus(officeFid,source,names);
    }

    @Then("the user should not see the new office name row with $dropdown")
    public void verifyNoNewOfficeNameRow(String dropdown)
    {
        getEditOfficePage().verifyNoNewOfficeNameRow(dropdown);
    }

    @Then("the user should not see the delete button for legal title in names for office")
    public void verifyDeleteButtonForOfficeLegalTitle() {
        getEditOfficePage().verifyDeleteButtonForOfficeLegalTitle();
    }


    @Then("the user verifies the office name value maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthOfficeNameValueText(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeNameValueText(maxSize,rowIdentifier);}


    @Then("the user verifies the office name sort name maxlength is $maxSize for the sortName")
    public void verifyMaxlengthOfficeNameSortNameText(@Named("maxSize") String maxSize){getEditOfficePage().verifyMaxlengthOfficeNameSortNameText(maxSize);}

    @When("the user enters sort name as $sortName in the office name")
    public void entersSortNameInOfficeName(@Named("sortName") String sortName){
        getEditOfficePage().entersSortNameInOfficeName(sortName);
    }

    @Then("the user should see the edits to office sort name as <sortName> for fid <officeFid> in zeus document and in UI")
    public void verifyOfficeSortNameInZeusDocumentAndInUI(@Named("officeFid") String officeFid,@Named("sortName") String sortName) {
        getEditOfficePage().verifyOfficeSortNameInZeusDocumentAndInUI(officeFid,sortName);
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
    	setEditCityPage(getDataPage().createEditCityPage());
    	getEditCityPage().deleteAllIdentifierRows();
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

	@When("the user enters identifier type as <newIdentifierType> in the office identifier page")
	public void editOfficeIdentifierType(@Named("newIdentifierType") String identifierType) {
		getEditOfficePage().enterOfficeIdentifierType(identifierType, 1);
	}

	@When("the user enters identifier value as <newIdentifierValue> in the office identifier page")
	public void editOfficeIdentifierValue(@Named("newIdentifierValue") String identifierValue) {
		getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 1);
	}

	@When("the user enters identifier status as <newIdentifierStatus> in the office identifier page")
	public void editOfficeIdentifierStatus(@Named("newIdentifierStatus") String identifierStatus) {
		getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 1);
	}

	@When("the user enters identifier type as <identifierType2> in the office identifier page")
	public void enterOfficeIdentifierType2(@Named("identifierType2") String identifierType) {
		getEditOfficePage().enterOfficeIdentifierType(identifierType, 2);
	}

	@When("the user enters identifier value as <identifierValue2> in the office identifier page")
	public void enterOfficeIdentifierValues2(@Named("identifierValue2") String identifierValue) {
		getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 2);
	}

	@When("the user enters identifier status as <identifierStatus2> in the office identifier page")
	public void enterOfficeIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
		getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 2);
	}

	@Then("the user should see the successful update message at top of the office page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user verifies that the identifiers parameters are entered in the office identifiers page")
	public void verifyOfficeIdentifierParametersInUI(@Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {

		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };

		getEditOfficePage().verifyOfficeIdentifierParametersInUI(identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user should see the office identifier values as in $source document")
	public void verifyOfficeIdentifierValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("identifierType") String identifierType,
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

	@Then("the user should not see the newly added identifier row in the office identifiers page")
	@Alias("the user should not see the identifier row in the office identifiers page")
	public void verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed();
	}

	@Then("the user verifies that no values are entered in $source document for office identifiers")
	public void verifyOfficeIdentifierRowValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("identifierType") String identifierType,
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

	@Then("the user verifies that office identifier values are updated in $source document")
	public void verifyOfficeIdentifierRowValuesAreUpdatedInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("newIdentifierType") String identifierType,
			@Named("newIdentifierValue") String identifierValue,
			@Named("newIdentifierStatus") String identifierStatus) {
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);

		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user verifies existing offices identifiers parameters are updated with new office identifiers")
	public void verifyOfficeIdentifierParametersInUI(@Named("newIdentifierType") String identifierType,
			@Named("newIdentifierValue") String identifierValue,
			@Named("newIdentifierStatus") String identifierStatus) {

		String[] identifierTypes = { identifierType };
		String[] identifierValues = { identifierValue };
		String[] identifierStatusValues = { identifierStatus };

		getEditOfficePage().verifyOfficeIdentifierParametersInUI(identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user should see maximum length of office identifier value is limited to $maxLength")
	public void verifyMaxLengthInOfficeIdentifierValue(@Named("maxLength") String maxLength) {
		getEditOfficePage().verifyMaxLengthInOfficeIdentifierValue(maxLength);
	}

	@Then("the user should see the error message $errorMessage for identifier type field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierType(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierType(errorMessage);
	}

	@Then("the user should see the error message $errorMessage for identifier value field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierValue(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierValue(errorMessage);
	}

	@Then("the user should see the error message $errorMessage for identifier status field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierStatus(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierStatus(errorMessage);
	}

	@Then("the user verifies that the deleted row for office identifier does not exist in $source document")
	public void verifyOfficeIdentifierRowNotPresentInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid) {
		getEditOfficePage().verifyIdentifierRowNotPresentInZeusDB(source, officeFid);
	}

	@When("the user clicks on the delete identifier row button in the office identifiers page")
	public void clickOnDeleteNewOfficeIdentifierRowButton() {
		getEditOfficePage().clickOnDeleteNewOfficeIdentifierRowButton();
	}

	@Then("the user should see the newly added identifier row in the office identifiers page")
	public void verifyNewlyAddedOfficeIdentifierRowIsDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowIsDisplayed();
	}
	
	@Then("the user should see the Office History value in office page is same as per $source document")
	public void verifyOfficeHistoryFromTrustedDB(@Named("officeFid") String officeFid,@Named("source") String source) {
    	getEditOfficePage().verifyOfficeHistoryFromTrustedDB(source,"officeHistory",officeFid);
	}
	
    @When("the user enters <officeHistoryOld> value in office page")
    public void enterOfficeHistoryOld(@Named("officeHistoryOld") String officeHistoryOld) {
    	getEditOfficePage().enterOfficeHistory(officeHistoryOld);
	}
    
    @Then("the user should see the entered <officeHistoryOld> in Office page")
    public void verifyOfficeHistoryOld(@Named("officeHistoryOld") String officeHistoryOld) {
    	getEditOfficePage().verifyOfficeHistory(officeHistoryOld);
	}
    
    @When("the user enters <officeHistory> value in Office page")
    public void enterOfficeHistory(@Named("officeHistory") String officeHistory) {
    	getEditOfficePage().enterOfficeHistory(officeHistory);
	}
    
    @Then("the user should see the entered <officeHistory> in Office page")
    public void verifyOfficeHistory(@Named("officeHistory") String officeHistory) {
    	getEditOfficePage().verifyOfficeHistory(officeHistory);
	}
    
    @Then("the user should see the entered Office History in $source document")
	public void verifyOfficeHistoryZeus(@Named("officeFid") String officeFid,@Named("source") String source) {
    	getEditOfficePage().verifyOfficeHistoryZeus(source,"officeHistory",officeFid);
	}
        
    @When("the user enters values which is beyond 10000 unicode characters in the Office History field")
	public void enterCharactersInOfficeHistory() {
    	getEditOfficePage().enterCharactersInOfficeHistory();
	}
    
    @Then("the user should see maximum length of office history is limited to $maxLength")
	public void verifyMaxLengthOfficeHistory(@Named("maxLength") String maxLength) {
    	getEditOfficePage().verifyMaxLengthOfficeHistory(maxLength);
	}
    
    @Then("the user should be able to view that only 10000 unicode characters are saved in Office History field")
	public void viewValidCharacterLengthInterestRate() {
    	getEditOfficePage().viewValidCharacterLengthOfficeHistory();
	}
    
    @Then("the user should be able to verify the maximum values are entered in the Office History field")
	public void verifyMaximumTextInInterestRate() {
    	getEditOfficePage().verifyMaximumTextInOfficeHistory();
	}

}
