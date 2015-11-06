package com.accuity.zeus.aft.jbehave.pages;

import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OfficesPage extends AbstractPage {

    private String office_results_card_xpath = "//*[@id='data']//tr[td='1038']";
    private By office_personnel_link_id = By.id("officePersonnel");
    private By office_basic_info_link_id = By.id("officeBasicInfo");
    private By office_history_link_id = By.id("officeHistory");
    private By office_services_link_id = By.id("officeServices");
    private By office_services_label_xpath = By.xpath("//li[contains(h1,'Services')]/h1/span");
    private By office_offered_services_label_xpath = By.xpath("//li[h2 = 'Offered Services']//h2");
    private By office_service_category_label_xpath = By.xpath("//li[h2 = 'Offered Services']//table/thead//th[1]");
    private By office_service_override_label_xpath = By.xpath("//li[h2 = 'Offered Services']//table/thead//th[2]");
    private By office_statistics_link_id = By.xpath("officeStatistics");


    public OfficesPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void clickOnOfficeResultsCard(String officeFid) {
        attemptClick(By.xpath(office_results_card_xpath + officeFid + "']"));
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

    public void verifyNoServices() {
        verifyOfficeOfferedServicesLabels();
        try {
            assertFalse(getDriver().findElement(By.xpath("//li[h2='Offered Services']//table//tbody//td[1]")).isDisplayed());
        }catch (NoSuchElementException e){

        }
    }

    public void verifyOfficeServices(ExamplesTable services) {
       verifyOfficeOfferedServicesLabels();
       verifyServices(services, "Offered Services");
    }

    public void verifyServices(ExamplesTable services, String serviceType){
        List<WebElement> category = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[1]"));
        List<WebElement> override_details = getDriver().findElements(By.xpath(".//li[h2='" + serviceType + "']//tr/td[2]"));

        for(int i=0;i<services.getRowCount();i++){
            assertEquals(services.getRow(i).get(services.getHeaders().get(0)),category.get(i).getText());
            assertEquals(services.getRow(i).get(services.getHeaders().get(1)),override_details.get(i).getText());
        }
    }

     public void verifyOfficeOfferedServicesLabels() {
        assertEquals("SERVICES", getDriver().findElement(office_services_label_xpath).getText());
        assertEquals("OFFERED SERVICES", getDriver().findElement(office_offered_services_label_xpath).getText());
        assertEquals("SERVICE CATEGORY", getDriver().findElement(office_service_category_label_xpath).getText());
        assertEquals("SERVICE OVERRIDE", getDriver().findElement(office_service_override_label_xpath).getText());
    }

    public void clickOnOfficeBasicInfoLink() {
        attemptClick(office_basic_info_link_id);
    }

    public void clickOnOfficeHistoryLink() {
        attemptClick(office_history_link_id);
    }
}
