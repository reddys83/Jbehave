package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;


@Component
public class FinancialsSteps extends AbstractSteps{



	@Then("the user should see the <displayDate> should be the prefix to the Section Header 'FINANCIALS'")
	public void verifyFinancialsHeading(@Named("displayDate") String displayDate) {
		getFinancialsPage().verifyFinancialsHeadingText(displayDate);
	}

    @Then("the user should see the financials section field values same as in the trusted document of <fid> for <displayDate>")
    public void verifyFinancialsFieldValues(@Named("fid")String fid, @Named("displayDate") String displayDate){
        getFinancialsPage().verifyFinancialsFieldValues(fid, displayDate);
    }

    @Then("the user verifies Audited by field is displayed only when Audited field is true")
    public void verifyAuditedByField(){
        getFinancialsPage().verifyAuditedByField();
    }
    
    @When("the user clicks on <periodEndDate> on the left navigation")
    public void clickPeriodEndDate(@Named("periodEndDate") String periodEndDate){
    	getFinancialsPage().clickPeriodEndDate(periodEndDate);
    }
}
