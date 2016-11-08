package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;


@Component
public class FinancialsSteps extends AbstractSteps{

 @Then("the user should see the <latestPeriodEndDate> should be the prefix to the Section Header 'FINANCIALS'")
    public void verifyFinancialsHeading(@Named("financialStatementPeriodEndDate") String financialStatementPeriodEndDate){
     getFinancialsPage().verifyFinancialsHeadingText(financialStatementPeriodEndDate);
 }

    @Then("the user should see the financials section field values same as in the trusted document of <fid> for <latestPeriodEndDate>")
    public void verifyFinancialsFieldValues(@Named("fid")String fid, @Named("latestPeriodEndDate") String latestPeriodEndDate){
        getFinancialsPage().verifyFinancialsFieldValues(fid,latestPeriodEndDate);
    }
}
