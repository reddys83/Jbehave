package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class TaxonomiesIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
    	hmap.put("taxonomies_sub_groupings", By.xpath("//*[@class='multi-body']//*[@class='level1']"));
    	hmap.put("taxonomies_update_button", By.xpath("//*[@id='update-button']"));
    	hmap.put("taxonomies_category_header", By.xpath("//*[@class='side-navbar-layout']//span"));
    }
    
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
    
}