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
		hmap.put("city_places_link_id", By.xpath("//*[@id='cityPlaces']"));
		hmap.put("city_add_places_button_edit_id", By.xpath("//button[@id='add-relatedPlaces']"));
		hmap.put("city_places_type_required_error_message_xpath", By.xpath(".//*[@class='notification error'][@data-error_id='relatedPlaceTypeError']"));
		hmap.put("city_places_place_required_error_message_xpath", By.xpath(".//*[@class='notification error'][@data-error_id='relatedPlacePlaceError']"));
		hmap.put("city_places_type_dropdown_xpath", By.xpath(".//*[@class='new'][@data-row_id='relatedPlaces']//select[@id='relatedPlaceType']"));
		hmap.put("city_places_type_options_dropdown_xpath", By.xpath(".//*[@class='new'][@data-row_id='relatedPlaces']//select[@id='relatedPlaceType']/option"));
		hmap.put("city_places_place_edit_button_xpath", By.xpath(".//tr[@class='new']//button[@class='edit-row']"));
		hmap.put("city_places_country_dropDown_xpath", By.xpath(".//*[@id='country_chosen']//a"));
		hmap.put("city_places_country_dropDown_input_xpath", By.xpath(".//*[@id='country_chosen']//input"));
		hmap.put("city_places_area_dropdown_xpath", By.xpath(".//*[@id='area_chosen']//a"));
		hmap.put("city_places_area_dropdown_input_xpath", By.xpath(".//*[@id='area_chosen']//input"));
		hmap.put("city_places_city_dropdown_xpath", By.xpath(".//*[@id='city_chosen']//a"));
		hmap.put("city_places_city_dropdown_input_xpath", By.xpath(".//*[@id='city_chosen']//input"));
		hmap.put("city_places_go_button_xpath", By.xpath(".//*[@id='multiSelectRow']/button"));
		hmap.put("city_places_details_Select_dropdown_xpath",By.xpath("//*[@id='additionalRelatedPlaces']/tr[@class='new']/td[4]/select"));
	
		
		
	}


	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
