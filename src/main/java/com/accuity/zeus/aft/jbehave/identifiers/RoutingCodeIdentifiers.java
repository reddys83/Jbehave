package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by pinintir on 6/23/2016.
 */
public class RoutingCodeIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {

        hmap.put("routingcodes_rows_xpath", By.xpath("//*[@id='searchEntityList-list']//tbody//tr"));
        hmap.put("routingcode_basicInfo_link", By.xpath("//*[@id='routingCodeBasicInfo']"));
        hmap.put("routingcode_basicInfo_label", By.xpath("//*[@id='routingCodeBasicInfo']/h1/span"));
        hmap.put("routingcode_basicInfo_view_RoutingCodeType", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Type']/td"));
        hmap.put("routingcode_basicInfo_view_RoutingCodeTypeDescription", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Type Description']/td"));
        hmap.put("routingcode_basicInfo_view_ RoutingCodeSubtype", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Subtype']/td"));
        hmap.put("routingcode_basicInfo_view_ABACodeSource", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='ABA Code Source']/td"));
        hmap.put("routingcode_basicInfo_view_RoutingCode", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code']/td"));
        hmap.put("routingcode_basicInfo_view_RoutingCodeCheckDigit", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Check Digit']/td"));
       // hmap.put("routingcode_basicInfo_view_AlternateCodeFormType", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Type']/td"));
        hmap.put("routingcode_basicInfo_view_AlternateCodeForm", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Alternate Code Form']/td/span"));
        hmap.put("routingcode_basicInfo_view_Status", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Status']/td"));
        hmap.put("routingcode_basicInfo_view_AccountEligibility", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Account Eligibility']/td"));
        hmap.put("routingcode_basicInfo_view_StartDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td"));
        hmap.put("routingcode_basicInfo_view_EndDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td"));
        hmap.put("routingcode_basicInfo_view_ForthcomingRetirementDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td"));
        hmap.put("routingcode_basicInfo_view_ConfirmedwithFed", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td"));
        hmap.put("routingcode_basicInfo_view_AssignedInstitutionName", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Assigned Institution Name']/td"));
        hmap.put("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']/td"));
        hmap.put("routingcode_basicInfo_view_InternalUseOnly",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Internal Use Only']/td"));
        hmap.put("routingcode_basicInfo_view_String UseHeadOffice",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Use Head Office']/td"));
        hmap.put("routingcode_basicInfo_view_String Comment",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']/td"));
        hmap.put("routingcode_page_header_link",By.xpath(".//*[@id='cssTempFixId']/header//a"));
        hmap.put("routingCode_usages_link", By.xpath(".//*[@id='data-side-navbar']//li[@id='routingCodeUsages']"));
        hmap.put("routingCode_usages_header_text", By.xpath(".//*[@id='routingCodeUsages']//thead/tr"));
        hmap.put("routingCode_usages_name_column_header_xpath", By.xpath(".//*[@id='routingCodeUsages']//thead//th[3]"));
        hmap.put("routingCode_usages_city_column_header_xpath", By.xpath(".//*[@id='routingCodeUsages']//thead//th[4]"));
        hmap.put("routingCode_usages_area_column_header_xpath", By.xpath(".//*[@id='routingCodeUsages']//thead//th[5]"));
        hmap.put("routingCode_owning_usages_name_column_xpath", By.xpath(".//*[@id='usages']/tr[td='true']/td[3]"));
        hmap.put("routingCode_owning_usages_city_column_xpath", By.xpath(".//*[@id='usages']/tr[td='true']/td[4]"));
        hmap.put("routingCode_owning_usages_area_column_xpath", By.xpath(".//*[@id='usages']/tr[td='true']/td[5]"));
        hmap.put("routingCode_NotOwing_usages_name_column_xpath", By.xpath(".//*[@id='usages']/tr[not(td='true')]/td[3]"));
        hmap.put("routingCode_NotOwing_usages_city_column_xpath", By.xpath(".//*[@id='usages']/tr[not(td='true')]/td[4]"));
        hmap.put("routingCode_NotOwing_usages_area_column_xpath", By.xpath(".//*[@id='usages']/tr[not(td='true')]/td[5]"));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}