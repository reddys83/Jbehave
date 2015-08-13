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

    @Then("the user should see the option no results match for the searched string")
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

    @Then("the country list box is displayed")
    public void verifyCountryListBoxIsDisplayed(){
        getDataPage().verifyCountryListBoxIsDisplayed();
    }

    @When("the user clicks on the country list box")
    public void userClicksOnCountryListBox(){
        getDataPage().clickOnCountryListBox();
    }

    @Then("the countries type ahead and list is displayed")
    public void verifyCountryTypeAheadAndListBox(){
        getDataPage().verifyCountryTypeAheadAndListBox();
    }

    @Then("the list matches the expected country list and is sorted")
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
}

