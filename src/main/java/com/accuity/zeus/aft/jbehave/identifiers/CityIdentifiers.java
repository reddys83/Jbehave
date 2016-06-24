package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CityIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();
	

	public static void setIdentifiers() {		

		hmap.put("city_status_identifier_dropdown_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select")));
		hmap.put("city_status_identifier_dropdown_options_xpath", By.xpath(("//*[@id='cityBasicInfo']//tr[th='Status']//select/option")));		
		hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));
        hmap.put("city_add_identifier_xpath", By.xpath(("//button[@id='add-identifiers']")));
        hmap.put("city_identifier_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierValueError']")));
        hmap.put("city_identifier_type_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierTypeError']")));
        hmap.put("city_identifier_status_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierStatusError']")));        
        hmap.put("city_add_new_identifier_button_id", By.id("add-identifiers"));
        hmap.put("city_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
        hmap.put("city_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
        hmap.put("city_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
        hmap.put("city_confirm_button", By.xpath("//button[@id='confirm-button']"));       
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
    	hmap.put("city_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
    	hmap.put("city_population_input_id", By.xpath("//*[@id='cityBasicInfo']//*[@name='population']"));					
		hmap.put("city_population_error_message_id", By.xpath("//*[@id='cityBasicInfo']//*[@data-error_id='populationError']"));	   		
		hmap.put("city_add_info_text_xpath", By.xpath(("//*[@id='cityBasicInfo']//textarea[@name='addInfo']")));		
		hmap.put("city_save_confirmation_message_id", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("city_addInfo_error_message_edit_xpath", By.xpath("//*[@id='cityBasicInfo']//*[@data-error_id='addInfoError']"));
		hmap.put("save_button_id", By.xpath("//*[@id='save-button']"));
		hmap.put("city_add_info_xpath_after_save", By.xpath("//*[@id='cityBasicInfo']//tr[th='Add Info']/td"));
		hmap.put("city_end_date_info_text_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[th='End Date']/td"));
		hmap.put("city_day_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='endDate-day']"));
		hmap.put("city_month_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//select[@name='endDate-month']"));
		hmap.put("city_year_end_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='endDate-year']"));
		hmap.put("city_error_for_invalid_date", By.xpath("//*[@id='cityBasicInfo']//*[@data-error_id='endDateError']"));
		hmap.put("city_day_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='startDate-day']"));
		hmap.put("city_month_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//select[@name='startDate-month']"));
		hmap.put("city_year_began_date_xpath", By.xpath("//*[@id='cityBasicInfo']//input[@name='startDate-year']"));
		hmap.put("city_begandate_day_input_xpath", By.xpath("//input[@name='startDate-day']"));
    	hmap.put("city_begandate_year_input_xpath", By.xpath("//input[@name='startDate-year']"));
    	hmap.put("city_begandate_month_dropdown_xpath", By.xpath("//select[@name='startDate-month']"));
    	hmap.put("city_begandate_errorMessage_xpath",By.xpath("//*[@data-error_id='startDateError']"));    	
    	hmap.put("city_get_beganDate_value_xpath",By.xpath("//*[@id='cityBasicInfo']//tr[th='Began Date']/td"));
		hmap.put("city_use_in_address_true", By.xpath("//*[@id='cityBasicInfo']//input[@value='true']"));
		hmap.put("city_use_in_address_false", By.xpath("//*[@id='cityBasicInfo']//input[@value='false']"));
		hmap.put("city_address_flag_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[th='Use In Address']/td"));

		// adding values for city names
		hmap.put("city_names_full_name_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']"));
		hmap.put("city_names_full_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedNameValue']"));
		hmap.put("city_add_new_name_button_xpath", By.xpath("//*[@id='cityBasicInfo']//*[@id='add-names']"));
        hmap.put("city_name_type_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameType']"));
		hmap.put("city_names_full_name_value_view_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[td='Full Name']/td[2]"));
        hmap.put("city_name_type_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameType']"));
        hmap.put("city_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameValue']"));
        hmap.put("city_name_type_req_err_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameTypeError']")));
        hmap.put("city_name_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameValueError']")));
        hmap.put("city_delete_name_row_button_xpath", By.xpath(".//*[@data-row_id='names']//button[@class='delete-row']"));
        hmap.put("delete_names_row_confirmation_modal_xpath", By.xpath("//*[@id='additionalNames']/tr[3]"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
