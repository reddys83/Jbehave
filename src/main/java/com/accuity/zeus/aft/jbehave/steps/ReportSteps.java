package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class ReportSteps extends AbstractSteps{

    SearchSteps searchSteps;

    @Then("the user should see the report page")
    public void thenTheUserShouldSeeReportPage(){
        searchSteps.reportPage.verifyReportPage();
    }

    @When("the user selects the area as <area>")
    public void whenUserSelectsArea(@Named("area") String area){
        searchSteps.reportPage.selectArea(area);
    }

    @When("the user selects the required match as <requiredMatch>")
    public void whenUserSelectsRequiredMatch(@Named("requiredMatch") String requiredMatch){
        searchSteps.reportPage.selectRequiredMatch(requiredMatch);
    }

    @When("the user clicks on the Run button")
    public void whenUserClicksOnRunButton(){
        searchSteps.reportPage.clickOnRunButton();
    }

    @Then("the user should see the count of the selected criteria as <count>")
    public void theTheUserShouldSeeTheCount(@Named("count") String count){
        searchSteps.reportPage.verifyCount(count);
    }

}
