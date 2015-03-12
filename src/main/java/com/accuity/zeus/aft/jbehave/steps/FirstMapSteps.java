package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.service.WebDriverState;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 3/11/2015.
 */
@Component
public class FirstMapSteps {

    WebDriverState webDriverState = new WebDriverState();



    @Given("a system state")
    public void given(){
        System.out.println("");
        webDriverState.webDriver.get("https://www.google.com");
    }

    @When("I do something")
    public void when(){
        webDriverState.webDriver.get("https://www.google.com");
    }


    @Given("a new system state")
    public void givenNew(){
        System.out.println("");
        webDriverState.webDriver.get("https://www.google.com");
    }

    @When("I do something new")
    public void whenNew(){
        webDriverState.webDriver.get("https://www.google.com");
    }

}
