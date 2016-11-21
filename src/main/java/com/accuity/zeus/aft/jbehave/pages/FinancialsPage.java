package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

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
    
	public void verifyLineItemsFromTrusted(String fid, String source) {
try{
		List<String> lineItemType = new ArrayList<String>();
		List<String> lineItemCalculated = new ArrayList<String>();
		List<String> lineItemValue = new ArrayList<String>();
		List<String> lineItemNormalized = new ArrayList<String>();
		List<String> lineItemNotes = new ArrayList<String>();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> lineItemRows = getDriver()
				.findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_line_item_table"));
		System.out.println(lineItemRows.size());
		for (int index = 0; index < lineItemRows.size(); index++) {
			List<WebElement> lineItemCols = lineItemRows.get(index).findElements(By.tagName("td"));
			lineItemType.add(lineItemCols.get(0).getText());
			lineItemCalculated.add(lineItemCols.get(1).getText());
			lineItemValue.add(lineItemCols.get(2).getText());
			lineItemNormalized.add(lineItemCols.get(3).getText());
			lineItemNotes.add(lineItemCols.get(4).getText());
		}
		verifyLineItemsValuesFromDB(fid, source, lineItemType, lineItemCalculated, lineItemValue, lineItemNormalized,
				lineItemNotes);
}
catch (StaleElementReferenceException e){
	e.printStackTrace();
}
	
	}
    
	public void verifyLineItemsValuesFromDB(String fid, String source, List<String> lineItemType,
			List<String> lineItemCalculated, List<String> lineItemValue, List<String> lineItemNormalized,
			List<String> lineItemNotes) {
		String lineItemsValue;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(5000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get line items values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("lineItems").item(0).getChildNodes()
						.getLength(); i++) {
					for (int childNode = 0; childNode < document.getElementsByTagName("lineItems").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {
						lineItemsValue = document.getElementsByTagName("lineItems").item(0).getChildNodes().item(i)
								.getChildNodes().item(childNode).getTextContent().trim();
						switch (document.getElementsByTagName("lineItems").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "typeName":
							assertEquals(lineItemsValue, lineItemType.get(i));
							break;
						case "calculated":
							assertEquals(lineItemsValue, (lineItemCalculated.get(i).toLowerCase()));
							break;
						case "normalizedValue":
							assertEquals(lineItemsValue, (lineItemNormalized.get(i)));
							break;
						case "value":
							assertEquals(lineItemsValue, (lineItemValue.get(i)));
							break;
						case "notes":
							assertEquals(lineItemsValue.replaceAll("\\s{2,}", " "), lineItemNotes.get(i));
							;
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

	public void verifyLineItemsSort(){
		
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			Thread.sleep(5000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get line items type lookup Values", nvPairs);
			if (document != null) {
				//System.out.println("length");
				//System.out.println(document.getElementsByTagName("lineItem").getLength());
				List<String> lineItemLookup = new ArrayList<String>();
				List<String> lineItemFromUi = new ArrayList<String>();
				for (int i = 0; i < document.getElementsByTagName("lineItem").getLength(); i++) {
					lineItemLookup.add(document.getElementsByTagName("lineItem").item(i).getTextContent());
				}
				
				List<WebElement> lineItemRows = getDriver()
						.findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_line_item_table"));
				System.out.println(lineItemRows.size());
				for (int index = 0; index < lineItemRows.size(); index++) {
					List<WebElement> lineItemCols = lineItemRows.get(index).findElements(By.tagName("td"));
					lineItemFromUi.add(lineItemCols.get(0).getText());
				}
				
				System.out.println(document.getElementsByTagName("lineItem").getLength());
				//compare
				for(String temp: lineItemLookup ){
				
					if((lineItemFromUi.contains(temp))){
						for(int i=1;i<=lineItemFromUi.size();i++){
							for(int x=0;i<lineItemFromUi.size();x++){
								//int firstIndexUiInLookUp=lineItemLookup.indexOf(lineItemFromUi.get(0));
								System.out.println(x);
								System.out.println(i);
								System.out.println("**************");
								System.out.println((lineItemLookup.indexOf(lineItemFromUi.get(x))));
								System.out.println(lineItemLookup.indexOf(lineItemFromUi.get(i)));
								System.out.println();
								System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
								System.out.println(lineItemFromUi.get(x));
								System.out.println(lineItemLookup.get(x));
								System.out.println("%%%%%%%%%%%%%%%%%");
								if((lineItemLookup.indexOf(lineItemFromUi.get(x)))>lineItemLookup.indexOf(lineItemFromUi.get(i))){
									System.out.println("Failure");
									System.out.println(lineItemFromUi.get(i));
								}
							}
							
						}
						
					}
				}
				
				
				//System.out.println(lineItemFromUi.get(0));
				
				
				
				}
			}
		
	 catch(Exception e){
		 e.printStackTrace();
	 }
  }
}
