package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by konugantis on 5/13/2016.
 */
public class CurrencyIdentifiers {

    private HashMap<String, By> hmap = new HashMap<String, By>();

    public CurrencyIdentifiers(){
        hmap.put("first_existing_row_currency_primary_radio_button", By.xpath(("//tr[1]//fieldset[@data-error_id='primary']/input")));
        hmap.put("first_new_row_currency_primary_radio_button", By.xpath(("//tr[@class='new'][1]//fieldset[@data-error_id='primary']/input")));
        hmap.put("second_new_row_currency_primary_radio_button", By.xpath(("//tr[@class='new'][2]//fieldset[@data-error_id='primary']/input")));
        hmap.put("duplicate_primary_currency_error_message",By.xpath("//*[@data-error_id='primaryError'][@class='notification error']"));
    }

    public By getObjectIdentifier(String key) {

        return hmap.get(key);

    }
}
