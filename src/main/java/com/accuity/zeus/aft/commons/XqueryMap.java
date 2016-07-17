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
        queryMap.put("get legalEntity Locations","getLegalEntityLocations.xqy");
        queryMap.put("office types list", "getOfficeTypesList.xqy");
        queryMap.put("office search results with type filter","getOfficeSearchByTypeFilter.xqy");
        queryMap.put("get Id for currency","getIdForCurrency.xqy");
        queryMap.put("area list","getAreaList.xqy");
        queryMap.put("subarea list","getSubAreaList.xqy");
        queryMap.put("city list","getCityList.xqy");
        queryMap.put("country basic info","getCountryBasicInfo.xqy");
        queryMap.put("get LegalEntity BoardMeeting","getLegalEntityBoardMeetings.xqy");
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
        queryMap.put("get country regions type","getCountryAlternativeRegions.xqy");
        queryMap.put("get values for region type","getCountryAlternateRegionValues.xqy");
        queryMap.put("ascending order by office address","sortAscByOfficeAddressLine1.xqy");
        queryMap.put("descending order by office address","sortDescByOfficeAddressLine1.xqy");
        queryMap.put("area related places","getAreaRelatedPlaces.xqy");
        queryMap.put("city related places", "getCityRelatedPlaces.xqy");
        queryMap.put("country related places", "getCountryRelatedPlaces.xqy");
        queryMap.put("get country places type", "getCountryPlacesType.xqy");
        queryMap.put("get country places details","getCountryPlacesDetails.xqy");
        queryMap.put("get Trust Powers for Legal Entity", "getLegalEntityTrustPowers.xqy");
        queryMap.put("get legal entity basic info left column","getLegalEntityBasicInfo.xqy");
        queryMap.put("get Office Location Summary From LegalEntity", "getOfficeLocationSummaryFromLegalEntity.xqy");
        queryMap.put("get charter type from lookup document", "getCharterTypeFromLookupTable.xqy");
        queryMap.put("get legal entity Status types","getLegalEntityStatusTypes.xqy");
        queryMap.put("abcd","getLegalEntityLeadInstitutionFlag.xqy");
        queryMap.put("get Id for legalentity","getIdForLegalEntity.xqy");
        queryMap.put("get legal entity entity types","getLegalEntityEntityTypes.xqy");
        queryMap.put("load test data for Area illinois","loadTestDataAreaIL.xqy");
        queryMap.put("load test data for City Chicago","loadTestDataCityChicago.xqy");
        queryMap.put("load test data for Currency","loadTestDataCurrency.xqy");
        queryMap.put("load test data for sub area Cook","loadTestDataSubAreaCook.xqy");
        queryMap.put("get data from lookup table","getValueFromLookupTable.xqy");
        queryMap.put("get city basic info","getCityBasicInfo.xqy");
        queryMap.put("get document id for city","getIdForCity.xqy");
        queryMap.put("get LegalEntity statistics flag","getLegalEntityStatisticsFlag.xqy");
        queryMap.put("get country related entities","getCountryRelatedEntities.xqy");
        queryMap.put("verify trust power section display","checkConditionForTrustPowersSection.xqy");
        queryMap.put("get document id for city","getIdForCity.xqy");
        queryMap.put("get city identifiers", "getCountryIdentifiers.xqy");
		queryMap.put("get city Status types","getCityStatusTypes.xqy");
		queryMap.put("get city basic info","getCityBasicInfo.xqy");
        queryMap.put("get office basic info","getOfficeBasicInfo.xqy");
        queryMap.put("get id for offices", "getIdForOffices.xqy");

		queryMap.put("get city places type lookup","getCityRelatedPlacesTypeFromLookup.xqy");
		queryMap.put("get city places detail lookup","getCityRelatedPlacesDetailsFromLookup.xqy");
		queryMap.put("get city related place info","getCityRelatedPlaces.xqy");
		queryMap.put("get city basic info","getCityBasicInfo.xqy");
        queryMap.put("get LegalEntity personnel", "getLegalEntityPersonnel.xqy");
        queryMap.put("get LegalEntity IdentifierTypes From Lookup","getLegalEntityIdentifierTypesFromLookup.xqy");
        queryMap.put("get LegalEntity IdentifierStatus From Lookup","getLegalEntityIdentifierStatusFromLookup.xqy");
		queryMap.put("get area basic info","getAreaBasicInfo.xqy");
        queryMap.put("get city credit look up values","getCityCreditRatingLookUpValues.xqy");
        queryMap.put("get LegalEntity OwnershipType From Lookup","getLegalEntityOwnershipSummariesFromLookup.xqy");
		queryMap.put("get city basic info","getCityBasicInfo.xqy");
        queryMap.put("get legalEntity Services From Lookup","getLegalEntityServicesFromLookup.xqy");
        queryMap.put("get legalEntity Services From DB","getLegalEntityServicesFromDB.xqy");
        queryMap.put("get legal entity credit ratings from trusted","getLegalEntityCreditRatings.xqy");
        queryMap.put("get document id for area","getIdForArea.xqy");
        queryMap.put("get city name types","getCityNameTypes.xqy");
		queryMap.put("get area Status types","getCityStatusTypes.xqy");
		queryMap.put("get areastatus","getAreaStatus.xqy");
		queryMap.put("get area basic info","getAreaBasicInfo.xqy");
        queryMap.put("get office name types from lookup","getOfficeNameTypesFromLookup.xqy");
   }

    public String getXquery(String key){
        return queryMap.get(key);
    }

}
