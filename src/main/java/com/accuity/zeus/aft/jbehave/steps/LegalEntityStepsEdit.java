package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.jbehave.steps.AbstractSteps;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class LegalEntityStepsEdit extends AbstractSteps{


    public static String selectedEntity="";

    @Then("the user updates the value of insurance type <ownershipType>")
    public void updateOwnershipType(@Named("ownershipType") String ownershipType){getLegalEntityPage().updateOwnershipType(ownershipType);}

    @When("the user verifies if the update for successful in zeus document <ownershipType> <fid>")
    public void verifyOwnershipTypeValueFromZeusDoc(@Named("ownershipType") String ownershipType, @Named("fid") String fid){getLegalEntityPage().verifyOwnershipTypeValueFromDocument(ownershipType, fid);}

    @Then("the user should see the fatcaStatus value as in $source document with fid <fid>")

    public void verifyEditLegalEntityFatcaStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromTrusted(fid,"fatcaStatus",source);
    }

    @Then("the user should see the legalentity's lead institution value as in $source document with fid <fid>")
    public void verifyEditLegalEntityLeadInstitutionFlagInTrusted(@Named("fid") String fid,@Named("source") String source){
        getLegalEntityPage().verifyEditLegalEntityLeadInstitutionFlagInDB(fid,source);
    }

    @When("the user gets the document with $xqueryName with the $param as <entity> from the database")
    public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("param") String param,@Named("entity") String entity)
    {
        getDataPage().getDocument(xqueryName, param, entity);

    }

    @When("the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page")
    public void selectLegalEntityLeadInstitutionFlag(@Named("leadInstitutionflag") String leadInstitutionflag){
        getLegalEntityPage().selectLegalEntityLeadInstitutionFlag(leadInstitutionflag);
    }

    @Then("the user should see leadInstitution value as <leadInstitutionflag> for fid <fid> in $source document")
    public void getDocumentLeadInstitution(@Named("leadInstitutionflag") String leadInstitutionflag,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyLeadInstitutionValuefromDB(leadInstitutionflag,fid,source);
    }

    @Then("the user should not see lead institution label and value")
    public void verifyNoLeadInstitution() {
        getLegalEntityPage().verifyNoLeadInstitution();
    }
    @Then("the user should return to edit legalentity page mode")
    public void verifyLegalEntityEditPageMode(){
        getLegalEntityPage().verifyLegalEntityEditPageMode();
    }
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

    @Then("the user verifies options displayed for charter type from lookup document")
    public void verifyCharterTypeOptions(){getLegalEntityPage().verifyCharterTypeOptions();}

    @Then("the user validates default value for charter type from trusted document <fid>")
    public void verifyCharterTypeDefaultValue(@Named("fid") String fid){getLegalEntityPage().verifyCharterTypeDefaultValue(fid);}

    @When("the user updates charter type value <chartertype>")
    public void updateCharterType(@Named("chartertype") String charterType){getLegalEntityPage().updateCharterType(charterType);}

    @Then("the user verifies charter type from trusted and zeus document <fid>")
    public void verifyUpdatedCharterTypeFromBothDocs(@Named("fid") String fid){getLegalEntityPage().verifyUpdatedCharterTypeBothDocs(fid);}

    @When("the user clicks on the Status drop-down in the basicinfo legalentity page")
    public void clickOnStatusType(){
        getLegalEntityPage().clickOnStatusType();
    }

    @Then("the user should see the status values from lookup Status")
    public void verifyLegalEntityStatusList(){
        getLegalEntityPage().verifyLegalEntityStatusList();
    }
    @When("the user clicks on the $entitytype_dropdown in the basicinfo legalentity page")
    public void clickOnNewEntityTypeDropDown(String entitytype_dropdown ){
        getLegalEntityPage().clickOnNewEntityTypeDropDown(entitytype_dropdown);
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


    @When("the user selects value as <fatcastatus> from Fatca Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityFatcaStatusValue(@Named("fatcastatus") String fatcaStatus)
    {
        getLegalEntityPage().selectLegalEntityFatcaStatusValue(fatcaStatus);
    }

    @Then("the user should see fatcaStatus value as <fatcastatus> for fid <fid> in $source document")
    public void verifyFatcaStatusValuefromDB(@Named("fatcastatus") String fatcastatus,@Named("fid") String fid,@Named("source") String source) {
        getLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromZeus(fatcastatus,"fatcaStatus",fid,source);
    }

    @When("the user updates corporate statement <value>")
    public void entersCorporateStatement(@Named("value") String corporateStatement){
        getLegalEntityPage().enterValueForCorporateStatement(corporateStatement);
    }

    @Then("the user verifies corporate summary from zeus document <fid> <value>")
    public void verifyUpdatedCorporateSummary(@Named("fid") String fid,@Named("value") String corporateStatement){getLegalEntityPage().verifyUpdatedCorporateSummary(fid,corporateStatement);}
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
    @When("the user selects entity type value as <entityTypeValue> from $rowIdentifier in the basicinfo legalentity page")
    public void selectEntityType(@Named("entityTypeValue") String entityTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getLegalEntityPage().selectEntityType(entityTypeValue,rowIdentifier);
    }

    @Then("the user should not see the deleted entity type value $value in the $source document for fid <fid>")
    public void verifyEntityTypeNotPresentInZeus(@Named("value") String value,@Named("source") String source,@Named("fid") String fid)
    {
        getLegalEntityPage().verifyEntityTypeNotPresentInZeus(source,fid,"type",value);
    }

    @Then("the user should see the delete row confirmation modal in the legal entity page")
    public void verifyDeleteConfirmationModalInlegalEntity() {
        getLegalEntityPage().verifyDeleteConfirmationModalInlegalEntity();
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
    @Then("the user should see the newly added names in the legal entity basic info page")
    public void verifyNewlyAddedNames() {
        getLegalEntityPage().verifyNewlyAddedNames();
    }
    @When("the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page")
    public void clickOnYesButtonInDeleteConfirmationModalInLegalEntity() {
        getLegalEntityPage().clickOnYesButtonInDeleteConfirmationModalInLegalEntity();
    }
    @Then("the user should not see the newly added names in the legal entity basic info page")
    public void verifyNoNewlyAddedNames() {
        getLegalEntityPage().verifyNoNewlyAddedNames();
    }
    @Then("the user updates Chartered date <day> <month> <year>")
    public void updateCharteredDate(@Named("day") String day,@Named("month") String month,@Named("year") String year){getLegalEntityPage().updateCharteredDate(day,month,year);}
    @Then("the user verifies chartered date <fid>")
    public void verifyCharteredDate(@Named("fid") String fid){getLegalEntityPage().verifyUpdatedCharteredDate(fid);}
    @Then("the user verifies options displayed for insurance type from lookup document")
    public void verifyInsuranceTypeOptions(){getLegalEntityPage().verifyInsuranceTypeOptions();}

    @Then("the user updates the value of insurance type <insuranceValue>")
    public void updateInsuranceType(@Named("insuranceValue") String insuranceType){getLegalEntityPage().updateInsuranceType(insuranceType);}

    @When("the user verifies if the update for successful in zeus document <insuranceValue> <fid>")
    public void verifyInsuranceTypeValueFromZeusDoc(@Named("insuranceValue") String insuranceValue, @Named("fid") String fid){getLegalEntityPage().verifyInsuranceTypeValueFromDocument(insuranceValue, fid);}

    @Then("the user verifies options displayed for ownership type from lookup document")
    public void verifyOwnershipTypeOptions(){getLegalEntityPage().verifyOwnershipTypeOptionsFromLookup();}





}
