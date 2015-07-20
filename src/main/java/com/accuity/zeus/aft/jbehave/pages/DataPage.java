package com.accuity.zeus.aft.jbehave.pages;

import org.openqa.selenium.By;
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
    private By currency_name_label_id = By.id("");
    private By currency_name_id = By.id("");
    private By currency_abbr_label_id = By.id("");
    private By currency_abbr_id = By.id("");
    private By currency_unit_label_id = By.id("");
    private By currency_unit_id = By.id("");
    private By currency_quantity_label_id = By.id("");
    private By currency_quantity_id = By.id("");

    private String currencySearchString = null;

    public DataPage(WebDriver driver, String urlPrefix) {
        super(driver, urlPrefix);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void clickOnCurrencyTab() {
        getDriver().findElement(currency_tab_xpath).click();
    }

    public void clickOnChooseACurrencyOption() {
        getDriver().findElement(choose_currency_option_xpath).click();
    }

    public void verifyCurrencyList() {
        assertEquals(getDriver().findElement(currency_label_xpath).getText(), "CURRENCY");
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        assertTrue(currencyList.size() > 0);
    }

    public void enterCurrency(String curr) {
        currencySearchString = curr;
        getDriver().findElement(currency_input_xpath).sendKeys(curr);
    }

    public void verifyCurrencyDropDownMatchesSearchString() {
        List<WebElement> currencyList = getDriver().findElements(currency_list_xpath);
        for(WebElement currencyElement : currencyList){
            assertTrue(currencyElement.getText().matches(currencySearchString));
        }
    }

    public void verifyNoResultsMatchOption() {
        assertEquals(getDriver().findElement(no_results_match_xpath).getText(),"\"No results match \"" + currencySearchString);
    }

    public void selectCurrencyFromDropDownList(String currency) {
        selectItemFromDropdownList(currency_list_xpath, currency);
    }

    public void verifyCurrencyIsoCode(String isoCode) {
        assertEquals(currency_iso_code_label_id, "ISO:");
        assertEquals(currency_iso_code_id, isoCode);
    }

    public void verifyCurrencyName(String name) {
        assertEquals(currency_name_label_id, "Name:");
        assertEquals(currency_name_id, name);
    }

    public void verifyCurrencyAbbr(String abbr) {
        assertEquals(currency_abbr_label_id, "Abbr:");
        assertEquals(currency_abbr_id, abbr);
    }

    public void verifyCurrencyUnit(String unit) {
        assertEquals(currency_unit_label_id, "Abbr:");
        assertEquals(currency_unit_id, unit);
    }

    public void verifyCurrencyQuantity(String quantity) {
        assertEquals(currency_quantity_label_id, "Quantity:");
        assertEquals(currency_quantity_id, quantity);
    }
}
