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
public class CurrencySteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;
    private String selectedCurrency;

    @When("the user clicks on the currency tab in the data area")
    public void clickOnCurrencyTab() {
        getDataPage().clickOnCurrencyTab();
    }

    @When("the user clicks on the choose a currency option in the currency page")
    public void clickOnChooseACurrencyOption() {
        setCurrencyPage(getDataPage().clickOnChooseACurrencyOption());
    }

    @Then("the user should see the list of all existing currencies by full name")
    public void verifyCurrencyList() {
        getCurrencyPage().verifyCurrencyList(database, apacheHttpClient);
    }

    @When("the user starts typing the name of a currency as $curr in the currency input box")
    public void enterCurrency(@Named("curr") String curr) {
        getCurrencyPage().enterCurrency(curr);
    }

    @Then("the user should see the drop-down list of the currencies matching the input characters")
    public void thenUserShouldSeeCurrencyDropDownMatchingTheSearchString() {
        getCurrencyPage().verifyCurrencyDropDownMatchesSearchString();
    }

    @Then("the user should see the currencies in the listbox as: $currencyList")
    public void verifyCurrencyInListBox(ExamplesTable currencyList) {
        getCurrencyPage().verifyCurrencyInListBox(currencyList);
    }

    @Then("the user should see the option no results match for the searched currency string")
    public void thenTheUSerShouldNoResultsMatchOption() {
        getCurrencyPage().verifyNoResultsMatchOption();
    }

    @Then("the user should see the currency iso code value as <isoCode> in the currency page")
    public void verifyCurrencyIsoCode(@Named("isoCode") String isoCode) {
        getCurrencyPage().verifyCurrencyIsoCode(isoCode);
    }

    @Then("the user should see the currency name value as <name> in the currency page")
    public void verifyCurrencyName(@Named("name") String name) {
        getCurrencyPage().verifyCurrencyName(name);
    }

    @Then("the user should see the currency abbr value as <abbr> in the currency page")
    public void verifyCurrencyAbbr(@Named("abbr") String abbr) {
        getCurrencyPage().verifyCurrencyAbbr(abbr);
    }

    @Then("the user should see the currency unit value as <unit> in the currency page")
    public void verifyCurrencyUnit(@Named("unit") String unit) {
        getCurrencyPage().verifyCurrencyUnit(unit);
    }

    @Then("the user should see the currency quantity value as <quantity> in the currency page")
    public void verifyCurrencyQuantity(@Named("quantity") String quantity) {
        getCurrencyPage().verifyCurrencyQuantity(quantity);
    }

    @Then("user should see the list of countries in currency edit mode from trusted document")
    public void verifyCountryListInCurrencyEditMode() { getCurrencyPage().verifyCountryListInCurrencyEditMode();}

    @Then("the user should see the edit currency details from trusted document")
    public void verifyEditCurrencyDetailsFromTrusted() {
        getCurrencyPage().verifyEditCurrencyDetailsFromTrusted(selectedCurrency);
    }

    @Then("the user should see the view currency details from trusted document")
    public void verifyViewCurrencyDetailsFromTrusted() {
        getCurrencyPage().verifyViewCurrencyDetailsFromTrusted(database, apacheHttpClient, selectedCurrency);
    }

    @Then("the user should see the view currency use from trusted document")
    public void verifyViewCurrencyUseFromTrusted() {
        getCurrencyPage().verifyViewCurrencyUseFromTrusted(database, apacheHttpClient, selectedCurrency);
    }

    @Then("the user should see the edits to currency details in zeus document")
    public void verifyEditCurrencyInZeus(){
        getCurrencyPage().verifyEditCurrencyInZeus(selectedCurrency);
    }

    @Then("the user should see the edits to currency uses in zeus document")
    public void verifyEditCurrencyUseInZeus() {
        getCurrencyPage().verifyEditCurrencyUseInZeus(selectedCurrency);
    }

    @Then("the user should see the currency uses in edit mode are from trusted document")
    public void verifyCurrencyUseInEditMode() {
        getCurrencyPage().verifyEditCurrencyUseFromTrusted(database, apacheHttpClient, selectedCurrency);
    }

    @Then("the user should return to view currency page mode")
    public void verifyCurrencyViewMode() {
        getCurrencyPage().verifyCurrencyViewMode();
    }

    @Then("the user should see the currency usage is editable for status active")
    public void verifyCurrencyUpdateModeForStatusActive() {
        getCurrencyPage().verifyCurrencyUpdateModeForStatusActive();
    }

    @Then("the user should see the currency usage is editable for status inactive")
    public void verifyCurrencyUpdateModeForStatusInactive() {
        getCurrencyPage().verifyCurrencyUpdateModeForStatusInactive();
    }

    @Then("the user should not see the currency's uses in the currency page")
    public void verifyNoCurrencyUse() {
        getCurrencyPage().verifyNoCurrencyUse();
    }

    @When("the user clicks on the replaced by currency $replacedBy in the currency page")
    public void clickOnReplacedByLink(String replacedBy) {
        getCurrencyPage().clickOnReplacedByLink(replacedBy);
    }

    @When("the user clicks on the country <currencyUsageCountry> in the currency usage")
    public void clickOnCurrencyUsageCountry(@Named("currencyUsageCountry") String currencyUsageCountry) {
        getCurrencyPage().clickOnCurrencyUsageCountry(currencyUsageCountry);
    }

    @When("the user clicks on the country iso3 $iso3 in the currency usage")
    public void clickOnCurrencyIso3(@Named("iso3") String iso3) {
        getCurrencyPage().clickOnCurrencyIso3(iso3);
    }

    @When("the user enters the currency name value as <name> in the currency page")
    public void enterCurrencyName(@Named("name") String name) {
        getCurrencyPage().enterCurrencyName(name);
    }

    @When("the user enters the currency abbr value as <abbr> in the currency page")
    public void enterCurrencyAbbr(@Named("abbr") String abbr) {
        getCurrencyPage().enterCurrencyAbbr(abbr);
    }

    @When("the user enters the currency unit value as <unit> in the currency page")
    public void enterCurrencyUnit(@Named("unit") String unit) {
        getCurrencyPage().enterCurrencyUnit(unit);
    }

    @When("the user enters the currency quantity value as <quantity> in the currency page")
    public void enterCurrencyQuantity(@Named("quantity") String quantity) {
        getCurrencyPage().enterCurrencyQuantity(quantity);
    }

    @Then("the user should see the currency page for clicked iso name")
    public void verifyCurrencyPageForClickedISOName(){
        getCurrencyPage().verifyCurrencyPageForClickedISOName();
    }

    @Then("the user should return to edit currency page mode")
    public void verifyCurrencyEditMode(){
        getCurrencyPage().verifyCurrencyEditMode();
    }

    @Then("the user should see the list of all other existing currencies (by name) excluding the currency they are currently viewing")
    public void verifyReplacedByCurrencyList() {
        getCurrencyPage().verifyReplacedByCurrencyList(database, apacheHttpClient, selectedCurrency);
    }

    @When("the user selects the currency country as <currencyCountry> in the currency page")
    public void selectCurrencyCountry(@Named("currencyCountry") String currencyCountry){
        getCurrencyPage().selectCurrencyCountry(currencyCountry);
    }

    @When("the user enters the currency start day as <currencyStartDay> in the currency page")
    public void enterCurrencyStartDay(@Named("currencyStartDay") String currencyStartDay){
        getCurrencyPage().enterCurrencyStartDay(currencyStartDay);
    }

    @When("the user enters the currency new start day as <currencyStartDay> in the currency page")
    public void enterCurrencyNewStartDay(@Named("currencyStartDay") String currencyStartDay){
        getCurrencyPage().enterCurrencyNewStartDay(currencyStartDay);
    }

    @When("the user clicks on the currency start month drop-down in the currency page")
    public void clickOnCurrencyStartMonthDropDown(){
        getCurrencyPage().clickOnCurrencyStartMonthDropDown();
    }

    @When("the user enters the currency start month as <currencyStartMonth> in the currency page")
    public void enterCurrencyStartMonth(@Named("currencyStartMonth") String currencyStartMonth) {
        getCurrencyPage().enterCurrencyStartMonth(currencyStartMonth);
    }

    @When("the user enters the currency start year as <currencyStartYear> in the currency page")
    public void enterCurrencyStartYear(@Named("currencyStartYear") String currencyStartYear) {
        getCurrencyPage().enterCurrencyStartYear(currencyStartYear);
    }

    @When("the user enters the currency new start month as <currencyStartMonth> in the currency page")
    public void enterCurrencyNewStartMonth(@Named("currencyStartMonth") String currencyStartMonth) {
        getCurrencyPage().enterCurrencyNewStartMonth(currencyStartMonth);
    }

    @When("the user enters the currency new start year as <currencyStartYear> in the currency page")
    public void enterCurrencyNewStartYear(@Named("currencyStartYear") String currencyStartYear) {
        getCurrencyPage().enterCurrencyNewStartYear(currencyStartYear);
    }


    @When("the user enters the currency end day as <currencyEndDay> in the currency page")
    public void enterCurrencyEndDay(@Named("currencyEndDay") String currencyEndDay){
        getCurrencyPage().enterCurrencyEndDay(currencyEndDay);
    }

    @When("the user enters the currency end month as <currencyEndMonth> in the currency page")
    public void enterCurrencyEndMonth(@Named("currencyEndMonth") String currencyEndMonth){
        getCurrencyPage().enterCurrencyEndMonth(currencyEndMonth);
    }

    @When("the user enters the currency end year as <currencyEndYear> in the currency page")
    public void enterCurrencyEndYear(@Named("currencyEndYear") String currencyEndYear){
        getCurrencyPage().enterCurrencyEndYear(currencyEndYear);
    }

    @When("the user enters the $primary_radio_button value as <primary> in the currency page")
    public void enterCurrencyPrimary(@Named("primary_radio_button") String primary_radio_button,@Named("primary") String primary){
        getCurrencyPage().enterCurrencyPrimary(primary_radio_button,primary);
    }

    @When("the user enters the currency usage replaced by as <replacedBy> in the currency page")
    public void enterCurrencyReplacedBy(@Named("replacedBy") String replacedBy){
        getCurrencyPage().enterCurrencyReplacedBy(replacedBy);
    }

    @When("the user enters the country <addCurrencyCountry> in the add country type-ahead box")
    public void enterCountryInAddCountryTyAhead(@Named("addCurrencyCountry") String addCurrencyCountry) {
        getCurrencyPage().enterCountryInAddCountryTyAhead(addCurrencyCountry);
    }

    @When("the user enters the country <addSecondCurrencyCountry> in the add country type-ahead box")
    public void enterSecondCountryInAddCountryTyAhead(@Named("addSecondCurrencyCountry") String addSecondCurrencyCountry) {
        getCurrencyPage().enterCountryInAddCountryTyAhead(addSecondCurrencyCountry);
    }


    @When("the user enters the country <currencyCountry> in the currency usage")
    public void enterCountryInCurrencyUsage(@Named("currencyCountry") String currencyCountry) {
        getCurrencyPage().enterCountryInCurrencyUsage(currencyCountry);
    }

    @When("the user clicks on the delete option for the additional currency use")
    public void clickOnDeleteUseOption(){
        getCurrencyPage().clickOnDeleteUseOption();
    }

    @Then("the user should not see the additional currency use")
    public void verifyNoAdditionalCurrencyUse(){
        getCurrencyPage().verifyNoAdditionalCurrencyUse();
    }

    @Then("the user should see the error message enter up to 30 valid characters for abbreviation in the currency page")
    public void verifyErrorMessageForCurrAbbr(){
        getCurrencyPage().verifyErrorMessageForCurrAbbr();
    }

    @Then("the user should see the error message enter up to 100 valid characters for name in the currency page")
    public void verifyErrorMessageForCurrName(){
        getCurrencyPage().verifyErrorMessageForCurrName();
    }

    @Then("the user should see the error message enter up to 100 valid characters for unit in the currency page")
    public void verifyErrorMessageForCurrUnit(){
        getCurrencyPage().verifyErrorMessageForCurrUnit();
    }

    @Then("the user should see the error message enter a numeric value up to 10,000 for quantity in the currency page")
    public void verifyErrorMessageForCurrQuantity(){
        getCurrencyPage().verifyErrorMessageForCurrQuantity();
    }

    @Then("the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved")
    public void verifyErrorMessageAtTopOfThePage(){
        getDataPage().verifyErrorMessageAtTopOfThePage();
    }

    @When("the user clicks on the no button in the delete row confirmation modal in the currency page")
    public void clickOnNoButtonInDeleteConfirmationModalInCurrency() {
        getCurrencyPage().clickOnNoButtonInDeleteConfirmationModalInCurrency();
    }

    @When("the user clicks on the yes button in the delete row confirmation modal in the currency page")
    public void clickOnYesButtonInDeleteConfirmationInCurrency() {
        getCurrencyPage().clickOnYesButtonInDeleteConfirmationInCurrency();
    }

    @Then("the user should see the newly added usage in the currency page")
    public void verifyNoNewlyAddedCurrencyUsage(){
        getCurrencyPage().verifyNewlyAddedCurrencyUsage();
    }

    @Then("the user should not see the newly added usage in the currency page")
    public void verifyNewlyAddedCurrnecyUsage() {
        getCurrencyPage().verifyNoNewlyAddedCurrencyUsage();
    }

    @Then("the user should see the error message for the required name field in the currency page")
    public void verifyErrorMessageForRequiredField(){
        getCurrencyPage().verifyErrorMessageForRequiredField();
    }

    @When("the user clicks on the add country type-ahead option")
    public void clickOnAddCountryOption(){
        getCurrencyPage().clickOnAddCountryOption();
    }

    @Then("the user should see the primary equals to true by default")
    public void verifyPrimaryTrueByDefault(){
        getCurrencyPage().verifyPrimaryTrueByDefault();
    }

    @Then("the user should see the status equals to active by default")
    public void verifyStatusActiveByDefault(){
        getCurrencyPage().verifyStatusActiveByDefault();
    }

    @Then("the user should see the list of all the existing country in add country list")
    public void verifyAddCountryList() {
        getCurrencyPage().verifyAddCountryList(database, apacheHttpClient);
    }

    @When("the user enters the currency <currency> in the typeahead box in the currency page")
    public void selectCurrencyFromTypeAhead(@Named("currency") String currency) {
        selectedCurrency = currency;
        getCurrencyPage().selectCurrencyFromTypeAhead(currency);
    }
    @Then("the user should see the delete row confirmation modal in the currency page")
    public void verifyDeleteConfirmationModalInCurrency() {
        getCurrencyPage().verifyDeleteConfirmationModalInCurrency();
    }

    @When("the user clicks on delete currency usage")
      public void clickOnDeleteCurrencyUsage() {
        getCurrencyPage().clickOnDeleteCurrencyUsage();
    }
    @Then("the user should see the currency page")
    public void verifyCurrencyPage() {
        getCurrencyPage().verifyCurrencyPage();
    }

    @Then("the user should see confirmation message")
    public void verifyCurrencySaveConfirmationMessage(){getCurrencyPage().verifySaveConfirmationMessage();}

    @Then("the user should see the $duplicatePrimaryError as $duplicateErrorMsg for $numberOfRows rows")
    public void verifyDuplicatePrimaryCurrencyErrorMessage(@Named("duplicatePrimayError") String duplicatePrimaryError,@Named("duplicateErrorMsg") String duplicateErrorMsg,@Named("numberOfRows") int numberOfRows) {
        getCurrencyPage().verifyDuplicatePrimaryCurrencyErrorMessage(duplicatePrimaryError,duplicateErrorMsg,numberOfRows);
    }

}
