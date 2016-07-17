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
        hmap.put("office_name_type_first_row_existing_office_name_value",By.xpath("//*[@id='additionalNames']//input[@name='fixedName']"));
        hmap.put("office_name_second_row_existing_office_type_dropdown",By.xpath(".//*[@id='additionalNames']//select[@name='nameType']"));
        hmap.put("office_name_second_row_existing_office_value",By.xpath(".//*[@id='additionalNames']//input[@data-internal_id='nameValue']"));
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
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}