package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingCodeSteps extends AbstractSteps {

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;
    private String selectedOffice;


    @Then("the user should see the routing code basic info page")
    public void verifyRoutingCodeBasicInfoPage() {
        getRoutingCodePage().verifyRoutingCodeBasicInfoPage();
    }
    @Then("the user should see the routing code basic info values from Trusted document for routing code <routingCode> with code type <codeType>")
            public void verifyRoutingCodeBasicInfoValuesFromTrustedDoc(@Named("routingCode") String routingCode,@Named("codeType") String codeType){

            getRoutingCodePage().verifyRoutingCodeBasicInfoValuesFromTrustedDoc(routingCode,codeType);
    }

    @Then("the user should not see ABA code type specific fields in the basic info page")
    public void verifyABAFieldsNotExist()
    {
        getRoutingCodePage().verifyABAFieldsNotExist();
    }

    @When("the user clicks on the legal entity link in the routing code page header")
    public void clickonHeaderLink()
    {
        getRoutingCodePage().clickonHeaderLink();
    }
    
    @Then("the user should verify the message")
    public void verifyRoutingCodeSearchText()
    {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setRoutingCodePage(getDataPage().createRoutingCodePage());
        getRoutingCodePage().verifyRoutingCodeSearchText();
    }
    
    @Then("the user should not see the message")
    public void verifyRoutingCodeSearchTextNoDisplay()
    {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	setRoutingCodePage(getDataPage().createRoutingCodePage());
        getRoutingCodePage().verifyRoutingCodeSearchText();
    }
    
    
    @When("the user clears the entity value in type ahead box")
	public void clearEntityInTypeAheadBox() {
    	getRoutingCodePage().clearEntityInTypeAheadBox();
	}
}



