package com.accuity.zeus.aft.jbehave.pages;

import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LegalEntityPage extends AbstractPage {
    private By legalEntity_entityType_label_xpath = By.xpath(".//*[@id='content']//h2[2]");
    private By legalEntity_entityType_type_label_xpath=By.xpath(".//*[@id='content']//table[2]//th");
    private By legalEntity_entityType_list_xpath = By.xpath(".//*[@id='content']//table[2]//td");
    private By legalEntity_telecoms_type_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Type']");
    private By legalEntity_telecoms_rank_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Rank']");
    private By legalEntity_telecoms_info_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Info']");
    private By legalEntity_telecoms_value_label_xpath = By.xpath(".//*[@id='content']//table[3]/thead//th[text()='Value']");
    private By legalEntity_telecoms_type_xpath= By.xpath(".//*[@id='content']//table[3]/tbody//td[1]");
    private By legalEntity_telecoms_rank_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[2]");
    private By legalEntity_telecoms_info_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[3]");
    private By legalEntity_telecoms_value_xpath = By.xpath(".//*[@id='content']//table[3]/tbody//td[4]");
    private By legalEntity_basic_info_corporate_statement_label_xpath = By.xpath(".//*[@id='content']//dt");
    private By legalEntity_basic_info_corporate_statement_xpath = By.xpath(".//*[@id='content']//dd");
    private By legalEntity_searchResults_institution_xpath = By.xpath(".//*[@id='legalEntityContentSummary']/header//h1");
    private By legalEntity_searchResults_headOffice_address_xpath=By.xpath(".//*[@id='legalEntityContentSummary']/header//p");
    private By legalEntity_searchResults_header_fid_xpath= By.xpath(".//*[@id='legalEntityContentSummary']/header/table//tr[th='FID']/td");
    private By legalEntity_searchResults_header_tfpid_xpath = By.xpath(".//*[@id='legalEntityContentSummary']/header/table//tr[th='TFPID']/td");
    private By legalEntity_services_link_id = By.id("legalEntityServices");
    private By legalEntity_offered_services_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[1]/h2");
    private By legalEntity_offered_services_category_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[1]//tr/th[1]");
    private By legalEntity_offered_services_override_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[1]//tr/th[2]");
    private By legalEntity_financial_services_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[2]/h2");
    private By legalEntity_financial_services_category_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[2]//tr/th[1]");
    private By legalEntity_financial_services_details_label_xpath = By.xpath("//*[@id='content']//li[3]/ul/li[2]//tr/th[2]");
    private By legalEntity_services_label_xpath = By.xpath("//*[@id='content']/div/ul/li[3]/h1/span");
    private By legalEntity_search_msg_xpath = By.xpath("//*[@id='editHeader']/div/p");
    private By legalEntity_statistics_link_id = By.id("legalEntityStatistics");
    private By legalEntity_statistics_label_xpath = By.xpath(".//*[@id='content']//li/h1/span[text()='Statistics']");
    private By legalEntity_statistics_type_label_xpath = By.xpath(".//*[@id='content']//li[h1='Statistics']//li//th[1]");
    private By legalEntity_statistics_value_label_xpath = By.xpath(".//*[@id='content']//li[h1='Statistics']//li//th[2]");
    private By legalEntity_statistics_type_list_xpath = By.xpath(".//*[@id='content']//li[3]//table/tbody/tr/td[1]");
    private By legalEntity_statistics_value_list_xpath = By.xpath(".//*[@id='content']//li[3]//table/tbody/tr/td[2]");
    private By legalEntity_trustPowers_link_id = By.id("legalEntityTrustPowers");
    private By legalEntity_trustPowers_label_xpath = By.xpath(".//*[@id='content']//h1/span[text()='Trust Powers']");
    private By legalEntity_trustPower_granted_label_xpath = By.xpath(".//*[@id='content']//th[text()='Granted']");
    private By legalEntity_trustPower_full_label_xpath = By.xpath(".//*[@id='content']//th[text()='Full']");
    private By legalEntity_trustPower_used_label_xpath = By.xpath(".//*[@id='content']//th[text()='Used']");
    private By legalEntity_trustPower_profEmployees_label_xpath = By.xpath(".//*[@id='content']//th[text()='Prof. Employees']");
    private By legalEntity_trustPower_adminEmployees_label_xpath = By.xpath(".//*[@id='content']//th[text()='Admin Employees']");
    private By legalEntity_trustPower_minAccountSize_label_xpath = By.xpath(".//*[@id='content']//th[text()='Min Account Size($)']");
    private By legalEntity_trustPower_values_list_xpath= By.xpath(".//*[@id='content']//li[h1='Trust Powers']//tbody/tr");

    public LegalEntityPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalEntityEntities(ExamplesTable legalEntities)
    {
        assertEquals("ENTITY TYPES", getDriver().findElement(legalEntity_entityType_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(legalEntity_entityType_type_label_xpath).getText());
        List<WebElement> legalEntityEntityList = getDriver().findElements(legalEntity_entityType_list_xpath);
        assertTrue(legalEntities.getRowCount() == legalEntityEntityList.size());
        for (int i=0;i<legalEntities.getRowCount();i++)
        {
            assertEquals(legalEntities.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(), legalEntityEntityList.get(i).getText().replace(",", "").trim());
        }
    }

    public void verifyLegalEntitiesTelecoms(ExamplesTable legalEntitiesTelecoms)
    {
        assertEquals("TYPE", getDriver().findElement(legalEntity_telecoms_type_label_xpath).getText());
        assertEquals("RANK",getDriver().findElement(legalEntity_telecoms_rank_label_xpath).getText());
        assertEquals("INFO",getDriver().findElement(legalEntity_telecoms_info_label_xpath).getText());
        assertEquals("VALUE",getDriver().findElement(legalEntity_telecoms_value_label_xpath).getText());
        List<WebElement> type = getDriver().findElements(legalEntity_telecoms_type_xpath);
        List<WebElement> rank = getDriver().findElements(legalEntity_telecoms_rank_xpath);
        List<WebElement> info = getDriver().findElements(legalEntity_telecoms_info_xpath);
        List<WebElement> value = getDriver().findElements(legalEntity_telecoms_value_xpath);

        for(int i=0;i<legalEntitiesTelecoms.getRowCount();i++){
            assertEquals(legalEntitiesTelecoms.getRow(i).get(legalEntitiesTelecoms.getHeaders().get(0)),type.get(i).getText());
            assertEquals(legalEntitiesTelecoms.getRow(i).get(legalEntitiesTelecoms.getHeaders().get(1)),rank.get(i).getText());
            assertEquals(legalEntitiesTelecoms.getRow(i).get(legalEntitiesTelecoms.getHeaders().get(2)), info.get(i).getText());
            assertEquals(legalEntitiesTelecoms.getRow(i).get(legalEntitiesTelecoms.getHeaders().get(3)),value.get(i).getText());
        }
    }

    public void verifyCorporateStatement(String corporateStatement) {
        assertEquals("Corporate Statement", getDriver().findElement(legalEntity_basic_info_corporate_statement_label_xpath).getText());
        assertEquals(corporateStatement, getDriver().findElement(legalEntity_basic_info_corporate_statement_xpath).getText());
    }

    public void verifyLegalEntityHeader(String entity, String headOfficeAddress, String fid, String tfpid) {
        assertEquals(entity, getDriver().findElement(legalEntity_searchResults_institution_xpath).getText());
        assertEquals(headOfficeAddress, getDriver().findElement(legalEntity_searchResults_headOffice_address_xpath).getText());
        assertEquals(fid,getDriver().findElement(legalEntity_searchResults_header_fid_xpath).getText());
        assertEquals(tfpid,getDriver().findElement(legalEntity_searchResults_header_tfpid_xpath).getText());
    }

    public void clickOnLegalEntityServices() {
        attemptClick(legalEntity_services_link_id);
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

    public void verifyLegalEntityOfferedServicesLabels(){
        verifyServicesLabel();
        assertEquals("OFFERED SERVICES", getTextOnPage(legalEntity_offered_services_label_xpath));
        assertEquals("CATEGORY", getTextOnPage(legalEntity_offered_services_category_label_xpath));
        assertEquals("OVERRIDE", getTextOnPage(legalEntity_offered_services_override_label_xpath));
    }


    public void verifyLegalEntityFinancialServices(ExamplesTable financialServices) {
        verifyLegalEntityFinancialServicesLabels();
        verifyServices(financialServices, "Financial Services");
    }

    public void verifyLegalEntityFinancialServicesLabels(){
        verifyServicesLabel();
        assertEquals("FINANCIAL SERVICES", getTextOnPage(legalEntity_financial_services_label_xpath));
        assertEquals("FINANCIAL CATEGORY", getTextOnPage(legalEntity_financial_services_category_label_xpath));
        assertEquals("FINANCIAL DETAILS", getTextOnPage(legalEntity_financial_services_details_label_xpath));
    }

    public void verifyServices(ExamplesTable services, String serviceType){
        List<WebElement> category = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[1]"));
        List<WebElement> override_details = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[2]"));

        for(int i=0;i<services.getRowCount();i++){
            assertEquals(services.getRow(i).get(services.getHeaders().get(0)),category.get(i).getText());
            assertEquals(services.getRow(i).get(services.getHeaders().get(1)),override_details.get(i).getText());
        }
    }

    public void verifyLegalEntityStatistics(ExamplesTable legalEntityStatistics){
        assertEquals("STATISTICS", getTextOnPage(legalEntity_statistics_label_xpath));
        assertEquals("TYPE",getTextOnPage(legalEntity_statistics_type_label_xpath));
        assertEquals("VALUE",getTextOnPage(legalEntity_statistics_value_label_xpath));
        List<WebElement> type = getDriver().findElements(legalEntity_statistics_type_list_xpath);
        List<WebElement> value = getDriver().findElements(legalEntity_statistics_value_list_xpath);

        for(int i=0;i<legalEntityStatistics.getRowCount();i++){
            assertEquals(legalEntityStatistics.getRow(i).get(legalEntityStatistics.getHeaders().get(0)),type.get(i).getText());
            assertEquals(legalEntityStatistics.getRow(i).get(legalEntityStatistics.getHeaders().get(1)),value.get(i).getText());
        }
    }

    public void verifyLegalEntityTrustPowersLabels()
    {
        assertEquals("TRUST POWERS", getTextOnPage(legalEntity_trustPowers_label_xpath));
        assertEquals("GRANTED", getTextOnPage(legalEntity_trustPower_granted_label_xpath));
        assertEquals("FULL", getTextOnPage(legalEntity_trustPower_full_label_xpath));
        assertEquals("USED", getTextOnPage(legalEntity_trustPower_used_label_xpath));
        assertEquals("PROF. EMPLOYEES", getTextOnPage(legalEntity_trustPower_profEmployees_label_xpath));
        assertEquals("ADMIN EMPLOYEES",getTextOnPage(legalEntity_trustPower_adminEmployees_label_xpath));
        assertEquals("MIN ACCOUNT SIZE($)", getTextOnPage(legalEntity_trustPower_minAccountSize_label_xpath));
    }

    public void verifyLegalEntityTrustPowers(ExamplesTable legalEntityTrustPowers)
    {
        verifyLegalEntityTrustPowersLabels();
        assertEquals(legalEntityTrustPowers.getRow(0).values().toString().replace("[", "").replace("]", "").replace(",", "").trim(), getTextOnPage(legalEntity_trustPower_values_list_xpath).replace(",", "").trim());

    }

    public void verifyNoLegalEntityTrustPowers() {
        verifyLegalEntityTrustPowersLabels();
        try {
            assertFalse(getDriver().findElement(legalEntity_trustPower_values_list_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyServicesLabel(){
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
}
