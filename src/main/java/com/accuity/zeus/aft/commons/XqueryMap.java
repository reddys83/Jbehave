package com.accuity.zeus.aft.commons;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class XqueryMap {

    private HashMap<String, String> queryMap = new HashMap<String, String>();

    public XqueryMap(){
        queryMap.put("descending order by office fid","sortDescByOfficeFid.xqy");
        queryMap.put("ascending order by office fid", "sortAscByOfficeFid.xqy");
        queryMap.put("descending order by office status","sortDescByOfficeStatus.xqy");
        queryMap.put("ascending order by office status", "sortAscByOfficeStatus.xqy");
        queryMap.put("country list","getCountryList.xqy");
        queryMap.put("multiple office types sorted alphabetically", "multipleOfficeTypesAlphabetically.xqy");
        queryMap.put("ascending order by office type","sortAscByOfficeTypes.xqy");
        queryMap.put("descending order by office type","sortDescByOfficeTypes.xqy");
        queryMap.put("domestic offices list", "getDomesticOfficesList.xqy");
        queryMap.put("foreign offices list", "getForeignOfficesList.xqy");
        queryMap.put("currency list", "getCurrencyList.xqy");
        queryMap.put("currency uses", "getCurrencyUses.xqy");
        queryMap.put("currency details", "getCurrencyDetails.xqy");
        queryMap.put("ascending order by office name", "sortAscByOfficeName.xqy");
        queryMap.put("descending order by office name","sortDescByOfficeName.xqy");
        queryMap.put("taxonomies list", "getTaxonomiesList.xqy");
        queryMap.put("office locations", "getOfficeLocations.xqy");
        queryMap.put("ascending order by office area", "sortAscByOfficeArea.xqy");
        queryMap.put("descending order by office area", "sortDescByOfficeArea.xqy");
        queryMap.put("active offices list", "getActiveOfficesList.xqy");
        queryMap.put("inactive offices list", "getInactiveOfficesList.xqy");
        queryMap.put("ascending order by office country", "sortAscByOfficeCountry.xqy");
        queryMap.put("descending order by office country","sortDescByOfficeCountry.xqy");
        queryMap.put("ascending order by office city", "sortAscByOfficeCity.xqy");
        queryMap.put("descending order by office city", "sortDescByOfficeCity.xqy");
        queryMap.put("office types list", "getOfficeTypesList.xqy");
        queryMap.put("office search results with type filter","getOfficeSearchByTypeFilter.xqy");
        queryMap.put("revert changes to currency","updateCurrency.xqy");
    }

    public String getXquery(String key){
        return queryMap.get(key);
    }

}
