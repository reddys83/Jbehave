package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 2/11/2016.
 */

@Component
public class EditCountrySteps extends AbstractSteps {

    @Then("the user can edit banking hours summary and date")
    public void verifyUserCanEditBankingHours(){

    }

    @When("the user selects day as $day and hours as $hours")
    public void userSelectsDayAndHour(String day, String hours){

    }

    @When("the user clicks on the update country link")
    public void userClicksOnCountryUpdateLink(){

    }

    @Then("the $rowId row is saved successfully with day as $day and hours as $hours")
    public void verifyRowIsSaved(String rowId, String day, String hours){

    }

    @When("the user deletes the $rowId row")
    public void userDeletesRow(String rowId){

    }

    @Then("the user should see the message $message")
    public void verifyMessage(String message){

    }

    @When("the user clicks the $buttonName button")
    public void userClicksOnButton(String buttonName){

    }

    @Then ("the $rowId row is deleted successfully")
    public void verifyRowIsDeleted(String rowId){

    }

    @When("the user deletes the banking hours summary")
    public void userDeletesBankingSummary(){

    }

    @Then("the banking hours summary is deleted")
    public void verifyBankingHoursSummaryIsDeleted(){

    }


    @Then("the user should see the view banking hours from trusted document")
    public void verifyViewCurrencyUseFromTrusted() {

    }

    @When("the user gets the trusted document for country <country>")
    public void getCountryTrustedDocument(String country){

    }

    @Then("the user reverts the changes to the country <country>")
    public void revertCountry(String country){

    }
}
