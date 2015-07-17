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
    private By currency_input_xpath = By.xpath("//*[@id='currency_chosen']/a/span");
    private By no_results_match_xpath = By.xpath("//*[@id='currency_chosen']/div/ul/li");
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
}
