package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

/**
 * Created by shahc1 on 5/19/2016.
 */
public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	/**This method is used for verifying the Identifier Type List
	 * 
	 * @param lookupFid
	 */
	public void verifyIdentifierTypeList(String lookupFid) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("fid", lookupFid));
		List<WebElement> statusList = getDriver().findElements(
				LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_list_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get legal entity Status types", nvPairs);
		for (int i = 0; i < document.getElementsByTagName("status").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					statusList.get(i + 1).getAttribute("value"));
		}
	}

	/**This method is used to click on the Identifier button for adding a new row
	 * 
	 */
	public void clickOnAddNewIdentifierButton() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attemptClick(CityIdentifiers.getObjectIdentifier("city_add_new_identifier_button_id"));
	}

	/**This method is used to enter the Identifier type
	 * 
	 * @param identifierType
	 */
	public void enterIdentifierType(String identifierType) {
		try {

			List<WebElement> webElements = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
			int columns_count = webElements.size();
			WebElement mySelectElm = webElements.get(columns_count - 1);
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByValue(identifierType);
		} catch (Exception e) {
		}
	}

	/**This method is used to enter the Identifier status
	 * 
	 * @param identifierStatus
	 */
	public void enterIdentifierStatus(String identifierStatus) {
		try {

			List<WebElement> webElements = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
			int columns_count = webElements.size();
			WebElement mySelectElm = webElements.get(columns_count - 1);
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByValue(identifierStatus);
		} catch (Exception e) {
		}
	}

	/**This method is used for performing the delete operation for a Identifier row by clicking on the delete row button 
	 * 
	 */
	public void clickOnDeleteNewIdentifierRowButtonCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));
	}

	/**This method is used to verify whether the delete confirmation table is present upon clicking the delete row button 
	 * 
	 */
	public void verifyDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
	}

	/**This method is used to verify whether data is present in the Identifiers as mentioned below 
	 * @param identifierType
	 * @param identifierValue
	 * @param identifierStatus
	 * @throws Exception
	 */
	public void verifyUpdateSuccessIdentifiers(String identifierType, String identifierValue, String identifierStatus)
			throws Exception {
		Thread.sleep(6000);
		assertEquals(identifierType, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_type_value")).getText());
		assertEquals(identifierValue,
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_value")).getText());
		assertEquals(identifierStatus, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_status_value")).getText());

	}

	/**This method verifies whether the confirmation model is not present upon clicking 'No' after clicking delete row button
	 * 
	 */
	public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {
		try {
			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_additional_identifiers_row_id"))
							.isDisplayed());
		} catch (NoSuchElementException e) {
		}
	}

	/**This method is used to clear the data present in the Identifier value text box
	 * 
	 */
	public void clearCityIdentifierValue() {
		try {
			List<WebElement> webElements = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
			int columns_count = webElements.size();
			WebElement mySelectElm = webElements.get(columns_count - 1);
			mySelectElm.clear();
		} catch (Exception e) {
		}
	}

	/**This method is used to click on the 'Confirm' button after saving
	 * @throws Exception
	 */
	public void clickOnConfirmButtonCity() throws Exception {
		Thread.sleep(3000);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_confirm_button")).click();
		Thread.sleep(3000);
	}

	/**This method is used to enter the Identifier value
	 * @param identifierValue
	 */
	public void enterIdentifierValue(String identifierValue) {
		try {
			List<WebElement> webElements = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
			int columns_count = webElements.size();
			WebElement mySelectElm = webElements.get(columns_count - 1);
			mySelectElm.sendKeys(identifierValue);
		} catch (Exception e) {

		}
	}

	/**This method is used to verify whether we get an error message after clicking save without entering any text for Identifier Value
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierValue() {
		assertEquals("Required", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_value_req_err_msg_xpath")).getText());
	}

	/**This method is used to verify whether we get an error message after clicking save without entering any text for Identifier Type
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierType() {
		assertEquals("Required", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_req_err_msg_xpath")).getText());
	}

	/**This method is used to verify whether we get an error message after clicking save without entering any text for Identifier Status
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierStatus() {
		assertEquals("Required",
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_status_req_err_msg_xpath"))
						.getText());
	}

	/**This method is used to verify whether we get an error message for entering a text beyond 50 characters for Identifier Value
	 * 
	 */
	public void verifyErrorMessageForLongCityIdentifierValue() {
		assertEquals("Enter up to 50 valid characters.",
				getDriver()
						.findElement(
								CityIdentifiers.getObjectIdentifier("city_identifier_value_max_length_err_msg_xpath"))
						.getText());
	}

	/**This method is used for pressing the Enter key in the delete confirmation modal
	 * 
	 */
	public void pressEnterButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id")).sendKeys(Keys.ENTER);
	}

	/**This method is used for clicking the 'No' button in the delete confirmation modal
	 * 
	 */
	public void clickNoButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_no_button_id_click")).click();
	}

	/**This method is used for clicking the 'Yes' button in the delete confirmation modal
	 * 
	 */
	public void clickYesButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id_click")).click();
	}

	/**This method is used to verify that delete confirmation modal is not displayed
	 * 
	 */
	public void verifyDeleteConfirmationModalIsNotDisplayed() {
		try {

			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath"))
							.isDisplayed());

		} catch (NoSuchElementException e) {

		}
	}

	@Override
	public String getPageUrl() {
		return null;
	}
}
