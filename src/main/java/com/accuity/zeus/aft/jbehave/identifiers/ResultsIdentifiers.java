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
        hmap.put("routingCode_results_header_xpath", By.xpath(".//*[@class='data-header']//h1"));

    }
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
