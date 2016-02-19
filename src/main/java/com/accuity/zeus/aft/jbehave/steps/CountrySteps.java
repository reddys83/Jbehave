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

    @Then("the user should see the country iso3 as $iso3")
    public void verifyCountryIso3(@Named("iso3") String iso3) {
        getCountryPage().verifyCountryIso3(iso3);
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

    @Then("the user should see the country name types from lookup COUNTRY_NAME_TYPE")
    public void verifyCountryNameTypesList(){
        getCountryPage().verifyCountryNameTypesList(database, apacheHttpClient);
    }

    @When("the user clicks on the add new name button in the basic info country page")
    public void clickOnAddNewNameButton(){
        getCountryPage().clickOnAddNewNameButton();
    }

    @When("the user enters country name as <countryName> in the basic info country page")
    public void enterCountryName(@Named("countryName") String countryName){
        getCountryPage().enterCountryName(countryName);
    }

    @Then("the user should see the error message for the required country name field in the basic info country page")
    public void verifyErrorMessageForCountryName(){
        getCountryPage().verifyErrorMessageForCountryName();
    }

    @Then("the user should see the error message for the required name type field in the basic info country page")
    public void verifyErrorMessageForRequiredNameType(){
        getCountryPage().verifyErrorMessageForRequiredNameType();
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

    @Then("the user should see the error message enter a day/month/year in the holidays country page")
    public void verifyErrorMsgForCountryHolidayDate(){
        getCountryPage().verifyErrorMsgForCountryHolidayDate();
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
    public void enterLanguageSummary(@Named("summary")String summary){
        getCountryPage().enterSummaryLanguage(summary);
    }

    @Then("the user should see the error message enter upto 100 valid characters for the country language in the country page")
    public void verifyErrorMsgForCountryLanguage(){
        getCountryPage().verifyErrorMsgForCountryLanguage();
    }

    @When("the user clicks on the add country banking hours option")
    public void userClicksOnTheAddCountryBankingHours(){
        getCountryPage().userClicksOnTheAddCountryBankingHours();
    }

    @Then("the user should see a new row with day drop-down list with all days and hours with values in half hour increments")
    public void verifyUserSeesBankingDaysAndHours(){
        getCountryPage().verifyUserSeeBankingDaysAndHours();
    }

}
