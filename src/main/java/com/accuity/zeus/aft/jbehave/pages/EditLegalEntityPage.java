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
    public String EditLegalEntityPersonnelValue="";
    public String EditLegalEntityPersonnelType= "";


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
            assertEquals(getNodeValuesByTagName(document, tagName), getAlreadySelectedEntityTypes("legalEntity_basicInfo_entitytypes_dropdown_xpath"));
        }

    }

    public void verifyLegalEntityDocumentInZeus(String entityTypeValue, String tagName, String fid, String source, String xqueryName) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        if (document != null && !entityTypeValue.isEmpty()) {
            assertTrue(getNodeValuesByTagName(document, tagName).contains(entityTypeValue));

        } else if (document != null && entityTypeValue.isEmpty()) {
            assertFalse(getNodeValuesByTagName(document, tagName).contains(entityTypeValue));
        }

    }

    public void verifyEditLegalEntityCreditRatingsValuesFromTrusted(String fid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity credit ratings from trusted", nvPairs);

        if (document != null) {
            List agencyNameList =getNodeValuesByTagName(document, "agencyName");
            List typeList = getNodeValuesByTagName(document, "type");
            List valueList =getNodeValuesByTagName(document, "value");
            List dateAppliedList =getNodeValuesByTagName(document, "dateApplied");
            List dateConfirmedList =getNodeValuesByTagName(document, "dateConfirmed");

            for(int i=0;i<agencyNameList.size();i++)
            {
                WebElement agencyName=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[1]/select"));
                WebElement type=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[2]/select"));
                WebElement value=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[3]/input"));
                WebElement appliedDateDay=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[4]/fieldset/input[1]"));
                WebElement appliedDateMonth=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[4]/fieldset/select"));
                WebElement appliedDateYear=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[4]/fieldset/input[2]"));
                WebElement confirmedDateDay=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[5]/fieldset/input[1]"));
                WebElement confirmedDateMonth=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[5]/fieldset/select"));
                WebElement confirmedDateYear=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_creditratings_Table")).get(i).findElement(By.xpath("td[5]/fieldset/input[2]"));
                assertEquals(agencyNameList.get(i),(new Select(agencyName)).getFirstSelectedOption().getText());
                assertEquals(typeList.get(i),(new Select(type)).getFirstSelectedOption().getText());
                assertEquals(valueList.get(i),value.getAttribute("value"));
                String appliedDatestring=appliedDateDay.getAttribute("value")+(new Select(appliedDateMonth)).getFirstSelectedOption().getText()+appliedDateYear.getAttribute("value");
                if(appliedDatestring.equals(" "))
                {
                    appliedDatestring="null";
                }
                assertEquals(dateAppliedList.get(i).toString().replace(" ",""),appliedDatestring);
                String confirmedDatestring=confirmedDateDay.getAttribute("value")+(new Select(confirmedDateMonth)).getFirstSelectedOption().getText()+confirmedDateYear.getAttribute("value");
                if(confirmedDatestring.equals(" "))
                {
                    confirmedDatestring="null";
                }
                assertEquals(dateConfirmedList.get(i).toString().replace(" ",""),confirmedDatestring);
            }
        }

    }

    public boolean checkEditLegalEntityCreditRatingsValuesFromZeus(String agencyName,
                                                                 String type,
                                                                 String value,
                                                                 String AppliedDateDay,
                                                                 String AppliedDateMonth,
                                                                 String AppliedDateYear,
                                                                 String ConfirmedDateDay,
                                                                 String ConfirmedDateMonth,
                                                                 String ConfirmedDateYear,
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
        String appliedDate="null";
        String confirmedDate="null";
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity credit ratings from trusted", nvPairs);
        if(!AppliedDateDay.equals("") &&!AppliedDateMonth.equals("")&&!AppliedDateYear.equals(""))
        {
            appliedDate=AppliedDateDay+AppliedDateMonth+AppliedDateYear;
        }
        if(!ConfirmedDateDay.equals("") &&!ConfirmedDateMonth.equals("")&&!ConfirmedDateYear.equals(""))
        {
            confirmedDate=ConfirmedDateDay+ConfirmedDateMonth+ConfirmedDateYear;
        }
        String creditRatings=agencyName+type+value+appliedDate+confirmedDate;
        if (document != null) {

            List agencyNameList =getNodeValuesByTagName(document, "agencyName");
            List typeList = getNodeValuesByTagName(document, "type");
            List valueList =getNodeValuesByTagName(document, "value");
            List dateAppliedList =getNodeValuesByTagName(document, "dateApplied");
            List dateConfirmedList =getNodeValuesByTagName(document, "dateConfirmed");

            for(int i=0;i<agencyNameList.size();i++)
            {
                String creditRatingsFromZeus=agencyNameList.get(i).toString()+typeList.get(i).toString()+valueList.get(i).toString()+(dateAppliedList.get(i).toString().replace(" ","").toString())+(dateConfirmedList.get(i).toString().replace(" ","").toString());
                if(creditRatingsFromZeus.equals(creditRatings)) {
                    flag=true;
                    break;
                }
            }

        }
        return flag;
    }

    public void verifyEditLegalEntityCreditRatingsValuesExistInZeus(String agencyName,
                                                                 String type,
                                                                 String value,
                                                                 String AppliedDateDay,
                                                                 String AppliedDateMonth,
                                                                 String AppliedDateYear,
                                                                 String ConfirmedDateDay,
                                                                 String ConfirmedDateMonth,
                                                                 String ConfirmedDateYear,
                                                                 String fid,
                                                                 String source)
    {
        assertTrue(checkEditLegalEntityCreditRatingsValuesFromZeus(agencyName,type,value,AppliedDateDay,AppliedDateMonth,AppliedDateYear,ConfirmedDateDay,ConfirmedDateMonth,ConfirmedDateYear,fid,source));
    }

    public void verifyEditLegalEntityCreditRatingsValuesNotExistInZeus(ExamplesTable ex, String fid, String source)
    {
        assertFalse(checkEditLegalEntityCreditRatingsValuesFromZeus(ex.getRow(0).get("agencyName"),ex.getRow(0).get("type"),ex.getRow(0).get("value"),ex.getRow(0).get("AppliedDateDay"),ex.getRow(0).get("AppliedDateMonth"),ex.getRow(0).get("AppliedDateYear"),ex.getRow(0).get("ConfirmedDateDay"),ex.getRow(0).get("ConfirmedDateMonth"),ex.getRow(0).get("ConfirmedDateYear"),fid,source));
    }

    public void verifyDeleteLegalEntityTypeButtonStatus(String deleteButton) {
        assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(deleteButton)).isEnabled());
    }

    public void clickonDeleteEntityTypeRowButton(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void clickonDeleteCreditRatingsRowButton(String rowIdentifier) {
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

    public void verifyNewCreditRatingsRow(String rowIdentifier) {
        assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
    }

    public void verifyNoNewCreditRatingsRow(String rowIdentifier) {
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

    public void verifyMaxLengthCreditRatingsValueText(String maxSize,String rowIdentifier) {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);
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

    public void verifyHistoryTextAreaLength(String fid) {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_history_value_edit_xpath")).getAttribute("maxlength"), "10000");
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
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "EntityType"), getAlreadySelectedEntityTypes("legalEntity_basicInfo_entitytypes_dropdown_xpath"));
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

    public List<String> getAlreadySelectedEntityTypes(String identifier) {
        ArrayList<String> selectedValueList = new ArrayList();
        for (WebElement entityTypeDropDown : getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(identifier))) {
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

    public void clickOnLegalEntityPersonnelTypeDropdown(String webElement) {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
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

    public void verifyLegalEntityPersonnelTypeValues() {
        List<WebElement> legalEntityPersonnelType = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_type_dropdown_edit_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"getLegalEntityPersonnelTypesFromLookup.xqy");
        for (int i=1;i<document.getElementsByTagName("type").getLength();i++)
        {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), legalEntityPersonnelType.get(i).getText());
        }
    }

    public void clickNewLegalEntityLocations() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_new_locations_summary_id"));
    }

    public void clickNewLegalEntityBoardMeetings() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_add_button_id"));
    }

    public void clickNewLegalEntityPersonnel() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_add_button_id"));
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

    public void selectsTypeInLegalEntityPersonnel(String type, String webElement)
    {
        EditLegalEntityPersonnelType = type;
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(webElement));
        List<WebElement> options = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_type_dropdown_edit_xpath"));
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

    public void verifyLegalEntityHistoryInZeusDocument(String fid,String historyValue) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        if (historyValue.equals(""))
        {
            historyValue="null";
        }
        assertTrue(getNodeValuesByTagName(document, "history").contains(historyValue));
    }

    public void verifyLegalEntityBoardMeetingInZeus(String fid,String monthNumber) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity BoardMeeting", nvPairs);
        assertTrue(getNodeValuesByTagName(document, "summary").get(0).contains(EditLEgalEntityBoardmeetingSummary));
        assertTrue(getNodeValuesByTagName(document, "type").contains(EditLegalEntityBoardMeetingsType));
        assertTrue(getNodeValuesByTagName(document, "value").contains(monthNumber));
    }

    public void verifyLegalEntityPersonnelInZeus(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity personnel", nvPairs);
        assertTrue(getNodeValuesByTagName(document, "type").contains(EditLegalEntityPersonnelType));
        assertTrue(getNodeValuesByTagName(document, "value").contains(EditLegalEntityPersonnelValue));
    }

    public void entersLegalEntityValueInLocationSummary(String value) {
        EditLegalEntityLocationsValue = value;
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), value);
    }

    public void entersLegalEntityValueInPersonnel(String value) {
        EditLegalEntityPersonnelValue = value;
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_value_xpath"), value);
    }

    public void enterValueInLegalEntityHistoryTextField(String value)
    {
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_history_value_edit_xpath"), value);
    }
    public void verifyRequiredErrorMessageForTypeInLegalEntityLocations() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_location_type_error_message_xpath")).getText(), "Required");
    }

    public void enterInvalidCharactersInLegalEntityBoardMeetingSummary() {
        String strBigString = createBigString(10001);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_xpath"), strBigString);
    }

    public void enterInvalidCharactersInLegalEntityPersonnelValue() {
        String strBigString = createBigString(10001);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_value_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_value_xpath"), strBigString);
    }

    public void enterInvalidCharactersInLegalEntityLocationsValue() {
        String strBigString = createBigString(10001);
        modifyHtmlByName(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), "maxlength", "");
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_locations_summary_value_edit_xpath"), strBigString);
    }

    public void verifyErrorMessageForInvalidCharacter() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_location_value_error_message_xpath")).getText(), "Enter up to 10000 valid characters.");
    }

    public void verifyErrorMessageForLegalEntityValuePersonnel() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_value_error_message_xpath")).getText(),"Enter up to 10000 valid characters.");
    }

    public void verifyErrorMessageForLegalEntitySummaryBoardMeeting() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardMeetings_summary_error_message_xpath")).getText(),"Enter up to 10000 valid characters.");
    }

    public void verifyRequiredErrorMessageForTypeInLegalEntityPersonnel() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_personnel_type_error_message_xpath")).getText(),"Required");
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
    public void
    verifyLegalEntityIdentifierTypesListFromLookup(String rowIdentifier) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", "THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY"));
        List<String> dropdownValuesList = returnAllDropDownUnselectedValues(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity IdentifierTypes From Lookup", nvPairs);
        // finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "IdentifierType"), getAlreadySelectedEntityTypes("legalEntity_Identifier_All_Types_dropdown_xpath"));
        assertEquals(dropdownValuesList, resultList);

    }
    public void clickOnLegalEntityIdentifierStatus() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("LegalEntity_Identifier_status_xpath"));
    }

    public void verifyLegalEntityIdentifierStatusList(String rowIdentifier) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", "STATUS"));
        List<String> dropdownValuesList = returnAllListValues(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity IdentifierStatus From Lookup", nvPairs);
        assertEquals(dropdownValuesList, getNodeValuesByTagName(document, "IdentifierStatus"));
    }

    public void clickOnAddNewIdentifiersButton() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_add_new_identifiers_button_xpath"));
    }

    public void selectIdentifierType(String identifierTypeValue, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)));
        if (dropdown.getFirstSelectedOption().getText()!=identifierTypeValue) {
            dropdown.selectByVisibleText(identifierTypeValue);
        } else {assertFalse("dropdown selection value passed from story is the same as the one on the webpage",true);}

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
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);

        if (document != null) {
            List typeList =getNodeValuesByTagName(document, "legalEntityIdentifierType");
            List valueList = getNodeValuesByTagName(document, "legalEntityIdentifierValue");
            List statusList =getNodeValuesByTagName(document, "legalEntityIdentifierStatus");

            for(int i=0;i<typeList.size();i++)
            {
                WebElement type=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[1]/select"));
                WebElement value=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[2]/input"));
                WebElement status=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Basic_Info_Table")).get(i).findElement(By.xpath("td[3]/select"));
                assertEquals(typeList.get(i),(new Select(type)).getFirstSelectedOption().getAttribute("value"));
                assertEquals(statusList.get(i),(new Select(status)).getFirstSelectedOption().getAttribute("value"));
                assertEquals(valueList.get(i),value.getAttribute("value"));
            }
        }

    }

    public void selectIdentifierStatus(String identifierStatus, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByValue(identifierStatus);

    }

    public void enterIdentifierValue(String identifierValueRowIdentifier,String value){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(identifierValueRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(identifierValueRowIdentifier)).sendKeys(value);
    }

    public boolean checkEditLegalEntityIdentifierValuesFromZeus(String type,
                                                               String status,
                                                               String value,
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
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        String identifiersFromUI=type+value+status;
        if (document != null) {

            List typeList =getNodeValuesByTagName(document, "legalEntityIdentifierType");
            List valueList = getNodeValuesByTagName(document, "legalEntityIdentifierValue");
            List statusList =getNodeValuesByTagName(document, "legalEntityIdentifierStatus");

            for(int i=0;i<typeList.size();i++)
            {
                String identifiersFromZeus=typeList.get(i).toString()+valueList.get(i).toString()+statusList.get(i).toString();
                if(identifiersFromZeus.equals(identifiersFromUI)) {
                    flag=true;
                    break;
                }
            }


        }
        return flag;
    }

    public void verifyEditLegalEntityIdentifierValuesFromZeus(String type,String status,String value,String fid,String source)
    {
        assertTrue(checkEditLegalEntityIdentifierValuesFromZeus(type,status,value,fid,source));
    }

    public void clickOnIdentifierDeleteRowButton(String rowIdentifier) {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
    }

    public void pressEnterButtonInDeleteConfirmationModal() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_identifier_delete_yes_button_id"));
    }

    public void verifyIdentifierValuesNotExistInZEUS(String fid,String source,ExamplesTable identifiers) {
        assertFalse(checkEditLegalEntityIdentifierValuesFromZeus(identifiers.getRow(0).get("identifierType"),identifiers.getRow(0).get("value"),identifiers.getRow(0).get("identifierStatus"),fid,source));

    }


    public void verifyNewlyAddedIdentifierRowIsDisplayed(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void enter50CharactersInIdentifierValueField() {
        String strBigString = createBigString(50);
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_first_row_new_identifier_value")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_first_row_new_identifier_value")));
    }

    public void verifyMaxlengthIdentifierValueText(String maxSize,String rowIdentifier) {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);
    }


    public void verifyLegalEntityIdentifierValueErrorMessageForMaxLength() {
        assertEquals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_first_row_new_identifier_value")).getText(), "Enter up to 50 valid characters");

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

    public void verifyOwnershipTypeFromLookup(String rowIdentifier,String lookupfid){

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("lookupfid", lookupfid));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get LegalEntity OwnershipType From Lookup", nvPairs);
        List<String> dropdownValuesList = returnAllListValues(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
        assertEquals(dropdownValuesList, getNodeValuesByTagName(document, "OwnershipType"));
    }

    public void clickAddNewOwnershipButton(){
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_ownershipsummaries_add_button_id"));
    }

    public void verifyOwnershipSummaryFromTrusted(String source,String fid)
    {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);

        if (document != null) {
            List ownershipTypeList =getNodeValuesByTagName(document, "ownershipSummaryType");
            List ownershipValueList = getNodeValuesByTagName(document, "ownershipSummaryValue");


            for(int i=0;i<ownershipTypeList.size();i++)
            {
                WebElement ownershipType=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_OwnershipSummary_Table")).get(i).findElement(By.xpath("td[1]/select"));
                WebElement ownershipValue=getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_Edit_OwnershipSummary_Table")).get(i).findElement(By.xpath("td[2]/textarea"));
                assertEquals(ownershipTypeList.get(i),(new Select(ownershipType)).getFirstSelectedOption().getAttribute("value"));
                assertEquals(ownershipValueList.get(i),ownershipValue.getAttribute("value"));
            }
        }
    }



    public void selectOwnershipType(String ownershipType,String rowIdentifier){
        selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier),ownershipType);
    }

    public void enterOwnershipValue(String value,String rowIdentifier){
        clearAndEnterValue(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier),value);
    }
    public void verifyOwnershipSummaryFromZeus(String ownershipType,String value, String fid,String source){
        assertTrue(checkOwnershipSummaryFromZeus(ownershipType, value, fid,source));
    }

    public boolean checkOwnershipSummaryFromZeus(String ownershipType,String value,String fid,String source)
    {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        String ownershipSummaryFromUI=ownershipType+value;
        if (document != null) {

            List ownershipTypeList =getNodeValuesByTagName(document, "ownershipSummaryType");
            List ownershipValueList = getNodeValuesByTagName(document, "ownershipSummaryValue");


            for(int i=0;i<ownershipTypeList.size();i++)
            {
                String ownershipSummaryFromZeus=ownershipTypeList.get(i).toString()+ownershipValueList.get(i).toString();
                if(ownershipSummaryFromZeus.equals(ownershipSummaryFromUI)) {
                    flag=true;
                    break;
                }
            }


        }
        return flag;
    }

    public void clickOnDeleteOwnershipSummaryButton(String rowIdentifier){
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
    }

    public void verifyOwnershipSummaryValuesNotExistInZEUS(String fid,String source,ExamplesTable ownershipSummaries){
        assertFalse(checkOwnershipSummaryFromZeus(ownershipSummaries.getRow(0).get("ownershipType"), ownershipSummaries.getRow(0).get("value"), fid,source));
    }


    public void verifyOwnershipSummaryValueMaxLength(String maxlength,String rowIdentifier)
    {
        assertEquals(maxlength,getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"));
    }

    public void verifyRequiredErrorMsgForOwnershipSummary(String reqMsg,String rowIdentifier){
        assertEquals(reqMsg,getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).getText());
    }

    public void verifyCategoryDropdownValuesFromLookup(String row_Identifier,String lookupFid){
        List<NameValuePair> nvPairs = new ArrayList<>();
        List<String> dropdownValuesList = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(row_Identifier)));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        for (WebElement option : dropdown.getOptions()) {
            dropdownValuesList.add(option.getAttribute("value"));
        }
        dropdownValuesList.remove(selectedValue);
        if (dropdownValuesList.get(0).equals("")) {
            dropdownValuesList.remove(0);
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Services From Lookup", nvPairs);
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "serviceCategory"), getAlreadySelectedValuesInAllRowsForADropdown(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_offeredservices_category_dropdown")));
        assertEquals(dropdownValuesList, resultList);

        }

        public void verifyFinancialCategoryDropdownValuesFromLookup(String row_Identifier,String lookup){
            List<NameValuePair> nvPairs = new ArrayList<>();
            List<String> dropdownValuesList = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", lookup));
            Select dropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(row_Identifier)));
            String selectedValue = dropdown.getFirstSelectedOption().getText();
            for (WebElement option : dropdown.getOptions()) {
                dropdownValuesList.add(option.getAttribute("value"));
            }
            dropdownValuesList.remove(selectedValue);
            if (dropdownValuesList.get(0).equals("")) {
                dropdownValuesList.remove(0);
            }
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Services From Lookup", nvPairs);
            List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "FinancialCategory"), getAlreadySelectedValuesInAllRowsForADropdown(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_financial_category_dropdown")));
            assertEquals(dropdownValuesList, resultList);
        }
        public void verifyFinancialDetailsDropdownValuesFromLookup(String row_Identifier,String lookup,String categoryLookup){
            List<String> financialCategoryDropdowndropDownValues = new ArrayList<>();
            Select financialCategoryDropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(categoryLookup)));
            for (WebElement option1 : financialCategoryDropdown.getOptions()) {
                financialCategoryDropdowndropDownValues.add(option1.getText());
            }
            for(int i=0;i<financialCategoryDropdowndropDownValues.size();i++){
                List<String> dropdownValuesList = new ArrayList<>();
                if(!financialCategoryDropdowndropDownValues.get(i).equals("")) {
                    financialCategoryDropdown.selectByVisibleText(financialCategoryDropdowndropDownValues.get(i));
                    List<NameValuePair> nvPairs = new ArrayList<>();
                    nvPairs.add(new BasicNameValuePair("fid", lookup));
                    nvPairs.add(new BasicNameValuePair("financialCategory",financialCategoryDropdowndropDownValues.get(i)));
                    Select financialDetailsDropdown = new Select(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(row_Identifier)));
                    for (WebElement option : financialDetailsDropdown.getOptions()) {
                        dropdownValuesList.add(option.getAttribute("value"));
                    }
                    if (dropdownValuesList.get(0).equals("")) {
                        dropdownValuesList.remove(0);
                    }
                    Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Services From Lookup", nvPairs);
                    List test=getAlreadySelectedValuesInAllRowsForADropdown(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_financial_details_dropdown"));
                    test.remove(financialDetailsDropdown.getFirstSelectedOption().getAttribute("value"));
                    List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "FinancialCategoryDetails"), test);
                    assertEquals(dropdownValuesList, resultList);
                }
            }
        }

    public void verifyCreditRatingValuesFromLookup(String rowIdentifier,String lookupFid)
    {   List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> creditRatingsList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity CreditRatings From Lookup", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("CreditRatings").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), creditRatingsList.get(i).getAttribute("value"));
        }


    }
    public void clickAddRowButton() {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_credit_rating_addRow_id"));
    }

    public void selectCreditRatingsAgencyName(String agencyRowIdentifier,String agencyName){
        selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(agencyRowIdentifier),agencyName);
    }

    public void selectCreditRatingsAgencyType(String agencyTypeRowIdentifier,String agencyType){
        selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(agencyTypeRowIdentifier),agencyType);
    }

    public void enterCreditRatingsAgencyValue(String agencyValueRowIdentifier,String value){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyValueRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyValueRowIdentifier)).sendKeys(value);
    }

    public void enterCreditRatingsAgencyAppliedDateDay(String agencyAppliedDateDayRowIdentifier,String AppliedDateDay){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyAppliedDateDayRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyAppliedDateDayRowIdentifier)).sendKeys(AppliedDateDay);
    }
    public void selectCreditRatingsAgencyAppliedDateMonth(String agencyAppliedDateMonthRowIdentifier,String AppliedDateMonth){
        selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(agencyAppliedDateMonthRowIdentifier),AppliedDateMonth);
    }
    public void enterCreditRatingsAgencyAppliedDateYear(String agencyAppliedDateYearRowIdentifier,String AppliedDateYear){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyAppliedDateYearRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyAppliedDateYearRowIdentifier)).sendKeys(AppliedDateYear);

    }
    public void enterCreditRatingsAgencyConfirmedDateDay(String agencyConfirmedDateDayRowIdentifier,String ConfirmedDateDay){
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyConfirmedDateDayRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyConfirmedDateDayRowIdentifier)).sendKeys(ConfirmedDateDay);

    }
    public void selectCreditRatingsAgencyConfirmedDateMonth(String agencyConfirmedDateMonthRowIdentifier,String ConfirmedDateMonth){
        selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(agencyConfirmedDateMonthRowIdentifier),ConfirmedDateMonth);
    }
    public void enterCreditRatingsAgencyConfirmedDateyear(String agencyConfirmedDateYearRowIdentifier,String ConfirmedDateYear){

        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyConfirmedDateYearRowIdentifier)).clear();
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(agencyConfirmedDateYearRowIdentifier)).sendKeys(ConfirmedDateYear);
    }

    public void verifyCreditRatingsErrorMessage(String xpathIdentifier,String errorMsg)
    {
        assertEquals(getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    }

    public void verifyAppliedDateErrorMessage(String appliedDateErrorMsg) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(appliedDateErrorMsg.replace("'", ""), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_appliedDate_errorMessage_xpath")).getText());
    }

    public void verifyConfirmedDateErrorMessage(String confirmedDateErrorMsg) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(confirmedDateErrorMsg.replace("'", ""), getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_confirmedDate_errorMessage_xpath")).getText());
    }

    public void clickAddOfferedServiceButton(){
            attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_add_oferedservices_button"));
        }
        public void clickAddFinancialServiceButton(){
            attemptClick(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_add_financialservices_button"));
        }
        public void selectFinancialCategoryValue(String row_Identifier,String financialCategory){}

        public void verifyLegalEntityServiceValuesFromTrusted(String fid,String source)
        {
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", fid));
            nvPairs.add(new BasicNameValuePair("source", source));
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Services From DB", nvPairs);

            if (document != null) {
                List serviceCategoryList =getNodeValuesByTagName(document, "serviceCategory");
                List overrideList = getNodeValuesByTagName(document, "customDescription");
                List financialCategoryList =getNodeValuesByTagName(document, "financialCategory");
                List financialDetailsList =getNodeValuesByTagName(document, "detail");
                String overrideValue;
                for(int i=0;i<serviceCategoryList.size();i++) {
                    WebElement serviceCategory = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_offeredservices_table")).get(i).findElement(By.xpath("td/select"));
                    WebElement override = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_offeredservices_table")).get(i).findElement(By.xpath("td/input"));
                    overrideValue=overrideList.get(i).toString();
                    if(overrideValue.equals("null"))
                    {
                        overrideValue="";
                    }
                    assertEquals(serviceCategoryList.get(i), (new Select(serviceCategory)).getFirstSelectedOption().getText());
                    assertEquals(overrideValue, override.getAttribute("value"));
                }

                for(int i=0;i<financialCategoryList.size();i++) {
                    WebElement financialCategory = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_financialservices_table")).get(i).findElement(By.xpath("td[1]/select"));
                    WebElement financialDetails = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_financialservices_table")).get(i).findElement(By.xpath("td[2]/select"));
                    assertEquals(financialCategoryList.get(i), (new Select(financialCategory)).getFirstSelectedOption().getText());
                    assertEquals(financialDetailsList.get(i), (new Select(financialDetails)).getFirstSelectedOption().getText());
                }

            }
        }

        public void selectlegalEntityServices(String category,String rowIdentifier){
            selectItemFromDropdownListByText(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier),category);
        }

        public void enterlegalEntityServicesOverride(String category,String rowIdentifier){
            getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).clear();
            getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).sendKeys(category);
        }

    public boolean checkLegalEntityServiceValuesFromZeus(String fid,String source,String category,String override,String financialCategory,String financialDetails){

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean offeredServicesflag=false;
        Boolean financialServicesflag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity Services From DB", nvPairs);
        List serviceCategoryList = getNodeValuesByTagName(document, "serviceCategory");
        List overrideList = getNodeValuesByTagName(document, "customDescription");
        List financialCategoryList = getNodeValuesByTagName(document, "financialCategory");
        List financialDetailsList = getNodeValuesByTagName(document, "detail");
        for (int i = 0; i < serviceCategoryList.size(); i++) {

                String categoryAndOverridePair = serviceCategoryList.get(i).toString() + overrideList.get(i).toString();
                if (categoryAndOverridePair.equals(category.toString() + override.toString())) {
                    offeredServicesflag = true;
                    break;
                }
            }
        for (int i = 0; i < financialCategoryList.size(); i++) {

            String financialcategoryAndDetailsPair=financialCategoryList.get(i).toString()+financialDetailsList.get(i).toString();
            if (financialcategoryAndDetailsPair.equals(financialCategory.toString() + financialDetails.toString())) {
                financialServicesflag = true;
                break;
            }
        }
        return offeredServicesflag&financialServicesflag;

    }

    public void verifyLegalEntityServiceValuesFromZeus(String fid,String source,String category,String override,String financialCategory,String financialDetails) {
        assertTrue(checkLegalEntityServiceValuesFromZeus(fid, source, category, override, financialCategory, financialDetails));
    }

    public void verifyLegalEntityServiceValuesNotExistInZeus(String fid,String source,String category,String override,String financialCategory,String financialDetails) {
        assertFalse(checkLegalEntityServiceValuesFromZeus(fid, source, category, override, financialCategory, financialDetails));
    }

    public void clickServicesDeleteRowButton(String rowIdentifier)
    {
        attemptClick(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier));
    }

    public void verifyNoNewServicesRow(String rowIdentifier){
        try {
            assertFalse(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {

        }

    }

    public void verifyRequiredMessage(String reqMessage,String reqMsgXpath)
    {
        assertTrue(reqMessage.equals(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(reqMsgXpath)).getText()));
    }

    public void verifyMaxLengthForOverrideTextField(String maxlength,String rowIdentifier)
    {
        assertEquals(maxlength,getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"));
    }

    public void deleteAllLegalEntityRows(By by) {
        int numberOfRows = getDriver().findElements(by).size();
        for (int buttonCount = 0; buttonCount < numberOfRows; buttonCount++) {
            getDriver().findElements(by).get(0).click();
            attemptClick(LegalEntityIdentifiers.getObjectIdentifier("delete_confirmation_yes_button_id"));
        }
    }

    public void clickonDeleteBoardMeetingsRowButton(String rowIdentifier) {
        getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

       public void verifyEditLegalEntityBoardMeetingsValuesNotExistInZeus(ExamplesTable ex, String fid, String source)
    {
        assertFalse(checkEditLegalEntityBoardMeetingsValuesFromZeus(ex.getRow(0).get("type"),ex.getRow(0).get("value"),fid,source));

    }
    public void verifyNewlyAddedBoardMeetingRowIsNotDisplayed() {
            try
        {
            WebElement identifier = getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_boardmeeting_type_view_mode"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkEditLegalEntityBoardMeetingsValuesFromZeus(String type,String value,String fid,String source)
    {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity board meetings", nvPairs);
        String boardMeetings=type+value;
        if (document != null) {

            List typeList = getNodeValuesByTagName(document, "type");
            List valueList =getNodeValuesByTagName(document, "value");

            for(int i=0;i<typeList.size();i++)
            {
                String boardMeetingsfromZeus=typeList.get(i).toString()+valueList.get(i).toString();
                if(boardMeetingsfromZeus.equals(boardMeetings)) {
                    flag=true;
                    break;
                }
            }

        }
         return flag;

    }
    @Override
    public String getPageUrl() {
        return null;
    }
}
