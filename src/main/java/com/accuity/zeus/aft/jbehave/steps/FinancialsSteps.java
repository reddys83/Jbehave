package com.accuity.zeus.aft.jbehave.steps;

import java.util.ArrayList;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

/**
 * Created by tubatil on 10/31/2016.
 */
@Component
public class FinancialsSteps  extends AbstractSteps{

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
}
