package com.accuity.zeus.aft.web.driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.URL;

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
	CHROME {
		@Override
		public WebDriver createWebDriver() {
			URL url;
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				url = this.getClass().getResource("/chromedriver.exe");
			} else {
				url = this.getClass().getResource("/chromedriver_linux");
			}
			System.setProperty("webdriver.chrome.driver", url.getPath());
			return new ChromeDriver();
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
