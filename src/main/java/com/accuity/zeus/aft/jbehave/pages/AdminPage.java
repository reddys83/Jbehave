package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.DataManagementAppVals;
import com.accuity.zeus.aft.commons.Utils;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminPage extends AbstractPage{

    private By taxonomies_listbox_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By taxonomies_tab_id = By.id("taxonomy-nav");
    private By choose_taxonomy_option_xpath = By.xpath("//*[@id='entitySelect_chosen']/a/span");
    private By taxonomy_input_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/div/input");
    private By taxonomy_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By taxonomy_label_xpath = By.xpath("//*[@id='selection']/dl/dt");
    private By no_results_match_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private String taxonomySearchString = "";
    private By taxonomies_table_headers_xpath = By.xpath("//table[1]/thead/tr");
    private String taxonomies_table_rows = "//table[1]/tbody/tr";
    private String taxonomies_table_cols = "//table[1]/thead//th";

    public AdminPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }


    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyTaxonomiesList() {
        assertEquals("TAXONOMIES", getDriver().findElement(taxonomy_label_xpath).getText());
        List<WebElement> retTaxonomiesListVal = getDriver().findElements(taxonomies_listbox_xpath);
        assertTrue(DataManagementAppVals.expTaxonomiesListVal.size() == retTaxonomiesListVal.size());
        for (int i = 0; i <=DataManagementAppVals.expTaxonomiesListVal.size()-1; i++) {
            if (retTaxonomiesListVal.get(i).getText().equals(DataManagementAppVals.expTaxonomiesListVal.get(i))) {
                continue;
            }
            else {
                System.out.println("The returned taxonomies list has the value " + retTaxonomiesListVal.get(i) + " but the expected taxonomy list has the value " + DataManagementAppVals.expTaxonomiesListVal.get(i));
                assertTrue(false);
                break;
            }
        }
    }

    public void clickOnTaxonomiesTab() {
        attemptClick(taxonomies_tab_id);
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

    public void verifyNoDuplicatesInList() {
        Utils utils = new Utils();
        List<String> retTaxonomiesListVal = new ArrayList<>();
        for (Iterator<WebElement> it = getDriver().findElements(taxonomies_listbox_xpath).iterator(); it.hasNext();){
            retTaxonomiesListVal.add(it.next().getText());
        }
        assertTrue(utils.findDuplicates(retTaxonomiesListVal).size() == 0);
    }

    public void enterTaxonomyInTheTypeAheadBox(String taxonomy) {
        getDriver().findElement(taxonomy_input_xpath).sendKeys(taxonomy);
        getDriver().findElement(taxonomy_input_xpath).sendKeys(Keys.RETURN);
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
}
