package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		
		hmap.put("city_status_identifier_dropdown_xpath", By.xpath(("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[1]/td/select")));
		hmap.put("city_status_identifier_dropdown_options_xpath", By.xpath(("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[1]/td/select/option")));
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
		hmap.put("city_status_confirmation_changes_xpath", By.xpath("//div[@id='modal-region']/div/div/ul/li"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
