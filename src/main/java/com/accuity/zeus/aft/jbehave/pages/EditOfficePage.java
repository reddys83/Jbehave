package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.utils.SimpleCacheManager;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.springframework.http.ResponseEntity;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.*;



public class EditOfficePage extends AbstractPage {

    static ResponseEntity responseEntity;
    static String endpointWithID;
    public static String selectedEntity = "";
    public String EditSortNameValue = "";
    public String EditOfficeSortName = "";
    public static String officeHistoryMaximumCharacter = null;
    public static String addressLine1SecondPrimaryFlag = null;
    public static String addressLine1FirstPrimaryFlag = null;


    public EditOfficePage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }


    public void clearAndEnterValue(By webElement, String value) {
        getDriver().findElement(webElement).clear();
        getDriver().findElement(webElement).sendKeys(value);

    }

    public void updateOfficeOpenedDate(String day, String month, String year) {

        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_day_xpath"), day);
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_month_xpath"), month);
        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_year_xpath"), year);
    }

    public void verifyOpenedDateErrorMessage(String openedDateErrorMsg) {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(openedDateErrorMsg.replace("'", ""), getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_errorMessage_xpath")).getText());
    }


    public void verifyUpdatedOfficeOpenedDate(String officeFid, String day, String month, String year, String source) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", officeFid));
        zeusPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", zeusPairs);
        assertEquals(document.getElementsByTagName("officeOpenedDate").item(0).getTextContent(), getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_view_xpath")).getText());
        assertEquals(document.getElementsByTagName("officeOpenedDate").item(0).getTextContent().replace(" ", ""), day + month + year);
    }

    public void enterValueinTextField(String identifier,String value){

        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier(identifier),value);
    }
    public void verifyPrefixSuffixAndOverrideValuesFromZeus(String fid,ExamplesTable values)
    {
        List<NameValuePair> nvPairs = new ArrayList<>();
        String prefixValue_zeus="";
        String suffixValue_zeus="";
        String overrideValue_zeus="";
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        if (document != null) {
         prefixValue_zeus = getNodeValuesByTagName(document, "officePrefixValue").size() == 0 ? "" : getNodeValuesByTagName(document, "officePrefixValue").get(0);
         suffixValue_zeus = getNodeValuesByTagName(document, "officeSuffixValue").size() == 0 ? "" : getNodeValuesByTagName(document, "officeSuffixValue").get(0);
         overrideValue_zeus = getNodeValuesByTagName(document, "officeOverrideValue").size() == 0 ? "" : getNodeValuesByTagName(document, "officeOverrideValue").get(0);
    }
       // check the values from zeus document with the expected values
        assertEquals(prefixValue_zeus.toString(), values.getRow(0).get("prefix"));
        assertEquals(suffixValue_zeus.toString(), values.getRow(0).get("suffix"));
        assertEquals(overrideValue_zeus.toString(), values.getRow(0).get("override"));

        // check the values from UI with the expected values

        assertEquals(getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_prefix_xpath")), values.getRow(0).get("prefix"));
        assertEquals(getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_suffix_xpath")), values.getRow(0).get("suffix"));
        assertEquals(getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_override_xpath")), values.getRow(0).get("override"));

    }

    public void verifyMaxLength(String identifier,String maxLength){
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(identifier)).getAttribute("maxLength"),maxLength);
    }

    public void verifyOfficesNameTypesFromLookup(String rowIdentifier, String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> officeTypesList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(rowIdentifier));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office name types from Lookup", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("officeNameTypes").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), officeTypesList.get(i).getAttribute("value"));
        }

    }

    public void clickAddRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_name_addRow_id"));
    }

    public void verifyEditOfficeNameValuesFromTrusted(String officeFid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);

        if (document != null) {
            List typeList = getNodeValuesByTagName(document, "officeType");
            List valueList = getNodeValuesByTagName(document, "officeValue");

            for (int i = 1; i < typeList.size(); i++) {
                WebElement type = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(i + 1).findElement(By.xpath("td/select"));
                WebElement value = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(i + 1).findElement(By.xpath("td/input"));
                assertEquals(typeList.get(i), (new Select(type)).getFirstSelectedOption().getText());
                assertEquals(valueList.get(i), value.getAttribute("value"));
            }
            assertEquals(typeList.get(0), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(1).findElement(By.xpath("td")).getText());
            assertEquals(valueList.get(0), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(1).findElement(By.xpath("td/input")).getAttribute("value"));

        }
    }

    public void selectOfficeNameType(String officeNameTypeRowIdentifier, String type) {
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier(officeNameTypeRowIdentifier), type);
    }

    public void enterOfficeNameValue(String officeNameValueRowIdentifier, String value) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(officeNameValueRowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(officeNameValueRowIdentifier)).sendKeys(value);
    }


    public void verifyEditOfficeNameValuesExistInZeusandinUI(String type, String value, String officeFid, String source) {
        assertTrue(checkEditOfficeNameValuesFromZeus(type, value, officeFid, source));
        boolean flag=false;
       List<WebElement> officeNameRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_names_type_mode"));
        for (int i = 0; i < officeNameRows.size(); i++) {

          if(type.equals(officeNameRows.get(i).findElements(By.tagName("td")).get(0).getText())){
               if(value.equals(officeNameRows.get(i).findElements(By.tagName("td")).get(1).getText())) {
                  flag=true;
              }
            }

             }
        assertTrue(flag);
    }

    public boolean checkEditOfficeNameValuesFromZeus(String type,String value,String officeFid,String source) {

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        String officeName=type+value;
                if (document != null) {

            List typeList = getNodeValuesByTagName(document, "officeType");
            List valueList =getNodeValuesByTagName(document, "officeValue");

            for(int i=0;i<typeList.size();i++)
            {
                String officeNameFromZeus=typeList.get(i).toString()+valueList.get(i).toString();
                if(officeNameFromZeus.equals(officeName)) {
                    flag=true;
                    break;
                }
            }

        }
        return flag;
    }

    public void verifyOfficeNameValueErrorMessage(String xpathIdentifier,String errorMsg)
    {
        assertEquals(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    }

    public void clickonDeleteOfficeNamesRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyEditOfficeNameValuesNotExistInZeus(String officeFid,String source,ExamplesTable names) {
        assertFalse(checkEditOfficeNameValuesFromZeus(names.getRow(0).get("type"),names.getRow(0).get("value"),officeFid,source));

    }

    public void verifyNoNewOfficeNameRow(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }

    }

    public void verifyDeleteButtonForOfficeLegalTitle() {
        try {
            assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_name_delete_button_for_legalTitle_edit_xpath")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyMaxlengthOfficeNameValueText(String maxSize,String rowIdentifier) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);
    }

    public void verifyMaxlengthOfficeNameSortNameText(String maxSize) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_name_sort_name_xpath")).getAttribute("maxlength"), maxSize);
    }

    public void entersSortNameInOfficeName(String sortName) {
        EditSortNameValue = sortName;
        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_name_sort_name_xpath"), sortName);
    }

    public void verifyOfficeSortNameInZeusDocumentAndInUI(String officeFid,String sortName) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        if (sortName.equals(""))
        {
            sortName="null";
        }
        assertTrue(getNodeValuesByTagName(document, "officeSortKey").contains(sortName));
        assertEquals(sortName,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_name_sort_name_view")));


    }

    public void selectOfficeLeadLocationFlag(String leadLocationflag) {
        selectRadioButtonByValue(OfficeIdentifiers.getObjectIdentifier("office_leadlocation_radio_options_xpath"), leadLocationflag);
    }
    public void clickOnNewOfficeTypeDropDown(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();

    }

    public List<String> getAlreadySelectedOfficeTypes(String identifier) {
        ArrayList<String> selectedValueList = new ArrayList();
        for (WebElement officeTypeDropDown : getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(identifier))) {
            Select dropdown = new Select(officeTypeDropDown);
            String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
            selectedValueList.add(selectedValue);
        }
        return selectedValueList;
    }

    public void verifyOfficeTypeListFromLookup(String lookupFid, String rowIdentifier) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        List<String> dropdownValuesList = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        Select dropdown = new Select(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        for (WebElement option : dropdown.getOptions()) {
            dropdownValuesList.add(option.getText());
        }
        dropdownValuesList.remove(selectedValue);
        if (dropdownValuesList.get(0).equals("")) {
            dropdownValuesList.remove(0);
        }
        // finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get offices office types", nvPairs);
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "OfficeType"), getAlreadySelectedOfficeTypes("office_basicInfo_officetypes_dropdown_xpath"));
        assertEquals(dropdownValuesList, resultList);

    }

    public void clickOnAddNewOfficeTypeButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_add_new_officetype_button_id"));
    }


    public void verifyEditOfficesOfficeTypeValueFromTrusted(String officeFid, String tagName, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        if (document != null) {
            assertEquals(getNodeValuesByTagName(document, tagName), getAlreadySelectedOfficeTypes("office_basicInfo_officetypes_dropdown_xpath"));
        }

    }

    public void selectOfficeType(String officeTypeValue, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByVisibleText(officeTypeValue);

    }


    public void verifyEditOfficesOfficeTypeValueFromZeusAndInUI(String officeTypeValue, String tagName, String officeFid, String source, String xqueryName) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        if (document != null && !officeTypeValue.isEmpty()) {
            assertTrue(getNodeValuesByTagName(document, tagName).contains(officeTypeValue));

            Boolean flag=false;
            List<WebElement> officeTypes = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("basic_info_office_type_xpath"));

                for (int j=0;j<officeTypes.size();j++){
                    if(officeTypeValue.equals(officeTypes.get(j).getText()))
                    {
                        flag=true;
                        break;
                    }
                    assertTrue(flag);
                }


            //assertEquals(officeTypeValue,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("first_existing_officetype_dropdown")));

        } else if (document != null && officeTypeValue.isEmpty()) {
            assertFalse(getNodeValuesByTagName(document, tagName).contains(officeTypeValue));
           assertEquals(officeTypeValue,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("basic_info_office_type_xpath")));
        }

    }

    public void verifyOfficeTypeNotPresentInZeusAndInUI(String source, String officeFid, String tagName, String officeTypeValue) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);

            assertFalse(getNodeValuesByTagName(document, tagName).contains(officeTypeValue));

            Boolean flag = false;
            List<WebElement> officeTypes = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("basic_info_office_type_xpath"));

            for (int j = 0; j < officeTypes.size(); j++) {
                if (officeTypeValue.equals(officeTypes.get(j).getText())) {
                    flag = true;
                    break;
                }
                assertFalse(flag);
            }
        }

     public void verifyDeleteOfficeTypeButtonStatus(String delete_button) {
        assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(delete_button)).isEnabled());
    }

    public void clickonDeleteOfficeTypeRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyExistingOfficeTypeRow(String rowIdentifier, String dropdownvalue) {
        assertTrue(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        Select dropdown = new Select(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)));
        assertEquals(dropdown.getFirstSelectedOption().getText(), dropdownvalue);
    }

    public void verifyNoExistingOfficeTypeRow(String rowIdentifier, String dropdownvalue) {
        Select dropdown = new Select(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)));
        assertFalse(dropdown.getFirstSelectedOption().getText().equalsIgnoreCase(dropdownvalue));

    }

    public void verifyNewOfficeTypeRow(String rowIdentifier) {
        assertTrue(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
    }

    public void verifyNoNewOfficeTypeRow(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }

    }

    public void deleteAllOfficeTypeRowsExceptRow1() {
        int numberOfRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_officetypes_delete_button_xpath")).size();
        for (int buttonCount = 1; buttonCount < numberOfRows; buttonCount++) {
            getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_officetypes_delete_button_xpath")).get(1).click();
            attemptClick(OfficeIdentifiers.getObjectIdentifier("delete_confirmation_yes_button_id"));
        }
    }

    public void verifyErrorMsgRequiredForOfficeType() {
        assertEquals(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_office_type_error_msg_xpath")).size(), 1);
        assertEquals("Required", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_office_type_error_msg_xpath")).getText());
    }

    public void enterNullValueForAllOfficeTypeRows() {
        int numberOfRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_officetypes_dropdown_xpath")).size();
        for (int entityTypesCount = 0; entityTypesCount < numberOfRows; entityTypesCount++) {
            Select dropdown = new Select(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_officetypes_dropdown_xpath")).get(entityTypesCount));
            dropdown.selectByVisibleText("");
        }
    }


    public void verifyLeadLocationValuefromZeusDocumentAndUI(String leadLocationflag, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getLeadLocationFlagFromDB(selectedEntity, source), leadLocationflag);
        assertEquals(leadLocationflag, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_leadlocation_xpath")));


    }

    public String getLeadLocationFlagFromDB(String officeFid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String leadLocationDBValue = getNodeValuesByTagName(document, "leadLocation").size() == 0 ? "" : getNodeValuesByTagName(document, "leadLocation").get(0);
        return leadLocationDBValue;
    }

    public void changeAlternateRadioButtonValue(String identifier) {
        String newleadInstitutionflag = "";
        String selectedRadioValue = getSelectedRadioValue(OfficeIdentifiers.getObjectIdentifier(identifier));
        if (selectedRadioValue.equalsIgnoreCase("true")) {
            newleadInstitutionflag = "false";
        } else if (selectedRadioValue.equalsIgnoreCase("false")) {
            newleadInstitutionflag = "true";
        }
        selectRadioButtonByValue(OfficeIdentifiers.getObjectIdentifier(identifier), newleadInstitutionflag);
    }

    public void verifyOfficeEditPageMode() {
        assertTrue(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_month_xpath")).size() > 0);
    }

    public void selectForeignOfficeFlag(String foreignOfficeflag) {
        selectRadioButtonByValue(OfficeIdentifiers.getObjectIdentifier("office_foreignoffice_radio_options_xpath"), foreignOfficeflag);
    }

    public void verifyForeignOfficeValuefromZeusDocumentandUI(String foreignOfficeflag, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getForeignOfficeFlagFromDB(selectedEntity, source), foreignOfficeflag);
        assertEquals(foreignOfficeflag, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_foreignoffice_xpath")));

    }

    public String getForeignOfficeFlagFromDB(String officeFid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String leadLocationDBValue = getNodeValuesByTagName(document, "foreignOffice").size() == 0 ? "" : getNodeValuesByTagName(document, "foreignOffice").get(0);
        return leadLocationDBValue;
    }

    public String getOfficeValuesFromDB(String officeFid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        String statusValue = "";
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", nvPairs);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (document != null) {
            statusValue = getNodeValuesByTagName(document, "additionalInfo").size() == 0 ? "" : getNodeValuesByTagName(document, "additionalInfo").get(0);
        }
        return statusValue;
    }

    public void enterOfficeAdditionalInfo(String additionalInfoText) {
        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath"), additionalInfoText);

    }

    public void verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(String additionalInfoText, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getOfficeValuesFromDB(selectedEntity, source), additionalInfoText);
        assertEquals(additionalInfoText, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_view_xpath")));

    }

    public void verifyOfficeAdditionalInfoTextAreaLength(String officeFid) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")).getAttribute("maxlength"), "10000");
    }

    public void enter10000CharactersInOfficeAdditionalInfo(String officeFid) {
        String strBigString = createBigString(10000);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")));
    }

    public void verifyAdditionalInfoValueWithMaxLengthFromZeus(String officeFid, String selectedEntity, String source) {
        assertEquals(getOfficeValuesFromDB(selectedEntity, source), bigString);

    }


    public void verifyAddOfficeLocationButtonStatus(String add_button) {
        assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(add_button)).isEnabled());
    }

    public void verifyDeleteOfficeAddressButtonStatus(String delete_button) {
        assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(delete_button)).isEnabled());
    }


    public void clickonDeleteOfficeLocationsRowButton(String rowIdentifier)
    {
        try {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
        } catch (NoSuchElementException e) {
        }

    }

    public void verifyOfficeLocationRowIsNotDisplayed() {
        try {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_location_delete_row_edit_mode"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNoNewOfficeLocationRow(String rowIdentifier) {
        try {
            assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).isDisplayed());
        } catch (NoSuchElementException e) {
        }

    }

    public void selectPrimaryFlag(String primaryFlag) {
        selectRadioButtonByValue(OfficeIdentifiers.getObjectIdentifier("office_location_primary_flag_radio_options"), primaryFlag);
    }

    public void clickOnAddAddressRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_address_addRow_id"));
    }

    public void selectOfficeAddressType(String typeRowIdentifier, String Type) {
        Select dropdown = new Select(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier)));
        if (dropdown.getFirstSelectedOption().getText()!=Type) {
            dropdown.selectByVisibleText(Type);
        } else {assertFalse("dropdown selection value passed from story is the same as the one on the webpage",true);}

    }
    public void enterofficeAddressLine1(String addressLine1RowIdentifier, String AddressLine1) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine1RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine1RowIdentifier)).sendKeys(AddressLine1);

    }

    public void enterofficeAddressLine2(String addressLine2RowIdentifier, String AddressLine2) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine2RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine2RowIdentifier)).sendKeys(AddressLine2);

    }

    public void enterofficeAddressLine3(String addressLine3RowIdentifier, String AddressLine3) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine3RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine3RowIdentifier)).sendKeys(AddressLine3);

    }

    public void enterofficeAddressLine4(String addressLine4RowIdentifier, String AddressLine4) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine4RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine4RowIdentifier)).sendKeys(AddressLine4);

    }
    public void clickOnCountryListBox() {

        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_country_dropdown"));
           }

       public CountryPage enterOfficeCountryInTheTypeAheadBox(String Country) {
           SimpleCacheManager.getInstance().put("selectedCountry", Country);
           selectedEntity = Country;
           getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_country_type_ahead")).sendKeys(Country);
           getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_country_type_ahead")).sendKeys(Keys.RETURN);
           try {
               Thread.sleep(1000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return new CountryPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
       }


    public void enterOfficeCityInTheTypeAheadBox(String City) {
        SimpleCacheManager.getInstance().put("selectedCity", City);
        selectedEntity = City;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_city_type_ahead")).sendKeys(City);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_city_type_ahead")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickOnAreaListBox() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown"));
    }

    public void verifyOfficeAreaList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get area list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
            assertEquals(document.getElementsByTagName("area").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown")).get(i).getText());

        }
    }


    public void  enterOfficeAreaInTypeAhead(String Area) {
        SimpleCacheManager.getInstance().put("selectedArea", Area);
        selectedEntity = Area;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_type_ahead")).sendKeys(Area);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_type_ahead")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            }

    public void verifyOfficeSubAreaList(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get subarea list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("subarea").getLength(); i++) {
            assertEquals(document.getElementsByTagName("subarea").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown")).get(i).getText());
        }
    }

    public void clickOnSubAreaListBox() {

        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown"));
    }

    public void enterOfficeSubAreaInTypeAhead(String subArea) {
        SimpleCacheManager.getInstance().put("selectedsubArea", subArea);
        selectedEntity = subArea;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_typeAhead")).sendKeys(subArea);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_typeAhead")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyCitiesForSelectedSubArea(ExamplesTable cities) {
        List<WebElement> citiesCollection = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list"));
        for (int i = 0; i < cities.getRowCount(); i++) {
            assertEquals(cities.getRow(i).get(cities.getHeaders().get(0)), citiesCollection.get(i).getText());
        }
    }

     public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        List<WebElement> areasCollection = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list"));
        for (int i = 0; i < areas.getRowCount(); i++) {
            assertEquals(areas.getRow(i).get(areas.getHeaders().get(0)), areasCollection.get(i).getText());
        }
    }


    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        List<WebElement> areasCollection = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list"));
        for (int i = 0; i < cities.getRowCount(); i++) {
            assertEquals(cities.getRow(i).get(cities.getHeaders().get(0)), areasCollection.get(i).getText());
        }
    }
    public void clickOnAreaDropdown() {

        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list"));
    }


    public void clickOnCityDropdown() {

        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown"));
    }


    public void verifyOfficeCityList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("city").getLength(); i++) {
            assertEquals(document.getElementsByTagName("city").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list")).get(i).getText());
        }
    }

    public void clickonDeleteOfficeAddressRowButton(String rowIdentifier) {
        try {
            getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
        } catch (Exception e) {

        }
    }

     public void verifyOfficeAddressRowIsNotDisplayed() {
        try {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_delete_row_view"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyOfficeLocationsRowNotPresentInZeusDB(String officeFid, String source) {
        try {
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", officeFid));
            nvPairs.add(new BasicNameValuePair("source", source));
            Thread.sleep(3000L);
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
            if (document != null) {
                assertNull(document.getElementsByTagName("location ").item(0));

            } else
                assert false : source + " document is null";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyOfficeAddressRowNotPresentInZeusDB(String officeFid, String source) {
        try {
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", officeFid));
            nvPairs.add(new BasicNameValuePair("source", source));
            Thread.sleep(3000L);
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
            if (document != null) {
                assertNull(document.getElementsByTagName("address ").item(0));

            } else
                assert false : source + " document is null";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void verifyOfficeTelecomsRowNotPresentInZeusDB(String officeFid, String source) {
        try {
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", officeFid));
            nvPairs.add(new BasicNameValuePair("source", source));
            Thread.sleep(3000L);
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
            if (document != null) {
                assertNull(document.getElementsByTagName("telecom ").item(0));

            } else
                assert false : source + " document is null";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnAddTelecomsRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_telecoms_addRow_id"));
    }
    public void selectOfficeTelecomsType(String typeRowIdentifier , String Type) {
            Select dropdown = new Select(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier)));

                dropdown.selectByVisibleText(Type);


        }

    public void enterOfficeTelecomsRank(String rankRowIdentifier, String Rank) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rankRowIdentifier)).sendKeys(Rank);

    }

    public void enterOfficeTelecomsTextBefore(String textBeforeRowIdentifier, String TextBefore) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(textBeforeRowIdentifier)).sendKeys(TextBefore);

    }

    public void enterOfficeTelecomsCountryCode(String valueRowIdentifier, String CountryCode) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier)).sendKeys(CountryCode);

    }

    public void enterOfficeTelecomsAreaCode(String valueRowIdentifier, String AreaCode) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier)).sendKeys(AreaCode);

    }

    public void enterOfficeTelecomsNumber(String valueRowIdentifier, String Number) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier)).sendKeys(Number);

    }

    public void enterOfficeTelecomsRangeLimit(String rangeLimitRowIdentifier, String RangeLimit) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rangeLimitRowIdentifier)).sendKeys(RangeLimit);

    }

    public void enterOfficeTelecomsExt(String extRowIdentifier, String Ext) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(extRowIdentifier)).sendKeys(Ext);

    }

    public void enterOfficeTelecomsTextAfter(String textAfterRowIdentifier, String TextAfter) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(textAfterRowIdentifier)).sendKeys(TextAfter);

    }

    public void enterOfficeTelecomsAnswerBack(String answerBackRowIdentifier, String AnswerBack) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(answerBackRowIdentifier)).sendKeys(AnswerBack);

    }

    public void enterOfficeTelecomsValue(String valueRowIdentifier, String Value) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier)).sendKeys(Value);

    }
    public void verifyOfficeLocationsRowIsNotDisplayed() {
        try {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_row_view"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyOfficeTelecomsRowIsNotDisplayed() {
        try {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_telecoms_delete_row_edit_view"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterOfficeAddressPostalCode(String postalCodeRowIdentifier, String PostalCode) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(postalCodeRowIdentifier)).sendKeys(PostalCode);

    }

    public void enterOfficeAddressPostalCodeSuffix(String postalCodeSuffixRowIdentifier, String PostalCodeSuffix) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(postalCodeSuffixRowIdentifier)).sendKeys(PostalCodeSuffix);

    }

    public void enterOfficeAddressInfo(String infoRowIdentifier, String Info) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(infoRowIdentifier)).sendKeys(Info);

    }

    public void clickonDeleteOfficeTelecomsRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyOfficeAddressTypesFromLookup(String officeaddress_rowIdentifier,String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", "lookupFid"));

        List<String> dropdownValuesList = returnAllDropDownUnselectedValues(OfficeIdentifiers.getObjectIdentifier(officeaddress_rowIdentifier));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get Office Address Types", nvPairs);
        // finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
        List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "officeAddressTypes"), getAlreadySelectedAddressTypes("office_addressType_first_row_existing_address_type_dropdown"));
        assertEquals(dropdownValuesList, resultList);

    }

    public void verifyOfficeTelecomTypesFromLookup(String officetelecom_rowIdentifier,String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", "lookupFid"));
        List<String> dropdownValuesList = returnAllListValues(OfficeIdentifiers.getObjectIdentifier(officetelecom_rowIdentifier));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get Office Telecoms Types", nvPairs);
        assertEquals(dropdownValuesList, getNodeValuesByTagName(document, "officeTelecomTypes"));
    }


    public List<String> getAlreadySelectedAddressTypes(String identifier) {
        ArrayList<String> selectedValueList = new ArrayList();
        for (WebElement addressTypeDropDown : getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(identifier))) {
            Select dropdown = new Select(addressTypeDropDown);
            String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
            selectedValueList.add(selectedValue);
        }
        return selectedValueList;
    }

    public void verifyOfficeErrorMessage(String xpathIdentifier, String errorMsg) {
        assertEquals(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).size(), 1);
        assertEquals(errorMsg, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    }


    public void verifyMaxlengthOfficeAddressText(String maxSize, String rowIdentifier) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);}


    public void verifyOfficeAddressLinesAddressesInUI(String Type,String AddressLine1, String AddressLine2, String AddressLine3, String AddressLine4, String Country, String Area, String Subarea, String City, String PostalCode, String PostalCodeSuffix,String PostalCodePosition, String Info) {

            assertEquals(Type, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_Address_type_textarea_view")));
            assertEquals(AddressLine1, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_AddressLine1_textarea_view")));
            assertEquals(AddressLine2, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_AddressLine2_textarea_view")));
            assertEquals(AddressLine3, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_AddressLine3_textarea_view")));
            assertEquals(AddressLine4, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_AddressLine4_textarea_view")));
            assertEquals(Country, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_country_dropdown_list")));
            assertEquals(Area, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown")));
            assertEquals(Subarea, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown")));
            assertEquals(City, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_xpath")));
            assertEquals(PostalCode, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCode")));
            assertEquals(PostalCodeSuffix, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCodeSuffix")));
            assertEquals(PostalCodePosition, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_address_postalCodePosition")));
            assertEquals(Info, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_info")));


        }

    public boolean verifyOfficeAddressLinesAddressesFromDB(String Type,String AddressLine1,String AddressLine2, String AddressLine3, String AddressLine4,String PostalCode,String PostalCodeSuffix,String PostalCodePosition,String Info,String Country,String Area,String Subarea, String City,String officeFid,String source) {

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
        String officeAddressLines=Type+AddressLine1+AddressLine2+AddressLine3+AddressLine4+PostalCode+PostalCodeSuffix+PostalCodePosition+Info+Country+Area+Subarea+City;
        if (document != null) {

            List TypeList = getNodeValuesByTagName(document, "addressType");
            List AddressLine1List = getNodeValuesByTagName(document, "addressLine1");
            List AddressLine2List =getNodeValuesByTagName(document, "addressLine2");
            List AddressLine3List =getNodeValuesByTagName(document, "addressLine3");
            List AddressLine4List =getNodeValuesByTagName(document, "addressLine4");
            List PostalCodeList =getNodeValuesByTagName(document, "postalCode");
            List PostalCodeSuffixList =getNodeValuesByTagName(document, "postalCodeSuffix");
            List PostalCodePositionList= getNodeValuesByTagName(document, "postalCodePosition");
            List InfoList =getNodeValuesByTagName(document, "info");
            List CountryList=getNodeValuesByTagName(document, "country");
            List AreaList=getNodeValuesByTagName(document, "area");
            List SubareaList=getNodeValuesByTagName(document, "subarea");
            List CityList=getNodeValuesByTagName(document, "city");

        for(int i=0;i<TypeList.size();i++)
            {
        String officeAddressLinesFromZeus=TypeList.get(i).toString()+AddressLine1List.get(i).toString()+AddressLine2List.get(i).toString()+AddressLine3List.get(i).toString()+AddressLine4List.get(i).toString()+PostalCodeList.get(i).toString()+PostalCodeSuffixList.get(i).toString()+InfoList.get(i).toString()+CountryList.get(i).toString()+AreaList.get(i).toString()+SubareaList.get(i).toString()+CityList.get(i).toString()+PostalCodePositionList.get(i).toString();
                if(officeAddressLinesFromZeus.equals(officeAddressLines)) {
                    flag=true;
                    break;
            }
            }

        }
        return flag;

    }

    public void verifyOfficeTelecommFieldsInUI(String Type,String Rank,String TextBefore,String CountryCode,String AreaCode,String Number,String RangeLimit,String Ext,String TextAfter,String AnswerBack,String Value){
        String Value1;
        String Value2;
        String Value3;
        String Value4;
        String Value5;
        String Value6;
        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_rangeLimit_textarea_view")).isDisplayed())
        {     Value1=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_rangeLimit_textarea_view"));}
        else{
            Value1="";
        }

        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_ext_textarea_view")).isDisplayed())
        {     Value2=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_ext_textarea_view"));}
        else{
            Value2="";
        }

        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_textAfter_textarea_view")).isDisplayed())
        {     Value3=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_textAfter_textarea_view"));}
        else{
            Value3="";
        }

        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_answerback_textarea_view")).isDisplayed())
        {     Value4=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_answerback_textarea_view"));}
        else{
            Value4="";
        }
        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_value_textarea_view")).isDisplayed())
        {     Value5=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_value_textarea_view"));}
        else{
            Value5="";
        }
        if(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_value2_textarea_view")).isDisplayed())
        {     Value6=getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_value2_textarea_view"));}
        else{
            Value6="";
        }
        assertEquals(Type, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_type_textarea_view")));
        assertEquals(Rank, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_rank_textarea_view")));
        assertEquals(TextBefore, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_telecoms_textBefore_textarea_view")));
        assertEquals(RangeLimit, Value1);
        assertEquals(Ext, Value2);
        assertEquals(TextAfter,Value3);
        assertEquals(AnswerBack,Value4);
        assertEquals(CountryCode, Value5);
        assertEquals(AreaCode, Value5);
        assertEquals(Number, Value5);
        assertEquals(Value, Value6);

    }

    public boolean verifyOfficeTelecommFieldsFromDB(String Type,String Rank,String TextBefore, String CountryCode, String AreaCode,String Number,String RangeLimit,String Ext,String TextAfter,String AnswerBack,String Value,String officeFid,String source) {


        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Boolean flag=false;
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
        String officeTelecomFields=Type+Rank+TextBefore+CountryCode+AreaCode+Number+RangeLimit+Ext+TextAfter+AnswerBack+Value;

        if (document != null) {

            List TypeList = getNodeValuesByTagName(document, "telecomType");
            List RankList = getNodeValuesByTagName(document, "rank");
            List TextBeforeList =getNodeValuesByTagName(document, "textBefore");
            List CountryCodeList =getNodeValuesByTagName(document, "countryCode");
            List AreaCodeList =getNodeValuesByTagName(document, "areaCode");
            List NumberList =getNodeValuesByTagName(document, "phoneNumber");
            List RangeLimitList =getNodeValuesByTagName(document, "rangeLimit");
            List ExtList= getNodeValuesByTagName(document, "extension");
            List TextAfterList =getNodeValuesByTagName(document, "textAfter");
            List AnswerBackList=getNodeValuesByTagName(document, "answerBack");
            List ValueList=getNodeValuesByTagName(document, "value");


            for(int i=0;i<TypeList.size();i++)
            {
                String officeTelecomFieldsFromZeus=TypeList.get(i).toString()+RankList.get(i).toString()+TextBeforeList.get(i).toString()+CountryCodeList.get(i).toString()+AreaCodeList.get(i).toString()+NumberList.get(i).toString()+RangeLimitList.get(i).toString()+ExtList.get(i).toString()+TextAfterList.get(i).toString()+AnswerBackList.get(i).toString()+ValueList.get(i).toString();
                if(officeTelecomFieldsFromZeus.equals(officeTelecomFields)) {
                    flag=true;
                    break;
                }
            }

        }
        return flag;

    }

    public String getDocumentPrimaryFlagFromDB(String officeFid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", officeFid));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office locations", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String primaryFlagDBValue = getNodeValuesByTagName(document, "primaryFlag").size() == 0 ? "" : getNodeValuesByTagName(document, "primaryFlag").get(0);
        return primaryFlagDBValue;
    }

    public void verifyPrimaryFlagValuefromZeusDocumentAndUI(String primaryFlag, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDocumentPrimaryFlagFromDB(selectedEntity, source), primaryFlag);
        assertEquals(primaryFlag, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_view_primaryflag_xpath")));


    }
     public void verifySuccessfulUpdatedMessage() {
        try {
            assertTrue(
                    getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_save_confirmation_message"))
                            .isDisplayed());
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyMaxlengthOfficeTelecomsText(String maxSize, String rowIdentifier) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);}

    public void pressNoButtonInDeleteConfirmationModalForOfficeLocation() {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_location_delete_no_button")).click();
    }
    public void pressYesButtonInDeleteConfirmationModalForOfficeLocation() {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_location_delete_yes_button")).click();
    }

    public void pressNoButtonInDeleteConfirmationModalForOffice() {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_delete_no_button")).click();
    }

      public void verifyNewlyAddedOfficeLocationRowExists() {
        try
        {

            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_addressType_first_row_existing_address_type_dropdown"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyDeleteConfirmationModal() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Confirm DeleteAre you sure, you want to delete?NO YES", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_location_delete_row_confirmation_modal")).getText().replace("\n", ""));

    }

    public void verifyOfficeLocationsEditPageMode() {
        assertTrue(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_location_primaryoffice_location_delete_row_edit_mode_flag_radio_options")).size()>0);
    }

    public void verifyAreaDropdownNull(String areaDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(areaDropDown, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_area_listBox")).getText());

    }

    public void verifySubAreaDropdownNull(String subareaDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(subareaDropDown, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_subarea_listBox")).getText());

    }
    public void verifyCityDropdownNull(String cityDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(cityDropDown, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_city_listBox")).getText());

    }

    public void verifyOfficeDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
    }

    
    public void verifyOfficeIdentifierValuesFromTrustedDB(String source, String officeFid) {
    	try {
			attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_new_identifier_button_id"));
			List<String> identifierTypes = new ArrayList<>();
			List<String> identifierValues = new ArrayList<>();
			List<String> identifierStatusValues = new ArrayList<>();
			List<WebElement> identifierTypeDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_input_xpath"));
			
			if (identifierTypeDropDowns.size() > 0) {
				List<WebElement> identifierValueDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_value_input_xpath"));
				List<WebElement> identifierStatusDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_status_input_xpath"));
				
				for (int index = 0; index < identifierTypeDropDowns.size(); index++) {					
					identifierTypes.add(new Select(identifierTypeDropDowns.get(index)).getAllSelectedOptions().get(0).getText());
					identifierValues.add(identifierValueDropDowns.get(index).getAttribute("value"));
					identifierStatusValues.add(new Select(identifierStatusDropDowns.get(index)).getAllSelectedOptions().get(0).getText());
				}
				
				verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
						identifierStatusValues);
			} else {
				assertTrue("There is no existing values in Identifier section", true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void verifyOfficeIdentifierValuesFromDB(String source, String officeFid, List<String> identifierType,
			List<String> identifierValue, List<String> identifierStatus) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office identifiers values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("identifiers").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("identifiers").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("identifiers").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "identifierType":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierType.get(i));
							break;
						case "identifierValue":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierValue.get(i));
							break;
						case "identifierStatus":
							assertEquals(
									StringUtils.capitalize(document.getElementsByTagName("identifiers").item(0)
											.getChildNodes().item(i).getChildNodes().item(childNode).getTextContent()),
									identifierStatus.get(i));
							break;
						}
					}
				}
			} else
				assertTrue(source+ "document is null",false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void clickOnOfficeAddNewIdentifierButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_new_identifier_button_id"));
	}
    
    public void verifyOfficeIdentifierTypesList() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get office identifiers type list");
		List<WebElement> officeIdentifierTypesList = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_id"));

		List<WebElement> options = officeIdentifierTypesList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 1; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption).getText().trim());
		}
	}
    
    public void verifyOfficeIdentifierStatusList() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get office Status types");
		List<WebElement> officeIdentifierStatusList = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_status_input_xpath"));

		List<WebElement> options = officeIdentifierStatusList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 0; indexOfOption < document.getElementsByTagName("status")
				.getLength(); indexOfOption++) {
			assertEquals(StringUtils.capitalize(
					document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent()),
					options.get(indexOfOption + 1).getText().trim());
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption + 1).getAttribute("value").trim());
		}
	}    
  
    public void enterOfficeIdentifierType(String identifierType, int rowNumber) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_input_xpath"));
			if (rowNumber <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNumber - 1));
				if (identifierType.equals("")) {
					dropdown.selectByValue(identifierType);
				} else {
					dropdown.selectByVisibleText(identifierType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void enterOfficeIdentifierValue(String identifierValue, int rowNumber) {
		try {
			List<WebElement> identifierValues = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_value_input_xpath"));
			if (rowNumber <= identifierValues.size()) {
				identifierValues.get(rowNumber - 1).clear();
				identifierValues.get(rowNumber - 1).sendKeys(identifierValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void enterOfficeIdentifierStatus(String identifierStatus, int rowNumber) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_status_input_xpath"));
			if (rowNumber <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNumber - 1));
				if (identifierStatus.equals("")) {
					dropdown.selectByValue(identifierStatus);
				} else {
					dropdown.selectByVisibleText(identifierStatus);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void verifySelectedOfficeIdentifierTypeNotInNewRow(String identifierType, int rowNumber) {
    	try {
			List<WebElement> identifierDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_input_xpath"));
			if (rowNumber <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNumber - 1));
				for (int index = 0; index < dropdown.getOptions().size(); index++) {
					assertTrue(!dropdown.getOptions().get(index).getText().contains(identifierType));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
    
    public void verifyOfficeIdentifierParametersInUI(String[] identifierTypes, String[] identifierValues,
			String[] identifierStatusValues) {
		
		List<WebElement> identifierRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_view_mode"));
		
		for (int i = 0; i < identifierRows.size(); i++) {
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(0).getText().contains(identifierTypes[i]));
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(1).getText().contains(identifierValues[i]));
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(2).getText().contains(identifierStatusValues[i]));
		}
	}   
    
    public void verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed() {
		try {
			WebElement identifier = getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_AdditionalIdentifiers"));
			assertTrue(identifier == null);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
    
    public void verifyMaxLengthInOfficeIdentifierValue(String maxLength) {
		assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_identifier_value_input_xpath"))
				.getAttribute("maxlength"), maxLength);
	}
    
    public void verifyErrorMessageForRequiredOfficeIdentifierType(String errorMessage) {
		assertEquals(errorMessage, getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_req_err_msg_xpath")).getText());
	}
    
    public void verifyErrorMessageForRequiredOfficeIdentifierValue(String errorMessage) {
		assertEquals(errorMessage, getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_identifier_value_req_err_msg_xpath")).getText());
	}
    
    public void verifyErrorMessageForRequiredOfficeIdentifierStatus(String errorMessage) {
		assertEquals(errorMessage,
				getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_identifier_status_req_err_msg_xpath"))
						.getText());
	}
    
    public void verifyIdentifierRowNotPresentInZeusDB(String source, String officeFid) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(1000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office identifiers values", nvPairs);
			if (document != null) {
				assertNull(document.getElementsByTagName("identifierType").item(0));
				assertNull(document.getElementsByTagName("identifierValue").item(0));
				assertNull(document.getElementsByTagName("identifierStatus").item(0));
			} else
				assert false : source + " document is null";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void clickOnDeleteNewOfficeIdentifierRowButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_delete_identifiers_row_button_xpath"));
	}
      
    public void verifyNewlyAddedOfficeIdentifierRowIsDisplayed() {
		try {
			WebElement identifier = getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_identifier_type_input_xpath"));
			assertTrue(identifier != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

    public void clickOnOfficeAddNewPersonnelButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_new_personnel_button_id"));
	}

    public void verifyOfficePersonnelTypesList() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get office personnel type list");
		List<WebElement> officePersonnelTypesList = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_input_xpath"));

		List<WebElement> options = officePersonnelTypesList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 1; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption).getText().trim());
		}
	}

	public void enterOfficePersonnelValueInNewlyAddedRow(String personnelValue) {
		try {
			List<WebElement> personnelValues = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_value_input_xpath"));
			int rowCount = personnelValues.size();
			if (rowCount > 0) {
				personnelValues.get(rowCount - 1).clear();
				personnelValues.get(rowCount - 1).sendKeys(personnelValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficePersonnelValuesFromTrustedDB(String source, String officeFid) {
		try {
			List<String> personnelTypes = new ArrayList<>();
			List<String> personnelValues = new ArrayList<>();
			attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_new_personnel_button_id"));
			List<WebElement> personnelTypeDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_input_xpath"));

			if (personnelTypeDropDowns.size() > 0) {
				List<WebElement> personnelValueDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_value_input_xpath"));
				for (int index = 0; index < personnelTypeDropDowns.size(); index++) {
					personnelTypes.add(new Select(personnelTypeDropDowns.get(index)).getAllSelectedOptions().get(0).getText());
					personnelValues.add(personnelValueDropDowns.get(index).getAttribute("value"));
				}
				verifyOfficePersonnelValuesFromDB(source, officeFid, personnelTypes, personnelValues);
			} else {
				assertTrue("There is no existing values in personnel section", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterOfficePersonnelTypeInNewlyAddedRow(String personnelType) {
		try {
			List<WebElement> personnelTypeDropDowns = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_input_xpath"));
			int rowCount = personnelTypeDropDowns.size();
			if (rowCount > 0) {
				Select dropdown = new Select(personnelTypeDropDowns.get(rowCount - 1));
				if (personnelType.equals("")) {
					dropdown.selectByValue(personnelType);
				} else {
					dropdown.selectByVisibleText(personnelType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficePersonnelValuesFromDB(String source, String officeFid, List<String> personnelTypes,
			List<String> personnelValues) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(2000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office personnel values", nvPairs);
			if (document != null) {
				NodeList nodeList = document.getElementsByTagName("personnel");
				if (personnelTypes == null && personnelValues == null) {
					assertTrue("Personal data is not deleted from Zeus Document", nodeList.getLength() == 0);
				}
				for (int index = 0; index < nodeList.getLength(); index++) {
					NodeList childNodeList = nodeList.item(index).getChildNodes();
					assertEquals(childNodeList.item(0).getTextContent(), personnelTypes.get(index));
					assertEquals(childNodeList.item(1).getTextContent(), personnelValues.get(index));
				}
			} else {
				assertTrue(source + "document is not available", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySelectedOfficePersonnelTypeNotInNewRow(String personnelType, int rowNumber) {
		verifySelectedTypeNotInNewRow(personnelType, rowNumber, OfficeIdentifiers.getObjectIdentifier("office_personnel_type_input_xpath"));
	}


	private void verifySelectedTypeNotInNewRow(String selectedType, int rowNumber, By by) {
		try {
			List<WebElement> typeDropDowns = getDriver().findElements(by);
			if (rowNumber <= typeDropDowns.size()) {
				Select dropdown = new Select(typeDropDowns.get(rowNumber - 1));
				for (int index = 0; index < dropdown.getOptions().size(); index++) {
					assertTrue(!dropdown.getOptions().get(index).getText().contains(selectedType));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficePersonnelParametersInUI(List<String> personnelTypes, List<String> personnelValues) {
		List<WebElement> personnelRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_view_mode"));
		for (int i = 0; i < personnelRows.size(); i++) {
			assertTrue(personnelRows.get(i).findElements(By.tagName("td")).get(0).getText().equals(personnelTypes.get(i)));
			assertTrue(personnelRows.get(i).findElements(By.tagName("td")).get(1).getText().equals(personnelValues.get(i)));
		}
	}

	public void verifyNewlyAddedOfficePersonnelRowIsNotDisplayed() {
		try {
			getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_additional_personnel"));
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void verifyErrorMessageForPersonnelValue(String errorMessage) {
		assertEquals(errorMessage, getDriver().findElement(By.xpath("//*[@data-error_id='personnelValueError']")).getText());
	}

	public void verifyErrorMessageForPersonnelType(String errorMessage) {
		assertEquals(errorMessage, getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_error_msg_xpath")).getText());
	}

	public void enterOfficePersonnelValue() {
        String personnelValue = createBigString(10000);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_personnel_value_input_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + personnelValue + "'",
        		getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_personnel_value_input_xpath")));
    }

	public void verifyOfficePersonnelValueTextAreaLength() {
        assertEquals(getDriver().findElement(OfficeIdentifiers
        		.getObjectIdentifier("office_personnel_value_input_xpath")).getAttribute("maxlength"), "10000");
    }

	public void verifyPersonnelValueWithMaxLengthFromZeus(String personnelType, String officeFid, String source) {
		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(bigString);
		verifyOfficePersonnelValuesFromDB(source, officeFid, personnelTypes, personnelValues);
    }

	public String getBigStringValue() {
		return bigString;
	}

	public void clickOnDeleteOfficePersonnelRowButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_delete_personnel_row_button_xpath"));
	}

	public void verifyNewlyAddedOfficePersonnelRowIsDisplayed() {
		try {
			WebElement personnel = getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_personnel_type_input_xpath"));
			assertTrue(personnel != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	public void verifyOfficeBusinessHourValueFromTrustedDB(String officeFid, String source) {
		assertEquals(getOfficeBusinessHoursInfoFromDB(officeFid, source, "hours"),
				getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_edit_mode"))
						.getAttribute("value"));
	}

	public String getOfficeBusinessHoursInfoFromDB(String officeFid, String source, String tagName) {		
		String tagValue = null;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", officeFid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(2000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office basic info", nvPairs);
			if (document != null) {
				tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
						: getNodeValuesByTagName(document, tagName).get(0);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return tagValue;
	}

	public void enterOfficeBusinessHourText(String businessHourText) {
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_business_hours_edit_mode"), businessHourText);
	}

	public void verifyOfficeBusinessHourTextInUI(String businessHourText) {
		assertEquals(businessHourText, getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_view_mode")).getText());
	}

	public void verifyOfficeBusinessHourValueFromZeusDB(String officeFid, String source) {
		assertEquals(getOfficeBusinessHoursInfoFromDB(officeFid, source, "hours"), getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_view_mode")).getText());
	}

	public void enterMaximumCharactersInOfficeBusinessHours() {
		String businessHoursRandomText = createBigString(200);
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_business_hours_edit_mode"), businessHoursRandomText);
	}

	public void viewOfficeBusinessHoursValidCharacterLength() {
		Integer businessHoursTextLength = getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_view_mode")).getText().length();
		assertEquals(businessHoursTextLength.toString(), "200");
	}		
	
	public void verifyOfficeBusinessHoursMaxLenghtAttribute(String maxLength) {
		assertEquals((getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_edit_mode"))
				.getAttribute("maxlength")), maxLength);

	}

    public void verifyEditOfficeStatisticsValueFromTrusted(String fieldName, String fieldValue)
			throws InterruptedException {

		assertEquals(fieldName + " : " + fieldValue, fieldValue, getDriver().findElement(
				          OfficeIdentifiers.getObjectIdentifier("office_total_atms_xpath")).getAttribute("value"));
	}

	public void verifyOfficeStatisticsValueInUI(String totalAtms, String totalCheckingAccounts,
			String totalSavingsAccounts) throws InterruptedException {

		assertEquals(totalAtms, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_total_atms_view_xpath")).getText());
		assertEquals(totalCheckingAccounts,	getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_total_checking_accounts_view_xpath")).getText());
		assertEquals(totalSavingsAccounts, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_total_savings_accounts_view_xpath")).getText());
	}

	public void verifyOfficeStatisticsValueFromZeus(String fieldName, String fieldValue, String fieldValueInDB) {
		assertEquals(fieldName + " : " + fieldValue, fieldValue, fieldValueInDB);
	}

	public void verifyOfficeStatisticsFieldsMaxLengthAttribute(String maxLength, String totalAtms,
			String totalCheckingAccounts, String totalSavingsAccounts) {

		assertEquals(maxLength,	getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_atms_xpath")).getAttribute("maxlength"));
		assertEquals(maxLength,	getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_checking_accounts_xpath")).getAttribute("maxlength"));
		assertEquals(maxLength,	getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_savings_accounts_xpath")).getAttribute("maxlength"));
	}

	public void verifyErrorMessageForTotalAtm(String errorMessage) {
		assertEquals(errorMessage, getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_atms_err_msg_xpath")).getText());
	}

	public void verifyErrorMessageForTotalCheckingAccounts(String errorMessage) {
		assertEquals(errorMessage, getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_checking_accounts_err_msg_xpath")).getText());
	}

	public void verifyErrorMessageForTotalSavingsAccount(String errorMessage) {
		assertEquals(errorMessage, getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_total_savings_accounts_err_msg_xpath")).getText());
	}

	public void enterValueInStatisticsPageTextField(String textField, String value) {
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier(textField), value);
	}

	public String getOfficeHistoryFromDB(String source, String tagName, String officeFid) {

		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, 
																		"get office history details", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	public void verifyOfficeHistoryFromTrustedDB(String source, String tagName, String officeFid) {
		assertEquals(getOfficeHistoryFromDB(source, tagName, officeFid), getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_history_edit_mode_xpath")).getText());
	}

	public void enterOfficeHistory(String officeHistoryValue) {
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_history_edit_mode_xpath"), officeHistoryValue);
	}

	public void verifyOfficeHistory(String officeHistoryValue) {
		try {
			Thread.sleep(2000);
			assertEquals(officeHistoryValue, getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_history_view_mode_xpath")).getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeHistoryZeus(String source, String tagName, String officeFid) {
		assertEquals(getOfficeHistoryFromDB(source, tagName, officeFid), getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_history_view_mode_xpath")).getText());
	}

	public void enterCharactersInOfficeHistory() {
		String officeHistoryText = createBigString(10000);
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_history_edit_mode_xpath"), officeHistoryText);
		officeHistoryMaximumCharacter = officeHistoryText;
	}

	public void verifyMaxLengthOfficeHistory(String maxLength) {
		assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_history_edit_mode_xpath"))
				.getAttribute("maxlength"), maxLength);
	}

	public void verifyValidCharacterLengthOfficeHistory() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Integer officeHistoryLength = getDriver().findElement(OfficeIdentifiers
				.getObjectIdentifier("office_history_view_mode_xpath")).getText().length();
		assertEquals(officeHistoryLength.toString(), "10000");
	}

	public void verifyMaximumTextInOfficeHistory() {
		assertEquals(officeHistoryMaximumCharacter.subSequence(0, 10000), getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_history_view_mode_xpath")).getText());
	}
	
	public void verifyOfficeServiceCategoryFromLookup() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,
				"get office service category list");
		List<WebElement> officeServiceCategoryList = getDriver().findElements(
				OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath"));

		List<WebElement> options = officeServiceCategoryList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 1; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption).getText().trim());
		}
	}

	public void clickOnAddServicesButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_service_button_xpath"));
	}

	public void selectsServiceCategoryTypeFromDropdown(String serviceCategory, int rowNumber) {
		selectDropDownValueFromRowNumber(
				OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath"),
				serviceCategory, rowNumber);
	}

	public void selectsExistingServiceCategoryTypeFromDropdown(String serviceCategory) {
		selectItemFromDropdownListByText(
				OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath"),
				serviceCategory);
	}

	public void enterServiceOverrideValue(String serviceOverride, int rowNumber) {
		selectTexBoxValueFromRowNumber(
				OfficeIdentifiers.getObjectIdentifier("office_service_override_textbox_edit_mode_xpath"),
				serviceOverride, rowNumber);
	}

	public void verifySelectedOfficeServiceCategoryNotInNewRow(String serviceCategory, int rowNumber) {
		try {
			List<WebElement> serviceCategoryDropDowns = getDriver().findElements(
					OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath"));
			if (rowNumber <= serviceCategoryDropDowns.size()) {
				Select dropdown = new Select(serviceCategoryDropDowns.get(rowNumber - 1));
				for (int index = 0; index < dropdown.getOptions().size(); index++) {
					assertTrue(!dropdown.getOptions().get(index).getText().contains(serviceCategory));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeServiceParametersInUI(String[] serviceCategory, String[] serviceOverride) {

		List<WebElement> serviceRows = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_services_type_view_mode"));

		for (int i = 0; i < serviceRows.size(); i++) {
			assertTrue(serviceRows.get(i).findElements(By.tagName("td")).get(0).getText().contains(serviceCategory[i]));
			assertTrue(serviceRows.get(i).findElements(By.tagName("td")).get(1).getText().contains(serviceOverride[i]));
		}
	}

	public void verifyMaxLengthInServiceOverride(String maxLength) {
		assertEquals(getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_service_override_textbox_edit_mode_xpath"))
				.getAttribute("maxlength"), maxLength);
	}

	public void verifyErrorMsgRequiredForOfficeServiceCategory() {
		assertEquals(getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_service_category_error_msg_xpath")).size(), 1);
		assertEquals("Required",
				getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_service_category_error_msg_xpath")).getText());
	}

	public void clickOnDeleteNewOfficeServicesRowButton() {
		attemptClick(OfficeIdentifiers.getObjectIdentifier("office_services_delete_button_xpath"));
	}

	public void verifyOfficeServicesParametersNotInUI(String serviceCategory, String serviceOverride) {
		try {
			assertNotEquals(serviceCategory, getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_service_category_view_mode")).getText());
			assertNotEquals(serviceOverride,getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_services_override_view_mode")).getText());
		}
		catch (NoSuchElementException ex) {
			assertTrue("Deleted Row not present", true);
		}
	}

	public void verifyOfficeServiceValuesAreUpdatedInZeusDB(String source, String officeFid,
			List<String> serviceCategoryValues, List<String> serviceOverrideValues) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(2000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office service values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("services").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("services").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("services").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "serviceCategoryValues":
							assertEquals(
									document.getElementsByTagName("services").item(0).getChildNodes().item(i)
											.getChildNodes().item(childNode).getTextContent(),
									serviceCategoryValues.get(i));
							break;
						case "serviceOverrideValues":
							assertEquals(
									document.getElementsByTagName("services").item(0).getChildNodes().item(i)
											.getChildNodes().item(childNode).getTextContent(),
									serviceOverrideValues.get(i));
							break;
						}
					}
				}
			} else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficesServicesFromTrusted(String source, String officeFid) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			String serviceCategoryValue = getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath")).getText();
			String serviceOverrideValue = getDriver()
					.findElement(OfficeIdentifiers.getObjectIdentifier("office_service_override_textbox_edit_mode_xpath")).getText();

			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office service values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("services").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("services").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("services").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "serviceCategoryValues":
							assertEquals(document.getElementsByTagName("services").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), serviceCategoryValue);
							break;
						case "serviceOverrideValues":
							assertEquals(document.getElementsByTagName("services").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), serviceOverrideValue);
							break;
						}
					}
				}
			} else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeServiceValuesAreNotUpdatedInZeusDB(String source, String officeFid,
			List<String> serviceCategoryValues, List<String> serviceOverrideValues) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office service values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("services").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("services").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("services").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "serviceCategoryValues":
							assertNotEquals(
									document.getElementsByTagName("services").item(0).getChildNodes().item(i)
											.getChildNodes().item(childNode).getTextContent(),
									serviceCategoryValues.get(i));
							break;
						case "serviceOverrideValues":
							assertNotEquals(
									document.getElementsByTagName("services").item(0).getChildNodes().item(i)
											.getChildNodes().item(childNode).getTextContent(),
									serviceOverrideValues.get(i));
							break;
						}
					}
				}
			} else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeServicesParametersInEditUI(String serviceCategory, String serviceOverride) {
		try {
			assertEquals(serviceCategory,getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_service_category_dropdown_edit_mode_xpath")).getAttribute("value"));
			assertEquals(serviceOverride,getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_service_override_textbox_edit_mode_xpath"))
							.getAttribute("value"));
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}
	}

	public void verifyBlankOfficeServices() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_services_entire_xpath")).getText());
	}
	
	public void verifyPrimaryFlagValueFromTrustedDB(String source, String officeFid) {
		String primaryFlagValue = null;
		if (getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_row_edit_mode")).size() > 1) {
			List<WebElement> primaryFlagList = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_primary_flag_field"));

			for (int index = 0; index < primaryFlagList.size(); index++) {
				if (primaryFlagList.get(index).findElements(By.tagName("input")).get(0).isSelected()) {
					primaryFlagValue = primaryFlagList.get(index).findElements(By.tagName("input")).get(0).getAttribute("value");
				} else {
					primaryFlagValue = primaryFlagList.get(index).findElements(By.tagName("input")).get(1).getAttribute("value");
				}
				try {
					List<NameValuePair> nvPairs = new ArrayList<>();
					nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
					nvPairs.add(new BasicNameValuePair("source", source));
					Thread.sleep(2000L);

					Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
							"office locations primary flag values", nvPairs);
					if (document != null && document.getElementsByTagName("primary").getLength() > 0) {
						assertEquals(primaryFlagValue, document.getElementsByTagName("primary").item(index).getTextContent());
					} else {
						assertTrue(source + "document is null / primary tagname is not present", false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void verifySelectedPrimaryFlagNotEditable() {
		List<WebElement> secondPrimaryFlagList = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("office_second_location_primary_flag"));
		for(int index=0; index < secondPrimaryFlagList.size(); index++) {
			assertFalse(secondPrimaryFlagList.get(index).isEnabled());
		}
	}
	
	public void getAddressLine1ValueForPrimaryFlag() {
		addressLine1SecondPrimaryFlag = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_first_location_addressline1_edit_mode")).getAttribute("value");
		addressLine1FirstPrimaryFlag = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_second_location_addressline1_edit_mode")).getAttribute("value");
	}
	
	public void verifyPrimaryFlagInUI(String primaryFlag) {
		try {
			Thread.sleep(3000L);
			if (primaryFlag.equals("true")) {
				assertEquals(primaryFlag, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_first_location_primary_flag_view_mode"))
								.getText());
				assertEquals(addressLine1FirstPrimaryFlag, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_first_location_addressline1_view_mode"))
								.getText());
			} else {
				assertEquals(primaryFlag, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_second_location_primary_flag_view_mode")).getText());
				assertEquals(addressLine1SecondPrimaryFlag,	getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_second_location_addressline1_view_mode"))
								.getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void primaryFlagValueFromZeusDB(String source, String officeFid) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(2000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"office locations primary flag values", nvPairs);
			HashMap<String, String> locationValueInUI = new HashMap<String, String>();
			HashMap<String, String> locationValueInDB = new HashMap<String, String>();
			
			if(document!=null && document.getElementsByTagName("location").getLength()>1) {
				for(int index=0; index < document.getElementsByTagName("location").getLength(); index++) {
					String primaryFlagDBValue = document.getElementsByTagName("primary").item(index).getTextContent();
					String addressLine1DB = document.getElementsByTagName("location").item(index).getChildNodes()
							.item(1).getChildNodes().item(1).getTextContent();
					locationValueInUI.put(primaryFlagDBValue, addressLine1DB);
				}
			}
			
			locationValueInDB.put(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_first_location_primary_flag_view_mode")).getText(),
					getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_first_location_addressline1_view_mode")).getText());
			locationValueInDB.put(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_second_location_primary_flag_view_mode")).getText(),
					getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_second_location_addressline1_view_mode")).getText());
			
			assertTrue(locationValueInUI.equals(locationValueInDB));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


    @Override
    public String getPageUrl() {
        return null;
    }





    public void setPrincipalOffice(String principalFlag) {
        if (principalFlag.equalsIgnoreCase("true")) {
            getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_principalFlag_name")).get(0).click();
        } else getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_principalFlag_name")).get(1).click();
    }


}

