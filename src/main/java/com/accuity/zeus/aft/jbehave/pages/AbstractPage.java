package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

public abstract class AbstractPage {

	private final static long STANDARD_WAIT = 1000L;

	private WebDriver driver;

	private String urlPrefix;

	protected By contentLocator = By.xpath("//body/div[@id='content']");

	public AbstractPage(WebDriver driver, String urlPrefix) {
		this.driver = driver;
		this.urlPrefix = urlPrefix;
	}

	public abstract String getPageUrl();

	public void open() {
		driver.get(getPageUrl());
		validatePage();
	}

	public void validatePage() {
		assertNotNull(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(contentLocator));
	}

	public void validatePage(By by) {
		assertNotNull(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public String getTextOnPage(By by) {
		int timeout = 0;
		String text = null;
		while(true){
			if(!driver.findElement(by).getText().trim().isEmpty() || !driver.findElement(by).getText().trim().equals("")){
				text = driver.findElement(by).getText().trim();
				break;
			}
			if(timeout>=10){
				break;
			}
			waitFor();
			timeout++;
		}
		return text;
	}

	private void waitFor(){
		try {
			Thread.sleep(STANDARD_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectItemFromDropdownList(By by, String value) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
	}
}
