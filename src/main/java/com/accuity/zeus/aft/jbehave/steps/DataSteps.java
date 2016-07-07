package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.Database;
import org.eclipse.jetty.util.annotation.Name;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSteps extends AbstractSteps {

    @Autowired
    com.accuity.zeus.aft.io.ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    @When("the user clicks on the currency tab in the data area")
    public void clickOnCurrencyTab() {
        getDataPage().clickOnCurrencyTab();
    }

	@When("the user clicks on the city update link")
	public void clickOnUpdateCurrencyLink() {
		getDataPage().clickOnUpdateCurrencyLink();
		setEditCityPage(getDataPage().createEditCityPage());
	}

    @When("the user clicks on the country tab in the data area")
    public void clickOnCountryTab() {
        getDataPage().clickOnCountryTab();
    }

    @When("the user clicks on the area tab in the data area")
    public void clickOnAreaTab() {
        getDataPage().clickOnAreaTab();
    }

    @When("the user clicks on the legal entity tab in the data area")
    public void userClicksOnLegalEntityTab() {
        setLegalEntityPage(getDataPage().clickOnLegalEntityTab());
    }

    @When("the user enters the country <country> in the type-ahead box")
    public void enterCountryInTheTypeAheadBox(@Named("country") String country) {
        setCountryPage(getDataPage().enterCountryInTheTypeAheadBox(country));
    }

    @When("the user clicks on the choose a country option")
    public void clickOnCountryListBox() throws InterruptedException {
        setCountryPage(getDataPage().clickOnCountryListBox());
    }

    @When("the user clicks on the cancel button")
    public void clickOnCancelButton() {
        getDataPage().clickOnCancelButton();
    }

    @Then("the user should see the currency selection disabled in the currency page")
    @Alias("the user should see the country selection disabled in the country page")
    public void verifyCurrencySelectionDisabled() {
        getDataPage().verifyCurrencySelectionDisabled();
    }

    @When("the user enters the area <area> in the type-ahead box")
    public void enterAreaInTypeAhead(@Named("area") String area) {
        getDataPage().enterAreaInTypeAhead(area);
    }

    @When("the user enters an another area $anotherArea in the type-ahead box")
    public void entersArea(@Named("anotherArea") String anotherArea) {
        getDataPage().enterAreaInTypeAhead(anotherArea);
    }

    @When("the user enters an another city $anotherCity in the type-ahead box")
    public void entersCity(@Named("anotherCity") String anotherCity) {
        getDataPage().enterCityInTheTypeAheadBox(anotherCity);
    }

    @Then("the user should see the basic info for the selected country")
    public void verifyCountryBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the basic info for selected area")
    @Aliases(values = {"the user should see the basic info for selected city",
            "the user should see the basic info for selected sub-area"})
    public void verifyAreaBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the list of country's names type and value as: $countryNames")
    public void verifyCountryNames(ExamplesTable countryNames) {
        getDataPage().verifyNames(countryNames);
    }

    @Then("the user should see the area's names as: $names")
    @Aliases(values = {"the user should see the legal entity's names as: $names",
            "the user should see the sub-area's names as: $names"})
    public void verifyAreaNames(ExamplesTable names) {
        getDataPage().verifyNames(names);
    }

    @Then("the user should see the office's names as: $Names")
    public void verifyOfficeNames(ExamplesTable Names) {
        getDataPage().verifyNames(Names);
    }

    @Then("the user should see the office sort key as $officeSortKey")
    public void verifyOfficeSortKey(@Named("officeSortKey") String officeSortKey) {
        getDataPage().verifyOfficeSortKey(officeSortKey);
    }

    @Then("the user should see the office types: $Types")
    public void verifyOfficeTypes(ExamplesTable Types) {
        getDataPage().verifyTypes(Types);
    }

    @When("the user clicks on the legalEntity basic info link in the navigation bar")
    public void clickOnLegalEntityBasicInfo() {
        getDataPage().clickOnLegalEntityBasicInfo();
    }

    @Then("the user should see the city's names as: $cityNames")
    public void verifyCityNames(ExamplesTable cityNames) {
        getDataPage().verifyNames(cityNames);
    }


    @Then("the user should see the country's identifiers as: $countryIdentifiers")
    public void verifyCountryIdentifiers(ExamplesTable countryIdentifiers) {
        getDataPage().verifyIdentifiers(countryIdentifiers);
    }

    @Then("the user should see the area's identifiers as: $areaIdentifiers")
    @Alias("the user should see the sub-area's identifiers as: $areaIdentifiers")
    public void verifyAreaIdentifiers(ExamplesTable areaIdentifiers) {
        getDataPage().verifyIdentifiers(areaIdentifiers);
    }

    @Then("the user should see the city's identifiers as: $cityIdentifiers")
    public void verifyCityIdentifiers(ExamplesTable cityIdentifiers) {
        getDataPage().verifyIdentifiers(cityIdentifiers);
    }

    @Then("the user should see the area's time zones summary as $areaTimeZonesSummary")
    @Alias("the user should see the sub-area's time zones summary as $areaTimeZonesSummary")
    public void verifyAreaTimeZonesSummary(@Named("areaTimeZonesSummary") String areaTimeZonesSummary) {
        getDataPage().verifyAreaTimeZonesSummary(areaTimeZonesSummary);
    }

    @Then("the user should see the area's replace by as $areaReplacedBy")
    @Alias("the user should see the sub-area's replace by as $areaReplacedBy")
    public void verifyAreaReplaceByLabelValues(@Named("areaReplacedBy") String areaReplacedBy) {
        getDataPage().verifyReplaceByLabelValues(areaReplacedBy);
    }

    @Then("the user should not see the area's area link")
    public void verifyAreaLinkInBasicInfo() {
        getDataPage().verifyAreaLinkInBasicInfo();
    }

    @Then("the user should not see the city's area link")
    public void verifyAreaLinkForCityInBasicInfo() {
        getDataPage().verifyAreaLinkForCityInBasicInfo();
    }

    @Then("the user should not see the city's Subarea link")
    public void verifySubAreaLinkForCityInBasicInfo() {
        getDataPage().verifySubAreaLinkForCityInBasicInfo();
    }

    @Then("the user should see the area's time zones as: $areaTimeZones")
    @Alias("the user should see the sub-area's time zones as: $areaTimeZones")
    public void verifyAreaTimeZones(ExamplesTable areaTimeZones) {
        getDataPage().verifyAreaTimeZones(areaTimeZones);
    }

    @Then("the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>")
    public void verifyLegalEntityHeader(@Named("entity") String entity,
                                        @Named("headOfficeAddress") String headOfficeAddress,
                                        @Named("fid") String fid,
                                        @Named("tfpid") String tfpid) {
        getDataPage().verifyHeader(entity, headOfficeAddress, fid, tfpid);
    }

    @Then("the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>")
    public void verifyOfficeHeader(@Named("entity") String entity,
                                   @Named("headOfficeAddress") String headOfficeAddress,
                                   @Named("officeFid") String fid,
                                   @Named("officeTfpid") String tfpid) {
        getDataPage().verifyHeader(entity, headOfficeAddress, fid, tfpid);
    }

    @Then("the user should see the $label of a city as $value")
    @Aliases(values = {"the user should see the $label of an office as $value",
            "the user should see the $label of an area as $value",
            "the user should see the $label of an sub-area as $value"})
    public void verifyBasicInfo(@Named("label") String label, @Named("value") String value) {
        getDataPage().verifyBasicInfo(label, value);
    }

    @Then("the user should see the country status not editable")
    public void verifyStatusNotEditable() {
        getDataPage().verifyStatusNotEditable();
    }

    @Then("the user should see the country's alternative regions as: $countryRegions")
    public void verifyCountryRegions(ExamplesTable countryRegions) {
        getDataPage().verifyRegions(countryRegions);
    }

    @Then("the user should not see the country regions section")
    public void verifyNoCountryRegionsSection() {
        getDataPage().verifyNoCountryRegionsSection();
    }

    @Then("the user should not see the country's places")
    public void verifyNoCountryPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should not see the area's places")
    @Alias("the user should not see the sub-area's places")
    public void verifyNoAreaPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should not see the city's related places")
    public void verifyNoCityPlaces() {
        getDataPage().verifyNoPlaces();
    }

    @Then("the user should see the country's entities as: $countryEntities")
    public void verifyCountryEntities(ExamplesTable countryEntities) {
        getDataPage().verifyEntities(countryEntities);
    }

    @Then("the user should see the country's people as: $countryPeople")
    public void verifyCountryPeople(ExamplesTable countryPeople) {
        getDataPage().verifyPeople(countryPeople);
    }

    @Then("the user should not see the country's entities")
    public void verifyNoCountryEntities() {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should not see the city's entity")
    public void verifyNoCityEntities() {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should not see the country's people")
    public void verifyNoCountryPeople() {
        getDataPage().verifyNoPeople();
    }

    @Then("the user should see the default country page and display all info")
    public void verifyCountryDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @When("the user refreshes the page")
    public void refreshThePage() {
        getDataPage().refreshThePage();
    }

    @When("the user clicks on the choose an area option")
    public void clickOnAreaDropdown() {
        getDataPage().clickOnAreaDropdown();
    }

    @Then("the user should see the below subareas for the selected country and area: $subarea")
    public void verifySubareaForSelectedArea(ExamplesTable subarea) {
        getDataPage().verifySubareaForSelectedArea(subarea);}

    @Then("the user should see the area dropdown disabled")
    public void verifyAreaDropdownDisabled() {
        getDataPage().verifyAreaDropdownDisabled();
    }

    @Then("the user should see the subarea dropdown disabled")
    public void verifySubareaDropdownDisabled() {
        getDataPage().verifySubareaDropdownDisabled();
    }

    @When("the user clicks on the area basic info link in the navigation bar")
    @Alias("the user clicks on the sub-area basic info link in the navigation bar")
    public void clickOnAreaBasicInfoInNavigationBar() {
        getDataPage().clickOnAreaBasicInfoInNavigationBar();
    }

    @When("the user clicks on the city basic info link in the navigation bar")
    public void clickOnCityBasicInfoInNavigationBar() {
        getDataPage().clickOnCityBasicInfoInNavigationBar();
    }

    @When("the user clicks on the area's places link in the navigation bar")
    @Alias("the user clicks on the sub-area's places link in the navigation bar")
    public void clickOnAreaRelatedPlaces() {
        getDataPage().clickOnAreaRelatedPlaces();
    }

    @Then("the user should see the area related places from trusted document")
    @Alias("the user should see the sub-area's related places from trusted document")
    public void verifyAreaRelatedPlacesFromTrusted() {
        getDataPage().verifyAreaRelatedPlacesFromTrusted();
    }

    @Then("the user should see the city related places from trusted document")
    public void verifyCityRelatedPlacesFromTrusted() {
        getDataPage().verifyCityRelatedPlacesFromTrusted();
    }

    @When("the user clicks on the city's places link in the navigation bar")
    public void clickOnCityRelatedPlaces() {
        getDataPage().clickOnCityRelatedPlaces();
    }


    @When("the user clicks on the city tab in the data area")
    public void userClicksOnCityTab() {
        getDataPage().clickOnCityTab();
    }

    @When("the user clicks on the choose a city option")
    public void clickOnCityDropdown() {
        getDataPage().clickOnCityDropdown();
    }

    @Then("the user should see the below cities for the selected area: $cities")
    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        getDataPage().verifyCitiesForSelectedArea(cities);
    }

    @Then("the user should not see any cities for the selected area")
    public void verifyNoCitiesForSelectedArea() {
        getDataPage().verifyNoCitiesForSelectedArea();
    }

    @When("the user clicks on the area's people link in the navigation bar")
    @Alias("the user clicks on the sub-area's people link in the navigation bar")
    public void clickOnAreaRelatedPeople() {
        getDataPage().clickOnAreaRelatedPeople();
    }

    @When("the user clicks on the area's demographics link in the navigation bar")
    public void clickOnAreaDemographics() {
        getDataPage().clickOnDemographics();
    }

    @When("the user clicks on the sub-area's demographics link in the navigation bar")
    public void clickOnSubAreaDemographics() {
        getDataPage().clickOnDemographics();
    }

    @Then("the user should see the area's demographics as: $areaDemographics")
    public void verifyAreaDemographics(ExamplesTable areaDemographics) {
        getDataPage().verifyDemographics(areaDemographics);
    }

    @Then("the user should see the legal entity's statistics as: $statistics")
    @Aliases(values = {"the user should see the office's statistics as: $statistics"})
    public void verifyStatistics(ExamplesTable statistics) {
        getDataPage().verifyStatistics(statistics);
    }

    @Then("the user should see the statistics for the legal entity")
    public void verifyLegalEntityStatisticsLabels() {
        getDataPage().verifyStatisticsLabels();
    }

    @Then("the user should see the sub-area's demographics as: $subAreaDemographics")
    public void verifySubAreaDemographics(ExamplesTable subAreaDemographics) {
        getDataPage().verifyDemographics(subAreaDemographics);
    }

    @Then("the user should not see the area's demographics")
    public void verifyNoAresDemographics() {
        getDataPage().verifyNoDemographics();
    }

    @Then("the user should not see the sub-area's demographics")
    public void verifyNoSubAreaDemographics() {
        getDataPage().verifyNoDemographics();
    }

    @Then("the user should see the area's people as: $areaPeople")
    @Alias("the user should see the sub-area's people as: $areaPeople")
    public void verifyAreaPeople(ExamplesTable areaPeople) {
        getDataPage().verifyPeople(areaPeople);
    }

    @Then("the user should not see the area's people")
    @Alias("the user should not see the sub-area's people")
    public void verifyNoAreaPeople() {
        getDataPage().verifyNoPeople();
    }

    @When("the user clicks on the area's credit rating link in the navigation bar")
    public void clickOnAreasCreditRatings() {
        getDataPage().clickOnAreasCreditRatings();
    }

    @When("the user clicks on the choose a sub-area option")
    public void clickOnSubAreaDropDown() {
        getDataPage().clickOnSubAreaDropDown();
    }

    @When("the user enters the sub-area <subArea> in the type-ahead box")
    @Alias("the user enters the sub-area $subArea in the type-ahead box")
    public void enterSubAreaInTypeAhead(@Named("subArea") String subArea) {
        getDataPage().enterSubAreaInTypeAhead(subArea);
    }

    @When("the user clicks on the sub-area's credit rating link in the navigation bar")
    public void clickOnSubAreasCreditRatings() {
        getDataPage().clickOnAreasCreditRatings();
    }

    @When("the user clicks on the area's alternative regions link in the navigation bar")
    public void clickOnAreasAlternativeRegions() {
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the area's alternative regions as: $areaRegions")
    public void verifyAreaRegions(ExamplesTable areaRegions) {
        getDataPage().verifyRegions(areaRegions);
    }

    @When("the user clicks on the sub-area's alternative regions link in the navigation bar")
    public void clickOnSubAreasAlternativeRegions() {
        getDataPage().clickOnAreasAlternativeRegions();
    }

    @Then("the user should see the sub-area's alternative regions as: $subAreaRegions")
    public void verifySubAreaRegions(ExamplesTable subAreaRegions) {
        getDataPage().verifyRegions(subAreaRegions);
    }

    @Then("the user should not see the area's alternative regions")
    public void verifyNoAreaAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should not see the sub-area's alternative regions")
    public void verifyNoSubAreaAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should see the default area page and display all info")
    public void verifyAreaDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the default sub-area page and display all info")
    public void verifySubAreaDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the credit ratings for selected sub-area")
    @Alias("the user should see the credit rating for selected city")
    public void verifyCreditRatingsLabel() {
        getDataPage().verifyCreditRatingsLabelsGeo();
    }

    @Then("the user should see the credit ratings for selected area")
    public void verifyCreditRatingsForArea() {
        getDataPage().verifyCreditRatingsLabelsGeo();
    }

    @Then("the user should see the demographics for selected area")
    public void verifyDemographicsForArea() {
        getDataPage().verifyDemographicsLabel();
    }

    @Then("the user should see the demographics for selected sub-area")
    public void verifyDemographicsForSubArea() {
        getDataPage().verifyDemographicsLabel();
    }

    @Then("the user should see the places for selected sub-area")
    @Alias("the user should see the places for selected city")
    public void verifyPlacesForSubArea() {
        getDataPage().verifyPlacesLabel();
    }

    @Then("the user should see the places for selected area")
    public void verifyPlacesForArea() {
        getDataPage().verifyPlacesLabel();
    }

    @Then("the user should see the people for selected area")
    public void verifyPeopleForArea() {
        getDataPage().verifyPeopleLabel();
    }

    @Then("the user should see the people for selected sub-area")
    @Alias("the user should see the people for selected city")
    public void verifyPeopleForSubArea() {
        getDataPage().verifyPeopleLabel();
    }

    @Then("the user should see the entities for selected city")
    public void verifyEntitiesForCity() {
        getDataPage().verifyEntitiesLabel();
    }

    @Then("the user should see the regions for selected city")
    public void verifyRegionsForCity() {
        getDataPage().verifyRegionsLabel();
    }

    @When("the user clicks on the city's credit rating link in the navigation bar")
    public void clickOnCityCreditRatings() {
        getDataPage().clickOnCityCreditRatings();
    }


    @When("the user clicks on the city's entity link in the navigation bar")
    public void clickOnCityEntity() {
        getDataPage().clickOnCityEntity();
    }

    @Then("the user should see the legal entity's credit ratings as: $creditRatings")
    @Aliases(values = {"the user should see the office's credit ratings as: $creditRatings"})
    public void verifyCreditRatings(ExamplesTable creditRatings) {
        getDataPage().verifyCreditRatings(creditRatings);
    }

    @Then("the user should see the city's credit ratings as: $creditRatings")
    @Aliases(values = {"the user should see the area's credit ratings as: $creditRatings",
            "the user should see the country's credit ratings as: $creditRatings",
            "the user should see the sub-area's credit ratings as: $creditRatings"})
    public void verifyCreditRatingsGeo(ExamplesTable creditRatings) {
        getDataPage().verifyCreditRatingsGeo(creditRatings);
    }

    @Then("the user should see all is selected by default in the navigation bar")
    public void verifyDefaultToViewAll() {
        getDataPage().verifyDefaultToViewAll();
    }

    @Then("the user should see the city's entity as: $cityEntities")
    public void verifyCityEntities(ExamplesTable cityEntities) {
        getDataPage().verifyEntities(cityEntities);
    }


    @Then("the user should not see the legal entity's credit ratings")
    @Aliases(values = {"the user should not see the office's credit ratings"})
    public void verifyNoCreditRatings() {
        getDataPage().verifyNoCreditRatings();
    }

    @Then("the user should not see the city's credit ratings")
    @Aliases(values = {"the user should not see the country's credit ratings",
            "the user should not see the area's credit ratings",
            "the user should not see the sub-area's credit ratings"})
    public void verifyNoCreditRatingsGeo() {
        getDataPage().verifyNoCreditRatingsGeo();
    }

    @When("the user enters the city <city> in the type-ahead box")
    public void enterCityInTheTypeAheadBox(@Named("city") String city) {
        getDataPage().enterCityInTheTypeAheadBox(city);
        setEditCityPage(getDataPage().createEditCityPage());
        
    }

    @When("the user clicks on the city all link in the navigation bar")
    public void clicksOnCiltyAllLink() {
        getDataPage().clicksOnAllLink();
    }

    @Then("the user should see the default city page and display basic info")
    public void verifyDefaultBasicInfo() {
        getDataPage().verifyDefaultBasicInfo();
    }

    @When("the user clicks on the city regions link in the navigation bar")
    public void clickOnCityAlternativeRegions() {
        getDataPage().clickOnCityRegionsInNavigationBar();
    }

    @Then("the user should see the city's alternative regions as: $citryRegions")
    public void verifyCityRegions(ExamplesTable citryRegions) {
        getDataPage().verifyRegions(citryRegions);
    }

    @When("the user clicks on the city's people link in the navigation bar")
    public void clickOnCityRelatedPeople() {
        getDataPage().clickOnCityRelatedPeople();
    }

    @Then("the user should see the city's people as: $cityPeople")
    public void verifyCityPeople(ExamplesTable cityPeople) {
        getDataPage().verifyPeople(cityPeople);
    }

    @Then("the user should not see the city's people")
    public void verifyNoCityPeople() {
        getDataPage().verifyNoPeople();
    }

    @Then("the user should not see the city's alternative regions")
    public void verifyNoCityAlternativeRegions() {
        getDataPage().verifyNoAlternativeRegions();
    }

    @Then("the user should not see the city's alternative regions section")
    public void verifyNoCityAlternativeRegionsSection() {
        getDataPage().verifyNoCityAlternativeRegionsSection();
    }

    @When("the user clicks on the area's entity link in the navigation bar")
    public void clickOnAreaEntity() {
        getDataPage().clickOnAreaEntity();
    }

    @Then("the user should see the area's entities as: $areaEntities")
    public void verifyAreaEntities(ExamplesTable areaEntities) {
        getDataPage().verifyEntities(areaEntities);
    }

    @When("the user clicks on the sub-area's entity link in the navigation bar")
    public void clickOnSubAreaEntity() {
        getDataPage().clickOnAreaEntity();
    }

    @Then("the user should see the sub-area's entities as: $areaEntities")
    public void verifySubAreaEntities(ExamplesTable areaEntities) {
        getDataPage().verifyEntities(areaEntities);
    }

    @Then("the user should not see the area's entities")
    public void verifyNoAreaEntities() {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should not see the sub-area's entities")
    public void verifyNoSubAreaEntities() {
        getDataPage().verifyNoEntities();
    }

    @Then("the user should see the legal entity's personnel as: $personnel")
    @Alias("the user should see the office's personnel as: $personnel")
    public void verifyPersonnel(ExamplesTable personnel) {
        getDataPage().verifyPersonnel(personnel);
    }

    @Then("the user should not see the legal entity's personnel")
    @Alias("the user should not see the office's personnel")
    public void verifyNoPersonnel() {
        getDataPage().verifyNoPersonnel();
    }

    @Then("the user should see the personnel for the legal entity")
    @Alias("the user should see the personnel for the office")
    public void verifyPersonnelLabels() {
        getDataPage().verifyPersonnelLabels();
    }

    @Then("the user should see the legal entity's history as: $history")
    @Alias("the user should see the office's history as: $history")
    public void verifyHistory(ExamplesTable history) {
        getDataPage().verifyHistory(history);
    }

    @Then("the user should see the history for the legal entity")
    @Alias("the user should see the history for the office")
    public void verifyHistoryLabel() {
        getDataPage().verifyHistoryLabel();
    }

    @Then("the user should not see the legal entity's history")
    @Alias("the user should not see the office's history")
    public void verifyNoHistory() {
        getDataPage().verifyNoHistory();
    }

    @Then("the user should see the default legal entity page and display basic info")
    @Alias("the user should see the default office page and display basic info")
    public void verifyDefaultSection() {
        getDataPage().verifyBasicInfo();
    }

    @When("the user clicks on the legal entity all link in the navigation bar")
    @Alias("the user clicks on the office all link in the navigation bar")
    public void clickOnAllLink() {
        getDataPage().clicksOnAllLink();
    }

    @Then("the user should see the basic info label for selected legal entity")
    @Alias("the user should see the basic info for selected office")
    public void verifyBasicInfo() {
        getDataPage().verifyBasicInfo();
    }

    @Then("the user should see the legal entity's identifiers as: $identifiers")
    @Alias("the user should see the office's identifiers as: $identifiers")
    public void verifyLegalEntityOfficeIdentifiers(ExamplesTable identifiers) {
        getDataPage().verifyLegalEntityOfficeIdentifiers(identifiers);
    }

    @Then("the user should not see the legal entity's identifiers")
    @Alias("the user should not see the office's identifiers")
    public void verifyNoLegalEntityOfficeIdentifiers() {
        getDataPage().verifyNoLegalEntityOfficeIdentifiers();
    }

    @Then("the user should see the identifiers for the legal entity")
    @Alias("the user should see the identifiers for the office")
    public void verifyLegalEntityOfficeIdentifiersLabels() {
        getDataPage().verifyLegalEntityOfficeIdentifiersLabels();
    }

    @When("the user clicks on the area parent <areaParent> link for the selected area")
    public void clickOnAreaParentLink(@Named("areaParent") String areaParent) {
        getDataPage().clickOnAreaParentLink(areaParent);
    }

    @When("the user clicks on the area's city <areaCity> link in the area view")
    @Alias("the user clicks on the sub-area's city <areaCity> link in the sub area view")
    public void clickOnAreaCityLink(@Named("areaCity") String areaCity) {
        getDataPage().clickOnAreaCityLink(areaCity);
    }

    @When("the user clicks on the view head office <viewHeadOffice> link for the selected legal entity")
    public void clickOnViewHeadOfficeLink(@Named("viewHeadOffice") String viewHeadOffice) {
        getDataPage().clickOnViewHeadOfficeLink(viewHeadOffice);
    }

    @Then("the user should not see the legalEntity's headOffice link")
    public void verifyHeadOfficeInLegalEntityBasicInfo() {
        getDataPage().verifyHeadOfficeInLegalEntityBasicInfo();
    }

    @When("the user clicks on the currency iso link <isoCode>")
    public void clickOnISOLink(@Named("isoCode") String isoCode) {
        setCurrencyPage(getDataPage().clickOnISOLink(isoCode));
    }

    @When("the user clicks on the city area link $area")
    public void clickOnCityArea(@Named("area") String area) {
        getDataPage().clickOnCityArea(area);
    }

    @Then("the user should see the area page with $countryDropDown, $areaDropDown and $subAreaDropDown selected")
    public void verifyClickedAreaPage(@Named("countryDropDown") String countryDropDown, @Named("areaDropDown") String areaDropDown, @Named("subAreaDropDown") String subAreaDropDown) {
        getDataPage().verifyClickedAreaPage(countryDropDown, areaDropDown, subAreaDropDown);
    }

    @When("the user clicks on the city subarea link $subArea")
    public void clickOnCitySubArea(@Named("subArea") String subArea) {
        getDataPage().clickOnCitySubArea(subArea);
    }

    @When("the user clicks on the city country link $country")
    public void clickOnCityCountry(@Named("country") String country) {
        getDataPage().clickOnCityCountry(country);
    }

    @When("the user clicks on the city related place link $relatedPlace")
    public void clickOnCityRelatedPlace(@Named("relatedPlace") String relatedPlace) {
        getDataPage().clickOnCityRelatedPlace(relatedPlace);
    }

    @Then("the user should see the below country sections $countrySections")
    public void verifyCountrySections(ExamplesTable countrySections) {
        getDataPage().verifySections(countrySections);
    }

    @Then("the user should see the below area sections $areaSections")
    public void verifyAreaSections(ExamplesTable areaSections) {
        getDataPage().verifySections(areaSections);
    }

    @Then("the user should see the below city sections $citySections")
    public void verifyCitySections(ExamplesTable citySections) {
        getDataPage().verifySections(citySections);
    }

    @Then("the user should see the below legal entity sections $legalEntitySections")
    public void verifyLegalEntitySections(ExamplesTable legalEntitySections) {
        getDataPage().verifySections(legalEntitySections);
    }

    @Then("the user should see the below office sections $legalEntitySections")
    public void verifyOfficeSections(ExamplesTable officeSections) {
        getDataPage().verifySections(officeSections);
    }

    @Then("the user should see the below fields in the country basic info left section $basicInfoLeftSection")
    public void verifyBasicInfoLeftSection(ExamplesTable basicInfoLeftSection) {
        getDataPage().verifyBasicInfoLeftSection(basicInfoLeftSection);
    }

    @Then("the user should see the error $startDateErrorMsg for start date")
    public void verifyStartDateErrorMessage(@Named("startDateErrorMsg") String startDateErrorMsg) {
        getDataPage().verifyStartDateErrorMessage(startDateErrorMsg);
    }

    @Then("the user should see the error message enter a day/month/year for startDate in country basic info page")
    public void verifyStartDateErrorMessageForDayMonthYear() {
        getDataPage().verifyStartDateErrorMessageForDayMonthYear();
    }

    @Then("the user should see the error message enter a day/month/year for endDate in country basic info page")
    public void verifyEndDateErrorMessageForDayMonthYear() {
        getDataPage().verifyEndDateErrorMessageForDayMonthYear();
    }

    @Then("the user should see the error $startDateErrorMsg for end date")
    public void verifyEndDateErrorMessage(@Named("endDateErrorMsg") String endDateErrorMsg) {
        getDataPage().verifyEndDateErrorMessage(endDateErrorMsg);
    }

    @Then("the user should not see the cancel update confirmation modal")
    public void verifyNoCountryCancelUpdateConfirmationModal(){
        getDataPage().verifyNoCancelUpdateConfirmationModal();
    }

    @When("the user get the document with $xqueryName with the name as $name from the database")
    public void getDocument(String xqueryName, String name) {
        getDataPage().getDocument(xqueryName, name);
    }


    @Then("the user should see the list of all existing area for the selected country by full name")
    public void verifyAreaList() {
        getDataPage().verifyAreaList();
    }

    @Then("the user should see the list of all existing subarea for the selected area by full name")
    public void verifySubAreaList() {
        getDataPage().verifySubAreaList(database, apacheHttpClient);
    }

    @Then("the user should see the list of all existing city for the selected area by full name")
    public void verifyCityList() {
        getDataPage().verifyCityList();
    }

    @Then("the user should see the below states for the selected country: $areas")
    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        getDataPage().verifyAreaForSelectedCountry(areas);
    }

    @Then("the user should see the country page with $countryDropDown selected")
    public void verifyClickedCountryPage(@Named("countryDropDown") String countryDropDown) {
        getDataPage().verifyClickedCountryPage(countryDropDown);
    }

    @Then("the user should be redirected to view mode")
    public void verifyUserRedirectedToViewMode(){getDataPage().verifyUserRedirectedViewMode();}

    @Given("the user loads area test data for nightly runs in database <xqueryName>")
        public void clickloadTestData(@Name("xqueryName") String xqueryName){
            getDataPage().loadDocument(xqueryName);

        }
    @When("the user clicks on the area related place link $relatedPlace")
    public void clickOnAreaRelatedPlace(@Named("relatedPlace") String relatedPlace) {
        getDataPage().clickOnAreaRelatedPlace(relatedPlace);
    }

    @When("the user clicks on the Country link in the area basic info")
    public void clickOnCountryLink(){ getDataPage().clickOnCountryLink();}


    @When("the user updates the browser url to new $entity id <entityID>")
    public void changeBrowserUrlAndNavigate(@Named("entityID") String countryID){getDataPage().changeBrowserUrlAndNavigate(countryID);}

    @Then("the user should see the $entity page in the view mode")
    public void verifyViewModeForEntity(){getDataPage().verifyViewModeForEntity();}
    
    @When("the user clicks on the area update link")
    public void clickOnUpdateAreaLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        setEditAreaPage(getDataPage().createEditAreaPage());
    }
}
