package com.accuity.zeus.aft.jbehave.pages;


import com.accuity.zeus.aft.commons.DataManagementAppVals;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DataPage extends AbstractPage {

    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By country_tab_xpath=By.xpath("//*[@id='data-navbar']/ul/li[2]");
    private By currency_label_xpath = By.xpath("//*[@id='data']/dl/dt[1]");
    private By currency_list_xpath = By.xpath("//*[@class='chosen-results']/li");
    private By choose_currency_option_xpath = By.xpath("//*[@id='entitySelect_chosen']/a/span");
    private By currency_input_xpath = By.xpath("//*[@class='chosen-search']/input");
    private By no_results_match_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By currency_iso_code_label_id = By.id("iso");
    private By currency_iso_code_id = By.id("iso-value");
    private By currency_name_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[1]");
    private By currency_name_xpath = By.xpath("//*[@id='content']/div/dl[1]/dd[1]");
    private By currency_abbr_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[2]");
    private By currency_abbr_xpath = By.xpath("//div[@id='content']//dd[2]");
    private By currency_unit_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[3]");
    private By currency_unit_xpath = By.xpath("//*[@id='content']/div/dl[1]/dd[3]");
    private By currency_quantity_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[4]");
    private By currency_quantity_xpath = By.xpath("//div[@id='content']//dd[4]");
    String currency_use_table_xpath_string = "//*[@id='content']/div/table/tbody/tr[";
    private By currency_use_table_header_xpath = By.xpath("//*[@id='content']/div/table/thead/tr");
    private By country_listbox_id= By.id("entitySelect_chosen");
    private By country_type_ahead_xpath=By.xpath("//*[@class='chosen-search']/input");
    private String currencySearchString = null;
    private By country_iso2_label_id = By.id("iso2");
    private By country_iso2_id = By.id("iso2-value");
    private By country_iso3_label_id = By.id("iso3");
    private By country_iso3_id = By.id("iso3-value");
    private By country_basic_info_xpath = By.xpath("//*[@id='content']/div/ul/li/h1/span");
    private By country_names_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[1]");
    private By country_names_type_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[1]");
    private By country_names_value_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[2]");
    private By country_names_type_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[1]");
    private By country_names_value_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[2]");
    private By basic_info_link_id = By.id("basicInfo");
    private By country_demographics_type_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[1]");
    private By country_demographics_value_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[2]");
    private By country_demographics_unit_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[3]");
    private By country_demographics_date_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[4]");
    private By country_demographics_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[2]");
    private By country_demographics_type_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[1]");
    private By country_demographics_value_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[2]");
    private By country_demographics_unit_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[3]");
    private By country_demographics_date_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[4]");
    private By country_identifiers_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[3]");
    private By country_identifiers_type_label_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/thead/tr/th[1]");
    private By country_identifiers_value_label_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/thead/tr/th[2]");
    private By country_identifiers_status_label_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/thead/tr/th[3]");
    private By country_identifiers_type_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/tbody/tr/td[1]");
    private By country_identifiers_value_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/tbody/tr/td[2]");
    private By country_identifiers_status_xpath = By.xpath("//*[@id='content']//li[1]/table[3]/tbody/tr/td[3]");
    private By country_banking_hr_summary_label_xpath = By.xpath("//*[@id='content']//li[1]/dl[1]/dt");
    private By country_banking_hr_summary_xpath = By.xpath("//*[@id='content']//li[1]/dl[1]/dd");
    private By country_banking_hrs_label_xpath =  By.xpath("//*[@id='content']//li[1]/h2[4]");
    private By country_banking_hrs_day_label_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[1]");
    private By country_banking_hrs_hrs_label_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[2]");
    private By country_banking_hrs_day_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[1]");
    private By country_banking_hrs_hrs_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[2]");
    private By country_time_zones_summary_label_xpath = By.xpath("//*[@id='content']//li[1]/dl[2]/dt");
    private By country_time_zones_summary_xpath = By.xpath("//*[@id='content']//li[1]/dl[2]/dd");
    private By country_time_zones_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[5]");
    private By country_time_zones_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/th");
    private By country_time_zones_value_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/td");
    private By country_summary_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/th");
    private By country_summary_value_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/td");
    private By country_status_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[1]/th");
    private By country_status_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[1]/td");
    private By country_start_date_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[2]/th");
    private By country_start_date_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[2]/td");
    private By country_end_date_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[3]/th");
    private By country_end_date_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[3]/td");
    private By country_replaced_by_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[4]/th");
    private By country_replaced_by_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[4]/td");
    private By country_exports_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[7]/th");
    private By country_exports_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[7]/td");
    private By country_intl_dial_code_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[8]/th");
    private By country_intl_dial_code_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[8]/td");
    private By country_political_structure_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[9]/th");
    private By country_political_structure_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[9]/td");
    private By country_add_info_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[5]/th");
    private By country_add_info_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[5]/td");
    private By country_imports_label_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[6]/th");
    private By country_imports_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr[6]/td");
    private By country_name_selected_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr[1]/td[2]");
    private By currency_usage_label_xpath = By.xpath("//*[@id='content']/div/dl[2]/dt");
    private By currency_usage_xpath = By.xpath("//*[@id='content']/div/dl[2]/dd/a");
    private By country_holidays_link_id = By.id("holidays");
    private By country_holiday_label_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//span");
    private By country_holiday_for_label_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//h2");
    private By country_holiday_table_header_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//thead");
    private By country_holiday_date_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[1]");
    private By country_holiday_description_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[2]");
    private By country_holiday_notes_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[3]");
    private By country_payments_link_id = By.id("payments");
    private By country_payments_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//span");
    private By country_payments_iban_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//h2[1]");
    private By country_payments_status_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[1]");
    private By country_payments_iso_code_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[2]");
    private By country_payments_registered_date_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[3]");
    private By country_payments_code_type_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[4]");
    private By country_payments_status_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[1]");
    private By country_payments_iso_code_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[2]");
    private By country_payments_registered_date_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[3]");
    private By country_payments_code_type_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[4]");
    private By country_payments_routing_code_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//h2[2]");
    private By country_payments_routing_codes_types_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[2]//th[1]");
    private By country_payments_routing_code_code_types_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[2]//td");
    private By country_regions_link_id = By.id("regions");
    private By country_regions_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//span");
    private By country_alt_regions_for_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//h2");
    private By country_regions_type_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/th[1]");
    private By country_regions_value_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/th[2]");
    private By country_regions_type_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/td[1]");
    private By country_regions_value_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/td[2]");

    private By currency_update_link_id = By.id("update-link");
    private By currency_input_name_xpath = By.xpath("//input[@name='name']");
    private By currency_input_abbr_xpath = By.xpath("//input[@name='abbr']");
    private By currency_input_unit_xpath = By.xpath("//input[@name='unit']");
    private By currency_input_quantity_xpath = By.xpath("//input[@name='quantity']");
    private By save_button_id = By.id("save-button");
    private By cancel_button_id = By.id("cancel-button");

    private String selectedCountry = "";


    public DataPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void clickOnCurrencyTab() {
        attemptClick(currency_tab_xpath);
    }

    public void clickOnChooseACurrencyOption() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(choose_currency_option_xpath).click();
    }

    public void verifyCurrencyList() {
        assertEquals(getDriver().findElement(currency_label_xpath).getText(), "CURRENCY");
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        assertTrue(currencyList.size() > 0);
    }

    public void enterCurrency(String curr) {
        currencySearchString = curr;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(currency_input_xpath).sendKeys(curr);
    }

    public void verifyCurrencyDropDownMatchesSearchString() {
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        for(int i=0; i<currencyList.size(); i++){
            assertTrue(currencyList.get(i).getText().toLowerCase().contains(currencySearchString.toLowerCase()));
        }
    }

    public void verifyNoResultsMatchOption() {
        assertEquals("No results match \"" + currencySearchString + "\"", getDriver().findElement(no_results_match_xpath).getText());
    }

    public void selectCurrencyFromTypeAhead(String currency) {
        getDriver().findElement(currency_input_xpath).sendKeys(currency);
        getDriver().findElement(currency_input_xpath).sendKeys(Keys.RETURN);
    }

    public void verifyCurrencyIsoCode(String isoCode) {
        assertEquals("ISO", getTextOnPage(currency_iso_code_label_id));
        assertEquals(isoCode, getTextOnPage(currency_iso_code_id));
    }

    public void verifyCurrencyName(String name) {
        assertEquals("Name", getTextOnPage(currency_name_label_xpath));
        assertEquals(name, getTextOnPage(currency_name_xpath));
    }

    public void verifyCurrencyAbbr(String abbr) {
        assertEquals("Abbr", getTextOnPage(currency_abbr_label_xpath));
        assertEquals(abbr, getTextOnPage(currency_abbr_xpath));
    }

    public void verifyCurrencyUnit(String unit) {
        assertEquals("Unit", getTextOnPage(currency_unit_label_xpath));
        if(unit.equals("null")){
            assertTrue(null == getTextOnPage(currency_unit_xpath));
        } else {
            assertEquals(unit, getTextOnPage(currency_unit_xpath));
        }

    }

    public void verifyCurrencyQuantity(String quantity) {
        assertEquals("Quantity", getTextOnPage(currency_quantity_label_xpath));
        if(quantity.equals("null")){
            assertTrue(null == getTextOnPage(currency_quantity_xpath));
        } else {
            assertEquals(quantity, getTextOnPage(currency_quantity_xpath));
        }
    }

    public void clickOnCountryTab() {
        attemptClick(country_tab_xpath);
    }

    public void verifyCountryListBoxIsDisplayed() {
        assertTrue(getDriver().findElement(country_listbox_id).isDisplayed());
    }

    public void clickOnCountryListBox() {
        getDriver().findElement(country_listbox_id).click();
    }

    public void verifyCountryTypeAheadAndListBox() {
        assertTrue(getDriver().findElement(country_type_ahead_xpath).isDisplayed());
        assertFalse(getDriver().findElement(country_listbox_id).getText().isEmpty());

    }

    //=CHAR(34)&A1&CHAR(34)&","
    public void verifyCountryListValues() {
        List<String> retCountryListVal = new ArrayList<>(Arrays.asList(getDriver().findElement(country_listbox_id).getText().split("\n")));
        assertTrue(DataManagementAppVals.expCountryListVal.size() == retCountryListVal.size());
        for (int i = 0; i <=DataManagementAppVals.expCountryListVal.size()-1; i++) {
            if (retCountryListVal.get(i).equals(DataManagementAppVals.expCountryListVal.get(i))) {
                continue;
            }
                else {
                System.out.println("The returned country list has the value " + retCountryListVal.get(i) + " but the expected country list has the value " + DataManagementAppVals.expCountryListVal.get(i));
                assertTrue(false);
                break;
            }
        }
    }

    public void enterValueInCountryTypeAhead(String word) {
        getDriver().findElement(country_type_ahead_xpath).sendKeys(word);
    }

    public void verifyCountriesInListBox(ExamplesTable countryList) {
        String[] expCountryList = getDriver().findElement(country_listbox_id).getText().split("\n");
        for (int i=0; i<=countryList.getRowCount()-1;i++){
            assertTrue(countryList.getRow(i).containsValue(expCountryList[i + 1]));
        }
    }

    public void verifyCurrencyUse(ExamplesTable currencyUseTable) {
        verifyCurrencyUseTableHeaders();
        for(int i=0; i<currencyUseTable.getRowCount(); i++){

            assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(0)),
                    getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[1]")));

            assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(1)),
                    getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i+1) + "]/td[2]")));

            if(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(2)).isEmpty()){} else{
                assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(2)),
                        getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[3]")));
            }

            assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(3)),
                    getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i+1) + "]/td[4]")));

            if(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(4)).isEmpty()){} else {
                assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(4)),
                        getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[5]")));
            }

            if(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(5)).isEmpty()){} else {
                assertEquals(currencyUseTable.getRow(i).get(currencyUseTable.getHeaders().get(5)),
                        getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[6]")));
            }
       }
    }

    public void verifyCurrencyUseTableHeaders() {
            assertEquals(getTextOnPage(currency_use_table_header_xpath).replace("/n", "").replace("/r", ""), "COUNTRY START DATE END DATE PRIMARY REPLACED BY STATUS");
        }

    public void verifyNoCurrencyUse() {
        try {
            assertNull(getDriver().findElement(currency_use_table_header_xpath));
        } catch(Exception NoSuchElementException){}
    }

    public void clickOnReplacedByLink(String replacedBy) {
        attemptClick(By.linkText(replacedBy));
    }

    public void verifyCurrencyInListBox(ExamplesTable currencyList) {
        String[] expCurrencyList = getDriver().findElement(currency_list_xpath).getText().split("\n");
        for (int i=0; i<=currencyList.getRowCount()-1;i++){
            assertTrue(currencyList.getRow(i).containsValue(expCurrencyList[i+1]));
        }
    }

    public void enterCountryInTheTypeAheadBox(String country) {
        selectedCountry = country;
        getDriver().findElement(country_type_ahead_xpath).sendKeys(country);
        getDriver().findElement(country_type_ahead_xpath).sendKeys(Keys.RETURN);
    }

    public void verifyCountryIso2(String iso2) {
        assertEquals("ISO2", getDriver().findElement(country_iso2_label_id).getText());
        assertEquals(iso2, getDriver().findElement(country_iso2_id).getText());
    }

    public void verifyCountryIso3(String iso3) {
        assertEquals("ISO3",getDriver().findElement(country_iso3_label_id).getText());
        assertEquals(iso3, getDriver().findElement(country_iso3_id).getText());
    }

    public void verifyCountryBasicInfo() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(selectedCountry, getDriver().findElement(country_name_selected_xpath).getText());
        assertEquals("BASIC INFO", getDriver().findElement(country_basic_info_xpath).getText());
    }


    public void verifyCountryNames(ExamplesTable countryNames) {
        assertEquals("NAMES", getDriver().findElement(country_names_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_names_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(country_names_value_label_xpath).getText());
        List<WebElement> actCountryNameTypes = getDriver().findElements(country_names_type_xpath);
        List<WebElement> actCountryNameValue = getDriver().findElements(country_names_value_xpath);
        for(int i = 0; i<countryNames.getRowCount(); i++){
            assertEquals(countryNames.getRow(i).get(countryNames.getHeaders().get(0)),actCountryNameTypes.get(i).getText());
            assertEquals(countryNames.getRow(i).get(countryNames.getHeaders().get(1)),actCountryNameValue.get(i).getText());
        }

    }

    public void clickOnBasicInfoInNavigationBar() {
        attemptClick(basic_info_link_id);
    }

    public void verifyCountryDemographics(ExamplesTable countryDemographics) {
        assertEquals("DEMOGRAPHICS", getDriver().findElement(country_demographics_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(country_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(country_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(country_demographics_date_label_xpath).getText());
        List<WebElement> actCountryDemoTypes = getDriver().findElements(country_demographics_type_xpath);
        List<WebElement> actCountryDemoValue = getDriver().findElements(country_demographics_value_xpath);
        List<WebElement> actCountryDemoUnit = getDriver().findElements(country_demographics_unit_xpath);
        List<WebElement> actCountryDemoDate = getDriver().findElements(country_demographics_date_xpath);
        for(int i = 0; i<countryDemographics.getRowCount(); i++){
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(0)),actCountryDemoTypes.get(i).getText());
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(1)),actCountryDemoValue.get(i).getText());
            if(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(2)).isEmpty()){} else {
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(2)),actCountryDemoUnit.get(i).getText());}
            if(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(3)).isEmpty()){} else {
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(3)),actCountryDemoDate.get(i).getText());}
        }
    }

    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers) {
        assertEquals("IDENTIFIERS", getDriver().findElement(country_identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(country_identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(country_identifiers_status_label_xpath).getText());
        List<WebElement> actCountryIdentifiersTypes = getDriver().findElements(country_identifiers_type_xpath);
        List<WebElement> actCountryIdentifiersValue = getDriver().findElements(country_identifiers_value_xpath);
        List<WebElement> actCountryIdentifiersStatus = getDriver().findElements(country_identifiers_status_xpath);
        for(int i = 0; i<countryIdentifiers.getRowCount(); i++) {
            assertEquals(countryIdentifiers.getRow(i).get(countryIdentifiers.getHeaders().get(0)), actCountryIdentifiersTypes.get(i).getText());
            assertEquals(countryIdentifiers.getRow(i).get(countryIdentifiers.getHeaders().get(1)), actCountryIdentifiersValue.get(i).getText());
            assertEquals(countryIdentifiers.getRow(i).get(countryIdentifiers.getHeaders().get(2)), actCountryIdentifiersStatus.get(i).getText());
        }
    }

    public void verifyCountryBankingHourSummary(String countryBankingHourSummary) {
        assertEquals("Summary", getDriver().findElement(country_banking_hr_summary_label_xpath).getText());
        assertEquals(countryBankingHourSummary, getDriver().findElement(country_banking_hr_summary_xpath).getText());
    }

    public void verifyCountryBankingHourSummaryDaysAndHrs(ExamplesTable countryBankingHrSummary) {
        assertEquals("BANKING HOURS", getDriver().findElement(country_banking_hrs_label_xpath).getText());
        assertEquals("DAY", getDriver().findElement(country_banking_hrs_day_label_xpath).getText());
        assertEquals("HOURS", getDriver().findElement(country_banking_hrs_hrs_label_xpath).getText());
        List<WebElement> actCountryBankingHrsDay = getDriver().findElements(country_banking_hrs_day_xpath);
        List<WebElement> actCountryBankingHrsHours = getDriver().findElements(country_banking_hrs_hrs_xpath);
        for(int i = 0; i<countryBankingHrSummary.getRowCount(); i++) {
            assertEquals(countryBankingHrSummary.getRow(i).get(countryBankingHrSummary.getHeaders().get(0)), actCountryBankingHrsDay.get(i).getText());
            assertEquals(countryBankingHrSummary.getRow(i).get(countryBankingHrSummary.getHeaders().get(1)), actCountryBankingHrsHours.get(i).getText());
        }
    }

    public void verifyCountryTimeZonesSummary(String countryTimeZonesSummary) {
        assertEquals("Summary", getDriver().findElement(country_time_zones_summary_label_xpath).getText());
        assertEquals(countryTimeZonesSummary, getDriver().findElement(country_time_zones_summary_xpath).getText());
    }

    public void verifyCountryTimeZones(ExamplesTable countryTimeZones) {
        assertEquals("TIME ZONES", getDriver().findElement(country_time_zones_label_xpath).getText());
        List<WebElement> actCountryTimeZone = getDriver().findElements(country_time_zones_xpath);
        List<WebElement> actCountryTimeZoneValue = getDriver().findElements(country_time_zones_value_xpath);
        for(int i = 0; i<countryTimeZones.getRowCount(); i++) {
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(0)), actCountryTimeZone.get(i).getText());
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(1)), actCountryTimeZoneValue.get(i).getText());
        }
    }

    public void verifyCountrySummary(ExamplesTable countrySummary) {
        List<WebElement> actCountrySummary = getDriver().findElements(country_summary_xpath);
        List<WebElement> actCountrySummaryValue= getDriver().findElements(country_summary_value_xpath);
        for(int i = 0; i<countrySummary.getRowCount(); i++) {
            assertEquals(countrySummary.getRow(i).get(countrySummary.getHeaders().get(0)), actCountrySummary.get(i).getText());
            System.out.println(countrySummary.getRow(i).get(countrySummary.getHeaders().get(1)) + actCountrySummaryValue.get(i).getText());
            assertEquals(countrySummary.getRow(i).get(countrySummary.getHeaders().get(1)), actCountrySummaryValue.get(i).getText());
        }
    }

    public void verifyCountryStatus(String status) {
        assertEquals("Status", getDriver().findElement(country_status_label_xpath).getText());
        assertEquals(status, getDriver().findElement(country_status_xpath).getText());
    }

    public void verifyCountryStartDate(String startDate) {
        assertEquals("Start Date", getDriver().findElement(country_start_date_label_xpath).getText());
        assertEquals(startDate, getDriver().findElement(country_start_date_xpath).getText());
    }

    public void verifyCountryEndDate(String endDate) {
        assertEquals("End Date", getDriver().findElement(country_end_date_label_xpath).getText());
        assertEquals(endDate, getDriver().findElement(country_end_date_xpath).getText());
    }

    public void verifyCountryReplacedBy(String replacedBy) {
        assertEquals("Replaced By", getDriver().findElement(country_replaced_by_label_xpath).getText());
        String replacedBys[] = replacedBy.split(" ");
        for(int i=0; i<replacedBys.length; i++){
            assertTrue(getDriver().findElement(country_replaced_by_xpath).getText().contains(replacedBys[i].replace(",","")));
        }
    }

    public void verifyCountryExport(String exports) {
        assertEquals("Exports", getDriver().findElement(country_exports_label_xpath).getText());
        assertEquals(exports, getDriver().findElement(country_exports_xpath).getText());
    }

    public void verifyCountryIntlDialCode(String intlDialCode) {
        assertEquals("Intl Dialing Code", getDriver().findElement(country_intl_dial_code_label_xpath).getText());
        assertEquals(intlDialCode, getDriver().findElement(country_intl_dial_code_xpath).getText());
    }

    public void verifyCountryPoliticalStructure(String politicalStructure) {
        assertEquals("Political Structure", getDriver().findElement(country_political_structure_label_xpath).getText());
        assertEquals(politicalStructure, getDriver().findElement(country_political_structure_xpath).getText());
    }

    public void verifyCountryAddInfo(String addInfo) {
        assertEquals("Add Info", getDriver().findElement(country_add_info_label_xpath).getText());
        assertEquals(addInfo, getDriver().findElement(country_add_info_xpath).getText());
    }

    public void verifyCountryImports(String imports) {
        assertEquals("Imports", getDriver().findElement(country_imports_label_xpath).getText());
        assertEquals(imports, getDriver().findElement(country_imports_xpath).getText());
    }

    public void clickOnReplacedByCountry(String replacedByCountry) {
        selectedCountry = replacedByCountry;
        attemptClick(By.linkText(replacedByCountry));
    }

    public void verifyCountriesCurrencyUsage(ExamplesTable currencyCountries) {
        assertEquals("USAGE", getDriver().findElement(currency_usage_label_xpath).getText());
        for (int i = 0; i<currencyCountries.getRowCount(); i++){
            assertEquals(currencyCountries.getRow(i).get(currencyCountries.getHeaders().get(0)), getDriver().findElements(currency_usage_xpath).get(i).getText());
        }
    }

    public void clickOnCurrencyUsageCountry(String currencyUsageCountry) {
        selectedCountry = currencyUsageCountry;
        attemptClick(By.linkText(currencyUsageCountry));
    }

    public void clickOnCurrencyIso3(String iso3) {
        attemptClick(By.linkText(iso3));
    }
    public void clickOnCountryHolidays() {
        attemptClick(country_holidays_link_id);
    }

    public void verifyCountryHolidays(ExamplesTable countryHolidaysList) {
        assertEquals("HOLIDAYS", getDriver().findElement(country_holiday_label_xpath).getText());
        assertEquals("PUBLIC HOLIDAYS FOR " + selectedCountry.toUpperCase(), getDriver().findElement(country_holiday_for_label_xpath).getText());
        assertEquals("DATE DESCRIPTION NOTES", getDriver().findElement(country_holiday_table_header_xpath).getText());
        List<WebElement> dates = getDriver().findElements(country_holiday_date_xpath);
        List<WebElement> description = getDriver().findElements(country_holiday_description_xpath);
        List<WebElement> notes = getDriver().findElements(country_holiday_notes_xpath);
        for (int i=0; i<countryHolidaysList.getRowCount(); i++){
            assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(0)), dates.get(i).getText());
            if(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(1)).isEmpty()){} else{
            assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(1)), description.get(i).getText());}
            if(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(2)).isEmpty()){} else{
            assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(2)), notes.get(i).getText());}
        }
    }

    public void verifyNoCountryHolidays() {
        assertEquals("HOLIDAYS", getDriver().findElement(country_holiday_label_xpath).getText());
        assertEquals("PUBLIC HOLIDAYS FOR " + selectedCountry.toUpperCase(), getDriver().findElement(country_holiday_for_label_xpath).getText());
        assertEquals("DATE DESCRIPTION NOTES", getDriver().findElement(country_holiday_table_header_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_holiday_date_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void clickOnCountryPayments() {
        attemptClick(country_payments_link_id);
    }

    public void verifyCountryPaymentsIban(ExamplesTable countryPaymentsIban) {
        assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("IBAN", getDriver().findElement(country_payments_iban_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(country_payments_status_label_xpath).getText());
        assertEquals("ISO CODE", getDriver().findElement(country_payments_iso_code_label_xpath).getText());
        assertEquals("REGISTERED DATE", getDriver().findElement(country_payments_registered_date_label_xpath).getText());
        assertEquals("IBAN ROUTING CODE TYPE", getDriver().findElement(country_payments_code_type_label_xpath).getText());
        List<WebElement> status = getDriver().findElements(country_payments_status_xpath);
        List<WebElement> isoCode = getDriver().findElements(country_payments_iso_code_xpath);
        List<WebElement> registeredDate = getDriver().findElements(country_payments_registered_date_xpath);
        List<WebElement> ibanRoutingCode = getDriver().findElements(country_payments_code_type_xpath);
        for(int i=0; i<countryPaymentsIban.getRowCount(); i++){
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(0)),status.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(1)),isoCode.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(2)),registeredDate.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(3)),ibanRoutingCode.get(i).getText());
        }
    }

    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes) {
        assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("ROUTING CODE TYPES IN " + selectedCountry.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
        List<WebElement> types = getDriver().findElements(country_payments_routing_code_code_types_xpath);
        for (int i=0; i<countryPaymentsRoutingCodesTypes.getRowCount(); i++){
            assertEquals(countryPaymentsRoutingCodesTypes.getRow(i).get(countryPaymentsRoutingCodesTypes.getHeaders().get(0)),types.get(i).getText());
        }
    }

    public void verifyCountryNoIbanInfo() {
        assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("IBAN", getDriver().findElement(country_payments_iban_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(country_payments_status_label_xpath).getText());
        assertEquals("ISO CODE", getDriver().findElement(country_payments_iso_code_label_xpath).getText());
        assertEquals("REGISTERED DATE", getDriver().findElement(country_payments_registered_date_label_xpath).getText());
        assertEquals("IBAN ROUTING CODE TYPE", getDriver().findElement(country_payments_code_type_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_payments_status_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){}

    }


    public void verifyCountryNoRoutingCodeTypes() {
        assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("ROUTING CODE TYPES IN " + selectedCountry.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_payments_routing_code_code_types_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnRegionsInNavigationBar() {
        attemptClick(country_regions_link_id);
    }

    public void verifyCountryRegions(ExamplesTable countryRegions) {
        assertEquals("REGIONS", getDriver().findElement(country_regions_label_xpath).getText());
        assertEquals("ALTERNATIVE REGIONS FOR " + selectedCountry.toUpperCase(), getDriver().findElement(country_alt_regions_for_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_regions_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(country_regions_value_label_xpath).getText());
        List<WebElement> regionType = getDriver().findElements(country_regions_type_xpath);
        List<WebElement> regionValue = getDriver().findElements(country_regions_value_xpath);
        for(int i=0; i<countryRegions.getRowCount(); i++){
            assertEquals(countryRegions.getRow(i).get(countryRegions.getHeaders().get(0)),regionType.get(i).getText());
            assertEquals(countryRegions.getRow(i).get(countryRegions.getHeaders().get(1)),regionValue.get(i).getText());
        }
    }

    public void clickOnUpdateCurrencyLink() {
        attemptClick(currency_update_link_id);
    }

    public void enterCurrencyName(String name) {
        getDriver().findElement(currency_input_name_xpath).clear();
        getDriver().findElement(currency_input_name_xpath).sendKeys(name);
    }

    public void enterCurrencyAbbr(String abbr) {
        getDriver().findElement(currency_input_abbr_xpath).clear();
        getDriver().findElement(currency_input_abbr_xpath).sendKeys(abbr);
    }

    public void enterCurrencyUnit(String unit) {
        getDriver().findElement(currency_input_unit_xpath).clear();
        getDriver().findElement(currency_input_unit_xpath).sendKeys(unit);
    }

    public void enterCurrencyQuantity(String quantity) {
        getDriver().findElement(currency_input_quantity_xpath).clear();
        getDriver().findElement(currency_input_quantity_xpath).sendKeys(quantity);
    }

    public void clickOnSaveButton() {
        getDriver().findElement(save_button_id).click();
    }

    public void clickOnCancelButton() {
        getDriver().findElement(cancel_button_id).click();
    }
}
