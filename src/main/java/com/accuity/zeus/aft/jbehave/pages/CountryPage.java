package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.w3c.dom.Document;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryPage extends AbstractPage {

    private By basic_info_time_zones_label_xpath = By.xpath("//*[@id='content']//li[1]//h2[text()='Time Zones']");
    private By area_area_dropdown_list_xpath = By.xpath(".//*[@id='selection1'] //ul/li");
    private By labels_xpath = By.xpath("//*[@id='selection']/fieldset/h1");
    private By country_listBox_value_xpath=By.xpath(".//*[@id='selection0'] //*[@class='chosen-drop']//ul");
    private By country_type_ahead_xpath=By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input");
    private By country_iso2_label_id = By.id("iso2");
    private By country_iso2_id = By.id("iso2-value");
    private By country_iso3_label_id = By.id("iso3");
    private By country_iso3_id = By.id("iso3-value");
    private By country_currencies_link_id = By.id("countryCurrencies");
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
    private By country_banking_hr_summary_label_xpath = By.xpath("//*[@id='content']//li[1]/dl[1]/dt");
    private By country_banking_hr_summary_xpath = By.xpath("//*[@id='content']//li[1]/dl[1]/dd");
    private By country_banking_hrs_label_xpath =  By.xpath("//*[@id='content']//li[1]/h2[4]");
    private By country_banking_hrs_day_label_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[1]");
    private By country_banking_hrs_hrs_label_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[2]");
    private By country_banking_hrs_day_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[1]");
    private By country_banking_hrs_hrs_xpath =  By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[2]");
    private By country_time_zones_summary_label_xpath = By.xpath("//*[@id='content']//li[1]/dl[2]/dt");
    private By country_time_zones_summary_xpath = By.xpath("//*[@id='content']//li[1]/dl[2]/dd");
    private By country_time_zones_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/th");
    private By country_time_zones_value_xpath = By.xpath("//*[@id='data']//li[1]/table[5]/tbody/tr/td");
    private By country_summary_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/th");
    private By country_summary_value_xpath = By.xpath("//*[@id='content']//li[2]/table/tbody/tr/td");
    private By country_holidays_link_id = By.id("countryHolidays");
    private By country_languages_link_id = By.id("countryLanguages");
    private By country_holiday_label_xpath = By.xpath("//li[contains(h1,'Holidays for')]//span");
    private By country_languages_label_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dt");
    private By country_languages_value_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dd");
    private By country_country_name_input_xpath = By.xpath("//tr[td = 'Country Name']/td[2]/input");
    private By country_holiday_table_header_xpath = By.xpath("//li[contains(h1,'Holidays for')]//thead");
    private By country_holiday_date_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[1]");
    private By country_holiday_description_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[2]");
    private By country_holiday_notes_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[3]");
    private By country_name_value_required_err_msg_xpath = By.xpath("//tr[td = 'Country Name']/td[2]/p");
    private By country_names_type_required_err_msg_xpath = By.xpath("//*[@id='additionalNames']/tr/td[1]/p");
    private By country_names_value_required_err_msg_xpath = By.xpath("//*[@id='additionalNames']/tr/td[2]/p");
    private By country_delete_new_row_button_xpath = By.xpath("//*[@class='delete-row']");
    private By country_delete_confirmation_modal_xpath = By.xpath("//*[@colspan='10']");
    private By country_delete_no_button_id = By.id("no-button");
    private By country_delete_yes_button_id = By.id("yes-button");
    private By country_additional_name_row_id = By.xpath("//*[@id='additionalNames']/tr");
    private By country_additional_identifiers_row_id = By.xpath("//*[@id='additionalIdentifiers']/tr");
    private By country_time_zone_summary_err_msg_xpath = By.xpath("//*[@data-error_id='timeZonesSummaryError']");
    private By country_time_zone_summary_input_xpath = By.xpath("//*[@data-edit_id='timeZonesSummary']");
    private By country_add_new_time_zone_button_id = By.id("add-timeZones");
    private By country_time_zone_list_box_xpath = By.xpath("//*[@data-row_id='timeZoneRow']/td/select");
    private By country_time_zone_list_xpath = By.xpath("//*[@data-row_id='timeZoneRow']/td/select/option");
    private By country_additional_time_zone_row_id = By.xpath("//*[@id='additionalTimeZones']/tr");
    private By country_add_new_holiday_button_id = By.id("add-holidays");
    private By country_holiday_day_xpath = By.xpath("//*[@data-row_id='holidayRow']//tr[1]/td/fieldset/input[1]");
    private By country_holiday_month_xpath = By.xpath("//*[@data-row_id='holidayRow']//tr[1]/td/fieldset/select");
    private By country_holiday_year_xpath = By.xpath("//*[@data-row_id='holidayRow']//tr[1]/td/fieldset/input[2]");
    private By country_holiday_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayDateError']");
    private By country_holiday_description_box_xpath = By.xpath("//*[@data-row_id='holidayRow']//tr[1]/td[2]/input");
    private By country_holiday_note_box_xpath = By.xpath("//*[@data-row_id='holidayRow']//tr[1]/td[3]/input");
    private By country_holiday_description_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayNameError']");
    private By country_holiday_notes_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayNoteError']");
    private By country_new_holiday_row_xpath = By.xpath("//*[@id='additionalHolidays']/tr");
    private By country_language_err_msg_xpath = By.xpath("//*[@class='notification error'][data-error_id='languagesError']");

    private By country_payments_link_id = By.id("countryPayments");
    private By country_payments_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//span");
    private By country_payments_iban_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//h2[1]");
    private By country_payments_status_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[1]");
    private By country_payments_iso_code_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[2]");
    private By country_payments_registered_date_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[1]");
    private By country_payments_code_type_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]//th[3]");
    private By country_payments_status_xpath = By.xpath("//li[contains(h2,'IBAN')]/dl");
    private By country_payments_iso_code_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[2]");
    private By country_payments_registered_date_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[1]");
    private By country_payments_code_type_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[1]/tbody//tr/td[3]");
    private By country_payments_routing_code_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//h2[2]");
    private By country_payments_routing_codes_types_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[2]//th[1]");
    private By country_payments_routing_code_code_types_xpath = By.xpath("//li[contains(h2,'IBAN')]//table[2]//td");
    private By country_regions_link_id = By.id("countryRegions");
    private By country_credit_rating_id = By.id("countryCreditRating");
    private By country_places_link_id= By.id("countryPlaces");
    private By country_entity_link_id = By.id("countryPresences");
    private By country_currencies_label_xpath = By.xpath("//li[contains(h1,'Currencies')]//span");
    private By country_currencies_table_headings_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/thead//tr");
    private By country_currencies_iso_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[1]");
    private By country_currencies_name_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[2]");
    private By country_currencies_start_date_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[3]");
    private By country_currencies_end_date_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[4]");
    private By country_currencies_primary_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[5]");
    private By country_currencies_replaced_by_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[6]");
    private By country_currencies_status_xpath = By.xpath("//li[contains(h1,'Currencies')]//table/tbody//td[7]");
    private By country_people_link_id= By.id("countryPeople");
    private By currency_country_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private String selectedCountry ="";
    private By country_listBox_xpath = By.xpath("//*[@id='selection0'] //*[@id='entitySelect_chosen']//span");
    private By country_edit_names_type_list_xpath = By.xpath("//*[@id='additionalNames']/tr/td[1]/select");
    private By country_edit_identifier_type_list_xpath = By.xpath("//*[@id='additionalIdentifiers']//select");
    private By country_name_type_list_xpath = By.xpath("//*[@data-row_id='nameRow']/tbody/tr/td/select/option");
    private By country_identifier_type_list_xpath = By.xpath("//*[@id='additionalIdentifiers']//*[@class=\"new\"]//select/option");

    private By country_add_new_name_button_id = By.id("add-names");
    private By country_add_new_identifier_button_id = By.id("add-identifiers");
    private By country_dropdown_is_visible_xpath = By.xpath("//*[@id='selection0']//div[@class='chosen-container chosen-container-single']");
    private By regions_label_xpath = By.xpath("//li[contains(h1,'Regions for')] //span");
    private By country_language_link_id = By.id("countryLanguages");
    private By language_summary_textarea_xpath = By.xpath("//*[@id='content']/div/ul/form/li/dl/dd/textarea");

    private By country_identifier_value_err_msg_xpath=By.xpath(".//*[@class=\"notification error\"][@data-error_id='identifierValueError']");
    private By country_identifier_type_required_err_msg_xpath=By.xpath(".//*[@class=\"notification error\"][@data-error_id='identifierTypeError']");
    private By country_identifier_type_input_xpath=By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']");
    private By country_identifier_value_input_xpath=By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']");
    private By country_identifier_status_input_xpath=By.xpath(".//*[@data-row_id='identifierRow']//fieldset/input");

    private By getCountry_basic_info_identifier_default_status=By.xpath(".//*[@data-row_id='identifierRow']//*[@class='new']//fieldset//input[@value='active']");
    private String basic_info_label_value_xpath = ".//*[@id='content']//table[@class='vertical']/tbody/tr[th='";

    private By country_basic_info_startDate_day_edit_xpath=By.xpath("//input[@name='startDate-day']");
    String country_basic_info_startDate_month_edit_xpath = "//select[@name='startDate-month']";
    private By country_basic_info_startDate_year_edit_xpath=By.xpath("//input[@name='startDate-year']");

    private By country_basic_info_endDate_day_edit_xpath=By.xpath("//input[@name='endDate-day']");
    String country_basic_info_endDate_month_edit_xpath = "//select[@name='endDate-month']";
    private By country_basic_info_endDate_year_edit_xpath=By.xpath("//input[@name='endDate-year']");

    private By country_addInfo_error_message_edit_xpath=By.xpath("//*[@data-error_id='addInfoError']");
    private By country_imports_error_message_edit_xpath=By.xpath("//*[@data-error_id='primaryImportsError']");
    private By country_exports_error_message_edit_xpath=By.xpath("//*[@data-error_id='primaryExportsError']");
    private By country_political_structure_error_message_edit_xpath = By.xpath("//*[@data-error_id='politicalStructureError']");
    private By country_intlDialingCode_error_message_edit_xpath = By.xpath("//*[@data-error_id='telephoneCodeError']");
    private By country_replacedBy_edit_xpath=By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li");
    private By country_credit_rating_appliedYear_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[4]/fieldset/input[2]");
    private By country_credit_rating_appliedyear_errorNolaterThanToday_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[4]/fieldset/p");
    private By country_credit_rating_confirmedYear_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[2]/td[5]/fieldset/input[2]");
    private By country_credit_rating_confirmedYear_errorNoLaterThanToday_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[2]/td[5]/fieldset/p");
    private By country_credit_rating_required_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[3]/td[5]/fieldset/p");
    private By country_credit_rating_addRow_id = By.id("add-creditRatings");
    private By country_credit_rating_tableBody_id = By.id("additionalCreditRatings");
    private By country_credit_rating_deleteButton_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[4]/td[6]/button");
    private int rowCount;


    public CountryPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    public DataPage dataPage;

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyCountryTypeAheadAndListBox() {
        assertTrue(getDriver().findElement(country_type_ahead_xpath).isDisplayed());
        assertFalse(getDriver().findElement(country_listBox_xpath).getText().isEmpty());
    }

    public void verifyCountryCurrencies(ExamplesTable countryCurrencies) {
        if(SearchPage.selectedEntity !=""){
            selectedCountry = SearchPage.selectedEntity;
        }
        assertTrue(getDriver().findElement(country_currencies_label_xpath).getText().matches("^CURRENCIES FOR " + selectedCountry.toUpperCase() + ".*$"));
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

    public void verifyCountryList(Database database, ApacheHttpClient apacheHttpClient){
        assertEquals(getDriver().findElement(labels_xpath).getText(), "COUNTRY");
        List<WebElement> countryList = getDriver().findElements(currency_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), countryList.get(i).getText().trim());
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

    public void verifyCountryIso2(String iso2) {
        assertEquals("ISO2", getDriver().findElement(country_iso2_label_id).getText());
        assertEquals(iso2, getDriver().findElement(country_iso2_id).getText());
    }

    public void verifyIdentifierStatus() {
        assertTrue(getDriver().findElement(getCountry_basic_info_identifier_default_status).isSelected());
    }

    public void verifyEditCountryBasicInfoFromTrusted(){
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", DataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "country basic info", nvPairs);
        for(int i=0;i<document.getElementsByTagName("country").getLength();i++) {
            assertEquals(document.getElementsByTagName("ISO2").item(i).getTextContent(), getDriver().findElement(country_iso2_id).getText());
            assertEquals(document.getElementsByTagName("ISO3").item(i).getTextContent(), getDriver().findElement(country_iso3_id).getText());
            assertEquals(document.getElementsByTagName("Status").item(i).getTextContent().toLowerCase(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Status']/td")).getText().toLowerCase());
            assertEquals(document.getElementsByTagName("BeginDate").item(i).getTextContent().replace(" ",""),getDriver().findElement(country_basic_info_startDate_day_edit_xpath).getAttribute("value")+getDriver().findElement(By.xpath(country_basic_info_startDate_month_edit_xpath+"/option[@selected='selected']")).getText()+getDriver().findElement(country_basic_info_startDate_year_edit_xpath).getAttribute("value").replace(" ",""));
            assertEquals(document.getElementsByTagName("EndDate").item(i).getTextContent().replace(" ",""), getDriver().findElement(country_basic_info_endDate_day_edit_xpath).getAttribute("value")+getDriver().findElement(By.xpath(country_basic_info_endDate_month_edit_xpath+"/option[@selected='selected']")).getText()+getDriver().findElement(country_basic_info_endDate_year_edit_xpath).getAttribute("value").replace(" ",""));

            assertEquals(document.getElementsByTagName("ReplacedBy").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText());
            assertEquals(document.getElementsByTagName("AddInfo").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Add Info']/td")).getText());
            assertEquals(document.getElementsByTagName("Imports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Imports']/td")).getText());
            assertEquals(document.getElementsByTagName("Exports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Exports']/td")).getText());
            assertEquals(document.getElementsByTagName("PoliticalStructure").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Political Structure']/td")).getText());
            assertEquals(document.getElementsByTagName("IntlDialingCode").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Intl Dialing Code']/td/input")).getAttribute("value"));

       }
    }

    public void clicksOnReplacedByDropdown() {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath +"Replaced By']/td")).click();
    }

    public void verifyReplacedByDropdownList() {
        List<WebElement> replacedBy = getDriver().findElements(By.xpath(basic_info_label_value_xpath+"Replaced By']/td//div[@class='chosen-drop']//li"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"country list");
        List<String> countryList = new ArrayList<>();
         for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
             countryList.add(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent());
        }
        countryList.remove(DataPage.selectedEntity);
        for(int i=0; i<replacedBy.size(); i++){
            assertEquals(countryList.get(i).trim(),replacedBy.get(i).getText().trim());
        }
    }

    public void entersCountryBasicInfoStartDate() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).sendKeys(String.valueOf(year + 3));
    }

    public void entersCountryBasicInfoEndDate() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).sendKeys(String.valueOf(year+3));

    }
    public void enterCountryStartYear(String countryStartYear) {
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).sendKeys(countryStartYear);
    }

    public void enterCountryEndYear(String countryEndYear){
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).sendKeys(countryEndYear);
    }

    public void enterCountryReplacedBy(String countryReplacedBy){
       getDriver().findElement(country_replacedBy_edit_xpath).click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li/input")).sendKeys(countryReplacedBy);
        getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li/input")).sendKeys(Keys.RETURN);

    }

    public void enterCountryAddInfo(String countryAddInfo){
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Add Info']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).sendKeys(countryAddInfo);
    }

    public void enterCountryImports(String countryImports){
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Imports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Imports']/td/textarea")).sendKeys(countryImports);
    }

    public void enterCountryExports(String countryExports){
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Exports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Exports']/td/textarea")).sendKeys(countryExports);
    }

    public void enterCountryPoliticalStructure(String countryPoliticalStructure){
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Political Structure']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Political Structure']/td/textarea")).sendKeys(countryPoliticalStructure);
    }

    public void enterCountryIntlDialingCode(String countryIntlDialingCode) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Intl Dialing Code']/td/input")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Intl Dialing Code']/td/input")).sendKeys(countryIntlDialingCode);
    }


    public void enterInvalidCharactersInCountryAddInfo() {
        char c='a';
        String invalidData="";
         for (int i=0;i<=500;i++){
             invalidData += c;
            }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Add Info']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryImports() {
        char c='a';
        String invalidData="";
        for (int i=0;i<=200;i++){
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Imports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Imports']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryExports() {
        char c='a';
        String invalidData="";
        for (int i=0;i<=200;i++){
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Exports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Exports']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryPoliticalStructure()
    {        char c='a';
        String invalidData="";
        for (int i=0;i<=200;i++){
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Political Structure']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Political Structure']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryIntlDialingCode() {
        char c='a';
        String invalidData="";
        for (int i=0;i<=5;i++){
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Intl Dialing Code']/td/input")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath+"Intl Dialing Code']/td/input")).sendKeys(invalidData);
    }

    public void verifyErrorMessageForAddInfo() {
        assertEquals(getDriver().findElement(country_addInfo_error_message_edit_xpath).getText(),"Enter up to 500 valid characters.");
    }

    public void verifyErrorMessageForImports() {
        assertEquals(getDriver().findElement(country_imports_error_message_edit_xpath).getText(),"Enter up to 200 valid characters.");
    }
    public void verifyErrorMessageForExports() {
        assertEquals(getDriver().findElement(country_exports_error_message_edit_xpath).getText(),"Enter up to 200 valid characters.");
    }
    public void verifyErrorMessageForPoliticalStructure() {
        assertEquals(getDriver().findElement(country_political_structure_error_message_edit_xpath).getText(),"Enter up to 200 valid characters.");
    }
    public void verifyErrorMessageForIntlDialingCode() {
        assertEquals(getDriver().findElement(country_intlDialingCode_error_message_edit_xpath).getText(),"Enter up to 5 valid characters.");
    }

    public void verifyISO2NotEditable() {
      try {
          getDriver().findElement(country_iso2_id).getAttribute("data-edit_id").toString();
      }catch (Exception e) {
          assertTrue(e.toString().equals("java.lang.NullPointerException"));
      }
    }

    public void verifyISO3NotEditable() {
        try {
            getDriver().findElement(country_iso3_id).getAttribute("data-edit_id").toString();
        }catch (Exception e) {
            assertTrue(e.toString().equals("java.lang.NullPointerException"));
        }
    }

    public void verifyCountryIso3(String iso3) {
        assertEquals("ISO3", getDriver().findElement(country_iso3_label_id).getText());
        assertEquals(iso3, getDriver().findElement(country_iso3_id).getText());
    }

    public void clickOnBasicInfoInNavigationBar() {
        attemptClick(country_basic_info_link_id);
    }

    public void clickOnRegionsInNavigationBar() {
        attemptClick(country_regions_link_id);
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
        assertEquals("TIME ZONES", getDriver().findElement(basic_info_time_zones_label_xpath).getText());
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

    public void clickOnReplacedByCountry(String replacedByCountry) {
        selectedCountry = replacedByCountry;
        attemptClick(By.linkText(replacedByCountry));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCountryHolidays() {
        attemptClick(country_holidays_link_id);
    }

    public void verifyCountryHolidays(ExamplesTable countryHolidaysList) {
        assertEquals("HOLIDAYS FOR " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_label_xpath).getText());
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
        assertEquals("HOLIDAYS FOR " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_label_xpath).getText());
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
        assertEquals("PAYMENTS FOR " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("IBAN", getDriver().findElement(country_payments_iban_label_xpath).getText());
        assertEquals("REGISTERED DATE", getDriver().findElement(country_payments_registered_date_label_xpath).getText());
        assertEquals("ISO CODE", getDriver().findElement(country_payments_iso_code_label_xpath).getText());
        assertEquals("IBAN ROUTING CODE TYPE", getDriver().findElement(country_payments_code_type_label_xpath).getText());
        List<WebElement> isoCode = getDriver().findElements(country_payments_iso_code_xpath);
        List<WebElement> registeredDate = getDriver().findElements(country_payments_registered_date_xpath);
        List<WebElement> ibanRoutingCode = getDriver().findElements(country_payments_code_type_xpath);
        for(int i=0; i<countryPaymentsIban.getRowCount(); i++){
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(0)),registeredDate.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(1)),isoCode.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(2)),ibanRoutingCode.get(i).getText());
        }
    }

    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes) {
        assertEquals("ROUTING CODE TYPES IN " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
        List<WebElement> types = getDriver().findElements(country_payments_routing_code_code_types_xpath);
        for (int i=0; i<countryPaymentsRoutingCodesTypes.getRowCount(); i++){
            assertEquals(countryPaymentsRoutingCodesTypes.getRow(i).get(countryPaymentsRoutingCodesTypes.getHeaders().get(0)),types.get(i).getText());
        }
    }

    public void verifyCountryNoIbanInfo() {
        assertEquals("PAYMENTS FOR", getDriver().findElement(country_payments_label_xpath).getText());
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
        //assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("ROUTING CODE TYPES IN " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_payments_routing_code_code_types_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyCountryPaymentsIbanStatus(String status) {
        assertEquals("Status " + status, getDriver().findElement(country_payments_status_xpath).getText());
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

    public void clickOnCountryLanguages() {
        attemptClick(country_languages_link_id);
    }

    public void verifyCountryLanguages(String languages) {
        assertEquals("Summary", getDriver().findElement(country_languages_label_xpath).getText());
        assertEquals(languages, getDriver().findElement(country_languages_value_xpath).getText());
    }

    public void clickOnCountryPlaces() {
        attemptClick(country_places_link_id);
    }

    public void clickOnCountryEntity() {
        attemptClick(country_entity_link_id);
    }

    public void clickOnCountryPeople() {
        attemptClick(country_people_link_id);
    }

    public void clickOnCountryCurrenciesLink() {
        attemptClick(country_currencies_link_id);
    }

    public void clickOnCountryNameType() {
        attemptClick(country_edit_names_type_list_xpath);
    }


    public void clickOnCountryIdentifierType() {
        attemptClick(country_edit_identifier_type_list_xpath);
    }

    public void verifyCountryNameTypesList(Database database, ApacheHttpClient apacheHttpClient) {
        List<WebElement> countryNameTypesList = getDriver().findElements(country_name_type_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country names type");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryNameTypesList.get(i).getText());
        }
    }

    public void verifyCountryIdentifierTypesList(Database database, ApacheHttpClient apacheHttpClient) {
        List<WebElement> countryIdentifierTypesList = getDriver().findElements(country_identifier_type_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country identifiers");
        for (int i = 1; i < document.getElementsByTagName("identifier").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryIdentifierTypesList.get(i).getText());
        }
    }

    public void clickOnAddNewNameButton() {
        attemptClick(country_add_new_name_button_id);
    }


    public void clickOnAddNewIdentifierButton() {
        attemptClick(country_add_new_identifier_button_id);
    }


    public void enterCountryName(String countryName) {
        getDriver().findElement(country_country_name_input_xpath).clear();
        getDriver().findElement(country_country_name_input_xpath).sendKeys(countryName);
    }




    public void clearCountryIdentifierValue() {
        try
        {
            List<WebElement> webElements = getDriver().findElements(country_identifier_value_input_xpath);
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.clear();
        }
        catch (Exception e)
        {
        }

    }

    public void clearCountryIdentifierType() {
        getDriver().findElement(country_identifier_type_input_xpath).clear();
    }



    public void enterIdentifierType(String identifierType)
    {
        try
        {
            List<WebElement> webElements = getDriver().findElements(country_identifier_type_input_xpath);
            int columns_count = webElements.size();

            WebElement mySelectElm = webElements.get(columns_count - 1);
                    Select mySelect = new Select(mySelectElm);
            mySelect.selectByValue(identifierType);
        }
        catch (Exception e)
        {
        }
    }


    public void enterIdentifierValue(String identifierValue)
    {
        try
        {

            List<WebElement> webElements = getDriver().findElements(country_identifier_value_input_xpath);
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.sendKeys(identifierValue);
        }
        catch (Exception e)
        {

        }
    }

        public void verifyErrorMessageForCountryName() {
        assertEquals("Required", getDriver().findElement(country_name_value_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredNameType() {
        assertEquals("Required", getDriver().findElement(country_names_type_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredIdentifierValue() {
        assertEquals("Required", getDriver().findElement(country_identifier_value_err_msg_xpath).getText());
    }


    public void verifyErrorMessageForLongIdentifierValue() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_identifier_value_err_msg_xpath).getText());
    }


    public void verifyErrorMessageForRequiredIdentifierType() {
        assertEquals("Required", getDriver().findElement(country_identifier_type_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredValueType() {
        assertEquals("Required", getDriver().findElement(country_names_value_required_err_msg_xpath).getText());
    }

    public void clickOnDeleteNewRowButton() {
        attemptClick(country_delete_new_row_button_xpath);
    }

    public void verifyDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(country_delete_confirmation_modal_xpath).getText());
    }


    public void verifyIdentifierDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(country_delete_confirmation_modal_xpath).getText());
    }


    public void clickOnNoButtonInDeleteConfirmationModal() {
        attemptClick(country_delete_no_button_id);
    }

    public void clickOnYesButtonInDeleteConfirmationModal() {
        attemptClick(country_delete_yes_button_id);
    }

    public void verifyNewlyAddedNameRowIsDisplayed() {
        assertTrue(getDriver().findElement(country_additional_name_row_id).isDisplayed());
    }

    public void verifyNewlyAddedNameRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(country_additional_name_row_id).isDisplayed());
        } catch (NoSuchElementException e){}
    }

    public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(country_additional_identifiers_row_id).isDisplayed());
        } catch (NoSuchElementException e){}
        }

    public void verifyCountryNameValueErrMsg() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_name_value_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForTimeZoneSummary() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(country_time_zone_summary_err_msg_xpath).getText());
    }

    public void enterTimeZoneSummary(String timeZoneSummary) {
        getDriver().findElement(country_time_zone_summary_input_xpath).clear();
        getDriver().findElement(country_time_zone_summary_input_xpath).sendKeys(timeZoneSummary);
    }

    public void clickOnAddNewTimeZone() {
        attemptClick(country_add_new_time_zone_button_id);
    }

    public void clickOnSelectTimeZone() {
        attemptClick(country_time_zone_list_box_xpath);
    }

    public void verifyCountryTimeZoneSummary() {
        List<WebElement> countryTimeZonesList = getDriver().findElements(country_time_zone_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country time zones");
        for (int i = 1; i < document.getElementsByTagName("timeZone").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryTimeZonesList.get(i).getText());
        }
    }

    public void verifyNewlyAddedTimeZoneRowIsDisplayed() {
        assertTrue(getDriver().findElement(country_additional_time_zone_row_id).isDisplayed());
    }

    public void verifyNewlyAddedTimeZoneRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(country_additional_time_zone_row_id).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){

        }
    }

    public void enterCountryHolidayDay(String day) {
        getDriver().findElement(country_holiday_day_xpath).clear();
        getDriver().findElement(country_holiday_day_xpath).sendKeys(day);
    }

    public void enterCountryHolidayMonth(String month) {
        selectItemFromDropdownListByText((country_holiday_month_xpath), month);
    }

    public void enterCountryHolidayYear(String year) {
        getDriver().findElement(country_holiday_year_xpath).clear();
        getDriver().findElement(country_holiday_year_xpath).sendKeys(year);
    }

    public void verifyErrorMsgForCountryHolidayDate() {
        assertEquals("Enter a day/month/year.", getDriver().findElement(country_holiday_date_error_msg_xpath).getText());
    }

    public void clickOnAddNewCountryHolidayButton() {
        attemptClick(country_add_new_holiday_button_id);
    }

    public void verifyErrorMsgRequiredForCountryHolidayDate() {
        assertEquals("Required", getDriver().findElement(country_holiday_date_error_msg_xpath).getText());
    }

    public void enterCountryHolidayDescription(String description) {
        getDriver().findElement(country_holiday_description_box_xpath).clear();
        getDriver().findElement(country_holiday_description_box_xpath).sendKeys(description);
    }

    public void enterCountryHolidayNotes(String notes) {
        getDriver().findElement(country_holiday_note_box_xpath).clear();
        getDriver().findElement(country_holiday_note_box_xpath).sendKeys(notes);
    }

    public void verifyCountryHolidaysDescriptionErrMsg() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(country_holiday_description_err_msg_xpath).getText());
    }

    public void verifyCountryHolidaysNotesErrMsg() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(country_holiday_notes_err_msg_xpath).getText());
    }

    public void verifyNewlyAddedHolidayRow() {
        assertTrue(getDriver().findElement(country_new_holiday_row_xpath).isDisplayed());
    }

    public void verifyNoNewlyAddedHolidayRow() {
        try {
            assertFalse(getDriver().findElement(country_new_holiday_row_xpath).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void clickOnLanguageLink() {
        attemptClick(country_language_link_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterSummaryLanguage(String summary) {
        getDriver().findElement(language_summary_textarea_xpath).sendKeys(summary);
    }

    public void verifyErrorMsgForCountryLanguage() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(country_language_err_msg_xpath));
    }


    public void enterCreditRatingAppliedYear (String appliedYear) {
        getDriver().findElement(country_credit_rating_appliedYear_xpath).clear();
        getDriver().findElement(country_credit_rating_appliedYear_xpath).sendKeys(appliedYear);
    }

    public void verifyErrorMessageAppliedYearLaterThanToday() {
        assertEquals("Must be no later than today.",getDriver().findElement(country_credit_rating_appliedyear_errorNolaterThanToday_xpath).getText());
    }

    public void enterCreditRatingConfirmedYear (String confirmedYear) {
        getDriver().findElement(country_credit_rating_confirmedYear_xpath).clear();
        getDriver().findElement(country_credit_rating_confirmedYear_xpath).sendKeys(confirmedYear);
    }

    public void verifyErrorMessageConfirmedYearLaterThanToday(){
        assertEquals("Must be no later than today.",getDriver().findElement(country_credit_rating_confirmedYear_errorNoLaterThanToday_xpath).getText());
    }

    public void verifyRequiredErrorMessage() {
        assertEquals("Required",getDriver().findElement(country_credit_rating_required_xpath).getText());
    }

    public void clickAddRowButton(){
        rowCount = getDriver().findElement(country_credit_rating_tableBody_id).findElements(By.tagName("tr")).size();
        getDriver().findElement(country_credit_rating_addRow_id).click();
    }

    public void verifyRowCount(){
        rowCount++;
        assertEquals(rowCount,getDriver().findElement(country_credit_rating_tableBody_id).findElements(By.tagName("tr")).size());
        rowCount--;
        assertEquals("new",getDriver().findElement(country_credit_rating_tableBody_id).findElements(By.tagName("tr")).get(rowCount).getAttribute("class"));

    }

    public void clickOnRemoveButton() {
        getDriver().findElement(country_credit_rating_deleteButton_xpath).click();
    }

    public void verifyRowCountAfterDelete(){
        int updatedRows = getDriver().findElement(country_credit_rating_tableBody_id).findElements(By.tagName("tr")).size();
        for(int i=0;i<updatedRows;i++){
            assertTrue(getDriver().findElement(country_credit_rating_tableBody_id).findElements(By.tagName("tr")).get(i).getAttribute("class").equals(""));
        }
    }




}
