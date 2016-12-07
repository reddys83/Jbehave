package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by tubatil on 10/31/2016.
 */
public class FinancialsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("financialStatement_period_EndDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//ul[@id='periodEnd']/li")));
        hmap.put("financialStatement_default_selected_endDate_xpath", By.xpath(".//*[@id='results']//*[@id='periodEnd']/*[@class='selected']"));
        hmap.put("financialStatement_period_endDate_leftSideMenu_xpath", By.xpath((".//*[@id='results']//*[@id='periodEnd']/li")));
        hmap.put("financialStatement_financials_heading_xpath",By.xpath(("//*[@id='financialStatementFinancials']/h1")));
        hmap.put("financialStatement_financials_statementType",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Financial Statement Type']/td")));
        hmap.put("financialStatement_financials_startDate",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Period Start Date']/td")));
        hmap.put("financialStatement_financials_endDate",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Reporting Period End Date']/td")));
        hmap.put("financialStatement_financials_yearEnd",By.xpath((".//*[@id='results']//*//tr[th='Reporting Period Financial Year End']/td")));
        hmap.put("financialStatement_financials_currency",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Statement Currency']/td")));
        hmap.put("financialStatement_financials_orderOfMagnitude",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Order of Magnitude']/td")));
        hmap.put("financialStatement_financials_consolidated",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Consolidated']/td")));
        hmap.put("financialStatement_financials_accountingStandards",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Accounting Standards']/td")));
        hmap.put("financialStatement_financials_audited",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Audited']/td")));
        hmap.put("financialStatement_financials_auditedBy",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Audited by']/td")));
        hmap.put("financialStatement_financials_documentPhysical",By.xpath((".//*[@id='results']//*['side-navbar-layout']//tr[th='Document (Physical)']/td")));
        hmap.put("financialStatement_financials_exchangeRate_From",By.xpath((".//*[@id='results']//h2[contains(text(), 'Exchange Rate at Period End')]/following-sibling::table//td[1]")));
        hmap.put("financialStatement_financials_exchangeRate_To",By.xpath((".//*[@id='results']//h2[contains(text(), 'Exchange Rate at Period End')]/following-sibling::table//td[2]")));
        hmap.put("financialStatement_financials_exchangeRate_Value",By.xpath((".//*[@id='results']//h2[contains(text(), 'Exchange Rate at Period End')]/following-sibling::table//td[3]")));
        hmap.put("financial_missing_item_table", By.xpath("//*[@id='financialStatementMissing']//tbody/tr"));
        hmap.put("financialStatement_missingItem_alternateStatement_link", By.xpath("//*[@id='financialStatementMissing']//span[contains(text(), 'Missing')]/../following-sibling::table//tr[1]/td[3]"));
        hmap.put("financialStatement_missingItem_entity_link", By.xpath("//*[@id='financialStatementMissing']//span[contains(text(), 'Missing')]/../following-sibling::table//tr[1]//a[1]"));
        hmap.put("legalEntity_basicInfo_link", By.xpath("//*[@id='legalEntityBasicInfo']"));
        hmap.put("legalEntity_basicInfo_label", By.xpath("//*[@id='legalEntityBasicInfo']/h1"));
        hmap.put("alternateEntity_text_value",  By.xpath("//*[@class='data-header-internal']//a[@class='entity']"));
        hmap.put("financial_missing_item_statement_header", By.xpath("//*[@id='financialStatementMissing']//span[contains(text(), 'Missing')]"));
        hmap.put("view_financial_line_item_table", By.xpath("//*[@id='financialStatementLineItems']//tbody/tr"));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}