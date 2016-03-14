package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OfficesPage extends AbstractPage {

    private String office_results_card_xpath = "//*[@id='data']//tr[td='";
    private By office_personnel_link_id = By.id("officePersonnel");
    private By office_basic_info_link_id = By.id("officeBasicInfo");
    private By office_history_link_id = By.id("officeHistory");
    private By office_identifiers_link_id = By.id("officeIdentifiers");
    private By office_services_link_id = By.id("officeServices");
    private By office_services_label_xpath = By.xpath("//li[contains(h1,'Services')]/h1/span");
    private By office_service_category_label_xpath = By.xpath("//li[contains(h1,'Services')]//table/thead//th[1]");
    private By office_service_override_label_xpath = By.xpath("//li[contains(h1,'Services')]//table/thead//th[2]");
    private By office_statistics_link_id = By.id("officeStatistics");
    private By office_credit_ratings_link_id = By.id("officeCreditRating");
    private By office_legalTitle_header_link_xpath = By.xpath(".//*[@id='cssTempFixId']/header//a");
    private By office_tab_id = By.id("office-link");
    private By office_department_tab_id = By.id("department-link");
    private By office_locations_link_id = By.id("officeLocations");
    private By office_locations_section_xpath = By.xpath("//*[@class='location']");
    private By office_locations_address_xpath = By.xpath("//*[@class='location']");
    private By office_location_primary_xpath = By.xpath("//*[@class='location']/dl[1]");
    private By office_location_address_type_xpath = By.xpath("//*[@class='location']/dl[dt='Type']");
    private By office_locations_addresses_title_xpath = By.xpath("//*[@class='location']/h2[1]");
    private By office_locations_title_xpath = By.xpath("//*[@id='content']//h1[span='Locations']");
    private By office_locations_address_line_1_xpath = By.xpath("//*[@class='location']//li[1]//tr[1]");
    private By office_locations_address_line_2_xpath = By.xpath("//*[@class='location']//li[1]//tr[2]");
    private By office_locations_address_line_3_xpath = By.xpath("//*[@class='location']//li[1]//tr[3]");
    private By office_locations_address_line_4_xpath = By.xpath("//*[@class='location']//li[1]//tr[4]");
    private By office_locations_city_xpath = By.xpath("//*[@class='location']//li[2]//tr[1]");
    private By office_locations_subarea_xpath = By.xpath("//*[@class='location']//li[2]//tr[2]");
    private By office_locations_area_xpath = By.xpath("//*[@class='location']//li[2]//tr[3]");
    private By office_locations_country_xpath = By.xpath("//*[@class='location']//li[2]//tr[4]");
    private By office_locations_postal_code_xpath = By.xpath("//*[@class='location']//li[3]//tr[1]");
    private By office_locations_postal_code_1_xpath = By.xpath(".//*[@id='content']/div/ul/li/div/ul/li[3]/table/tbody/tr[1]");
    private By office_locations_postal_code_pos_xpath = By.xpath("//*[@class='location']//li[3]//tr[2]");
    private By office_locations_postal_code_suffix_xpath = By.xpath("//*[@class='location']//li[3]//tr[3]");
    private By office_locations_info_xpath = By.xpath("//*[@class='location']//li[3]//tr[4]");
    private By office_locations_telecoms_title_xpath = By.xpath("//*[@class='location']/h2[2]");
    private By office_locations_telecoms_table_columns_xpath = By.xpath("//*[@class='location']/table/thead/tr");
    private By office_locations_telecoms_type_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[1]");
    private By office_locations_telecoms_rank_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[2]");
    private By office_locations_telecoms_text_before_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[3]");
    private By office_locations_telecoms_value_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[4]");
    private By office_locations_telecoms_range_limit_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[5]");
    private By office_locations_telecoms_ext_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[6]");
    private By office_locations_telecoms_text_after_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[7]");
    private By office_locations_telecoms_answerback_xpath = By.xpath("//*[@class='location']/table/tbody/tr/td[8]");
    private By office_locations_summary_title_xpath = By.xpath("//li[h2='Summary']/h2");
    private By office_locations_summary_column_xpath = By.xpath("//li[h2='Summary']/table/thead/tr");
    private By office_locations_summary_type_xpath = By.xpath("//li[h2='Summary']/table/tbody/tr/td[1]");
    private By office_locations_summary_value_xpath = By.xpath("//li[h2='Summary']/table/tbody/tr/td[2]");
    private By office_locations_summaries_xpath = By.xpath("//li[h2='Summary']/table/tbody/tr");
    private By office_address_label_xpath = By.xpath("//*[@id='subEntityList-list']//table/thead/tr/th[3]");


    public OfficesPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
       super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void clickOnOfficeResultsCard(String officeFid) {
        attemptClick(By.xpath(office_results_card_xpath + officeFid + "']"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnOfficePersonnelLink() {
        attemptClick(office_personnel_link_id);
    }

    public void clickOnOfficeServicesLink() {
        attemptClick(office_services_link_id);
    }

    public void clickOnOfficeStatisticsLink() {
        attemptClick(office_statistics_link_id);
    }

    public void clickOnLegalTitleOnOfficeHeader() {
        attemptClick(office_legalTitle_header_link_xpath);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyNoServices() {
        verifyOfficeOfferedServicesLabels();
        try {
            assertFalse(getDriver().findElement(By.xpath("//li[h2='Offered Services']//table//tbody//td[1]")).isDisplayed());
        }catch (NoSuchElementException e){

        }
    }

    public void verifyOfficesDepartmentTabsInOffice() {
        assertTrue(getDriver().findElement(office_tab_id).isDisplayed());
        assertTrue(getDriver().findElement(office_department_tab_id).isDisplayed());
    }

    public void clickOnOfficeCreditRatingsLink() {
        attemptClick(office_credit_ratings_link_id);
    }

     public void verifyOfficeServices(ExamplesTable services) {
       verifyOfficeOfferedServicesLabels();
       verifyServices(services, "Services");
    }

    public void verifyServices(ExamplesTable services, String serviceType){
        List<WebElement> category = getDriver().findElements(By.xpath(".//li[h1='" + serviceType + "']//tr/td[1]"));
        List<WebElement> override_details = getDriver().findElements(By.xpath(".//li[h1='" + serviceType + "']//tr/td[2]"));

        for(int i=0;i<services.getRowCount();i++){
            assertEquals(services.getRow(i).get(services.getHeaders().get(0)),category.get(i).getText());
            assertEquals(services.getRow(i).get(services.getHeaders().get(1)),override_details.get(i).getText());
        }
    }

     public void verifyOfficeOfferedServicesLabels() {
        assertEquals("SERVICES", getDriver().findElement(office_services_label_xpath).getText());
        assertEquals("SERVICE CATEGORY", getDriver().findElement(office_service_category_label_xpath).getText());
        assertEquals("SERVICE OVERRIDE", getDriver().findElement(office_service_override_label_xpath).getText());
    }

    public void clickOnOfficeBasicInfoLink() {
        attemptClick(office_basic_info_link_id);
    }

    public void clickOnOfficeHistoryLink() {
        attemptClick(office_history_link_id);
    }

    public void clickOnOfficeIdentifiersLink() {
        attemptClick(office_identifiers_link_id);
    }

    public void verifyNoOfficePersonnelSection() {
        try {
            assertFalse(getDriver().findElement(By.xpath("//*[@id='content']//li[h1='Personnel']")).isDisplayed());
        }catch (NoSuchElementException e){

        }
    }

    public void clickOnOfficeLocationsLink() {
        attemptClick(office_locations_link_id);
    }

    public void verifyOfficeLocations(Database database, ApacheHttpClient apacheHttpClient, String selectedOffice) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "office locations", "fid", selectedOffice);
        for(int i=0; i<getDriver().findElements(office_locations_address_xpath).size(); i++){
            assertEquals("LOCATIONS", getDriver().findElement(office_locations_title_xpath).getText());
            verifyOfficeLocationsAddresses(document, i);
            verifyOfficeLocationsTelecoms(document, i);
        }
            verifyOfficeLocationsPrimaryType(document);
            verifyOfficeLocationsAddressType(document);
            verifyOfficeLocationsSummaries(document);

    }

    public void verifyOfficeLocationsPrimaryType(Document document){
        for(int i=0; i<getDriver().findElements(office_location_primary_xpath).size(); i++) {
            assertEquals(("Primary " + document.getElementsByTagName("primary").item(i).getTextContent()).trim(), getDriver().findElements(office_location_primary_xpath).get(i).getText());
        }
    }

    public void verifyOfficeLocationsAddressType(Document document){
        for(int i=0; i<getDriver().findElements(office_location_primary_xpath).size(); i++) {
            assertEquals(("Type " + document.getElementsByTagName("type").item(i).getTextContent()).trim(), getDriver().findElements(office_location_address_type_xpath).get(i).getText());
        }
    }

    public void verifyOfficeLocationsAddresses(Document document, int i){
        assertEquals("ADDRESSES", getDriver().findElements(office_locations_addresses_title_xpath).get(i).getText());
        assertEquals(("Address Line 1 " + document.getElementsByTagName("addressLine1").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_address_line_1_xpath).get(i).getText());
        assertEquals(("Address Line 2 " + document.getElementsByTagName("addressLine2").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_address_line_2_xpath).get(i).getText());
        assertEquals(("Address Line 3 " + document.getElementsByTagName("addressLine3").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_address_line_3_xpath).get(i).getText());
        assertEquals(("Address Line 4 " + document.getElementsByTagName("addressLine4").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_address_line_4_xpath).get(i).getText());
        assertEquals(("City " + document.getElementsByTagName("city").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_city_xpath).get(i).getText());
        assertEquals(("Subarea " + document.getElementsByTagName("subarea").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_subarea_xpath).get(i).getText());
        assertEquals(("Area " + document.getElementsByTagName("area").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_area_xpath).get(i).getText());
        assertEquals(("Country " + document.getElementsByTagName("country").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_country_xpath).get(i).getText());
        assertEquals(("Postal Code " + document.getElementsByTagName("postalCode").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_postal_code_xpath).get(i).getText());
        assertEquals(("Postal Code Position " + document.getElementsByTagName("postalCodePos").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_postal_code_pos_xpath).get(i).getText());
        assertEquals(("Postal Code Suffix " + document.getElementsByTagName("postalSuffix").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_postal_code_suffix_xpath).get(i).getText());
        assertEquals(("Info " + document.getElementsByTagName("info").item(i).getTextContent()).trim(), getDriver().findElements(office_locations_info_xpath).get(i).getText());
    }

    public void verifyOfficeLocationsTelecoms(Document document, int i){
        assertEquals("TELECOMS", getDriver().findElements(office_locations_telecoms_title_xpath).get(i).getText());
        assertEquals("TYPE RANK TEXT BEFORE VALUE RANGE LIMIT EXT TEXT AFTER ANSWERBACK", getDriver().findElements(office_locations_telecoms_table_columns_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tType").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_type_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tRank").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_rank_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tTextBefore").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_text_before_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tValue").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_value_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tRangeLimit").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_range_limit_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tExt").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_ext_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tTextAfter").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_text_after_xpath).get(i).getText());
        assertEquals(document.getElementsByTagName("tAnswerback").item(i).getTextContent(),getDriver().findElements(office_locations_telecoms_answerback_xpath).get(i).getText());
    }

    public void verifyOfficeLocationsSummaries(Document document){
        assertEquals("SUMMARY",getDriver().findElement(office_locations_summary_title_xpath).getText());
        assertEquals("TYPE VALUE",getDriver().findElement(office_locations_summary_column_xpath).getText());
        for(int i=0; i<getDriver().findElements(office_locations_summaries_xpath).size(); i++){
            assertEquals(document.getElementsByTagName("summaryType").item(i).getTextContent(),getDriver().findElements(office_locations_summary_type_xpath).get(i).getText());
            assertEquals(document.getElementsByTagName("summaryValue").item(i).getTextContent(),getDriver().findElements(office_locations_summary_value_xpath).get(i).getText());
        }
    }

    public void verifyOfficeAddressPostalCode(String postalCode) {
        assertEquals("Postal Code " + postalCode, getDriver().findElement(office_locations_postal_code_1_xpath ).getText());
    }

    public void clickOnAddressLabel(){
        try{
        Thread.sleep(1000);
        getDriver().findElement(office_address_label_xpath).click();
    }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

}
