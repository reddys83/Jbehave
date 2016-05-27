package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		hmap.put("city_add_info_text_xpath",
				By.xpath(("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[10]/td/textarea")));
		hmap.put("city_save_confirmation_message_id", By.id(("//*[@id='saveSuccess']")));
		hmap.put("city_addInfo_error_message_edit_xpath",
				By.xpath("//*[@id='data']/div/ul/li[1]/ul/li[2]/table/tbody/tr[10]/td/p"));	
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
