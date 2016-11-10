package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;

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
    
    @Then("the user should see the missing items retrieved from $source document")
	public void verifyHistoryValuesFromTrusted(@Named("entityFid") String entityFid, @Named("source") String source) {
		getFinancialsPage().verifyMissingItemsFromTrusted(entityFid, source);
	}
}
