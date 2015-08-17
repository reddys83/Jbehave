package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.DataManagementAppVals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminPage extends AbstractPage{

    private By taxonomies_listbox_id = By.id("taxonomy_chosen");
    private By taxonomies_tab_xpath = By.xpath("//*[@id='admin-navbar']/ul/li");
    private By choose_taxonomy_option_xpath = By.xpath("//*[@id='taxonomy_chosen']/a/span");
    private By taxonomy_input_xpath = By.xpath("//*[@id='taxonomy_chosen']/div/div/input");
    private By taxonomy_list_xpath = By.xpath("//*[@id='taxonomy_chosen']/div/ul/li");
    private By taxonomy_label_xpath = By.xpath("//*[@id='admin']/fieldset/label");
    private By no_results_match_xpath = By.xpath("//*[@id='taxonomy_chosen']/div/ul/li");
    private String taxonomySearchString = "";

    public AdminPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyTaxonomiesList() {
        assertEquals("TAXONOMIES:",getDriver().findElement(taxonomy_label_xpath).getText());
        List<String> retTaxonomiesListVal = new ArrayList<>(Arrays.asList(getDriver().findElement(taxonomies_listbox_id).getText().split("\n")));
        assertTrue(DataManagementAppVals.expTaxonomiesListVal.size() == retTaxonomiesListVal.size());
        for (int i = 0; i <=DataManagementAppVals.expTaxonomiesListVal.size()-1; i++) {
            if (retTaxonomiesListVal.get(i).equals(DataManagementAppVals.expTaxonomiesListVal.get(i))) {
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
        attemptClick(taxonomies_tab_xpath);
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
}
