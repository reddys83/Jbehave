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
	

	public void clickOnCityCreditRating() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_creditRating"));
	}

	public void enterCityCreditRatingAppliedDateDay(String appliedDay, int row) {
		List<WebElement> appliedDateList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_applied_date_day_xpath"));		
		appliedDateList.get(row).sendKeys(appliedDay);					
	}
	

	public void enterCityCreditRatingAppliedDateMonth(String appliedMonth, int row) {
		List<WebElement> appliedMonthList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_applied_date_month_xpath"));
		selectItemFromDropdownListByText(appliedMonthList.get(row), appliedMonth);
	}

	public void enterCityCreditRatingConfirmedDateMonth(String confirmedMonth, int row) {
		List<WebElement> confirmedDateList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_month_xpath"));
		selectItemFromDropdownListByText(confirmedDateList.get(row), confirmedMonth);
	}

	public void enterCityCreditRatingConfirmedDateDay(String confirmedDay, int row) {
		List<WebElement> confirmedMonth = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_day_xpath"));
		confirmedMonth.get(row).clear();				
		confirmedMonth.get(row).sendKeys(confirmedDay);
	}

	public void enterCreditRatingAppliedYear(String appliedYear, int row) {
		List<WebElement> appliedYearList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_appliedYear_xpath"));
		appliedYearList.get(row).clear();
		appliedYearList.get(row).sendKeys(appliedYear);
	}

	public void verifyErrorMessageEnterYearMonthDayForAppliedDate() {
		assertEquals("Enter a year, month/year or day/month/year.",
				getDriver()
						.findElement(
								CityIdentifiers.getObjectIdentifier("city_credit_rating_applied_date_error_msg_xpath"))
						.getText());
	}

	public void enterCreditRatingConfirmedYear(String confirmedYear, int row) {
		List<WebElement> confirmedYearList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_year_xpath"));
		confirmedYearList.get(row).clear();
		confirmedYearList.get(row).sendKeys(confirmedYear);
	}

	public void clickAddRowButton() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_credit_rating_addRow_id"));
	}

	/**
	 * This method is used to click the city Agency drop-down
	 */
	public void clickOnAgencyDropDown() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_credit_rating_agency_dropdown_xpath"));
	}

	/**
	 * This method is used to click the city Agency drop-down
	 */
	public void clickOnAgencyTypeDropDown() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_credit_rating_type_dropdown_xpath"));
	}

	/**
	 * This method is used to verify the look up data values available for city
	 * agency drop-down
	 */
	public void verifyCityAgencyList() {
		List<WebElement> agencyList = getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_agency_dropdown_xpath"))
				.findElements(By.tagName("option"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,
				"get city credit look up values");
		for (int i = 0; i < document.getElementsByTagName("creditRatingAgency").getLength(); i++) {
			assertEquals(document.getElementsByTagName("creditRatingAgency").item(i).getTextContent(),
					agencyList.get(i + 1).getAttribute("value"));
		}

	}

	/**
	 * This method is used to verify the look up data values available for city
	 * agency drop-down
	 */
	public void verifyCityCreditRatingTypeList() {
		List<WebElement> typeList = getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_type_dropdown_xpath"))
				.findElements(By.tagName("option"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,
				"get city credit look up values");
		for (int i = 0; i < document.getElementsByTagName("creditRatingType").getLength(); i++) {
			assertEquals(document.getElementsByTagName("creditRatingType").item(i).getTextContent(),
					typeList.get(i + 1).getAttribute("value"));
		}

	}

	/**
	 * This method is used to enter the CreditRatingType *
	 * 
	 * @param CreditRatingType
	 */
	public void enterCreditRatingType(String creditRatingType, int row) {

		List<WebElement> typeDropDownList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_type_dropdown_xpath"));
		selectItemFromDropdownListByText(typeDropDownList.get(row),creditRatingType);

	}

	/**
	 * This method is used to enter the CreditRatingAgency *
	 * 
	 * @param CreditRatingAgency
	 */
	public void enterCreditRatingAgency(String creditRatingAgency, int row) {
		try {
			List<WebElement> agencyDropDownList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_agency_dropdown_xpath"));
			selectItemFromDropdownListByText(agencyDropDownList.get(row),creditRatingAgency);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterCityCreditRatingValue(String appliedDay,int row) {
		List<WebElement> valueTextboxList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_value_xpath"));
		valueTextboxList.get(row).clear();		
		valueTextboxList.get(row).sendKeys(appliedDay);
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
	public void verifyCityCreditRatingValuesFromDB(String country, String area, String city, String source,
			String agency, String type, String value, String appliedDate, String confirmedDate, int row) {

		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("country", country));
			nvPairs.add(new BasicNameValuePair("area", area));
			nvPairs.add(new BasicNameValuePair("city", city));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get city basic info", nvPairs);

			if (document != null && document.getElementsByTagName("creditRating").getLength() > row) {

				for (int childNode = 0; childNode < document.getElementsByTagName("creditRating").item(row)
						.getChildNodes().getLength(); childNode++) {

					switch (document.getElementsByTagName("creditRating").item(row).getChildNodes().item(childNode)
							.getNodeName()) {
					case "creditRatingAgencyName":
						assertEquals(document.getElementsByTagName("creditRating").item(row).getChildNodes()
								.item(childNode).getTextContent(), agency);
						break;
					case "creditRatingType":
						assertEquals(document.getElementsByTagName("creditRating").item(row).getChildNodes()
								.item(childNode).getTextContent(), type);
						break;
					case "creditRatingValue":
						assertEquals(document.getElementsByTagName("creditRating").item(row).getChildNodes()
								.item(childNode).getTextContent(), value);
						break;
					case "creditDateApplied":
						assertEquals(String.valueOf(document.getElementsByTagName("creditRating").item(row).getChildNodes()
								.item(childNode).getTextContent()), appliedDate);
						break;
					case "creditDateConfirmed":
						assertEquals(String.valueOf(document.getElementsByTagName("creditRating").item(row).getChildNodes()
								.item(childNode).getTextContent()), confirmedDate);
						break;

					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
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
	public void verifyCityCreditRatingValuesFromTrustedDB(String country, String area, String city, String source)
	{	

		try {		
			    //to avoid the driver finding time when there are no rows, clicking row button. so that at least one web element will be exist.
				clickAddRowButton();
				List<WebElement> agencyDropDownList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_agency_dropdown_xpath"));
				List<WebElement> typeDropDownList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_type_dropdown_xpath"));
				List<WebElement> appliedDateList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_applied_date_day_xpath"));
				List<WebElement> appliedMonthList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_applied_date_month_xpath"));
				List<WebElement> appliedYearList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_appliedYear_xpath"));
				List<WebElement> confirmedDateList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_day_xpath"));
				List<WebElement> confirmedMonth = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_month_xpath"));
				List<WebElement> confirmedYearList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_confirmed_date_year_xpath"));			
				List<WebElement> valueTextboxList = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_credit_rating_value_xpath"));
				
				for(int index =0;index<agencyDropDownList.size();index++)
				{					
					String agency = new Select(agencyDropDownList.get(index)).getFirstSelectedOption().getText().trim();
					String type =  new Select(typeDropDownList.get(index)).getFirstSelectedOption().getText();
					String value = valueTextboxList.get(index).getAttribute("value");
					String appliedDate =  new Select(appliedMonthList.get(index)).getFirstSelectedOption().getText() +" "+ appliedYearList.get(index).getAttribute("value");
					String confirmedDate = new Select(confirmedMonth.get(index)).getFirstSelectedOption().getText() +" "+ confirmedYearList.get(index).getAttribute("value");
					if(!appliedDateList.get(index).getAttribute("value").isEmpty() && !confirmedDateList.get(index).getAttribute("value").isEmpty()){
						 appliedDate = String.format("%02d",Integer.parseInt(appliedDateList.get(index).getAttribute("value"))) + " " +  appliedDate;
						 confirmedDate = String.format("%02d",Integer.parseInt(confirmedDateList.get(index).getAttribute("value"))) + " " + confirmedDate;	
					}										    
					verifyCityCreditRatingValuesFromDB(country, area, city, source, agency, type, value, appliedDate, confirmedDate, index);	
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used for performing the delete all credit rating rows row by
	 * clicking on the delete row button
	 * 
	 */
	public void deleteExistingCreditRatingRows() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_credit_rating_addRow_id"));
		List<WebElement> deleteRows = getDriver()
				.findElements(CityIdentifiers.getObjectIdentifier("city_delete_credit_rating_row_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(CityIdentifiers.getObjectIdentifier("city_delete_credit_rating_row_button_xpath"))
					.get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyCreditRatingDeleteConfirmationModal();
				pressEnterButtonInDeleteConfirmationModalForCity();
			}

		}

	}
	
	/**
	 * This method is used to verify whether the delete confirmation table is
	 * present upon clicking the delete row button
	 * 
	 */
	public void verifyCreditRatingDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver()
				.findElement(CityIdentifiers.getObjectIdentifier("city_delete_credit_rating_row_confirmation_modal_xpath")).getText());
	}
	
	/**
	 * This method is used to verify whether we get an error message after
	 * clicking save without entering any text for credit rating agency
	 */
	public void verifyErrorMessageForRequiredCityCreditRatingAgency() {
		assertEquals("Required",
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_agency_error_xpath"))
						.getText());
	}
	
	/**
	 * This method is used to verify whether we get an error message after
	 * clicking save without entering any text for credit rating type
	 */
	public void verifyErrorMessageForRequiredCityCreditRatingType() {
		assertEquals("Required",
				getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_type_error_xpath")).getText());
	}
	
	/**
	 * This is to verify error message is displayed for credit rating value field as
	 * expected
	 */
	public void verifyErrorMessageInCityCreditRatingValue(String errorMsg) {

		assertEquals(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_value_error_xpath"))
				.getText(), errorMsg);
	}
	
	public void clickOnDeleteNewCreditRatingRowButtonCity() {
		attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_credit_rating_row_button_xpath"));
	}
	
	public void verifyNewlyAddedCreditRatingRowIsNotDisplayed() {

		try {
			WebElement identifier = getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_row_xpath"));
			assertTrue(identifier == null);
		} catch (Exception e) {
			assertTrue(true);
		}

	}
	
	public void verifyNewlyAddedCreditRatingRowIsDisplayed() {

		try {
			WebElement identifier = getDriver()
					.findElement(CityIdentifiers.getObjectIdentifier("city_credit_rating_row_xpath"));
			assertTrue(identifier !=null);
		} catch (Exception e) {
			assertTrue(false);
		}
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

	@Override
	public String getPageUrl() {
		return null;
	}

}
