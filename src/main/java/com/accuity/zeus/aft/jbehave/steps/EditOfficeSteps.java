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

    @Then("the user should see the officetype $dropdown values from lookup $fid except the values that are selected already")
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

    @Then("the user should see officeType value as <officeTypeValue> for fid <officeFid> in $source document")
    public void verifyEditOfficesOfficeTypeValueFromZeus(@Named("officeTypeValue") String officeTypeValue,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficesOfficeTypeValueFromZeus(officeTypeValue, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should not see the deleted office type value $value in the $source document for fid <officeFid>")
    public void verifyOfficeTypeNotPresentInZeus(@Named("value") String value,@Named("source") String source,@Named("officeFid") String officeFid)
    {
        getEditOfficePage().verifyOfficeTypeNotPresentInZeus(source,officeFid,"type",value);
    }
}



