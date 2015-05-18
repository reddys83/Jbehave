package com.accuity.zeus.aft.jbehave.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends AbstractPage {

    private By legalTitleLocator = By.xpath("//dd[@class='legalTitle']");
    private By entityLocator = By.xpath("//*[@id='content']/div/section/article[1]/dl");
    private By countryOfOperationsLocator = By.xpath("//dd[@class='entity-country-of-operations']");
    private By statusLocator = By.xpath("//dd[@class='entity-status']");

    private By officeTypeLocator = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[1]");
    private By officeNameLocator = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[2]");
    private By addressTypeLocator = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dt[3]");
    private By addressInfoLocator = By.xpath("//*[@id='content']/div/section/article[2]/dl/dd[3]");
    private By faxLocator = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[5]");
    private By emailLocator = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[6]");
    private By telexLocator = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[7]");
    private By telephoneLocator = By.xpath(".//*[@id='content']/div/section/article[2]/dl/dd[8]");


    public DetailsPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalName(String legalName) {
        Assert.assertTrue(getTextOnPage(legalTitleLocator).equals(legalName));
    }

    public void verifyFormerNames(String formerNames) {
        Assert.assertTrue(getTextOnPage(entityLocator).contains(formerNames));
    }

    public void verifyCountryOfOperations(String country) {
        Assert.assertTrue(getTextOnPage(countryOfOperationsLocator).contains(country));
    }

    public void verifyStatus(String status) {
        Assert.assertTrue(getTextOnPage(statusLocator).contains(status));
    }

    public void verifyOfficeType() {
        Assert.assertTrue(getTextOnPage(officeTypeLocator).equals("Head Office"));
    }

    public void verifyOfficeName(String officeName) {
        Assert.assertTrue(getTextOnPage(officeNameLocator).equals(officeName));
    }

    public void verifyAddress(String addressType, String addressInfo) {
        Assert.assertTrue(getTextOnPage(addressTypeLocator).equals(addressType));
        Assert.assertTrue(getTextOnPage(addressInfoLocator).equals(addressInfo));
    }

    public void verifyFax(String fax) {
        Assert.assertTrue(getTextOnPage(faxLocator).equals(fax));
    }

    public void verifyEmail(String email) {
        Assert.assertTrue(getTextOnPage(emailLocator).equals(email));
    }

    public void verifyTelex(String telex) {
        Assert.assertTrue(getTextOnPage(telexLocator).equals(telex));
    }

    public void verifyTelephone(String telephone) {
        Assert.assertTrue(getTextOnPage(telephoneLocator).equals(telephone));
    }
}
