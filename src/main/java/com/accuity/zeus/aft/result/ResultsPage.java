package com.accuity.zeus.aft.result;

import com.accuity.zeus.aft.jbehave.pages.AbstractPage;
import com.accuity.zeus.aft.jbehave.pages.LegalEntityPage;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultsPage extends AbstractPage {

	private static final String PAGE_URI = "/#results";
	private String entity;
	private String field;
	private String value;
	int totalCount = 0;
	public static String lastNavigationPage;
	private List<ResultsListItem> resultsList = null;
    private String pagesNavigationListElements = ".//*[@id='pages-navigation-list']";
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
	private By office_to_search_results_count_xpath = By.xpath("//*[@class='search-results-module']//span[2]");
	private By office_from_search_results_count_xpath = By.xpath("//*[@class='search-results-module']//span[1]");
	private By office_search_results_current_page_xpath = By.className("current-page");
	private By office_header_counter_xpath = By.xpath("//*[@id='subEntityList-header']//p");
	private By office_footer_counter_xpath = By.xpath("//*[@id='subEntityList-footer']//p");
	private By office_search_results_last_page_xpath = By.xpath("//*[@id='pages-navigation-list']/li[8]");

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

    public List<WebElement> getPagesNavigationList(){
        return getDriver().findElements(pages_navigation_list_locator_xpath);
    }

    public WebElement getPagesNavigation(){
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
		for (ResultsListItem resultListItem : resultList){
			if (resultListItem.getResultListItem().getText().equals(value.toString())){
				return resultListItem.getResultListItem();
			}
		}
		return null;
	}

    public WebElement getLastNavigationPage(){
        String lastNavigationListItem = Integer.toString(getPagesNavigationList().size() - 1);
        WebElement lastNavigationElement = getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + lastNavigationListItem + "]/span"));
        return lastNavigationElement;
    }

    public WebElement goToLastSearchResultsPage(){
        lastNavigationPage = getLastNavigationPage().getText();
        return getLastNavigationPage();
    }

    public WebElement goToDesiredSearchResultsPage(String page){
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "") + "]/span"));
    }

    public WebElement getCurrentSearchResultsPage(){
        return getDriver().findElement(currentSearchResultsPage);
    }

    public WebElement getNextPageLink(){
        return getDriver().findElement(next_page_link_locator_xpath);
    }

    public WebElement getPreviousPageLink(){
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
		for (int i=0; i<legalEntitySearchResults.getRowCount(); i++){
			assertEquals("FID:",getDriver().findElements(fid_label_locator_xpath).get(i).getText());
			assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(0)),getDriver().findElements(fid_locator_xpath).get(i).getText());
			assertEquals("TFPID:",getDriver().findElements(tfpid_label_locator_xpath).get(i).getText());
			assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(1)),getDriver().findElements(tfpid_locator_xpath).get(i).getText());
			assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(2)),getDriver().findElements(name_locator_xpath).get(i).getText());
			assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(3)),getDriver().findElements(address_locator_xpath).get(i).getText());
			assertEquals("STATUS:",getDriver().findElements(status_label_locator_xpath).get(i).getText());
			assertEquals(legalEntitySearchResults.getRow(i).get(legalEntitySearchResults.getHeaders().get(4)),getDriver().findElements(status_locator_xpath).get(i).getText());
		}
	}

	public void verifyOfficeSearchResults(ExamplesTable officeSearchResults) {
		verifyOfficeHeading();
		verifyOfficeSearchResultsColumn();
		for (int i=0; i<officeSearchResults.getRowCount(); i++){
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(0)),getDriver().findElements(office_id_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(1)),getDriver().findElements(office_name_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(2)),getDriver().findElements(office_address_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(3)),getDriver().findElements(office_city_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(4)),getDriver().findElements(office_area_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(5)),getDriver().findElements(office_country_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(6)),getDriver().findElements(office_type_locator_xpath).get(i).getText());
			assertEquals(officeSearchResults.getRow(i).get(officeSearchResults.getHeaders().get(7)),getDriver().findElements(office_status_locator_xpath).get(i).getText());
		}
	}

	public void verifyOfficeSearchResultsColumn(){
		assertEquals("FID NAME ADDRESS CITY AREA COUNTRY TYPE STATUS",getDriver().findElement(office_search_results_table_head_xpath).getText());
	}

	public void verifyOfficeHeading(){
		assertEquals("OFFICES",getDriver().findElement(office_label_xpath).getText());
	}

	public void verifyOfficeSearchResultsIsPaginated() {
		if(Integer.parseInt(getOfficeTotalResultsCount()) <= 25) {
				assertEquals(getOfficeTotalResultsCount(), Integer.toString(getOfficeResultsCountInCurrentPage().size()));
			} else {
				navigateToOfficeLastSearchResultsPage();
				assertEquals(getOfficeTotalResultsCount(), getOfficeResultsCountTillCurrentPage());
		}
	}

	public String getOfficeTotalResultsCount() {
		return getDriver().findElements(office_total_search_results_count_xpath).get(1).getText();
	}

	public List<WebElement> getOfficeResultsCountInCurrentPage() {
		return getDriver().findElements(office_current_page_search_results_count_xpath);
	}

	public String getOfficeToResultsCount() {
		return getDriver().findElement(office_to_search_results_count_xpath).getText();
	}

	public String getOfficeFromResultsCount() {
		return getDriver().findElement(office_from_search_results_count_xpath).getText();
	}

	public void verifyOfficeSearchResultsCounter(){
		if(Integer.parseInt(getOfficeTotalResultsCount()) <= 25) {
			if(Integer.parseInt(getOfficeTotalResultsCount()) == 1){
				assertEquals("1", getOfficeResultsCountInCurrentPage());
				assertEquals("1 to 1 of 1 result", getDriver().findElement(office_header_counter_xpath).getText());
				assertEquals("1 to 1 of 1 result", getDriver().findElement(office_footer_counter_xpath).getText());
			} else {
				assertEquals("1 to " + getOfficeResultsCountInCurrentPage() + " of " + getOfficeResultsCountInCurrentPage() +" results", getDriver().findElement(office_header_counter_xpath).getText());
				assertEquals("1 to " + getOfficeResultsCountInCurrentPage() + " of " + getOfficeResultsCountInCurrentPage() +" results", getDriver().findElement(office_footer_counter_xpath).getText());
			}
		} else {
			navigateToOfficeLastSearchResultsPage();
			assertEquals(getOfficeTotalResultsCount(), getOfficeResultsCountTillCurrentPage());
		}
	}

	public String getOfficeResultsCountTillCurrentPage() {
			return Integer.toString(
					getOfficeResultsCountInCurrentPage().size() + ((
							Integer.parseInt(getDriver().findElement(office_search_results_current_page_xpath).getText()) - 1) * 25));
	}

	public void navigateToOfficeLastSearchResultsPage(){
		attemptClick(office_search_results_last_page_xpath);
	}

}
