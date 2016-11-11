package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class FinancialsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("financialStatement_period_EndDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//ul[@id='periodEnd']/li")));
        hmap.put("view_financial_missing_item_table", By.xpath("//*[@id='subEntityList-list']//tbody/tr"));
        hmap.put("financialStatement_missingItem_alternateStatement_link_xpath", By.xpath("//*[@id='subEntityList-list']//td[3]/a"));
        hmap.put("financialStatement_missingItem_entity_link_xpath", By.xpath("//*[@id='subEntityList-list']//td[2]/a"));
        hmap.put("legalEntity_basicInfo_link", By.xpath("//*[@id='legalEntityBasicInfo']"));
        hmap.put("legalEntity_basicInfo_label", By.xpath("//*[@id='legalEntityBasicInfo']/h1/span"));
        hmap.put("alternateEntity_text_value",  By.xpath("//*[@id='cssTempFixId']/header/div/a"));
        hmap.put("financial_missing_item_statement_header", By.xpath("//*[@id='subEntityList-list']/div/h1/span"));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
