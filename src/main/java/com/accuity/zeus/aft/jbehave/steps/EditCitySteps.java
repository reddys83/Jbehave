package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.When;

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
}
