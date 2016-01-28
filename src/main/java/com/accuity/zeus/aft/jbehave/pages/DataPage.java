package com.accuity.zeus.aft.jbehave.pages;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataPage extends AbstractPage {

    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By country_tab_xpath=By.xpath("//*[@id='data-navbar']/ul/li[2]");
    private By area_tab_id=By.id("area-nav");
    private By labels_xpath = By.xpath("//*[@id='selection']/fieldset/h1");
    private By currency_country_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By currency_country_list_edit_xpath = By.xpath("//fieldset//select[@name='country']/option");
    private By legalEntity_tab_id = By.id("legalEntity-nav");
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
    private By country_listBox_xpath = By.xpath("//*[@id='selection0'] //*[@id='entitySelect_chosen']//span");
    private By area_listBox_xpath = By.xpath("//*[@id='selection1'] //*[@id='entitySelect_chosen']//span");
    private By subarea_listBox_xpath = By.xpath("//*[@id='selection2'] //*[@id='entitySelect_chosen']//span");

    String currency_use_table_country_edit_xpath = "//select[@name='country']";

    private By currency_use_table_startDate_day_edit_xpath=By.xpath("//input[@name='began-day']");
    String currency_use_table_startDate_month_edit_xpath = "//select[@name='began-month']";
    private By currency_use_table_startDate_year_edit_xpath=By.xpath("//input[@name='began-year']");
    private By currency_use_table_endDate_day_edit_xpath=By.xpath("//input[@name='end-day']");
    String currency_use_table_endDate_month_edit_xpath = "//select[@name='end-month']";

    private By currency_use_table_endDate_year_edit_xpath=By.xpath("//input[@name='end-year']");

  //  private By currency_use_table_primary_edit_xpath =By.xpath("//fieldset[@data-edit_id='primary']/input[@checked]");
    String currency_use_table_primary_edit_xpath ="//fieldset[@data-edit_id='primary']";

    private By currency_use_table_replacedBy_disable_edit_xpath = By.xpath("//fieldset[2]//div[@class='chosen-container chosen-container-single chosen-disabled']/a");
    String currency_use_table_replacedBy_edit_xpath= "//fieldset[2]//div[@class='chosen-container chosen-container-single']";
    private By country_listBox_value_xpath=By.xpath(".//*[@id='selection0'] //*[@class='chosen-drop']//ul");
    private By country_type_ahead_xpath=By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input");
    private By currency_selection_disabled_xpath=By.xpath(".//*[@id='entitySelect_chosen'][@class='chosen-container chosen-container-single chosen-disabled']");
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
    private By legalEntity_basic_info_link_id = By.id("legalEntityBasicInfo");
    private By country_demographics_type_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[1]");
    private By country_demographics_value_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[2]");
    private By country_demographics_unit_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[3]");
    private By country_demographics_date_label_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/thead/tr/th[4]");
    private By country_demographics_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[2]");
    private By country_demographics_type_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[1]");
    private By country_demographics_value_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[2]");
    private By country_demographics_unit_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[3]");
    private By country_demographics_date_xpath = By.xpath("//*[@id='content']//li[1]/table[2]/tbody/tr/td[4]");

    private By identifiers_label_xpath = By.xpath("//*[@id='content']//h2[text()='Identifiers']");
    private By identifiers_type_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[1]");
    private By identifiers_value_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[2]");
    private By identifiers_status_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[3]");
    private By identifiers_type_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//td[1]");

    private By legal_entity_office_identifiers_label_xpath = By.xpath("//*[@id='content']//li//h1/span[text()='Identifiers']");
    private By legal_entity_office_identifiers_type_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[1]");
    private By legal_entity_office_identifiers_value_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[2]");
    private By legal_entity_office_identifiers_status_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[3]");
    private By legal_entity_office_identifiers_type_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//td[1]");

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

    private By country_holidays_link_id = By.id("countryHolidays");
    private By country_languages_link_id = By.id("countryLanguages");
    private By country_holiday_label_xpath = By.xpath("//li[contains(h1,'Holidays for')]//span");
    private By country_languages_label_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dt");
    private By country_languages_value_xpath = By.xpath("//*[@id='content']/div/ul/li/dl/dd");

    private By country_holiday_table_header_xpath = By.xpath("//li[contains(h1,'Holidays for')]//thead");
    private By country_holiday_date_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[1]");
    private By country_holiday_description_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[2]");
    private By country_holiday_notes_xpath = By.xpath("//li[contains(h1,'Holidays for')]//tr/td[3]");

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

    private By regions_label_xpath = By.xpath("//li[contains(h1,'Regions for')] //span");
    private By regions_type_label_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/th[1]");
    private By regions_value_label_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/th[2]");
    private By regions_type_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/td[1]");
    private By regions_value_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/td[2]");

    private By country_credit_rating_id = By.id("countryCreditRating");
    private By credit_rating_label_xpath = By.xpath("//li[contains(h1,'Credit Rating')]/h1/span");
    private By credit_rating_table_headers_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//thead/tr");
    private By credit_rating_agency_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[1]");
    private By credit_rating_type_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[2]");
    private By credit_rating_value_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[3]");
    private By credit_rating_applied_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[4]");
    private By credit_rating_confirmed_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[5]");

    private By currency_update_button_id = By.id("update-button");
    private By currency_cancel_button_id = By.id("cancel-button");
    private By currency_input_name_xpath = By.xpath("//input[@name='name']");
    private By currency_input_abbr_xpath = By.xpath("//input[@name='abbr']");
    private By currency_input_unit_xpath = By.xpath("//input[@name='unit']");
    private By currency_input_quantity_xpath = By.xpath("//input[@name='quantity']");
    private By currency_header_xpath = By.xpath(".//*[@id='selection']/fieldset/h1");
    private By currency_header_iso_id = By.id("iso-value");
    private By country_places_link_id= By.id("countryPlaces");
    private By places_label_xpath = By.xpath("//li[contains(h1,'Places')]//span");
    private By places_type_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[1]");
    private By places_place_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[2]");
    private By places_details_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[3]");
    private By country_places_type_xpath = By.xpath("//li[contains(h1,'Places')]//table/tbody//td[1]");
    private String selectedEntity="";
    private By country_entity_link_id = By.id("countryPresences");
    private By entities_label_xpath = By.xpath("//li[contains(h1,'Entities')]//span");
    private By entities_type_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[1]");
    private By entities_entity_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[2]");
    private By entities_details_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[3]");
    private By country_entities_type_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/tbody//td[1]");
    private By select_all_link_xpath = By.xpath("//*[@id='all'][@class='selected']");
    private By all_link_id = By.id("all");
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
    private By area_area_dropdown_xpath = By.xpath("//*[@id='selection1'] /div //*[@id='entitySelect_chosen'] //a");
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
    private By city_people_link_id = By.id("cityPeople");
    private By area_entities_link_id = By.id("areaPresences");
    private By identifiers_header_xpath = By.xpath("//li[h1='Identifiers'] //span");
    private By office_sort_name_label_xpath = By.xpath("//*[@id='content']//li[1]/dl/dt");
    private By office_sort_name_value_xpath = By.xpath("//*[@id='content']//li[1]/dl/dd");

    public DataPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    private By people_label_xpath = By.xpath("//li[contains(h1,'People')]//span");
    private By people_type_label_xpath = By.xpath("//li[contains(h1,'People for ')]//table/thead//th[1]");
    private By people_entity_label_xpath = By.xpath("//li[contains(h1,'People for ')]//table/thead//th[2]");
    private By people_type_xpath = By.xpath("//li[contains(h1,'People for ')]//table/tbody//td[1]");
    private By area_area_dropdown_list_xpath = By.xpath(".//*[@id='selection1'] //ul/li");
    private By area_subarea_dropdown_list_xpath = By.xpath(".//*[@id='selection2'] //ul/li");
    private By area_area_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen']//input");
    private By area_subarea_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    private By area_basic_info_link_id = By.id("areaBasicInfo");
    private By area_related_places_link_id = By.id("areaPlaces");
    private By area_related_people_link_id = By.id("areaPeople");
    private By area_demographics_link_id= By.id("areaDemographics");
    private By area_demographics_label_xpath = By.xpath("//li[contains(h1, 'Demographics for')]/h1/span");
    private By area_demographics_type_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[1]");
    private By area_demographics_value_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[2]");
    private By area_demographics_unit_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[3]");
    private By area_demographics_date_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[4]");
    private By area_demographics_type_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table//tbody//td[1]");
    private By city_type_ahead_xpath =By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    private By city_region_link_id =By.id("cityRegions");
    public By city_entity_link_id = By.id("cityPresences");
    private By city_basic_info_link_id = By.id("cityBasicInfo");
    private By city_related_places_link_id = By.id("cityPlaces");

    private By basic_info_office_names_label_xpath = By.xpath(".//*[@id='content']//li[1]/h2[2]");
    private By basic_info_office_type_label_xpath = By.xpath(".//*[@id='content']//li[1]/table[2]/thead/tr/th");
    private By basic_info_office_type_xpath = By.xpath(".//*[@id='content']//li[1]/table[2]/tbody/tr/td");

    private By personnel_label_xpath = By.xpath("//li[contains(h1,'Personnel')]/h1/span");
    private By personnel_type_label_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/thead//th[1]");
    private By personnel_value_label_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/thead//th[2]");
    private By personnel_type_list_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/tbody//td[1]");
    private By personnel_value_list_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/tbody//td[2]");

    private By history_label_xpath = By.xpath("//li/h1/span[text()='History']");
    private By history_message_xpath = By.xpath("//li[contains(h1,'History')]/p");

    private By statistics_label_xpath = By.xpath("//li/h1/span[text()='Statistics']");
    private By statistics_type_label_xpath = By.xpath("//li[h1='Statistics'] //thead/tr/th[1]");
    private By statistics_value_label_xpath = By.xpath("//li[h1='Statistics'] //thead/tr/th[2]");
    private By statistics_type_list_xpath = By.xpath("//li[h1='Statistics'] //table/tbody/tr/th");
    private By statistics_value_list_xpath = By.xpath("//li[h1='Statistics'] //table/tbody/tr/td");

    private By searchResults_institution_xpath = By.xpath(".//*[@id='cssTempFixId']/header//a");
    private By searchResults_headOffice_address_xpath =By.xpath(".//*[@id='cssTempFixId']/header//p");
    private By searchResults_header_fid_xpath = By.xpath(".//*[@id='cssTempFixId']/header/table//tr[th='FID']/td");
    private By searchResults_header_tfpid_xpath = By.xpath(".//*[@id='cssTempFixId']/header/table//tr[th='TFPID']/td");
    private String clickedCurrencyIso="";
    private String city_area_link_xpath = "//*[@class='vertical']//tr[5]/td[a='";
    private String city_subarea_link_xpath = "//*[@class='vertical']//tr[6]/td[a='";
    private String city_country_link_xpath = "//*[@class='vertical']//tr[4]/td[a='";
    String city_related_places_place_link_xpath = "//li[contains(h1,'Places')]//tr[td='";

    private By sections_display_xpath = By.xpath("//*[@id='data-side-navbar']//h1");
    private By sections_list_xpath = By.xpath("//*[@id='data-side-navbar']//ul/li");

    private By country_dropdown_is_visible_xpath = By.xpath("//*[@id='selection0']//div[@class='chosen-container chosen-container-single']");
    private By area_dropdown_is_visible_xpath = By.xpath("//*[@id='selection1']//div[@class='chosen-container chosen-container-single']");
    private By subarea_city_dropdown_is_visible_xpath = By.xpath("//*[@id='selection2']//div[@class='chosen-container chosen-container-single']");
    private String area_area_parent_link_xpath = "//table[@class='vertical']//td[a='";
    private By basic_info_left_section_xpath = By.xpath("//table[@class='vertical']/tbody//th");
    private By confirm_button_id = By.id("confirm-button");
    private By save_button_id = By.id("save-button");
    private By currency_abbr_error_message_xpath = By.xpath("//*[@data-error_id='abbrError']");
    private By currency_name_error_message_xpath = By.xpath("//*[@data-error_id='nameError']");
    private By currency_unit_error_message_xpath = By.xpath("//*[@data-error_id='unitError']");
    private By currency_quantity_error_message_xpath = By.xpath("//*[@data-error_id='quantityError']");
    private By error_message_at_top_xpath = By.xpath("//*[@id='error']/div/div/p");
    private By confirm_button_xpath = By.xpath("//*[@id='modal-region'] //*[@id='confirm-button']");
    private By cancel_yes_button_id = By.id("confirm-button");
    private By return_button_xpath = By.xpath("//*[@id='modal-region'] //button[@id='cancel-button']");
    private By confirm_changes_info_xpath = By.xpath("//*[@id='modal-region']/div/p");
    private By confirm_changes_heading_xpath = By.xpath("//*[@id='modal-region']/div/h1");
    private By currency_replaced_by_xpath = By.xpath("//*[@class='chosen-results']/li");
    private By currency_start_date_error_msg_xpath = By.xpath("//*[@data-error_id='startDateError']");
    private By currency_end_date_error_msg_xpath = By.xpath("//*[@data-error_id='endDateError']");
    private By currency_start_date_drop_down_xpath = By.xpath("//select[@name='began-month']");
    private By cancel_no_button_id = By.id("cancel-button");
    private By currency_add_country_option_xpath = By.xpath("//*[@id='add_use_chosen']/a");
    private By currency_add_country_type_ahead_input_xpath = By.xpath("//*[@id='add_use_chosen']/div/div/input");
    private By currency_use_table_additional_use_primary_edit_xpath = By.xpath("//*[@id='additionalUses']//fieldset/input[@checked]");
    private By currency_use_table_additional_use_status_xpath = By.xpath("//*[@id='additionalUses']/tr/td[@class='status']");
    private By currency_add_country_list_xpath = By.xpath("//*[@id='add_use_chosen'] //ul/li");
    private By currency_use_table_delete_use_option_xpath = By.xpath("//button[@class='delete-row']");
    private By currency_use_table_additional_use_row_xpath = By.xpath("//*[@id='additionalUses']");

    private String editedCurrencyName="";
    private String editedCurrencyAbbr="";
    private String editedCurrencyUnit="";
    private String editedCurrencyQuantity="";
    private String editedCurrencyStartDay="";
    private String editedCurrencyStartMonth="";
    private String editedCurrencyStartYear="";
    private String editedCurrencyEndDay="";
    private String editedCurrencyEndMonth="";
    private String editedCurrencyEndYear="";
    private String editedCurrencyPrimary="";
    private String editedCurrencyCountry="";
    private String editedCurrencyReplacedBy="";

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

    public void verifyCurrencyList(Database database, ApacheHttpClient apacheHttpClient) {
        assertEquals(getDriver().findElement(labels_xpath).getText(), "CURRENCY");
        List<WebElement> currencyList = getDriver().findElements(currency_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "currency list");
        for (int i = 0; i < document.getElementsByTagName("name").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), currencyList.get(i).getText());
        }
    }

    public void verifyCountryList(Database database, ApacheHttpClient apacheHttpClient){
        assertEquals(getDriver().findElement(labels_xpath).getText(), "COUNTRY");
        List<WebElement> countryList = getDriver().findElements(currency_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), countryList.get(i).getText().trim());
        }
    }

    public void verifyCountryListInCurrencyEditMode(Database database, ApacheHttpClient apacheHttpClient){
        List<WebElement> countryList = getDriver().findElements(currency_country_list_edit_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), countryList.get(i).getText().trim());
        }
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
        List<WebElement> currencyList = getDriver().findElements(currency_country_list_xpath);
        for(int i=0; i<currencyList.size(); i++){
            assertTrue(currencyList.get(i).getText().toLowerCase().contains(currencySearchString.toLowerCase()));
        }
    }

    public void verifyNoResultsMatchOption() {
        assertEquals("No results match \"" + currencySearchString + "\"", getDriver().findElement(no_results_match_xpath).getText());
    }

    public void selectCurrencyFromTypeAhead(String currency) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public LegalEntityPage clickOnLegalEntityTab() {
        attemptClick(legalEntity_tab_id);
        return new LegalEntityPage(getDriver(), getUrlPrefix());
    }

    public void clickOnCountryListBox() {
        waitForElementToAppear(country_dropdown_is_visible_xpath);
        attemptClick(country_listBox_xpath);
    }

    public void verifyCountryTypeAheadAndListBox() {
        assertTrue(getDriver().findElement(country_type_ahead_xpath).isDisplayed());
        assertFalse(getDriver().findElement(country_listBox_xpath).getText().isEmpty());
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

    public void clickOnCancelButton() {
        attemptClick(currency_cancel_button_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyCurrencyViewMode() {
        assertTrue(getDriver().findElement(currency_abbr_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_name_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_unit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_quantity_xpath).isDisplayed());
    }

    public void verifyCurrencyUpdateModeForStatusActive() {
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_day_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_year_edit_xpath).isDisplayed());
        assertFalse(getDriver().findElement(currency_use_table_endDate_day_edit_xpath).isEnabled());
        assertFalse(getDriver().findElement(By.xpath(currency_use_table_endDate_month_edit_xpath+"/option[@selected='selected']")).isEnabled());
        assertFalse(getDriver().findElement(currency_use_table_endDate_year_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_replacedBy_disable_edit_xpath).isDisplayed());
    }

    public void verifyCurrencyUpdateModeForStatusInactive() {
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_day_edit_xpath).isDisplayed());

        //assertTrue(getDriver().findElement(currency_use_table_startDate_month_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).isDisplayed());

        assertTrue(getDriver().findElement(currency_use_table_startDate_year_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_endDate_day_edit_xpath).isEnabled());

        //assertTrue(getDriver().findElement(currency_use_table_endDate_month_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_endDate_month_edit_xpath+"/option[@selected='selected']")).isEnabled());
        assertTrue(getDriver().findElement(currency_use_table_endDate_year_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_replacedBy_edit_xpath + "/a")).isDisplayed());
    }

    public void verifyViewCurrencyDetailsFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedEntity) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            assertEquals("ISO", getTextOnPage(currency_iso_code_label_id));
            assertEquals(document.getElementsByTagName("iso").item(i).getTextContent(), getDriver().findElement(currency_iso_code_id).getText());
            assertEquals("Abbr", getTextOnPage(currency_abbr_label_xpath));
            assertEquals(document.getElementsByTagName("abbr").item(i).getTextContent(), getDriver().findElement(currency_abbr_xpath).getText());
            assertEquals("Name", getTextOnPage(currency_name_label_xpath));
            assertEquals(document.getElementsByTagName("name").item(i).getTextContent(), getDriver().findElement(currency_name_xpath).getText());
            assertEquals("Unit", getTextOnPage(currency_unit_label_xpath));
            assertEquals(document.getElementsByTagName("unit").item(i).getTextContent(), getDriver().findElement(currency_unit_xpath).getText());
            assertEquals("Quantity", getTextOnPage(currency_quantity_label_xpath));
            assertEquals(document.getElementsByTagName("quantity").item(i).getTextContent(), getDriver().findElement(currency_quantity_xpath).getText());
        }
    }

    public void verifyEditCurrencyDetailsFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedEntity) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            assertEquals(document.getElementsByTagName("iso").item(i).getTextContent(), getDriver().findElement(currency_iso_code_id).getText());
            assertEquals(document.getElementsByTagName("abbr").item(i).getTextContent(), getDriver().findElement(currency_input_abbr_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("name").item(i).getTextContent(), getDriver().findElement(currency_input_name_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("unit").item(i).getTextContent(), getDriver().findElement(currency_input_unit_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("quantity").item(i).getTextContent(), getDriver().findElement(currency_input_quantity_xpath).getAttribute("value"));
        }
    }

    public void verifyEditCurrencyInZeus(Database database, ApacheHttpClient apacheHttpClient, String selectedEntity){
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            if (editedCurrencyName.equals("")){}else{
                assertEquals(editedCurrencyName, document.getElementsByTagName("name").item(i).getTextContent());}
            if (editedCurrencyAbbr.equals("")){}else{
                assertEquals(editedCurrencyAbbr, document.getElementsByTagName("abbr").item(i).getTextContent());}
            if (editedCurrencyUnit.equals("")){}else{
                assertEquals(editedCurrencyUnit, document.getElementsByTagName("unit").item(i).getTextContent());}
            if (editedCurrencyQuantity.equals("")){}else{
                assertEquals(editedCurrencyQuantity, document.getElementsByTagName("quantity").item(i).getTextContent());}
        }
    }

    public void verifyEditCurrencyUseFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency)
    {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++){
            assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).getText());
            assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim(), getDriver().findElement(currency_use_table_startDate_day_edit_xpath).getAttribute("value")+" "+getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).getText()+" "+getDriver().findElement(currency_use_table_startDate_year_edit_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(), getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).getAttribute("value"));
        }
    }

    public void verifyEditCurrencyUseInZeus(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++) {
            if (editedCurrencyCountry.equals("")) {
            } else {
                assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), editedCurrencyCountry);
            }
            if (editedCurrencyStartMonth.equals("") && editedCurrencyStartDay.equals("") && editedCurrencyStartYear.equals("")) {
            } else {
                assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim().replace(" ",""), editedCurrencyStartDay+editedCurrencyStartMonth+editedCurrencyStartYear);
            }
            if (editedCurrencyEndDay.equals("") && editedCurrencyEndMonth.equals("") && editedCurrencyEndYear.equals("")){
            } else {
                assertEquals(document.getElementsByTagName("endDate").item(i).getTextContent().trim().replace(" ", ""), editedCurrencyEndDay+editedCurrencyEndMonth+editedCurrencyEndYear);
            }
            if(editedCurrencyReplacedBy.equals("")){
            } else {
                assertEquals(document.getElementsByTagName("replacedByName").item(i).getTextContent().trim(), editedCurrencyReplacedBy);
            }
            if (editedCurrencyPrimary.equals("")){}
            else{
                assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(),editedCurrencyPrimary);
            }
           // verifying the accuracy for start date
            if(editedCurrencyStartDay.equals("")&& !editedCurrencyStartMonth.equals("") && !editedCurrencyStartYear.equals(""))
            {
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"month");
            }else if(editedCurrencyStartDay.equals("")&& editedCurrencyStartMonth.equals("") && !editedCurrencyStartYear.equals("")){
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"year");
            }else {
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"day");
            }

            // verifying the accuracy for end date


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
        List<WebElement> expCurrencyList = getDriver().findElements(currency_country_list_xpath);
        for (int i=0; i<currencyList.getRowCount();i++){
            assertTrue(currencyList.getRow(i).containsValue(expCurrencyList.get(i).getText()));
        }
    }

    public void enterCountryInTheTypeAheadBox(String country) {
        selectedEntity = country;
        getDriver().findElement(country_type_ahead_xpath).sendKeys(country);
        getDriver().findElement(country_type_ahead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterAreaInTypeAhead(String area) {
        selectedEntity = area;
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(area);
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public void verifyTypes(ExamplesTable types) {
        assertEquals("OFFICE TYPES", getDriver().findElement(basic_info_office_names_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(basic_info_office_type_label_xpath).getText());
        List<WebElement> officeTypes = getDriver().findElements(basic_info_office_type_xpath);
        for(int i=0; i<types.getRowCount(); i++){
            assertEquals(types.getRow(i).get(types.getHeaders().get(0)), officeTypes.get(i).getText());
        }
    }

    public void clickOnBasicInfoInNavigationBar() {
        attemptClick(country_basic_info_link_id);
    }

    public void clickOnLegalEntityBasicInfo() {
        attemptClick(legalEntity_basic_info_link_id);
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

    public void verifyIdentifiers(ExamplesTable identifiers) {
        verifyIdentifiersLabels();
        List<WebElement> IdentifiersTypeVal = getDriver().findElements(identifiers_type_xpath);
        assertTrue(identifiers.getRowCount() == IdentifiersTypeVal.size());
        for(int i = 0; i<identifiers.getRowCount(); i++)
        {
            assertEquals(identifiers.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", "").trim(),
                    getDriver().findElement(
                            By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//tr[td='" + identifiers.getRow(i)
                                    .get(identifiers.getHeaders().get(0)) + "']")).getText().replace(",","").replace(" ", "").trim());
        }
    }

    public void verifyIdentifiersLabels(){
        assertEquals("IDENTIFIERS", getDriver().findElement(identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(identifiers_status_label_xpath).getText());
    }

    public void verifyLegalEntityOfficeIdentifiers(ExamplesTable identifiers){
        verifyLegalEntityOfficeIdentifiersLabels();
        List<WebElement> IdentifiersTypeVal = getDriver().findElements(legal_entity_office_identifiers_type_xpath);
        assertTrue(identifiers.getRowCount() == IdentifiersTypeVal.size());
        for(int i = 0; i<identifiers.getRowCount(); i++)
        {
            assertEquals(identifiers.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", "").trim(),
                    getDriver().findElement(
                            By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//tr[td='" + identifiers.getRow(i)
                                    .get(identifiers.getHeaders().get(0)) + "']")).getText().replace(",","").replace(" ", "").trim());

        }
    }

    public void verifyLegalEntityOfficeIdentifiersLabels(){
        assertEquals("IDENTIFIERS", getDriver().findElement(legal_entity_office_identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(legal_entity_office_identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(legal_entity_office_identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(legal_entity_office_identifiers_status_label_xpath).getText());
    }

    public void verifyIdentifiersSectionLabels(){
        verifyIdentifiersLabels();
        assertEquals("IDENTIFIERS", getDriver().findElement(identifiers_header_xpath).getText());
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

    public void verifyHeader(String entity, String headOfficeAddress, String fid, String tfpid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(entity, getDriver().findElement(searchResults_institution_xpath).getText());
        assertEquals(headOfficeAddress, getDriver().findElement(searchResults_headOffice_address_xpath).getText());
        assertEquals(fid, getDriver().findElement(searchResults_header_fid_xpath).getText());
        assertEquals(tfpid, getDriver().findElement(searchResults_header_tfpid_xpath).getText());
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

    public void verifyBasicInfo(String label,String value) {
        assertEquals(label, getDriver().findElement(By.xpath(basic_info_label_xpath +label+"']")).getText());
        assertEquals(value, getDriver().findElement(By.xpath(basic_info_label_value_xpath + label + "']/td")).getText().replace("\n", ""));
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

    public void verifyAreaLinkForCityInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Area']/td")).isSelected());
    }

    public void verifySubAreaLinkForCityInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Sub Area']/td")).isSelected());
    }
    public void clickOnReplacedByCountry(String replacedByCountry) {
        selectedEntity = replacedByCountry;
        attemptClick(By.linkText(replacedByCountry));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        assertEquals("HOLIDAYS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_label_xpath).getText());
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
        assertEquals("HOLIDAYS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(country_holiday_label_xpath).getText());
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
        assertEquals("PAYMENTS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(country_payments_label_xpath).getText());
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
        //assertEquals("PAYMENTS", getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("ROUTING CODE TYPES IN " + selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
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
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
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

    private void verifyCreditRatingsInternal(ExamplesTable creditRatings) {
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

    public void verifyCreditRatingsGeo(ExamplesTable creditRatings) {
        verifyCreditRatingsLabelsGeo();
        verifyCreditRatingsInternal(creditRatings);
    }

    public void verifyCreditRatings(ExamplesTable creditRatings) {
        verifyCreditRatingsLabels();
        verifyCreditRatingsInternal(creditRatings);
    }

    private void verifyCreditRatingsLabelsInternal() {
        assertEquals("AGENCY TYPE VALUE APPLIED DATE CONFIRMED DATE", getDriver().findElement(credit_rating_table_headers_xpath).getText());
    }

    public void verifyCreditRatingsLabelsGeo() {
        if(SearchPage.selectedEntity !=""){
            selectedEntity = SearchPage.selectedEntity;
        }
        assertEquals("CREDIT RATING FOR " + selectedEntity.toUpperCase(), getDriver().findElement(credit_rating_label_xpath).getText());
        verifyCreditRatingsLabelsInternal();
    }

    public void verifyCreditRatingsLabels() {
        assertEquals("CREDIT RATING", getDriver().findElement(credit_rating_label_xpath).getText());
        verifyCreditRatingsLabelsInternal();
    }

    public void verifyNoCreditRatings() {
        verifyCreditRatingsLabels();
        try {
            assertFalse(getDriver().findElement(credit_rating_agency_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){}
    }

    public void verifyNoCreditRatingsGeo() {
        verifyCreditRatingsLabelsGeo();
        try {
            assertFalse(getDriver().findElement(credit_rating_agency_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){}
    }

    public void clickOnUpdateCurrencyLink() {

        attemptClick(currency_update_button_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterCurrencyName(String name) {
        editedCurrencyName = name;
        if(name.length() > 100){
            modifyHtmlByName("name","maxlength", "");
        }
        getDriver().findElement(currency_input_name_xpath).clear();
        getDriver().findElement(currency_input_name_xpath).sendKeys(name);
    }

    public void enterCurrencyAbbr(String abbr) {
        editedCurrencyAbbr = abbr;
        if(abbr.length() > 30){
            modifyHtmlByName("abbr","maxlength", "");
        }
        getDriver().findElement(currency_input_abbr_xpath).clear();
        getDriver().findElement(currency_input_abbr_xpath).sendKeys(abbr);
    }

    public void enterCurrencyUnit(String unit) {
        editedCurrencyUnit = unit;
        if(unit.length() > 100){
            modifyHtmlByName("unit","maxlength", "");
        }
        getDriver().findElement(currency_input_unit_xpath).clear();
        getDriver().findElement(currency_input_unit_xpath).sendKeys(unit);
    }

    public void enterCurrencyQuantity(String quantity) {
        editedCurrencyQuantity = quantity;
        if(Integer.parseInt(quantity) > 10000){
            modifyHtmlByName("quantity","maxlength", "");
        }
        getDriver().findElement(currency_input_quantity_xpath).clear();
        getDriver().findElement(currency_input_quantity_xpath).sendKeys(quantity);
    }

    public void verifyCurrencySelectionDisabled() {
        assertTrue(getDriver().findElement(currency_selection_disabled_xpath).isDisplayed());
    }

    public void clickOnCountryPlaces() {
        attemptClick(country_places_link_id);
    }

    public void verifyPlaces(ExamplesTable placeValues)  {
        verifyPlacesLabel();
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
        assertEquals("PLACES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(places_label_xpath).getText());
    }

    public void verifyNoPlaces() {
        assertEquals("PLACES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(places_label_xpath).getText());
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


    public void verifyEntities(ExamplesTable countryEntities) {
        verifyEntitiesLabel();
        assertEquals("TYPE", getDriver().findElement(entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(entities_details_label_xpath).getText());
        for(int i = 0; i<countryEntities.getRowCount(); i++){
            assertEquals(countryEntities.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryEntities.getRow(i).get(countryEntities.getHeaders().get(0)) + "']")).getText().replace(",","").trim());
        }
    }


    public void verifyEntitiesLabel() {
        assertEquals("ENTITIES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(entities_label_xpath).getText());
    }

    public void verifyRegionsLabel() {
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
    }

    public void verifyNoEntities() {
        verifyEntitiesLabel();
        assertEquals("TYPE", getDriver().findElement(entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(entities_details_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_entities_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyDefaultToViewAll() {
        assertTrue(getDriver().findElement(select_all_link_xpath).isDisplayed());
    }

    public void clicksOnAllLink() {
        attemptClick(all_link_id);
    }

    public void verifyDefaultBasicInfo() {
        assertTrue(getDriver().findElement(city_basic_info_link_id).isDisplayed());
    }

    public void refreshThePage() {
        getDriver().navigate().refresh();
    }

    public void clickOnCountryCurrenciesLink() {
        attemptClick(country_currencies_link_id);
    }

    public void verifyCountryCurrencies(ExamplesTable countryCurrencies) {
        if(SearchPage.selectedEntity !=""){
            selectedEntity = SearchPage.selectedEntity;
        }
        assertTrue(getDriver().findElement(country_currencies_label_xpath).getText().matches("^CURRENCIES FOR " + selectedEntity.toUpperCase() + ".*$"));
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

    public void clickOnCountryPeople() {
        attemptClick(country_people_link_id);
    }

    public void verifyPeople(ExamplesTable countryPeople) {
        verifyPeopleLabel();
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        for(int i = 0; i<countryPeople.getRowCount(); i++){
            assertEquals(countryPeople.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryPeople.getRow(i).get(countryPeople.getHeaders().get(0)) + "']")).getText().replace(",", "").trim());
        }
    }

    public void verifyPeopleLabel() {
        assertEquals("PEOPLE FOR " + selectedEntity.toUpperCase(), getDriver().findElement(people_label_xpath).getText());
    }

    public void verifyNoPeople() {
        assertEquals("PEOPLE FOR " + selectedEntity.toUpperCase(), getDriver().findElement(people_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(people_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnAreaDropdown() {
        waitForElementToAppear(area_dropdown_is_visible_xpath);
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

    public void clickOnCityBasicInfoInNavigationBar() {
        attemptClick(city_basic_info_link_id);
    }

    public void clickOnAreaRelatedPlaces() {
        attemptClick(area_related_places_link_id);
    }

    public void clickOnCityRelatedPlaces() {
        attemptClick(city_related_places_link_id);
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
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + areaDemographics.getRow(i).get(areaDemographics.getHeaders().get(0)) + "']")).getText().replace(",", "").replace(" ","").trim());

        }
    }

    public void verifyDemographicsLabel() {
        if(SearchPage.selectedEntity !=""){
            selectedEntity = SearchPage.selectedEntity;
        }
        assertEquals("DEMOGRAPHICS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(area_demographics_label_xpath).getText());
    }

    public void verifyNoDemographics() {
        verifyDemographicsLabel();
        assertEquals("TYPE", getDriver().findElement(area_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(area_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(area_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(area_demographics_date_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(area_demographics_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void verifyStatistics(ExamplesTable statistics){
        verifyStatisticsLabels();
        List<WebElement> type = getDriver().findElements(statistics_type_list_xpath);
        List<WebElement> value = getDriver().findElements(statistics_value_list_xpath);

        for(int i=0;i<statistics.getRowCount();i++){
            assertEquals(statistics.getRow(i).get(statistics.getHeaders().get(0)),type.get(i).getText());
            assertEquals(statistics.getRow(i).get(statistics.getHeaders().get(1)),value.get(i).getText());
        }
    }

    public void verifyStatisticsLabels(){
        assertEquals("STATISTICS", getTextOnPage(statistics_label_xpath));
        assertEquals("TYPE",getTextOnPage(statistics_type_label_xpath));
        assertEquals("VALUE",getTextOnPage(statistics_value_label_xpath));
    }

    public void clickOnCityTab() {
        attemptClick(city_tab_id);
    }

    public void clickOnCityDropdown() {
        waitForElementToAppear(subarea_city_dropdown_is_visible_xpath);
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
        waitForElementToAppear(subarea_city_dropdown_is_visible_xpath);
        attemptClick(area_subarea_dropdown_xpath);
    }

    public void enterSubAreaInTypeAhead(String subArea) {
        selectedEntity = subArea;
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(subArea);
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
    }

    public void clickOnAreasAlternativeRegions() {
        attemptClick(area_regions_link_id);
    }

    public void verifyNoAlternativeRegions() {
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
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

    public void clickOnCityEntity() {
        attemptClick(city_entity_link_id);
    }

    public void enterCityInTheTypeAheadBox(String city) {
        selectedEntity = city;
        getDriver().findElement(city_type_ahead_xpath).sendKeys(city);
        getDriver().findElement(city_type_ahead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityRegionsInNavigationBar() {
        attemptClick(city_region_link_id);
    }

    public void clickOnCityRelatedPeople() {
        attemptClick(city_people_link_id);
    }

    public void clickOnAreaEntity(){
        attemptClick(area_entities_link_id);
    }

    public void verifyNoIdentifiers() {
        verifyIdentifiersLabels();
        try {
            assertFalse(getDriver().findElement(identifiers_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyNoLegalEntityOfficeIdentifiers() {
        verifyLegalEntityOfficeIdentifiersLabels();
        try {
            assertFalse(getDriver().findElement(legal_entity_office_identifiers_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyPersonnel(ExamplesTable personnel) {
        verifyPersonnelLabels();
        List<WebElement> type = getDriver().findElements(personnel_type_list_xpath);
        List<WebElement> value = getDriver().findElements(personnel_value_list_xpath);

        for(int i=0;i<personnel.getRowCount();i++){
            assertEquals(personnel.getRow(i).get(personnel.getHeaders().get(0)),type.get(i).getText());
            assertEquals(personnel.getRow(i).get(personnel.getHeaders().get(1)),value.get(i).getText());
        }
    }

    public void verifyPersonnelLabels() {
        assertEquals("PERSONNEL", getTextOnPage(personnel_label_xpath));
        assertEquals("TYPE",getTextOnPage(personnel_type_label_xpath));
        assertEquals("VALUE",getTextOnPage(personnel_value_label_xpath));
    }

    public void verifyNoPersonnel() {
        verifyPersonnelLabels();
        try {
            assertFalse(getDriver().findElement(personnel_type_list_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyHistoryLabel() {
        assertEquals("HISTORY", getTextOnPage(history_label_xpath));
    }
    public void verifyHistory(ExamplesTable history)
    {
        verifyHistoryLabel();
        assertEquals(history.getRow(0).get(history.getHeaders().get(0)), getTextOnPage(history_message_xpath));
    }

    public void verifyNoHistory() {
        verifyHistoryLabel();
        try{
            assertFalse(getDriver().findElement(history_message_xpath).isDisplayed());
        }catch (NoSuchElementException e)
        {
        }
    }

    public void verifyOfficeSortKey(String officeSortKey) {
        assertEquals("Sort Name",getTextOnPage(office_sort_name_label_xpath));
        assertEquals(officeSortKey,getTextOnPage(office_sort_name_value_xpath));
    }

    public void clickOnAreaParentLink(String areaParent) {
        attemptClick(By.xpath(area_area_parent_link_xpath + areaParent + "']/a"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnViewHeadOfficeLink(String viewHeadOffice) {
        attemptClick(By.linkText(viewHeadOffice));
    }

    public void verifyHeadOfficeInLegalEntityBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Head Office']/td")).isSelected());
    }

    public void clickOnISOLink(String isoCode){
        clickedCurrencyIso = isoCode;
        attemptClick(By.linkText(isoCode));

    }

    public void verifyCurrencyPage(){
        try{
            Thread.sleep(1500L);
            assertEquals("CURRENCY",getTextOnPage(currency_header_xpath));
            assertEquals(clickedCurrencyIso,getTextOnPage(currency_header_iso_id));
        }catch (Exception e){

        }
    }

    public void clickOnCityArea(String area) {
        attemptClick(By.xpath(city_area_link_xpath + area + "']/a"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyClickedAreaPage(String countryDropDown, String areaDropDown, String subAreaDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(countryDropDown,getDriver().findElement(country_listBox_xpath).getText());
        assertEquals(areaDropDown,getDriver().findElement(area_listBox_xpath).getText());
        assertEquals(subAreaDropDown,getDriver().findElement(subarea_listBox_xpath).getText());
    }

    public void clickOnCitySubArea(String subArea) {
        attemptClick(By.xpath(city_subarea_link_xpath + subArea + "']/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityRelatedPlace(String relatedPlace) {
        attemptClick(By.xpath(city_related_places_place_link_xpath + relatedPlace + "']/td/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityCountry(String country) {
        attemptClick(By.xpath(city_country_link_xpath + country + "']/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyClickedCountryPage(String countryDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(countryDropDown, getDriver().findElement(country_listBox_xpath).getText());
    }

    public void verifySections(ExamplesTable sections) {
        assertEquals("DISPLAY:",getDriver().findElement(sections_display_xpath).getText());
        for(int i=0; i<getDriver().findElements(sections_list_xpath).size(); i++) {
            assertEquals(sections.getRow(i).get(sections.getHeaders().get(0)), getDriver().findElements(sections_list_xpath).get(i).getText());
        }
    }

    public void verifyBasicInfoLeftSection(ExamplesTable basicInfoLeftSection) {
        List<WebElement> basicInfoLeftSectionFields = getDriver().findElements(basic_info_left_section_xpath);
        for(int i=0; i<getDriver().findElements(basic_info_left_section_xpath).size(); i++) {
            assertEquals(basicInfoLeftSection.getRow(i).get(basicInfoLeftSection.getHeaders().get(0)), basicInfoLeftSectionFields.get(i).getText());
        }
    }

    public void verifyNoCityAlternativeRegionsSection() {
        try {
            assertFalse(getDriver().findElement(regions_label_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e){
        }
    }

    public void clickOnSaveButton() {

        attemptClick(save_button_id);
    }

    public void verifyErrorMessageForCurrAbbr() {
        assertEquals("Please enter up to 30 valid characters for Abbreviation.", getDriver().findElement(currency_abbr_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrName() {
        assertEquals("Please enter up to 100 valid characters for Name.", getDriver().findElement(currency_name_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrUnit() {
        assertEquals("Please enter up to 100 valid characters for Unit.", getDriver().findElement(currency_unit_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrQuantity() {
        assertEquals("Please enter a numeric value up to 10,000 for Quantity.", getDriver().findElement(currency_quantity_error_message_xpath).getText());
    }

    public void verifyErrorMessageAtTopOfThePage() {
        assertEquals("The highlighted fields must be addressed before this update can be saved.", getDriver().findElement(error_message_at_top_xpath).getText());
    }

    public void verifyErrorMessageForRequiredField() {
        assertEquals("Required", getDriver().findElement(currency_name_error_message_xpath).getText());
    }

    public void clickOnConfirmButton() {
        attemptClick(confirm_button_xpath);
    }

    public void revertChangesToCurrencyAfghani(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency afghani for zeus",nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency afghani for trusted",nvPairs);
    }

    public void revertChangesToCurrencyDeutscheMark(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency Deutsche Mark for zeus",nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency Deutsche Mark for trusted",nvPairs);

    }

    public void revertChangesToCurrencyAsianCurrencyUnit(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency asian currency unit for zeus",nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency asian currency unit for trusted",nvPairs);
    }

    public void clickOnCancelYesButton() {
        attemptClick(cancel_yes_button_id);
    }

    public void verifySaveConfirmationModal() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Confirm Changes", getDriver().findElement(confirm_changes_heading_xpath).getText());
        assertEquals("Click Confirm to save or Return to continue with your edits.", getDriver().findElement(confirm_changes_info_xpath).getText());
        assertEquals("RETURN", getDriver().findElement(return_button_xpath).getText());
        assertEquals("CONFIRM", getDriver().findElement(confirm_button_xpath).getText());
    }

    public void clickOnReturnButton() {
        attemptClick(return_button_xpath);
    }

    public void verifyCurrencyEditMode(){
        assertTrue(getDriver().findElement(currency_input_name_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_abbr_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_unit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_quantity_xpath).isDisplayed());
    }

    public void verifyReplacedByCurrencyList(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency) {
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "currency list");
        List<String> currencyList = new ArrayList<>();
        List <WebElement> replacedByCurrenciesList = getDriver().findElements(currency_replaced_by_xpath);
        for (int i = 0; i < document.getElementsByTagName("name").getLength(); i++) {
            currencyList.add(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent());
        }
        currencyList.remove(selectedCurrency);
        for(int i=0; i<getDriver().findElements(currency_replaced_by_xpath).size(); i++){
            assertEquals(currencyList.get(i),replacedByCurrenciesList.get(i).getText());
        }
    }

    public void verifyStartDateErrorMessage(String startDateErrorMsg) {
        assertEquals(startDateErrorMsg.replace("'",""), getDriver().findElement(currency_start_date_error_msg_xpath).getText());
    }

    public void verifyEndDateErrorMessage(String endDateErrorMsg) {
        assertEquals(endDateErrorMsg.replace("'",""), getDriver().findElement(currency_end_date_error_msg_xpath).getText());
    }

    public void selectCurrencyCountry(String currencyCountry) {
        selectItemFromDropdownListByValue(currency_country_list_edit_xpath, currencyCountry);
    }

    public void enterCurrencyStartDay(String currencyStartDay) {
        editedCurrencyStartDay = currencyStartDay;
        getDriver().findElement(currency_use_table_startDate_day_edit_xpath).clear();
        getDriver().findElement(currency_use_table_startDate_day_edit_xpath).sendKeys(currencyStartDay);
    }

    public void enterCurrencyStartMonth(String currencyStartMonth) {
        editedCurrencyStartMonth = currencyStartMonth;
        selectItemFromDropdownListByText(By.xpath(currency_use_table_startDate_month_edit_xpath), currencyStartMonth);
    }

    public void enterCurrencyStartYear(String currencyStartYear) {
        editedCurrencyStartYear = currencyStartYear;
        getDriver().findElement(currency_use_table_startDate_year_edit_xpath).clear();
        getDriver().findElement(currency_use_table_startDate_year_edit_xpath).sendKeys(currencyStartYear);
    }

    public void enterCurrencyEndDay(String currencyEndDay) {
        editedCurrencyEndDay = currencyEndDay;
        getDriver().findElement(currency_use_table_endDate_day_edit_xpath).clear();
        getDriver().findElement(currency_use_table_endDate_day_edit_xpath).sendKeys(currencyEndDay);
    }

    public void enterCurrencyEndMonth(String currencyEndMonth) {
        editedCurrencyEndMonth = currencyEndMonth;
        selectItemFromDropdownListByText(By.xpath(currency_use_table_endDate_month_edit_xpath), currencyEndMonth);

    }

    public void enterCurrencyEndYear(String currencyEndYear) {
        editedCurrencyEndYear = currencyEndYear;
        getDriver().findElement(currency_use_table_endDate_year_edit_xpath).clear();
        getDriver().findElement(currency_use_table_endDate_year_edit_xpath).sendKeys(currencyEndYear);
    }

    public void enterCurrencyPrimary(String primary) {
        editedCurrencyPrimary=primary;
        getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath+"/input[@value='"+editedCurrencyPrimary.toLowerCase()+"']")).click();
    }

    public void enterCurrencyReplacedBy(String replacedBy) {
        editedCurrencyReplacedBy= replacedBy;
        getDriver().findElement(By.xpath(currency_use_table_replacedBy_edit_xpath+"/a")).click();

        getDriver().findElement(By.xpath(".//*[@id='content']/div/form/fieldset[2]/table/tbody[1]/tr/td[5]//input")).sendKeys(replacedBy);

        getDriver().findElement(By.xpath(".//*[@id='content']/div/form/fieldset[2]/table/tbody[1]/tr/td[5]//input")).sendKeys(Keys.RETURN);
    }

    public void clickOnCurrencyStartMonthDropDown() {
        attemptClick(currency_start_date_drop_down_xpath);
    }

    public void clickOnCancelNoButton() {
        attemptClick(cancel_no_button_id);
    }

    public void enterCountryInAddCountryTyAhead(String addCurrencyCountry) {
        getDriver().findElement(currency_add_country_type_ahead_input_xpath).sendKeys(addCurrencyCountry);
        getDriver().findElement(currency_add_country_type_ahead_input_xpath).sendKeys(Keys.RETURN);
    }

    public void enterCountryInCurrencyUsage(String currencyCountry){
        getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath)).sendKeys(currencyCountry);
        getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath)).sendKeys(Keys.RETURN);
        editedCurrencyCountry=currencyCountry;
    }

    public void clickOnAddCountryOption() {
        attemptClick(currency_add_country_option_xpath);
    }

    public void verifyPrimaryTrueByDefault(){
        assertEquals("true", getDriver().findElement(currency_use_table_additional_use_primary_edit_xpath).getAttribute("value"));
    }

    public void verifyStatusActiveByDefault(){
        assertEquals("Active", getDriver().findElement(currency_use_table_additional_use_status_xpath).getText());
    }

    public void verifyAddCountryList(Database database, ApacheHttpClient apacheHttpClient) {
        List<WebElement> addCountryList = getDriver().findElements(currency_add_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), addCountryList.get(i).getText().trim());
        }
    }

    public void clickOnDeleteUseOption() {
        attemptClick(currency_use_table_delete_use_option_xpath);
    }

    public void verifyNoAdditionalCurrencyUse(){
        assertTrue(getDriver().findElement(currency_use_table_additional_use_row_xpath).isDisplayed());
    }

    public void verifyViewCurrencyUseFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency) {
        verifyCurrencyUseTableHeaders();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++){
            assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[1]")).trim());
            assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[2]")).trim());
            assertEquals(document.getElementsByTagName("endDate").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[3]")).trim());
            assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[4]")).trim().toLowerCase());
            assertEquals(document.getElementsByTagName("replacedByISO").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[5]")).trim());
            assertEquals(document.getElementsByTagName("status").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[6]")).trim().toLowerCase());
        }
    }
}
