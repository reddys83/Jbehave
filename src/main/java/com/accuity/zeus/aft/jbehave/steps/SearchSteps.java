package com.accuity.zeus.aft.jbehave.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.page.result.ResultsPage;
import com.accuity.zeus.aft.page.search.SearchPage;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchSteps extends AbstractSteps {

	private SearchPage searchPage = null;

	private ResultsPage resultsPage = null;

	@Given("a user is on the search page")
	public void givenUserIsOnSearchPage() {
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
		searchPage.open();
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
		if (searchPage != null) {
			resultsPage = searchPage.search(entity, field, value);
		}
	}

	@Then("the results should appear correctly $table")
	public void thenUserShouldSeeCorrectResults(ExamplesTable table) {
		if (resultsPage != null) {
			assertEquals("1", resultsPage.getNumResultsValue().getText());
			assertNotNull(resultsPage.getResultsList());
			assertEquals(1, resultsPage.getResultsList().size());
			for (int i = 0; i < table.getRowCount(); i++) {
				resultsPage.getResultsList().get(i).assertValid(table.getRow(i).get(table.getHeaders().get(0)), table.getRow(i).get(table.getHeaders().get(1)), table.getRow(i).get(table.getHeaders().get(2)), table.getRow(i).get(table.getHeaders().get(3)), table.getRow(i).get(table.getHeaders().get(4)));
			}
		}
	}

	@Then("there should be no results $table")
	public void thenUserShouldSeeNoResults(ExamplesTable table) {
		if (resultsPage != null) {
			for (int i = 0; i < table.getRowCount(); i++) {
				assertEquals(resultsPage.getResultsList().get(i).getNoResults(), table.getRow(i).get(table.getHeaders().get(0)));
			}
		}
	}

}