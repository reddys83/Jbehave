package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 3/12/2015.
 */
@Component
public class SecondMapSteps extends AbstractMapSteps {
	
    @Then("system is in a different state")
    public void then(){
    	webDriverState.getWebDriver().get("https://www.google.com");
    }

    @Then("system is in a new different state")
    public void thenNew(){
    	webDriverState.getWebDriver().get("https://www.google.com");
    }
}
