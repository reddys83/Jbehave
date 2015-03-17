package com.accuity.zeus.aft.service;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.org.mozilla.javascript.internal.annotations.JSGetter;

import java.util.concurrent.TimeUnit;

/**
 * Created by soofis on 3/11/2015.
 */
@Component
public class WebDriverState {

    @Value("${web.aft.webdriver.type}")
    private String webDriverType;

    @Value("${web.aft.webdriver.implicitWait}")
    private long implicitWait;

    public static WebDriver webDriver;

    @BeforeScenario
    public void create() throws InterruptedException{
        if (webDriver==null) {
            webDriver = getWebDriver(webDriverType);
            webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            Thread.sleep(2000L);
        }
    }

    @AfterScenario
    public void cleanup(){
        webDriver.quit();
        webDriver = null;
    }

    private WebDriver getWebDriver(String webDriverName){
        switch(webDriverName) {
            case "firefox":
                return WebDriverEnum.FIREFOX.createWebDriver();
            default:
                return WebDriverEnum.FIREFOX.createWebDriver();
        }
    }

}
