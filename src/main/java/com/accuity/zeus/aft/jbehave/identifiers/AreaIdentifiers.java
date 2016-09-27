package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class AreaIdentifiers {

	private static HashMap<String, By> hmap = new HashMap<String, By>();	


	public static void setIdentifiers() {
		hmap.put("area_day_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-day']"));
		hmap.put("area_month_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='startDate-month']"));
		hmap.put("area_year_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-year']"));
		hmap.put("area_began_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Began Date']/td"));
		hmap.put("area_begandate_errorMessage_xpath",By.xpath("//*[@data-error_id='startDateError']"));
		hmap.put("area_status_identifier_dropdown_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select")));
		hmap.put("area_status_identifier_dropdown_options_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("area_update_button_xpath", By.xpath("//*[@id='update-button']"));
		hmap.put("area_save_confirmation_message_xpath", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
		hmap.put("area_day_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-day']"));
		hmap.put("area_month_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='endDate-month']"));
		hmap.put("area_year_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-year']"));
		hmap.put("area_end_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='End Date']/td"));
		hmap.put("area_enddate_errorMessage_xpath",By.xpath("//*[@data-error_id='endDateError']"));
		hmap.put("area_names_full_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']"));
		hmap.put("area_names_full_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedFullName']"));
		hmap.put("area_names_full_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Full Name']/td[2]"));
		hmap.put("area_names_display_name_type_xpath", By.xpath("//*[@id='additionalNames']//td[text() = 'Display Name']"));
		hmap.put("area_names_full_name_type_parent", By.xpath("//*[@id='additionalNames']//td[text() = 'Full Name']/.."));
		hmap.put("area_names_display_name_type_parent", By.xpath("//*[@id='additionalNames']//td[text() = 'Display Name']/.."));
		hmap.put("area_names_display_name_value_xpath", By.xpath("//*[@id='additionalNames']//input[@name='fixedDisplayName']"));
		hmap.put("area_names_display_name_value_view_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[td='Display Name']/td[2]"));
		hmap.put("area_names_add_names_button_xpath", By.xpath("//*[@id='areaBasicInfo']//*[@id='add-names']"));
		hmap.put("area_name_type_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameType']"));
		hmap.put("area_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']//*[@data-internal_id='nameValue']"));
		hmap.put("area_NameTable", By.xpath("//*[@id='areaBasicInfo']//h2[text() = 'Names']/.."));
		hmap.put("delete_row_confirmation_modal_xpath", By.xpath("//*[@colspan='10']"));
		hmap.put("area_name_type_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameTypeError']")));
		hmap.put("area_name_value_error_msg_xpath", By.xpath(("//*[@id='additionalNames']//*[@data-error_id='nameValueError']")));
		hmap.put("area_delete_name_row_button_xpath", By.xpath(".//*[@data-row_id='names']//button[@class='delete-element']"));
		hmap.put("area_second_name_value_input_xpath", By.xpath(".//*[@id='additionalNames']/tr[4]//*[@data-internal_id='nameValue']"));
		hmap.put("area_add_info_text_xpath", By.xpath(("//*[@id='areaBasicInfo']//textarea[@name='addInfo']")));
		hmap.put("area_add_info_xpath_after_save", By.xpath("//*[@id='areaBasicInfo']//tr[th='Add Info']/td"));
		hmap.put("area_status_identifier_dropdown_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select")));
		hmap.put("area_status_identifier_dropdown_options_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("area_update_button_xpath", By.xpath("//*[@id='update-button']"));
		hmap.put("area_save_confirmation_message_xpath", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
	    hmap.put("country_places_country_dropDown_select_option_xpath", By.xpath("//*[@id='country']//li"));
	    hmap.put("country_places_areas_dropdown_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Area Parent']//select"));
	    hmap.put("country_places_country_dropDown_select_xpath", By.xpath("//*[@id='country']//td//select"));
	    hmap.put("country_places_areas_option_dropdown_xpath", By.xpath("//*[@id='area']//li"));
        hmap.put("country_current_value_xpath", By.xpath(".//*[@id='selection0']//span"));
        hmap.put("area_current_value_xpath", By.xpath(".//*[@id='selection1']//span"));
        hmap.put("area_List_value_xpath", By.xpath(".//*[@id='selection2']/div //*[@id='entitySelect_chosen']//li"));
        hmap.put("country_places_country_dropDown_xpath", By.xpath("//*[@id='country']//select/option"));
        hmap.put("area_parent_req_err_msg_xpath", By.xpath(("//*[@data-error_id='areaError']")));
        hmap.put("country_places_areaparent_dropdown_xpath", By.xpath(".//*[@id='area']//option"));
        hmap.put("country_default_value_dropdown_xpath", By.xpath("//*[@id='country']//a[@class='chosen-single']/span"));
        hmap.put("parent_area_default_value_dropdown_xpath", By.xpath(".//*[@id='area']//a/span"));
        hmap.put("country_header_value_xpath", By.xpath(".//*[@id='country']"));
        hmap.put("area_header_value_xpath", By.xpath(".//*[@id='area']//option"));
        hmap.put("subarea_header_value_xpath", By.xpath(".//*[@id='area']//option"));
        hmap.put("subarea_header_value_xpath", By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input"));
        hmap.put("country_type_ahead_xpath", By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input"));
        hmap.put("area_area_dropdown_typeAhead_xpath", By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen']//input"));
        hmap.put("area_subarea_dropdown_typeAhead_xpath", By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input"));
        hmap.put("areaParent_currentValue_xpath", By.xpath(".//*[@id='area']"));
        hmap.put("subarea_current_value_xpath", By.xpath(".//*[@id='selection2']//span"));

		hmap.put("area_add_new_identifier_button_id", By.id("add-identifiers"));
		hmap.put("areaIdentifier_type_id", By.xpath("//*[@id='identifierType']"));
		hmap.put("area_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
		hmap.put("area_delete_identifiers_row_button_xpath", By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-element']"));
		hmap.put("delete_area_identifier_row_confirmation_modal_xpath", By.xpath("//*[@id='additionalIdentifiers']/tr[2]"));
		hmap.put("area_delete_yes_button_id", By.xpath("//*[@id='yes-button']"));
		hmap.put("area_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
		hmap.put("area_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
		hmap.put("area_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
		hmap.put("area_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
		hmap.put("area_identifier_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierValueError']")));
		hmap.put("area_identifier_status_req_err_msg_xpath", By.xpath(("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierStatusError']")));
		hmap.put("area_delete_no_button_id_click", By.xpath("//*[@id='no-button']"));
		hmap.put("area_identifier_type_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierTypeError']"));
		hmap.put("area_identifier_type_view_mode", By.xpath("//*[@id='areaBasicInfo']//table[2]//tbody/tr"));
		hmap.put("area_interest_rate_xpath_after_save",By.xpath("//*[@id='areaBasicInfo']//tr[th='Interest Rate Limit']/td"));
		hmap.put("area_interest_rate_text_xpath",By.xpath("//*[@id='areaBasicInfo']//tr[th='Interest Rate Limit']/td/input"));
		hmap.put("area_timezone_utc_second_dropDown", By.xpath("(//*[@name='utc3'])[2]//option"));
		hmap.put("timezone_utc_add_timezone_xpath", By.xpath("//*[@id='add-timeZones']"));
		hmap.put("timezone_utc_dropdown_xpath", By.xpath("//*[@name='utc3']"));
		hmap.put("timezone_utc_dropdown_option", By.xpath("//*[@name='utc3']/option"));
		hmap.put("area_summary_timezone_xpath", By.xpath("//*[@name='timeZonesSummary']"));
		hmap.put("area_delete_timezone_row_button_xpath", By.xpath("//*[@id='additionalTimeZones']//*[@class='delete-element']"));
		hmap.put("area_timezone_dropdown_xpath", By.xpath("//*[@id='additionalTimeZones']/tr"));
		hmap.put("area_timezone_type_view_mode", By.xpath("//*[@id='additionalTimeZones']"));
		hmap.put("utc_current_value_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='UTC']/td"));
		hmap.put("timezone_utc_current_value_xpath", By.xpath("//*[@name='utc3']//option[@selected='selected']"));
		hmap.put("summary_current_value_view_mode_xpath", By.xpath("//*[@id='areaBasicInfo']//dl[dt='Summary']/dd"));
		hmap.put("area_timezone_add_button_xpath", By.xpath("//*[@id='areaBasicInfo']//*[@id='add-timeZones']"));
		hmap.put("area_use_in_address_true", By.xpath("//*[@id='areaBasicInfo']//input[@value='true']"));
		hmap.put("area_use_in_address_false", By.xpath("//*[@id='areaBasicInfo']//input[@value='false']"));
		hmap.put("area_address_flag_view_mode_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Use in Address']/td"));
		hmap.put("area_address_flag_edit_mode_xpath", By.xpath("//input[@name='useInAddress']"));
		hmap.put("area_region_type_dropdown_options_xpath", By.xpath(("//*[@id='areaRegions']//*[@id='regionType']/option")));
		hmap.put("area_add_new_region_button_id", By.id("add-regions"));
		hmap.put("area_region_type_dropdown_xpath", By.xpath(".//*[@id='regionType']"));
		hmap.put("area_region_value_dropdown_xpath", By.xpath(".//select[@id='regionValue']"));
		hmap.put("area_region_value_dropdown_option", By.xpath(".//select[@id='regionValue']/option"));
		hmap.put("area_region_value_req_err_msg_xpath", By.xpath(("//*[@id='additionalRegions']//*[@data-error_id='regionValueError']")));
		hmap.put("area_delete_region_row_button_xpath", By.xpath(".//*[@data-row_id='regions']//button[@class='delete-element']"));
		hmap.put("area_region_table", By.xpath("//*[@id='areaRegions']//table"));
		hmap.put("area_region_link", By.xpath("//*[@id='areaRegions']"));
		hmap.put("area_credit_rating", By.xpath("//*[@id='areaCreditRating']"));
		hmap.put("area_credit_rating_row", By.xpath("//*[@class='data']//*[@id='areaCreditRating']//tr"));
		hmap.put("area_credit_rating_new_row", By.xpath("//*[@class='data']//*[@id='areaCreditRating']//tr[@class='new']"));
		hmap.put("area_credit_rating_agency_dropdown", By.xpath("//*[@id='additionalCreditRatings']//select[@data-internal_id='creditRatingAgency']"));
		hmap.put("area_credit_rating_type_dropdown", By.xpath("//*[@id='additionalCreditRatings']//select[@data-internal_id='creditRatingType']"));
		hmap.put("area_credit_rating_applied_date_day", By.xpath("//input[@name='creditRatingAppliedDate-day']"));
		hmap.put("area_credit_rating_applied_date_month", By.xpath("//*[@name='creditRatingAppliedDate-month']"));
		hmap.put("area_credit_rating_applied_date_year", By.xpath("//input[@name='creditRatingAppliedDate-year']"));
		hmap.put("area_credit_rating_confirmed_date_day", By.xpath("//input[@name='creditRatingConfirmedDate-day']"));
		hmap.put("area_credit_rating_confirmed_date_month", By.xpath("//*[@name='creditRatingConfirmedDate-month']"));
		hmap.put("area_credit_rating_confirmed_date_year", By.xpath("//input[@name='creditRatingConfirmedDate-year']"));
		hmap.put("area_credit_rating_value", By.xpath("//*[@id='additionalCreditRatings']//*[@name='creditRatingValue']"));
		hmap.put("area_credit_rating_add_row_id", By.xpath("//*[@id='add-creditRatings']"));
		hmap.put("area_delete_credit_rating_row_button", By.xpath(".//*[@id='additionalCreditRatings']//*[@class='delete-element']"));
		hmap.put("area_credit_rating_agency_error", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingAgencyError']"));
		hmap.put("area_credit_rating_type_error", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingTypeError']"));
		hmap.put("area_credit_rating_value_error", By.xpath("//*[@id='additionalCreditRatings']//*[@data-error_id='creditRatingValueError']"));
		hmap.put("area_credit_rating_applied_date_error_msg", By.xpath("//*[@data-error_id='creditRatingAppliedDateError']"));
		hmap.put("area_credit_rating_confirmed_date_error_msg", By.xpath("//*[@data-error_id='creditRatingConfirmedDateError']"));
		hmap.put("area_add_demographics_button", By.id("add-demographics"));
		hmap.put("area_demographics_type", By.xpath("//select[@id='demographicType']"));
		hmap.put("area_demographics_value", By.xpath("//*[@id='additionalDemographics']//*[@data-internal_id='demographicValue']"));		 
		hmap.put("area_demographics_unit_dropdown", By.xpath("//*[@id='areaDemographics']//*[@data-internal_id='demographicUnit']"));
		hmap.put("area_demographics_unit_options", By.xpath("//*[@id='areaDemographics']//*[@data-internal_id='demographicUnit']/option"));
		hmap.put("area_demographic_date-day", By.xpath("//*[@id='areaDemographics']//*[@name='demographicDate-day']"));
		hmap.put("area_demographic_date-month", By.xpath("//*[@id='areaDemographics']//*[@name='demographicDate-month']"));
		hmap.put("area_demographic_date-year", By.xpath("//*[@id='areaDemographics']//*[@name='demographicDate-year']"));
		hmap.put("area_demographic-delete-button", By.xpath("//*[@id='additionalDemographics']//button[@class='delete-element']"));	
		hmap.put("area_demographics_type_options", By.xpath("//select[@id='demographicType']/option"));
		hmap.put("area_demographic_type_error_message", By.xpath("//*[@data-error_id='demographicTypeError']"));
		hmap.put("area_demographic_value_error_message", By.xpath("//*[@data-error_id='demographicValueError']"));
		hmap.put("area_demographic_date_error_message", By.xpath("//*[@data-error_id='demographicDateError']"));
		hmap.put("area_demographics_row", By.xpath("//*[@class='data']//*[@id='areaDemographics']//tr[@data-row_id='demographics']"));
		hmap.put("area_demographics_row_view_mode", By.xpath("//*[@class='data']//*[@id='areaDemographics']//tr"));
		hmap.put("area_place_entirevalue_xpath", By.xpath("//*[@id='areaPlaces']//tbody"));
		hmap.put("area_places_link_id", By.xpath("//*[@id='areaPlaces']"));
		hmap.put("area_places_type_dropdown_xpath", By.xpath("//*[@id='relatedPlaceType']"));
		hmap.put("area_places_type_options_dropdown_xpath", By.xpath("//*[@id='relatedPlaceType']/option"));
		hmap.put("area_places_detail_dropdown_xpath", By.xpath("//*[@data-internal_id='relatedPlaceDetails']"));
		hmap.put("area_places_place_edit_button_2_xpath",
				By.xpath("//*[@id='additionalRelatedPlaces']/tr[2]/td[2]/button"));
		hmap.put("area_place_entirevalues_xpath", By.xpath("//*[@id='areaPlaces']//tbody//tr"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}