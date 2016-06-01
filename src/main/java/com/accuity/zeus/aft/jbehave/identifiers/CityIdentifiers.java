package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		hmap.put("city_population_input_id", By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[8]/td/input"));	
		hmap.put("city_save_confirmation_message_id", By.xpath("//p[@id='saveSuccess']"));				
		hmap.put("save_button_id",By.xpath("//button[@id='save-button']"));
		hmap.put("city_population_error_message_id", By.xpath("//li[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[8]/td/p"));		
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
