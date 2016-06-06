package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
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

	/**
	 * This method is used to click on the Identifier button for adding a new
	 * row
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

	/**
	 * This method is used to enter the Identifier type
	 * 
	 * @param identifierType
	 */
	public void enterIdentifierType(String identifierType) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
			Select dropdown = new Select(identifierDropDowns.get(0));
			if (identifierType.equals("")) {
				dropdown.selectByValue(identifierType);
			} else {
				dropdown.selectByVisibleText(identifierType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to enter the Identifier type on empty row
	 * 
	 * @param identifierType
	 */
	public void enterIdentifierType_Row(String identifierType, int rowNo) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
			if (rowNo <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNo - 1));
				if (identifierType.equals("")) {
					dropdown.selectByValue(identifierType);
				} else {
					dropdown.selectByVisibleText(identifierType);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to enter the Identifier status
	 * 
	 * @param identifierStatus
	 */
	public void enterIdentifierStatus_Row(String identifierStatus, int rowNo) {
		try {

			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
			if (rowNo <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNo - 1));
				if (identifierStatus.equals("")) {
					dropdown.selectByValue(identifierStatus);
				} else {
					dropdown.selectByVisibleText(identifierStatus);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to enter the Identifier status
	 * 
	 * @param identifierStatus
	 */
	public void enterIdentifierStatus(String identifierStatus) {
		try {

			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
			Select dropdown = new Select(identifierDropDowns.get(0));
			if (identifierStatus.equals("")) {
				dropdown.selectByValue(identifierStatus);
			} else {
				dropdown.selectByVisibleText(identifierStatus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used for performing the delete operation for a Identifier
	 * row by clicking on the delete row button
	 * 
	 */
	public void clickOnDeleteNewIdentifierRowButtonCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));
	}

	/**
	 * This method is used for performing the delete all identifier rows row by
	 * clicking on the delete row button
	 * 
	 */
	public void deleteAllIdentifierRows() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));
		List<WebElement> deleteRows = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"))
					.get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyDeleteConfirmationModal();
				pressEnterButtonInDeleteConfirmationModalForCity();
			}

		}

	}

	/**
	 * This method is used to verify whether the delete confirmation table is
	 * present upon clicking the delete row button
	 * 
	 */
	public void verifyDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
	}

	/**
	 * This method is used to verify whether data is present in the Identifiers
	 * as mentioned below
	 * 
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

	/**
	 * This method verifies whether the confirmation model is not present.
	 */
	public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {	

		try
		{
			WebElement identifier = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_AdditionalIdentifiers"));
			assertTrue(identifier==null);
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
		
	}

	/**
	 * This method verifies whether the confirmation model is present.
	 */
	public void verifyNewlyAddedIdentifierRowIsDisplayed(){
		
			WebElement identifier = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
			assertTrue(identifier!=null);		

	}

	/**
	 * This method is used to clear the data present in the Identifier value
	 * text box
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

	/**
	 * This method is used to click on the 'Confirm' button after saving
	 * 
	 * @throws Exception
	 */
	public void clickOnConfirmButtonCity() throws Exception {
		Thread.sleep(3000);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_confirm_button")).click();
		Thread.sleep(3000);
	}

	/**
	 * This method is used to enter the Identifier value
	 * 
	 * @param identifierValue
	 */
	public void enterIdentifierValue_Row(String identifierValue, int rowNo) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
			if (rowNo <= identifierDropDowns.size()) {
				identifierDropDowns.get(rowNo - 1).clear();
				identifierDropDowns.get(rowNo - 1).sendKeys(identifierValue);
			}

		} catch (Exception e) {

		}
	}

	/**
	 * This method is used to enter the Identifier value
	 * 
	 * @param identifierValue
	 */
	public void enterIdentifierValue(String identifierValue) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
			identifierDropDowns.get(0).clear();
			identifierDropDowns.get(0).sendKeys(identifierValue);

		} catch (Exception e) {

		}
	}

	/**
	 * This method is used to verify whether we get an error message after
	 * clicking save without entering any text for Identifier Value
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierValue() {
		assertEquals("Required", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_value_req_err_msg_xpath")).getText());
	}

	/**
	 * This method is used to verify whether we get an error message after
	 * clicking save without entering any text for Identifier Type
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierType() {
		assertEquals("Required", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_req_err_msg_xpath")).getText());
	}

	/**
	 * This method is used to verify whether we get an error message after
	 * clicking save without entering any text for Identifier Status
	 * 
	 */
	public void verifyErrorMessageForRequiredCityIdentifierStatus() {
		assertEquals("Required",
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_status_req_err_msg_xpath"))
						.getText());
	}

	/**
	 * This method is used to verify whether we get an error message for
	 * entering a text beyond 50 characters for Identifier Value
	 * 
	 */
	public void verifyErrorMessageForLongCityIdentifierValue() {
		assertEquals("Enter up to 50 valid characters.",
				getDriver()
						.findElement(
								CityIdentifiers.getObjectIdentifier("city_identifier_value_max_length_err_msg_xpath"))
						.getText());
	}

	/**
	 * This method is used for pressing the Enter key in the delete confirmation
	 * modal
	 * 
	 */
	public void pressEnterButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id")).sendKeys(Keys.ENTER);
	}

	/**
	 * This method is used for clicking the 'No' button in the delete
	 * confirmation modal
	 * 
	 */
	public void clickNoButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_no_button_id_click")).click();
	}

	/**
	 * This method is used for clicking the 'Yes' button in the delete
	 * confirmation modal
	 * 
	 */
	public void clickYesButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id_click")).click();
	}

	/**
	 * This method is used to verify that delete confirmation modal is not
	 * displayed
	 * 
	 */
	public void verifyDeleteConfirmationModalIsNotDisplayed() {
		try {

			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath"))
							.isDisplayed());

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to verify that delete confirmation modal is not
	 * displayed
	 * 
	 */
	public void verifyDeleteConfirmationModalIsDisplayed() {
		try {

			assertTrue(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath"))
							.isDisplayed());

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to verify whether the successful message is generated
	 * after saving the city page.
	 */
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id"))
				.isDisplayed());
	}

	/**
	 * This method is used to get the city information from DB
	 * 
	 * @param country
	 * @param area
	 * @param city
	 * @param tagName
	 * @param source
	 * @return value of the tag name passed to it
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

	/**
	 * This method is used to verify the value in trusted DB is same as UI
	 * value.
	 * 
	 * @param country
	 * @param area
	 * @param city
	 * @param tagName
	 * @param source
	 */
	public void verifyCityIdentifierValuesFromTrusted(String country, String area, String city, String[] identifierType,
			String[] identifierValue, String[] identifierStatus) {

		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("country", country));
			nvPairs.add(new BasicNameValuePair("area", area));
			nvPairs.add(new BasicNameValuePair("city", city));
			nvPairs.add(new BasicNameValuePair("source", "trusted"));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get city basic info", nvPairs);

			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("identifiers").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("identifiers").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("identifiers").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "type":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierType[i]);
							break;
						case "value":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierValue[i]);
							break;
						case "identifierStatus":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierStatus[i]);
							break;

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCityIdentifierTypesList_forOneRow() {

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get city identifiers");
		List<WebElement> cityIdentifierTypesList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("cityIdentifier_type_id"));

		List<WebElement> options = cityIdentifierTypesList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 1; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption).getText().trim());
		}

	}

	public void verifyCityIdentifierStatusList() {

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get Status types");
		List<WebElement> cityIdentifierTypesList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));

		List<WebElement> options = cityIdentifierTypesList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 0; indexOfOption < document.getElementsByTagName("status")
				.getLength(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent()
					.toLowerCase(), options.get(indexOfOption + 1).getText().trim());
		}

	}

	public void clickOnCityIdentifierStatus() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
	}

	public void clickOnCityIdentifierType() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
	}

	@Override
	public String getPageUrl() {
		return null;
	}
}
