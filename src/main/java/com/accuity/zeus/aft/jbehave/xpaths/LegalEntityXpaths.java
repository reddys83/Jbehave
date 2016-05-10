package com.accuity.zeus.aft.jbehave.xpaths;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by soofis on 5/10/2016.
 */
public class LegalEntityXpaths {

    private HashMap<String, By> hmap = new HashMap<String, By>();

    public LegalEntityXpaths(){
        hmap.put("existing entitytype dropdown", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr/td/select[@id='legalEntityType']"));
        hmap.put("new entitytype dropdown", By.xpath("//*[@id='legalEntityBasicInfo']//table/tbody[@id='additionalTypes']/tr[@class='new']/td/select[@id='legalEntityType']"));
    }



    public By getXpath(String key) {
        return hmap.get(key);
    }


}
