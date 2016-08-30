package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.w3c.dom.Document;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormatSymbols;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryPage extends AbstractPage {

    private By basic_info_time_zones_label_xpath = By.xpath("//*[@id='content']//li[1]//h2[text()='Time Zones']");
    private By labels_xpath = By.xpath("//*[@id='selection']/fieldset/h1");
    private By country_listBox_value_xpath = By.xpath(".//*[@id='selection0'] //*[@class='chosen-drop']//ul");
    private By country_type_ahead_xpath = By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input");
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
    private By country_banking_hrs_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[4]");
    private By country_banking_hrs_day_label_xpath = By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[1]");
    private By country_banking_hrs_hrs_label_xpath = By.xpath("//*[@id='content']//li[1]/table[4]/thead/tr/th[2]");
    private By country_banking_hrs_day_xpath = By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[1]");
    private By country_banking_hrs_hrs_xpath = By.xpath("//*[@id='content']//li[1]/table[4]/tbody/tr/td[2]");
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
    private By country_delete_timeZone_new_row_button_xpath = By.xpath(".//*[@data-row_id='timeZones']//button[@class='delete-element']");
    private By country_delete_identifiers_row_button_xpath = By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-element']");
    private By country_delete_names_row_button_xpath = By.xpath(".//*[@data-row_id='names']//button[@class='delete-element']");
    private By country_delete_holidays_row_button_xpath = By.xpath(".//*[@data-row_id='holidays']//button[@class='delete-element']");
    private By country_delete_Iban_new_row_button_xpath = By.xpath(".//*[@class='new'][@data-row_id='ibans']//button[@class='delete-element']");
    private By country_delete_routingCode_new_row_button_xpath = By.xpath(".//*[@class='new'][@data-row_id='codeTypes']//button[@class='delete-element']");
    private By country_delete_confirmation_modal_xpath = By.xpath("//*[@colspan='10']");
    private By country_delete_no_button_id = By.id("no-button");
    private By country_delete_yes_button_id = By.id("yes-button");
    private By country_additional_name_row_id = By.xpath("//*[@id='additionalNames']/tr[@class='new']");
    private By country_additional_identifiers_row_id = By.xpath("//*[@id='additionalIdentifiers']/tr");
    private By country_time_zone_summary_err_msg_xpath = By.xpath("//*[@data-error_id='timeZonesSummaryError']");
    private By country_time_zone_summary_input_xpath = By.xpath("//*[@data-edit_id='timeZonesSummary']");
    private By country_add_new_time_zone_button_id = By.id("add-timeZones");
    private By country_time_zone_list_box_xpath = By.xpath("//*[@name='utc3']");
    private By country_time_zone_list_xpath = By.xpath("//*[@name='utc3']/option");
    private By country_additional_time_zone_row_id = By.xpath("//*[@id='additionalTimeZones']/tr");
    private By country_add_new_holiday_button_id = By.id("add-holidays");
    private By country_holiday_day_xpath = By.xpath("//*[@id='additionalHolidays']/tr[1]/td[1]/fieldset/input[1]");
    private By country_holiday_month_xpath = By.xpath("//*[@id='additionalHolidays']/tr[1]/td[1]/fieldset/select");
    private By country_holiday_year_xpath = By.xpath("//*[@id='additionalHolidays']/tr[1]/td[1]/fieldset/input[2]");
    private By country_holiday_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayDateError']");
    private By country_holiday_description_box_xpath = By.xpath("//*[@id='additionalHolidays']/tr[1]/td[2]/input");
    private By country_holiday_note_box_xpath = By.xpath("//*[@id='additionalHolidays']/tr[1]/td[3]/input");
    private By country_holiday_description_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayNameError']");
    private By country_holiday_notes_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayNoteError']");
    private By country_new_holiday_row_xpath = By.xpath("//*[@id='additionalHolidays']/tr");
    private By country_language_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='languagesError']");

    private By country_payments_link_id = By.id("countryPayments");
    private By country_payments_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//span");
    private By country_payments_iban_label_xpath = By.xpath("//li[contains(h2,'IBAN')]//h2[1]");
    private By country_payments_status_label_xpath = By.xpath(".//*[@id='countryPayments']/dl/dt");
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
    private By country_places_link_id = By.id("countryPlaces");
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
    private By country_people_link_id = By.id("countryPeople");
    private By currency_country_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private String selectedCountry = "";
    private By country_listBox_xpath = By.xpath("//*[@id='selection0'] //*[@id='entitySelect_chosen']//span");
    private By country_edit_names_type_list_xpath = By.xpath("//*[@data-internal_id='nameType']");
    private By country_edit_identifier_type_list_xpath = By.xpath("//*[@id='additionalIdentifiers']//select");
    private By country_name_type_list_xpath = By.xpath("//*[@id='additionalNames']/tr[2]/td[1]/select/option");
    private By country_identifier_type_list_xpath = By.xpath("//*[@id='additionalIdentifiers']//*[@class=\"new\"]//select/option");

    private By country_add_new_name_button_id = By.id("add-names");
    private By country_add_new_identifier_button_id = By.id("add-identifiers");
    private By country_language_link_id = By.id("countryLanguages");

    private By countryBasicInfo_bankingHours_add_button_id = By.id("add-businessHours");
    private By countryBasicInfo_bankingHours_day_dropdown_xpath = By.xpath(".//*[@class='new'][@data-row_id='businessHours']//select[@name='bankingDay']");
    private By countryBasicInfo_bankingHours_day_dropdown_values_xpath = By.xpath(".//*[@class='new'][@data-row_id='businessHours']//select[@name='bankingDay']/option");
    private By countryBasicInfo_bankingHours_existing_day_dropdown_values_xpath = By.xpath(".//*[@data-row_id='businessHours']//select[@name='bankingDay']/option[@selected='selected']");
    private By countryBasicInfo_bankingHours_startHour_dropdown_xpath = By.xpath(".//*[@class='new'][@data-row_id='businessHours']//select[@name='bankingHour0']/option");
    private By countryBasicInfo_bankingHours_endHour_dropdown_xpath = By.xpath(".//*[@class='new'][@data-row_id='businessHours']//select[@name='bankingHour1']/option");
    private By countryBasicInfo_bankingHours_delete_button_xpath = By.xpath(".//*[@class='new'][@data-row_id='businessHours']//button[@class='delete-element']");

    private By language_summary_textarea_xpath = By.xpath("//*[@data-edit_id='languages']");

    private By country_identifier_value_err_msg_xpath = By.xpath(".//*[@class=\"notification error\"][@data-error_id='identifierValueError']");
    private By country_identifier_type_required_err_msg_xpath = By.xpath(".//*[@class=\"notification error\"][@data-error_id='identifierTypeError']");
    private By country_identifier_type_input_xpath = By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']");
    private By country_identifier_value_input_xpath = By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']");

    private By getCountry_basic_info_identifier_default_status = By.xpath("//*[@class='new']//fieldset//input[@value='active']");

    private String basic_info_label_value_xpath = ".//*[@id='content']//table[@class='vertical']/tbody/tr[th='";

    private By country_basic_info_startDate_day_edit_xpath = By.xpath("//input[@name='startDate-day']");
    String country_basic_info_startDate_month_edit_xpath = "//select[@name='startDate-month']";
    private By country_basic_info_startDate_year_edit_xpath = By.xpath("//input[@name='startDate-year']");

    private By country_basic_info_endDate_day_edit_xpath = By.xpath("//input[@name='endDate-day']");
    String country_basic_info_endDate_month_edit_xpath = "//select[@name='endDate-month']";
    private By country_basic_info_endDate_year_edit_xpath = By.xpath("//input[@name='endDate-year']");

    private By country_addInfo_error_message_edit_xpath = By.xpath("//*[@data-error_id='addInfoError']");
    private By country_imports_error_message_edit_xpath = By.xpath("//*[@data-error_id='primaryImportsError']");
    private By country_exports_error_message_edit_xpath = By.xpath("//*[@data-error_id='primaryExportsError']");
    private By country_political_structure_error_message_edit_xpath = By.xpath("//*[@data-error_id='politicalStructureError']");
    private By country_intlDialingCode_error_message_edit_xpath = By.xpath("//*[@data-error_id='telephoneCodeError']");
    private By country_replacedBy_edit_xpath = By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li");
    private By country_credit_rating_appliedYear_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[4]/fieldset/input[2]");
    private By country_credit_rating_applied_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='creditRatingAppliedDateError']");
    private By country_credit_rating_confirmed_date_xpath = By.xpath(".//*[@data-internal_id='creditRatingConfirmedDate']//input[@name='creditRatingConfirmedDate-year']");
    private By country_credit_rating_confirmed_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='creditRatingConfirmedDateError']");
    private By country_credit_rating_addRow_id = By.id("add-creditRatings");
    private By country_credit_rating_delete_button_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[@class='new']/td[6]/button");
    private int rowCount;
    private By country_credit_rating_value_xpath = By.xpath("//*[@id='additionalCreditRatings']/tr[1]/td[3]/input");
    private By country_credit_rating_agency_xpath = By.xpath("//*[@id='additionalCreditRatings']/tr[1]/td[1]/select");
    private By country_credit_rating_type_xpath = By.xpath("//*[@id='additionalCreditRatings']/tr[1]/td[2]/select");
    private By country_credit_value_error_msg_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[3]/p");
    private By country_credit_rating_applied_date_month_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[4]/fieldset/select");
    private By country_credit_rating_confirmed_year_month_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[5]/fieldset/select");
    private By country_credit_rating_applied_date_day_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[4]/fieldset/input[1]");
    private By country_credit_rating_confirmed_date_day_xpath = By.xpath(".//*[@id='additionalCreditRatings']/tr[1]/td[5]/fieldset/input[1]");
    private By country_edit_fields_xpath = By.xpath("//*[@id='content'] //*[@type='text']");
    private By country_iban_registered_day_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[1]/fieldset/input[1]");
    private By country_iban_registered_year_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[1]/fieldset/input[2]");
    private By country_iban_registered_month_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[1]/fieldset/select");
    private By country_iban_date_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='ibanRegisteredDateError']");
    private By country_payments_iban_routing_code_types_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[3]/select");
    private By country_payments_iban_routing_code_types_list_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[3]/select/option");
    private By country_payments_routing_code_types_xpath = By.xpath("//*[@id='additionalCodeTypes']/tr[1]/td[1]/select");
    private By country_payments_routing_code_types_list_xpath = By.xpath("//*[@id='additionalCodeTypes']/tr[1]/td[1]/select/option");
    private By country_payments_country_iso2_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[2]/select");
    private By country_payments_country_iso2_list_xpath = By.xpath("//*[@id='additionalIbans']/tr[1]/td[2]/select/option");
    private By country_payments_iban_row_country_iso2_xpath = By.xpath("//*[@id='additionalIbans']/tr/td[2]/select/option[@selected='selected']");
    private By country_payments_iban_row_registered_day_xpath = By.xpath("//*[@name='ibanRegisteredDate-day']");
    private By country_payments_iban_row_registered_month_xpath = By.xpath("//*[@name='ibanRegisteredDate-month']/option[@selected='selected']");
    private By country_payments_iban_row_registered_year_xpath = By.xpath("//*[@name='ibanRegisteredDate-year']");
    private By country_payments_iban_row_routing_code_type_xpath = By.xpath("//*[@id='additionalIbans']/tr/td[3]/select/option[@selected='selected']");
    private By country_payments_routing_codes_row_xpath = By.xpath("//*[@id='additionalCodeTypes']/tr/td[1]/select/option[@selected='selected']");
    private By country_payments_status_check_box_xpath = By.xpath("//*[@data-edit_id='ibanStatus']/input[@checked='']");
    private By country_payments_iban_add_new_button_id = By.id("add-ibans");
    private By country_payments_routing_code_add_new_button_id = By.id("add-codeTypes");
    private By country_payments_new_iban_row_xpath = By.xpath("//*[@id='additionalIbans']/tr[@class='new']");
    private By country_payments_new_routing_code_row_xpath = By.xpath("//*[@id='additionalCodeTypes']/tr[@class='new']");
    private By countryBasicInfo_Add_demographics_button_edit_id = By.id("add-demographics");
    private By countryBasicInfo_Delete_demographics_button_edit_id = By.xpath(".//*[@class='new'][@data-row_id='demographics']//button[@class='delete-element']");
    private By countryBasicInfo_demographics_date_year_edit_xpath = By.xpath(".//*[@class='new'][@data-row_id='demographics']//input[@name='demographicDate-year']");
    private By countryBasicInfo_demographics_date_day_edit_xpath = By.xpath(".//*[@class='new'][@data-row_id='demographics']//input[@name='demographicDate-day']");
    private By countryBasicInfo_demographics_date_month_edit_xpath = By.xpath(".//*[@class='new'][@data-row_id='demographics']//select[@name='demographicDate-month']");
    String countryBasicInfo_demographics_type_dropdown_edit_xpath = ".//tr[@class='new'][@data-row_id='demographics']/td/select[@data-internal_id='demographicType']";
    String countryBasicInfo_demographics_unit_dropdown_edit_xpath = ".//*[@class='new']//select[@id='demographicUnit']";
    private By countryBasicInfo_demographics_value_edit_xpath = By.xpath(".//*[@class='new'][@data-row_id='demographics']//input[@data-internal_id='demographicValue']");
    private By countryBasicInfo_demographics_date_error_message_xpath = By.xpath("//*[@class='notification error'][@data-error_id='demographicDateError']");
    private By countryBasicInfo_demographics_type_error_message_xpath = By.xpath(".//*[@class='notification error'][@data-error_id='demographicTypeError']");
    private By countryBasicInfo_demographics_value_error_message_xpath = By.xpath(".//*[@class='notification error'][@data-error_id='demographicValueError']");
    private By countryBasicInfo_holiday_date_error_message_xpath = By.xpath("//*[@class='notification error'][@data-error_id='holidayDateError']");

    private String editCountryDemographicType = "";
    private By country_credit_rating_new_row_xpath = By.xpath("//*[@class='new'][@data-row_id='creditRatings']");
    private By country_regions_existing_type_xpath = By.xpath(".//*[@id='additionalRegions']/tr[not(@class='new')]/td[1]");

    private By country_add_regions_button_edit_id = By.id("add-regions");
    private By country_add_places_button_edit_id = By.id("add-relatedPlaces");

    private By country_sepaRegion_value_xpath = By.xpath(".//*[@id='additionalRegions']//fieldset");
    private By country_region_type_error_message_xpath = By.xpath(".//*[@class='notification error'][@data-error_id='regionTypeError']");
    private By country_region_value_error_message_xpath = By.xpath(".//*[@class='notification error'][@data-error_id='regionValueError']");
    private By country_region_delete_button_xpath = By.xpath(".//*[@class='new'][@data-row_id='regions']//button[@class='delete-element']");
    String country_regions_new_type_xpath = ".//*[@id='additionalRegions']/tr[@class='new']/td[1]/select";
    String country_trading_region_value_dropdown_xpath = ".//*[@id='additionalRegions']//select[@data-error_id='tradingRegionValue']";
    String country_region_value_dropdown_xpath = ".//*[@id='additionalRegions']//select[@data-error_id='regionValue']";
    private By country_banking_hrs_day_list_xpath = By.xpath("//*[@class='new'] //*[@id='bankingDay-select']");
    private By country_banking_hrs_start_time_list_xpath = By.xpath("//*[@class='new'] //*[@data-error_ref_id='bankingHour0Error']");
    private By country_banking_hrs_end_time_list_xpath = By.xpath("//*[@class='new'] //*[@data-error_ref_id='bankingHour1Error']");
    private By country_banking_hours_row_delete_button_xpath = By.xpath(".//*[@id='additionalBusinessHours']//button[@class='delete-element']");
    private By country_banking_hours_delete_row_confirmation_modal_xpath = By.xpath("//*[@colspan='10']");
    private By country_bankingHours_rows_xpath= By.xpath(".//*[@id='countryBasicInfo']//*[@data-row-id='businessHours']");
    private By country_places_go_button_xpath = By.xpath(".//*[@id='multiSelectRow']/button");
    private By country_places_required_error_message_xpath = By.xpath(".//*[@class='notification error'][@data-error_id='relatedPlacePlaceError']");
    private By country_places_delete_button_xpath = By.xpath(".//*[@class='new'][@data-row_id='relatedPlaces']//button[@class='delete-element']");
    private By country_places_place_edit_xpath = By.xpath(".//*[@class='new']/td/input[@id='relatedPlacePlace']");
    private By country_places_place_edit_button_xpath = By.xpath(".//tr[@class='new']//button[@class='edit-row']");
    private By country_places_existing_place_edit_button_xpath = By.xpath(".//tr//button[@class='edit-row']");
    String country_places_type_dropdown_xpath = ".//*[@class='new'][@data-row_id='relatedPlaces']//select[@id='relatedPlaceType']";
    String country_places_details_dropdown_xpath = ".//*[@class='new'][@data-row_id='relatedPlaces']//select[@data-internal_id='relatedPlaceDetails']";
    String country_places_country_dropDown_xpath = ".//*[@id='country_chosen']";
    String country_places_area_dropdown_xpath = ".//*[@id='area_chosen']";
    String country_places_city_dropdown_xpath = ".//*[@id='city_chosen']";
    private By country_hera_validation_err_msg_xpath = By.xpath("//*[@id='error']//p[@class='notification error']");
    private By country_places_details_Select_dropdown_xpath = By.xpath("//*[@id='additionalRelatedPlaces']/tr[@class='new']/td[4]/select");
    String country_relatedentity_list_table_xpath = "//*[@id='countryPresences']//tr[td='";

    private String editedCountryBankingHrsDay = "";
    private String editedCountryBankingHrsStartTime = "";
    private String editedCountryBankingHrsEndTime = "";
    private String editedCountryHolidayDay = "";
    private String editedCountryHolidayMonth = "";
    private String editedCountryHolidayYear = "";
    private String editedCountryHolidayDescription = "";
    private String editedCountryHolidayNotes = "";
    private String editedCountryStartYear = "";
    private String editedCountryEndYear = "";
    private String countryPlacesCountry = "";
    private String countryPlacesArea = "";


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
        assertTrue(getDriver().findElement(country_currencies_label_xpath).getText().matches("^CURRENCIES FOR " + selectedCountry.toUpperCase() + ".*$"));
        assertEquals("ISO NAME START DATE END DATE PRIMARY REPLACED BY STATUS", getDriver().findElement(country_currencies_table_headings_xpath).getText());
        List<WebElement> iso = getDriver().findElements(country_currencies_iso_xpath);
        List<WebElement> name = getDriver().findElements(country_currencies_name_xpath);
        List<WebElement> startDate = getDriver().findElements(country_currencies_start_date_xpath);
        List<WebElement> endDate = getDriver().findElements(country_currencies_end_date_xpath);
        List<WebElement> primary = getDriver().findElements(country_currencies_primary_xpath);
        List<WebElement> replacedBy = getDriver().findElements(country_currencies_replaced_by_xpath);
        List<WebElement> status = getDriver().findElements(country_currencies_status_xpath);

        for (int i = 0; i < countryCurrencies.getRowCount(); i++) {
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(0)), iso.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(1)), name.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(2)), startDate.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(3)), endDate.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(4)), primary.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(5)), replacedBy.get(i).getText());
            assertEquals(countryCurrencies.getRow(i).get(countryCurrencies.getHeaders().get(6)), status.get(i).getText());
        }
    }

    public void verifyCountryList() {
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
        for (int i = 0; i <= countryList.getRowCount() - 1; i++) {
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

    public void verifyViewCountryBasicInfoFromTrusted() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", DataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "country basic info", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("country").getLength(); i++) {
            assertEquals(document.getElementsByTagName("ISO2").item(i).getTextContent(), getDriver().findElement(country_iso2_id).getText());
            assertEquals(document.getElementsByTagName("ISO3").item(i).getTextContent(), getDriver().findElement(country_iso3_id).getText());
            assertEquals(document.getElementsByTagName("Status").item(i).getTextContent().toLowerCase(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Status']/td")).getText().toLowerCase());
            assertEquals(document.getElementsByTagName("BeginDate").item(i).getTextContent().replace(" ", ""), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Start Date']/td")).getText().replace(" ", ""));
            assertEquals(document.getElementsByTagName("EndDate").item(i).getTextContent().replace(" ", ""), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "End Date']/td")).getText().replace(" ", ""));
            assertEquals(document.getElementsByTagName("ReplacedBy").item(i).getTextContent().replace(" ", ""), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText().replace(" ", "").replace(",", ""));
            assertEquals(document.getElementsByTagName("AddInfo").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td")).getText().replace(" ", ""));

            assertEquals(document.getElementsByTagName("DomesticWith").item(0).getTextContent().replace(" ", ""), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Domestic with']/td")).getText().replace(",", "").replace(" ", ""));
            assertEquals(document.getElementsByTagName("Imports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td")).getText());
            assertEquals(document.getElementsByTagName("Exports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td")).getText());
            assertEquals(document.getElementsByTagName("PoliticalStructure").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td")).getText());
            assertEquals(document.getElementsByTagName("IntlDialingCode").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td")).getText().replace("+", ""));
        }
    }

    public void verifyEditCountryBasicInfoFromTrusted() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", DataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "country basic info", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("country").getLength(); i++) {
            assertEquals(document.getElementsByTagName("ISO2").item(i).getTextContent(), getDriver().findElement(country_iso2_id).getText());
            assertEquals(document.getElementsByTagName("ISO3").item(i).getTextContent(), getDriver().findElement(country_iso3_id).getText());
            assertEquals(document.getElementsByTagName("Status").item(i).getTextContent().toLowerCase(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Status']/td")).getText().toLowerCase());
            assertEquals(document.getElementsByTagName("BeginDate").item(i).getTextContent().replace(" ", "").replaceFirst("^0+(?!$)", ""), getDriver().findElement(country_basic_info_startDate_day_edit_xpath).getAttribute("value") + getDriver().findElement(By.xpath(country_basic_info_startDate_month_edit_xpath + "/option[@selected='selected']")).getText().replace(" ", "") + getDriver().findElement(country_basic_info_startDate_year_edit_xpath).getAttribute("value").replace(" ", ""));
            assertEquals(document.getElementsByTagName("EndDate").item(i).getTextContent().replace(" ", "").replaceFirst("^0+(?!$)", ""), getDriver().findElement(country_basic_info_endDate_day_edit_xpath).getAttribute("value") + getDriver().findElement(By.xpath(country_basic_info_endDate_month_edit_xpath + "/option[@selected='selected']")).getText().replace(" ", "") + getDriver().findElement(country_basic_info_endDate_year_edit_xpath).getAttribute("value").replace(" ", ""));

            assertEquals(document.getElementsByTagName("ReplacedBy").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText());
            assertEquals(document.getElementsByTagName("AddInfo").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td")).getText());
            assertEquals(document.getElementsByTagName("Imports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td")).getText());
            assertEquals(document.getElementsByTagName("Exports").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td")).getText());
            assertEquals(document.getElementsByTagName("PoliticalStructure").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td")).getText());
            assertEquals(document.getElementsByTagName("IntlDialingCode").item(i).getTextContent(), getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td/input")).getAttribute("value"));

        }
    }


    public void verifyEditCountryBasicInfoInZeus(String selectedCountry) {
        selectedCountry = DataPage.selectedEntity;
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCountry));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "country basic info", nvPairs);
        assertEquals(editedCountryStartYear, document.getElementsByTagName("BeginDate").item(0).getTextContent());
        assertEquals(editedCountryEndYear, document.getElementsByTagName("EndDate").item(0).getTextContent());
    }

    public void verifyEditCountryHolidaysInZeus(String selectedCountry) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCountry));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country holidays", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("holiday").getLength(); i++) {
            assertEquals(editedCountryHolidayDay + " " + editedCountryHolidayMonth + " " + editedCountryHolidayYear, document.getElementsByTagName("date").item(i).getTextContent());
            assertEquals(editedCountryHolidayDescription, document.getElementsByTagName("name").item(i).getTextContent());
            assertEquals(editedCountryHolidayNotes, document.getElementsByTagName("note").item(i).getTextContent());
        }
    }

    public void clicksOnReplacedByDropdown() {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).click();
    }

    public void verifyReplacedByDropdownList() {
        List<WebElement> replacedBy = getDriver().findElements(By.xpath(basic_info_label_value_xpath + "Replaced By']/td//div[@class='chosen-drop']//li"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
        List<String> countryList = new ArrayList<>();
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            countryList.add(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent());
        }
        countryList.remove(DataPage.selectedEntity);
        for (int i = 0; i < replacedBy.size(); i++) {
            assertEquals(countryList.get(i).trim(), replacedBy.get(i).getText().trim());
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
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).sendKeys(String.valueOf(year + 2));

    }

    public void enterCountryStartYear(String countryStartYear) {
        editedCountryStartYear = countryStartYear;
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_startDate_year_edit_xpath).sendKeys(countryStartYear);
    }

    public void enterCountryEndYear(String countryEndYear) {
        editedCountryEndYear = countryEndYear;
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).clear();
        getDriver().findElement(country_basic_info_endDate_year_edit_xpath).sendKeys(countryEndYear);
    }

    public void enterCountryReplacedBy(String countryReplacedBy) {
        getDriver().findElement(country_replacedBy_edit_xpath).click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li/input")).sendKeys(countryReplacedBy);
        getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[1]/ul/li[2]/fieldset/table/tbody/tr[4]/td/div/ul/li/input")).sendKeys(Keys.RETURN);

    }

    public void enterCountryAddInfo(String countryAddInfo) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).sendKeys(countryAddInfo);
    }

    public void enterCountryImports(String countryImports) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td/textarea")).sendKeys(countryImports);
    }

    public void enterCountryExports(String countryExports) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td/textarea")).sendKeys(countryExports);
    }

    public void enterCountryPoliticalStructure(String countryPoliticalStructure) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td/textarea")).sendKeys(countryPoliticalStructure);
    }

    public void enterCountryIntlDialingCode(String countryIntlDialingCode) {
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td/input")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td/input")).sendKeys(countryIntlDialingCode);
    }


    public void enterInvalidCharactersInCountryAddInfo() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 500; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Add Info']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryImports() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 200; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Imports']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryExports() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 200; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Exports']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryPoliticalStructure() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 200; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td/textarea")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Political Structure']/td/textarea")).sendKeys(invalidData);
    }

    public void enterInvalidCharactersInCountryIntlDialingCode() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 5; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td/input")).clear();
        getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Intl Dialing Code']/td/input")).sendKeys(invalidData);
    }

    public void verifyErrorMessageForAddInfo() {
        assertEquals(getDriver().findElement(country_addInfo_error_message_edit_xpath).getText(), "Enter up to 500 valid characters.");
    }

    public void verifyErrorMessageForImports() {
        assertEquals(getDriver().findElement(country_imports_error_message_edit_xpath).getText(), "Enter up to 200 valid characters.");
    }

    public void verifyErrorMessageForExports() {
        assertEquals(getDriver().findElement(country_exports_error_message_edit_xpath).getText(), "Enter up to 200 valid characters.");
    }

    public void verifyErrorMessageForPoliticalStructure() {
        assertEquals(getDriver().findElement(country_political_structure_error_message_edit_xpath).getText(), "Enter up to 200 valid characters.");
    }

    public void verifyErrorMessageForIntlDialingCode() {
        assertEquals(getDriver().findElement(country_intlDialingCode_error_message_edit_xpath).getText(), "Enter up to 5 valid characters.");
    }

    public void verifyISO2NotEditable() {
        try {
            getDriver().findElement(country_iso2_id).getAttribute("data-edit_id").toString();
        } catch (Exception e) {
            assertTrue(e.toString().equals("java.lang.NullPointerException"));
        }
    }

    public void verifyISO3NotEditable() {
        try {
            getDriver().findElement(country_iso3_id).getAttribute("data-edit_id").toString();
        } catch (Exception e) {
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
        for (int i = 0; i < countryDemographics.getRowCount(); i++) {
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(0)), actCountryDemoTypes.get(i).getText());
            assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(1)), actCountryDemoValue.get(i).getText());
            if (countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(2)).isEmpty()) {
            } else {
                assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(2)), actCountryDemoUnit.get(i).getText());
            }
            if (countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(3)).isEmpty()) {
            } else {
                assertEquals(countryDemographics.getRow(i).get(countryDemographics.getHeaders().get(3)), actCountryDemoDate.get(i).getText());
            }
        }
    }

    public void verifyCountryBankingHourSummary(String countryBankingHourSummary) {
        assertEquals("Summary", getDriver().findElement(country_banking_hr_summary_label_xpath).getText());
        assertEquals(countryBankingHourSummary, getDriver().findElement(country_banking_hr_summary_xpath).getText());
    }

    public void verifyCountryBankingHourInTrusted() {
        assertEquals("BANKING HOURS", getDriver().findElement(country_banking_hrs_label_xpath).getText());
        assertEquals("DAY", getDriver().findElement(country_banking_hrs_day_label_xpath).getText());
        assertEquals("HOURS", getDriver().findElement(country_banking_hrs_hrs_label_xpath).getText());

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", dataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country banking hrs", nvPairs);

        List<WebElement> actCountryBankingHrsDay = getDriver().findElements(country_banking_hrs_day_xpath);
        List<WebElement> actCountryBankingHrsHours = getDriver().findElements(country_banking_hrs_hrs_xpath);
        for (int i = 0; i < document.getElementsByTagName("day").getLength(); i++) {

            assertEquals(document.getElementsByTagName("name").item(i).getTextContent(), actCountryBankingHrsDay.get(i).getText());
            assertEquals(document.getElementsByTagName("startTime").item(i).getTextContent() + "-" + document.getElementsByTagName("endTime").item(i).getTextContent(), actCountryBankingHrsHours.get(i).getText());
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
        for (int i = 0; i < countryTimeZones.getRowCount(); i++) {
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(0)), actCountryTimeZone.get(i).getText());
            assertEquals(countryTimeZones.getRow(i).get(countryTimeZones.getHeaders().get(1)), actCountryTimeZoneValue.get(i).getText());
        }
    }

    public void verifyCountrySummary(ExamplesTable countrySummary) {
        List<WebElement> actCountrySummary = getDriver().findElements(country_summary_xpath);
        List<WebElement> actCountrySummaryValue = getDriver().findElements(country_summary_value_xpath);
        for (int i = 0; i < countrySummary.getRowCount(); i++) {
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
        for (int i = 0; i < countryHolidaysList.getRowCount(); i++) {
            assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(0)), dates.get(i).getText());
            if (countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(1)).isEmpty()) {
            } else {
                assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(1)), description.get(i).getText());
            }
            if (countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(2)).isEmpty()) {
            } else {
                assertEquals(countryHolidaysList.getRow(i).get(countryHolidaysList.getHeaders().get(2)), notes.get(i).getText());
            }
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
        verifyCountryIBANInfoLabels();
        List<WebElement> isoCode = getDriver().findElements(country_payments_iso_code_xpath);
        List<WebElement> registeredDate = getDriver().findElements(country_payments_registered_date_xpath);
        List<WebElement> ibanRoutingCode = getDriver().findElements(country_payments_code_type_xpath);
        for (int i = 0; i < countryPaymentsIban.getRowCount(); i++) {
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(0)), registeredDate.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(1)), isoCode.get(i).getText());
            assertEquals(countryPaymentsIban.getRow(i).get(countryPaymentsIban.getHeaders().get(2)), ibanRoutingCode.get(i).getText());
        }
    }

    public void verifyCountryPaymentsRoutingCodesTypes(ExamplesTable countryPaymentsRoutingCodesTypes) {
        verifyCountryRoutingCodesLabels();
        List<WebElement> types = getDriver().findElements(country_payments_routing_code_code_types_xpath);
        for (int i = 0; i < countryPaymentsRoutingCodesTypes.getRowCount(); i++) {
            assertEquals(countryPaymentsRoutingCodesTypes.getRow(i).get(countryPaymentsRoutingCodesTypes.getHeaders().get(0)), types.get(i).getText());
        }
    }

    public void verifyCountryNoIbanInfo() {
        verifyCountryIBANInfoLabels();
        try {
            assertFalse(getDriver().findElement(country_payments_status_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }

    }

    public void verifyCountryIBANInfoLabels() {
        assertEquals("PAYMENTS FOR " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_payments_label_xpath).getText());
        assertEquals("IBAN", getDriver().findElement(country_payments_iban_label_xpath).getText());
        assertEquals("Status", getDriver().findElement(country_payments_status_label_xpath).getText());
        assertEquals("ISO CODE", getDriver().findElement(country_payments_iso_code_label_xpath).getText());
        assertEquals("REGISTERED DATE", getDriver().findElement(country_payments_registered_date_label_xpath).getText());
        assertEquals("IBAN ROUTING CODE TYPE", getDriver().findElement(country_payments_code_type_label_xpath).getText());
    }

    public void verifyCountryRoutingCodesLabels() {
        assertEquals("ROUTING CODE TYPES IN " + dataPage.selectedEntity.toUpperCase(), getDriver().findElement(country_payments_routing_code_label_xpath).getText());
        assertEquals("TYPES", getDriver().findElement(country_payments_routing_codes_types_label_xpath).getText());
    }

    public void verifyCountryNoRoutingCodeTypes() {
        verifyCountryRoutingCodesLabels();
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
        } catch (org.openqa.selenium.NoSuchElementException e) {

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

    public void verifyRelatedEntitiesFromTrusted(String countryname, String source) {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", countryname));
        nvPairs.add(new BasicNameValuePair("source", source));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country related entities", nvPairs);
        List legalTitles = getNodeValuesByTagName(document, "legalTitle");
        List types = getNodeValuesByTagName(document, "type");
        List details = getNodeValuesByTagName(document, "details");
        String detail = "";
        for (int i = 0; i < legalTitles.size(); i++) {
            String legalTitle = legalTitles.get(i).toString();
            String type = types.get(i).toString();
            if (details.size() != 0) {
                detail = details.get(i).toString();
            }
            assertTrue(getDriver().findElement(By.xpath(country_relatedentity_list_table_xpath + type + "']/td[2]")).getText().equals(legalTitle));
            assertTrue(getDriver().findElement(By.xpath(country_relatedentity_list_table_xpath + type + "']/td[3]")).getText().replace(", ", "").equals(detail));
        }


    }

    public void clickOnCountryPeople() {
        attemptClick(country_people_link_id);
    }

    public void clickOnCountryCurrenciesLink() {
        attemptClick(country_currencies_link_id);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCountryNameType() {
        attemptClick(country_edit_names_type_list_xpath);
    }


    public void clickOnCountryIdentifierType() {
        attemptClick(country_edit_identifier_type_list_xpath);
    }

    public void verifyCountryPlacesTypeList() {
        List<WebElement> countryPlacesTypeList = getDriver().findElements(By.xpath(country_places_type_dropdown_xpath + "/option"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country places type");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryPlacesTypeList.get(i).getText());
        }
    }

    public void verifyCountryplacesDetailsList() {
        List<WebElement> countryPlacesDetailsList = getDriver().findElements(By.xpath(country_places_details_dropdown_xpath + "/option"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country places details");
        for (int i = 1; i < document.getElementsByTagName("detail").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryPlacesDetailsList.get(i).getText());
        }
    }

    public void verifyCountryNameTypesList() {
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
        try {
            List<WebElement> webElements = getDriver().findElements(country_identifier_value_input_xpath);
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.clear();
        } catch (Exception e) {
        }
    }

    public void clearCountryIdentifierType() {
        getDriver().findElement(country_identifier_type_input_xpath).clear();
    }

    public void enterIdentifierType(String identifierType) {
        try {

            List<WebElement> webElements = getDriver().findElements(country_identifier_type_input_xpath);
            int columns_count = webElements.size();

            WebElement mySelectElm = webElements.get(columns_count - 1);
            Select mySelect = new Select(mySelectElm);
            mySelect.selectByValue(identifierType);
        } catch (Exception e) {
        }
    }

    public void enterIdentifierValue(String identifierValue) {
        try {
            List<WebElement> webElements = getDriver().findElements(country_identifier_value_input_xpath);
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.sendKeys(identifierValue);
        } catch (Exception e) {

        }
    }

    public void verifyErrorMessageForCountryName() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_name_value_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredNameType() {
        assertEquals("Required", getDriver().findElement(country_names_type_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredIdentifierValue() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_identifier_value_err_msg_xpath).getText());
    }

    public void clickOnAddDemographicsButton() {
        attemptClick(countryBasicInfo_Add_demographics_button_edit_id);
    }

    public void clickOnAddRegionsButton() {
        attemptClick(country_add_regions_button_edit_id);
    }

    public void clickOnNewCountryPlaceTypeDropdown() {
        attemptClick(By.xpath(country_places_type_dropdown_xpath));
    }

    public void clickOnNewCountryPlaceDetatilsDropdown() {
        attemptClick(By.xpath(country_places_details_dropdown_xpath));
    }

    public void clickOnAddPlacesButton() {
        attemptClick(country_add_places_button_edit_id);
    }

    public void clickOnTradingRegionValuesDropdown() {
        attemptClick(By.xpath(country_trading_region_value_dropdown_xpath));
    }

    public void clickOnContinentRegionValuesDropdown() {
        attemptClick(By.xpath(country_region_value_dropdown_xpath));
    }

    public void verifyRequiredErrorMessageForType() {
        assertEquals(getDriver().findElement(country_places_required_error_message_xpath).getText(), "Required");
    }

    public void clicksOnCountryInPlacesForCountry() {
        attemptClick(By.xpath(country_places_country_dropDown_xpath + "//a"));
    }

    public void verifyCountryListInPlacesForCountry() {
        List<WebElement> countryList = getDriver().findElements(By.xpath(country_places_country_dropDown_xpath + "//li"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), countryList.get(i).getText().trim());
        }
    }

    public void verifyAreaListInPlacesForCountry() {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", countryPlacesCountry));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list", nvPairs);
        if (getDriver().findElements(By.xpath(country_places_area_dropdown_xpath + "//li")).size() > 2) {
            assertEquals(getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//li[1]")).getText(), "No Area");
            assertEquals(getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//li[2]")).getText(), "Return All Cities");
            for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
                assertEquals(document.getElementsByTagName("area").item(i).getTextContent(), getDriver().findElements(By.xpath(country_places_area_dropdown_xpath + "//li")).get(i + 2).getText());
            }
        } else {
            assertEquals(getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//li[1]")).getText(), "No Area");
            assertEquals(getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//li[2]")).getText(), "Return All Cities");
        }
    }

    public void verifyCityListInPlacesForCountry() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", countryPlacesArea));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("city").getLength(); i++) {
            assertEquals(document.getElementsByTagName("city").item(i).getTextContent(), getDriver().findElements(By.xpath(country_places_city_dropdown_xpath + "//li")).get(i).getText());
        }
    }

    public void clicksOnAreaDropdownInPlacesForCountry() {
        attemptClick(By.xpath(country_places_area_dropdown_xpath + "//a"));
    }

    public void clicksOnCityDropdownInPlacesForCountry() {
        attemptClick(By.xpath(country_places_city_dropdown_xpath + "//a"));
    }

    public void selectsCountryInPlacesForCountry(String countryPlaces) {
        countryPlacesCountry = countryPlaces;
        getDriver().findElement(By.xpath(country_places_country_dropDown_xpath + "//input")).sendKeys(countryPlaces);
        getDriver().findElement(By.xpath(country_places_country_dropDown_xpath + "//input")).sendKeys(Keys.RETURN);
    }

    public void selectsAreaInPlacesForCountry(String AreaPlaces) {
        countryPlacesArea = AreaPlaces;
        getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//input")).sendKeys(AreaPlaces);
        getDriver().findElement(By.xpath(country_places_area_dropdown_xpath + "//input")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectsCityInPlacesForCountry(String cityPlaces) {
        getDriver().findElement(By.xpath(country_places_city_dropdown_xpath + "//input")).sendKeys(cityPlaces);
        getDriver().findElement(By.xpath(country_places_city_dropdown_xpath + "//input")).sendKeys(Keys.RETURN);
        waitForElementToAppear(By.xpath("//*[@id='city_chosen']/a/span[text()='"+cityPlaces+"']"));
    }

    public void verifyPlaceInPlacesForCountry(String place) {
        assertEquals(getDriver().findElement(country_places_place_edit_xpath).getAttribute("value"), place);
    }

    public void clicksOnGoButton() {
        getDriver().findElement(country_places_go_button_xpath).click();
    }

    public void clicksOnEditButton() {
        attemptClick(country_places_place_edit_button_xpath);
    }

    public void clicksOnExistingEditPlacesButton() {
        attemptClick(country_places_existing_place_edit_button_xpath);
    }

    public void selectsPlacesTypeFromDropdwon(String placeType) {
        List<WebElement> options = getDriver().findElements(By.xpath(country_places_type_dropdown_xpath + "/option"));

        for (WebElement option : options) {
            if (option.getText().contains(placeType)) {

                getDriver().findElement(By.xpath(country_places_type_dropdown_xpath)).click();

                option.click();

                break;
            }
        }
    }

    public void selectsPlacesDetailsFromDropdown(String PlaceDetails) {
        selectItemFromDropdownListByText(country_places_details_Select_dropdown_xpath, PlaceDetails);
    }

    public void selectsRegionTypeFromDropdown(String regionType) {
        getDriver().findElement(By.xpath(country_regions_new_type_xpath)).click();
        List<WebElement> options = getDriver().findElements(By.xpath(country_regions_new_type_xpath + "/option"));

        for (WebElement option : options) {
            if (option.getText().contains(regionType)) {

                getDriver().findElement(By.xpath(country_regions_new_type_xpath)).click();

                option.click();

                break;
            }
        }
    }

    public void selectsRegionValueFromDropdown(String regionValue) {

        By regionDropDown = By.xpath(country_region_value_dropdown_xpath);
        selectItemFromDropdownListByValue(regionDropDown, regionValue);
    }

    public void verifyContinentRegionsValuesDropdown() {
        String regionType = "CONTINENT";
        List<WebElement> continentValues = getDriver().findElements(By.xpath(country_region_value_dropdown_xpath + "/option"));

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("regionType", regionType));

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get values for region type", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), continentValues.get(i).getText());
        }

    }

    public void verifySepaValues() {
        assertEquals(getDriver().findElement(country_sepaRegion_value_xpath).getText(), "true false");
    }


    public void verifyTradingRegionsValuesDropdown() {
        String regionType = "TRADING_REGION";
        List<WebElement> tradingRegionValues = getDriver().findElements(By.xpath(country_trading_region_value_dropdown_xpath + "/option"));

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("regionType", regionType));

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get values for region type", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), tradingRegionValues.get(i).getText());
        }
    }

    public void veirfyDemograhicsDateErrorMessage() {
        assertEquals(getDriver().findElement(countryBasicInfo_demographics_date_error_message_xpath).getText(), "Must be no later than today.");
    }

    public void verifyRequiredErrorMessageForTypeAndValue() {
        assertEquals(getDriver().findElement(countryBasicInfo_demographics_type_error_message_xpath).getText(), "Required");
        assertEquals(getDriver().findElement(countryBasicInfo_demographics_value_error_message_xpath).getText(), "Required");
    }

    public void verifyRequiredErrorMessageRegionType() {
        assertEquals(getDriver().findElement(country_region_type_error_message_xpath).getText(), "Required");

    }

    public void verifyRequiredErrorMessageRegionValue() {
        try {
            Thread.sleep(2000L);
            assertEquals(getDriver().findElement(country_region_value_error_message_xpath).getText(), "Required");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void entersDemographicDateLaterThanToday() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        getDriver().findElement(countryBasicInfo_demographics_date_year_edit_xpath).clear();
        getDriver().findElement(countryBasicInfo_demographics_date_year_edit_xpath).sendKeys(String.valueOf(year + 3));
    }

    public void clickOnDeleteCountryDemographicsOption() {
        attemptClick(countryBasicInfo_Delete_demographics_button_edit_id);
    }
/*
    public void clicksOnDemographicsTypeDropdown() {
        attemptClick(By.xpath(countryBasicInfo_demographics_type_dropdown_edit_xpath));
    }*/

    public void selectsDemographicsTypesFromDropdown(String demographicType) {
        editCountryDemographicType = demographicType;
        attemptClick(By.xpath(countryBasicInfo_demographics_type_dropdown_edit_xpath));
        List<WebElement> options = getDriver().findElements(By.xpath(countryBasicInfo_demographics_type_dropdown_edit_xpath + "/option"));

        for (WebElement option : options) {
            if (option.getText().contains(demographicType)) {

                getDriver().findElement(By.xpath(countryBasicInfo_demographics_type_dropdown_edit_xpath)).click();

                option.click();

                break;
            }
        }
    }

    public void entersDemographicsValue(String demographicValue) {
        getDriver().findElement(countryBasicInfo_demographics_value_edit_xpath).sendKeys(demographicValue);
    }

    public void entersDemographicsDay(String day) {
        getDriver().findElement(countryBasicInfo_demographics_date_day_edit_xpath).sendKeys(day);
    }

    public void entersDemographicMonth(String month) {
        selectItemFromDropdownListByText(countryBasicInfo_demographics_date_month_edit_xpath, month);
    }

    public void entersDemographicYear(String year) {
        getDriver().findElement(countryBasicInfo_demographics_date_year_edit_xpath).sendKeys(year);
    }

    public void verifyCountryDemographicsUnitDropdownNotExist() {
        try {
            getDriver().findElement(By.xpath(countryBasicInfo_demographics_unit_dropdown_edit_xpath)).toString();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }
    }

    public void clickOnTimeZoneDeleteNewRowButton() {
        attemptClick(country_delete_timeZone_new_row_button_xpath);
    }

    public void clickOnIdentifierDeleteNewRowButton() {
        attemptClick(country_delete_identifiers_row_button_xpath);
    }

    public void clickOnNameDeleteRowButton() {
        attemptClick(country_delete_names_row_button_xpath);
    }

    public void clickOnIbanDeleteNewRowButton() {
        attemptClick(country_delete_Iban_new_row_button_xpath);
    }

    public void clickOnRoutingCodeDeleteNewRowButton() {
        attemptClick(country_delete_routingCode_new_row_button_xpath);
    }

    public void verifyCountryDemographicsDropdownExist() {
        assertTrue(getDriver().findElement(By.xpath(countryBasicInfo_demographics_unit_dropdown_edit_xpath)).isDisplayed());
    }

    public void clickOnHolidayDeleteRowButton() {
        attemptClick(country_delete_holidays_row_button_xpath);
    }

    public void verifyCountryDemographicsTypeDropdownList() {

        List<WebElement> countryDemographicsList = getDriver().findElements(By.xpath(countryBasicInfo_demographics_type_dropdown_edit_xpath + "/option"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country demographics type");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryDemographicsList.get(i).getText());
        }

    }

    public void verifyCountryRegionsTypeDropdownList() {

        String existingType = getDriver().findElement(country_regions_existing_type_xpath).getText();
        attemptClick(By.xpath(country_regions_new_type_xpath));
        List<WebElement> newRegionsType = getDriver().findElements(By.xpath(country_regions_new_type_xpath + "/option"));
        List<String> alternateRegions = new ArrayList<>();

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country regions type");
        for (int i = 0; i < document.getElementsByTagName("type").getLength(); i++) {
            alternateRegions.add(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent());
        }
        alternateRegions.remove(existingType);
        for (int i = 0; i < alternateRegions.size(); i++) {
            assertEquals(alternateRegions.get(i).trim(), newRegionsType.get(i + 1).getText().trim());
        }
    }


    public void verifyCountryDemographicsUnitDropdownList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("unit", editCountryDemographicType.toLowerCase()));
        attemptClick(By.xpath(countryBasicInfo_demographics_unit_dropdown_edit_xpath));
        List<WebElement> demographicsUnit = getDriver().findElements(By.xpath(countryBasicInfo_demographics_unit_dropdown_edit_xpath + "/option"));


        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country demographics unit", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("unit").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), demographicsUnit.get(i + 1).getText());
        }
    }

    public void verifyErrorMessageForLongIdentifierValue() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_identifier_value_err_msg_xpath).getText());
    }


    public void verifyErrorMessageForRequiredIdentifierType() {
        assertEquals("Required", getDriver().findElement(country_identifier_type_required_err_msg_xpath).getText());
    }

    public void verifyErrorMessageForRequiredValueType() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(country_names_value_required_err_msg_xpath).getText());
    }

    public void verifyNewlyAddedNameRowIsDisplayed() {
        assertTrue(getDriver().findElement(country_additional_name_row_id).isDisplayed());
    }

    public void verifyNewlyAddedNameRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(country_additional_name_row_id).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(country_additional_identifiers_row_id).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyNewlyAddedIdentifierRowIsDisplayed() {
        try {
            assertTrue(getDriver().findElement(country_additional_identifiers_row_id).isDisplayed());
        } catch (NoSuchElementException e) {
        }
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
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void enterCountryHolidayDay(String day) {
        editedCountryHolidayDay = day;
        getDriver().findElement(country_holiday_day_xpath).clear();
        getDriver().findElement(country_holiday_day_xpath).sendKeys(day);
    }

    public void enterCountryHolidayMonth(String month) {
        editedCountryHolidayMonth = month;
        selectItemFromDropdownListByText((country_holiday_month_xpath), month);
    }

    public void enterCountryHolidayYear(String year) {
        editedCountryHolidayYear = year;
        getDriver().findElement(country_holiday_year_xpath).clear();
        getDriver().findElement(country_holiday_year_xpath).sendKeys(year);
    }

    public void verifyErrorMsgForCountryDemographicsDate() {
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(countryBasicInfo_demographics_date_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCountryHolidayDate() {
        assertEquals("Enter a day/month/year.", getDriver().findElement(countryBasicInfo_holiday_date_error_message_xpath).getText());
    }

    public void clickOnAddNewCountryHolidayButton() {
        attemptClick(country_add_new_holiday_button_id);
    }

    public void verifyErrorMsgRequiredForCountryHolidayDate() {
        assertEquals("Required", getDriver().findElement(country_holiday_date_error_msg_xpath).getText());
    }

    public void enterCountryHolidayDescription(String description) {
        editedCountryHolidayDescription = description;
        getDriver().findElement(country_holiday_description_box_xpath).clear();
        getDriver().findElement(country_holiday_description_box_xpath).sendKeys(description);
    }

    public void enterCountryHolidayNotes(String notes) {
        editedCountryHolidayNotes = notes;
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

    public void enterSummaryLanguage(String countryLanguages) {
        getDriver().findElement(language_summary_textarea_xpath).sendKeys(countryLanguages);
    }

    public void verifyErrorMsgForCountryLanguage() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(country_language_err_msg_xpath).getText());
    }

    public void userClicksOnTheAddCountryBankingHours() {
        attemptClick(countryBasicInfo_bankingHours_add_button_id);
    }

    public void userClicksOnDeleteCountryBankingHours() {
        attemptClick(countryBasicInfo_bankingHours_delete_button_xpath);
    }

    public void userClicksOnDeleteCountryRegionType() {
        attemptClick(country_region_delete_button_xpath);
    }

    public void clicksOnDeleteCountryPlacesType() {
        attemptClick(country_places_delete_button_xpath);
    }

    public void verifyUserSeeBankingDaysAndHours() {
        List<String> hours = new ArrayList<>();
        attemptClick(countryBasicInfo_bankingHours_day_dropdown_xpath);

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] weekDays = dateFormatSymbols.getWeekdays();

        List<WebElement> dropdownWeeks = getDriver().findElements(countryBasicInfo_bankingHours_day_dropdown_values_xpath);
        for (int i = 0; i < dropdownWeeks.size(); i++) {
            assertTrue(weekDays[i].equals(dropdownWeeks.get(i).getText()));
        }

        Calendar cal = Calendar.getInstance();
        cal.clear();
        hours.add(0, " ");
        for (int i = 1; i <= 48; i++) {
            int h = cal.get(Calendar.HOUR_OF_DAY);
            int m = cal.get(Calendar.MINUTE);
            hours.add(String.format("%02d:%02d", h, m));
            cal.add(Calendar.MINUTE, 30);
        }

        List<WebElement> dropdownStartHours = getDriver().findElements(countryBasicInfo_bankingHours_startHour_dropdown_xpath);

        for (int j = 0; j < dropdownStartHours.size(); j++) {
            assertTrue(hours.get(j).equals(dropdownStartHours.get(j).getText()));
        }

        List<WebElement> dropdownEndHours = getDriver().findElements(countryBasicInfo_bankingHours_endHour_dropdown_xpath);

        for (int j = 0; j < dropdownEndHours.size(); j++) {
            assertTrue(hours.get(j).equals(dropdownEndHours.get(j).getText()));
        }

    }

    public void verifyBankingHoursExceptExistingHours() {
        List<String> hours = new ArrayList<>();
        List<WebElement> ExistingWeekDays = getDriver().findElements(countryBasicInfo_bankingHours_existing_day_dropdown_values_xpath);

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] weekDays = dateFormatSymbols.getWeekdays();
        List<String> weekDaysList = new ArrayList<>(Arrays.asList(weekDays));

        for (WebElement day : ExistingWeekDays) {
            weekDaysList.remove(day.getText());
        }

        List<WebElement> newDropdownWeeks = getDriver().findElements(countryBasicInfo_bankingHours_day_dropdown_values_xpath);

        for (int i = 0; i < newDropdownWeeks.size(); i++) {
            assertTrue(weekDaysList.get(i).equals(newDropdownWeeks.get(i).getText()));
        }
        Calendar cal = Calendar.getInstance();
        cal.clear();
        hours.add(0, " ");
        for (int i = 1; i <= 48; i++) {
            int h = cal.get(Calendar.HOUR_OF_DAY);
            int m = cal.get(Calendar.MINUTE);
            hours.add(String.format("%02d:%02d", h, m));
            cal.add(Calendar.MINUTE, 30);
        }

        List<WebElement> dropdownStartHours = getDriver().findElements(countryBasicInfo_bankingHours_startHour_dropdown_xpath);

        for (int j = 0; j < dropdownStartHours.size(); j++) {
            assertTrue(hours.get(j).equals(dropdownStartHours.get(j).getText()));
        }

        List<WebElement> dropdownEndHours = getDriver().findElements(countryBasicInfo_bankingHours_endHour_dropdown_xpath);

        for (int j = 0; j < dropdownEndHours.size(); j++) {
            assertTrue(hours.get(j).equals(dropdownEndHours.get(j).getText()));
        }


    }

    public void enterCreditRatingAppliedYear(String appliedYear) {
        getDriver().findElement(country_credit_rating_appliedYear_xpath).clear();
        getDriver().findElement(country_credit_rating_appliedYear_xpath).sendKeys(appliedYear);
    }

    public void verifyErrMustBeNoLaterThanTodayForAppliedDate() {
        assertEquals("Must be no later than today.", getDriver().findElement(country_credit_rating_applied_date_error_msg_xpath).getText());
    }

    public void enterCreditRatingConfirmedYear(String confirmedYear) {
        getDriver().findElement(country_credit_rating_confirmed_date_xpath).clear();
        getDriver().findElement(country_credit_rating_confirmed_date_xpath).sendKeys(confirmedYear);
    }

    public void verifyErrMustBeNoLaterThanTodayForConfirmedDate() {
        assertEquals("Must be no later than today.", getDriver().findElement(country_credit_rating_confirmed_date_error_msg_xpath).getText());
    }

    public void verifyCreditRatingConfirmedDateRequiredErrorMessage() {
        assertEquals("Required", getDriver().findElement(country_credit_rating_confirmed_date_error_msg_xpath).getText());
    }

    public void clickAddRowButton() {
        attemptClick(country_credit_rating_addRow_id);
    }

    public void clickOnDeleteCreditRatingButton() {
        getDriver().findElement(country_credit_rating_delete_button_xpath).click();
    }

    public void verifyNoNewlyAddedCreditRatingRow() {
        try {
            assertFalse(getDriver().findElement(country_credit_rating_new_row_xpath).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void VerifyCreditRatingValueMaxLength(String maxLength) {
        assertEquals(getDriver().findElement(country_credit_rating_value_xpath).getAttribute("maxlength"), maxLength);
    }

    public void verifyErrorMessageEnterYearMonthDayForAppliedDate(String errorMsg) {
        assertEquals(errorMsg, getDriver().findElement(country_credit_rating_applied_date_error_msg_xpath).getText());
    }

    public void verifyCountryEditPageMode() {
        assertTrue(getDriver().findElements(country_edit_fields_xpath).size() > 1);
    }

    public void enterIBANRegisteredDay(String day) {
        getDriver().findElement(country_iban_registered_day_xpath).clear();
        getDriver().findElement(country_iban_registered_day_xpath).sendKeys(day);
    }

    public void selectIBANRegisteredMonth(String month) {
        selectItemFromDropdownListByText((country_iban_registered_month_xpath), month);
    }

    public void enterIBANRegisteredYear(String year) {
        getDriver().findElement(country_iban_registered_year_xpath).clear();
        getDriver().findElement(country_iban_registered_year_xpath).sendKeys(year);
    }

    public void verifyErrorMsgForCountryPaymentsRegisteredDate() {
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(country_iban_date_err_msg_xpath).getText());
    }

    public void clickOnIBANRoutingCodeTypes() {
        attemptClick(country_payments_iban_routing_code_types_xpath);
    }

    public void verifyIBANRoutingCodeTypes() {
        List<WebElement> ibanRoutingCodeTypesList = getDriver().findElements(country_payments_iban_routing_code_types_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get routing code types");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), ibanRoutingCodeTypesList.get(i).getText());
        }
    }

    public void clickOnRoutingCodeTypes() {
        attemptClick(country_payments_routing_code_types_xpath);
    }

    public void verifyRoutingCodeTypes() {
        List<WebElement> routingCodeTypesList = getDriver().findElements(country_payments_routing_code_types_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get routing code types");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), routingCodeTypesList.get(i).getText());
        }
    }

    public void clickOnCountryPaymentsIsoCode() {
        attemptClick(country_payments_country_iso2_xpath);
    }

    public void verifyCountryPaymentsIso2List() {
        List<WebElement> countryIso2List = getDriver().findElements(country_payments_country_iso2_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get country iso2 list");
        for (int i = 1; i < document.getElementsByTagName("iso2").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), countryIso2List.get(i).getText());
        }
    }

    public void verifyCountryIBANInfoFromTrusted() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", dataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        List<WebElement> registeredDay = getDriver().findElements(country_payments_iban_row_registered_day_xpath);
        List<WebElement> registeredMonth = getDriver().findElements(country_payments_iban_row_registered_month_xpath);
        List<WebElement> registeredYear = getDriver().findElements(country_payments_iban_row_registered_year_xpath);
        List<WebElement> isoCodes = getDriver().findElements(country_payments_iban_row_country_iso2_xpath);
        List<WebElement> routingCodeType = getDriver().findElements(country_payments_iban_row_routing_code_type_xpath);

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country IBAN info", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("iban").getLength(); i++) {

            assertEquals(document.getElementsByTagName("iso2").item(i).getTextContent(), isoCodes.get(i).getText());

            assertEquals(document.getElementsByTagName("registeredDate").item(i).getTextContent(), String.format("%02d", Integer.parseInt(registeredDay.get(i).getAttribute("value"))) + " " + registeredMonth.get(i).getText() + " " + registeredYear.get(i).getAttribute("value"));
            assertEquals(document.getElementsByTagName("routingCodeType").item(i).getTextContent(), routingCodeType.get(i).getText());
        }
        assertEquals(document.getElementsByTagName("status").item(0).getTextContent(), getDriver().findElement(country_payments_status_check_box_xpath).getAttribute("value"));
    }

    public void verifyCountryRoutingCodeTypesFromTrusted() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", dataPage.selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        List<WebElement> routingCodes = getDriver().findElements(country_payments_routing_codes_row_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country routing codes", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("code").getLength(); i++) {
            assertEquals(document.getElementsByTagName("code").item(i).getTextContent(), routingCodes.get(i).getText());
        }
    }

    public void clickOnAddNewIBANButton() {
        attemptClick(country_payments_iban_add_new_button_id);
    }

    public void clickOnAddNewRoutingCodeButton() {
        attemptClick(country_payments_routing_code_add_new_button_id);
    }

    public void verifyNewlyAddedIBANRow() {
        assertTrue(getDriver().findElement(country_payments_new_iban_row_xpath).isDisplayed());
    }

    public void verifyNoNewlyAddedIBANRow() {
        try {
            assertFalse(getDriver().findElement(country_payments_new_iban_row_xpath).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void verifyNewlyAddedRoutingCodeRow() {
        assertTrue(getDriver().findElement(country_payments_new_routing_code_row_xpath).isDisplayed());
    }

    public void verifyNoNewlyAddedRoutingCodeRow() {
        try {
            assertFalse(getDriver().findElement(country_payments_new_routing_code_row_xpath).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void enterCountryCreditRatingAppliedDateDay(String appliedDay) {
        getDriver().findElement(country_credit_rating_applied_date_day_xpath).clear();
        getDriver().findElement(country_credit_rating_applied_date_day_xpath).sendKeys(appliedDay);
    }

    public void enterCountryCreditRatingAppliedDateMonth(String appliedMonth) {
        selectItemFromDropdownListByText(country_credit_rating_applied_date_month_xpath, appliedMonth);
    }

    public void enterCountryCreditRatingConfirmedDateMonth(String confirmedMonth) {
        selectItemFromDropdownListByText(country_credit_rating_confirmed_year_month_xpath, confirmedMonth);
    }

    public void enterCountryCreditRatingConfirmedDateDay(String confirmedDay) {
        getDriver().findElement(country_credit_rating_confirmed_date_day_xpath).clear();
        getDriver().findElement(country_credit_rating_confirmed_date_day_xpath).sendKeys(confirmedDay);
    }

    public void verifyErrorMessageEnterYearMonthDayForConfirmedDate(String errorMsgForDate) {
        assertEquals(errorMsgForDate, getDriver().findElement(country_credit_rating_confirmed_date_error_msg_xpath).getText());
    }

    public void verifyNewlyAddedCreditRatingRow() {
        assertTrue(getDriver().findElement(country_credit_rating_new_row_xpath).isDisplayed());
    }

    public void selectCountryBankingHrsDay(String bankingHrsDay) {
        editedCountryBankingHrsDay = bankingHrsDay;
        selectItemFromDropdownListByText(country_banking_hrs_day_list_xpath, bankingHrsDay);
    }

    public void selectCountryBankingHrsStartTime(String bankingHrsStartTime) {
        editedCountryBankingHrsStartTime = bankingHrsStartTime;
        selectItemFromDropdownListByText(country_banking_hrs_start_time_list_xpath, bankingHrsStartTime);
    }

    public void selectCountryBankingHrsEndTime(String bankingHrsEndTime) {
        editedCountryBankingHrsEndTime = bankingHrsEndTime;
        selectItemFromDropdownListByText(country_banking_hrs_end_time_list_xpath, bankingHrsEndTime);
    }

    public void verifyEditCountryBankingHrsInZeus(String selectedCountry) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCountry));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get country banking hrs", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("day").getLength(); i++) {
            assertEquals(editedCountryBankingHrsDay, document.getElementsByTagName("name").item(i).getTextContent());
            assertEquals(editedCountryBankingHrsStartTime, document.getElementsByTagName("startTime").item(i).getTextContent());
            assertEquals(editedCountryBankingHrsEndTime, document.getElementsByTagName("endTime").item(i).getTextContent());
        }
    }

    public void verifyHeraValidationError() {
        assertEquals("Technical error. Update not successful. Please contact Accuity Helpdesk", getDriver().findElement(country_hera_validation_err_msg_xpath).getText());
    }

    public void pressEnterButtonInDeleteConfirmationModal() {
        getDriver().findElement(country_delete_yes_button_id).sendKeys(Keys.ENTER);
    }

    public void verifyDisabledGoButtonStatus() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(getDriver().findElement(country_places_go_button_xpath).isEnabled());
    }

    public void verifyDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(country_banking_hours_delete_row_confirmation_modal_xpath).getText());
    }

    public void selectCreditRatingAgency(String agency) {
        selectItemFromDropdownListByValue(country_credit_rating_agency_xpath, agency);
    }


    public void deleteAllBankingHours() {

        List<WebElement> deleteRows = getDriver().findElements(country_banking_hours_row_delete_button_xpath);
        for (int i = 0; i < deleteRows.size(); i++) {
            WebElement currentInstance = getDriver().findElements((country_banking_hours_row_delete_button_xpath)).get(0);
            if (currentInstance != null) {
                currentInstance.click();
            }
            verifyDeleteConfirmationModal();
            pressEnterButtonInDeleteConfirmationModal();
        }
    }

    public void verifyNoBankingHoursRows() {

        try {
            assertFalse(getDriver().findElement(country_bankingHours_rows_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void selectCreditRatingType(String type) {
        selectItemFromDropdownListByValue(country_credit_rating_type_xpath, type);
    }

    public void enterCreditRatingValue(String value) {
        getDriver().findElement(country_credit_rating_value_xpath).clear();

        getDriver().findElement(country_credit_rating_value_xpath).sendKeys(value);
    }
}