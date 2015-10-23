package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Alias;
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

    @Then("the user should see the basic info for selected legalEntity")
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

    @When("the user clicks on the legal entity statistics link in the navigation bar")
    public void clickOnLegalEntityStatistics(){
        getLegalEntityPage().clickOnLegalEntityStatistics();
    }

    @Then("the user should see the legal entity's offered services as: $offeredServices")
    public void verifyLegalEntityOfferedServices(ExamplesTable offeredServices){
        getLegalEntityPage().verifyLegalEntityOfferedServices(offeredServices);
    }

    @Then("the user should see the legal entity's statistics as: $legalEntityStatistics")
    public void verifyLegalEntityStatistics(ExamplesTable legalEntityStatistics) {
        getLegalEntityPage().verifyLegalEntityStatistics(legalEntityStatistics);
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
}
