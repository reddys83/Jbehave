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

    public static String selectedEntity="";

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

    @Then("the user should see the Fatca status values from lookup $fid")
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

    @Then("the user should see the fatcaStatus value as in $source document with fid <fid>")

    public void verifyEditLegalEntityFatcaStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromTrusted(fid,"fatcaStatus",source);
    }
    @When("the user selects value as <fatcastatus> from Fatca Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityFatcaStatusValue(@Named("fatcastatus") String fatcaStatus)
    {
        getLegalEntityPage().selectLegalEntityFatcaStatusValue(fatcaStatus);
    }
    @Then("the user should see fatcaStatus value as <fatcastatus> for fid <fid> in $source document")
    public void verifyFatcaStatusValuefromDB(@Named("fatcastatus") String fatcastatus,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromZeus(fatcastatus,"fatcaStatus",fid,source);
    }

    @When("the user clicks on the add new name button in the basic info legal entity page")
    public void clicksAddLegalEntityNames() {
        getLegalEntityPage().clicksAddLegalEntityNames();
    }

    @When("the user enters more than 200 characters in legal entity names value")
    public void entersInvalidCharactersForValueInNames()
    {
        getLegalEntityPage().entersInvalidCharactersForValueInNames();
    }

    @When("the user clicks on new legal entity names type drop-down")
    public void clicksLegalEntityNamesTypeDropdown() {
        getLegalEntityPage().clicksLegalEntityNamesTypeDropdown();
    }

    @Then("the user should see the legal entity names types from lookup LEGAL_ENTITY_NAME_TYPE")
    public void verifyLegalEntityNamesTypeDropdown() {
        getLegalEntityPage().verifyLegalEntityNamesTypeDropdown();
    }

    @When("the user selects names type <legalEntityNameType> in the basic info legal entity page")
    public void selectLegalEntityNamesType(@Named("legalEntityNameType") String legalEntityNameType) {
        getLegalEntityPage().selectLegalEntityNamesType(legalEntityNameType);
    }

    @When("the user enters names value <legalEntityNameValue> in the basic info legal entity page")
    public void enterLegalEntityNamesValue(@Named("legalEntityNameValue") String legalEntityNameValue) {
        getLegalEntityPage().enterLegalEntityNamesValue(legalEntityNameValue);
    }

    @Then("the user should see the edits to legal entity names in zeus document")
    public void verifyEditLegalEntityNamesInZeus()
    {
     getLegalEntityPage().verifyEditLegalEntityNamesInZeus(selectedEntity);
    }
    @When("the user clicks on delete legal entity names option")
    public void clicksOnDeleteLegalEntityNames()
    {
        getLegalEntityPage().clicksOnDeleteLegalEntityNames();
    }

    @Then("the user should see the delete row confirmation modal in the legal entity page")
    public void verifyDeleteConfirmationModalInlegalEntity() {
        getLegalEntityPage().verifyDeleteConfirmationModalInlegalEntity();
    }

    @When("the user clicks on the no button in the delete row confirmation modal in the legal entity basic info page")
    public void clickOnNoButtonInDeleteConfirmationModalInLegalEntity() {
        getLegalEntityPage().clickOnNoButtonInDeleteConfirmationModalInLegalEntity();
    }

    @When("the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page")
    public void clickOnYesButtonInDeleteConfirmationModalInLegalEntity() {
        getLegalEntityPage().clickOnYesButtonInDeleteConfirmationModalInLegalEntity();
    }

    @Then("the user should see the newly added names in the legal entity basic info page")
    public void verifyNewlyAddedNames() {
        getLegalEntityPage().verifyNewlyAddedNames();
    }

    @Then("the user should not see the newly added names in the legal entity basic info page")
    public void verifyNoNewlyAddedNames() {
        getLegalEntityPage().verifyNoNewlyAddedNames();
    }
    @Then("the user should not see the delete button for legal tiltle in names for legal entity")
    public void verifyDeleteButtonForLegalTitle() {
           getLegalEntityPage().verifyDeleteButtonForLegalTitle();
     }

    @Then("the user should see the error message required for the type and value fields of legal entity names")
    public void verifyRequiredErrorMessageForTypesAndValues() {
        getLegalEntityPage().verifyRequiredErrorMessageForTypesAndValues();
    }

    @Then("the user should see the error message enter up to 200 valid characters for value in the legal entity page")
    public void verifyErrorMessageForValue() {
        getLegalEntityPage().verifyErrorMessageForValue();
    }
    @When("the user enters the <additionalInfoText> in the additional info text area")
    public void enterLegalEntityAdditionalInfo(@Named("additionalInfoText") String additionalInfoText)
    {
        getLegalEntityPage().enterLegalEntityAdditionalInfo(additionalInfoText);
    }

    @Then("the user should see additional info text value as <additionalInfoText> for fid <fid> in $source document")
    public void verifyAdditionalInfoValuefromDB(@Named("additionalInfoText") String additionalInfoText,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityAdditionalInfoValueFromZeus(additionalInfoText,"additionalInfo",fid,source);
    }

    @Then("the user should see additional info text value with 10000 characters for fid <fid> in $source document")
    public void verifyAdditionalInfoValueWithMaxLengthFromDB(@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyAdditionalInfoValueWithMaxLengthFromZeus("additionalInfo",fid,source);
    }

    @Then("the user should see the additional info text area field length as 10000")
    public void verifyAdditionalInfoTextAreaLength(@Named("fid") String fid) {
        getLegalEntityPage().verifyAdditionalInfoTextAreaLength(fid);
    }

    @When("the user enters 10001 characters in the additional info text area")
    public void enter10001CharactersInLegalEntityAdditionalInfo(@Named("fid") String fid) {
        getLegalEntityPage().enter10001CharactersInLegalEntityAdditionalInfo(fid);
    }

    @When("the user enters 10000 characters in the additional info text area")
    public void enter10000CharactersInLegalEntityAdditionalInfo(@Named("fid") String fid) {
        getLegalEntityPage().enter10000CharactersInLegalEntityAdditionalInfo(fid);
    }

    @Then("the user should see the error message enter up to 10000 valid characters for additional info value in the basic info legal entity page")
    public void verifyLegalEntityAdditionalInfoErrorMessageForMaxLength() {
        getLegalEntityPage().verifyLegalEntityAdditionalInfoErrorMessageForMaxLength();
    }

    @When("the user updates corporate statement <value>")
    public void entersCorporateStatement(@Named("value") String corporateStatement){
        getLegalEntityPage().enterValueForCorporateStatement(corporateStatement);
    }

    @Then("the user verifies corporate summary from zeus document <fid> <value>")
    public void verifyUpdatedCorporateSummary(@Named("fid") String fid,@Named("value") String corporateStatement){getLegalEntityPage().verifyUpdatedCorporateSummary(fid,corporateStatement);}

    @Then("the user verifies corporate action text area field length as 10000")
    public void verifyMaXlengthCorporateActionTextArea(){getLegalEntityPage().verifyMaxLengthCorporateActionTextArea();}

    @Then("the user enters 10000 characters in corporate action text area")
    public void enter10000CharactersInCorporateActionTextArea(){getLegalEntityPage().enter10000CharactersInLegalEntityCorporateAction();}

    @When("the user enters 10001 characters in the corporate action text area")
    public void enter10001CharctersCorporateActionTextArea(){getLegalEntityPage().enter10001CharactersInLegalEntityCorporateAction();}

    @Then("the user should see the error message enter up to 10000 valid characters for corporate action value in the basic info legal entity page")
    public void verifyLegalEntityCorporateActionErrorMessageForMaxLength() {
        getLegalEntityPage().verifyLegalEntityCorporateActionErrorMessageForMaxLength();
    }

    @Then("the user should see the $dropdown values from lookup $fid except the values that are selected already")
    public void verifyLegalEntityEntityTypeList(String dropdown,String fid){
    getLegalEntityPage().verifyLegalEntityEntityTypeListFromLookup(fid,dropdown);
    }

    @When("the user clicks on the add new entity type button")
    public void clickOnAddNewEntityTypeButton()
    {
        getLegalEntityPage().clickOnAddNewEntityTypeButton();
    }

    @When("the user clicks on the $entitytype_dropdown in the basicinfo legalentity page")
    public void clickOnNewEntityTypeDropDown(String entitytype_dropdown ){
        getLegalEntityPage().clickOnNewEntityTypeDropDown(entitytype_dropdown);
    }

    @When("the user selects entity type value as <entityTypeValue> from $rowIdentifier in the basicinfo legalentity page")
    public void selectEntityType(@Named("entityTypeValue") String entityTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getLegalEntityPage().selectEntityType(entityTypeValue,rowIdentifier);
    }

    @Then("the user should see the entityType value as in $source document with fid <fid>")

    public void verifyEditLegalEntityEntityTypeValueFromTrusted(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityEntityTypeValueFromTrusted(fid,"type",source);
    }

    @Then("the user should see entityType value as <entityTypeValue> for fid <fid> in $source document")
    public void verifyEditLegalEntityEntityTypeValueFromZeus(@Named("entityTypeValue") String entityTypeValue,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityEntityTypeValueFromZeus(entityTypeValue,"type",fid,source);
    }

    @Then("the user should see the $delete_button in disabled state in entity types section")
    public void verifyDeleteLegalEntityTypeButtonStatus(@Named("delete_button") String delete_button)
    {
        getLegalEntityPage().verifyDeleteLegalEntityTypeButtonStatus(delete_button);
    }

    @When("the user clicks on the $deletebutton in entity types section")
    public void clickonDeleteEntityTypeRowButton(String deletebutton)
    {
        getLegalEntityPage().clickonDeleteEntityTypeRowButton(deletebutton);
    }

    @Then("the user should still see the $dropdown with value $dropdownvalue")
    public void verifyExistingEntityTypeRow(String dropdown,String dropdownvalue)
    {
        getLegalEntityPage().verifyExistingEntityTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should not see the $dropdown with value $dropdownvalue")
    public void verifyNoExistingEntityTypeRow(String dropdown,String dropdownvalue)
    {
        getLegalEntityPage().verifyNoExistingEntityTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should not see the deleted entity type value $value in the $source document for fid <fid>")
    public void verifyEntityTypeNotPresentInZeus(@Named("value") String value,@Named("source") String source,@Named("fid") String fid)
    {
        getLegalEntityPage().verifyEntityTypeNotPresentInZeus(source,fid,"type",value);
    }

    @Then("the user should still see the $dropdown in the new row")
    public void verifyNewEntityTypeRow(String dropdown)
    {
        getLegalEntityPage().verifyNewEntityTypeRow(dropdown);
    }

    @Then("the user should not see the $dropdown in the new row")

    public void verifyNoNewEntityTypeRow(String dropdown)
    {
        getLegalEntityPage().verifyNoNewEntityTypeRow(dropdown);
    }

    @When("the user selects to delete all the entity type rows except the first one")
    public void deleteAllEntityTypeRowsExceptRow1()
    {
        getLegalEntityPage().deleteAllEntityTypeRowsExceptRow1();
    }

    @Then("the user should see the error message for the required entity type field in the basic info legal entity page")
    public void verifyErrorMsgRequiredForEntityType(){
        getLegalEntityPage().verifyErrorMsgRequiredForEntityType();
    }

    @When("the user enters null value for all the entity type rows")
    public void enterNullValueForAllEntityTypeRows()
    {
        getLegalEntityPage().enterNullValueForAllEntityTypeRows();
    }

    @Then("the user updates Chartered date <day> <month> <year>")
    public void updateCharteredDate(@Named("day") String day,@Named("month") String month,@Named("year") String year){getLegalEntityPage().updateCharteredDate(day,month,year);}

    @Then("the user verifies chartered date <fid>")
    public void verifyCharteredDate(@Named("fid") String fid){getLegalEntityPage().verifyUpdatedCharteredDate(fid);}

    @Then("the user should see the error $startDateErrorMsg for chartered date")
    public void verifyStartDateErrorMessage(@Named("startDateErrorMsg") String startDateErrorMsg) {
        getLegalEntityPage().verifyErrorMessageCharteredDate(startDateErrorMsg);
    }

}
