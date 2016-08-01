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
        hmap.put("office_location_addRow_id",By.id("add-location"));
        hmap.put("office_first_row_existing_location_add_button", By.id("add-location"));
        hmap.put("office_first_existing_row_location_delete_button",By.id("delete-location"));
        hmap.put("office_first_new_row_location_delete_button",By.id("delete-location"));
        hmap.put("",By.xpath(".//*[@id='officeLocations']/div[1]/h1"));
        hmap.put("office_location_primaryoffice_location_delete_row_edit_mode_flag_radio_options", By.xpath("//*[@id='locationDiv']//input[@name='primaryLocation-1']"));
        hmap.put("office_address_addRow_id", By.xpath(".//*[@id='add-locationAddresses-0']"));
        //hmap.put("office_address_addRow_id", By.xpath("//*[@id='locationDiv']//button[@class='addRowButton addAddress']"));
        hmap.put("office_addressType_first_row_new_address_type_dropdown", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//select[@id='addressType-0']"));
        hmap.put("office_address_first_row_new_addressLine1", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//input[@name='addrLine1']"));
        hmap.put("office_address_first_row_new_addressLine2", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//input[@name='addrLine2']"));
        hmap.put("office_address_first_row_new_addressLine3", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//input[@name='addrLine3']"));
        hmap.put("office_address_first_row_new_addressLine4", By.xpath(".//*[@id='locationDiv']//li[@class='address new']//input[@name='addrLine4']"));
        hmap.put("office_address_country_type_ahead_xpath", By.xpath(".//*[@id='addrcountry-0']/td/div/a/span"));
        hmap.put("office_area_dropdown_list_xpath", By.xpath(".//*[@id='addrarea-0']/td/div/a/div/b"));
        hmap.put("office_area_dropdown_typeAhead_xpath", By.xpath(".//*[@id='addrarea-0']/td/div/a/span"));
        hmap.put("office_subarea_dropdown_list_xpath", By.xpath(".//*[@id='addrsubarea-0']/td/div/a/div/b"));
        hmap.put("office_subarea_dropdown_typeAhead_xpath", By.xpath(".//*[@id='addrsubarea-0']/td/div/a/span"));
        hmap.put("office_city_dropdown_list_xpath", By.xpath(".//*[@id='addrcity-0']/td/div/a/div/b"));
        hmap.put("office_address_first_row_new_postalCode", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrPostCode']"));
        hmap.put("office_address_first_row_new_postalCodeSuffix", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrPostCodeSuffix']"));
        hmap.put("office_address_first_row_new_info", By.xpath(".//*[@id='additionalLocationAddresses-0']//li[@class='address new']//input[@name='addrInfo']"));
        hmap.put("office_first_new_row_address_delete_button", By.xpath(".//*[@id='additionalLocationAddresses-0']/li/div/button"));
        hmap.put("office_address_delete_row_view",By.xpath(".//*[@id='officeLocations']/div/h2[1]"));
        hmap.put("office_telecoms_addRow_id", By.id("add-locationTelecomms-0"));
        hmap.put("office_telecomsType_first_row_new_telecoms_type_dropdown", By.xpath(".//*[@id='locationDiv']//select[@id='telecommType-0']"));
        hmap.put("office_telecoms_first_row_new_rank", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommRank']"));
        hmap.put("office_telecoms_first_row_new_textBefore", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommTextBefore']"));
        hmap.put("office_telecoms_first_row_new_value", By.xpath(".//*[@id='additionalLocationTelecomms-0']//td[4]//input"));
        hmap.put("office_telecoms_first_row_new_rangeLimit", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommRange']"));
        hmap.put("office_telecoms_first_row_new_ext", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommExt']"));
        hmap.put("office_telecoms_first_row_new_textAfter", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommTextAfter']"));
        hmap.put("office_telecoms_first_row_new_answerBack", By.xpath(".//*[@id='additionalLocationTelecomms-0']//input[@name='telecommAnswerBack']"));
        hmap.put("office_telecoms_delete_row_view",By.xpath(".//*[@id='officeLocations']/div/h2[2]"));
        hmap.put("office_first_new_row_telecoms_delete_button", By.xpath(".//*[@id='additionalLocationTelecomms-0']/tr[@class='new']//button[@class='delete-row']"));

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}