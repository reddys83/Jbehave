package com.accuity.zeus.aft.jbehave.identifiers;

import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by shahc1 on 5/19/2016.
 */
public class CityIdentifiers {

    private static HashMap<String, By> hmap = new HashMap<String, By>();

    public CityIdentifiers(){

    }
    public static By getObjectIdentifier(String key) {

        return hmap.get(key);

    }
}
