package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
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

    @Then("the user verifies office opened date from zeus document <fid> <day> <month> <year>")
    public void verifyUpdatedOfficeOpenedDate(@Named("fid") String fid,@Named("day") String day,@Named("month") String month,@Named("year") String year){getEditOfficePage().verifyUpdatedOfficeOpenedDate(fid,day,month,year);}

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



}



