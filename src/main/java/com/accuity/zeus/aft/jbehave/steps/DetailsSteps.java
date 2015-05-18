package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.DetailsPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;

@Component
public class DetailsSteps extends AbstractSteps {

    private DetailsPage detailsPage = null;

    @Then("the user should see the details page for the selected institution")
    public void thenUsersIsOnDetailsPage(){
        detailsPage = new DetailsPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
    }

    @Then("the user should see the legal name as <legalName> in the details page")
    public void thenUserCanVerifyLegalName(@Named("legalName") String legalName){
        detailsPage.verifyLegalName(legalName);
    }

    @Then("the user should see the former names as <formerNames> in the details page")
    public void thenUserCanVerifyFormerNames(@Named("formerNames") String formerNames){
        detailsPage.verifyFormerNames(formerNames);
    }

    @Then("the user should see the country of operations as <country> in the details page")
    public void thenUserCanVerifyCountryOfOperations(@Named("country") String country){
        detailsPage.verifyCountryOfOperations(country);
    }

    @Then("the user should see the status as <status> in the details page")
    public void thenUserCanVerifyTheStatus(@Named("status") String status){
        detailsPage.verifyStatus(status);
    }

    @Then("the user should see the office type as head office in the details page")
    public void theUserCanVerifyOfficeType(){
        detailsPage.verifyOfficeType();
    }

    @Then("the user should see the office name as <officeName> in the details page")
    public void theUserCanVerifyOfficeName(@Named("officeName") String officeName){
        detailsPage.verifyOfficeName(officeName);
    }

    @Then("the user should see the <addressType> and <addressInfo> in the details page")
    public void theUserCanVerifyAddress(@Named("addressType") String addressType, @Named("addressInfo") String addressInfo){
        detailsPage.verifyAddress(addressType, addressInfo);
    }

    @Then("the user should see the fax information <fax> in the details page")
    public void theUserCanVerifyFax(@Named("fax") String fax){
        detailsPage.verifyFax(fax);
    }

    @Then("the user should see the email information <email> in the details page")
    public void theUserCanVerifyEmail(@Named("email") String email){
        detailsPage.verifyEmail(email);
    }

    @Then("the user should see the telex information <telex> in the details page")
    public void theUserCanVerifyTelex(@Named("telex") String telex){
        detailsPage.verifyTelex(telex);
    }

    @Then("the user should see the telephone information <telephone> in the details page")
    public void theUserCanVerifyTelephone(@Named("telephone") String telephone){
        detailsPage.verifyTelephone(telephone);
    }

}
