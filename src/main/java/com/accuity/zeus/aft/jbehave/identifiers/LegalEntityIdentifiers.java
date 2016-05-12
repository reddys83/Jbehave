package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by soofis on 5/10/2016.
 */
public class LegalEntityIdentifiers {

    private HashMap<String, By> hmap = new HashMap<String, By>();

    public LegalEntityIdentifiers(){
        hmap.put("first_existing_entitytype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[1]/td[1]/select")));
        hmap.put("second_existing_entitytype_dropdown", By.xpath(("//tbody[@id='additionalTypes']/tr[2]/td[1]/select")));
        hmap.put("first_new_entitytype_dropdown", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='legalEntityType']"));
        hmap.put("first_row_existing_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[1]/td[@class='delete']/button"));
        hmap.put("second_row_existing_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[2]/td[@class='delete']/button"));
        hmap.put("first_new_entitytype_delete_button", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td[@class='delete']/button"));
    }



    public By getObjectIdentifier(String key) {

        return hmap.get(key);

    }

}
