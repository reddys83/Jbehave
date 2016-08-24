package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pinintir on 6/23/2016.
 */
public class OfficeIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {

        hmap.put("office_basicInfo_openedDate_view_xpath", By.xpath("//*[@id='officeBasicInfo']//tbody/tr[th='Opened']/td"));
        hmap.put("office_basicInfo_openedDate_day_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='openedDate-day']"));
        hmap.put("office_basicInfo_openedDate_month_xpath", By.xpath("//*[@id='officeBasicInfo']//select[@name='openedDate-month']"));
        hmap.put("office_basicInfo_openedDate_year_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='openedDate-year']"));
        hmap.put("office_basicInfo_openedDate_errorMessage_xpath", By.xpath("//*[@data-error_id='openedDateError']"));
        hmap.put("office_leadlocation_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='leadLocation']"));
        hmap.put("office_basicInfo_view_leadlocation_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Lead Location']/td"));
        hmap.put("office_foreignoffice_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='foreignOffice']"));
        hmap.put("office_basicInfo_view_foreignoffice_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Foreign Office']/td"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td/textarea"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_view_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td"));
        hmap.put("office_first_row_existing_location_add_button", By.id("add-locations"));
        hmap.put("office_locations_row_view", By.xpath(".//*[@id='officeLocations']/h1"));
        hmap.put("office_first_existing_row_location_delete_button", By.id("delete-location"));
        hmap.put("office_first_new_row_location_delete_button", By.id("delete-location"));
        hmap.put("office_location_delete_row_confirmation_modal", By.xpath("//*[@id='modal-region']/div"));
        hmap.put("office_location_primary_flag_radio_options", By.xpath("//*[@id='officeLocations']//input[@name='primaryLocation-1']"));
        hmap.put("office_location_primaryoffice_location_delete_row_edit_mode_flag_radio_options", By.xpath("//*[@id='locationDiv']//input[@name='primaryLocation-1']"));
        hmap.put("office_address_addRow_id", By.xpath(".//*[@id='add-locationAddresses-0']"));
        hmap.put("office_addressType_first_row_existing_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//li[1]//select[@id='addressType-0']"));
        hmap.put("office_addressType_second_row_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//li[2]//select[@id='addressType-0']"));
        hmap.put("office_addressType_first_row_new_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//select[@id='addressType-0']"));
        hmap.put("office_address_types_dropdown", By.xpath(".//*[@id='officeLocations']//select[@id='addressType-0']"));
        hmap.put("office_address_first_row_new_addressLine1", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//input[@name='addrLine1']"));
        hmap.put("office_address_first_row_new_addressLine2", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//input[@name='addrLine2']"));
        hmap.put("office_address_first_row_new_addressLine3", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//input[@name='addrLine3']"));
        hmap.put("office_address_first_row_new_addressLine4", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//input[@name='addrLine4']"));
        hmap.put("office_country_dropdown", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='country']/td//a"));
        hmap.put("office_area_dropdown_list_view", By.xpath(".//*[@id='addrarea-0']//*[@class='chosen-single']"));
        hmap.put("office_address_country_type_ahead", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='country']/td//input"));
        hmap.put("office_address_city_type_ahead", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='city']/td//input"));
        hmap.put("office_area_dropdown", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='area']/td//a"));
        hmap.put("office_area_dropdown_list", By.xpath(".//*[@id='area']/td//ul/li"));
        hmap.put("office_area_dropdown_type_ahead", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='area']/td//input"));
        hmap.put("office_subarea_dropdown", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='subarea']/td//a"));
        hmap.put("office_subarea_dropdown_list", By.xpath(".//*[@id='subarea']/td//ul/li"));
        hmap.put("office_subarea_dropdown_typeAhead", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='subarea']/td//input"));
        hmap.put("office_city_dropdown", By.xpath("//*[@id='officeLocations']//li[@class='address new']//tr[@id='city']/td//a"));
        hmap.put("office_city_dropdown_list", By.xpath(".//*[@id='city']/td//ul/li"));
        hmap.put("office_address_first_row_new_postalCode", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrPostCode']"));
        hmap.put("office_address_first_row_new_postalCodeSuffix", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrPostCodeSuffix']"));
        hmap.put("office_address_postalCodePosition", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[1]/div[1]/ul//li[3]//tr[2]/td"));
        hmap.put("office_address_first_row_new_info", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrInfo']"));
        hmap.put("office_first_existing_row_address_delete_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[1]//button"));
        hmap.put("office_address_delete_row_view", By.xpath(".//*[@id='officeLocations']/div/h2[1]"));
        hmap.put("office_telecoms_addRow_id", By.id("add-locationTelecomms-0"));
        hmap.put("office_telecoms_first_row_new_telecoms_type_dropdown", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//select[@id='telecommType-0']"));
        hmap.put("office_telecoms_first_row_new_rank", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommRank']"));
        hmap.put("office_telecoms_first_row_new_textBefore", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommTextBefore']"));
        hmap.put("office_telecoms_first_row_new_CountryCode", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommValueCountry']"));
        hmap.put("office_telecoms_first_row_new_AreaCode", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommValueArea']"));
        hmap.put("office_telecoms_first_row_new_Number", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommValueNumber']"));
        hmap.put("office_telecoms_first_row_new_rangeLimit", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommRange']"));
        hmap.put("office_telecoms_first_row_new_ext", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommExt']"));
        hmap.put("office_telecoms_first_row_new_textAfter", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommTextAfter']"));
        hmap.put("office_telecoms_first_row_new_answerBack", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@name='telecommAnswerBack']"));
        hmap.put("office_telecoms_first_row_new_value", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[1]//input[@name='telecommValue']"));
        hmap.put("office_telecoms_delete_row_edit_view", By.xpath(".//*[@id='locationDiv']/div/div[3]/h2"));
        hmap.put("office_first_new_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[2]//button[@class='delete-element']"));
        hmap.put("office_first_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[1]//button[@class='delete-element']"));
        hmap.put("office_address_type_error_msg", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//select[@data-error_id='addressTypeError-0']"));
        hmap.put("office_locations_Address_type_textarea_view", By.xpath(".//*[@id='officeLocations']//dl[dt='Type']/dd"));
        hmap.put("office_locations_AddressLine1_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Address Line 1']/td"));
        hmap.put("office_locations_AddressLine2_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Address Line 2']/td"));
        hmap.put("office_locations_AddressLine3_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Address Line 3']/td"));
        hmap.put("office_locations_AddressLine4_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Address Line 4']/td "));
        hmap.put("office_locations_primaryflag_view", By.xpath(".//*[@id='officeLocations']//dl[dt='Primary']/dd"));
        hmap.put("office_locations_postalCode_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Postal Code']/td"));
        hmap.put("office_locations_postalCodeSuffix_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Postal Code Suffix']/td"));
        hmap.put("office_locations_info_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Info']/td"));
        hmap.put("office_address_country_error_msg", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//select[@data-error_id='addrcountry']"));
        hmap.put("office_telecoms_countryCode_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueCountry']"));
        hmap.put("office_telecoms_areaCode_error_msg", By.xpath("//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueArea']"));
        hmap.put("office_telecoms_number_error_msg", By.xpath("//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueNumber']"));
        hmap.put("office_telecoms_rangeLimit_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommRange']"));
        hmap.put("office_telecoms_ext_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommExt']"));
        hmap.put("office_telecoms_rank_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommRank']"));
        hmap.put("office_telecoms_value_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[1]//input[@data-error_id='telecommValue']"));
        hmap.put("office_telecoms_type_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//select[@data-error_id='telecommType-0']"));
        hmap.put("office_first_row_existing_delete_address_type_physical_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[1]//button"));
        hmap.put("office_first_row_new_delete_address_type_physical_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[2]//button"));
        hmap.put("office_locations_save_confirmation_message", By.xpath(("//*[@id='saveSuccess']")));
        hmap.put("office_locations_AddressLines_textarea_view", By.xpath(".//*[@id='officeLocations']//tr"));
        hmap.put("office_address_city_error_msg_xpath", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//select[@data-error_id='addrcity']"));
        hmap.put("office_locations_telecoms_type_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Type']/td"));
        hmap.put("office_locations_telecoms_rank_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Rank']/td"));
        hmap.put("office_locations_telecoms_textBefore_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Text Before']/td"));
        hmap.put("office_locations_telecoms_value_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Value']/td"));
        hmap.put("office_locations_telecoms_rangeLimit_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Range Limit']/td"));
        hmap.put("office_locations_telecoms_ext_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Ext']/td"));
        hmap.put("office_locations_telecoms_textAfter_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Text After']/td"));
        hmap.put("office_locations_telecoms_answerback_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Answerback']/td"));
        hmap.put("office_locations_telecoms_value2_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Value']/td"));
        hmap.put("office_location_delete_no_button", By.id("cancel-button"));
        hmap.put("office_location_delete_yes_button",By.id("confirm-button"));
        hmap.put("office_delete_no_button", By.id("no-button"));
        hmap.put("office_area_listBox",By.xpath("//*[@id='area']/td//span"));
        hmap.put("office_subarea_listBox",By.xpath(".//*[@id='subarea']/td//span"));
        hmap.put("office_city_listBox",By.xpath(".//*[@id='city']/td//span"));
        hmap.put("delete_row_confirmation_modal_xpath",By.xpath(".//*[@id='additionalLocationAddresses-0']/li[2]"));

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}