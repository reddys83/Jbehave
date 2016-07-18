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
		hmap.put("area_names_full_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedFullNameValue']"));
		hmap.put("area_names_full_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Full Name']/td[2]"));
		hmap.put("area_names_display_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Display Name']"));
		hmap.put("area_names_display_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedDisplayNameValue']"));
		hmap.put("area_names_display_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Display Name']/td[2]"));
		hmap.put("area_names_add_names_button_xpath", By.xpath("//*[@id='areaBasicInfo']//*[@id='add-names']"));
		hmap.put("area_name_type_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameType']"));
		hmap.put("area_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameValue']"));
		hmap.put("area_name_type_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameTypeError']")));
		hmap.put("area_name_value_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameValueError']")));
		hmap.put("area_delete_name_row_button_xpath", By.xpath(".//*[@data-row_id='names']//button[@class='delete-row']"));
		hmap.put("area_second_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']/tr[4]//*[@data-internal_id='nameValue']"));

	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
