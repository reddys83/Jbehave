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
    public void verifyCountryListBoxIsDisplayed(){
        getDataPage().verifyCountryListBoxIsDisplayed();
    }

    @When("the user clicks on the choose a country option")
    public void userClicksOnCountryListBox(){
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

    @Then("the user should see the currency's uses $currencyUseTable")
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
        getDataPage().verifyCountryBasicInfo();
    }

    @Then("the user should see the list of country names type and value as: $countryNames")
    public void verifyCountryNames(ExamplesTable countryNames){
        getDataPage().verifyCountryNames(countryNames);
    }

    @When("the user clicks on the basic info link in the navigation bar")
    public void clickOnBasicInfoInNavigationBar(){
        getDataPage().clickOnBasicInfoInNavigationBar();
    }

    @Then("the user should see the country demographics info as: $countryDemographics")
    public void verifyCountryDemographics(ExamplesTable countryDemographics){
        getDataPage().verifyCountryDemographics(countryDemographics);
    }

    @Then("the user should see the country identifiers as: $countryIdentifiers")
    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers){
        getDataPage().verifyCountryIdentifiers(countryIdentifiers);
    }

    @Then("the user should see the country banking hours summary as $countryBankingHourSummary")
    public void verifyCountryBankingHourSummary(@Named("countryBankingHourSummary") String countryBankingHourSummary){
        getDataPage().verifyCountryBankingHourSummary(countryBankingHourSummary);
    }

    @Then("the user should see the country banking hours as: $countryBankingHrSummary")
    public void verifyCountryBankingHourSummaryDaysAndHrs(ExamplesTable countryBankingHrSummary){
        getDataPage().verifyCountryBankingHourSummaryDaysAndHrs(countryBankingHrSummary);
    }

    @Then("the user should see the country time zones summary as $countryTimeZonesSummary")
    public void verifyCountryTimeZonesSummary(@Named("countryTimeZonesSummary") String countryTimeZonesSummary){
        getDataPage().verifyCountryTimeZonesSummary(countryTimeZonesSummary);
    }

    @Then("the user should see the country time zones as: $countryTimeZones")
    public void verifyCountryTimeZones(ExamplesTable countryTimeZones){
        getDataPage().verifyCountryTimeZones(countryTimeZones);
    }

    @Then("the user should see the country summary as: $countrySummary")
    public void verifyCountrySummary(ExamplesTable countrySummary){
        getDataPage().verifyCountrySummary(countrySummary);
    }

    @Then("the user should see the country status as $status")
    public void verifyCountryStatus(@Named("status") String status){
        getDataPage().verifyCountryStatus(status);
    }

    @Then("the user should see the country start date as $startDate")
    public void verifyCountryStartDate(@Named("startDate") String startDate){
        getDataPage().verifyCountryStartDate(startDate);
    }

    @Then("the user should see the country end date as $endDate")
    public void verifyCountryEndDate(@Named("endDate") String endDate){
        getDataPage().verifyCountryEndDate(endDate);
    }

    @Then("the user should see the country replaced by as $replacedBy")
    public void verifyCountryReplacedBy(@Named("replacedBy") String replacedBy){
        getDataPage().verifyCountryReplacedBy(replacedBy);
    }

    @Then("the user should see the country imports as $imports")
    public void verifyCountryImports(@Named("imports") String imports){
        getDataPage().verifyCountryImports(imports);
    }

    @Then("the user should see the country exports as $exports")
    public void verifyCountryExport(@Named("exports") String exports){
        getDataPage().verifyCountryExport(exports);
    }

    @Then("the user should see the country intl dialing code as $intlDialCode")
    public void verifyCountryIntlDialCode(@Named("intlDialCode") String intlDialCode){
        getDataPage().verifyCountryIntlDialCode(intlDialCode);
    }

    @Then("the user should see the country political structure as $politicalStructure")
    public void verifyCountryPoliticalStructure(@Named("politicalStructure") String politicalStructure){
        getDataPage().verifyCountryPoliticalStructure(politicalStructure);
    }

    @Then("the user should see the country additional info as $addInfo")
    public void verifyCountryAddInfo(@Named("addInfo") String addInfo){
        getDataPage().verifyCountryAddInfo(addInfo);
    }

    @When("the user clicks on the replaced by country <replacedByCountry> in the country basic info")
    public void clickOnReplacedByCountry(@Named("replacedByCountry") String replacedByCountry){
        getDataPage().clickOnReplacedByCountry(replacedByCountry);
    }

    @When("the user clicks on the country holiday link in the navigation bar")
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

}


