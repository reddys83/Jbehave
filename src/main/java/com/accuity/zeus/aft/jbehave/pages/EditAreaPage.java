package com.accuity.zeus.aft.jbehave.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.AreaIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

public class EditAreaPage extends AbstractPage {

	
	private static String selectedCountryID = "";
	private static  String selectedAreaID = "";

	public EditAreaPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	public void verifyAreaEndDateFromTrustedDB(String country, String area, String tagName, String source) {

		List<WebElement> appliedMonthList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_month_end_date_xpath"));
		String day = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_day_end_date_xpath"))
				.getAttribute("value");

		if (StringUtils.isNotBlank(day) && StringUtils.length(day) < 2) {
			day = "0" + day;
		}

		String month = new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_year_end_date_xpath"))
				.getAttribute("value");
		String expectedEndDate = (day + " " + month + " " + year).trim();
		String actualEndDate = getAreaBasicInfoFromDB(country, area, tagName, source).trim();

		assertEquals(expectedEndDate, actualEndDate);

	}

	/**
	 * This method is used to get the area basic information from DB
	 *
	 * @param country
	 * @param area
	 * @param tagName
	 * @param source
	 * @return value of the tag name passed to it
	 */

	public String getAreaBasicInfoFromDB(String country, String area, String tagName, String source) {

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
				"get area basic info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
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
				.findElements(AreaIdentifiers.getObjectIdentifier("area_month_end_date_xpath"));

		Select monthDropdown = new Select(monthDropDownList.get(0));

		List<String> monthListInString = new ArrayList<String>();
		for (WebElement monthoption : monthDropdown.getOptions()) {
			monthListInString.add(monthoption.getText());
		}

		assertTrue(monthInOrder.equals(monthListInString));
	}

	public void enterDayInBeganDate(String day) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_day_began_date_xpath"), day);
	}

	public void enterMonthInBeganDate(String month) {
		try {
			List<WebElement> monthDropDowns = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_month_began_date_xpath"));
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
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_year_began_date_xpath"), year);
	}

	public void enterDayInEndDate(String day) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_day_end_date_xpath"), day);
	}

	public void enterMonthInEndDate(String month) {
		try {
			List<WebElement> monthDropDowns = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_month_end_date_xpath"));
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

	public void enterYearInEndDate(String year) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_year_end_date_xpath"), year);
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

	public void verifyErrorMessageEndDate(String endDateErrorMsg) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(endDateErrorMsg, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_enddate_errorMessage_xpath")).getText());
	}

	public void verifyEndDateInAreaPage(String day, String month, String year) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_end_date_info_text_xpath")).getText());
		}

		else if ((day.isEmpty()) && (month.isEmpty())) {
			assertEquals(year, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_end_date_info_text_xpath")).getText());
		}

		else if ((day.isEmpty())) {
			String getExpectedDate = month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_end_date_info_text_xpath")).getText());
		}

		else {
			String getExpectedDate = day + " " + month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_end_date_info_text_xpath")).getText());
		}
	}

	/**
	 *
	 * This method is used to verify the End Date value from Zeus DB
	 *
	 */
	public void verifyAreaEndDateFromZeusDB(String country, String area, String tagName, String source, String day,
			String month, String year) {
		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getAreaBasicInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty()) && (month.isEmpty())) {
			String expectedEndDate = year;
			assertEquals(expectedEndDate, getAreaBasicInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty())) {
			String expectedEndDate = month + " " + year;
			assertEquals(expectedEndDate, getAreaBasicInfoFromDB(country, area, tagName, source));
		} else {
			String setEndDate = (day + " " + month + " " + year).trim();
			assertEquals(setEndDate, getAreaBasicInfoFromDB(country, area, tagName, source).trim());
		}
	}

	public void verifyAreaBeganDateFromTrustedDB(String country, String area, String tagName, String source) {

		List<WebElement> appliedMonthList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_month_began_date_xpath"));
		String day = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_day_began_date_xpath"))
				.getAttribute("value");

		if (StringUtils.isNotBlank(day) && StringUtils.length(day) < 2) {
			day = "0" + day;
		}

		String month = new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_year_began_date_xpath"))
				.getAttribute("value");
		String beganDate = day + " " + month + " " + year;

		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), beganDate);

	}

	public void verifyErrorMessageBeganDate(String beganDateErrorMsg) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(beganDateErrorMsg, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_begandate_errorMessage_xpath")).getText());
	}

	public void verifyDayMonthYearInAreaPage(String day, String month, String year) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_began_date_info_text_xpath")).getText());
		}

		else if ((day.isEmpty()) && (month.isEmpty())) {
			assertEquals(year, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_began_date_info_text_xpath")).getText());
		}

		else if ((day.isEmpty())) {
			String getExpectedDate = month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_began_date_info_text_xpath")).getText());
		}

		else {
			String getExpectedDate = day + " " + month + " " + year;
			assertEquals(getExpectedDate, getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_began_date_info_text_xpath")).getText());
		}
	}

	/**
	 *
	 * This method is used to verify the Began Date value from Zeus DB
	 *
	 */
	public void verifyAreaBeganDateFromZeusDB(String country, String area, String tagName, String source, String day,
			String month, String year) {
		if ((day.isEmpty()) && (month.isEmpty()) && (year.isEmpty())) {
			assertEquals("", getAreaBasicInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty()) && (month.isEmpty())) {
			String expectedBeganDate = year;
			assertEquals(expectedBeganDate, getAreaBasicInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty())) {
			String expectedBeganDate = month + " " + year;
			assertEquals(expectedBeganDate, getAreaBasicInfoFromDB(country, area, tagName, source));
		} else {
			String setBeganDate = day + " " + month + " " + year;
			assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), setBeganDate);
		}
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
		try {
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,
					"get area Status types");
			for (int i = 1; i < document.getElementsByTagName("status").getLength(); i++) {
				assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),
						statusList.get(i).getAttribute("value"));
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * This method is to verify whether the successful message is generated
	 * after saving the area page.
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
		assertEquals(status,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_get_status_value_xpath")).getText());
	}

	/**
	 * This method is used to get the area information from DB
	 *
	 * @param country
	 * @param area
	 *            * @param tagName
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

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get areastatus",
				nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	public void verifyAreaStatusFromZeusDB(String country, String area, String tagName, String source, String status) {
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
	 *            will hold the value to be verified with area status drop-down
	 *            selection
	 */
	public void verifyAreaStatusInDropdown(String status) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(
				getSelectedDropdownValue(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_xpath"))
						.equalsIgnoreCase(status));
	}

	public void verifyAreaFromTrustedDB(String country, String area, String tagName, String source) {

		assertEquals((getAreaInfoFromDB(country, area, tagName, source)),
				getSelectedDropdownValue(AreaIdentifiers.getObjectIdentifier("area_status_identifier_dropdown_xpath")));

	}

	public void selectCountryValue(String country) throws InterruptedException {
		try {

			attemptClick(AreaIdentifiers.getObjectIdentifier("country_header_value_xpath"));
			List<WebElement> drpList = getDriver().findElements(
					AreaIdentifiers.getObjectIdentifier("country_places_country_dropDown_select_option_xpath"));
			for (int i = 0; i < drpList.size(); i++) {
				if (drpList.get(i).getText().equals(country)) {
					selectedCountryID = drpList.get(i).getAttribute("value");
					selectItemFromDropdownListByindex(
							AreaIdentifiers.getObjectIdentifier("country_places_country_dropDown_select_xpath"), i);
					break;
				}
			}
		} catch (Exception e) {

		}
		Thread.sleep(3000);// Time required for area parent dropdown to ReLoad

	}
	
	
	 public void textToBePresentInElement(WebElement element) {
	        try {
	            WebDriverWait wait = new WebDriverWait(getDriver(), 25);
	            wait.until(ExpectedConditions.textToBePresentInElement(element, "Required"));
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	        }
	    }

	public void selectAreaValue(String areaParent) throws InterruptedException {
		try {
			attemptClick(AreaIdentifiers.getObjectIdentifier("areaParent_currentValue_xpath"));
			List<WebElement> drpList = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("country_places_areas_option_dropdown_xpath"));
			for (int i = 0; i < drpList.size(); i++) {
				if (drpList.get(i).getText().equals(areaParent)) {
					selectedAreaID = drpList.get(i).getAttribute("value");
					selectItemFromDropdownListByindex(
							AreaIdentifiers.getObjectIdentifier("country_places_areas_dropdown_xpath"), i);
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	public void verifyHeaderDropDownValues(String country, String areaParent, String subArea)
			throws InterruptedException {
		Thread.sleep(2000);//wait time for Header drop down to reload
		assertEquals(country,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("country_current_value_xpath")).getText());
		assertEquals(areaParent,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_current_value_xpath")).getText());
		assertEquals(subArea,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("subarea_current_value_xpath")).getText());

	}

	public void checksAddressBarIsHavingNewCountryAreaIds(String country, String areaParent)
			throws InterruptedException {
		String [] urlPartitions = getDriver().getCurrentUrl().split("/");		
		String countryID = urlPartitions[6];
		String areaID = urlPartitions[7];
		assertEquals(countryID, selectedCountryID);
		assertEquals(areaID, selectedAreaID);
	}

	public void verifySubAreaInfoFromZeusDB(String country, String area, String subarea, String tagName, String source,
			String status) {
		assertEquals(getSubareaInfoFromDB(country, area, subarea, tagName, source), status);
	}

	public String getSubareaInfoFromDB(String country, String area, String subarea, String tagName, String source) {

		String tagValue = null;
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("subarea", subarea));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
				"get area basic info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	public void verifySubAreaDropdown(String subArea) throws InterruptedException {
		List<WebElement> list = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_List_value_xpath"));
		List<String> subarealist = new ArrayList<String>();
		int size = (getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_List_value_xpath")).size());
		for (int j = 0; j < size; j++) {
			subarealist.add((list.get(j)).getText());
		}
		assertFalse(subarealist.contains(subArea));
	}

	public void verifyParentAreaListInPlaceForCountry(String country) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("name", country));
		nvPairs.add(new BasicNameValuePair("source", "trusted"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list",
				nvPairs);
		if (getDriver().findElements(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
				.size() == 1) {
			assertTrue(getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
					.getText().isEmpty());
		}

		else {
			throw new AssertionError("Area parent List is not Empty");
		}
	}

	public void verifyChooseAnAreaOptionInAreaparent() throws InterruptedException {		
		assertEquals("Choose an Area",
				getDriver()
						.findElements(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
						.get(0).getText());
	}

	public void verifyAreaListInPlacesForCountry(String country) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("name", country));
		nvPairs.add(new BasicNameValuePair("source", "trusted"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list",
				nvPairs);
			for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
				assertEquals(document.getElementsByTagName("area").item(i).getTextContent(),
						getDriver()
								.findElements(
										AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
								.get(i).getText());
			}
		}


	public void userVerifyHeaderDropdownValuesDisabled() throws InterruptedException {
		assertFalse(
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("country_type_ahead_xpath")).isEnabled());
		assertFalse(getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_subarea_dropdown_typeAhead_xpath")).isEnabled());
		assertFalse(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_area_dropdown_typeAhead_xpath"))
				.isEnabled());
	}

	public void userVerifyCountryDropdownDefaultValue(String country) {

		assertEquals(country, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("country_default_value_dropdown_xpath")).getText());

	}

	public void verifyCountryListInPlacesForCountry() {
		List<WebElement> countryList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("country_places_country_dropDown_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
		for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
			assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(),
					countryList.get(i).getText().trim());
		}
	}

	public void verifyErrorMessageForRequiredAreaparentIdentifierType() throws InterruptedException {
		textToBePresentInElement(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_type_req_err_msg_xpath")));
		assertEquals("Required", getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_type_req_err_msg_xpath")).getText());
	}

	public void checksHeaderdropdownValue(String country1, String area) throws InterruptedException {
		Thread.sleep(2000);//wait for header dropdowns to reload
		assertEquals(country1,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("country_current_value_xpath")).getText());
		assertEquals(area,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_current_value_xpath")).getText());

	}

	public void verifyAreaInfoFromZeusDB(String country, String area, String tagName, String source, String status) throws InterruptedException {		

		assertEquals(getAreasInfoFromDB(country, area, tagName, source), status);
	}

	public String getAreasInfoFromDB(String country, String area, String tagName, String source) {

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
				"get area basic info", nvPairs);
		if (document != null) {
			tagValue = getNodeValuesByTagName(document, tagName).size() == 0 ? ""
					: getNodeValuesByTagName(document, tagName).get(0);
		}
		return tagValue;
	}

	public void userVerifyAreaParentDropdownDefaultValue(String area) {

		assertEquals(area,
				getDriver()
						.findElements(AreaIdentifiers.getObjectIdentifier("parent_area_default_value_dropdown_xpath"))
						.get(0).getText());

	}

	public void clickOnAreaDropdown() throws InterruptedException {
		attemptClick(AreaIdentifiers.getObjectIdentifier("areaParent_currentValue_xpath"));
	}

	public void verifyParentAreaDropdownDontHaveNoArea() {

		List<WebElement> list = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"));
		List<String> areaParentList = new ArrayList<String>();
		int size = (getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath")).size());
		for (int j = 0; j < size; j++) {
			areaParentList.add((list.get(j)).getText());
		}
		assertFalse(areaParentList.contains("NULL") || areaParentList.contains("No Area"));
	}
	
	public void verifyAreaListInPlaceForCountry(String Country) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("name", Country));
		nvPairs.add(new BasicNameValuePair("source", "trusted"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list",
				nvPairs);
		if (getDriver().findElements(AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
				.size() > 2) {
			for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
				assertEquals(document.getElementsByTagName("area").item(i).getTextContent(),
						getDriver()
								.findElements(
										AreaIdentifiers.getObjectIdentifier("country_places_areaparent_dropdown_xpath"))
								.get(i+1).getText());
			}
		}

	}

	@Override
	public String getPageUrl() {
		return null;
	}

}