package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class FinancialsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("financialStatement_period_EndDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//ul[@id='periodEnd']/li")));
        hmap.put("view_financial_missing_item_table", By.xpath("//*[@id='subEntityList-list']//tbody/tr"));
        hmap.put("financialStatement_missingItem_alternateStatement_link_xpath", By.xpath(""));
        hmap.put("financialStatement_missingItem_entity_link_xpath", By.xpath(""));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
