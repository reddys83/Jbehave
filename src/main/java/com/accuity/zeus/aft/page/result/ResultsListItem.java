package com.accuity.zeus.aft.page.result;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsListItem {

	private WebElement webElement;
	
	private By nameLocator = By.xpath("//div[@class='name-address-container']/h3");
	private By addressLocator = By.xpath("//div[@class='name-address-container']/p");
	private By fidLocator = By.xpath("//dl[@class='fid']/dd");
	private By tfpidLocator = By.xpath("//dl[@class='tfpid']/dd");
	private By statusLocator = By.xpath("//dl[@class='status']/dd");
	
	public ResultsListItem(WebElement webElement) {
		this.webElement = webElement;
	}
	
	public void assertValid(String name, String address, String fid, String tfpid, String status) {
		assertEquals(name, getName());
		assertEquals(address, getAddress());
		assertEquals(fid, getFid());
		assertEquals(tfpid, getTfpid());
		assertEquals(status, getStatus());
	}
	
	public String getName() {
		return webElement.findElement(nameLocator).getText();
	}
	
	public String getAddress() {
		return webElement.findElement(addressLocator).getText();
	}
	
	public String getFid() {
		return webElement.findElement(fidLocator).getText();
	}
	
	public String getTfpid() {
		return webElement.findElement(tfpidLocator).getText();
	}
	
	public String getStatus() {
		return webElement.findElement(statusLocator).getText();
	}

}
