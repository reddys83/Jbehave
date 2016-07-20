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
		hmap.put("area_day_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-day']"));
		hmap.put("area_month_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='startDate-month']"));
		hmap.put("area_year_began_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='startDate-year']"));
		hmap.put("area_day_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-day']"));
		hmap.put("area_month_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//select[@name='endDate-month']"));
		hmap.put("area_year_end_date_xpath", By.xpath("//*[@id='areaBasicInfo']//input[@name='endDate-year']"));
		hmap.put("area_end_date_info_text_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='End Date']/td"));
		hmap.put("area_enddate_errorMessage_xpath",By.xpath("//*[@data-error_id='endDateError']"));
		hmap.put("area_status_identifier_dropdown_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select")));
		hmap.put("area_status_identifier_dropdown_options_xpath",
				By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']//select/option")));
		hmap.put("area_update_button_xpath", By.xpath("//*[@id='update-button']"));
		hmap.put("area_save_confirmation_message_xpath", By.xpath(("//*[@id='saveSuccess']")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));
		hmap.put("area_get_status_value_xpath", By.xpath(("//*[@id='areaBasicInfo']//tr[th='Status']/td")));	
	    hmap.put("country_places_country_dropDown_select_option_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Country']//select/option"));
	    hmap.put("country_places_areas_dropdown_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Area Parent']//select"));
	    hmap.put("country_places_country_dropDown_select_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Country']//select"));
	    hmap.put("country_places_areas_option_dropdown_xpath", By.xpath("//*[@id='areaBasicInfo']//tr[th='Area Parent']//select//option"));	   
            
	    hmap.put("country_current_value_xpath", By.xpath(".//*[@id='selection0']//span"));
        hmap.put("area_current_value_xpath", By.xpath(".//*[@id='selection1']//span")); 

        hmap.put("area_List_value_xpath", By.xpath(".//*[@id='selection2']/div //*[@id='entitySelect_chosen']//li"));        
        hmap.put("country_places_country_dropDown_xpath", By.xpath(".//*[@id='country']//option"));
        hmap.put("area_identifier_type_req_err_msg_xpath", By.xpath(("//*[@data-error_id='areaParentError']")));       
        hmap.put("country_places_areaparent_dropdown_xpath", By.xpath(".//*[@id='areaParent']//option"));
        hmap.put("country_default_value_dropdown_xpath", By.xpath(".//*[@id='country']//option[@selected='selected']"));
        hmap.put("parent_area_default_value_dropdown_xpath", By.xpath(" .//*[@id='areaParent']//option[@selected='selected']"));
        hmap.put("country_header_value_xpath", By.xpath(".//*[@id='country']"));
        hmap.put("area_header_value_xpath", By.xpath(".//*[@id='area']//option"));
        hmap.put("subarea_header_value_xpath", By.xpath(".//*[@id='area']//option"));        
        hmap.put("subarea_header_value_xpath", By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input"));
        hmap.put("country_type_ahead_xpath", By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input"));
        hmap.put("area_area_dropdown_typeAhead_xpath", By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen']//input"));
        hmap.put("area_subarea_dropdown_typeAhead_xpath", By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input")); 
        hmap.put("areaParent_currentValue_xpath", By.xpath(".//*[@id='areaParent']"));
        hmap.put("subarea_current_value_xpath", By.xpath(".//*[@id='selection2']//span"));
	}

	public static By getObjectIdentifier(String key) {
		setIdentifiers();
		return hmap.get(key);

	}

}
