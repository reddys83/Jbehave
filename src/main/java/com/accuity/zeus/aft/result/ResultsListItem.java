package com.accuity.zeus.aft.result;

import static com.accuity.zeus.junit.AssertUtils.*;
import static org.junit.Assert.*;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ResultsListItem {

	private WebElement webElement;
	
	private By nameLocator = By.xpath(".//div[@class='name-address-container']/h3");
	private By addressLocator = By.xpath(".//div[@class='name-address-container']/p");
	private By fidLocator = By.xpath(".//dl[@class='fid']/dd");
	private By tfpidLocator = By.xpath(".//dl[@class='tfpid']/dd");
	private By statusLocator = By.xpath(".//dl[@class='status']/dd");
	
	public ResultsListItem(WebElement webElement) {
		this.webElement = webElement;
	}

	public WebElement getResultListItem(){
		return webElement;
	}
	
	public void assertValid(String name, String address, String fid, String tfpid, String status) {
		assertEqualsOrIsExpectedBlank(name, getName().getText());
		assertEqualsOrIsExpectedBlank(address, getAddress().getText());
		assertEqualsOrIsExpectedBlank(fid, getFid().getText());
		assertEqualsOrIsExpectedBlank(tfpid, getTfpid().getText());
		assertEqualsOrIsExpectedBlank(status, getStatus().getText());
	}
	
	public WebElement getName() {
		return webElement.findElement(nameLocator);
	}
	
	public WebElement getAddress() {
		return webElement.findElement(addressLocator);
	}
	
	public WebElement getFid() {
		return webElement.findElement(fidLocator);
	}
	
	public WebElement getTfpid() {
		return webElement.findElement(tfpidLocator);
	}
	
	public WebElement getStatus() {
		return webElement.findElement(statusLocator);
	}

}
