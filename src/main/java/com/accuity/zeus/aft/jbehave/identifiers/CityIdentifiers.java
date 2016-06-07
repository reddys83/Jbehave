package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		
		hmap.put("city_status_identifier_dropdown_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select")));
		hmap.put("city_status_identifier_dropdown_options_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
		hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
