package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends AbstractPage {

    private By legal_title_xpath = By.xpath("//dd[@class='legalTitle']");
    private By entity_xpath = By.xpath("//*[@id='content']/div/section/article[1]/dl");
    private By country_of_operations_xpath = By.xpath("//dd[@class='entity-country-of-operations']");
    private By status_xpath = By.xpath("//dd[@class='entity-status']");

    private By office_type_xpath = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[1]");
    private By office_name_xpath = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[2]");
    private By address_type_xpath = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dt[3]");
    private By address_info_xpath = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[3]");
    private By fax_xpath = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[5]");
    private By email_xpath = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[6]");
    private By telex_xpath = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[7]");
    private By telephone_xpath = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[8]");

    public DetailsPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalName(String legalName) {
        Assert.assertTrue(getTextOnPage(legal_title_xpath).equals(legalName));
    }

    public void verifyFormerNames(String formerNames) {
        Assert.assertTrue(getTextOnPage(entity_xpath).contains(formerNames));
    }

    public void verifyCountryOfOperations(String country) {
        Assert.assertTrue(getTextOnPage(country_of_operations_xpath).contains(country));
    }

    public void verifyStatus(String status) {
        Assert.assertTrue(getTextOnPage(status_xpath).contains(status));
    }

    public void verifyOfficeType() {
        Assert.assertTrue(getTextOnPage(office_type_xpath).equals("Head Office"));
    }

    public void verifyOfficeName(String officeName) {
        Assert.assertTrue(getTextOnPage(office_name_xpath).equals(officeName));
    }

    public void verifyAddress(String addressType, String addressInfo) {
        Assert.assertTrue(getTextOnPage(address_type_xpath).equals(addressType));
        Assert.assertTrue(getTextOnPage(address_info_xpath).equals(addressInfo));
    }

    public void verifyFax(String fax) {
        Assert.assertTrue(getTextOnPage(fax_xpath).equals(fax));
    }

    public void verifyEmail(String email) {
        Assert.assertTrue(getTextOnPage(email_xpath).equals(email));
    }

    public void verifyTelex(String telex) {
        Assert.assertTrue(getTextOnPage(telex_xpath).equals(telex));
    }

    public void verifyTelephone(String telephone) {
        Assert.assertTrue(getTextOnPage(telephone_xpath).equals(telephone));
    }
}
