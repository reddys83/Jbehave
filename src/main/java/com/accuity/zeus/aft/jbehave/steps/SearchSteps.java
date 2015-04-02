package com.accuity.zeus.aft.jbehave.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accuity.domain.legalEntity.LegalEntity;
import com.accuity.zeus.aft.page.result.ResultsListItem;
import com.accuity.zeus.aft.page.result.ResultsPage;
import com.accuity.zeus.aft.page.search.SearchPage;
import com.accuity.zeus.aft.service.legalEntity.LegalEntityDocumentService;

@Component
public class SearchSteps extends AbstractSteps {
	
	@Autowired
	private LegalEntityDocumentService legalEntityDocumentService;

	private SearchPage searchPage = null;

	private ResultsPage resultsPage = null;
	
	private Map<String, LegalEntity> expectedMap = new HashMap<String, LegalEntity>();

	@Given("a user is on the search page")
	public void givenUserIsOnSearchPage() {
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
		searchPage.open();
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
		if (searchPage != null) {
			resultsPage = searchPage.search(entity, field, value);
			setExpectedLegalEntity(entity, field, value);
		}
	}

	@Then("the results should appear correctly")
	public void thenUserShouldSeeCorrectResults() {
		if (resultsPage != null) {
			assertEquals("1", resultsPage.getNumResultsValue().getText());
			assertNotNull(resultsPage.getResults());
			assertEquals(1, resultsPage.getResults().size());
			for (ResultsListItem resultsListItem : resultsPage.getResults()) {
				resultsListItem.assertValid(expectedMap);
			}
			//resultsPage.getResults().get(0).assertValid("Bank of America National Association", "100 N Tryon St, Ste 170", "1038", "10077420", "Active");
		}
	}
	
	private void setExpectedLegalEntity(String entity, String field, String value) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("entity", entity);
		params.put("idType", field);
		params.put("id", value);
		LegalEntity instance = legalEntityDocumentService.getArbitraryEntity(params);
		if (instance != null) {
			expectedMap.put(instance.getFid(), instance);
		}
	}

}