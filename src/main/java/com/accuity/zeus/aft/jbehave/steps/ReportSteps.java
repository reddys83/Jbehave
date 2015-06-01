package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.ReportPage;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

@Component
public class ReportSteps extends AbstractSteps{

    @Then("the user should see the report page")
    public void thenTheUserShouldSeeReportPage(){
        getReportPage().verifyReportPage();
    }

    @When("the user selects the area as <area>")
    public void whenUserSelectsArea(@Named("area") String area){
        getReportPage().selectArea(area);
    }

    @When("the user selects the required match as <requiredMatch>")
    public void whenUserSelectsRequiredMatch(@Named("requiredMatch") String requiredMatch){
        getReportPage().selectRequiredMatch(requiredMatch);
    }

    @When("the user clicks on the Run button")
    public void whenUserClicksOnRunButton(){
        getReportPage().clickOnRunButton();
    }

    @Then("the Run button is disabled")
    public void verifyRunButtonIsDisabled(){

    }

    @Then("the user should see the count of the selected criteria as <count>")
    public void theTheUserShouldSeeTheCount(@Named("count") String count){
        getReportPage().verifyCount(count);
    }

}
