package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.result.ResultsPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends AbstractPage {

	private static final String PAGE_URI = "";

	private By search_field_xpath = By.xpath(".//header/form/select[@name='idType']");

	private By search_value_xpath = By.xpath(".//header/form/input[@name='id']");

	private By search_button_id = By.id("search-button");

	private By result_link_xpath = By.id("report-nav");

	private By data_tab_xpath = By.xpath("//header/nav[1]/ul/li[1]");

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
		getDriver().findElement(search_field_xpath).sendKeys(field);
		getDriver().findElement(search_value_xpath).sendKeys(value);
		getDriver().findElement(search_button_id).click();
		ResultsPage resultsPage = new ResultsPage(getDriver(), getUrlPrefix(), entity, field, value);
		resultsPage.validatePage();
		return resultsPage;
	}

	public ReportPage clickOnReportsTab(){
        getDriver().findElement(result_link_xpath).click();
        ReportPage reportPage = new ReportPage(getDriver(), getUrlPrefix());
		return reportPage;
    }

	public DataPage clickOnDataTab() {
		getDriver().findElement(data_tab_xpath).click();
		DataPage dataPage = new DataPage(getDriver(), getUrlPrefix());
		return dataPage;
	}
}
