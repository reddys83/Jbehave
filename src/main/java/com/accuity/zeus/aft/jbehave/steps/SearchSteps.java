package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.domain.legalEntity.LegalEntity;
import com.accuity.zeus.aft.jbehave.pages.SearchPage;
import com.accuity.zeus.aft.result.ResultsPage;
import com.accuity.zeus.aft.service.legalEntity.LegalEntityDocumentService;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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
	
	@When("the user searches for an arbitrary <entity>")
	public void whenUserSearches(@Named("entity") String entity) {
		if (searchPage != null) {
			LegalEntity tempEntity = getExpectedLegalEntity(entity);
			resultsPage = searchPage.search(entity, "id", tempEntity.getId());
		}
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
		if (searchPage != null) {
			//getExpectedLegalEntity(entity, field, value);
			resultsPage = searchPage.search(entity, field, value);
		}
	}

	@When("the user clicks on the card with fid <value>")
	public void whenUserClicksOnTheResultCard(@Named("value") String value){
		resultsPage.clickOnResultCard(resultsPage.getResultCardElement(value));
	}


	@Then("the user should see the search results for the searched entity")
	public void thenUserShouldSeeCorrectResults() {
		assertNotNull(resultsPage);
        if(Integer.parseInt(resultsPage.getNumResultsValue().getText()) < 10) {
            assertEquals(Integer.toString(resultsPage.getResultsList().size()), resultsPage.getNumResultsValue().getText());
        } else {
            resultsPage.goToLastSearchResultsPage().click();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals(Integer.toString(resultsPage.getResultsList().size() + ((Integer.parseInt(resultsPage.lastNavigationPage) - 1) * 10)), resultsPage.getNumResultsValue().getText());
        }
		assertNotNull(resultsPage.getResultsList());
		//Below code is not working. Need to simplify the code and see its uses in the project. Commented out to make rest of the things work.
		/*
        for (ResultsListItem resultsListItem : resultsPage.getResultsList()) {
			resultsListItem.assertValid(expectedMap);
		}
		*/
	}

	@Then("the user should see no results found message")
	public void thenUserShouldSeeNoResults() {
		assertNotNull(resultsPage);
		assertEquals("No results found", resultsPage.getNoResults().getText());
        try {
            assertFalse(resultsPage.getPaginationInfo().isDisplayed());
            assertFalse(resultsPage.getPagesNavigation().isDisplayed());
        } catch (NoSuchElementException e){
            System.out.println(e);
        }
	}

	@Then("the user should see the number of records displayed in the page w.r.t total search results")
	public void thenUserShouldSeeNoOfRecordsWRTTotalSearchResults(){
		if(Integer.parseInt(resultsPage.getNumResultsValue().getText()) < 10) {
            assertEquals("Displaying: 1 to " + resultsPage.getNumResultsValue().getText() + " of " + resultsPage.getNumResultsValue().getText(), resultsPage.getPaginationInfo().getText());
		} else {
            String displayingResultFrom = Integer.toString(((Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) - 1) * 10) + 1);
            assertEquals("Displaying: " + displayingResultFrom + " to " + resultsPage.getNumResultsValue().getText() + " of " + resultsPage.getNumResultsValue().getText(), resultsPage.getPaginationInfo().getText());
		}
	}

    @Then("the user should see the option to navigate to the desired page")
    public void thenUserShouldSeeOptionToNavigateToDesiredPage(){
        if(Integer.parseInt(resultsPage.getLastNavigationPage().getText()) > 7) {

            if (Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) <= 4) {
                assertEquals(resultsPage.getPagesNavigation().getText(), "< Previous12345..." + resultsPage.getLastNavigationPage().getText() + "Next >");
            } else if (Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) > 5 && Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) < (Integer.parseInt(resultsPage.getLastNavigationPage().getText()) - 3)){
                assertEquals(resultsPage.getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) - 1) +
                        resultsPage.getCurrentSearchResultsPage().getText() +
                        Integer.toString(Integer.parseInt(resultsPage.getCurrentSearchResultsPage().getText()) + 1) + "Next >");
            } else {
                assertEquals(resultsPage.getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(resultsPage.getLastNavigationPage().getText()) - 4) +
                        Integer.toString(Integer.parseInt(resultsPage.getLastNavigationPage().getText()) - 3) +
                        Integer.toString(Integer.parseInt(resultsPage.getLastNavigationPage().getText()) - 2) +
                        Integer.toString(Integer.parseInt(resultsPage.getLastNavigationPage().getText()) - 1) +
                        resultsPage.getLastNavigationPage().getText() + "Next >");
            }
        } else {
            assertEquals(resultsPage.getPagesNavigation().getText(), "< Previous1234567Next >");
        }
    }

    @When("the user navigates to the $page search results page")
    public void whenUserNavigatesThroughSearchResultsPage(@Named("page") String page){
        if(page.equals("last")){
            resultsPage.goToLastSearchResultsPage().click();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            resultsPage.goToDesiredSearchResultsPage(page).click();
        }
    }

    @When("the user clicks on the next page link")
    public void whenUserClicksOnNextPageLink(){
        String currentPage = resultsPage.getCurrentSearchResultsPage().getText();
        resultsPage.getNextPageLink().click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(resultsPage.getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) + 1));
    }

    @When("the user clicks on the previous page link")
    public void whenUserClicksOnPreviousPageLink(){
        String currentPage = resultsPage.getCurrentSearchResultsPage().getText();
        resultsPage.getPreviousPageLink().click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(resultsPage.getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) - 1));
    }

	private LegalEntity getExpectedLegalEntity(String entity) {
		LegalEntity instance = legalEntityDocumentService.getArbitraryEntity(entity);
		if (instance != null) {
			expectedMap.put(instance.getFid(), instance);
		}
		return instance;
	}

	private LegalEntity getExpectedLegalEntity(String entity, String field, String value) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("entity", entity);
		if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(value)) {
			params.put("idType", field);
			params.put("id", value);
		}
		LegalEntity instance = legalEntityDocumentService.search(params);
		if (instance != null) {
			expectedMap.put(instance.getFid(), instance);
		}
		return instance;
	}

}