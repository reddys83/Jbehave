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
		
		hmap.put("city_status_identifier_dropdown_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select")));
		hmap.put("city_status_identifier_dropdown_options_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
		hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));

        hmap.put("city_add_identifier_xpath", By.xpath(("//button[@id='add-identifiers']")));
        hmap.put("city_identifier_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']/tr/td[2]/*[@data-error_id='identifierValueError']")));
        hmap.put("city_identifier_type_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']/tr/td[1]/*[@data-error_id='identifierTypeError']")));
        hmap.put("city_identifier_status_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']/tr/td[3]/*[@data-error_id='identifierStatusError']")));
        hmap.put("city_identifier_value_max_length_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']/tr/td[2]/p")));
        hmap.put("save_button_id", By.xpath(("//*[@id='save-button']")));
        hmap.put("city_add_new_identifier_button_id", By.id("add-identifiers"));
        hmap.put("city_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
        hmap.put("city_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
        hmap.put("city_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
        hmap.put("city_confirm_button", By.xpath("//button[@id='confirm-button']"));
        hmap.put("city_get_identifier_type_value", By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td"));
        hmap.put("city_get_identifier_value", By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td[2]"));
        hmap.put("city_get_identifier_status_value", By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td[3]"));
        hmap.put("city_delete_identifiers_row_button_xpath", By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-row']"));
        hmap.put("delete_row_confirmation_modal_xpath", By.xpath("//*[@id='additionalIdentifiers']/tr[2]"));            
    	hmap.put("city_delete_yes_button_id", By.xpath("//*[@id='yes-button']"));
    	hmap.put("city_additional_identifiers_row_id", By.xpath("//*[@id='additionalIdentifiers']/tr"));
    	hmap.put("city_delete_no_button_id_click", By.xpath("//*[@id='no-button']"));
    	hmap.put("city_delete_yes_button_id_click", By.xpath("//*[@id='yes-button']"));    	
    	hmap.put("city_save_confirmation_message_id", By.xpath(("//*[@id='saveSuccess']")));
    	hmap.put("cityIdentifier_type_id", By.cssSelector("#identifierType"));
    	hmap.put("cityIdentifier_status_id", By.cssSelector("#identifierStatus"));
    	hmap.put("city_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));    	    	
    
	}


	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);
	}

}
