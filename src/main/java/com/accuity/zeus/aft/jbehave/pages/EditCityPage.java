package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	/**
	 * This method is used to click the city status drop-down
	 */
	public void clickOnCityStatusDropDown() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_options_xpath"));
	}

	/**
	 * This method is used to verify the look up data values available for city
	 * status drop-down
	 */
   public void verifyCityStatusList() {
		List<WebElement> statusList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_options_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get city Status types");
		for (int i = 1; i < document.getElementsByTagName("status").getLength(); i++) {
			assertEquals(
					document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					statusList.get(i).getAttribute("value"));
		}

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

	public void verifyCityInfoFromTrustedDB(String country, String area, String city, String tagName, String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source),
				getSelectedDropdownValue(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath")));

	}

	public void verifyCityInfoFromZeusDB(String country, String area, String city, String tagName, String source,
			String status) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), status);

	}

	/**
	 * This method is used to verify the passing status is selected in the city
	 * status drop-down
	 * 
	 * @param status
	 *            will hold the value to be verified with city status drop-down
	 *            selection
	 */
	public void verifyStatusInDropdown(String status) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(
				getSelectedDropdownValue(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath"))
						.equalsIgnoreCase(status));

	}

	/**
	 * This method is used to enter the value in city status drop-down
	 * 
	 * @param will
	 *            hold the value to be entered in the drop-down
	 */
	public void enterValueInStatusDropdown(String word) {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath"))
				.sendKeys(word);
	}

	/**
	 * This method is used to check there are no Confirmation Summary (no changes) in the confirmation modal
	 * 
	 * @param will
	 *            check if the required confirmation changes message is not present in confirmation modal
	 */
	  public void verifyNoChangeConfirmationMsg(String summaryText) {
		  
		  try {
				WebElement confirmChanges = getDriver()
						.findElement(CityIdentifiers.getObjectIdentifier("confirmation_modal_xpath"));
				String confirmationText = confirmChanges.getText();
				assertTrue(!(confirmationText.contains("Summary")) && !(confirmationText.contains(summaryText)));
			} catch (Exception e) {
				assertTrue(true);
			}
	  }
	
	/**
	 * This method is used to check whether the driver stays on city edit page.
	 */
	public void verifyCityEditPageMode() {
		assertTrue(getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath")).size() > 0);
	}

	public void selectCityStatusValue(String status) {
		selectItemFromDropdownListByValue(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath"),
				status);
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