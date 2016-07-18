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
        hmap.put("first_existing_officetype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[1]/td[1]/select")));
        hmap.put("second_existing_officetype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("office_basicInfo_officetypes_dropdown_xpath",By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr/td/select[@id='officeType' or @id='fixedofficeType']"));
        hmap.put("office_basicInfo_add_new_officetype_button_id",By.id("add-types"));
        hmap.put("first_new_officetype_dropdown", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='officeType']"));
        hmap.put("second_row_existing_officetype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("first_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[1]/td[@class='delete']/button"));
        hmap.put("second_row_existing_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[2]/td[@class='delete']/button"));
        hmap.put("first_new_row_officetype_delete_button", By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td[@class='delete']/button"));
        hmap.put("office_basicInfo_officetypes_delete_button_xpath",By.xpath("//*[@id='officeBasicInfo']//table/tbody[@id='additionalTypes']/tr/td[@class='delete']/button"));
        hmap.put("delete_confirmation_yes_button_id",By.id("yes-button"));
        hmap.put("office_office_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='fixedofficeTypeError']"));

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}