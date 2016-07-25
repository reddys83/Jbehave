package com.accuity.zeus.aft.jbehave.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;

@Component
public class EditAreaSteps extends AbstractSteps {

	@Autowired
	ApacheHttpClient apacheHttpClient;
	@Autowired
	Database database;

	@Then("the user should see area end date value same as in $source document")
	public void verifyAreaEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		setEditAreaPage(getDataPage().createEditAreaPage());
		getEditAreaPage().verifyAreaEndDateFromTrustedDB(country, area, "EndDate", source);

	}

	@Then("the user verifies whether all the months in the drop down option for End date are in MMM format & are sorted in the chronological order")
	public void verifyEndDateMonthChronologicalOrder() {
		getEditAreaPage().verifyMonthInChronologicalOrder();
	}


	@When("the user gets the document with $xqueryName with the <area> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("area") String param) {
		getDataPage().getDocument(xqueryName, param);
	}

	@When("the user enters began date day <day> in the edit basic info area page")
	public void enterDayInBeganDate(@Named("day") String day) {
		getEditAreaPage().enterDayInBeganDate(day);
	}

	@When("the user enters began date month <month> in the edit basic info area page")
	public void enterMonthInBeganDate(@Named("month") String month) {
		getEditAreaPage().enterMonthInBeganDate(month);
	}

	@When("the user enters began date year <year> in the edit basic info area page")
	public void enterYearInBeganDate(@Named("year") String year) {
		getEditAreaPage().enterYearInBeganDate(year);
	}

	@When("the user enters end date day <day> in the edit basic info area page")
	public void enterDayInEndDate(@Named("day") String day) {
		getEditAreaPage().enterDayInEndDate(day);
	}

	@When("the user enters end date month <month> in the edit basic info area page")
	public void enterMonthInEndDate(@Named("month") String month) {
		getEditAreaPage().enterMonthInEndDate(month);
	}

	@When("the user enters end date year <year> in the edit basic info area page")
	public void enterYearInEndDate(@Named("year") String year) {
		getEditAreaPage().enterYearInEndDate(year);
	}

	@Then("the user should see the error $endDateErrorMsg for area end date")
	public void verifyErrorMessageEndDate(@Named("endDateErrorMsg") String endDateErrorMsg) {
		getEditAreaPage().verifyErrorMessageEndDate(endDateErrorMsg);
	}

	@When("the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page")
	public void enterBeganDate(@Named("beganDay1") String beganDay1, @Named("beganMonth1") String beganMonth1, @Named("beganYear1") String beganYear1) {
		enterDayInBeganDate(beganDay1);
		enterMonthInBeganDate(beganMonth1);
		enterYearInBeganDate(beganYear1);
	}

	@When("the user enters <endDay1> <endMonth1> <endYear1> End Date in the edit basic info area page")
	public void enterEndDate(@Named("endDay1") String endDay1, @Named("endMonth1") String endMonth1, @Named("endYear1") String endYear1) {
		enterDayInEndDate(endDay1);
		enterMonthInEndDate(endMonth1);
		enterYearInEndDate(endYear1);
	}


	@Then("the user should see the entered end date <day> <month> <year> in area page")
	public void verifyEndDateInAreaPage(@Named("day") String day, @Named("month") String month,
			@Named("year") String year) {
		getEditAreaPage().verifyEndDateInAreaPage(day, month, year);
	}

	@Then("the user should see the area end date <day> <month> <year> value in $source document")
	public void verifyAreaEndDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("day") String day,
			@Named("month") String month, @Named("year") String year) {
		getEditAreaPage().verifyAreaEndDateFromZeusDB(country, area, "EndDate", source, day, month, year);
	}

	@Then("the user should see area began date value same as in $source document")
	public void verifyAreaBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		setEditAreaPage(getDataPage().createEditAreaPage());
		getEditAreaPage().verifyAreaBeganDateFromTrustedDB(country, area, "BeganDate", source);

	}

	@Then("the user verifies whether all the months in the drop down option for area are in MMM format & are sorted in the chronological order")
	public void verifyBeganDateMonthChronologicalOrder() {
		getEditAreaPage().verifyMonthInChronologicalOrder();
	}


	@Then("the user should see the error $beganDateErrorMsg for area began date")
	public void verifyErrorMessageBeganDate(@Named("beganDateErrorMsg") String beganDateErrorMsg) {
		getEditAreaPage().verifyErrorMessageBeganDate(beganDateErrorMsg);
	}

	@When("the user enters <day2> <month2> <year2> Began Date in the edit basic info area page")
	public void enterBeganDates(@Named("day2") String day2, @Named("month2") String month2, @Named("year2") String year2) {
		enterDayInBeganDate(day2);
		enterMonthInBeganDate(month2);
		enterYearInBeganDate(year2);
	}

	@Then("the user should see the entered <day> <month> <year> in area page")
	public void verifyDayMonthYearInAreaPage(@Named("day") String day, @Named("month") String month,
			@Named("year") String year) {
		getEditAreaPage().verifyDayMonthYearInAreaPage(day, month, year);
	}

	@Then("the user should see the area began date <day> <month> <year> value in $source document")
	public void verifyAreaBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("day") String day,
			@Named("month") String month, @Named("year") String year) {
		getEditAreaPage().verifyAreaBeganDateFromZeusDB(country, area, "BeganDate", source, day, month, year);
	}

	@Then("the user should not see the <ConfirmationSummary> changes in confirmation modal for area")
	public void verifyNoChangeConfirmationMsg(@Named("ConfirmationSummary") String ConfirmationSummary) {
		getDataPage().verifyNoSummaryConfirmationModal(ConfirmationSummary);
	}

	@When("the user clicks on the Status drop-down in the basicinfo area page")
	public void clickOnCityStatusDropDown() {
		getEditAreaPage().clickOnAreaStatusDropDown();
	}

	@Then("the user should see the area status values from lookup AREA")
	public void verifyCityStatusList() {
		getEditAreaPage().verifyAreaStatusList();
	}

	@When("the user selects value as <status> from Status drop-down in the area basicinfo page")
	public void selectAreaStatusValue(@Named("status") String status) {
		getEditAreaPage().selectAreaStatusValue(status);
	}

	@Then("the user should see the successful update message at top of the area page")
	public void verifySuccessfulUpdatedMessage() {
		getEditAreaPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user should see the updated <status> in area web page")
	public void verifyStatusInAreaPage(@Named("status") String status) {
		getEditAreaPage().verifyStatusInAreaPage(status);
	}

	@Then("the user should see status value in area page as in $source document")
	public void verifyStatusValueFromZeusDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source, @Named("status") String status) {
		getEditAreaPage().verifyAreaStatusFromZeusDB(country, area, "status", source, status);
	}

	@When("the user starts typing the name of a status as $word in the Area Status drop-down")
	public void enterValueInStatusDropdown(String word) {
		getEditAreaPage().enterValueInStatusDropdown(word);

	}

	@Then("the user should see the selected status in the Area Status drop-down as $status")
	public void verifyAreaStatusInDropdown(String status) {
		getEditAreaPage().verifyAreaStatusInDropdown(status);
	}

	@When("the user enters the <area> in the type-ahead box")
	public void enterAreaInTypeAhead(@Named("area") String area) {
		getDataPage().enterAreaInTypeAhead(area);
	}

	@Then("the user should see the status value in area page is same as in $source document")
	public void verifyCityBeganDateValueFromDB(@Named("country") String country, @Named("area") String area,
			@Named("source") String source) {
		getEditAreaPage().verifyAreaFromTrustedDB(country, area, "status", source);
	}

	@When("the user selects value as <status2> from Status drop-down in the area basicinfo page")
	public void selectAreaStatusValue2(@Named("status2") String status) {
		getEditAreaPage().selectAreaStatusValue(status);
	}
	
	@When("the user enters the <addInfoText> in the area add info text area")
	public void enterTextAreaAddInfo(@Named("addInfoText") String addInfoText) {
		getEditAreaPage().enterTextAreaAddInfo(addInfoText);
	}
	
	@Then("the user should be able to verify the values are entered in the area add info field")
	public void verifyAreaTextInAddInfo(@Named("addInfoText") String addInfoText) {
		getEditAreaPage().verifyAreaTextInAddInfo(addInfoText);
	}
	
	@When("the user enters values which is beyond 500 unicode characters in the area add info field")
	public void enterInvalidCharactersInAreaAddInfo() {
		getEditAreaPage().enterInvalidCharactersInAreaAddInfo();
	}
	
	@Then("the user should be able to view that only 500 unicode characters are saved in area add info")
	public void viewValidCharacterLength() {
		getEditAreaPage().viewValidCharacterLength();
	}
	
	@Then("the user should be able to verify the maximum values are entered in the area add info field")
	public void verifyMaximumTextInAddInfo() {
		getEditAreaPage().verifyMaximumChracterEnteredInAddInfo();
	}
	
	@Then("the user should see the area addInfoText value same as in $source document")
	public void verifyAreaAddInfoValueFromDB(@Named("country") String country, @Named("area") String area, @Named("source") String source) {
		getEditAreaPage().verifyAreaAddInfoValueFromTrusted(country, area, "AdditionalInfo", source);
	}
	
	@Then("the user should see the area addinfo value $addInfoText as in $source document")
	public void verifyAreaAddInfoFromDB(@Named("country") String country, @Named("area") String area, @Named("source") String source, @Named("addInfoText") String addInfoText) {
		getEditAreaPage().verifyAreaAddInfoValueFromZeus(country, area, "AdditionalInfo", source,addInfoText);
	}
	
	@When("the user enters the <addInfoDiffText> in the area add info text area")
	public void enterTextAreaAddInfo2(@Named("addInfoDiffText") String addInfoDiffText) {
		getEditAreaPage().enterTextAreaAddInfo(addInfoDiffText);
	}
	
	@Then("the user should verify the header dropdowns are disabled")
	public void userVerifyHeaderDropdownValuesDisabled() throws InterruptedException {
		getEditAreaPage().userVerifyHeaderDropdownValuesDisabled();
	}

	@Then("the user should verify the country dropdown is populating with default country <country> as a option")
	public void userVerifyCountryDropdownDefaultValue(@Named("country") String country) {
		getEditAreaPage().userVerifyCountryDropdownDefaultValue(country);
	}

	@Then("the user should see all the list of existing countries by full name in Alphabetical order in area basic info page")
	public void verifyCountryListInPlacesFortheCountry() {
		getEditAreaPage().verifyCountryListInPlacesForCountry();
	}

	@Then("the user should see the $errorMessage error message for the required area parent field in the area basic page")
	public void verifyErrorMessageForRequiredAreaparentField(@Named("errorMessage") String errorMessage) throws InterruptedException {
		getEditAreaPage().verifyErrorMessageForRequiredAreaparentField(errorMessage);
	}

	@Then("the user checks whether the header dropdown updates with <country2>, <area>")
	public void checksHeaderdropdownValue(@Named("country2") String country, @Named("area") String area)
			throws InterruptedException {
		getEditAreaPage().checksHeaderdropdownValue(country, area);
	}	
	
	@Then("the user verifies <area> is mapped to newly added <country2> in $source document")
	public void verifyZeusDocument(@Named("source") String source, @Named("area") String area,
			@Named("country2") String country2, @Named("area") String areaId) throws InterruptedException {
		getEditAreaPage().verifyAreaInfoFromZeusDB(country2, area, "area", source, areaId);
	}

	@Then("the user should verify the parent area dropdown is populating with default area <area> as a option")
	public void userVerifyAreaParentDropdownDefaultValue(@Named("area") String area) {
		getEditAreaPage().userVerifyAreaParentDropdownDefaultValue(area);
	}

	@When("the user click on the choose an area parent option of area basic page")
	public void clicksOnAreaDropdown() throws InterruptedException {
		getEditAreaPage().clickOnAreaDropdown();
	}

	@Then("user should see the list of area parent options are pointing to selected <country> in area basic page")
	public void verifyParentAreaListInPlaceForCountry(@Named("country") String country) {
		getEditAreaPage().verifyAreaListInPlacesForCountry(country);
	}

	@Then("user verify the list of area pareant options do not have No Area")
	public void verifyParentAreaListDontHaveNullNovalue() {
		getEditAreaPage().verifyParentAreaDropdownDontHaveNoArea();
	}	

	@Then("the user checks whether the header dropdown updates with <country2>, <areaParent>, <subArea>")
	public void checksHeaderdropdownValues(@Named("country2") String country, @Named("areaParent") String areaParent,
			@Named("subArea") String subArea) throws InterruptedException {
		getEditAreaPage().verifyHeaderDropDownValues(country, areaParent, subArea);
	}

	@Then("the user checks whether the Address bar url is updated  with <country2>, <areaParent>")
	public void checksAddressBar(@Named("country2") String country, @Named("areaParent") String areaParent)
			throws InterruptedException {
		getEditAreaPage().checksAddressBarIsHavingNewCountryAreaIds(country, areaParent);
	}
	
	@Then("the user verifies <subArea> is mapped to newly added <country2> and <areaParent> in $source document")
	public void verifySubAreaInfoFromZeusDocument(@Named("source") String source, @Named("subArea") String subArea,
			@Named("country2") String country2, @Named("area") String area, @Named("areaParent") String areaParent)
			throws InterruptedException {
		getEditAreaPage().verifySubAreaInfoFromZeusDB(country2, areaParent, subArea, "subarea", source, subArea);
	}

	@Then("user should verify the subArea dropdown does not have subArea <subArea> value mapped to old country and area")
	public void verifySubAreaDropdown(@Named("subArea") String subArea) throws InterruptedException {
		getEditAreaPage().verifySubAreaDropdown(subArea);
	}

	@Then("user should see the list of area parent options in Area page is Empty")
	public void verifyParentAreaListIsEmpty(@Named("country2") String country2) {
		getEditAreaPage().verifyParentAreaListIsEmpty(country2);
	}
	
	@Then("user should see the list of area parent options in area page is Empty")
	public void verifyParentAreasListIsEmpty(@Named("country") String country) {
		getEditAreaPage().verifyParentAreaListIsEmpty(country);
	}

	@Then("the user should verfiy that the 'Choose an Area' option is populated in the area parent dropdown")
	public void userVerifyNoSubarea() throws InterruptedException {
		getEditAreaPage().verifyChooseAnAreaOptionInAreaparent();
	}

	@Then("user should see the list of Area parent options in Area page are in Alphabetical order")
	@Alias("user should see the list of area parent options are refreshed pointing to selected <country2> in area basic info page")
	public void verifyParentAreaListInPlacesForCountry(@Named("country2") String country) {
		getEditAreaPage().verifyAreaListInPlaceForCountry(country);
	}
	
	@When("user changes the <country2> in the country dropdownfield of area basic page")
	public void userChangesCountryDropdownValue(@Named("country2") String country2) throws InterruptedException {
		getEditAreaPage().selectCountryValue(country2);
	}

	@Then("user changes the area <areaParent> in the area dropdown field in area basic page")
	public void userChangesAreaDropdownvalue(@Named("areaParent") String areaParent) throws InterruptedException {
		getEditAreaPage().userChangesAreaDropdownvalue(areaParent);
	}	
		
	@When("the user gets the document with $xqueryName with the <subArea> from the database")
	public void getDocumentByFidSubArea(@Named("xqueryName") String xqueryName, @Named("subArea") String subArea,@Named("country") String country,@Named("area") String area) {
		getDataPage().getDocumentforSubArea(xqueryName, subArea, country, area);
	}
}