package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
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
		
			List<String> lineItemType = new ArrayList<String>();
			/*List<String> historyEventDate = new ArrayList<String>();
			List<String> historyEventDescription = new ArrayList<String>();
			List<String> historyEventReplacedByCode = new ArrayList<String>();
			List<String> historyUsageName = new ArrayList<String>();
			List<String> historyUsageAddress = new ArrayList<String>();
			List<String> historyUsageCity = new ArrayList<String>();
			List<String> historyUsageArea = new ArrayList<String>();
			List<String> historyUsageSubArea = new ArrayList<String>();
			List<String> historyUsageCountry = new ArrayList<String>();
			List<String> historyUsagePostalCode = new ArrayList<String>();
			List<String> historyUsageAdditionalInfo = new ArrayList<String>();	*/	
			
			List<WebElement> lineItemRows = getDriver().findElements(FinancialsIdentifiers.getObjectIdentifier("view_financial_line_item_table"));
			System.out.println(lineItemRows.size());
			for (int index = 1; index < lineItemRows.size() ; index++) {
				List<WebElement> historyEventColumns = lineItemRows.get(index).findElements(By.tagName("td"));
				lineItemType.add(historyEventColumns.get(0).getText());
				System.out.println(historyEventColumns.get(0).getText());
				
			}
		}
  }
