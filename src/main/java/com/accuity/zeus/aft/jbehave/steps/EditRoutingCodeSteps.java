package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
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
    
    @When("the user enters the <registarFeeSFDCSubscription> in the routing code basic info page")
	public void enterTextInRegistarFeeSFDCSubscription(@Named("registarFeeSFDCSubscription") String registarFeeSFDCSubscription) {
    	getEditRoutingCodePage().enterTextInRegistarFeeSFDCSubscription(registarFeeSFDCSubscription);
	}
    
    @When("the user enters the <routingCodeComment> in the routing code basic info page")
   	public void enterTextInRoutingCodeComment(@Named("routingCodeComment") String routingCodeComment) {
       	getEditRoutingCodePage().enterTextInRoutingCodeComment(routingCodeComment);
   	}
    
    @Then("the user should see the successful update message at top of the routing code page")
	public void verifySuccessfulUpdatedMessage() {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}
    
    @Then("the user should be able to verify the values are entered in the routing code basic info page")
	public void verifyResisterFeeAndRoutingCodeComment(@Named("routingCodeComment") String routingCodeComment,@Named("registarFeeSFDCSubscription") String registarFeeSFDCSubscription) {
    	getEditRoutingCodePage().verifyResisterFeeAndRoutingCodeComment(registarFeeSFDCSubscription,routingCodeComment);
	}
    
    @Then("the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in $source document")
    public void verifyResisterFeeAndRoutingCodeCommentZeusDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyRegisterFeeAndRoutingCodeFromZeusDB(source, routingCode, codeType);
    }
    
    @When("the user gets the document with $xqueryName with the <routingCode> and <codeType> from the database")
    public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
		getDataPage().getDocumentForRoutingCode(xqueryName, routingCode, codeType);
	}
    
    @When("the user enters values which is beyond 30 unicode characters in Registar Fee subscription field")
	public void enterInvalidCharactersInRegisterFeeSubscription() {
    	getEditRoutingCodePage().enterInvalidCharactersInRegisterFeeSubscription();
	}
    
    @Then("the user should see maximum length of Registar Fee subscription field is limited to $maxLength")
	public void verifyMaxLengthRegisterFeeSubscription(@Named("maxLength") String maxLength) {
    	getEditRoutingCodePage().verifyMaxLengthRegisterFeeSubscription(maxLength);
	}
    
    @Then("the user should be able to view that only 30 unicode characters are saved in Registar Fee subscription field")
	public void verifyValidCharacterLengthRegisterFeeSubscription() {
    	getEditRoutingCodePage().verifyValidCharacterLengthRegisterFeeSubscription();
	}
	
    @Then("the user should be able to verify the maximum values are entered in Registar Fee subscription field")
	public void verifyMaximumTextInRegisterFeeSubscription() {
    	getEditRoutingCodePage().verifyMaximumTextInRegisterFeeSubscription();
	}
    
    @When("the user enters values which is beyond 1000 unicode characters in Routing Code Comment field")
	public void enterInvalidCharactersInRoutingCodeComment() {
    	getEditRoutingCodePage().enterInvalidCharactersInRoutingCodeComment();
	}
    
    @Then("the user should see maximum length of Routing Code Comment field is limited to $maxLength")
	public void verifyMaxLengthRoutingCodeComment(@Named("maxLength") String maxLength) {
    	getEditRoutingCodePage().verifyMaxLengthRoutingCodeComment(maxLength);
	}
    
    @Then("the user should be able to view that only 1000 unicode characters are saved in Routing Code Comment field")
	public void verifyValidCharacterLengthRoutingCodeComment() {
    	getEditRoutingCodePage().verifyValidCharacterLengthRoutingCodeComment();
	}
    
    @Then("the user should be able to verify the maximum values are entered in Routing Code Comment field")
	public void verifyMaximumTextInRoutingCodeComment() {
    	getEditRoutingCodePage().verifyMaximumTextInRoutingCodeComment();
	}
	
}



