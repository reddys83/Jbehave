package com.accuity.zeus.aft.jbehave.steps;

import java.util.ArrayList;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;
import org.jbehave.core.annotations.When;
import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;

/**
 * Created by tubatil on 10/31/2016.
 */
@Component
public class FinancialsSteps  extends AbstractSteps{
	public String financialAlternateEntityName;
	public String financialAlternateStatementName;

	@Then("the user should see legalEntity financialStatements for legalEntity <fid> in the left side menu bar")
	public void verifyLegalEntityFinancialStatements(@Named("fid") String fid) {
		getFinancialsPage().verifyLegalEntityFinancialStatements(fid);
	}
    
    @Then("the user should see the displayDate <dateIndex> should be the prefix to the Section Header 'FINANCIALS'")
	public void verifyFinancialsHeading(@Named("dateIndex") int dateIndex) {
    	ArrayList<String> displayDatesInUI = getFinancialsPage().getDisplayDates();
		getFinancialsPage().verifyFinancialsHeadingText(displayDatesInUI.get(dateIndex-1));
	}

    @Then("the user should see the financials section field values same as in the trusted document of <fid> for displayDate <dateIndex>")
    public void verifyFinancialsFieldValues(@Named("fid")String fid, @Named("dateIndex") int dateIndex){
    	ArrayList<String> displayDatesInUI = getFinancialsPage().getDisplayDates();
        getFinancialsPage().verifyFinancialsFieldValues(fid, displayDatesInUI.get(dateIndex-1));
    }

    @Then("the user verifies Audited by field is displayed only when Audited field is true")
    public void verifyAuditedByField(){
        getFinancialsPage().verifyAuditedByField();
    }
    
    @When("the user clicks on displayDate <dateIndex> on the left navigation")
    public void clickPeriodEndDate(@Named("dateIndex") int dateIndex){    	    	
    	getFinancialsPage().clickPeriodEndDateWithIndex(dateIndex);
    }
    
    @Then("the user should see the missing items retrieved from $source document")
	public void verifyHistoryValuesFromTrusted(@Named("fid") String fid,@Named("displayDate") String displayDate, @Named("source") String source) {
		getFinancialsPage().verifyMissingItemsFromTrusted(fid,displayDate, source);
	}

	@When("the user clicks on 'Alternate of Statement' hyperlink")
	public void clickLinkAlternateStatement() {
		try {
			financialAlternateStatementName = getFinancialsPage().alternateStatementName();
			getDataPage().attemptClick(FinancialsIdentifiers
					.getObjectIdentifier("financialStatement_missingItem_alternateStatement_link"));
			Thread.sleep(2000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("the user clicks on 'Alternate Entity' hyperlink")
	public void clickLinkAlternateEntity() {
		financialAlternateEntityName = getFinancialsPage().getAlternateEntityLinkText();
		getDataPage()
				.attemptClick(FinancialsIdentifiers.getObjectIdentifier("financialStatement_missingItem_entity_link"));
	}

	@Then("the user should see Legal Entity basic info page is dispayed")
	public void verifyLegalEntityBasicInfoPage() {
		getFinancialsPage().verifyLegalEntityNameBasicInfoPage(financialAlternateEntityName);
	}

	@Then("the user should see details screen for the linked Financial Statement is displayed")
	public void verifyLinkedFinancialStatementIsDisplayed() {
		getFinancialsPage().verifyFinancialMissingPage(financialAlternateStatementName, financialAlternateEntityName);
	}

	@When("the user clicks on <displayDate> on the left navigation")
	public void clickPeriodEndDate(@Named("displayDate") String displayDate) {
		getFinancialsPage().clickPeriodEndDate(displayDate);
	}

	@Then("the user should see the <displayDate> should be the prefix to the Section Header 'MISSING'")
	public void verifyFinancialMissingHeading(@Named("displayDate") String displayDate) {
		getFinancialsPage().verifyFinancialMissingHeading(displayDate);
	}
	
	@Then("the user should see the line items retrieved from $source document")
	public void verifyLineItemsFromTrusted(@Named("displayDate") String displayDate,@Named("fid") String fid, @Named("source") String source) {
		getFinancialsPage().verifyLineItemsFromTrusted(displayDate, fid, source);
	}

	@Then("the user should see the line items are sorted as per lookup")
	public void verifyLineItemsSort() {
		getFinancialsPage().verifyLineItemsSort();
	}
}