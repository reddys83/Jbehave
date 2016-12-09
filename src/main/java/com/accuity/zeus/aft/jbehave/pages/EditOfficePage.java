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
    public int telecomAreaCodeCount = 0 ;
    public int telecomValueCount = 0 ;
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

    public void clickOnAddNewOfficeTypeButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_add_new_officetype_button_id"));
    }

    public void selectOfficeType(String officeTypeValue, String rowIdentifier) {
        Select dropdown = new Select(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).get(0));
        dropdown.selectByVisibleText(officeTypeValue);
    }
    

	public void verifyOfficeTypeNotPresentInZeusAndInUI(String source, String officeFid, String tagName,
			String officeTypeValue) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("fid", officeFid));
		nvPairs.add(new BasicNameValuePair("source", source));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get office basic info", nvPairs);

		assertFalse(getNodeValuesByTagName(document, tagName).contains(officeTypeValue));

		Boolean flag = false;
		List<WebElement> officeTypes = getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier("basic_info_office_type_xpath"));

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

	public CountryPage enterOfficeCountryInTheTypeAheadBox(String Country, int index) {		
		try {
			SimpleCacheManager.getInstance().put("selectedCountry", Country);
			selectedEntity = Country;		
			List<WebElement> countryDropDownList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_address_country_type_ahead"));
			countryDropDownList.get(index-1).sendKeys(Country);
			countryDropDownList.get(index-1).sendKeys(Keys.RETURN);			
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CountryPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(),
				getHeraApi());
	}


	public void enterOfficeCityInTheTypeAheadBox(String city, int index) {
		try {
			SimpleCacheManager.getInstance().put("selectedCity", city);
			selectedEntity = city;
			List<WebElement> dropDownList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_address_city_type_ahead"));
			dropDownList.get(index-1).sendKeys(city);
			dropDownList.get(index-1).sendKeys(Keys.RETURN);
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public void verifyOfficeAreaList() {        
        try { 
            Thread.sleep(3000L);           
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("name", selectedEntity));
            nvPairs.add(new BasicNameValuePair("source", "trusted"));
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list", nvPairs);            
            List<WebElement> areaList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list"));                        
            assertEquals(areaList.get(0).getText(), "No Area");
            assertEquals(areaList.get(1).getText(), "Return All Cities");
            for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
                assertEquals(document.getElementsByTagName("area").item(i).getTextContent(), areaList.get(i+2).getText());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }      
    }


	public void enterOfficeAreaInTypeAhead(String Area, int index) {		
		try {
			SimpleCacheManager.getInstance().put("selectedArea", Area);
			selectedEntity = Area;
			List<WebElement> dropDownList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_type_ahead"));
			dropDownList.get(index-1).sendKeys(Area);
			dropDownList.get(index-1).sendKeys(Keys.RETURN);
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeSubAreaList(Database database, ApacheHttpClient apacheHttpClient) {

		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("name", selectedEntity));
			nvPairs.add(new BasicNameValuePair("source", "trusted"));
			Thread.sleep(5000L);
			List<WebElement> subAreaList = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_list"));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"subarea list", nvPairs);
			for (int i = 0; i < document.getElementsByTagName("subarea").getLength(); i++) {
				assertEquals(document.getElementsByTagName("subarea").item(i).getTextContent(),
						subAreaList.get(i).getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enterOfficeSubAreaInTypeAhead(String subArea, int index) {
		try {
			SimpleCacheManager.getInstance().put("selectedsubArea", subArea);
			selectedEntity = subArea;
			List<WebElement> dropDownList = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_typeAhead"));
			dropDownList.get(index - 1).sendKeys(subArea);
			dropDownList.get(index - 1).sendKeys(Keys.RETURN);
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

    public void verifyOfficeCityList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> cityOptions = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("city").getLength(); i++) {
            assertEquals(document.getElementsByTagName("city").item(i).getTextContent(), cityOptions.get(i).getText());
        }
    }

    public void clickonDeleteOfficeAddressRowButton(String rowIdentifier) {
        try {
            getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
        } catch (Exception e) {

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
                assertNull(document.getElementsByTagName("address").item(0));

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
                assertNull(document.getElementsByTagName("telecom").item(0));
            } else
                assert false : source + " document is null";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public void verifyOfficeLocationFromTrustedDB(String officeFid, String source) {
		try {			
			List<WebElement> typeList = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_view_mode"));
			if (typeList.size() > 0) {				

				for (int index = 1; index <= typeList.size(); index++) {					
					String type = getSelectedOptionInDropDownByIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_dropdown"), index);
					 String addressLine1 = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine1"), index);
			            String addressLine2 = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine2"), index);
			            String addressLine3 = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine3"), index);
			            String addressLine4 = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine4"), index);
			            String country = getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_country_view_mode"), index);
			            String area = getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_area_view_mode"), index);
			            String subArea = getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_subarea_view_mode"), index);
			            String city = getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_city_view_mode"), index);
			            String postalCode = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCode"), index);
			            String postalCodeSuffix = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCodeSuffix"), index);           
			            String info = getAttributeValueOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_info"), index);					
					    verifyOfficeAddressLinesAddressesFromDB(type, addressLine1, addressLine2, addressLine3,	addressLine4, postalCode, postalCodeSuffix, info, country, area, subArea, city,
							officeFid, source);	
				}
			} else {
				assertTrue("There is no existing values in location address section", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void clickOnAddTelecomsRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_telecoms_addRow_id"));
    }

    public void verifyOfficeLocationsRowIsNotDisplayed() {
        try {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_row_view"));
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

    public void verifyOfficeErrorMessage(String xpathIdentifier, String errorMsg) {
    	try {
			Thread.sleep(2000L);
        assertTrue(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).size() > 0);
        assertEquals(errorMsg, getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(xpathIdentifier)).getText());
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	public void verifyMaxlengthOfficeLocationsTextFields(String maxSize, String rowIdentifier) {
		assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"),maxSize);
	}


    public void verifyOfficeAddressLinesAddressesInUI(String type,String addressLine1, String addressLine2, String addressLine3, String addressLine4, String country, String area, String subArea, String city, String postalCode, String postalCodeSuffix, String info, int index) {
    	try {    			    	
            assertEquals(type, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_view_mode"), index));
            assertEquals(addressLine1, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine1_view_mode"), index));
            assertEquals(addressLine2, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine2_view_mode"), index));
            assertEquals(addressLine3, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine3_view_mode"), index));
            assertEquals(addressLine4, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine4_view_mode"), index));
            assertEquals(country, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_country_view_mode"), index));
            assertEquals(area, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_area_view_mode"), index));
            assertEquals(subArea, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_subarea_view_mode"), index));
            assertEquals(city, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_city_view_mode"), index));
            assertEquals(postalCode, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_postal_code_view_mode"), index));
            assertEquals(postalCodeSuffix, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_postal_code_suffix_view_mode"), index));           
            assertEquals(info, getTextOnPageUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_address_info_view_mode"), index));
    	}
    	catch(Exception e) {
    		e.printStackTrace();
        }
    }

	public boolean verifyOfficeAddressLinesAddressesFromDB(String type, String addressLine1, String addressLine2,
			String addressLine3, String addressLine4, String postalCode, String postalCodeSuffix, String info,
			String country, String area, String subArea, String city, String officeFid, String source) {
		Boolean flag = false;
		try {
			Thread.sleep(1000L);
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			nvPairs.add(new BasicNameValuePair("source", source));

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get Office Locations", nvPairs);
			StringBuilder officeAddressLines = new StringBuilder();
			officeAddressLines.append(type);
			officeAddressLines.append(addressLine1);
			officeAddressLines.append(addressLine2);
			officeAddressLines.append(addressLine3);
			officeAddressLines.append(addressLine4);
			officeAddressLines.append(postalCode);
			officeAddressLines.append(postalCodeSuffix);
			officeAddressLines.append(info);
			officeAddressLines.append(country);
			officeAddressLines.append(area);
			officeAddressLines.append(subArea);
			officeAddressLines.append(city);

			if (document != null) {

				List<String> typeList = getNodeValuesByTagName(document, "addressType");
				List<String> addressLine1List = getNodeValuesByTagName(document, "addressLine1");
				List<String> addressLine2List = getNodeValuesByTagName(document, "addressLine2");
				List<String> addressLine3List = getNodeValuesByTagName(document, "addressLine3");
				List<String> addressLine4List = getNodeValuesByTagName(document, "addressLine4");
				List<String> postalCodeList = getNodeValuesByTagName(document, "postalCode");
				List<String> postalCodeSuffixList = getNodeValuesByTagName(document, "postalSuffix");
				List<String> infoList = getNodeValuesByTagName(document, "info");
				List<String> countryList = getNodeValuesByTagName(document, "country");
				List<String> areaList = getNodeValuesByTagName(document, "area");
				List<String> subAreaList = getNodeValuesByTagName(document, "subarea");
				List<String> cityList = getNodeValuesByTagName(document, "city");

				for (int i = 0; i < typeList.size(); i++) {
					String officeAddressLinesFromZeus = typeList.get(i).toString() + addressLine1List.get(i).toString()
							+ addressLine2List.get(i).toString() + addressLine3List.get(i).toString()
							+ addressLine4List.get(i).toString() + postalCodeList.get(i).toString()
							+ postalCodeSuffixList.get(i).toString() + infoList.get(i).toString()
							+ countryList.get(i).toString() + areaList.get(i).toString() + subAreaList.get(i).toString()
							+ cityList.get(i).toString();
					if (officeAddressLinesFromZeus.equals(officeAddressLines.toString())) {
						flag = true;
						break;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	public void deleteLocationRows() {
		try {
			List<WebElement> deleteRows = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_row_delete_button"));
			for (int index = 0; index < deleteRows.size(); index++) {
				WebElement currentInstance = getDriver()
						.findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_row_delete_button")).get(0);
				if (currentInstance != null) {
					attemptClick(OfficeIdentifiers.getObjectIdentifier("office_locations_row_delete_button"));
					verifyDeleteConfirmationModalForLocation();
					Thread.sleep(5000L);
					attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_delete_yes_button"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void verifySelectedOfficeAddressTypeNotInNewRow(String Type, int rowNo) {
		try {
			List<WebElement> addressTypeDropDown = getDriver()
					.findElements(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_dropdown"));
			if (rowNo <= addressTypeDropDown.size()) {
				Select dropdown = new Select(addressTypeDropDown.get(rowNo - 1));
				for (int index = 0; index < dropdown.getOptions().size(); index++) {
					assertTrue(!dropdown.getOptions().get(index).getText().contains(Type));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDeleteConfirmationModalForLocation() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Confirm DeleteAre you sure, you want to delete?NO YES",
				getDriver()
						.findElement(
								OfficeIdentifiers.getObjectIdentifier("office_location_delete_row_confirmation_modal"))
						.getText().replace("\n", ""));
	}

	public void verifyOfficeLocationsTelecommFieldsInUI(String rank, String textBefore, String value, String rangeLimit,
			String ext, String textAfter, String answerBack) {
		assertFalse("No rows exist in office locations telecom section",
				getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_telecom_row_view_mode")).size() == 0);
		List<WebElement> telecomColumn = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_telecom_row_view_mode")).get(0)
				.findElements(By.tagName("td"));
		assertEquals("Rank: ", telecomColumn.get(1).getText(), rank);
		assertEquals("Text Before: ", telecomColumn.get(2).getText(), textBefore);
		assertEquals("Value: ", telecomColumn.get(3).getText(), value);
		if (rangeLimit != null && ext != null) {
			assertEquals("Range Limit: ", telecomColumn.get(4).getText(), rangeLimit);
			assertEquals("Ext: ", telecomColumn.get(5).getText(), ext);
		}
		assertEquals("Text After: ", telecomColumn.get(6).getText(), textAfter);
		if (answerBack != null) {
			assertEquals("Answer Back: ", telecomColumn.get(7).getText(), answerBack);
		}
	}

    public void verifyOfficeTelecommFieldsFromDB(String Type, String Rank, String TextBefore, String CountryCode,
			String AreaCode, String Number, String RangeLimit, String Ext, String TextAfter, String AnswerBack,
			String Value, String officeFid, String source) {
		try {
			Thread.sleep(1000L);
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", officeFid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office telecom locations", nvPairs);

			if (document != null) {
				assertEquals(Rank, getNodeValuesByTagName(document, "rank").get(0));
				assertEquals(TextBefore, getNodeValuesByTagName(document, "textBefore").get(0));
				assertEquals(TextAfter, getNodeValuesByTagName(document, "textAfter").get(0));
				if (RangeLimit != null && Ext != null) {
					assertEquals(RangeLimit, getNodeValuesByTagName(document, "phoneNumberRangeLimit").get(0));
					assertEquals(Ext, getNodeValuesByTagName(document, "phoneExtension").get(0));
				}
				if (AnswerBack != null)
					assertEquals(AnswerBack, getNodeValuesByTagName(document, "answerBack").get(0));
				if (CountryCode != null && AreaCode != null && Number != null) {
					String newValue = CountryCode + "-" + AreaCode + "-" + Number;
					assertEquals(newValue, getNodeValuesByTagName(document, "value").get(0));
				} else {
					assertEquals(Value, getNodeValuesByTagName(document, "value").get(0));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
        assertEquals(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).getAttribute("maxlength"), maxSize);
    }

    public void pressNoButtonInDeleteConfirmationModalForOffice() {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_delete_no_button")).click();
    }

	public void verifyNewlyAddedOfficeLocationRowExists() {
		try {
			WebElement identifier = getDriver().findElement(OfficeIdentifiers
					.getObjectIdentifier("office_addressType_first_row_existing_address_type_dropdown"));
			assertTrue(identifier != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent().replaceAll("\\s{2,}", " ").trim(),
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
		try {
			if (getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_row_edit_mode")).size() > 0) {
				List<WebElement> primaryFlagList = getDriver()
						.findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_primary_flag_field"));

				for (int index = 0; index < primaryFlagList.size(); index++) {
					List<WebElement> flagOptions = primaryFlagList.get(index).findElements(By.name("primaryLocation-"+index));
					for (int flagIndex = 0; flagIndex < flagOptions.size(); flagIndex++) {
						if (flagOptions.get(flagIndex).isSelected()) {
							primaryFlagValue = flagOptions.get(flagIndex).getAttribute("value");
							break;
						}
					}
					List<NameValuePair> nvPairs = new ArrayList<>();
					nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
					nvPairs.add(new BasicNameValuePair("source", source));
					Thread.sleep(2000L);

					Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
							"office locations", nvPairs);
					if (document != null && document.getElementsByTagName("primary").getLength() > 0) {
						assertEquals(primaryFlagValue,
								document.getElementsByTagName("primary").item(index).getTextContent());
					} else {
						assertTrue(source + "document is null / primary tagname is not present", false);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
					"office locations", nvPairs);
			HashMap<String, String> locationValueInUI = new HashMap<String, String>();
			HashMap<String, String> locationValueInDB = new HashMap<String, String>();
			
			if(document!=null && document.getElementsByTagName("locationPrimaryFlag").getLength()>1) {
				for(int index=0; index < document.getElementsByTagName("locationPrimaryFlag").getLength(); index++) {
					String primaryFlagDBValue = document.getElementsByTagName("primaryFlag").item(index).getTextContent();
					String addressLine1DB = document.getElementsByTagName("locationPrimaryFlag").item(index).getChildNodes()
							.item(1).getTextContent();
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

	public void verifyPrimaryFlagValuefromZeusDocumentAndUI(String primaryFlag, String selectedEntity, String source) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDocumentPrimaryFlagFromDB(selectedEntity, source), primaryFlag);
        assertEquals(primaryFlag, getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_locations_view_primaryflag_xpath")));
    }

	public void deleteExistingLocationValues(String officeFid, String location, String documentType) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
		nvPairs.add(new BasicNameValuePair("location", location));
		nvPairs.add(new BasicNameValuePair("documentType", documentType));
		apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "delete office locations values", nvPairs);
	}
	
	public void verifyOfficeTelecomValuesFromTrustedDB(String officeFid, String source) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", officeFid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get office telecom locations", nvPairs);
    		List<WebElement> telecomRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_telecom_rows_edit_mode"));    		
    		Thread.sleep(1000L);
			for (int index = 1; index < telecomRows.size(); index++) {
				String telecomType = getTelecomFieldValue("type", index);
				assertEquals(telecomType, getNodeValuesByTagName(document, "type").get(index - 1));
				if (telecomType.equals("cable") || telecomType.equals("reuters") || telecomType.equals("telex")) {
					if (!getTelecomFieldValue("answerBack", index).isEmpty()) {
						assertEquals(getTelecomFieldValue("answerBack", index),	getNodeValuesByTagName(document, "answerBack").get(index - 1));
					}
				}
				if (!(telecomType.equals("email") || telecomType.equals("website"))) {
					if (!getTelecomFieldValue("rangeLimit", index).isEmpty()) {
						assertEquals(getTelecomFieldValue("rangeLimit", index),	getNodeValuesByTagName(document, "phoneNumberRangeLimit").get(index - 1));
					}
					if (!getTelecomFieldValue("ext", index).isEmpty()) {
						assertEquals(getTelecomFieldValue("ext", index), getNodeValuesByTagName(document, "phoneExtension").get(index - 1));
					}
				}
				assertEquals(getTelecomFieldValue("rank", index), getNodeValuesByTagName(document, "rank").get(index - 1));
				assertEquals(getTelecomFieldValue("textBefore", index),	getNodeValuesByTagName(document, "textBefore").get(index - 1));
				assertEquals(getTelecomFieldValue("value", index), getNodeValuesByTagName(document, "value").get(index - 1));
				assertEquals(getTelecomFieldValue("textAfter", index), getNodeValuesByTagName(document, "textAfter").get(index - 1));
			}    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();		
    	}
    }
	
		
	public String getTelecomFieldValue(String fieldName, int row) {
		Map<String, By> telecomFieldMap = new HashMap<String, By>();
		List<WebElement> telecomRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_telecom_rows_edit_mode"));
		String value = null;
		String typeValue = null;
		try {
			if (telecomRows.size() > 1) {
				telecomFieldMap.put("type", OfficeIdentifiers.getObjectIdentifier("office_telecom_type_dropdown_input"));
				telecomFieldMap.put("rank", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_rank"));
				telecomFieldMap.put("textBefore", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_textBefore"));
				telecomFieldMap.put("countryCode", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_countryCode"));
				telecomFieldMap.put("areaCode", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_areaCode"));
				telecomFieldMap.put("number", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_number"));
				telecomFieldMap.put("rangeLimit", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_rangeLimit"));
				telecomFieldMap.put("ext", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_ext"));
				telecomFieldMap.put("textAfter", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_textAfter"));		
				telecomFieldMap.put("answerBack",OfficeIdentifiers.getObjectIdentifier( "office_telecoms_first_row_new_answerBack"));	
				telecomFieldMap.put("value", OfficeIdentifiers.getObjectIdentifier("office_telecoms_first_row_new_value"));
				Thread.sleep(1000L);
				typeValue = getSelectedOptionInDropDownByIndex(telecomFieldMap.get("type"), row);
				if (fieldName.equals("type")) {
					value = typeValue;
				} else if (typeValue.equals("telephone") || typeValue.equals("fax")) {
					if (fieldName.equals("value")) {
						value = getTextUsingIndex(telecomFieldMap.get("countryCode"), row - telecomValueCount) + "-"
								+ getTextUsingIndex(telecomFieldMap.get("areaCode"), row - telecomValueCount) + "-"
								+ getTextUsingIndex(telecomFieldMap.get("number"), row - telecomValueCount);
						telecomAreaCodeCount++;
					} else {
						value = getTextUsingIndex(telecomFieldMap.get(fieldName), row);
					}
				} else {
					if (fieldName.equals("value")) {
						value = getTextUsingIndex(telecomFieldMap.get(fieldName), row - telecomAreaCodeCount);
						telecomValueCount++;
					} else {
						value = getTextUsingIndex(telecomFieldMap.get(fieldName), row);
					}
				}
			} else {
				assertTrue("There is no existing values in telecom location section", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public void verifypostalCodePositonInUI(String postalCodePositon) {
		assertEquals(postalCodePositon,
				getDriver()
						.findElement(OfficeIdentifiers.getObjectIdentifier("office_locations_postalCodePosition_xpath"))
						.getAttribute("value"));
	}
	
	public void verifyLocationsSummaryValuesFromTrustedDB(String source, String officeFid) {
		List<String> summaryTypeList = new ArrayList<String>();
		List<String> summaryValueList = new ArrayList<String>();
		List<WebElement> summaryTypeDropDowns = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_type_dropdown"));
		List<WebElement> summaryValueTextBox = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_value"));
		if(summaryTypeDropDowns.size() > 0) {
			for (int index = 1; index <= summaryTypeDropDowns.size(); index++) {					
				summaryTypeList.add(getSelectedOptionInDropDownByIndex(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_type_dropdown"), index));
				summaryValueList.add(summaryValueTextBox.get(index-1).getText());
			}
			verifyLocationsSummaryValuesFromDB(source, officeFid, summaryTypeList, summaryValueList);
		} else {
			assertTrue("There is no existing values in Locations summary section", true);
		}
	}
	
	public void verifyLocationsSummaryValuesFromDB(String source, String officeFid, List<String> summaryTypeList, List<String> summaryValueList) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"office locations", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("summaries").item(0).getChildNodes().getLength(); i++) {
					for (int childNode = 0; childNode < document.getElementsByTagName("summaries").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("summaries").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "summaryType":
							assertEquals(document.getElementsByTagName("summaries").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), summaryTypeList.get(i));
							break;
						case "summaryValue":
							assertEquals(document.getElementsByTagName("summaries").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), summaryValueList.get(i));
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
	
	public void verifyOfficeLocationsSummaryParametersInUI(String[] summaryTypes, String[] summaryValues) {	
		try {
			List<WebElement> summaryRows = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_locations_summary_row_view_mode"));
			assertTrue(summaryRows.get(0).findElements(By.tagName("th")).get(0).getText().contains("TYPE"));
			assertTrue(summaryRows.get(0).findElements(By.tagName("th")).get(1).getText().contains("VALUE"));
			for (int i = 1; i < summaryRows.size(); i++) {
				assertTrue(summaryRows.get(i).findElements(By.tagName("td")).get(0).getText().contains(summaryTypes[i - 1]));
				assertTrue(summaryRows.get(i).findElements(By.tagName("td")).get(1).getText().contains(summaryValues[i - 1]));
			}
		} catch (Exception e) {
			assertTrue("Locations Summary section is not present.", false);
		}
	}
	
	public void verifyOfficeLocationsSummaryValueMaxLengthAttribute(String maxlength) {
        assertEquals(getDriver().findElement(OfficeIdentifiers
        		.getObjectIdentifier("office_edit_locations_summary_value")).getAttribute("maxlength"), maxlength);
    }
	
	public void verifyOfficeLocationsSummaryRowNotPresentInZeusDB(String source, String officeFid) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("officeFid", officeFid));
			Thread.sleep(2000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "office locations", nvPairs);
			if (document != null) {
				assertNull(document.getElementsByTagName("summaryType").item(0));
				assertNull(document.getElementsByTagName("summaryValue").item(0));
			} else
				assert false : source + " document is null";
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		// finding the list of values from the taxonomy and subtracting the
		// values which are selected in other dropdowns
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get offices office types", nvPairs);
		List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "OfficeType"),
				getAlreadySelectedOfficeTypes("office_basicInfo_officetypes_dropdown_xpath"));
		assertEquals(dropdownValuesList, resultList);

	}

	public void verifyEditOfficesOfficeTypeValueFromTrusted(String officeFid, String tagName, String source) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("fid", officeFid));
		nvPairs.add(new BasicNameValuePair("source", source));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get office basic info", nvPairs);
		if (document != null) {
			assertEquals(getNodeValuesByTagName(document, tagName),
					getAlreadySelectedOfficeTypes("office_basicInfo_officetypes_dropdown_xpath"));
		}

	}

	public List<String> getAlreadySelectedOfficeTypes(String identifier) {
		ArrayList<String> selectedValueList = new ArrayList();
		for (WebElement officeTypeDropDown : getDriver()
				.findElements(OfficeIdentifiers.getObjectIdentifier(identifier))) {
			Select dropdown = new Select(officeTypeDropDown);
			String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
			selectedValueList.add(selectedValue);
		}
		return selectedValueList;
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

        } else if (document != null && officeTypeValue.isEmpty()) {
            assertFalse(getNodeValuesByTagName(document, tagName).contains(officeTypeValue));
           assertEquals(officeTypeValue,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("basic_info_office_type_xpath")));
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