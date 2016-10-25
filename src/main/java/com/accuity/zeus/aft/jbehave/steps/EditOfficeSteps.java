package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EditOfficeSteps extends AbstractSteps{

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;

    @When("the user updates office Opened <day> <month> <year>")
    public void updateOfficeOpenedDate(@Named("day") String day,@Named("month") String month,@Named("year") String year)
    {getEditOfficePage().updateOfficeOpenedDate(day,month,year);}

    @When("the user gets the document with $xqueryName with the <officeFid> from the database")
    public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("officeFid") String officeFid) {
        getDataPage().getDocument(xqueryName, "fid",officeFid);
    }

    @Then("the user should see the error $openedDateErrorMsg for opened date")
    public void verifyOpenedDateErrorMessage(@Named("openedDateErrorMsg") String openedDateErrorMsg) {
        getEditOfficePage().verifyOpenedDateErrorMessage(openedDateErrorMsg);
    }
    @When("the user clicks on the office update link")
    public void clickOnUpdateCurrencyLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editOfficePage==null){
            editOfficePage = getOfficesPage().createEditOfficePage();
        }}

    @Then("the user verifies office opened date from $source document <officeFid> <day> <month> <year>")
    public void verifyUpdatedOfficeOpenedDate(@Named("officeFid") String officeFid,@Named("day") String day,@Named("month") String month,@Named("year") String year,@Named("source") String source){getEditOfficePage().verifyUpdatedOfficeOpenedDate(officeFid,day,month,year,source);}

    @When("the user updates principal office flag to <principalFlag>")
    public void updatePrincipalFlag(@Named("principalFlag") String principalFlag){
        editOfficePage.setPrincipalOffice(principalFlag);
    }


    @When("the user selects lead location value <leadLocationflag> in the basicinfo office page")
    public void selectOfficeLeadLocationFlag(@Named("leadLocationflag") String leadLocationflag){
        getEditOfficePage().selectOfficeLeadLocationFlag(leadLocationflag);
    }
    @When("the user enters the office prefix value as <prefix>")
    public void enterOfficePrefixValue(@Named("prefix") String prefix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_prefix_xpath",prefix);
    }
    @When("the user enters the office suffix value as <suffix>")
    public void enterOfficeSuffixValue(@Named("suffix") String suffix)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_suffix_xpath",suffix);
    }
    @When("the user enters the office override value as <override>")
    public void enterOfficeOverrideValue(@Named("override") String override)
    {
        getEditOfficePage().enterValueinTextField("office_basicInfo_edit_override_xpath",override);
    }
    @Then("the user should verify the prefix,suffix and override values for fid <officeFid> as:$values")
    public void verifyPrefixSuffixAndOverrideValuesFromZeus(@Named("officeFid") String officeFid, @Named("values")ExamplesTable values)
    {
        getEditOfficePage().verifyPrefixSuffixAndOverrideValuesFromZeus(officeFid,values);
    }

    @Then("the user should see the maxlength of prefix field set to $maxlength")
    public void verifyPrefixMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_prefix_xpath",maxlength);
    }
    @Then("the user should see the maxlength of suffix field set to $maxlength")
    public void verifySuffixMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_suffix_xpath",maxlength);
    }
    @Then("the user should see the maxlength of override field set to $maxlength")
    public void verifyOverrideMaxLength(String maxlength){
        getEditOfficePage().verifyMaxLength("office_basicInfo_edit_override_xpath",maxlength);
    }


    @Then("the user should see leadLocation value as <leadLocationflag> for fid <officeFid> in $source document and in zeus UI")
    public void getDocumentLeadLocation(@Named("leadLocationflag") String leadLocationflag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyLeadLocationValuefromZeusDocumentAndUI(leadLocationflag,officeFid,source);
    }


    @When("the user selects lead location value other than default value in the basicinfo office page")
    public void changeOfficeLeadLocationFlag() {
        getEditOfficePage().changeAlternateRadioButtonValue("office_leadlocation_radio_options_xpath");
    }

    @When("the user selects foreign office value <foreignOfficeflag> in the basicinfo office page")
    public void selectForeignOfficeFlag(@Named("foreignOfficeflag") String foreignOfficeflag){
        getEditOfficePage().selectForeignOfficeFlag(foreignOfficeflag);
    }

    @Then("the user should see foreignOffice value as <foreignOfficeflag> for fid <officeFid> in $source document and in zeus UI")
    public void verifyForeignOfficeValuefromZeusDocumentandUI(@Named("foreignOfficeflag") String foreignOfficeflag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyForeignOfficeValuefromZeusDocumentandUI(foreignOfficeflag,officeFid,source);
    }


    @When("the user selects foreign office value other than default value in the basicinfo office page")
    public void changeForeignOfficeFlag() {
        getEditOfficePage().changeAlternateRadioButtonValue("office_foreignoffice_radio_options_xpath");
    }

    @Then("the user should return to edit office page mode")
    public void verifyOfficeEditPageMode(){
        getEditOfficePage().verifyOfficeEditPageMode();
    }
    @When("the user enters the <additionalInfoText> in the office additional info text area")
    public void enterOfficeAdditionalInfo(@Named("additionalInfoText") String additionalInfoText)
    {
        getEditOfficePage().enterOfficeAdditionalInfo(additionalInfoText);
    }

    @Then("the user should see office additional info text value as <additionalInfoText> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(@Named("additionalInfoText") String additionalInfoText,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAdditionalInfoValueFromZeusDocumentAndUI(additionalInfoText,officeFid,source);
    }

    @Then("the user should see the office additional info text area field length as 10000")
    public void verifyOfficeAdditionalInfoTextAreaLength(@Named("officeFid") String officeFid) {
        getEditOfficePage().verifyOfficeAdditionalInfoTextAreaLength(officeFid);
    }


    @When("the user enters 10000 characters in the office additional info text area")
    public void enter10000CharactersInOfficeAdditionalInfo(@Named("officeFid") String officeFid) {
        getEditOfficePage().enter10000CharactersInOfficeAdditionalInfo(officeFid);
    }


    @Then("the user should see the office additional info text value with 10000 characters for fid <officeFid> in $source document")
    public void verifyAdditionalInfoValueWithMaxLengthFromDB(@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyAdditionalInfoValueWithMaxLengthFromZeus("additionalInfo",officeFid,source);
    }

	@When("the user clicks on the add new office location button in the office page")
	public void clickOnAddButton() {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_locations_id"));
	}

	@Then("the user should see the $add_button in disabled state in locations section")
	public void verifyAddOfficeLocationButtonStatus(@Named("add_button") String add_button) {
		getEditOfficePage().verifyAddOfficeLocationButtonStatus(add_button);
	}

	@Then("the user should see the $delete_button in disabled state in location address section")
	public void verifyDeleteOfficeAddressButtonStatus(@Named("delete_button") String delete_button) {
		getEditOfficePage().verifyDeleteOfficeAddressButtonStatus(delete_button);
	}

	@When("the user clicks on delete office locations $rowNumber delete button")
	public void clickonDeleteOfficeLocationsRowButton(@Named("rowNumber") int rowNumber) throws Exception {	
		Thread.sleep(3000L);
		getDataPage().clickElementUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_delete_button"), rowNumber);
	}

	@Then("the user should not see the office location row in the locations office page")
	public void verifyOfficeLocationRowIsNotDisplayed() throws Exception {
		getEditOfficePage().verifyOfficeLocationRowIsNotDisplayed();
	}

	public void verifyNoNewOfficeLocationRow(String dropdown) {
		getEditOfficePage().verifyNoNewOfficeLocationRow(dropdown);
	}

    @When("the user selects primary flag  value <primaryFlag> in the office locations")
    public void selectPrimaryFlag(@Named("primaryFlag") String primaryFlag){
        getEditOfficePage().selectPrimaryFlag(primaryFlag);
    }

    @When("the user clicks on add new office address button in the office locations")
    public void clickOnAddAddressRowButton(){
        getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_address_addRow_button"));
    }

	@When("the user selects office address type value as <Type> in row $index")
	public void selectOfficeAddressType(@Named("index") int index, @Named("Type") String type) {	 
		getDataPage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_dropdown"), type, index);
	}

	@When("the user enters office address <AddressLine1> in row $index")
	public void enterofficeAddressLine1(@Named("index") int index, @Named("AddressLine1") String AddressLine1) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine1"), AddressLine1, index);
	}

	@When("the user enters office address <AddressLine2> in row $index")
	public void enterofficeAddressLine2(@Named("index") int index, @Named("AddressLine2") String AddressLine2) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine2"), AddressLine2, index);
	}

	@When("the user enters office address <AddressLine3> in row $index")
	public void enterofficeAddressLine3(@Named("index") int index, @Named("AddressLine3") String AddressLine3) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine3"), AddressLine3, index);
	}

	@When("the user enters office address <AddressLine4> in row $index")
	public void enterofficeAddressLine4(@Named("index") int index, @Named("AddressLine4") String AddressLine4) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine4"), AddressLine4, index);
	}

	@When("the user clicks on the choose a country option in the office locations")
	public void clickOnCountryListBox() throws InterruptedException {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_country_dropdown"));
	}

	@When("the user enters the office country <Country> in the type-ahead box")
	public void enterOfficeCountryInTheTypeAheadBox(@Named("Country") String Country) {
		getEditOfficePage().enterOfficeCountryInTheTypeAheadBox(Country, 1);
	}

	@When("the user enters the office city <City> in the type-ahead box")
	public void enterOfficeCityInTheTypeAheadBox(@Named("City") String City) {
		getEditOfficePage().enterOfficeCityInTheTypeAheadBox(City, 1);
	}

	@Then("the user should see the list of all existing area for the selected country by full name in office address")
	public void verifyOfficeAreaList() {
		getEditOfficePage().verifyOfficeAreaList();
	}

	@When("the user clicks on the choose an area option in the office locations")
	public void clickOnAreaListBox() throws InterruptedException {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown"));
	}

	@When("the user enters the office area <Area> in the type-ahead box")
	public void enterOfficeAreaInTypeAhead(@Named("Area") String Area) {
		getEditOfficePage().enterOfficeAreaInTypeAhead(Area, 1);
	}

	@Then("the user should see the list of all existing subarea for the selected area by full name in office address")
	public void verifyOfficeSubAreaList() {
		getEditOfficePage().verifyOfficeSubAreaList(database, apacheHttpClient);
	}

	@When("the user clicks on the choose a subarea option in the office locations")
	public void clickOnSubAreaListBox() throws InterruptedException {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown"));
	}

	@When("the user enters the office subarea <subArea> in the type-ahead box")
	public void enterOfficeSubAreaInTypeAhead(@Named("subArea") String subArea) {
		getEditOfficePage().enterOfficeSubAreaInTypeAhead(subArea, 1);
	}

	@Then("the user should see the below office cities for the selected subarea: $cities")
	public void verifyCitiesForSelectedSubArea(ExamplesTable cities) {
		getEditOfficePage().verifyCitiesForSelectedSubArea(cities);
	}

	@Then("the user should see the below office states for the selected country: $areas")
	public void verifyAreaForSelectedCountry(ExamplesTable areas) {
		getEditOfficePage().verifyAreaForSelectedCountry(areas);

	}
	
	@Then("the user verifies that the location row exists in the office locations page")
    public void verifyOfficeLocationsRowIsDisplayed() throws Exception {
           getDataPage().verifyRowIsDisplayed(OfficeIdentifiers.getObjectIdentifier("office_locations_row_exists_edit_mode"),
                        true);
    }
    
    @Then("the user verifies that the location row does not exist in the office locations page")
    public void verifyOfficeLocationsRowIsDeleted() throws Exception {
    	Thread.sleep(2000L);
        getDataPage().verifyElementNotExistInUI(OfficeIdentifiers.getObjectIdentifier("office_location_row_exists_view_mode"));
    }


	@Then("the user should see the below office cities for the selected area: $cities")
	public void verifyCitiesForSelectedArea(ExamplesTable cities) {
		getEditOfficePage().verifyCitiesForSelectedArea(cities);
	}

	@When("the user clicks on the choose a city option in the office locations")
	public void clickOnCityDropdown() {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown"));
	}

	@Then("the user should see the list of all existing city for the selected area by full name in office address")
	public void verifyOfficeCityList() {
		getEditOfficePage().verifyOfficeCityList();
	}

	@When("the user clicks on delete office address row button for the row $deletebutton_Row")
	public void clickonDeleteOfficeAddressRowButton(String deletebutton_Row) {
		getEditOfficePage().clickonDeleteOfficeAddressRowButton(deletebutton_Row);
	}

	@Then("the user should not see the office address row in the locations office page")
	public void verifyOfficeAddressRowIsNotDisplayed() throws Exception {
		getDataPage().verifyElementNotExistInUI(OfficeIdentifiers.getObjectIdentifier("office_address_delete_row_view"));
	}

    @Then("the user verifies that the deleted row for office locations does not exist in $source document")
    @Alias("the user verifies that blank office locations row is not added in $source document")
    public void verifyOfficeLocationsRowNotPresentInZeusDB(@Named("officeFid") String officeFid,  @Named("source") String source) {
        getEditOfficePage().verifyOfficeLocationsRowNotPresentInZeusDB(officeFid, source);
    }

    @Then("the user verifies that the deleted row for office address does not exist in $source document")
    public void verifyOfficeAddressRowNotPresentInZeusDB(@Named("officeFid") String officeFid,  @Named("source") String source) {
        getEditOfficePage().verifyOfficeAddressRowNotPresentInZeusDB(officeFid, source);
    }

    @Then("the user verifies that the deleted row for office telecoms does not exist in $source document")
    public void verifyOfficeTelecomsRowNotPresentInZeusDB(@Named("officeFid") String officeFid,  @Named("source") String source) {
        getEditOfficePage().verifyOfficeTelecomsRowNotPresentInZeusDB(officeFid, source);
    }

    @When("the user clicks on add new office telecoms button in the office locations")
    public void clickOnAddTelecomsRowButton(){
        getEditOfficePage().clickOnAddTelecomsRowButton();
    }

	@When("the user selects office telecoms type $typeRowIdentifier value as <type>")
	public void selectOfficeTelecomsType(@Named("typeRowIdentifier") String typeRowIdentifier, @Named("type") String type) {
		getEditOfficePage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier), type, 1);
	}

	@When("the user enters office telecoms rank $rankRowIdentifier value as <rank>")
	public void enterOfficeTelecomsRank(@Named("rankRowIdentifier") String rankRowIdentifier, @Named("rank") String rank) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(rankRowIdentifier), rank, 1);
	}

	@When("the user enters office telecoms text before $textBeforeRowIdentifier value as <textBefore>")
	public void enterOfficeTelecomsTextBefore(@Named("textBeforeRowIdentifier") String textBeforeRowIdentifier, @Named("textBefore") String textBefore) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(textBeforeRowIdentifier), textBefore, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <countryCode>")
	public void enterOfficeTelecomsCountryCode(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("countryCode") String countryCode) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), countryCode, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <areaCode>")
	public void enterOfficeTelecomsAreaCode(@Named("valueRowIdentifier") String valueRowIdentifier,	@Named("areaCode") String areaCode) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), areaCode, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <number>")
	public void enterOfficeTelecomsNumber(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("number") String number) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), number, 1);
	}

	@When("the user enters office telecoms range limit $rangeLimitRowIdentifier value as <rangeLimit>")
	public void enterOfficeTelecomsRangeLimit(@Named("rangeLimitRowIdentifier") String rangeLimitRowIdentifier,	@Named("rangeLimit") String rangeLimit) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(rangeLimitRowIdentifier), rangeLimit, 1);
	}

	@When("the user enters office telecoms ext $extRowIdentifier value as <ext>")
	public void enterOfficeTelecomsExt(@Named("extRowIdentifier") String extRowIdentifier, @Named("ext") String ext) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(extRowIdentifier), ext, 1);
	}

	@When("the user enters office telecoms text after $textAfterRowIdentifier value as <textAfter>")
	public void enterOfficeTelecomsTextAfter(@Named("textAfterRowIdentifier") String textAfterRowIdentifier, @Named("textAfter") String textAfter) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(textAfterRowIdentifier), textAfter, 1);
	}

	@When("the user enters office telecoms answer back $answerBackRowIdentifier value as <answerBack>")
	public void enterOfficeTelecomsAnswerBack(@Named("answerBackRowIdentifier") String answerBackRowIdentifier, @Named("answerBack") String answerBack) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(answerBackRowIdentifier), answerBack, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <value>")
	public void enterOfficeTelecomsValue(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("value") String value) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), value, 1);
	}
    
    @Then("the user should not see the office telecoms row in the locations office page")
	public void verifyNewlyAddedOfficeTelecomRowIsNotDisplayed() throws Exception {
		getDataPage().verifyElementNotExistInUI(OfficeIdentifiers.getObjectIdentifier("office_locations_telecom_row_view_mode"));
	}

    @Then("the user should not see the newly added locations row in the office locations page")
    public void verifyOfficeLocationsRowIsNotDisplayed() throws Exception {
        getEditOfficePage().verifyOfficeLocationsRowIsNotDisplayed();
    }

	@When("the user enters office address postal code value as <PostalCode> in location $index")
	public void enterOfficeAddressPostalCode(@Named("index") int index, @Named("PostalCode") String postalCode) {
		getDataPage().enterTextUsingIndex(
				OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCode"), postalCode, index);
	}
	
	@When("the user enters office address postal code suffix value as <PostalCodeSuffix> in location $index")
	public void enterOfficeAddressPostalCodeSuffix(@Named("index") int index,
			@Named("PostalCodeSuffix") String PostalCodeSuffix) {
		getDataPage().enterTextUsingIndex(
				OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCodeSuffix"), PostalCodeSuffix, index);
	}
	
	@When("the user enters office address info value as <Info> in location $index")
	public void enterOfficeAddressInfo(@Named("index") int index, @Named("Info") String info) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_info"),
				info, index);
	}
	
    @When("the user clicks on delete office telecoms row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeTelecomsRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeTelecomsRowButton(deletebutton_Row);
    }

    @When("the user clicks on office address type drodown")
    public void clickonTypeDropdown() {
           getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_dropdown"));
    }
    
    @Then("the user should see the address type values in office location's section from lookup $lookup")
    public void verifyOfficeAddressTypesFromLookup(@Named("officeaddress_rowIdentifier") String officeaddress_rowIdentifier,@Named("officeFid") String lookupFid) {     
    	getDataPage().verifyLookUpValues(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_options_dropdown"), "get Office Address Types", "officeAddressType");
    }

    @Then("the user should see the error message $errorMsg for the office address type field")
    public void verifyOfficeAddressTypeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_type_physical_error_msg", errorMsg);

    }

    @Then("the user should see the $officetelecom_rowIdentifier values in office telecoms's section from lookup $lookup")
    public void verifyOfficeTelecomTypesFromLookup(@Named("officetelecom_rowIdentifier") String officetelecom_rowIdentifier, @Named("lookup") String lookup) {
        getDataPage().verifyLookUpValues(OfficeIdentifiers.getObjectIdentifier(officetelecom_rowIdentifier), "get Office Telecoms Types", "officeTelecomTypes");
    }
    
    @Then("the user should see the office telecom values same as in $source document")
	public void verifyOfficeTelecomValuesFromTrustedDB(@Named("officeFid") String officeFid, @Named("source") String source) {
    	getEditOfficePage().verifyOfficeTelecomValuesFromTrustedDB(officeFid, source);
	}
    
    @Then("the user verifies the $officeField maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthOfficeLocationsTextFields(@Named("$officeField") String officeField,@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){
    	getEditOfficePage().verifyMaxlengthOfficeLocationsTextFields(maxSize,rowIdentifier);
    }

	@Then("the user verifies that the office address lines addresses are entered in the office locations page for two locations")
	public void verifyOfficeAddressLinesAddressesForTwoLocations(@Named("Type") String type, @Named("Type2") String type2,
					@Named("AddressLine1") String addressLine1, @Named("AddressLine2") String addressLine2,
					@Named("AddressLine3") String addressLine3, @Named("AddressLine4") String addressLine4,
					@Named("PostalCode") String postalCode, @Named("PostalCodeSuffix") String postalCodeSuffix, 
					@Named("Info") String info, @Named("Country") String country, @Named("Area") String area,
					@Named("subArea") String subArea, @Named("City") String city) {		
		if(editOfficePage==null){
            editOfficePage = getOfficesPage().createEditOfficePage();
        }
		getEditOfficePage().verifyOfficeAddressLinesAddressesInUI(type, addressLine1, addressLine2, addressLine3,
					addressLine4, country, area, subArea, city, postalCode, postalCodeSuffix, info, 1);
		getEditOfficePage().verifyOfficeAddressLinesAddressesInUI(type2, addressLine1, addressLine2, addressLine3,
				addressLine4, country, area, subArea, city, postalCode, postalCodeSuffix, info, 2);
	}
	
	@Then("the user verifies that the office address lines addresses are entered in the office locations page")
	public void verifyOfficeAddressLinesAddressesInUI(@Named("Type") String type,
					@Named("AddressLine1") String addressLine1, @Named("AddressLine2") String addressLine2,
					@Named("AddressLine3") String addressLine3, @Named("AddressLine4") String addressLine4,
					@Named("PostalCode") String postalCode, @Named("PostalCodeSuffix") String postalCodeSuffix, 
					@Named("Info") String info, @Named("Country") String country, @Named("Area") String area,
					@Named("subArea") String subArea, @Named("City") String city) {		
		
		getEditOfficePage().verifyOfficeAddressLinesAddressesInUI(type, addressLine1, addressLine2, addressLine3,
					addressLine4, country, area, subArea, city, postalCode, postalCodeSuffix, info, 1);		
	}

	@Then("the user should see the office address lines addresses as in $source document")
	public void verifyOfficeAddressLinesAddressesFromDB(@Named("Type") String type, 
			@Named("officeFid") String officeFid, @Named("AddressLine1") String addressLine1,
			@Named("AddressLine2") String addressLine2, @Named("AddressLine3") String addressLine3,
			@Named("AddressLine4") String addressLine4, @Named("PostalCode") String postalCode,
			@Named("PostalCodeSuffix") String postalCodeSuffix, @Named("Info") String info, @Named("Country") String country, @Named("Area") String area,
			@Named("subArea") String subArea, @Named("City") String city, @Named("source") String source) {

		getEditOfficePage().verifyOfficeAddressLinesAddressesFromDB(type, addressLine1, addressLine2, addressLine3,	addressLine4, postalCode, postalCodeSuffix, info, country, area, subArea, city,
					officeFid, source);		
	}
	
	@Then("the user should see the office address lines addresses as in $source document for two locations")
	public void verifyOfficeAddressLinesAddressesFromDBForTwoLocations(@Named("Type") String type, @Named("Type2") String type2,
			@Named("officeFid") String officeFid, @Named("AddressLine1") String addressLine1,
			@Named("AddressLine2") String addressLine2, @Named("AddressLine3") String addressLine3,
			@Named("AddressLine4") String addressLine4, @Named("PostalCode") String postalCode,
			@Named("PostalCodeSuffix") String postalCodeSuffix, @Named("Info") String info, @Named("Country") String country, @Named("Area") String area,
			@Named("subArea") String subArea, @Named("City") String city, @Named("source") String source) {

		getEditOfficePage().verifyOfficeAddressLinesAddressesFromDB(type, addressLine1, addressLine2, addressLine3,	addressLine4, postalCode, postalCodeSuffix, info, country, area, subArea, city,
					officeFid, source);
		getEditOfficePage().verifyOfficeAddressLinesAddressesFromDB(type2, addressLine1, addressLine2, addressLine3,	addressLine4, postalCode, postalCodeSuffix, info, country, area, subArea, city,
				officeFid, source);
	}


	@When("the user enters office address values in location $index")
	public void enterLocationAddressesInLocation2(@Named("Type2") String type2,
			@Named("AddressLine1") String addressLine1, @Named("AddressLine2") String addressLine2,
			@Named("AddressLine3") String addressLine3, @Named("AddressLine4") String addressLine4,
			@Named("PostalCode") String postalCode, @Named("PostalCodeSuffix") String postalCodeSuffix,
			@Named("Info") String info, @Named("Country") String country, @Named("Area") String area,
			@Named("subArea") String subArea, @Named("City") String city,@Named("index") int index) {
		
		getDataPage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier("office_location_address_type_dropdown"), type2, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine1"), addressLine1, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine2"), addressLine2, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine3"), addressLine3, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_location_addressLine4"), addressLine4, index);
		getDataPage().clickElementUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_country_dropdown"), index);
		getEditOfficePage().enterOfficeCountryInTheTypeAheadBox(country, index);
		getDataPage().clickElementUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_area_dropdown"), index);
		getEditOfficePage().enterOfficeAreaInTypeAhead(area, index);
		getDataPage().clickElementUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_subarea_dropdown"), index);
		getEditOfficePage().enterOfficeSubAreaInTypeAhead(subArea, index);
		getDataPage().clickElementUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_city_dropdown"), index);
		getEditOfficePage().enterOfficeCityInTheTypeAheadBox(city, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCode"), postalCode, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_postalCodeSuffix"), postalCodeSuffix, index);
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_address_first_row_new_info"), info, index);
		
	}

	@When("the user deletes the existing office locations rows")
	public void deleteExistingOfficeLocationRows() throws Exception {
		Thread.sleep(2000);//loading issue in multi location
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_locations_id"));
		getEditOfficePage().deleteLocationRows();
	}
	
	@Then("the user should see the office locations address same as in $source document")
	public void verifyOfficeLocationAddressFromTrustedDB(@Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeLocationFromTrustedDB(officeFid, source);
	}

	@Then("the user verifies that the newly added address row exists in the office locations page")
	public void verifyNewlyAddedOfficeAddressRowIsDisplayed() throws Exception {
		getDataPage().verifyRowIsDisplayed(OfficeIdentifiers.getObjectIdentifier("office_locations_address_rows_edit_mode"),
				true);
	}
	@Then("the user should see the error message $errorMsg for the office address addressLine1 field")
	public void verifyOfficeAddressLine1ErrorMessage(@Named("errorMsg") String errorMsg) {
		getEditOfficePage().verifyOfficeErrorMessage("office_locations_addressLine1_error_msg_second_row", errorMsg);
	}

	@Then("the user should see the error message $errorMsg for the office address type field for the second address row")
	public void verifyOfficeAddressTypeErrorMessageSecondRow(@Named("errorMsg") String errorMsg) {
		getEditOfficePage().verifyOfficeErrorMessage("office_address_type_error_msg_second_row", errorMsg);
	}
    
    @Then("the user verifies that previously selected <Type> is not present in the new address row")
    public void verifySelectedOfficeAddressTypeNotInNewRow(@Named("Type") String Type) {
           getEditOfficePage().verifySelectedOfficeAddressTypeNotInNewRow(Type, 2);
    }

    @Then("the user should see the office telecomm fields for Type(telephone/fax) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("type") String type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("countryCode") String countryCode,
			@Named("areaCode") String areaCode, @Named("number") String number, @Named("rangeLimit") String rangeLimit,
			@Named("ext") String ext, @Named("textAfter") String textAfter, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(type, rank, textBefore, countryCode, areaCode, number,
				rangeLimit, ext, textAfter, null, null, officeFid, source);
	}
    
    @Then("the user should see the office telecomm fields for Type(telex/reuters/cable) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("type") String type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("textAfter") String textAfter,
			@Named("answerBack") String answerBack, @Named("value") String value, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(type, rank, textBefore, null, null, null, null, null,
				textAfter, answerBack, value, officeFid, source);
	}
    
    @Then("the user should see the office telecomm fields for Type(email/website) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("type") String type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("textAfter") String textAfter, @Named("value") String value,
			@Named("officeFid") String officeFid, @Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(type, rank, textBefore, null, null, null, null, null, textAfter, null, value, officeFid, source);
	}

    @Then("the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in $source document and in zeus UI")
    public void getDocumentPrimaryFlag(@Named("primaryFlag") String primaryFlag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyPrimaryFlagValuefromZeusDocumentAndUI(primaryFlag,officeFid,source);
    }


    @Then("the user should see the error message $errorMsg for the office country field")
    public void verifyOfficeCountryErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_country_error_msg", errorMsg);

    }
    @Then("the user should see the error message $errorMsg for the office country code field")
    public void verifyOfficeCountryCodeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_countryCode_error_msg", errorMsg);

    }

    @Then("the user should see the error message $errorMsg for the office area code field")
    public void verifyOfficeAreaCodeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_areaCode_error_msg", errorMsg);

    }

    @Then("the user should see the error message $errorMsg for the office number field")
    public void verifyOfficeNumberErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_number_error_msg", errorMsg);

    }

    @Then("the user should see the error message $errorMsg for the office range limit field")
    public void verifyOfficeRangeLimitErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_rangeLimit_error_msg", errorMsg);

    }

    @Then("the user should see the error message $errorMsg for the office ext field")
    public void verifyOfficeExttErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_ext_error_msg", errorMsg);

    }

    @Then("the user should see the error message $errorMsg for the office city field")
    public void verifyOfficeCityErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_city_error_msg", errorMsg);

    }    

    @Then("the user should see the error message $errorMsg for the office telecom type field")
    public void verifyOfficeTelecomTypeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_type_error_msg", errorMsg);
    }
    
    @Then("the user should see the error message $errorMessage for the office value field")
    public void verifyOfficeTelecomValueErrorMessage(@Named("errorMessage") String errorMessage) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_value_error_msg", errorMessage);
    }

    @Then("the user should see the error message $errorMessage for the office telecom rank field")
    public void verifyOfficeTelecomRankErrorMessage(@Named("errorMessage") String errorMessage) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_rank_error_msg", errorMessage);
    }

    @When("the user clicks on the No button to cancel the deletion of row in office locations section")
    public void pressNoButtonInDeleteConfirmationModalForOfficeLocation() {
    	getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_delete_no_button"));
    }

    @When("the user clicks on the Yes button to confirm the deletion of row in office locations section")
    public void pressYesButtonInDeleteConfirmationModalForOfficeLocation() {
        getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_location_delete_yes_button"));
    }

    @Then("the user verifies that the row values exists in the office locations page")
    public void verifyNewlyAddedOfficeLocationRowExists() {
        getEditOfficePage().verifyNewlyAddedOfficeLocationRowExists();
    }

    @When("the user clicks on the No button to cancel the deletion of row in office locations page")
    public void pressNoButtonInDeleteConfirmationModalForOffice() {
        getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_delete_no_button"));
    }
    @Then("the user should see the delete row confirmation modal in the office locations")
    public void verifyDeleteConfirmationModal() {
    	getEditOfficePage().verifyDeleteConfirmationModalForLocation();
    }

    @Then("the user should return to edit office locations page mode")
    public void verifyOfficeLocationsEditPageMode(){
        getEditOfficePage().verifyOfficeLocationsEditPageMode();
    }

    @Then("the user should see the area dropdown with $areaDropDown selected")
    public void verifyAreaDropdownNull(@Named("areaDropDown") String areaDropDown) {
        getEditOfficePage().verifyAreaDropdownNull(areaDropDown);
    }

    @Then("the user should see the subarea dropdown with $subAreaDropDown selected")
    public void verifySubAreaDropdownNull(@Named("subAreaDropDown") String subareaDropDown) {
        getEditOfficePage().verifySubAreaDropdownNull(subareaDropDown);
    }

    @Then("the user should see the city dropdown with $cityDropDown selected")
    public void verifyCityDropdownNull(@Named("cityDropDown") String cityDropDown) {
        getEditOfficePage().verifyCityDropdownNull(cityDropDown);
    }

    @Then("the user should see the delete row confirmation modal")
    public void verifyOfficeDeleteConfirmationModal() {
        getEditOfficePage().verifyOfficeDeleteConfirmationModal();
    }

    @When("the user clicks on the $officetype_dropdown in the basicinfo office page")
    public void clickOnNewOfficeTypeDropDown(String officetype_dropdown ){
        getEditOfficePage().clickOnNewOfficeTypeDropDown(officetype_dropdown);
    }

    @When("the user clicks on the add new office type button")
    public void clickOnAddNewOfficeTypeButton()
    {
        getEditOfficePage().clickOnAddNewOfficeTypeButton();
    }
  
    @When("the user selects office type value as <officeTypeValue> from $rowIdentifier in the basicinfo office page")
    public void selectOfficeType(@Named("officeTypeValue") String officeTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getEditOfficePage().selectOfficeType(officeTypeValue,rowIdentifier);
    }
   
    @Then("the user should not see the deleted office type value $officeTypeValue in the $source document and in UI for fid <officeFid>")
    public void verifyOfficeTypeNotPresentInZeusAndInUI(@Named("officeTypeValue") String officeTypeValue,@Named("source") String source,@Named("officeFid") String officeFid)
    {
        getEditOfficePage().verifyOfficeTypeNotPresentInZeusAndInUI(source,officeFid,"type",officeTypeValue);
    }


    @Then("the user should see the $delete_button in disabled state in office types section")
    public void verifyDeleteOfficeTypeButtonStatus(@Named("delete_button") String delete_button)
    {
        getEditOfficePage().verifyDeleteOfficeTypeButtonStatus(delete_button);
    }

    @When("the user clicks on the $deletebutton in office types section")
    public void clickonDeleteOfficeTypeRowButton(String deletebutton)
    {
        getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier(deletebutton));
    }

    @Then("the user should still see the office $dropdown with value $dropdownvalue as office type in office page")
    public void verifyExistingOfficeTypeRow(String dropdown,String dropdownvalue)
    {
        getEditOfficePage().verifyExistingOfficeTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should not see the office $dropdown with value $dropdownvalue in office type in office page")
    public void verifyNoExistingOfficeTypeRow(String dropdown,String dropdownvalue)
    {
        getEditOfficePage().verifyNoExistingOfficeTypeRow(dropdown,dropdownvalue);
    }

    @Then("the user should still see the office $dropdown in the new office type row")
    public void verifyNewOfficeTypeRow(String dropdown)
    {
        getEditOfficePage().verifyNewOfficeTypeRow(dropdown);
    }

    @Then("the user should not see the office $dropdown in the new office type row")
    public void verifyNoNewOfficeTypeRow(String dropdown)
    {
        getEditOfficePage().verifyNoNewOfficeTypeRow(dropdown);
    }

    @When("the user selects to delete all the office type rows except the first one in office types")
    public void deleteAllOfficeTypeRowsExceptRow1()
    {
        getEditOfficePage().deleteAllOfficeTypeRowsExceptRow1();
    }

    @Then("the user should see the error message for the required office type field in the basic info office page")
    public void verifyErrorMsgRequiredForOfficeType(){
        getEditOfficePage().verifyErrorMsgRequiredForOfficeType();
    }

    @When("the user enters null value for all the office type rows")
    public void enterNullValueForAllOfficeTypeRows()
    {
        getEditOfficePage().enterNullValueForAllOfficeTypeRows();
    }

    @Then("the user should see the $office_rowIdentifier values in office's section from lookup $lookup")
    public void verifyOfficesNameTypesFromLookup(@Named("offices_rowIdentifier") String offices_rowIdentifier,@Named("lookup") String lookup) {
        getEditOfficePage().verifyOfficesNameTypesFromLookup(offices_rowIdentifier,lookup);
    }

    @Then("the user should see the office name values as in $source document with fid <officeFid>")
    public void verifyEditOfficeNameValuesFromTrusted(@Named("officeFid") String officeFid,@Named("source") String source){
        getEditOfficePage().verifyEditOfficeNameValuesFromTrusted(officeFid,source);
    }

    @When("the user selects office name type $officeNameTypeRowIdentifier value as <type>")
    public void selectOfficeNameType(@Named("officeNameTypeRowIdentifier") String officeNameTypeRowIdentifier,@Named("type") String type1)
    {
        getEditOfficePage().selectOfficeNameType(officeNameTypeRowIdentifier,type1);
    }

    @When("the user enters office name value $officeNameValueRowIdentifier as <value>")
    public void enterOfficeNameValue(@Named("officeNameValueRowIdentifier") String officeNameValueRowIdentifier,@Named("value") String value1)
    {
        getEditOfficePage().enterOfficeNameValue(officeNameValueRowIdentifier,value1);
    }

    @Then("the user should see officename values as <type><value> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeNameValuesExistInZeusandinUI(@Named("type") String type,@Named("value") String value,@Named("officeFid") String officeFid,@Named("source") String source){

        getEditOfficePage().verifyEditOfficeNameValuesExistInZeusandinUI(type,value,officeFid,source);
    }

    @When("the user clicks on delete office names row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeNamesRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeNamesRowButton(deletebutton_Row);
    }
    @Then("the user should see the error message $errorMsg for the office name value field")
    public void verifyOfficeNameValueErrorMessage(@Named("errorMsg") String errorMsg)
    {
        getEditOfficePage().verifyOfficeNameValueErrorMessage("office_name_value_error_msg_xpath",errorMsg);
    }

    @Then("the user should not see officename values for fid <officeFid> in $source document as: $names")
    public void verifyEditOfficeNameValuesNotExistInZeus(@Named("officeFid") String officeFid,@Named("source") String source,@Named("names") ExamplesTable names)
    {
        getEditOfficePage().verifyEditOfficeNameValuesNotExistInZeus(officeFid,source,names);
    }

    @Then("the user should not see the new office name row with $dropdown")
    public void verifyNoNewOfficeNameRow(String dropdown)
    {
        getEditOfficePage().verifyNoNewOfficeNameRow(dropdown);
    }

    @Then("the user should not see the delete button for legal title in names for office")
    public void verifyDeleteButtonForOfficeLegalTitle() {
        getEditOfficePage().verifyDeleteButtonForOfficeLegalTitle();
    }


    @Then("the user verifies the office name value maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthOfficeNameValueText(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeNameValueText(maxSize,rowIdentifier);}


    @Then("the user verifies the office name sort name maxlength as $maxSize for the sortName field")
    public void verifyMaxlengthOfficeNameSortNameText(@Named("maxSize") String maxSize){getEditOfficePage().verifyMaxlengthOfficeNameSortNameText(maxSize);}


    @When("the user enters sort name as $sortName in the office name")
    public void entersSortNameInOfficeName(@Named("sortName") String sortName){
        getEditOfficePage().entersSortNameInOfficeName(sortName);
    }

    @Then("the user should see the edits to office sort name as <sortName> for fid <officeFid> in zeus document and in UI")
    public void verifyOfficeSortNameInZeusDocumentAndInUI(@Named("officeFid") String officeFid,@Named("sortName") String sortName) {
        getEditOfficePage().verifyOfficeSortNameInZeusDocumentAndInUI(officeFid,sortName);
    }
    
    @Then("the user should see the office's identifier values same as in $source document")
	public void verifyOfficeIdentifierValuesFromTrustedDB(@Named("source") String source, @Named("officeFid") String officeFid) { 		 
    	
    	getEditOfficePage().verifyOfficeIdentifierValuesFromTrustedDB(source, officeFid);
	}
    
    @When("the user clicks on the add new identifier button in the office identifier page")
    public void clickOnOfficeAddNewIdentifierButton() {
    	getEditOfficePage().clickOnOfficeAddNewIdentifierButton();
	} 
    
    @Then("the user should see the office identifier types from lookup THIRD_PARTY_IDENTIFIER_OFFICE")
	public void verifyOfficeIdentifierTypesList() {
    	getEditOfficePage().verifyOfficeIdentifierTypesList();
	}
    
    @Then("the user should see the office identifier status from lookup STATUS")
	public void verifyOfficeIdentifierStatusList() {
    	getEditOfficePage().verifyOfficeIdentifierStatusList();
	}
    
    @When("the user deletes the existing office identifier rows")
    public void deleteAllOfficeIdentifiers() {
    	setEditCityPage(getDataPage().createEditCityPage());
    	getEditCityPage().deleteAllIdentifierRows();
	} 
    
	@When("the user enters identifier type as <identifierType> in the office identifier page")
	public void enterOfficeIdentifierType(@Named("identifierType") String identifierType) {
		getEditOfficePage().enterOfficeIdentifierType(identifierType, 1);
	}

	@When("the user enters identifier value as <identifierValue> in the office identifier page")
	public void enterOfficeIdentifierValue(@Named("identifierValue") String identifierValue) {
		getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 1);
	}

	@When("the user enters identifier status as <identifierStatus> in the office identifier page")
	public void enterOfficeIdentifierStatus(@Named("identifierStatus") String identifierStatus) {
		getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 1);
	}

	@Then("the user verifies that previously selected <identifierType> is not present in the new office identifier row")
	public void verifySelectedOfficeIdentifierTypeNotInNewRow(@Named("identifierType") String identifierType) {
		getEditOfficePage().verifySelectedOfficeIdentifierTypeNotInNewRow(identifierType, 2);
	}

	@When("the user enters identifier type as <newIdentifierType> in the office identifier page")
	public void editOfficeIdentifierType(@Named("newIdentifierType") String identifierType) {
		getEditOfficePage().enterOfficeIdentifierType(identifierType, 1);
	}

	@When("the user enters identifier value as <newIdentifierValue> in the office identifier page")
	public void editOfficeIdentifierValue(@Named("newIdentifierValue") String identifierValue) {
		getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 1);
	}

	@When("the user enters identifier status as <newIdentifierStatus> in the office identifier page")
	public void editOfficeIdentifierStatus(@Named("newIdentifierStatus") String identifierStatus) {
		getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 1);
	}

	@When("the user enters identifier type as <identifierType2> in the office identifier page")
	public void enterOfficeIdentifierType2(@Named("identifierType2") String identifierType) {
		getEditOfficePage().enterOfficeIdentifierType(identifierType, 2);
	}

	@When("the user enters identifier value as <identifierValue2> in the office identifier page")
	public void enterOfficeIdentifierValues2(@Named("identifierValue2") String identifierValue) {
		getEditOfficePage().enterOfficeIdentifierValue(identifierValue, 2);
	}

	@When("the user enters identifier status as <identifierStatus2> in the office identifier page")
	public void enterOfficeIdentifierStatus2(@Named("identifierStatus2") String identifierStatus) {
		getEditOfficePage().enterOfficeIdentifierStatus(identifierStatus, 2);
	}

	@Then("the user should see the successful update message at top of the office page")
	public void verifySuccessfulUpdatedMessage() {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user verifies that the identifiers parameters are entered in the office identifiers page")
	public void verifyOfficeIdentifierParametersInUI(@Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {

		String[] identifierTypes = { identifierType, identifierType2 };
		String[] identifierValues = { identifierValue, identifierValue2 };
		String[] identifierStatusValues = { identifierStatus, identifierStatus2 };

		getEditOfficePage().verifyOfficeIdentifierParametersInUI(identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user should see the office identifier values as in $source document")
	public void verifyOfficeIdentifierValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus,
			@Named("identifierType2") String identifierType2, @Named("identifierValue2") String identifierValue2,
			@Named("identifierStatus2") String identifierStatus2) {

		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);
		identifierTypes.add(identifierType2);
		identifierValues.add(identifierValue2);
		identifierStatusValues.add(identifierStatus2);

		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user should not see the newly added identifier row in the office identifiers page")
	@Alias("the user should not see the identifier row in the office identifiers page")
	public void verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowIsNotDisplayed();
	}

	@Then("the user verifies that no values are entered in $source document for office identifiers")
	public void verifyOfficeIdentifierRowValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("identifierType") String identifierType,
			@Named("identifierValue") String identifierValue, @Named("identifierStatus") String identifierStatus) {
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);

		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user verifies that office identifier values are updated in $source document")
	public void verifyOfficeIdentifierRowValuesAreUpdatedInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("newIdentifierType") String identifierType,
			@Named("newIdentifierValue") String identifierValue,
			@Named("newIdentifierStatus") String identifierStatus) {
		List<String> identifierTypes = new ArrayList<>();
		List<String> identifierValues = new ArrayList<>();
		List<String> identifierStatusValues = new ArrayList<>();
		identifierTypes.add(identifierType);
		identifierValues.add(identifierValue);
		identifierStatusValues.add(identifierStatus);

		getEditOfficePage().verifyOfficeIdentifierValuesFromDB(source, officeFid, identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user verifies existing offices identifiers parameters are updated with new office identifiers")
	public void verifyOfficeIdentifierParametersInUI(@Named("newIdentifierType") String identifierType,
			@Named("newIdentifierValue") String identifierValue,
			@Named("newIdentifierStatus") String identifierStatus) {

		String[] identifierTypes = { identifierType };
		String[] identifierValues = { identifierValue };
		String[] identifierStatusValues = { identifierStatus };

		getEditOfficePage().verifyOfficeIdentifierParametersInUI(identifierTypes, identifierValues,
				identifierStatusValues);
	}

	@Then("the user should see maximum length of office identifier value is limited to $maxLength")
	public void verifyMaxLengthInOfficeIdentifierValue(@Named("maxLength") String maxLength) {
		getEditOfficePage().verifyMaxLengthInOfficeIdentifierValue(maxLength);
	}

	@Then("the user should see the error message $errorMessage for identifier type field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierType(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierType(errorMessage);
	}

	@Then("the user should see the error message $errorMessage for identifier value field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierValue(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierValue(errorMessage);
	}

	@Then("the user should see the error message $errorMessage for identifier status field in the office identifiers page")
	public void verifyErrorMessageForRequiredOfficeIdentifierStatus(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForRequiredOfficeIdentifierStatus(errorMessage);
	}

	@Then("the user verifies that the deleted row for office identifier does not exist in $source document")
	public void verifyOfficeIdentifierRowNotPresentInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid) {
		getEditOfficePage().verifyIdentifierRowNotPresentInZeusDB(source, officeFid);
	}

	@When("the user clicks on the delete identifier row button in the office identifiers page")
	public void clickOnDeleteNewOfficeIdentifierRowButton() {
		getEditOfficePage().clickOnDeleteNewOfficeIdentifierRowButton();
	}

	@Then("the user should see the newly added identifier row in the office identifiers page")
	public void verifyNewlyAddedOfficeIdentifierRowIsDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficeIdentifierRowIsDisplayed();
	}

	@When("the user clicks on the add new personnel button in the office personnel page")
    public void clickOnOfficeAddNewPersonnelButton() {
		getEditOfficePage().clickOnOfficeAddNewPersonnelButton();
	}
	
	@Then("the user should see the office personnel types from lookup PERSONNEL_SUMMARY_TEXT_TYPE")
	public void verifyOfficePersonnelTypesList() {
    	getEditOfficePage().verifyOfficePersonnelTypesList();
	}
	
	@When("the user enters personnel type as <personnelType> in the office personnel page")
	public void enterOfficePersonnelType(@Named("personnelType") String personnelType) {
		getEditOfficePage().enterOfficePersonnelTypeInNewlyAddedRow(personnelType);
	}

	@When("the user enters personnel value as <personnelValue> in the office personnel page")
	public void enterOfficePersonnelValue(@Named("personnelValue") String personnelValue) {
		getEditOfficePage().enterOfficePersonnelValueInNewlyAddedRow(personnelValue);
	}
	
	@When("the user enters personnel type as <personnelType2> in the office personnel page")
	public void enterOfficePersonnelType2(@Named("personnelType2") String personnelType) {
		getEditOfficePage().enterOfficePersonnelTypeInNewlyAddedRow(personnelType);
	}

	@When("the user enters personnel value as <personnelValue2> in the office personnel page")
	public void enterOfficePersonnelValue2(@Named("personnelValue2") String personnelValue) {
		getEditOfficePage().enterOfficePersonnelValueInNewlyAddedRow(personnelValue);
	}
	
	@Then("the user should see the office's personnel values same as in $source document")
	public void verifyOfficePersonnelValuesFromDB(@Named("source") String source, @Named("officeFid") String officeFid) {
    	getEditOfficePage().verifyOfficePersonnelValuesFromTrustedDB(source, officeFid);
	}
	
	@When("the user deletes the existing office personnel rows")
    public void deleteAllOfficePersonnel() {
		setEditLegalEntityPage(getLegalEntityPage().createEditLegalEntityPage());
		getEditOfficePage().clickOnOfficeAddNewPersonnelButton();
		getEditLegalEntityPage().deleteAllLegalEntityRows(OfficeIdentifiers.getObjectIdentifier("office_delete_personnel_row_button_xpath"));
	}
	
	@Then("the user verifies that previously selected <personnelType> is not present in the new office personnel row")
	public void verifySelectedOfficePersonnelTypeNotInNewRow(@Named("personnelType") String personnelType) {
		getEditOfficePage().verifySelectedOfficePersonnelTypeNotInNewRow(personnelType, 2);
	}
	
	@Then("the user verifies that the personnel parameters are present in the office identifiers page")
	public void verifyOfficePersonnelParametersInUI(@Named("personnelType") String personnelType, 
					@Named("personnelValue") String personnelValue, @Named("personnelType2") String personnelType2, 
					@Named("personnelValue2") String personnelValue2) {

		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);
		personnelTypes.add(personnelType2);
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(personnelValue);
		personnelValues.add(personnelValue2);
		
		getEditOfficePage().verifyOfficePersonnelParametersInUI(personnelTypes, personnelValues);
	}
	
	@Then("the user verifies that the personnel parameters with 10000 characters are present in the office identifiers page")
	public void verifyOfficePersonnelParametersInUI(@Named("personnelType2") String personnelType) {

		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);		
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(getEditOfficePage().getBigStringValue());		
		
		getEditOfficePage().verifyOfficePersonnelParametersInUI(personnelTypes, personnelValues);
	}

	@Then("the user should see the office personnel values as in $source document")
	public void verifyOfficePersonnelValuesFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid, 
			@Named("personnelType") String personnelType, @Named("personnelValue") String personnelValue, 
			@Named("personnelType2") String personnelType2, @Named("personnelValue2") String personnelValue2) {

		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);
		personnelTypes.add(personnelType2);
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(personnelValue);
		personnelValues.add(personnelValue2);

		getEditOfficePage().verifyOfficePersonnelValuesFromDB(source, officeFid, personnelTypes, personnelValues);
	}
		
	@Then("the user verifies that the existing personnel parameters are updated in the office identifiers page")
	public void verifyUpdatedOfficePersonnelParametersInUI(@Named("personnelType") String personnelType,
			@Named("personnelValue") String personnelValue) {

		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(personnelValue);
		
		getEditOfficePage().verifyOfficePersonnelParametersInUI(personnelTypes, personnelValues);
	}
	
	@Then("the user should see the updated office personnel values as in $source document")	
	public void verifyUpdatedOfficePersonnelValuesFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid,
			@Named("personnelType") String personnelType, @Named("personnelValue") String personnelValue) {

		List<String> personnelTypes = new ArrayList<>();
		personnelTypes.add(personnelType);
		List<String> personnelValues = new ArrayList<>();
		personnelValues.add(personnelValue);

		getEditOfficePage().verifyOfficePersonnelValuesFromDB(source, officeFid, personnelTypes, personnelValues);
	}
	
	@Then("the user verifies that no personnel values are updated in $source document")
	public void verifyOfficePersonnelValuesAreDeletedFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid) {
		getEditOfficePage().verifyOfficePersonnelValuesFromDB(source, officeFid, null, null);
	}
	
	
	@Then("the user should not see the newly added personnel row in the office personnel page")
	public void verifyNewlyAddedOfficePersonnelRowIsNotDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficePersonnelRowIsNotDisplayed();
	}
	
	@Then("the user should see the error message $errorMessage for personnel value field in the office personnel page")
	public void verifyErrorMessageForPersonnelValue(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForPersonnelValue(errorMessage);
	}
	
	@When("the user enters 10000 characters in the office personnel value text area")
    public void enterOfficePersonnelValue() {
        getEditOfficePage().enterOfficePersonnelValue();
    }
	
	@Then("the user should see the office personnel value text area field length as 10000")
    public void verifyOfficePersonnelValueTextAreaLength() {
        getEditOfficePage().verifyOfficePersonnelValueTextAreaLength();
    }
	
	@Then("the user should see the office personnel value text with 10000 characters for fid <officeFid> in $source document")
    public void verifyPersonnelValueWithMaxLengthFromDB(@Named("personnelType2") String personnelType, 
    		@Named("officeFid") String officeFid, @Named("source") String source) {
        getEditOfficePage().verifyPersonnelValueWithMaxLengthFromZeus(personnelType, officeFid, source);
    }
	
	@Then("the user should see the error message $errorMessage for personnel type field in the office personnel page")
	public void verifyErrorMessageForPersonnelType(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForPersonnelType(errorMessage);
	}
	
	@When("the user clicks on the delete personnel row button in the office personnel page")
	public void clickOnDeleteOfficePersonnelRowButton() {
		getEditOfficePage().clickOnDeleteOfficePersonnelRowButton();
	}
	
	@Then("the user should see the newly added personnel row in the office personnel page")
	public void verifyNewlyAddedOfficePersonnelRowIsDisplayed() throws Exception {
		getEditOfficePage().verifyNewlyAddedOfficePersonnelRowIsDisplayed();
	}
	
	@Then("the user should see the office's business hours value same as in $source document")
	public void verifyOfficeBusinessHourValueFromTrustedDB(@Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeBusinessHourValueFromTrustedDB(officeFid, source);
	}

	@When("the user enters the <businessHour> in the office business hour text area")
	public void enterOfficeBusinessHourText(@Named("businessHour") String businessHour) {
		getEditOfficePage().enterOfficeBusinessHourText(businessHour);
	}

	@Then("the user should be able to verify the values are entered in the office business hour field")
	public void verifyOfficeBusinessHourTextInUI(@Named("businessHour") String businessHour) {
		getEditOfficePage().verifyOfficeBusinessHourTextInUI(businessHour);
	}

	@Then("the user should see the office business hours value same as in $source document")
	public void verifyOfficeBusinessHourValueFromZeusDB(@Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeBusinessHourValueFromZeusDB(officeFid, source);
	}

	@When("the user enters 200 unicode characters in the office business hours field")
	public void enterMaximumCharactersInOfficeBusinessHours() {
		getEditOfficePage().enterMaximumCharactersInOfficeBusinessHours();
	}

	@Then("the user should be able to view that only 200 unicode characters are saved in office business hours")
	public void viewOfficeBusinessHoursValidCharacterLength() {
		getEditOfficePage().viewOfficeBusinessHoursValidCharacterLength();
	}
	
	@Then("the user verifies business hours max length attribute is $maxLength")
	public void verifyOfficeBusinessHoursMaxLenghtAttribute(@Named("maxLength") String maxLength) {
		getEditOfficePage().verifyOfficeBusinessHoursMaxLenghtAttribute(maxLength);
	}

	@Then("the user should see the Office History value in office page is same as per $source document")
	public void verifyOfficeHistoryFromTrustedDB(@Named("officeFid") String officeFid, @Named("source") String source) {
		getEditOfficePage().verifyOfficeHistoryFromTrustedDB(source, "officeHistory", officeFid);
	}

	@Then("the user should see the statistics values same as in $source document for fid <officeFid>")
	public void verifyEditOfficeStatisticsValueFromTrusted(@Named("officeFid") String fid,
			@Named("source") String source) throws InterruptedException {
		Map<String, String> inputParameters = new HashMap<String, String>();
		inputParameters.put("fid", fid);
		inputParameters.put("source", source);

		getEditOfficePage().verifyEditOfficeStatisticsValueFromTrusted("numberOfAtms",
				getDataPage().getTagValueFromDB("get office statistics values", "numberOfAtms", inputParameters));
		getEditOfficePage().verifyEditOfficeStatisticsValueFromTrusted("numberOfCheckingAccounts",
				getDataPage().getTagValueFromDB("get office statistics values", "numberOfCheckingAccounts", inputParameters));
		getEditOfficePage().verifyEditOfficeStatisticsValueFromTrusted("numberOfSavingsAccounts",
				getDataPage().getTagValueFromDB("get office statistics values", "numberOfSavingsAccounts", inputParameters));
	}

	@When("the user enters <officeHistory> value in Office page")
	public void enterOfficeHistory(@Named("officeHistory") String officeHistory) {
		getEditOfficePage().enterOfficeHistory(officeHistory);
	}

	@Then("the user should see the entered <officeHistory> in Office page")
	public void verifyOfficeHistory(@Named("officeHistory") String officeHistory) {
		getEditOfficePage().verifyOfficeHistory(officeHistory);
	}

	@Then("the user should see the entered Office History in $source document")
	public void verifyOfficeHistoryZeus(@Named("officeFid") String officeFid, @Named("source") String source) {
		getEditOfficePage().verifyOfficeHistoryZeus(source, "officeHistory", officeFid);
	}

	@When("the user enters values which is beyond 10000 unicode characters in the Office History field")
	public void enterCharactersInOfficeHistory() {
		getEditOfficePage().enterCharactersInOfficeHistory();
	}

	@Then("the user should see maximum length of office history is limited to $maxLength")
	public void verifyMaxLengthOfficeHistory(@Named("maxLength") String maxLength) {
		getEditOfficePage().verifyMaxLengthOfficeHistory(maxLength);
	}

	@Then("the user should be able to view that only 10000 unicode characters are saved in Office History field")
	public void verifyValidCharacterLengthOfficeHistory() {
		getEditOfficePage().verifyValidCharacterLengthOfficeHistory();
	}

	@Then("the user should be able to verify the maximum values are entered in the Office History field")
	public void verifyMaximumTextInOfficeHistory() {
		getEditOfficePage().verifyMaximumTextInOfficeHistory();
	}

	@When("the user enters the office total atms value as <totalAtms>")
	public void enterOfficeTotalAtmsValue(@Named("totalAtms") String totalAtms) {
		getEditOfficePage().enterValueInStatisticsPageTextField("office_total_atms_xpath", totalAtms);
	}

	@When("the user enters the office total checking accounts value as <totalCheckingAccounts>")
	public void enterOfficeTotalCheckingAccountsValue(@Named("totalCheckingAccounts") String totalCheckingAccounts) {
		getEditOfficePage().enterValueInStatisticsPageTextField("office_total_checking_accounts_xpath",
				totalCheckingAccounts);
	}

	@When("the user enters the office total savings accounts value as <totalSavingsAccounts>")
	public void enterOfficeTotalSavingsAccountsValue(@Named("totalSavingsAccounts") String totalSavingsAccounts) {
		getEditOfficePage().enterValueInStatisticsPageTextField("office_total_savings_accounts_xpath",
				totalSavingsAccounts);
	}

	@Then("the user verifies the office statistics field values are updated in Office Page")
	public void verifyOfficeStatisticsValueInUI(@Named("totalAtms") String totalAtms,
			@Named("totalCheckingAccounts") String totalCheckingAccounts,
			@Named("totalSavingsAccounts") String totalSavingsAccounts) throws InterruptedException {
		getEditOfficePage().verifyOfficeStatisticsValueInUI(totalAtms, totalCheckingAccounts, totalSavingsAccounts);
	}

	@Then("the user verifies the office statistics values are updated in $source document for fid <officeFid>")
	public void verifyOfficeStatisticsUpdatedValuesFromZeus(@Named("officeFid") String fid, @Named("source") String source,
			@Named("totalAtms") String totalAtms, @Named("totalCheckingAccounts") String totalCheckingAccounts,
			@Named("totalSavingsAccounts") String totalSavingsAccounts) {
		Map<String, String> inputParameters = new HashMap<String, String>();
		inputParameters.put("fid", fid);
		inputParameters.put("source", source);

		getEditOfficePage().verifyOfficeStatisticsValueFromZeus("numberOfAtms", totalAtms,
				getDataPage().getTagValueFromDB("get office statistics values", "numberOfAtms", inputParameters));
		getEditOfficePage().verifyOfficeStatisticsValueFromZeus("numberOfCheckingAccounts",
				totalCheckingAccounts, getDataPage().getTagValueFromDB("get office statistics values", "numberOfCheckingAccounts", inputParameters));
		getEditOfficePage().verifyOfficeStatisticsValueFromZeus("numberOfSavingsAccounts",
				totalCheckingAccounts, getDataPage().getTagValueFromDB("get office statistics values", "numberOfSavingsAccounts", inputParameters));
	}

	@Then("the user verifies office statistics page fields max length attribute is $maxLength")
	public void verifyAreaTimeZoneSummaryMaxLenghtAttribute(@Named("maxLength") String maxLength,
			@Named("totalAtms") String totalAtms, @Named("totalCheckingAccounts") String totalCheckingAccounts,
			@Named("totalSavingsAccounts") String totalSavingsAccounts) {
		getEditOfficePage().verifyOfficeStatisticsFieldsMaxLengthAttribute(maxLength, totalAtms, totalCheckingAccounts,
				totalSavingsAccounts);
	}

	@Then("the user should see the $errorMessage error message for the total atms field in the office statistics page")
	public void verifyErrorMessageForTotalAtms(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForTotalAtm(errorMessage);
	}

	@Then("the user should see the $errorMessage error message for the total checking accounts field in the office statistics page")
	public void verifyErrorMessageForTotalCheckingAccounts(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForTotalCheckingAccounts(errorMessage);
	}

	@Then("the user should see the $errorMessage error message for the total savings account field in the office statistics page")
	public void verifyErrorMessageForTotalSavingsAccount(@Named("errorMessage") String errorMessage) {
		getEditOfficePage().verifyErrorMessageForTotalSavingsAccount(errorMessage);
	}
	
	@Then("the user should see the office's service's values are same as in $source document")
	public void verifyEditOfficeServiceValueFromTrusted(@Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficesServicesFromTrusted(officeFid, source);
	}

	@Then("the user should see the office service category dropdown values from lookup SERVICE_CATEGORY")
	public void verifyOfficeServiceCategoryFromLookup() {
		getEditOfficePage().verifyOfficeServiceCategoryFromLookup();
	}	

	@When("the user clicks on the add button for adding new services for office page")
	public void clickOnAddServicesButton() {
		getEditOfficePage().clickOnAddServicesButton();
	}
	
	@When("the user deletes all service rows in office page")
	public void deleteAllRows() {
		getEditOfficePage().clickOnAddServicesButton();
		getDataPage().deleteAllRows(OfficeIdentifiers.getObjectIdentifier("office_services_delete_button_xpath"));
	}	

	@When("the user selects <serviceCategory> type in the services for office page")
	public void selectsServiceCategoryTypeFromDropdown(@Named("serviceCategory") String serviceCategory) {
		getEditOfficePage().selectsServiceCategoryTypeFromDropdown(serviceCategory, 1);
	}

	@When("the user updates <serviceCategory> type in the services for office page")
	public void selectsServicesCategoryTypeFromDropdown(@Named("serviceCategory") String serviceCategory) {
		getEditOfficePage().selectsExistingServiceCategoryTypeFromDropdown(serviceCategory);
	}

	@When("the user enters <serviceOverride> value  in the text box for office page")
	public void enterServiceOverrideValue(@Named("serviceOverride") String serviceOverride) {
		getEditOfficePage().enterServiceOverrideValue(serviceOverride, 1);
	}

	@Then("the user verifies that previously selected <serviceCategory> is not displayed in second row")
	public void verifySelectedOfficeServiceCategoryNotInNewRow(@Named("serviceCategory") String serviceCategory) {
		getEditOfficePage().verifySelectedOfficeServiceCategoryNotInNewRow(serviceCategory, 2);
	}

	@When("the user selects <serviceCategory2> type in the services for office page")
	public void selectsServiceCategoryTypeFromDropdown2(@Named("serviceCategory2") String serviceCategory2) {
		getEditOfficePage().selectsServiceCategoryTypeFromDropdown(serviceCategory2, 2);
	}

	@When("the user enters <serviceOverride2> value  in the text box for office page")
	public void enterServiceOverrideValue2(@Named("serviceOverride2") String serviceOverride2) {
		getEditOfficePage().enterServiceOverrideValue(serviceOverride2, 2);
	}

	@Then("the user should see the Office Services values updated in office services page")
	public void verifyOfficeServiceParametersInUI(@Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride, @Named("serviceCategory2") String serviceCategory2,
			@Named("serviceOverride2") String serviceOverride2) {
		String[] serviceCategoryValues = { serviceCategory, serviceCategory2 };
		String[] serviceOverrideValues = { serviceOverride, serviceOverride2 };
		getEditOfficePage().verifyOfficeServiceParametersInUI(serviceCategoryValues, serviceOverrideValues);
	}

	@Then("the user should see maximum length of office service value is limited to $maxLength")
	public void verifyMaxLengthOfficeService(@Named("maxLength") String maxLength) {
		getEditOfficePage().verifyMaxLengthInServiceOverride(maxLength);
	}

	@Then("the user should see error message for the required office Service Category field in office page")
	public void verifyErrorMsgRequiredForOfficeServiceCategory() {
		getEditOfficePage().verifyErrorMsgRequiredForOfficeServiceCategory();
	}

	@Then("the user should see the Office Services values are updated in office services page")
	public void verifyOfficeServiceParameters2InUI(@Named("serviceCategory2") String serviceCategory2,
			@Named("serviceOverride2") String serviceOverride2) {
		String[] serviceCategoryValues = { serviceCategory2 };
		String[] serviceOverrideValues = { serviceOverride2 };
		getEditOfficePage().verifyOfficeServiceParametersInUI(serviceCategoryValues, serviceOverrideValues);
	}

	@When("the user selects <serviceCategory2> type in the services office page")
	public void selectsServiceCategoryFromDropdown2(@Named("serviceCategory2") String serviceCategory2) {
		getEditOfficePage().selectsServiceCategoryTypeFromDropdown(serviceCategory2, 1);
	}

	@When("the user enters <serviceOverride2> value  in the text box for service office page")
	public void enterServiceOverrideText2(@Named("serviceOverride2") String serviceOverride2) {
		getEditOfficePage().enterServiceOverrideValue(serviceOverride2, 1);
	}

	@When("the user clicks on the delete services row button in the office services page")
	public void clickOnDeleteNewOfficeServiceRowButton() {
		getEditOfficePage().clickOnDeleteNewOfficeServicesRowButton();
	}

	@Then("the user should not see the deleted Office Services values in office services page")
	public void verifyOfficeServicesParametersNotInUI(@Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		getEditOfficePage().verifyOfficeServicesParametersNotInUI(serviceCategory, serviceOverride);
	}

	@Then("the user should see Office Services values are updated in office services page")
	public void verifyOfficeServicesParameterInUI(@Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		String[] serviceCategoryValues = { serviceCategory };
		String[] serviceOverrideValues = { serviceOverride };
		getEditOfficePage().verifyOfficeServiceParametersInUI(serviceCategoryValues, serviceOverrideValues);
	}

	@Then("the user should see the <serviceCategory> <serviceOverride> values updated in $source document")
	public void verifyOfficeServiceValuesAreUpdatedInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		List<String> serviceCategoryValues = new ArrayList<>();
		List<String> serviceOverrideValues = new ArrayList<>();
		serviceCategoryValues.add(serviceCategory);
		serviceOverrideValues.add(serviceOverride);
		getEditOfficePage().verifyOfficeServiceValuesAreUpdatedInZeusDB(source, officeFid, serviceCategoryValues,
				serviceOverrideValues);
	}

	@Then("the user should see the user should see the  Office Services values updated in $source document")
	public void verifyOfficeMultipleServiceValuesAreUpdatedInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride, @Named("serviceCategory2") String serviceCategory2,
			@Named("serviceOverride2") String serviceOverride2) {
		List<String> serviceCategoryValues = new ArrayList<>();
		List<String> serviceOverrideValues = new ArrayList<>();
		serviceCategoryValues.add(serviceCategory);
		serviceCategoryValues.add(serviceCategory2);
		serviceOverrideValues.add(serviceOverride);
		serviceOverrideValues.add(serviceOverride2);
		getEditOfficePage().verifyOfficeServiceValuesAreUpdatedInZeusDB(source, officeFid, serviceCategoryValues,
				serviceOverrideValues);
	}

	@Then("the user should see the <serviceCategory> <serviceOverride> values not updated in $source document")
	public void verifyOfficeServiceValuesAreNotUpdatedInZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		List<String> serviceCategoryValues = new ArrayList<>();
		List<String> serviceOverrideValues = new ArrayList<>();
		serviceCategoryValues.add(serviceCategory);
		serviceOverrideValues.add(serviceOverride);
		getEditOfficePage().verifyOfficeServiceValuesAreUpdatedInZeusDB(source, officeFid, serviceCategoryValues,
				serviceOverrideValues);
	}

	@Then("the user should see the <serviceCategory2> <serviceOverride2> values updated in $source document")
	public void verifyOfficeServiceValuesAreUpdatedInZeusDB2(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		List<String> serviceCategoryValues = new ArrayList<>();
		List<String> serviceOverrideValues = new ArrayList<>();
		serviceCategoryValues.add(serviceCategory);
		serviceOverrideValues.add(serviceOverride);
		getEditOfficePage().verifyOfficeServiceValuesAreUpdatedInZeusDB(source, officeFid, serviceCategoryValues,
				serviceOverrideValues);
	}

	@Then("the user should see Office Services values are updated in Edit office services page")
	public void verifyOfficeServicesParameterInEditUI(@Named("serviceCategory") String serviceCategory,
			@Named("serviceOverride") String serviceOverride) {
		getEditOfficePage().verifyOfficeServicesParametersInEditUI(serviceCategory, serviceOverride);
	}
	
	@Then("the user should see Office Services values are updated as blank in office services page")
	public void verifyBlankOfficeServicesParameterInUI() {
		getEditOfficePage().verifyBlankOfficeServices(); 
	}
	
	@When("the user deletes the existing office telecom locations rows")
	public void deleteExistingTelecomLocationRows() {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_telecoms_addRow_id"));
		getDataPage().deleteAllRows(OfficeIdentifiers.getObjectIdentifier("office_row_telecoms_delete_button"));
	}
	
	@Then("the user should see the error message <errorText> for the office telecom value field")
    public void verifyOfficeTelecomErrorMessage(@Named("errorText") String errorText) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_value_error_msg", errorText);
    }
	
	@Then("the user should see the newly added telecom row in the office locations telecom page")
	public void verifyNewlyAddedOfficeTelecomRowIsDisplayed() throws Exception {
		getDataPage().verifyRowIsDisplayed(OfficeIdentifiers.getObjectIdentifier("office_telecom_rows_edit_mode"), true);
	}
	
	@Then("the user verifies that the office telecom fields for Type(telephone/fax) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("type") String Type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("countryCode") String countryCode,
			@Named("areaCode") String areaCode, @Named("number") String number, @Named("rangeLimit") String rangeLimit,
			@Named("ext") String ext, @Named("textAfter") String textAfter) {
		String Value = countryCode + "-" + areaCode + "-" + number;
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(rank, textBefore, Value, rangeLimit, ext, textAfter, null);
	}
	
	@Then("the user verifies that the office telecom fields for Type(telex/reuters/cable) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("type") String type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("textAfter") String textAfter,
			@Named("answerBack") String answerBack, @Named("value") String value) {
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(rank, textBefore, value, null, null, textAfter,	answerBack);
	}
	
	@Then("the user verifies that the office telecom fields for Type(email/website) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("type") String type, @Named("rank") String rank,
			@Named("textBefore") String textBefore, @Named("textAfter") String textAfter, @Named("value") String value) {
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(rank, textBefore, value, null, null, textAfter, null);
	}
	
	@When("the user deletes the existing office $locationType locations values in $documentType document")
	public void deleteExistingLocationValues(@Named("officeFid") String officeFid, @Named("locationType") String locationType, @Named("documentType") String documentType) {
		getEditOfficePage().deleteExistingLocationValues(officeFid, locationType, documentType);
	}
	
	@Then("the user should see the primary flag value same as in $source document")
	public void primaryFlagValueFromTrustedDB(@Named("source") String source, @Named("officeFid") String officeFid) {
		getEditOfficePage().verifyPrimaryFlagValueFromTrustedDB(source, officeFid);
	}
	
	@When("the user selects <primaryFlag1> for office locations second primary flag")
	public void selectPrimaryFlagTrueValue(@Named("primaryFlag1") String primaryFlag1) {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_second_location_true_primary_flag"));
		getEditOfficePage().getAddressLine1ValueForPrimaryFlag();
	}
	
	@Then("the user verifies the true primary flag is not editable")
	public void verifySelectedPrimaryFlagNotEditable() {
		getEditOfficePage().verifySelectedPrimaryFlagNotEditable();
	}
	
	@Then("the user verifies that <primaryFlag1> is updated in UI")
	public void verifyPrimaryFlagIsTrue(@Named("primaryFlag1") String primaryFlag1) {
		getEditOfficePage().verifyPrimaryFlagInUI(primaryFlag1);
	}
	
	@Then("the user verifies <primaryFlag2> is saved for other location")
	public void verifyPrimaryFlagIsFalse(@Named("primaryFlag2") String primaryFlag2) {
		getEditOfficePage().verifyPrimaryFlagInUI(primaryFlag2);
	}
	
	@Then("the user verifies the primary flag values in $source document")
	public void primaryFlagValueFromZeusDB(@Named("source") String source, @Named("officeFid") String officeFid) {
		getEditOfficePage().primaryFlagValueFromZeusDB(source, officeFid);
	}
	
	@Then("the user should verify the postal code position is updated in Office web page")
	public void verifyPostalCodePositionInUI(@Named("postalCodePosition") String postalCodePosition) {

		getEditOfficePage().verifypostalCodePositonInUI(postalCodePosition);
	}

	@Then("the user should verify postal code position is $source document")
	public void verifyPostalCodePositionInZeus(@Named("Country") String country,
			@Named("postalCodePosition") String postalCodePosition, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		Map<String, String> inputParameters = new HashMap<String, String>();
		inputParameters.put("officeFid", officeFid);
		inputParameters.put("source", source);
		inputParameters.put("Country", country);
		assertEquals(postalCodePosition,
				getDataPage().getTagValueFromDB("get Office Locations", "postalCodePos", inputParameters));
		assertEquals(postalCodePosition, getDataPage().getTagValueFromDB("get postalCodePos from countryDoc",
				"postalCodePosition", inputParameters));

	}

	@Then("the user should verify the postal code position should be null in office web page")
	public void verifyPostalCodePositionNullInUI(@Named("postalCodePosition") String postalCodePosition) {

		getEditOfficePage().verifypostalCodePositonInUI(postalCodePosition);
	}

	@Then("the user should verify postal code position should be blank in $source document")
	public void verifyPostalCodePositionBlankInZeus(@Named("Country") String country,
			@Named("postalCodePosition") String postalCodePosition, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		Map<String, String> inputParameters = new HashMap<String, String>();
		inputParameters.put("officeFid", officeFid);
		inputParameters.put("source", source);
		inputParameters.put("Country", country);

		assertNotEquals(postalCodePosition,
				getDataPage().getTagValueFromDB("get Office Locations", "postalCodePos", inputParameters));
		assertNotEquals(postalCodePosition, getDataPage().getTagValueFromDB("get postalCodePos from countryDoc",
				"postalCodePosition", inputParameters));
	}
	
	@Then("the user should see the locations summary value same as in $source document")
	public void verifyLocationsSummaryValuesFromTrustedDB(@Named("source") String source, @Named("officeFid") String officeFid) {
		getEditOfficePage().verifyLocationsSummaryValuesFromTrustedDB(source, officeFid);
	}
	
	@When("the user clicks on the add new summary button in the office locations page")
	public void clickOnAddSummaryRow() {
		getDataPage().attemptClick(OfficeIdentifiers.getObjectIdentifier("office_add_locations_summary_row"));
	}
	
	@Then("the user should see the type drop-down values from lookup LOCATION_SUMMARY_TEXT_TYPE")
	public void verifyLocationSummaryTypeFromLookup() {
		getEditOfficePage().verifyLookUpValuesForLocationSummaryType(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_type_dropdown"),
				"get office locations summary type lookup");
	}
	
	@When("the user deletes the existing office locations summary rows")
	public void deleteAllOfficeLocationsSummaryRows() {
		getDataPage().deleteAllRows(OfficeIdentifiers.getObjectIdentifier("office_delete_locations_summary_row"));
	}
	
	@When("the user selects the type drop-down value as <type> in the office locations page")
	public void selectOfficeLocationsSummaryType(@Named("type") String type) {
		getDataPage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_type_dropdown"), type, 1);
	}
	
	@When("the user selects the value field as <value> in the office locations page")
	public void enterOfficeLocationsSummaryValueField(@Named("value") String value) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_value"), value, 1);
	}
	
	@Then("the user should not see the newly added summary row in the office locations page")
	public void verifyLocationsSummaryRowNotDisplayed() {
		getDataPage().verifyRowIsDisplayed(OfficeIdentifiers.getObjectIdentifier("office_locations_summary_row_view_mode"), false);
	}
	
	@Then("the user verifies that no values are entered in $source document for office locations summary")
	@Alias("the user verifies that the office locations summary parameters in the $source document")
	public void verifyOfficeIdentifierRowValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("type") String type, @Named("value") String value) {
		List<String> summaryTypes = new ArrayList<>();
		List<String> summaryValues = new ArrayList<>();
		summaryTypes.add(type);
		summaryValues.add(value);
		getEditOfficePage().verifyLocationsSummaryValuesFromDB(source, officeFid, summaryTypes, summaryValues);
	}
	
	@When("the user selects the type drop-down value as <type2> in the office locations page")
	public void selectOfficeLocationsSummaryType2(@Named("type2") String type) {
		getDataPage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_type_dropdown"), type, 2);
	}
	
	@When("the user selects the value field as <value2> in the office locations page")
	public void enterOfficeLocationsSummaryValueField2(@Named("value2") String value) {
		getDataPage().enterTextUsingIndex(OfficeIdentifiers.getObjectIdentifier("office_edit_locations_summary_value"), value, 2);
	}
	
	@Then("the user verifies that the summary parameters are entered in the office locations page")
	public void verifyOfficeLocationsSummaryParametersInUI(@Named("type") String type, @Named("value") String value, @Named("type2") String type2, @Named("value2") String value2) {
		String[] summaryTypes = { type, type2 };
		String[] summaryValues = { value, value2 };
		getEditOfficePage().verifyOfficeLocationsSummaryParametersInUI(summaryTypes, summaryValues);
	}
	
	@Then("the user verifies that the office locations summary parameters are entered in the $source document")
	public void verifyOfficeIdentifierValuesFromZeusDB(@Named("source") String source,
			@Named("officeFid") String officeFid, @Named("type") String type, @Named("value") String value, @Named("type2") String type2, @Named("value2") String value2) {
		List<String> summaryTypes = new ArrayList<>();
		List<String> summaryValues = new ArrayList<>();
		summaryTypes.add(type);
		summaryTypes.add(type2);
		summaryValues.add(value);
		summaryValues.add(value2);
		getEditOfficePage().verifyLocationsSummaryValuesFromDB(source, officeFid, summaryTypes, summaryValues);
	}
	
	@Then("the user verifies existing locations summary parameters are updated with new values")
	public void verifyOfficeIdentifierParametersInUI(@Named("type") String type, @Named("value") String value) {
		String[] summaryTypes = { type };
		String[] summaryValues = { value };
		getEditOfficePage().verifyOfficeLocationsSummaryParametersInUI(summaryTypes, summaryValues);
	}
}