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

        hmap.put("first_existing_officetype_dropdown", By.xpath((".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[1]/td[1]/select")));
        hmap.put("second_existing_officetype_dropdown", By.xpath((".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("office_basicInfo_officetypes_dropdown_xpath",By.xpath(".//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']//select[@id='officeType' or @id='firstOfficeType']"));
        hmap.put("office_basicInfo_add_new_officetype_button_id",By.id("add-types"));
        hmap.put("first_new_officetype_dropdown", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='officeType']"));
        hmap.put("first_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[1]/td[@class='delete']/button"));
        hmap.put("second_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[2]/td[@class='delete']/button"));
        hmap.put("first_new_row_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//tbody[@id='additionalTypes']/tr[@class='new']/td[@class='delete']/button"));
        hmap.put("office_basicInfo_officetypes_delete_button_xpath",By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr/td[@class='delete']/button"));
        hmap.put("delete_confirmation_yes_button_id",By.id("yes-button"));
        hmap.put("office_office_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='firstOfficeTypeError']"));
        hmap.put("basic_info_office_type_xpath", By.xpath(".//*[@id='content']//li[1]/table[2]/tbody/tr/td"));
        hmap.put("office_add_new_identifier_button_id", By.id("add-identifiers"));
        hmap.put("office_identifier_type_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']"));
        hmap.put("office_identifier_value_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']"));
        hmap.put("office_identifier_status_input_xpath", By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']"));
        hmap.put("office_identifier_type_id", By.xpath("//*[@id='identifierType']"));        
        hmap.put("office_identifier_type_view_mode", By.xpath("//*[@id='officeIdentifiers']//tbody/tr"));     
        hmap.put("office_AdditionalIdentifiers", By.xpath("#additionalIdentifiers"));
        hmap.put("office_identifier_type_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierTypeError']"));
        hmap.put("office_identifier_value_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierValueError']"));
        hmap.put("office_identifier_status_req_err_msg_xpath", By.xpath("//*[@id='additionalIdentifiers']//*[@data-error_id='identifierStatusError']"));        
        hmap.put("office_delete_identifiers_row_button_xpath", By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-row']"));
        
        hmap.put("office_name_type_first_row_existing_office_name_value",By.xpath("//*[@id='additionalNames']//input[@name='fixedName']"));
        hmap.put("office_name_second_row_existing_office_type_dropdown",By.xpath(".//*[@id='additionalNames']//select[@name='nameType']"));
        hmap.put("office_name_second_row_existing_office_value",By.xpath(".//*[@id='additionalNames']//input[@data-internal_id='nameValue']"));
        hmap.put("office_name_second_row_type_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/table[1]/tbody/tr[2]/td[1]"));
        hmap.put("office_name_second_row_value_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/table[1]/tbody/tr[2]/td[2]"));
        hmap.put("office_basic_info_names_type_xpath",By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[1]"));
        hmap.put("office_basic_info_names_value_xpath",By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[2]"));
        hmap.put("office_name_addRow_id",By.id("add-names"));
        hmap.put("office_Edit_officenames_Table",By.xpath(".//*[@data-edit_id='names']//tr"));
        hmap.put("office_name_type_first_row_new_office_name_type_dropdown",By.xpath(".//*[@id='additionalNames']//tr[@class='new'][1]//select[@name='nameType']"));
        hmap.put("office_name_first_row_new_office_value",By.xpath(".//*[@id='additionalNames']//tr[@class='new'][1]//input[@data-internal_id='nameValue']"));
        hmap.put("office_name_value_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='nameValueError']"));
        hmap.put("office_name_first_row_new_delete_button",By.xpath("//*[@id='additionalNames']//tr[@class='new'][1]//button"));
        hmap.put("office_name_second_row_existing_delete_button",By.xpath("//*[@id='additionalNames']//tr[2]//button"));
        hmap.put("office_name_delete_button_for_legalTitle_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[td='Legal Title']//button[@class='delete-row']"));
        hmap.put("office_name_basicInfo_names_value_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new']//input"));
        hmap.put("office_name_sort_name_xpath",By.xpath(".//*[@id='officeBasicInfo']//input[@name='officeSortName']"));
        hmap.put("office_name_sort_name_view",By.xpath(".//*[@id='officeBasicInfo']/ul/li[1]/dl/dd"));
        hmap.put("office_names_type_mode",By.xpath("//*[@id='officeBasicInfo']/ul/li[1]//table[1]//tbody/tr"));
        hmap.put("legalEntity_statistics_label_xpath",By.xpath(".//*[@id='content']//h1/span[text()='Statistics']"));
        hmap.put("office_basicInfo_edit_prefix_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitlePrefix']"));
        hmap.put("office_basicInfo_edit_suffix_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitleSuffix']"));
        hmap.put("office_basicInfo_edit_override_xpath", By.xpath("//*[@id='officeBasicInfo']//input[@name='officeTitleOverride']"));
        hmap.put("office_basicInfo_view_prefix_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Prefix']/td"));
        hmap.put("office_basicInfo_view_suffix_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Suffix']/td"));
        hmap.put("office_basicInfo_view_override_xpath", By.xpath("//*[@id='officeBasicInfo']//tr[th='Override']/td"));
        // personnel
        hmap.put("office_add_new_personnel_button_id", By.id("add-personnel"));
        hmap.put("office_personnel_type_input_xpath", By.xpath(".//*[@id='additionalPersonnel']//*[@data-internal_id='personnelType']"));
        hmap.put("office_personnel_value_input_xpath", By.xpath(".//*[@id='additionalPersonnel']//*[@data-internal_id='personnelValue']"));
        hmap.put("office_delete_personnel_row_button_xpath", By.xpath(".//*[@data-row_id='personnel']//button[@class='delete-row']"));
        hmap.put("office_personnel_type_view_mode", By.xpath("//*[@id='officePersonnel']//tbody/tr"));
        hmap.put("office_AdditionalPersonnel", By.xpath("#additionalPersonnel"));
        hmap.put("office_personnel_type_error_msg_xpath", By.xpath(("//*[@id='additionalPersonnel']//*[@data-error_id='personnelTypeError']")));
		hmap.put("office_personnel_value_error_msg_xpath", By.xpath(("//*[@id='additionalPersonnel']//*[@data-error_id='personnelValueError']")));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}