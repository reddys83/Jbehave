package com.accuity.zeus.aft.result;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.pages.AbstractPage;
import com.accuity.zeus.aft.jbehave.pages.LegalEntityPage;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ResultsPage extends AbstractPage {

    private static final String PAGE_URI = "/#results";
    private String entity;
    private String field;
    private String value;
    int totalCount = 0;
    public static String lastNavigationPage;
    private List<ResultsListItem> resultsList = null;
    private String pagesNavigationListElements = "//*[@id='pages-navigation-list']";
    private By num_results_value_selector_xpath = By.xpath("//*[@id='content']/div //header/p/span[@class='counter']");
    private By results_selector_xpath = By.xpath(".//*[@id='search-results-list']/section/ol/li");
    private By no_results_text_css = By.cssSelector(".subheader>p");
    private By pagination_info_xpath = By.xpath(".//*[@id='pagination-info']");
    private By pages_navigation_list_locator_xpath = By.xpath(pagesNavigationListElements + "/li");
    private By currentSearchResultsPage = By.xpath("//span[contains(@class,'pages-navigation-link-current')]");
    private By next_page_link_locator_xpath = By.xpath("//span[contains(@class,'pages-navigation-link-next')]");
    private By previous_page_link_locator_xpath = By.xpath("//span[contains(@class,' pages-navigation-link-previous')]");
    private By fid_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[1]/dd");
    private By fid_label_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[1]/dt");
    private By tfpid_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[2]/dd");
    private By tfpid_label_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[2]/dt");
    private By name_locator_xpath = By.xpath("//*[@id='search-results-items']/li/div/h3");
    private By address_locator_xpath = By.xpath("//*[@id='search-results-items']/li/div/p");
    private By status_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[3]/dd");
    private By status_label_locator_xpath = By.xpath("//*[@id='search-results-items']/li/dl[3]/dt");

    private By office_search_results_table_head_xpath = By.xpath("//*[@id='subEntityList-list']//thead//tr");
    private By office_label_xpath = By.xpath("//*[@id='subEntityList-summary']//h1/span");
    private By office_id_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[1]");
    private By office_name_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[2]");
    private By office_address_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[3]");
    private By office_city_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[4]");
    private By office_area_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[5]");
    private By office_country_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[6]");
    private By office_type_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[7]");
    private By office_status_locator_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr/td[8]");

    private By legalEntity_search_results_xpath = By.xpath("//*[@id='search-results-items']/li");
    private By office_total_search_results_count_xpath = By.xpath("//*[@class='search-results-module']//span[3]");
    private By office_current_page_search_results_count_xpath = By.xpath("//*[@id='subEntityList-list']//tbody/tr");
    private By office_search_results_current_page_xpath = By.className("current-page");
    private By office_header_counter_xpath = By.xpath("//*[@id='subEntityList-header']//p");
    private By office_footer_counter_xpath = By.xpath("//*[@id='subEntityList-footer']//p");
    private By office_search_results_last_page_xpath = By.xpath("//*[@id='pages-navigation-list']/li[8]");
    private By office_search_results_navigation_xpath = By.xpath("//*[@id='pages-navigation-list']");
    private By office_search_results_next_page_classname = By.className("next-page");
    private By office_search_results_previous_page_classname = By.className("previous-page");
    private By office_search_results_column_name_xpath = By.xpath(".//*[@id='content'][@class='data-content']//thead//th[@id='name']");

    private By office_search_results_column_fid_xpath = By.xpath("//tr/th[@id='fid']");
    private By office_search_current_page_xpath = By.xpath("//li[contains(@class,'current-page')]");
    private String office_search_results_select_officeByFid_xpath = ".//a[contains(text(),'";
    String office_search_results_select_officeTypes_xpath = ".//*[@class='subEntityList-container']//table//tbody//tr[td='";
    private By office_type_default_filter_all_xpath = By.xpath("//*[@id='isForeign-all'][@class='selected']");
    private By office_type_filter_domestic_id = By.id("isForeign-false");
    private By office_type_filter_domestic_selected_xpath = By.xpath("//*[@id='isForeign-false'][@class='selected']");
    private By office_type_filter_foreign_id = By.id("isForeign-true");
    private By office_type_filter_foreign_selected_xpath = By.xpath("//*[@id='isForeign-true'][@class='selected']");
    private By office_search_results_status_xpath = By.xpath("//tr/th[@id='status']");
    private By office_search_results_type_xpath = By.xpath("//tr/th[@id='type']");
    private By office_search_results_status_col_xpath = By.xpath("//tr/td[8]");

    private By office_search_results_0_results_xpath = By.xpath("//*[@class='search-results-module']/div/p");
    private String office_search_results_per_page_id = "count-";
    private By office_search_deault_results_per_page_id = By.id("count-25");
    private By office_search_results_header_xpath = By.xpath("//*[@id='subEntityList-summary']/div/div/div/p/span[2]");
    private By office_search_results_displayed_body_xpath = By.xpath("//*[@id='content']/div/ul/li");
    private int resultsDisplayed = 25;
    private By office_status_filter_active_id = By.id("status-active");
    private By office_status_filter_inactive_id = By.id("status-inactive");
    private By office_status_filter_active_selected_xpath = By.xpath("//*[@id='status-active'][@class='selected']");
    private By office_status_filter_inactive_selected_xpath = By.xpath("//*[@id='status-inactive'][@class='selected']");
    private By office_status_filter_all_selected_xpath = By.xpath("//*[@id='status-all'][@class='selected']");
    private By office_type_headoffice_id = By.id("type-Head_Office");
    private By office_results_list_container_id = By.id("subEntityList-list");

    public ResultsPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    public ResultsPage(WebDriver driver, String urlPrefix, String entity, String field, String value) {
        this(driver, urlPrefix);
        this.entity = entity;
        this.field = field;
        this.value = value;
    }

    @Override
    public String getPageUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getUrlPrefix());
        sb.append(PAGE_URI);
        sb.append("/").append(entity);
        sb.append("/").append(field);
        sb.append("/").append(value);
        return sb.toString();
    }

    public WebElement getNumResultsValue() {
        return getDriver().findElement(num_results_value_selector_xpath);
    }

    public WebElement getNoResults() {
        return getDriver().findElement(no_results_text_css);
    }

    public WebElement getPaginationInfo() {
        return getDriver().findElement(pagination_info_xpath);
    }

    public List<ResultsListItem> getResultsList() {
        if (resultsList == null) {
            resultsList = createResultsItemList();
        }
        return resultsList;
    }

    public List<WebElement> getPagesNavigationList() {
        return getDriver().findElements(pages_navigation_list_locator_xpath);
    }

    public WebElement getPagesNavigation() {
        return getDriver().findElement(By.xpath(pagesNavigationListElements));
    }

    public List<ResultsListItem> createResultsItemList() {
        List<ResultsListItem> tempResults = new LinkedList<ResultsListItem>();
        List<WebElement> webElements = getDriver().findElements(results_selector_xpath);
        if (webElements != null && webElements.size() > 0) {
            for (WebElement webElement : webElements) {
                tempResults.add(new ResultsListItem(webElement));
            }
            return tempResults;
        } else {
            // The following provides a webElement to access the no results disclaimer
            webElements = getDriver().findElements(contentLocator);
            if (webElements != null && webElements.size() > 0) {
                for (WebElement webElement : webElements) {
                    tempResults.add(new ResultsListItem(webElement));
                }
                return tempResults;
            }
        }
        return Collections.emptyList();
    }

    public WebElement getResultCardElement(String value) {
        List<ResultsListItem> resultList = getResultsList();
        for (ResultsListItem resultListItem : resultList) {
            if (resultListItem.getResultListItem().getText().equals(value.toString())) {
                return resultListItem.getResultListItem();
            }
        }
        return null;
    }

    public WebElement getLastNavigationPage() {
        String lastNavigationListItem = Integer.toString(getPagesNavigationList().size() - 1);
        WebElement lastNavigationElement = getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + lastNavigationListItem + "]/span"));
        return lastNavigationElement;
    }

    public WebElement goToLastSearchResultsPage() {
        lastNavigationPage = getLastNavigationPage().getText();
        return getLastNavigationPage();
    }

    public WebElement navigateToDesiredSearchResultsPage(String page) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + page + "]"));
    }

    public WebElement getCurrentSearchResultsPage() {
        return getDriver().findElement(currentSearchResultsPage);
    }

    public WebElement getNextPageLink() {
        return getDriver().findElement(next_page_link_locator_xpath);
    }

    public WebElement getPreviousPageLink() {
        return getDriver().findElement(previous_page_link_locator_xpath);
    }

    public LegalEntityPage clickOnResultCard(WebElement element) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
        return new LegalEntityPage(getDriver(), getUrlPrefix());
    }

    public WebElement getFidElements(String fid) {
        List<WebElement> elements = getDriver().findElements(fid_locator_xpath);
        for (WebElement element : elements) {
            if (element.getText().equals(fid.toString())) {
                return element;
            }
        }
        return null;
    }

    public void verifySearchResults() {
        getDriver().findElement(legalEntity_search_results_xpath).isDisplayed();
    }

    public void verifyLegalEntitySearchResultsCards(ExamplesTable legalEntitySearchResults) {
        for (int i = 0; i < legalEntitySearchResults.getRowCount(); i++) {
            assertEquals("FID:", getDriver().findElements(fid_label_locator_xpath).get(i).getText());
            assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(0)), getDriver().findElements(fid_locator_xpath).get(i).getText());
            assertEquals("TFPID:", getDriver().findElements(tfpid_label_locator_xpath).get(i).getText());
            assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(1)), getDriver().findElements(tfpid_locator_xpath).get(i).getText());
            assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(2)), getDriver().findElements(name_locator_xpath).get(i).getText());
            assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(3)), getDriver().findElements(address_locator_xpath).get(i).getText());
            assertEquals("STATUS:", getDriver().findElements(status_label_locator_xpath).get(i).getText());
            assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(4)), getDriver().findElements(status_locator_xpath).get(i).getText());
        }
    }

    public void clickOnColumnFid() {
        attemptClick(office_search_results_column_fid_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyOfficeSearchResults(ExamplesTable officeSearchResults) {
        verifyOfficeHeading();
        verifyOfficeSearchResultsColumn();
        for (int i = 0; i < officeSearchResults.getRowCount(); i++) {
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(0)), getDriver().findElements(office_id_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(1)), getDriver().findElements(office_name_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(2)), getDriver().findElements(office_address_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(3)), getDriver().findElements(office_city_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(4)), getDriver().findElements(office_area_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(5)), getDriver().findElements(office_country_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(6)), getDriver().findElements(office_type_locator_xpath).get(i).getText());
            assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(7)), getDriver().findElements(office_status_locator_xpath).get(i).getText());
        }
    }

    public void verifyOfficeSearchResultsColumn() {
        assertEquals("FID NAME ADDRESS CITY AREA COUNTRY TYPE STATUS", getDriver().findElement(office_search_results_table_head_xpath).getText());
    }

    public void verifyOfficeHeading() {
        assertEquals("OFFICES", getDriver().findElement(office_label_xpath).getText());
    }

    public void verifyOfficeSearchResultsIsPaginated() {

        if (Integer.parseInt(officeTotalResultsCount()) <= resultsDisplayed) {
            assertEquals(officeTotalResultsCount(), Integer.toString(getOfficeResultsCountInCurrentPage().size()));
        } else {
            navigateToOfficeLastSearchResultsPage();
            assertEquals(officeTotalResultsCount(), getOfficeResultsCountTillCurrentPage());
        }
    }

    public String officeTotalResultsCount() {
        return getDriver().findElements(office_total_search_results_count_xpath).get(1).getText();
    }

    public List<WebElement> getOfficeResultsCountInCurrentPage() {
        return getDriver().findElements(office_current_page_search_results_count_xpath);
    }

    public String getOfficeSearchResultsLastNavigationPage() {
        String lastNavigationListItem = Integer.toString(getPagesNavigationList().size() - 1);
        return getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + lastNavigationListItem + "]")).getText();
    }

    public String getOfficeSearchResultsCurrentPage() {
        return getDriver().findElement(office_search_results_current_page_xpath).getText();
    }

    public void verifyOfficeSearchResultsCounter() {
        if (Integer.parseInt(officeTotalResultsCount()) <= resultsDisplayed) {
            if (Integer.parseInt(officeTotalResultsCount()) == 1) {
                assertEquals("1", Integer.toString(getOfficeResultsCountInCurrentPage().size()));
                assertEquals("1 to 1 of 1 result", getDriver().findElement(office_header_counter_xpath).getText());
                assertEquals("1 to 1 of 1 result", getDriver().findElement(office_footer_counter_xpath).getText());
            } else {
                assertEquals("1 to " + Integer.toString(getOfficeResultsCountInCurrentPage().size()) + " of " + Integer.toString(getOfficeResultsCountInCurrentPage().size()) + " results", getDriver().findElement(office_header_counter_xpath).getText());
                assertEquals("1 to " + Integer.toString(getOfficeResultsCountInCurrentPage().size()) + " of " + Integer.toString(getOfficeResultsCountInCurrentPage().size()) + " results", getDriver().findElement(office_footer_counter_xpath).getText());
            }
        } else {
            navigateToOfficeLastSearchResultsPage();
            assertEquals(officeTotalResultsCount(), getOfficeResultsCountTillCurrentPage());
        }
    }

    public String getOfficeResultsCountTillCurrentPage() {
       return Integer.toString(
                getOfficeResultsCountInCurrentPage().size() + ((
                        Integer.parseInt(getDriver().findElement(office_search_results_current_page_xpath).getText()) - 1) * resultsDisplayed));
    }

    public void navigateToOfficeLastSearchResultsPage() {
        attemptClick(office_search_results_last_page_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifySearchResultsNavigation() {
        if (Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) > 7) {
            if (Integer.parseInt(getOfficeSearchResultsCurrentPage()) <= 4) {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), "Previous 1 2 3 4 5 ... " + getOfficeSearchResultsLastNavigationPage() + " Next");
            } else if (Integer.parseInt(getOfficeSearchResultsCurrentPage()) > 5
                    && Integer.parseInt(getOfficeSearchResultsCurrentPage()) < (Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 3)) {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), "Previous 1 ... " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsCurrentPage()) - 1) + " " +
                        getOfficeSearchResultsCurrentPage() + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsCurrentPage()) + 1) + " ... " +
                        getOfficeSearchResultsLastNavigationPage() + " Next");
            } else {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), "Previous 1 ... " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 4) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 3) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 2) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 1) + " " +
                        getOfficeSearchResultsLastNavigationPage() + " Next");
            }
        } else {
            assertTrue(getDriver().findElement(office_search_results_navigation_xpath).getText().contains("Previous"));
            assertTrue(getDriver().findElement(office_search_results_navigation_xpath).getText().contains("Next"));
            for (int i = 1; i <= Integer.parseInt(getOfficeSearchResultsLastNavigationPage()); i++) {
                assertTrue(getDriver().findElement(office_search_results_navigation_xpath).getText().contains(Integer.toString(i)));
            }
        }
    }

    public void verifyCurrentPageOnSearchResults(String page) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_search_current_page_xpath).getText().contains(page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")));
    }

    public void navigateThroughSearchResults(String page) {
        if (page.equals("last")) {
            navigateToOfficeLastSearchResultsPage();
        } else {
            navigateToDesiredSearchResultsPage(Integer.toString(Integer.parseInt(page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")) + 1)).click();
        }
    }

    public void navigateToNextOfficeSearchResultsPage() {
        attemptClick(office_search_results_next_page_classname);
    }

    public void navigateToPreviousOfficeSearchResultsPage() {
        attemptClick(office_search_results_previous_page_classname);
    }


    public void clickOnColumnName() {
        attemptClick(office_search_results_column_name_xpath);
    }

    public void rightClicksOnOfficeID(String officeFid) {
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath(office_search_results_select_officeByFid_xpath + officeFid + "')]"));
        action.moveToElement(element);
        // Right click and select the option ' Open in new window'
        action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        // Switch to new window
        for (String Handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(Handle);
        }
    }

    public void verifySortOrderByOfficeFid(Database database, ApacheHttpClient apacheHttpClient, String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, xQueryName, "fid", searchedEntity);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyDefaultOfficeTypeFilterIsAll() {
        assertTrue(getDriver().findElement(office_type_default_filter_all_xpath).isDisplayed());
    }

    public void selectOfficeTypeFilterDomestic() {
        attemptClick(office_type_filter_domestic_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrderByOfficeType(Database database, ApacheHttpClient apacheHttpClient, String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> typeList = getDriver().findElements(office_type_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, xQueryName, "fid", searchedEntity);
        for (int i=0; i< typeList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), typeList.get(i).getText());
        }
    }

    public void verifySortOrderByOfficeName(Database database, ApacheHttpClient apacheHttpClient, String xQueryName, String fid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> nameList = getDriver().findElements(office_name_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, xQueryName, "fid", fid);
        for (int i=0; i< nameList.size();i++) {
            try {
                assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), nameList.get(i).getText());
            } catch (NullPointerException e) {
                String nullNameList = nameList.get(i).getText();
                nullNameList = null;
            }
        }
    }

    public void clickOnOfficeSearchResultsStatus() {
        attemptClick(office_search_results_status_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnOfficesSearchResultsType() {
        attemptClick(office_search_results_type_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyOfficeSearchResultIsResetToPage1() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("1", getOfficeSearchResultsCurrentPage());
    }

    public void verifyOfficeIsSortedAscByStatus(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> status = getDriver().findElements(office_search_results_status_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "ascending order by office status", "fid", searchedEntity);
        for (int i = 0; i < status.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), status.get(i).getText());
        }
    }

    public void verifyOfficeIsSortedDescByStatus(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> status = getDriver().findElements(office_search_results_status_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "descending order by office status", "fid", searchedEntity);
        for (int i = 0; i < status.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), status.get(i).getText());
        }
    }

    public void verifyDomesticOfficesSearchResults(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_type_filter_domestic_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "domestic offices list", "fid", searchedEntity);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyForeignOfficesSearchResults(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_type_filter_foreign_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "foreign offices list", "fid", searchedEntity);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void selectOfficeTypeFilterForeign() {
        attemptClick(office_type_filter_foreign_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifySearchReturned0Results() {
        assertEquals("Your search returned 0 results.", getDriver().findElement(office_search_results_0_results_xpath).getText());
    }


    public void selectResultsPerPage(String count) {
        resultsDisplayed = Integer.parseInt(count);
        attemptClick(By.id(office_search_results_per_page_id + count));
    }

    public void verifyDefaultSelectionResultPerPage() {
        String className = getDriver().findElement(office_search_deault_results_per_page_id).getAttribute("class");
        resultsDisplayed = 25;
        assertEquals("selected", className);
    }

    public void verifyResultsDisplayedOnPage(String count) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String resultsDisplayed = getDriver().findElement(office_search_results_header_xpath).getText();
        assertEquals(count, resultsDisplayed);
        List<WebElement> resultsDisplayedTable = getDriver().findElement(office_search_results_displayed_body_xpath).findElements(By.tagName("tr"));
        String resultCountDisplayed = Integer.toString(resultsDisplayedTable.size() - 1);
        junit.framework.Assert.assertEquals(resultCountDisplayed, count);

    }

    public void verifyMultipleOfficeTypesAlphabetically(Database database, ApacheHttpClient apacheHttpClient, String xQueryName, String fid) {
        WebElement multipleOfficeTypes = getDriver().findElement(By.xpath(office_search_results_select_officeTypes_xpath+fid + "']/td[7]"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, xQueryName, "fid", fid);
        assertEquals(document.getElementsByTagName("offices").item(0).getTextContent(), multipleOfficeTypes.getText());
    }

    public void selectOfficeStatusFilterActive() {
        attemptClick(office_status_filter_active_id);
    }

    public void selectOfficeStatusFilterInactive() {
        attemptClick(office_status_filter_inactive_id);
    }

    public void verifyActiveOfficesSearchResults(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_status_filter_active_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "active offices list", "fid", searchedEntity);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyInactiveOfficesSearchResults(Database database, ApacheHttpClient apacheHttpClient, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_status_filter_inactive_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithParameter(database, "inactive offices list", "fid", searchedEntity);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyDefaultOfficeStatusFilterIsAll() {
        assertTrue(getDriver().findElement(office_status_filter_all_selected_xpath).isDisplayed());
    }

    public void clickHeadOfficeType(){
        try{
            getDriver().findElement(office_type_headoffice_id).click();
            Thread.sleep(1500L);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void verifyResultsDisplayed(String typeOffice, String statusOffice){
        try{
            WebElement listContainer = getDriver().findElement(office_results_list_container_id);
            WebElement tableBodyContainer = listContainer.findElement(By.tagName("section")).findElement(By.tagName("div")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
            WebElement type = tableBodyContainer.findElements(By.tagName("td")).get(6);
            WebElement status = tableBodyContainer.findElements(By.tagName("td")).get(7);
            assertEquals(typeOffice,type.getText());
            assertEquals(statusOffice,status.getText());

        }catch(Exception e){

        }
    }

}
