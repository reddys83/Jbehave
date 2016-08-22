package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.ParamMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.utils.SimpleCacheManager;
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
    public static String selectedEntity = "";

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

    public void selectOfficeLeadLocationFlag(String leadLocationflag) {
        selectRadioButtonByValue(OfficeIdentifiers.getObjectIdentifier("office_leadlocation_radio_options_xpath"), leadLocationflag);
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

     public void clickAddRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_addRow_id"));
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
    @Override
    public String getPageUrl() {
        return null;
    }

}