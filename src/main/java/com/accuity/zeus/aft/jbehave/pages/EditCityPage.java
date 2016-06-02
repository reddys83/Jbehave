package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;

public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	String prevText = "";
	String text = "";
	Integer len = null;

	public void verifyTextInAddInfo() {
		assertTrue(
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).isDisplayed());
	}

	public void enterTextCityAddInfo(String addInfoText) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"), addInfoText);
	}

	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id"))
				.isDisplayed());
	}

	public void clearAndEnterValue(By webElement, String value) {
		getDriver().findElement(webElement).clear();
		getDriver().findElement(webElement).sendKeys(value);

	}

	public void enterInvalidCharactersInCityAddInfo() {
		char c = 'a';
		String invalidData = "";
		for (int i = 0; i <= 500; i++) {
			invalidData += c;
		}
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).clear();
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).sendKeys(invalidData);
	}

	public void verifyErrorMessageInCityAddInfo() {
		assertEquals(getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_addInfo_error_message_edit_xpath")).getText(),
				"Enter up to 500 valid characters.");
	}

	public void verifyCityAddInfoValueFromTrusted(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityAddInfoValueFromDB(country, area, city, tagName, source),
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).getText());

	}

	public String getCityAddInfoValueFromDB(String country, String area, String city, String tagName, String source) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("city", city));
		nvPairs.add(new BasicNameValuePair("source", source));
		String statusValue = "";
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get city basic info", nvPairs);
		if (document != null) {
			statusValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return statusValue;
	}

	public String getCityInfoFromDB(String country, String area, String city, String tagName, String source) {

		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("city", city));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get city basic info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	public void verifyCityInfoFromDB(String country, String area, String city, String tagName, String source,
			String valueTobeverifed) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), valueTobeverifed);
	}

	public DataPage clickOnSaveButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("save_button_id"));
		return new DataPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
	}

	public void verifySameTextInTextArea(String addInfoText) {
		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_added_text_xpath"))
				.getText(), addInfoText);
	}

	public void getTextInTextArea() {
		prevText = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).getText();
	}

	public void newValueCheck(String addInfoText) {
		assertNotEquals(prevText, addInfoText);
	}

	public void verifyNoSummaryInConfirmationModal() {
		try {
			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("no_summary_confirmation_modal_xpath"))
							.isDisplayed());
		} catch (NoSuchElementException e) {

		}
	}

	public void clearAddInfoTextArea() {
		clearValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"));
	}

	public void clearValue(By webElement) {
		getDriver().findElement(webElement).clear();
	}

	public void viewValidCharacterLength() {
		text = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_added_text_xpath")).getText();
		len = text.length();
		assertEquals(len.toString(), "500");
	}

	@Override
	public String getPageUrl() {
		return null;
	}
}