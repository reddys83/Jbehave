package com.accuity.zeus.aft.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by soofis on 3/10/2015.
 */
public enum WebDriverEnum {
    FIREFOX {
        @Override
        public WebDriver createWebDriver(){
              return new FirefoxDriver();
        }
    },
    INTERNETEXPLORER {
        @Override
        public WebDriver createWebDriver() {
            return new InternetExplorerDriver();
        }
    };


    public abstract WebDriver createWebDriver();
}
