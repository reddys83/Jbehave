package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

public class TaxonomiesIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public static void setIdentifiers() {
    	hmap.put("taxonomies_sub_groupings", By.xpath("//*[@class='multi-body']//*[@class='level1']"));
    	hmap.put("taxonomies_update_button", By.xpath("//*[@id='update-button']"));
    	hmap.put("taxonomies_category_header", By.xpath("//*[@class='side-navbar-layout']//h1"));
    	hmap.put("taxonomies_column_header_list", By.xpath("//*[@class='side-navbar-layout']//th"));
    	hmap.put("taxonomies_row_values_list", By.xpath("//*[@class='side-navbar-layout']//tbody//tr"));
    	hmap.put("taxonomies_dropdown_list", By.xpath("//*[@class='chosen-results']//*[contains(@class,'active-result')]"));
    	hmap.put("hierarchial_taxonomies_list", By.xpath("//*[@class='multi-body']//tbody//tr[@class='level1']"));    	
    	hmap.put("hierarchical_taxonomy_sub_groupings_list", By.xpath("//*[@class='multi-body']//*[starts-with(@class,'level')]"));
    	hmap.put("hierarchical_taxonomies_row_values_list", By.xpath("//*[@class='side-navbar-layout']//tbody//tr"));
    }
    
    public static By getObjectIdentifier(String key) {
        setIdentifiers();
        return hmap.get(key);

    }
    
}