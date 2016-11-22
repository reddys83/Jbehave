package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.accuity.zeus.aft.commons.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tubatil on 10/31/2016.
 */
public class FinancialsPage extends AbstractPage{
    public FinancialsPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyLegalEntityFinancialStatements(String fid) {
        ArrayList<String> periodEndDateFromDB= new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> periodEndDate = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_EndDate_leftSideMenu_xpath"));



        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legalEntity financialStatements periodEndDate", nvPairs);
        for (int j=0;j<document.getElementsByTagName("periodEnd").getLength();j++)
        {
            periodEndDateFromDB.add(document.getElementsByTagName("periodEnd").item(j).getTextContent());
        }
     if(periodEndDateFromDB.size()>=1) {
         assertEquals(periodEndDateFromDB.get(0), getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_default_selected_endDate_xpath")).getText());
     }
        for (int i = 0; i < periodEndDate.size(); i++) {
            assertEquals(document.getElementsByTagName("periodEnd").item(i).getTextContent(), periodEndDate.get(i).getText());
            }
    }
    
	public void verifyLineItemsFromTrusted(String periodEndDate, String fid, String source) {
		try {
			List<String> lineItemType = new ArrayList<String>();
			List<String> lineItemCalculated = new ArrayList<String>();
			List<String> lineItemValue = new ArrayList<String>();
			List<String> lineItemNormalized = new ArrayList<String>();
			List<String> lineItemNotes = new ArrayList<String>();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<WebElement> lineItemRows = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_line_item_table"));
			for (int index = 0; index < lineItemRows.size(); index++) {
				List<WebElement> lineItemCols = lineItemRows.get(index).findElements(By.tagName("td"));
				lineItemType.add(lineItemCols.get(0).getText());
				lineItemCalculated.add(lineItemCols.get(1).getText());
				lineItemValue.add(lineItemCols.get(2).getText());
				lineItemNormalized.add(lineItemCols.get(3).getText());
				lineItemNotes.add(lineItemCols.get(4).getText());
			}
			verifyLineItemsValuesFromDB(periodEndDate, fid, source, lineItemType, lineItemCalculated, lineItemValue,
					lineItemNormalized, lineItemNotes);
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	public void verifyLineItemsValuesFromDB(String periodEndDate, String fid, String source, List<String> lineItemType,
			List<String> lineItemCalculated, List<String> lineItemValue, List<String> lineItemNormalized,
			List<String> lineItemNotes) {
		String lineItemsValue;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("source", "trusted"));
			nvPairs.add(new BasicNameValuePair("periodEndDate", Utils.formatMonth(periodEndDate)));
			Thread.sleep(1000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get line items values", nvPairs);
			if (document != null) {
				NodeList nodeList = document.getElementsByTagName("items");
				for (int i = 0; i < nodeList.getLength(); i++) {
					NodeList childNodeList = nodeList.item(i).getChildNodes();
					for (int childNode = 0; childNode < childNodeList.getLength(); childNode++) {
						lineItemsValue = childNodeList.item(childNode).getTextContent().trim();
						switch (childNodeList.item(childNode).getNodeName()) {
						case "typeName":
							assertTrue(lineItemType.contains(lineItemsValue));
							break;
						case "calculated":
							assertTrue(lineItemCalculated.contains(StringUtils.capitalize(lineItemsValue)));
							break;
						case "normalizedValue":
							assertTrue(lineItemNormalized.contains(lineItemsValue));
							break;
						case "value":
							assertTrue(lineItemValue.contains(lineItemsValue));
							break;
						case "notes":
							assertTrue(lineItemNotes.contains(lineItemsValue.replaceAll("\\s{2,}", " ")));
							break;
						}
					}
				}
			} else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickPeriodEndDate(String date) {
		Boolean flag = false;
		List<WebElement> displayDates = getDriver().findElements(
				FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_endDate_leftSideMenu_xpath"));
		for (int index = 0; index < displayDates.size(); index++) {
			if (displayDates.get(index).getText().equals(date)) {
				attemptClickTheWebElement(displayDates.get(index));
				flag = true;
			}
		}
		if (!flag) {
			assertTrue("The date " + date + " is not available in the Financial page.", false);
		}
	}

	public void verifyLineItemsSort() {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			Thread.sleep(3000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get line items type lookup Values", nvPairs);
			if (document != null) {
				List<String> lineItemLookup = new ArrayList<String>();
				List<String> lineItemFromUi = new ArrayList<String>();
				for (int indexDb = 0; indexDb < document.getElementsByTagName("lineItem").getLength(); indexDb++) {
					lineItemLookup.add(document.getElementsByTagName("lineItem").item(indexDb).getTextContent());
				}
				List<WebElement> lineItemRows = getDriver()
						.findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_line_item_table"));
				for (int indexUI = 0; indexUI < lineItemRows.size(); indexUI++) {
					List<WebElement> lineItemCols = lineItemRows.get(indexUI).findElements(By.tagName("td"));
					lineItemFromUi.add(lineItemCols.get(0).getText());
				}
				int tempIndex = 1;
				for (int count = 0; count < lineItemFromUi.size(); count++) {
					if (tempIndex == lineItemFromUi.size()) {
						if ((lineItemLookup.indexOf(lineItemFromUi.get(tempIndex - 1))) < lineItemLookup.indexOf(lineItemFromUi.get(count - 1))) {
							assertTrue("Line Items Type is not sorted in order: " + "Line No : "	+ lineItemFromUi.get(tempIndex - 1) + "Value :" + lineItemFromUi.get(tempIndex - 1),
									false);
						}
					} else {
						if ((lineItemLookup.indexOf(lineItemFromUi.get(tempIndex))) < lineItemLookup.indexOf(lineItemFromUi.get(count))) {
							assertTrue("Line Items Type is not sorted in order :"
									+ lineItemLookup.indexOf(lineItemFromUi.get(count)) + "Line No : "
									+ lineItemFromUi.get(tempIndex - 1) + "Value : "
									+ lineItemFromUi.get(tempIndex - 1), false);
						}
						tempIndex++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
