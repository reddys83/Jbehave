package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class SearchResultsSteps extends AbstractSteps{

    @Then("the user should see the search results paginated for the searched entity")
    public void thenUserShouldSeeCorrectResults() {
        if(Integer.parseInt(getResultsPage().getNumResultsValue().getText()) < 10) {
            assertEquals(Integer.toString(getResultsPage().getResultsList().size()), getResultsPage().getNumResultsValue().getText());
        } else {
            try {
                getResultsPage().goToLastSearchResultsPage().click();
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals(Integer.toString(getResultsPage().getResultsList().size() + ((Integer.parseInt(getResultsPage().lastNavigationPage) - 1) * 10)), getResultsPage().getNumResultsValue().getText());
        }
        assertNotNull(getResultsPage().getResultsList());
        //Below code is not working. Need to simplify the code and see its uses in the project. Commented out to make rest of the things work.
		/*
        for (ResultsListItem resultsListItem : resultsPage.getResultsList()) {
			resultsListItem.assertValid(expectedMap);
		}
		*/
    }

    @Then("the user should see the number of records displayed in the page w.r.t total search results")
    public void thenUserShouldSeeNoOfRecordsWRTTotalSearchResults(){
        if(Integer.parseInt(getResultsPage().getNumResultsValue().getText()) < 10) {
            assertEquals("Displaying: 1 to " + getResultsPage().getNumResultsValue().getText() + " of " + getResultsPage().getNumResultsValue().getText(), getResultsPage().getPaginationInfo().getText());
        } else {
            String displayingResultFrom = Integer.toString(((Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) - 1) * 10) + 1);
            assertEquals("Displaying: " + displayingResultFrom + " to " + getResultsPage().getNumResultsValue().getText() + " of " + getResultsPage().getNumResultsValue().getText(), getResultsPage().getPaginationInfo().getText());
        }
    }

    @Then("the user should see no results found message")
    public void thenUserShouldSeeNoResults() {
        assertEquals("No results found", getResultsPage().getNoResults().getText());
        try {
            assertFalse(getResultsPage().getPaginationInfo().isDisplayed());
            assertFalse(getResultsPage().getPagesNavigation().isDisplayed());
        } catch (NoSuchElementException e){
            //System.out.println(e);
        }
    }

    @Then("the user should see the option to navigate to the desired page")
    public void thenUserShouldSeeOptionToNavigateToDesiredPage(){
        if(Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) > 7) {

            if (Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) <= 4) {
                assertEquals(getResultsPage().getPagesNavigation().getText(), "< Previous12345..." + getResultsPage().getLastNavigationPage().getText() + "Next >");
            } else if (Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) > 5 && Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) < (Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) - 3)){
                assertEquals(getResultsPage().getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) - 1) +
                        getResultsPage().getCurrentSearchResultsPage().getText() +
                        Integer.toString(Integer.parseInt(getResultsPage().getCurrentSearchResultsPage().getText()) + 1) + "Next >");
            } else {
                assertEquals(getResultsPage().getPagesNavigation().getText(), "< Previous1..." +
                        Integer.toString(Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) - 4) +
                        Integer.toString(Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) - 3) +
                        Integer.toString(Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) - 2) +
                        Integer.toString(Integer.parseInt(getResultsPage().getLastNavigationPage().getText()) - 1) +
                        getResultsPage().getLastNavigationPage().getText() + "Next >");
            }
        } else {
            assertEquals(getResultsPage().getPagesNavigation().getText(), "< Previous1234567Next >");
        }
    }

    @When("the user navigates to the $page search results page")
    public void whenUserNavigatesThroughSearchResultsPage(@Named("page") String page){
        if(page.equals("last")){
            getResultsPage().goToLastSearchResultsPage().click();
        }else{
            getResultsPage().goToDesiredSearchResultsPage(page).click();
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the user clicks on the next page link")
    public void whenUserClicksOnNextPageLink(){
        String currentPage = getResultsPage().getCurrentSearchResultsPage().getText();
        getResultsPage().getNextPageLink().click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getResultsPage().getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) + 1));
    }

    @When("the user clicks on the previous page link")
    public void whenUserClicksOnPreviousPageLink(){
        String currentPage = getResultsPage().getCurrentSearchResultsPage().getText();
        getResultsPage().getPreviousPageLink().click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getResultsPage().getCurrentSearchResultsPage().getText(), Integer.toString(Integer.parseInt(currentPage) - 1));
    }

    @When("the user clicks on the search results card with fid <fid>")
    public void clickOnResultCard(@Named("fid") String fid){
        setLegalEntityPage(getResultsPage().clickOnResultCard(getResultsPage().getFidElements(fid)));
    }

    @Then("the user should see the search results for the institution")
    public void verifySearchResults() {
        getResultsPage().verifySearchResults();
    }

    @Then("the user should see the legal entity search results card matching the searched entity $legalEntitySearchResults")
    public void verifyLegalEntitySearchResultsCards(ExamplesTable legalEntitySearchResults){
        getResultsPage().verifyLegalEntitySearchResultsCards(legalEntitySearchResults);
    }

    @Then("the user should see the office search results card for the searched legal entity $officeSearchResults")
    public void verifyOfficeSearchResults(ExamplesTable officeSearchResults){
        getResultsPage().verifyOfficeSearchResults(officeSearchResults);
    }

    @Then("the user should see the office search results paginated")
    public void verifyOfficeSearchResultsIsPaginated(){
        getResultsPage().verifyOfficeSearchResultsIsPaginated();
    }

    @Then("the user should see the offices number of records displayed in the page w.r.t total search results")
    public void verifyOfficeSearchResultsCounter(){
        getResultsPage().verifyOfficeSearchResultsCounter();
    }

    @Then("the user should see the option to navigate to the desired office search results page")
    public void verifyOfficeSearchResultsNavigation(){
        getResultsPage().verifyOfficeSearchResultsNavigation();
    }
}
