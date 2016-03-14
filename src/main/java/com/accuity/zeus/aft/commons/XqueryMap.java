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
        queryMap.put("get Id for currency","getIdForCurrency.xqy");
        queryMap.put("area list","getAreaList.xqy");
        queryMap.put("subarea list","getSubAreaList.xqy");
        queryMap.put("city list","getCityList.xqy");
        queryMap.put("country basic info","getCountryBasicInfo.xqy");
        queryMap.put("get country names type", "getCountryNamesType.xqy");
        queryMap.put("get country time zones", "getCountryTimeZone.xqy");
        queryMap.put("get country identifiers", "getCountryIdentifiers.xqy");
        queryMap.put("get routing code types", "getRoutingCodeTypes.xqy");
        queryMap.put("get country iso2 list", "getCountryISO2List.xqy");
        queryMap.put("get country IBAN info", "getCountryIBANInfo.xqy");
        queryMap.put("get country routing codes", "getCountryRoutingCodes.xqy");
        queryMap.put("get country demographics type","getDemographicsType.xqy");
        queryMap.put("get country demographics unit","getDemographicsUnit.xqy");
        queryMap.put("get country banking hrs","getCountryBankingHrs.xqy");
        queryMap.put("get Id for country","getIdForCountry.xqy");
        queryMap.put("get country holidays", "getCountryHolidays.xqy");
        queryMap.put("ascending order by office address","sortAscByOfficeAddressLine1.xqy");
        queryMap.put("descending order by office address","sortDescByOfficeAddressLine1.xqy");

   }

    public String getXquery(String key){
        return queryMap.get(key);
    }

}
