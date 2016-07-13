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
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
