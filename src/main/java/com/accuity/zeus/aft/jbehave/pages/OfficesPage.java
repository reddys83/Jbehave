package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficesPage extends AbstractPage {

    private String office_results_card_xpath = "//*[@id='data']//tr[td='1038']";
    private By office_personnel_link_id = By.id("officePersonnel");
    private By office_history_link_id = By.id("officeHistory");

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

    public void clickOnOfficeHistoryLink() {
        attemptClick(office_history_link_id);
    }
}
