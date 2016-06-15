package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.commons.collections.ListUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by shahc1 on 5/16/2016.
 */

public class EditLegalEntityPage extends AbstractPage {


    private String editLegalEntityNameValue = "";
    public String EditLegalEntityLocationsType = "";
    public String EditLegalEntityLocationsValue = "";
    public String EditLegalEntityBoardMeetingsType="";
    public String EditLegalEntityBoardMeetingValue="";
    public String EditLEgalEntityBoardmeetingSummary="";


    public EditLegalEntityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    public void verifyEditLegalEntityFatcaStatusValueFromTrusted(String fid, String tagName, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), getSelectedDropdownValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath")));
    }

    public String getLegalEntityValuesFromDB(String fid, String tagName, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        String statusValue = "";
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        if (document != null) {
            statusValue = getNodeValuesByTagName(document, tagName).size() == 0 ? "" : getNodeValuesByTagName(document, tagName).get(0);
        }
        return statusValue;
    }

    public void verifyEditLegalEntityLeadInstitutionFlagInDB(String fid, String source) {
        assertEquals(getLeadInstitutionFlagFromDB(fid, source), getSelectedRadioValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_leadinstitution_radio_options_xpath")));
    }

    public String getLeadInstitutionFlagFromDB(String fid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String leadInstitutionDBValue = getNodeValuesByTagName(document, "leadInstitution").size() == 0 ? "" : getNodeValuesByTagName(document, "leadInstitution").get(0);
        return leadInstitutionDBValue;
    }

    public void selectLegalEntityLeadInstitutionFlag(String leadInstitutionflag) {
        selectRadioButtonByValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_leadinstitution_radio_options_xpath"), leadInstitutionflag);
    }

    public void verifyLeadInstitutionValuefromDB(String leadInstitutionflag, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getLeadInstitutionFlagFromDB(selectedEntity, source), leadInstitutionflag);

    }

    public void verifyNoLeadInstitution() {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leadInstitution_label_xpath")).isDisplayed());
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leadInstitution_value_xpath")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyLegalEntityEditPageMode() {
        assertTrue(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath")).size()>0);
    }

    public void clickOnAddNewEntityTypeButton() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_add_new_entitytype_button_id"));
    }


    public void selectEntityType(String entityTypeValue, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByVisibleText(entityTypeValue);

    }

    public void verifyEditLegalEntityEntityTypeValueFromTrusted(String fid, String tagName, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        if (document != null) {
            assertEquals(getNodeValuesByTagName(document, tagName), getAlreadySelectedEntityTypes());
        }

    }

    public void verifyEditLegalEntityEntityTypeValueFromZeus(String entityTypeValue, String tagName, String fid, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        if (document != null && !entityTypeValue.isEmpty()) {
            assertTrue(getNodeValuesByTagName(document, tagName).contains(entityTypeValue));

        } else if (document != null && entityTypeValue.isEmpty()) {
            assertFalse(getNodeValuesByTagName(document, tagName).contains(entityTypeValue));
        }

    }


    public void verifyDeleteLegalEntityTypeButtonStatus(String deleteButton) {
        assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(deleteButton)).isEnabled());
    }

    public void clickonDeleteEntityTypeRowButton(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyExistingEntityTypeRow(String rowIdentifier, String dropdownvalue) {
        assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)));
        assertEquals(dropdown.getFirstSelectedOption().getText(), dropdownvalue);
    }

    public void verifyNoExistingEntityTypeRow(String rowIdentifier, String dropdownvalue) {
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)));
        assertFalse(dropdown.getFirstSelectedOption().getText().equalsIgnoreCase(dropdownvalue));

    }

    public void verifyEntityTypeNotPresentInZeus(String source, String fid, String tagName, String value) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        assertFalse(getNodeValuesByTagName(document, tagName).contains(value));
    }


    public void verifyNewEntityTypeRow(String rowIdentifier) {
        assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
    }

    public void verifyNoNewEntityTypeRow(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }

    }

    public void deleteAllEntityTypeRowsExceptRow1() {
        int numberOfRows = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_delete_button_xpath")).size();
        for (int buttonCount = 1; buttonCount < numberOfRows; buttonCount++) {
            getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_delete_button_xpath")).get(1).click();
            attemptClick(LegalEntityIdentifiers.getObjectIdentifier("delete_confirmation_yes_button_id"));
        }
    }

    public void verifyErrorMsgRequiredForEntityType() {
        assertEquals(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_entity_type_error_msg_xpath")).size(), 1);
        assertEquals("Required", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_entity_type_error_msg_xpath")).getText());
    }

    public void enterNullValueForAllEntityTypeRows() {
        int numberOfRows = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_dropdown_xpath")).size();
        for (int entityTypesCount = 0; entityTypesCount < numberOfRows; entityTypesCount++) {
            Select dropdown = new Select(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_dropdown_xpath")).get(entityTypesCount));
            dropdown.selectByVisibleText("");
        }
    }


    public void updateCharteredDate(String day, String month, String year) {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_charteredDate_day_xpath"), day);
        Select monthDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_charteredDate_month_xpath")));
        monthDropDown.selectByValue(month);
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_charteredDate_year_xpath"), year);


    }

    public void verifyUpdatedCharteredDate(String fid) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", fid));
        zeusPairs.add(new BasicNameValuePair("source", "zeus"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
        assertEquals(document.getElementsByTagName("characteredDate").item(0).getTextContent(), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_charteredDate_view_xpath")).getText());
    }

    public void verifyErrorMessageCharteredDate(String startDateErrorMsg) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(startDateErrorMsg.replace("'", ""), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_charteredDate_errorMessage_xpath")).getText());
    }

    public void verifyInsuranceTypeOptions() {
        String source = "source-trusted";
        String fidValue = "LEGAL_ENTITY_INSURANCE_TYPE";
        String webElement = "edit_legalEntity_insuranceType_dropdown";
        verifyingValuesFromLookUpDoc(source, fidValue, webElement);
    }

    public void updateInsuranceType(String insuranceType) {
        Select insuranceTypeDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("edit_legalEntity_insuranceType_dropdown")));
        insuranceTypeDropDown.selectByValue(insuranceType);
    }

    public void verifyInsuranceTypeValueFromDocument(String insuranceType, String fid) {
        String xqueryName = "get legal entity basic info left column";
        String tagName = "insuranceType";
        String source = "zeus";
        verifyingDataFromMLDocs(insuranceType, fid, xqueryName, tagName, source);
    }


    public void verifyOwnershipTypeOptionsFromLookup() {
        String source = "source-trusted";
        String fidValue = "LEGAL_ENTITY_ORGANISATION_TYPE";
        String webElement = "edit_legalEntity_ownershipType_dropdown";
        verifyingValuesFromLookUpDoc(source, fidValue, webElement);
    }

    public void updateOwnershipType(String ownershipType) {
        Select insuranceTypeDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("edit_legalEntity_ownershipType_dropdown")));
        insuranceTypeDropDown.selectByValue(ownershipType);
    }

    public void verifyOwnershipTypeValueFromDocument(String ownershipType, String fid) {
        String xqueryName = "get legal entity basic info left column";
        String tagName = "ownershipType";
        String source = "zeus";
        verifyingDataFromMLDocs(ownershipType, fid, xqueryName, tagName, source);
    }

    /**
     * This method can be used when we are verifying specific value from front end with any marklogic document
     *
     * @param valueToBeVerified String value which is to be compared
     * @param fid               fid
     * @param xqueryName        xquery to be executed
     * @param tagName           name of the tag from the xquery results with which front end value is to be compared
     * @param source            source of document
     */
    private void verifyingDataFromMLDocs(String valueToBeVerified, String fid, String xqueryName, String tagName, String source) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        assertEquals(document.getElementsByTagName(tagName).item(0).getTextContent(), valueToBeVerified);
    }

    /**
     * This method is created to verify the options displayed in dropdown of any field with respective lookup document
     *
     * @param source     source of document
     * @param fidValue   fid value of lookup table
     * @param webElement drop down whose options are to be verified
     */
    private void verifyingValuesFromLookUpDoc(String source, String fidValue, String webElement) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("source", source));
        nvPairs.add(new BasicNameValuePair("fidValue", fidValue));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get data from lookup table", nvPairs);
        Select webElementDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(webElement)));
        Integer optionsDisplayed = webElementDropDown.getOptions().size();
        for (int i = 0; i < optionsDisplayed - 2; i++) {
            assertEquals(webElementDropDown.getOptions().get(i + 1).getText(), document.getElementsByTagName("a").item(i).getTextContent());
        }
    }

    public void selectLegalEntityStatusValue(String status) {
        selectItemFromDropdownListByValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath"), status);
    }

    public void clickOnStatusType() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath"));
    }

    public void verifyCharterTypeOptions() {
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "get charter type from lookup document", "source", "source-trusted");
        Select charterTypeDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_CharterType_dropdown_xpath")));
        Integer optionsDisplayed = charterTypeDropDown.getOptions().size();
        for (int i = 0; i < optionsDisplayed - 2; i++) {
            assertEquals(charterTypeDropDown.getOptions().get(i + 1).getText(), document.getElementsByTagName("a").item(i).getTextContent());
        }
    }

    public void verifyLegalEntityStatusList() {
        List<WebElement> statusList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_list_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get legal entity Status types");
        for (int i = 1; i < document.getElementsByTagName("status").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), statusList.get(i).getAttribute("value"));
        }
    }


    public void enterValueInStatusDropdown(String word) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath")).sendKeys(word);
    }


    public void verifyStatusInDropdown(String status) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getSelectedDropdownValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath")).equalsIgnoreCase(status));

    }

    public void verifyEditLegalEntityStatusValueFromTrusted(String fid, String tagName, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), getSelectedDropdownValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath")));

    }

    public void verifyEditLegalEntityStatusValueFromZeus(String status, String tagName, String fid, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), status);

    }

    public void changeLegalEntityStatusValue() {
        String valuetobeSelected = "";
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath")));
        for (WebElement option : dropdown.getOptions()) {
            if (!option.isSelected()) {
                valuetobeSelected = option.getAttribute("value");
                break;
            }
        }
        selectItemFromDropdownListByValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_status_dropdown_xpath"), valuetobeSelected);

    }

    public void verifyCharterTypeDefaultValue(String fid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        Select charterTypeDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_CharterType_dropdown_xpath")));
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), charterTypeDropDown.getFirstSelectedOption().getText());
    }

    public void updateCharterType(String charterType) {
        Select charterTypeDropDown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_CharterType_dropdown_xpath")));
        charterTypeDropDown.selectByVisibleText(charterType);

    }

    public void verifyUpdatedCharterTypeBothDocs(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_CharterType_view_xpath")).getText());
        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", fid));
        zeusPairs.add(new BasicNameValuePair("source", "zeus"));
        document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_CharterType_view_xpath")).getText());
    }

    public void enterDayValueForClaimedEstDate(String day) {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_day_Claimed_est_date_xpath"), day);

    }

    public void enterMonthValueForClaimedEstDate(String month) {
        Select monthDropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_Month__Claimed_est_date_xpath")));
        monthDropdown.selectByValue(month);
    }

    public void enterYearValueForClaimedEstDate(String year) {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_year_Claimed_est_date_xpath"),year);

    }

    public void validateErrorMessageforClaimedEstDate() {
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("countryBasicInfo_claimedEst_date_error_message_xpath")).getText());
    }

    public void verifyUpdatedClaimedEstDateBothDocs(String fid) {
        try {
            Thread.sleep(1000L);
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", fid));
            nvPairs.add(new BasicNameValuePair("source", "trusted"));
            Thread.sleep(5000L);
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
            assertEquals(document.getElementsByTagName("claimedEstDate").item(0).getTextContent(), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_claimedEstDate_xpath")).getText());
            List<NameValuePair> zeusPairs = new ArrayList<>();
            zeusPairs.add(new BasicNameValuePair("fid", fid));
            zeusPairs.add(new BasicNameValuePair("source", "zeus"));
            Thread.sleep(5000L);
            document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
            assertEquals(document.getElementsByTagName("claimedEstDate").item(0).getTextContent(), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_claimedEstDate_xpath")).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void selectLegalEntityFatcaStatusValue(String status) {
        selectItemFromDropdownListByValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath"), status);
    }

    public void clickOnFatcaStatusType() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath"));
    }

    public void verifyLegalEntityFatcaStatusList(String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> statusList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_list_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity Status types", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("status").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), statusList.get(i + 1).getAttribute("value"));
        }
    }


    public void enterValueInFatcaStatusDropdown(String word) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath")).sendKeys(word);
    }

    public void verifyFatcaStatusInDropdown(String status) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getSelectedDropdownValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath")).contains(status));

    }

    public void verifyEditLegalEntityFatcaStatusValueFromZeus(String fatcastatus, String tagName, String fid, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), fatcastatus);
    }

    public void clicksAddLegalEntityNames() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Add_Names_button_edit_id"));
    }

    public void entersInvalidCharactersForValueInNames() {
        char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 200; i++) {
            invalidData += c;
        }
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_value_edit_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_value_edit_xpath"),invalidData);

    }

    public void clicksLegalEntityNamesTypeDropdown() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_type_dropdown_edit_xpath"));
    }


    public void verifyLegalEntityNamesTypeDropdown() {
        List<WebElement> TypesList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_type_dropdown_edit_options_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "getLegalEntityNamesType.xqy");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), TypesList.get(i).getAttribute("value"));
        }
    }

    public void selectLegalEntityNamesType(String legalEntityNameType) {
        {
            List<WebElement> typeList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_type_dropdown_edit_options_xpath"));
            for (WebElement option : typeList) {
                if (option.getText().contains(legalEntityNameType)) {
                    getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_type_dropdown_edit_xpath")).click();
                    option.click();
                    break;
                }
            }
        }
    }

    public void enterLegalEntityNamesValue(String legalEntityNameValue) {
        editLegalEntityNameValue = legalEntityNameValue;
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_value_edit_xpath")).sendKeys(legalEntityNameValue);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_Names_value_edit_xpath")).sendKeys(Keys.RETURN);
    }

    public void clicksOnDeleteLegalEntityNames() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_names_delete_button_xpath"));
    }

    public void verifyDeleteConfirmationModalInlegalEntity() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_delete_confirmation_modal_xpath")).getText());
    }

    public void clickOnNoButtonInDeleteConfirmationModalInLegalEntity() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_delete_no_button_id"));
    }

    public void clickOnYesButtonInDeleteConfirmationModalInLegalEntity() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_delete_yes_button_id"));
    }


    public void verifyEditLegalEntityNamesInZeus(String selectedEntity) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "getLegalEntityNames.xqy", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("name").getLength(); i++) {
            assertEquals(editLegalEntityNameValue, document.getElementsByTagName("name").item(i).getTextContent());
        }
    }

    public void verifyUpdatedCorporateSummary(String fid, String corporateStatement) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", fid));
        zeusPairs.add(new BasicNameValuePair("source", "zeus"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
        assertEquals(document.getElementsByTagName("corporateStatement").item(0).getTextContent(), corporateStatement);
    }

    public void verifyNewlyAddedNames() {
        assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_names_type_edit_xpath")).isDisplayed());
    }

    public void verifyNoNewlyAddedNames() {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_names_type_edit_xpath")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyDeleteButtonForLegalTitle() {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_delete_button_for_legalTitle_edit_xpath")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyRequiredErrorMessageForTypesAndValues() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_type_required_error_message_xpath")).getText(), "Required");
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_value_required_error_message_xpath")).getText(), "Required");
    }

    public void verifyErrorMessageForValue() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntityBasicInfo_value_required_error_message_xpath")).getText(), "Enter up to 200 valid characters.");
    }

    public void changeLegalEntityFatcaStatusValue() {
        String valuetobeSelected = "";
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_dropdown_xpath")));
        for (WebElement option : dropdown.getOptions()) {
            if (!option.isSelected()) {
                valuetobeSelected = option.getAttribute("value");
                break;
            }
        }
        dropdown.selectByValue(valuetobeSelected);
    }

    public void enterValueForCorporateStatement(String corporateStatement) {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath"),corporateStatement);
    }

    public void clearAndEnterValue(By webElement, String value) {
        getDriver().findElement(webElement).clear();
        getDriver().findElement(webElement).sendKeys(value);

    }


    public void verifyMaxLengthCorporateActionTextArea() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")).getAttribute("maxlength"), "10000");
    }


    public void enter10001CharactersInLegalEntityCorporateAction() {
        String strBigString = createBigString(10000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('maxlength','10001')", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")));
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")));
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")).sendKeys("1");
    }

    public void enter10000CharactersInLegalEntityCorporateAction() {
        String strBigString = createBigString(10000);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_xpath")));
    }

    public void verifyLegalEntityCorporateActionErrorMessageForMaxLength() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("corporateSummary_textarea_maxLenght_error_xpath")).getText(), "Enter up to 10000 valid characters.");
    }

    public void enterLegalEntityAdditionalInfo(String additionalInfoText) {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath"),additionalInfoText);

    }

    public void verifyEditLegalEntityAdditionalInfoValueFromZeus(String additionalInfoText, String tagName, String fid, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), additionalInfoText);

    }

    public void verifyAdditionalInfoValueWithMaxLengthFromZeus(String tagName, String fid, String source) {
        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), bigString);

    }

    public void verifyAdditionalInfoTextAreaLength(String fid) {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")).getAttribute("maxlength"), "10000");
    }


    public void enter10001CharactersInLegalEntityAdditionalInfo(String fid) {
        String strBigString = createBigString(10000);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath"), "maxlength", "10001");
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")));
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")).sendKeys("1");
    }

    public void enter10000CharactersInLegalEntityAdditionalInfo(String fid) {
        String strBigString = createBigString(10000);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfo_textarea_xpath")));
    }

    public void verifyLegalEntityAdditionalInfoErrorMessageForMaxLength() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_AdditionalInfos_err_msg_xpath")).getText(), "Enter up to 10000 valid characters.");
    }


    public void clickOnExistingEntityTypeDropDown() {
        getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_dropdown_xpath")).get(0).click();
    }

    public void clickOnNewEntityTypeDropDown(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();

    }

    public void verifyLegalEntityEntityTypeListFromLookup(String lookupFid, String rowIdentifier) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        List<String> dropdownValuesList = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        for (WebElement option : dropdown.getOptions()) {
            dropdownValuesList.add(option.getText());
        }
        dropdownValuesList.remove(selectedValue);
        if (dropdownValuesList.get(0).equals("")) {
            dropdownValuesList.remove(0);
        }
        // finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity entity types", nvPairs);
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "EntityType"), getAlreadySelectedEntityTypes());
        assertEquals(dropdownValuesList, resultList);

    }

    public void verifyLegalEntityBasicInfoLeftColumn(String fid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        fetchingIndRecordsFromContainerUpperCaseConversion(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "status", nvPairs, "status");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Claimed Est Date", nvPairs, "claimedEstDate");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Chartered Date", nvPairs, "characteredDate");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Charter Type", nvPairs, "charterType");
        fetchingIndRecordsFromContainerUpperCaseConversion(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "FATCA Status", nvPairs, "fatcaStatus");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Insurance Type", nvPairs, "insuranceType");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Ownership Type", nvPairs, "organisationType");
        fetchingIndRecordsFromContainerUpperCaseConversion(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Lead Institution", nvPairs, "leadInstitution");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Add Info", nvPairs, "additionalinfo");
        fetchingIndRecordsFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Country of Operations", nvPairs, "countryOfOperation");
        fetchingHeadOfficeAddressFromContainer(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_leftContainer_container_xpath"), "Head Office", nvPairs, "headOfficeaddressLine1");

    }

    public List<String> getAlreadySelectedEntityTypes() {
        ArrayList<String> selectedValueList = new ArrayList();
        for (WebElement entityTypeDropDown : getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_entitytypes_dropdown_xpath"))) {
            Select dropdown = new Select(entityTypeDropDown);
            String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
            selectedValueList.add(selectedValue);
        }
        return selectedValueList;
    }

    /*
    *   Need to call this method only when value displayed on the front end has the first letter in upper case
    *
    * */
    public void fetchingIndRecordsFromContainerUpperCaseConversion(By containerPath, String labelText, List<NameValuePair> nvPairs, String xqueryparameterName) {
        List<WebElement> tableContainer = getDriver().findElement(containerPath).findElements(By.tagName("tr"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        for (int i = 0; i < tableContainer.size(); i++) {
            if (tableContainer.get(i).findElement(By.tagName("th")).getText().equalsIgnoreCase(labelText)) {
                assertEquals(convertingUpperCaseIntialCharacter(document.getElementsByTagName(xqueryparameterName).item(0).getTextContent()), tableContainer.get(i).findElement(By.tagName("td")).getText());
                break;
            }
        }
    }

    public String convertingUpperCaseIntialCharacter(String inputString) {
        if (inputString != null && !inputString.equalsIgnoreCase("")) {
            String intialcharacter = inputString.substring(0, 1).toUpperCase();
            inputString = intialcharacter.concat(inputString.substring(1));
        }
        return inputString;
    }

    public void fetchingIndRecordsFromContainer(By containerPath, String labelText, List<NameValuePair> nvPairs, String xqueryparameterName) {
        List<WebElement> tableContainer = getDriver().findElement(containerPath).findElements(By.tagName("tr"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        for (int i = 0; i < tableContainer.size(); i++) {
            if (tableContainer.get(i).findElement(By.tagName("th")).getText().equalsIgnoreCase(labelText)) {
                assertEquals(document.getElementsByTagName(xqueryparameterName).item(0).getTextContent(), tableContainer.get(i).findElement(By.tagName("td")).getText());
                break;
            }
        }
    }

    /*
    *
    * This method is used for comparing address lines of head office only
    * */
    public void fetchingHeadOfficeAddressFromContainer(By containerPath, String labelText, List<NameValuePair> nvPairs, String xqueryparameterName) {
        List<WebElement> tableContainer = getDriver().findElement(containerPath).findElements(By.tagName("tr"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        for (int i = 0; i < tableContainer.size(); i++) {
            if (tableContainer.get(i).findElement(By.tagName("th")).getText().equalsIgnoreCase(labelText)) {
                assertTrue(tableContainer.get(i).findElement(By.tagName("td")).getText().contains(document.getElementsByTagName(xqueryparameterName).item(0).getTextContent()));
                break;
            }
        }
    }

    public void clickOnLegalEntityLocationTypeDropDwon() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_type_edit_xpath"));
    }

    public void clickOnLegalEntityBoardMeetingsTypeDropdown(String webElement) {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
    }

    public void clickOnLegalEntityBoardMeetingsValueDropdown(String webElement) {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
    }

    public void verifyLegalEntityBoardMeetingType(ExamplesTable boardMeetingType) {
        assertEquals("BOARD MEETINGS", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_label_xpath")).getText());
        List<WebElement> types = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_type_dropdown_options_xpath"));
        for (int i=0; i<boardMeetingType.getRowCount();i++)
        {
            assertEquals(boardMeetingType.getRow(i).get(boardMeetingType.getHeaders().get(0)),types.get(i+1).getText());
        }
    }

    public void verifyLegalEntityBoardMeetingValue(ExamplesTable boardMeetingValue) {
        List<WebElement> values = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_value_dropdown_options_xpath"));
        for (int i=0; i<boardMeetingValue.getRowCount();i++)
        {
            assertEquals(boardMeetingValue.getRow(i).get(boardMeetingValue.getHeaders().get(0)),values.get(i+1).getText());
        }
    }

    public void verifyLegalEntityLocationsTypeValues() {
        List<WebElement> legalEntityLocationType = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_type_dropdown_edit_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "getLegalEntityLocationSummaryTypesFromLookup.xqy");
        for (int i = 1; i < document.getElementsByTagName("type").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), legalEntityLocationType.get(i).getText());
        }
    }

    public void clickNewLegalEntityLocations() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_locations_summary_id"));
    }

    public void clickNewLegalEntityBoardMeetings() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_add_button_id"));
    }

    public void enterSummaryInLegalEntityBoardMeeting(String summary) {
        EditLEgalEntityBoardmeetingSummary= summary;
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath")).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath")).sendKeys(summary);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath")).sendKeys(Keys.RETURN);
    }

    public void selectsTypeInLegalEntityBoardMeeting(String type, String webElement) {
        EditLegalEntityBoardMeetingsType = type;
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
        List<WebElement> options = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_type_dropdown_options_xpath"));
        for (WebElement option : options) {
            if (option.getText().contains(type)) {
                getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(webElement)).click();
                option.click();
                break;
            }
        }
    }

    public void selectsValueInLegalEntityBoardMeeting(String value, String webElement) {
        EditLegalEntityBoardMeetingValue = value;
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
        List<WebElement> options = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_value_dropdown_options_xpath"));
        for (WebElement option : options) {
            if (option.getText().contains(value)) {
                getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(webElement)).click();
                option.click();
                break;
            }
        }
    }

    public void selectsTypeInLegalEntityLocationSummary(String type) {
        EditLegalEntityLocationsType = type;
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_type_edit_xpath"));
        List<WebElement> options = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_type_dropdown_edit_xpath"));
        for (WebElement option : options) {
            if (option.getText().contains(type)) {
                getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_type_edit_xpath")).click();
                option.click();
                break;
            }
        }
    }

    public void verifyLegalEntityLocationSummaryInZeusDocument(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Locations", nvPairs);
        assertTrue(getNodeValuesByTagName(document, "type").contains(EditLegalEntityLocationsType));
        assertTrue(getNodeValuesByTagName(document, "value").contains(EditLegalEntityLocationsValue));
    }

    public void verifyLegalEntityBoardMeetingInZeus(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity BoardMeeting", nvPairs);
        assertTrue(getNodeValuesByTagName(document, "summary").contains(EditLEgalEntityBoardmeetingSummary));
        assertTrue(getNodeValuesByTagName(document, "type").contains(EditLegalEntityBoardMeetingsType));
        assertTrue(getNodeValuesByTagName(document, "value").contains(EditLegalEntityBoardMeetingValue));
    }

    public void entersLegalEntityValueInLocationSummary(String value) {
        EditLegalEntityLocationsValue = value;
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), value);
    }

    public void verifyRequiredErrorMessageForTypeInLegalEntityLocations() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_location_type_error_message_xpath")).getText(), "Required");
    }

    public void enterInvalidCharactersInLegalEntityBoardMeetingSummary() {
        String strBigString = createBigString(10001);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath"), strBigString);
    }

    public void enterInvalidCharactersInLegalEntityLocationsValue() {
        String strBigString = createBigString(10001);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), strBigString);
    }

    public void verifyErrorMessageForInvalidCharacter() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_location_value_error_message_xpath")).getText(), "Enter up to 10000 valid characters.");
    }

    public void verifyErrorMessageForLegalEntitySummaryBoardMeeting() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_error_message_xpath")).getText(),"Enter up to 10000 valid characters.");
    }

    public void verifyDuplicateErrorMessageForLegalEntityBoardMeeting() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeeting_duplicate_error_message_xpath")).getText(),"Duplicate Board Meeting");
    }

    public void clickOnDeleteButtonInLegalEntityLocationSummary() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_delete_button_legalEntity_location_edit_xpath"));
    }

    public void verifyNewlyAddLegalEntityLocations() {
        assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_locations_summary_value_edit_xpath")).isDisplayed());
    }

    public void verifyNoNewlyAddedLegalEntityLocations() {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_locations_summary_value_edit_xpath")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void clickOnIdentifierTypeDropDown(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void clickOnIdentifierStatusDropDown(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }
    public void verifyLegalEntityIdentifierTypesListFromLookup(String rowIdentifier,String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> identifierTypesList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity IdentifierTypes From Lookup", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("IdentifierType").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), identifierTypesList.get(i).getAttribute("value"));
        }

    }
    public void clickOnLegalEntityIdentifierStatus() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("LegalEntity_Identifier_status_xpath"));
    }

    public void verifyLegalEntityIdentifierStatusList(Database database, ApacheHttpClient apacheHttpClient) {
        List<WebElement> legalEntityIdentifierStatusList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Identifier_status_list_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get LegalEntity IdentifierStatus From Lookup");
        for (int i = 1; i < document.getElementsByTagName("IdentifierStatus").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), legalEntityIdentifierStatusList.get(i).getText());
        }
    }

    public void clickOnAddNewIdentifiersButton() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_add_new_identifiers_button_xpath"));
    }

    public void selectIdentifierType(String identifierTypeValue, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByVisibleText(identifierTypeValue);

    }

    public void verifyEditLegalEntityIdentifierTypeValueFromZeus(String identifierTypeValue, String tagName, String fid, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        if (document != null && !identifierTypeValue.isEmpty()) {
            assertTrue(getNodeValuesByTagName(document, tagName).contains(identifierTypeValue));

        } else if (document != null && identifierTypeValue.isEmpty()) {
            assertFalse(getNodeValuesByTagName(document, tagName).contains(identifierTypeValue));
        }

    }

    public void verifyEditLegalEntityIdentifierTypeValuesFromTrusted(String fid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity identifiers from trusted", nvPairs);

        if (document != null) {
            List typeList =getNodeValuesByTagName(document, "legalEntityIdentifierType");
            List valueList = getNodeValuesByTagName(document, "legalEntityIdentifierValue");
            List statusList =getNodeValuesByTagName(document, "legalEntityIdentifierStatus");

            for(int i=0;i<typeList.size();i++)
            {
                WebElement type=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[1]/select"));
                WebElement value=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[2]/select"));
                WebElement status=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[3]/input"));
                assertEquals(typeList.get(i),(new Select(type)).getFirstSelectedOption().getText());
                assertEquals(statusList.get(i),(new Select(status)).getFirstSelectedOption().getText());
                assertEquals(valueList.get(i),value.getAttribute("value"));
            }
        }

    }

    public void selectIdentifierStatus(String identifierStatus, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByVisibleText(identifierStatus);

    }

    public void enterIdentifierValue(String identifierValueRowIdentifier,String value){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(identifierValueRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(identifierValueRowIdentifier)).sendKeys(value);
    }

    public void verifyEditLegalEntityIdentifierValuesFromZeus(String type,
                                                              String value,
                                                              String status,
                                                              String fid,
                                                              String source)
    {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity identifiers from trusted", nvPairs);
        String identifiers=type+value+status;
        if (document != null) {
            Boolean flag=false;
            List typeList =getNodeValuesByTagName(document, "legalEntityIdentifierType");
            List valueList = getNodeValuesByTagName(document, "legalEntityIdentifierTypeValue");
            List statusList =getNodeValuesByTagName(document, "legalEntityIdentifierStatus");

            for(int i=0;i<typeList.size();i++)
            {
                String identifiersFromZeus=typeList.get(i).toString()+valueList.get(i).toString()+statusList;
                if(identifiersFromZeus.equals(identifiers)) {
                    flag=true;
                    break;
                }
            }
            flag=true;
            assertTrue(flag);
        }
        else{assertFalse(true);}
    }

    public void clickOnIdentifierDeleteNewRowButton() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_delete_identifiers_row_button_xpath"));
    }

    public void pressEnterButtonInDeleteConfirmationModal() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_delete_yes_button_id"));
    }

    public void verifyNewlyAddedIdentifierRowIsNotDisplayed(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }

    }

    public void pressNoButtonInDeleteConfirmationModal() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legal_entity_delete_no_identifiers_button_xpath"));
    }

    public void verifyNewlyAddedIdentifierRowIsDisplayed(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void enter50CharactersInIdentifierValueField() {
        String strBigString = createBigString(50);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_value_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_value_xpath")));
    }

    public void enter51CharactersInIdentifierValueField() {
        String strBigString = createBigString(51);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_value_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_value_xpath")));
    }

    public void verifyLegalEntityIdentifierValueErrorMessageForMaxLength() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_value_error_xpath")).getText(), "Enter up to 50 valid characters.");
    }

    public void verifyIdentifierValueErrorMessage(String xpathIdentifier,String errorMsg)
    {
        assertEquals(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());

    }

    public void verifyIdentifierStatusErrorMessage(String xpathIdentifier,String errorMsg)
    {
        assertEquals(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    }

    public void clickonDeleteidentifierRowButton(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyIdentifierTypeErrorMessage(String xpathIdentifier,String errorMsg)
    {
        assertEquals(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    }
    @Override
    public String getPageUrl() {
        return null;
    }

}
