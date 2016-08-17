package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
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
import static org.junit.Assert.*;



public class EditOfficePage extends AbstractPage {

    static ResponseEntity responseEntity;
    static String endpointWithID;
    public String EditSortNameValue = "";
    public String EditOfficeSortName = "";

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


    public void verifyUpdatedOfficeOpenedDate(String officeFid, String day, String month, String year , String source) {
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
        assertEquals(leadLocationflag,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_leadlocation_xpath")));


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
        assertTrue(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_month_xpath")).size()>0);
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
        assertEquals(foreignOfficeflag,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_view_foreignoffice_xpath")));

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
        clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath"),additionalInfoText);

    }

    public void verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(String additionalInfoText, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getOfficeValuesFromDB(selectedEntity, source), additionalInfoText);
        assertEquals(additionalInfoText,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_view_xpath")));

    }

    public void verifyOfficeAdditionalInfoTextAreaLength(String officeFid) {
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")).getAttribute("maxlength"), "10000");
    }

    public void enter10000CharactersInOfficeAdditionalInfo(String officeFid) {
        String strBigString = createBigString(10000);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strBigString + "'", getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_AdditionalInfo_textarea_xpath")));
    }

    public void verifyAdditionalInfoValueWithMaxLengthFromZeus(String officeFid, String selectedEntity, String source){
        assertEquals(getOfficeValuesFromDB(selectedEntity, source), bigString);

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

    public void setPrincipalOffice(String principalFlag) {
        if (principalFlag.equalsIgnoreCase("true")) {
            getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_principalFlag_name")).get(0).click();
        } else getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_principalFlag_name")).get(1).click();
    }
    
    @Override
    public String getPageUrl() {
        return null;
    }
}
