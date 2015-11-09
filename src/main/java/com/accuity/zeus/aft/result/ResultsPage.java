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

	private By legalEntity_search_results_xpath = By.xpath("//*[@id='search-results-items']/li");

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

	public void verifySearchResultsCards(ExamplesTable searchResults) {
		for (int i=0; i<searchResults.getRowCount(); i++){
			assertEquals("FID:",getDriver().findElements(fid_label_locator_xpath).get(i).getText());
			assertEquals(searchResults.getRow(i).get(searchResults.getHeaders().get(0)),getDriver().findElements(fid_locator_xpath).get(i).getText());
			assertEquals("TFPID:",getDriver().findElements(tfpid_label_locator_xpath).get(i).getText());
			assertEquals(searchResults.getRow(i).get(searchResults.getHeaders().get(1)),getDriver().findElements(tfpid_locator_xpath).get(i).getText());
			assertEquals(searchResults.getRow(i).get(searchResults.getHeaders().get(2)),getDriver().findElements(name_locator_xpath).get(i).getText());
			assertEquals(searchResults.getRow(i).get(searchResults.getHeaders().get(3)),getDriver().findElements(address_locator_xpath).get(i).getText());
			assertEquals("STATUS:",getDriver().findElements(status_label_locator_xpath).get(i).getText());
			assertEquals(searchResults.getRow(i).get(searchResults.getHeaders().get(4)),getDriver().findElements(status_locator_xpath).get(i).getText());
		}
	}
}
