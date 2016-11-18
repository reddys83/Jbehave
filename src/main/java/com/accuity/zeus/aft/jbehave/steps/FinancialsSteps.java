package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

@Component
public class FinancialsSteps  extends AbstractSteps{
	public String financialAlternateEntityName;
	public String financialAlternateStatementName;
	
	@Then("the user should see legalEntity financialStatements for legalEntity <fid> in the left side menu bar")
	public void verifyLegalEntityFinancialStatements(@Named("fid") String fid) {
		getFinancialsPage().verifyLegalEntityFinancialStatements(fid);
	}

	@Then("the user should see the missing items retrieved from $source document")
	public void verifyHistoryValuesFromTrusted(@Named("entityFid") String entityFid, @Named("source") String source) {
		getFinancialsPage().verifyMissingItemsFromTrusted(entityFid, source);
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

}
