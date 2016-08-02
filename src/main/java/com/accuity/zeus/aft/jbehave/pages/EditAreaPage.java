package com.accuity.zeus.aft.jbehave.pages;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.apache.commons.lang3.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;
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
	
   private static final String DISPLAY_NAME = "Display Name";
   private static final String FULL_NAME = "Full Name";
   public static String addInfoMaximumCharacterString=null;
   
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
		assertEquals(endDateErrorMsg, getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_enddate_errorMessage_xpath")).getText());
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
			String source)
	{

		List<WebElement> appliedMonthList = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_month_began_date_xpath"));
		String day = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_day_began_date_xpath")).getAttribute("value");

		if(StringUtils.isNotBlank(day) && StringUtils.length(day) < 2)
		{
			day = "0" + day;
		}

		String month =  new Select(appliedMonthList.get(0)).getFirstSelectedOption().getText();
		String year = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_year_began_date_xpath")).getAttribute("value");
		String beganDate = (day+month+year).replace(" ","");

		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source).replace(" ",""), beganDate);

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
		try {
			assertTrue(
					getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_save_confirmation_message_xpath"))
							.isDisplayed());
			Thread.sleep(5000); // to wait for page get refresh
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * This method is to enter the value in Area addInfo text field
	 *
	 * @param addInfoText
	 */
	public void enterTextAreaAddInfo(String addInfoText) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_add_info_text_xpath"), addInfoText);
	}

	/**
	 * This method is to verify the value in area addInfo text field to equal to
	 * expected.
	 *
	 * @param addInfoText
	 */
	public void verifyAreaTextInAddInfo(String addInfoText) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(addInfoText, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_xpath_after_save")).getText());
	}

	/**
	 * This method is to verify maximum characters entered in area additional
	 * info text box is 500
	 */
	

	public void enterInvalidCharactersInAreaAddInfo() {
		char addCharToAddInfo = 'a';
		String addInfoRandomText = null;
		for (int i = 0; i <= 500; i++) {
			addInfoRandomText += addCharToAddInfo;
		}
		getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_text_xpath")).clear();
		getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_text_xpath")).sendKeys(addInfoRandomText);
		addInfoMaximumCharacterString = addInfoRandomText;
	}

	public void viewValidCharacterLength() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Integer addInfoLength = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_xpath_after_save")).getText().length();
		assertEquals(addInfoLength.toString(), "500");
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

        String nameValuePath = null;
		
		if(FULL_NAME.equals(nameType)) {
			nameValuePath = "area_names_full_name_value_xpath";
		} else if(DISPLAY_NAME.equals(nameType)) {
			nameValuePath = "area_names_display_name_value_xpath";
		}
		
		assertEquals(cityNameValueMap.get(nameType),
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier(nameValuePath)).getAttribute("value"));

	}
	
	public void verifyAreaNameTypeFromLookup(String nameType) {
		List<String> names = getAreaNameTypesFromLookup();
		
		String nameTypePath = null;
		
		if(FULL_NAME.equals(nameType)) {
			nameTypePath = "area_names_full_name_type_xpath";
		} else if(DISPLAY_NAME.equals(nameType)) {
			nameTypePath = "area_names_display_name_type_xpath";
		}
		assertTrue(names.contains(
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier(nameTypePath)).getText()));

	}
	
	public void verifyFixedNameTypeNotEditable(String nameType) {
		
        String nameTypePath = null;		
		try {
			
			if(FULL_NAME.equals(nameType)) {
				nameTypePath = "area_names_full_name_type_parent";
			} else if(DISPLAY_NAME.equals(nameType)) {
				nameTypePath = "area_names_display_name_type_parent";
			}
			assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier(nameTypePath)).findElement(By.cssSelector("input")).getAttribute("name").contains("fixed"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void enterValueInNameField(String nameType, String value) {
        
		String nameValuePath = null;
		
		if(FULL_NAME.equals(nameType)) {
			nameValuePath = "area_names_full_name_value_xpath";
		} else if(DISPLAY_NAME.equals(nameType)) {
			nameValuePath = "area_names_display_name_value_xpath";
		}
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier(nameValuePath), value);
	}
	
	public void verifyUpdatedAreaNameInDB(String country, String area, String nameType, String source, String nameValue) {
		if(FULL_NAME.equals(nameType)) {
			area = nameValue;
		}			
		Map<String, String> cityNameValueMap = getAreaNameValueMapFromDB(country, area, source);
		assertEquals(cityNameValueMap.get(nameType), nameValue);
	}
	
	public void verifyTextInNameValue(String nameValue, String nameType) {
		
        String nameValuePath = null;
		
		if(FULL_NAME.equals(nameType)) {
			nameValuePath = "area_names_full_name_value_view_xpath";
		} else if(DISPLAY_NAME.equals(nameType)) {
			nameValuePath = "area_names_display_name_value_view_xpath";
		}
		assertEquals(nameValue, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier(nameValuePath)).getText());
	}
	
	public void clickOnAddNewNameButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_names_add_names_button_xpath"));
	}
	
	public void verifyNewRowAreaNameTypesList() {
		
		List<String> names = getAreaNameTypesFromLookup();
		
		List<String> newRowNameTypes = new ArrayList<String>();
		newRowNameTypes.add("");
		newRowNameTypes.addAll(names);
		newRowNameTypes.remove(FULL_NAME);
		newRowNameTypes.remove(DISPLAY_NAME);
		
		List<WebElement> areaNameTypesList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_name_type_input_xpath"));
		List<WebElement> options = areaNameTypesList.get(0).findElements(By.cssSelector("option"));
		for (int i = 0; i < options.size(); i++) {
            assertEquals(newRowNameTypes.get(i), 
            			 options.get(i).getText().trim());
        }
	}
	
	public void enterNameType(String nameType, int index) {
		try {
			if (nameType != null) {
				List<WebElement> identifierDropDowns = getDriver()
						.findElements(AreaIdentifiers.getObjectIdentifier("area_name_type_input_xpath"));
				Select dropdown = new Select(identifierDropDowns.get(index));
				if (nameType.equals("")) {
					dropdown.selectByValue(nameType);
				} else {
					dropdown.selectByVisibleText(nameType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterNameValue(String newNameValue) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_name_value_input_xpath"), newNameValue);
	}	
	
	public void verifyNameValueInEditMode(String nameType, String newNameValue) {
		try {
			Boolean nameTypeAndValueFound = false;			
			List<WebElement> dropDown = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_name_type_input_xpath"));
			List<WebElement> nameValues = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_name_value_input_xpath"));
			for (int i = 0; i < dropDown.size(); i++) {
				Select dropdown = new Select(dropDown.get(i));
				if (nameType.equals(dropdown.getFirstSelectedOption().getText()) && newNameValue.equals(nameValues.get(i).getAttribute("value"))) {
					nameTypeAndValueFound = true;	
					break;
				}				
			}	
			assertTrue(nameTypeAndValueFound);

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void verifyNameTypeAndValueInViewMode(String nameType, String nameValue) {
		try {
			WebElement areaNameTable = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_NameTable"));
			List<WebElement> areaNameRows = areaNameTable.findElements(By.tagName("tr"));
			Boolean nameValueFound = false;
			for (int i = 0; i < areaNameRows.size(); i++) {
				if(areaNameRows.get(i).getText().contains(nameType) && areaNameRows.get(i).getText().contains(nameValue)){				
					List<WebElement> areaNameRowsColumns = areaNameRows.get(i).findElements(By.tagName("td"));					
					if (areaNameRowsColumns.get(0).getText().equals(nameType) && areaNameRowsColumns.get(1).getText().equals(nameValue)) {				
						nameValueFound = true;
						break;
					}
				}				
			}
			assertTrue(nameValueFound);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	public void verifyNameTypeNotPresent(String nameType, String nameValue) {
		try {
			WebElement areaNameTable = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_NameTable"));
			List<WebElement> areaNameRows = areaNameTable.findElements(By.tagName("tr"));		
			Boolean nameNotFound = true;
			for (int i = 0; i < areaNameRows.size(); i++) {		
				if(areaNameRows.get(i).getText().contains(nameType) && areaNameRows.get(i).getText().contains(nameValue)){				
					List<WebElement> areaNameRowsColumns = areaNameRows.get(i).findElements(By.tagName("td"));					
					if (areaNameRowsColumns.get(0).getText().equals(nameType) && areaNameRowsColumns.get(1).getText().equals(nameValue)) {				
						nameNotFound = false;
					}
				}	
			}
			assertTrue(nameNotFound);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void verifyDuplicateNameTypeNotPresent(String nameType, String nameValue) {
		try {
			WebElement areaNameTable = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_NameTable"));
			List<WebElement> areaNameRows = areaNameTable.findElements(By.tagName("tr"));		
			int duplicateNameCount = 0;
			for (int i = 0; i < areaNameRows.size(); i++) {		
				if(areaNameRows.get(i).getText().contains(nameType) && areaNameRows.get(i).getText().contains(nameValue)){				
					List<WebElement> areaNameRowsColumns = areaNameRows.get(i).findElements(By.tagName("td"));					
					if (areaNameRowsColumns.get(0).getText().equals(nameType) && areaNameRowsColumns.get(1).getText().equals(nameValue)) {				
						duplicateNameCount ++;
					}
				}	
			}
			assertTrue(duplicateNameCount==1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	public void verifyAreaNameValueNotUpdatedInDB(String country, String area, String nameType, String source, String nameValue) {		
		Map<String, String> cityNameValueMap = getAreaNameValueMapFromDB(country, area, source);
		assertTrue(!cityNameValueMap.containsKey(nameType));
		assertTrue(!cityNameValueMap.values().contains(nameValue));
	}
	
	public void verifyErrorMessageRequiredForAreaNameType(String errorMessage) {
		assertEquals(errorMessage, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_name_type_error_msg_xpath")).getText());
	}
	
	public void verifyErrorMessageForRequiredAreaNameValue(String errorMessage) {
		assertEquals(errorMessage, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_name_value_error_msg_xpath")).getText());
	}
	
	public void clickOnDeleteNameRowButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_delete_name_row_button_xpath"));
	}
	
	public void checkDeleteRowButtonNotExist(String nameType) {
		try {
			String nameTypeParent = null;
			if(FULL_NAME.equals(nameType)) {
				nameTypeParent = "area_names_full_name_type_parent";
			} else if(DISPLAY_NAME.equals(nameType)) {
				nameTypeParent = "area_names_display_name_type_parent";
			}
			// First two columns for Type and value, delete button exist in 3rd column, if we verify only two columns exist in Full and Display name then delete button will not be present.
			assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier(nameTypeParent)).findElements(By.tagName("td")).size()==2);
			
		} catch(NoSuchElementException ex) {
			assertTrue("Delete Row button not present", true);
		}
	}
	
	public void deleteAllAreaNameRows() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_names_add_names_button_xpath"));
		List<WebElement> deleteRows = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_name_row_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_name_row_button_xpath"))
					.get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyDeleteConfirmationModalInAreaPage();
				pressEnterButtonInDeleteConfirmationModalForArea();
			}
		}
	}	
	
	public void verifyDeleteConfirmationModalInAreaPage() {
		 assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(AreaIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
	}
	
	public void enterSecondNameValue(String newNameValue) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_second_name_value_input_xpath"), newNameValue);
	}
	
	public Map<String, List<String>> getAreaNameMultipleValueMapFromDB(String country, String area, String source) {
		Map<String, List<String>> cityNameMap = new HashMap<String, List<String>>();
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
				if(cityNameMap.containsKey(childNodeList.item(0).getTextContent())) {
					List<String> values = cityNameMap.get(childNodeList.item(0).getTextContent());
					values.add(childNodeList.item(1).getTextContent());
					cityNameMap.put(childNodeList.item(0).getTextContent(), values);
				} else {
					List<String> values = new ArrayList<String>();
					values.add(childNodeList.item(1).getTextContent());
					cityNameMap.put(childNodeList.item(0).getTextContent(), values);
				}
				
			}
		}
		return cityNameMap;
	}
	
	public void verifyUpdatedMultipleAreaNamesInDB(String country, String area, String nameType, String source, String nameValue, String nameValue2) {
		Map<String, List<String>> cityNameValueMap = getAreaNameMultipleValueMapFromDB(country, area, source);
		assertTrue(cityNameValueMap.get(nameType).contains(nameValue));
		assertTrue(cityNameValueMap.get(nameType).contains(nameValue));
	}

	/**
	 * This method is to verify maximum characters entered in area additional
	 * info text box is 500
	 */
	public void verifyMaximumChracterEnteredInAddInfo() {
		assertEquals(addInfoMaximumCharacterString.subSequence(0, 500), getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_xpath_after_save")).getText());
	}

	public void verifyAreaAddInfoValueFromTrusted(String country, String area, String tagName, String source) {
		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source),
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_add_info_text_xpath")).getText());
	}

	public void verifyAreaAddInfoValueFromZeus(String country, String area, String tagName, String source,
			String addInfoText) {
		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), addInfoText);
	}
	
	public void clickOnAreaAddNewIdentifierButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_add_new_identifier_button_id"));
	}

	public void verifyAreaIdentifierTypesList() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get area identifiers");
		List<WebElement> areaIdentifierTypesList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("areaIdentifier_type_id"));

		List<WebElement> options = areaIdentifierTypesList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 1; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption).getText().trim());
		}
	}

	public void verifyAreaIdentifierStatusList() {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get area Status types");
		List<WebElement> areaIdentifierStatusList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_status_input_xpath"));

		List<WebElement> options = areaIdentifierStatusList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 0; indexOfOption < document.getElementsByTagName("status")
				.getLength(); indexOfOption++) {
			assertEquals(StringUtils.capitalize(
					document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent()),
					options.get(indexOfOption + 1).getText().trim());
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getFirstChild().getTextContent(),
					options.get(indexOfOption + 1).getAttribute("value").trim());
		}
	}

	public void deleteAllAreaIdentifierRows() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_add_new_identifier_button_id"));
		List<WebElement> deleteRows = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_identifiers_row_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_identifiers_row_button_xpath"))
					.get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyAreaIdentifierRowDeleteConfirmationModal();
				pressEnterButtonInDeleteConfirmationModalForArea();
			}
		}
	}

	public void verifyAreaIdentifierRowDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES",
				getDriver().findElement(
						AreaIdentifiers.getObjectIdentifier("delete_area_identifier_row_confirmation_modal_xpath"))
						.getText());
	}

	public void pressEnterButtonInDeleteConfirmationModalForArea() {
		getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_delete_yes_button_id")).sendKeys(Keys.ENTER);
	} 

	public void enterAreaIdentifierType(String identifierType, int rowNo) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_type_input_xpath"));
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

	public void enterAreaIdentifierValue(String identifierValue, int rowNo) {
		try {
			List<WebElement> identifierValues = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_value_input_xpath"));
			if (rowNo <= identifierValues.size()) {
				identifierValues.get(rowNo - 1).clear();
				identifierValues.get(rowNo - 1).sendKeys(identifierValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAreaIdentifierStatus(String identifierStatus, int rowNo) {
		try {
			List<WebElement> identifierDropDowns = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_status_input_xpath"));
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

	public void verifyAreaIdentifierValuesFromDB(String country, String area, List<String> identifierType,
			List<String> identifierValue, List<String> identifierStatus, String source) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("country", country));
			nvPairs.add(new BasicNameValuePair("area", area));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get area basic info", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("identifiers").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("identifiers").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						switch (document.getElementsByTagName("identifiers").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "identifierType":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierType.get(i));
							break;
						case "identifierValue":
							assertEquals(document.getElementsByTagName("identifiers").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), identifierValue.get(i));
							break;
						case "identifierStatus":
							assertEquals(
									StringUtils.capitalize(document.getElementsByTagName("identifiers").item(0)
											.getChildNodes().item(i).getChildNodes().item(childNode).getTextContent()),
									identifierStatus.get(i));
							break;
						}
					}
				}
			} else
				assertTrue(source+ "document is null",false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnDeleteNewAreaIdentifierRowButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_delete_identifiers_row_button_xpath"));
	}

	public void verifyDeleteConfirmationModal() {
		assertEquals("Please confirm - would you like to delete this row? NO YES",
				getDriver().findElement(
						AreaIdentifiers.getObjectIdentifier("delete_area_identifier_row_confirmation_modal_xpath"))
						.getText());
	}

	public void verifyNewlyAddedAreaIdentifierRowIsNotDisplayed() {
		try {
			WebElement identifier = getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_AdditionalIdentifiers"));
			assertTrue(identifier == null);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	public void verifyAreaIdentifierValuesFromTrustedDB(String country, String area, String source) {
		try {
			attemptClick(AreaIdentifiers.getObjectIdentifier("area_add_new_identifier_button_id"));
			List<String> identifierTypes = new ArrayList<>();
			List<String> identifierValues = new ArrayList<>();
			List<String> identifierStatusValues = new ArrayList<>();
			List<WebElement> identifierTypeDropDowns = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_type_input_xpath"));
			
			if (identifierTypeDropDowns.size() > 0) {
				List<WebElement> identifierValueDropDowns = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_value_input_xpath"));
				List<WebElement> identifierStatusDropDowns = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_status_input_xpath"));
				
				for (int index = 0; index < identifierTypeDropDowns.size(); index++) {					
					identifierTypes.add(new Select(identifierTypeDropDowns.get(index)).getAllSelectedOptions().get(0).getText());
					identifierValues.add(identifierValueDropDowns.get(index).getAttribute("value"));
					identifierStatusValues.add(new Select(identifierStatusDropDowns.get(index)).getAllSelectedOptions().get(0).getText());
				}
				
				verifyAreaIdentifierValuesFromDB(country, area, identifierTypes, identifierValues,
						identifierStatusValues, source);
			} else {
				assertTrue("There is no existing values in Identifier section", true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMaxLengthInAreaIdentifierValue(String maxLength) {
		assertEquals(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_value_input_xpath"))
				.getAttribute("maxlength"), maxLength);
	}

	public void verifyErrorMessageForRequiredAreaIdentifierValue(String errMsg) {
		assertEquals(errMsg, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_value_req_err_msg_xpath")).getText());
	}

	public void verifyErrorMessageForRequiredAreaIdentifierStatus(String errMsg) {
		assertEquals(errMsg,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_status_req_err_msg_xpath"))
						.getText());
	}

	public void verifyNewlyAddedAreaIdentifierRowIsDisplayed() {
		WebElement identifier = getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_type_input_xpath"));
		assertTrue(identifier != null);
	}

	public void pressNoButtonInDeleteConfirmationModalForArea() {
		getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_delete_no_button_id_click")).click();
	}

	public void verifyIdentifierRowNotPresentInZeusDB(String country, String area, String source) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("country", country));
			nvPairs.add(new BasicNameValuePair("area", area));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get area basic info", nvPairs);
			if (document != null) {
				assertNull(document.getElementsByTagName("identifierType").item(0));
				assertNull(document.getElementsByTagName("identifierValue").item(0));
				assertNull(document.getElementsByTagName("identifierStatus").item(0));
			} else
				assert false : source + " document is null";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyErrorMessageForRequiredAreaIdentifierType(String errMsg) {
		assertEquals(errMsg, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_type_req_err_msg_xpath")).getText());
	}

	public void verifyAreaIdentifierParametersInUI(String[] identifierTypes, String[] identifierValues,
			String[] identifierStatusValues) {
		
		List<WebElement> identifierRows = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_type_view_mode"));
		
		for (int i = 0; i < identifierRows.size(); i++) {
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(0).getText().contains(identifierTypes[i]));
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(1).getText().contains(identifierValues[i]));
			assertTrue(identifierRows.get(i).findElements(By.tagName("td")).get(2).getText().contains(identifierStatusValues[i]));
		}
	}

	public void verifySelectedIdentifierTypeNotInNewRow(String identifierType, int rowNo) {
		try {
			List<WebElement> identifierDropDowns = getDriver().findElements(AreaIdentifiers.getObjectIdentifier("area_identifier_type_input_xpath"));
			if (rowNo <= identifierDropDowns.size()) {
				Select dropdown = new Select(identifierDropDowns.get(rowNo - 1));
				for (int index = 0; index < dropdown.getOptions().size(); index++) {
					assertTrue(!dropdown.getOptions().get(index).getText().contains(identifierType));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyNewlyAddedAreaIdentifierRowExists() {
		try
		{
			WebElement identifier = getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_identifier_type_view_mode"));
			assertTrue(identifier != null);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void verifyTimeZoneDropdownListMatchesWithLookup() throws InterruptedException {
		List<WebElement> timeZoneList = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_timezone_utc_dropDown_xpath"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "get utc list");
		attemptClick(AreaIdentifiers.getObjectIdentifier("timezone_utc_default_value_xpath"));
		if (timeZoneList != null) {
			assertTrue("time zone values are empty",document.getElementsByTagName("utcid").getLength() >= 1);
			for (int i = 1; i < document.getElementsByTagName("utcid").getLength(); i++) {
				assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(),
						timeZoneList.get(i).getText().trim());
			}
		} else {
			assertTrue("timezone list is not displayed", false);
		}
	}

	public void userVerifyTimeZoneDropDownDefaultValueFromTrusted(String country, String area, String tagName,
			String source) {
		assertEquals(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("timezone_utc_current_value_xpath"))
				.getText(), getAreaBasicInfoFromDB(country, area, tagName, source));

	}

	public void userVerifyAddTimeZoneIsDisplayed() {
		assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("timezone_utc_add_timezone_xpath"))
				.isDisplayed());
	}

	public void userVerifyTimeZoneDropdownIsDisplayed() {
		assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("timezone_utc_dropdown_xpath"))
				.isDisplayed());
	}

	public void userClickOnAddNewTimeZoneButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("timezone_utc_add_timezone_xpath"));
	}

	public void userVerifiesTimeZoneDefaultValueIsBlank() {
		assertTrue((getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("timezone_utc_default_value_addrows_xpath")).getText())
						.isEmpty());
	}

	public void verifyTimeZoneDropDownIsNotHavingSelectedTimeZone(String timeZone) {

		List<WebElement> subAreaChoices = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_timezone_utc_dropDown_new_xpath"));
		List<String> selectedOptions = new ArrayList<String>();
		for (int j = 0; j < subAreaChoices.size(); j++) {
			selectedOptions.add((subAreaChoices.get(j)).getText());
		}
		assertFalse(selectedOptions.contains(timeZone));
	}

	public void userEntersSummaryValue(String summary) {
		clearAndEnterValue(AreaIdentifiers.getObjectIdentifier("area_summary_timezone_xpath"), summary);
	}

	public void clickOnDeleteAreaTimeZoneRowButton() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_delete_timezone_row_button_xpath"));
	}

	public void verifyNewlyAddedAreaTimeZoneRowIsDisplayed() {
		assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_timezone_input_xpath"))
				.isDisplayed());
	}

	public void verifyNewlyAddedAreaTimeZoneRowExists() {
		try {
			WebElement timeZone = getDriver()
					.findElement(AreaIdentifiers.getObjectIdentifier("area_timezone_type_view_mode"));
			assertTrue(timeZone != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNewlyAddedAreaTimeZoneRowIsNotDisplayed() {
		try {
			assertFalse(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_timezone_input_xpath"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

	public void verifyAreaTimeZoneValuesFromDB(String country, String area, String tagName, String source,
			String timeZone) {
		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), timeZone);
	}
	
	public void verifyAreaSummaryValuesFromZeusDB(String country, String area, String tagName, String source,
			String summary) {
		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), summary);
	}
	
	public void verifySummaryFieldLimitInZeusDB(String country, String area, String tagName, String source, int maxLength) {
		assertEquals((getAreaBasicInfoFromDB(country, area, tagName, source).length()), maxLength);
	}

	public void verifyAreaSummaryValueInUI(String summary) throws InterruptedException {
		assertEquals(summary, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("summary_current_value_viewmode_xpath")).getText());
	}

	public void verifyAreasTimeZoneValueInUI(String timeZone) throws InterruptedException {
		assertEquals(timeZone,
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("utc_current_value_xpath")).getText());
	}

	public void verifyAreasTimeZoneValuesFromZeusDB(String country, String area, String tagName, String source,
			String timeZone) {
		assertEquals(getAreaBasicInfoFromDB(country, area, tagName, source), timeZone);
	}
	
	public void verifyAreasTimeZoneValueNotUpdatedInUI() throws InterruptedException {
		try {
			assertFalse(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("utc_current_value_xpath"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

	public void verifyAreasTimeZoneValueNotUpdatedInZeusDB(String country, String area, String tagName, String source) {
		assertTrue((getAreaBasicInfoFromDB(country, area, tagName, source).isEmpty()));
	}

	public void verifyAreasTimeZoneSummaryMaxLenghtAttribute(String maxLength) {
		assertEquals((getDriver().findElement(AreaIdentifiers.getObjectIdentifier("summary_current_value_xpath"))
				.getAttribute("maxlength")), maxLength);
	}

	public void verifySummaryFieldLimit(int maxLength) throws InterruptedException {
		assertEquals(
				getDriver().findElement(AreaIdentifiers.getObjectIdentifier("summary_current_value_viewmode_xpath"))
						.getText().length(),
				maxLength);
	}

	public void clickOnTimeZoneDropDown() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("utc_current_value_xpath"));
	}

	public void verifyAreaTimeZoneRowValueNotPresentInZeusDB(String country, String area, String tagName,
			String source) {
		assertTrue(getAreaBasicInfoFromDB(country, area, tagName, source).isEmpty());
	}

	public void userSelectsTimeZoneDropDownValue(String timeZoneType, int rowNo) {
		try {
			List<WebElement> timeZoneDropDowns = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("timezone_utc_default_value_xpath"));
			if (rowNo <= timeZoneDropDowns.size()) {
				Select dropdown = new Select(timeZoneDropDowns.get(rowNo - 1));
				if (timeZoneType.equals("")) {
					dropdown.selectByValue(timeZoneType);
				} else {
					dropdown.selectByVisibleText(timeZoneType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void verifyAreaTimeZoneValuesInUI(String[] timeZoneValues) {

		List<WebElement> timeZoneRows = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("timezone_row_value_viewmode_xpath"));

		for (int i = 0; i < timeZoneRows.size(); i++) {
			assertTrue(timeZoneRows.get(i).findElements(By.tagName("td")).get(0).getText().contains(timeZoneValues[i]));
		}
	}
	
	public void verifyDeleteConfirmationModals() {
		assertEquals("Please confirm - would you like to delete this row? NO YES",
				getDriver().findElement(
						AreaIdentifiers.getObjectIdentifier("delete_area_timezone_row_confirmation_modal_xpath"))
						.getText());
	}
	
	public void verifyAreasTimeZoneValuesFromDB(String country, String area, List<String> timeZoneValues,
			String source) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("country", country));
			nvPairs.add(new BasicNameValuePair("area", area));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get area basic info", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("timezoneutc").item(0).getChildNodes()
						.getLength(); i++) {
					for (int childNode = 0; childNode < document.getElementsByTagName("timezoneutc").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {
						assertEquals(document.getElementsByTagName("timezoneutc").item(0).getChildNodes().item(i)
								.getChildNodes().item(childNode).getTextContent(), timeZoneValues.get(i));
					}
				}
			} else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllAreaTimeZoneRows() {
		attemptClick(AreaIdentifiers.getObjectIdentifier("area_timezone_add_names_button_xpath"));
		List<WebElement> deleteRows = getDriver()
				.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_timezone_row_button_xpath"));

		for (int index = 0; index < deleteRows.size(); index++) {
			WebElement currentInstance = getDriver()
					.findElements(AreaIdentifiers.getObjectIdentifier("area_delete_timezone_row_button_xpath"))
					.get(0);
			if (currentInstance != null) {
				currentInstance.click();
				verifyDeleteConfirmationModalInAreaPage();
				pressEnterButtonInDeleteConfirmationModalForArea();
			}
		}
	}		
	
	@Override
	public String getPageUrl() {
		return null;
	}

}