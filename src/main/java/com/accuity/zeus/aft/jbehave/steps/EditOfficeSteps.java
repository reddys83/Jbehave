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

    @When("the user enters the office prefix value as <prefix>")
    public void enterOfficePrefixValue(String prefix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_prefix_xpath",prefix);
    }
    @When("the user enters the office suffix value as <suffix>")
    public void enterOfficeSuffixValue(String prefix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_suffix_xpath",prefix);
    }
    @When("the user enters the office override value as <override>")
    public void enterOfficeOverrideValue(String prefix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_override_xpath",prefix);
    }
    @Then("the user should verify the prefix,suffix and override values for fid <officeFid> as:")
    public void verifyPrefixSuffixAndOverrideValuesFromZeus(String officeFid)
    {
        getEditOfficePage().verifyPrefixSuffixAndOverrideValuesFromZeus(officeFid);
    }

}



