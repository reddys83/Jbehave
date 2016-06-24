package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

import java.text.ParseException;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditCitySteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@When("the user enters the <value> in the population field")
	public void entervalueInPopulationField(@Named("value") String value) {
		getEditCityPage().entervalueInPopulationField(value);
	}

	@When("the user enters the <addInfoText> in the add info text area")
	public void enterTextInCityAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().enterTextCityAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the values are entered in the add info field")
	public void verifyTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyTextInAddInfo(addInfoText);
	}

	@Then("the user should be able to verify the maximum values are entered in the add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditCityPage().verifyMaximumChracterEnteredInAddInfo();
	}

	@When("the user clicks on the Status drop-down in the basicinfo city page")
	public void clickOnCityStatusDropDown() {
		getEditCityPage().clickOnCityStatusDropDown();
	}

	@Then("the user should be able to view the error message 'Enter up to 50 valid numbers'")
	public void verifyErrorMessageInCityPopulation() {
		getEditCityPage().verifyErrorMessageInCityPopulation();
	}

	@Then("the user should see maximum length of population is limited to $maxLength")
	public void verifyMaxLengthInCityPopulation(String maxLength) {
		getEditCityPage().verifyMaxLengthInCityPopulation(maxLength);
	}

	@Then("the user should see the population $value as in $source document")
	public void verifyCityPopulationValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("value") String population) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "population", source, population);
	}

	@Then("the user should see the city addinfo value $addInfoText as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "additionalinfo", source, addInfoText);
	}

	@Then("the user should see no summary changes in the city save confirmation modal")
	public void verifyNoSummaryInConfirmationModal(@Named("Summary") String summaryText) {
		getEditCityPage().verifyNoSummaryConfirmationModal(summaryText);

	}

	@Then("the user should be able to view that only 500 unicode characters are saved")
	public void viewValidCharacterLength() {
		getEditCityPage().viewValidCharacterLength();
	}

	@Then("the user should see the status values from City Status dropdown")
	public void verifyCityStatusList() {
		getEditCityPage().verifyCityStatusList();
	}

	@When("the user starts typing the name of a status as $word in the City Status drop-down")
	public void enterValueInStatusDropdown(String word) {
		getEditCityPage().enterValueInStatusDropdown(word);

	}

	@Then("the user should see the selected status in the City Status drop-down as $status")
	public void verifyCityStatusInDropdown(String status) {
		getEditCityPage().verifyCityStatusInDropdown(status);
	}

	@Then("the user should return to edit city page mode")
	public void verifyCityEditPageMode() {
		getEditCityPage().verifyCityEditPageMode();
	}

	@Then("the user should see the city status value same as in $source document")
	public void verifyCityStatusInfoFromTrustedDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityStatusInfoFromTrustedDB(country, area, city, "status", source);
	}

	@Then("the user should see the city $status value as in $source document")
	public void verifyCityStatusValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("status") String status) {
		getEditCityPage().verifyCityInfoFromZeusDB(country, area, city, "status", source, status);
	}

	@When("the user selects value as $status from Status drop-down in the city basicinfo page")
	public void selectCityStatusValue(@Named("status") String status) {
		getEditCityPage().selectCityStatusValue(status);
	}

	@When("the user clicks on the save button in city page")
	public void clickOnSaveButton() {
		getEditCityPage().clickOnSaveButton();
	}

	@When("the user gets the document with $xqueryName with the <city> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("city") String param) {
		getDataPage().getDocument(xqueryName, param);

	}

	@Then("the user should not see the <ConfirmationSummary> changes in confirmation modal")
	public void verifyNoChangeConfirmationMsg(@Named("ConfirmationSummary") String ConfirmationSummary) {
		getEditCityPage().verifyNoSummaryConfirmationModal(ConfirmationSummary);
	}

	@When("the user clicks on the add new identifier button in the basic info city page")
	public void clickOnAddNewIdentifierButton() {
		getEditCityPage().clickOnAddNewIdentifierButton();
	}

	@When("the user enters identifier type as <identifierType> in the basic info city page")
	public void enterIdentifierType(@Named("identifierType") String identifierType) {
		getEditCityPage().enterIdentifierType(identifierType);
	}

	@When("the user enters identifier type as <identifierType2> in the basic info city page")
	public void enterIdentifierType2(@Named("identifierType2") String identifierType) {
		getEditCityPage().enterIdentifierType_Row(identifierType, 2);
	}

	@When("the user enters identifier status as <identifierStatus> in the basic info city page")
	public void enterIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
		getEditCityPage().enterIdentifierStatus(identifierStatus);

	}

	@When("the user enters identifier status as <identifierStatus2> in the basic info city page")
	public void enterIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
		getEditCityPage().enterIdentifierStatus_Row(identifierStatus, 2);

	}

	@Then("the user should see the successful update message at top of the page")
	public void verifySuccessfulUpdatedMessage() {
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@When("the user clicks on the delete identifier row button in the basic info city page")
	public void clickOnDeleteNewIdentifierRowButtonCity() {
		getEditCityPage().clickOnDeleteNewIdentifierRowButtonCity();
	}

	@Then("the user should not see the newly added identifier row in the basic info city page")
	public void verifyNewlyAddedIdentifierRowIsNotDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedIdentifierRowIsNotDisplayed();
	}

	@Then("the user should see the newly added identifier row in the basic info city page")
	public void verifyNewlyAddedIdentifierRowIsDisplayed() throws Exception {
		getEditCityPage().verifyNewlyAddedIdentifierRowIsDisplayed();
	}

	@Then("the user should see delete row confirmation modal in the city page")
	public void verifyDeleteConfirmationModal() {
		getEditCityPage().verifyDeleteConfirmationModal();
	}

	@When("the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page")
	public void enterIdentifierValue(@Named("identifierValueIncorrect") String incorrectIdentifierValue) {
		getEditCityPage().enterIdentifierValue(incorrectIdentifierValue);
	}

	@When("the user enters identifier value as <identifierValue> in the basic info city page")
	public void enterIdentifierValues(@Named("identifierValue") String identifierValue) {
		getEditCityPage().enterIdentifierValue(identifierValue);
	}

	@When("the user enters identifier value as <identifierValue2> in the basic info city page")
	public void enterIdentifierValues2(@Named("identifierValue2") String identifierValue) {
		getEditCityPage().enterIdentifierValue_Row(identifierValue, 2);
	}

	@When("the user clicks on the confirm button in city page")
	public void clickOnConfirmButtonCity() throws Exception {
		getEditCityPage().clickOnConfirmButtonCity();
	}

	@Then("the user should see the error message for the required identifier value field in the city basic info page")
	public void verifyErrorMessageForRequiredCityIdentifierValue() {
		getEditCityPage().verifyErrorMessageForRequiredCityIdentifierValue();
	}

	@Then("the user should see the error message for the required identifier type field in the city basic info page")
	public void verifyErrorMessageForRequiredCityIdentifierType() {
		getEditCityPage().verifyErrorMessageForRequiredCityIdentifierType();
	}

	@Then("the user should see the error message for the required identifier status field in the city basic info page")
	public void verifyErrorMessageForRequiredCityIdentifierStatus() {
		getEditCityPage().verifyErrorMessageForRequiredCityIdentifierStatus();
	}

	@When("the user clicks on the No button to cancel the deletion of row")
	public void clickNoButtonInDeleteConfirmationModalForCity() {
		getEditCityPage().clickNoButtonInDeleteConfirmationModalForCity();
	}

	@When("the user clicks on the Yes button to cancel the deletion of row")
	public void clickYesButtonInDeleteConfirmationModalForCity() {
		getEditCityPage().clickYesButtonInDeleteConfirmationModalForCity();
	}

	@Then("the user should not see delete row confirmation modal in the city page")
	public void verifyDeleteConfirmationModalIsNotDisplayed() {
		getEditCityPage().verifyDeleteConfirmationModalIsNotDisplayed();
	}

	@Then("the user should see the identifier <value> as in zeus document $identifierType $identifierValue $identifierStatus and $identifierType2 $identifierValue2 $identifierStatus2")
	public void verifyCityIdentifierValuesFromTrusted(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {

		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };

		getEditCityPage().verifyCityIdentifierValuesFromTrusted(country, area, city, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@When("the user clicks on the city Identifier type drop-down")
	public void clickOnCityIdentifierType() {
		getEditCityPage().clickOnCityIdentifierType();
	}

	@When("the user clicks on the city Identifier status drop-down")
	public void clickOnCityIdentifierStatus() {
		getEditCityPage().clickOnCityIdentifierStatus();
	}

	@Then("the user should see the city identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO")
	public void verifyCityIdentifierTypesList() {
		getEditCityPage().verifyCityIdentifierTypesList_forOneRow();
	}

	@Then("the user should see the city identifier status from lookup STATUS")
	public void verifyCityIdentifierStatusList() {
		getEditCityPage().verifyCityIdentifierStatusList();
	}

	@When("the user deletes the existing identifier rows")
	public void deleteAllIdentifiers() {
		getEditCityPage().deleteAllIdentifierRows();
	}

	@When("the user enters values which is beyond 500 unicode characters in the add info field")
	public void enterInvalidCharactersInCityAddInfo() {
		getEditCityPage().enterInvalidCharactersInCityAddInfo();
	}

	@Then("the user should see the addInfoText value same as in $source document")
	public void verifyCityAddInfoValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddInfoValueFromTrusted(country, area, city, "additionalinfo", source);
	}
	
	@When("the user enters the day <beganDay> in the text box for Began Date")
	public void enterDayInBeganDate(@Named("beganDay") String beganDay) {
		getEditCityPage().enterDayInBeganDate(beganDay);
	}

	@When("the user enters the month <beganMonth> in the drop down box for Began Date")
	public void enterMonthInBeganDate(@Named("beganMonth") String month) {
		getEditCityPage().enterMonthInBeganDate(month);
	}

	@When("the user enters the year <beganYear> in the text box for Began Date")
	public void enterYearInBeganDate(@Named("beganYear") String year) {
		getEditCityPage().enterYearInBeganDate(year);
	}

	@When("the user enters the day <endDay> in the text box for End Date")
	public void enterDayInEndDate(@Named("endDay") String day) {
		getEditCityPage().enterDayInEndDate(day);
	}

	@When("the user enters the month <endMonth> in the drop down box for End Date")
	public void enterMonthInEndDate(@Named("endMonth") String month) {
		getEditCityPage().enterMonthInEndDate(month);
	}

	@When("the user enters the year <endYear> in the text box for End Date")
	public void enterYearInEndDate(@Named("endYear") String year) {
		getEditCityPage().enterYearInEndDate(year);
	}

	@Then("the user verifies whether all the months in the drop down option are present in chronological order")
	public void verifyMonthInChronologicalOrder() {
		getEditCityPage().verifyMonthInChronologicalOrder();
	}

	@Then("the user should see the <endDate> value as in $source document")
	public void verifyCityEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("endDate") String endDate) {
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "EndDate", source, endDate);
	}
	
	@Then("the user should see the $endDay2 $endMonth2 $endYear2 value as in $source document")
	public void verifyCityEndDate2ValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source, @Named("endDay2") String day2,
			@Named("endMonth2") String month2, @Named("endYear2") String year2) {
		String endDate = day2 +" " + month2 + " " + year2;
		getEditCityPage().verifyCityInfoFromDB(country, area, city, "EndDate", source, endDate);
	}

	@Then("the user verifies whether error message $errMsg is displayed for End Date")
	public void verifyErrorMessageForEndDate(@Named("errMsg") String errMsg) {
		getEditCityPage().verifyErrorMessageForEndDate(errMsg);
	}

	@When("the user enters $endDay2 $endMonth2 $endYear2 for End Date values")
	public void enterEndDate(@Named("endDay2") String endDay2, @Named("endMonth2") String endMonth2,@Named("endYear2") String endYear2) {
		getEditCityPage().enterEndDate(endDay2, endMonth2, endYear2);
	}

	@When("the user enters the future date in the text box for End Date")
	public void enterDateLaterThanToday() throws ParseException {
		getEditCityPage().enterDateLaterThanToday();
	}

	@When("the user clears the day, month and year values for Began Date")
	public void clearBeganDate() {
		getEditCityPage().clearBeganDate();
	}

	@Then("the user should see city end date value same as in $source document")
	public void verifyCityEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifyCityEndDateFromTrustedDB(country, area, city, "EndDate", source);

	}
	
	@Then("the user should see the began date value in city page is same as in $source document")
	public void verifyCityBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifyCityBeganDateFromTrustedDB(country, area, city, "BeginDate", source);
	}

	@When("the user enters began date day <day> in the edit basic info city page")
	public void enterDayBeganDate(@Named("day") String day) {
		getEditCityPage().enterDayBeganDate(day);
	}

	@When("the user enters began date year <year> in the edit basic info city page")
	public void enterYearBeganDate(@Named("year") String year) {
		getEditCityPage().enterYearBeganDate(year);
	}

	@When("the user enters began date month <month> in the edit basic info city page")
	public void selectMonthBeganDate(@Named("month") String month) {
		getEditCityPage().selectMonthBeganDate(month);
	}

	@Then("the user should see the error $beganDateErrorMsg for began date")
	public void verifyErrorMessageBeganDate(@Named("beganDateErrorMsg") String beganDateErrorMsg) {
		getEditCityPage().verifyErrorMessageBeganDate(beganDateErrorMsg);
	}

	@Then("the user should see the entered <day> <month> <year> in city page")
	public void verifyDayMonthYearInCityPage(@Named("day") String day, @Named("month") String month,
			@Named("year") String year) {
		getEditCityPage().verifyDayMonthYearInCityPage(day, month, year);
	}

	@Then("the user should see the city began date <day><month><year> value in $source document")
	public void verifyCityBeganDateValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("day") String day, @Named("month") String month,
			@Named("year") String year, @Named("source") String source) {
		getEditCityPage().verifyCityBeganDateFromZeusDB(country, area, city, "BeginDate", source, day, month, year);
	}
	
	@Then("the user verifies whether all the months in the drop down option are in MMM format & are sorted in the chronological order")
	public void verifyBeganDateMonthChronologicalOrder() {
		getEditCityPage().verifyMonthInChronologicalOrder();
	}
	
	@When("the user clicks on True option for Use in Address") 
	public void selectTrueForUseInAddress() {
		getEditCityPage().selectTrueForUseInAddress();
	}
	
	@When("the user clicks on False option for Use in Address") 
	public void selectFalseForUseInAddress() {
		getEditCityPage().selectFalseForUseInAddress();
	}
	
	@Then("the user should see the address flag value same as in $source document")
	public void verifyCityAddressFlagFromDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city, @Named("source") String source) {
		getEditCityPage().verifyCityAddressFlagFromZeusDB(country, area, city, "addressFlag", source);

	}
	
	@Then("the user should see maximum length of identifier value is limited to $maxLength")
	public void verifyMaxLengthInCityIdentifierValue(@Named("maxLength") String maxLength) {
		getEditCityPage().verifyMaxLengthInCityIdentifierValue(maxLength);
	}
	
	@When("the user clicks on the add button for adding new places for city page")
    public void clickOnAddPlacesButton() {
	 getEditCityPage().clickOnAddPlacesButton();
  }
 
	 
 @Then("the user should see the error message required for type in places for city")
    public void verifyRequiredErrorMessageForType()
    {
	 getEditCityPage().verifyRequiredErrorMessageForType();
    }
 
 @Then("the user should see the error message required for place in places for city")
    public void verifyRequiredErrorMessageForPlace()
    {
	 getEditCityPage().verifyRequiredErrorMessageForPlace();
    }
 
 @When("the user clicks on the city places link in the navigation bar")
    public void clickOnCitylaces() {
	 getEditCityPage().clickOnCityPlaces();
    }
 
  @When("the user clicks on new city places type drop-down for city")
    public void clickCityPlaceType() {
	  getEditCityPage().clickCityPlaceType();
    }
  
  @When("the user selects type value as <PlaceType> in the places for city")
    public void selectsTypeFromDropdown(@Named("PlaceType") String PlaceType) {
	  getEditCityPage().selectsPlacesTypeFromDropdwon(PlaceType);
    }
  
  @When("the user clicks on edit button in places for city")
    public void clicksOnEditButton() {
	  getEditCityPage().clicksOnEditButton();
    }
  
  @When("the user clicks on the country drop down in the places for city")
    public void clicksOnCountryInPlacesForCity() {
	  getEditCityPage().clicksOnCountryInPlacesForCity();
    }
  
  @When("the user selects the country <countryPlaces> in the places for city")
    public void selectsCountryInPlacesForCity(@Named("countryPlaces") String countryPlaces) {
	  getEditCityPage().selectsCountryInPlacesForCity(countryPlaces);
    }
  
  @When("the user clicks on area drop down in the places for city")
    public void clicksOnAreaDropdownInPlacesForCity() {
	  getEditCityPage().clicksOnAreaDropdownInPlacesForCity();
    }
  
  @When("the user selects area <areaPlaces> dropdown in places for city")
    public void selectsAreaInPlacesForCity(@Named("areaPlaces") String areaPlaces) {
	  getEditCityPage().selectsAreaInPlacesForCity(areaPlaces);
    }
  
  @When("the user clicks on city drop down in the places for city")
    public void clicksOnCityDropdownInPlacesForCity() {
	  getEditCityPage().clicksOnCityDropdownInPlacesForCity();
    }
  
  @When("the user selects city <cityPlaces> dropdown in the places for city")
    public void selectsCityInPlacesForCountry(@Named("cityPlaces") String cityPlaces) {
	  getEditCityPage().selectsCityInPlacesForCountry(cityPlaces);
    }
  
  @When("the user clicks on go button in places for city")
     public void clicksOnGoButton() {
	  getEditCityPage().clicksOnGoButton();
    }
  
  @When("the user selects details value as <PlaceDetails> in the places for city")
    public void selectsDetailsFromDropdown(@Named("PlaceDetails") String PlaceDetails) {
	  getEditCityPage().selectsPlacesDetailsFromDropdown(PlaceDetails);
    }
  
  @Then("the user should see place as $place in places for city")
    public void verifyPlaceInPlacesForCity(@Named("place") String place) {
	  getEditCityPage().verifyPlaceInPlacesForCity(place);
    }
  

    @When("the user clicks on delete city places type")
    public void clicksOnDeleteCityPlacesType() {
    	getEditCityPage().clicksOnDeleteCityPlacesType();
    }
    
    @Then("the user should see that drawer is closed")
    public void verifyDrawerClosed() {
    	getEditCityPage().verifyDrawerClosed();
    }
    
   @Then("the user should see 'Go' button disabled until value for $value is selected")
    public void verifyGoButtonDisabled() {
    	getEditCityPage().verifyGoButtonDisabled();
    }
    
    @Then("the user should see Edit button for place field is disabled")
    public void verifyEditButtonDisabled() {
    	getEditCityPage().verifyEditButtonDisabled();
    }
    
    @Then("the user should see the delete option is  disabled until drawer closes")
    public void verifyDeleteButtonDisabled() {
    	getEditCityPage().verifyDeleteButtonDisabled();
    }
    
    @When("the user clicks on new city places details drop-down for city")
    public void clickDetailsDropDown() {
	  getEditCityPage().clickDetailsDropDown();
    }
    
    @Then("the user should see the values for type dropdown from lookup CITY_RELATED_PLACE_TYPE")
    public void verifyCityPlacesTypeList() {
    	getEditCityPage().verifyCityPlacesTypeList();
    }
    
    @Then("the user should see the values for details dropdown from lookup CITY_RELATED_PLACE_SUBTYPE")
    public void verifyCityPlacesDetailsList() {
    	getEditCityPage().verifyCityPlacesDetailsList();
    }
    
    @Then("the user should see the list of all existing countries by full name in places for city")
    public void verifyCountryListInPlacesForCity() {
    	getEditCityPage().verifyCountryListInPlacesForCity();
    }
    
    @Then("the user should see the list of all existing area for the selected country by full name in places for city")
    public void verifyAreaListInPlacesForCity(@Named("countryPlaces") String country) {
    	getEditCityPage().verifyAreaListInPlacesForCity(country);
    }
    
    @Then("the user should see the list of all existing city for the selected area by full name in places for city")
    public void verifyCityListInPlacesForCity() {
    	getEditCityPage().verifyCityListInPlacesForCity();
    }
    
    @Then("the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place")
    public void verifyRelatedPlacesInCityPage(@Named("PlaceType") String cityPlacesType,@Named("cityPlaces") String cityPlacesPlace,@Named("PlaceDetails") String cityPlacesDetails) {
    	getEditCityPage().verifyRelatedPlacesInCityPage(cityPlacesType,cityPlacesPlace,cityPlacesDetails);
    }
    
    @Then("the user should see the city related place date <PlaceType> <cityPlaces> <PlaceDetails> value in $source document")
	public void verifyCityRelatedValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city,@Named("PlaceType") String type, @Named("cityPlaces") String place,
			@Named("PlaceDetails") String details, @Named("source") String source) {
		getEditCityPage().verifyCityRelatedValueFromZeusDB(country,area,city,type, place, details, source);
	}
    
    @When("the user deletes the existing related places rows")
	public void deleteAllRelatedPlaces() {
		getEditCityPage().deleteAllRelatedPlaces();
	}
    
    @Then("the user should not see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place")
	public void verifyDeletedRelatedPlaces(@Named("PlaceType") String type, @Named("cityPlaces") String place,
			@Named("PlaceDetails") String details) {
		getEditCityPage().verifyDeletedRelatedPlaces(type,place,details);
	}
    @Then("the user should not see the city related place value in $source document")
    public void verifyDeletedCityRelatedValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("city") String city,@Named("source") String source) {
		getEditCityPage().verifyDeletedCityRelatedValueFromZeusDB(country,area,city,source);
	}
    
    @Then("the user should see that Edit button for place field is enabled")
    public void verifyEditButtonEnabled() {
    	getEditCityPage().verifyEditButtonEnabled();
    }
    
    @Then("the user should see the default value for country is Choose a country")
    public void verifyDefaultValueCountry() {
    	getEditCityPage().verifyDefaultValueCountry();
    }
  
    @Then("the user should see the area dropdown is disabled")
    public void verifyAreaDisabled() {
    	getEditCityPage().verifyAreaDisabled();
    }
    
    @Then("the user should see the city dropdown is disabled")
    public void verifyCityDisabled() {
    	getEditCityPage().verifyCityDisabled();
    }
    
    @Then("the user should see Choose a country option is not selectable")
    public void verifyDefaultCountryOptionNotSelectable() {
    	getEditCityPage().verifyDefaultCountryOptionNotSelectable();
    }
    
    @Then("the user should see the default value for area is Choose an area")
    public void verifyDefaultValueArea() {
    	getEditCityPage().verifyDefaultValueArea();
    }
    
    @Then("the user should see the default value for area is Choose a city")
    public void verifyDefaultValueCity() {
    	getEditCityPage().verifyDefaultValueCity();
    }
    
    @Then("the user should see Choose an area option is not selectable")
    public void verifyDefaultAreaOptionNotSelectable() {
    	getEditCityPage().verifyDefaultAreaOptionNotSelectable();
    }
    
    @Then("the user should see Choose a City option is not selectable")
    public void verifyDefaultCityOptionNotSelectable() {
    	getEditCityPage().verifyDefaultCityOptionNotSelectable();
    }
    
    @Then("the user should see Go button enabled")
    public void verifyGoButtonEnabled() {
    	getEditCityPage().verifyGoButtonEnabled();
    }

}