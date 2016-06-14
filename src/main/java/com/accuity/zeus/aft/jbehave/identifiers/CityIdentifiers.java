package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {

		hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));
		hmap.put("save_button_id", By.xpath(("//*[@id='save-button']")));
		hmap.put("city_confirm_button", By.xpath("//button[@id='confirm-button']"));
		hmap.put("city_save_confirmation_message_id", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("city_end_date_info_text_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[th='End Date']/td"));
		hmap.put("city_day_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='endDate-day']"));
		hmap.put("city_month_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//select[@name='endDate-month']"));
		hmap.put("city_year_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='endDate-year']"));
		hmap.put("city_save_confirmation_message_id", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("city_error_for_invalid_date", By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[3]/td/p"));
		hmap.put("city_day_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='startDate-day']"));
		hmap.put("city_month_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//select[@name='startDate-month']"));
		hmap.put("city_year_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='startDate-year']"));
		hmap.put("city_error_msg_at_top_page", By.xpath("//*[@id='error']/div/div/p"));

	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}

}
