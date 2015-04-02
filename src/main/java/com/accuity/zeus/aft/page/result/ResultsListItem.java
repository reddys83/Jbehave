package com.accuity.zeus.aft.page.result;

import static org.junit.Assert.*;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.accuity.domain.legalEntity.LegalEntity;

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
		assertEquals(name, getName().getText());
		assertEquals(address, getAddress().getText());
		assertEquals(fid, getFid().getText());
		assertEquals(tfpid, getTfpid().getText());
		assertEquals(status, getStatus().getText());
	}
	
	public void assertValid(Map<String, LegalEntity> expectedMap) {
		LegalEntity expected = expectedMap.get(getFid().getText());
		if (expected == null) {
			fail();
		}
		assertEquals(expected.getSummary().getNames().getNames().get(0).getValue(), getName().getText());
		//assertEquals(address, getAddress().getText());
		assertEquals(expected.getFid(), getFid().getText());
		assertEquals(expected.getTfpid(), getTfpid().getText());
		assertEquals(expected.getSummary().getStatus(), getStatus().getText());
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
