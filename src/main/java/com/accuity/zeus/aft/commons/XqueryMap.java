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
        queryMap.put("get View legalEntity Names", "getViewLegalEntityNames.xqy");
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

        queryMap.put("get office basic info","getOfficeBasicInfo.xqy");
        queryMap.put("get id for offices", "getIdForOffices.xqy");

        queryMap.put("get Office Telecoms Types", "getOfficeTelecomsTypeFromLookup.xqy");
        queryMap.put("get Office Address Types", "getOfficeAddressTypesFromLookup.xqy");
        queryMap.put("get Office Locations", "getOfficeLocations.xqy");

		queryMap.put("get city places type lookup","getCityRelatedPlacesTypeFromLookup.xqy");
		queryMap.put("get city places detail lookup","getCityRelatedPlacesDetailsFromLookup.xqy");
		queryMap.put("get city related place info","getCityRelatedPlaces.xqy");

        queryMap.put("get LegalEntity personnel", "getLegalEntityPersonnel.xqy");
        queryMap.put("get LegalEntity IdentifierTypes From Lookup","getLegalEntityIdentifierTypesFromLookup.xqy");
        queryMap.put("get LegalEntity IdentifierStatus From Lookup","getLegalEntityIdentifierStatusFromLookup.xqy");
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
		queryMap.put("get area name types","getAreaNameTypes.xqy");
		queryMap.put("get area basic info","getAreaBasicInfo.xqy");
		queryMap.put("active office test list","getActiveOfficeFidTest.xqy");
		queryMap.put("get area identifiers","getCountryIdentifiers.xqy");
        queryMap.put("get offices office types","getOfficesOfficeTypes.xqy");
        queryMap.put("get office name types from lookup","getOfficeNameTypesFromLookup.xqy");
        queryMap.put("get office identifiers values", "getOfficeIdentifiers.xqy");
		queryMap.put("get office identifiers type list", "getOfficeIdentifiersTypesFromLookup.xqy");
		queryMap.put("get office Status types", "getCityStatusTypes.xqy");
        queryMap.put("get area timezones","getCountryTimeZone.xqy");
        queryMap.put("get city region types","getCityRegionTypes.xqy");
		queryMap.put("get city region values","getCityRegionValues.xqy");
		queryMap.put("get office personnel values", "getOfficePersonnel.xqy");
		queryMap.put("get office personnel type list", "getLegalEntityPersonnelTypesFromLookup.xqy");
		queryMap.put("get office history details","getOfficeHistory.xqy");
		queryMap.put("get office statistics values","getOfficeStatisticsValues.xqy");
		queryMap.put("get office service category list","getOfficeServiceCategoryFromLookup.xqy");
		queryMap.put("get office service values","getOfficeServiceValues.xqy");
		queryMap.put("get area region types","getAreaRegionTypes.xqy");
		queryMap.put("get area region values","getAreaRegionValues.xqy");
		queryMap.put("get area regions list","getAreaRegionList.xqy");
		queryMap.put("get area demographics type","getDemographicsType.xqy");
        queryMap.put("get area demographics unit","getDemographicsUnit.xqy");
        queryMap.put("get area demographics info","getAreaDemographics.xqy");
		queryMap.put("get area credit ratings", "getAreaCreditRatingValues.xqy");
        queryMap.put("get routingCode results", "getRoutingCodeResults.xqy");
		queryMap.put("get area places type lookup","getAreaRelatedPlacesTypeFromLookup.xqy");
		queryMap.put("get area places detail lookup","getAreaRelatedPlacesDetailsFromLookup.xqy");
		queryMap.put("get area related place info","getAreaRelatedPlaces.xqy");
		queryMap.put("get document id for subarea","getIdForSubArea.xqy");
        queryMap.put("get Id for area", "getIdForArea.xqy");
        queryMap.put("get routingCode basic info","getRoutingCodeBasicInfo.xqy");
        queryMap.put("get routingCode usages", "getRoutingCodeUsages.xqy");
		queryMap.put("get office telecom locations", "getOfficeTelecomLocations.xqy");
		queryMap.put("delete office locations values", "deleteOfficeLocationsValues.xqy");
		queryMap.put("get area entity type lookup","getAreaRelatedEntityTypeFromLookup.xqy");
		queryMap.put("get area entity detail lookup", "getAreaRelatedEntityDetailsFromLookup.xqy");
		queryMap.put("get area entity details", "getAreaRelatedEntityDetails.xqy");
		queryMap.put("get document id for routing code", "getIdForRoutingCode.xqy");
		queryMap.put("get postalCodePos from countryDoc","getPostalCodeFromCountryDoc.xqy");
		queryMap.put("change routing code status", "changeRoutingCodeStatus.xqy");
		queryMap.put("get routing code former usages values", "getRoutingCodeFormerUsages.xqy");
		queryMap.put("delete routing code former usages values", "deleteRoutingCodeFormerUsagesValues.xqy");
		queryMap.put("insert routing code former usages values", "insertRoutingCodeFormerUsagesValues.xqy");
        queryMap.put("get routingCode relatedCodes", "getRoutingCodeRelatedCodes.xqy");

        queryMap.put("get routingCode payment systems info","getRoutingCodePaymentSystems.xqy");
        queryMap.put("get routing code subtype lookup", "getRoutingCodeSubtypeFromLookup.xqy");
        queryMap.put("get ABA code source lookup", "getABACodeSourceTypesFromLookup.xqy");        
        queryMap.put("get routing code history values", "getRoutingCodeHistoryDetails.xqy");        
        queryMap.put("get office locations summary type lookup", "getOfficeLocationsSummaryTypeFromLookup.xqy");
        queryMap.put("get hierarchial taxonomy sub-grouping values", "getHierarchialTaxonomySubGroupingValues.xqy");
   }

    public String getXquery(String key){
        return queryMap.get(key);
    }

}
