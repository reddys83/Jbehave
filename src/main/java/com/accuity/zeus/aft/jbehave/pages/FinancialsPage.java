package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FinancialsPage extends AbstractPage {
	public FinancialsPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient,
			RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}

	@Override
	public String getPageUrl() {
		return null;
	}

	public void verifyMissingItemsFromTrusted(String fid, String source) {
		String reason;
		String alternateEntity;
		String alternateStatement;
		List<WebElement> missingItemRows = getDriver()
				.findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_missing_item_table"));
		List<WebElement> lineItemCols = missingItemRows.get(0).findElements(By.tagName("td"));
		reason = (lineItemCols.get(0).getText());
		alternateEntity = (lineItemCols.get(1).getText());
		alternateStatement = (lineItemCols.get(2).getText());
		verifyMissingItemsValuesFromDB(fid, source, reason, alternateEntity, alternateStatement);
	}

	public void verifyMissingItemsValuesFromDB(String fid, String source, String reason, String alternateEntity,
			String alternatestatement) {
		String missingItemsValue;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(5000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get missing items values", nvPairs);
			if (document != null) {
				for (int childNode = 0; childNode < document.getElementsByTagName("lineItems").item(0).getChildNodes()
						.item(0).getChildNodes().getLength(); childNode++) {
					missingItemsValue = document.getElementsByTagName("lineItems").item(0).getChildNodes().item(0)
							.getChildNodes().item(childNode).getTextContent();
					switch (document.getElementsByTagName("lineItems").item(0).getChildNodes().item(0).getChildNodes()
							.item(childNode).getNodeName()) {
					case "reason":
						assertEquals(missingItemsValue, reason);
						break;

					case "alternateEntity":
						assertEquals(missingItemsValue, (alternateEntity));
						break;

					case "statementType":
						assertTrue(alternatestatement.contains(missingItemsValue));
						break;
						
					case "periodEndDate":
						SimpleDateFormat actualMissingItemsValue = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat newMissingItemsValue = new SimpleDateFormat("yyyy MMM dd");
						Date date = actualMissingItemsValue.parse(missingItemsValue);
						String formattedMissinhItemValue = newMissingItemsValue.format(date);
						assertTrue(alternatestatement.contains(formattedMissinhItemValue));
						break;

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAlternateEntityLinkText() {
		return getDriver()
				.findElement(
						FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_entity_link_xpath"))
				.getText();
	}

	public String alternateStatementName() {
		return getDriver().findElement(FinancialsIdentifiers
				.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link_xpath")).getText();
	}

	public void verifyLegalEntityNameBasicInfoPage(String financialAlternateEntityName) {
		assertTrue(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("legalEntity_basicInfo_link"))
				.getAttribute("class").equals("selected"));
		assertTrue(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("legalEntity_basicInfo_label"))
				.getText().equals("BASIC INFO"));
		assertTrue(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("alternateEntity_text_value"))
				.getText().equals(financialAlternateEntityName));
	}

	public void verifyFinancialMissingPage(String financialAlternateStatementName,
			String financialAlternateEntityName) {
		assertTrue(getDriver().findElement(LegalEntityIdentifiers.getObjectIdentifier("LegalEntity_financials_link"))
				.getAttribute("class").equals("selected"));
		assertTrue(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("alternateEntity_text_value"))
				.getText().equals(financialAlternateEntityName));
		assertEquals((financialAlternateStatementName.substring(7, 19).toLowerCase().trim()),
				getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financial_missing_item_statement_header")).getText().toLowerCase().substring(0, 11));
	}
	
	public void clickPeriodEndDate(String date) {    	
    	List<WebElement> displayDates = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_endDate_leftSideMenu_xpath"));
    	for(int index = 0; index<displayDates.size(); index++) {
    		if (displayDates.get(index).getText().equals(date)) {
    			attemptClickTheWebElement(displayDates.get(index));
    		}
    	}
    }
	
	public void verifyFinancialsHeadingText(String periodEndDate) {
		try {
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String endDate = new String(new StringBuffer(periodEndDate.replace("-", " ")).append(" MISSING"));
			assertEquals(endDate, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_heading_xpath")).getText());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

  }
