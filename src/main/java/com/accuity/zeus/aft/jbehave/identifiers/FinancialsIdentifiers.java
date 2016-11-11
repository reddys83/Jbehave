package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class FinancialsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("financialStatement_period_endDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//*[@id='periodEnd']/li")));
        hmap.put("financial_missing_item_table", By.xpath("//*[@id='subEntityList-list']//tbody/tr"));
        hmap.put("financialStatement_missingItem_alternateStatement_link", By.xpath("//*[@id='subEntityList-list']//span[contains(text(), 'Missing')]/../following-sibling::table//tr[1]//a[2]"));
        hmap.put("financialStatement_missingItem_entity_link", By.xpath("//*[@id='subEntityList-list']//span[contains(text(), 'Missing')]/../following-sibling::table//tr[1]//a[1]"));
        hmap.put("legalEntity_basicInfo_link", By.xpath("//*[@id='legalEntityBasicInfo']"));
        hmap.put("legalEntity_basicInfo_label", By.xpath("//*[@id='legalEntityBasicInfo']/h1"));
        hmap.put("alternateEntity_text_value",  By.xpath("//*[@class='data-header-internal']//a[@class='entity']"));
        hmap.put("financial_missing_item_statement_header", By.xpath("//*[@id='subEntityList-list']//span[contains(text(), 'Missing')]"));
        hmap.put("financialStatement_financials_heading_xpath",By.xpath((".//*[@id='results']//*[@class='side-navbar-layout']/h1")));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
