package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataPage extends AbstractPage {

    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By currency_label_xpath = By.xpath("//*[@id='data']/dl/dt[1]");
    private By currency_list_xpath = By.xpath("//*[@class='chosen-results']/li");
    private By choose_currency_option_xpath = By.xpath("//*[@id='currency_chosen']/a/span");
    private By currency_input_xpath = By.xpath("//*[@class='chosen-search']/input");
    private By no_results_match_xpath = By.xpath("//*[@id='currency_chosen']/div/ul/li");
    private By currency_iso_code_label_id = By.id("iso");
    private By currency_iso_code_id = By.id("iso-value");
    private By currency_name_label_xpath = By.xpath("//div[@id='view-currency']//dt[1]");
    private By currency_name_xpath = By.xpath("//div[@id='view-currency']//dd[1]");
    private By currency_abbr_label_xpath = By.xpath("//div[@id='view-currency']//dt[2]");
    private By currency_abbr_xpath = By.xpath("//div[@id='view-currency']//dd[2]");
    private By currency_unit_label_xpath = By.xpath("//div[@id='view-currency']//dt[3]");
    private By currency_unit_xpath = By.xpath("//div[@id='view-currency']//dd[3]");
    private By currency_quantity_label_xpath = By.xpath("//div[@id='view-currency']//dt[4]");
    private By currency_quantity_xpath = By.xpath("//div[@id='view-currency']//dd[4]");

    private String currencySearchString = null;

    public DataPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void clickOnCurrencyTab() {
        attemptClick(currency_tab_xpath);
    }

    public void clickOnChooseACurrencyOption() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(choose_currency_option_xpath).click();
    }

    public void verifyCurrencyList() {
        assertEquals(getDriver().findElement(currency_label_xpath).getText(), "CURRENCY");
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        assertTrue(currencyList.size() > 0);
    }

    public void enterCurrency(String curr) {
        currencySearchString = curr;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(currency_input_xpath).sendKeys(curr);
    }

    public void verifyCurrencyDropDownMatchesSearchString() {
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        for(int i=0; i<currencyList.size(); i++){
            assertTrue(currencyList.get(i).getText().toLowerCase().contains(currencySearchString.toLowerCase()));
        }
    }

    public void verifyNoResultsMatchOption() {
        assertEquals("No results match \"" + currencySearchString + "\"",getDriver().findElement(no_results_match_xpath).getText());
    }

    public void selectCurrencyFromTypeAhead(String currency) {
        getDriver().findElement(currency_input_xpath).sendKeys(currency);
        getDriver().findElement(currency_input_xpath).sendKeys(Keys.RETURN);
    }

    public void verifyCurrencyIsoCode(String isoCode) {
        assertEquals("ISO", getTextOnPage(currency_iso_code_label_id));
        assertEquals(isoCode, getTextOnPage(currency_iso_code_id));
    }

    public void verifyCurrencyName(String name) {
        assertEquals("Name", getTextOnPage(currency_name_label_xpath));
        assertEquals(name, getTextOnPage(currency_name_xpath));
    }

    public void verifyCurrencyAbbr(String abbr) {
        assertEquals("Abbr", getTextOnPage(currency_abbr_label_xpath));
        assertEquals(abbr, getTextOnPage(currency_abbr_xpath));
    }

    public void verifyCurrencyUnit(String unit) {
        assertEquals("Unit", getTextOnPage(currency_unit_label_xpath));
        if(unit.equals("null")){
            assertTrue(null == getTextOnPage(currency_unit_xpath));
        } else {
            assertEquals(unit, getTextOnPage(currency_unit_xpath));
        }

    }

    public void verifyCurrencyQuantity(String quantity) {
        assertEquals("Quantity", getTextOnPage(currency_quantity_label_xpath));
        if(quantity.equals("null")){
            assertTrue(null == getTextOnPage(currency_quantity_xpath));
        } else {
            assertEquals(quantity, getTextOnPage(currency_quantity_xpath));
        }
    }
}
