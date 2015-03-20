package com.accuity.zeus.aft.jbehave.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 3/11/2015.
 */
@Component
public class FirstMapSteps extends AbstractMapSteps {
	
	private static final Logger log = Logger.getLogger(FirstMapSteps.class);

    @Given("the data management webapp is running")
    public void given(){
        log.info("");
        webDriverState.getWebDriver().get(getDataManagementWebappUrl());
    }

    @When("I do something")
    public void when(){
    	webDriverState.getWebDriver().get("https://www.google.com");
    }


    @Given("a new system state")
    public void givenNew(){
    	log.info("");
    	webDriverState.getWebDriver().get("https://www.google.com");
    }

    @When("I do something new")
    public void whenNew(){
    	webDriverState.getWebDriver().get("https://www.google.com");
    }

}