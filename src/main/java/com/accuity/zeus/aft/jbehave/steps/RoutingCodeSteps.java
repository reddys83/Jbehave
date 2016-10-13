package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.AreaIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingCodeSteps extends AbstractSteps {

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;
    private String selectedOffice;
    public String formerUsageOfficeName;


    @Then("the user should see the routing code basic info page")
    public void verifyRoutingCodeBasicInfoPage() {
        getRoutingCodePage().verifyRoutingCodeBasicInfoPage();
    }
    @Then("the user should see the routing code basic info values from Trusted document for routing code <routingCode> with code type <codeType>")
            public void verifyRoutingCodeBasicInfoValuesFromTrustedDoc(@Named("routingCode") String routingCode,@Named("codeType") String codeType){

            getRoutingCodePage().verifyRoutingCodeBasicInfoValuesFromTrustedDoc(routingCode,codeType);
    }

    @Then("the user should not see ABA code type specific fields in the basic info page")
    public void verifyABAFieldsNotExist()
    {
        getRoutingCodePage().verifyABAFieldsNotExist();
    }

    @When("the user clicks on the legal entity link in the routing code page header")
    public void clickonHeaderLink()
    {
        getRoutingCodePage().clickonHeaderLink();
    }
    

	@When("the user clicks on the former usages link in the navigation bar")
	public void clickOnFormerUsageLink() {
		 getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_former_usages_navigation_link"));
	}
	
	@When("the user clicks on exact match link")
	public void clickOnExactMatchLink() {
		 getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("exact_match_link"));
	}
	
	@Then("the user should verify the column names in former usage page")
	public void verifyFormerUsageColumnNames() {
		getRoutingCodePage().verifyFormerUsageColumnNames();
	}
	
	@Then("the user verifies that values in name column is in alphabetical order")
	public void verifyFormerUsagesNameColumnInAlphabeticalOrder() {
		getRoutingCodePage().verifyFormerUsagesColumnInAlphabeticalOrder(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_list"));
	}
	
	@When("the user clicks on sort button for city column")
	public void clickOnFormerUsagesCitySortButton() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_city_col"));
	}
	
	@Then("the user verifies that values in city column is in alphabetical order")
	public void verifyFormerUsagesCityColumnInAlphabeticalOrder() {
		getRoutingCodePage().verifyFormerUsagesColumnInAlphabeticalOrder(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_city_list"));
	}
	
	@When("the user clicks on sort button for area column")
	public void clickOnFormerUsagesAreaSortButton() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_area_col"));
	}
	
	@Then("the user verifies that values in area column is in alphabetical order")
	public void verifyFormerUsagesAreaColumnInAlphabeticalOrder() {
		getRoutingCodePage().verifyFormerUsagesColumnInAlphabeticalOrder(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_area_list"));
	}
	
	@When("the user clicks on the first office name link")
	public void clickOnFirstOfficeNameLink() {
		formerUsageOfficeName = getRoutingCodePage().getOfficeNameLinkText();
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_first_office_name_link"));
	}
	
	@Then("the user should see the office name basic info page")
	public void verifyOfficeNameBasicInfoPage() {
		getRoutingCodePage().verifyOfficeNameBasicInfoPage(formerUsageOfficeName);
	}
}



