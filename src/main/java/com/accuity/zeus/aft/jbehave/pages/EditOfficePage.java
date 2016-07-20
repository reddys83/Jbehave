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


    public void verifyUpdatedOfficeOpenedDate(String fid, String day, String month, String year) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", fid));
        zeusPairs.add(new BasicNameValuePair("source", "zeus"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get office basic info", zeusPairs);
        assertEquals(document.getElementsByTagName("officeOpenedDate").item(0).getTextContent(), getDriver().findElement(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_view_xpath")).getText());
        assertEquals(document.getElementsByTagName("officeOpenedDate").item(0).getTextContent().replace(" ",""), day+month+year);
    }


    public void verifyOfficesNameTypesFromLookup(String rowIdentifier,String lookupFid)
    {   List<NameValuePair> nvPairs = new ArrayList<>();
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
                WebElement type = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(i+1).findElement(By.xpath("td/select"));
                WebElement value = getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(i+1).findElement(By.xpath("td/input"));
                assertEquals(typeList.get(i), (new Select(type)).getFirstSelectedOption().getText());
                assertEquals(valueList.get(i), value.getAttribute("value"));
            }
            assertEquals(typeList.get(0), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(1).findElement(By.xpath("td")).getText());
            assertEquals(valueList.get(0), getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_Edit_officenames_Table")).get(1).findElement(By.xpath("td/input")).getAttribute("value"));

        }
    }

    public void selectOfficeNameType(String officeNameTypeRowIdentifier, String type) {
        selectItemFromDropdownListByText(OfficeIdentifiers.getObjectIdentifier(officeNameTypeRowIdentifier),type);
    }

    public void enterOfficeNameValue(String officeNameValueRowIdentifier, String value) {
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(officeNameValueRowIdentifier)).clear();
        getDriver().findElement(OfficeIdentifiers.getObjectIdentifier(officeNameValueRowIdentifier)).sendKeys(value);
    }


    public void verifyEditOfficeNameValuesExistInZeusAndUI(String type, String value, String officeFid, String source) {

        assertTrue(checkEditOfficeNameValuesFromZeus(type,value,officeFid,source));
        assertEquals(type,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_name_second_row_existing_office_type_dropdown")));
        assertEquals(value,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_name_second_row_existing_office_value")));
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
        assertEquals(sortName,getTextOnPage(OfficeIdentifiers.getObjectIdentifier("office_name_sort_name_xpath")));

    }


    @Override
    public String getPageUrl() {
        return null;
    }
}
