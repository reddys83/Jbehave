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
    
    @When("the user selects <accountEligibilityValue> for routing code account eligibility field")
    public void selectAccountEligibilityFieldAsFalse(@Named("accountEligibilityValue") String accountEligibilityValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_accountEligibility_radio"), accountEligibilityValue);
    }
    
    @When("the user selects <internalUseOnlyValue> for routing code internal use only field")
    public void selectInternalUseOnlyFieldAsFalse(@Named("internalUseOnlyValue") String internalUseOnlyValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_internalUseOnly_radio"), internalUseOnlyValue);
    }
    
    @When("the user selects <useHeadOfficeValue> for routing code use head office field")
    public void selectUseHeadOfficeFieldAsFalse(@Named("useHeadOfficeValue") String useHeadOfficeValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_useHeadOffice_radio"), useHeadOfficeValue);
    }
    
    @Then("the user should be able to verify the boolean field values in routing code basic info page")
    public void verifyRoutingCodeBooleanFieldValuesInUI(@Named("accountEligibilityValue") String accountEligibilityValue, @Named("internalUseOnlyValue") String internalUseOnlyValue, @Named("useHeadOfficeValue") String useHeadOfficeValue) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesInUI(accountEligibilityValue, internalUseOnlyValue, useHeadOfficeValue);
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