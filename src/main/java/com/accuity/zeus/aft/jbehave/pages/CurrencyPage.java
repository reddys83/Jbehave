package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.CurrencyIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.*;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;



public class CurrencyPage extends AbstractPage {

    private String selectedEntity="";
    private String clickedCurrencyIso="";
    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By currency_country_list_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By currency_country_list_edit_xpath = By.xpath(".//*[@id='add_currencyUses_chosen']//li");
    private By currency_iso_code_label_id = By.id("iso");
    private By currency_iso_code_id = By.id("iso-value");
    private By currency_name_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[1]");
    private By currency_name_xpath = By.xpath("//*[@id='content']/div/dl[1]/dd[1]");
    private By currency_abbr_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[2]");
    private By currency_abbr_xpath = By.xpath("//div[@id='content']//dd[2]");
    private By currency_unit_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[3]");
    private By currency_unit_xpath = By.xpath("//*[@id='content']/div/dl[1]/dd[3]");
    private By currency_quantity_label_xpath = By.xpath("//*[@id='content']/div/dl[1]/dt[4]");
    private By currency_quantity_xpath = By.xpath("//div[@id='content']//dd[4]");
    String currency_use_table_xpath_string = "//*[@id='content']/div/table/tbody/tr[";
    private By currency_use_table_header_xpath = By.xpath("//*[@id='content']/div/table/thead/tr");
    private By currency_use_table_row_xpath = By.xpath("//*[@id='content']/div/table/tbody/tr");
    String currency_use_table_country_edit_xpath = "//select[@name='country']";
    private By currency_use_table_startDate_day_edit_xpath=By.xpath("//input[@name='startDate-day']");
    String currency_use_table_startDate_month_edit_xpath = "//select[@name='startDate-month']";
    private By currency_use_table_startDate_year_edit_xpath=By.xpath("//input[@name='startDate-year']");

    private By currency_new_use_table_startDate_day_edit_xpath=By.xpath("//*[@id='additionalCurrencyUses']//tr[last()]//input[@name='startDate-day']");
    String currency_new_use_table_startDate_month_edit_xpath = "//*[@id='additionalCurrencyUses']//tr[last()]//select[@name='startDate-month']";
    private By currency_new_use_table_startDate_year_edit_xpath=By.xpath("//*[@id='additionalCurrencyUses']//tr[last()]//input[@name='startDate-year']");

    private By currency_use_table_endDate_day_edit_xpath=By.xpath("//input[@name='endDate-day']");
    String currency_use_table_endDate_month_edit_xpath = "//select[@name='endDate-month']";
    private By currency_use_table_endDate_year_edit_xpath=By.xpath("//input[@name='endDate-year']");
    String currency_use_table_primary_edit_xpath ="//fieldset[@data-error_id='primary']";
    private By currency_use_table_replacedBy_disable_edit_xpath = By.xpath("//fieldset[2]//div[@class='chosen-container chosen-container-single chosen-disabled']/a");
    String currency_use_table_replacedBy_edit_xpath= "//fieldset[2]//div[@class='chosen-container chosen-container-single']";
    private String currencySearchString = null;
    private By currency_input_name_xpath = By.xpath("//input[@name='name']");
    private By currency_input_abbr_xpath = By.xpath("//input[@name='abbr']");
    private By currency_input_unit_xpath = By.xpath("//input[@name='unit']");
    private By currency_input_quantity_xpath = By.xpath("//input[@name='quantity']");
    private By currency_header_xpath = By.xpath(".//*[@id='selection']/fieldset/h1");
    private By currency_header_iso_id = By.id("iso-value");
    private By currency_abbr_error_message_xpath = By.xpath("//*[@data-error_id='abbrError']");
    private By currency_name_error_message_xpath = By.xpath("//*[@data-error_id='nameError']");
    private By currency_unit_error_message_xpath = By.xpath("//*[@data-error_id='unitError']");
    private By currency_quantity_error_message_xpath = By.xpath("//*[@data-error_id='quantityError']");
    private By currency_replaced_by_xpath = By.xpath("//*[@class='chosen-results']/li");
    private By currency_start_date_drop_down_xpath = By.xpath("//select[@name='startDate-month']");
    private By currency_add_country_option_xpath = By.xpath("//*[@id='add_currencyUses_chosen']/a");
    private By currency_add_country_type_ahead_input_xpath = By.xpath("//*[@id='add_currencyUses_chosen']/div/div/input");
    private By currency_use_table_additional_use_primary_edit_xpath = By.xpath("//*[@id='additionalCurrencyUses']/tr[@class='new'] //fieldset/input[@checked]");
    private By currency_use_table_additional_use_status_xpath = By.xpath("//*[@id='additionalCurrencyUses']/tr[@class='new']/td[@class='status']");
    private By currency_add_country_list_xpath = By.xpath("//*[@id='add_currencyUses_chosen'] //ul/li");
    private By currency_use_table_delete_use_option_xpath = By.xpath("//*[@id='additionalCurrencyUses']/tr[@class='new']/td[@class='delete']/button[@class='delete-element']");
    private By currency_use_table_additional_use_row_xpath = By.xpath("//*[@id='additionalCurrencyUses']/tr[@class='new']");
    private By labels_xpath = By.xpath("//*[@id='selection']/fieldset/h1");
    private By no_results_match_xpath = By.xpath("//*[@id='entitySelect_chosen']/div/ul/li");
    private By currency_input_xpath = By.xpath("//*[@class='chosen-search']/input");
    private By currency_save_confirmation_message_id = By.id("saveSuccess");
    private By currency_new_usage_delete_button_xpath=By.xpath(".//*[@id='additionalCurrencyUses']/tr[@class='new']//button");
    private By currency_delete_confirmation_modal_xpath = By.xpath("//*[@colspan='10']");
    private By currency_delete_no_button_id = By.id("no-button");
    private By currency_delete_yes_button_id= By.id("yes-button");



    private String editedCurrencyName="";
    private String editedCurrencyAbbr="";
    private String editedCurrencyUnit="";
    private String editedCurrencyQuantity="";
    private String editedCurrencyStartDay="";
    private String editedCurrencyStartMonth="";
    private String editedCurrencyStartYear="";
    private String editedCurrencyEndDay="";
    private String editedCurrencyEndMonth="";
    private String editedCurrencyEndYear="";
    private String editedCurrencyPrimary="";
    private String editedCurrencyCountry="";
    private String editedCurrencyReplacedBy="";

    public CurrencyPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }



    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyCurrencyList(Database database, ApacheHttpClient apacheHttpClient) {
        assertEquals(getDriver().findElement(labels_xpath).getText(), "CURRENCY");
        List<WebElement> currencyList = getDriver().findElements(currency_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "currency list");
        for (int i = 0; i < document.getElementsByTagName("name").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent(), currencyList.get(i).getText());
        }
    }

    public void verifyCurrencyDropDownMatchesSearchString() {
        List<WebElement> currencyList = getDriver().findElements(currency_country_list_xpath);
        for(int i=0; i<currencyList.size(); i++){
            assertTrue(currencyList.get(i).getText().toLowerCase().contains(currencySearchString.toLowerCase()));
        }
    }

    public void verifyCurrencyInListBox(ExamplesTable currencyList) {
        List<WebElement> expCurrencyList = getDriver().findElements(currency_country_list_xpath);
        for (int i=0; i<currencyList.getRowCount();i++){
            assertTrue(currencyList.getRow(i).containsValue(expCurrencyList.get(i).getText()));
        }
    }

    public void enterCurrency(String curr) {
        currencySearchString = curr;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(currency_input_xpath).sendKeys(curr);
        //return new CurrencyPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void verifyNoResultsMatchOption() {
        assertEquals("No results match \"" + currencySearchString + "\"", getDriver().findElement(no_results_match_xpath).getText());
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

    public void verifyCountryListInCurrencyEditMode(){
        List<WebElement> countryList = getDriver().findElements(currency_country_list_edit_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), countryList.get(i).getText().trim());
        }
    }

    public void verifyEditCurrencyDetailsFromTrusted(String selectedEntity) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            assertEquals(document.getElementsByTagName("iso").item(i).getTextContent(), getDriver().findElement(currency_iso_code_id).getText());
            assertEquals(document.getElementsByTagName("abbr").item(i).getTextContent(), getDriver().findElement(currency_input_abbr_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("name").item(i).getTextContent(), getDriver().findElement(currency_input_name_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("unit").item(i).getTextContent(), getDriver().findElement(currency_input_unit_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("quantity").item(i).getTextContent(), getDriver().findElement(currency_input_quantity_xpath).getAttribute("value"));
        }
    }

    public void verifyViewCurrencyDetailsFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedEntity) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            assertEquals("ISO", getTextOnPage(currency_iso_code_label_id));
            assertEquals(document.getElementsByTagName("iso").item(i).getTextContent(), getDriver().findElement(currency_iso_code_id).getText());
            assertEquals("Abbr", getTextOnPage(currency_abbr_label_xpath));
            assertEquals(document.getElementsByTagName("abbr").item(i).getTextContent(), getDriver().findElement(currency_abbr_xpath).getText());
            assertEquals("Name", getTextOnPage(currency_name_label_xpath));
            assertEquals(document.getElementsByTagName("name").item(i).getTextContent(), getDriver().findElement(currency_name_xpath).getText());
            assertEquals("Unit", getTextOnPage(currency_unit_label_xpath));
            assertEquals(document.getElementsByTagName("unit").item(i).getTextContent(), getDriver().findElement(currency_unit_xpath).getText());
            assertEquals("Quantity", getTextOnPage(currency_quantity_label_xpath));
            assertEquals(document.getElementsByTagName("quantity").item(i).getTextContent(), getDriver().findElement(currency_quantity_xpath).getText());
        }
    }

    public void verifyViewCurrencyUseFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency) {
        verifyCurrencyUseTableHeaders();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++){
            assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[1]")).trim());
            assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[2]")).trim());
            assertEquals(document.getElementsByTagName("endDate").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[3]")).trim());
            assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[4]")).trim().toLowerCase());
            assertEquals(document.getElementsByTagName("replacedByISO").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[5]")).trim());
            assertEquals(document.getElementsByTagName("status").item(i).getTextContent().trim(), getTextOnPage(By.xpath(currency_use_table_xpath_string + Integer.toString(i + 1) + "]/td[6]")).trim().toLowerCase());
        }
    }

    public void verifyCurrencyUseTableHeaders() {
        assertEquals(getTextOnPage(currency_use_table_header_xpath).replace("/n", "").replace("/r", ""), "COUNTRY START DATE END DATE PRIMARY REPLACED BY STATUS");
    }

    public void verifyNoCurrencyUse() {
        verifyCurrencyUseTableHeaders();
        try {
            assertNull(getDriver().findElement(currency_use_table_row_xpath));
        } catch(Exception NoSuchElementException){}
    }

    public void clickOnReplacedByLink(String replacedBy) {
        attemptClick(By.linkText(replacedBy));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyEditCurrencyInZeus(String selectedEntity){
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency details", nvPairs);
        for(int i=0;i<document.getElementsByTagName("currency").getLength();i++) {
            if (editedCurrencyName.equals("")){}else{
                assertEquals(editedCurrencyName, document.getElementsByTagName("name").item(i).getTextContent());}
            if (editedCurrencyAbbr.equals("")){}else{
                assertEquals(editedCurrencyAbbr, document.getElementsByTagName("abbr").item(i).getTextContent());}
            if (editedCurrencyUnit.equals("")){}else{
                assertEquals(editedCurrencyUnit, document.getElementsByTagName("unit").item(i).getTextContent());}
            if (editedCurrencyQuantity.equals("")){}else{
                assertEquals(editedCurrencyQuantity, document.getElementsByTagName("quantity").item(i).getTextContent());}
        }
    }

    public void verifyEditCurrencyUseFromTrusted(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency)
    {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++){
            assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).getText());
            assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim(), getDriver().findElement(currency_use_table_startDate_day_edit_xpath).getAttribute("value")+" "+getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).getText()+" "+getDriver().findElement(currency_use_table_startDate_year_edit_xpath).getAttribute("value"));
            assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(), getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).getAttribute("value"));
        }
    }

    public void verifyEditCurrencyUseInZeus(String selectedCurrency) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedCurrency));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "currency uses", nvPairs);
        for(int i=0; i<document.getElementsByTagName("currencyUse").getLength(); i++) {
            if (editedCurrencyCountry.equals("")) {
            } else {
                assertEquals(document.getElementsByTagName("countryName").item(i).getTextContent().trim(), editedCurrencyCountry);
            }
            if (editedCurrencyStartMonth.equals("") && editedCurrencyStartDay.equals("") && editedCurrencyStartYear.equals("")) {
            } else {
                assertEquals(document.getElementsByTagName("startDate").item(i).getTextContent().trim().replace(" ",""), editedCurrencyStartDay+editedCurrencyStartMonth+editedCurrencyStartYear);
            }
            if (editedCurrencyEndDay.equals("") && editedCurrencyEndMonth.equals("") && editedCurrencyEndYear.equals("")){
            } else {
                assertEquals(document.getElementsByTagName("endDate").item(i).getTextContent().trim().replace(" ", ""), editedCurrencyEndDay+editedCurrencyEndMonth+editedCurrencyEndYear);
            }
            if(editedCurrencyReplacedBy.equals("")){
            } else {
                assertEquals(document.getElementsByTagName("replacedByName").item(i).getTextContent().trim(), editedCurrencyReplacedBy);
            }
            if (editedCurrencyPrimary.equals("")){}
            else{
                assertEquals(document.getElementsByTagName("primary").item(i).getTextContent().trim(),editedCurrencyPrimary);
            }
            // verifying the accuracy for start date
            if(editedCurrencyStartDay.equals("")&& !editedCurrencyStartMonth.equals("") && !editedCurrencyStartYear.equals(""))
            {
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"month");
            }else if(editedCurrencyStartDay.equals("")&& editedCurrencyStartMonth.equals("") && !editedCurrencyStartYear.equals("")){
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"year");
            }else {
                assertEquals(document.getElementsByTagName("startDate").item(i).getAttributes().getNamedItem("accuracy").getTextContent(),"day");
            }
        }

    }

    public void verifyCurrencyViewMode() {
        assertTrue(getDriver().findElement(currency_abbr_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_name_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_unit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_quantity_xpath).isDisplayed());
    }

    public void verifyCurrencyUpdateModeForStatusActive() {
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_day_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_year_edit_xpath).isDisplayed());
        assertFalse(getDriver().findElement(currency_use_table_endDate_day_edit_xpath).isEnabled());
        assertFalse(getDriver().findElement(By.xpath(currency_use_table_endDate_month_edit_xpath + "/option[@selected='selected']")).isEnabled());
        assertFalse(getDriver().findElement(currency_use_table_endDate_year_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_replacedBy_disable_edit_xpath).isDisplayed());
    }

    public void verifyCurrencyUpdateModeForStatusInactive() {
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath + "/option[@selected='selected']")).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_startDate_day_edit_xpath).isDisplayed());

        //assertTrue(getDriver().findElement(currency_use_table_startDate_month_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_startDate_month_edit_xpath + "/option[@selected='selected']")).isDisplayed());

        assertTrue(getDriver().findElement(currency_use_table_startDate_year_edit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_use_table_endDate_day_edit_xpath).isEnabled());

        //assertTrue(getDriver().findElement(currency_use_table_endDate_month_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_endDate_month_edit_xpath+"/option[@selected='selected']")).isEnabled());
        assertTrue(getDriver().findElement(currency_use_table_endDate_year_edit_xpath).isEnabled());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_primary_edit_xpath + "/input[@checked]")).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath(currency_use_table_replacedBy_edit_xpath + "/a")).isDisplayed());
    }

    public void clickOnCurrencyUsageCountry(String currencyUsageCountry) {
        selectedEntity = currencyUsageCountry;
        attemptClick(By.linkText(currencyUsageCountry));
    }

    public void clickOnCurrencyIso3(String iso3) {
        attemptClick(By.linkText(iso3));
    }

    public void enterCurrencyName(String name) {
        editedCurrencyName = name;
        if(name.length() > 100){
            modifyHtmlByName(currency_input_name_xpath,"maxlength", "");
        }
        getDriver().findElement(currency_input_name_xpath).clear();
        getDriver().findElement(currency_input_name_xpath).sendKeys(name);
    }

    public void enterCurrencyAbbr(String abbr) {
        editedCurrencyAbbr = abbr;
        if(abbr.length() > 30){
            modifyHtmlByName(currency_input_abbr_xpath,"maxlength", "");
        }
        getDriver().findElement(currency_input_abbr_xpath).clear();
        getDriver().findElement(currency_input_abbr_xpath).sendKeys(abbr);
    }

    public void enterCurrencyUnit(String unit) {
        editedCurrencyUnit = unit;
        if(unit.length() > 100){
            modifyHtmlByName(currency_input_unit_xpath,"maxlength", "");
        }
        getDriver().findElement(currency_input_unit_xpath).clear();
        getDriver().findElement(currency_input_unit_xpath).sendKeys(unit);
    }

    public void enterCurrencyQuantity(String quantity) {
        editedCurrencyQuantity = quantity;
        /* Catching the NumberFormatException when user inputs alphabets*/
        try{
            if(Integer.parseInt(quantity) > 10000){
                modifyHtmlByName(currency_input_quantity_xpath,"maxlength", "");
            }
        } catch (Exception NumberFormatException){

        }
        getDriver().findElement(currency_input_quantity_xpath).clear();
        getDriver().findElement(currency_input_quantity_xpath).sendKeys(quantity);
    }

    public void verifyCurrencyPageForClickedISOName(){
        try{
            Thread.sleep(2000L);
            assertEquals("CURRENCY",getTextOnPage(currency_header_xpath));
            assertEquals(DataPage.clickedCurrencyIso,getTextOnPage(currency_header_iso_id));
        }catch (Exception e){

        }
    }

    public void revertChangesToCurrencyAfghani(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency afghani for zeus", nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency afghani for trusted", nvPairs);
    }

    public void revertChangesToCurrencyDeutscheMark(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency Deutsche Mark for zeus",nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency Deutsche Mark for trusted",nvPairs);

    }

    public void revertChangesToCurrencyAsianCurrencyUnit(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency asian currency unit for zeus", nvPairs);
        apacheHttpClient.executeDatabaseAdminQuery(database, "revert changes to currency asian currency unit for trusted", nvPairs);
    }

    public void verifyCurrencyEditMode(){
        assertTrue(getDriver().findElement(currency_input_name_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_abbr_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_unit_xpath).isDisplayed());
        assertTrue(getDriver().findElement(currency_input_quantity_xpath).isDisplayed());
    }

    public void verifyReplacedByCurrencyList(Database database, ApacheHttpClient apacheHttpClient, String selectedCurrency) {
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, "currency list");
        List<String> currencyList = new ArrayList<>();
        List <WebElement> replacedByCurrenciesList = getDriver().findElements(currency_replaced_by_xpath);
        for (int i = 0; i < document.getElementsByTagName("name").getLength(); i++) {
            currencyList.add(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent());
        }
        currencyList.remove(selectedCurrency);
        for(int i=0; i<getDriver().findElements(currency_replaced_by_xpath).size(); i++){
            assertEquals(currencyList.get(i),replacedByCurrenciesList.get(i).getText());
        }
    }

    public void selectCurrencyCountry(String currencyCountry) {
        selectItemFromDropdownListByValue(currency_country_list_edit_xpath, currencyCountry);
    }

    public void enterCurrencyStartDay(String currencyStartDay) {
        editedCurrencyStartDay = currencyStartDay;
        getDriver().findElement(currency_use_table_startDate_day_edit_xpath).clear();
        getDriver().findElement(currency_use_table_startDate_day_edit_xpath).sendKeys(currencyStartDay);
    }

    public void enterCurrencyNewStartDay(String currencyStartDay) {
        getDriver().findElement(currency_new_use_table_startDate_day_edit_xpath).clear();
        getDriver().findElement(currency_new_use_table_startDate_day_edit_xpath).sendKeys(currencyStartDay);
    }

    public void enterCurrencyStartMonth(String currencyStartMonth) {
        editedCurrencyStartMonth = currencyStartMonth;
        selectItemFromDropdownListByText(By.xpath(currency_use_table_startDate_month_edit_xpath), currencyStartMonth);
    }

    public void enterCurrencyNewStartMonth(String currencyStartMonth) {
        selectItemFromDropdownListByText(By.xpath(currency_new_use_table_startDate_month_edit_xpath), currencyStartMonth);
    }

    public void enterCurrencyStartYear(String currencyStartYear) {
        editedCurrencyStartYear = currencyStartYear;
        getDriver().findElement(currency_use_table_startDate_year_edit_xpath).clear();
        getDriver().findElement(currency_use_table_startDate_year_edit_xpath).sendKeys(currencyStartYear);
    }

    public void enterCurrencyNewStartYear(String currencyStartYear) {
        getDriver().findElement(currency_new_use_table_startDate_year_edit_xpath).clear();
        getDriver().findElement(currency_new_use_table_startDate_year_edit_xpath).sendKeys(currencyStartYear);
    }

    public void enterCurrencyEndDay(String currencyEndDay) {
        editedCurrencyEndDay = currencyEndDay;
        getDriver().findElement(currency_use_table_endDate_day_edit_xpath).clear();
        getDriver().findElement(currency_use_table_endDate_day_edit_xpath).sendKeys(currencyEndDay);
    }

    public void enterCurrencyEndMonth(String currencyEndMonth) {
        editedCurrencyEndMonth = currencyEndMonth;
        selectItemFromDropdownListByText(By.xpath(currency_use_table_endDate_month_edit_xpath), currencyEndMonth);

    }

    public void enterCurrencyEndYear(String currencyEndYear) {
        editedCurrencyEndYear = currencyEndYear;
        getDriver().findElement(currency_use_table_endDate_year_edit_xpath).clear();
        getDriver().findElement(currency_use_table_endDate_year_edit_xpath).sendKeys(currencyEndYear);
    }

    public void enterCurrencyPrimary(String rowIdentifier,String primary) {
        editedCurrencyPrimary=primary;
        selectRadioButtonByValue(CurrencyIdentifiers.getObjectIdentifier(rowIdentifier),primary);
    }

    public void enterCurrencyReplacedBy(String replacedBy) {
        editedCurrencyReplacedBy= replacedBy;
        getDriver().findElement(By.xpath(currency_use_table_replacedBy_edit_xpath+"/a")).click();

        getDriver().findElement(By.xpath(".//*[@id='content']/div/form/fieldset[2]/table/tbody[1]/tr/td[5]//input")).sendKeys(replacedBy);

        getDriver().findElement(By.xpath(".//*[@id='content']/div/form/fieldset[2]/table/tbody[1]/tr/td[5]//input")).sendKeys(Keys.RETURN);
    }

    public void clickOnCurrencyStartMonthDropDown() {
        attemptClick(currency_start_date_drop_down_xpath);
    }

    public void enterCountryInAddCountryTyAhead(String addCurrencyCountry) {
        getDriver().findElement(currency_add_country_type_ahead_input_xpath).sendKeys(addCurrencyCountry);
        getDriver().findElement(currency_add_country_type_ahead_input_xpath).sendKeys(Keys.RETURN);
    }

    public void enterCountryInCurrencyUsage(String currencyCountry){
        getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath)).sendKeys(currencyCountry);
        getDriver().findElement(By.xpath(currency_use_table_country_edit_xpath)).sendKeys(Keys.RETURN);
        editedCurrencyCountry=currencyCountry;
    }

    public void clickOnDeleteUseOption() {
        attemptClick(currency_use_table_delete_use_option_xpath);
        attemptClick(currency_delete_yes_button_id);
    }

    public void verifyNoAdditionalCurrencyUse(){
        try{
          assertFalse(getDriver().findElement(currency_use_table_additional_use_row_xpath).isDisplayed());

    }catch(NoSuchElementException e){
        e.printStackTrace();
    }
    }

    public void verifyErrorMessageForCurrAbbr() {
        assertEquals("Enter up to 30 valid characters.", getDriver().findElement(currency_abbr_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrName() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(currency_name_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrUnit() {
        assertEquals("Enter up to 100 valid characters.", getDriver().findElement(currency_unit_error_message_xpath).getText());
    }

    public void verifyErrorMessageForCurrQuantity() {
        assertEquals("Enter a numeric value up to 10,000.", getDriver().findElement(currency_quantity_error_message_xpath).getText());
    }

    public void verifyErrorMessageForRequiredField() {
        assertEquals("Required", getDriver().findElement(currency_name_error_message_xpath).getText());
    }

    public void clickOnAddCountryOption() {
        attemptClick(currency_add_country_option_xpath);
    }

    public void verifyPrimaryTrueByDefault(){
        assertEquals("true", getDriver().findElement(currency_use_table_additional_use_primary_edit_xpath).getAttribute("value"));
    }

    public void verifyStatusActiveByDefault() {
        assertEquals("Active", getDriver().findElement(currency_use_table_additional_use_status_xpath).getText());
    }

    public void verifyAddCountryList(Database database, ApacheHttpClient apacheHttpClient) {
        List<WebElement> addCountryList = getDriver().findElements(currency_add_country_list_xpath);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,"country list");
        for (int i = 0; i < document.getElementsByTagName("value").getLength(); i++) {
            assertEquals(document.getFirstChild().getChildNodes().item(i).getFirstChild().getTextContent().trim(), addCountryList.get(i).getText().trim());
        }
    }
    public void clickOnDeleteCurrencyUsage() {
        attemptClick(currency_new_usage_delete_button_xpath);
    }

    public void verifyDeleteConfirmationModalInCurrency() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(currency_delete_confirmation_modal_xpath).getText());
    }

    public CurrencyPage selectCurrencyFromTypeAhead(String currency) {

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(currency_input_xpath).sendKeys(currency);
        getDriver().findElement(currency_input_xpath).sendKeys(Keys.RETURN);
        waitForElementToAppear(By.xpath("//*[@id='entitySelect_chosen']/a/span[text()='"+currency+"']"));
        return new CurrencyPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void verifyCurrencyPage() {
        assertEquals("CURRENCY",getTextOnPage(currency_header_xpath));
    }

    public void verifySaveConfirmationMessage() {
        assertTrue(getDriver().findElement(currency_save_confirmation_message_id).isDisplayed());
    }

    public void clickOnNoButtonInDeleteConfirmationModalInCurrency() {
        attemptClick(currency_delete_no_button_id);
    }

    public void clickOnYesButtonInDeleteConfirmationInCurrency() {
        attemptClick(currency_delete_yes_button_id);
    }

    public void verifyNewlyAddedCurrencyUsage() {
        assertTrue(getDriver().findElement(currency_new_use_table_startDate_year_edit_xpath).isDisplayed());
    }

    public void verifyNoNewlyAddedCurrencyUsage() {
        try {
            assertFalse(getDriver().findElement(currency_new_usage_delete_button_xpath).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyDuplicatePrimaryCurrencyErrorMessage(String duplicatePrimaryError,String duplicateErrorMsg, int numberOfRows){

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(getDriver().findElements(CurrencyIdentifiers.getObjectIdentifier(duplicatePrimaryError)).size(),numberOfRows);
        assertEquals(duplicateErrorMsg, getDriver().findElement(CurrencyIdentifiers.getObjectIdentifier(duplicatePrimaryError)).getText());
    }
}
