package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.SearchPage;
import com.accuity.zeus.aft.result.ResultsPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchSteps extends AbstractSteps {

	private SearchPage searchPage;

	@Given("a user is on the search page")
	public void givenUserIsOnSearchPage() {
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
		setSearchPage(searchPage.goToSearchPage());
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
			setResultsPage(getSearchPage().search(entity, field, value));
	}

	@When("the user clicks on the report tab")
    public void whenUserClicksOnReportTab(){
        setReportPage(getSearchPage().clickOnReportsTab());
    }


	@When("the user clicks on the logout link in the search page")
	public void whenUserClicksLogout(){
		setLoginPage(getSearchPage().clickOnLogout());
	}

	@When("the user moves the cursor to the settings in the search page")
	public void userMovesCursorToSettings(){
		getSearchPage().moveCursorToSettings();
	}

	@When("the user clicks on the data tab in the search page")
	public void whenUserClicksOnDataTab(){
		setDataPage(searchPage.clickOnDataTab());
	}
}