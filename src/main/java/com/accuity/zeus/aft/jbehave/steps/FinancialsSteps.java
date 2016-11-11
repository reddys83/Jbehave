package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;

/**
 * Created by tubatil on 10/31/2016.
 */
@Component
public class FinancialsSteps  extends AbstractSteps{
  
    @Then("the user should see the missing items retrieved from $source document")
	public void verifyHistoryValuesFromTrusted(@Named("entityFid") String entityFid, @Named("source") String source) {
		getFinancialsPage().verifyMissingItemsFromTrusted(entityFid, source);
	}
    
	@When("the user clicks on the <financialStatementDate> in financial page")
	public void clickOnFinancialsStatement(@Named("financialStatementDate") String financialStatementDate) {
		getFinancialsPage().clickOnFinancialStatement(financialStatementDate);
	}
	
	@When("the user selects 'Alternate of Statement' hyperlink")
	public void clickLinkAlternateStatement(){
		getDataPage().attemptClick(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link_xpath"));
	}
	
	@When("the user clicks on 'Alternate Entity' hyperlink")
	public void clickLinkAlternateEntity(){
		getDataPage().attemptClick(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link_xpath"));
	}
	
	@Then("the user should see Legal Entity basic info page is dispayed")
	public void verifyLegalEntityBasicInfoPage(){
		getDataPage().attemptClick(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link_xpath"));
	}
	
	@Then("the user should see details screen for the linked Financial Statement is displayed")
	public void verifyLinkedFinancialStatementIsDisplayed(){
		getDataPage().attemptClick(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link_xpath"));
	}
}
