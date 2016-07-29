package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pinintir on 6/23/2016.
 */
public class OfficeIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {

        hmap.put("office_basicInfo_openedDate_view_xpath",By.xpath("//*[@id='officeBasicInfo']//tbody/tr[th='Opened']/td"));
        hmap.put("office_basicInfo_openedDate_day_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='openedDate-day']"));
        hmap.put("office_basicInfo_openedDate_month_xpath", By.xpath("//*[@id='officeBasicInfo']//select[@name='openedDate-month']"));
        hmap.put("office_basicInfo_openedDate_year_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='openedDate-year']"));
        hmap.put("office_basicInfo_openedDate_errorMessage_xpath",By.xpath("//*[@data-error_id='openedDateError']"));
        hmap.put("office_leadlocation_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='leadLocation']"));
        hmap.put("office_basicInfo_view_leadlocation_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Lead Location']/td"));

        hmap.put("office_foreignoffice_radio_options_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='foreignOffice']"));
        hmap.put("office_basicInfo_view_foreignoffice_xpath", By.xpath(".//*[@id='officeBasicInfo']//tr[th='Foreign Office']/td"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_xpath",By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td/textarea"));
        hmap.put("office_basicInfo_AdditionalInfo_textarea_view_xpath",By.xpath(".//*[@id='officeBasicInfo']//tr[th='Add Info']/td"));
        hmap.put("office_add_new_identifier_button_id", By.id(""));
        hmap.put("office_identifier_type_input_xpath", By.xpath(""));
        hmap.put("office_identifier_value_input_xpath", By.xpath(""));
        hmap.put("office_identifier_status_input_xpath", By.xpath(""));
        hmap.put("officeIdentifier_type_id", By.xpath(""));
        hmap.put("office_save_confirmation_message_xpath", By.xpath("//*[@id='saveSuccess']"));
        hmap.put("office_identifier_type_view_mode", By.xpath(""));
        hmap.put("confirmation_modal_xpath", By.xpath("//*[@id='modal-region']"));
        hmap.put("office_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
        hmap.put("office_identifier_type_req_err_msg_xpath", By.xpath(""));
        hmap.put("office_identifier_value_req_err_msg_xpath", By.xpath(""));
        hmap.put("office_identifier_status_req_err_msg_xpath", By.xpath(""));
        hmap.put("delete_office_identifier_row_confirmation_modal_xpath", By.xpath(""));
        hmap.put("office_delete_yes_button_id", By.xpath(""));
        hmap.put("office_delete_identifiers_row_button_xpath", By.xpath(""));
        hmap.put("office_delete_no_button_id_click", By.xpath(""));

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}