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
        assertTrue(getDriver().findElements(OfficeIdentifiers.getObjectIdentifier("office_basicInfo_openedDate_view_xpath")).size()>0);
    }
    @Override
    public String getPageUrl() {
        return null;
    }
}
