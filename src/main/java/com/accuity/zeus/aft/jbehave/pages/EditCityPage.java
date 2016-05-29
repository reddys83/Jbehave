package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.aft.jbehave.identifiers.CityIdentifiers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

/**
 * Created by shahc1 on 5/19/2016.
 */
public class EditCityPage extends AbstractPage  {
	
    private By city_add_new_identifier_button_id = By.id("add-identifiers");
    private By city_identifier_type_input_xpath = By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierType']");
    private By city_identifier_status_input_xpath = By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierStatus']");
    private By city_identifier_value_input_xpath = By.xpath(".//*[@id='additionalIdentifiers']//*[@data-internal_id='identifierValue']");
    private By city_get_identifier_type_value = By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td");
    private By city_get_identifier_status_value =By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td[3]");
    private By city_get_identifier_value = By.xpath("//li[@id='cityBasicInfo']/ul/li/table[2]/tbody/tr/td[2]");
    private By city_confirm_button = By.xpath("//button[@id='confirm-button']");
    private By delete_row_confirmation_modal_xpath =By.xpath("//*[@colspan='10']");
    private By city_delete_identifiers_row_button_xpath = By.xpath(".//*[@data-row_id='identifiers']//button[@class='delete-row']");
    private By city_additional_identifiers_row_id = By.xpath("//*[@id='additionalIdentifiers']/tr");
    private By city_identifier_value_req_err_msg_xpath = By.xpath("//*[@id='additionalIdentifiers']/tr/td[2]/p");
    private By city_identifier_type_req_err_msg_xpath = By.xpath("//*[@id='additionalIdentifiers']/tr/td[1]/p");
    private By city_identifier_status_req_err_msg_xpath = By.xpath("//*[@id='additionalIdentifiers']/tr/td[3]/p");
    private By city_delete_yes_button_id = By.xpath("//*[@id='yes-button']");
    
    public EditCityPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    public void verifyIdentifierTypeList(String lookupFid) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("fid", lookupFid));
        List<WebElement> statusList = getDriver().findElements(LegalEntityIdentifiers.getObjectIdentifier("legalEntity_basicInfo_fatcastatus_list_xpath"));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get legal entity Status types", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("status").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), statusList.get(i + 1).getAttribute("value"));
        }
    }
    
    
    
   public void clickOnAddNewIdentifierButton() {
    	try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        attemptClick(CityIdentifiers.getObjectIdentifier("city_add_new_identifier_button_id"));
    }
    
    
    
    public void enterIdentifierType(String identifierType) {
        try {

            List<WebElement> webElements = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_identifier_type_input_xpath"));
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            Select mySelect = new Select(mySelectElm);
            mySelect.selectByValue(identifierType);
        } catch (Exception e) {
        }
    }
    
    public void enterIdentifierStatus(String identifierStatus) {
        try {

            List<WebElement> webElements = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_identifier_status_input_xpath"));
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            Select mySelect = new Select(mySelectElm);
            mySelect.selectByValue(identifierStatus);
        } catch (Exception e) {
        }
    }
    
    public void clickOnDeleteNewIdentifierRowButtonCity() {
        attemptClick(CityIdentifiers.getObjectIdentifier("city_delete_identifiers_row_button_xpath"));
    }
    
    public void verifyDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).getText());
    }
    
    public void verifyUpdateSuccessIdentifiers(String identifierType,String identifierValue,String identifierStatus) throws Exception {
    	Thread.sleep(6000);
    	assertEquals(identifierType, getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_type_value")).getText());
        assertEquals(identifierValue, getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_value")).getText());
        assertEquals(identifierStatus, getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_get_identifier_status_value")).getText());
    	
    }
	
    public void verifyNewlyAdedIdentifierRowIsNotDisplayed() {
        try {
            assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_additional_identifiers_row_id")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }
    
    public void clearCityIdentifierValue() {
        try {
            List<WebElement> webElements = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.clear();
        } catch (Exception e) {
        }
    }
    
    public void clickOnConfirmButtonCity() throws Exception {
    	Thread.sleep(3000);
    	getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_confirm_button")).click(); 
    	Thread.sleep(3000);
    }
	
    
    public void enterIdentifierValue(String identifierValue) {
        try {
            List<WebElement> webElements = getDriver().findElements(CityIdentifiers.getObjectIdentifier("city_identifier_value_input_xpath"));
            int columns_count = webElements.size();
            WebElement mySelectElm = webElements.get(columns_count - 1);
            mySelectElm.sendKeys(identifierValue);
        } catch (Exception e) {

        }
    }
    
    public void verifyErrorMessageForRequiredCityIdentifierValue() {
        assertEquals("Required", getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_value_req_err_msg_xpath")).getText());
    }
    
    public void verifyErrorMessageForRequiredCityIdentifierType() {
        assertEquals("Required", getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_type_req_err_msg_xpath")).getText());
    }
    
    public void verifyErrorMessageForRequiredCityIdentifierStatus() {
    	assertEquals("Required", getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_status_req_err_msg_xpath")).getText());
    }
    
    public void verifyErrorMessageForLongCityIdentifierValue() {
        assertEquals("Enter up to 50 valid characters.", getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_identifier_value_max_length_err_msg_xpath")).getText());
    }
    
    public void pressEnterButtonInDeleteConfirmationModalForCity() {
        getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id")).sendKeys(Keys.ENTER);
    }
    
    public void clickNoButtonInDeleteConfirmationModalForCity() {
    	 getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_no_button_id_click")).click();
    }
    
    public void clickYesButtonInDeleteConfirmationModalForCity() {
   	 getDriver().findElement(CityIdentifiers.getObjectIdentifier("city_delete_yes_button_id_click")).click();
   }
    
    public void verifyNoDeleteConfirmationModal() {
    	try{
    		
    		assertFalse(getDriver().findElement(CityIdentifiers.getObjectIdentifier("delete_row_confirmation_modal_xpath")).isDisplayed());
    
    	}catch(NoSuchElementException e){
    	
    	}
    }
    
    @Override
    public String getPageUrl() {
        return null;
    }
}
