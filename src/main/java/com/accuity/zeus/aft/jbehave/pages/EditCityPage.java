package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shahc1 on 5/19/2016.
 */
public class EditCityPage extends AbstractPage  {

    public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

	public void verifyTextInAddInfo(String addInfoText) {
		// TODO Auto-generated method stub
		 assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).getText(), addInfoText);
	}

	public void enterCityAddInfo(String addInfoText) {
		// TODO Auto-generated method stub
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"),addInfoText);
	}
	
	public void enterDifferentCityAddInfo(String addDifferentInfoText) {
		// TODO Auto-generated method stub
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"),addDifferentInfoText);
	}
	
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id")).isDisplayed());
	}
	
	public void clearAndEnterValue(By webElement, String value) {
        getDriver().findElement(webElement).clear();
        getDriver().findElement(webElement).sendKeys(value);

    }

	public void enterInvalidCharactersInCityAddInfo() {
		// TODO Auto-generated method stub
		char c = 'a';
        String invalidData = "";
        for (int i = 0; i <= 500; i++) {
            invalidData += c;
        }
        getDriver().findElement(By.xpath("")).clear();
        getDriver().findElement(By.xpath("")).sendKeys(invalidData);
	}

	public void verifyErrorMessageInCityAddInfo() {
		// TODO Auto-generated method stub
		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_addInfo_error_message_edit_xpath")).getText(), "Enter up to 500 valid characters.");
	}
}
