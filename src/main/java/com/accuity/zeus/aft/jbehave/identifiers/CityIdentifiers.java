package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();

	public static void setIdentifiers() {
		hmap.put("city_add_info_text_xpath", By.xpath(("//*[@id='cityBasicInfo']//textarea[@name='addInfo']")));	
		hmap.put("city_add_info_added_text_xpath",By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[10]/td"));
		hmap.put("city_save_confirmation_message_id", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("city_addInfo_error_message_edit_xpath", By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[10]/td/p[@data-error_id='addInfoError']"));		
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
		hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));
		hmap.put("city_add_info_xpath_after_save", By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[10]/td"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}
}
