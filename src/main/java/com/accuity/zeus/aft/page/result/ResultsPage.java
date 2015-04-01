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
	
	private List<ResultsListItem> results = null;
	
	private By numResultsValueSelector = By.xpath("//*[@id='content']/div/header/p/span[@class='counter']");

	private By resultsSelector = By.xpath("//*[@id='search-results-list']//li");

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

	public String getNumResultsValue() {
		return getDriver().findElement(numResultsValueSelector).getText();
	}

	public List<ResultsListItem> getResults() {
		if (results == null) {
			results = createResultsItemList();
		}
		return results;
	}
	
	private List<ResultsListItem> createResultsItemList() {
		List<WebElement> webElements = getDriver().findElements(resultsSelector);
		if (webElements != null && webElements.size() > 0) {
			List<ResultsListItem> tempResults = new LinkedList<ResultsListItem>();
			for (WebElement webElement : webElements) {
				tempResults.add(new ResultsListItem(webElement));
			}
			return tempResults;
		}
		return Collections.emptyList();
	}

}
