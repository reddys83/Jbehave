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
        hmap.put("legalEntity_basicInfo_fatcastatus_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='FATCA Status']/td/select"));
        hmap.put("legalEntity_leadinstitution_radio_options_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//input[@name='leadInstitution']"));
        hmap.put("legalEntity_basicInfo_leadInstitution_label_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/th"));
        hmap.put("legalEntity_basicInfo_leadInstitution_value_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/td"));
        hmap.put("legalEntity_basicInfo_add_new_entitytype_button_id",By.id("add-types"));
        hmap.put("legalEntity_basicInfo_entitytypes_delete_button_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr/td[@class='delete']/button"));
        hmap.put("delete_confirmation_yes_button_id",By.id("yes-button"));
        hmap.put("legalEntity_entity_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='legalEntityTypeError']"));
        hmap.put("legalEntity_basicInfo_entitytypes_dropdown_xpath",By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr/td/select[@id='legalEntityType']"));
        hmap.put(" legalEntity_basicInfo_charteredDate_view_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td"));
        hmap.put(" legalEntity_basicInfo_charteredDate_day_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/input[1]"));
        hmap.put(" legalEntity_basicInfo_charteredDate_month_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/select"));
        hmap.put(" legalEntity_basicInfo_charteredDate_year_xpath",By.xpath("//table[@class='vertical']/tbody/tr[3]/td/input[2]"));
        hmap.put(" legalEntity_basicInfo_charteredDate_errorMessage_xpath",By.xpath("//*[@data-error_id='charteredDateError']"));
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
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_dropdown",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//select[@data-internal_id='creditRatingAgency']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_dropdown",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//select[@data-internal_id='creditRatingAgency']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_Type_dropdown",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//select[@data-internal_id='creditRatingType']"));
        hmap.put("legalEntity_first_row_new_creditrating_Type_dropdown",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//select[@data-internal_id='creditRatingType']"));
        hmap.put("legalEntity_credit_rating_addRow_id",By.id("add-creditRatings"));
        hmap.put("legalEntity_Edit_creditratings_Table",By.xpath("//*[@id='additionalCreditRatings']//tr[@data-row_id='creditRatings']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_Value",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//input[@name='creditRatingValue']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_AppliedDateDay",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//input[@name='creditRatingAppliedDate-day']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_AppliedDateMonth",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//select[@name='creditRatingAppliedDate-month']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_AppliedDateYear",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//input[@name='creditRatingAppliedDate-year']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateDay",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//input[@name='creditRatingConfirmedDate-day']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateMonth",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//select[@name='creditRatingConfirmedDate-month']"));
        hmap.put("legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateYear",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//input[@name='creditRatingConfirmedDate-year']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_Value",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//input[@name='creditRatingValue']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_AppliedDateDay",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//input[@name='creditRatingAppliedDate-day']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//select[@name='creditRatingAppliedDate-month']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_AppliedDateYear",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//input[@name='creditRatingAppliedDate-year']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//input[@name='creditRatingConfirmedDate-day']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//select[@name='creditRatingConfirmedDate-month']"));
        hmap.put("legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//input[@name='creditRatingConfirmedDate-year']"));
        hmap.put("legalEntity_first_new_row_creditrating_delete_button",By.xpath("//*[@id='additionalCreditRatings']//tr[@class='new'][1]//button"));
        hmap.put("legalEntity_first_existing_row_creditrating_delete_button",By.xpath("//*[@id='additionalCreditRatings']//tr[1]//button"));
        hmap.put("legalEntity_creditRating_agency_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='creditRatingAgencyError']"));
        hmap.put("legalEntity_creditRating_type_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='creditRatingTypeError']"));
        hmap.put("legalEntity_creditRating_value_error_msg_xpath",By.xpath("//*[@class='notification error'][@data-error_id='creditRatingValueError']"));
        hmap.put("legalEntity_basicInfo_appliedDate_errorMessage_xpath",By.xpath("//*[@class='notification error'][@data-error_id='creditRatingAppliedDateError']"));
                hmap.put("legalEntity_basicInfo_confirmedDate_errorMessage_xpath",By.xpath("//*[@class='notification error'][@data-error_id='creditRatingConfirmedDateError']"));
    }



    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }

}
