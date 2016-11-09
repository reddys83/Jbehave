package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.jbehave.identifiers.FinancialsIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

/**
 * Created by tubatil on 10/31/2016.
 */
@Component
public class FinancialsSteps  extends AbstractSteps{

    @Then("the user should see legalEntity financialStatements for legalEntity <fid> in the left side menu bar")
    public void verifyLegalEntityFinancialStatements(@Named("fid") String fid)
    {
        getFinancialsPage().verifyLegalEntityFinancialStatements(fid);
    }
    
	@Then("the user should see the line items retrieved from $source document")
	public void verifyHistoryValuesFromTrusted(@Named("entityFid") String entityFid, @Named("source") String source) {
		getFinancialsPage().verifyLineItemsFromTrusted(entityFid, source);
	}

	@When("the user clicks on the <financialStatementDate> in financial page")
	public void clickOnFinancialsStatement(@Named("financialStatementDate") String financialStatementDate) {
		getFinancialsPage().clickOnFinancialStatement(financialStatementDate);
	}

	@Then("the user should see order of Type Name groupings is as per the corresponding lookup $lookup")
	public void verifyLineItemTypeValuesFromLookup(@Named("entityFid") String entityFid) {
		getFinancialsPage().verifyLineItemTypeValuesFromLoopup("trusted", entityFid);
	}

}
