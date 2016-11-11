package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.TaxonomiesIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminPage extends AbstractPage{

    private By taxonomies_listbox_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By taxonomies_tab_id = By.id("taxonomy-nav");
    private By choose_taxonomy_option_xpath = By.xpath("//*[@id='entitySelect_chosen']/a/span");
    private By taxonomy_input_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/div/input");
    private By taxonomy_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By taxonomy_label_xpath = By.xpath("//*[@id='selection']/fieldset/h1");
    private By no_results_match_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private String taxonomySearchString = "";
    private By taxonomies_table_headers_xpath = By.xpath("//table[1]/thead/tr");
    private String taxonomies_table_rows = "//table[1]/tbody/tr";
    private String taxonomies_table_cols = "//table[1]/thead//th";


    public AdminPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }


    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyTaxonomiesList(Database database, ApacheHttpClient apacheHttpClient) {
        assertEquals("TAXONOMIES", getDriver().findElement(taxonomy_label_xpath).getText());
        List<WebElement> retTaxonomiesListVal = getDriver().findElements(taxonomies_listbox_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"taxonomies list");
        for (int i = 0; i < document.getElementsByTagName("lookupName").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), retTaxonomiesListVal.get(i).getText().trim());
        }
    }

    public void clickOnTaxonomiesTab() {
        attemptClick(taxonomies_tab_id);
    }

    public void verifyChooseATaxonomyTextColor()
    {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDriver().findElement(choose_taxonomy_option_xpath).getCssValue("color"),"rgba(0, 0, 0, 1)");
    }

    public void clickOnChooseATaxonomy() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(choose_taxonomy_option_xpath).click();
    }

    public void enterTaxonomy(String taxonomy) {
        taxonomySearchString = taxonomy;
        getDriver().findElement(taxonomy_input_xpath).sendKeys(taxonomy);
    }

    public void verifyTaxonomyDropDownMatchesSearchString() {
        List<WebElement> taxonomyList = getDriver().findElements(taxonomy_list_xpath );
        for(int i=0; i<taxonomyList.size(); i++){
            assertTrue(taxonomyList.get(i).getText().toLowerCase().contains(taxonomySearchString.toLowerCase()));
        }
    }

    public void verifyNoResultsMatchOption() {
        assertEquals("No results match \"" + taxonomySearchString + "\"", getDriver().findElement(no_results_match_xpath).getText());
    }

    public void enterTaxonomyInTheTypeAheadBox(String taxonomy) {
        /*getDriver().findElement(taxonomy_input_xpath).sendKeys(taxonomy);
        getDriver().findElement(taxonomy_input_xpath).sendKeys(Keys.RETURN);*/
        List<WebElement> options = getDriver().findElements(By.xpath("//*[@id='entitySelect_chosen']/div//li"));
        for(WebElement option:options){
            if(option.getText().contains(taxonomy)){
                option.click();
                break;
            }
        }






    }

    public void verifyTaxonomiesEntry(ExamplesTable taxonomyEntry) {
        assertEquals(taxonomyEntry.getHeaders().toString().replace(",","").replace("[","").replace("]",""), getDriver().findElement(taxonomies_table_headers_xpath).getText());
        int rows = getDriver().findElements(By.xpath(taxonomies_table_rows)).size();
        int cols = getDriver().findElements(By.xpath(taxonomies_table_cols)).size();
        for(int i=1; i<rows+1; i++){
            for (int j=1; j<cols; j++){
                assertEquals(taxonomyEntry.getRow(i-1).get(taxonomyEntry.getHeaders().get(j-1)), getDriver().findElement(By.xpath(taxonomies_table_rows + "[" + i + "]" + "/td[" + j + "]")).getText());
                assertTrue(getDriver().findElement(By.xpath("//table[1]//tr[" + i + "]//button[1]")).isDisplayed());
                assertTrue(getDriver().findElement(By.xpath("//table[1]//tr[" + i + "]//button[2]")).isDisplayed());
            }
        }
    }
    
    public void verifySubGroupingInHierarchicalTaxonomy() {
    	List<WebElement> hierarchialTaxonomyList = getDriver().findElements(TaxonomiesIdentifiers.getObjectIdentifier("hierarchial_taxonomies_list"));    	
    	assertTrue(hierarchialTaxonomyList.get(0).isDisplayed());    	
    }
    
	public void verifyHierarchicalTaxonomyValuesFromTrustedDB(String taxonomy, String source) {
		try {			
			List<String> columnHeaderList = new ArrayList<String>();
			List<String> categoryList = new ArrayList<String>();
			List<String> taxonomySubGroupingRowValueList = new ArrayList<String>();
			List<WebElement> columnHeader = getDriver().findElements(TaxonomiesIdentifiers.getObjectIdentifier("taxonomies_column_header_list"));
			List<WebElement> categoryListValues = getDriver().findElements(TaxonomiesIdentifiers.getObjectIdentifier("hierarchical_taxonomies_row_values_list"));
			List<WebElement> taxonomySubGroupingRows = getDriver().findElements(TaxonomiesIdentifiers.getObjectIdentifier("hierarchical_taxonomy_sub_groupings_list"));
			Map<String, List<String>> taxonomyMapForUI = new HashMap<String, List<String>>();
			if (columnHeader.size() > 0) {
				for (int index = 0; index < columnHeader.size(); index++) {
					columnHeaderList.add(columnHeader.get(index).getText());
				}
				Collections.sort(columnHeaderList);
				taxonomyMapForUI.put("columnHeaderList", columnHeaderList);	
				List<String> levelCount = new ArrayList<String>();			 
				for (int index = 0; index<taxonomySubGroupingRows.size(); index++) {
					String level = taxonomySubGroupingRows.get(index).getAttribute("class").replace("level", "");
					if(!levelCount.contains(level)) {
						levelCount.add(level);
					}							
				}
				
				for (int index = 0; index < categoryListValues.size(); index++) {
					if( categoryListValues.get(index).getAttribute("class").isEmpty() ) {
						categoryList.add(categoryListValues.get(index).getText());
					}					
				}
				Collections.sort(categoryList);
				taxonomyMapForUI.put("categoryList", categoryList);	
				
				for (int index = 0; index < levelCount.size(); index++) {
					for (int innerIndex = 0; innerIndex < taxonomySubGroupingRows.size(); innerIndex++) {
						if (taxonomySubGroupingRows.get(innerIndex).getAttribute("class").equals("level" + levelCount.get(index))) {
							taxonomySubGroupingRowValueList.add(taxonomySubGroupingRows.get(innerIndex).getText());
						}
					}
					Collections.sort(taxonomySubGroupingRowValueList);
					taxonomyMapForUI.put("subCategory " + levelCount.get(index), taxonomySubGroupingRowValueList);	
					taxonomySubGroupingRowValueList = new ArrayList<String>();
				}				
				verifyHeirarchicalTaxonomyValuesFromDB(taxonomy, source, taxonomyMapForUI);
			} else {
				assertTrue("There is no existing values for " + taxonomy + " taxonomy", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void verifyHeirarchicalTaxonomyValuesFromDB(String taxonomy, String source, Map<String, List<String>>  taxonomyMapForUI) {			 
		try {
			
			List<String> columnHeaderList = new ArrayList<String>();
			List<String> categoryList = new ArrayList<String>();
			List<String> categorySubgroupList = new ArrayList<String>();
			Map<String, List<String>> taxonomyMapForDB = new HashMap<String, List<String>>();
			List<NameValuePair> nvPairs = new ArrayList<>();
			
			nvPairs.add(new BasicNameValuePair("taxonomy", taxonomy));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(2000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get hierarchial taxonomy sub-grouping values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("columnHeaders").item(0).getChildNodes()
						.getLength(); i++) {
					columnHeaderList.add(document.getElementsByTagName("columnHeaders").item(0).getChildNodes().item(i).getTextContent().toUpperCase());
				}	
				Collections.sort(columnHeaderList);
				taxonomyMapForDB.put("columnHeaderList", columnHeaderList);	
				
				List<String> levelCount = new ArrayList<String>();					
				NodeList nodeList = document.getElementsByTagName("subCategory");
				for (int index = 0; index<nodeList.getLength(); index++) {
					if(!levelCount.contains(nodeList.item(index).getAttributes().item(0).getNodeValue())) {
						levelCount.add(nodeList.item(index).getAttributes().item(0).getNodeValue());
					}							
				}				
				
				for(int index = 0; index < levelCount.size();index++) {
				 nodeList = document.getElementsByTagName("entryValues");				
					for (int innerIndex = 0; innerIndex<nodeList.getLength(); innerIndex++) {
						if(nodeList.item(innerIndex).getParentNode().getAttributes().getLength()>0) {
							if(levelCount.get(index).equals(nodeList.item(innerIndex).getParentNode().getAttributes().item(0).getNodeValue())) {
								String rowValue = "";
								for(int columIndex=0;columIndex<columnHeaderList.size();columIndex++) {
									if(!nodeList.item(innerIndex).getChildNodes().item(columIndex).getTextContent().isEmpty()) {
										rowValue = rowValue + nodeList.item(innerIndex).getChildNodes().item(columIndex).getTextContent() + " ";
									}									
								}
								categorySubgroupList.add(rowValue.trim());
							}	
						}
						else if(nodeList.item(innerIndex).getParentNode().getNodeName().equals("category")) {													
							if(index==0) {
								String rowValue = "";	
								for(int columIndex=0;columIndex<columnHeaderList.size();columIndex++) {
									if(!nodeList.item(innerIndex).getChildNodes().item(columIndex).getTextContent().isEmpty()) {
										rowValue = rowValue + nodeList.item(innerIndex).getChildNodes().item(columIndex).getTextContent() + " ";	
									}									
								}	
								categoryList.add(rowValue.trim());
							}
						}						
					}
					Collections.sort(categorySubgroupList);
					taxonomyMapForDB.put("subCategory " + levelCount.get(index), categorySubgroupList);
					categorySubgroupList = new ArrayList<String>();
				}
				Collections.sort(categoryList);
				taxonomyMapForDB.put("categoryList", categoryList);			
				assertEquals(taxonomyMapForDB, taxonomyMapForUI);				
			} else
				assertTrue(source + " document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
