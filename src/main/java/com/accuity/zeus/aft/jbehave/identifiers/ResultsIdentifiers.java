package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import java.util.HashMap;

/**
 * Created by tubatil on 9/15/2016.
 */
public class ResultsIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
            hmap.put("routingCode_results_header_code_xpath", By.xpath(".//*[@class='searchEntityList-container']//th[@id='name']"));
            hmap.put("routingCode_results_header_type_xpath", By.xpath(".//*[@class='searchEntityList-container']//th[@id='codeType']"));
            hmap.put("routingCode_results_header_entity_xpath", By.xpath(".//*[@class='searchEntityList-container']//th[@id='legalEntityName']"));
            hmap.put("routingCode_results_header_fid_xpath", By.xpath(""));
            hmap.put("routingCode_results_header_address_xpath", By.xpath(""));
            hmap.put("", By.xpath());

    }

    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
}
