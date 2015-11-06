package com.accuity.zeus.aft.jbehave.steps;


import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
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

    @When("the user clicks on the office services link in the navigation bar")
    public void clickOnOfficeServicesLink(){
        getOfficesPage().clickOnOfficeServicesLink();
    }

    @When("the user clicks on the office statistics link in the navigation bar")
    public void clickOnOfficeStatisticsLink(){
        getOfficesPage().clickOnOfficeStatisticsLink();
    }



    @Then("the user should see the office's services as: $services")
    public void verifyOfficeServices(ExamplesTable services) {
         getOfficesPage().verifyOfficeServices(services);
    }

    @Then("the user should not see the office's services")
    public void verifyNoServices() {
        getOfficesPage().verifyNoServices();
    }


    @When("the user clicks on the office basic info link in the navigation bar")
    public void clickOnOfficeBasicInfoLink() {
        getOfficesPage().clickOnOfficeBasicInfoLink();
    }

    @When("the user clicks on the office history link in the navigation bar")
    public void clickOnOfficeHistoryLink(){
        getOfficesPage().clickOnOfficeHistoryLink();
    }

    @Then("the user should see the offered services for the office")
    public void verifyOfficeOfferedServicesLabels() {
        getOfficesPage().verifyOfficeOfferedServicesLabels();
    }

    @When("the user clicks on the office identifier link in the navigation bar")
    public void clickOnOfficeIdentifiersLink(){
        getOfficesPage().clickOnOfficeIdentifiersLink();
    }

    @Then("the user should not see the personnel section for the office")
    public void verifyNoOfficePersonnelSection(){
        getOfficesPage().verifyNoOfficePersonnelSection();
    }

    @When("the user clicks on the office credit ratings link in the navigation bar")
    public void clickOnOfficeCreditRatingsLink() { getOfficesPage().clickOnOfficeCreditRatingsLink(); }

  }

