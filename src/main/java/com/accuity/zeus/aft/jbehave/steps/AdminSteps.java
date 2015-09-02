package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.stereotype.Component;

@Component
public class AdminSteps extends AbstractSteps{

    @Then("the user should see the list of all existing taxonomies by name")
    public void thenUserShouldSeeListOfAllTaxonomies(){
        getAdminPage().verifyTaxonomiesList();
    }

    @When("the user clicks on the taxonomies tab in the data area")
    public void whenTheUserClicksOnTheTaxonomiesTab(){
        getAdminPage().clickOnTaxonomiesTab();
    }

    @When("the user clicks on the choose a taxonomy option")
    public void whenUserClicksOnChooseTaxonomy(){
        getAdminPage().clickOnChooseATaxonomy();
    }

    @When("the user starts typing the name of a taxonomy as $taxonomy in the taxonomy input box")
    public void whenTheUserStartsTypingTaxonomy(@Named("taxonomy") String taxonomy){
        getAdminPage().enterTaxonomy(taxonomy);
    }

    @Then("the user should see the drop-down list of the taxonomies matching the input characters")
    public void thenUserShouldSeeCurrencyDropDownMatchingTheSearchString(){
        getAdminPage().verifyTaxonomyDropDownMatchesSearchString();
    }

    @Then("the user should see the option no results match for the searched taxonomy string")
    public void thenTheUSerShouldNoResultsMatchOption(){
        getAdminPage().verifyNoResultsMatchOption();
    }

    @Then("the list should not have any duplicates")
    public void verifyNoDuplicatesInList(){
        getAdminPage().verifyNoDuplicatesInList();
    }

    @When("the user enters the taxonomy <taxonomy> in the type-ahead box")
    public void enterTaxonomyInTheTypeAheadBox(@Named("taxonomy") String taxonomy){
        getAdminPage().enterTaxonomyInTheTypeAheadBox(taxonomy);
    }

    @Then("the user should see the taxonomy's entry as: $taxonomyEntry")
    public void verifyTaxonomiesEntry(ExamplesTable taxonomyEntry){
        getAdminPage().verifyTaxonomiesEntry(taxonomyEntry);
    }
}