package com.accuity.zeus.aft.jbehave.steps;


import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class OfficesSteps extends AbstractSteps {

    @When("the user clicks on the offices results card with fid <officeFid>")
    public void clickOnOfficeResultsCard(@Named("officeFid") String officeFid){
        getOfficesPage().clickOnOfficeResultsCard(officeFid);
    }

    @When("the user clicks on the office personnel link in the navigation bar")
    public void clickOnOfficePersonnelLink(){
        getOfficesPage().clickOnOfficePersonnelLink();
    }

    @When("the user clicks on the office history link in the navigation bar")
    public void clickOnOfficeHistoryLink(){
        getOfficesPage().clickOnOfficeHistoryLink();
    }
}
