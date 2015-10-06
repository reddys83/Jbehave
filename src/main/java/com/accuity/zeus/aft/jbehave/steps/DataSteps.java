package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

@Component
public class DataSteps extends AbstractSteps {

    @When("the user clicks on the currency tab in the data area")
    public void whenUserClicksOnCurrencyTab(){
        getDataPage().clickOnCurrencyTab();
    }

    @When("the user clicks on the country tab in the data area")
    public void userClicksOnCountryTab(){
        getDataPage().clickOnCountryTab();
    }

    @When("the user clicks on the area tab in the data area")
    public void userClicksOnAreaTab() {
        getDataPage().clickOnAreaTab();
    }

    @When("the user clicks on the choose a currency option")
    public void whenUserClicksOnChooseACurrency(){
        getDataPage().clickOnChooseACurrencyOption();
    }

    @Then("the user should see the list of all existing currencies by full name")
    public void thenUserShouldSeeListOfAllCurrencies(){
        getDataPage().verifyCurrencyList();
    }

    @When("the user starts typing the name of a currency as $curr in the currency input box")
    public void whenTheUserStartsTypingCurrency(@Named("curr") String curr){
        getDataPage().enterCurrency(curr);
    }

    @Then("the user should see the drop-down list of the currencies matching the input characters")
    public void thenUserShouldSeeCurrencyDropDownMatchingTheSearchString(){
        getDataPage().verifyCurrencyDropDownMatchesSearchString();
    }

    @Then("the user should see the option no results match for the searched currency string")
    public void thenTheUSerShouldNoResultsMatchOption(){
        getDataPage().verifyNoResultsMatchOption();
    }

    @When("the user enters the currency <currency> in the typeahead box")
    public void whenTheUserSelctsTheCurrecny(@Named("currency") String currency){
        getDataPage().selectCurrencyFromTypeAhead(currency);
    }

    @When("the user enters the currency $currency in the typeahead box")
    public void whenUserEntersCurrency(String currency){
        getDataPage().selectCurrencyFromTypeAhead(currency);
    }

    @Then("the user should see the currency iso code value as <isoCode>")
    public void thenTheUserShouldSeeCurrencyIsoCode(@Named("isoCode") String isoCode){
        getDataPage().verifyCurrencyIsoCode(isoCode);
    }

    @Then("the user should see the currency name value as <name>")
    public void thenTheUserShouldSeeCurrencyName(@Named("name") String name){
        getDataPage().verifyCurrencyName(name);
    }

    @Then("the user should see the currency abbr value as <abbr>")
    public void thenTheUserShouldSeeCurrencyAbbr(@Named("abbr") String abbr){
        getDataPage().verifyCurrencyAbbr(abbr);
    }

    @Then("the user should see the currency unit value as <unit>")
    public void thenTheUserShouldSeeCurrencyUnit(@Named("unit") String unit){
        getDataPage().verifyCurrencyUnit(unit);
    }

    @Then("the user should see the currency quantity value as <quantity>")
    public void thenTheUserShouldSeeCurrencyQuantity(@Named("quantity") String quantity){
        getDataPage().verifyCurrencyQuantity(quantity);
    }

    @Then("the user should see the country list box displayed")
    public void verifyCountryListBoxIsDisplayed()  {
        getDataPage().verifyCountryListBoxIsDisplayed();
    }

    @When("the user clicks on the choose a country option")
    public void userClicksOnCountryListBox()  {
        getDataPage().clickOnCountryListBox();
    }

    @Then("the user should see the list of all existing countries by full name")
    public void verifyCountryTypeAheadAndListBox(){
        getDataPage().verifyCountryTypeAheadAndListBox();
    }

    @Then("the user should see the country list matching the expected country list and sorted alphabetically")
    public void verifyCountryListMatchesExpectedList(){
        getDataPage().verifyCountryListValues();
    }

    @When("the user starts typing the name of a country as $word in the country input box")
    public void userEnterCountryTextInTypeAhead(String word){
        getDataPage().enterValueInCountryTypeAhead(word);
    }

    @Then("the user should see the countries in the listbox as: $countryList")
    public void verifyCountriesInListBox(ExamplesTable countryList) {
        getDataPage().verifyCountriesInListBox(countryList);
    }

    @Then("the user should see the countries in the currency usage as: $currencyCountries")
    public void verifyCountriesCurrencyUsage(ExamplesTable currencyCountries){
        getDataPage().verifyCountriesCurrencyUsage(currencyCountries);
    }

    @Then("the user should see the currency's uses as: $currencyUseTable")
    public void thenTheUserShouldSeeCurrencyUse(ExamplesTable currencyUseTable){
        getDataPage().verifyCurrencyUse(currencyUseTable);
    }

    @Then("the user should not see the currency's uses")
    public void thenTheUserShouldNotSeeCurrencyUse(){
        getDataPage().verifyNoCurrencyUse();
    }

    @When("the user clicks on the replaced by currency $replacedBy")
    public void userClicksOnReplacedByCurrency(String replacedBy){
        getDataPage().clickOnReplacedByLink(replacedBy);
    }

    @Then("the user should see the currencies in the listbox as: $currencyList")
    public void verifyCurrencyInListBox(ExamplesTable currencyList){
        getDataPage().verifyCurrencyInListBox(currencyList);
    }

    @When("the user enters the country <country> in the type-ahead box")
    public void enterCountryInTheTypeAheadBox(@Named("country") String country){
        getDataPage().enterCountryInTheTypeAheadBox(country);
    }

    @When("the user enters the area <area> in the type-ahead box")
    public void enterAreaInTypeAhead(@Named("area") String area){
        getDataPage().enterAreaInTypeAhead(area);
    }

    @Then("the user should see the country iso2 as $iso2")
    public void verifyCountryIso2(@Named("iso2") String iso2){
        getDataPage().verifyCountryIso2(iso2);
    }

    @Then("the user should see the country iso3 as $iso3")
    public void verifyCountryIso3(@Named("iso3") String iso3){
        getDataPage().verifyCountryIso3(iso3);
    }


    @Then("the user should see the basic info for the selected country")
    public void verifyCountryBasicInfo(){
        getDataPage().verifyBasicInfo(); }

    @Then("the user should see the basic info for selected area")
    public void verifyAreaBasicInfo(){
            getDataPage().verifyBasicInfo(); }

    @Then("the user should see the basic info for selected city")
    public void verifyCityBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the list of country's names type and value as: $countryNames")
    public void verifyCountryNames(ExamplesTable countryNames){
        getDataPage().verifyNames(countryNames);
    }

    @Then("the user should see the area's names as: $areaNames")
    public void verifyAreaNames(ExamplesTable areaNames){
        getDataPage().verifyNames(areaNames);
    }

    @Then("the user should see the city's names as: $cityNames")
    public void verifyCityNames(ExamplesTable cityNames) {
        getDataPage().verifyNames(cityNames);
    }

    @When("the user clicks on the country basic info link in the navigation bar")
    public void clickOnBasicInfoInNavigationBar(){
        getDataPage().clickOnBasicInfoInNavigationBar();
    }

    @When("the user clicks on the country regions link in the navigation bar")
    public void clickOnRegionsInNavigationBar(){
        getDataPage().clickOnRegionsInNavigationBar();
    }

    @Then("the user should see the country's demographics info as: $countryDemographics")
    public void verifyCountryDemographics(ExamplesTable countryDemographics){
        getDataPage().verifyCountryDemographics(countryDemographics);
    }

    @Then("the user should see the country's identifiers as: $countryIdentifiers")
    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers){
        getDataPage().verifyCountryIdentifiers(countryIdentifiers);
    }

    @Then("the user should see the area's identifiers as: $areaIdentifiers")
    public void verifyAreaIdentifiers(ExamplesTable areaIdentifiers){
        getDataPage().verifyIdentifiers(areaIdentifiers);
    }

    @Then("the user should see the city's identifiers as: $cityIdentifiers")
    public void verifyCityIdentifiers(ExamplesTable cityIdentifiers){
        getDataPage().verifyIdentifiers(cityIdentifiers);
    }
    @Then("the user should see the country's banking hours summary as $countryBankingHourSummary")
    public void verifyCountryBankingHourSummary(@Named("countryBankingHourSummary") String countryBankingHourSummary){
        getDataPage().verifyCountryBankingHourSummary(countryBankingHourSummary);
    }

    @Then("the user should see the country's banking hours as: $countryBankingHrSummary")
    public void verifyCountryBankingHourSummaryDaysAndHrs(ExamplesTable countryBankingHrSummary){
        getDataPage().verifyCountryBankingHourSummaryDaysAndHrs(countryBankingHrSummary);
    }

    @Then("the user should see the country's time zones summary as $countryTimeZonesSummary")
    public void verifyCountryTimeZonesSummary(@Named("countryTimeZonesSummary") String countryTimeZonesSummary){
        getDataPage().verifyCountryTimeZonesSummary(countryTimeZonesSummary);
    }

    @Then("the user should see the area's time zones summary as $areaTimeZonesSummary")
    public void verifyAreaTimeZonesSummary(@Named("areaTimeZonesSummary") String areaTimeZonesSummary){
        getDataPage().verifyAreaTimeZonesSummary(areaTimeZonesSummary);
    }

    @Then("the user should see the area's replace by as $areaReplacedBy")
    public void verifyAreaReplaceByLabelValues(@Named("areaReplacedBy") String areaReplacedBy){
        getDataPage().verifyReplaceByLabelValues(areaReplacedBy);
    }

    @Then("the user should see the countries's replace by as $countryReplacedBy")
    public void verifyCountryReplaceByLabelValues(@Named("countryReplacedBy") String countryReplacedBy){
        getDataPage().verifyReplaceByLabelValues(countryReplacedBy);
    }
    @Then("the user should see the country's time zones as: $countryTimeZones")
    public void verifyCountryTimeZones(ExamplesTable countryTimeZones){
        getDataPage().verifyCountryTimeZones(countryTimeZones);
    }

    @Then("the user should not see the area's area link")
    public void verifyAreaLinkInBasicInfo()
    {
        getDataPage().verifyAreaLinkInBasicInfo();
    }

    @Then("the user should not see the city's area link")
    public void verifyAreaLinkForCityInBasicInfo()
    { getDataPage().verifyAreaLinkForCityInBasicInfo(); }

    @Then("the user should not see the city's Subarea link")
    public void verifySubAreaLinkForCityInBasicInfo() {
        getDataPage().verifySubAreaLinkForCityInBasicInfo();
    }

    @Then("the user should see the area's time zones as: $areaTimeZones")
    public void verifyAreaTimeZones(ExamplesTable areaTimeZones) {
        getDataPage().verifyAreaTimeZones(areaTimeZones);
    }

    @Then("the user should see the country summary as: $countrySummary")
    public void verifyCountrySummary(ExamplesTable countrySummary){
        getDataPage().verifyCountrySummary(countrySummary);
    }

    @Then("the user should see the $label of a country as $value")
    public void verifyCountryBasicInfo(@Named("label") String label,@Named("value") String value){
        getDataPage().verifyBasicInfoLabel(label, value);
    }

    @Then("the user should see the $label of an area as $value")
    public void verifyAreaBasicInfo(@Named("label") String label,@Named("value") String value){
        getDataPage().verifyBasicInfoLabel(label, value);
    }

    @Then("the user should see the $label of a city as $value")
    public void verifyCityBasicInfo(@Named("label") String label,@Named("value") String value) {
        getDataPage().verifyBasicInfoLabel(label, value);
    }

    @When("the user clicks on the replaced by country <replacedByCountry> in the country basic info")
    public void clickOnReplacedByCountry(@Named("replacedByCountry") String replacedByCountry){
        getDataPage().clickOnReplacedByCountry(replacedByCountry);
    }

    @When("the user clicks on the country <currencyUsageCountry> in the currency usage")
    public void clickOnCurrencyUsageCountry(@Named("currencyUsageCountry") String currencyUsageCountry){
        getDataPage().clickOnCurrencyUsageCountry(currencyUsageCountry);
    }

    @When("the user clicks on the country iso3 $iso3 in the currency usage")
    public void clickOnCurrencyIso3(@Named("iso3") String iso3){
        getDataPage().clickOnCurrencyIso3(iso3);
    }

    @When("the user clicks on the country holidays link in the navigation bar")
    public void clickOnCountryHolidays(){
        getDataPage().clickOnCountryHolidays();
    }

    @Then("the user should see the country's holidays list as: $countryHolidaysList")
    public void verifyCountryHolidays(ExamplesTable countryHolidaysList){
        getDataPage().verifyCountryHolidays(countryHolidaysList);
    }

    @Then("the user should not see the country's holidays list")
    public void verifyNoCountryHolidays(){
        getDataPage().verifyNoCountryHolidays();
    }
    
    @When("the user clicks on the country payments link in the navigation bar")
    public void clickOnCountryPayments(){
        getDataPage().clickOnCountryPayments();
    }

    @Then("the user should see the country's payments iban as: $countryPaymentsIban")
    public void verifyCountryPaymentsIban(ExamplesTable countryPaymentsIban){
        getDataPage().verifyCountryPaymentsIban(countryPaymentsIban);
    }

    @Then("the user should see the country's payments routing code types as: $countryPaymentsRoutingCodesTypes")
    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes){
        getDataPage().verifyCountryPaymentsRoutingCodesTypes(countryPaymentsRoutingCodesTypes);
    }

    @Then("the user should not see the country's payments iban")
    public void verifyCountryNoIbanInfo(){
        getDataPage().verifyCountryNoIbanInfo();
    }

    @Then("the user should not see the country's payments routing codes types")
    public void verifyCountryNoRoutingCodeTypes(){
        getDataPage().verifyCountryNoRoutingCodeTypes();
    }

    @Then("the user should see the country's alternative regions as: $countryRegions")
    public void verifyCountryRegions(ExamplesTable countryRegions){
        getDataPage().verifyRegions(countryRegions);
    }

    @Then("the user should not see the country regions section")
    public void verifyNoCountryRegionsSection(){
        getDataPage().verifyNoCountryRegionsSection();
    }

    @Then("the user should not see the country holidays section")
    public void verifyNoCountryHolidaysSection(){
        getDataPage().verifyNoCountryHolidaysSection();
    }

    @When("the user clicks on the country languages link in the navigation bar")
    public void clickOnCountryLanguages() {
        getDataPage().clickOnCountryLanguages();
    }

    @Then("the user should see the country's languages list as $languages")
    public void verifyCountryLanguages(@Named("languages")String languages){
        getDataPage().verifyCountryLanguages(languages);
    }

    @When("the user clicks on the country credit rating link in the navigation bar")
    public void clickOnCountryCreditRating(){
        getDataPage().clickOnCountryCreditRating();
    }

    @Then("the user should see the country's credit ratings as: $countryCreditRatings")
    public void verifyCountryCreditRatings(ExamplesTable countryCreditRatings){
        getDataPage().verifyCreditRatings(countryCreditRatings);
    }

    @Then("the user should not see the country's credit ratings")
    public void verifyNoCountryCreditRatings() {
        getDataPage().verifyNoCreditRatings();
    }

    @When("the user clicks on the update currency link")
    public void clickOnUpdateCurrencyLink(){
        getDataPage().clickOnUpdateCurrencyLink();
    }

    @When("the user enters the currency name value as <name>")
    public void enterCurrencyName(@Named("name") String name){
        getDataPage().enterCurrencyName(name);
    }

    @When("the user enters the currency abbr value as <abbr>")
    public void enterCurrencyAbbr(@Named("abbr") String abbr){
        getDataPage().enterCurrencyAbbr(abbr);
    }

    @When("the user enters the currency unit value as <unit>")
    public void enterCurrencyUnit(@Named("unit") String unit){
        getDataPage().enterCurrencyUnit(unit);
    }

    @When("the user enters the currency quantity value as <quantity>")
    public void enterCurrencyQuantity(@Named("quantity") String quantity){
        getDataPage().enterCurrencyQuantity(quantity);
    }

    @When("the user clicks on the country places link in the navigation bar")
    public void clickOnCountryPlaces() {
        getDataPage().clickOnCountryPlaces();
    }

    @Then("the user should see the country's places as: $countryPlaces")
    public void verifyCountryPlaces(ExamplesTable countryPlaces){
        getDataPage().verifyPlaces(countryPlaces);
    }

    @Then("the user should see the area's places as: $areaPlaces")
    public void verifyAreaPlaces(ExamplesTable areaPlaces) {
        getDataPage().verifyPlaces(areaPlaces);
    }

    @Then("the user should not see the country's places")
    public void verifyNoCountryPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should not see the area's places")
    public void verifyNoAreaPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @When("the user clicks on the country entity link in the navigation bar")
    public void clickOnCountryEntity () {
        getDataPage().clickOnCountryEntity();
    }

    @When("the user clicks on the country people link in the navigation bar")
    public void clickOnCountryPeople() {
    getDataPage().clickOnCountryPeople();
    }

    @Then("the user should see the country's entities as: $countryEntities")
    public void verifyCountryEntities (ExamplesTable countryEntities){
        getDataPage().verifyCountryEntities(countryEntities);
    }

    @Then("the user should see the country's people as: $countryPeople")
    public void verifyCountryPeople (ExamplesTable countryPeople) {
        getDataPage().verifyPeople(countryPeople);
    }

    @Then("the user should not see the country's entities")
    public void verifyNoCountryEntities () {
        getDataPage().verifyNoCountryEntities();
    }

    @Then("the user should not see the country's people")
    public void verifyNoCountryPeople() {
        getDataPage().verifyNoPeople();
    }

    @Then("the user should see the default country page and display all info")
    public void verifyCountryDefaultToViewAll(){
        getDataPage().verifyDefaultToViewAll();
    }

    @When("the user refreshes the page")
    public void refreshThePage(){
        getDataPage().refreshThePage();
    }

    @When("the user clicks on the currencies link in the navigation bar")
    public void clickOnCountryCurrenciesLink(){
        getDataPage().clickOnCountryCurrenciesLink();
    }

    @Then("the user should see the country's currencies as: $countryCurrencies")
    public void verifyCountryCurrencies(ExamplesTable countryCurrencies){
        getDataPage().verifyCountryCurrencies(countryCurrencies);
    }

    @When("the user clicks on the choose an area option")
    public void clickOnAreaDropdown() { getDataPage().clickOnAreaDropdown();}

    @Then("the user should see the below states for the selected country: $areas")
    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        getDataPage().verifyAreaForSelectedCountry(areas);
    }

    @Then("the user should see the below subareas for the selected country and area: $subarea")
    public void verifySubareaForSelectedArea(ExamplesTable subarea) {getDataPage().verifySubareaForSelectedArea(subarea); }

    @Then("the user should see the area dropdown disabled")
    public void verifyAreaDropdownDisabled() {
        getDataPage().verifyAreaDropdownDisabled();
    }

    @Then("the user should see the subarea dropdown disabled")
    public void verifySubareaDropdownDisabled() {getDataPage().verifySubareaDropdownDisabled(); }

    @When("the user clicks on the area basic info link in the navigation bar")
    public void clickOnAreaBasicInfoInNavigationBar() {
        getDataPage().clickOnAreaBasicInfoInNavigationBar();
    }

    @When("the user clicks on the city basic info link in the navigation bar")
    public void clickOnCityBasicInfoInNavigationBar() {
        getDataPage().clickOnCityBasicInfoInNavigationBar();
    }

    @When("the user clicks on the area's places link in the navigation bar")
    public void clickOnAreaRelatedPlaces() {
        getDataPage().clickOnAreaRelatedPlaces();
    }


    @When("the user clicks on the city tab in the data area")
    public void userClicksOnCityTab() {
        getDataPage().clickOnCityTab();
    }

    @When("the user clicks on the choose a city option")
    public void clickOnCityDropdown() { getDataPage().clickOnCityDropdown();}

    @Then("the user should see the below cities for the selected area: $cities")
    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        getDataPage().verifyCitiesForSelectedArea(cities);
    }

    @Then("the user should not see any cities for the selected area")
    public void verifyNoCitiesForSelectedArea() {
        getDataPage().verifyNoCitiesForSelectedArea();
    }

    @When("the user clicks on the area's people link in the navigation bar")
    public void clickOnAreaRelatedPeople() {
        getDataPage().clickOnAreaRelatedPeople();
    }

    @When("the user clicks on the area's demographics link in the navigation bar")
    public void clickOnAreaDemographics() {
        getDataPage().clickOnDemographics();
    }

    @When("the user clicks on the sub-area's demographics link in the navigation bar")
    public void clickOnSubAreaDemographics() {
        getDataPage().clickOnDemographics();
    }

    @Then("the user should see the area's demographics as: $areaDemographics")
    public void verifyAreaDemographics(ExamplesTable areaDemographics) {
        getDataPage().verifyDemographics(areaDemographics);
    }

    @Then("the user should see the sub-area's demographics as: $subAreaDemographics")
    public void verifySubAreaDemographics(ExamplesTable subAreaDemographics) {
        getDataPage().verifyDemographics(subAreaDemographics);
    }

    @Then("the user should not see the area's demographics")
        public void verifyNoAresDemographics() {
        getDataPage().verifyNoDemographics();
    }
    @Then("the user should not see the sub-area's demographics")
    public void verifyNoSubAreaDemographics() {
        getDataPage().verifyNoDemographics();
    }

    @Then("the user should see the area's people as: $areaPeople")
    public void verifyAreaPeople (ExamplesTable areaPeople) {
        getDataPage().verifyPeople(areaPeople);
    }

    @Then("the user should not see the area's people")
    public void verifyNoAreaPeople() {
        getDataPage().verifyNoPeople();
    }

    @When("the user clicks on the area's credit rating link in the navigation bar")
    public void clickOnAreasCreditRatings(){
        getDataPage().clickOnAreasCreditRatings();
    }

    @Then("the user should see the area's credit ratings as: $areaCreditRatings")
    public void verifyAreaCreditRatings(ExamplesTable areaCreditRatings) {
        getDataPage().verifyCreditRatings(areaCreditRatings);
    }

    @When("the user clicks on the choose a sub-area option")
    public void clickOnSubAreaDropDown(){
        getDataPage().clickOnSubAreaDropDown();
    }

    @When("the user enters the sub-area <subArea> in the type-ahead box")
    public void enterSubAreaInTypeAhead(@Named("subArea") String subArea){
        getDataPage().enterSubAreaInTypeAhead(subArea);
    }

    @Then("the user should not see the area's credit ratings")
    public void verifyNoAreaCreditRatings(){
        getDataPage().verifyNoCreditRatings();
    }

    @When("the user clicks on the sub-area's credit rating link in the navigation bar")
    public void clickOnSubAreasCreditRatings(){
        getDataPage().clickOnAreasCreditRatings();
    }

    @Then("the user should see the sub-area's credit ratings as: $areaCreditRatings")
    public void verifySubAreaCreditRatings(ExamplesTable areaCreditRatings) {
        getDataPage().verifyCreditRatings(areaCreditRatings);
    }

    @Then("the user should not see the sub-area's credit ratings")
    public void verifyNoSubAreaCreditRatings(){
        getDataPage().verifyNoCreditRatings();
    }

    @When("the user clicks on the area's alternative regions link in the navigation bar")
    public void clickOnAreasAlternativeRegions(){
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the area's alternative regions as: $areaRegions")
    public void verifyAreaRegions(ExamplesTable areaRegions){
        getDataPage().verifyRegions(areaRegions);
    }

    @When("the user clicks on the sub-area's alternative regions link in the navigation bar")
    public void clickOnSubAreasAlternativeRegions(){
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the sub-area's alternative regions as: $subAreaRegions")
    public void verifySubAreaRegions(ExamplesTable subAreaRegions){
        getDataPage().verifyRegions(subAreaRegions);
    }

    @Then("the user should not see the area's alternative regions")
    public void verifyNoAreaAlternativeRegions(){
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should not see the sub-area's alternative regions")
    public void verifyNoSubAreaAlternativeRegions(){
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should see the default area page and display all info")
    public void verifyAreaDefaultToViewAll(){
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the default sub-area page and display all info")
    public void verifySubAreaDefaultToViewAll(){
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the basic info for selected sub-area")
    public void verifySubAreaBasicInfo(){
        getDataPage().verifyBasicInfo(); }

    @Then("the user should see the credit ratings for selected sub-area")
    public void verifyCreditRatingsForSubArea(){
        getDataPage().verifyCreditRatingsLabel();
    }

    @Then("the user should see the credit ratings for selected area")
    public void verifyCreditRatingsForArea() {
        getDataPage().verifyCreditRatingsLabel();
    }

    @Then("the user should see the demographics for selected area")
    public void verifyDemographicsForArea() {
        getDataPage().verifyDemographicsLabel();
    }

    @Then("the user should see the demographics for selected sub-area")
    public void verifyDemographicsForSubArea() {
        getDataPage().verifyDemographicsLabel();
    }

    @Then("the user should see the places for selected sub-area")
    public void verifyPlacesForSubArea() {
        getDataPage().verifyPlacesLabel();
    }

    @Then("the user should see the places for selected area")
    public void verifyPlacesForArea() {
        getDataPage().verifyPlacesLabel();
    }

    @Then("the user should see the people for selected area")
    public void verifyPeopleForArea() {
        getDataPage().verifyPeopleLabel();
    }

    @Then("the user should see the people for selected sub-area")
    public void verifyPeopleForSubArea() {
        getDataPage().verifyPeopleLabel();
    }



    @When("the user enters the city <city> in the type-ahead box")
    public void enterCityInTheTypeAheadBox(@Named("city") String city){
        getDataPage().enterCityInTheTypeAheadBox(city);
    }
    
    @When("the user clicks on the city regions link in the navigation bar")
    public void clickOnCityAlternativeRegions(){
        getDataPage().clickOnCityRegionsInNavigationBar();
    }
    
    @Then("the user should see the city's alternative regions as: $citryRegions")
    public void verifyCityRegions(ExamplesTable citryRegions){
        getDataPage().verifyRegions(citryRegions);
    }
    
}



