package com.accuity.zeus.aft.web.driver;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component()
@Scope("singleton")
public class WebDriverState {

	@Value("${web.aft.webdriver.type}")
	private String webDriverType;

	@Value("${web.aft.webdriver.implicitWait}")
	private long implicitWait;

	private WebDriver webDriver;

	@BeforeStories
	public void create() throws InterruptedException {
		if (webDriver == null) {
			webDriver = WebDriverEnum.getWebDriver(webDriverType);
			webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
			Thread.sleep(1000L);
		}
	}

	@AfterStories
	public void cleanup(){
		webDriver.quit();
	}

	public WebDriver getWebDriver() {
		if (System.getProperty("browser") == null) {
			return webDriver;
		} else {
			return WebDriverEnum.getWebDriver(System.getProperty("browser"));
		}
	}
}
