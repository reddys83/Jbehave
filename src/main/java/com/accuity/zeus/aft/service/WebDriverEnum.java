package com.accuity.zeus.aft.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by soofis on 3/10/2015.
 */
public enum WebDriverEnum {
    FIREFOX {
        @Override
        public WebDriver createWebDriver(){
              return new FirefoxDriver();
        }
    };

    public abstract WebDriver createWebDriver();



}
