package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.*;

import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.remote.internal.ApacheHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSteps extends AbstractSteps {

    @Autowired
    com.accuity.zeus.aft.io.ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    @When("the user clicks on the country tab in the data area")
    public void clickOnCountryTab() {
        getDataPage().clickOnCountryTab();
    }

    @When("the user clicks on the area tab in the data area")
    public void clickOnAreaTab() {
        getDataPage().clickOnAreaTab();
    }

    @When("the user clicks on the legal entity tab in the data area")
    public void userClicksOnLegalEntityTab() {
        setLegalEntityPage(getDataPage().clickOnLegalEntityTab());
    }

    @Then("the user should see the country type-ahead displayed")
    public void verifyCountryTypeAheadAndListBox() {
        getDataPage().verifyCountryTypeAheadAndListBox();
    }

    @When("the user clicks on the choose a country option")
    public void clickOnCountryListBox() throws InterruptedException {
        getDataPage().clickOnCountryListBox();
    }

    @Then("the user should see the country's currencies as: $countryCurrencies")
    public void verifyCountryCurrencies(ExamplesTable countryCurrencies) {
        getDataPage().verifyCountryCurrencies(countryCurrencies);
    }

    @Then("the user should see the list of all existing countries by full name")
    public void verifyCountryList() {
        getDataPage().verifyCountryList();
    }

    @When("the user starts typing the name of a country as $word in the country input box")
    public void enterValueInCountryTypeAhead(String word) {
        getDataPage().enterValueInCountryTypeAhead(word);
    }

    @Then("the user should see the countries in the listbox as: $countryList")
    public void verifyCountriesInListBox(ExamplesTable countryList) {
        getDataPage().verifyCountriesInListBox(countryList);
    }


    @When("the user clicks on the cancel button")
    public void clickOnCancelButton() {
        getDataPage().clickOnCancelButton();
    }

    @When("the user clicks on the cancel yes button")
    public void clickOnCancelYesButton() {
        getDataPage().clickOnCancelYesButton();
    }

    @When("the user enters the country <country> in the type-ahead box")
    public void enterCountryInTheTypeAheadBox(@Named("country") String country) {
        getDataPage().enterCountryInTheTypeAheadBox(country);
    }

    @When("the user enters an another country $anotherCountry in the type-ahead box")
    public void enterCountryName(@Named("anotherCountry") String anotherCountry) {
        getDataPage().enterCountryInTheTypeAheadBox(anotherCountry);
    }

    @When("the user enters the area <area> in the type-ahead box")
    public void enterAreaInTypeAhead(@Named("area") String area) {
        getDataPage().enterAreaInTypeAhead(area);
    }

    @When("the user enters an another area $anotherArea in the type-ahead box")
    public void entersArea(@Named("anotherArea") String anotherArea) {
        getDataPage().enterAreaInTypeAhead(anotherArea);
    }

    @When("the user enters an another city $anotherCity in the type-ahead box")
    public void entersCity(@Named("anotherCity") String anotherCity) {
        getDataPage().enterCityInTheTypeAheadBox(anotherCity);
    }

    @Then("the user should see the country iso2 as $iso2")
    public void verifyCountryIso2(@Named("iso2") String iso2) {
        getDataPage().verifyCountryIso2(iso2);
    }

    @Then("the user should see the country iso3 as $iso3")
    public void verifyCountryIso3(@Named("iso3") String iso3) {
        getDataPage().verifyCountryIso3(iso3);
    }


    @Then("the user should see the basic info for the selected country")
    public void verifyCountryBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the basic info for selected area")
    @Aliases(values={"the user should see the basic info for selected city",
            "the user should see the basic info for selected sub-area"})
    public void verifyAreaBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the list of country's names type and value as: $countryNames")
    public void verifyCountryNames(ExamplesTable countryNames) {
        getDataPage().verifyNames(countryNames);
    }

    @Then("the user should see the area's names as: $names")
    @Aliases(values={"the user should see the legal entity's names as: $names",
            "the user should see the sub-area's names as: $names"})
    public void verifyAreaNames(ExamplesTable names) {
        getDataPage().verifyNames(names);
    }

    @Then("the user should see the office's names as: $Names")
    public void verifyOfficeNames(ExamplesTable Names) { getDataPage().verifyNames(Names);}

    @Then("the user should see the office sort key as $officeSortKey")
    public void verifyOfficeSortKey(@Named("officeSortKey") String officeSortKey){
        getDataPage().verifyOfficeSortKey(officeSortKey);
    }

    @Then("the user should see the office types: $Types")
    public void verifyOfficeTypes(ExamplesTable Types) { getDataPage().verifyTypes(Types); }

    @When("the user clicks on the legalEntity basic info link in the navigation bar")
    public void clickOnLegalEntityBasicInfo() {
        getDataPage().clickOnLegalEntityBasicInfo();
    }

    @Then("the user should see the city's names as: $cityNames")
    public void verifyCityNames(ExamplesTable cityNames) {
        getDataPage().verifyNames(cityNames);
    }

    @When("the user clicks on the country basic info link in the navigation bar")
    public void clickOnBasicInfoInNavigationBar() {
        getDataPage().clickOnBasicInfoInNavigationBar();
    }

    @When("the user clicks on the country regions link in the navigation bar")
    public void clickOnRegionsInNavigationBar() {
        getDataPage().clickOnRegionsInNavigationBar();
    }

    @Then("the user should see the country's demographics info as: $countryDemographics")
    public void verifyCountryDemographics(ExamplesTable countryDemographics) {
        getDataPage().verifyCountryDemographics(countryDemographics);
    }

    @Then("the user should see the country's identifiers as: $countryIdentifiers")
    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers) {
        getDataPage().verifyIdentifiers(countryIdentifiers);
    }

    @Then("the user should see the area's identifiers as: $areaIdentifiers")
    @Alias("the user should see the sub-area's identifiers as: $areaIdentifiers")
    public void verifyAreaIdentifiers(ExamplesTable areaIdentifiers) {
        getDataPage().verifyIdentifiers(areaIdentifiers);
    }

    @Then("the user should see the city's identifiers as: $cityIdentifiers")
    public void verifyCityIdentifiers(ExamplesTable cityIdentifiers) {
        getDataPage().verifyIdentifiers(cityIdentifiers);
    }

    @Then("the user should see the country's banking hours summary as $countryBankingHourSummary")
    public void verifyCountryBankingHourSummary(@Named("countryBankingHourSummary") String countryBankingHourSummary) {
        getDataPage().verifyCountryBankingHourSummary(countryBankingHourSummary);
    }

    @Then("the user should see the country's banking hours as: $countryBankingHrSummary")
    public void verifyCountryBankingHourSummaryDaysAndHrs(ExamplesTable countryBankingHrSummary) {
        getDataPage().verifyCountryBankingHourSummaryDaysAndHrs(countryBankingHrSummary);
    }

    @Then("the user should see the country's time zones summary as $countryTimeZonesSummary")
    public void verifyCountryTimeZonesSummary(@Named("countryTimeZonesSummary") String countryTimeZonesSummary) {
        getDataPage().verifyCountryTimeZonesSummary(countryTimeZonesSummary);
    }

    @Then("the user should see the area's time zones summary as $areaTimeZonesSummary")
    @Alias("the user should see the sub-area's time zones summary as $areaTimeZonesSummary")
    public void verifyAreaTimeZonesSummary(@Named("areaTimeZonesSummary") String areaTimeZonesSummary) {
        getDataPage().verifyAreaTimeZonesSummary(areaTimeZonesSummary);
    }

    @Then("the user should see the area's replace by as $areaReplacedBy")
    @Alias("the user should see the sub-area's replace by as $areaReplacedBy")
    public void verifyAreaReplaceByLabelValues(@Named("areaReplacedBy") String areaReplacedBy) {
        getDataPage().verifyReplaceByLabelValues(areaReplacedBy);
    }

    @Then("the user should see the countries's replace by as $countryReplacedBy")
    public void verifyCountryReplaceByLabelValues(@Named("countryReplacedBy") String countryReplacedBy) {
        getDataPage().verifyReplaceByLabelValues(countryReplacedBy);
    }

    @Then("the user should see the country's time zones as: $countryTimeZones")
    public void verifyCountryTimeZones(ExamplesTable countryTimeZones) {
        getDataPage().verifyCountryTimeZones(countryTimeZones);
    }

    @Then("the user should not see the area's area link")
    public void verifyAreaLinkInBasicInfo() {
        getDataPage().verifyAreaLinkInBasicInfo();
    }

    @Then("the user should not see the city's area link")
    public void verifyAreaLinkForCityInBasicInfo() {
        getDataPage().verifyAreaLinkForCityInBasicInfo();
    }

    @Then("the user should not see the city's Subarea link")
    public void verifySubAreaLinkForCityInBasicInfo() {
        getDataPage().verifySubAreaLinkForCityInBasicInfo();
    }

    @Then("the user should see the area's time zones as: $areaTimeZones")
    @Alias("the user should see the sub-area's time zones as: $areaTimeZones")
    public void verifyAreaTimeZones(ExamplesTable areaTimeZones) {
        getDataPage().verifyAreaTimeZones(areaTimeZones);
    }

    @Then("the user should see the country summary as: $countrySummary")
    public void verifyCountrySummary(ExamplesTable countrySummary) {
        getDataPage().verifyCountrySummary(countrySummary);
    }

    @Then("the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>")
    public void verifyLegalEntityHeader(@Named("entity") String entity,
                                        @Named("headOfficeAddress") String headOfficeAddress,
                                        @Named("fid") String fid,
                                        @Named("tfpid") String tfpid){
        getDataPage().verifyHeader(entity, headOfficeAddress, fid, tfpid);
    }

    @Then("the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>")
    public void verifyOfficeHeader(@Named("entity") String entity,
                                   @Named("headOfficeAddress") String headOfficeAddress,
                                   @Named("officeFid") String fid,
                                   @Named("officeTfpid") String tfpid){
        getDataPage().verifyHeader(entity, headOfficeAddress, fid, tfpid);
    }

    @Then("the user should see the $label of a city as $value")
    @Aliases(values={"the user should see the $label of an office as $value",
            "the user should see the $label of an area as $value",
            "the user should see the $label of an sub-area as $value",
            "the user should see the $label of a legal entity as $value",
            "the user should see the $label of a country as $value"})
    public void verifyBasicInfo(@Named("label") String label, @Named("value") String value) {
        getDataPage().verifyBasicInfo(label, value);
    }

    @When("the user clicks on the replaced by country <replacedByCountry> in the country basic info")
    public void clickOnReplacedByCountry(@Named("replacedByCountry") String replacedByCountry) {
        getDataPage().clickOnReplacedByCountry(replacedByCountry);
    }

    @When("the user clicks on the country holidays link in the navigation bar")
    public void clickOnCountryHolidays() {
        getDataPage().clickOnCountryHolidays();
    }

    @Then("the user should see the country's holidays list as: $countryHolidaysList")
    public void verifyCountryHolidays(ExamplesTable countryHolidaysList) {
        getDataPage().verifyCountryHolidays(countryHolidaysList);
    }

    @Then("the user should not see the country's holidays list")
    public void verifyNoCountryHolidays() {
        getDataPage().verifyNoCountryHolidays();
    }

    @When("the user clicks on the country payments link in the navigation bar")
    public void clickOnCountryPayments() {
        getDataPage().clickOnCountryPayments();
    }

    @Then("the user should see the country's payments iban status as $status")
    public void verifyCountryPaymentsIbanStatus(@Named("status") String status) {
        getDataPage().verifyCountryPaymentsIbanStatus(status);
    }

    @Then("the user should see the country's payments iban as: $countryPaymentsIban")
    public void verifyCountryPaymentsIban(ExamplesTable countryPaymentsIban) {
        getDataPage().verifyCountryPaymentsIban(countryPaymentsIban);
    }

    @Then("the user should see the country's payments routing code types as: $countryPaymentsRoutingCodesTypes")
    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes) {
        getDataPage().verifyCountryPaymentsRoutingCodesTypes(countryPaymentsRoutingCodesTypes);
    }

    @Then("the user should not see the country's payments iban")
    public void verifyCountryNoIbanInfo() {
        getDataPage().verifyCountryNoIbanInfo();
    }

    @Then("the user should not see the country's payments routing codes types")
    public void verifyCountryNoRoutingCodeTypes() {
        getDataPage().verifyCountryNoRoutingCodeTypes();
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
        getDataPage().verifyNoCountryHolidaysSection();
    }

    @When("the user clicks on the country languages link in the navigation bar")
    public void clickOnCountryLanguages() {
        getDataPage().clickOnCountryLanguages();
    }

    @Then("the user should see the country's languages list as $languages")
    public void verifyCountryLanguages(@Named("languages") String languages) {
        getDataPage().verifyCountryLanguages(languages);
    }

    @When("the user clicks on the country credit rating link in the navigation bar")
    public void clickOnCountryCreditRating() {
        getDataPage().clickOnCountryCreditRating();
    }

    @When("the user clicks on the country places link in the navigation bar")
    public void clickOnCountryPlaces() {
        getDataPage().clickOnCountryPlaces();
    }

    @Then("the user should see the country's places as: $countryPlaces")
    public void verifyCountryPlaces(ExamplesTable countryPlaces) {
        getDataPage().verifyPlaces(countryPlaces);
    }

    @Then("the user should see the area's places as: $areaPlaces")
    @Alias("the user should see the sub-area's places as: $areaPlaces")
    public void verifyAreaPlaces(ExamplesTable areaPlaces) {
        getDataPage().verifyPlaces(areaPlaces);
    }

    @Then("the user should see the city's places as: $cityPlaces")
    public void verifyCityPlaces(ExamplesTable cityPlaces) {
        getDataPage().verifyPlaces(cityPlaces);
    }

    @Then("the user should not see the country's places")
    public void verifyNoCountryPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should not see the area's places")
    @Alias("the user should not see the sub-area's places")
    public void verifyNoAreaPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should not see the city's related places")
    public void verifyNoCityPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @When("the user clicks on the country entity link in the navigation bar")
    public void clickOnCountryEntity() {
        getDataPage().clickOnCountryEntity();
    }

    @When("the user clicks on the country people link in the navigation bar")
    public void clickOnCountryPeople() {
        getDataPage().clickOnCountryPeople();
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

    @Then("the user should not see the city's entity")
    public void verifyNoCityEntities() {
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

    @When("the user refreshes the page")
    public void refreshThePage() {
        getDataPage().refreshThePage();
    }

    @When("the user clicks on the choose an area option")
    public void clickOnAreaDropdown() {
        getDataPage().clickOnAreaDropdown();
    }

    @Then("the user should see the below states for the selected country: $areas")
    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        getDataPage().verifyAreaForSelectedCountry(areas);
    }

    @Then("the user should see the below subareas for the selected country and area: $subarea")
    public void verifySubareaForSelectedArea(ExamplesTable subarea) {
        getDataPage().verifySubareaForSelectedArea(subarea);
    }

    @Then("the user should see the area dropdown disabled")
    public void verifyAreaDropdownDisabled() {
        getDataPage().verifyAreaDropdownDisabled();
    }

    @Then("the user should see the subarea dropdown disabled")
    public void verifySubareaDropdownDisabled() {
        getDataPage().verifySubareaDropdownDisabled();
    }

    @When("the user clicks on the area basic info link in the navigation bar")
    @Alias("the user clicks on the sub-area basic info link in the navigation bar")
    public void clickOnAreaBasicInfoInNavigationBar() {
        getDataPage().clickOnAreaBasicInfoInNavigationBar();
    }

    @When("the user clicks on the city basic info link in the navigation bar")
    public void clickOnCityBasicInfoInNavigationBar() {
        getDataPage().clickOnCityBasicInfoInNavigationBar();
    }

    @When("the user clicks on the area's places link in the navigation bar")
    @Alias("the user clicks on the sub-area's places link in the navigation bar")
    public void clickOnAreaRelatedPlaces() {
        getDataPage().clickOnAreaRelatedPlaces();
    }

    @When("the user clicks on the city's places link in the navigation bar")
    public void clickOnCityRelatedPlaces() {
        getDataPage().clickOnCityRelatedPlaces();
    }


    @When("the user clicks on the city tab in the data area")
    public void userClicksOnCityTab() {
        getDataPage().clickOnCityTab();
    }

    @When("the user clicks on the choose a city option")
    public void clickOnCityDropdown() {
        getDataPage().clickOnCityDropdown();
    }

    @Then("the user should see the below cities for the selected area: $cities")
    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        getDataPage().verifyCitiesForSelectedArea(cities);
    }

    @Then("the user should not see any cities for the selected area")
    public void verifyNoCitiesForSelectedArea() {
        getDataPage().verifyNoCitiesForSelectedArea();
    }

    @When("the user clicks on the area's people link in the navigation bar")
    @Alias("the user clicks on the sub-area's people link in the navigation bar")
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

    @Then("the user should see the legal entity's statistics as: $statistics")
    @Aliases(values = {"the user should see the office's statistics as: $statistics"})
    public void verifyStatistics(ExamplesTable statistics) {
        getDataPage().verifyStatistics(statistics);
    }

    @Then("the user should see the statistics for the legal entity")
    public void verifyLegalEntityStatisticsLabels(){
        getDataPage().verifyStatisticsLabels();
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
    @Alias("the user should see the sub-area's people as: $areaPeople")
    public void verifyAreaPeople(ExamplesTable areaPeople) {
        getDataPage().verifyPeople(areaPeople);
    }

    @Then("the user should not see the area's people")
    @Alias("the user should not see the sub-area's people")
    public void verifyNoAreaPeople() {
        getDataPage().verifyNoPeople();
    }

    @When("the user clicks on the area's credit rating link in the navigation bar")
    public void clickOnAreasCreditRatings() {
        getDataPage().clickOnAreasCreditRatings();
    }

    @When("the user clicks on the choose a sub-area option")
    public void clickOnSubAreaDropDown() {
        getDataPage().clickOnSubAreaDropDown();
    }

    @When("the user enters the sub-area <subArea> in the type-ahead box")
    @Alias("the user enters the sub-area $subArea in the type-ahead box")
    public void enterSubAreaInTypeAhead(@Named("subArea") String subArea) {
        getDataPage().enterSubAreaInTypeAhead(subArea);
    }

    @When("the user clicks on the sub-area's credit rating link in the navigation bar")
    public void clickOnSubAreasCreditRatings() {
        getDataPage().clickOnAreasCreditRatings();
    }

    @When("the user clicks on the area's alternative regions link in the navigation bar")
    public void clickOnAreasAlternativeRegions() {
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the area's alternative regions as: $areaRegions")
    public void verifyAreaRegions(ExamplesTable areaRegions) {
        getDataPage().verifyRegions(areaRegions);
    }

    @When("the user clicks on the sub-area's alternative regions link in the navigation bar")
    public void clickOnSubAreasAlternativeRegions() {
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the sub-area's alternative regions as: $subAreaRegions")
    public void verifySubAreaRegions(ExamplesTable subAreaRegions) {
        getDataPage().verifyRegions(subAreaRegions);
    }

    @Then("the user should not see the area's alternative regions")
    public void verifyNoAreaAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should not see the sub-area's alternative regions")
    public void verifyNoSubAreaAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should see the default area page and display all info")
    public void verifyAreaDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the default sub-area page and display all info")
    public void verifySubAreaDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the credit ratings for selected sub-area")
    @Alias("the user should see the credit rating for selected city")
    public void verifyCreditRatingsLabel() {
        getDataPage().verifyCreditRatingsLabelsGeo();
    }

    @Then("the user should see the credit ratings for selected area")
    public void verifyCreditRatingsForArea() {
        getDataPage().verifyCreditRatingsLabelsGeo();
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
    @Alias("the user should see the places for selected city")
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
    @Alias("the user should see the people for selected city")
    public void verifyPeopleForSubArea() {
        getDataPage().verifyPeopleLabel();
    }

    @Then("the user should see the entities for selected city")
    public void verifyEntitiesForCity() {
        getDataPage().verifyEntitiesLabel();
    }

    @Then("the user should see the regions for selected city")
    public void verifyRegionsForCity() {
        getDataPage().verifyRegionsLabel();
    }

    @When("the user clicks on the city's credit rating link in the navigation bar")
    public void clickOnCityCreditRatings() {
        getDataPage().clickOnCityCreditRatings();
    }


    @When("the user clicks on the city's entity link in the navigation bar")
    public void clickOnCityEntity() {
        getDataPage().clickOnCityEntity();
    }

    @Then("the user should see the legal entity's credit ratings as: $creditRatings")
    @Aliases(values={"the user should see the office's credit ratings as: $creditRatings"})
    public void verifyCreditRatings(ExamplesTable creditRatings) {
        getDataPage().verifyCreditRatings(creditRatings);
    }

    @Then("the user should see the city's credit ratings as: $creditRatings")
    @Aliases(values={"the user should see the area's credit ratings as: $creditRatings",
            "the user should see the country's credit ratings as: $creditRatings",
            "the user should see the sub-area's credit ratings as: $creditRatings"})
    public void verifyCreditRatingsGeo(ExamplesTable creditRatings) {
        getDataPage().verifyCreditRatingsGeo(creditRatings);
    }

    @Then("the user should see all is selected by default in the navigation bar")
    public void verifyDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the city's entity as: $cityEntities")
    public void verifyCityEntities(ExamplesTable cityEntities) {
        getDataPage().verifyEntities(cityEntities);
    }


    @Then("the user should not see the legal entity's credit ratings")
    @Aliases(values= {"the user should not see the office's credit ratings"})
    public void verifyNoCreditRatings(){
        getDataPage().verifyNoCreditRatings();
    }

    @Then("the user should not see the city's credit ratings")
    @Aliases(values= {"the user should not see the country's credit ratings",
            "the user should not see the area's credit ratings",
            "the user should not see the sub-area's credit ratings"})
    public void verifyNoCreditRatingsGeo(){
        getDataPage().verifyNoCreditRatingsGeo();
    }

    @When("the user enters the city <city> in the type-ahead box")
    public void enterCityInTheTypeAheadBox(@Named("city") String city){
        getDataPage().enterCityInTheTypeAheadBox(city);
    }

    @When("the user clicks on the city all link in the navigation bar")
    public void clicksOnCiltyAllLink() {
        getDataPage().clicksOnAllLink();
    }

    @Then("the user should see the default city page and display basic info")
    public void verifyDefaultBasicInfo() {
        getDataPage().verifyDefaultBasicInfo();
    }

    @When("the user clicks on the city regions link in the navigation bar")
    public void clickOnCityAlternativeRegions(){
        getDataPage().clickOnCityRegionsInNavigationBar();
    }

    @Then("the user should see the city's alternative regions as: $citryRegions")
    public void verifyCityRegions(ExamplesTable citryRegions){
        getDataPage().verifyRegions(citryRegions);
    }

    @When("the user clicks on the city's people link in the navigation bar")
    public void clickOnCityRelatedPeople() {
        getDataPage().clickOnCityRelatedPeople();
    }

    @Then("the user should see the city's people as: $cityPeople")
    public void verifyCityPeople(ExamplesTable cityPeople) {
        getDataPage().verifyPeople(cityPeople);
    }

    @Then("the user should not see the city's people")
    public void verifyNoCityPeople() {
        getDataPage().verifyNoPeople();
    }

    @Then("the user should not see the city's alternative regions")
    public void verifyNoCityAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should not see the city's alternative regions section")
    public void verifyNoCityAlternativeRegionsSection() {
        getDataPage().verifyNoCityAlternativeRegionsSection();
    }

    @When("the user clicks on the area's entity link in the navigation bar")
    public void clickOnAreaEntity() {
        getDataPage().clickOnAreaEntity();
    }

    @Then("the user should see the area's entities as: $areaEntities")
    public void verifyAreaEntities(ExamplesTable areaEntities) {
        getDataPage().verifyEntities(areaEntities);
    }

    @When("the user clicks on the sub-area's entity link in the navigation bar")
    public void clickOnSubAreaEntity() {
        getDataPage().clickOnAreaEntity();
    }

    @Then("the user should see the sub-area's entities as: $areaEntities")
    public void verifySubAreaEntities(ExamplesTable areaEntities) {
        getDataPage().verifyEntities(areaEntities);
    }

    @Then("the user should not see the area's entities")
    public void verifyNoAreaEntities () {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should not see the sub-area's entities")
    public void verifyNoSubAreaEntities () {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should see the legal entity's personnel as: $personnel")
    @Alias("the user should see the office's personnel as: $personnel")
    public void verifyPersonnel(ExamplesTable personnel) {
        getDataPage().verifyPersonnel(personnel);
    }

    @Then("the user should not see the legal entity's personnel")
    @Alias("the user should not see the office's personnel")
    public void verifyNoPersonnel() {
        getDataPage().verifyNoPersonnel();
    }

    @Then("the user should see the personnel for the legal entity")
    @Alias("the user should see the personnel for the office")
    public void verifyPersonnelLabels() {
        getDataPage().verifyPersonnelLabels();
    }

    @Then("the user should see the legal entity's history as: $history")
    @Alias("the user should see the office's history as: $history")
    public void verifyHistory(ExamplesTable history) {
        getDataPage().verifyHistory(history);
    }

    @Then("the user should see the history for the legal entity")
    @Alias("the user should see the history for the office")
    public void verifyHistoryLabel(){
        getDataPage().verifyHistoryLabel();
    }

    @Then ("the user should not see the legal entity's history")
    @Alias ("the user should not see the office's history")
    public void verifyNoHistory() {
        getDataPage().verifyNoHistory();
    }

    @Then("the user should see the default legal entity page and display basic info")
    @Alias("the user should see the default office page and display basic info")
    public void verifyDefaultSection(){
        getDataPage().verifyBasicInfo();
    }

    @When("the user clicks on the legal entity all link in the navigation bar")
    @Alias("the user clicks on the office all link in the navigation bar")
    public void clickOnAllLink() {
        getDataPage().clicksOnAllLink();
    }

    @Then("the user should see the basic info for selected legal entity")
    @Alias("the user should see the basic info for selected office")
    public void verifyBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the legal entity's identifiers as: $identifiers")
    @Alias("the user should see the office's identifiers as: $identifiers")
    public void verifyLegalEntityOfficeIdentifiers(ExamplesTable identifiers) {
        getDataPage().verifyLegalEntityOfficeIdentifiers(identifiers);
    }

    @Then("the user should not see the legal entity's identifiers")
    @Alias("the user should not see the office's identifiers")
    public void verifyNoLegalEntityOfficeIdentifiers() {
        getDataPage().verifyNoLegalEntityOfficeIdentifiers();
    }

    @Then("the user should see the identifiers for the legal entity")
    @Alias("the user should see the identifiers for the office")
    public void verifyLegalEntityOfficeIdentifiersLabels(){
        getDataPage().verifyLegalEntityOfficeIdentifiersLabels();
    }

    @When("the user clicks on the area parent <areaParent> link for the selected area")
    public void clickOnAreaParentLink(@Named("areaParent") String areaParent){
        getDataPage().clickOnAreaParentLink(areaParent);
    }

    @When("the user clicks on the view head office <viewHeadOffice> link for the selected legal entity")
    public void clickOnViewHeadOfficeLink(@Named("viewHeadOffice") String viewHeadOffice) {
        getDataPage().clickOnViewHeadOfficeLink(viewHeadOffice);
    }

    @Then("the user should not see the legalEntity's headOffice link")
    public void verifyHeadOfficeInLegalEntityBasicInfo() {
        getDataPage().verifyHeadOfficeInLegalEntityBasicInfo();
    }

    @When("the user clicks on iso link <isoCode>")
    public void clickOnISOLink(@Named("isoCode") String isoCode){
        getDataPage().clickOnISOLink(isoCode);
    }

    @When("the user clicks on the city area link $area")
    public void clickOnCityArea(@Named("area") String area){
        getDataPage().clickOnCityArea(area);
    }

    @Then("the user should see the area page with $countryDropDown, $areaDropDown and $subAreaDropDown selected")
    public void verifyClickedAreaPage(@Named("countryDropDown") String countryDropDown, @Named("areaDropDown") String areaDropDown, @Named("subAreaDropDown") String subAreaDropDown) {
        getDataPage().verifyClickedAreaPage(countryDropDown, areaDropDown, subAreaDropDown);
    }

    @Then("the user should see the country page with $countryDropDown selected")
    public void verifyClickedCountryPage(@Named("countryDropDown") String countryDropDown) {
        getDataPage().verifyClickedCountryPage(countryDropDown);
    }

    @When("the user clicks on the city subarea link $subArea")
    public void clickOnCitySubArea(@Named("subArea") String subArea){
        getDataPage().clickOnCitySubArea(subArea);
    }

    @When("the user clicks on the city country link $country")
    public void clickOnCityCountry(@Named("country") String country){
        getDataPage().clickOnCityCountry(country);
    }

    @When("the user clicks on the city related place link $relatedPlace")
    public void clickOnCityRelatedPlace(@Named("relatedPlace") String relatedPlace){
        getDataPage().clickOnCityRelatedPlace(relatedPlace);
    }

    @Then("the user should see the below country sections $countrySections")
    public void verifyCountrySections(ExamplesTable countrySections){
        getDataPage().verifySections(countrySections);
    }

    @Then("the user should see the below area sections $areaSections")
    public void verifyAreaSections(ExamplesTable areaSections){
        getDataPage().verifySections(areaSections);
    }

    @Then("the user should see the below city sections $citySections")
    public void verifyCitySections(ExamplesTable citySections){
        getDataPage().verifySections(citySections);
    }

    @Then("the user should see the below legal entity sections $legalEntitySections")
    public void verifyLegalEntitySections(ExamplesTable legalEntitySections){
        getDataPage().verifySections(legalEntitySections);
    }

    @Then("the user should see the below office sections $legalEntitySections")
    public void verifyOfficeSections(ExamplesTable officeSections){
        getDataPage().verifySections(officeSections);
    }

    @Then("the user should see the below fields in the country basic info left section $basicInfoLeftSection")
    public void verifyBasicInfoLeftSection(ExamplesTable basicInfoLeftSection) {
        getDataPage().verifyBasicInfoLeftSection(basicInfoLeftSection);
    }

    @When("the user clicks on the save button")
    public void clickOnSaveButton(){
        getDataPage().clickOnSaveButton();
    }

    @Then("the user should see the save confirmation modal")
    public void verifySaveConfirmationModal(){
        getDataPage().verifySaveConfirmationModal();
    }

    @When("the user clicks on the confirm button")
    public void clickOnConfirmButton(){
        getDataPage().clickOnConfirmButton();
    }

    @When("the user clicks on the return button")
    public void clickOnReturnButton(){
        getDataPage().clickOnReturnButton();
    }

    @When("the user clicks on the cancel no button")
    public void clickOnCancelNoButton() {
        getDataPage().clickOnCancelNoButton();
    }

    @Then("the user should see the list of all existing area for the selected country by full name")
    public void verifyAreaList(){
        getDataPage().verifyAreaList(database, apacheHttpClient);
    }

    @Then("the user should see the list of all existing subarea for the selected area by full name")
    public void verifySubAreaList(){
        getDataPage().verifySubAreaList(database, apacheHttpClient);
    }

    @Then("the user should see the list of all existing city for the selected area by full name")
    public void verifyCityList(){
        getDataPage().verifyCityList(database, apacheHttpClient);
    }
}
