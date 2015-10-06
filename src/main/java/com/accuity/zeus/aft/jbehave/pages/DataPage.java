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

import static org.junit.Assert.*;

public class DataPage extends AbstractPage {

    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By country_tab_xpath=By.xpath("//*[@id='data-navbar']/ul/li[2]");
    private By area_tab_id=By.id("area-nav");
    private By currency_label_xpath = By.xpath("//*[@id='selection']/dl/dt[1]");
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
    private By country_listBox_xpath= By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//span");
    private By country_listBox_value_xpath=By.xpath(".//*[@id='selection0'] //*[@class='chosen-drop']//ul");
    private By country_type_ahead_xpath=By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input");
    private String currencySearchString = null;
    private By country_iso2_label_id = By.id("iso2");
    private By country_iso2_id = By.id("iso2-value");
    private By country_iso3_label_id = By.id("iso3");
    private By country_iso3_id = By.id("iso3-value");
    private By basic_info_xpath = By.xpath("//*[@id='content']/div/ul/li/h1/span");
    private By basic_info_names_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[1]");
    private By basic_info_names_type_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[1]");
    private By basic_info_names_value_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[2]");
    private By basic_info_names_type_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[1]");
    private By basic_info_names_value_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[2]");
    private By country_basic_info_link_id = By.id("countryBasicInfo");
    private By country_demographics_type_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[1]");
    private By country_demographics_value_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[2]");
    private By country_demographics_unit_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[3]");
    private By country_demographics_date_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[4]");
    private By country_demographics_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[2]");
    private By country_demographics_type_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[1]");
    private By country_demographics_value_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[2]");
    private By country_demographics_unit_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[3]");
    private By country_demographics_date_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[4]");
    private By basic_info_identifiers_label_xpath = By.xpath("//*[@id='content']//li[1]//h2[text()='Identifiers']");
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
    private By basic_info_time_zones_label_xpath = By.xpath("//*[@id='content']//li[1]//h2[text()='Time Zones']");
    private By country_time_zones_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/th");
    private By country_time_zones_value_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/td");
    private By country_summary_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/th");
    private By country_summary_value_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/td");
    private String basic_info_label_xpath ="//*[@id='content']//li[2]/table/tbody/tr/th[text()='";
    private String basic_info_label_value_xpath = ".//*[@id='content']//table[@class='vertical']/tbody/tr[th='";

    private By currency_usage_label_xpath = By.xpath("//*[@id='content']/div/dl[2]/dt");
    private By currency_usage_xpath = By.xpath("//*[@id='content']/div/dl[2]/dd/a");
    private By country_holidays_link_id = By.id("countryHolidays");
    private By country_languages_link_id = By.id("countryLanguages");
    private By country_holiday_label_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//span");
    private By country_languages_label_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dt");
    private By country_languages_value_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dd");
    private By country_holiday_for_label_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//h2");
    private By country_holiday_table_header_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//thead");
    private By country_holiday_date_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[1]");
    private By country_holiday_description_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[2]");
    private By country_holiday_notes_xpath = By.xpath("//li[contains(h2,'Public Holidays')]//tr/td[3]");
    private By country_payments_link_id = By.id("countryPayments");
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
    private By country_regions_link_id = By.id("countryRegions");
    private By regions_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//span");
    private By alt_regions_for_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//h2");
    private By regions_type_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/th[1]");
    private By regions_value_label_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/th[2]");
    private By regions_type_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/td[1]");
    private By regions_value_xpath = By.xpath("//li[contains(h2,'Alternative Regions')]//tr/td[2]");

    private By country_credit_rating_id = By.id("countryCreditRating");
    private By credit_rating_label_xpath = By.xpath("//li[contains(h1,'Credit Rating')]/h1/span");
    private By credit_rating_for_label_xpath = By.xpath("//li[contains(h1,'Credit Rating')]/h2");
    private By credit_rating_table_headers_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//thead/tr");
    private By credit_rating_agency_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[1]");
    private By credit_rating_type_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[2]");
    private By credit_rating_value_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[3]");
    private By credit_rating_applied_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[4]");
    private By credit_rating_confirmed_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[5]");

    private By currency_update_link_id = By.id("update-link");
    private By currency_input_name_xpath = By.xpath("//input[@name='name']");
    private By currency_input_abbr_xpath = By.xpath("//input[@name='abbr']");
    private By currency_input_unit_xpath = By.xpath("//input[@name='unit']");
    private By currency_input_quantity_xpath = By.xpath("//input[@name='quantity']");
    private By country_places_link_id= By.id("countryPlaces");
    private By places_label_xpath = By.xpath("//li[contains(h1,'Places')]//span");
    private By related_places_label_xpath = By.xpath("//li[contains(h2,'Places')]//h2");
    private By places_type_label_xpath = By.xpath("//li[contains(h2,'Places')]//table/thead//th[1]");
    private By places_place_label_xpath = By.xpath("//li[contains(h2,'Places')]//table/thead//th[2]");
    private By places_details_label_xpath = By.xpath("//li[contains(h2,'Places')]//table/thead//th[3]");
    private By country_places_type_xpath = By.xpath("//li[contains(h2,'Places')]//table/tbody//td[1]");
    public String selectedEntity="";
    private By country_entity_link_id = By.id("countryPresence");
    private By country_entities_label_xpath = By.xpath("//li[contains(h1,'Entities')]//span");
    private By country_related_entities_label_xpath = By.xpath("//li[contains(h2,'Entities')]//h2");
    private By country_entities_type_label_xpath = By.xpath("//li[contains(h2,'Entities')]//table/thead//th[1]");
    private By country_entities_entity_label_xpath = By.xpath("//li[contains(h2,'Entities')]//table/thead//th[2]");
    private By country_entities_details_label_xpath = By.xpath("//li[contains(h2,'Entities')]//table/thead//th[3]");
    private By country_entities_type_xpath = By.xpath("//li[contains(h2,'Entities')]//table/tbody//td[1]");
    private By select_all_link_xpath = By.xpath("//*[@id='all'][@class='selected']");
    private By country_currencies_link_id = By.id("countryCurrencies");
    private By country_currencies_label_xpath = By.xpath("//li[contains(h1,'Currencies')]//span");
    private By country_currencies_table_headings_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/thead//tr");
    private By country_currencies_iso_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[1]");
    private By country_currencies_name_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[2]");
    private By country_currencies_start_date_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[3]");
    private By country_currencies_end_date_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[4]");
    private By country_currencies_primary_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[5]");
    private By country_currencies_replaced_by_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[6]");
    private By country_currencies_status_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[7]");
    private By area_area_dropdown_xpath = By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen'] //a");
    private By area_subarea_dropdown_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen'] //a");
    private By country_people_link_id= By.id("countryPeople");

    private By area_time_zones_summary_label_xpath=By.xpath(".//*[@id='content']//li[1]/dl/dt");
    private By area_time_zones_summary_xpath=By.xpath(".//*[@id='content']//li[1]/dl/dd");
    private By area_time_zones_xpath=By.xpath(".//*[@id='content']//li/table[3]/tbody/tr/th");
    private By area_time_zones_value_xpath= By.xpath(".//*[@id='content']//li/table[3]/tbody/tr/td");
    private By city_tab_id = By.id("city-nav");
    private By city_city_dropdown_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen'] //a");
    private By city_city_dropdown_list_xpath = By.xpath(".//*[@id='selection2'] //ul/li");
    private By city_city_dropdown_disabled_xpath = By.xpath(".//*[@id='selection2'] /div //*[contains(@class,'chosen-disabled')]");
    private By area_credit_ratings_link_id = By.id("areaCreditRating");
    private By area_regions_link_id = By.id("areaRegions");
    private By city_credit_ratings_link_id = By.id("cityCreditRating");

    public DataPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    public By people_label_xpath = By.xpath("//li[contains(h1,'People')]//span");
    public By related_people_label_xpath = By.xpath("//li[contains(h2,'People')]//h2");
    public By people_type_label_xpath = By.xpath("//li[contains(h2,'People')]//table/thead//th[1]");
    public By people_entity_label_xpath = By.xpath("//li[contains(h2,'People')]//table/thead//th[2]");
    public By people_type_xpath = By.xpath("//li[contains(h2,'People')]//table/tbody//td[1]");
    public By area_area_dropdown_list_xpath = By.xpath(".//*[@id='selection1'] //ul/li");
    public By area_subarea_dropdown_list_xpath = By.xpath(".//*[@id='selection2'] //ul/li");
    public By area_area_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen']//input");
    public By area_subarea_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    public By area_basic_info_link_id = By.id("areaBasicInfo");
    public By area_related_places_link_id = By.id("areaPlaces");
    public By area_related_people_link_id = By.id("areaPeople");
    public By area_demographics_link_id= By.id("areaDemographics");
    public By area_demographics_label_xpath = By.xpath("//li/h1/span[text()='Demographics']");
    public By area_demographics_type_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[1]");
    public By area_demographics_value_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[2]");
    public By area_demographics_unit_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[3]");
    public By area_demographics_date_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[4]");
    public By area_demographics_type_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table//tbody//td[1]");
    private By city_type_ahead_xpath =By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    private By city_region_link_id =By.id("cityRegions");

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

    public void clickOnAreaTab() {
        attemptClick(area_tab_id);
    }

    public void verifyCountryListBoxIsDisplayed()   {

        assertTrue(getDriver().findElement(country_listBox_xpath).isDisplayed());
    }

    public void clickOnCountryListBox() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(country_listBox_xpath).click();
    }

    public void verifyCountryTypeAheadAndListBox() {
        assertTrue(getDriver().findElement(country_type_ahead_xpath).isDisplayed());
        assertFalse(getDriver().findElement(country_listBox_xpath).getText().isEmpty());

    }

    //=CHAR(34)&A1&CHAR(34)&","
    public void verifyCountryListValues() {
        List<String> retCountryListVal = new ArrayList<>(Arrays.asList(getDriver().findElement(country_listBox_value_xpath).getText().split("\n")));
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
        String[] expCountryList = getDriver().findElement(country_listBox_value_xpath).getText().split("\n");
        for (int i=0; i<=countryList.getRowCount()-1;i++){
            assertTrue(countryList.getRow(i).containsValue(expCountryList[i]));
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
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyCurrencyInListBox(ExamplesTable currencyList) {
        List<WebElement> expCurrencyList = getDriver().findElements(currency_list_xpath);
        for (int i=0; i<currencyList.getRowCount();i++){
            assertTrue(currencyList.getRow(i).containsValue(expCurrencyList.get(i).getText()));
        }
    }

    public void enterCountryInTheTypeAheadBox(String country) {
        selectedEntity = country;
        getDriver().findElement(country_type_ahead_xpath).sendKeys(country);
        getDriver().findElement(country_type_ahead_xpath).sendKeys(Keys.RETURN);
    }

    public void enterAreaInTypeAhead(String area) {
        selectedEntity = area;
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(area);
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
    }

    public void verifyCountryIso2(String iso2) {
        assertEquals("ISO2", getDriver().findElement(country_iso2_label_id).getText());
        assertEquals(iso2, getDriver().findElement(country_iso2_id).getText());
    }

    public void verifyCountryIso3(String iso3) {
        assertEquals("ISO3", getDriver().findElement(country_iso3_label_id).getText());
        assertEquals(iso3, getDriver().findElement(country_iso3_id).getText());
    }

    public void verifyBasicInfo() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // assertEquals(selectedCountry, getDriver().findElement(country_name_selected_xpath).getText());
        assertEquals("BASIC INFO", getDriver().findElement(basic_info_xpath).getText());
    }

    public void verifyNames(ExamplesTable namesList) {
        assertEquals("NAMES", getDriver().findElement(basic_info_names_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(basic_info_names_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(basic_info_names_value_label_xpath).getText());
        List<WebElement> actNameTypes = getDriver().findElements(basic_info_names_type_xpath);
        List<WebElement> actNameValue = getDriver().findElements(basic_info_names_value_xpath);
        for(int i = 0; i<namesList.getRowCount(); i++){
            assertEquals(namesList.getRow(i).get(namesList.getHeaders().get(0)), actNameTypes.get(i).getText());
            assertEquals(namesList.getRow(i).get(namesList.getHeaders().get(1)), actNameValue.get(i).getText());
        }

    }

    public void clickOnBasicInfoInNavigationBar() {
        attemptClick(country_basic_info_link_id);
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

    public void verifyIdentifiers(ExamplesTable identifiersList) {
        assertEquals("IDENTIFIERS", getDriver().findElement(basic_info_identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(country_identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(country_identifiers_status_label_xpath).getText());
        List<WebElement> actIdentifiersTypes = getDriver().findElements(country_identifiers_type_xpath);
        List<WebElement> actIdentifiersValue = getDriver().findElements(country_identifiers_value_xpath);
        List<WebElement> actIdentifiersStatus = getDriver().findElements(country_identifiers_status_xpath);
        for(int i = 0; i<identifiersList.getRowCount(); i++) {
            assertEquals(identifiersList.getRow(i).get(identifiersList.getHeaders().get(0)), actIdentifiersTypes.get(i).getText());
            assertEquals(identifiersList.getRow(i).get(identifiersList.getHeaders().get(1)), actIdentifiersValue.get(i).getText());
            assertEquals(identifiersList.getRow(i).get(identifiersList.getHeaders().get(2)), actIdentifiersStatus.get(i).getText());
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

    public void verifyAreaTimeZonesSummary(String areaTimeZonesSummary){
        assertEquals("Summary", getDriver().findElement(area_time_zones_summary_label_xpath).getText());
        assertEquals(areaTimeZonesSummary, getDriver().findElement(area_time_zones_summary_xpath).getText());
    }

    public void verifyCountryTimeZones(ExamplesTable countryTimeZones) {
        assertEquals("TIME ZONES", getDriver().findElement(basic_info_time_zones_label_xpath).getText());
        List<WebElement> actCountryTimeZone = getDriver().findElements(country_time_zones_xpath);
        List<WebElement> actCountryTimeZoneValue = getDriver().findElements(country_time_zones_value_xpath);
        for(int i = 0; i<countryTimeZones.getRowCount(); i++) {
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(0)), actCountryTimeZone.get(i).getText());
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(1)), actCountryTimeZoneValue.get(i).getText());
        }
    }

    public void verifyAreaTimeZones(ExamplesTable areaTimeZones) {
        assertEquals("TIME ZONES", getDriver().findElement(basic_info_time_zones_label_xpath).getText());
        List<WebElement> actAreaTimeZone = getDriver().findElements(area_time_zones_xpath);
        List<WebElement> actAreaTimeZoneValue = getDriver().findElements(area_time_zones_value_xpath);
        for(int i = 0; i<areaTimeZones.getRowCount(); i++) {
            assertEquals(areaTimeZones.getRow(i).get(areaTimeZones.getHeaders().get(0)), actAreaTimeZone.get(i).getText());
            assertEquals(areaTimeZones.getRow(i).get(areaTimeZones.getHeaders().get(1)), actAreaTimeZoneValue.get(i).getText());
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

    public void verifyBasicInfoLabel(String label,String value) {
        assertEquals(label, getDriver().findElement(By.xpath(basic_info_label_xpath +label+"']")).getText());
        assertEquals(value, getDriver().findElement(By.xpath(basic_info_label_value_xpath+label+"']/td")).getText());
    }

    public void verifyReplaceByLabelValues(String replacedBy) {
        assertEquals("Replaced By", getDriver().findElement(By.xpath(basic_info_label_xpath + "Replaced By']")).getText());
        String replacedBys[] = replacedBy.split(" ");
        int values = getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText().split(",").length;
        if(replacedBys.length== values)
        for(int i=0; i<replacedBys.length; i++){
            assertTrue(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText().contains(replacedBys[i].replace(",", "")));
        }
    }

    public void verifyAreaLinkInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Area Parent']/td")).isSelected());
    }

    public void clickOnReplacedByCountry(String replacedByCountry) {
        selectedEntity = replacedByCountry;
        attemptClick(By.linkText(replacedByCountry));
    }

    public void verifyCountriesCurrencyUsage(ExamplesTable currencyCountries) {
        assertEquals("USAGE", getDriver().findElement(currency_usage_label_xpath).getText());
        for (int i = 0; i<currencyCountries.getRowCount(); i++){
            assertEquals(currencyCountries.getRow(i).get(currencyCountries.getHeaders().get(0)), getDriver().findElements(currency_usage_xpath).get(i).getText());
        }
    }

    public void clickOnCurrencyUsageCountry(String currencyUsageCountry) {
        selectedEntity = currencyUsageCountry;
        attemptClick(By.linkText(currencyUsageCountry));
    }

    public void clickOnCurrencyIso3(String iso3) {
        attemptClick(By.linkText(iso3));
    }
    public void clickOnCountryHolidays() {
        attemptClick(country_holidays_link_id);
    }

    public void clickOnCountryLanguages() {
        attemptClick(country_languages_link_id);
    }

    public void verifyCountryHolidays(ExamplesTable countryHolidaysList) {
        assertEquals("HOLIDAYS", getDriver().findElement(country_holiday_label_xpath).getText());
        assertEquals("PUBLIC HOLIDAYS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_for_label_xpath).getText());
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

    public void verifyCountryLanguages(String languages) {
        assertEquals("Summary", getDriver().findElement(country_languages_label_xpath).getText());
        assertEquals(languages, getDriver().findElement(country_languages_value_xpath).getText());
    }

    public void verifyNoCountryHolidays() {
        assertEquals("HOLIDAYS", getDriver().findElement(country_holiday_label_xpath).getText());
        assertEquals("PUBLIC HOLIDAYS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_for_label_xpath).getText());
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
        assertEquals("ROUTING CODE TYPES IN " + selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
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
        assertEquals("ROUTING CODE TYPES IN " + selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_payments_routing_code_code_types_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnRegionsInNavigationBar() {
        attemptClick(country_regions_link_id);
    }

    public void verifyRegions(ExamplesTable regions) {
        assertEquals("REGIONS", getDriver().findElement(regions_label_xpath).getText());
        assertEquals("ALTERNATIVE REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(alt_regions_for_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(regions_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(regions_value_label_xpath).getText());
        List<WebElement> regionType = getDriver().findElements(regions_type_xpath);
        List<WebElement> regionValue = getDriver().findElements(regions_value_xpath);
        for(int i=0; i<regions.getRowCount(); i++){
            assertEquals(regions.getRow(i).get(regions.getHeaders().get(0)), regionType.get(i).getText());
            assertEquals(regions.getRow(i).get(regions.getHeaders().get(1)), regionValue.get(i).getText());
        }
    }

    public void verifyNoCountryRegionsSection() {
        try {
            assertFalse(getDriver().findElement(regions_label_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){

        }
    }

    public void verifyNoCountryHolidaysSection() {
        try {
            assertFalse(getDriver().findElement(country_holiday_label_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){

        }
    }

    public void clickOnCountryCreditRating() {
        attemptClick(country_credit_rating_id);
    }

    public void verifyCreditRatings(ExamplesTable creditRatings) {
        verifyCreditRatingsLabel();
        assertEquals("CREDIT RATINGS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(credit_rating_for_label_xpath).getText());
        assertEquals("AGENCY TYPE VALUE APPLIED DATE CONFIRMED DATE", getDriver().findElement(credit_rating_table_headers_xpath).getText());
        List<WebElement> agency = getDriver().findElements(credit_rating_agency_xpath);
        List<WebElement> type = getDriver().findElements(credit_rating_type_xpath);
        List<WebElement> value = getDriver().findElements(credit_rating_value_xpath);
        List<WebElement> appliedDate = getDriver().findElements(credit_rating_applied_date_xpath);
        List<WebElement> confirmedDate = getDriver().findElements(credit_rating_confirmed_date_xpath);
        for (int i=0; i<creditRatings.getRowCount(); i++){
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(0)),agency.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(1)),type.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(2)),value.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(3)),appliedDate.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(4)),confirmedDate.get(i).getText());
        }
    }

    public void verifyCreditRatingsLabel() {
        assertEquals("CREDIT RATING", getDriver().findElement(credit_rating_label_xpath).getText());
    }

    public void verifyNoCreditRatings() {
        assertEquals("CREDIT RATING", getDriver().findElement(credit_rating_label_xpath).getText());
        assertEquals("CREDIT RATINGS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(credit_rating_for_label_xpath).getText());
        assertEquals("AGENCY TYPE VALUE APPLIED DATE CONFIRMED DATE", getDriver().findElement(credit_rating_table_headers_xpath).getText());
        try {
            assertFalse(getDriver().findElement(credit_rating_agency_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){}
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

    public void clickOnCountryPlaces() {
        attemptClick(country_places_link_id);
    }

    public void verifyPlaces(ExamplesTable placeValues)  {
        verifyPlacesLabel();
        assertEquals("RELATED PLACES FOR " + selectedEntity.toUpperCase(),getDriver().findElement(related_places_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());
        for(int i = 0; i<placeValues.getRowCount(); i++){
            assertEquals(placeValues.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + placeValues.getRow(i).get(placeValues.getHeaders().get(0)) + "']")).getText().replace(",","").trim());
        }
    }

    public void verifyPlacesLabel() {
        assertEquals("PLACES", getDriver().findElement(places_label_xpath).getText());
    }

    public void verifyNoPlaces() {
        assertEquals("PLACES", getDriver().findElement(places_label_xpath).getText());
        assertEquals("RELATED PLACES FOR " + selectedEntity.toUpperCase(),getDriver().findElement(related_places_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_places_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void clickOnCountryEntity() {
        attemptClick(country_entity_link_id);
    }

    public void verifyCountryEntities(ExamplesTable countryEntities) {
        assertEquals("ENTITIES", getDriver().findElement(country_entities_label_xpath).getText());
        assertEquals("RELATED ENTITIES FOR " + selectedEntity.toUpperCase(),getDriver().findElement(country_related_entities_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(country_entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(country_entities_details_label_xpath).getText());
        for(int i = 0; i<countryEntities.getRowCount(); i++){
            assertEquals(countryEntities.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                        By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryEntities.getRow(i).get(countryEntities.getHeaders().get(0)) + "']")).getText().replace(",","").trim());
        }
    }

    public void verifyNoCountryEntities() {
        assertEquals("ENTITIES", getDriver().findElement(country_entities_label_xpath).getText());
        assertEquals("RELATED ENTITIES FOR " + selectedEntity.toUpperCase(),getDriver().findElement(country_related_entities_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(country_entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(country_entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(country_entities_details_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_entities_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyDefaultToViewAll() {
        assertTrue(getDriver().findElement(select_all_link_xpath).isDisplayed());
    }

    public void refreshThePage() {
        getDriver().navigate().refresh();
    }

    public void clickOnCountryCurrenciesLink() {
        attemptClick(country_currencies_link_id);
    }

    public void verifyCountryCurrencies(ExamplesTable countryCurrencies) {
        assertEquals("CURRENCIES", getDriver().findElement(country_currencies_label_xpath).getText());
        assertEquals("ISO NAME START DATE END DATE PRIMARY REPLACED BY STATUS", getDriver().findElement(country_currencies_table_headings_xpath).getText());
        List<WebElement> iso = getDriver().findElements(country_currencies_iso_xpath);
        List<WebElement> name = getDriver().findElements(country_currencies_name_xpath);
        List<WebElement> startDate = getDriver().findElements(country_currencies_start_date_xpath);
        List<WebElement> endDate = getDriver().findElements(country_currencies_end_date_xpath);
        List<WebElement> primary = getDriver().findElements(country_currencies_primary_xpath);
        List<WebElement> replacedBy = getDriver().findElements(country_currencies_replaced_by_xpath);
        List<WebElement> status = getDriver().findElements(country_currencies_status_xpath);

        for(int i=0; i<countryCurrencies.getRowCount(); i++){
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(0)),iso.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(1)),name.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(2)),startDate.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(3)),endDate.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(4)),primary.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(5)),replacedBy.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(6)),status.get(i).getText());
        }
    }

    public void clickOnCountryPeople() { attemptClick(country_people_link_id);
    }

    public void verifyPeople(ExamplesTable countryPeople) {
        verifyPeopleLabel();
        assertEquals("RELATED PEOPLE FOR " + selectedEntity.toUpperCase(),getDriver().findElement(related_people_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        for(int i = 0; i<countryPeople.getRowCount(); i++){
            assertEquals(countryPeople.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryPeople.getRow(i).get(countryPeople.getHeaders().get(0)) + "']")).getText().replace(",", "").trim());
        }
    }

    public void verifyPeopleLabel() {
        assertEquals("PEOPLE", getDriver().findElement(people_label_xpath).getText());
    }

    public void verifyNoPeople() {
        assertEquals("PEOPLE", getDriver().findElement(people_label_xpath).getText());
        assertEquals("RELATED PEOPLE FOR " + selectedEntity.toUpperCase(),getDriver().findElement(related_people_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(people_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void clickOnAreaDropdown() {
        attemptClick(area_area_dropdown_xpath);
    }

    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
         List<WebElement> areasCollection = getDriver().findElements(area_area_dropdown_list_xpath);
        for (int i=0; i<areas.getRowCount(); i++){
           assertEquals(areas.getRow(i).get(areas.getHeaders().get(0)),areasCollection.get(i).getText());
        }
    }

    public void verifySubareaForSelectedArea(ExamplesTable subarea) {
        attemptClick(area_subarea_dropdown_xpath);
        List<WebElement> subareaCollection = getDriver().findElements(area_subarea_dropdown_list_xpath);
        for(int i=0;i<subarea.getRowCount();i++){
            assertEquals(subarea.getRow(i).get(subarea.getHeaders().get(0)),subareaCollection.get(i).getText());
        }
    }

    public void verifyAreaDropdownDisabled() {
       assertFalse(getDriver().findElement(area_area_dropdown_xpath).isSelected());
    }

    public void verifySubareaDropdownDisabled() {
        assertFalse(getDriver().findElement(area_subarea_dropdown_xpath).isSelected());
    }

    public void clickOnAreaBasicInfoInNavigationBar() {
        attemptClick(area_basic_info_link_id);
    }

    public void clickOnAreaRelatedPlaces() {
        attemptClick(area_related_places_link_id);
    }

    public void clickOnAreaRelatedPeople() {
        attemptClick(area_related_people_link_id);
    }
    public void clickOnDemographics() {
        attemptClick(area_demographics_link_id);
    }

    public void verifyDemographics(ExamplesTable areaDemographics) {
        verifyDemographicsLabel();
        assertEquals("TYPE", getDriver().findElement(area_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(area_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(area_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(area_demographics_date_label_xpath).getText());
        List<WebElement> areaDemographicsTypeVal = getDriver().findElements(area_demographics_type_xpath);
        assertTrue(areaDemographics.getRowCount() == areaDemographicsTypeVal.size());
        for(int i = 0; i<areaDemographics.getRowCount(); i++)
        {
            assertEquals(areaDemographics.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ","").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + areaDemographics.getRow(i).get(areaDemographics.getHeaders().get(0)) + "']")).getText().replace(",","").replace(" ","").trim());

        }
    }

    public void verifyDemographicsLabel() {
        assertEquals("DEMOGRAPHICS", getDriver().findElement(area_demographics_label_xpath).getText());
    }

    public void verifyNoDemographics() {
        assertEquals("DEMOGRAPHICS", getDriver().findElement(area_demographics_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(area_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(area_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(area_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(area_demographics_date_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(area_demographics_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }

    }

    public void clickOnCityTab() {
        attemptClick(city_tab_id);
    }

    public void clickOnCityDropdown() {
        attemptClick(city_city_dropdown_xpath);
    }

    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        List<WebElement> areasCollection = getDriver().findElements(city_city_dropdown_list_xpath);
        for (int i=0; i<cities.getRowCount(); i++){
            assertEquals(cities.getRow(i).get(cities.getHeaders().get(0)),areasCollection.get(i).getText());
        }
    }

    public void verifyNoCitiesForSelectedArea() {
        assertTrue(getDriver().findElement(city_city_dropdown_disabled_xpath).isDisplayed());
    }

    public void clickOnAreasCreditRatings() {
        attemptClick(area_credit_ratings_link_id);
    }

    public void clickOnSubAreaDropDown() {
        attemptClick(area_subarea_dropdown_xpath);
    }

    public void enterSubAreaInTypeAhead(String subArea) {
        selectedEntity = subArea;
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(subArea);
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
    }
    
    public void enterCityInTheTypeAheadBox(String city) {
        selectedEntity = city;
        getDriver().findElement(city_type_ahead_xpath).sendKeys(city);
        getDriver().findElement(city_type_ahead_xpath).sendKeys(Keys.RETURN);
   }
    
   public void clickOnCityRegionsInNavigationBar() {
        attemptClick(city_region_link_id);
   }

    public void clickOnAreasAlternativeRegions() {
        attemptClick(area_regions_link_id);
    }

    public void verifyNoAlternativeRegions() {
        assertEquals("REGIONS", getDriver().findElement(regions_label_xpath).getText());
        assertEquals("ALTERNATIVE REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(alt_regions_for_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(regions_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(regions_value_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(regions_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }
    
    public void clickOnCityCreditRatings() {
        attemptClick(city_credit_ratings_link_id);
    }
}

