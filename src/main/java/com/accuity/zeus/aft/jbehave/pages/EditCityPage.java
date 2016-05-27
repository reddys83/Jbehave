package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;


public class EditCityPage extends AbstractPage {

	
	private By city_add_info_text_xpath = By.xpath("//*[@id='cityBasicInfo']/ul/li[2]/table/tbody/tr[10]/td/textarea");
	
	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	public void verifyTextInAddInfo(String addInfoText) {
		// TODO Auto-generated method stub
		 assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).getText(), addInfoText);
	}

	public void enterTextCityAddInfo(String addInfoText) {
		// TODO Auto-generated method stub
		/*System.out.println("Inside enterCityAddInfo");
		System.out.println("Inside enterCityAddInfo"+addInfoText);*/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"),addInfoText);
		//getDriver().findElement(city_add_info_text_xpath).clear();
        //getDriver().findElement(city_add_info_text_xpath).sendKeys(addInfoText);
	}
	
	public void enterDifferentCityAddInfo(String addDifferentInfoText) {
		// TODO Auto-generated method stub
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"),addDifferentInfoText);
	}
	
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id")).isDisplayed());
	}
	
	public void clearAndEnterValue(By webElement, String value) {
		System.out.println("Inside clearAndEnterValue" + value);
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

	@Override
	public String getPageUrl() {
		return null;
	}
}