package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.SearchPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class SearchSteps extends AbstractSteps {

	private SearchPage searchPage;
	private DataPage dataPage;

	@Given("a user is on the search page")
	public void SearchPage() {
		dataPage = new DataPage(webDriverState.getWebDriver(), getDataManagementWebappUrl(), database, apacheHttpClient, restClient, heraApi);
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl(), database, apacheHttpClient, restClient, heraApi);
		setSearchPage(searchPage.goToSearchPage());
		setDataPage(dataPage);
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void search(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
			setResultsPage(getSearchPage().search(entity, field, value));
	}

	@When("the user clicks on the report tab")
    public void clickOnReportsTab(){
        setReportPage(getSearchPage().clickOnReportsTab());
    }
	@When("the user clicks on the results tab")
	public void clickOnResultsTab(){
		setResultsPage(getSearchPage().clickOnResultsTab());
	}

	@When("the user clicks on the logout link in the search page")
	public void clickOnLogout(){
		setLoginPage(getSearchPage().clickOnLogout());
	}

	@When("the user moves the cursor to the settings in the search page")
	public void moveCursorToSettings(){
		getSearchPage().moveCursorToSettings();
	}

	@When("the user clicks on the data tab in the search page")
	public void clickOnDataTab(){
		setDataPage(searchPage.clickOnDataTab());
	}

	@When("the user clicks on the admin tab in the search page")
	public void clickOnAdminTab() {
		setAdminPage(searchPage.clickOnAdminTab());
	}

	@When("the user enters the <entity> in the typeahead")
	public void enterLegalEntityInTypeAheadBox(@Named("entity") String entity) {
		getSearchPage().enterLegalEntityInTypeAheadBox(entity);
	}

	@When("the user selects the <searchBy> from the dropdown")
	public void enterSearchByOption(@Named("searchBy") String searchBy) {
		getSearchPage().enterSearchByOption(searchBy);
	}

	@When("the user clicks on the search button")
	public void clicksOnSearchIcon() {
		setResultsPage(getSearchPage().clicksOnSearchIcon());
	}
	
	@Then("the user should see the message $message in search box")
	public void verifyRoutingCodeSearchText(@Named("message") String message) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getSearchPage().verifyRoutingCodeSearchText(message);
	}

	@Then("the user should not see the message $message in search box")
	public void verifyRoutingCodeSearchTextNoDisplay(@Named("message") String message) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getSearchPage().verifyRoutingCodeSearchText(message);
	}

	@When("the user clears the entity value in type ahead box")
	public void clearEntityInTypeAheadBox() {
		getSearchPage().clearEntityInTypeAheadBox();
	}
}