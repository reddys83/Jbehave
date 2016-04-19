package com.accuity.zeus.aft.jbehave.steps;


import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

@Component
public class LegalEntitySteps extends AbstractSteps{

    @Then("the user should see the legal entity's entity types as: $legalEntityEntities")
    public void verifyLegalEntityEntities(ExamplesTable legalEntities) {
        getLegalEntityPage().verifyLegalEntityEntities(legalEntities);
    }

    @Then("the user should see the legal entity's virtual presence as: $legalEntityTelecoms")
    public void verifyLegalEntitiesVirtualPresence(ExamplesTable legalEntitiesVirtualPresence){
        getLegalEntityPage().verifyLegalEntitiesVirtualPresence(legalEntitiesVirtualPresence);
    }

    @Then("the user should see the legal entity corporate statement as $corporateStatement")
    public void verifyCorporateStatement(@Named("corporateStatement") String corporateStatement) {
        getLegalEntityPage().verifyCorporateStatement(corporateStatement);
    }

    @When("the user clicks on the legal entity services link in the navigation bar")
    public void clickOnLegalEntityServices(){
        getLegalEntityPage().clickOnLegalEntityServices();
    }

    @When("the user clicks on the legal entity locations link in the navigation bar")
    public void clickOnLegalEntityLocations(){
        getLegalEntityPage().clickOnLegalEntityLocations();
    }

    @When("the user clicks on the legal entity statistics link in the navigation bar")
    public void clickOnLegalEntityStatistics(){
        getLegalEntityPage().clickOnLegalEntityStatistics();
    }

    @When("the user clicks on the legal entity tust power link in the navigation bar")
    public void clickOnLegalEntityTrustPowers(){
        getLegalEntityPage().clickOnLegalEntityTrustPowers();
    }

    @Then("the user should see the legal entity's offered services as: $offeredServices")
    public void verifyLegalEntityOfferedServices(ExamplesTable offeredServices){
        getLegalEntityPage().verifyLegalEntityOfferedServices(offeredServices);
    }

    @Then("the user should see the legal entity's location summaries for fid <fid> from trusted document")
    public void verifyLegalEntityLocations(@Named("fid") String fid){
        getLegalEntityPage().verifyLegalEntityLocations(fid);
    }

    @Then("the user should not see the legal entity's location summaries")
    public void verifyNoLegalEntityLocations(){
        getLegalEntityPage().verifyNoLegalEntityLocations();
    }

    @Then("the user should see the legal entity's trust powers for fid <fid> from trusted document")
    public void verifyLegalEntityTrustPowersfromDB(@Named("fid") String searchedEntity) {
        getLegalEntityPage().verifyLegalEntityTrustPowersfromDB(searchedEntity);
    }
    @Then("the user should not see the legal entity's trust powers")
    public void verifyNoLegalEntityTrustPowers(){
        getLegalEntityPage().verifyNoLegalEntityTrustPowers();
    }

    @Then("the user should see the legal entity's financial services as: $financialServices")
    public void verifyLegalEntityFinancialServices(ExamplesTable financialServices){
        getLegalEntityPage().verifyLegalEntityFinancialServices(financialServices);
    }

    @Then("the user should see the message you can search for a legal entity at any time using the header search")
    public void verifyLegalEntitySearchMsg(){
        getLegalEntityPage().verifyLegalEntitySearchMsg();
    }

    @Then("the user should not see the legal entity's offered services")
    public void verifyNoLegalEntityOfferedServices(){
        getLegalEntityPage().verifyNoLegalEntityOfferedServices();
    }

    @Then("the user should not see the legal entity's financial services")
    public void verifyNoLegalEntityFinancialServices(){
        getLegalEntityPage().verifyNoLegalEntityFinancialServices();
    }

    @When("the user clicks on the legal entity identifier link in the navigation bar")
    public void clickOnLegalEntityIdentifierLink(){
        getLegalEntityPage().clickOnLegalEntityIdentifierLink();
    }

    @When("the user clicks on the legal entity personnel link in the navigation bar")
    public void clickOnLegalEntityPersonnel() {
        getLegalEntityPage().clickOnLegalEntityPersonnel();
    }

    @When("the user clicks on the legal entity credit rating link in the navigation bar")
    public void clickOnLegalEntityCreditRating() {
        getLegalEntityPage().clickOnLegalEntityCreditRating();
    }

    @When("the user clicks on the legal entity history link in the navigation bar")
    public void clickOnLegalEntityHistory(){
        getLegalEntityPage().clickOnLegalEntityHistory();
    }

    @When("the user clicks on the legal entity board meetings link in the navigation bar")
    public void clickOnLegalEntityBoardMeetings(){
        getLegalEntityPage().clickOnLegalEntityBoardMeetings();
    }
    @Then("the user should see the legal entity's summary as $SummaryValue")
    public void verifyBoardMeetingsSummary(@Named("SummaryValue") String SummaryValue){
        getLegalEntityPage().verifyBoardMeetingsSummary(SummaryValue);
    }

    @Then("the user should not see the legal entity's summary")
    public void verifyNoBoardMeetingsSummary() {
        getLegalEntityPage().verifyNoBoardMeetingsSummary();
    }

    @Then("the user should see the legal entity's board meetings as: $BoardMeetingsValues")
    public void verifyBoardMeetingsValues(ExamplesTable BoardMeetingsValues) {
        getLegalEntityPage().verifyBoardMeetingsValues(BoardMeetingsValues);
    }

    @Then("the user should not see the legal entity's board meetings")
    public void verifyNoBoardMeetingsValues() {
        getLegalEntityPage().verifyNoBoardMeetingsValues();
    }

    @When("the user clicks on the legal entity ownership link in the navigation bar")
    public void clickOnLegalEntityOwnership() {
        getLegalEntityPage().clickOnLegalEntityOwnership();
    }

    @Then("the user should see the legal entity's ownership as: $legalEntityOwnership")
    public void verifyLegalEntityOwnership(ExamplesTable legalEntityOwnership) {
        getLegalEntityPage().verifyLegalEntityOwnership(legalEntityOwnership);
    }

    @Then("the user should not see the legal entity's ownership")
    public void verifyNoLegalEntityOwnership(){
        getLegalEntityPage().verifyNoLegalEntityOwnership();
    }

    @Then("the user should see the board meetings for the legal entity")
    public void verifyBoardMeetingsLabels(){
        getLegalEntityPage().verifyBoardMeetingsLabels();
    }

    @Then("the user should see the credit rating for the legal entity")
    public void verifyCreditRatingsLabel(){
        getDataPage().verifyCreditRatingsLabels();
    }

    @Then("the user should see the location summaries for the legal entity")
    public void verifyLegalEntityLocationsLabel(){
        getLegalEntityPage().verifyLegalEntityLocationsLabel();
    }

    @Then("the user should see the ownership summaries for the legal entity")
    public void verifyOwnershipLabels(){
        getLegalEntityPage().verifyOwnershipLabels();
    }

    @Then("the user should see the offered services for the legal entity")
    public void verifyLegalEntityOfferedServicesLabels(){
        getLegalEntityPage().verifyLegalEntityOfferedServicesLabels();
    }

    @Then("the user should see the financial services for the legal entity")
    public void verifyLegalEntityFinancialServicesLabels(){
        getLegalEntityPage().verifyLegalEntityFinancialServicesLabels();
    }

    @Then("the user should see the trust powers for the legal entity")
    public void verifyLegalEntityTrustPowersLabels(){
        getLegalEntityPage().verifyLegalEntityTrustPowersLabels();
    }

    @Then("the user should not see the legal entity's credit ratings section")
    public void verifyNoLegalEntityCreditRatingsSection(){
        getLegalEntityPage().verifyNoLegalEntityCreditRatingsSection();
    }

    @When("the user clicks on the offices link in the legal entity page")
    public void clickOnOfficesLink(){
        setOfficesPage(getLegalEntityPage().clickOnOfficesLink());
    }

    @When("the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page")
    public void selectLegalEntityLeadInstitutionFlag(@Named("leadInstitutionflag") String leadInstitutionflag){
        getLegalEntityPage().selectLegalEntityLeadInstitutionFlag(leadInstitutionflag);
    }
    @When("the user selects lead institution value other than default value in the basicinfo legalentity page")
    public void changeLegalEntityLeadInstitutionFlag(){
        getLegalEntityPage().changeLegalEntityLeadInstitutionFlag();
    }
    @Then("the user should see the legalentity's lead institution value as in $source document with fid <fid>")
    public void verifyEditLegalEntityLeadInstitutionFlagInZeus(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityLeadInstitutionFlagInDB(fid,source);
    }

    @Then("the user should see leadInstitution value as <leadInstitutionflag> for fid <fid> in $source document")
    public void getDocumentLeadInstitution(@Named("leadInstitutionflag") String leadInstitutionflag,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyLeadInstitutionValuefromDB(leadInstitutionflag,fid,source);
    }


    @Then("the user should not see lead institution label and value")
    public void verifyNoLeadInstitution() {
        getLegalEntityPage().verifyNoLeadInstitution();
    }

    @Then("the user verifies basic info for legal entity left column <fid> from trusted document")
    public void getLegalEntityBasicinfoLeftColumn(@Named("fid") String fid){getLegalEntityPage().verifyLegalEntityBasicInfoLeftColumn(fid);}

    @Then("the user should return to edit legalentity page mode")
    public void verifyLegalEntityEditPageMode(){
        getLegalEntityPage().verifyLegalEntityEditPageMode();
    }
}
