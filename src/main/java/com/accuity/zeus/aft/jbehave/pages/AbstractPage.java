package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
		if(driver instanceof InternetExplorerDriver) {
			try {
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			} catch (Exception e) {
				System.out.println("SSL not handled");
			}
		}
	}

	public void validatePage() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNotNull(driver);
		assertTrue(driver.findElement(contentLocator).isEnabled());
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
		int attempts = 0;
		String text = null;
		while(true){
			waitFor();
			if(driver.findElement(by).isDisplayed()){
				text = driver.findElement(by).getText().trim();
				break;
			}
			if(attempts>=10){
				break;
			}
			waitFor();
			attempts++;
		}
		return text;
	}

	public void attemptClick(By by) {
		int attempts = 0;
		String text = null;
		while(true){
			waitFor();
			if(driver.findElement(by).isDisplayed()){
				driver.findElement(by).click();
				break;
			}
			if(attempts>=10){
				break;
			}
			waitFor();
			attempts++;
		}
	}

	private void waitFor(){
		try {
			Thread.sleep(STANDARD_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToAppear(By by){
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(),15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}catch(org.openqa.selenium.NoSuchElementException e){
		}
	}

	public void selectItemFromDropdownList(By by, String value) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
	}

    public void selectMonthFromDropdownList(By by, String value) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(by));
        if (value.equals(""))
        {
            dropdown.selectByValue(value);
        } else {
            dropdown.selectByVisibleText(value);
        }
    }

	public void modifyHtmlByName(String element, String attribute, String value){
		WebElement webElement = getDriver().findElement(By.name(element));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		executor.executeScript(scriptSetAttrValue,webElement,attribute,value);
	}

}
