package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.result.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SearchPage extends AbstractPage {

	private static final String PAGE_URI = "";
	private By search_by_id = By.id("search-type");
	private By search_hera_css = By.cssSelector("[type='text']");
	private By search_button_id = By.id("search-button");
	private By result_link_id = By.id("report-nav");
	private By logout_link_id = By.id("logout");
	private By settings_icon_id = By.cssSelector("#user-menu>span");

	public SearchPage(WebDriver driver, String urlPrefix) {
		super(driver, urlPrefix);
	}

	private LoginPage loginPage = new LoginPage(getDriver(), getUrlPrefix());
	private SearchPage searchPage;

	@Override
	public String getPageUrl() {
		return getUrlPrefix() + PAGE_URI;
	}

	public ResultsPage search(String entity, String field, String value) {
		/*
		if (StringUtils.isBlank(entity) || StringUtils.isBlank(field) || StringUtils.isBlank(value)) {
			throw new RuntimeException();
		}
		*/
		//getDriver().findElement(entityTypeLocator).sendKeys(entity);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(search_hera_css).click();
        getDriver().findElement(search_hera_css).sendKeys(value);
        getDriver().findElement(search_by_id).sendKeys(field);
		getDriver().findElement(search_button_id).click();
		ResultsPage resultsPage = new ResultsPage(getDriver(), getUrlPrefix(), entity, field, value);
		resultsPage.validatePage();
		return resultsPage;
	}

	public ReportPage clickOnReportsTab(){
        getDriver().findElement(result_link_id).click();
        ReportPage reportPage = new ReportPage(getDriver(), getUrlPrefix());
		return reportPage;
    }

	public LoginPage clickOnLogout() {
		getDriver().findElement(logout_link_id).click();
		loginPage = new LoginPage(getDriver(), getUrlPrefix());
		return loginPage;
	}

	public void moveCursorToSettings() {
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(settings_icon_id);
		action.moveToElement(we).build().perform();
	}

	public SearchPage goToSearchPage(){
		open();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(getDriver().getCurrentUrl().contains("#login")){
			loginPage.enterUserName("qatest");
			loginPage.enterPassword("password1");
			searchPage = loginPage.clickOnLoginButton();
		} else {
            searchPage = new SearchPage(getDriver(), getUrlPrefix());
        }
		return searchPage;
	}
}
