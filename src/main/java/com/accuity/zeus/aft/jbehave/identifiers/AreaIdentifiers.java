package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class AreaIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {

		hmap.put("area_status_identifier_dropdown_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select")));
		hmap.put("area_status_identifier_dropdown_options_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("area_update_button_xpath", By.xpath("//*[@id='update-button']"));
		hmap.put("area_save_confirmation_message_xpath", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
		hmap.put("area_use_in_address_true", By.xpath("//*[@id='cityBasicInfo']//input[@value='true']"));
		hmap.put("area_use_in_address_false", By.xpath("//*[@id='cityBasicInfo']//input[@value='false']"));
		hmap.put("area_address_flag_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[th='Use In Address']/td"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}