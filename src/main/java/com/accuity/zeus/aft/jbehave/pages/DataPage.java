package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.commons.ParamMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.AreaIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.rest.Response;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.utils.SimpleCacheManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.http.ResponseEntity;
import org.w3c.dom.Document;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.*;

public class DataPage extends AbstractPage {

    private By currency_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li");
    private By edit_confirmationModal_summary_xpath = By.xpath(".//*[@class='summary']//li");
    private By area_tab_id = By.id("area-nav");
    public static String clickedCurrencyIso = "";
    private By legalEntity_tab_id = By.id("legalEntity-nav");
    private By country_listBox_xpath = By.xpath("//*[@id='selection0'] //*[@id='entitySelect_chosen']//span");
    private By area_listBox_xpath = By.xpath("//*[@id='selection1'] //*[@id='entitySelect_chosen']//span");
    private By subarea_listBox_xpath = By.xpath("//*[@id='selection2'] //*[@id='entitySelect_chosen']//span");
    private By regions_label_xpath = By.xpath("//li[contains(h1,'Regions for')] //span");
    private By country_type_ahead_xpath = By.xpath(".//*[@id='selection0'] //*[@id='entitySelect_chosen']//input");
    private By basic_info_xpath = By.xpath("//*[@id='content']/div/ul/li/h1/span");
    private By basic_info_names_label_xpath = By.xpath("//*[@id='content']//li[1]/h2[1]");
    private By basic_info_names_type_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[1]");
    private By basic_info_names_value_label_xpath = By.xpath("//*[@id='content']//table[1]/thead/tr/th[2]");
    private By basic_info_names_type_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[1]");
    private By basic_info_names_value_xpath = By.xpath("//*[@id='content']//li[1]/table[1]/tbody/tr/td[2]");

    private By legalEntity_basic_info_link_id = By.id("legalEntityBasicInfo");
    private By currency_update_button_id = By.id("update-button");


    private By identifiers_label_xpath = By.xpath("//*[@id='content']//h2[text()='Identifiers']");
    private By identifiers_type_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[1]");
    private By identifiers_value_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[2]");
    private By identifiers_status_label_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//th[3]");
    private By identifiers_type_xpath = By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//td[1]");

    private By legal_entity_office_identifiers_label_xpath = By.xpath("//*[@id='content']//li//h1/span[text()='Identifiers']");
    private By legal_entity_office_identifiers_type_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[1]");
    private By legal_entity_office_identifiers_value_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[2]");
    private By legal_entity_office_identifiers_status_label_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//th[3]");
    private By legal_entity_office_identifiers_type_xpath = By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//td[1]");


    private By basic_info_time_zones_label_xpath = By.xpath("//*[@id='content']//li[1]//h2[text()='Time Zones']");

    private String basic_info_label_xpath = "//*[@id='content']//li[2]/table/tbody/tr/th[text()='";
    private String basic_info_label_value_xpath = ".//*[@id='content']//table[@class='vertical']/tbody/tr[th='";

    private By regions_type_label_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/th[1]");
    private By regions_value_label_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/th[2]");
    private By regions_type_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/td[1]");
    private By regions_value_xpath = By.xpath("//li[contains(h1,'Regions for')]//tr/td[2]");


    private By credit_rating_label_xpath = By.xpath("//li[contains(h1,'Credit Rating')]/h1/span");
    private By credit_rating_table_headers_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//thead/tr");
    private By credit_rating_agency_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[1]");
    private By credit_rating_type_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[2]");
    private By credit_rating_value_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[3]");
    private By credit_rating_applied_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[4]");
    private By credit_rating_confirmed_date_xpath = By.xpath("//li[contains(h1,'Credit Rating')]//tbody/tr/td[5]");


    private By currency_cancel_button_id = By.id("cancel-button");

    private By places_label_xpath = By.xpath("//li[contains(h1,'Places')]//span");
    private By places_type_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[1]");
    private By places_place_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[2]");
    private By places_details_label_xpath = By.xpath("//li[contains(h1,'Places')]//table/thead//th[3]");
    private By country_places_type_xpath = By.xpath("//li[contains(h1,'Places')]//table/tbody//td[1]");
    public static String selectedEntity = "";

    private By entities_label_xpath = By.xpath("//li[contains(h1,'Entities')]//span");
    private By entities_type_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[1]");
    private By entities_entity_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[2]");
    private By entities_details_label_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/thead//th[3]");
    private By country_entities_type_xpath = By.xpath("//li[contains(h1,'Entities for ')]//table/tbody//td[1]");
    private By select_all_link_xpath = By.xpath("//*[@id='all'][@class='selected']");
    private By all_link_id = By.id("all");

    private By area_area_dropdown_xpath = By.xpath("//*[@id='selection1'] /div //*[@id='entitySelect_chosen'] //a");
    private By area_subarea_dropdown_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen'] //a");


    private By area_time_zones_summary_label_xpath = By.xpath(".//*[@id='content']//li[1]/dl/dt");
    private By area_time_zones_summary_xpath = By.xpath(".//*[@id='content']//li[1]/dl/dd");
    private By area_time_zones_xpath = By.xpath(".//*[@id='content']//li/table[3]/tbody/tr/th");
    private By area_time_zones_value_xpath = By.xpath(".//*[@id='content']//li/table[3]/tbody/tr/td");
    private By city_tab_id = By.id("city-nav");
    private By city_city_dropdown_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen'] //a");
    private By city_city_dropdown_list_xpath = By.xpath(".//*[@id='selection2'] //ul/li");
    private By city_city_dropdown_disabled_xpath = By.xpath(".//*[@id='selection2'] /div //*[contains(@class,'chosen-disabled')]");
    private By area_credit_ratings_link_id = By.id("areaCreditRating");
    private By area_regions_link_id = By.id("areaRegions");
    private By city_credit_ratings_link_id = By.id("cityCreditRating");
    private By city_people_link_id = By.id("cityPeople");
    private By area_entities_link_id = By.id("areaPresences");
    private By identifiers_header_xpath = By.xpath("//li[h1='Identifiers'] //span");
    private By office_sort_name_label_xpath = By.xpath("//*[@id='content']//li[1]/dl/dt");
    private By office_sort_name_value_xpath = By.xpath("//*[@id='content']//li[1]/dl/dd");

    private By people_label_xpath = By.xpath("//li[contains(h1,'People')]//span");
    private By people_type_label_xpath = By.xpath("//li[contains(h1,'People for ')]//table/thead//th[1]");
    private By people_entity_label_xpath = By.xpath("//li[contains(h1,'People for ')]//table/thead//th[2]");
    private By people_type_xpath = By.xpath("//li[contains(h1,'People for ')]//table/tbody//td[1]");
    private By area_area_dropdown_list_xpath = By.xpath(".//*[@id='selection1'] //ul/li");
    private By area_subarea_dropdown_list_xpath = By.xpath(".//*[@id='selection2'] //ul/li");
    private By area_area_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection1'] /div //*[@id='entitySelect_chosen']//input");
    private By area_subarea_dropdown_typeAhead_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    private By area_basic_info_link_id = By.id("areaBasicInfo");
    private By area_related_places_link_id = By.id("areaPlaces");
    private By area_related_people_link_id = By.id("areaPeople");
    private By area_demographics_link_id = By.id("areaDemographics");
    private By area_demographics_label_xpath = By.xpath("//li[contains(h1, 'Demographics for')]/h1/span");
    private By area_demographics_type_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[1]");
    private By area_demographics_value_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[2]");
    private By area_demographics_unit_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[3]");
    private By area_demographics_date_label_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table/thead//th[4]");
    private By area_demographics_type_xpath = By.xpath("//li[contains(h1, 'Demographics')]//table//tbody//td[1]");
    private By city_type_ahead_xpath = By.xpath(".//*[@id='selection2'] /div //*[@id='entitySelect_chosen']//input");
    private By city_region_link_id = By.id("cityRegions");
    public By city_entity_link_id = By.id("cityPresences");
    private By city_basic_info_link_id = By.id("cityBasicInfo");
    private By city_related_places_link_id = By.id("cityPlaces");

    private By basic_info_office_names_label_xpath = By.xpath(".//*[@id='content']//li[1]/h2[2]");
    private By basic_info_office_type_label_xpath = By.xpath(".//*[@id='content']//li[1]/table[2]/thead/tr/th");
    private By basic_info_office_type_xpath = By.xpath(".//*[@id='content']//li[1]/table[2]/tbody/tr/td");

    private By personnel_label_xpath = By.xpath("//li[contains(h1,'Personnel')]/h1/span");
    private By personnel_type_label_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/thead//th[1]");
    private By personnel_value_label_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/thead//th[2]");
    private By personnel_type_list_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/tbody//td[1]");
    private By personnel_value_list_xpath = By.xpath("//li[contains(h1,'Personnel')]//table/tbody//td[2]");

    private By history_label_xpath = By.xpath("//li/h1/span[text()='History']");
    private By history_message_xpath = By.xpath("//li[contains(h1,'History')]/p");

    private By statistics_label_xpath = By.xpath("//li/h1/span[text()='Statistics']");
    private By statistics_type_label_xpath = By.xpath("//li[h1='Statistics'] //thead/tr/th[1]");
    private By statistics_value_label_xpath = By.xpath("//li[h1='Statistics'] //thead/tr/th[2]");
    private By statistics_type_list_xpath = By.xpath("//li[h1='Statistics'] //table/tbody/tr/th");
    private By statistics_value_list_xpath = By.xpath("//li[h1='Statistics'] //table/tbody/tr/td");

    private By searchResults_institution_xpath = By.xpath(".//*[@id='cssTempFixId']/header//a");
    private By searchResults_headOffice_address_xpath = By.xpath(".//*[@id='cssTempFixId']/header//p");
    private By searchResults_header_fid_xpath = By.xpath(".//*[@id='cssTempFixId']/header/table//tr[th='FID']/td");
    private By searchResults_header_tfpid_xpath = By.xpath(".//*[@id='cssTempFixId']/header/table//tr[th='TFPID']/td");

    private String city_area_link_xpath = "//*[@class='vertical']//tr[5]/td[a='";
    private String city_subarea_link_xpath = "//*[@class='vertical']//tr[6]/td[a='";
    private String city_country_link_xpath = "//*[@class='vertical']//tr[4]/td[a='";
    String city_related_places_place_link_xpath = "//li[contains(h1,'Places')]//tr[td='";
    private String city_name_link_xpath = "//*[@id='cityBasicInfo']//tbody/tr[th='Replaced By']//a[text()='";

    private By sections_display_xpath = By.xpath("//*[@id='data-side-navbar']//h1");
    private By sections_list_xpath = By.xpath("//*[@id='data-side-navbar']//ul/li");

    private By country_dropdown_is_visible_xpath = By.xpath("//*[@id='selection0']//div[@class='chosen-container chosen-container-single']");
    private By area_dropdown_is_visible_xpath = By.xpath("//*[@id='selection1']//div[@class='chosen-container chosen-container-single']");
    private By subarea_city_dropdown_is_visible_xpath = By.xpath("//*[@id='selection2']//div[@class='chosen-container chosen-container-single']");
    private String area_area_parent_link_xpath = "//table[@class='vertical']//td[a='";
    private By basic_info_left_section_xpath = By.xpath("//table[@class='vertical']/tbody//th");

    private String area_area_city_link_xpath = "//*[@id='areaPlaces']/table/tbody//td[a='";
    private String area_related_places_place_link_xpath = "//li[contains(h1,'Places')]//tr[td='";
    private By select_places_view_xpath = By.xpath(".//*[@id='areaPlaces']/h1/span']");

    private By save_button_id = By.id("save-button");
    private By error_message_at_top_xpath = By.xpath("//*[@id='error']/div/div/p");
    private By confirm_button_xpath = By.xpath("//*[@id='modal-region'] //*[@id='confirm-button']");
    private By cancel_yes_button_xpath = By.xpath("//*[@class='modal-content'] //*[@id='confirm-button']");
    private By return_button_xpath = By.xpath("//*[@id='modal-region'] //button[@id='cancel-button']");
    private By confirm_changes_info_xpath = By.xpath("//*[@id='modal-region']/div/p");
    private By confirm_changes_heading_xpath = By.xpath("//*[@id='modal-region']/div/h1");
    private By country_tab_xpath = By.xpath("//*[@id='data-navbar']/ul/li[2]");
    private By cancel_no_button_xpath = By.xpath("//*[@class='modal-content'] //*[@id='cancel-button']");
    private By currency_country_selection_disabled_xpath = By.xpath(".//*[@id='entitySelect_chosen'][@class='chosen-container chosen-container-single chosen-disabled']");
    private By start_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='startDateError']");
    private By end_date_error_msg_xpath = By.xpath("//*[@class='notification error'][@data-error_id='endDateError']");
    private By choose_currency_option_xpath = By.xpath("//*[@id='entitySelect_chosen']/a/span");
    private By cancel_update_confirmation_modal_xpath = By.xpath("//*[@id='modal-region']/div");
    private By delete_row_confirmation_modal_xpath = By.xpath("//*[@colspan='10']");
    private By delete_confirmation_no_button_id = By.id("no-button");
    private By delete_confirmation_yes_button_id = By.id("yes-button");
    private By save_success_message_id=By.id("saveSuccess");
    private By area_basic_info_country_link_xpath = By.xpath(".//*//tr[th='Country']/td/a");

    static ResponseEntity responseEntity;
    static String endpointWithID;

    public DataPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }


    @Override
    public String getPageUrl() {
        return null;
    }

    public CurrencyPage clickOnCurrencyTab() {
        attemptClick(currency_tab_xpath);
        return new CurrencyPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public CurrencyPage clickOnChooseACurrencyOption() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(choose_currency_option_xpath).click();
        return new CurrencyPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void clickOnCountryTab() {
        attemptClick(country_tab_xpath);
    }

    public CountryPage clickOnCountryListBox() {
        waitForElementToAppear(country_dropdown_is_visible_xpath);
        attemptClick(country_listBox_xpath);
        return new CountryPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void clickOnAreaTab() {
        attemptClick(area_tab_id);
    }

    public LegalEntityPage clickOnLegalEntityTab() {
        attemptClick(legalEntity_tab_id);
        return new LegalEntityPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void clickOnCancelButton() {
        attemptClick(currency_cancel_button_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CountryPage enterCountryInTheTypeAheadBox(String country) {
        SimpleCacheManager.getInstance().put("selectedCountry",country);
        selectedEntity = country;
        getDriver().findElement(country_type_ahead_xpath).sendKeys(country);
        getDriver().findElement(country_type_ahead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CountryPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void enterAreaInTypeAhead(String area) {
        SimpleCacheManager.getInstance().put("selectedArea",area);
        selectedEntity = area;
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(area);
        getDriver().findElement(area_area_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyBasicInfo() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("BASIC INFO", getDriver().findElement(basic_info_xpath).getText());
    }

    public void verifyNames(ExamplesTable namesList) {
        assertEquals("NAMES", getDriver().findElement(basic_info_names_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(basic_info_names_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(basic_info_names_value_label_xpath).getText());
        List<WebElement> actNameTypes = getDriver().findElements(basic_info_names_type_xpath);
        List<WebElement> actNameValue = getDriver().findElements(basic_info_names_value_xpath);
        for (int i = 0; i < namesList.getRowCount(); i++) {
            assertEquals(namesList.getRow(i).get(namesList.getHeaders().get(0)), actNameTypes.get(i).getText());
            assertEquals(namesList.getRow(i).get(namesList.getHeaders().get(1)), actNameValue.get(i).getText());
        }
    }

    public void verifyTypes(ExamplesTable types) {
        assertEquals("OFFICE TYPES", getDriver().findElement(basic_info_office_names_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(basic_info_office_type_label_xpath).getText());
        List<WebElement> officeTypes = getDriver().findElements(basic_info_office_type_xpath);
        for (int i = 0; i < types.getRowCount(); i++) {
            assertEquals(types.getRow(i).get(types.getHeaders().get(0)), officeTypes.get(i).getText());
        }
    }

    public void clickOnLegalEntityBasicInfo() {
        attemptClick(legalEntity_basic_info_link_id);
    }

    public void verifyIdentifiers(ExamplesTable identifiers) {
        verifyIdentifiersLabels();
        List<WebElement> IdentifiersTypeVal = getDriver().findElements(identifiers_type_xpath);
        assertTrue(identifiers.getRowCount() == IdentifiersTypeVal.size());
        for (int i = 0; i < identifiers.getRowCount(); i++) {
            assertEquals(identifiers.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", "").trim(),
                    getDriver().findElement(
                            By.xpath("//li[h2='Identifiers']/table[thead/tr[contains(.,'Status')]]//tr[td='" + identifiers.getRow(i)
                                    .get(identifiers.getHeaders().get(0)) + "']")).getText().replace(",", "").replace(" ", "").trim());
        }
    }

    public void verifyIdentifiersLabels() {
        assertEquals("IDENTIFIERS", getDriver().findElement(identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(identifiers_status_label_xpath).getText());
    }

    public void verifyLegalEntityOfficeIdentifiers(ExamplesTable identifiers) {
        verifyLegalEntityOfficeIdentifiersLabels();
        List<WebElement> IdentifiersTypeVal = getDriver().findElements(legal_entity_office_identifiers_type_xpath);
        assertTrue(identifiers.getRowCount() == IdentifiersTypeVal.size());
        for (int i = 0; i < identifiers.getRowCount(); i++) {
            assertEquals(identifiers.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", "").trim(),
                    getDriver().findElement(
                            By.xpath("//li[contains(h1,'Identifiers')]/table[thead/tr[contains(.,'Status')]]//tr[td='" + identifiers.getRow(i)
                                    .get(identifiers.getHeaders().get(0)) + "']")).getText().replace(",", "").replace(" ", "").trim());

        }
    }

    public void verifyLegalEntityOfficeIdentifiersLabels() {
        assertEquals("IDENTIFIERS", getDriver().findElement(legal_entity_office_identifiers_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(legal_entity_office_identifiers_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(legal_entity_office_identifiers_value_label_xpath).getText());
        assertEquals("STATUS", getDriver().findElement(legal_entity_office_identifiers_status_label_xpath).getText());
    }

    public void verifyIdentifiersSectionLabels() {
        verifyIdentifiersLabels();
        assertEquals("IDENTIFIERS", getDriver().findElement(identifiers_header_xpath).getText());
    }

    public void verifyAreaTimeZonesSummary(String areaTimeZonesSummary) {
        assertEquals("Summary", getDriver().findElement(area_time_zones_summary_label_xpath).getText());
        assertEquals(areaTimeZonesSummary, getDriver().findElement(area_time_zones_summary_xpath).getText());
    }

    public void verifyAreaTimeZones(ExamplesTable areaTimeZones) {
        assertEquals("TIME ZONES", getDriver().findElement(basic_info_time_zones_label_xpath).getText());
        List<WebElement> actAreaTimeZone = getDriver().findElements(area_time_zones_xpath);
        List<WebElement> actAreaTimeZoneValue = getDriver().findElements(area_time_zones_value_xpath);
        for (int i = 0; i < areaTimeZones.getRowCount(); i++) {
            assertEquals(areaTimeZones.getRow(i).get(areaTimeZones.getHeaders().get(0)), actAreaTimeZone.get(i).getText());
            assertEquals(areaTimeZones.getRow(i).get(areaTimeZones.getHeaders().get(1)), actAreaTimeZoneValue.get(i).getText());
        }
    }

    public void verifyStatusNotEditable() {
        try {
            getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Status']/td")).getAttribute("data-edit_id").toString();
        } catch (Exception e) {
            assertTrue(e.toString().equals("java.lang.NullPointerException"));
        }
    }


    public void verifyHeader(String entity, String headOfficeAddress, String fid, String tfpid) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(entity, getDriver().findElement(searchResults_institution_xpath).getText());
        assertEquals(headOfficeAddress, getDriver().findElement(searchResults_headOffice_address_xpath).getText());
        assertEquals(fid, getDriver().findElement(searchResults_header_fid_xpath).getText());
        assertEquals(tfpid, getDriver().findElement(searchResults_header_tfpid_xpath).getText());
    }

    public void verifyBasicInfo(String label, String value) {
        assertEquals(label, getDriver().findElement(By.xpath(basic_info_label_xpath + label + "']")).getText());
        assertEquals(value, getDriver().findElement(By.xpath(basic_info_label_value_xpath + label + "']/td")).getText().replace("\n", ""));
    }

    public void verifyReplaceByLabelValues(String replacedBy) {
        assertEquals("Replaced By", getDriver().findElement(By.xpath(basic_info_label_xpath + "Replaced By']")).getText());
        String replacedBys[] = replacedBy.split(" ");
        int values = getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText().split(",").length;
        if (replacedBys.length == values)
            for (int i = 0; i < replacedBys.length; i++) {
                assertTrue(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Replaced By']/td")).getText().contains(replacedBys[i].replace(",", "")));
            }
    }

    public void verifyAreaLinkInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Area Parent']/td")).isSelected());
    }

    public void verifyAreaLinkForCityInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Area']/td")).isSelected());
    }

    public void verifySubAreaLinkForCityInBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Sub Area']/td")).isSelected());
    }

    public void verifyRegions(ExamplesTable regions) {
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(regions_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(regions_value_label_xpath).getText());
        List<WebElement> regionType = getDriver().findElements(regions_type_xpath);
        List<WebElement> regionValue = getDriver().findElements(regions_value_xpath);
        for (int i = 0; i < regions.getRowCount(); i++) {
            assertEquals(regions.getRow(i).get(regions.getHeaders().get(0)), regionType.get(i).getText());
            assertEquals(regions.getRow(i).get(regions.getHeaders().get(1)), regionValue.get(i).getText());
        }
    }

    public void verifyNoCountryRegionsSection() {
        try {
            assertFalse(getDriver().findElement(regions_label_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    private void verifyCreditRatingsInternal(ExamplesTable creditRatings) {
        List<WebElement> agency = getDriver().findElements(credit_rating_agency_xpath);
        List<WebElement> type = getDriver().findElements(credit_rating_type_xpath);
        List<WebElement> value = getDriver().findElements(credit_rating_value_xpath);
        List<WebElement> appliedDate = getDriver().findElements(credit_rating_applied_date_xpath);
        List<WebElement> confirmedDate = getDriver().findElements(credit_rating_confirmed_date_xpath);
        for (int i = 0; i < creditRatings.getRowCount(); i++) {
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(0)), agency.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(1)), type.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(2)), value.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(3)), appliedDate.get(i).getText());
            assertEquals(creditRatings.getRow(i).get(creditRatings.getHeaders().get(4)), confirmedDate.get(i).getText());
        }
    }

    public void verifyCreditRatingsGeo(ExamplesTable creditRatings) {
        verifyCreditRatingsLabelsGeo();
        verifyCreditRatingsInternal(creditRatings);
    }

    public void verifyCreditRatings(ExamplesTable creditRatings) {
        verifyCreditRatingsLabels();
        verifyCreditRatingsInternal(creditRatings);
    }

    private void verifyCreditRatingsLabelsInternal() {
        assertEquals("AGENCY TYPE VALUE APPLIED DATE CONFIRMED DATE", getDriver().findElement(credit_rating_table_headers_xpath).getText());
    }

    public void verifyCreditRatingsLabelsGeo() {
        assertEquals("CREDIT RATING FOR " + selectedEntity.toUpperCase(), getDriver().findElement(credit_rating_label_xpath).getText());
        verifyCreditRatingsLabelsInternal();
    }

    public void verifyCreditRatingsLabels() {
        assertEquals("CREDIT RATING", getDriver().findElement(credit_rating_label_xpath).getText());
        verifyCreditRatingsLabelsInternal();
    }

    public void verifyNoCreditRatings() {
        verifyCreditRatingsLabels();
        try {
            assertFalse(getDriver().findElement(credit_rating_agency_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyNoCreditRatingsGeo() {
        verifyCreditRatingsLabelsGeo();
        try {
            assertFalse(getDriver().findElement(credit_rating_agency_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyCountryRelatedPlacesFromTrusted() {
        verifyPlacesLabel();
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "country related places", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("relation").getLength(); i++) {
            assertEquals(document.getElementsByTagName("type").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='countryPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[1]")).getText());
            assertEquals(document.getElementsByTagName("value").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='countryPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[2]")).getText());
            assertEquals(document.getElementsByTagName("details").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='countryPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[3]")).getText());
        }
    }

    public void verifyPlacesLabel() {
        assertEquals("PLACES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(places_label_xpath).getText());
    }

    public void verifyNoPlaces() {
        assertEquals("PLACES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(places_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_places_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void verifyEntities(ExamplesTable countryEntities) {
        verifyEntitiesLabel();
        assertEquals("TYPE", getDriver().findElement(entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(entities_details_label_xpath).getText());
        for (int i = 0; i < countryEntities.getRowCount(); i++) {
            assertEquals(countryEntities.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryEntities.getRow(i).get(countryEntities.getHeaders().get(0)) + "']")).getText().replace(",", "").trim());
        }
    }


    public void verifyEntitiesLabel() {
        assertEquals("ENTITIES FOR " + selectedEntity.toUpperCase(), getDriver().findElement(entities_label_xpath).getText());
    }

    public void verifyRegionsLabel() {
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
    }

    public void verifyNoEntities() {
        verifyEntitiesLabel();
        assertEquals("TYPE", getDriver().findElement(entities_type_label_xpath).getText());
        assertEquals("ENTITY", getDriver().findElement(entities_entity_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(entities_details_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(country_entities_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyDefaultToViewAll() {
        assertTrue(getDriver().findElement(select_all_link_xpath).isDisplayed());
    }

    public void clicksOnAllLink() {
        attemptClick(all_link_id);
    }

    public void verifyDefaultBasicInfo() {
        assertTrue(getDriver().findElement(city_basic_info_link_id).isDisplayed());
    }

    public void refreshThePage() {
        getDriver().navigate().refresh();
    }

    public void verifyPeople(ExamplesTable countryPeople) {
        verifyPeopleLabel();
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        for (int i = 0; i < countryPeople.getRowCount(); i++) {
            assertEquals(countryPeople.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + countryPeople.getRow(i).get(countryPeople.getHeaders().get(0)) + "']")).getText().replace(",", "").trim());
        }
    }

    public void verifyPeopleLabel() {
        assertEquals("PEOPLE FOR " + selectedEntity.toUpperCase(), getDriver().findElement(people_label_xpath).getText());
    }

    public void verifyNoPeople() {
        assertEquals("PEOPLE FOR " + selectedEntity.toUpperCase(), getDriver().findElement(people_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(people_type_label_xpath).getText());
        assertEquals("PERSON", getDriver().findElement(people_entity_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(people_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnAreaDropdown() {
        waitForElementToAppear(area_dropdown_is_visible_xpath);
        attemptClick(area_area_dropdown_xpath);
    }

    public void verifySubareaForSelectedArea(ExamplesTable subarea) {
        attemptClick(area_subarea_dropdown_xpath);
        List<WebElement> subareaCollection = getDriver().findElements(area_subarea_dropdown_list_xpath);
        for (int i = 0; i < subarea.getRowCount(); i++) {
            assertEquals(subarea.getRow(i).get(subarea.getHeaders().get(0)), subareaCollection.get(i).getText());
        }
    }

    public void verifyAreaDropdownDisabled() {
        assertFalse(getDriver().findElement(area_area_dropdown_xpath).isSelected());
    }

    public void verifySubareaDropdownDisabled() {
        assertFalse(getDriver().findElement(area_subarea_dropdown_xpath).isSelected());
    }

    public void clickOnAreaBasicInfoInNavigationBar() {
        attemptClick(area_basic_info_link_id);
    }

    public void clickOnCityBasicInfoInNavigationBar() {
        attemptClick(city_basic_info_link_id);
    }

    public void clickOnAreaRelatedPlaces() {
        attemptClick(area_related_places_link_id);
    }

    public void verifyAreaRelatedPlacesFromTrusted() {
        verifyPlacesLabel();
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area related places", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("relation").getLength(); i++) {
            assertEquals(document.getElementsByTagName("type").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='areaPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[1]")).getText());
            assertEquals(document.getElementsByTagName("value").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='areaPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[2]")).getText());
            assertEquals(document.getElementsByTagName("details").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='areaPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[3]")).getText());
        }
    }

    public void verifyCityRelatedPlacesFromTrusted() {
        verifyPlacesLabel();
        assertEquals("TYPE", getDriver().findElement(places_type_label_xpath).getText());
        assertEquals("PLACE", getDriver().findElement(places_place_label_xpath).getText());
        assertEquals("DETAILS", getDriver().findElement(places_details_label_xpath).getText());

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city related places", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("relation").getLength(); i++) {
            assertEquals(document.getElementsByTagName("type").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='cityPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[1]")).getText());
            assertEquals(document.getElementsByTagName("value").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='cityPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[2]")).getText());
            assertEquals(document.getElementsByTagName("details").item(i).getTextContent(), getDriver().findElement(By.xpath("//*[@id='cityPlaces']//table//tbody/tr[td='" + document.getElementsByTagName("type").item(i).getTextContent() + "']/td[3]")).getText());
        }
    }

    public void clickOnCityRelatedPlaces() {
        attemptClick(city_related_places_link_id);
    }

    public void clickOnAreaRelatedPeople() {
        attemptClick(area_related_people_link_id);
    }

    public void clickOnDemographics() {
        attemptClick(area_demographics_link_id);
    }

    public void verifyDemographics(ExamplesTable areaDemographics) {
        verifyDemographicsLabel();
        assertEquals("TYPE", getDriver().findElement(area_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(area_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(area_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(area_demographics_date_label_xpath).getText());
        List<WebElement> areaDemographicsTypeVal = getDriver().findElements(area_demographics_type_xpath);
        assertTrue(areaDemographics.getRowCount() == areaDemographicsTypeVal.size());
        for (int i = 0; i < areaDemographics.getRowCount(); i++) {
            assertEquals(areaDemographics.getRow(i).values().toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", "").trim(),
                    getDriver().findElement(
                            By.xpath("//*[@id='content']//table/tbody//tr[td='" + areaDemographics.getRow(i).get(areaDemographics.getHeaders().get(0)) + "']")).getText().replace(",", "").replace(" ", "").trim());

        }
    }

    public void verifyDemographicsLabel() {
       assertEquals("DEMOGRAPHICS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(area_demographics_label_xpath).getText());
    }

    public void verifyNoDemographics() {
        verifyDemographicsLabel();
        assertEquals("TYPE", getDriver().findElement(area_demographics_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(area_demographics_value_label_xpath).getText());
        assertEquals("UNIT", getDriver().findElement(area_demographics_unit_label_xpath).getText());
        assertEquals("DATE", getDriver().findElement(area_demographics_date_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(area_demographics_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void verifyStatistics(ExamplesTable statistics) {
        verifyStatisticsLabels();
        List<WebElement> type = getDriver().findElements(statistics_type_list_xpath);
        List<WebElement> value = getDriver().findElements(statistics_value_list_xpath);

        for (int i = 0; i < statistics.getRowCount(); i++) {
            assertEquals(statistics.getRow(i).get(statistics.getHeaders().get(0)), type.get(i).getText());
            assertEquals(statistics.getRow(i).get(statistics.getHeaders().get(1)), value.get(i).getText());
        }
    }

    public void verifyStatisticsLabels() {
        assertEquals("STATISTICS", getTextOnPage(statistics_label_xpath));
        assertEquals("TYPE", getTextOnPage(statistics_type_label_xpath));
        assertEquals("VALUE", getTextOnPage(statistics_value_label_xpath));
    }

    public void clickOnCityTab() {
        attemptClick(city_tab_id);
    }

    public void clickOnCityDropdown() {
        waitForElementToAppear(subarea_city_dropdown_is_visible_xpath);
        attemptClick(city_city_dropdown_xpath);
    }

    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        List<WebElement> areasCollection = getDriver().findElements(city_city_dropdown_list_xpath);
        for (int i = 0; i < cities.getRowCount(); i++) {
            assertEquals(cities.getRow(i).get(cities.getHeaders().get(0)), areasCollection.get(i).getText());
        }
    }

    public void verifyNoCitiesForSelectedArea() {
        assertTrue(getDriver().findElement(city_city_dropdown_disabled_xpath).isDisplayed());
    }

    public void clickOnAreasCreditRatings() {
        attemptClick(area_credit_ratings_link_id);
    }

    public void clickOnSubAreaDropDown() {
        waitForElementToAppear(subarea_city_dropdown_is_visible_xpath);
        attemptClick(area_subarea_dropdown_xpath);
    }

    public void enterSubAreaInTypeAhead(String subArea) {
        selectedEntity = subArea;
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(subArea);
        getDriver().findElement(area_subarea_dropdown_typeAhead_xpath).sendKeys(Keys.RETURN);
    }

    public void clickOnAreasAlternativeRegions() {
        attemptClick(area_regions_link_id);
    }

    public void verifyNoAlternativeRegions() {
        assertEquals("REGIONS FOR " + selectedEntity.toUpperCase(), getDriver().findElement(regions_label_xpath).getText());
        assertEquals("TYPE", getDriver().findElement(regions_type_label_xpath).getText());
        assertEquals("VALUE", getDriver().findElement(regions_value_label_xpath).getText());
        try {
            assertFalse(getDriver().findElement(regions_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
    }

    public void clickOnCityCreditRatings() {
        attemptClick(city_credit_ratings_link_id);
    }

    public void clickOnCityEntity() {
        attemptClick(city_entity_link_id);
    }

    public void enterCityInTheTypeAheadBox(String city) {
        SimpleCacheManager.getInstance().put("selectedCity",city);
        selectedEntity = city;
        getDriver().findElement(city_type_ahead_xpath).sendKeys(city);
        getDriver().findElement(city_type_ahead_xpath).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityRegionsInNavigationBar() {
        attemptClick(city_region_link_id);
    }

    public void clickOnCityRelatedPeople() {
        attemptClick(city_people_link_id);
    }

    public void clickOnAreaEntity() {
        attemptClick(area_entities_link_id);
    }

    public void verifyNoIdentifiers() {
        verifyIdentifiersLabels();
        try {
            assertFalse(getDriver().findElement(identifiers_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyNoLegalEntityOfficeIdentifiers() {
        verifyLegalEntityOfficeIdentifiersLabels();
        try {
            assertFalse(getDriver().findElement(legal_entity_office_identifiers_type_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyPersonnel(ExamplesTable personnel) {
        verifyPersonnelLabels();
        List<WebElement> type = getDriver().findElements(personnel_type_list_xpath);
        List<WebElement> value = getDriver().findElements(personnel_value_list_xpath);

        for (int i = 0; i < personnel.getRowCount(); i++) {
            assertEquals(personnel.getRow(i).get(personnel.getHeaders().get(0)), type.get(i).getText());
            assertEquals(personnel.getRow(i).get(personnel.getHeaders().get(1)), value.get(i).getText());
        }
    }

    public void verifyPersonnelLabels() {
        assertEquals("PERSONNEL", getTextOnPage(personnel_label_xpath));
        assertEquals("TYPE", getTextOnPage(personnel_type_label_xpath));
        assertEquals("VALUE", getTextOnPage(personnel_value_label_xpath));
    }

    public void verifyNoPersonnel() {
        verifyPersonnelLabels();
        try {
            assertFalse(getDriver().findElement(personnel_type_list_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyHistoryLabel() {
        assertEquals("HISTORY", getTextOnPage(history_label_xpath));
    }

    public void verifyHistory(ExamplesTable history) {
        verifyHistoryLabel();
        assertEquals(history.getRow(0).get(history.getHeaders().get(0)), getTextOnPage(history_message_xpath));
    }

    public void verifyNoHistory() {
        verifyHistoryLabel();
        try {
            assertFalse(getDriver().findElement(history_message_xpath).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyOfficeSortKey(String officeSortKey) {
        assertEquals("Sort Name", getTextOnPage(office_sort_name_label_xpath));
        assertEquals(officeSortKey, getTextOnPage(office_sort_name_value_xpath));
    }

    public void clickOnAreaParentLink(String areaParent) {
        attemptClick(By.xpath(area_area_parent_link_xpath + areaParent + "']/a"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnAreaCityLink(String areaCity) {
        attemptClick(By.xpath(area_area_city_link_xpath + areaCity + "']/a"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnViewHeadOfficeLink(String viewHeadOffice) {
        attemptClick(By.linkText(viewHeadOffice));
    }

    public void verifyHeadOfficeInLegalEntityBasicInfo() {
        assertFalse(getDriver().findElement(By.xpath(basic_info_label_value_xpath + "Head Office']/td")).isSelected());
    }

    public CurrencyPage clickOnISOLink(String isoCode) {
        clickedCurrencyIso = isoCode;
        attemptClick(By.linkText(isoCode));
        return new CurrencyPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
    }

    public void clickOnCityArea(String area) {
        attemptClick(By.xpath(city_area_link_xpath + area + "']/a"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyClickedAreaPage(String countryDropDown, String areaDropDown, String subAreaDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(countryDropDown, getDriver().findElement(country_listBox_xpath).getText());
        assertEquals(areaDropDown, getDriver().findElement(area_listBox_xpath).getText());
        assertEquals(subAreaDropDown, getDriver().findElement(subarea_listBox_xpath).getText());
    }

    public void clickOnCitySubArea(String subArea) {
        attemptClick(By.xpath(city_subarea_link_xpath + subArea + "']/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityNameLink(String subCity)
    {
        attemptClick(By.xpath(city_name_link_xpath + subCity +  "']"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public void clickOnCityRelatedPlace(String relatedPlace) {
        attemptClick(By.xpath(city_related_places_place_link_xpath + relatedPlace + "']/td/a"));
        waitForElementToAppear(area_listBox_xpath);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCityCountry(String country) {
        attemptClick(By.xpath(city_country_link_xpath + country + "']/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyClickedCountryPage(String countryDropDown) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(countryDropDown, getDriver().findElement(country_listBox_xpath).getText());
    }

    public void verifySections(ExamplesTable sections) {
        assertEquals("DISPLAY:", getDriver().findElement(sections_display_xpath).getText());
        for (int i = 0; i < getDriver().findElements(sections_list_xpath).size(); i++) {
            assertEquals(sections.getRow(i).get(sections.getHeaders().get(0)), getDriver().findElements(sections_list_xpath).get(i).getText());
        }
    }

    public void verifyBasicInfoLeftSection(ExamplesTable basicInfoLeftSection) {
        List<WebElement> basicInfoLeftSectionFields = getDriver().findElements(basic_info_left_section_xpath);
        for (int i = 0; i < getDriver().findElements(basic_info_left_section_xpath).size(); i++) {
            assertEquals(basicInfoLeftSection.getRow(i).get(basicInfoLeftSection.getHeaders().get(0)), basicInfoLeftSectionFields.get(i).getText());
        }
    }

    public void verifyNoCityAlternativeRegionsSection() {
        try {
            assertFalse(getDriver().findElement(regions_label_xpath).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickOnSaveButton() {
        attemptClick(save_button_id);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnConfirmButton() {
        attemptClick(confirm_button_xpath);
        (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(save_success_message_id));

    }

    public void getDocument(String xqueryName, String param, String entity) {
        ParamMap paramMap = new ParamMap();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair(paramMap.getParam(param), entity));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        if (document != null) {
            endpointWithID = document.getElementsByTagName("documentIdwithEndpoint").item(0).getAttributes().getNamedItem("resource").getTextContent().toString();
            responseEntity = restClient.getDocumentByID(endpointWithID, heraApi);
            assertTrue(responseEntity.getStatusCode().value() == 200);
        } else {
            assertFalse("Zeus document with " + param + " as " + entity + " does not exist in the DB", true);
        }
    }

    public void getDocument(String xqueryName, String name) {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", name));
        nvPairs.add(new BasicNameValuePair("source", "zeus"));

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, xqueryName, nvPairs);
        if(document != null) {
	        endpointWithID = document.getElementsByTagName("documentIdwithEndpoint").item(0).getAttributes().getNamedItem("resource").getTextContent().toString();

	        responseEntity = restClient.getDocumentByID(endpointWithID, heraApi);
	        assertTrue(responseEntity.getStatusCode().value() == 200);
	    }
	    else {
            assertFalse("Zeus document with name " + name + " does not exist in the DB", true);
	    }
    }

    public void revertChangesToDocument() {

        int response = restClient.putDocumentByID(endpointWithID, heraApi, responseEntity.getBody().toString());
        assertTrue(response == 200);
    }

    public void clickOnCancelYesButton() {
        attemptClick(cancel_yes_button_xpath);
    }

    public void verifySaveConfirmationModal() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Confirm Changes", getDriver().findElement(confirm_changes_heading_xpath).getText());
        assertEquals("Click Confirm to save or Return to continue with your edits.", getDriver().findElement(confirm_changes_info_xpath).getText());
        assertEquals("RETURN", getDriver().findElement(return_button_xpath).getText());
        assertEquals("CONFIRM", getDriver().findElement(confirm_button_xpath).getText());
    }

    public void verifyCurrencySelectionDisabled() {
        assertTrue(getDriver().findElement(currency_country_selection_disabled_xpath).isDisplayed());
    }


    public void clickOnReturnButton() {
        attemptClick(return_button_xpath);
    }

    public void clickOnCancelNoButton() {
        attemptClick(cancel_no_button_xpath);
    }

    public void verifyAreaList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "area list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("area").getLength(); i++) {
            assertEquals(document.getElementsByTagName("area").item(i).getTextContent(), getDriver().findElements(area_area_dropdown_list_xpath).get(i).getText());
        }
    }

    public void verifySubAreaList(Database database, ApacheHttpClient apacheHttpClient) {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "subarea list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("subarea").getLength(); i++) {
            assertEquals(document.getElementsByTagName("subarea").item(i).getTextContent(), getDriver().findElements(area_subarea_dropdown_list_xpath).get(i).getText());
        }
    }

    public void verifyCityList() {
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("name", selectedEntity));
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "city list", nvPairs);
        for (int i = 0; i < document.getElementsByTagName("city").getLength(); i++) {
            assertEquals(document.getElementsByTagName("city").item(i).getTextContent(), getDriver().findElements(city_city_dropdown_list_xpath).get(i).getText());
        }
    }

    public void verifyErrorMessageAtTopOfThePage() {
        assertEquals("The highlighted fields must be addressed before this update can be saved.", getDriver().findElement(error_message_at_top_xpath).getText());
    }

    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        List<WebElement> areasCollection = getDriver().findElements(area_area_dropdown_list_xpath);
        for (int i = 0; i < areas.getRowCount(); i++) {
            assertEquals(areas.getRow(i).get(areas.getHeaders().get(0)), areasCollection.get(i).getText());
        }
    }

    public void clickOnUpdateCurrencyLink() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attemptClick(currency_update_button_id);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyStartDateErrorMessage(String startDateErrorMsg) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(startDateErrorMsg.replace("'", ""), getDriver().findElement(start_date_error_msg_xpath).getText());
    }

    public void verifyStartDateErrorMessageForDayMonthYear() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(start_date_error_msg_xpath).getText());
    }

    public void verifyEndDateErrorMessageForDayMonthYear() {
        assertEquals("Enter a year, month/year or day/month/year.", getDriver().findElement(end_date_error_msg_xpath).getText());
    }

    public void verifyEndDateErrorMessage(String endDateErrorMsg) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(endDateErrorMsg.replace("'", ""), getDriver().findElement(end_date_error_msg_xpath).getText());
    }

    public void verifyNoCancelUpdateConfirmationModal() {
        try {
            assertFalse(getDriver().findElement(cancel_update_confirmation_modal_xpath).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public void verifyCancelUpdateConfirmationModal() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Cancel UpdateDo you want to leave this update without saving?NO YES", getDriver().findElement(cancel_update_confirmation_modal_xpath).getText().replace("\n", ""));
    }

    public void verifyUserRedirectedViewMode() {
        try {
            Thread.sleep(1000);
            assertTrue(getDriver().findElement(currency_update_button_id).isDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public void verifySummaryConfirmationModal(ExamplesTable Summary) {
		try {
			Thread.sleep(1000);
			List<WebElement> confirmChanges = getDriver().findElements(edit_confirmationModal_summary_xpath);
			for (int i = 0; i < Summary.getRowCount(); i++) {
				assertEquals(Summary.getRow(i).get(Summary.getHeaders().get(0)), confirmChanges.get(i).getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public void verifyNoSummaryConfirmationModal(ExamplesTable Summary) {
        try {
            Thread.sleep(1000);
            List<WebElement> confirmChanges = getDriver().findElements(edit_confirmationModal_summary_xpath);
            for (int i = 0; i < Summary.getRowCount(); i++) {
                assertFalse(Summary.getRow(i).get(Summary.getHeaders().get(0)).equals(confirmChanges.get(i).getText()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(true);
        }
    }

    public void verifyDeleteConfirmationModal() {
        assertEquals("Please confirm - would you like to delete this row? NO YES", getDriver().findElement(delete_row_confirmation_modal_xpath).getText());
    }

    public void clickOnNoButtonInDeleteConfirmationModal() {
        attemptClick(delete_confirmation_no_button_id);
    }

    public void clickOnYesButtonInDeleteConfirmationModal() {
        attemptClick(delete_confirmation_yes_button_id);
    }

    public void loadDocument(String xqueryName) {

        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database,xqueryName);
        assertTrue(document!=null);


    }

    public EditCityPage createEditCityPage() {
        return new EditCityPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);

    }

    public void clickOnCountryLink() {
        attemptClick(area_basic_info_country_link_xpath);
    }

    
    public void clickOnAreaRelatedPlace(String relatedPlace) {
        attemptClick(By.xpath(area_related_places_place_link_xpath + relatedPlace + "']/td/a"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public EditAreaPage createEditAreaPage() {
        return new EditAreaPage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);

    }
    
    public void verifyNoSummaryConfirmationModal(String summaryText) {
		try {
			WebElement confirmChanges = getDriver()
					.findElement(cancel_update_confirmation_modal_xpath);
			String confirmationText = confirmChanges.getText();
			assertTrue(!(confirmationText.contains("Summary")) && !(confirmationText.contains(summaryText)));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

    public void changeBrowserUrlAndNavigate(String id){
        String curentUrl=getDriver().getCurrentUrl();
        String[]currentUrl=curentUrl.split("country/");
        curentUrl=currentUrl[0]+"country/"+id;
        getDriver().navigate().to(curentUrl);
    }

    public void verifyViewModeForEntity(){
        assertTrue(getDriver().findElement(currency_update_button_id).isDisplayed());
    }

    public void verifyAreaPlacesView() {
        assertTrue(getDriver().findElement(select_places_view_xpath).isDisplayed());
    }


}