package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    
    public void verifyFinancialsHeadingText(String periodEndDate) {
		try {
			Thread.sleep(3000L);
			String endDate = new String(new StringBuffer(periodEndDate).append(" FINANCIALS"));
			assertEquals(endDate, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_heading_xpath")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyFinancialsFieldValues(String fid, String periodEndDate) {		
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", "trusted"));
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("periodenddate", Utils.formatMonth(periodEndDate)));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get financial statement field values", nvPairs);
			
			Thread.sleep(2000L);
			String statementType = getNodeValuesByTagName(document, "statementType").size() == 0 ? "" : getNodeValuesByTagName(document, "statementType").get(0);
	        String periodStart = getNodeValuesByTagName(document, "periodStart").size() == 0 ? "" : getNodeValuesByTagName(document, "periodStart").get(0);
	        String periodEnd = getNodeValuesByTagName(document, "periodEnd").size() == 0 ? "" : getNodeValuesByTagName(document, "periodEnd").get(0);
	        String financialYearEnd = getNodeValuesByTagName(document, "financialYearEnd").size() == 0 ? "" : getNodeValuesByTagName(document, "financialYearEnd").get(0);
	        String currency =  getNodeValuesByTagName(document, "currency").size() == 0 ? "" : getNodeValuesByTagName(document, "currency").get(0);
	        String orderOfMagnitude = getNodeValuesByTagName(document, "orderOfMagnitude").size() == 0 ? "" : getNodeValuesByTagName(document, "orderOfMagnitude").get(0);
	        if(!orderOfMagnitude.isEmpty()) {
	        	orderOfMagnitude = Utils.getOrderOfMagnitude(orderOfMagnitude);	
	        }	        
	        String consolidated = getNodeValuesByTagName(document, "consolidated").size() == 0 ? "" : getNodeValuesByTagName(document, "consolidated").get(0);
	        String accountingStandards = getNodeValuesByTagName(document, "accountingStandards").size() == 0 ? "" : getNodeValuesByTagName(document, "accountingStandards").get(0);
	        String audited = getNodeValuesByTagName(document, "audited").size() == 0 ? "" : getNodeValuesByTagName(document, "audited").get(0);
	        String auditedBy = getNodeValuesByTagName(document, "auditedBy").size() == 0 ? "" : getNodeValuesByTagName(document, "auditedBy").get(0);
	        String documentPhysical =  getNodeValuesByTagName(document, "document").size() == 0 ? "" : getNodeValuesByTagName(document, "document").get(0);

	        assertEquals(statementType, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_statementType")).getText());
	        assertEquals(periodStart, Utils.formatMonth(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_startDate")).getText()));
	        assertEquals(periodEnd, Utils.formatMonth(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_endDate")).getText()));
	        assertEquals(financialYearEnd, Utils.formatMonth(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_yearEnd")).getText()));
	        assertEquals(currency, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_currency")).getText());
	        assertEquals(orderOfMagnitude, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_orderOfMagnitude")).getText());
	        assertEquals(consolidated, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_consolidated")).getText().toLowerCase());
	        assertEquals(accountingStandards, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_accountingStandards")).getText());
	        assertEquals(audited, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_audited")).getText().toLowerCase());
	        assertEquals(auditedBy, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_auditedBy")).getText());
	        assertEquals(documentPhysical, getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_documentPhysical")).getText());

	        if (getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_From")).size() > 0) {

	            for (int index = 0; index < getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_From")).size(); index++) {
	                assertEquals(currency, getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_From")).get(index).getText());
	            }
	        }

			if (getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_To")).size() > 0) {
				Map<String, String> exchangeRates = new HashMap<String, String>();
				for (int index = 0; index < getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_To")).size(); index++) {
					exchangeRates.put(getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_To")).get(index).getText(),
							getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_exchangeRate_Value")).get(index).getText());
				}

				NodeList exchangeRatesFromDB = document.getElementsByTagName("exchangeRate");
				for (int i = 0; i < exchangeRatesFromDB.getLength(); i++) {
					String currencyCode = exchangeRatesFromDB.item(i).getChildNodes().item(0).getTextContent();
					String exchangeRateValue = exchangeRatesFromDB.item(i).getChildNodes().item(1).getTextContent();
					assertTrue(exchangeRates.containsKey(currencyCode));
					assertEquals(exchangeRateValue, exchangeRates.get(currencyCode));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }

    public void verifyAuditedByField(){
        Boolean audited = new Boolean(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_audited")).getText().toLowerCase());
        String auditedBy = getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_financials_auditedBy")).getText();
        if(audited){
            assertNotEquals("", auditedBy);
        }else {
            assertEquals("", auditedBy);
        }
    }
    
	public void clickPeriodEndDateWithIndex(int dateIndex) { 
		Boolean flag = false;
		ArrayList<String> displayDatesInUI = getDisplayDates();
		assertTrue("There is no date with "+dateIndex+" in left navigation" , displayDatesInUI.size()>=dateIndex);
    	List<WebElement> displayDates = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_endDate_leftSideMenu_xpath"));
    	for(int index = 0; index < displayDates.size(); index++) {
    		if (displayDates.get(index).getText().equals(displayDatesInUI.get(dateIndex-1))) {
    			attemptClickTheWebElement(displayDates.get(index));
    			flag = true;
    		}
    	}
    	if(!flag) {
    		assertTrue("The date " + displayDatesInUI.get(dateIndex) + " is not available in the Financial page.", false);
    	}
    }
	
	public ArrayList<String> getDisplayDates() {		
		ArrayList<String> displayDatesListInUI = new ArrayList<String>();
    	List<WebElement> displayDates = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_endDate_leftSideMenu_xpath"));    	
    	for(int index = 0; index < displayDates.size(); index++) {    		
    		displayDatesListInUI.add(displayDates.get(index).getText());
    	} 
    	return displayDatesListInUI;
    }
	
	public void verifyMissingItemsFromTrusted(String fid,String displayDate, String source) {
		String reason;
		String alternateEntity;
		String alternateStatement;
		List<WebElement> missingItemRows = getDriver()
				.findElements(FinancialsIdentifiers.getObjectIdentifier("financial_missing_item_table"));
		List<WebElement> lineItemCols = missingItemRows.get(0).findElements(By.tagName("td"));
		reason = (lineItemCols.get(0).getText());
		alternateEntity = (lineItemCols.get(1).getText());
		alternateStatement = (lineItemCols.get(2).getText());
		verifyMissingItemsValuesFromDB(fid, displayDate, source, reason, alternateEntity, alternateStatement);
	}

	public void verifyMissingItemsValuesFromDB(String fid, String displayDate, String source, String reason, String alternateEntity,
			String alternatestatement) {
		String missingItemsValue;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("source", source));
			System.out.println(Utils.formatMonth(displayDate));
			nvPairs.add(new BasicNameValuePair("endDate", Utils.formatMonth(displayDate))); 
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
				.findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_entity_link")).getText();
	}

	public String alternateStatementName() {
		return getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link"))
				.getText();
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
		assertTrue(getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("alternateEntity_text_value"))
				.getText().equals(financialAlternateEntityName));
		String[] financialAlternateStatementDate = financialAlternateStatementName.split(",");
		assertTrue((getDriver().findElement(FinancialsIdentifiers.getObjectIdentifier("financial_missing_item_statement_header"))
						.getText().toUpperCase()).contains(financialAlternateStatementDate[1].toUpperCase().trim()));
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

	public void verifyFinancialMissingHeading(String periodEndDate) {
		try {
			Thread.sleep(3000L);
			String endDate = new String(new StringBuffer(periodEndDate).append(" MISSING"));
			assertEquals(endDate,getDriver().findElement(
							FinancialsIdentifiers.getObjectIdentifier("financial_missing_item_statement_header")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  }