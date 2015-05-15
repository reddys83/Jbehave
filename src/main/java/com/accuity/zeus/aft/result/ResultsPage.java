package com.accuity.zeus.aft.result;

import com.accuity.zeus.aft.jbehave.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ResultsPage extends AbstractPage {

	private static final String PAGE_URI = "/#results";

	private String entity;

	private String field;

	private String value;

    public static String lastNavigationPage;

	private List<ResultsListItem> resultsList = null;

    private String pagesNavigationListElements = ".//*[@id='pages-navigation-list']";

	private By numResultsValueSelector = By.xpath("//*[@id='content']/div //header/p/span[@class='counter']");

	private By resultsSelector = By.xpath(".//*[@id='search-results-list']/section/ol/li");

	private By noResultsLocator = By.xpath("//*[@id='content']/div //header[@class='subheader']/p");

	private By paginationInfoLocator = By.xpath(".//*[@id='pagination-info']");

    private By pagesNavigationListLocator = By.xpath(pagesNavigationListElements + "/li");

    private By currentSearchResultsPage = By.xpath("//span[contains(@class,'pages-navigation-link-current')]");

    private By nextPageLinkLocator = By.xpath("//span[contains(@class,'pages-navigation-link-next')]");

    private By previousPageLinkLocator = By.xpath("//span[contains(@class,' pages-navigation-link-previous')]");

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
		return getDriver().findElement(numResultsValueSelector);
	}

	public WebElement getNoResults() {
		return getDriver().findElement(noResultsLocator);
	}

	public WebElement getPaginationInfo() {
		return getDriver().findElement(paginationInfoLocator);
	}

	public List<ResultsListItem> getResultsList() {

        if (resultsList == null) {
			resultsList = createResultsItemList();
		}
		return resultsList;
	}

    public List<WebElement> getPagesNavigationList(){
        return getDriver().findElements(pagesNavigationListLocator);
    }

    public WebElement getPagesNavigation(){
        return getDriver().findElement(By.xpath(pagesNavigationListElements));
    }

	public List<ResultsListItem> createResultsItemList() {
		List<ResultsListItem> tempResults = new LinkedList<ResultsListItem>();
		List<WebElement> webElements = getDriver().findElements(resultsSelector);
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
        return getDriver().findElement(By.xpath(pagesNavigationListElements + "/li[" + page.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "") + "]/span"));
    }

    public WebElement getCurrentSearchResultsPage(){
        return getDriver().findElement(currentSearchResultsPage);
    }

    public WebElement getNextPageLink(){
        return getDriver().findElement(nextPageLinkLocator);
    }

    public WebElement getPreviousPageLink(){
        return getDriver().findElement(previousPageLinkLocator);
    }

    public void clickOnResultCard(WebElement element) {
        element.click();
    }
}
