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

    @Then("the user should return to edit office page mode")
    public void verifyOfficeEditPageMode(){
        getEditOfficePage().verifyOfficeEditPageMode();
    }

}



