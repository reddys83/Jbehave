package com.accuity.zeus.aft.jbehave.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.AreaIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

public class EditAreaPage extends AbstractPage {

	public EditAreaPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}


	public void verifyAreaEndDateFromTrustedDB(String country, String area, String tagName,
			String source) {

		List<WebElement> appliedMonthList = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_month_end_date_xpath"));
		String day = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_day_end_date_xpath")).getAttribute("value");

		if(StringUtils.isNotBlank(day) && StringUtils.length(day) < 2) {
			day = "0" + day;
		}

		String month =  new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_year_end_date_xpath")).getAttribute("value");
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
	public void verifyAreaEndDateFromZeusDB(String country, String area, String tagName, String source,
			String day, String month, String year) {
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


	public void verifyAreaBeganDateFromTrustedDB(String country, String area, String tagName,
			String source) {

		List<WebElement> appliedMonthList = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_month_began_date_xpath"));
		String day = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_day_began_date_xpath")).getAttribute("value");

		if(StringUtils.isNotBlank(day) && StringUtils.length(day) < 2) {
			day = "0" + day;
		}

		String month =  new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_year_began_date_xpath")).getAttribute("value");
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
	public void verifyAreaBeganDateFromZeusDB(String country, String area, String tagName, String source,
			String day, String month, String year) {
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
	
	public Map<String, String> getAreaNameValueMapFromDB(String country, String area, String source) {
		Map<String, String> cityNameMap = new HashMap<String, String>();
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("country", country));
		nvPairs.add(new BasicNameValuePair("area", area));
		nvPairs.add(new BasicNameValuePair("source", source));
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get area basic info", nvPairs);
		if (document != null) {
			NodeList nodeList = document.getElementsByTagName("name");
			for(int index = 0; index < nodeList.getLength(); index++)  {
				NodeList childNodeList = nodeList.item(index).getChildNodes();
				cityNameMap.put(childNodeList.item(0).getTextContent(), childNodeList.item(1).getTextContent());
			}
		}
		return cityNameMap;
	}
	
	public List<String> getAreaNameTypesFromLookup() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<String> nameTypes = new ArrayList<String>();

		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get area name types");
		if (document != null) {
			NodeList nodeList = document.getElementsByTagName("type");
			for(int index = 0; index < nodeList.getLength(); index++)  {
				NodeList childNodeList = nodeList.item(index).getChildNodes();
				nameTypes.add(childNodeList.item(0).getTextContent());
			}
		}
		return nameTypes;
	}
	
	public void verifyAreaNameFromTrustedDB(String country, String area, String nameType, String source) {
		Map<String, String> cityNameValueMap = getAreaNameValueMapFromDB(country, area, source);

		assertEquals(cityNameValueMap.get(nameType),
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_names_full_name_value_xpath")).getAttribute("value"));

	}
	
	public void verifyAreaNameTypeFromLookup(String nameType) {
		List<String> names = getAreaNameTypesFromLookup();
		assertTrue(names.contains(
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_names_full_name_type_xpath")).getText()));

	}
	
	public void verifyFixedNameTypeNotEditable(String nameType) {
		try {
			getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_names_full_name_type_xpath")).findElement(By.cssSelector("input"));
		} catch(NoSuchElementException ex) {
			assertTrue("Full Name is not editable", true);
		}
	}
	
	public void enterValueInNameField(String nameType, String value) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_names_full_name_value_xpath"), value);
	}
	
	public void verifyUpdatedAreaNameInDB(String country, String area, String nameType, String source, String nameValue) {
		Map<String, String> cityNameValueMap = getAreaNameValueMapFromDB(country, area, source);
		assertEquals(cityNameValueMap.get(nameType), nameValue);
	}
	
	public void verifyTextInNameValue(String nameValue, String nameType) {
		assertEquals(nameValue, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_names_full_name_value_view_xpath")).getText());
	}

	@Override
	public String getPageUrl() {
		return null;
	}

}