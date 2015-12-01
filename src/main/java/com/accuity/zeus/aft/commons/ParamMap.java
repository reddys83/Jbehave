package com.accuity.zeus.aft.commons;

import java.util.HashMap;

public class ParamMap {
    private HashMap<String, String> paramMap = new HashMap<String, String>();

    public ParamMap(){
        paramMap.put("name","name");
        paramMap.put("fid", "fid");
        paramMap.put("tfpid","tfpid");
    }

    public String getParam(String key){
        return paramMap.get(key);
    }
}
