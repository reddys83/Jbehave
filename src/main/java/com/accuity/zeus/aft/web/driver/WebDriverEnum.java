package com.accuity.zeus.aft.web.driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by soofis on 3/10/2015.
 */
public enum WebDriverEnum {
	FIREFOX {
		@Override
		public WebDriver createWebDriver() {
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
	
	public static WebDriver getWebDriver(String webDriverType) {
		if (StringUtils.isNotBlank(webDriverType)) {
			WebDriverEnum webDriver = valueOf(StringUtils.upperCase(webDriverType));
			if (webDriver != null) {
				return webDriver.createWebDriver();
			}
		}
		return FIREFOX.createWebDriver();
	}
}
