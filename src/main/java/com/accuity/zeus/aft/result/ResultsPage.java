package com.accuity.zeus.aft.result;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.jbehave.pages.AbstractPage;
import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.LegalEntityPage;
import com.accuity.zeus.aft.jbehave.identifiers.ResultsIdentifiers;
import com.accuity.zeus.aft.jbehave.pages.RoutingCodePage;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.utils.SimpleCacheManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.Document;
import java.util.*;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
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
    private By no_search_results_msg_xpath = By.xpath("//*[@id='search-results-summary']/h1/header/p");
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
    private By office_search_results_last_page_xpath = By.xpath("//*[@id='pages-navigation-list']/li[last()-1]");
    private By office_search_results_navigation_xpath = By.xpath("//*[@id='pages-navigation-list']");
    private By office_search_results_next_page_classname = By.className("next-page");
    private By office_search_results_previous_page_classname = By.className("previous-page");
    private By office_search_results_column_name_xpath = By.xpath(".//*[@id='content'][@class='data-content']//thead//th[@id='name']");
    private By office_search_results_column_area_xpath = By.xpath(".//*[@id='content'][@class='data-content']//thead//th[@id='areaName']");
    private By office_search_results_column_city_xpath = By.xpath(".//*[@id='content'][@class='data-content']//thead//th[@id='cityName']");

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
    private By office_search_results_country_col_xpath = By.xpath("//tr/td[6]");
    private By office_search_results_country_xpath = By.xpath("//tr/th[@id='countryName']");
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
    private By office_search_results_rows_xpath = By.xpath("//*[@class='search-results-module']//tbody/tr");
    private String appliedStatusFilter = "";
    private String appliedInstTypeFilter = "";
    private By office_search_results_type_filter_xpath = By.xpath(".//*[@id='type']/li");
    private By office_search_refine_results_searchBox_xpath = By.xpath("//input[@id='refine-input']");
    private By office_addressList_locator_xpath = By.xpath(".//*[@class='search-results-module'] //td[3]");
    private By office_search_total_number_of_results_xpath = By.xpath("//*[@id='subEntityList-header']");
    private By results_tab_xpath = By.xpath("//*[@id='results-nav']");


    List<NameValuePair> nvPairs = new ArrayList<>();


    public ResultsPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

  /*  public ResultsPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi, String entity, String field, String value) {
        this(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
        this.entity = entity;
        this.field = field;
        this.value = value;
    } */

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
        return new LegalEntityPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public RoutingCodePage clickOnRoutingCodeResultCard(WebElement element) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new RoutingCodePage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
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

    public WebElement getRoutingCodeElements(String routingCode,String codeType) {
        List<WebElement> elements = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcodes_rows_xpath"));
        for (WebElement element : elements) {
            if (element.findElement(By.xpath("td[1]")).getText().equals(routingCode) && element.findElement(By.xpath("td[2]")).getText().equals(codeType)) {
                return element.findElement(By.xpath("td[1]"));

            }
        }
        return null;
    }

    public void verifySearchResults() {
        getDriver().findElement(legalEntity_search_results_xpath).isDisplayed();
        saveTheResultsAndCurrentURLToCache();
    }

    public void applyCountryFilter(ExamplesTable Country) {
       for (int i = 0; i < Country.getRowCount(); i++) {
            getDriver().findElement(By.id("countryName-" + Country.getRow(i).values().toString().replace(" ", "_").replace("[", "").replace("]", "").trim())).click();
        }
    }

    public void applyTypeFilter(ExamplesTable Type) {
        for (int i=0;i<Type.getRowCount();i++)
        {
            getDriver().findElement(By.id("codeType-" + Type.getRow(i).values().toString().replace("[", "").replace("]", "").trim())).click();
        }
    }

    public void applyStatusFilterInRCSearch(String status)
    {
        getDriver().findElement(By.id("codeStatus-"+status)).click();
    }

    public void verifyTypeFilterInRCSearchResults(ExamplesTable Type){
        boolean val=false;
        List typeFilter = new ArrayList();
        List typeList = new ArrayList();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Map<String,String> row : Type.getRows())
        {
            typeFilter.add(row.get("Type"));
        }
        List <WebElement>  typeListElement = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_type_xpath"));
        for(WebElement e : typeListElement)
        {
            typeList.add(e.getText());
        }
        if(typeList.containsAll(typeFilter) && typeFilter.containsAll(typeList))
            val=true;
        else
            val=false;
        assertTrue(val);
    }


    public void verifyCountryFilterInRCSearchResults(ExamplesTable Country) {
        boolean val=false;
        List countryFilter = new ArrayList();
        List countryList = new ArrayList();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Map<String,String> row : Country.getRows())
        {
           countryFilter.add(row.get("Country"));
        }

        List <WebElement>  countryListElement = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_country_xpath"));
        for(WebElement e : countryListElement)
        {
           countryList.add(e.getText());
        }
          if(countryList.containsAll(countryFilter) && countryFilter.containsAll(countryList))
              val=true;
        else
              val=false;
        assertTrue(val);
    }

    public void verifyStatusFilterInRCSearchResults(String status)
    {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> statusElement = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_status_xpath"));
        for (int i=0;i<statusElement.size();i++)
        {
            assertEquals(statusElement.get(i).getText().toLowerCase(),status);
        }
    }



    public void verifyRoutingCodeSearchResultsHeaders(){
        assertEquals("CODE TYPE ENTITY FID ADDRESS CITY AREA COUNTRY STATUS",getDriver().findElement(ResultsIdentifiers.getObjectIdentifier("routingCode_results_list_header_xpath")).getText());
    }

    public void clickOnRoutingCodeResultsCODEColumn() {
        attemptClick(ResultsIdentifiers.getObjectIdentifier("routingCode_results_codeHeader_xpath"));
    }

    public void clickOnRoutingCodeResultsTYPEColumn() {
        attemptClick(ResultsIdentifiers.getObjectIdentifier("routingCode_results_typeHeader_xpath"));
    }

    public void clickOnRoutingCodeResultsENTITYColumn() {
        attemptClick(ResultsIdentifiers.getObjectIdentifier("routingCode_results_entityHeader_xpath"));
    }

    public void clickOnRoutingCodeResultsFIDColumn() {
        attemptClick(ResultsIdentifiers.getObjectIdentifier("routingCode_results_fidHeader_xpath"));
    }
    public void verifyRoutingCodeResultsDescendingOrder(String code)
    {
        List<String> Codes = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", code));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode results", nvPairs);

        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Codes.add(document.getElementsByTagName("Code").item(i).getTextContent());
        }
        Collections.sort(Codes, Collections.reverseOrder());
        List<WebElement> RoutingCodesList = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_codeList_xpath"));

        for (int j=0;j<Codes.size();j++)
        {
            assertEquals(Codes.get(j),RoutingCodesList.get(j).getText());
        }
    }

    public void verifyRoutingCodeResultsAscendingByType(String code) {
        List<String> Types = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", code));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode results", nvPairs);

        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Types.add(document.getElementsByTagName("Type").item(i).getTextContent());
        }
        Collections.sort(Types);
        List<WebElement> RoutingCodesTypeList = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_type_xpath"));

        for (int j=0;j<Types.size();j++)
        {
            assertEquals(Types.get(j),RoutingCodesTypeList.get(j).getText());
        }
    }

    public void verifyRoutingCodeResultsAscendingByEntity(String code){
        List<String> Entity = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", code));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode results", nvPairs);

        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Entity.add(document.getElementsByTagName("Entity").item(i).getTextContent());
        }
        Collections.sort(Entity);
        List<WebElement> RoutingCodesEntityList = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_entity_xpath"));

        for (int j=0;j<Entity.size();j++)
        {
            assertEquals(Entity.get(j),RoutingCodesEntityList.get(j).getText());
        }
    }

    public void verifyRoutingCodeResultsAscendingByFID(String code){
        List<String> Fid = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", code));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode results", nvPairs);

        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Fid.add(document.getElementsByTagName("FID").item(i).getTextContent());
        }
        Collections.sort(Fid);
        List<WebElement> RoutingCodesFidList = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_fid_xpath"));

        for (int j=0;j<Fid.size();j++)
        {
            assertEquals(Fid.get(j),RoutingCodesFidList.get(j).getText());
        }
    }

    public void verifyRoutingCodeSearchResults(String code) {
        code = code.replaceAll("[^a-zA-Z0-9]+", "");

   /* Due to perfomance issue with the routingCode resutls
   Forced to sleep for 50 seconds */

        try {
            Thread.sleep(50000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        verifyRoutingCodeSearchResultsHeaders();
        assertEquals("Routing Code results for " + code, getDriver().findElement(ResultsIdentifiers.getObjectIdentifier("routingCode_results_header_xpath")).getText());

        List<WebElement> resultsCount = getDriver().findElements(ResultsIdentifiers.getObjectIdentifier("routingCode_results_resultsCount_xpath"));
        nvPairs.add(new BasicNameValuePair("code", code));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode results", nvPairs);

        int codeResultsCount = Integer.parseInt(document.getElementsByTagName("codeCount").item(0).getTextContent());
        for (int p = 0; p < resultsCount.size(); p++) {
            if (codeResultsCount < 25) {
                assertEquals("1 to " + codeResultsCount + " of " + codeResultsCount + " results", resultsCount.get(p).getText());
            } else
                assertEquals("1 to 25 of " + codeResultsCount + " results", resultsCount.get(p).getText());
        }

        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            String routingCodeType = document.getElementsByTagName("Type").item(i).getTextContent();
            String routingCode = document.getElementsByTagName("Code").item(i).getTextContent();
            for (int j = 1; j <= document.getElementsByTagName("results").item(i).getChildNodes().getLength(); j++) {
                assertEquals(document.getElementsByTagName("results").item(i).getChildNodes().item(j - 1).getTextContent().replaceAll(" +", " "),
                        getDriver().findElement(By.xpath(".//*[@class='searchEntityList-container']//tbody/tr[td='" + routingCode + "' and td='" + routingCodeType + "']/td["+j+"]")).getText());

            }

        }
    }


    public void verifyErrorMessageForAtleast2Char()
    {
        assertEquals("ENTER AT LEAST 2 VALID CHARACTERS",getDriver().findElement(ResultsIdentifiers.getObjectIdentifier("routingCode_results_valid_character_error_message")).getText());
    }

    public void verifyMessageFor0Results()
    {
        assertEquals("Your search returned 0 results.",getDriver().findElement(ResultsIdentifiers.getObjectIdentifier("routingCode_results_zero_results_message_xpath")).getText());
    }

    public LegalEntityPage clickFidNavigation(String fid)
    {
        getDriver().findElement(By.xpath(".//*[@id='searchEntityList-list']//tbody//tr[td='" + fid + "']//a")).click();
        return new LegalEntityPage(getDriver(), getPageUrl(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());

    }

    public void saveTheResultsAndCurrentURLToCache() {
    List<String> fids = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(fid_locator_xpath);
    for(WebElement element:elements)
        fids.add(element.getText());

    SimpleCacheManager.getInstance().put("legalEntityFIDs",fids);
    SimpleCacheManager.getInstance().put("currentURL",getDriver().getCurrentUrl());

}
    public void compareURLAndSearchResults(){
        assertEquals(SimpleCacheManager.getInstance().get("currentURL").toString(),getDriver().getCurrentUrl());
        List<WebElement> elements=getDriver().findElements(fid_locator_xpath);
        List<String> fids=new ArrayList<>();
        for (WebElement element:elements)
        {
            fids.add(element.getText());
        }
        List<WebElement> previousSeacrhResultsFidsList=(List)SimpleCacheManager.getInstance().get("legalEntityFIDs");
        assertTrue(fids.equals(previousSeacrhResultsFidsList));

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
            Thread.sleep(5000L);
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
       // String currentPageNumber=getDriver().findElement(office_search_results_current_page_xpath).getText();
       attemptClick(office_search_results_last_page_xpath);
        waitForElementToDisappear(By.id("loader"));
       // waitForElementToDisappear(By.xpath("//*[@id='pages-navigation-list']//li[@class='current-page' and text()='"+currentPageNumber+"']"));
    }

    public void verifySearchResultsNavigation() {
        if (Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) > 7) {
            if (Integer.parseInt(getOfficeSearchResultsCurrentPage()) <= 4) {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), ("Previous 1 2 3 4 5 � " + getOfficeSearchResultsLastNavigationPage() + " Next"));
            } else if((Integer.parseInt(getOfficeSearchResultsCurrentPage()) >= 5)
                    && Integer.parseInt(getOfficeSearchResultsCurrentPage()) < (Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 3)) {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), ("Previous 1 � " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsCurrentPage()) - 1) + " " +
                        getOfficeSearchResultsCurrentPage() + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsCurrentPage()) + 1) + " � " +
                        getOfficeSearchResultsLastNavigationPage() + " Next"));
            } else {
                assertEquals(getDriver().findElement(office_search_results_navigation_xpath).getText(), ("Previous 1 � " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 4) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 3) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 2) + " " +
                        Integer.toString(Integer.parseInt(getOfficeSearchResultsLastNavigationPage()) - 1) + " " +
                        getOfficeSearchResultsLastNavigationPage() + " Next"));
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
        System.out.println("abcdefg"+getDriver().findElement(office_search_current_page_xpath).getText());
        assertTrue(getDriver().findElement(office_search_current_page_xpath).getText().contains(page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")));
    }

    public void navigateThroughSearchResults(String page) {
        if (page.equals("last")) {
            navigateToOfficeLastSearchResultsPage();
        } else {
            //String currentPageNumber=getDriver().findElement(office_search_results_current_page_xpath).getText();
            navigateToDesiredSearchResultsPage(Integer.toString(Integer.parseInt(page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")) + 1)).click();
            waitForElementToDisappear(By.id("loader"));
            //waitForElementToDisappear(By.xpath("//*[@id='pages-navigation-list']//li[@class='current-page' and text()='"+currentPageNumber+"']"));

        }
    }

    public void navigateToNextOfficeSearchResultsPage() {
        //String currentPageNumber=getDriver().findElement(office_search_results_current_page_xpath).getText();
        attemptClick(office_search_results_next_page_classname);
        waitForElementToDisappear(By.id("loader"));
        //waitForElementToDisappear(By.xpath("//*[@id='pages-navigation-list']//li[@class='current-page' and text()='"+currentPageNumber+"']"));

    }

    public void navigateToPreviousOfficeSearchResultsPage() {
        //String currentPageNumber=getDriver().findElement(office_search_results_current_page_xpath).getText();
        attemptClick(office_search_results_previous_page_classname);
        waitForElementToDisappear(By.id("loader"));
       // waitForElementToDisappear(By.xpath("//*[@id='pages-navigation-list']//li[@class='current-page' and text()='"+currentPageNumber+"']"));
    }


    public void clickOnColumnName() {
        attemptClick(office_search_results_column_name_xpath);
    }

    public void clickOnColumnArea() {
        attemptClick(office_search_results_column_area_xpath);
    }

    public void clickOnColumnCity() {
        attemptClick(office_search_results_column_city_xpath);
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

    public void verifySortOrderByOfficeFid(String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));

        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName, nvPairs);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyDefaultOfficeTypeFilterIsAll() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().findElement(office_type_default_filter_all_xpath).isDisplayed());
    }

    public void verifyAllDeselectedOfficeTypeFilter() {
        assertFalse(getDriver().findElement(office_type_default_filter_all_xpath).isSelected());
    }

    public void selectOfficeTypeFilterDomestic() {
        attemptClick(office_type_filter_domestic_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrderByOfficeType(String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> typeList = getDriver().findElements(office_type_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName, nvPairs);
        for (int i=0; i< typeList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), typeList.get(i).getText());
        }
    }

    public void verifySortOrderByOfficeName(String xQueryName, String fid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", fid));
        List<WebElement> nameList = getDriver().findElements(office_name_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName, nvPairs);
        for (int i=0; i< nameList.size();i++) {
            try {
                assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), nameList.get(i).getText());
            } catch (NullPointerException e) {
                String nullNameList = nameList.get(i).getText();
                nullNameList = null;
            }
        }
    }

	public void entersTextInRefineFilterForCity(String searchText) {

		try {
			Thread.sleep(5000L);
			getDriver().findElement(office_search_refine_results_searchBox_xpath).sendKeys(searchText);
			getDriver().findElement(office_search_refine_results_searchBox_xpath).sendKeys(Keys.RETURN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyOfficeSearchResultsForCity(String searchText) {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> cityList = getDriver().findElements(office_city_locator_xpath);
		for (int i = 0; i < cityList.size(); i++) {
			assertTrue(cityList.get(i).getText().contains(searchText));

		}

	}

    public void verifySortOrderByOfficeArea(String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> areaList = getDriver().findElements(office_area_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName, nvPairs);
        for (int i=0; i< areaList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), areaList.get(i).getText());
        }
    }

    public void verifySortOrderByOfficeCity(String xQueryName, String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> cityList = getDriver().findElements(office_city_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName,nvPairs);
        for (int i=0; i< cityList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), cityList.get(i).getText());
        }
    }

    public void clickOnOfficeSearchResultsStatus() {
        attemptClick(office_search_results_status_xpath);
        try {
            Thread.sleep(3000L);
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

    public void verifyOfficeIsSortedAscByStatus(String searchedEntity) {

        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> status = getDriver().findElements(office_search_results_status_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "ascending order by office status", nvPairs);
        for (int i = 0; i < status.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), status.get(i).getText().toLowerCase());
        }
    }

    public void verifyOfficeIsSortedDescByStatus(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> status = getDriver().findElements(office_search_results_status_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "descending order by office status", nvPairs);
        for (int i = 0; i < status.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), status.get(i).getText().toLowerCase());
        }
    }

    public void verifyDomesticOfficesSearchResults(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        assertTrue(getDriver().findElement(office_type_filter_domestic_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "domestic offices list", nvPairs);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyForeignOfficesSearchResults(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        assertTrue(getDriver().findElement(office_type_filter_foreign_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "foreign offices list", nvPairs);
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
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Your search returned 0 results.", getDriver().findElement(office_search_results_0_results_xpath).getText());
    }


    public void selectResultsPerPage(String count) {
        resultsDisplayed = Integer.parseInt(count);
        attemptClick(By.id(office_search_results_per_page_id + count));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyDefaultSelectionResultPerPage() {
        String className = getDriver().findElement(office_search_deault_results_per_page_id).getAttribute("class");
        resultsDisplayed = 25;
        assertEquals("selected", className);
    }


    public void verifyMultipleOfficeTypesAlphabetically(String xQueryName, String fid) {
        nvPairs.add(new BasicNameValuePair("fid", fid));
        WebElement multipleOfficeTypes = getDriver().findElement(By.xpath(office_search_results_select_officeTypes_xpath+fid + "']/td[7]"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xQueryName, nvPairs);
        assertEquals(document.getElementsByTagName("offices").item(0).getTextContent(), multipleOfficeTypes.getText());
    }

    public void selectOfficeStatusFilterActive() {
        appliedStatusFilter = "Active";
        attemptClick(office_status_filter_active_id);
    }

    public void selectOfficeStatusFilterInactive() {
        appliedStatusFilter = "Inactive";
        try{
        attemptClick(office_status_filter_inactive_id);
            Thread.sleep(2000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyActiveOfficesSearchResults(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        assertTrue(getDriver().findElement(office_status_filter_active_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "active offices list", nvPairs);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyInactiveOfficesSearchResults(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        assertTrue(getDriver().findElement(office_status_filter_inactive_selected_xpath).isDisplayed());
        List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "inactive offices list", nvPairs);
        for (int i = 0; i < fidList.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), fidList.get(i).getText());
        }
    }

    public void verifyDefaultOfficeStatusFilterIsAll() {
        assertTrue(getDriver().findElement(office_status_filter_all_selected_xpath).isDisplayed());
    }

    public void verifyOfficeIsSortedAscByCountry(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> country = getDriver().findElements(office_search_results_country_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "ascending order by office country", nvPairs);
        for (int i = 0; i < country.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), country.get(i).getText());
        }
    }

    public void verifyOfficeTypesInTypeFilter(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> typeFilter = getDriver().findElements(office_search_results_type_filter_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "office types list", nvPairs);
        for (int i=0; i<typeFilter.size()-1;i++)
        {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().toUpperCase(), typeFilter.get(i+1).getText());
        }
    }

    public void officeSearchResultsWithTypeFilter(String searchedEntity, String institutionType) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> officeFid = getDriver().findElements(office_id_locator_xpath);

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        nvPairs.add(new BasicNameValuePair("types", institutionType));

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "office search results with type filter", nvPairs);
        for (int i = 0; i < officeFid.size(); i++)
        {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), officeFid.get(i).getText());
        }

    }

    public void verifyOfficeIsSortedDescByCountry(String searchedEntity) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
        List<WebElement> country = getDriver().findElements(office_search_results_country_col_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "descending order by office country", nvPairs);
        for (int i = 0; i < country.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), country.get(i).getText());
        }
    }

    public void clickOnOfficeSearchResultsCountry() {
        attemptClick(office_search_results_country_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectOfficeInstitutionType(String institutionType){
        appliedInstTypeFilter = institutionType;
        try{
            attemptClick(By.id("type-"+institutionType.replace(" ","_")));
            Thread.sleep(2000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyOfficeTypeSelectedByDefault(String institutionType) {
         assertTrue(getDriver().findElement(By.xpath("//*[@id='type-" + institutionType.replace(" ", "_") + "'][@class='selected']")).isDisplayed());
         }


    public void verifyOfficeResultsForAppliedFilters(){
        for(int i=0; i<getDriver().findElements(office_search_results_rows_xpath).size(); i++){
            assertEquals(appliedStatusFilter, getDriver().findElements(office_search_results_status_col_xpath).get(i).getText());
            assertTrue(getDriver().findElements(office_type_locator_xpath).get(i).getText().contains(appliedInstTypeFilter));
        }
    }

    public void verifySortAscOrderByAddress(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comparingAddressXpathUI(nvPairs,"ascending order by office address");

    }

    public void comparingAddressXpathUI(List<NameValuePair>nvPairs,String xqueryName){
        List<WebElement> officeAdd = getDriver().findElements(office_addressList_locator_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        for (int i = 0; i < officeAdd.size(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(),officeAdd.get(i).getText());
        }
    }

    public void verifySortDscOrderByAddress(String fid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", fid));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comparingAddressXpathUI(nvPairs,"descending order by office address");
    }

    public void verifyToolTipClickToView(){
        assertEquals("Click to view office",getDriver().findElement(office_current_page_search_results_count_xpath).getAttribute("title"));
    }    

	public void verifyActiveOfficesSearchResultsForAllPages(String searchedEntity, String status, int paginationCount) {
		try {
			Thread.sleep(1000L);
			assertTrue(getDriver().findElement(office_status_filter_active_selected_xpath).isDisplayed());
			WebElement searchHeader = getDriver().findElement(office_search_total_number_of_results_xpath);
			String fidCount = searchHeader.getText().split("of")[1].split("results")[0].trim();
			WebElement nextPage = getDriver().findElement(office_search_results_next_page_classname);
			int pageCount = 1;
			int comparedFidsCount = 0;
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", searchedEntity));
			nvPairs.add(new BasicNameValuePair("fidCount", fidCount));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"active office test list", nvPairs);
			while (nextPage != null) {

				//Thread.sleep(5000L); //there is no unique element in next page, hence using direct wait
				List<WebElement> resultList = getDriver().findElements(office_search_results_rows_xpath);
				List<WebElement> fidList = getDriver().findElements(office_id_locator_xpath);

				for (int i = 0; i < resultList.size() && i < document.getElementsByTagName("fid").getLength(); i++) {

					assertTrue(resultList.get(i).getText().contains(status));

					assertEquals(document.getElementsByTagName("fid").item(i + (paginationCount * (pageCount - 1)))
							.getTextContent(), fidList.get(i).getText());
					comparedFidsCount++;
				}
				if (comparedFidsCount < Integer.parseInt(fidCount)) {
					nextPage = getDriver().findElement(office_search_results_next_page_classname);
					if (nextPage != null) {
                        String currentPageNumber=getDriver().findElement(office_search_results_current_page_xpath).getText();
						nextPage.click();
                        waitForElementToDisappear(By.xpath("//*[@id='pages-navigation-list']//li[@class='current-page' and text()='"+currentPageNumber+"']"));
					}
				} else {
					break;
				}
				pageCount++;

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

    public DataPage createDataPage() {
        DataPage DOP=null;
        try {
            DOP= new DataPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
        }
        catch(Exception e)
        {e.printStackTrace();}
        return DOP;
    }


    public void verifyResultsTabSelected(){
        assertTrue(getDriver().findElement(results_tab_xpath).getAttribute("class").equals("selected"));
    }

    public WebElement getRoutingCodeHyperlinkElementForCodeValue(String routingCode, String codeType) {
        List<WebElement> elements = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcodes_rows_xpath"));
        for (WebElement element : elements) {
            if (element.findElement(By.xpath("td[1]")).getText().equals(routingCode) && element.findElement(By.xpath("td[2]")).getText().equals(codeType)) {
                return element.findElement(By.xpath("td[1]/*[@href]"));
            }
        }
        return null;
    }

    public void verifyToolTipInRoutingCodeResultsPage(String tooltip, By by) {
    	assertEquals(tooltip, getDriver().findElement(by).getAttribute("title"));
    }

    public void verifyResultsPage() {
		assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCodeResultsHeader_view_mode")).getText().contains("Routing Code results for"));
	}
 }

