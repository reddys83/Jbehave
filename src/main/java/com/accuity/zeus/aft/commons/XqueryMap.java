package com.accuity.zeus.aft.commons;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by soofis on 8/24/2015.
 */
@Component
public class XqueryMap {

    private HashMap<String, String> hashMap = new HashMap<String, String>();

    public XqueryMap(){
        hashMap.put("list of countries","testSample.xqy");
    }

    public String getXquery(String key){
        return hashMap.get(key);
    }
}
