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
        hmap.put("office_basicInfo_openedDate_view_xpath",By.xpath("//table[@class='vertical']/tbody/tr[5]/td"));
        hmap.put("office_basicInfo_openedDate_day_xpath", By.xpath("//table[@class='vertical']/tbody/tr[5]/td/input[1]"));
        hmap.put("office_basicInfo_openedDate_month_xpath", By.xpath("//table[@class='vertical']/tbody/tr[5]/td/select"));
        hmap.put("office_basicInfo_openedDate_year_xpath", By.xpath("//table[@class='vertical']/tbody/tr[5]/td/input[2]"));
        hmap.put("office_basicInfo_openedDate_errorMessage_xpath",By.xpath("//*[@data-error_id='openedDateError']"));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}