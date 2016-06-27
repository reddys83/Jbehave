package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang.StringUtils;

public class EditCityPage extends AbstractPage {
	private String countryPlacesArea = "";

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
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
	 * This method is to clear and enter the value in text field
	 * 
	 * @param webElement
	 * @param value
	 */
	public void clearAndEnterValue(By webElement, String value) {
		getDriver().findElement(webElement).clear();
		getDriver().findElement(webElement).sendKeys(value);
	}

	/**
	 * This method is to enter the value in addInfo text field
	 * 
	 * @param addInfoText
	 */
	public void enterTextCityAddInfo(String addInfoText) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath"), addInfoText);
	}

	/**
	 * This method is to verify the value in addInfo text field to equal to
	 * expected.
	 * 
	 * @param addInfoText
	 */
	public void verifyTextInAddInfo(String addInfoText) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(addInfoText, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_add_info_xpath_after_save")).getText());
	}

	/**
	 * This method is to verify maximum characters entered in additional info
	 * text box is 500
	 */
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

	/**
	 * This method is to verify maximum characters entered in additional info
	 * text box is 500
	 */
	public void verifyMaximumChracterEnteredInAddInfo() {
		assertEquals(addInfoMaximumCharacterString.subSequence(0, 500), getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_add_info_xpath_after_save")).getText());
	}

	/**
	 * This method is used to click the city status drop-down
	 */
	public void clickOnCityStatusDropDown() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_options_xpath"));
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
	 * This method is to verify the specified value 'valueToBeVerified' is
	 * present in specified 'source' DB
	 * 
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
			Thread.sleep(7000L);
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

	public void verifyNoSummaryConfirmationModal(String summaryText) {
		try {
			WebElement confirmChanges = getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("confirmation_modal_xpath"));
			String confirmationText = confirmChanges.getText();
			assertTrue(!(confirmationText.contains("Summary")) && !(confirmationText.contains(summaryText)));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	public void viewValidCharacterLength() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String text = "";
		Integer len = null;
		text = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_xpath_after_save")).getText();
		len = text.length();
		assertEquals(len.toString(), "500");
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
	 * This method is used to verify the passing status is selected in the city
	 * status drop-down
	 * 
	 * @param status
	 *            will hold the value to be verified with city status drop-down
	 *            selection
	 */
	public void verifyCityStatusInDropdown(String status) {
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
	 * This method is used to check whether the driver stays on city edit page.
	 */
	public void verifyCityEditPageMode() {
		assertTrue(getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath")).size() > 0);
	}

	public void verifyCityStatusInfoFromTrustedDB(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source),
				getSelectedDropdownValue(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath")));

	}

	public void verifyCityInfoFromZeusDB(String country, String area, String city, String tagName, String source,
			String status) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), status);
	}

	public void selectCityStatusValue(String status) {
		selectItemFromDropdownListByValue(CityIdentifiers.getObjectIdentifier("city_status_identifier_dropdown_xpath"),
				status);
	}

	public DataPage clickOnSaveButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("save_button_id"));
		return new DataPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
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
	 * This method is used to enter the Identifier type *
	 * 
	 * @param identifierType
	 */
	public void enterIdentifierType(String identifierType) {
		try {
			if (identifierType != null) {
				List<WebElement> identifierDropDowns = getDriver()
						.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
				Select dropdown = new Select(identifierDropDowns.get(0));
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
	public void enterIdentifierStatus(String identifierStatus) {
		try {
			if (identifierStatus != null) {
				List<WebElement> identifierDropDowns = getDriver()
						.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
				Select dropdown = new Select(identifierDropDowns.get(0));
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
	 * This method is to verify whether the successful message is generated
	 * after saving the city page.
	 */
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_save_confirmation_message_id"))
				.isDisplayed());
	}

	/**
	 * This method is used for performing the delete operation for a Identifier
	 * row by clicking on the delete row button
	 * 
	 */
	public void clickOnDeleteNewIdentifierRowButtonCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));
	}

	public void verifyNewlyAddedIdentifierRowIsNotDisplayed() {

		try {
			WebElement identifier = getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_AdditionalIdentifiers"));
			assertTrue(identifier == null);
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	public void verifyNewlyAddedIdentifierRowIsDisplayed() {

		WebElement identifier = getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
		assertTrue(identifier != null);

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
	 * This method is used to verify whether the delete confirmation table is
	 * present upon clicking the delete row button
	 * 
	 */
	public void verifyDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
	}

	/**
	 * This method is used to enter the Identifier value
	 * 
	 * @param identifierValue
	 */
	public void enterIdentifierValue(String identifierValue) {
		try {
			if (identifierValue != null) {

				List<WebElement> identifierDropDowns = getDriver()
						.findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
				identifierDropDowns.get(0).clear();
				identifierDropDowns.get(0).sendKeys(identifierValue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to enter the Identifier value
	 * 
	 * @param rowNo
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
			e.printStackTrace();
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
	 * This method is used to verify whether the error message in identifier
	 * value field
	 */
	public void verifyErrorMessageForRequiredCityIdentifierValue() {
		assertEquals("Enter up to 50 valid characters.", getDriver()
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
	 */
	public void verifyErrorMessageForRequiredCityIdentifierStatus() {
		assertEquals("Required",
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_status_req_err_msg_xpath"))
						.getText());
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
	 */
	public void clickYesButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id_click")).click();
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
							assertEquals(
									StringUtils.capitalize(document.getElementsByTagName("identifiers").item(0)
											.getChildNodes().item(i).getChildNodes().item(childNode).getTextContent()),
									identifierStatus[i]);
							break;

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCityIdentifierType() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
	}

	public void clickOnCityIdentifierStatus() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
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
			assertEquals(StringUtils.capitalize(
					document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent()),
					options.get(indexOfOption + 1).getText().trim());
		}

	}

	/**
	 * This method is used for performing the delete all identifier rows row by
	 * clicking on the delete row button
	 * 
	 */
	public void deleteAllIdentifierRows() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_add_new_identifier_button_id"));
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
	 * This method is used for pressing the Enter key in the delete confirmation
	 * modal
	 */
	public void pressEnterButtonInDeleteConfirmationModalForCity() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id")).sendKeys(Keys.ENTER);
	}

	public void verifyCityAddInfoValueFromTrusted(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source),
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_add_info_text_xpath")).getText());

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
	public void verifyCityEndDateValueFromTrusted(String country, String area, String city, String tagName,
			String source) {
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_end_date_info_text_xpath")).getText());

	}

	public void enterDayInBeganDate(String day) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_day_began_date_xpath"), day);
	}

	public void enterMonthInBeganDate(String month) {
		try {
			List<WebElement> monthDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_month_began_date_xpath"));
			Select dropdown = new Select(monthDropDowns.get(0));
			if (month.equals("")) {
				dropdown.selectByValue(month);
			} else {
				month = month.substring(0, 3);
				dropdown.selectByVisibleText(month);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterYearInBeganDate(String year) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_year_began_date_xpath"), year);
	}

	public void enterDayInEndDate(String day) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_day_end_date_xpath"), day);
	}

	public void enterMonthInEndDate(String month) {
		try {
			List<WebElement> monthDropDowns = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_month_end_date_xpath"));
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

	public void enterYearInEndDate(String year) {
		clearAndEnterValue(CityIdentifiers.getObjectIdentifier("city_year_end_date_xpath"), year);
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

		List<WebElement> monthDropDownList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_month_end_date_xpath"));

		Select monthDropdown = new Select(monthDropDownList.get(0));

		List<String> monthListInString = new ArrayList<String>();
		for (WebElement monthoption : monthDropdown.getOptions()) {
			monthListInString.add(monthoption.getText());
		}

		assertTrue(monthInOrder.equals(monthListInString));
	}

	public void verifyErrorMessageForEndDate(String errMsg) {
		assertEquals(
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_error_for_invalid_date")).getText(),
				errMsg);
	}

	public void enterDateLaterThanToday() throws ParseException {
		Calendar cal = Calendar.getInstance();
		enterDayInEndDate(Integer.toString(cal.get(Calendar.DATE) + 1));
		Format formatter = new SimpleDateFormat("MMMM");
		String month = formatter.format(new Date());
		month = month.substring(0, 3);
		enterMonthInEndDate(month);
		enterYearInEndDate(Integer.toString(cal.get(Calendar.YEAR) + 1));
	}

	public void clearBeganDate() {
		clearValue(CityIdentifiers.getObjectIdentifier("city_day_began_date_xpath"));
		enterMonthInBeganDate("");
		clearValue(CityIdentifiers.getObjectIdentifier("city_year_began_date_xpath"));
	}

	public void clearValue(By webElement) {
		getDriver().findElement(webElement).clear();
	}

	public void verifyCityEndDateFromTrustedDB(String country, String area, String city, String tagName,
			String source) {

		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_end_date_info_text_xpath")).getText());

	}

	public void enterEndDate(String day, String month, String year) {
		enterDayInEndDate(day);
		enterMonthInEndDate(month);
		enterYearInEndDate(year);
	}

	public void selectTrueForUseInAddress() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_use_in_address_true"));
	}

	public void selectFalseForUseInAddress() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_use_in_address_false"));
	}

	public void verifyCityAddressFlagFromZeusDB(String country, String area, String city, String tagName,
			String source) {
		assertEquals(StringUtils.capitalize(getCityInfoFromDB(country, area, city, tagName, source)),
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_address_flag_xpath")).getText());

	}

	public void verifyMaxLengthInCityIdentifierValue(String maxLength) {
		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"))
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

	public void verifyCityBeganDateFromTrustedDB(String country, String area, String city, String tagName,
			String source) {
		List<WebElement> appliedMonthList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_month_began_date_xpath"));
		String day = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_day_began_date_xpath"))
				.getAttribute("value");
		String month = new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_year_began_date_xpath"))
				.getAttribute("value");
		String beganDate = day + " " + month + " " + year;
		assertEquals(getCityInfoFromDB(country, area, city, tagName, source), beganDate);

	}

	public void clickOnCityPlaces() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_link_id"));
	}

	public void clickOnAddPlacesButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_add_places_button_edit_id"));
	}

	public void verifyRequiredErrorMessageForType() {
		assertEquals(getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_places_type_required_error_message_xpath"))
				.getText(), "Required");
	}

	public void verifyRequiredErrorMessageForPlace() {
		assertEquals(getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_places_place_required_error_message_xpath"))
				.getText(), "Required");
	}

	public void clickCityPlaceType() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_type_dropdown_xpath"));
	}

	public void selectsPlacesTypeFromDropdwon(String placeType) {
		List<WebElement> options = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_type_options_dropdown_xpath"));

		for (WebElement option : options) {
			if (option.getText().contains(placeType)) {
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_type_options_dropdown_xpath"))
						.click();
				option.click();
				break;
			}
		}
	}

	public void clicksOnEditButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_place_edit_button_xpath"));
	}

	public void clicksOnCountryInPlacesForCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_xpath"));
	}

	public void selectsCountryInPlacesForCity(String countryPlaces) {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_input_xpath"))
				.sendKeys(countryPlaces);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_input_xpath"))
				.sendKeys(Keys.RETURN);
		try {
			Thread.sleep(6000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clicksOnAreaDropdownInPlacesForCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_xpath"));
	}

	public void selectsAreaInPlacesForCity(String areaPlaces) {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_input_xpath"))
				.sendKeys(areaPlaces);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_input_xpath"))
				.sendKeys(Keys.RETURN);
		
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clicksOnCityDropdownInPlacesForCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_city_dropdown_xpath"));
	}

	public void selectsCityInPlacesForCountry(String cityPlaces) {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_city_dropdown_input_xpath"))
				.sendKeys(cityPlaces);
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_city_dropdown_input_xpath"))
				.sendKeys(Keys.RETURN);
	}

	public void clicksOnGoButton() {
		getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_go_button_xpath")).click();
	}

	public void selectsPlacesDetailsFromDropdown(String PlaceDetails) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		selectItemFromDropdownListByText(
				CityIdentifiers.getObjectIdentifier("city_places_details_Select_dropdown_xpath"), PlaceDetails);
	}

	public void verifyPlaceInPlacesForCity(String place) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(place, getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_place_edit_xpath"))
				.getAttribute("value"));
	}

	public void clicksOnDeleteCityPlacesType() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_delete_button_xpath"));
	}

	public void verifyDrawerClosed() {
		try {
			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_xpath"))
							.isDisplayed());
			assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_xpath"))
					.isDisplayed());
			assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_city_dropdown_xpath"))
					.isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

		}
	}

	public void verifyGoButtonDisabled() {
		try {
			assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_go_button_xpath"))
					.isEnabled());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyEditButtonDisabled() {
		try {
			assertFalse(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_place_edit_button_xpath"))
							.isEnabled());
		}

		catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyDeleteButtonDisabled() {
		try {
			assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_delete_button_xpath"))
					.isEnabled());
		}

		catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void clickDetailsDropDown() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_places_details_Select_dropdown_xpath"));
	}

	public void verifyCityPlacesTypeList() {
		List<WebElement> cityPlacesTypeList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_type_options_dropdown_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get city places type");
		for (int i = 1; i < document.getElementsByTagName("detail").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					cityPlacesTypeList.get(i).getText());
		}
	}

	public void verifyCityPlacesDetailsList() {
		List<WebElement> cityPlacesDetailsList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_details_options_dropdown_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get city places detail");
		for (int i = 1; i < document.getElementsByTagName("detail").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
					cityPlacesDetailsList.get(i).getText());
		}
	}

	public void verifyCountryListInPlacesForCity() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebElement> countryList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_list_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");

		for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(),
					countryList.get(i).getText().trim());
		}
	}

	public void verifyAreaListInPlacesForCity(String countryPlacesCountry) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("name", countryPlacesCountry));
			nvPairs.add(new BasicNameValuePair("source", "trusted"));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list",
					nvPairs);
			if (getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list_xpath"))
					.size() > 2) {
				assertEquals(getDriver()
						.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list1_xpath"))
						.getText(), "No Area");
				assertEquals(getDriver()
						.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list2_xpath"))
						.getText(), "Return All Cities");
				for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
					assertEquals(document.getElementsByTagName("area").item(i).getTextContent(),
							getDriver()
									.findElements(
											CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list_xpath"))
									.get(i + 2).getText());
				}
			} else {
				assertEquals(getDriver()
						.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list1_xpath"))
						.getText(), "No Area");
				assertEquals(getDriver()
						.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list2_xpath"))
						.getText(), "Return All Cities");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyCityListInPlacesForCity() {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("name", countryPlacesArea));
		nvPairs.add(new BasicNameValuePair("source", "trusted"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city list",
				nvPairs);
		for (int i = 0; i < document.getElementsByTagName("city").getLength(); i++) {
			assertEquals(document.getElementsByTagName("city").item(i).getTextContent(),
					getDriver()
							.findElements(CityIdentifiers.getObjectIdentifier("city_places_city_dropDown_list_xpath"))
							.get(i).getText());
		}
	}

	public void verifyRelatedPlacesInCityPage(String type, String place, String details) {
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(type, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_relatedplace_typevalue_xpath")).getText());
		assertEquals(place, getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_relatedplace_placevalue_xpath")).getText());
		assertEquals(details,
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_get_relatedplace_detailsvalue_xpath"))
						.getText());
	}

	public void verifyCityRelatedValueFromZeusDB(String country, String area, String city, String type, String place,
			String details, String source) {
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlaceType", source), type);
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlacePlace", source), place);
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlaceDetail", source), details);

	}

	public String getCityRelatedInfoFromDB(String country, String area, String city, String tagName, String source) {

		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("city", city));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get city related place info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	/**
	 * This method is used for performing the delete all related places rows row
	 * by clicking on the delete row button
	 * 
	 */
	public void deleteAllRelatedPlaces() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_add_places_button_edit_id"));
		List<WebElement> deleteRows = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_delete_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_places_delete_button_xpath")).get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyDeleteConfirmationModalRelatedPlace();
				pressEnterButtonInDeleteConfirmationModalForCity();
			}

		}

	}

	/**
	 * This method is used to verify whether the delete confirmation table in
	 * related place is present upon clicking the delete row button
	 * 
	 */
	public void verifyDeleteConfirmationModalRelatedPlace() {
		assertEquals("Please confirm - would you like to delete this row? NO YES",
				getDriver()
						.findElement(
								CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_relatedplace_xpath"))
						.getText());
	}

	public void verifyDeletedRelatedPlaces(String type, String place, String details) {
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_get_relatedplace_entirevalue_xpath")).getText());
	}

	public void verifyDeletedCityRelatedValueFromZeusDB(String country, String area, String city, String source) {
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlaceType", source), "");
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlacePlace", source), "");
		assertEquals(getCityRelatedInfoFromDB(country, area, city, "RelatedPlaceDetail", source), "");

	}

	public void verifyEditButtonEnabled() {
		try {
			assertTrue(
					getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_place_edit_button_xpath"))
							.isEnabled());
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyDefaultValueCountry() {
		assertEquals("Choose a Country", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_xpath")).getText());
	}

	public void verifyAreaDisabled() {
		try {

			assertFalse(getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_input_xpath"))
					.isDisplayed());
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyCityDisabled() {
		try {
			assertFalse(getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_input_xpath"))
					.isDisplayed());
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void verifyDefaultCountryOptionNotSelectable() {
		List<WebElement> countryList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_country_dropDown_list_xpath"));
		for (int i = 0; i < countryList.size(); i++) {
			assertNotEquals(countryList.get(i).getText(), "Choose a Country");
		}
	}

	public void verifyDefaultValueArea() {
		assertEquals("Choose an Area", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_places_area_dropdown_xpath")).getText());
	}

	public void verifyDefaultValueCity() {
		assertEquals("Choose a City", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_places_city_dropdown_xpath")).getText());
	}

	public void verifyDefaultAreaOptionNotSelectable() {
		List<WebElement> AreaList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_area_dropDown_list_xpath"));
		for (int i = 0; i < AreaList.size(); i++) {
			assertNotEquals(AreaList.get(i).getText(), "Choose an Area");

		}
	}

	public void verifyDefaultCityOptionNotSelectable() {
		List<WebElement> CityList = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_places_city_dropDown_list_xpath"));
		for (int i = 0; i < CityList.size(); i++) {
			assertNotEquals(CityList.get(i).getText(), "Choose a City");

		}
	}

	public void verifyGoButtonEnabled() {
		try {
			assertTrue(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_places_go_button_xpath"))
					.isEnabled());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnAll() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_All_link_id"));
	}

	@Override
	public String getPageUrl() {
		return null;
	}

}