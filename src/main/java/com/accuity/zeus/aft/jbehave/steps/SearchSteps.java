package com.accuity.zeus.aft.jbehave.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.page.result.ResultsPage;
import com.accuity.zeus.aft.page.search.SearchPage;

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

	@Then("the results should appear correctly")
	public void thenUserShouldSeeCorrectResults() {
		if (resultsPage != null) {
			assertEquals("1", resultsPage.getNumResultsValue().getText());
			assertNotNull(resultsPage.getResults());
			assertEquals(1, resultsPage.getResults().size());
			/*
			for (ResultsListItem resultsListItem : resultsPage.getResults()) {
				resultsListItem.assertValid(name, address, fid, tfpid, status)
			}
			*/
			resultsPage.getResults().get(0).assertValid("Bank of America National Association", "100 N Tryon St, Ste 170", "1038", "10077420", "Active");
		}
	}

}