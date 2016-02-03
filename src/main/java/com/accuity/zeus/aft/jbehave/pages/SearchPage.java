package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.aft.result.ResultsPage;
import org.jbehave.core.annotations.AfterStories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SearchPage extends AbstractPage {

	private static final String PAGE_URI = "";
	private By search_by_id = By.id("search-type");
	private By search_hera_css = By.cssSelector("[type='text']");
	private By result_link_id = By.id("report-nav");
	private By logout_link_id = By.id("logout");
	private By settings_icon_id = By.cssSelector("#user-menu>span");
	private Utils utils = new Utils();
	private By admin_tab_xpath = By.xpath("//header/nav[1]/ul/li[5]");
	private By search_field_xpath = By.xpath(".//header/form/select[@name='idType']");
	private By search_button_id = By.id("search-button");
	private By data_tab_xpath = By.xpath("//header/nav[1]/ul/li[1]");
	private By legalEntity_type_ahead_xpath = By.xpath(".//*[@id='main-header']//input[2]");
	private By legalEntity_search_option_type_dropdown_id= By.id("search-type");
	private By legalEntity_search_button_id=By.id("search-button");
	public static String selectedEntity="";

	public SearchPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
		super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
	}
	private LoginPage loginPage = new LoginPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());

	@AfterStories
	public void cleanup() {
		clickOnLogout();
		getDriver().quit();
	}

	@Override
	public String getPageUrl() {
		return getUrlPrefix() + PAGE_URI;
	}

	public ResultsPage search(String entity, String field, String value) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(search_hera_css).click();
        getDriver().findElement(search_hera_css).sendKeys(value);
        getDriver().findElement(search_by_id).sendKeys(field);
		getDriver().findElement(search_field_xpath).sendKeys(field);
		getDriver().findElement(search_button_id).click();
		ResultsPage resultsPage = new ResultsPage(getDriver(), getUrlPrefix(),getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi(), entity, field, value);
		resultsPage.validatePage();
		return resultsPage;
	}

	public ReportPage clickOnReportsTab(){
        getDriver().findElement(result_link_id).click();
        return new ReportPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

	public LoginPage clickOnLogout() {
		if(!getDriver().getCurrentUrl().contains("#login")) {
			getDriver().findElement(logout_link_id).click();
			loginPage = new LoginPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
			return loginPage;
		}
		return null;
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
			loginPage.enterUserName(utils.readPropertyFile().getProperty("data.management.webapp.aft.uid"));
			loginPage.enterPassword(utils.readPropertyFile().getProperty("data.management.webapp.aft.pwd"));
			return loginPage.clickOnLoginButton();
		} else {
              return new SearchPage(getDriver(), getUrlPrefix(), getDatabase(),getApacheHttpClient(), getRestClient(), getHeraApi());
        }
    }

	public DataPage clickOnDataTab() {
		attemptClick(data_tab_xpath);
        return new DataPage(getDriver(), getUrlPrefix(), database , apacheHttpClient, restClient, heraApi);
	}

	public AdminPage clickOnAdminTab() {
		attemptClick(admin_tab_xpath);
		return new AdminPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
	}

	public void enterLegalEntityInTypeAheadBox(String entity) {
		selectedEntity = entity;
		getDriver().findElement(legalEntity_type_ahead_xpath).sendKeys(entity);
		getDriver().findElement(legalEntity_type_ahead_xpath).sendKeys(Keys.RETURN);
	}

	public void enterSearchByOption(String searchBy) {
		getDriver().findElement(legalEntity_search_option_type_dropdown_id).sendKeys(searchBy);

	}

	public ResultsPage clicksOnSearchIcon() {
        try {
            Thread.sleep(1000L);
            attemptClick(legalEntity_search_button_id);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }  return new ResultsPage(getDriver(), getPageUrl(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }
}
