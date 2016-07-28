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
		hmap.put("area_day_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-day']"));
		hmap.put("area_month_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='startDate-month']"));
		hmap.put("area_year_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-year']"));
		hmap.put("area_day_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-day']"));
		hmap.put("area_month_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='endDate-month']"));
		hmap.put("area_year_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-year']"));
		hmap.put("area_end_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='End Date']/td"));
		hmap.put("area_enddate_errorMessage_xpath",By.xpath("//*[@data-error_id='endDateError']"));
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
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
