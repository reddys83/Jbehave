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
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_month_xpath"),month);
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
        assertEquals(document.getElementsByTagName("officeOpenedDate").item(0).getTextContent().replace(" ",""), day+month+year);
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

    public void clickAddRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_addRow_id"));
    }

    public void verifyAddOfficeLocationButtonStatus(String add_button) {
        assertFalse(getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(add_button)).isEnabled());
    }

    public void clickonDeleteOfficeLocationsRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyOfficeLocationRowIsNotDisplayed() {
        try
        {
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

    public void selectOfficeAddressType(String typeRowIdentifier,String Type){
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier),Type);

    }

    public void enterofficeAddressLine1(String addressLine1RowIdentifier,String AddressLine1){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine1RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine1RowIdentifier)).sendKeys(AddressLine1);

    }

    public void enterofficeAddressLine2(String addressLine2RowIdentifier,String AddressLine2){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine2RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine2RowIdentifier)).sendKeys(AddressLine2);

    }

    public void enterofficeAddressLine3(String addressLine3RowIdentifier,String AddressLine3){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine3RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine3RowIdentifier)).sendKeys(AddressLine3);

    }

    public void enterofficeAddressLine4(String addressLine4RowIdentifier,String AddressLine4){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine4RowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(addressLine4RowIdentifier)).sendKeys(AddressLine4);

    }

    public CountryPage enterOfficeCountryInTheTypeAheadBox(String country) {
        SimpleCacheManager.getInstance().put("selectedCountry",country);
        selectedEntity = country;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_country_type_ahead_xpath")).sendKeys(country);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_country_type_ahead_xpath")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CountryPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
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
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
            assertEquals(document.getElementsByTagName("area").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list_xpath")).get(i).getText());

        }
    }

    public void enterOfficeAreaInTypeAhead(String area) {
        SimpleCacheManager.getInstance().put("selectedArea",area);
        selectedEntity = area;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_typeAhead_xpath")).sendKeys(area);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_typeAhead_xpath")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(3000L);
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
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "subarea list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("subarea").getLength(); i++) {
            assertEquals(document.getElementsByTagName("subarea").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_list_xpath")).get(i).getText());
        }
    }


    public void enterOfficeSubAreaInTypeAhead(String subarea) {
        SimpleCacheManager.getInstance().put("selectedSubArea",subarea);
        selectedEntity = subarea;
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_typeAhead_xpath")).sendKeys(subarea);
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown_typeAhead_xpath")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyCitiesForSelectedSubArea(ExamplesTable cities) {
        List<WebElement> subareasCollection = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list_xpath"));
        for (int i = 0; i < cities.getRowCount(); i++) {
            assertEquals(cities.getRow(i).get(cities.getHeaders().get(0)), subareasCollection.get(i).getText());
        }
    }


    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        List<WebElement> areasCollection = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list_xpath"));
        for (int i = 0; i < areas.getRowCount(); i++) {
            assertEquals(areas.getRow(i).get(areas.getHeaders().get(0)), areasCollection.get(i).getText());
        }
    }


    public void clickOnAreaDropdown() {
        //waitForElementToAppear(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_typeAhead_xpath"));
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown_list_xpath"));
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
            assertEquals(document.getElementsByTagName("city").item(i).getTextContent(), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown_list_xpath")).get(i).getText());
        }
    }

    public void clickonDeleteOfficeAddressRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyOfficeAddressRowIsNotDisplayed() {
        try
        {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_address_delete_row_view"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnAddTelecomsRowButton() {
        attemptClick(OfficeIdentifiers.getObjectIdentifier("office_telecoms_addRow_id"));
    }

    public void selectOfficeTelecomsType(String typeRowIdentifier,String Type){
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier),Type);

    }

    public void enterOfficeTelecomsRank(String rankRowIdentifier,String Rank){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rankRowIdentifier)).sendKeys(Rank);

    }

    public void enterOfficeTelecomsTextBefore(String textBeforeRowIdentifier,String TextBefore){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(textBeforeRowIdentifier)).sendKeys(TextBefore);

    }

    public void enterOfficeTelecomsValue(String valueRowIdentifier,String Value){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier)).sendKeys(Value);

    }

    public void enterOfficeTelecomsRangeLimit(String rangeLimitRowIdentifier,String RangeLimit){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rangeLimitRowIdentifier)).sendKeys(RangeLimit);

    }

    public void enterOfficeTelecomsExt(String extRowIdentifier,String Ext){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(extRowIdentifier)).sendKeys(Ext);

    }

    public void enterOfficeTelecomsTextAfter(String textAfterRowIdentifier,String TextAfter){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(textAfterRowIdentifier)).sendKeys(TextAfter);

    }

    public void enterOfficeTelecomsAnswerBack(String answerBackRowIdentifier,String AnswerBack){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(answerBackRowIdentifier)).sendKeys(AnswerBack);

    }

    public void verifyOfficeTelecomsRowIsNotDisplayed() {
        try
        {
            WebElement identifier = getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_telecoms_delete_row_view"));
            assertTrue(identifier != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void enterOfficeAddressPostalCode(String postalCodeRowIdentifier,String PostalCode){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(postalCodeRowIdentifier)).sendKeys(PostalCode);

    }

    public void enterOfficeAddressPostalCodeSuffix(String postalCodeSuffixRowIdentifier,String PostalCodeSuffix){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(postalCodeSuffixRowIdentifier)).sendKeys(PostalCodeSuffix);

    }
    public void enterOfficeAddressInfo(String infoRowIdentifier,String Info){
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(infoRowIdentifier)).sendKeys(Info);

    }

    public void clickonDeleteOfficeTelecomsRowButton(String rowIdentifier) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(rowIdentifier)).click();
    }

    public void verifyOfficeAddressTypesFromLookup(String rowIdentifier,String lookupFid)
    {   List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> officeLocationsList = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier(rowIdentifier));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office address type from lookup", nvPairs);
        for (int i = 1; i < document.getElementsByTagName("officeAddressTypes").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), officeLocationsList.get(i).getAttribute("value"));
        }


    }
    @Override
    public String getPageUrl() {
        return null;
    }
}
