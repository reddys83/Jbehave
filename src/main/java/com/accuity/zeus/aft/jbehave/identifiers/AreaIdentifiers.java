package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class AreaIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();	


	public static void setIdentifiers() {
		hmap.put("area_day_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-day']"));
		hmap.put("area_month_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='startDate-month']"));
		hmap.put("area_year_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-year']"));
		hmap.put("area_began_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Began Date']/td"));
		hmap.put("area_begandate_errorMessage_xpath",By.xpath("//*[@data-error_id='startDateError']"));
		hmap.put("area_status_identifier_dropdown_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select")));
		hmap.put("area_status_identifier_dropdown_options_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("area_update_button_xpath", By.xpath("//*[@id='update-button']"));
		hmap.put("area_save_confirmation_message_xpath", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
		hmap.put("area_day_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-day']"));
		hmap.put("area_month_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='endDate-month']"));
		hmap.put("area_year_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-year']"));
		hmap.put("area_end_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='End Date']/td"));
		hmap.put("area_enddate_errorMessage_xpath",By.xpath("//*[@data-error_id='endDateError']"));
		hmap.put("area_names_full_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']"));
		hmap.put("area_names_full_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedFullName']"));
		hmap.put("area_names_full_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Full Name']/td[2]"));
		hmap.put("area_names_display_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Display Name']"));
		hmap.put("area_names_full_name_type_parent", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']/.."));
		hmap.put("area_names_display_name_type_parent", By.xpath("//*[@id='additionalNames']//td[text() = 'Display Name']/.."));
		hmap.put("area_names_display_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedDisplayName']"));
		hmap.put("area_names_display_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Display Name']/td[2]"));
		hmap.put("area_names_add_names_button_xpath", By.xpath("//*[@id='areaBasicInfo']//*[@id='add-names']"));
		hmap.put("area_name_type_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameType']"));
		hmap.put("area_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameValue']"));
		hmap.put("area_NameTable", By.xpath("//*[@id='areaBasicInfo']//h2[text() = 'Names']/.."));
		hmap.put("delete_row_confirmation_modal_xpath", By.xpath("//*[@colspan='10']"));	
		hmap.put("area_name_type_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameTypeError']")));
		hmap.put("area_name_value_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameValueError']")));
		hmap.put("area_delete_name_row_button_xpath", By.xpath(".//*[@data-row_id='names']//button[@class='delete-row']"));
		hmap.put("area_second_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']/tr[4]//*[@data-internal_id='nameValue']"));
		hmap.put("area_add_info_text_xpath", By.xpath(("//*[@id='areaBasicInfo']//textarea[@name='addInfo']")));
		hmap.put("area_add_info_xpath_after_save", By.xpath("//*[@id='areaBasicInfo']//tr[th='Add Info']/td"));
		hmap.put("area_add_new_identifier_button_id", By.id("add-identifiers"));
		hmap.put("areaIdentifier_type_id", By.xpath("//*[@id='identifierType']"));
		hmap.put("area_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
		hmap.put("area_delete_identifiers_row_button_xpath", By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-row']"));
		hmap.put("delete_area_identifier_row_confirmation_modal_xpath", By.xpath("//*[@id='additionalIdentifiers']/tr[2]"));
		hmap.put("area_delete_yes_button_id", By.xpath("//*[@id='yes-button']"));
		hmap.put("area_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
		hmap.put("area_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
		hmap.put("area_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
		hmap.put("area_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
		hmap.put("area_identifier_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierValueError']")));
		hmap.put("area_identifier_status_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierStatusError']")));
		hmap.put("area_delete_no_button_id_click", By.xpath("//*[@id='no-button']"));
		hmap.put("area_identifier_type_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierTypeError']"));
		hmap.put("area_identifier_type_view_mode", By.xpath("//*[@id='areaBasicInfo']//table[2]//tbody/tr"));
		hmap.put("area_interest_rate_xpath_after_save",By.xpath("//*[@id='areaBasicInfo']//tr[th='Interest Rate Limit']/td"));
		hmap.put("area_interest_rate_text_xpath",By.xpath("//*[@id='areaBasicInfo']//tr[th='Interest Rate Limit']/td/input"));
		hmap.put("area_timezone_utc_second_dropDown", By.xpath("(//*[@name='utc3'])[2]//option"));	
		hmap.put("timezone_utc_add_timezone_xpath", By.xpath("//*[@id='add-timeZones']"));	
		hmap.put("timezone_utc_dropdown_xpath", By.xpath("//*[@name='utc3']"));
		hmap.put("timezone_utc_dropdown_option", By.xpath("//*[@name='utc3']/option"));		
		hmap.put("area_summary_timezone_xpath", By.xpath("//*[@name='timeZonesSummary']"));
		hmap.put("area_delete_timezone_row_button_xpath", By.xpath("//*[@id='additionalTimeZones']//*[@class='delete-row']"));
		hmap.put("area_timezone_dropdown_xpath", By.xpath("//*[@id='additionalTimeZones']/tr"));
		hmap.put("area_timezone_type_view_mode", By.xpath("//*[@id='additionalTimeZones']"));		
		hmap.put("utc_current_value_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='UTC']/td"));		
		hmap.put("timezone_utc_current_value_xpath", By.xpath("//*[@name='utc3']//option[@selected='selected']"));		
		hmap.put("summary_current_value_view_mode_xpath", By.xpath("//*[@id='areaBasicInfo']//dl[dt='Summary']/dd"));
		hmap.put("area_timezone_add_button_xpath", By.xpath("//*[@id='areaBasicInfo']//*[@id='add-timeZones']"));

	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}