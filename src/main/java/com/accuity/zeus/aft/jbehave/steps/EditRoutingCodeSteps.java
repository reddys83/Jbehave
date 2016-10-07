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
}



