package com.accuity.zeus.aft.jbehave.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
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

		assertEquals(getAreaInfoFromDB(country, area, tagName, source), beganDate);

	}
	

	/**
	 * This method is to verify the specified value 'valueToBeVerified' is
	 * present in specified 'source' DB
	 * 
	 * @param country
	 * @param area
	 * @param tagName
	 * @param source
	 * @param valueTobeverifed
	 */
	public void verifyAreaInfoFromDB(String country, String area, String tagName, String source,
			String valueTobeverifed) {
		assertEquals(getAreaInfoFromDB(country, area, tagName, source), valueTobeverifed);
	}

	/**
	 * This method is used to get the city information from DB
	 * 
	 * @param country
	 * @param area
	 * @param tagName
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
				.findElements(AreaIdentifiers.getObjectIdentifier("area_month_began_date_xpath"));

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
	
	public void verifyErrorMessageBeganDate(String beganDateErrorMsg) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(beganDateErrorMsg, getDriver()
				.findElement(AreaIdentifiers.getObjectIdentifier("area_begandate_errorMessage_xpath")).getText());
	}
	
	/**
	 * This method is to verify whether the successful message is generated
	 * after saving the city page.
	 */
	public void verifySuccessfulUpdatedMessage() {
		assertTrue(getDriver().findElement(AreaIdentifiers.getObjectIdentifier("area_save_confirmation_message_id"))
				.isDisplayed());
	}
	
	public void verifyDayMonthYearInCityPage(String day, String month, String year) {
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
			assertEquals("", getAreaInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty()) && (month.isEmpty())) {
			String expectedBeganDate = year;
			assertEquals(expectedBeganDate, getAreaInfoFromDB(country, area, tagName, source));
		} else if ((day.isEmpty())) {
			String expectedBeganDate = month + " " + year;
			assertEquals(expectedBeganDate, getAreaInfoFromDB(country, area, tagName, source));
		} else {
			String setBeganDate = day + " " + month + " " + year;
			assertEquals(getAreaInfoFromDB(country, area, tagName, source), setBeganDate);
		}

	}
	

	@Override
	public String getPageUrl() {
		return null;
	}

}