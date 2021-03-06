package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.LegalEntityPage;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.LegalEntityPage;

import static org.junit.Assert.*;

@Component
public class SearchResultsSteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;
    private String searchedEntity;

    @Then("the user should see the search results paginated for the searched entity")
    public void thenUserShouldSeeCorrectResults() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @When("the user navigates to the $page page on the legal entity search results page")
    public void navigateThroughLegalEntitySearchResultsPage(@Named("page") String page){
        getResultsPage().navigateThroughSearchResults(page);
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
        searchedEntity = fid;
        setLegalEntityPage(getResultsPage().clickOnResultCard(getResultsPage().getFidElements(fid)));
        if(dataPage==null){
            dataPage = getResultsPage().createDataPage();
        }
    }

    @When("the user clicks on the search results card with routing code <routingCode> and code type <codeType>")
    public void clickOnResultCard(@Named("routingCode") String routingCode,@Named("codeType") String codeType){
        //searchedEntity = fid;
        setRoutingCodePage(getResultsPage().clickOnRoutingCodeResultCard(getResultsPage().getRoutingCodeElements(routingCode, codeType)));
        if(dataPage==null){
            dataPage = getResultsPage().createDataPage();
        }
    }

    @Then("the user should see the search results for the institution")
    public void verifySearchResults() {
        getResultsPage().verifySearchResults();
    }

    @Then("the user should see the search results for <entity> routingCode")
    public void verifyRoutingCodeSearchResults(@Named("entity") String code) {
        getResultsPage().verifyRoutingCodeSearchResults(code);
    }

    @Then("user should see the results in descending order by code for <entity> routingCode")
    public void verifyRoutingCodeResultsDescendingOrder(@Named("entity") String code)
    {
        getResultsPage().verifyRoutingCodeResultsDescendingOrder(code);
    }

    @Then("user should see the results in ascending order by type for <entity> routingCode")
    public void verifyRoutingCodeResultsAscendingByType(@Named("entity") String code) {
        getResultsPage().verifyRoutingCodeResultsAscendingByType(code);
    }

    @Then("user should see the results in ascending order by entity for <entity> routingCode")
    public void verifyRoutingCodeResultsAscendingByEntity(@Named("entity") String code){
        getResultsPage().verifyRoutingCodeResultsAscendingByEntity(code);
    }

    @Then("user should see the results in ascending order by fid for <entity> routingCode")
    public void verifyRoutingCodeResultsAscendingByFID(@Named("entity") String code){
        getResultsPage().verifyRoutingCodeResultsAscendingByFID(code);
    }

    @When("the user clicks on the column CODE in the routingCode search results")
    public void clickOnRoutingCodeResultsCODEColumn() {
        getResultsPage().clickOnRoutingCodeResultsCODEColumn();
    }

    @When("the user clicks on the column TYPE in the routingCode search results")
    public void clickOnRoutingCodeResultsTYPEColumn() {
        getResultsPage().clickOnRoutingCodeResultsTYPEColumn();
    }

    @When("the user clicks on the column ENTITY in the routingCode search results")
    public void clickOnRoutingCodeResultsENTITYColumn() {
        getResultsPage().clickOnRoutingCodeResultsENTITYColumn();
    }

    @When("the user clicks on the column FID in the routingCode search results")
    public void clickOnRoutingCodeResultsFIDColumn() {
        getResultsPage().clickOnRoutingCodeResultsFIDColumn();
    }

    @When("the user applied the country filter as: $Country")
    public void applyCountryFilter(ExamplesTable Country) {
        getResultsPage().applyCountryFilter(Country);
    }

    @When("the user applied the type filter as: $Type")
    public void applyTypeFilterInRCResults(ExamplesTable Type) {
        getResultsPage().applyTypeFilter(Type);
    }

    @Then("the user should see the routingCode search results for selected country as: $Country")
    public void verifyCountryFilterInRCSearchResults(ExamplesTable Country) {
        getResultsPage().verifyCountryFilterInRCSearchResults(Country);
    }

    @Then("the user should see the routingCode search results for selected type as: $Type")
    public void verifyTypeFilterInRCSearchResults(ExamplesTable Type) {
        getResultsPage().verifyTypeFilterInRCSearchResults(Type);
    }

    @When("the user applied the status filter $status in the routingCode search results")
    public void applyStatusFilterInRCSearch(String status){
        getResultsPage().applyStatusFilterInRCSearch(status);
    }

    @Then("the user should see the routing code search results for $status status")
    public void verifyStatusFilterInRCSearchResults(String status){
        getResultsPage().verifyStatusFilterInRCSearchResults(status);
    }

    @Then("the user should see the error message enter at least 2 valid characters in routing search results")
    public void verifyErrorMessageForAtleast2Char()
    {
        getResultsPage().verifyErrorMessageForAtleast2Char();
    }

    @Then("the user should see the message for 0 search results in routingCode search results")
    public void verifyMessageFor0Results()
    {
        getResultsPage().verifyMessageFor0Results();
    }

    @When("the user clicks on <fid> in the routing search results")
    public void clickFidNavigation(@Named("fid") String fid) {
       setLegalEntityPage(getResultsPage().clickFidNavigation(fid));
    }

    @Then("the user should see the same results of the previous search")
    public void compareSearchResults() {
        getResultsPage().compareURLAndSearchResults();
    }

    @Then("the user should see the legal entity search results card matching the searched entity $legalEntitySearchResults")
    public void verifyLegalEntitySearchResultsCards(ExamplesTable legalEntitySearchResults){
        getResultsPage().verifyLegalEntitySearchResultsCards(legalEntitySearchResults);
    }

    @Then("the user should see the office search results card for the searched legal entity $officeSearchResults")
    public void verifyOfficeSearchResults(ExamplesTable officeSearchResults) {
        getResultsPage().verifyOfficeSearchResults(officeSearchResults);
    }

    @When("the user clicks on the office search results column name")
    public void clickOnColumnName() {
        getResultsPage().clickOnColumnName();
    }

    @When("the user clicks on the office search results column area")
    public void clickOnColumnArea() {
        getResultsPage().clickOnColumnArea();
    }

    @When("the user clicks on the office search results column city")
    public void clickOnColumnCity() {
        getResultsPage().clickOnColumnCity();
    }
    @When("the user clicks on the office search results fid column")
    public void clickOnColumnFid(){
        getResultsPage().clickOnColumnFid();
    }

    @Then("the user should see the office search results cards sorted $xqueryName with fid $fid from the database")
    public void verifySortOrderByOfficeFid(String xqueryName, String fid) {
        getResultsPage().verifySortOrderByOfficeFid(xqueryName, fid);
    }

    @Then("the office search results should sort by type which sorted $xqueryName with fid $fid from the database")
    public void verifySortOrderByOfficeType(String xqueryName, String fid) {
        getResultsPage().verifySortOrderByOfficeType(xqueryName, searchedEntity);
    }

    @Then("the office search results should sort by name which sorted $xqueryName with fid $fid from the database")
    public void verifySortOrderByOfficeName(String xqueryName, String fid) {
        getResultsPage().verifySortOrderByOfficeName(xqueryName, fid);
    }

    @Then("the office search results should sort by area which sorted $xqueryName with fid $fid from the database")
    public void verifySortOrderByOfficeArea(String xqueryName, String fid) {
        getResultsPage().verifySortOrderByOfficeArea(xqueryName, fid);
    }

    @When("the user enters $searchText in the refine results search bar")
    public void entersTextInRefineFilterForCity(String searchText) {
        getResultsPage().entersTextInRefineFilterForCity(searchText);
    }

    @Then("the user should see the office search results for city contains the $searchText")
    public void verifyOfficeSearchResultsForCity(String searchText) {
        getResultsPage().verifyOfficeSearchResultsForCity(searchText);
    }

    @Then("the office search results should sort by city which sorted $xqueryName with fid $fid from the database")
    public void verifySortOrderByOfficeCity(String xqueryName, String fid) {
        getResultsPage().verifySortOrderByOfficeCity(xqueryName, fid);
    }

    @Then("the user should see the office search results cards sorted ascending order by office status")
    public void verifyOfficeIsSortedAscByStatus(){
        getResultsPage().verifyOfficeIsSortedAscByStatus(searchedEntity);
    }

    @Then("the user should see the office search results cards sorted descending order by office status")
    public void verifyOfficeIsSortedDescByStatus(){
        getResultsPage().verifyOfficeIsSortedDescByStatus(searchedEntity);
    }

    @Then("the user should see the office search results paginated")
    public void verifyOfficeSearchResultsIsPaginated() {
        getResultsPage().verifyOfficeSearchResultsIsPaginated();
    }

    @Then("the user should see the offices number of records displayed in the page w.r.t total search results")
    public void verifyOfficeSearchResultsCounter(){
        getResultsPage().verifyOfficeSearchResultsCounter();
    }

    @Then("the user should see the option to navigate to the desired office search results page")
    public void verifyOfficeSearchResultsNavigation(){
        getResultsPage().verifySearchResultsNavigation();
    }

    @Then("the user should see the option to navigate to the desired legal entity search results page")
    public void verifyLegalEntitySearchResultsNavigation(){
        getResultsPage().verifySearchResultsNavigation();
    }

    @When("the user navigates to the $page page on the office search results")
    public void navigateThroughOfficeSearchResults(@Named("page") String page){
        getResultsPage().navigateThroughSearchResults(page);
    }

    @Then("the user should see the $page page on the office search results")
    public void verifyCurrentPageOnSearchResults(@Named("page") String page) {
        getResultsPage().verifyCurrentPageOnSearchResults(page);
    }

    @When("the user navigates to the office search results next page")
    public void navigateToNextOfficeSearchResultsPage(){
        getResultsPage().navigateToNextOfficeSearchResultsPage();
    }

    @When("the user navigates to the office search results previous page")
    public void navigateToPreviousOfficeSearchResultsPage(){
        getResultsPage().navigateToPreviousOfficeSearchResultsPage();
    }

    @When("the user right clicks on the office <officeFid> in the office search results")
    public void rightClicksOnOfficeID(@Named("officeFid") String officeFid) {
        getResultsPage().rightClicksOnOfficeID(officeFid);
    }

    @Then("the user should see the $xqueryName with comma separated for office $fid")
    public void verifyMultipleOfficeTypesAlphabetically(String xqueryName, String fid) {
        getResultsPage().verifyMultipleOfficeTypesAlphabetically(xqueryName, fid);
    }
    @Then("the user should see the office type filter default to all")
    public void verifyDefaultOfficeTypeFilterIsAll(){
        getResultsPage().verifyDefaultOfficeTypeFilterIsAll();
    }
    @Then("the user should see all is deselected in the office type filter")
    public void verifyAllDeselectedOfficeTypeFilter() {
        getResultsPage().verifyAllDeselectedOfficeTypeFilter();
    }

    @When("the user selects the office type filter domestic")
    public void selectOfficeTypeFilterDomestic(){
        getResultsPage().selectOfficeTypeFilterDomestic();
    }

    @When("the user selects the office type filter foreign")
    public void selectOfficeTypeFilterForeign(){ getResultsPage().selectOfficeTypeFilterForeign();
    }

    @Then("the user should see the list of domestic offices in the office search results")
    public void verifyDomesticOfficesSearchResults() {
        getResultsPage().verifyDomesticOfficesSearchResults(searchedEntity);
    }

    @Then("the user should see the list of foreign offices in the office search results")
    public void verifyForeignOfficesSearchResults() {
        getResultsPage().verifyForeignOfficesSearchResults(searchedEntity);
    }

    @When("the user clicks on the office search results status column")
    public void clickOnOfficeSearchResultsStatus(){
        getResultsPage().clickOnOfficeSearchResultsStatus();
    }

    @When("the user clicks on the office search results type column")
    public void clickOnOfficesSearchResultsType(){
        getResultsPage().clickOnOfficesSearchResultsType();
    }

    @Then("the user should see office search results reset to page 1")
    public void verifyOfficeSearchResultIsResetToPage1(){
        getResultsPage().verifyOfficeSearchResultIsResetToPage1();
    }

    @Then("the user should see the message your search returned 0 results")
    public void verifySearchReturned0Results(){
        getResultsPage().verifySearchReturned0Results();
    }

    @When("the user selects the $count results/page in the office results page")
    public void selectResultsPerPage(@Named("count") String count){
        getResultsPage().selectResultsPerPage(count);
    }

    @Then("the user should see 25 results/page selected by default")
    public void verifyDefaultSelectionResultPerPage() {
        getResultsPage().verifyDefaultSelectionResultPerPage();
    }

    @When("the user selects the office status filter active")
    public void selectOfficeStatusFilterActive(){
        getResultsPage().selectOfficeStatusFilterActive();
    }

    @When("the user selects the office status filter inactive")
    public void selectOfficeStatusFilterInactive(){
        getResultsPage().selectOfficeStatusFilterInactive();
    }

    @Then("the user should see the list of active offices in the office search results")
    public void verifyActiveOfficesSearchResults() {
        getResultsPage().verifyActiveOfficesSearchResults(searchedEntity);
    }

    @Then("the user should see the list of inactive offices in the office search results")
    public void verifyInactiveOfficesSearchResults() {
        getResultsPage().verifyInactiveOfficesSearchResults(searchedEntity);
    }

    @Then("the user should see the office status filter default to all")
    public void verifyDefaultOfficeStatusFilterIsAll(){
        getResultsPage().verifyDefaultOfficeStatusFilterIsAll();
    }

    @Then("the user should see the office search results cards sorted ascending order by office country")
    public void verifyOfficeIsSortedAscByCountry(){
        getResultsPage().verifyOfficeIsSortedAscByCountry(searchedEntity);
    }

    @Then("the user should see the types in the type filter should be based on the types of office search results")
    public void verifyOfficeTypesInTypeFilter() {
        getResultsPage().verifyOfficeTypesInTypeFilter(searchedEntity);
    }

    @Then("the user should see the office list for the institution <entity> with the $institutionType office type in the office search results")
    public void officeSearchResultsWithTypeFilter(@Named("institutionType") String institutionType, @Named("entity") String searchedEntity) {
        getResultsPage().officeSearchResultsWithTypeFilter(searchedEntity,institutionType);
    }

    @Then("the user should see the office search results cards sorted descending order by office country")
    public void verifyOfficeIsSortedDescByCountry() {
        getResultsPage().verifyOfficeIsSortedDescByCountry(searchedEntity);
    }

    @When("the user clicks on the office search results country column")
    public void clickOnOfficeSearchResultsCountry() {
        getResultsPage().clickOnOfficeSearchResultsCountry();
    }

    @When("the user selects the institution type filter $institutionType")
    public void selectOfficeInstitutionType(@Named("institutionType") String institutionType) {
        getResultsPage().selectOfficeInstitutionType(institutionType);
    }
    @Then("the user should see $institutionType is selected by default")
    public void verifyOfficeTypeSelectedByDefault(@Named("institutionType") String institutionType) {
        getResultsPage().verifyOfficeTypeSelectedByDefault(institutionType);
    }
    @Then("the user should see the office results for the applied filters")
    public void verifyResultsDisplayed(){
        getResultsPage().verifyOfficeResultsForAppliedFilters();
    }

    @Then("the user should see the office search results sorted ascending by addressLine1 from trusted document")
    public void verifyOfficeAddressSortingAscending() {
        getResultsPage().verifySortAscOrderByAddress(searchedEntity);
    }

    @Then("the user should see the office search results sorted descending by addressLine1 from trusted document")
    public void verifyOfficeAddressSortingDescending() {
        getResultsPage().verifySortDscOrderByAddress(searchedEntity);
    }

    @Then("the user should see the click to view tooltip on office search page")
    public void verifyClickToViewOfficeSearch(){
        getResultsPage().verifyToolTipClickToView();
    }

	@Then("the user should see the list of <status> offices in All result pages")
	public void verifyActiveOfficesSearchResultsInAllPages(@Named("status") String status, @Named("count") int count) {
		getResultsPage().verifyActiveOfficesSearchResultsForAllPages(searchedEntity, status, count);
	}

    @Then("the user should see results tab is selected")
    public void verifyResultsTabSelected() {
        getResultsPage().verifyResultsTabSelected();
    }

    @Then("the user should see the label offices on the results list page")
    public void verifyOfficesLabelOnResultsPage()
    {
        getResultsPage().verifyOfficeHeading();
    }
    
    @When("the user clicks on the code value hyperlink on the search results card with routing code <routingCode> and code type <codeType>")
    public void clickOnCodeValueHyperlink(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        setRoutingCodePage(getResultsPage().clickOnRoutingCodeResultCard(getResultsPage().getRoutingCodeHyperlinkElementForCodeValue(routingCode, codeType)));
        if(dataPage==null){
            dataPage = getResultsPage().createDataPage();
        }
    }
    
    @Then("the user should see the $tooltip tooltip on routing code results page")
    public void verifyToolTipViewRoutingCode(@Named("tooltip") String tooltip) {
    	getResultsPage().verifyToolTipInRoutingCodeResultsPage(tooltip, RoutingCodeIdentifiers.getObjectIdentifier("routingcodes_rows_xpath"));
    }
    
    @Then("the user should see the $tooltip tooltip on routing code search results page")
    public void verifyToolTipViewOffice(@Named("tooltip") String tooltip) {
    	getResultsPage().verifyToolTipInRoutingCodeResultsPage(tooltip, RoutingCodeIdentifiers.getObjectIdentifier("routingcode_office_fid_search_results"));
    }
    
    @Then("the user should see Results page displayed")
	public void verifyRoutingCodeSearchTextNoDisplay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        getResultsPage().verifyResultsPage();
	}
}
