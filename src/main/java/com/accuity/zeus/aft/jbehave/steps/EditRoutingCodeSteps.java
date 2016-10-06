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
    
    @When("the user selects <booleanFieldValue> for routing code account eligibility field")
    public void selectAccountEligibilityFalseValue(@Named("booleanFieldValue") String booleanFieldValue) {
    	getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_AccountEligibility_false"));
    }
    
    @When("the user selects <booleanFieldValue> for routing code internal use only field")
    public void selectInternalUseOnlyFalseValue(@Named("booleanFieldValue") String booleanFieldValue) {
    	getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_InternalUseOnly_false"));
    }
    
    @When("the user selects <booleanFieldValue> for routing code use head office field")
    public void selectUseHeadOffice(@Named("booleanFieldValue") String booleanFieldValue) {
    	getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_UseHeadOffice_false"));
    }
    
    @Then("the user should be able to verify the boolean field values in routing code basic info page")
    public void verifyRoutingCodeBooleanFieldValuesInUI(@Named("booleanFieldValue") String booleanFieldValue) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesInUI(booleanFieldValue);
    }
    
    @Then("the user should see the boolean field values same as in $source document")
    public void verifyRoutingCodeBooleanFieldValuesFromZeusDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesFromZeusDB(source, routingCode, codeType);
    }
    
    @Then("the user verifies the boolean field values same as in $source document")
    public void verifyRoutingCodeBooleanFieldValuesFromTrustedDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesFromTrustedDB(source, routingCode, codeType);
    } 
}



