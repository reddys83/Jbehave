package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.text.Format;


public class EditCityPage extends AbstractPage {

	public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	public void clearAndEnterValue(By webElement, String value) {
		getDriver().findElement(webElement).clear();
		getDriver().findElement(webElement).sendKeys(value);
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

	public void clearValue(By webElement) {
		getDriver().findElement(webElement).clear();
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
				month = month.substring(0, 3);
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
		for (WebElement monthWebelement : monthDropdown.getOptions()) {
			monthListInString.add(monthWebelement.getText());
		}

		assertTrue(monthInOrder.equals(monthListInString));
	}

	public void verifyGregorianCalendarFormat(String day, String month, String year) {
		String s = day + "/" + month + "/" + year;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		try {
			Date date = simpleDateFormat.parse(s);
			assertTrue(date!=null);
		} catch (Exception ex) {
			assertTrue(false);
		}
	}

	public void verifyDateIsBeforeToday(String day, String month, String year) throws ParseException {

		String enteredDate = day + "/" + month + "/" + year;
		SimpleDateFormat dateFormatObj = new SimpleDateFormat("dd/MMMM/yyyy");
		Date date = dateFormatObj.parse(enteredDate);
		Calendar cal = Calendar.getInstance();
		if (date.compareTo(dateFormatObj.parse(dateFormatObj.format(cal.getTime()))) > 0) {
			assertTrue(false);
		} else {
			assertTrue(true);
		}

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
		enterMonthInEndDate(month);
		enterYearInEndDate(Integer.toString(cal.get(Calendar.YEAR) + 1));		
	}

	public void clearBeganDate() {
		clearValue(CityIdentifiers.getObjectIdentifier("city_day_began_date_xpath"));
		enterMonthInBeganDate("");
		clearValue(CityIdentifiers.getObjectIdentifier("city_year_began_date_xpath"));
	}
	
	@Override
	public String getPageUrl() {
		return null;
	}

}
