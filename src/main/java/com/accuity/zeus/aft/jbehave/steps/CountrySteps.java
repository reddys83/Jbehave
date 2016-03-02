package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CountrySteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    private String selectedCountry;

    @Then("the user should see the country type-ahead displayed")
    public void verifyCountryTypeAheadAndListBox() {
        getCountryPage().verifyCountryTypeAheadAndListBox();
    }

    @Then("the user should see the country's currencies as: $countryCurrencies")
    public void verifyCountryCurrencies(ExamplesTable countryCurrencies) {
        getCountryPage().verifyCountryCurrencies(countryCurrencies);
    }

    @Then("the user should see the list of all existing countries by full name")
    public void verifyCountryList() {
        getCountryPage().verifyCountryList(database, apacheHttpClient);
    }

    @When("the user starts typing the name of a country as $word in the country input box")
    public void enterValueInCountryTypeAhead(String word) {
        getCountryPage().enterValueInCountryTypeAhead(word);
    }

    @Then("the user should see the countries in the listbox as: $countryList")
    public void verifyCountriesInListBox(ExamplesTable countryList) {
        getCountryPage().verifyCountriesInListBox(countryList);
    }

    @Then("the user should see the country iso2 as $iso2")
    public void verifyCountryIso2(@Named("iso2") String iso2) {
        getCountryPage().verifyCountryIso2(iso2);
    }

    @Then("the user should see the country ISO2 not editable")
    public void verifyISO2NotEditable() {
        getCountryPage().verifyISO2NotEditable();
    }

    @Then("the user should see the country ISO3 not editable")
    public void verifyISO3NotEditable() {
        getCountryPage().verifyISO3NotEditable();
    }

    @Then("the user should see the country iso3 as $iso3")
    public void verifyCountryIso3(@Named("iso3") String iso3) {
        getCountryPage().verifyCountryIso3(iso3);
    }

    @Then("the user should see the edits to country basic info from trusted dcoument")
    public void verifyEditCountryBasicInfoFromTrusted(){
        getCountryPage().verifyEditCountryBasicInfoFromTrusted();
    }

    @When("the user clicks on replaced by drop down")
    public void clicksOnReplacedByDropdown() {
        getCountryPage().clicksOnReplacedByDropdown();
    }

    @Then("the user should see the list of all active countries except the country the user is currently editing")
    public void verifyReplacedByDropdownList() {
        getCountryPage().verifyReplacedByDropdownList();
    }

    @When("the user enters the begin date later than today")
    public void entersCountryBasicInfoStartDate() {
        getCountryPage().entersCountryBasicInfoStartDate();
    }

    @When("the user enters more than 500 characters in the country add info")
    public void enterInvalidCharactersInCountryAddInfo() {
        getCountryPage().enterInvalidCharactersInCountryAddInfo();
    }

    @When("the user enters country start year as <countryStartYear>")
    public void enterCountryStartYear(@Named("countryStartYear") String countryStartYear) {
        getCountryPage().enterCountryStartYear(countryStartYear);
    }

    @When("the user enters country end year as <countryEndYear>")
    public void enterCountryEndYear(@Named("countryEndYear") String countryEndYear) {
        getCountryPage().enterCountryEndYear(countryEndYear);
    }

    @When("the user selects replaced by country from the drop down as <countryReplacedBy>")
    public void enterCountryReplacedBy(@Named("countryReplacedBy") String countryReplacedBy) {
        getCountryPage().enterCountryReplacedBy(countryReplacedBy);
    }
    @When("the user enters country add info as <countryAddInfo>")
    public void enterCountryAddInfo(@Named("countryAddInfo") String countryAddInfo) {
        getCountryPage().enterCountryAddInfo(countryAddInfo);
    }
    @When("the user enters country imports as <countryImports>")
    public void enterCountryImports(@Named("countryImports") String countryImports){
        getCountryPage().enterCountryImports(countryImports);
    }

    @When("the user enters country exports as <countryExports>")
    public void enterCountryExports(@Named("countryExports") String countryExports) {
        getCountryPage().enterCountryExports(countryExports);
    }
    @When("the user enters country political structure as <countryPoliticalStructure>")
    public void enterCountryPoliticalStructure(@Named("countryPoliticalStructure") String countryPoliticalStructure) {
        getCountryPage().enterCountryPoliticalStructure(countryPoliticalStructure);
    }
    @When("the user enters country intl dialing code as <countryIntlDialingCode>")
    public void enterCountryIntlDialingCode(@Named("countryIntlDialingCode") String countryIntlDialingCode) {
        getCountryPage().enterCountryIntlDialingCode(countryIntlDialingCode);
    }

    @When("the user enters more than 200 characters in the country exports")
    public void enterInvalidCharactersInCountryExports(){
        getCountryPage().enterInvalidCharactersInCountryExports();
    }

    @When("the user enters more than 200 characters in the country political structure")
    public void enterInvalidCharactersInCountryPoliticalStructure() {
        getCountryPage().enterInvalidCharactersInCountryPoliticalStructure();
    }

    @When("the user enters more than 5 characters inthe country intl dialing code")
    public void enterInvalidCharactersInCountryIntlDialingCode() {
        getCountryPage().enterInvalidCharactersInCountryIntlDialingCode();
    }

    @Then("the user should see the error message enter uptp 500 valid charecters for addinfo")
    public void verifyErrorMessageForAddInfo(){
        getCountryPage().verifyErrorMessageForAddInfo();
    }
    @Then("the user should see the error message enter upto 200 valid charecters for imports")
    public void verifyErrorMessageForImports() {
        getCountryPage().verifyErrorMessageForImports();
    }
    @Then("the user should see the error message enter upto 200 valid charecters for exports")
    public void verifyErrorMessageForExports() {
        getCountryPage().verifyErrorMessageForExports();
    }
    @Then("the user should see the error message enter upto 200 valid charecters for political structure")
    public void verifyErrorMessageForPoliticalStructure() {
        getCountryPage().verifyErrorMessageForPoliticalStructure();
    }
    @Then("the user should see the error message enter upto 5 valid charectes for intl dialing code")
    public void verifyErrorMessageForIntlDialingCode() {
        getCountryPage().verifyErrorMessageForIntlDialingCode();
    }

    @When("the user enters the end date later than today")
    public void entersCountryBasicInfoEndDate() {
        getCountryPage().entersCountryBasicInfoEndDate();
    }

    @When("the user enters more than 200 characters in the country imports")
    public void enterInvalidCharactersInCountryImports()
    {
        getCountryPage().enterInvalidCharactersInCountryImports();
    }

    @When("the user enters an another country $anotherCountry in the type-ahead box")
    public void enterAnotherCountryName(@Named("anotherCountry") String anotherCountry) {
        getDataPage().enterCountryInTheTypeAheadBox(anotherCountry);
    }

    @Then("the user should see the basic info for the selected country")
    public void verifyCountryBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the list of country's names type and value as: $countryNames")
    public void verifyCountryNames(ExamplesTable countryNames) {
        getDataPage().verifyNames(countryNames);
    }

    @When("the user clicks on the country basic info link in the navigation bar")
    public void clickOnBasicInfoInNavigationBar() {
        getCountryPage().clickOnBasicInfoInNavigationBar();
    }

    @When("the user clicks on the country regions link in the navigation bar")
    public void clickOnRegionsInNavigationBar() {
        getCountryPage().clickOnRegionsInNavigationBar();
    }

    @Then("the user should see the country's demographics info as: $countryDemographics")
    public void verifyCountryDemographics(ExamplesTable countryDemographics) {
        getCountryPage().verifyCountryDemographics(countryDemographics);
    }

    @Then("the user should see the country's identifiers as: $countryIdentifiers")
    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers) {
        getDataPage().verifyIdentifiers(countryIdentifiers);
    }

    @Then("the user should see the country's banking hours summary as $countryBankingHourSummary")
    public void verifyCountryBankingHourSummary(@Named("countryBankingHourSummary") String countryBankingHourSummary) {
        getCountryPage().verifyCountryBankingHourSummary(countryBankingHourSummary);
    }

    @Then("the user should see the country's banking hours as: $countryBankingHrSummary")
    public void verifyCountryBankingHourSummaryDaysAndHrs(ExamplesTable countryBankingHrSummary) {
        getCountryPage().verifyCountryBankingHourSummaryDaysAndHrs(countryBankingHrSummary);
    }

    @Then("the user should see the country's time zones summary as $countryTimeZonesSummary")
    public void verifyCountryTimeZonesSummary(@Named("countryTimeZonesSummary") String countryTimeZonesSummary) {
        getCountryPage().verifyCountryTimeZonesSummary(countryTimeZonesSummary);
    }

    @Then("the user should see the countries's replace by as $countryReplacedBy")
    public void verifyCountryReplaceByLabelValues(@Named("countryReplacedBy") String countryReplacedBy) {
        getDataPage().verifyReplaceByLabelValues(countryReplacedBy);
    }

    @Then("the user should see the country's time zones as: $countryTimeZones")
    public void verifyCountryTimeZones(ExamplesTable countryTimeZones) {
        getCountryPage().verifyCountryTimeZones(countryTimeZones);
    }

    @Then("the user should see the country summary as: $countrySummary")
    public void verifyCountrySummary(ExamplesTable countrySummary) {
        getCountryPage().verifyCountrySummary(countrySummary);
    }

    @When("the user clicks on the replaced by country <replacedByCountry> in the country basic info")
    public void clickOnReplacedByCountry(@Named("replacedByCountry") String replacedByCountry) {
        getCountryPage().clickOnReplacedByCountry(replacedByCountry);
    }

    @When("the user clicks on the country holidays link in the navigation bar")
    public void clickOnCountryHolidays() {
        getCountryPage().clickOnCountryHolidays();
    }

    @Then("the user should see the country's holidays list as: $countryHolidaysList")
    public void verifyCountryHolidays(ExamplesTable countryHolidaysList) {
        getCountryPage().verifyCountryHolidays(countryHolidaysList);
    }

    @Then("the user should not see the country's holidays list")
    public void verifyNoCountryHolidays() {
        getCountryPage().verifyNoCountryHolidays();
    }

    @When("the user clicks on the country payments link in the navigation bar")
    public void clickOnCountryPayments() {
        getCountryPage().clickOnCountryPayments();
    }

    @Then("the user should see the country's payments iban status as $status")
    public void verifyCountryPaymentsIbanStatus(@Named("status") String status) {
        getCountryPage().verifyCountryPaymentsIbanStatus(status);
    }

    @Then("the user should see the country's payments iban as: $countryPaymentsIban")
    public void verifyCountryPaymentsIban(ExamplesTable countryPaymentsIban) {
        getCountryPage().verifyCountryPaymentsIban(countryPaymentsIban);
    }

    @Then("the user should see the country's payments routing code types as: $countryPaymentsRoutingCodesTypes")
    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes) {
        getCountryPage().verifyCountryPaymentsRoutingCodesTypes(countryPaymentsRoutingCodesTypes);
    }

    @Then("the user should not see the country's payments iban")
    public void verifyCountryNoIbanInfo() {
        getCountryPage().verifyCountryNoIbanInfo();
    }

    @Then("the user should not see the country's payments routing codes types")
    public void verifyCountryNoRoutingCodeTypes() {
        getCountryPage().verifyCountryNoRoutingCodeTypes();
    }

    @Then("the user should see the country's alternative regions as: $countryRegions")
    public void verifyCountryRegions(ExamplesTable countryRegions) {
        getDataPage().verifyRegions(countryRegions);
    }

    @Then("the user should not see the country regions section")
    public void verifyNoCountryRegionsSection() {
        getDataPage().verifyNoCountryRegionsSection();
    }

    @Then("the user should not see the country holidays section")
    public void verifyNoCountryHolidaysSection() {
        getCountryPage().verifyNoCountryHolidaysSection();
    }

    @When("the user clicks on the country languages link in the navigation bar")
    public void clickOnCountryLanguages() {
        getCountryPage().clickOnCountryLanguages();
    }

    @Then("the user should see the country's languages list as $languages")
    public void verifyCountryLanguages(@Named("languages") String languages) {
        getCountryPage().verifyCountryLanguages(languages);
    }

    @When("the user clicks on the country credit rating link in the navigation bar")
    public void clickOnCountryCreditRating() {
        getCountryPage().clickOnCountryCreditRating();
    }

    @When("the user clicks on the country places link in the navigation bar")
    public void clickOnCountryPlaces() {
        getCountryPage().clickOnCountryPlaces();
    }

    @Then("the user should see the country's places as: $countryPlaces")
    public void verifyCountryPlaces(ExamplesTable countryPlaces) {
        getDataPage().verifyPlaces(countryPlaces);
    }

    @Then("the user should not see the country's places")
    public void verifyNoCountryPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @When("the user clicks on the country entity link in the navigation bar")
    public void clickOnCountryEntity() {
        getCountryPage().clickOnCountryEntity();
    }

    @When("the user clicks on the country people link in the navigation bar")
    public void clickOnCountryPeople() {
        getCountryPage().clickOnCountryPeople();
    }

    @Then("the user should see the country's entities as: $countryEntities")
    public void verifyCountryEntities(ExamplesTable countryEntities) {
        getDataPage().verifyEntities(countryEntities);
    }

    @Then("the user should see the country's people as: $countryPeople")
    public void verifyCountryPeople(ExamplesTable countryPeople) {
        getDataPage().verifyPeople(countryPeople);
    }

    @Then("the user should not see the country's entities")
    public void verifyNoCountryEntities() {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should not see the country's people")
    public void verifyNoCountryPeople() {
        getDataPage().verifyNoPeople();
    }

    @Then("the user should see the default country page and display all info")
    public void verifyCountryDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the below country sections $countrySections")
    public void verifyCountrySections(ExamplesTable countrySections){
        getDataPage().verifySections(countrySections);
    }

    @Then("the user should see the below fields in the country basic info left section $basicInfoLeftSection")
    public void verifyBasicInfoLeftSection(ExamplesTable basicInfoLeftSection) {
        getDataPage().verifyBasicInfoLeftSection(basicInfoLeftSection);
    }

    @When("the user clicks on the currencies link in the navigation bar")
    public void clickOnCountryCurrenciesLink() {
        getCountryPage().clickOnCountryCurrenciesLink();
    }

    @When("the user clicks on the country name type drop-down")
    public void clickOnCountryNameType(){
        getCountryPage().clickOnCountryNameType();
    }


    @When("the user clicks on the country Identifier type drop-down")
    public void clickOnCountryIdentifierType(){
        getCountryPage().clickOnCountryIdentifierType();
    }

    @Then("the user should see the country name types from lookup COUNTRY_NAME_TYPE")
    public void verifyCountryNameTypesList(){
        getCountryPage().verifyCountryNameTypesList();
    }

    @Then("the user should see the country identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO")
    public void verifyCountryIdentifierTypesList(){
        getCountryPage().verifyCountryIdentifierTypesList(database, apacheHttpClient);
    }

    @When("the user clicks on the add new name button in the basic info country page")
    public void clickOnAddNewNameButton(){
        getCountryPage().clickOnAddNewNameButton();
    }

    @When("the user clicks on the add new identifier button in the basic info country page")
    public void clickOnAddNewIdentifierButton(){
        getCountryPage().clickOnAddNewIdentifierButton();
    }

    @When("the user should see the default identifier status as active")
    public void assertIdentifierStatus(){
        getCountryPage().verifyIdentifierStatus();
    }

    @When("the user enters country name as <countryName> in the basic info country page")
    public void enterCountryName(@Named("countryName") String countryName){
        getCountryPage().enterCountryName(countryName);
    }


    @When("the user clears identifier value in the basic info country page")
    public void clearCountryIdentifierValue(){
        getCountryPage().clearCountryIdentifierValue();
    }

    @When("the user clears identifier type in the basic info country page")
    public void clearCountryIdentifierType(){
        getCountryPage().clearCountryIdentifierType();
    }

    @When("the user enters identifier type as <identifierType> in the basic info country page")
    public void enterIdentifierType(@Named("identifierType") String identifierType) {
        getCountryPage().enterIdentifierType(identifierType);
    }

    @When("the user enters identifier value as <identifierValueIncorrect> in the basic info country page")
    public void enterIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
        getCountryPage().enterIdentifierValue(incorrectIdentifierValue);
    }

    @Then("the user should see the error message for the required country name field in the basic info country page")
    public void verifyErrorMessageForCountryName(){
        getCountryPage().verifyErrorMessageForCountryName();
    }

    @Then("the user should see the error message for the required name type field in the basic info country page")
    public void verifyErrorMessageForRequiredNameType(){
        getCountryPage().verifyErrorMessageForRequiredNameType();
    }

    @When("the user clicks on the add new demographics button in the country basic info page")
    public void clickOnAddDemographicsButton() {
        getCountryPage().clickOnAddDemographicsButton();
    }

    @When("the user enters the demographic date later than today")
    public void entersDemographicDateLaterThanToday() {
        getCountryPage().entersDemographicDateLaterThanToday();
    }

    @Then("the user should see the error 'Must be no later than today.' for demographics date")
    public void veirfyDemograhicsDateErrorMessage() {
        getCountryPage().veirfyDemograhicsDateErrorMessage();
    }

    @Then("the user should see the error message required for the type and value fields")
    public void verifyRequiredErrorMessageForTypeAndValue() {
        getCountryPage().verifyRequiredErrorMessageForTypeAndValue();
    }

    @When("the user clicks on delete country demographics option")
    public void clickOnDeleteCountryDemographicsOption() {
        getCountryPage().clickOnDeleteCountryDemographicsOption();
    }

    @When("the user selects the demographic types <demographicType> in the country basic info page")
    public void selectsDemographicsTypesFromDropdown(@Named("demographicType") String demographicType) {
        getCountryPage().selectsDemographicsTypesFromDropdown(demographicType);
    }

    @When("the user enter the demographic value <demographicValue> in the country basic info page")
    public void entersDemographicsValue(@Named("demographicValue") String demographicValue) {
        getCountryPage().entersDemographicsValue(demographicValue);
    }

    @When("the user enter demographics day <day> in the demographics country page")
    public void entersDemographicsDay(@Named("day") String day) {
        getCountryPage().entersDemographicsDay(day);
    }

    @When("the user enter demographics month <month> in the demographics country page")
    public void entersDemographicsMonth(@Named("month") String month) {
        getCountryPage().entersDemographicMonth(month);
    }

    @When("the user enter demographics year <year> in the demographics country page")
    public void entersDemographicYear(@Named("year") String year) {
        getCountryPage().entersDemographicYear(year);
    }

    @Then("the user should not see the unit drop down for selected demographic type")
    public void verifyCountryDemographicsUnitDropdownNotExist(){
        getCountryPage().verifyCountryDemographicsUnitDropdownNotExist();
    }

    @Then("the user should see the unit drop down for selected demographic type")
    public void verifyCountryDemographicsDropdownExist(){
        getCountryPage().verifyCountryDemographicsDropdownExist();
    }

    @Then("the user should see the country demographics types from lookup DEMOGRAPHIC_METRIC")
    public void verifyCountryDemographicsTypeDropdownList() {
        getCountryPage().verifyCountryDemographicsTypeDropdownList();
    }

    @Then("the user should see the demographics units are from lookup UNIT_OF_MEASUREMENT")
    public void verifyCountryDemographicsUnitDropdownList() {
        getCountryPage().verifyCountryDemographicsUnitDropdownList();
    }

    @Then("the user should see the error message for the required Identifier Value field in the basic info identifier page")
    public void verifyErrorMessageForRequiredIdentifierValue() {
        getCountryPage().verifyErrorMessageForRequiredIdentifierValue();
    }

    @Then("the user should see the Enter up to 50 valid characters error message for the Identifier Value field in the basic info identifier page")
    public void verifyErrorMessageForLongIdentifierValue() {
        getCountryPage().verifyErrorMessageForLongIdentifierValue();
    }

    @Then("the user should see the error message for the required Identifier Type field in the basic info identifier page")
    public void verifyErrorMessageForRequiredIdentifierType() {
        getCountryPage().verifyErrorMessageForRequiredIdentifierType();
    }


    @Then("the user should see the error message for the required name value field in the basic info country page")
    public void verifyErrorMessageForRequiredValueType(){
        getCountryPage().verifyErrorMessageForRequiredValueType();
    }

    @When("the user clicks on the delete name row button in the basic info country page")
    @Alias("the user clicks on the delete time zone row button in the basic info country page")
    public void clickOnDeleteNewRowButton(){
        getCountryPage().clickOnDeleteNewRowButton();
    }

    @Then("the user should see the delete row confirmation modal in the country page")
    public void verifyDeleteConfirmationModal(){
        getCountryPage().verifyDeleteConfirmationModal();
    }

    @When("the user clicks on the delete identifier row button in the basic info country page")
    public void clickOnDeleteNewIdentifierRowButton(){
        getCountryPage().clickOnDeleteNewRowButton();
    }

    @When("the user clicks on the no button in the delete row confirmation modal in the country page")
    public void clickOnNoButtonInDeleteConfirmationModal(){
        getCountryPage().clickOnNoButtonInDeleteConfirmationModal();
    }

    @When("the user clicks on the yes button in the delete row confirmation modal in the country page")
    public void clickOnYesButtonInDeleteConfirmationModal(){
        getCountryPage().clickOnYesButtonInDeleteConfirmationModal();
    }

    @Then("the user should see the newly added name row in the basic info country page")
    public void verifyNewlyAddedNameRowIsDisplayed(){
        getCountryPage().verifyNewlyAddedNameRowIsDisplayed();
    }

    @Then("the user should see the newly added time zone row in the basic info country page")
    public void verifyNewlyAddedTimeZoneRowIsDisplayed(){
        getCountryPage().verifyNewlyAddedTimeZoneRowIsDisplayed();
    }

    @Then("the user should not see the newly added name row in the basic info country page")
    public void verifyNewlyAddedNameRowIsNotDisplayed(){
        getCountryPage().verifyNewlyAddedNameRowIsNotDisplayed();
    }


    @Then("the user should not see the newly added identifier row in the basic info country page")
    public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {
        getCountryPage().verifyNewlyAddedIdentifierRowIsNotDisplayed();
    }

    @Then("the user should see the newly added identifier row in the basic info country page")
    public void verifyNewlyAddedIdentifierRowIsDisplayed() {
        getCountryPage().verifyNewlyAddedIdentifierRowIsDisplayed();
    }

    @Then("the user should not see the newly added time zone row in the basic info country page")
    public void verifyNewlyAddedTimeZoneRowIsNotDisplayed(){
        getCountryPage().verifyNewlyAddedTimeZoneRowIsNotDisplayed();
    }

    @Then("the user should see the error message enter up to 50 valid characters for country name value in the basic info country page")
    public void verifyCountryNameValueErrMsg(){
        getCountryPage().verifyCountryNameValueErrMsg();
    }

    @Then("the user should see the error message enter up to 100 valid characters for time zone summary in the basic info country page")
    public void verifyErrorMessageForTimeZoneSummary(){
        getCountryPage().verifyErrorMessageForTimeZoneSummary();
    }

    @When("the user enters time zones summary <timeZoneSummary> in the basic info country page")
    public void enterTimeZoneSummary(@Named("timeZoneSummary") String timeZoneSummary){
        getCountryPage().enterTimeZoneSummary(timeZoneSummary);
    }

    @When("the user clicks on the add new time zone button in the basic info country page")
    public void clickOnAddNewTimeZone(){
        getCountryPage().clickOnAddNewTimeZone();
    }

    @When("the user clicks on the select time zone list in the basic info country page")
    public void clickOnSelectTimeZone(){
        getCountryPage().clickOnSelectTimeZone();
    }

    @Then("the user should see the country time zones from lookup TIME_ZONE")
    public void verifyCountryTimeZoneSummary(){
        getCountryPage().verifyCountryTimeZoneSummary();
    }

    @When("the user enters holiday day <day> in the holidays country page")
    public void enterCountryHolidayDay(@Named("day") String day){
        getCountryPage().enterCountryHolidayDay(day);
    }

    @When("the user enters holiday month <month> in the holidays country page")
    public void enterCountryHolidayMonth(@Named("month") String month){
        getCountryPage().enterCountryHolidayMonth(month);
    }

    @When("the user enters holiday year <year> in the holidays country page")
    public void enterCountryHolidayYear(@Named("year") String year){
        getCountryPage().enterCountryHolidayYear(year);
    }

    @Then("the user should see the error message enter a day/month/year in the demographics country page")
    public void verifyErrorMsgForCountryDemographicsDate(){
        getCountryPage().verifyErrorMsgForCountryDemographicsDate();
    }

    @Then("the user should see the error message enter a day/month/year in the holidays country page")
    public void verifyErrorMsgForCountryHolidayDate() {
        getCountryPage().verifyErrorMessageForCountryHolidayDate();
    }

    @Then("the user should see the error message required for holiday date in the holidays country page")
    public void verifyErrorMsgRequiredForCountryHolidayDate(){
        getCountryPage().verifyErrorMsgRequiredForCountryHolidayDate();
    }

    @When("the user clicks on the add new holiday button in the holidays country page")
    public void clickOnAddNewCountryHolidayButton(){
        getCountryPage().clickOnAddNewCountryHolidayButton();
    }

    @When("the user enters holiday description <description> in the holidays country page")
    public void enterCountryHolidayDescription(@Named("description") String description){
        getCountryPage().enterCountryHolidayDescription(description);
    }

    @When("the user enters holiday notes <notes> in the holidays country page")
    public void enterCountryHolidayNotes(@Named("notes") String notes){
        getCountryPage().enterCountryHolidayNotes(notes);
    }

    @Then("the user should see the error message enter up to 100 valid characters for holiday description in the holidays country page")
    public void verifyCountryHolidaysDescriptionErrMsg(){
        getCountryPage().verifyCountryHolidaysDescriptionErrMsg();
    }

    @Then("the user should see the error message enter up to 100 valid characters for holiday notes in the holidays country page")
    public void verifyCountryHolidaysNotesErrMsg(){
        getCountryPage().verifyCountryHolidaysNotesErrMsg();
    }

    @Then("the user should see the newly added holiday row in the holiday country page")
    public void verifyNewlyAddedHolidayRow(){
        getCountryPage().verifyNewlyAddedHolidayRow();
    }

    @Then("the user should not see the newly added holiday row in the holiday country page")
    public void verifyNoNewlyAddedHolidayRow(){
        getCountryPage().verifyNoNewlyAddedHolidayRow();
    }

    @When("the user clicks on the delete holiday row button in the basic info country page")
    public void clickOnDeleteHolidayRowButton() {
        getCountryPage().clickOnDeleteNewRowButton();
    }

    @When("the user clicks on language option")
    public void clickOnLanguageLink(){
        getCountryPage().clickOnLanguageLink();
    }

    @When ("the user enters country languages as <countryLanguages> in the country language country page")
    public void enterLanguageSummary(@Named("countryLanguages") String countryLanguages){
        getCountryPage().enterSummaryLanguage(countryLanguages);
    }

    @Then("the user should see the error message enter upto 100 valid characters for the country language in the country page")
    public void verifyErrorMsgForCountryLanguage(){
        getCountryPage().verifyErrorMsgForCountryLanguage();
    }

    @When("the user clicks on the add country banking hours option")
    public void userClicksOnTheAddCountryBankingHours(){
        getCountryPage().userClicksOnTheAddCountryBankingHours();
    }

    @When("the user clicks on delete country banking hours option")
    public void userClicksOnDeleteCountryBankingHours(){
        getCountryPage().userClicksOnDeleteCountryBankingHours();
    }

    @Then("the user should see a new row with day drop-down list with all days and hours with values in half hour increments")
    public void verifyUserSeesBankingDaysAndHours(){
        getCountryPage().verifyUserSeeBankingDaysAndHours();
    }

    @Then("the user should see a new row with day drop-down list with all days except the day which is already existing and hours with values in half hour increments")
    public void verifyBankingHoursExceptExistingHours(){
        getCountryPage().verifyBankingHoursExceptExistingHours();
    }


    @When("the user enters applied date year <appliedYear> in the credit rating country page")
    public void enterCreditRatingAppliedYear(@Named("appliedYear") String appliedYear) {
        getCountryPage().enterCreditRatingAppliedYear(appliedYear);
    }

    @Then ("the user should see the error message must be no later than today for applied date in the credit rating country page")
    public void verifyErrMustBeNoLaterThanTodayForAppliedDate(){
        getCountryPage().verifyErrMustBeNoLaterThanTodayForAppliedDate();
    }

    @When("the user enters confirmed date year <confirmedYear> in the credit rating country page")
    public void enterConfirmedYear(@Named("confirmedYear") String confirmedYear){
        getCountryPage().enterCreditRatingConfirmedYear(confirmedYear);
    }

    @Then("the user should see the error message must be no later than today for confirmed date in the credit rating country page")
    public void verifyErrMustBeNoLaterThanTodayForConfirmedDate(){
        getCountryPage().verifyErrMustBeNoLaterThanTodayForConfirmedDate();
    }

    @Then("the user should see required error message for the credit rating confirmed date in the credit rating country page")
    public void verifyCreditRatingConfirmedDateRequiredErrorMessagae(){
        getCountryPage().verifyCreditRatingConfirmedDateRequiredErrorMessage();
    }

    @When("the user clicks on add new credit rating button in the credit rating country page")
    public void clickOnAddButton(){
        getCountryPage().clickAddRowButton();
    }

    @Then ("the user clicks on the delete credit rating row button in the basic info country page")
    public void clickOnDeleteCreditRatingButton(){
        getCountryPage().clickOnDeleteCreditRatingButton();
    }

    @Then("the user should see the newly added credit rating row in the credit rating country page")
    public void verifyNewlyAddedCreditRatingRow(){
        getCountryPage().verifyNewlyAddedCreditRatingRow();
    }

    @Then("the user should not see the newly added credit rating row in the credit rating country page")
    public void verifyNoNewlyAddedCreditRatingRow(){
        getCountryPage().verifyNoNewlyAddedCreditRatingRow();
    }

    @Then("the user enters credit rating value <value> in the credit rating country page")
    public void enterCreditRatingValue(@Named("value")String value){
        getCountryPage().enterCreditRatingValue(value);
    }

    @Then("the user should see the error message enter upto 5 valid characters in the credit rating country page")
    public void verifyErrorMessageForValidCharacters(){
        getCountryPage().verifyErrorMessageForValidCharacters();
    }

    @Then ("the user should see the error message enter a year, month/year or day/month/year for applied date in the credit rating country page")
    public void verifyErrorMessageEnterYearMonthDayForAppliedDate(){getCountryPage().verifyErrorMessageEnterYearMonthDayForAppliedDate();}

    @Then("the user should not see the cancel update confirmation modal in the country page")
    public void verifyNoCountryCancelUpdateConfirmationModal(){
        getDataPage().verifyNoCancelUpdateConfirmationModal();
    }

    @Then("the user should see the cancel update confirmation modal in the country page")
    public void verifyCountryCancelUpdateConfirmationModal(){
        getDataPage().verifyCancelUpdateConfirmationModal();
    }

    @Then("the user should return to edit country page mode")
    public void verifyCountryEditPageMode(){
        getCountryPage().verifyCountryEditPageMode();
    }

    @When("the user enters applied date day <appliedDay> in the credit rating country page")
    public void enterCountryCreditRatingAppliedDateDay(@Named("appliedDay") String appliedDay){
        getCountryPage().enterCountryCreditRatingAppliedDateDay(appliedDay);
    }

    @When("the user selects applied date month <appliedMonth> in the credit rating country page")
    public void enterCountryCreditRatingAppliedDateMonth(@Named("appliedMonth") String appliedMonth){
        getCountryPage().enterCountryCreditRatingAppliedDateMonth(appliedMonth);
    }

    @When("the user selects confirmed date month <confirmedMonth> in the credit rating country page")
    public void enterCountryCreditRatingConfirmedDateMonth(@Named("confirmedMonth") String confirmedMonth){
        getCountryPage().enterCountryCreditRatingConfirmedDateMonth(confirmedMonth);
    }

    @When("the user enters confirmed date day <confirmedDay> in the credit rating country page")
    public void enterCountryCreditRatingConfirmedDateDay(@Named("confirmedDay") String confirmedDay){
        getCountryPage().enterCountryCreditRatingConfirmedDateDay(confirmedDay);
    }

    @Then ("the user should see the error message enter a year, month/year or day/month/year for confirmed date in the credit rating country page")
    public void verifyErrorMessageEnterYearMonthDayForConfirmedDate(){getCountryPage().verifyErrorMessageEnterYearMonthDayForConfirmedDate();}

    @When("the user enters iban registered day <day> in the payments country page")
    public void enterIBANRegisteredDay(@Named("day") String day) {
        getCountryPage().enterIBANRegisteredDay(day);
    }

    @When("the user selects iban registered month <month> in the payments country page")
    public void selectIBANRegisteredMonth(@Named("month") String month) {
        getCountryPage().selectIBANRegisteredMonth(month);
    }

    @When("the user enters iban registered year <year> in the payments country page")
    public void enterIBANRegisteredYear(@Named("year") String year) {
        getCountryPage().enterIBANRegisteredYear(year);
    }

    @Then("the user should see the error message enter a year, month/year or day/month/year for country payments in the country page")
    public void verifyErrorMsgForCountryPaymentsRegisteredDate() {
        getCountryPage().verifyErrorMsgForCountryPaymentsRegisteredDate();
    }

    @When("the user clicks on the country payments iban routing code types in the country page")
    public void clickOnIBANRoutingCodeTypes() {
        getCountryPage().clickOnIBANRoutingCodeTypes();
    }

    @Then("the user should see the iban routing code type drop-down lists values alphabetically from lookup ROUTING_CODE_TYPE")
    public void verifyIBANRoutingCodeTypes() {
        getCountryPage().verifyIBANRoutingCodeTypes();
    }

    @When("the user clicks on the country payments routing code types in the country page")
    public void clickOnRoutingCodeTypes() {
        getCountryPage().clickOnRoutingCodeTypes();
    }

    @Then("the user should see the routing code type drop-down lists values alphabetically from lookup ROUTING_CODE_TYPE")
    public void verifyRoutingCodeTypes() {
        getCountryPage().verifyRoutingCodeTypes();
    }

    @When("the user clicks on the country payments iso code in the country page")
    public void clickOnCountryPaymentsIsoCode(){
        getCountryPage().clickOnCountryPaymentsIsoCode();
    }

    @Then("the user should see the iban country iso2 code drop-down list sorted alphabetically in the country page")
    public void verifyCountryPaymentsIso2List(){
        getCountryPage().verifyCountryPaymentsIso2List();
    }

    @Then("the user should see the country payments iban info from trusted document")
    public void verifyCountryIBANInfoFromTrusted(){
        getCountryPage().verifyCountryIBANInfoFromTrusted(database, apacheHttpClient);
    }

    @Then("the user should see the country payments routing code types from trusted document")
    public void verifyCountryRoutingCodeTypesFromTrusted(){
        getCountryPage().verifyCountryRoutingCodeTypesFromTrusted(database, apacheHttpClient);
    }

    @When("the user clicks on the add new iban button in the payments country page")
    public void clickOnAddNewIBANButton(){
        getCountryPage().clickOnAddNewIBANButton();
    }

    @When("the user clicks on the add new routing code button in the payments country page")
    public void clickOnAddNewRoutingCodeButton(){
        getCountryPage().clickOnAddNewRoutingCodeButton();
    }

    @When("the user clicks on the delete iban row button in the basic info country page")
    public void clickOnDeleteIBANRowButton() {
        getCountryPage().clickOnDeleteNewRowButton();
    }

    @When("the user clicks on the delete routing code row button in the basic info country page")
    public void clickOnDeleteRoutingCodeRowButton() {
        getCountryPage().clickOnDeleteNewRowButton();
    }

    @Then("the user should see the newly added iban row in the holiday country page")
    public void verifyNewlyAddedIBANRow() {
        getCountryPage().verifyNewlyAddedIBANRow();
    }

    @Then("the user should not see the newly added iban row in the holiday country page")
    public void verifyNoNewlyAddedIBANRow(){
        getCountryPage().verifyNoNewlyAddedIBANRow();
    }

    @Then("the user should see the newly added routing code row in the holiday country page")
    public void verifyNewlyAddedRoutingCodeRow() {
        getCountryPage().verifyNewlyAddedRoutingCodeRow();
    }

    @Then("the user should not see the newly added routing code row in the holiday country page")
    public void verifyNoNewlyAddedRoutingCodeRow(){
        getCountryPage().verifyNoNewlyAddedRoutingCodeRow();
    }
}