package com.accuity.zeus.aft.jbehave.identifiers;


import org.openqa.selenium.By;

import java.util.HashMap;

public class FinancialsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("financialStatement_period_EndDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//ul[@id='periodEnd']/li")));
        hmap.put("financialStatement_default_selected_endDate_xpath", By.xpath(".//*[@id='results']//ul[@id='periodEnd']/li[@class='selected']"));
        hmap.put("financialStatement_financials_heading_xpath",By.xpath(("")));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
