package com.accuity.zeus.aft.jbehave.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 5/4/2015.
 */

public class DetailsPage extends AbstractPage {

    private By legalTitle = By.xpath("//dd[@class='legalTitle']");

    public DetailsPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalName(String name) {
        Assert.assertTrue(getTextOnPage(legalTitle).equals(name));
    }
}
