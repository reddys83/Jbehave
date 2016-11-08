package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.TaxonomiesIdentifiers;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminSteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;


    @Then("the user should see the list of all existing taxonomies by name")
    public void verifyTaxonomiesList(){
        getAdminPage().verifyTaxonomiesList(database, apacheHttpClient);
    }

    @Then("the user should be able to see text choose a taxonomy in black color")
    public void verifyChooseATaxonomyTextColor(){
        getAdminPage().verifyChooseATaxonomyTextColor();
    }

    @When("the user clicks on the taxonomies tab in the data area")
    public void clickOnTaxonomiesTab(){
        getAdminPage().clickOnTaxonomiesTab();
    }

    @When("the user clicks on the choose a taxonomy option")
    public void clickOnChooseATaxonomy(){
        getAdminPage().clickOnChooseATaxonomy();
    }

    @When("the user starts typing the name of a taxonomy as $taxonomy in the taxonomy input box")
    public void enterTaxonomy(@Named("taxonomy") String taxonomy){
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

    @When("the user enters the taxonomy <taxonomy> in the type-ahead box")
    public void enterTaxonomyInTheTypeAheadBox(@Named("taxonomy") String taxonomy){
        getAdminPage().enterTaxonomyInTheTypeAheadBox(taxonomy);
    }

    @Then("the user should see the taxonomy's entry as: $taxonomyEntry")
    public void verifyTaxonomiesEntry(ExamplesTable taxonomyEntry){
        getAdminPage().verifyTaxonomiesEntry(taxonomyEntry);
    }
    
    @Then("the user should not see any sub-grouping for the selected taxonomy")
    public void verifyNoSubGroupingForSelectedTaxonomy() {
    	getDataPage().verifyElementNotExistInUI(TaxonomiesIdentifiers.getObjectIdentifier("taxonomies_sub_groupings"));
    }
    
    @Then("the user should see that the taxonomies update button is displayed")
    public void verifyTaxonomiesUpdateButtonIsDisplayed() {
    	getDataPage().verifyElementIsDisplayed("Taxonomies Update button", TaxonomiesIdentifiers.getObjectIdentifier("taxonomies_update_button"));
    }
    
    @Then("the user verifies the taxonomy name in the category header")
    public void verifyTaxonomyNameInCategoryHeader(@Named("taxonomy") String taxonomy) {
    	getDataPage().verifyWebElementText("Taxonomy Category Header", taxonomy.toUpperCase(), TaxonomiesIdentifiers.getObjectIdentifier("taxonomies_category_header"));
    }
}
