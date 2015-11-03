package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

@Component
public class LegalEntitySteps extends AbstractSteps{

    @Then("the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>")
    public void verifyLegalEntityHeader(@Named("entity") String entity,
                                        @Named("headOfficeAddress") String headOfficeAddress,
                                        @Named("fid") String fid,
                                        @Named("tfpid") String tfpid){
        getLegalEntityPage().verifyLegalEntityHeader(entity, headOfficeAddress, fid, tfpid);
    }

    @Then("the user should see the basic info for selected legal entity")
    public void verifyLegalEntityBasicInfo(){
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the legalEntity's entity types as: $legalEntityEntities")
    public void verifyLegalEntityEntities(ExamplesTable legalEntities) {
        getLegalEntityPage().verifyLegalEntityEntities(legalEntities);
    }

    @Then("the user should see the legalEntity's telecoms as: $legalEntityTelecoms")
    public void verifyLegalEntitiesTelecoms(ExamplesTable legalEntitiesTelecoms){
        getLegalEntityPage().verifyLegalEntitiesTelecoms(legalEntitiesTelecoms);
    }

    @Then("the user should see the legalEntity corporate statement as $corporateStatement")
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

    @Then("the user should see the legal entity's location summaries as: $legalEntityLocations")
    public void verifyLegalEntityLocations(ExamplesTable legalEntityLocations){
        getLegalEntityPage().verifyLegalEntityLocations(legalEntityLocations);
    }

    @Then("the user should not see the legal entity's location summaries")
    public void verifyNoLegalEntityLocations(){
        getLegalEntityPage().verifyNoLegalEntityLocations();
    }

    @Then("the user should see the legal entity's statistics as: $legalEntityStatistics")
    public void verifyLegalEntityStatistics(ExamplesTable legalEntityStatistics) {
        getLegalEntityPage().verifyLegalEntityStatistics(legalEntityStatistics);
    }

    @Then("the user should see the legal entity's trust power as: $legalEntityTrustPowers")
    public void verifyLegalEntityTrustPowers(ExamplesTable legalEntityTrustPowers) {
        getLegalEntityPage().verifyLegalEntityTrustPowers(legalEntityTrustPowers);
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

    @Then("the user should see the legal entity's identifiers as: $legalEntityIdentifiers")
    public void verifyLegalEntityIdentifiers(ExamplesTable legalEntityIdentifiers){
        getDataPage().verifyIdentifiers(legalEntityIdentifiers);
    }

    @Then("the user should not see the legal entity's identifiers")
    public void verifyNoLegalEntityIdentifiers() {
        getDataPage().verifyNoIdentifiers();
    }

    @When("the user clicks on the legal entity personnel link in the navigation bar")
    public void clickOnLegalEntityPersonnel() {
        getLegalEntityPage().clickOnLegalEntityPersonnel();
    }

    @Then("the user should see the legal entity's personnel as: $legalEntityPersonnel")
    public void verifyLegalEntityPersonnel(ExamplesTable legalEntityPersonnel){
        getLegalEntityPage().verifyLegalEntityPersonnel(legalEntityPersonnel);
    }

    @Then("the user should not see the legal entity's personnel")
    public void verifyNoLegalEntityPersonnel() {
        getLegalEntityPage().verifyNoLegalEntityPersonnel();
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

    @Then("the user should see the legal entity's history as: $legalEntityHistory")
    public void verifyLegalEntityHistory(ExamplesTable legalEntityHistory) {
        getLegalEntityPage().verifyLegalEntityHistory(legalEntityHistory);
    }

    @Then ("the user should not see the legal entity's history")
    public void verifyNoLegalEntityHistory() {
        getLegalEntityPage().verifyNoLegalEntityHistory();
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

    @Then("the user should see the default legal entity page and display basic info")
    public void verifyDefaultLegalEntitySection(){
        getDataPage().verifyBasicInfo();
    }

    @When("the user clicks on the legal entity all link in the navigation bar")
    public void clickOnLegalEntityAllLink() {
        getDataPage().clicksOnAllLink();
    }

    @Then("the user should see the board meetings for the legal entity")
    public void verifyBoardMeetingsLabels(){
        getLegalEntityPage().verifyBoardMeetingsLabels();
    }

    @Then("the user should see the credit rating for the legal entity")
    public void verifyCreditRatingsLabel(){
        getDataPage().verifyCreditRatingsLabel();
    }

    @Then("the user should see the history for the legal entity")
    public void verifyHistoryLabel(){
        getLegalEntityPage().verifyHistoryLabel();
    }

    @Then("the user should see the identifiers for the legal entity")
    public void verifyLegalEntityIdentifiersLabels(){
        getDataPage().verifyLegalEntityIdentifiersLabels();
    }

    @Then("the user should see the location summaries for the legal entity")
    public void verifyLegalEntityLocationsLabel(){
        getLegalEntityPage().verifyLegalEntityLocationsLabel();
    }

    @Then("the user should see the ownership summaries for the legal entity")
    public void verifyOwnershipLabels(){
        getLegalEntityPage().verifyOwnershipLabels();
    }

    @Then("the user should see the personnel for the legal entity")
    public void verifyPersonnelLabels(){
        getLegalEntityPage().verifyPersonnelLabels();
    }

    @Then("the user should see the offered services for the legal entity")
    public void verifyLegalEntityOfferedServicesLabels(){
        getLegalEntityPage().verifyLegalEntityOfferedServicesLabels();
    }

    @Then("the user should see the financial services for the legal entity")
    public void verifyLegalEntityFinancialServicesLabels(){
        getLegalEntityPage().verifyLegalEntityFinancialServicesLabels();
    }

    @Then("the user should see the statistics for the legal entity")
    public void verifyLegalEntityStatisticsLabels(){
        getLegalEntityPage().verifyLegalEntityStatisticsLabels();
    }

    @Then("the user should see the trust powers for the legal entity")
    public void verifyLegalEntityTrustPowersLabels(){
        getLegalEntityPage().verifyLegalEntityTrustPowersLabels();
    }

    @Then("the user should not see the legal entity's credit ratings section")
    public void verifyNoLegalEntityCreditRatingsSection(){
        getLegalEntityPage().verifyNoLegalEntityCreditRatingsSection();
    }

    @Then("the user clicks on the offices tab in the legal entity")
    public void clicksOnOfficesTab() {
        getLegalEntityPage().clicksOnOfficesTab();
    }
}
