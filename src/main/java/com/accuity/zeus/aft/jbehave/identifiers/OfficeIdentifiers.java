package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import java.util.HashMap;


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
        hmap.put("office_basicInfo_openedDate_errorMessage_xpath",By.xpath("//*[@data-error_id='openedDateError']"));
        hmap.put("office_basicInfo_principalFlag_name", By.name("principalOffice"));
        hmap.put("office_basicInfo_principalFlag_view_name", By.xpath("//*[@id='officeBasicInfo']//tbody/tr[8]/td"));
        hmap.put("office_leadlocation_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='leadLocation']"));
        hmap.put("office_basicInfo_view_leadlocation_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Lead Location']/td"));
        hmap.put("office_foreignoffice_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='foreignOffice']"));
        hmap.put("office_basicInfo_view_foreignoffice_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Foreign Office']/td"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td/textarea"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_view_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td"));
      
        hmap.put("office_add_locations_id", By.id("add-locations"));
        hmap.put("office_locations_row_delete_button", By.xpath("//*[@class='delete-block']"));
        hmap.put("office_locations_row_view", By.xpath(".//*[@id='officeLocations']/h1"));
        hmap.put("office_location_delete_button", By.id("delete-location"));
        hmap.put("office_first_new_row_location_delete_button", By.id("delete-location"));
        hmap.put("office_location_delete_row_confirmation_modal", By.xpath("//*[@id='modal-region']/div"));
        hmap.put("office_location_primary_flag_radio_options", By.xpath("//*[@id='officeLocations']//input[@name='primaryLocation-1']"));
        hmap.put("office_location_primaryoffice_location_delete_row_edit_mode_flag_radio_options", By.xpath("//*[@id='locationDiv']//input[@name='primaryLocation-1']"));
        hmap.put("office_address_addRow_button", By.cssSelector("button[id*='add-locationAddresses']")); 
        hmap.put("office_addressType_first_row_existing_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//li[1]//select[@id='addressType-0']"));
        hmap.put("office_addressType_second_row_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//li[2]//select[@id='addressType-0']"));
        hmap.put("office_location_address_type_dropdown", By.xpath(".//*[@id='officeLocations']//select[@id='addressType-0']"));
        hmap.put("office_address_types_dropdown", By.xpath(".//*[@id='officeLocations']//select[@id='addressType-0']"));
        hmap.put("office_location_addressLine1", By.xpath(".//*[@id='officeLocations']//input[@name='addrLine1']"));
        hmap.put("office_location_addressLine2", By.xpath(".//*[@id='officeLocations']//input[@name='addrLine2']"));
        hmap.put("office_location_addressLine3", By.xpath(".//*[@id='officeLocations']//input[@name='addrLine3']"));
        hmap.put("office_location_addressLine4", By.xpath(".//*[@id='officeLocations']//input[@name='addrLine4']"));
        hmap.put("office_address_first_row_new_addressLine4", By.xpath(".//*[@id='officeLocations']//input[@name='addrLine4']"));
        hmap.put("office_country_dropdown", By.xpath("//*[@id='officeLocations']//tr[@id='country']//a"));
        hmap.put("office_area_dropdown", By.xpath(".//*[@id='officeLocations']//*[@id='area']//a"));
        hmap.put("office_address_country_type_ahead", By.xpath("//*[@id='officeLocations']//tr[@id='country']/td//input"));
        hmap.put("office_address_city_type_ahead", By.xpath("//*[@id='officeLocations']//tr[@id='city']/td//input"));
        hmap.put("office_area_dropdown_list", By.xpath("//*[@id='officeLocations']//tr[@id='area']//*[contains(@class, 'active-result')]"));        
        hmap.put("office_locations_addressList_view_mode", By.xpath(".//*[@id='officeLocations']//*[@class='location']//tr"));
    	hmap.put("office_location_address_type_view_mode", By.xpath(".//*[@class='location']//dl/dt[contains(text(), 'Type')]/following-sibling::dd"));
        hmap.put("office_location_addressLine1_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Address Line 1')]/following-sibling::td"));
	    hmap.put("office_location_addressLine2_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Address Line 2')]/following-sibling::td"));
	    hmap.put("office_location_addressLine3_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Address Line 3')]/following-sibling::td"));
	    hmap.put("office_location_addressLine4_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Address Line 4')]/following-sibling::td"));        
	    hmap.put("office_location_address_city_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'City')]/following-sibling::td"));
	    hmap.put("office_location_address_country_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Country')]/following-sibling::td"));
	    hmap.put("office_location_address_subarea_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Subarea')]/following-sibling::td"));
	    hmap.put("office_location_address_area_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Area')]/following-sibling::td"));
	    hmap.put("office_location_address_postal_code_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Postal Code')]/following-sibling::td"));
	    hmap.put("office_location_address_postal_code_suffix_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Postal Code Suffix')]/following-sibling::td"));
	    hmap.put("office_location_address_info_view_mode", By.xpath(".//*[@class='location']//tr/th[contains(text(), 'Info')]/following-sibling::td"));
	    hmap.put("office_locations_row_exists_edit_mode", By.xpath("//*[@class='location'][@data-sequence_id='0']"));
        hmap.put("office_location_row_exists_view_mode", By.xpath("//*[@class='location']"));
        
        hmap.put("office_area_dropdown_type_ahead", By.xpath("//*[@id='officeLocations']//tr[@id='area']/td//input"));
        hmap.put("office_subarea_dropdown", By.xpath("//*[@id='officeLocations']//tr[@id='subarea']/td//a"));
        hmap.put("office_subarea_dropdown_list", By.xpath(".//*[@id='subarea']//*[contains(@class, 'active-result')]"));
        hmap.put("office_subarea_dropdown_typeAhead", By.xpath("//*[@id='officeLocations']//tr[@id='subarea']/td//input"));
        hmap.put("office_city_dropdown", By.xpath("//*[@id='officeLocations']//tr[@id='city']/td//a"));
        hmap.put("office_city_dropdown_list", By.xpath(".//*[@id='city']//*[contains(@class, 'active-result')]"));        
        hmap.put("office_address_first_row_new_postalCode", By.xpath(".//*[@id='officeLocations']//input[@name='addrPostCode']"));
        hmap.put("office_address_first_row_new_postalCodeSuffix", By.xpath(".//*[@id='officeLocations']//input[@name='addrPostCodeSuffix']"));       
        hmap.put("office_address_first_row_new_info", By.xpath(".//*[@id='officeLocations']//input[@name='addrInfo']"));
        hmap.put("office_first_existing_row_address_delete_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[1]//button"));
        hmap.put("office_address_delete_row_view", By.xpath(".//*[@id='officeLocations']/div[@class='location']/ul"));
        
        hmap.put("office_telecoms_addRow_id", By.id("add-locationTelecomms-0"));
        hmap.put("office_telecoms_first_row_new_telecoms_type_dropdown", By.xpath(".//*[@id='additionalLocationTelecomms-0']//select[@id='telecommType-0']"));
        hmap.put("office_telecoms_first_row_new_rank", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommRank']"));
        hmap.put("office_telecoms_first_row_new_textBefore", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommTextBefore']"));
        hmap.put("office_telecoms_first_row_new_countryCode", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommValueCountry']"));
        hmap.put("office_telecoms_first_row_new_areaCode", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommValueArea']"));
        hmap.put("office_telecoms_first_row_new_number", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommValueNumber']"));
        hmap.put("office_telecoms_first_row_new_rangeLimit", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommRange']"));
        hmap.put("office_telecoms_first_row_new_ext", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommExt']"));
        hmap.put("office_telecoms_first_row_new_textAfter", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommTextAfter']"));
        hmap.put("office_telecoms_first_row_new_answerBack", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommAnswerBack']"));
        hmap.put("office_telecoms_first_row_new_value", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommValue']"));
        hmap.put("office_telecoms_delete_row_edit_view", By.xpath(".//*[@id='locationDiv']/div/div[3]/h2"));
        hmap.put("office_first_new_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[2]//button[@class='delete-element']"));
        hmap.put("office_first_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[1]//button[@class='delete-element']"));
        hmap.put("office_address_type_error_msg", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//*[@data-error_id='addressType-0Error']"));    
        hmap.put("office_locations_addressLineList_view_mode", By.xpath(".//*[@id='officeLocations']//table[4]//tr"));
        
        hmap.put("office_locations_primaryflag_view", By.xpath(".//*[@id='officeLocations']//dl[dt='Primary']/dd"));
        hmap.put("office_locations_postalCode_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Postal Code']/td"));
        hmap.put("office_locations_postalCodeSuffix_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Postal Code Suffix']/td"));
        hmap.put("office_locations_info_textarea_view", By.xpath(".//*[@id='officeLocations']//tr[th='Info']/td"));
        hmap.put("office_address_country_error_msg", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//select[@data-error_id='addrcountry']"));
        hmap.put("office_telecoms_countryCode_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueCountry']"));
        hmap.put("office_telecoms_areaCode_error_msg", By.xpath("//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueArea']"));
        hmap.put("office_telecoms_number_error_msg", By.xpath("//*[@id='additionalLocationTelecomms-0']//tr[1]//input[@data-error_id='telecommValueNumber']"));
        hmap.put("office_telecoms_rangeLimit_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//*[@data-error_id='telecommRangeError']"));
        hmap.put("office_telecoms_ext_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//*[@data-error_id='telecommExtError']"));
        hmap.put("office_telecoms_rank_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//*[@data-error_id='telecommRankError']"));
        hmap.put("office_telecoms_value_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//*[@data-error_id='telecommValueError']"));
        hmap.put("office_telecoms_type_error_msg", By.xpath(".//*[@id='additionalLocationTelecomms-0']//tr[1]//select[@data-error_id='telecommType-0']"));
        hmap.put("office_first_row_existing_delete_address_type_physical_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[1]//button"));
        hmap.put("office_first_row_new_delete_address_type_physical_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li[2]//button"));
        hmap.put("office_locations_save_confirmation_message", By.xpath(("//*[@id='saveSuccess']")));
        hmap.put("office_locations_AddressLines_textarea_view", By.xpath(".//*[@id='officeLocations']//tr"));
        hmap.put("office_address_city_error_msg", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//*[@data-error_id='cityError']"));
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

        hmap.put("first_existing_officetype_dropdown", By.xpath((".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[1]/td[1]/select")));
        hmap.put("second_existing_officetype_dropdown", By.xpath((".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("office_basicInfo_officetypes_dropdown_xpath",By.xpath(".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']//select[@id='officeType' or @id='firstOfficeType']"));
        hmap.put("office_basicInfo_add_new_officetype_button_id",By.id("add-types"));
        hmap.put("first_new_officetype_dropdown", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='officeType']"));
        hmap.put("first_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[1]/td[@class='delete']/button"));
        hmap.put("second_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[2]/td[@class='delete']/button"));
        hmap.put("first_new_row_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[@class='new']/td[@class='delete']/button"));
        hmap.put("office_basicInfo_officetypes_delete_button_xpath",By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr/td[@class='delete']/button"));
        hmap.put("delete_confirmation_yes_button_id",By.id("yes-button"));
        hmap.put("office_office_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='firstOfficeTypeError']"));
        hmap.put("basic_info_office_type_xpath", By.xpath(".//*[@id='content']//li[1]/table[2]/tbody/tr/td"));
        hmap.put("office_add_new_identifier_button_id", By.id("add-identifiers"));
        hmap.put("office_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
        hmap.put("office_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
        hmap.put("office_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
        hmap.put("office_identifier_type_id", By.xpath("//*[@id='identifierType']"));        
        hmap.put("office_identifier_type_view_mode", By.xpath("//*[@id='officeIdentifiers']//tbody/tr"));     
        hmap.put("office_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
        hmap.put("office_identifier_type_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierTypeError']"));
        hmap.put("office_identifier_value_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierValueError']"));
        hmap.put("office_identifier_status_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierStatusError']"));        
        hmap.put("office_delete_identifiers_row_button_xpath", By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-element']"));
        
        hmap.put("office_name_type_first_row_existing_office_name_value",By.xpath("//*[@id='additionalNames']//input[@name='fixedName']"));
        hmap.put("office_name_second_row_existing_office_type_dropdown",By.xpath(".//*[@id='additionalNames']//select[@name='nameType']"));
        hmap.put("office_name_second_row_existing_office_value",By.xpath(".//*[@id='additionalNames']//input[@data-internal_id='nameValue']"));
        hmap.put("office_name_second_row_type_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/table[1]/tbody/tr[2]/td[1]"));
        hmap.put("office_name_second_row_value_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/table[1]/tbody/tr[2]/td[2]"));
        hmap.put("office_basic_info_names_type_xpath",By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[1]"));
        hmap.put("office_basic_info_names_value_xpath",By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[2]"));
        hmap.put("office_name_addRow_id",By.id("add-names"));
        hmap.put("office_Edit_officenames_Table",By.xpath(".//*[@data-edit_id='names']//tr"));
        hmap.put("office_name_type_first_row_new_office_name_type_dropdown",By.xpath(".//*[@id='additionalNames']//tr[@class='new'][1]//select[@name='nameType']"));
        hmap.put("office_name_first_row_new_office_value",By.xpath(".//*[@id='additionalNames']//tr[@class='new'][1]//input[@data-internal_id='nameValue']"));
        hmap.put("office_name_value_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='nameValueError']"));
        hmap.put("office_name_first_row_new_delete_button",By.xpath("//*[@id='additionalNames']//tr[@class='new'][1]//button"));
        hmap.put("office_name_second_row_existing_delete_button",By.xpath("//*[@id='additionalNames']//tr[2]//button"));
        hmap.put("office_name_delete_button_for_legalTitle_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[td='Legal Title']//button[@class='delete-element']"));
        hmap.put("office_name_basicInfo_names_value_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new']//input"));
        hmap.put("office_name_sort_name_xpath",By.xpath(".//*[@id='officeBasicInfo']//input[@name='officeSortName']"));
        hmap.put("office_name_sort_name_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/dl/dd"));
        hmap.put("office_names_type_mode",By.xpath("//*[@id='officeBasicInfo']/ul/li[1]//table[1]//tbody/tr"));
        hmap.put("legalEntity_statistics_label_xpath",By.xpath(".//*[@id='content']//h1/span[text()='Statistics']"));
        hmap.put("office_basicInfo_edit_prefix_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitlePrefix']"));
        hmap.put("office_basicInfo_edit_suffix_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitleSuffix']"));
        hmap.put("office_basicInfo_edit_override_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitleOverride']"));
        hmap.put("office_basicInfo_view_prefix_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Prefix']/td"));
        hmap.put("office_basicInfo_view_suffix_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Suffix']/td"));
        hmap.put("office_add_new_personnel_button_id", By.id("add-personnel"));
        hmap.put("office_personnel_type_input_xpath", By.xpath(".//*[@id='additionalPersonnel']//*[@data-internal_id='personnelType']"));
        hmap.put("office_personnel_value_input_xpath", By.xpath(".//*[@id='additionalPersonnel']//*[@data-internal_id='personnelValue']"));
        hmap.put("office_delete_personnel_row_button_xpath", By.xpath(".//*[@data-row_id='personnel']//button[@class='delete-element']"));
        hmap.put("office_personnel_type_view_mode", By.xpath("//*[@id='officePersonnel']//tbody/tr"));
        hmap.put("office_additional_personnel", By.xpath("#additionalPersonnel"));
        hmap.put("office_personnel_type_error_msg_xpath", By.xpath("//*[@data-error_id='personnelTypeError']"));
		hmap.put("office_personnel_value_error_msg_xpath", By.xpath("//*[@data-error_id='personnelValueError']"));
        hmap.put("office_basicInfo_view_override_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Override']/td"));
        hmap.put("office_business_hours_edit_mode", By.xpath("//*[@id='officeBasicInfo']//input[@name='businessHours']"));
        hmap.put("office_business_hours_view_mode", By.xpath("//*[@id='officeBasicInfo']//tr[th='Business Hours']/td"));
        hmap.put("office_history_edit_mode_xpath", By.xpath("//*[@id='officeHistory']/textarea"));
		hmap.put("office_history_link", By.xpath("//*[@id='legalEntityHistory']"));
		hmap.put("office_history_view_mode_xpath", By.xpath("//*[@id='officeHistory']/p"));
        hmap.put("office_total_atms_xpath", By.xpath("//*[@name='numberOfATMs']"));
        hmap.put("office_total_checking_accounts_xpath", By.xpath("//*[@name='numberOfCheckingAccounts']"));
        hmap.put("office_total_savings_accounts_xpath", By.xpath("//*[@name='numberOfSavingsAccounts']"));
        hmap.put("office_total_atms_err_msg_xpath", By.xpath("//*[@id='officeStatistics']//*[@data-error_id='numberOfATMsError']"));
        hmap.put("office_total_checking_accounts_err_msg_xpath", By.xpath("//*[@id='officeStatistics']//*[@data-error_id='numberOfCheckingAccountsError']"));
        hmap.put("office_total_savings_accounts_err_msg_xpath", By.xpath("//*[@id='officeStatistics']//*[@data-error_id='numberOfSavingsAccountsError']"));
        hmap.put("office_total_atms_view_xpath", By.xpath("//*[@id='officeStatistics']//tr[th='Total ATMs']/td"));
        hmap.put("office_total_checking_accounts_view_xpath", By.xpath("//*[@id='officeStatistics']//tr[th='Total Checking Accounts']/td"));
        hmap.put("office_total_savings_accounts_view_xpath", By.xpath("//*[@id='officeStatistics']//tr[th='Total Savings Accounts']/td"));
	    hmap.put("office_add_service_button_xpath", By.xpath("//*[@id='add-services']"));
	    hmap.put("delete_row_confirmation_modal_service_xpath", By.xpath("//*[@colspan='10']")); 
	    hmap.put("office_delete_yes_button_id", By.xpath("//*[@id='yes-button']"));
	    hmap.put("office_services_delete_button_xpath",By.xpath(".//*[@data-row_id='services']//button[@class='delete-element']"));
	    hmap.put("office_service_category_dropdown_edit_mode_xpath", By.xpath("//select[@id='serviceCategory']"));
	    hmap.put("office_service_override_textbox_edit_mode_xpath", By.xpath("//*[@id='additionalServices']/tr/td[2]/input"));
	    hmap.put("office_services_type_view_mode", By.xpath("//*[@id='officeServices']//tbody/tr")); 
	    hmap.put("office_service_category_view_mode", By.xpath("//*[@id='officeServices']//tr/td[1]")); 
	    hmap.put("office_services_override_view_mode", By.xpath("//*[@id='officeServices']//tr/td[2]")); 
	    hmap.put("office_service_category_dropdown_exist_edit_mode_xpath",By.xpath("//select[@id='serviceCategory']"));
	    hmap.put("office_service_category_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='serviceCategoryError']"));
	    hmap.put("office_services_entire_xpath",By.xpath("//*[@id='officeServices']//tbody"));

	    hmap.put("office_address_country_error_msg", By.xpath(".//*[@id='officeLocations']//li[@class='address new']//*[@data-error_id='countryError']"));
	    hmap.put("office_address_type_physical_error_msg", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address']//*[@data-error_id='addressType-0Error']"));
	    hmap.put("office_locations_telecom_row_view_mode", By.xpath("//*[@id='officeLocations']//*[@class='location']/table/tbody/tr"));
	    hmap.put("office_locations_telecoms_type_dropdown_options", By.xpath(".//*[@id='additionalLocationTelecomms-0']//select[@id='telecommType-0']//option"));
	    hmap.put("office_telecom_type_dropdown_input", By.xpath(".//*[@id='additionalLocationTelecomms-0']//select[@id='telecommType-0']"));
	    hmap.put("office_telecom_rows_edit_mode", By.xpath(".//*[@data-edit_id='locationTelecomms-0']//tr"));
	    hmap.put("office_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']//button[@class='delete-element']"));
	    hmap.put("office_locations_address_rows_edit_mode", By.xpath(".//*[@data-edit_id='locationAddresses-0']"));
	    hmap.put("office_location_address_type_options_dropdown", By.xpath(".//*[@id='officeLocations']//select[@id='addressType-0']/option"));

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}