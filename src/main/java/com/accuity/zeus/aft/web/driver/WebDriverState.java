package com.accuity.zeus.aft.web.driver;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by soofis on 3/11/2015.
 */
@Component()
@Scope("singleton")
public class WebDriverState {

	@Value("${web.aft.webdriver.type}")
	private String webDriverType;

	@Value("${web.aft.webdriver.implicitWait}")
	private long implicitWait;

	private WebDriver webDriver;

	@BeforeScenario
	public void create() throws InterruptedException {
		if (webDriver == null) {
			webDriver = WebDriverEnum.getWebDriver(webDriverType);
			webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
			Thread.sleep(1000L);
		}
	}

	@AfterScenario
	public void cleanup() {
		webDriver.quit();
		webDriver = null;
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
