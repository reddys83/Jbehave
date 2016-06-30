package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by soofis on 5/10/2016.
 */
public class LegalEntityIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers(){
        hmap.put("first_existing_entitytype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[1]/td[1]/select")));
        hmap.put("second_existing_entitytype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("first_new_entitytype_dropdown", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='legalEntityType']"));
        hmap.put("first_row_existing_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[1]/td[@class='delete']/button"));
        hmap.put("second_row_existing_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[2]/td[@class='delete']/button"));
        hmap.put("first_new_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td[@class='delete']/button"));
        hmap.put("edit_legalEntity_insuranceType_dropdown",By.xpath("//table[@class='vertical']/tbody/tr[th='Insurance Type']/td/select"));
        hmap.put("edit_legalEntity_ownershipType_dropdown",By.xpath("//table[@class='vertical']/tbody/tr[th='Ownership Type']/td/select"));
        hmap.put("legalEntity_boardMeetings_first_new_type_dropdown", By.xpath("//tr[@class='new'][1]//td/select[@id='boardMeetingType']"));
        hmap.put("legalEntity_boardMeetings_first_new_value_dropdown", By.xpath("//tr[@class='new'][1]//td/select[@id='boardMeetingValue']"));
        hmap.put("legalEntity_boardMeetings_second_new_type_dropdown", By.xpath("//tr[@class='new'][2]//td/select[@id='boardMeetingType']"));
        hmap.put("legalEntity_boardMeetings_second_new_value_dropdown",By.xpath("//tr[@class='new'][2]//td/select[@id='boardMeetingValue']"));
        hmap.put("legalEntity_boardMeetings_type_dropdown_options_xpath", By.xpath(".//tr[@data-row_id='boardMeetings'][last()]//select[@id='boardMeetingType']//option"));
        hmap.put("legalEntity_boardMeetings_value_dropdown_options_xpath", By.xpath(".//tr[@data-row_id='boardMeetings'][last()]//select[@id='boardMeetingValue']//option"));
        hmap.put("legalEntity_boardMeetings_summary_xpath", By.xpath(".//*[@id='legalEntityBoardMeetings']//textarea"));
        hmap.put("legalEntity_personnel_value_xpath", By.xpath(".//*[@id='additionalPersonnel']//textarea"));
        hmap.put("legalEntity_boardMeetings_second_new_type_dropdown", By.xpath("//tr[@class='new'][2]//td/select[@id='boardMeetingType']"));
        hmap.put("legalEntity_boardMeetings_add_button_id", By.id("add-boardMeetings"));
        hmap.put("legalEntity_boardMeetings_first_existing_type_dropdown", By.xpath("//tr[1]//td/select[@id='boardMeetingType']"));
        hmap.put("legalEntity_boardMeetings_label_xpath", By.xpath(".//*[@id='legalEntityBoardMeetings']//h2"));
        hmap.put("legalEntity_boardMeetings_summary_error_message_xpath", By.xpath(".//*[@class='notification error'][@data-error_id='boardMeetingsSummaryError']"));
        hmap.put("legalEntity_boardMeeting_duplicate_error_message_xpath", By.xpath(".//*[@class='notification error'][@data-error_id='boardMeetingValueError']"));
        hmap.put("legalEntity_basicInfo_fatcastatus_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='FATCA Status']/td/select"));
        hmap.put("legalEntity_leadinstitution_radio_options_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//input[@name='leadInstitution']"));
        hmap.put("legalEntity_basicInfo_leadInstitution_label_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/th"));
        hmap.put("legalEntity_basicInfo_leadInstitution_value_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/td"));
        hmap.put("legalEntity_basicInfo_add_new_entitytype_button_id",By.id("add-types"));
        hmap.put("legalEntity_basicInfo_entitytypes_delete_button_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr/td[@class='delete']/button"));
        hmap.put("delete_confirmation_yes_button_id",By.id("yes-button"));
        hmap.put("legalEntity_entity_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='legalEntityTypeError']"));
        hmap.put("legalEntity_basicInfo_entitytypes_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr/td/select[@id='legalEntityType' or @id='fixedlegalEntityType']"));
        hmap.put("legalEntity_basicInfo_charteredDate_view_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td"));
        hmap.put("legalEntity_basicInfo_charteredDate_day_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/input[1]"));
        hmap.put("legalEntity_basicInfo_charteredDate_month_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/select"));
        hmap.put("legalEntity_basicInfo_charteredDate_year_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/input[2]"));
        hmap.put("legalEntity_basicInfo_charteredDate_errorMessage_xpath",By.xpath("//*[@data-error_id='charteredDateError']"));
        hmap.put("legalEntity_basicInfo_status_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='Status']/td/select"));
        hmap.put("legalEntity_basicInfo_CharterType_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td/select"));
        hmap.put("legalEntity_basicInfo_status_list_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='Status']/td/select/option"));
        hmap.put("legalEntity_basicInfo_CharterType_view_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td"));
        hmap.put("legalEntity_basicInfo_day_Claimed_est_date_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/input[1]"));
        hmap.put("legalEntity_basicInfo_Month__Claimed_est_date_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/select"));
        hmap.put("legalEntity_basicInfo_year_Claimed_est_date_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/input[2]"));
        hmap.put("countryBasicInfo_claimedEst_date_error_message_xpath",By.xpath("//*[@class='notification error'][@data-error_id='establishedDateError']"));
        hmap.put("legalEntity_basicInfo_claimedEstDate_xpath",By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td"));
        hmap.put("legalEntity_basicInfo_fatcastatus_list_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='FATCA Status']/td/select/option"));
        hmap.put("legalEntityBasicInfo_Add_Names_button_edit_id",By.id("add-names"));
        hmap.put("legalEntityBasicInfo_Names_value_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new']//input"));
        hmap.put("legalEntityBasicInfo_Names_type_dropdown_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new']//select"));
        hmap.put("legalEntityBasicInfo_Names_type_dropdown_edit_options_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new']//select/option"));
        hmap.put("legalEntityBasicInfo_names_delete_button_xpath",By.xpath(".//*[@class='new'][@data-row_id='names']//button[@class='delete-row']"));
        hmap.put("legalEntityBasicInfo_delete_confirmation_modal_xpath",By.xpath("//*[@colspan='10']"));
        hmap.put("legalEntity_delete_no_button_id",By.id("no-button"));
        hmap.put("legalEntity_delete_yes_button_id",By.id("yes-button"));
        hmap.put("legalEntity_new_names_type_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[@class='new'][@data-row_id='names']"));
        hmap.put("legalEntity_delete_button_for_legalTitle_edit_xpath",By.xpath(".//*[@id='additionalNames']//tr[td='Legal Title']//button[@class='delete-row']"));
        hmap.put("legalEntityBasicInfo_type_required_error_message_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='nameTypeError']"));
        hmap.put("legalEntityBasicInfo_value_required_error_message_xpath", By.xpath(".//*[@class='notification error'][@data-error_id='nameValueError']"));
        hmap.put("corporateSummary_textarea_xpath",By.xpath("//*[@id='legalEntityBasicInfo']/dl/dd/textarea"));
        hmap.put("legalEntity_basicInfo_AdditionalInfo_textarea_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Add Info']/td/textarea"));
        hmap.put("corporateSummary_textarea_maxLenght_error_xpath",By.xpath("//*[@id='legalEntityBasicInfo']/dl/dd/p"));
        hmap.put("legalEntity_basicInfo_AdditionalInfos_err_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='addInfoError']"));
        hmap.put("legalEntity_basicInfo_leftContainer_container_xpath",By.xpath("//*[@id='legalEntityBasicInfo']/ul/li[2]/table/tbody"));
        hmap.put("legalEntity_locations_summary_type_edit_xpath",By.xpath("//*[@id='additionalLocationSummaries']/tr[last()]//td/select[@id='locationSummaryType']"));
        hmap.put("legalEntity_locations_summary_type_dropdown_edit_xpath",By.xpath("//*[@id='additionalLocationSummaries']/tr[last()]//td/select[@id='locationSummaryType']/option"));
        hmap.put("legalEntity_new_locations_summary_id",By.id("add-locationSummaries"));
        hmap.put("legalEntity_locations_summary_value_edit_xpath",By.xpath("//*[@id='additionalLocationSummaries']/tr[last()]//td//textarea"));
        hmap.put("legalEntity_location_type_error_message_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='locationSummaryTypeError']"));
        hmap.put("legalEntity_location_value_error_message_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='locationSummaryValueError']"));
        hmap.put("legalEntity_delete_button_legalEntity_location_edit_xpath",By.xpath(".//*[@id='additionalLocationSummaries']//tr[@class='new']//td[@class='delete']/button"));
        hmap.put("legalEntity_new_locations_summary_value_edit_xpath",By.xpath("//*[@id='additionalLocationSummaries']/tr[@class='new']//td//textarea"));
        hmap.put("legalEntity_personnel_first_existing_type_dropdown_edit_xpath", By.xpath("//tbody[@id='additionalPersonnel']/tr[1]/td[1]/select"));
        hmap.put("legalEntity_personnel_first_new_type_dropdown_edit_xpath", By.xpath("//tbody[@id='additionalPersonnel']/tr[@class='new']/td[1]/select"));
        hmap.put("legalEntity_personnel_type_dropdown_edit_xpath", By.xpath("//tbody[@id='additionalPersonnel']/tr[1]/td[1]/select[@id='personnelType']/option"));
        hmap.put("legalEntity_personnel_add_button_id", By.id("add-personnel"));
        hmap.put("legalEntity_personnel_type_error_message_xpath", By.xpath(".//*[@id='additionalPersonnel']//p[@class='notification error']"));
        hmap.put("legalEntity_personnel_value_error_message_xpath", By.xpath(".//*[@id='additionalPersonnel']//p[@data-error_id='personnelValueError']"));
        hmap.put("legalEntity_office_page_offices_label_xpath",By.xpath("//div[@id='subEntityList-summary']//span[text()='offices']"));
        hmap.put("legalEntity_Identifier_link_Navigation_xpath",By.xpath(".//*[@id='legalEntityIdentifiers']"));
        hmap.put("legalEntity_first_row_existing_identifier_type_dropdown",By.xpath("//*[@id='additionalIdentifiers']/tr[1]/td[1]/select"));
        hmap.put("legalEntity_first_row_existing_identifier_status_dropdown",By.xpath("//*[@id='additionalIdentifiers']/tr[1]/td[3]/select"));
        hmap.put("legalEntity_Identifier_All_Types_dropdown_xpath", By.xpath("//*[@id='additionalIdentifiers']/tr/td/select[@id='identifierType']"));
        hmap.put("legalEntity_Identifier_type_list_xpath",By.xpath("//*[@id='additionalIdentifiers']//*[@class=\"new\"]//select/option"));
        hmap.put("LegalEntity_Identifier_status_xpath",By.xpath(".//*[@id='additionalIdentifiers']/tr[1]/td[3]/select"));
        hmap.put("legalEntity_first_row_new_identifier_type_dropdown",By.xpath("//*[@id='additionalIdentifiers']//tr[@class='new'][1]//select[@data-internal_id='identifierType']"));
        hmap.put("legalEntity_first_row_new_identifier_status_dropdown",By.xpath("//*[@id='additionalIdentifiers']//tr[@class='new'][1]//select[@data-internal_id='identifierStatus']"));
        hmap.put("legalEntity_first_row_existing_delete_identifiers_button",By.xpath(".//*[@id='additionalIdentifiers']//tr[1]//button[@class='delete-row']"));
        hmap.put("legalEntity_first_row_existing_identifier_value",By.xpath(".//*[@id='additionalIdentifiers']/tr[1]/td[2]/input"));
        //hmap.put("legalEntity_first_row_new_identifier_value",By.xpath(".//*[@id='additionalIdentifiers']/tr[@class='new']/td[2]/input"));
        hmap.put("legalEntity_first_row_new_identifier_value",By.xpath(".//*[@id='additionalIdentifiers']/tr[@class='new'][1]//input[@name='identifierValue']"));
        //hmap.put("legalEntity_identifier_value_error_xpath",By.xpath(".//*[@id='additionalIdentifiers']/tr[3]/td[2]/p"));
        hmap.put("legalEntity_Basic_Info_Table",By.xpath("//*[@id='additionalIdentifiers']//tr[@data-row_id='identifiers']"));
        hmap.put("legalEntity_basicInfo_add_new_identifiers_button_xpath",By.xpath(".//*[@id='legalEntityIdentifiers']/div/div"));
        hmap.put("legalEntity_identifier_type_error_msg_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='identifierTypeError']"));
        hmap.put("legalEntity_identifier_value_error_msg_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='identifierValueError']"));
        hmap.put("legalEntity_identifier_status_error_msg_xpath",By.xpath(".//*[@class='notification error'][@data-error_id='identifierStatusError']"));
        hmap.put("legalEntity_first_row_new_delete_identifiers_button", By.xpath("//*[@id='additionalIdentifiers']//tr[@class='new']//button[@class='delete-row']"));
        hmap.put("legalEntity_identifier_delete_yes_button_id", By.id("yes-button"));
        hmap.put("legalEntity_history_value_edit_xpath",By.xpath("//*[@id='legalEntityHistory']/textarea"));
    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }

}
