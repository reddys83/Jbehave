package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		hmap.put("city_population_input_id", By.cssSelector(("input[name='population'")));		
		hmap.put("city_save_confirmation_message_id", By.cssSelector(("#saveSuccess")));				
		hmap.put("save_button_id", By.cssSelector("#save-button]"));	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
