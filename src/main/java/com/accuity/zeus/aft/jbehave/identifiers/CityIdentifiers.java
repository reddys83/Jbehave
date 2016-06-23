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

		hmap.put("city_creditRating", By.xpath("//*[@id='cityCreditRating']"));
		hmap.put("city_credit_rating_applied_date_day_xpath", By.xpath("//input[@name='creditRatingAppliedDate-day']"));
		hmap.put("city_credit_rating_applied_date_month_xpath", By.xpath("//*[@name='creditRatingAppliedDate-month']"));
		hmap.put("city_credit_rating_confirmed_date_month_xpath", By.xpath("//*[@name='creditRatingConfirmedDate-month']"));
		hmap.put("city_credit_rating_confirmed_date_day_xpath", By.xpath("//input[@name='creditRatingConfirmedDate-day']"));
		hmap.put("city_credit_rating_appliedYear_xpath", By.xpath("//input[@name='creditRatingAppliedDate-year']"));
		hmap.put("city_credit_rating_applied_date_error_msg_xpath", By.xpath("//*[@data-error_id='creditRatingAppliedDateError']"));
		hmap.put("city_credit_rating_confirmed_date_year_xpath", By.xpath("//input[@name='creditRatingConfirmedDate-year']"));
		hmap.put("city_credit_rating_addRow_id", By.xpath("//*[@id='add-creditRatings']"));
		hmap.put("city_credit_rating_type_dropdown_xpath", By.xpath("//*[@id='additionalCreditRatings']//select[@data-internal_id='creditRatingType']"));
		hmap.put("city_credit_rating_agency_dropdown_xpath", By.xpath("//*[@id='additionalCreditRatings']//select[@data-internal_id='creditRatingAgency']"));
		hmap.put("city_credit_rating_value_xpath", By.xpath("//*[@id='additionalCreditRatings']//*[@name='creditRatingValue']"));
		hmap.put("city_delete_credit_rating_row_button_xpath", By.xpath(".//*[@id='additionalCreditRatings']//*[@class='delete-row']"));
		hmap.put("city_delete_credit_rating_row_confirmation_modal_xpath", By.xpath("//*[@id='additionalCreditRatings']/tr[2]"));
		hmap.put("city_credit_rating_agency_error_xpath", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingAgencyError']"));
		hmap.put("city_credit_rating_type_error_xpath", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingTypeError']"));
		hmap.put("city_credit_rating_value_error_xpath", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingValueError']"));
		hmap.put("city_credit_rating_row_xpath", By.xpath("//*[@id='additionalCreditRatings']"));
		hmap.put("city_credit_rating_confirmed_date_error_msg_xpath", By.xpath("//*[@data-error_id='creditRatingConfirmedDateError']"));

		hmap.put("city_use_in_address_true", By.xpath("//*[@id='cityBasicInfo']//input[@value='true']"));
		hmap.put("city_use_in_address_false", By.xpath("//*[@id='cityBasicInfo']//input[@value='false']"));
		hmap.put("city_address_flag_xpath", By.xpath("//*[@id='cityBasicInfo']//tr[th='Use In Address']/td"));

	}


	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
