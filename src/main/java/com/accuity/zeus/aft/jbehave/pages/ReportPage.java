package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ReportPage extends AbstractPage {

    private static final String PAGE_URI = "/#report";

    private By report_new_row_id = By.id("new-report");
    private By area_css = By.cssSelector(".area");
    private By required_match_css = By.cssSelector(".required-match");
    private By run_button_css = By.cssSelector(".run-report");
    private By run_button_disabled = By.xpath("//*[@id='rows-list']/li/form/div/button[2][@disabled=\"\"]");
    private By count_css = By.cssSelector(".counter");
    private By report_type = By.xpath("//*[@id='rows-list']/li/div/p[1]");
    private By default_report_row = By.xpath("//*[@id='rows-list']/li/form/fieldset");
    private By area_label = By.xpath(".//*[@class='input-list']/li[1]/label");
    private By required_match_label = By.xpath(".//*[@class='input-list']/li[2]/label");

    private String area;
    private String requiredMatch;

    public ReportPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
       super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getUrlPrefix());
        sb.append(PAGE_URI);
        return sb.toString();
    }

    public void verifyReportPage() {
        assertTrue(getDriver().findElement(default_report_row).isDisplayed());
        assertTrue(getDriver().findElement(report_new_row_id).isDisplayed());
    }

    public void selectArea(String area) {
        this.area = area;
        assertEquals(getDriver().findElement(area_label).getText(),"AREA");
        assertTrue(getDriver().findElement(run_button_disabled).isDisplayed());
        selectItemFromDropdownListByValue(area_css, area);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectRequiredMatch(String requiredMatch) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.requiredMatch = requiredMatch;
        assertFalse(getDriver().findElement(run_button_disabled).isEnabled());
        assertEquals(getDriver().findElement(required_match_label).getText(), "REQUIRED MATCH");
        selectItemFromDropdownListByValue(required_match_css, requiredMatch);
    }

    public void clickOnRunButton() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(run_button_css).click();
    }

    public void verifyCount(String count) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDriver().findElement(report_type).getText(), "COUNT: " + area + " > " + requiredMatch + " >");
        assertEquals(getDriver().findElement(count_css).getText(), count);
    }

    public void verifyRunButtonIsDisabled() {
        assertFalse(getDriver().findElement(run_button_disabled).isEnabled());
    }
}
