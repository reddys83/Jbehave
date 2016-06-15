package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	String prevText = "";
	String text = "";
	Integer len = null;

	public void verifyTextInAddInfo(String addInfoText) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(addInfoText, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_add_info_xpath_after_save")).getText());

	}

	public void verifyMaximumChracterEnteredInAddInfo() {
		assertEquals(addInfoMaximumCharacterString.subSequence(0, 500), getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_add_info_xpath_after_save")).getText());
	}

	public void enterTextCityAddInfo(String addInfoText) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"), addInfoText);
	}

	public void clearAndEnterValue(By webElement, String value) {
		getDriver().findElement(webElement).clear();
		getDriver().findElement(webElement).sendKeys(value);

	}

	String addInfoMaximumCharacterString = null;

	public void enterInvalidCharactersInCityAddInfo() {
		char c = 'a';
		String invalidData = "";
		for (int i = 0; i <= 500; i++) {
			invalidData += c;
		}
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).clear();
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).sendKeys(invalidData);
		addInfoMaximumCharacterString = invalidData;
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
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					statusList.get(i).getAttribute("value"));
		}

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
	 * This method is used to check there are no Confirmation Summary (no
	 * changes) in the confirmation modal
	 * 
	 * @param will
	 *            check if the required confirmation changes message is not
	 *            present in confirmation modal
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

		try {
			WebElement identifier = getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_AdditionalIdentifiers"));
			assertTrue(identifier == null);
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	/**
	 * This method verifies whether the confirmation model is present.
	 */
	public void verifyNewlyAddedIdentifierRowIsDisplayed() {

		WebElement identifier = getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
		assertTrue(identifier != null);

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

	public void clearAddInfoTextArea() {
		clearValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"));
	}

	public void clearValue(By webElement) {
		getDriver().findElement(webElement).clear();
	}

	public void viewValidCharacterLength() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		text = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_added_text_xpath")).getText();
		len = text.length();
		assertEquals(len.toString(), "500");
	}

	public void verifyNoSummaryConfirmationModal(String summaryText) {
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

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get city Status types");
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

	/**
	 * This method is to enter the value in population text field
	 * 
	 * @param value
	 */
	public void entervalueInPopulationField(String value) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_population_input_id"), value);
	}

	/**
	 * This is to verify error message is displayed for population field as
	 * expected
	 */
	public void verifyErrorMessageInCityPopulation() {

		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_error_message_id"))
				.getText(), "Enter up to 50 valid numbers.");
	}

	/**
	 * This is to verify maximum length of population field is 50
	 */
	public void verifyMaxLengthInCityPopulation(String maxLength) {

		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_population_input_id"))
				.getAttribute("maxlength"), maxLength);
	}

	/**
	 * 
	 * This method is used to verify the Began Date value from Zeus DB
	 * 
	 */
	public void verifyCityBeganDateFromZeusDB(String country, String area, String city, String tagName, String source,
			String day, String month, String year) {
		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getCityInfoFromDB(country, area, city, tagName, source));
		} else if ((day.isEmpty()) && (month.isEmpty())) {
			String expectedBeganDate = year;
			assertEquals(expectedBeganDate, getCityInfoFromDB(country, area, city, tagName, source));
		} else if ((day.isEmpty())) {
			String expectedBeganDate = month + " " + year;
			assertEquals(expectedBeganDate, getCityInfoFromDB(country, area, city, tagName, source));
		} else {
			String setBeganDate = day + " " + month + " " + year;
			assertEquals(getCityInfoFromDB(country, area, city, tagName, source), setBeganDate);
		}

	}

	public void enterDayBeganDate(String day) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_begandate_day_input_xpath"), day);
	}

	public void enterYearBeganDate(String year) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_begandate_year_input_xpath"), year);
	}

	public void selectMonthBeganDate(String month) {

		try {
			List<WebElement> monthDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_begandate_month_dropdown_xpath"));
			Select dropdown = new Select(monthDropDowns.get(0));
			if (month.equals("")) {
				dropdown.selectByValue(month);
			} else {
				dropdown.selectByVisibleText(month);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyErrorMessageBeganDate(String beganDateErrorMsg) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(beganDateErrorMsg, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_begandate_errorMessage_xpath")).getText());
	}

	public void verifyDayMonthYearInCityPage(String day, String month, String year) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_get_beganDate_value_xpath")).getText());
		}

		else if ((day.isEmpty()) && (month.isEmpty())) {
			assertEquals(year, getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_get_beganDate_value_xpath")).getText());
		}

		else if ((day.isEmpty())) {
			String getExpectedDate = month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_get_beganDate_value_xpath")).getText());
		}

		else {
			String getExpectedDate = day + " " + month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_get_beganDate_value_xpath")).getText());
		}
	}

	public void verifyMonthInChronologicalOrder() {
		List<String> monthInOrder = new ArrayList<String>();
		monthInOrder.add(" ");
		monthInOrder.add("Jan");
		monthInOrder.add("Feb");
		monthInOrder.add("Mar");
		monthInOrder.add("Apr");
		monthInOrder.add("May");
		monthInOrder.add("Jun");
		monthInOrder.add("Jul");
		monthInOrder.add("Aug");
		monthInOrder.add("Sep");
		monthInOrder.add("Oct");
		monthInOrder.add("Nov");
		monthInOrder.add("Dec");

		List<WebElement> monthDropDowns = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_begandate_month_dropdown_xpath"));
		Select dropdown = new Select(monthDropDowns.get(0));
		List<String> monthListInString = new ArrayList<String>();
		for (WebElement monthoption : dropdown.getOptions()) {
			monthListInString.add(monthoption.getText());
		}
		assertTrue(monthInOrder.equals(monthListInString));
	}

	public void verifyCityBeganDateFromTrustedDB(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_beganDate_value_xpath")).getText());

	}

	@Override
	public String getPageUrl() {
		return null;
	}

}
