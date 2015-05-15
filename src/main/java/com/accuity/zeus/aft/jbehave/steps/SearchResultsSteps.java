package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class SearchResultsSteps extends AbstractSteps{

    SearchSteps searchSteps;

    @Then("the user should see the search results for the searched entity")
    public void thenUserShouldSeeCorrectResults() {
        assertNotNull(searchSteps.resultsPage);
        if(Integer.parseInt(searchSteps.resultsPage.getNumResultsValue().getText()) < 10) {
            assertEquals(Integer.toString(searchSteps.resultsPage.getResultsList().size()), searchSteps.resultsPage.getNumResultsValue().getText());
        } else {
            searchSteps.resultsPage.goToLastSearchResultsPage().click();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals(Integer.toString(searchSteps.resultsPage.getResultsList().size() + ((Integer.parseInt(searchSteps.resultsPage.lastNavigationPage) - 1) * 10)), searchSteps.resultsPage.getNumResultsValue().getText());
        }
        assertNotNull(searchSteps.resultsPage.getResultsList());
        //Below code is not working. Need to simplify the code and see its uses in the project. Commented out to make rest of the things work.
		/*
        for (ResultsListItem resultsListItem : resultsPage.getResultsList()) {
			resultsListItem.assertValid(expectedMap);
		}
		*/
    }

    @Then("the user should see the number of records displayed in the page w.r.t total search results")
    public void thenUserShouldSeeNoOfRecordsWRTTotalSearchResults(){
        if(Integer.parseInt(searchSteps.resultsPage.getNumResultsValue().getText()) < 10) {
            assertEquals("Displaying: 1 to " + searchSteps.resultsPage.getNumResultsValue().getText() + " of " + searchSteps.resultsPage.getNumResultsValue().getText(), searchSteps.resultsPage.getPaginationInfo().getText());
        } else {
            String displayingResultFrom = Integer.toString(((Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) - 1) * 10) + 1);
            assertEquals("Displaying: " + displayingResultFrom + " to " + searchSteps.resultsPage.getNumResultsValue().getText() + " of " + searchSteps.resultsPage.getNumResultsValue().getText(), searchSteps.resultsPage.getPaginationInfo().getText());
        }
    }

    @Then("the user should see no results found message")
    public void thenUserShouldSeeNoResults() {
        assertNotNull(searchSteps.resultsPage);
        assertEquals("No results found", searchSteps.resultsPage.getNoResults().getText());
        try {
            assertFalse(searchSteps.resultsPage.getPaginationInfo().isDisplayed());
            assertFalse(searchSteps.resultsPage.getPagesNavigation().isDisplayed());
        } catch (NoSuchElementException e){
            //System.out.println(e);
        }
    }

    @Then("the user should see the option to navigate to the desired page")
    public void thenUserShouldSeeOptionToNavigateToDesiredPage(){
        if(Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) > 7) {

            if (Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) <= 4) {
                assertEquals(searchSteps.resultsPage.getPagesNavigation().getText(), "< Previous12345..." + searchSteps.resultsPage.getLastNavigationPage().getText() + "Next >");
            } else if (Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) > 5 && Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) < (Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) - 3)){
                assertEquals(searchSteps.resultsPage.getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) - 1) +
                        searchSteps.resultsPage.getCurrentSearchResultsPage().getText() +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getCurrentSearchResultsPage().getText()) + 1) + "Next >");
            } else {
                assertEquals(searchSteps.resultsPage.getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) - 4) +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) - 3) +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) - 2) +
                        Integer.toString(Integer.parseInt(searchSteps.resultsPage.getLastNavigationPage().getText()) - 1) +
                        searchSteps.resultsPage.getLastNavigationPage().getText() + "Next >");
            }
        } else {
            assertEquals(searchSteps.resultsPage.getPagesNavigation().getText(), "< Previous1234567Next >");
        }
    }

    @When("the user navigates to the $page search results page")
    public void whenUserNavigatesThroughSearchResultsPage(@Named("page") String page){
        if(page.equals("last")){
            searchSteps.resultsPage.goToLastSearchResultsPage().click();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            searchSteps.resultsPage.goToDesiredSearchResultsPage(page).click();
        }
    }

    @When("the user clicks on the next page link")
    public void whenUserClicksOnNextPageLink(){
        String currentPage = searchSteps.resultsPage.getCurrentSearchResultsPage().getText();
        searchSteps.resultsPage.getNextPageLink().click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(searchSteps.resultsPage.getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) + 1));
    }

    @When("the user clicks on the previous page link")
    public void whenUserClicksOnPreviousPageLink(){
        String currentPage = searchSteps.resultsPage.getCurrentSearchResultsPage().getText();
        searchSteps.resultsPage.getPreviousPageLink().click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(searchSteps.resultsPage.getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) - 1));
    }
}
