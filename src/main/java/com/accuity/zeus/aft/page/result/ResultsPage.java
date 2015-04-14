package com.accuity.zeus.aft.page.result;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.accuity.zeus.aft.page.AbstractPage;

public class ResultsPage extends AbstractPage {
	
	private static final String PAGE_URI = "/#results";
	
	private String entity;

	private String field;
	
	private String value;
	
	private List<ResultsListItem> resultsList = null;

	private By numResultsValueSelector = By.xpath(".//*[@id='content']/div/header/p/span[@class='counter']");

	private By resultsSelector = By.xpath(".//*[@id='search-results-list']//li");
	
	private By noResultsLocator = By.xpath(".//*[@id='content']/div/header[@class='subheader']/p");


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

	public List<ResultsListItem> getResultsList() {
		if (resultsList == null) {
			resultsList = createResultsItemList();
		}
		return resultsList;
	}
	
	private List<ResultsListItem> createResultsItemList() {
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

}
