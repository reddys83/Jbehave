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
        hmap.put("edit_routingcode_page_add_alternateCode_btn",By.xpath("//*[@id='add-alternateCodes']"));
        hmap.put("edit_routingcode_page_new_delete_alternateCode_btn",By.xpath("//*[@id='additionalAlternateCodes']/tr[@class='new']/td[@class='delete']"));
        hmap.put("edit_routingcode_page_alternateCode_table",By.xpath("//*[@id='additionalAlternateCodes']/tr"));
        hmap.put("edit_routingcode_page_routingcode_subtype_dropdown",By.xpath("//*[@id='routingCodeSubtype']"));
        hmap.put("edit_routingcode_page_ABA_CodeSource_dropdown",By.xpath("//*[@id='routingCodeSource']"));
        hmap.put("edit_routingcode_accountEligibility_radio",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Account Eligibility']//input"));
        hmap.put("edit_routingcode_internalUseOnly_radio",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Internal Use Only']//input"));
        hmap.put("edit_routingcode_useHeadOffice_radio",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Use Head Office']//input"));
        hmap.put("edit_routingcode_page_startDateDay",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/input[@name='validFrom-day']"));
        hmap.put("edit_routingcode_page_startDateMonth",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/select[@name='validFrom-month']"));
        hmap.put("edit_routingcode_page_startDateYear",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/input[@name='validFrom-year']"));
        hmap.put("edit_routingcode_page_endDateDay",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/input[@name='validTo-day']"));
        hmap.put("edit_routingcode_page_endDateMonth",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/select[@name='validTo-month']"));
        hmap.put("edit_routingcode_page_endDateYear",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/input[@name='validTo-year']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateDay",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/input[@name='retireAt-day']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateMonth",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/select[@name='retireAt-month']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateYear",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/input[@name='retireAt-year']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateDay",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/input[@name='confirmedDate-day']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateMonth",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/select[@name='confirmedDate-month']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateYear",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/input[@name='confirmedDate-year']"));
        hmap.put("edit_routingcode_page_RegistrarFeeSFDCSubscription",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']//input"));
        hmap.put("edit_routingcode_registarFeeSFDCSubscription_text_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//input[@name='subscriptionNumber']")));  
        hmap.put("edit_routingcode_routingCodeComment_text_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//textarea[@name='routingCodeComment']")));
        hmap.put("edit_routingcode_registarFeeSFDCSubscription_afterSave_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']/td")));  
        hmap.put("edit_routingcode_routingCodeComment_afterSave_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']/td")));
        hmap.put("routingcode_navigation_link", By.xpath("//*[@id='routingCodeFormerUsages']"));
        hmap.put("exact_match_link", By.xpath("//*[@id='searchType-exact']"));
        hmap.put("view_routingcode_name_col_xpath", By.xpath("//*[@id='routingCodeFormerUsages']/table/thead/tr/th[1]"));
        hmap.put("view_routingcode_city_col_xpath", By.xpath("//*[@id='routingCodeFormerUsages']/table/thead/tr/th[2]"));
        hmap.put("view_routingcode_area_col_xpath", By.xpath("//*[@id='routingCodeFormerUsages']/table/thead/tr/th[3]"));
        hmap.put("view_routingcode_additional_info_col_xpath", By.xpath("//*[@id='routingCodeFormerUsages']/table/thead/tr/th[4]"));
    }
    
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}