package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.ParamMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.commons.collections.ListUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.springframework.http.ResponseEntity;


import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;



public class EditOfficePage extends AbstractPage {

    static ResponseEntity responseEntity;
    static String endpointWithID;
    public String EditSortNameValue = "";
    public String EditOfficeSortName = "";
    public static String businessHoursMaximumCharacterString=null;

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
    
	public void verifyOfficeBusinessHourValueFromTrustedDB(String officeFid, String source) {
		assertEquals(getOfficeBusinessHoursInfoFromDB(officeFid, source, "hours"),
				getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_xpath"))
						.getAttribute("value"));
	}

	public String getOfficeBusinessHoursInfoFromDB(String officeFid, String source, String tagName) {
		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("fid", officeFid));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get office basic info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;

	}

	public void enterOfficeBusinessHourText(String businessHourText) {
		clearAndEnterValue(OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_xpath"), businessHourText);
	}

	public void verifyOfficeBusinessHourTextInUI(String businessHourText) {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(businessHourText,
				getDriver()
						.findElement(
								OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_view_mode_xpath"))
						.getText());
	}

	public void verifyOfficeBusinessHourValueFromZeusDB(String officeFid, String source) {
		assertEquals(getOfficeBusinessHoursInfoFromDB(officeFid, source, "hours"),
				getDriver()
						.findElement(
								OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_view_mode_xpath"))
						.getText());
	}

	public void enterInvalidCharactersInOfficeBusinessHours() {
		char addCharToBusinessHours = 'a';
		String businessHoursRandomText = null;
		for (int i = 0; i <= 200; i++) {
			businessHoursRandomText += addCharToBusinessHours;
		}
		getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_xpath")).clear();
		getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_xpath"))
				.sendKeys(businessHoursRandomText);
		businessHoursMaximumCharacterString = businessHoursRandomText;
	}

	public void viewOfficeBusinessHoursValidCharacterLength() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Integer businessHoursTextLength = getDriver()
				.findElement(OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_view_mode_xpath"))
				.getText().length();
		assertEquals(businessHoursTextLength.toString(), "200");
	}

	public void verifyMaximumTextInOfficeBusinessHours() {
		assertEquals(businessHoursMaximumCharacterString.subSequence(0, 200),
				getDriver()
						.findElement(
								OfficeIdentifiers.getObjectIdentifier("office_business_hours_text_view_mode_xpath"))
						.getText());
	}
    
    @Override
    public String getPageUrl() {
        return null;
    }
}
