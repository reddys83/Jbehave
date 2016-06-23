package com.accuity.zeus.aft.jbehave.steps;


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
        getEditLegalEntityPage().verifyEditLegalEntityEntityTypeValueFromZeus(entityTypeValue,"type",fid,source);
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

    @When("the user selects value <value> in the legalEntity board meeting for $webElement")
    public void selectsValueInLegalEntityBoardMeeting(@Named("value") String value, @Named("webElement") String webElement){
        getEditLegalEntityPage().selectsValueInLegalEntityBoardMeeting(value,webElement);
    }

    @Then("the user should see the legalentity's location summary type values from lookup LOCATION_SUMMARY_TEXT_TYPE")
    public void verifyLegalEntityLocationsTypeValues() {
        getEditLegalEntityPage().verifyLegalEntityLocationsTypeValues();
    }

    @When("the user clicks on the add new location summary button in legalentity location")
    public void clickNewLegalEntityLocations() {
        getEditLegalEntityPage().clickNewLegalEntityLocations();
    }

    @When("the user clicks on the add new board meeting button in legalEntity")
    public void clickNewLegalEntityBoardMeetings() {
        getEditLegalEntityPage().clickNewLegalEntityBoardMeetings();
    }

    @When("the user select type as <type> in the legalentity location summary")
    public void selectsTypeInLegalEntityLocationSummary(@Named("type") String type){
        getEditLegalEntityPage().selectsTypeInLegalEntityLocationSummary(type);
    }

    @Then("the user should see the edits to legal entity location summary for fid <fid> in zeus document")
    public void verifyLegalEntityLocationSummaryInZeusDocument(@Named("fid") String fid) {
        getEditLegalEntityPage().verifyLegalEntityLocationSummaryInZeusDocument(fid);
    }

    @Then("the user should see the edits to legal entity board meeting for fid <fid> in zeus document")
    public void verifyLegalEntityBoardMeetingInZeusDocument(@Named("") String fid) {
        getEditLegalEntityPage().verifyLegalEntityBoardMeetingInZeus(fid);
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

    @Then("the user should see the error message enter up to 10000 valid characters for value in the legalentity location")
    public void verifyErrorMessageForInvalidCharacter() {
        getEditLegalEntityPage().verifyErrorMessageForInvalidCharacter();
    }

    @Then("the user should see the error message enter up to 10000 valid characters for summary in legalentity boardMeeting")
    public void verifyErrorMessageForLegalEntitySummaryBoardMeeting() {
        getEditLegalEntityPage().verifyErrorMessageForLegalEntitySummaryBoardMeeting();
    }

    @Then("user should see the duplicate error message for value dropdown in legalEntity board meeting")
    public void verifyDuplicateErrorMessageForLegalEntityBoardMeeting() {
        getEditLegalEntityPage().verifyDuplicateErrorMessageForLegalEntityBoardMeeting();
    }

    @When("the user enters value as <value> in the legalentity location summary")
    public void entersLegalEntityValueInLocationSummary(@Named("value") String value){
        getEditLegalEntityPage().entersLegalEntityValueInLocationSummary(value);
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

    @Then("the user should see the legal entity service values as in $source document with fid <fid>")
    public void verifyLegalEntityServiceValuesFromTrusted(@Named("fid") String fid,@Named("source") String source){
        getEditLegalEntityPage().verifyLegalEntityServiceValuesFromTrusted(fid,source);
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
}
