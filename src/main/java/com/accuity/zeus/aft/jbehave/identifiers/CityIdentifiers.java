package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by shahc1 on 5/19/2016.
 */
public class CityIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public CityIdentifiers(){
       hmap.put("city_add_info_text_xpath",By.xpath(("")));
       hmap.put("city_save_confirmation_message_id",By.id(("")));
       hmap.put("city_addInfo_error_message_edit_xpath", By.xpath(""));
    }
    public static By getObjectIdentifier(String key) {

        return hmap.get(key);

    }
}
