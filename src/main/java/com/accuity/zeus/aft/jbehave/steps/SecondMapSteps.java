package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.service.WebDriverState;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 3/12/2015.
 */
@Component
public class SecondMapSteps {


    WebDriverState webDriverState = new WebDriverState();

    @Then("system is in a different state")
    public void then(){
        webDriverState.webDriver.get("https://www.google.com");
    }

    @Then("system is in a new different state")
    public void thenNew(){
        webDriverState.webDriver.get("https://www.google.com");
    }
}
