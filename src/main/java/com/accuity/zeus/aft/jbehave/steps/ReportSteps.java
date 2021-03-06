package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class ReportSteps extends AbstractSteps{

    @Then("the user should see the report page")
    public void thenTheUserShouldSeeReportPage(){
        getReportPage().verifyReportPage();
    }

    @When("the user selects the area as <area> in the report page")
    public void whenUserSelectsArea(@Named("area") String area){
        getReportPage().selectArea(area);
    }

    @When("the user selects the required match as <requiredMatch> in the report page")
    public void whenUserSelectsRequiredMatch(@Named("requiredMatch") String requiredMatch){
        getReportPage().selectRequiredMatch(requiredMatch);
    }

    @When("the user clicks on the run button in the report page")
    public void whenUserClicksOnRunButton(){
        getReportPage().clickOnRunButton();
    }

    @Then("the user should see the run button disabled in the report page")
    public void verifyRunButtonIsDisabled(){
        getReportPage().verifyRunButtonIsDisabled();
    }

    @Then("the user should see the count of the selected criteria as <count> in the report page")
    public void theTheUserShouldSeeTheCount(@Named("count") String count){
        getReportPage().verifyCount(count);
    }

}
