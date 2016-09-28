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

    @When("the user clicks on the routingCode usages link in the navigation bar")
    public void clickOnUsagesLink() {
        getRoutingCodePage().clickOnUsagesLink();
    }

    @When("the user click on office $office in the routingCode usages")
    public void clickOfficeLinkInUsages(String office){
        setOfficesPage(getRoutingCodePage().clickOfficeLinkInUsages(office));

    }

    @When("the user clicks on name column in the routingCode usages")
    public void clickOnUsagesNameColumn() {
        getRoutingCodePage().clickOnUsagesNameColumn();
    }

    @When("the user clicks on city column in the routingCode usages")
    public void clickOnUsagesCityColumn(){
        getRoutingCodePage().clickOnUsagesCityColumn();
    }

    @When("the user clicks on area column in the routingCode usages")
    public void clickOnUsagesAreaColumn() {
        getRoutingCodePage().clickOnUsagesAreaColumn();
    }

    @Then("the user should see the usages for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesInView(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesInView(routingCode,codeType);
    }

    @Then("the user should see the usages sort descending order by name for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesDescendingOrderByName(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesDescendingOrderByName(routingCode, codeType);
    }

    @Then("the user should see the usages sort ascending order by city for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesAscendingOrderByCity(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesAscendingOrderByCity(routingCode, codeType);
    }

    @Then("the user should see the usages sort ascending order by area for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesAscendingOrderByArea(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesAscendingOrderByArea(routingCode, codeType);
    }

}



