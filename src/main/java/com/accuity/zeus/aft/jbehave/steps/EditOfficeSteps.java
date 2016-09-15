package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;

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
    public void clickOnAddButton(){
        getEditOfficePage().clickAddRowButton();
    }

    @Then("the user should see the $add_button in disabled state in locations section")
    public void verifyAddOfficeLocationButtonStatus(@Named("add_button") String add_button)
    {
        getEditOfficePage().verifyAddOfficeLocationButtonStatus(add_button);
    }


    @Then("the user should see the $delete_button in disabled state in location address section")
    public void verifyDeleteOfficeAddressButtonStatus(@Named("delete_button") String delete_button)
    {
        getEditOfficePage().verifyDeleteOfficeAddressButtonStatus(delete_button);
    }

    @When("the user clicks on delete office locations row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeLocationsRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeLocationsRowButton(deletebutton_Row);
    }

    @Then("the user should not see the office location row in the locations office page")
    public void verifyOfficeLocationRowIsNotDisplayed() throws Exception {
        getEditOfficePage().verifyOfficeLocationRowIsNotDisplayed();
    }


    public void verifyNoNewOfficeLocationRow(String dropdown)
    {
        getEditOfficePage().verifyNoNewOfficeLocationRow(dropdown);
    }

    @When("the user selects primary flag  value <primaryFlag> in the office locations")
    public void selectPrimaryFlag(@Named("primaryFlag") String primaryFlag){
        getEditOfficePage().selectPrimaryFlag(primaryFlag);
    }

    @When("the user clicks on add new office address button in the office locations")
    public void clickOnAddAddressRowButton(){
        getEditOfficePage().clickOnAddAddressRowButton();
    }

    @When("the user selects office address type $typeRowIdentifier value as <Type>")
      public void selectOfficeAddressType(@Named("typeRowIdentifier") String typeRowIdentifier,@Named("Type") String Type)
    {
        getEditOfficePage().selectOfficeAddressType(typeRowIdentifier,Type);
    }

    @When("the user selects office address type $typeRowIdentifier value as <Type1>")
    public void selectOfficeAddressType1(@Named("$typeRowIdentifier") String typeRowIdentifier,@Named("Type1") String Type1)
    {
        getEditOfficePage().selectOfficeAddressType(typeRowIdentifier,Type1);
    }
    @When("the user enters office address address line 1 $addressLine1RowIdentifier value as <AddressLine1>")
    public void enterofficeAddressLine1(@Named("addressLine1RowIdentifier") String addressLine1RowIdentifier,@Named("AddressLine1") String AddressLine1)
    {
        getEditOfficePage().enterofficeAddressLine1(addressLine1RowIdentifier,AddressLine1);
    }
    @When("the user enters office address address line 2 $addressLine2RowIdentifier value as <AddressLine2>")
    public void enterofficeAddressLine2(@Named("addressLine2RowIdentifier") String addressLine2RowIdentifier,@Named("AddressLine2") String AddressLine2)
    {
        getEditOfficePage().enterofficeAddressLine2(addressLine2RowIdentifier,AddressLine2);
    }

    @When("the user enters office address address line 3 $addressLine3RowIdentifier value as <AddressLine3>")
    public void enterofficeAddressLine3(@Named("addressLine3RowIdentifier") String addressLine3RowIdentifier,@Named("AddressLine3") String AddressLine3)
    {
        getEditOfficePage().enterofficeAddressLine3(addressLine3RowIdentifier,AddressLine3);
    }

    @When("the user enters office address address line 4 $addressLine4RowIdentifier value as <AddressLine4>")
    public void enterofficeAddressLine4(@Named("addressLine4RowIdentifier") String addressLine4RowIdentifier,@Named("AddressLine4") String AddressLine4)
    {
        getEditOfficePage().enterofficeAddressLine4(addressLine4RowIdentifier,AddressLine4);
    }

    @When("the user clicks on the choose a country option in the office locations")
    public void clickOnCountryListBox() throws InterruptedException {
        getEditOfficePage().clickOnCountryListBox();
    }

    @When("the user enters the office country <Country> in the type-ahead box")
    public void enterOfficeCountryInTheTypeAheadBox(@Named("Country") String Country) {
        getEditOfficePage().enterOfficeCountryInTheTypeAheadBox(Country);
    }

    @When("the user enters the office city <City> in the type-ahead box")
    public void enterOfficeCityInTheTypeAheadBox(@Named("City") String City) {
        getEditOfficePage().enterOfficeCityInTheTypeAheadBox(City);
    }
    @Then("the user should see the list of all existing area for the selected country by full name in office address")
    public void verifyOfficeAreaList() {
        getEditOfficePage().verifyOfficeAreaList();
    }

    @When("the user clicks on the choose an area option in the office locations")
    public void clickOnAreaListBox() throws InterruptedException {
        getEditOfficePage().clickOnAreaListBox();
    }

    @When("the user enters the office area <Area> in the type-ahead box")
    public void enterOfficeAreaInTypeAhead(@Named("Area") String Area) {
        getEditOfficePage().enterOfficeAreaInTypeAhead(Area);
    }


    @Then("the user should see the list of all existing subarea for the selected area by full name in office address")
    public void verifyOfficeSubAreaList() {
        getEditOfficePage().verifyOfficeSubAreaList(database, apacheHttpClient);
    }


    @When("the user clicks on the choose a subarea option in the office locations")
    public void clickOnSubAreaListBox() throws InterruptedException {
        getEditOfficePage().clickOnSubAreaListBox();
    }
    @When("the user enters the office subarea <subArea> in the type-ahead box")
    public void enterOfficeSubAreaInTypeAhead(@Named("subArea") String subArea) {
        getEditOfficePage().enterOfficeSubAreaInTypeAhead(subArea);
    }
    @Then("the user should see the below office cities for the selected subarea: $cities")
    public void verifyCitiesForSelectedSubArea(ExamplesTable cities) {
        getEditOfficePage().verifyCitiesForSelectedSubArea(cities);
    }

    @Then("the user should see the below office states for the selected country: $areas")
    public void verifyAreaForSelectedCountry(ExamplesTable areas) {
        getEditOfficePage().verifyAreaForSelectedCountry(areas);

    }
    @Then("the user should see the below office cities for the selected area: $cities")
    public void verifyCitiesForSelectedArea(ExamplesTable cities) {
        getEditOfficePage().verifyCitiesForSelectedArea(cities);
    }

    @When("the user clicks on the choose a city option in the office locations")
    public void clickOnCityDropdown() {
        getEditOfficePage().clickOnCityDropdown();
    }

    @Then("the user should see the list of all existing city for the selected area by full name in office address")
    public void verifyOfficeCityList() {
        getEditOfficePage().verifyOfficeCityList();

            }


    @When("the user clicks on delete office address row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeAddressRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeAddressRowButton(deletebutton_Row);
    }

    @Then("the user should not see the office address row in the locations office page")
    public void verifyOfficeAddressRowIsNotDisplayed() throws Exception {
        getEditOfficePage().verifyOfficeAddressRowIsNotDisplayed();
    }

    @Then("the user verifies that the deleted row for office locations does not exist in $source document")
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

	@When("the user selects office telecoms type $typeRowIdentifier value as <Type>")
	public void selectOfficeTelecomsType(@Named("typeRowIdentifier") String typeRowIdentifier, @Named("Type") String Type) {
		getEditOfficePage().selectDropDownValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(typeRowIdentifier), Type, 1);
	}

	@When("the user enters office telecoms rank $rankRowIdentifier value as <Rank>")
	public void enterOfficeTelecomsRank(@Named("rankRowIdentifier") String rankRowIdentifier, @Named("Rank") String Rank) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(rankRowIdentifier), Rank, 1);
	}

	@When("the user enters office telecoms text before $textBeforeRowIdentifier value as <TextBefore>")
	public void enterOfficeTelecomsTextBefore(@Named("textBeforeRowIdentifier") String textBeforeRowIdentifier, @Named("TextBefore") String TextBefore) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(textBeforeRowIdentifier), TextBefore, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <CountryCode>")
	public void enterOfficeTelecomsCountryCode(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("CountryCode") String CountryCode) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), CountryCode, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <AreaCode>")
	public void enterOfficeTelecomsAreaCode(@Named("valueRowIdentifier") String valueRowIdentifier,	@Named("AreaCode") String AreaCode) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), AreaCode, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <Number>")
	public void enterOfficeTelecomsNumber(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("Number") String Number) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), Number, 1);
	}

	@When("the user enters office telecoms range limit $rangeLimitRowIdentifier value as <RangeLimit>")
	public void enterOfficeTelecomsRangeLimit(@Named("rangeLimitRowIdentifier") String rangeLimitRowIdentifier,	@Named("RangeLimit") String RangeLimit) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(rangeLimitRowIdentifier), RangeLimit, 1);
	}

	@When("the user enters office telecoms ext $extRowIdentifier value as <Ext>")
	public void enterOfficeTelecomsExt(@Named("extRowIdentifier") String extRowIdentifier, @Named("Ext") String Ext) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(extRowIdentifier), Ext, 1);
	}

	@When("the user enters office telecoms text after $textAfterRowIdentifier value as <TextAfter>")
	public void enterOfficeTelecomsTextAfter(@Named("textAfterRowIdentifier") String textAfterRowIdentifier, @Named("TextAfter") String TextAfter) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(textAfterRowIdentifier), TextAfter, 1);
	}

	@When("the user enters office telecoms answer back $answerBackRowIdentifier value as <AnswerBack>")
	public void enterOfficeTelecomsAnswerBack(@Named("answerBackRowIdentifier") String answerBackRowIdentifier, @Named("AnswerBack") String AnswerBack) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(answerBackRowIdentifier), AnswerBack, 1);
	}

	@When("the user enters office telecoms value $valueRowIdentifier value as <Value>")
	public void enterOfficeTelecomsValue(@Named("valueRowIdentifier") String valueRowIdentifier, @Named("Value") String Value) {
		getEditOfficePage().selectTexBoxValueFromRowNumber(OfficeIdentifiers.getObjectIdentifier(valueRowIdentifier), Value, 1);
	}
    
    @Then("the user should not see the office telecoms row in the locations office page")
	public void verifyNewlyAddedOfficeTelecomRowIsNotDisplayed() throws Exception {
		getDataPage().verifyElementNotExistInUI(OfficeIdentifiers.getObjectIdentifier("office_locations_telecom_row_view_mode"));
	}

    @Then("the user should not see the newly added locations row in the office locations page")
    public void verifyOfficeLocationsRowIsNotDisplayed() throws Exception {
        getEditOfficePage().verifyOfficeLocationsRowIsNotDisplayed();
    }

    @When("the user enters office address postal code $postalCodeRowIdentifier value as <PostalCode>")
    public void enterOfficeAddressPostalCode(@Named("postalCodeRowIdentifier") String postalCodeRowIdentifier,@Named("PostalCode") String PostalCode)
    {
        getEditOfficePage().enterOfficeAddressPostalCode(postalCodeRowIdentifier,PostalCode);
    }
    @When("the user enters office address postal code suffix $postalCodeSuffixRowIdentifier value as <PostalCodeSuffix>")
    public void enterOfficeAddressPostalCodeSuffix(@Named("postalCodeSuffixRowIdentifier") String postalCodeSuffixRowIdentifier,@Named("PostalCodeSuffix") String PostalCodeSuffix)
    {
        getEditOfficePage().enterOfficeAddressPostalCodeSuffix(postalCodeSuffixRowIdentifier,PostalCodeSuffix);
    }
    @When("the user enters office address info $infoRowIdentifier value as <Info>")
    public void enterOfficeAddressInfo(@Named("infoRowIdentifier") String infoRowIdentifier,@Named("Info") String Info)
    {
        getEditOfficePage().enterOfficeAddressInfo(infoRowIdentifier,Info);
    }
    @When("the user clicks on delete office telecoms row button for the row $deletebutton_Row")
    public void clickonDeleteOfficeTelecomsRowButton(String deletebutton_Row)
    {
        getEditOfficePage().clickonDeleteOfficeTelecomsRowButton(deletebutton_Row);
    }

    @Then("the user should see the $officeaddress_rowIdentifier values in office location's section from lookup $lookup except the values that are selected already")
    public void verifyOfficeAddressTypesFromLookup(@Named("officeaddress_rowIdentifier") String officeaddress_rowIdentifier,@Named("lookupFid") String lookupFid) {
        getEditOfficePage().verifyOfficeAddressTypesFromLookup(officeaddress_rowIdentifier,lookupFid);
    }

    @Then("the user should see the error message $errorMsg for the office address type field")
    public void verifyOfficeAddressTypeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_type_error_msg", errorMsg);

    }

    @Then("the user should see the $officetelecom_rowIdentifier values in office telecoms's section from lookup $lookup")
    public void verifyOfficeTelecomTypesFromLookup(@Named("officetelecom_rowIdentifier") String officetelecom_rowIdentifier, @Named("lookup") String lookup) {
        getDataPage().verifyLookUpValues(OfficeIdentifiers.getObjectIdentifier(officetelecom_rowIdentifier), "get Office Telecoms Types", "officeTelecomTypes");
    }
    
    @Then("the user should see the office telecom values same as in $source document")
	public void verifyOfficeValueFromTrustedDB(@Named("officeFid") String officeFid, @Named("source") String source) {
    	getEditOfficePage().verifyOfficeTelecomValuesFromTrustedDB(officeFid, source);
	}
    
    @Then("the user verifies the $officeField maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthOfficeLocationsText(@Named("$officeField") String officeField,@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){
    	getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);
    }

    @Then("the user verifies that the office address lines addresses are entered in the office locations page")
    public void verifyOfficeAddressLinesAddressesInUI(@Named("Type") String Type,@Named("AddressLine1") String AddressLine1,
                                                      @Named("AddressLine2") String AddressLine2,
                                                      @Named("AddressLine3") String AddressLine3,
                                                      @Named("AddressLine4") String AddressLine4,@Named("PostalCode") String PostalCode,
                                                      @Named("PostalCodeSuffix") String PostalCodeSuffix,@Named("PostalCodePosition") String PostalCodePosition,
                                                      @Named("Info") String Info,@Named("Country") String Country,@Named("Area") String Area,@Named("Subarea") String Subarea,
                                                      @Named("City") String City) {

        getEditOfficePage().verifyOfficeAddressLinesAddressesInUI(Type,AddressLine1, AddressLine2, AddressLine3, AddressLine4,Country,Area,Subarea,City,PostalCode,PostalCodePosition,PostalCodeSuffix,Info);
    }


    @Then("the user should see the office address lines addresses as in $source document")
	public void verifyOfficeAddressLinesAddressesFromDB(@Named("Type") String Type,
			@Named("officeFid") String officeFid, @Named("AddressLine1") String AddressLine1,
			@Named("AddressLine2") String AddressLine2, @Named("AddressLine3") String AddressLine3,
			@Named("AddressLine4") String AddressLine4, @Named("PostalCode") String PostalCode,
			@Named("PostalCodeSuffix") String PostalCodeSuffix, @Named("PostalCodePosition") String PostalCodePosition,
			@Named("Info") String Info, @Named("Country") String Country, @Named("Area") String Area,
			@Named("Subarea") String Subarea, @Named("City") String City, @Named("source") String source) {
		getEditOfficePage().verifyOfficeAddressLinesAddressesFromDB(Type, AddressLine1, AddressLine2, AddressLine3,
				AddressLine4, PostalCode, PostalCodeSuffix, PostalCodePosition, Info, Country, Area, Subarea, City,
				officeFid, source);
	}

    @Then("the user should see the office telecomm fields for Type(telephone/fax) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("CountryCode") String CountryCode,
			@Named("AreaCode") String AreaCode, @Named("Number") String Number, @Named("RangeLimit") String RangeLimit,
			@Named("Ext") String Ext, @Named("TextAfter") String TextAfter, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(Type, Rank, TextBefore, CountryCode, AreaCode, Number,
				RangeLimit, Ext, TextAfter, null, null, officeFid, source);
	}
    
    @Then("the user should see the office telecomm fields for Type(telex/reuters/cable) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("TextAfter") String TextAfter,
			@Named("AnswerBack") String AnswerBack, @Named("Value") String Value, @Named("officeFid") String officeFid,
			@Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(Type, Rank, TextBefore, null, null, null, null, null,
				TextAfter, AnswerBack, Value, officeFid, source);
	}
    
    @Then("the user should see the office telecomm fields for Type(email/website) as in $source document")
	public void verifyOfficeTelecommFieldsFromDB(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("TextAfter") String TextAfter, @Named("Value") String Value,
			@Named("officeFid") String officeFid, @Named("source") String source) {
		getEditOfficePage().verifyOfficeTelecommFieldsFromDB(Type, Rank, TextBefore, null, null, null, null, null, TextAfter, null, Value, officeFid, source);
	}

    @Then("the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in $source document and in zeus UI")
    public void getDocumentPrimaryFlag(@Named("primaryFlag") String primaryFlag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyPrimaryFlagValuefromZeusDocumentAndUI(primaryFlag,officeFid,source);
    }


    @Then("the user should see the error message $errorMsg for the office country field")
    public void verifyOfficeCountryErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_country_error_msg_xpath", errorMsg);

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
        getEditOfficePage().verifyOfficeErrorMessage("office_address_country_error_msg", errorMsg);

    }

    @Then("the user verifies the office $officeTelecomField  maxlength is $maxSize for the $rowIdentifier in the telecom section")
    public void verifyMaxlengthOfficeTelecomsText(@Named("officeTelecomField") String officeTelecomField,@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}


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
        getEditOfficePage().pressNoButtonInDeleteConfirmationModalForOfficeLocation();
    }

    @When("the user clicks on the Yes button to confirm the deletion of row in office locations section")
    public void pressYesButtonInDeleteConfirmationModalForOfficeLocation() {
        getEditOfficePage().pressYesButtonInDeleteConfirmationModalForOfficeLocation();
    }

    @Then("the user verifies that the row values exists in the office locations page")
    public void verifyNewlyAddedOfficeLocationRowExists() {
        getEditOfficePage().verifyNewlyAddedOfficeLocationRowExists();
    }


    @When("the user clicks on the No button to cancel the deletion of row in office locations page")
    public void pressNoButtonInDeleteConfirmationModalForOffice() {
        getEditOfficePage().pressNoButtonInDeleteConfirmationModalForOffice();
    }
    @Then("the user should see the delete row confirmation modal in the office locations")
    public void verifyDeleteConfirmationModal() {
        getEditOfficePage().verifyDeleteConfirmationModal();
    }

    @Then("the user should return to edit office locations page mode")
    public void verifyOfficeLocationsEditPageMode(){
        getEditOfficePage().verifyOfficeLocationsEditPageMode();
    }

    @Then("the user should see the area dropdown with $areaDropDown selected")
    public void verifyAreaDropdownNull(@Named("areaDropDown") String areaDropDown) {
        getEditOfficePage().verifyAreaDropdownNull(areaDropDown);
    }

    @Then("the user should see the subarea dropdown with Choose a subarea selected")
    public void verifySubAreaDropdownNull(@Named("subareaDropDown") String subareaDropDown) {
        getEditOfficePage().verifySubAreaDropdownNull(subareaDropDown);
    }

    @Then("the user should see the city dropdown with Choose a city selected")
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

    @Then("the user should see the $dropdown values from lookup $fid except the values that are selected already in office")
    public void verifyOfficeTypeListFromLookup(String dropdown,String fid){
        getEditOfficePage().verifyOfficeTypeListFromLookup(fid,dropdown);
    }


    @When("the user clicks on the add new office type button")
    public void clickOnAddNewOfficeTypeButton()
    {
        getEditOfficePage().clickOnAddNewOfficeTypeButton();
    }

    @Then("the user should see the officeType value as in $source document with fid <officeFid>")
    public void verifyEditOfficesOfficeTypeValueFromTrusted(@Named("officeFid") String officeFid,@Named("source") String source){
        getEditOfficePage().verifyEditOfficesOfficeTypeValueFromTrusted(officeFid,"type",source);
    }

    @When("the user selects office type value as <officeTypeValue> from $rowIdentifier in the basicinfo office page")
    public void selectOfficeType(@Named("officeTypeValue") String officeTypeValue, @Named("rowIdentifier")String rowIdentifier)
    {
        getEditOfficePage().selectOfficeType(officeTypeValue,rowIdentifier);
    }

    @Then("the user should see officeType value as <officeTypeValue> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficesOfficeTypeValueFromZeusAndInUI(@Named("officeTypeValue") String officeTypeValue,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficesOfficeTypeValueFromZeusAndInUI(officeTypeValue, "type", officeFid, source, "get office basic info");
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
        getEditOfficePage().clickonDeleteOfficeTypeRowButton(deletebutton);
    }

    @Then("the user should still see the office $dropdown with value $dropdownvalue in office type in office page")
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


    @Then("the user verifies the office name sort name maxlength is $maxSize for the sortName")
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
		getDataPage().deleteAllRows(OfficeIdentifiers.getObjectIdentifier("office_first_row_telecoms_delete_button"));
	}
	
	@Then("the user should see the error message <errorText> for the office telecom value field")
    public void verifyOfficeTelecomErrorMessage(@Named("errorText") String errorText) {
        getEditOfficePage().verifyOfficeErrorMessage("office_telecoms_value_error_msg", errorText);
    }
	
	@Then("the user should see the newly added telecom row in the office locations telecom page")
	public void verifyNewlyAddedOfficeTelecomRowIsDisplayed() throws Exception {
		getDataPage().verifyRowIsDisplayed(OfficeIdentifiers.getObjectIdentifier("office_locations_telecom_row_edit_mode"), true);
	}
	
	@Then("the user verifies that the office telecom fields for Type(telephone/fax) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("CountryCode") String CountryCode,
			@Named("AreaCode") String AreaCode, @Named("Number") String Number, @Named("RangeLimit") String RangeLimit,
			@Named("Ext") String Ext, @Named("TextAfter") String TextAfter) {
		String Value = CountryCode + "-" + AreaCode + "-" + Number;
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(Rank, TextBefore, Value, RangeLimit, Ext, TextAfter, null);
	}
	
	@Then("the user verifies that the office telecom fields for Type(telex/reuters/cable) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("TextAfter") String TextAfter,
			@Named("AnswerBack") String AnswerBack, @Named("Value") String Value) {
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(Rank, TextBefore, Value, null, null, TextAfter,	AnswerBack);
	}
	
	@Then("the user verifies that the office telecom fields for Type(email/website) are entered in the office locations page")
	public void verifyOfficeTelecommFieldsInUI(@Named("Type") String Type, @Named("Rank") String Rank,
			@Named("TextBefore") String TextBefore, @Named("TextAfter") String TextAfter, @Named("Value") String Value) {
		getEditOfficePage().verifyOfficeLocationsTelecommFieldsInUI(Rank, TextBefore, Value, null, null, TextAfter, null);
	}
	
	@When("the user deletes the existing office telecom locations values in fdb document")
	public void deleteExistingTelecomLocationValuesInFDBDocument(@Named("officeFid") String officeFid) {
		getEditOfficePage().deleteExistingTelecomLocationValuesInFDBDocument(officeFid);
	}
}
