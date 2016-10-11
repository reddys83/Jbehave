package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditRoutingCodeSteps extends AbstractSteps {

    @When("the user clicks on the routing code update link")
    public void clickOnUpdateRoutingCodeLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editRoutingCodePage==null){
            editRoutingCodePage = getRoutingCodePage().createEditRoutingCodePage();
        }}


    @Then("the user should see the edit routing code values from trusted document for routing code <routingCode> with code type <codeType>")
    public void verifyEditRoutingCodeValuesFromTrusted(@Named("routingCode") String routingCode,@Named("codeType") String codeType){

        getEditRoutingCodePage().verifyEditRoutingCodeValuesFromTrusted(routingCode,codeType);
    }

@When("the user gets the document with $xqueryName with the <routingCode> and <codeType> from the database")
public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
	getDataPage().getDocumentForRoutingCode(xqueryName, routingCode, codeType);
}

@When("the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field")
public void enterRoutingCodeStartDateField(@Named("startDateDay") String startDateDay, @Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear) {
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateDay"), startDateDay, 1);
	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateMonth"), startDateMonth);
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateYear"), startDateYear, 1);
}

@When("the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field")
public void enterRoutingCodeEndDateField(@Named("endDateDay") String endDateDay, @Named("endDateMonth") String endDateMonth, @Named("endDateYear") String endDateYear) {
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateDay"), endDateDay, 1);
	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateMonth"), endDateMonth);
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateYear"), endDateYear, 1);
}

@When("the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field")
public void enterRoutingCodeForthcomingRetirementDateField(@Named("retirementDay") String retirementDay, @Named("retirementMonth") String retirementMonth, @Named("retirementYear") String retirementYear) {
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateDay"), retirementDay, 1);
	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateMonth"), retirementMonth);
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateYear"), retirementYear, 1);
}

@When("the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field")
public void enterRoutingCodeConfirmedWithFedField(@Named("fedDay") String fedDay, @Named("fedMonth") String fedMonth, @Named("fedYear") String fedYear) {
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateDay"), fedDay, 1);
	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateMonth"), fedMonth);
	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateYear"), fedYear, 1);
}

@Then("the user should see the error message <errorMessage> for routing code start date field")
public void verifyErrorMessageForStartDateField(@Named("errorMessage") String errorMessage) {
	getDataPage().verifyWebElementText("Routing Code Start Date", "Invalid Date", RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_StartDate_errorMessage"));
}

@Then("the user should see the error message <errorMessage> for routing code end date field")
public void verifyErrorMessageForEndDateField(@Named("errorMessage") String errorMessage) {
	getDataPage().verifyWebElementText("Routing Code End Date", "Invalid Date", RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_EndDate_errorMessage"));
}

@Then("the user should see the error message <errorMessage> for routing code forthcoming retirement date field")
public void verifyErrorMessageForRetirementDateField(@Named("errorMessage") String errorMessage) {
	getDataPage().verifyWebElementText("Routing Code Forthcoming Retirement Date", "Invalid Date", RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDate_errorMessage"));
}

@Then("the user should see the error message <errorMessage> for routing code confirmed with fed field")
public void verifyErrorMessageForConfirmedWithFedField(@Named("errorMessage") String errorMessage) {
	getDataPage().verifyWebElementText("Routing Code Confirmed With Fed", "Invalid Date", RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDate_errorMessage"));
}
}



