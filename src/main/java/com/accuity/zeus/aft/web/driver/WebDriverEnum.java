package com.accuity.zeus.aft.web.driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

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
			URL url;
			url = this.getClass().getResource("/iedriver.exe");
			System.setProperty("webdriver.ie.driver", url.getPath());
			return new InternetExplorerDriver();
		}
	},
	REMOTE {
		@Override
		public WebDriver createWebDriver() {
			URL hubUrl = null;
			try {
				hubUrl = new URL("http://localhost:5556/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			Properties properties = new Properties();
			try{
				properties.load(getClass().getClassLoader().getResourceAsStream("environment.properties"));
			}catch (IOException e)
			{e.printStackTrace();
			}
			if(System.getProperty("remoteBrowser") == null){
				capabilities.setBrowserName(properties.getProperty("web.aft.remote.browser"));
			} else {
				capabilities.setBrowserName((System.getProperty("remoteBrowser")));
			}
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			return new RemoteWebDriver(hubUrl, capabilities);
		}
	},;


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
