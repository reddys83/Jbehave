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
	private By noResultsLocator = By.xpath("//div/header[@class='subheader']/p");
	
	public ResultsListItem(WebElement webElement) {
		this.webElement = webElement;
	}
	
	public void assertValid(String name, String address, String fid, String tfpid, String status) {
		assertEquals(name, getName().getText());
		assertEquals(address, getAddress().getText());
		assertEquals(fid, getFid().getText());
		assertEquals(tfpid, getTfpid().getText());
		assertEquals(status, getStatus().getText());
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

	public WebElement getNoResults() { return webElement.findElement(noResultsLocator); }

}
