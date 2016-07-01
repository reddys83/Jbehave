package com.accuity.zeus.aft.jbehave.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.AreaIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

public class EditAreaPage extends AbstractPage {

	public EditAreaPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	
	/**
	 * This method is used to click the area status drop-down
	 */
	public void clickOnAreaStatusDropDown() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_options_xpath"));
	}

	/**
	 * This method is used to verify the look up data values available for area
	 * status drop-down
	 */
	public void verifyAreaStatusList() {
		List<WebElement> statusList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_options_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get area Status types");
		for (int i = 1; i < document.getElementsByTagName("status").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					statusList.get(i).getAttribute("value"));
		}

	}
	
	public void clickOnUpdate() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attemptClick(AreaIdentifiers.getObjectIdentifier("area_update_button_xpath"));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void selectAreaStatusValue(String status) {
		selectItemFromDropdownListByText(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_xpath"),
				status);
	}
	
	public DataPage clickOnSaveButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("save_button_xpath"));
		return new DataPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
	}
	
	/**
	 * This method is to verify whether the successful message is generated
	 * after saving the city page.
	 */
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_save_confirmation_message_xpath"))
				.isDisplayed());
	}
	
	public void verifyStatusInAreaPage(String status) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(status, getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_get_status_value_xpath")).getText());
	}
	
	/**
	 * This method is used to get the city information from DB
	 *
	 * @param country
	 * @param area
	 * 	 * @param tagName
	 * @param source
	 * @return value of the tag name passed to it
	 */

	public String getAreaInfoFromDB(String country, String area, String tagName, String source) {

		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get areastatus", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}
	
	public void verifyAreaStatusFromZeusDB(String country,String area,String tagName, String source,
			String status) {
		assertEquals(getAreaInfoFromDB(country, area, tagName, source), status.toLowerCase());
	}
	
	/**
	 * This method is used to enter the value in Area status drop-down
	 *
	 * @param will
	 *            hold the value to be entered in the drop-down
	 */
	public void enterValueInStatusDropdown(String word) {
		getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_xpath"))
				.sendKeys(word);
	}
	
	/**
	 * This method is used to verify the passing status is selected in the Area
	 * status drop-down
	 * 
	 * @param status
	 *            will hold the value to be verified with city status drop-down
	 *            selection
	 */
	public void verifyAreaStatusInDropdown(String status) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(
				getSelectedDropdownValue(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_xpath"))
						.equalsIgnoreCase(status));
	}
	
	
	public void verifyNoSummaryConfirmationModal(String summaryText) {
		try {
			WebElement confirmChanges = getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("confirmation_modal_xpath"));
			String confirmationText = confirmChanges.getText();
			assertTrue(!(confirmationText.contains("Summary")) && !(confirmationText.contains(summaryText)));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void verifyAreaFromTrustedDB(String country, String area, String tagName,
			String source) {
		
		String getStatusFromUI =getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_options_xpath")).getText().toLowerCase();
		assertEquals(getAreaInfoFromDB(country, area, tagName, source), getStatusFromUI);

	}
	
	@Override
	public String getPageUrl() {
		return null;
	}
}