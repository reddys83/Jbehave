package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;

public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	/**
	 * This method is to verify the value displayed in the population field
	 */
	public void verifyTextInPopulation() {
		assertTrue(
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id")).isDisplayed());
	}

	/**
	 * THis method is to enter the value in population text field
	 * @param value
	 */
	public void entervalueInPopulationField(String value) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_population_input_id"), value);
	}

	/**
	 * This method is to verify whether the successful message is generated after saving the city page.
	 */
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id"))
				.isDisplayed());
	}

	public void clearAndEnterValue(By webElement, String value) {
		getDriver().findElement(webElement).clear();
		getDriver().findElement(webElement).sendKeys(value);

	}


	/**
	 * This method is to enter the random number of range (50) in population field
	 */
	public void enterCharactersInCityPopulation(int limit) {
		String value = getRandomNumericString(limit);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id")).clear();
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id"))
				.sendKeys(value);		
	}
	
	/**
	 * This method is to enter the random number of range (51) in population field
	 */
	public void enterCharactersBeyondThelimitInCityPopulation(int limit) {
		String value = getRandomNumericString(limit+1);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id")).clear();
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id"))
				.sendKeys(value);		
	}
	

	/**
	 * This is to verify error message is displayed for population field as expected
	 */
	public void verifyErrorMessageInCityPopulation() {
		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_error_message_id"))
				.getText(), "Enter up to 50 valid characters.");
	}

	/**
	 * This method is used to verify the value in trusted DB is same as UI value.
	 * @param country
	 * @param area
	 * @param city
	 * @param tagName
	 * @param source
	 */
	public void verifyCityPopulationValueFromTrusted(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source),
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id")).getText());
	}

	/**
	 * This method is used to get the city information from DB
	 * 
	 * @param country
	 * @param area
	 * @param city
	 * @param tagName
	 * @param source
	 * @return value of the tagname passed to it
	 */
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

	/**This method is to verify the specified value 'valueToBeVerified' is present in specified 'source' DB
	 * @param country
	 * @param area
	 * @param city
	 * @param tagName
	 * @param source
	 * @param valueTobeverifed
	 */
	public void verifyCityInfoFromDB(String country, String area, String city, String tagName, String source,
			String valueTobeverifed) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), valueTobeverifed);
	}
    
	/**This method is to verify the specified value is displayed in the population field
	 * @param value
	 */
	public void verifyPopulationValueCityPage(String value) {
			assertEquals(getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_population_xpath")).getText(),value);
	}
	
	
	public DataPage clickOnSaveButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("save_button_id"));
		return new DataPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
	}

	@Override
	public String getPageUrl() {
		return null;
	}
}