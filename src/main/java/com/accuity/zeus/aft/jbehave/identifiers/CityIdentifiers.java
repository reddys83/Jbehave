package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		
		hmap.put("city_status_identifier_dropdown", By.cssSelector("select[data-edit_id='status']"));
		hmap.put("city_status_identifier_dropdown_options", By.cssSelector("select[data-edit_id='status'] > option"));
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
