package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.jbehave.steps.AbstractSteps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

@Component
public class EditLegalEntitySteps extends AbstractSteps{

    public static String selectedEntity="";

    @Then("the user updates the value of insurance type <ownershipType>")
    public void updateOwnershipType(@Named("ownershipType") String ownershipType){getEditLegalEntityPage().updateOwnershipType(ownershipType);}

    @When("the user verifies if the update for successful in zeus document <ownershipType> <fid>")
    public void verifyOwnershipTypeValueFromZeusDoc(@Named("ownershipType") String ownershipType, @Named("fid") String fid){getEditLegalEntityPage().verifyOwnershipTypeValueFromDocument(ownershipType, fid);}

    @Then("the user should see the fatcaStatus value as in $source document with fid <fid>")

    public void verifyEditLegalEntityFatcaStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromTrusted(fid,"fatcaStatus",source);
    }

    @Then("the user should see the legalentity's lead institution value as in $source document with fid <fid>")
    public void verifyEditLegalEntityLeadInstitutionFlagInTrusted(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyEditLegalEntityLeadInstitutionFlagInDB(fid,source);
    }

    @When("the user gets the document with $xqueryName with the $param as <entity> from the database")
    public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("param") String param,@Named("entity") String entity)
    {
        getDataPage().getDocument(xqueryName, param, entity);

    }

    @When("the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page")
    public void selectLegalEntityLeadInstitutionFlag(@Named("leadInstitutionflag") String leadInstitutionflag){
        getEditLegalEntityPage().selectLegalEntityLeadInstitutionFlag(leadInstitutionflag);
    }

    @Then("the user should see leadInstitution value as <leadInstitutionflag> for fid <fid> in $source document")
    public void getDocumentLeadInstitution(@Named("leadInstitutionflag") String leadInstitutionflag,@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyLeadInstitutionValuefromDB(leadInstitutionflag,fid,source);
    }

    @Then("the user should not see lead institution label and value")
    public void verifyNoLeadInstitution() {
        getEditLegalEntityPage().verifyNoLeadInstitution();
    }
    @Then("the user should return to edit legalentity page mode")
    public void verifyLegalEntityEditPageMode(){
        getEditLegalEntityPage().verifyLegalEntityEditPageMode();
    }
    @When("the user enters day for claimed est date <day>")
    public void enterDayForClaimedEstDate(@Named("day") String day){getEditLegalEntityPage().enterDayValueForClaimedEstDate(day);}

    @When("the user enters month for claimed est date <month>")
    public void enterMonthForClaimedEstDate(@Named("month") String month){getEditLegalEntityPage().enterMonthValueForClaimedEstDate(month);}

    @When("the user enters year for claimed est date <year>")
    public void enterYearForClaimedEstMonth(@Named("year") String year){getEditLegalEntityPage().enterYearValueForClaimedEstDate(year);}

    @Then("the user should see the error message enter a day/month/year on legal entity page")
    public void verifyErrorMessageDisplayedForClaimedEstDate(){getEditLegalEntityPage().validateErrorMessageforClaimedEstDate();}

    @Then("the user verifies claimed est date from trusted and zeus document <fid>")
    public void verifyUpdatedClaimedEstDateFromBothDocs(@Named("fid") String fid){getEditLegalEntityPage().verifyUpdatedClaimedEstDateBothDocs(fid);}

    @Then("the user verifies options displayed for charter type from lookup document")
    public void verifyCharterTypeOptions(){getEditLegalEntityPage().verifyCharterTypeOptions();}

    @Then("the user validates default value for charter type from trusted document <fid>")
    public void verifyCharterTypeDefaultValue(@Named("fid") String fid){getEditLegalEntityPage().verifyCharterTypeDefaultValue(fid);}

    @When("the user updates charter type value <chartertype>")
    public void updateCharterType(@Named("chartertype") String charterType){getEditLegalEntityPage().updateCharterType(charterType);}

    @Then("the user verifies charter type from trusted and zeus document <fid>")
    public void verifyUpdatedCharterTypeFromBothDocs(@Named("fid") String fid){getEditLegalEntityPage().verifyUpdatedCharterTypeBothDocs(fid);}

    @When("the user clicks on the Status drop-down in the basicinfo legalentity page")
    public void clickOnStatusType(){
        getEditLegalEntityPage().clickOnStatusType();
    }

    @Then("the user should see the status values from lookup Status")
    public void verifyLegalEntityStatusList(){
        getEditLegalEntityPage().verifyLegalEntityStatusList();
    }
    @When("the user clicks on the $entitytype_dropdown in the basicinfo legalentity page")
    public void clickOnNewEntityTypeDropDown(String entitytype_dropdown ){
        getEditLegalEntityPage().clickOnNewEntityTypeDropDown(entitytype_dropdown);
    }

    @When("the user starts typing the name of a status as $word in the Status drop-down")
    public void enterValueInStatusDropdown(String word) {
        getEditLegalEntityPage().enterValueInStatusDropdown(word);
    }
    @Then("the user should see the selected status in the drop-down as $status")
    public void verifyStatusInDropdown(String status)
    {
        getEditLegalEntityPage().verifyStatusInDropdown(status);
    }

    @When("the user selects value as <status> from Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityStatusValue(@Named("status") String status)
    {
        getEditLegalEntityPage().selectLegalEntityStatusValue(status);
    }

    @Then("the user should see the status value as in $source document with fid <fid>")

    public void verifyEditLegalEntityStatusValueFromDB(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyEditLegalEntityStatusValueFromTrusted(fid,"status",source);
    }

    @Then("the user should see status value as <status> for fid <fid> in $source document")
    public void verifyStatusValuefromDB(@Named("status") String status,@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityStatusValueFromZeus(status,"status",fid,source);
    }
    @When("the user selects a non-default value from Status drop-down in the basicinfo legalentity page")
    public void changeLegalEntityStatusValue(){
        getEditLegalEntityPage().changeLegalEntityStatusValue();
    }



    @When("the user clicks on the Fatca Status drop-down in the basicinfo legalentity page")
    public void clickOnFatcaStatusType(){
        getEditLegalEntityPage().clickOnFatcaStatusType();
    }

    @Then("the user should see the Fatca status values from lookup $fid")
    public void verifyLegalEntityFatcaStatusList(String fid){
        getEditLegalEntityPage().verifyLegalEntityFatcaStatusList(fid);
    }

    @When("the user starts typing the name of a status as $word in the Fatca Status drop-down")
    public void enterValueInFatcaStatusDropdown(String word) {
        getEditLegalEntityPage().enterValueInFatcaStatusDropdown(word);
    }

    @Then("the user should see the selected Fatca status in the drop-down as $status")
    public void verifyFatcaStatusInDropdown(String status)
    {
        getEditLegalEntityPage().verifyFatcaStatusInDropdown(status);
    }



    @When("the user selects value as <fatcastatus> from Fatca Status drop-down in the basicinfo legalentity page")
    public void selectLegalEntityFatcaStatusValue(@Named("fatcastatus") String fatcaStatus)
    {
        getEditLegalEntityPage().selectLegalEntityFatcaStatusValue(fatcaStatus);
    }

    @Then("the user should see fatcaStatus value as <fatcastatus> for fid <fid> in $source document")
    public void verifyFatcaStatusValuefromDB(@Named("fatcastatus") String fatcastatus,@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityFatcaStatusValueFromZeus(fatcastatus,"fatcaStatus",fid,source);
    }

     @Then("the user verifies basic info for legal entity left column <fid> from trusted document")
    public void getLegalEntityBasicinfoLeftColumn(@Named("fid") String fid){
         if(editLegalEntityPage==null){
             editLegalEntityPage = getLegalEntityPage().createEditLegalEntityPage();
         }
         getEditLegalEntityPage().verifyLegalEntityBasicInfoLeftColumn(fid);}


    @When("the user selects a non-default value from Fatca Status drop-down in the basicinfo legalentity page")
    public void changeLegalEntityFatcaStatusValue(){
        getEditLegalEntityPage().changeLegalEntityFatcaStatusValue();
    }

    @When("the user updates corporate statement <value>")
    public void entersCorporateStatement(@Named("value") String corporateStatement){
        getEditLegalEntityPage().enterValueForCorporateStatement(corporateStatement);
    }

    @Then("the user verifies corporate summary from zeus document <fid> <value>")
    public void verifyUpdatedCorporateSummary(@Named("fid") String fid,@Named("value") String corporateStatement){getEditLegalEntityPage().verifyUpdatedCorporateSummary(fid,corporateStatement);}
    @Then("the user should not see the delete button for legal tiltle in names for legal entity")
    public void verifyDeleteButtonForLegalTitle() {
        getEditLegalEntityPage().verifyDeleteButtonForLegalTitle();
    }

    @Then("the user should see the error message required for the type and value fields of legal entity names")
    public void verifyRequiredErrorMessageForTypesAndValues() {
        getEditLegalEntityPage().verifyRequiredErrorMessageForTypesAndValues();
    }

    @Then("the user should see the error message enter up to 200 valid characters for value in the legal entity page")
    public void verifyErrorMessageForValue() {
        getEditLegalEntityPage().verifyErrorMessageForValue();
    }

    @When("the user enters the <additionalInfoText> in the additional info text area")
    public void enterLegalEntityAdditionalInfo(@Named("additionalInfoText") String additionalInfoText)
    {
        getEditLegalEntityPage().enterLegalEntityAdditionalInfo(additionalInfoText);
    }

    @Then("the user should see additional info text value as <additionalInfoText> for fid <fid> in $source document")
    public void verifyAdditionalInfoValuefromDB(@Named("additionalInfoText") String additionalInfoText,@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityAdditionalInfoValueFromZeus(additionalInfoText,"additionalInfo",fid,source);
    }

    @Then("the user should see additional info text value with 10000 characters for fid <fid> in $source document")
    public void verifyAdditionalInfoValueWithMaxLengthFromDB(@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyAdditionalInfoValueWithMaxLengthFromZeus("additionalInfo",fid,source);
    }

    @Then("the user should see the additional info text area field length as 10000")
    public void verifyAdditionalInfoTextAreaLength(@Named("fid") String fid) {
        getEditLegalEntityPage().verifyAdditionalInfoTextAreaLength(fid);
    }

    @When("the user enters 10001 characters in the additional info text area")
    public void enter10001CharactersInLegalEntityAdditionalInfo(@Named("fid") String fid) {
        getEditLegalEntityPage().enter10001CharactersInLegalEntityAdditionalInfo(fid);
    }

    @When("the user enters 10000 characters in the additional info text area")
    public void enter10000CharactersInLegalEntityAdditionalInfo(@Named("fid") String fid) {
        getEditLegalEntityPage().enter10000CharactersInLegalEntityAdditionalInfo(fid);
    }

    @Then("the user should see the history text area field length as 10000")
    public void verifyHistoryTextAreaLength(@Named("fid") String fid) {
        getEditLegalEntityPage().verifyHistoryTextAreaLength(fid);
    }


    @Then("the user should see the error message enter up to 10000 valid characters for additional info value in the basic info legal entity page")
    public void verifyLegalEntityAdditionalInfoErrorMessageForMaxLength() {
        getEditLegalEntityPage().verifyLegalEntityAdditionalInfoErrorMessageForMaxLength();
    }

    @Then("the user verifies corporate action text area field length as 10000")
    public void verifyMaXlengthCorporateActionTextArea(){getEditLegalEntityPage().verifyMaxLengthCorporateActionTextArea();}

    @Then("the user enters 10000 characters in corporate action text area")
    public void enter10000CharactersInCorporateActionTextArea(){getEditLegalEntityPage().enter10000CharactersInLegalEntityCorporateAction();}

    @When("the user enters 10001 characters in the corporate action text area")
    public void enter10001CharctersCorporateActionTextArea(){getEditLegalEntityPage().enter10001CharactersInLegalEntityCorporateAction();}

    @Then("the user should see the error message enter up to 10000 valid characters for corporate action value in the basic info legal entity page")
    public void verifyLegalEntityCorporateActionErrorMessageForMaxLength() {
        getEditLegalEntityPage().verifyLegalEntityCorporateActionErrorMessageForMaxLength();
    }

    @Then("the user should see the $dropdown values from lookup $fid except the values that are selected already")
    public void verifyLegalEntityEntityTypeList(String dropdown,String fid){
        getEditLegalEntityPage().verifyLegalEntityEntityTypeListFromLookup(fid,dropdown);
    }

    @When("the user clicks on the add new entity type button")
    public void clickOnAddNewEntityTypeButton()
    {
        getEditLegalEntityPage().clickOnAddNewEntityTypeButton();
    }

    @Then("the user should see the entityType value as in $source document with fid <fid>")
    public void verifyEditLegalEntityEntityTypeValueFromTrusted(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyEditLegalEntityEntityTypeValueFromTrusted(fid,"type",source);
    }

    @Then("the user should see entityType value as <entityTypeValue> for fid <fid> in $source document")
    public void verifyEditLegalEntityEntityTypeValueFromZeus(@Named("entityTypeValue") String entityTypeValue,@Named("fid") String fid,@Named("source") String source) {
        getEditLegalEntityPage().verifyLegalEntityDocumentInZeus(entityTypeValue, "type", fid, source, "get legal entity basic info left column");
    }

    @Then("the user should see creditratings values as <agencyName><type><value><AppliedDateDay><AppliedDateMonth><AppliedDateYear><ConfirmedDateDay><ConfirmedDateMonth><ConfirmedDateYear> for fid <fid> in $source document")
    public void verifyEditLegalEntityCreditRatingsValuesExistInZeus(@Named("agencyName") String agencyName,
                                                                 @Named("type") String type,
                                                                 @Named("value") String value,
                                                                 @Named("AppliedDateDay") String AppliedDateDay,
                                                                 @Named("AppliedDateMonth") String AppliedDateMonth,
                                                                 @Named("AppliedDateYear") String AppliedDateYear,
                                                                 @Named("ConfirmedDateDay") String ConfirmedDateDay,
                                                                 @Named("ConfirmedDateMonth") String ConfirmedDateMonth,
                                                                 @Named("ConfirmedDateYear") String ConfirmedDateYear,
                                                                 @Named("fid") String fid,
                                                                 @Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityCreditRatingsValuesExistInZeus(agencyName,type,value,AppliedDateDay,AppliedDateMonth,AppliedDateYear,ConfirmedDateDay,ConfirmedDateMonth,ConfirmedDateYear,fid,source);
    }
    @Then("the user should not see creditratings values for fid <fid> in $source document as: $creditRatings")
    public void verifyEditLegalEntityCreditRatingsValuesNotExistInZeus1(@Named("creditRatings") ExamplesTable creditRatings,@Named("fid") String fid,@Named("source") String source)
    {
        getEditLegalEntityPage().verifyEditLegalEntityCreditRatingsValuesNotExistInZeus(creditRatings,fid,source);
    }
    @Then("the user should see the credit ratings values as in $source document with fid <fid>")
    public void verifyEditLegalEntityCreditRatingsValuesFromTrusted(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyEditLegalEntityCreditRatingsValuesFromTrusted(fid,source);
    }

    @Then("the user should see the $delete_button in disabled state in entity types section")
    public void verifyDeleteLegalEntityTypeButtonStatus(@Named("delete_button") String delete_button)
    {
        getEditLegalEntityPage().verifyDeleteLegalEntityTypeButtonStatus(delete_button);
    }

    @When("the user clicks on the $deletebutton in entity types section")
    public void clickonDeleteEntityTypeRowButton(String deletebutton)
    {
        getEditLegalEntityPage().clickonDeleteEntityTypeRowButton(deletebutton);
    }
    @When("the user selects entity type value as <entityTypeValue> from $rowIdentifier in the basicinfo legalentity page")
    public void selectEntityType(@Named("entityTypeValue") String entityTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getEditLegalEntityPage().selectEntityType(entityTypeValue,rowIdentifier);
    }

    @Then("the user should not see the deleted entity type value $value in the $source document for fid <fid>")
    public void verifyEntityTypeNotPresentInZeus(@Named("value") String value,@Named("source") String source,@Named("fid") String fid)
    {
        getEditLegalEntityPage().verifyEntityTypeNotPresentInZeus(source,fid,"type",value);
    }

    @Then("the user should see the delete row confirmation modal in the legal entity page")
    public void verifyDeleteConfirmationModalInlegalEntity() {
        getEditLegalEntityPage().verifyDeleteConfirmationModalInlegalEntity();
    }
    @Then("the user should still see the $dropdown with value $dropdownvalue")
    public void verifyExistingEntityTypeRow(String dropdown,String dropdownvalue)
    {
        getEditLegalEntityPage().verifyExistingEntityTypeRow(dropdown,dropdownvalue);
    }
    @Then("the user should not see the $dropdown with value $dropdownvalue")
    public void verifyNoExistingEntityTypeRow(String dropdown,String dropdownvalue)
    {
        getEditLegalEntityPage().verifyNoExistingEntityTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should still see the $dropdown in the new row")
    public void verifyNewEntityTypeRow(String dropdown)
    {
        getEditLegalEntityPage().verifyNewEntityTypeRow(dropdown);
    }

    @Then("the user should not see the $dropdown in the new row")

    public void verifyNoNewEntityTypeRow(String dropdown)
    {
        getEditLegalEntityPage().verifyNoNewEntityTypeRow(dropdown);
    }
    @Then("the user should still see the new credit ratings row with $dropdown")
    public void verifyNewCreditRatingsRow(String dropdown)
    {
        getEditLegalEntityPage().verifyNewCreditRatingsRow(dropdown);
    }

    @Then("the user should not see the new credit ratings row with $dropdown")

    public void verifyNoNewCreditRatingsRow(String dropdown)
    {
        getEditLegalEntityPage().verifyNoNewCreditRatingsRow(dropdown);
    }
    @When("the user selects to delete all the entity type rows except the first one")
    public void deleteAllEntityTypeRowsExceptRow1()
    {
        getEditLegalEntityPage().deleteAllEntityTypeRowsExceptRow1();
    }

    @Then("the user should see the error message for the required entity type field in the basic info legal entity page")
    public void verifyErrorMsgRequiredForEntityType(){
        getEditLegalEntityPage().verifyErrorMsgRequiredForEntityType();
    }
    @When("the user enters null value for all the entity type rows")
    public void enterNullValueForAllEntityTypeRows()
    {
        getEditLegalEntityPage().enterNullValueForAllEntityTypeRows();
    }
    @When("the user clicks on the add new name button in the basic info legal entity page")
    public void clicksAddLegalEntityNames() {
        getEditLegalEntityPage().clicksAddLegalEntityNames();
    }

    @When("the user enters more than 200 characters in legal entity names value")
    public void entersInvalidCharactersForValueInNames()
    {
        getEditLegalEntityPage().entersInvalidCharactersForValueInNames();
    }

    @When("the user clicks on new legal entity names type drop-down")
    public void clicksLegalEntityNamesTypeDropdown() {
        getEditLegalEntityPage().clicksLegalEntityNamesTypeDropdown();
    }

    @Then("the user should see the legal entity names types from lookup LEGAL_ENTITY_NAME_TYPE")
    public void verifyLegalEntityNamesTypeDropdown() {
        getEditLegalEntityPage().verifyLegalEntityNamesTypeDropdown();
    }

    @When("the user selects names type <legalEntityNameType> in the basic info legal entity page")
    public void selectLegalEntityNamesType(@Named("legalEntityNameType") String legalEntityNameType) {
        getEditLegalEntityPage().selectLegalEntityNamesType(legalEntityNameType);
    }

    @When("the user enters names value <legalEntityNameValue> in the basic info legal entity page")
    public void enterLegalEntityNamesValue(@Named("legalEntityNameValue") String legalEntityNameValue) {
        getEditLegalEntityPage().enterLegalEntityNamesValue(legalEntityNameValue);
    }

    @Then("the user should see the edits to legal entity names in zeus document")
    public void verifyEditLegalEntityNamesInZeus()
    {
        getEditLegalEntityPage().verifyEditLegalEntityNamesInZeus(selectedEntity);
    }
    @When("the user clicks on delete legal entity names option")
    public void clicksOnDeleteLegalEntityNames()
    {
        getEditLegalEntityPage().clicksOnDeleteLegalEntityNames();
    }

    @When("the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page")
    public void clickOnYesButtonInDeleteConfirmationModalInLegalEntity() {
        getEditLegalEntityPage().clickOnYesButtonInDeleteConfirmationModalInLegalEntity();
    }

    @Then("the user should see the newly added names in the legal entity basic info page")
    public void verifyNewlyAddedNames() {
        getEditLegalEntityPage().verifyNewlyAddedNames();
    }
    @Then("the user should not see the newly added names in the legal entity basic info page")
    public void verifyNoNewlyAddedNames() {
        getEditLegalEntityPage().verifyNoNewlyAddedNames();
    }
    @Then("the user updates Chartered date <day> <month> <year>")
    public void updateCharteredDate(@Named("day") String day,@Named("month") String month,@Named("year") String year){getEditLegalEntityPage().updateCharteredDate(day,month,year);}
    @Then("the user verifies chartered date <fid>")
    public void verifyCharteredDate(@Named("fid") String fid){getEditLegalEntityPage().verifyUpdatedCharteredDate(fid);}
    @Then("the user verifies options displayed for insurance type from lookup document")
    public void verifyInsuranceTypeOptions(){getEditLegalEntityPage().verifyInsuranceTypeOptions();}

    @Then("the user updates the value of insurance type <insuranceValue>")
    public void updateInsuranceType(@Named("insuranceValue") String insuranceType){getEditLegalEntityPage().updateInsuranceType(insuranceType);}

    @When("the user verifies if the update for successful in zeus document <insuranceValue> <fid>")
    public void verifyInsuranceTypeValueFromZeusDoc(@Named("insuranceValue") String insuranceValue, @Named("fid") String fid){getEditLegalEntityPage().verifyInsuranceTypeValueFromDocument(insuranceValue, fid);}

    @Then("the user verifies options displayed for ownership type from lookup document")
    public void verifyOwnershipTypeOptions(){getEditLegalEntityPage().verifyOwnershipTypeOptionsFromLookup();}

    @When("the user clicks on the legalEntity update link")
    public void clickOnUpdateCurrencyLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editLegalEntityPage==null){
        editLegalEntityPage = getLegalEntityPage().createEditLegalEntityPage();
    }}

    @When("the user clicks on the type dropdown in legalEntity locations")
    public void clickOnLegalEntityLocationTypeDropDwon() {
        getEditLegalEntityPage().clickOnLegalEntityLocationTypeDropDwon();
    }
    @When("the user clicks on the type dropdown in legalEntity personnel for $webElement")
    public void clickOnLegalEntityPersonnelTypeDropdown(@Named("webElement") String webElement) {
        getEditLegalEntityPage().clickOnLegalEntityPersonnelTypeDropdown(webElement);
    }
    @When("the user clicks on the type dropdown in legalEntity board meeting for $webElement")
    public void clickOnLegalEntityBoardMeetingsTypeDropdown(@Named("webElement") String webElement) {
        getEditLegalEntityPage().clickOnLegalEntityBoardMeetingsTypeDropdown(webElement);
    }
    @When("the user clicks on the value dropdown in legalEntity board meeting for $webElement")
    public void clickOnLegalEntityBoardMeetingsValueDropdown(@Named("webElement") String webElement) {
        getEditLegalEntityPage().clickOnLegalEntityBoardMeetingsValueDropdown(webElement);
    }

    @Then("the user should see the below options for legalEntity board meeting type dropdown as: $boardMeetingType")
    public void verifyLegalEntityBoardMeetingType(ExamplesTable boardMeetingType) {
        getEditLegalEntityPage().verifyLegalEntityBoardMeetingType(boardMeetingType);
    }

    @Then("the user should see the below options for legalEntity board meeting value dropdown as: $boardMeetingValue")
    public void verifyLegalEntityBoardMeetingValue(ExamplesTable boardMeetingValue) {
        getEditLegalEntityPage().verifyLegalEntityBoardMeetingValue(boardMeetingValue);
    }

    @When("the user enters summary <summary> in the legalEntity boardMeeting")
    public void enterSummaryInLegalEntityBoardMeeting(@Named("summary") String summary) {
        getEditLegalEntityPage().enterSummaryInLegalEntityBoardMeeting(summary);
    }
    @When("the user selects type <type> in the legalEntity board meeting for $webElement")
    public void selectsTypeInLegalEntityBoardMeeting(@Named("type") String type, @Named("webElement") String webElement){
        getEditLegalEntityPage().selectsTypeInLegalEntityBoardMeeting(type,webElement);
    }

    @When("the user selects type <type> in the legalEntity personnel for $webElement")
    public void selectsTypeInLegalEntityPersonnel(@Named("type") String type, @Named("webElement") String webElement) {
        getEditLegalEntityPage().selectsTypeInLegalEntityPersonnel(type, webElement);
    }

    @When("the user selects value <value> in the legalEntity board meeting for $webElement")
    public void selectsValueInLegalEntityBoardMeeting(@Named("value") String value, @Named("webElement") String webElement){
        getEditLegalEntityPage().selectsValueInLegalEntityBoardMeeting(value,webElement);
    }

    @Then("the user should see the legalentity's location summary type values from lookup LOCATION_SUMMARY_TEXT_TYPE")
    public void verifyLegalEntityLocationsTypeValues() {
        getEditLegalEntityPage().verifyLegalEntityLocationsTypeValues();
    }

    @Then("the user should see the legalEntity personnel type values from lookup PERSONNEL_SUMMARY_TEXT_TYPE")
    public void verifyLegalEntityPersonnelTypeValues() {
        getEditLegalEntityPage().verifyLegalEntityPersonnelTypeValues();
    }

    @When("the user clicks on the add new location summary button in legalentity location")
    public void clickNewLegalEntityLocations() {
        getEditLegalEntityPage().clickNewLegalEntityLocations();
    }

    @When("the user clicks on the add new board meeting button in legalEntity")
    public void clickNewLegalEntityBoardMeetings() {
        getEditLegalEntityPage().clickNewLegalEntityBoardMeetings();
    }

    @When("the user clicks on the add new personnel button in legalEntity")
    public void clickNewLegalEntityPersonnel() {
        getEditLegalEntityPage().clickNewLegalEntityPersonnel();
    }

    @When("the user select type as <type> in the legalentity location summary")
    public void selectsTypeInLegalEntityLocationSummary(@Named("type") String type){
        getEditLegalEntityPage().selectsTypeInLegalEntityLocationSummary(type);
    }

    @Then("the user should see the edits to legal entity location summary for fid <fid> in zeus document")
    public void verifyLegalEntityLocationSummaryInZeusDocument(@Named("fid") String fid) {
        getEditLegalEntityPage().verifyLegalEntityLocationSummaryInZeusDocument(fid);
    }

    @Then("the user should see the edits to legal entity history as <historyValue> for fid <fid> in zeus document")
    public void verifyLegalEntityHistoryInZeusDocument(@Named("fid") String fid,@Named("historyValue") String historyValue) {
        getEditLegalEntityPage().verifyLegalEntityHistoryInZeusDocument(fid,historyValue);
    }

    @Then("the user should see the edits to legal entity board meeting for fid <fid> in zeus document")
    public void verifyLegalEntityBoardMeetingInZeusDocument(@Named("fid") String fid,@Named("monthNumber") String monthNumber) {
        getEditLegalEntityPage().verifyLegalEntityBoardMeetingInZeus(fid,monthNumber);
    }

    @Then("the user should see the edits to legal entity personnel for fid <fid> in zeus document")
    public void verifyLegalEntityPersonnelInZeusDocument(@Named("fid") String fid) {
        getEditLegalEntityPage().verifyLegalEntityPersonnelInZeus(fid);
    }

    @Then("the user should see the error message required for the type in legalentity location summary")
    public void verifyRequiredErrorMessageForTypeInLegalEntityLocations() {
        getEditLegalEntityPage().verifyRequiredErrorMessageForTypeInLegalEntityLocations();
    }

    @When("the user enters more than 10000 characters in value for legalEntity location summary")
    public void enterInvalidCharactersInLegalEntityLocationsValue() {
        getEditLegalEntityPage().enterInvalidCharactersInLegalEntityLocationsValue();
    }

    @When("the user enters more than 10000 character in summary for legalEntity boardMeetings")
    public void enterInvalidCharactersInLegalEntityBoardMeetingSummary() {
        getEditLegalEntityPage().enterInvalidCharactersInLegalEntityBoardMeetingSummary();
    }

    @When("the user enters more than 10000 character in value for legalEntity personnel")
    public void enterInvalidCharactersInLegalEntityPersonnelValue() {
        getEditLegalEntityPage().enterInvalidCharactersInLegalEntityPersonnelValue();
    }

    @Then("the user should see the error message enter up to 10000 valid characters for value in the legalentity location")
    public void verifyErrorMessageForInvalidCharacter() {
        getEditLegalEntityPage().verifyErrorMessageForInvalidCharacter();
    }

    @Then("the user should see the error message enter up to 10000 valid characters for summary in legalentity boardMeeting")
    public void verifyErrorMessageForLegalEntitySummaryBoardMeeting() {
        getEditLegalEntityPage().verifyErrorMessageForLegalEntitySummaryBoardMeeting();
    }

    @Then("the user should see the error message enter up to 10000 valid characters for value in legalentity personnel")
    public void verifyErrorMessageForLegalEntityValuePersonnel() {
        getEditLegalEntityPage().verifyErrorMessageForLegalEntityValuePersonnel();
    }

    @Then("user should see the duplicate error message for value dropdown in legalEntity board meeting")
    public void verifyDuplicateErrorMessageForLegalEntityBoardMeeting() {
        getEditLegalEntityPage().verifyDuplicateErrorMessageForLegalEntityBoardMeeting();
    }

    @When("the user enters value as <value> in the legalentity location summary")
    public void entersLegalEntityValueInLocationSummary(@Named("value") String value){
        getEditLegalEntityPage().entersLegalEntityValueInLocationSummary(value);
    }

    @When("the user enters value as <value> in the legalEntity personnel")
    public void entersLegalEntityValueInPersonnel(@Named("value") String value){
        getEditLegalEntityPage().entersLegalEntityValueInPersonnel(value);
    }

    @Then("the user should see the error message required for type in legalEntity personnel")
    public void verifyRequiredErrorMessageForTypeInLegalEntityPersonnel() {
        getEditLegalEntityPage().verifyRequiredErrorMessageForTypeInLegalEntityPersonnel();
    }

    @When("the user clicks on delete button for legal entity location summary")
    public void clickOnDeleteButtonInLegalEntityLocationSummary() {
        getEditLegalEntityPage().clickOnDeleteButtonInLegalEntityLocationSummary();
    }
    @Then("the user should see the newly added legalentity location summary")
    public void verifyNewlyAddLegalEntityLocations() {
        getEditLegalEntityPage().verifyNewlyAddLegalEntityLocations();
    }

    @Then("the user should not see the newly added legalentity location summary")
    public void verifyNoNewlyAddedLegalEntityLocations() {
        getEditLegalEntityPage().verifyNoNewlyAddedLegalEntityLocations();
    }
    @When("the user enters value as <historyValue> in the legalentity history field")
    public void enterValueInLegalEntityHistoryTextField(@Named("historyValue") String historyValue){
    getEditLegalEntityPage().enterValueInLegalEntityHistoryTextField(historyValue);
    }

    @Then("the user should see the category dropdown i.e $row_Identifier values from lookup $lookup")
    public void verifyCategoryDropdownValuesFromLookup(@Named("row_Identifier") String row_Identifier,@Named("lookup") String lookup) {
        getEditLegalEntityPage().verifyCategoryDropdownValuesFromLookup(row_Identifier,lookup);
    }
    @Then("the user should see the financial category dropdown i.e $row_Identifier values from lookup $lookup")
    public void verifyFinancialCategoryDropdownValuesFromLookup(@Named("row_Identifier") String row_Identifier,@Named("lookup") String lookup) {
        getEditLegalEntityPage().verifyFinancialCategoryDropdownValuesFromLookup(row_Identifier,lookup);
    }
    @Then("the user should see the financial details dropdown i.e $row_Identifier values from lookup $lookup based on the selected value in $categoryLookup")
    public void verifyFinancialDetailsDropdownValuesFromLookup(@Named("row_Identifier") String row_Identifier,@Named("lookup") String lookup,@Named("categoryLookup") String categoryLookup) {
        getEditLegalEntityPage().verifyFinancialDetailsDropdownValuesFromLookup(row_Identifier,lookup,categoryLookup);
    }
    @When("the user clicks on add new offered services button in the services section of legal Entity page")
    public void clickAddOfferedServiceButton() {
        getEditLegalEntityPage().clickAddOfferedServiceButton();
    }
    @When("the user clicks on add new financial services button in the services section of legal Entity page")
    public void clickAddFinancialServiceButton() {
        getEditLegalEntityPage().clickAddFinancialServiceButton();
    }
    @When("the user selects financial category i.e $row_Identifier value as <financialCategory>")
    public void selectFinancialCategoryValue(@Named("row_Identifier") String row_Identifier,@Named("financialCategory") String financialCategory) {
        getEditLegalEntityPage().selectFinancialCategoryValue(row_Identifier,financialCategory);
    }

    @Then("the user should see the $creditratings_rowIdentifier values in credit rating's section from lookup $lookup")
    public void verifyCreditRatingValuesFromLookup(@Named("creditratings_rowIdentifier") String creditratings_rowIdentifier,@Named("lookup") String lookup) {
        getEditLegalEntityPage().verifyCreditRatingValuesFromLookup(creditratings_rowIdentifier,lookup);
    }
    @When("the user clicks on the $rowIdentifier in the legalentity identifier type section")
        public void clickOnIdentifierTypeDropDown(String rowIdentifier) {
        getEditLegalEntityPage().clickOnIdentifierTypeDropDown(rowIdentifier);
    }
    @Then("the user should see the legal entity service values as in $source document with fid <fid>")
    public void verifyLegalEntityServiceValuesFromTrusted(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyLegalEntityServiceValuesFromTrusted(fid,source);
    }

    @When("the user clicks on add new credit rating button in the credit rating legal Entity page")
    public void clickOnAddButton(){
        getEditLegalEntityPage().clickAddRowButton();
    }
    @Then("the user should see the identifier values for $row_Identifier from lookup $lookup except the values that are selected already")
    public void verifyLegalEntityIdentifierTypesListFromLookup(@Named("row_Identifier") String row_Identifier, @Named("lookup") String lookupFid) {
        getEditLegalEntityPage().verifyLegalEntityIdentifierTypesListFromLookup(row_Identifier);
    }
    @When("the user selects category value as <category> for $rowIdentifier")
    public void selectlegalEntityServicesCategory(@Named("category") String category,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().selectlegalEntityServices(category,rowIdentifier);
    }
    @When("the user enters override value as <override> for $rowIdentifier")
    public void enterlegalEntityServicesOverride(@Named("override") String override,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().enterlegalEntityServicesOverride(override,rowIdentifier);
    }
    @When("the user selects financialCategory value as <financialCategory> for $rowIdentifier")
    public void selectlegalEntityServicesFinancialCategory(@Named("financialCategory") String financialCategory,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().selectlegalEntityServices(financialCategory,rowIdentifier);
    }
    @When("the user selects financialDetails value as <financialDetails> for $rowIdentifier")
    public void selectlegalEntityServicesFinancialDetails(@Named("financialDetails") String financialDetails,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().selectlegalEntityServices(financialDetails,rowIdentifier);
    }

    @When("the user selects agency $agencyRowIdentifier value as <agencyName>")
    public void selectCreditRatingsAgencyName(@Named("agencyRowIdentifier") String agencyRowIdentifier,@Named("agencyName") String agencyName)
    {
        getEditLegalEntityPage().selectCreditRatingsAgencyName(agencyRowIdentifier,agencyName);
    }

    @When("the user clicks on the $rowIdentifier in the legalentity identifier status section")
    public void clickOnIdentifierStatusDropDown(String rowIdentifier) {
        getEditLegalEntityPage().clickOnIdentifierStatusDropDown(rowIdentifier);
    }

    @Then("the user should see the status values for $rowIdentifer from lookup $lookupFid")
    public void verifyLegalEntityIdentifierStatusList(String rowIdentifer, String lookupFid) {
        getEditLegalEntityPage().verifyLegalEntityIdentifierStatusList(rowIdentifer);
    }
    @When("the user clicks on the add new identifiers button")
    public void clickOnAddNewIdentifiersButton() {
        getEditLegalEntityPage().clickOnAddNewIdentifiersButton();
    }

    @When("the user selects identifier type as <identifierType> from $rowIdentifier in the legalentity page")
    public void identifierType(@Named("identifierType") String identifierType, @Named("rowIdentifier") String rowIdentifier) {
        getEditLegalEntityPage().selectIdentifierType(identifierType, rowIdentifier);
    }

    @Then("the user should see identifierType value as <identifierTypeValue> for fid <fid> in $source document")
    public void verifyEditLegalEntityIdentifierTypeValueFromZeus(@Named("entityTypeValue") String identifierTypeValue, @Named("fid") String fid, @Named("source") String source) {
        getEditLegalEntityPage().verifyLegalEntityDocumentInZeus(identifierTypeValue, "legalEntityIdentifierType", fid, source, "get legal entity basic info left column");
    }

    @Then("the user should see the identifier type as in $source document with fid <fid>")
    public void verifyEditLegalEntityIdentifierTypeValuesFromTrusted(@Named("fid") String fid, @Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityIdentifierTypeValuesFromTrusted(fid, source);
    }

    @When("the user selects identifier status as <identifierStatus> from $rowIdentifier in the legalentity page")
    public void identifierStatus(@Named("identifierStatus") String identifierStatus, @Named("rowIdentifier") String rowIdentifier) {
        getEditLegalEntityPage().selectIdentifierStatus(identifierStatus, rowIdentifier);
    }

    @When("the user enters identifier value as <value> for $identifierValueRowIdentifier")
    public void IdentifierValue(@Named("identifierValueRowIdentifier") String identifierValueRowIdentifier, @Named("value") String value) {
        getEditLegalEntityPage().enterIdentifierValue(identifierValueRowIdentifier, value);

    }

    @Then("the user should see identifier values as <identifierType><value><identifierStatus> for fid <fid> in $source document")
    public void verifyEditLegalEntityIdentifierValuesFromZeus(@Named("identifierType") String identifierType,
                                                              @Named("identifierStatus") String identifierStatus,
                                                              @Named("value") String value,
                                                              @Named("fid") String fid,
                                                              @Named("source") String source) {
        getEditLegalEntityPage().verifyEditLegalEntityIdentifierValuesFromZeus(identifierType,identifierStatus,value, fid, source);
    }

    @When("the user clicks on the delete button $rowIdentifier in the legal entity identifiers section")
        public void clickOnDeleteIdentifierRowButton(String rowIdentifier) {
        getEditLegalEntityPage().clickOnIdentifierDeleteRowButton(rowIdentifier);
    }

    @When("the user clicks yes button to delete row")
    public void pressEnterButtonInDeleteConfirmationModal(){
        getCountryPage().pressEnterButtonInDeleteConfirmationModal();
    }

    @Then("the user should not see identifier values for fid <fid> in $source document as: $identifiers")
    public void verifyIdentifierValuesNotExistInZEUS(@Named("fid") String fid,@Named("source") String source,@Named("identifiers") ExamplesTable identifiers) {
        getEditLegalEntityPage().verifyIdentifierValuesNotExistInZEUS(fid,source,identifiers);
    }


    @Then("the user should see the newly added identifier row in the basic info legal entity page")
    public void verifyNewlyAddedIdentifierRowIsDisplayed(String dropdown) {
        getEditLegalEntityPage().verifyNewlyAddedIdentifierRowIsDisplayed(dropdown);
    }



    @Then("the user enters 50 characters in the identifier value on the legal entity page")
    public void enter50CharactersInIdentifierValueField() {
        getEditLegalEntityPage().enter50CharactersInIdentifierValueField();
    }

    @Then("the user should see the error message enter only 50 valid characters for identifier value in the legal entity page")
    public void verifyLegalEntityIdentifierValueErrorMessageForMaxLength() {
        getEditLegalEntityPage().verifyLegalEntityIdentifierValueErrorMessageForMaxLength();
    }

    @Then("the user should see the error message $errorMsg for the identifier value field")
    public void verifyIdentifierValueErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditLegalEntityPage().verifyIdentifierValueErrorMessage("legalEntity_identifier_value_error_msg_xpath", errorMsg);
    }

    @Then("the user verifies the identifier value maxlength is $maxSize for the $rowIdentifier")
        public void verifyMaxlengthIdentifierValueText(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditLegalEntityPage().verifyMaxlengthIdentifierValueText(maxSize,rowIdentifier);}

    @Then("the user should see the error message $errorMsg for the identifier status field")
    public void verifyIdentifierStatusErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditLegalEntityPage().verifyIdentifierStatusErrorMessage("legalEntity_identifier_status_error_msg_xpath", errorMsg);
    }

    @When("the user clicks on new row delete legal entity identifier button for the row $deletebutton_Row")
    public void clickonDeleteidentifierRowButton(String deletebutton_Row)
    {
        getEditLegalEntityPage().clickonDeleteidentifierRowButton(deletebutton_Row);
    }

    @Then("the user should see the error message $errorMsg for the identifier type field")
    public void verifyIdentifierTypeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditLegalEntityPage().verifyIdentifierTypeErrorMessage("legalEntity_identifier_type_error_msg_xpath", errorMsg);
    }
    @Then("the user should see the legal entity service values for fid <fid> in the $source document as <category><override><financialCategory><financialDetails>")
    public void verifyLegalEntityServiceValuesFromZeus(@Named("fid") String fid,@Named("source") String source,@Named("category") String category,@Named("override") String override,@Named("financialCategory") String financialCategory,@Named("financialDetails") String financialDetails){
        getEditLegalEntityPage().verifyLegalEntityServiceValuesFromZeus(fid,source,category,override,financialCategory,financialDetails);
    }

    @When("the user clicks on delete legal entity offered services button $rowIdentifier")
    @Alias("the user clicks on delete legal entity financial services button $rowIdentifier")
    public void clickServicesDeleteRowButton(String rowIdentifier){
        getEditLegalEntityPage().clickServicesDeleteRowButton(rowIdentifier);
    }

    @Then("the user should not see legal entity service values for fid <fid> in $source document as <category><override><financialCategory><financialDetails>")
    public void verifyLegalEntityServiceValuesNotExistInZeus(@Named("fid") String fid,@Named("source") String source,@Named("category") String category,@Named("override") String override,@Named("financialCategory") String financialCategory,@Named("financialDetails") String financialDetails){
        getEditLegalEntityPage().verifyLegalEntityServiceValuesNotExistInZeus(fid,source,category,override,financialCategory,financialDetails);
    }

    @Then("the user should see the ownership type values for $rowIdentifier from lookup $lookup")
    public void verifyOwnershipTypeFromLookup(@Named("rowIdentifier") String rowIdentifier,@Named("lookup") String lookup){
        getEditLegalEntityPage().verifyOwnershipTypeFromLookup(rowIdentifier,lookup);
    }
    @When("the user clicks on add new ownership summaries button")
    public void clickAddNewOwnershipButton(){
        getEditLegalEntityPage().clickAddNewOwnershipButton();
    }

    @Then("the user should see the ownership summary values as in $source document with fid <fid>")
    public void verifyOwnershipSummaryFromTrusted(@Named("source") String source,@Named("fid") String fid)
    {
        getEditLegalEntityPage().verifyOwnershipSummaryFromTrusted(source,fid);
    }
    @When("the user selects ownership type as <ownershipType> from $rowIdentifier in the legalentity page")
    public void selectOwnershipType(@Named("ownershipType") String ownershipType,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().selectOwnershipType(ownershipType,rowIdentifier);
    }
    @When("the user enters ownership value as <value> for $rowIdentifier")
        public void enterOwnershipValue(@Named("value") String value,@Named("rowIdentifier") String rowIdentifier)
    {
        getEditLegalEntityPage().enterOwnershipValue(value,rowIdentifier);
    }

    @Then("the user should see ownership summary values as <ownershipType><value> for fid <fid> in $source document")
    public void verifyOwnershipSummaryFromZeus(@Named("ownershipType") String ownershipType,@Named("value") String value,@Named("fid") String fid,@Named("source") String source)
    {
        getEditLegalEntityPage().verifyOwnershipSummaryFromZeus(ownershipType,value,fid,source);
    }

    @When("the user clicks on the delete button $rowIdentifier in the legal entity ownership summary section")
    public void clickOnDeleteOwnershipSummaryButton(String rowIdentifier) {
        getEditLegalEntityPage().clickOnDeleteOwnershipSummaryButton(rowIdentifier);
    }
    @Then("the user should not see ownership summary values for fid <fid> in $source document as: $ownershipSummaries")
    public void verifyOwnershipSummaryValuesNotExistInZEUS(@Named("fid") String fid,@Named("source") String source,@Named("ownershipSummaries") ExamplesTable ownershipSummaries) {
        getEditLegalEntityPage().verifyOwnershipSummaryValuesNotExistInZEUS(fid,source,ownershipSummaries);
    }

    @Then("the user should see the ownership summary text area maxlength as $maxlength characters for the $rowIdentifier")

    public void verifyOwnershipSummaryValueMaxLength(@Named("maxlength") String maxlength,@Named("rowIdentifier") String rowIdentifier) {
        getEditLegalEntityPage().verifyOwnershipSummaryValueMaxLength(maxlength,rowIdentifier);
    }

    @Then("the user should see the error message $reqMsg for the ownership summary field $rowIdentifier")
    public void verifyRequiredErrorMsgForOwnershipSummary(@Named("reqMsg") String reqMsg,@Named("rowIdentifier") String rowIdentifier){
        getEditLegalEntityPage().verifyRequiredErrorMsgForOwnershipSummary(reqMsg,rowIdentifier);
    }

    @When("the user deletes all the existing ownership summary rows")
    public void deleteAllLegalEntityRows(){getEditLegalEntityPage().deleteAllLegalEntityRows(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_ownership_summary_delete_button"));}

    @Then("the user should not see the new offered services row with $rowIdentifier")
    @Alias("the user should not see the new financial services row with $rowIdentifier")
    public void verifyNoNewServicesRow(String rowIdentifier) {
        getEditLegalEntityPage().verifyNoNewServicesRow(rowIdentifier);

    }

    @Then("the user should see the $reqMsg message for offered service category field")
    public void verifyRequiredMessageForServiceCategory(@Named("reqMsg") String reqMsg)
    {
        getEditLegalEntityPage().verifyRequiredMessage(reqMsg,"legalEntity_entity_offeredservices_category_required_error_msg");
    }

    @Then("the user should see the $reqMsg message for financial details field")
    public void verifyRequiredMessageForFinancialDetails(@Named("reqMsg") String reqMsg)
    {
        getEditLegalEntityPage().verifyRequiredMessage(reqMsg,"legalEntity_entity_financialdetails_required_error_msg");
    }


    @Then("the user verifies the override value maxlength is $maxlength for the row $rowIdentifier")
    public void verifyMaxLengthForOverrideTextField(@Named("maxlength") String maxlength,@Named("rowIdentifier") String rowIdentifier)
    {getEditLegalEntityPage().verifyMaxLengthForOverrideTextField(maxlength,rowIdentifier);}

    @When("the user selects agency type $agencyTypeRowIdentifier value as <type>")
    public void selectCreditRatingsAgencyType(@Named("agencyTypeRowIdentifier") String agencyTypeRowIdentifier,@Named("type") String type)
    {getEditLegalEntityPage().selectCreditRatingsAgencyType(agencyTypeRowIdentifier,type);
    }
    @When("the user enters agency value $agencyValueRowIdentifier value as <value>")
    public void enterCreditRatingsAgencyValue(@Named("agencyValueRowIdentifier") String agencyValueRowIdentifier,@Named("value") String value)
    {
        getEditLegalEntityPage().enterCreditRatingsAgencyValue(agencyValueRowIdentifier,value);
    }
    @When("the user enters agency AppliedDate day $agencyAppliedDateDayRowIdentifier value as <AppliedDateDay>")
    public void enterCreditRatingsAgencyAppliedDateDay(@Named("agencyAppliedDateDayRowIdentifier") String agencyAppliedDateDayRowIdentifier,@Named("AppliedDateDay") String AppliedDateDay)
    {
        getEditLegalEntityPage().enterCreditRatingsAgencyAppliedDateDay(agencyAppliedDateDayRowIdentifier,AppliedDateDay);
    }
    @When("the user selects agency AppliedDate month $agencyAppliedDateMonthRowIdentifier value as <AppliedDateMonth>")
    public void selectCreditRatingsAgencyAppliedDateMonth(@Named("agencyAppliedDateMonthRowIdentifier") String agencyAppliedDateMonthRowIdentifier,@Named("AppliedDateMonth") String AppliedDateMonth)
    {
        getEditLegalEntityPage().selectCreditRatingsAgencyAppliedDateMonth(agencyAppliedDateMonthRowIdentifier,AppliedDateMonth);
    }
    @When("the user enters agency AppliedDate year $agencyAppliedDateYearRowIdentifier value as <AppliedDateYear>")
    public void enterCreditRatingsAgencyAppliedDateYear(@Named("agencyAppliedDateYearRowIdentifier") String agencyAppliedDateYearRowIdentifier,@Named("AppliedDateYear") String AppliedDateYear)
    {
        getEditLegalEntityPage().enterCreditRatingsAgencyAppliedDateYear(agencyAppliedDateYearRowIdentifier,AppliedDateYear);
    }
    @When("the user enters agency ConfirmedDate day $agencyConfirmedDateDayRowIdentifier value as <ConfirmedDateDay>")
    public void enterCreditRatingsAgencyConfirmedDateDay(@Named("agencyConfirmedDateDayRowIdentifier") String agencyConfirmedDateDayRowIdentifier,@Named("ConfirmedDateDay") String ConfirmedDateDay)
    {
        getEditLegalEntityPage().enterCreditRatingsAgencyConfirmedDateDay(agencyConfirmedDateDayRowIdentifier,ConfirmedDateDay);
    }
    @When("the user selects agency ConfirmedDate month $agencyConfirmedDateMonthRowIdentifier value as <ConfirmedDateMonth>")
    public void selectCreditRatingsAgencyConfirmedDateMonth(@Named("agencyConfirmedDateMonthRowIdentifier") String agencyConfirmedDateMonthRowIdentifier,@Named("ConfirmedDateMonth") String ConfirmedDateMonth)
    {
        getEditLegalEntityPage().selectCreditRatingsAgencyConfirmedDateMonth(agencyConfirmedDateMonthRowIdentifier,ConfirmedDateMonth);
    }
    @When("the user enters agency ConfirmedDate year $agencyConfirmedDateYearRowIdentifier value as <ConfirmedDateYear>")
    public void enterCreditRatingsAgencyConfirmedDateyear(@Named("agencyConfirmedDateYearRowIdentifier") String agencyConfirmedDateYearRowIdentifier,@Named("ConfirmedDateYear") String ConfirmedDateYear)
    {
        getEditLegalEntityPage().enterCreditRatingsAgencyConfirmedDateyear(agencyConfirmedDateYearRowIdentifier,ConfirmedDateYear);
    }

    @When("the user clicks on delete legal entity credit rating row button for the row $deletebutton_Row")
    public void clickonDeleteCreditRatingsRowButton(String deletebutton_Row)
    {
        getEditLegalEntityPage().clickonDeleteCreditRatingsRowButton(deletebutton_Row);
    }
    @Then("the user verifies the credit ratings value maxlength is $maxSize for the row $rowIdentifier")
    public void verifyMaXlengthCreditRatingsValueText(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditLegalEntityPage().verifyMaxLengthCreditRatingsValueText(maxSize,rowIdentifier);}

    @Then("the user should see the error message $errorMsg for the credit ratings agency value field")
    public void verifyCreditRatingsAgencyValueErrorMessage(@Named("errorMsg") String errorMsg)
    {
        getEditLegalEntityPage().verifyCreditRatingsErrorMessage("legalEntity_creditRating_value_error_msg_xpath",errorMsg);
    }

    @Then("the user should see the error message $errorMsg for the credit ratings agency type field")
    public void verifyCreditRatingsAgencyTypeErrorMessage(@Named("errorMsg") String errorMsg)
    {
        getEditLegalEntityPage().verifyCreditRatingsErrorMessage("legalEntity_creditRating_type_error_msg_xpath",errorMsg);
    }

    @Then("the user should see the error message $errorMsg for the credit ratings agency name field")
    public void verifyCreditRatingsAgencyNameErrorMessage(@Named("errorMsg") String errorMsg)
    {
        getEditLegalEntityPage().verifyCreditRatingsErrorMessage("legalEntity_creditRating_agency_error_msg_xpath",errorMsg);
    }
    @Then("the user should see the error $appliedDateErrorMsg for Applied date")
    public void verifyAppliedDateErrorMessage(@Named("appliedDateErrorMsg") String appliedDateErrorMsg) {
        getEditLegalEntityPage().verifyAppliedDateErrorMessage(appliedDateErrorMsg);
    }

    @Then("the user should see the error $confirmedDateErrorMsg for Confirmed date")
    public void verifyConfirmedDateErrorMessage(@Named("confirmedDateErrorMsg ") String confirmedDateErrorMsg) {
        getEditLegalEntityPage().verifyConfirmedDateErrorMessage(confirmedDateErrorMsg);
    }


    @When("the user clicks on delete legal entity board meetings row button for the row $deletebutton_Row")
    public void clickonDeleteBoardMeetingsRowButton(String deletebutton_Row)
    {
        getEditLegalEntityPage().clickonDeleteBoardMeetingsRowButton(deletebutton_Row);
    }
    @Then("the user should see the trust power values as in $source document with fid <fid> in edit mode")
    public void verifyTrustPowersInEditModeFromTrusted(@Named("source") String source,@Named("fid") String fid){
        getEditLegalEntityPage().verifyTrustPowersInEditModeFromTrusted(source, fid);
    }

    @When("the user selects the trust powers granted value as <grantedValue>")
    public void selectTrustPowersGrantedValue(@Named("grantedValue") String grantedValue)
    {
        getEditLegalEntityPage().selectTrustPowersGrantedValue(grantedValue);
    }
    @When("the user selects the trust powers granted value as <grantedValue1>")
    public void selectTrustPowersGrantedValue1(@Named("grantedValue1") String grantedValue1)
    {
        getEditLegalEntityPage().selectTrustPowersGrantedValue(grantedValue1);
    }
    @When("the user selects the trust powers full value as <fullValue>")
    public void selectTrustPowersFullValue(@Named("fullValue") String fullValue)
    {
        getEditLegalEntityPage().selectTrustPowersFullValue(fullValue);
    }
    @When("the user selects the trust powers used value as <usedValue>")
    public void selectTrustPowersUsedValue(@Named("usedValue") String usedValue)
    {
        getEditLegalEntityPage().selectTrustPowersUsedValue(usedValue);
    }
    @When("the user enters the trust powers professional employees value as <profEmployees>")
    public void enterTrustPowersProfessionalValue(@Named("profEmployees") String profEmployees)
    {
        getEditLegalEntityPage().enterTrustPowersProfessionalValue(profEmployees);
    }
    @When("the user enters the trust powers admin employees value as <adminEmployees>")
    public void enterTrustPowersAdminEmployeesValue(@Named("adminEmployees") String adminEmployees)
    {
        getEditLegalEntityPage().enterTrustPowersAdminEmployeesValue(adminEmployees);
    }
    @When("the user enters the trust powers min account size value as <minacctSize>")
    public void enterTrustPowersMinAccountSize(@Named("minacctSize") String minacctSize)
    {
        getEditLegalEntityPage().enterTrustPowersMinAccountSize(minacctSize);
    }

    @Then("the user should see trust power values as <grantedValue><fullValue><usedValue><profEmployees><adminEmployees><minacctSize> for fid <fid> in $source document")
    public void verifyEditTrustPowerValuesInZeusDocument(@Named("grantedValue") String grantedValue,@Named("fullValue") String fullValue,
                                                         @Named("usedValue") String usedValue,@Named("profEmployees") String profEmployees,
                                                         @Named("adminEmployees") String adminEmployees,
                                                         @Named("minacctSize") String minacctSize,@Named("fid") String fid,
                                                         @Named("source") String source
                                                         ){
        getEditLegalEntityPage().verifyEditTrustPowerValuesInZeusDocument(grantedValue,fullValue,usedValue,profEmployees,adminEmployees,minacctSize,fid,source);
    }

    @Then("the user should see the other trust power fields in disabled state")
    public void verifyTrustPowerFieldsStatus(){
        getEditLegalEntityPage().verifyTrustPowerFieldsStatus();
    }
    @Then("the user should see the other trust power fields in enabled state")
    public void verifyTrustPowerFieldsEnabledStatus(){
        getEditLegalEntityPage().verifyTrustPowerFieldsEnabledStatus();
    }

    @Then("the user should see the $status trust power values same as in $source document with fid <fid> in edit mode")
    public void verifyDisabledTrustPowersFromTrusted(@Named("source") String source,@Named("fid") String fid){
        getEditLegalEntityPage().verifyDisabledTrustPowersFromTrusted(source, fid);
    }

    @Then("the user verifies the trust powers professional employees value maxlength is $maxSize")
    public void verifyMaxLengthForTrustedPowersProfessionalEmployees(String maxSize)
    {getEditLegalEntityPage().verifyMaxLengthForTrustedPowers("legalEntity_edit_trustpowers_professional_textbox",maxSize);

    }

    @Then("the user verifies the trust powers admin employees value maxlength is $maxSize")
    public void verifyMaxLengthForTrustedPowersAdminEmployees(String maxSize)
    {getEditLegalEntityPage().verifyMaxLengthForTrustedPowers("legalEntity_edit_trustpowers_admin_textbox",maxSize);

    }
    @Then("the user verifies the trust powers min account size value maxlength is $maxSize")
    public void verifyMaxLengthForTrustedPowersMinAcctSize(String maxSize)
    {
        getEditLegalEntityPage().verifyMaxLengthForTrustedPowers("legalEntity_edit_trustpowers_minAccountSize_textbox",maxSize);
    }

    @Then("the user should see the error message $errMsg for prof Employees field")
    public void verifyErrorMsgForprofEmployee(@Named("errMsg") String errMsg)
    {
        getEditLegalEntityPage().verifyErrorMsgForTrustPowers("legalEntity_trustPower_Professional_error_message_xpath",errMsg);
    }
    @Then("the user should see the error message $errMsg for prof Admin field")
    public void verifyErrorMsgForprofAdmin(@Named("errMsg") String errMsg)
    {
        getEditLegalEntityPage().verifyErrorMsgForTrustPowers("legalEntity_trustPower_admin_error_message_xpath",errMsg);
    }
    @Then("the user should see the error message $errMsg for min account size field")
    public void verifyErrorMsgForminAccountSize(@Named("errMsg") String errMsg)
    {
        getEditLegalEntityPage().verifyErrorMsgForTrustPowers("legalEntity_trustPower_MinAccountSize_error_message_xpath",errMsg);
    }


    @Then("the user should not see boardmeetings values for fid <fid> in $source document as: $boardMeetings")
    public void verifyEditLegalEntityBoardMeetingsValuesNotExistInZeus(@Named("boardMeetings") ExamplesTable boardMeetings,@Named("fid") String fid,@Named("source") String source)
    {
        getEditLegalEntityPage().verifyEditLegalEntityBoardMeetingsValuesNotExistInZeus(boardMeetings,fid,source);
    }

    @Then("the user should not see the board meeting row in the basic info legal entity page")
    public void verifyNewlyAddedBoardMeetingRowIsNotDisplayed() throws Exception {
        getEditLegalEntityPage().verifyNewlyAddedBoardMeetingRowIsNotDisplayed();
    }
    
    @Then("the user should see the legal entity's country of operations value same as in $source document")
	public void verifyCountryOfOperationsFromTrustedDB(@Named("fid") String fid, @Named("source") String source) {
		getEditLegalEntityPage().verifyCountryOfOperationsFromTrustedDB(fid, source, "value");
	}

	@Then("the user verifies that the country of operations value is sorted in alphabetical order")
	public void verifyCountryOfOperationsList(@Named("fid") String fid) {
		getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_edit_mode"));
		getEditLegalEntityPage().verifyLookUpValues("country list", "value", fid);
        getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_edit_mode"));
	}

	@When("the user enters <countryOfOperations> in the country of operations drop down")
	public void enterCountryOfOperationsDropDownValue(@Named("countryOfOperations") String countryOfOperations) {
		getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_edit_mode"));
		getDataPage().enterValueInTypeHeadDropDown(LegalEntityIdentifiers
				.getObjectIdentifier("legalEntity_country_of_operations_type_ahead"),countryOfOperations);
	}

	@Then("the user verifies the country of operations value in the legal entity basic info page")
	public void verifyCountryOfOperationsUIViewMode(@Named("countryOfOperations") String countryOfOperations) {
		if (countryOfOperations.equals("Unknown")) {
			countryOfOperations = "";
		}
		getDataPage().verifyWebElementText("Country Of Operations", 
				countryOfOperations, LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_view_mode"));
	}

	@Then("the user should see the successful update message at top of the legal entity page")
	public void verifySuccessfulUpdatedMessage() {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user should see the country of operations value same as in $source document")
	public void verifyCountryOfOperationsFromZeusDB(@Named("fid") String fid,
			@Named("countryOfOperations") String countryOfOperations, @Named("source") String source) {
		if (countryOfOperations.equals("Unknown")) {
			countryOfOperations = "";
		}
		getEditLegalEntityPage().verifyCountryOfOperationsFromZeusDB(fid, countryOfOperations, source, "value");
	}

	@Then("the user should see the error message $errorMessage for country of operations dropdown in the legal entity basic info page")
	public void verifyErrorMessageForCountryOfOperations(@Named("errorMessage") String errorMessage) {
		getDataPage().verifyWebElementText("Country Of Operations", errorMessage, LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_error_message"));
	}

	@Then("the user should see the warning message for legal entity's country of operations")
	public void verifyCountryOfOperationsWarningMessage() {
		getEditLegalEntityPage().verifyCountryOfOperationsWarningMessage();
	}

	@When("the user clicks on the No button for legal entity's country of operations warning message")
	public void clickOnWarningMessageNoButton() {
		getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_warning_message_no_button"));
	}

	@Then("the user should not see the newly added country of operations value in the legal entity basic info page")
	public void verifyCountryOfOperationsIsNotUpdated(@Named("countryOfOperations") String countryOfOperations) {
		getEditLegalEntityPage().verifyCountryOfOperationsIsNotUpdated(countryOfOperations);
	}

	@When("the user clicks on the Yes button for legal entity's country of operations warning message")
	public void clickOnWarningMessageYesButton() {
		getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_warning_message_yes_button"));
	}

	@Then("the user should see the newly added country of operations value in the legal entity basic info page")
	public void verifyEnteredCountryOfOperationsValueInUI(@Named("countryOfOperations") String countryOfOperations) {
		getDataPage().verifyWebElementText("Country Of Operations", countryOfOperations, 
				LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_edit_mode"));
	}
	
	@When("the user enters <countryOfOperations2> in the country of operations drop down")
	public void enterCountryOfOperationsDropDownValue2(@Named("countryOfOperations2") String countryOfOperations) {
		getDataPage().attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_edit_mode"));
		getDataPage().enterValueInTypeHeadDropDown(LegalEntityIdentifiers
				.getObjectIdentifier("legalEntity_country_of_operations_type_ahead"),countryOfOperations);
	}
	
	@Then("the user verifies the <countryOfOperations2> value in the legal entity basic info page")
	public void verifyCountryOfOperationsUIViewMode2(@Named("countryOfOperations2") String countryOfOperations) {
		if (countryOfOperations.equals("Unknown")) {
			countryOfOperations = "";
		}
		getDataPage().verifyWebElementText("Country Of Operations", 
				countryOfOperations, LegalEntityIdentifiers.getObjectIdentifier("legalEntity_country_of_operations_view_mode"));
	}
	
	@Then("the user should see the <countryOfOperations2> value same as in $source document")
	public void verifyCountryOfOperationsFromZeusDB2(@Named("fid") String fid,
			@Named("countryOfOperations2") String countryOfOperations, @Named("source") String source) {
		if (countryOfOperations.equals("Unknown")) {
			countryOfOperations = "";
		}
		getEditLegalEntityPage().verifyCountryOfOperationsFromZeusDB(fid, countryOfOperations, source, "value");
	}
    
  }