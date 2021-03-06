package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import java.util.HashMap;

/**
 * Created by tubatil on 9/15/2016.
 */
public class ResultsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
        hmap.put("routingCode_results_list_header_xpath", By.xpath(".//*[@class='searchEntityList-container']//thead/tr"));
        hmap.put("routingCode_results_valid_character_error_message", By.xpath(".//*[@id='main-header']//p"));
        hmap.put("routingCode_results_zero_results_message_xpath", By.xpath(".//*[@id='searchEntityList-summary']//p"));
        hmap.put("routingCode_results_resultsCount_xpath", By.xpath(".//*[@class='search-results-module']//p"));
        hmap.put("routingCode_results_codeList_xpath", By.xpath(".//*[@class='search-results-module']//tbody//td[1]"));
        hmap.put("routingCode_results_type_xpath", By.xpath(".//*[@class='search-results-module']//td[2]"));
        hmap.put("routingCode_results_entity_xpath", By.xpath(".//*[@class='search-results-module']//td[3]"));
        hmap.put("routingCode_results_fid_xpath", By.xpath(".//*[@class='search-results-module']//td[4]"));
        hmap.put("routingCode_results_status_xpath",By.xpath(".//*[@class='search-results-module']//td[9]"));
        hmap.put("routingCode_results_country_xpath",By.xpath(".//*[@class='search-results-module']//td[8]"));
        hmap.put("routingCode_results_header_xpath", By.xpath(".//*[@class='data-header']//h1"));
        hmap.put("routingCode_results_codeHeader_xpath", By.xpath(".//th[@id='name']"));
        hmap.put("routingCode_results_typeHeader_xpath", By.xpath(".//th[@id='codeType']"));
        hmap.put("routingCode_results_entityHeader_xpath", By.xpath(".//th[@id='legalEntityName']"));
        hmap.put("", By.xpath(""));

    }
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
