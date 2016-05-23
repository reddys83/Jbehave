package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;


/**
 * Created by shahc1 on 5/19/2016.
 */
public class EditCitySteps extends AbstractSteps{

    @When("the user clicks on the city update link")
    public void clickOnUpdateCurrencyLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editCityPage==null){
            editCityPage = getDataPage().createEditCityPage();
            
        }}
    
    @When("the user clicks on the add new identifier button in the basic info city page")
    public void clickOnAddNewIdentifierButton(){
        getCountryPage().clickOnAddNewIdentifierButton();
    }
    
    @Then("the user should see the default identifier status as active")
    public void assertIdentifierStatus(){
        getCountryPage().verifyIdentifierStatus();
    }
    
    @When("the user enters identifier type as <identifierType> in the basic info city page")
    public void enterIdentifierType(@Named("identifierType") String identifierType) {
        getCountryPage().enterIdentifierType(identifierType);
    }

    @When("the user enters identifier value as <identifierValueIncorrect> in the basic info city page")
    public void enterIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
        getCountryPage().enterIdentifierValue(incorrectIdentifierValue);
    }
    
    @When("the user clears identifier value in the basic info city page")
    public void clearCountryIdentifierValue(){
        getCountryPage().clearCountryIdentifierValue();
    }
}
