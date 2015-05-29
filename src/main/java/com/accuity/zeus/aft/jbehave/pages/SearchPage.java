package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.result.ResultsPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends AbstractPage {

	private static final String PAGE_URI = "";

	private By searchFieldLocator = By.xpath(".//header/form/select[@name='idType']");

	private By searchValueLocator = By.xpath(".//header/form/input[@name='id']");

	private By searchButtonLocator = By.id("search-button");

	private By resultLinkLocator = By.id("report-nav");

	public SearchPage(WebDriver driver, String urlPrefix) {
		super(driver, urlPrefix);
	}

	@Override
	public String getPageUrl() {
		return getUrlPrefix() + PAGE_URI;
	}

	public ResultsPage search(String entity, String field, String value) {
		if (StringUtils.isBlank(entity) || StringUtils.isBlank(field) || StringUtils.isBlank(value)) {
			throw new RuntimeException();
		}
		//getDriver().findElement(entityTypeLocator).sendKeys(entity);
		getDriver().findElement(searchFieldLocator).sendKeys(field);
		getDriver().findElement(searchValueLocator).sendKeys(value);
		getDriver().findElement(searchButtonLocator).click();
		ResultsPage resultsPage = new ResultsPage(getDriver(), getUrlPrefix(), entity, field, value);
		resultsPage.validatePage();
		return resultsPage;
	}

	public ReportPage clickOnReportsTab(){
        getDriver().findElement(resultLinkLocator).click();
        ReportPage reportPage = new ReportPage(getDriver(), getUrlPrefix());
        return reportPage;
    }
}
