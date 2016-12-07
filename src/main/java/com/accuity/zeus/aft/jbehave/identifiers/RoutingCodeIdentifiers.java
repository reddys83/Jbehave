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
        hmap.put("routingcode_basicInfo_view_RoutingCodeSubtype", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Subtype']/td"));
        hmap.put("routingcode_basicInfo_view_ABACodeSource", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='ABA Code Source']/td"));
        hmap.put("routingcode_basicInfo_view_RoutingCode", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code']/td"));
        hmap.put("routingcode_basicInfo_view_RoutingCodeCheckDigit", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Check Digit']/td"));
        hmap.put("routingcode_basicInfo_view_AlternateCodeForm", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Alternate Code Form']/td/span"));
        hmap.put("routingcode_basicInfo_view_Status", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Status']/td"));
        hmap.put("routingcode_basicInfo_view_AccountEligibility", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Account Eligibility']/td"));
        hmap.put("routingcode_basicInfo_view_StartDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td"));
        hmap.put("routingcode_basicInfo_view_EndDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td"));
        hmap.put("routingcode_basicInfo_view_ForthcomingRetirementDate", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td"));
        hmap.put("routingcode_basicInfo_view_ConfirmedwithFed", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td"));
        hmap.put("routingcode_basicInfo_view_AssignedInstitutionName", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Assigned Institution Name']/td"));
        hmap.put("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']/td"));
        hmap.put("routingcode_basicInfo_view_InternalUseOnly", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Internal Use Only']/td"));
        hmap.put("routingcode_basicInfo_view_UseHeadOffice", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Use Head Office']/td"));
        hmap.put("routingcode_basicInfo_view_Comment", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']/td"));
        hmap.put("routingcode_page_header_link", By.xpath(".//*[@id='cssTempFixId']/header//a"));
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
        hmap.put("edit_routingcode_page_add_alternateCode_btn", By.xpath("//*[@id='add-alternateCodes']"));
        hmap.put("edit_routingcode_page_new_delete_alternateCode_btn", By.xpath("//*[@id='additionalAlternateCodes']/tr[@class='new']/td[@class='delete']"));
        hmap.put("edit_routingcode_page_alternateCode_table", By.xpath("//*[@id='additionalAlternateCodes']/tr"));
        hmap.put("edit_routingcode_page_routingcode_subtype_dropdown", By.xpath("//*[@id='routingCodeSubtype']"));
        hmap.put("edit_routingcode_page_ABA_CodeSource_dropdown", By.xpath("//*[@id='routingCodeSource']"));
        hmap.put("edit_routingcode_accountEligibility_radio", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Account Eligibility']//input"));
        hmap.put("edit_routingcode_internalUseOnly_radio", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Internal Use Only']//input"));
        hmap.put("edit_routingcode_useHeadOffice_radio", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Use Head Office']//input"));
        hmap.put("edit_routingcode_page_startDateDay", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/input[@name='validFrom-day']"));
        hmap.put("edit_routingcode_page_startDateMonth", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/select[@name='validFrom-month']"));
        hmap.put("edit_routingcode_page_startDateYear", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Start Date']/td/input[@name='validFrom-year']"));
        hmap.put("edit_routingcode_page_endDateDay", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/input[@name='validTo-day']"));
        hmap.put("edit_routingcode_page_endDateMonth", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/select[@name='validTo-month']"));
        hmap.put("edit_routingcode_page_endDateYear", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='End Date']/td/input[@name='validTo-year']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateDay", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/input[@name='retireAt-day']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateMonth", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/select[@name='retireAt-month']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDateYear", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Forthcoming Retirement Date']/td/input[@name='retireAt-year']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateDay", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/input[@name='confirmedDate-day']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateMonth", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/select[@name='confirmedDate-month']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDateYear", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Confirmed with Fed']/td/input[@name='confirmedDate-year']"));
        hmap.put("edit_routingcode_page_RegistrarFeeSFDCSubscription", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']//input"));
        hmap.put("edit_routingcode_registarFeeSFDCSubscription_text_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//input[@name='subscriptionNumber']")));
        hmap.put("edit_routingcode_routingCodeComment_text_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//textarea[@name='routingCodeComment']")));
        hmap.put("edit_routingcode_registarFeeSFDCSubscription_afterSave_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//tr[th='Registrar Fee SFDC Subscription']/td")));
        hmap.put("edit_routingcode_routingCodeComment_afterSave_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']/td")));
        hmap.put("edit_routingcode_page_StartDate_errorMessage", By.xpath("//*[@data-error_id='validFromError']"));
        hmap.put("edit_routingcode_page_EndDate_errorMessage", By.xpath("//*[@data-error_id='validToError']"));
        hmap.put("edit_routingcode_page_ForthcomingRetirementDate_errorMessage", By.xpath("//*[@data-error_id='retireAtError']"));
        hmap.put("edit_routingcode_page_ConfirmedWithFedDate_errorMessage", By.xpath("//*[@data-error_id='confirmedDateError']"));
        hmap.put("edit_routingcode_routingCodeComment_afterSave_xpath", By.xpath(("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']/td")));
        hmap.put("routingcode_former_usages_navigation_link", By.xpath("//*[@id='routingCodeFormerUsages']"));
        hmap.put("view_routingcode_name_col", By.xpath("//*[@id='routingCodeFormerUsages']//th[@sortfield='departmentName,officeName']"));
        hmap.put("view_routingcode_city_col", By.xpath("//*[@id='routingCodeFormerUsages']//th[@sortfield='cityName']"));
        hmap.put("view_routingcode_area_col", By.xpath("//*[@id='routingCodeFormerUsages']//th[@sortfield='areaName']"));
        hmap.put("view_routingcode_additional_info_col", By.xpath("//*[@id='routingCodeFormerUsages']//*[contains(text(),'Additional Info')]"));
        hmap.put("view_routingcode_name_list", By.xpath("//*[@id='formerUsages']//td[1]"));
        hmap.put("view_routingcode_city_list", By.xpath("//*[@id='formerUsages']//td[2]"));
        hmap.put("view_routingcode_area_list", By.xpath("//*[@id='formerUsages']//td[3]"));
        hmap.put("view_routingcode_additional_info_list", By.xpath("//*[@id='formerUsages']//td[4]"));
        hmap.put("view_routingcode_first_office_name_link", By.xpath("//*[@id='formerUsages']/tr[1]//*[@href]"));
        hmap.put("officename_basicInfo_link", By.xpath("//*[@id='officeBasicInfo']"));
        hmap.put("officename_basicInfo_label", By.xpath("//*[@id='officeBasicInfo']/h1/span"));
        hmap.put("officename_text_value", By.xpath("//*[@id='officeBasicInfo']//tr[td='Office Name']/td[2]"));

        hmap.put("routingCode_relatedCodes_link", By.id("routingCodeRelatedCodes"));
        hmap.put("routingCode_relatedCodes_context", By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr[1]/td[1]"));
        hmap.put("routingCode_relatedCodes_header", By.xpath(".//*[@id='routingCodeRelatedCodes']//span"));
        hmap.put("routingCode_relatedCodes_context_header", By.xpath(".//*[@id='routingCodeRelatedCodes']//thead//th[1]"));
        hmap.put("routingCode_relatedCodes_code_header", By.xpath(".//*[@id='routingCodeRelatedCodes']//thead//th[2]"));
        hmap.put("routingCode_relatedCodes_type_header", By.xpath(".//*[@id='routingCodeRelatedCodes']//thead//th[3]"));
        hmap.put("edit_routingcode_page_RoutingCodeComment", By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']//input"));
        hmap.put("routingcode_page_paymentsystems_link", By.xpath("//*[@id='routingCodePaymentSystems'][text()='Payment Systems']"));
        hmap.put("paymentsystems_productName", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']/h3"));
        hmap.put("paymentsystems_dateJoined", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Date Joined']/td"));
        hmap.put("paymentsystems_alternateFormType", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Alternate Form Type']/td"));
        hmap.put("paymentsystems_membershipType", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Membership Type']/td"));
        hmap.put("paymentsystems_systemActivityStatus", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='System Activity Status']/td"));
        hmap.put("paymentsystems_routeVia", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Route Via']/td"));
        hmap.put("paymentsystems_dateLeft", By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Date Left']/td"));
        hmap.put("paymentsystems_correspondents", By.xpath("//*[@id='routingCodePaymentSystems']//li[@class='correspondent']//tbody[//th='Code']"));
        hmap.put("paymentsystems_attributes", By.xpath("//*[@id='routingCodePaymentSystems']//li[h2='Payment System Attributes']//tbody"));
        hmap.put("paymentsystems_contactLocations", By.xpath("//*[@id='routingCodePaymentSystems']//div[@class='payment-system']/table//tbody"));

        hmap.put("routingCode_relatedCodes_code_header",By.xpath(".//*[@id='routingCodeRelatedCodes']//thead//th[2]"));
        hmap.put("routingCode_relatedCodes_type_header",By.xpath(".//*[@id='routingCodeRelatedCodes']//thead//th[3]"));

        hmap.put("edit_routingcode_page_RoutingCodeComment",By.xpath("//*[@id='routingCodeBasicInfo']//tr[th='Routing Code Comment']//input"));
        hmap.put("routingcode_page_paymentsystems_link",By.xpath("//*[@id='routingCodePaymentSystems'][text()='Payment Systems']"));
        hmap.put("paymentsystems_productName",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']/h3"));
        hmap.put("paymentsystems_dateJoined",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Date Joined']/td"));
        hmap.put("paymentsystems_alternateFormType",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Alternate Form Type']/td"));
        hmap.put("paymentsystems_membershipType",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Membership Type']/td"));
        hmap.put("paymentsystems_systemActivityStatus",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='System Activity Status']/td"));
        hmap.put("paymentsystems_routeVia",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Route Via']/td"));
        hmap.put("paymentsystems_dateLeft",By.xpath("//*[@id='routingCodePaymentSystems']/div[@class='payment-system']//tr[th='Date Left']/td"));
        hmap.put("paymentsystems_correspondents",By.xpath("//*[@id='routingCodePaymentSystems']//li[@class='correspondent']//tbody[//th='Code']"));
        hmap.put("paymentsystems_attributes",By.xpath("//*[@id='routingCodePaymentSystems']//li[h2='Payment System Attributes']//tbody"));
        hmap.put("paymentsystems_contactLocations",By.xpath("//*[@id='routingCodePaymentSystems']//div[@class='payment-system']/table//tbody"));
        hmap.put("routingcode_all_link", By.xpath("//*[@id='all']"));
        hmap.put("routingcode_payment_systems_link", By.xpath("//*[@id='routingCodePaymentSystems']"));
        hmap.put("routingcode_related_codes_link", By.xpath("//*[@id='routingCodeRelatedCodes']"));
        hmap.put("routingcode_usages_link", By.xpath("//*[@id='routingCodeUsages']"));
        hmap.put("routingcode_former_usages_link", By.xpath("//*[@id='routingCodeFormerUsages']"));
        hmap.put("routingcode_history_link", By.xpath("//*[@id='routingCodeHistory']"));
        hmap.put("routingcode_office_fid_search_results", By.xpath("//*[@id='searchEntityList-list']//tbody//td[4]/*[@href]"));

        hmap.put("view_routingCodeSearchEntityPlaceHolder_xpath", By.xpath("//input[@placeholder='Enter at least 2 valid characters']"));
        hmap.put("view_routingCodeSearchTypeAheadBox_xpath", By.xpath("//*[@id='search']"));
        hmap.put("routingCodeResultsHeader_view_mode", By.xpath("//div[@id='contentSummary']//*[@class='search-results']"));
        hmap.put("view_routingCodeSearchEntityPlaceHolder_xpath", By.xpath("//input[@placeholder='Enter at least 2 valid characters']"));
        hmap.put("view_routingCodeSearchTypeAheadBox_xpath", By.xpath("//*[@id='search']"));
        hmap.put("routingCodeResultsHeader_view_mode", By.xpath("//div[@id='contentSummary']//*[@class='search-results']"));
        hmap.put("view_routingcode_history_type_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Type')]"));
        hmap.put("routingcode_history_navigation_link", By.xpath("//*[@id='routingCodeHistory']"));
        hmap.put("view_routingcode_history_date_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Date')]"));
        hmap.put("view_routingcode_history_description_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Description')]"));
        hmap.put("view_routingcode_history_replacedbycode_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Replaced by Code')]"));
        hmap.put("view_routingcode_history_details_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Details')]"));
        hmap.put("routingcode_history_eye_icon", By.xpath("//*[@id='history']//*[@class='show']"));
        hmap.put("view_routingcode_history_usage_name_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Name')]"));
        hmap.put("view_routingcode_history_usage_address_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Address')]"));
        hmap.put("view_routingcode_history_usage_city_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'City')]"));
        hmap.put("view_routingcode_history_usage_area_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Area')]"));
        hmap.put("view_routingcode_history_usage_subarea_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Sub Area')]"));
        hmap.put("view_routingcode_history_usage_country_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Country')]"));
        hmap.put("view_routingcode_date_list", By.xpath("//*[@id='history']//td[2]"));
        hmap.put("view_routing_code_history_details_N/A", By.xpath("//*[@id='history']//td[contains(text(), 'N/A')]"));
        hmap.put("view_routingcode_history_usage_postalcode_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Postal Code')]"));
        hmap.put("view_routingcode_history_usage_addinfo_col", By.xpath("//*[@id='routingCodeHistory']//*[contains(text(),'Additional Info')]"));
        hmap.put("view_history_event_table", By.xpath("//*[@id='routingCodeHistory']//tr"));
        hmap.put("view_history_usage_table", By.xpath("//*[@id='routingCodeHistory']//div[@class='container']//tbody//tr"));
        hmap.put("edit_former_usages_name_list", By.xpath("//*[@data-row_id='formerUsages']//td[1]"));
        hmap.put("edit_former_usages_city_list", By.xpath("//*[@data-row_id='formerUsages']//td[2]"));
        hmap.put("edit_former_usages_area_list", By.xpath("//*[@data-row_id='formerUsages']//td[3]"));
        hmap.put("edit_former_usages_additional_info_list", By.xpath("//*[@data-row_id='formerUsages']//td[4]"));
        hmap.put("edit_former_usages_name_col", By.xpath("//*[@data-edit_id='formerUsages']//th[@sortfield='departmentName,officeName']"));
        hmap.put("edit_former_usages_city_col", By.xpath("//*[@data-edit_id='formerUsages']//th[@sortfield='cityName']"));
        hmap.put("edit_former_usages_area_col", By.xpath("//*[@data-edit_id='formerUsages']//th[@sortfield='areaName']"));
        hmap.put("edit_former_usages_additional_info_col", By.xpath("//*[@data-edit_id='formerUsages']//*[contains(text(),'Additional Info')]"));
        hmap.put("edit_former_usages_add_button", By.xpath("//*[@data-edit_id='formerUsages']//*[starts-with(@class,'add')]"));
        hmap.put("edit_former_usages_hyperlink", By.xpath("//*[@data-row_id='formerUsages']//*[@href]"));
        hmap.put("edit_former_usages_delete_row_button", By.xpath("//*[@data-row_id='formerUsages']//*[@class='delete-element']"));
        hmap.put("edit_former_usages_row", By.xpath("//*[@id='formerUsages']//*[@data-row_id='formerUsages']"));
        hmap.put("view_former_usages_row", By.xpath("//*[@id='formerUsages']//tr"));

        hmap.put("edit_routingcode_existing_alternate_code_type",By.xpath("//*[@id='additionalAlternateCodes']/tr[1]//select[@id='alternateCodeType']"));
        hmap.put("edit_routingcode_existing_alternate_code_value",By.xpath("//*[@id='additionalAlternateCodes']/tr[1]//input[@name='alternateCodeValue']"));
        hmap.put("edit_routingcode_new_alternate_code_type",By.xpath("//*[@id='additionalAlternateCodes']/tr[@class='new']//select[@id='alternateCodeType']"));
        hmap.put("edit_routingcode_new_alternate_code_value",By.xpath("//*[@id='additionalAlternateCodes']/tr[@class='new']//input"));
        hmap.put("edit_routingcode_add_new_alternate_code",By.xpath("//*[@id='add-alternateCodes']"));
        hmap.put("edit_routingcode_delete_first_row_alternate_code",By.xpath("//*[@id='additionalAlternateCodes']/tr[1]//button"));
        hmap.put("edit_routingcode_delete_second_row_alternate_code",By.xpath("//*[@id='additionalAlternateCodes']/tr[2]//button"));
        hmap.put("edit_routingCode_delete_yes_button_id_click", By.xpath("//*[@id='yes-button']"));
        hmap.put("edit_routingcode_alternate_code_type",By.xpath("//*[@id='alternateCodeType']"));
        hmap.put("edit_routingcode_alternate_code_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='alternateCodeTypeError']"));
        hmap.put("edit_routingcode_alternate_code_value_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='alternateCodeValueError']"));
        hmap.put("edit_routingcode_page_add_new_relatedcodes_btn", By.xpath("//*[@id='add-relatedCodes']"));
        hmap.put("edit_routingcode_page_relatedcodes_context_dropdown", By.xpath("//*[@id='additionalRelatedCodes']/tr//select[@id='relatedCodeContext']"));
        hmap.put("edit_routingcode_page_new_relatedcodes_context_dropdown", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//select[@id='relatedCodeContext']"));
        hmap.put("edit_routingcode_page_new_relatedcodes_chosen_Select_input", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//div[@class='chosen-search']/input"));
        hmap.put("edit_routingcode_page_new_relatedcodes_chosen_Select_options", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//select[@id='relatedCode']/option"));
        hmap.put("edit_routingcode_page_new_relatedcodes_chosen_Select_dropdown", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//div[@id='relatedCode_chosen']//ul/li"));
        hmap.put("edit_routingcode_page_new_relatedcodes_chosen_Select_link", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//div[@id='relatedCode_chosen']/a"));
        hmap.put("edit_routingcode_page_new_relatedcodes_type", By.xpath("//*[@id='additionalRelatedCodes']/tr[@class='new']//input[@id='relatedCodeType']"));
        hmap.put("first_row_existing_related_codes_delete_button", By.xpath("//*[@id='additionalRelatedCodes']/tr[1]//button[@title='Delete Row']"));
        hmap.put("edit_routingcode_page_relatedcodes_table", By.xpath("//*[@id='additionalRelatedCodes']/tr"));
        hmap.put("edit_routingcode_page_relatedcodes_no_searchResults_msg", By.xpath("//*[@id='relatedCode_chosen']/div/ul/li[@class='no-results']"));
        hmap.put("edit_routingcode_page_relatedcode_required_errorMessage", By.xpath("//*[@data-error_id='relatedCodeError']"));
        hmap.put("edit_routingcode_page_relatedcode_context_required_errorMessage", By.xpath("//*[@data-error_id='relatedCodeContextError']"));


    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}