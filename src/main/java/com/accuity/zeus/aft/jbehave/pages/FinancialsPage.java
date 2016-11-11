package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
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
   
    public void verifyMissingItemsFromTrusted(String fid, String source) {
    	String reason;
		String alternateEntity;
		String alternatestatement;
		List<WebElement> missingItemRows = getDriver()
				.findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_missing_item_table"));
       
			List<WebElement> lineItemCols = missingItemRows.get(0).findElements(By.tagName("td"));
			reason=(lineItemCols.get(0).getText());
			alternateEntity=(lineItemCols.get(1).getText());
			alternatestatement=(lineItemCols.get(2).getText());
			verifyMissingItemsValuesFromDB(fid, source, reason, alternateEntity, alternatestatement);

    }
    
    public void verifyMissingItemsValuesFromDB(String fid,String source,String reason,String alternateEntity,String  alternatestatement) {
    	String missingItemsValue;
    	try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", fid));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(5000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get missing items values", nvPairs);
			if (document != null) {
				for (int childNode = 0; childNode < document.getElementsByTagName("lineItems").item(0)
						.getChildNodes().item(0).getChildNodes().getLength(); childNode++) {
					missingItemsValue = document.getElementsByTagName("lineItems").item(0).getChildNodes().item(0)
							.getChildNodes().item(childNode).getTextContent();
					switch (document.getElementsByTagName("lineItems").item(0).getChildNodes().item(0)
							.getChildNodes().item(childNode).getNodeName()) {
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
						assertTrue(alternatestatement.contains(missingItemsValue));
						break;
	
						}
			}
    	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void clickOnFinancialStatement(String financialStatementDate) {
		List<WebElement> periodEndDate = getDriver().findElements(
				FinancialsIdentifiers.getObjectIdentifier("financialStatement_period_EndDate_leftSideMenu_xpath"));
		for (int i = 0; i < periodEndDate.size(); i++) {
			if (financialStatementDate.equals(periodEndDate.get(i).getText())) {
				periodEndDate.get(i).click();
			}
		}
	}
	
  }
