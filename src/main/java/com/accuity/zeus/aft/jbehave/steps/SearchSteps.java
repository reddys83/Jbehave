package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.domain.legalEntity.LegalEntity;
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
	public static ResultsPage resultsPage;
	public static DataPage dataPage;

	private Map<String, LegalEntity> expectedMap = new HashMap<String, LegalEntity>();

	@Given("a user is on the search page")
	public void givenUserIsOnSearchPage() {
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
		searchPage.open();
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
		if (searchPage != null) {
			//getExpectedLegalEntity(entity, field, value);
			resultsPage = searchPage.search(entity, field, value);
		}
	}

	@When("the user clicks on the report tab")
    public void whenUserClicksOnReportTab(){
        setReportPage(searchPage.clickOnReportsTab());
    }

	@When("the user clicks on the data tab in the search page")
	public void whenUserClicksOnDataTab(){
		setDataPage(searchPage.clickOnDataTab());
	}
}