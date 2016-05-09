package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.ParamMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LegalEntityPage extends AbstractPage {
    private By legalEntity_entityType_label_xpath = By.xpath(".//*[@id='content']//h2[2]");
    private By legalEntity_entityType_type_label_xpath = By.xpath(".//*[@id='content']//table[2]//th");
    private By legalEntity_entityType_list_xpath = By.xpath(".//*[@id='content']//table[2]//td");
    private By legalEntity_telecoms_type_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Type']");
    private By legalEntity_telecoms_rank_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Rank']");
    private By legalEntity_telecoms_info_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Name']");
    private By legalEntity_telecoms_value_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='URL']");
    private By legalEntity_telecoms_type_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[1]");
    private By legalEntity_telecoms_rank_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[2]");
    private By legalEntity_telecoms_info_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[3]");
    private By legalEntity_telecoms_value_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[4]");
    private By legalEntity_basic_info_corporate_statement_label_xpath = By.xpath(".//*[@id='content']//dt");
    private By legalEntity_basic_info_corporate_statement_xpath = By.xpath(".//*[@id='content']//dd");
    private By legalEntity_services_link_id = By.id("legalEntityServices");
    private By legalEntity_offered_services_label_xpath = By.xpath("//li[h2 = 'Offered Services']//h2");
    private By legalEntity_offered_services_category_label_xpath = By.xpath("//li[h2 = 'Offered Services']//table/thead//th[1]");
    private By legalEntity_offered_services_override_label_xpath = By.xpath("//li[h2 = 'Offered Services']//table/thead//th[2]");
    private By legalEntity_financial_services_label_xpath = By.xpath("//li[h2 = 'Financial Services']//h2");
    private By legalEntity_financial_services_category_label_xpath = By.xpath("//li[h2 = 'Financial Services']//table/thead//th[1]");
    private By legalEntity_financial_services_details_label_xpath = By.xpath("//li[h2 = 'Financial Services']//table/thead//th[2]");
    private By legalEntity_services_label_xpath = By.xpath("//li[contains(h1,'Services')]/h1/span");
    private By legalEntity_search_msg_xpath = By.xpath("//*[@id='editHeader']/div/p");
    private By legalEntity_identifiers_link_id = By.id("legalEntityIdentifiers");
    private By legalEntity_statistics_link_id = By.id("legalEntityStatistics");
    private By legalEntity_locations_link_id = By.id("legalEntityLocationSummaries");
    private By legalEntity_location_summary_label_xpath = By.xpath(".//*[@id='content']//span[text()='Location Summaries']");
    private By legalEntity_locationSummaries_type_label_xpath = By.xpath(".//*[@id='content']//li[contains(h1,'Location Summaries')]//thead/tr/th[text()='Type']");
    private By legalEntity_locationSummaries_value_lable_xpath = By.xpath(".//*[@id='content']//li[contains(h1,'Location Summaries')]//thead/tr/th[text()='Value']");
    private By legalEntity_locationSummaries_list_values_xpath = By.xpath(".//*[@id='content']//li[contains(h1,'Location Summaries')]//tbody/tr");
    private By legalEntity_locations_summary_type_xpath = By.xpath(".//*[@id='content']//li[contains(h1,'Location Summaries')]//tbody/tr/td[1]");
    private By legalEntity_locations_summary_value_xpath = By.xpath(".//*[@id='content']//li[contains(h1,'Location Summaries')]//tbody/tr/td[2]");
    private By legalEntity_trustPowers_link_id = By.id("legalEntityTrustPowers");
    private By legalEntity_trustPowers_label_xpath = By.xpath(".//*[@id='content']//h1/span[text()='Trust Powers']");
    private By legalEntity_trustPower_granted_label_xpath = By.xpath(".//*[@id='content']//th[text()='Granted']");
    private By legalEntity_trustPower_full_label_xpath = By.xpath(".//*[@id='content']//th[text()='Full']");
    private By legalEntity_trustPower_used_label_xpath = By.xpath(".//*[@id='content']//th[text()='Used']");
    private By legalEntity_trustPower_profEmployees_label_xpath = By.xpath(".//*[@id='content']//th[text()='Prof. Employees']");
    private By legalEntity_trustPower_adminEmployees_label_xpath = By.xpath(".//*[@id='content']//th[text()='Admin Employees']");
    private By legalEntity_trustPower_minAccountSize_label_xpath = By.xpath(".//*[@id='content']//th[text()='Min Account Size ($)']");
    private By legalEntity_trustPower_values_list_xpath = By.xpath("//*[@id='content']//li[h1='Trust Powers']//tbody/tr");
    private By legalEntity_personnel_link_id = By.id("legalEntityPersonnel");
    private By legalEntity_credit_rating_link_id = By.id("legalEntityCreditRating");
    private By legalEntity_ownership_link_id = By.id("legalEntityOwnershipSummaries");

    private By legalEntity_ownership_label_xpath = By.xpath("//li[h1 = 'Ownership Summaries']//h1/span");
    private By legalEntity_ownership_type_label_xpath = By.xpath("//li[contains(h1,'Ownership Summaries')]//table/thead//th[1]");
    private By legalEntity_ownership_value_label_xpath = By.xpath("//li[contains(h1,'Ownership Summaries')]//table/thead//th[2]");
    private By legalEntity_ownership_type_list_xpath = By.xpath("//li[contains(h1,'Ownership Summaries')]//table/tbody//td[1]");
    private By legalEntity_ownership_value_list_xpath = By.xpath("//li[contains(h1,'Ownership Summaries')]//table/tbody//td[2]");
    private By legalEntity_history_link_id = By.id("legalEntityHistory");
    private By legalEntity_boardMeeting_link_id = By.id("legalEntityBoardMeetings");
    private By legalEntity_boardMeeting_label_xpath = By.xpath(".//li[h1='Board Meetings'] //h2");
    private By legalEntity_boardMeeting_summary_label_xpath = By.xpath("//li[h1='Board Meetings']//dt");
    private By legalEntity_boardMeeting_summary_value_xpath = By.xpath("//li[h1='Board Meetings']//dd");
    private By getLegalEntity_boardMeeting_type_value_xpath = By.xpath("//*[@id='legalEntityBoardMeetings']/table/tbody/tr/td[1]");
    private By legalEntity_boardMeeting_type_label_xpath = By.xpath("//li[h1='Board Meetings']//th[1]");
    private By legalEntity_boardMeeting_value_label_xpath = By.xpath("//li[h1='Board Meetings']//th[2]");
    String legalEntity_boardMeeting_type_values_xpath = ("//li[h1='Board Meetings']//tr[td='");
    private By legalEntity_boardMeeting_header_xpath = By.xpath("//li[h1='Board Meetings'] //span");
    private By legalEntity_location_summary_header_xpath = By.xpath("//li[h1='Location Summaries'] //span");
    private By legalEntity_ownership_header_xpath = By.xpath("//li[h1='Ownership Summaries'] //span");
    private By credit_rating_section_xpath = By.xpath("//li[h1='Credit Rating']");
    private By office_link_xpath = By.id("office-link");
    private By legalEntity_basicInfo_leftContainer_container_xpath = By.xpath("//*[@id='legalEntityBasicInfo']/ul/li[2]/table/tbody");

    private By legalEntity_basicInfo_status_list_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='Status']/td/select/option");
    private By legalEntity_basicInfo_status_dropdown_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='Status']/td/select");
    private By legalEntity_leadinstitution_radio_options_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//input[@name='leadInstitution']");
    private By legalEntity_basicInfo_leadInstitution_label_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/th");
    private By legalEntity_basicInfo_leadInstitution_value_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Lead Institution']/td");
    private By legalEnttity_basicInfo_CharterType_dropdown_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td/select");
    private By legalEnttity_basicInfo_CharterType_view_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td");
    private By legalEntity_basicInfo_day_Claimed_est_date_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/input[1]");
    private By legalEntity_basicInfo_year_Claimed_est_date_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/input[2]");
    private By legalEntity_basicInfo_Month__Claimed_est_date_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td/select");
    private By countryBasicInfo_claimedEst_date_error_message_xpath = By.xpath("//*[@class='notification error'][@data-error_id='establishedDateError']");
    private By legalEntity_basicInfo_claimedEstDate_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Claimed Est Date']/td");
    private By legalEntity_basicInfo_CharterType_dropdown_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td/select");
    private By legalEntity_basicInfo_CharterType_view_xpath = By.xpath("//*[@id='legalEntityBasicInfo'] //table/tbody/tr[th='Charter Type']/td");
    private By legalEntity_basicInfo_fatcastatus_list_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='FATCA Status']/td/select/option");
    private By legalEntity_basicInfo_fatcastatus_dropdown_xpath=By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody/tr[th='FATCA Status']/td/select");
    private By countryBasicInfo_confirmationModal_summary_xpath= By.xpath(".//*[@class='summary']//li");
    private By corporateSummary_textarea_xpath = By.xpath("//*[@id='legalEntityBasicInfo']/dl/dd/textarea");
    private By corporateSummary_textarea_maxLenght_error_xpath = By.xpath("//*[@id='legalEntityBasicInfo']/dl/dd/p");


    private By legalEntity_basicInfo_AdditionalInfo_textarea_xpath = By.xpath("//*[@id='legalEntityBasicInfo']//tr[th='Add Info']/td/textarea");
    private By legalEntity_basicInfo_AdditionalInfos_err_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='addInfoError']");

    public LegalEntityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalEntityEntities(ExamplesTable legalEntities) {
        assertEquals("ENTITY TYPES", getDriver().findElement(legalEntity_entityType_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(legalEntity_entityType_type_label_xpath).getText());
        List<WebElement> legalEntityEntityList = getDriver().findElements(legalEntity_entityType_list_xpath);
        assertTrue(legalEntities.getRowCount() == legalEntityEntityList.size());
        for (int i = 0; i < legalEntities.getRowCount(); i++) {
            assertEquals(legalEntities.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(), legalEntityEntityList.get(i).getText().replace(",", "").trim());
        }
    }

    public void verifyLegalEntitiesVirtualPresence(ExamplesTable legalEntitiesVirtualPresence) {
        assertEquals("TYPE", getDriver().findElement(legalEntity_telecoms_type_label_xpath).getText());
        assertEquals("RANK", getDriver().findElement(legalEntity_telecoms_rank_label_xpath).getText());
        assertEquals("NAME", getDriver().findElement(legalEntity_telecoms_info_label_xpath).getText());
        assertEquals("URL", getDriver().findElement(legalEntity_telecoms_value_label_xpath).getText());
        List<WebElement> type = getDriver().findElements(legalEntity_telecoms_type_xpath);
        List<WebElement> rank = getDriver().findElements(legalEntity_telecoms_rank_xpath);
        List<WebElement> info = getDriver().findElements(legalEntity_telecoms_info_xpath);
        List<WebElement> value = getDriver().findElements(legalEntity_telecoms_value_xpath);

        for (int i = 0; i < legalEntitiesVirtualPresence.getRowCount(); i++) {
            assertEquals(legalEntitiesVirtualPresence.getRow(i).get(legalEntitiesVirtualPresence.getHeaders().get(0)), type.get(i).getText());
            assertEquals(legalEntitiesVirtualPresence.getRow(i).get(legalEntitiesVirtualPresence.getHeaders().get(1)), rank.get(i).getText());
            assertEquals(legalEntitiesVirtualPresence.getRow(i).get(legalEntitiesVirtualPresence.getHeaders().get(2)), info.get(i).getText());
            assertEquals(legalEntitiesVirtualPresence.getRow(i).get(legalEntitiesVirtualPresence.getHeaders().get(3)), value.get(i).getText());
        }
    }

    public void verifyCorporateStatement(String corporateStatement) {
        assertEquals("Corporate Statement", getDriver().findElement(legalEntity_basic_info_corporate_statement_label_xpath).getText());
        assertEquals(corporateStatement, getDriver().findElement(legalEntity_basic_info_corporate_statement_xpath).getText());
    }


    public void clickOnLegalEntityServices() {
        attemptClick(legalEntity_services_link_id);
    }

    public void clickOnLegalEntityLocations() {
        attemptClick(legalEntity_locations_link_id);
    }

    public void clickOnLegalEntityStatistics() {
        attemptClick(legalEntity_statistics_link_id);
    }

    public void clickOnLegalEntityTrustPowers() {
        attemptClick(legalEntity_trustPowers_link_id);
    }

    public void verifyLegalEntityOfferedServices(ExamplesTable offeredServices) {
        verifyLegalEntityOfferedServicesLabels();
        verifyServices(offeredServices, "Offered Services");
    }

    public void verifyLegalEntityLocationsLabel() {
        assertEquals("LOCATION SUMMARIES", getTextOnPage(legalEntity_location_summary_label_xpath));
        assertEquals("TYPE", getTextOnPage(legalEntity_locationSummaries_type_label_xpath));
        assertEquals("VALUE", getTextOnPage(legalEntity_locationSummaries_value_lable_xpath));
    }

    public void verifyLegalEntityLocations(String selectedlegalEntity) {
        verifyLegalEntityLocationsLabel();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "get Office Location Summary From LegalEntity", "fid", selectedlegalEntity);

        for (int i = 0; i < getDriver().findElements(legalEntity_locationSummaries_list_values_xpath).size(); i++) {
            assertEquals(document.getElementsByTagName("summaryType").item(i).getTextContent(), getDriver().findElements(legalEntity_locations_summary_type_xpath).get(i).getText());
            assertEquals(document.getElementsByTagName("summaryValue").item(i).getTextContent(), getDriver().findElements(legalEntity_locations_summary_value_xpath).get(i).getText());
        }

    }

    public void verifyNoLegalEntityLocations() {
        verifyLegalEntityLocationsLabel();
        try {
            assertFalse(getDriver().findElement(By.xpath("//li[h2='Location Summaries']//table//tbody//td[1]")).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void verifyLegalEntityOfferedServicesLabels() {
        verifyServicesLabel();
        assertEquals("OFFERED SERVICES", getTextOnPage(legalEntity_offered_services_label_xpath));
        assertEquals("CATEGORY", getTextOnPage(legalEntity_offered_services_category_label_xpath));
        assertEquals("OVERRIDE", getTextOnPage(legalEntity_offered_services_override_label_xpath));
    }


    public void verifyLegalEntityFinancialServices(ExamplesTable financialServices) {
        verifyLegalEntityFinancialServicesLabels();
        verifyServices(financialServices, "Financial Services");
    }

    public void verifyLegalEntityFinancialServicesLabels() {
        verifyServicesLabel();
        assertEquals("FINANCIAL SERVICES", getTextOnPage(legalEntity_financial_services_label_xpath));
        assertEquals("FINANCIAL CATEGORY", getTextOnPage(legalEntity_financial_services_category_label_xpath));
        assertEquals("FINANCIAL DETAILS", getTextOnPage(legalEntity_financial_services_details_label_xpath));
    }

    public void verifyServices(ExamplesTable services, String serviceType) {
        List<WebElement> category = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[1]"));
        List<WebElement> override_details = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[2]"));

        for (int i = 0; i < services.getRowCount(); i++) {
            assertEquals(services.getRow(i).get(services.getHeaders().get(0)), category.get(i).getText());
            assertEquals(services.getRow(i).get(services.getHeaders().get(1)), override_details.get(i).getText());
        }
    }


    public void verifyLegalEntityTrustPowersLabels() {
        assertEquals("TRUST POWERS", getTextOnPage(legalEntity_trustPowers_label_xpath));
        assertEquals("GRANTED", getTextOnPage(legalEntity_trustPower_granted_label_xpath));
        assertEquals("FULL", getTextOnPage(legalEntity_trustPower_full_label_xpath));
        assertEquals("USED", getTextOnPage(legalEntity_trustPower_used_label_xpath));
        assertEquals("PROF. EMPLOYEES", getTextOnPage(legalEntity_trustPower_profEmployees_label_xpath));
        assertEquals("ADMIN EMPLOYEES", getTextOnPage(legalEntity_trustPower_adminEmployees_label_xpath));
        assertEquals("MIN ACCOUNT SIZE ($)", getTextOnPage(legalEntity_trustPower_minAccountSize_label_xpath));
    }

    public void verifyLegalEntityTrustPowersfromDB(String searchedEntity) {

        verifyLegalEntityTrustPowersLabels();
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "get Trust Powers for Legal Entity", "fid", searchedEntity);
        String powersGrantedValue = getNodeValuesByTagName(document, "powersGranted").size() == 0 ? "" : getNodeValuesByTagName(document, "powersGranted").get(0);
        String powersFullValue = getNodeValuesByTagName(document, "powersFull").size() == 0 ? "" : getNodeValuesByTagName(document, "powersFull").get(0);
        String powersUsedValue = getNodeValuesByTagName(document, "powersUsed").size() == 0 ? "" : getNodeValuesByTagName(document, "powersUsed").get(0);
        String professionalValue = getNodeValuesByTagName(document, "professional").size() == 0 ? "" : getNodeValuesByTagName(document, "professional").get(0);
        String administrativeValue = getNodeValuesByTagName(document, "administrative").size() == 0 ? "" : getNodeValuesByTagName(document, "administrative").get(0);
        String minAccountSizeValue = getNodeValuesByTagName(document, "minAccountSize").size() == 0 ? "" : getNodeValuesByTagName(document, "minAccountSize").get(0);

        assertEquals(powersGrantedValue + " " + powersFullValue + " " + powersUsedValue + " " + professionalValue + " " + administrativeValue + " " + minAccountSizeValue, getTextOnPage(legalEntity_trustPower_values_list_xpath).replace(",", "").trim());
    }

    public void verifyNoLegalEntityTrustPowers() {
        verifyLegalEntityTrustPowersLabels();
        try {
            assertFalse(getDriver().findElement(legalEntity_trustPower_values_list_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyServicesLabel() {
        assertEquals("SERVICES", getTextOnPage(legalEntity_services_label_xpath));
    }

    public void verifyLegalEntitySearchMsg() {
        assertEquals("You can search for a legal entity at any time using the header search.", getTextOnPage(legalEntity_search_msg_xpath));
    }

    public void verifyNoLegalEntityOfferedServices() {
        verifyLegalEntityOfferedServicesLabels();
        try {
            assertFalse(getDriver().findElement(By.xpath("//li[h2='Offered Services']//tr/td")).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void verifyNoLegalEntityFinancialServices() {
        verifyLegalEntityFinancialServicesLabels();
        try {
            assertFalse(getDriver().findElement(By.xpath("//li[h2='Financial Services']//tr/td")).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnLegalEntityPersonnel() {
        attemptClick(legalEntity_personnel_link_id);
    }

    public void clickOnLegalEntityCreditRating() {
        attemptClick(legalEntity_credit_rating_link_id);
    }

    public void clickOnLegalEntityHistory() {
        attemptClick(legalEntity_history_link_id);
    }

    public void clickOnLegalEntityBoardMeetings() {
        attemptClick(legalEntity_boardMeeting_link_id);
    }

    public void verifyBoardMeetingsLabels() {
        assertEquals("BOARD MEETINGS", getTextOnPage(legalEntity_boardMeeting_header_xpath));
        assertEquals("BOARD MEETINGS", getTextOnPage(legalEntity_boardMeeting_label_xpath));
        assertEquals("Summary", getTextOnPage(legalEntity_boardMeeting_summary_label_xpath));
        assertEquals("TYPE", getTextOnPage(legalEntity_boardMeeting_type_label_xpath));
        assertEquals("VALUE", getTextOnPage(legalEntity_boardMeeting_value_label_xpath));
    }

    public void verifyBoardMeetingsSummary(String SummaryValue) {
        verifyBoardMeetingsLabels();
        assertEquals(SummaryValue, getDriver().findElement(getLegalEntity_boardMeeting_type_value_xpath).getText());
    }

    public void verifyNoBoardMeetingsSummary() {
        verifyBoardMeetingsLabels();
        try {
            assertFalse(getDriver().findElement(legalEntity_boardMeeting_summary_value_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyBoardMeetingsValues(ExamplesTable BoardMeetingsValues) {
        verifyBoardMeetingsLabels();
        for (int i = 0; i < BoardMeetingsValues.getRowCount(); i++) {
            assertEquals(BoardMeetingsValues.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath(legalEntity_boardMeeting_type_values_xpath + BoardMeetingsValues.getRow(i).get(BoardMeetingsValues.getHeaders().get(0)) + "']")).getText().replace(",", "").trim());
        }
    }

    public void verifyNoBoardMeetingsValues() {
        verifyBoardMeetingsLabels();
        try {
            assertFalse(getDriver().findElement(legalEntity_boardMeeting_summary_value_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnLegalEntityOwnership() {
        attemptClick(legalEntity_ownership_link_id);
    }

    public void verifyLegalEntityOwnership(ExamplesTable legalEntityOwnership) {
        verifyOwnershipLabels();
        List<WebElement> type = getDriver().findElements(legalEntity_ownership_type_list_xpath);
        List<WebElement> value = getDriver().findElements(legalEntity_ownership_value_list_xpath);

        for (int i = 0; i < legalEntityOwnership.getRowCount(); i++) {
            assertEquals(legalEntityOwnership.getRow(i).get(legalEntityOwnership.getHeaders().get(0)), type.get(i).getText());
            assertEquals(legalEntityOwnership.getRow(i).get(legalEntityOwnership.getHeaders().get(1)), value.get(i).getText());
        }
    }

    public void verifyOwnershipLabels() {
        assertEquals("OWNERSHIP SUMMARIES", getTextOnPage(legalEntity_ownership_label_xpath));
        assertEquals("TYPE", getTextOnPage(legalEntity_ownership_type_label_xpath));
        assertEquals("VALUE", getTextOnPage(legalEntity_ownership_value_label_xpath));
    }

    public void verifyNoLegalEntityOwnership() {
        verifyOwnershipLabels();
        try {
            assertFalse(getDriver().findElement(legalEntity_ownership_type_list_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void clickOnLegalEntityIdentifierLink() {
        attemptClick(legalEntity_identifiers_link_id);
    }

    public void verifyNoLegalEntityCreditRatingsSection() {
        try {
            assertFalse(getDriver().findElement(credit_rating_section_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public OfficesPage clickOnOfficesLink() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attemptClick(office_link_xpath);
        return new OfficesPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void selectLegalEntityLeadInstitutionFlag(String leadInstitutionflag) {
        selectRadioButtonByValue(legalEntity_leadinstitution_radio_options_xpath, leadInstitutionflag);
    }

    public void changeLegalEntityLeadInstitutionFlag() {
        String newleadInstitutionflag = "";
        String selectedRadioValue = getSelectedRadioValue(legalEntity_leadinstitution_radio_options_xpath);
        if (selectedRadioValue.equalsIgnoreCase("true")) {
            newleadInstitutionflag = "false";
        } else if (selectedRadioValue.equalsIgnoreCase("false")) {
            newleadInstitutionflag = "true";
        }
        selectRadioButtonByValue(legalEntity_leadinstitution_radio_options_xpath, newleadInstitutionflag);
    }

    public void verifyEditLegalEntityLeadInstitutionFlagInDB(String fid, String source) {

        assertEquals(getLeadInstitutionFlagFromDB(fid, source), getSelectedRadioValue(legalEntity_leadinstitution_radio_options_xpath));

    }

    public void verifyLeadInstitutionValuefromDB(String leadInstitutionflag, String selectedEntity, String source) {
        assertEquals(getLeadInstitutionFlagFromDB(selectedEntity, source), leadInstitutionflag);
    }

    public String getLeadInstitutionFlagFromDB(String fid, String source) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", source));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        String leadInstitutionDBValue = getNodeValuesByTagName(document, "leadInstitution").size() == 0 ? "" : getNodeValuesByTagName(document, "leadInstitution").get(0);
        return leadInstitutionDBValue;
    }

    public void verifyEditLegalEntityLeadInstitutionFlag(String leadInstitutionflag) {
        assertEquals(leadInstitutionflag, getSelectedRadioValue(legalEntity_leadinstitution_radio_options_xpath));
    }

    public void verifyNoLeadInstitution() {
        try {
            assertFalse(getDriver().findElement(legalEntity_basicInfo_leadInstitution_label_xpath).isDisplayed());
            assertFalse(getDriver().findElement(legalEntity_basicInfo_leadInstitution_value_xpath).isDisplayed());
        } catch (NoSuchElementException e) {

        }
    }

    public void verifyLegalEntityEditPageMode() {
        assertTrue(getDriver().findElements(legalEntity_leadinstitution_radio_options_xpath).size() > 0);
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
        fetchingIndRecordsFromContainerUpperCaseConversion(legalEntity_basicInfo_leftContainer_container_xpath, "status", nvPairs, "status");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Claimed Est Date", nvPairs, "claimedEstDate");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Chartered Date", nvPairs, "characteredDate");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Charter Type", nvPairs, "charterType");
        fetchingIndRecordsFromContainerUpperCaseConversion(legalEntity_basicInfo_leftContainer_container_xpath, "FATCA Status", nvPairs, "fatcaStatus");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Insurance Type", nvPairs, "insuranceType");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Ownership Type", nvPairs, "organisationType");
        fetchingIndRecordsFromContainerUpperCaseConversion(legalEntity_basicInfo_leftContainer_container_xpath, "Lead Institution", nvPairs, "leadInstitution");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Add Info", nvPairs, "additionalinfo");
        fetchingIndRecordsFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Country of Operations", nvPairs, "countryOfOperation");
        fetchingHeadOfficeAddressFromContainer(legalEntity_basicInfo_leftContainer_container_xpath, "Head Office", nvPairs, "headOfficeaddressLine1");

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

    public void clickOnStatusType() {
        attemptClick(legalEntity_basicInfo_status_dropdown_xpath);
    }

    public void verifyCharterTypeOptions() {

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "get charter type from lookup document", "source", "source-trusted");
        Select charterTypeDropDown = new Select(getDriver().findElement(legalEntity_basicInfo_CharterType_dropdown_xpath));
        Integer optionsDisplayed = charterTypeDropDown.getOptions().size();
        for (int i = 0; i < optionsDisplayed - 2; i++) {
            assertEquals(charterTypeDropDown.getOptions().get(i + 1).getText(), document.getElementsByTagName("a").item(i).getTextContent());
        }
    }

    public void verifyLegalEntityStatusList() {
        List<WebElement> statusList = getDriver().findElements(legalEntity_basicInfo_status_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get legal entity Status types");
        for (int i = 1; i < document.getElementsByTagName("status").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), statusList.get(i).getAttribute("value"));
        }
    }


    public void enterValueInStatusDropdown(String word) {
        getDriver().findElement(legalEntity_basicInfo_status_dropdown_xpath).sendKeys(word);
    }


    public void verifyStatusInDropdown(String status) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(getSelectedDropdownValue(legalEntity_basicInfo_status_dropdown_xpath).equalsIgnoreCase(status));

    }

    public void verifyEditLegalEntityStatusValueFromTrusted(String fid, String tagName, String source) {

        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), getSelectedDropdownValue(legalEntity_basicInfo_status_dropdown_xpath));

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

    public void selectLegalEntityStatusValue(String status) {
        selectItemFromDropdownListByValue(legalEntity_basicInfo_status_dropdown_xpath, status);
    }

    public void verifyEditLegalEntityStatusValueFromZeus(String status, String tagName, String fid, String source) {

        assertEquals(getLegalEntityValuesFromDB(fid, tagName, source), status);

    }

    public void changeLegalEntityStatusValue() {
        String valuetobeSelected = "";

        Select dropdown = new Select(getDriver().findElement(legalEntity_basicInfo_status_dropdown_xpath));
        for (WebElement option : dropdown.getOptions()) {
            if (!option.isSelected()) {
                valuetobeSelected = option.getAttribute("value");
                break;
            }
        }

        selectItemFromDropdownListByValue(legalEntity_basicInfo_status_dropdown_xpath, valuetobeSelected);

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
        Select charterTypeDropDown = new Select(getDriver().findElement(legalEntity_basicInfo_CharterType_dropdown_xpath));
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), charterTypeDropDown.getFirstSelectedOption().getText());
    }

    public void updateCharterType(String charterType) {
        Select charterTypeDropDown = new Select(getDriver().findElement(legalEntity_basicInfo_CharterType_dropdown_xpath));
        charterTypeDropDown.selectByVisibleText(charterType);

    }

    public void verifyUpdatedCharterTypeBothDocs(String fid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), getDriver().findElement(legalEntity_basicInfo_CharterType_view_xpath).getText());


        List<NameValuePair> zeusPairs = new ArrayList<>();
        zeusPairs.add(new BasicNameValuePair("fid", fid));
        zeusPairs.add(new BasicNameValuePair("source", "zeus"));
        document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
        assertEquals(document.getElementsByTagName("charterType").item(0).getTextContent(), getDriver().findElement(legalEntity_basicInfo_CharterType_view_xpath).getText());
    }

    public void enterDayValueForClaimedEstDate(String day) {
        getDriver().findElement(legalEntity_basicInfo_day_Claimed_est_date_xpath).click();
        getDriver().findElement(legalEntity_basicInfo_day_Claimed_est_date_xpath).clear();
        getDriver().findElement(legalEntity_basicInfo_day_Claimed_est_date_xpath).sendKeys(day);
    }

    public void enterMonthValueForClaimedEstDate(String month) {
        Select monthDropdown = new Select(getDriver().findElement(legalEntity_basicInfo_Month__Claimed_est_date_xpath));
        monthDropdown.selectByValue(month);
    }

    public void enterYearValueForClaimedEstDate(String year) {
        getDriver().findElement(legalEntity_basicInfo_year_Claimed_est_date_xpath).click();
        getDriver().findElement(legalEntity_basicInfo_year_Claimed_est_date_xpath).clear();
        getDriver().findElement(legalEntity_basicInfo_year_Claimed_est_date_xpath).sendKeys(year);
    }

    public void validateErrorMessageforClaimedEstDate() {
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(countryBasicInfo_claimedEst_date_error_message_xpath).getText());
    }

    public void verifyUpdatedClaimedEstDateBothDocs(String fid) {
        try {
            Thread.sleep(1000L);
            List<NameValuePair> nvPairs = new ArrayList<>();
            nvPairs.add(new BasicNameValuePair("fid", fid));
            nvPairs.add(new BasicNameValuePair("source", "trusted"));
            Thread.sleep(5000L);
            Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", nvPairs);
            assertEquals(document.getElementsByTagName("claimedEstDate").item(0).getTextContent(), getDriver().findElement(legalEntity_basicInfo_claimedEstDate_xpath).getText());


            List<NameValuePair> zeusPairs = new ArrayList<>();
            zeusPairs.add(new BasicNameValuePair("fid", fid));
            zeusPairs.add(new BasicNameValuePair("source", "zeus"));
            Thread.sleep(5000L);
            document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity basic info left column", zeusPairs);
            assertEquals(document.getElementsByTagName("claimedEstDate").item(0).getTextContent(), getDriver().findElement(legalEntity_basicInfo_claimedEstDate_xpath).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void selectLegalEntityFatcaStatusValue(String status) {
        selectItemFromDropdownListByValue(legalEntity_basicInfo_fatcastatus_dropdown_xpath, status);
    }

    public void clickOnFatcaStatusType() {
        attemptClick(legalEntity_basicInfo_fatcastatus_dropdown_xpath);
    }

    public void verifyLegalEntityFatcaStatusList(String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> statusList = getDriver().findElements(legalEntity_basicInfo_fatcastatus_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity Status types",nvPairs);
        for (int i = 0; i < document.getElementsByTagName("status").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), statusList.get(i+1).getAttribute("value"));
        }
    }


    public void enterValueInFatcaStatusDropdown(String word) {
        //getDriver().findElement(legalEntity_basicInfo_status_dropdown_xpath).click();
        getDriver().findElement(legalEntity_basicInfo_fatcastatus_dropdown_xpath).sendKeys(word);
        //System.out.println("focus value"+getDriver().findElements(legalEntity_basicInfo_status_list_xpath).get(0).getCssValue("focus"));
    }

    public void verifyFatcaStatusInDropdown(String status) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(getSelectedDropdownValue(legalEntity_basicInfo_fatcastatus_dropdown_xpath).contains(status));

    }

    public void verifyEditLegalEntityFatcaStatusValueFromZeus(String fatcastatus,String tagName,String fid,String source){

        assertEquals(getLegalEntityValuesFromDB(fid,tagName,source),fatcastatus);

    }


    public void verifyEditLegalEntityFatcaStatusValueFromTrusted(String fid,String tagName, String source){

        assertEquals(getLegalEntityValuesFromDB(fid,tagName,source),getSelectedDropdownValue(legalEntity_basicInfo_fatcastatus_dropdown_xpath));

    }

    public void changeLegalEntityFatcaStatusValue()
    {
        String valuetobeSelected="";
        Select dropdown = new Select(getDriver().findElement(legalEntity_basicInfo_fatcastatus_dropdown_xpath));
        for (WebElement option:dropdown.getOptions())
        {
            if(!option.isSelected())
            {
                valuetobeSelected= option.getAttribute("value");
                break;
            }
        }

        selectItemFromDropdownListByValue(legalEntity_basicInfo_fatcastatus_dropdown_xpath, valuetobeSelected);

    }

    public void enterValueForCorporateStatement(String corporateStatement) {
        getDriver().findElement(corporateSummary_textarea_xpath).clear();
        getDriver().findElement(corporateSummary_textarea_xpath).sendKeys(corporateStatement);
    }

    public void verifyUpdatedCorporateSummary(String fid,String corporateStatement) {
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

    public void verifyMaxLengthCorporateActionTextArea() {
        assertEquals(getDriver().findElement(corporateSummary_textarea_xpath).getAttribute("maxlength"),"10000");
    }


    public void enter10001CharactersInLegalEntityCorporateAction()
    {
        String strBigString=createBigString(10000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('maxlength','10001')",getDriver().findElement(corporateSummary_textarea_xpath));
        getDriver().findElement(corporateSummary_textarea_xpath).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+strBigString+"'",getDriver().findElement(corporateSummary_textarea_xpath));
        getDriver().findElement(corporateSummary_textarea_xpath).sendKeys("1");
    }

    public void enter10000CharactersInLegalEntityCorporateAction()
    {
        String strBigString=createBigString(10000);
        getDriver().findElement(corporateSummary_textarea_xpath).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+strBigString+"'",getDriver().findElement(corporateSummary_textarea_xpath));
    }

    public void verifyLegalEntityCorporateActionErrorMessageForMaxLength() {
        assertEquals(getDriver().findElement(corporateSummary_textarea_maxLenght_error_xpath).getText(),"Enter up to 10000 valid characters.");
    }

    public void enterLegalEntityAdditionalInfo(String additionalInfoText)
    {
        getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).clear();
        getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).sendKeys(additionalInfoText);
    }

    public void verifyEditLegalEntityAdditionalInfoValueFromZeus(String additionalInfoText,String tagName,String fid,String source){

        assertEquals(getLegalEntityValuesFromDB(fid,tagName,source),additionalInfoText);

    }

    public void verifyAdditionalInfoValueWithMaxLengthFromZeus(String tagName,String fid,String source){

        assertEquals(getLegalEntityValuesFromDB(fid,tagName,source),bigString);

    }

    public void verifyAdditionalInfoTextAreaLength(String fid)
    {
        assertEquals(getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).getAttribute("maxlength"),"10000");
    }


    public void enter10001CharactersInLegalEntityAdditionalInfo(String fid)
    {
        String strBigString=createBigString(10000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('maxlength','10001')",getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath));
        getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+strBigString+"'",getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath));
        getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).sendKeys("1");
    }

    public void enter10000CharactersInLegalEntityAdditionalInfo(String fid)
    {
        String strBigString=createBigString(10000);
        getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath).clear();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+strBigString+"'",getDriver().findElement(legalEntity_basicInfo_AdditionalInfo_textarea_xpath));
    }

    public void verifyLegalEntityAdditionalInfoErrorMessageForMaxLength()
    {
        assertEquals(getDriver().findElement(legalEntity_basicInfo_AdditionalInfos_err_msg_xpath).getText(),"Enter up to 10000 valid characters.");
    }
}

