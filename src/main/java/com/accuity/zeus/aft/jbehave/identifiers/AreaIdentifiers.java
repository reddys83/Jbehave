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
		hmap.put("area_names_full_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']"));
		hmap.put("area_names_full_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedFullNameValue']"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
