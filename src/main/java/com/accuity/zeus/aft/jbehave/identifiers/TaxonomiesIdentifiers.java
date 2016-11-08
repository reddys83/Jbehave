package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class TaxonomiesIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
    	hmap.put("hierarchial_taxonomies_list", By.xpath("//*[@class='multi-body']//tbody"));
    }
    
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
    
}