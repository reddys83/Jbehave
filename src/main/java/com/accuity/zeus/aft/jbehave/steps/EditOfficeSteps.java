package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
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

    @Then("the user verifies office opened date from zeus document <fid> <day> <month> <year>")
    public void verifyUpdatedOfficeOpenedDate(@Named("fid") String fid,@Named("day") String day,@Named("month") String month,@Named("year") String year){getEditOfficePage().verifyUpdatedOfficeOpenedDate(fid,day,month,year);}


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

}

