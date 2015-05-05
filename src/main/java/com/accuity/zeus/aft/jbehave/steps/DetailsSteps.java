package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.jbehave.pages.DetailsPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

/**
 * Created by soofis on 5/4/2015.
 */
public class DetailsSteps extends AbstractSteps {

    private DetailsPage detailsPage = null;

    @Then("the user is on details page")
    public void thenUsersIsOnDetailsPage(){
        detailsPage = new DetailsPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
    }

    @Then("the user can verify that the legal name is <legalName>")
    public void thenUserCanVerifyLegalName(@Named("legalName") String legalName){
        detailsPage.verifyLegalName(legalName);
    }

}
