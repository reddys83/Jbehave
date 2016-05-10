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
public class LegalEntitySteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

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

    @When("the user clicks on the type dropdown in legalEntity locations")
    public void clickOnLegalEntityLocationTypeDropDwon() {
        getLegalEntityPage().clickOnLegalEntityLocationTypeDropDwon();
    }

    @When("the user select type as <type> in the legalentity location summary")
    public void selectsTypeInLegalEntityLocationSummary(@Named("type") String type){
        getLegalEntityPage().selectsTypeInLegalEntityLocationSummary(type);
    }

    @When("the user enters value as <value> in the legalentity location summary")
    public void entersLegalEntityValueInLocationSummary(@Named("value") String value){
        getLegalEntityPage().entersLegalEntityValueInLocationSummary(value);
    }
    @When("the user clicks on the add new location summary button in legalentity location")
    public void clickNewLegalEntityLocations() {
         getLegalEntityPage().clickNewLegalEntityLocations();
    }

    @Then("the user should see the error message required for the type in legalentity location summary")
    public void verifyRequiredErrorMessageForTypeInLegalEntityLocations() {
        getLegalEntityPage().verifyRequiredErrorMessageForTypeInLegalEntityLocations();
    }

    @Then("the user should see the legalentity's location summary type values from lookup LOCATION_SUMMARY_TEXT_TYPE")
    public void verifyLegalEntityLocationsTypeValues() {
        getLegalEntityPage().verifyLegalEntityLocationsTypeValues();
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
    public void verifyEditLegalEntityLeadInstitutionFlagInTrusted(@Named("fid") String fid,@Named("source") String source){
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

    @When("the user clicks on the Status drop-down in the basicinfo legalentity page")
    public void clickOnStatusType(){
        getLegalEntityPage().clickOnStatusType();
    }

    @Then("the user should see the status values from lookup Status")
    public void verifyLegalEntityStatusList(){
        getLegalEntityPage().verifyLegalEntityStatusList();
    }

    @When("the user starts typing the name of a status as $word in the Status drop-down")
    public void enterValueInStatusDropdown(String word) {
        getLegalEntityPage().enterValueInStatusDropdown(word);
    }
    @Then("the user should see the selected status in the drop-down as $status")
    public void verifyStatusInDropdown(String status)
    {
        getLegalEntityPage().verifyStatusInDropdown(status);
    }

    @When("the user selects value as <status> from Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityStatusValue(@Named("status") String status)
    {
        getLegalEntityPage().selectLegalEntityStatusValue(status);
    }

    @Then("the user should see the status value as in $source document with fid <fid>")

    public void verifyEditLegalEntityStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityStatusValueFromTrusted(fid,"status",source);
    }

    @Then("the user should see status value as <status> for fid <fid> in $source document")
    public void verifyStatusValuefromDB(@Named("status") String status,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityStatusValueFromZeus(status,"status",fid,source);
    }
    @When("the user selects a non-default value from Status drop-down in the basicinfo legalentity page")
    public void changeLegalEntityStatusValue(){
        getLegalEntityPage().changeLegalEntityStatusValue();
    }


    @Then("the user verifies basic info for legal entity left column <fid> from trusted document")
    public void getLegalEntityBasicinfoLeftColumn(@Named("fid") String fid){getLegalEntityPage().verifyLegalEntityBasicInfoLeftColumn(fid);}


    @Then("the user verifies options displayed for charter type from lookup document")
    public void verifyCharterTypeOptions(){getLegalEntityPage().verifyCharterTypeOptions();}

    @Then("the user validates default value for charter type from trusted document <fid>")
    public void verifyCharterTypeDefaultValue(@Named("fid") String fid){getLegalEntityPage().verifyCharterTypeDefaultValue(fid);}

    @When("the user updates charter type value <chartertype>")
    public void updateCharterType(@Named("chartertype") String charterType){getLegalEntityPage().updateCharterType(charterType);}

    @Then("the user verifies charter type from trusted and zeus document <fid>")
    public void verifyUpdatedCharterTypeFromBothDocs(@Named("fid") String fid){getLegalEntityPage().verifyUpdatedCharterTypeBothDocs(fid);}


    @When("the user enters day for claimed est date <day>")
    public void enterDayForClaimedEstDate(@Named("day") String day){getLegalEntityPage().enterDayValueForClaimedEstDate(day);}

    @When("the user enters month for claimed est date <month>")
    public void enterMonthForClaimedEstDate(@Named("month") String month){getLegalEntityPage().enterMonthValueForClaimedEstDate(month);}

    @When("the user enters year for claimed est date <year>")
    public void enterYearForClaimedEstMonth(@Named("year") String year){getLegalEntityPage().enterYearValueForClaimedEstDate(year);}

    @Then("the user should see the error message enter a day/month/year on legal entity page")
    public void verifyErrorMessageDisplayedForClaimedEstDate(){getLegalEntityPage().validateErrorMessageforClaimedEstDate();}

    @Then("the user verifies claimed est date from trusted and zeus document <fid>")
    public void verifyUpdatedClaimedEstDateFromBothDocs(@Named("fid") String fid){getLegalEntityPage().verifyUpdatedClaimedEstDateBothDocs(fid);}


    @Then("the user should return to edit legalentity page mode")
    public void verifyLegalEntityEditPageMode(){
        getLegalEntityPage().verifyLegalEntityEditPageMode();
    }

    @When("the user clicks on the Fatca Status drop-down in the basicinfo legalentity page")
    public void clickOnFatcaStatusType(){
        getLegalEntityPage().clickOnFatcaStatusType();
    }

    @Then("the user should see the Fatca status values from lookup $fidS")
    public void verifyLegalEntityFatcaStatusList(String fid){
        getLegalEntityPage().verifyLegalEntityFatcaStatusList(fid);
    }

    @When("the user starts typing the name of a status as $word in the Fatca Status drop-down")
    public void enterValueInFatcaStatusDropdown(String word) {
        getLegalEntityPage().enterValueInFatcaStatusDropdown(word);
    }

    @Then("the user should see the selected Fatca status in the drop-down as $status")
    public void verifyFatcaStatusInDropdown(String status)
    {
        getLegalEntityPage().verifyFatcaStatusInDropdown(status);
    }

    @When("the user selects a non-default value from Fatca Status drop-down in the basicinfo legalentity page")
    public void changeLegalEntityFatcaStatusValue(){
        getLegalEntityPage().changeLegalEntityFatcaStatusValue();
    }

    @Then("the user should see the fatcastatus value as in $source document with fid <fid>")

    public void verifyEditLegalEntityFatcaStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromTrusted(fid,"fatcastatus",source);
    }
    @When("the user selects value as <fatcastatus> from Fatca Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityFatcaStatusValue(@Named("fatcastatus") String fatcaStatus)
    {
        getLegalEntityPage().selectLegalEntityFatcaStatusValue(fatcaStatus);
    }
    @Then("the user should see fatcaStatus value as <fatcastatus> for fid <fid> in $source document")
    public void verifyFatcaStatusValuefromDB(@Named("fatcastatus") String fatcastatus,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromZeus(fatcastatus,"fatcastatus",fid,source);
    }

}
