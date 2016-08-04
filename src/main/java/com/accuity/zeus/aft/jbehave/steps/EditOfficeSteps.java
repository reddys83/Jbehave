package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    @When("the user selects lead location value <leadLocationflag> in the basicinfo office page")
    public void selectOfficeLeadLocationFlag(@Named("leadLocationflag") String leadLocationflag){
        getEditOfficePage().selectOfficeLeadLocationFlag(leadLocationflag);
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
      public void selectOfficeAddressType(@Named("$typeRowIdentifier") String typeRowIdentifier,@Named("Type") String Type)
    {
        getEditOfficePage().selectOfficeAddressType(typeRowIdentifier,Type);
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
/*
    @When("the user enters the office country <Country> in the type-ahead box")
    public void enterOfficeCountryInTheTypeAheadBox(@Named("Country") String Country)
    {
        getEditOfficePage().enterOfficeCountryInTheTypeAheadBox(Country);
    }
*/
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


    @When("the user clicks on the choose an area option")
    public void clickOnAreaDropdown() {
        getEditOfficePage().clickOnAreaDropdown();
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

    @When("the user clicks on add new office telecoms button in the office locations")
    public void clickOnAddTelecomsRowButton(){
        getEditOfficePage().clickOnAddTelecomsRowButton();
    }

    @When("the user selects office telecoms type $typeRowIdentifier value as <Type>")
    public void selectOfficeTelecomsType(@Named("typeRowIdentifier") String typeRowIdentifier,@Named("Type") String Type)
    {
        getEditOfficePage().selectOfficeTelecomsType(typeRowIdentifier,Type);
    }

    @When("the user enters office telecoms rank $rankRowIdentifier value as <Rank>")
    public void enterOfficeTelecomsRank(@Named("rankRowIdentifier") String rankRowIdentifier,@Named("Rank") String Rank)
    {
        getEditOfficePage().enterOfficeTelecomsRank(rankRowIdentifier,Rank);
    }

    @When("the user enters office telecoms text before $textBeforeRowIdentifier value as <TextBefore>")
    public void enterOfficeTelecomsTextBefore(@Named("textBeforeRowIdentifier") String textBeforeRowIdentifier,@Named("TextBefore") String TextBefore)
    {
        getEditOfficePage().enterOfficeTelecomsTextBefore(textBeforeRowIdentifier,TextBefore);
    }

    @When("the user enters office telecoms value $valueRowIdentifier value as <Value1>")
     public void enterOfficeTelecomsValue1(@Named("valueRowIdentifier") String valueRowIdentifier,@Named("Value1") String Value1)
    {
        getEditOfficePage().enterOfficeTelecomsValue1(valueRowIdentifier,Value1);
    }

    @When("the user enters office telecoms value $valueRowIdentifier value as <Value2>")
    public void enterOfficeTelecomsValue2(@Named("valueRowIdentifier") String valueRowIdentifier,@Named("Value2") String Value2)
    {
        getEditOfficePage().enterOfficeTelecomsValue2(valueRowIdentifier,Value2);
    }

    @When("the user enters office telecoms value $valueRowIdentifier value as <Value3>")
    public void enterOfficeTelecomsValue3(@Named("valueRowIdentifier") String valueRowIdentifier,@Named("Value3") String Value3)
    {
        getEditOfficePage().enterOfficeTelecomsValue3(valueRowIdentifier,Value3);
    }

    @When("the user enters office telecoms range limit $rangeLimitRowIdentifier value as <RangeLimit>")
    public void enterOfficeTelecomsRangeLimit(@Named("rangeLimitRowIdentifier") String rangeLimitRowIdentifier,@Named("RangeLimit") String RangeLimit)
    {
        getEditOfficePage().enterOfficeTelecomsRangeLimit(rangeLimitRowIdentifier,RangeLimit);
    }

    @When("the user enters office telecoms ext $extRowIdentifier value as <Ext>")
       public void enterOfficeTelecomsExt(@Named("extRowIdentifier") String extRowIdentifier,@Named("Ext") String Ext)
    {
        getEditOfficePage().enterOfficeTelecomsExt(extRowIdentifier,Ext);
    }

    @When("the user enters office telecoms text after $textAfterRowIdentifier value as <TextAfter>")
    public void enterOfficeTelecomsTextAfter(@Named("textAfterRowIdentifier") String textAfterRowIdentifier,@Named("TextAfter") String TextAfter)
    {
        getEditOfficePage().enterOfficeTelecomsTextAfter(textAfterRowIdentifier,TextAfter);
    }

    @When("the user enters office telecoms answer back $answerBackRowIdentifier value as <AnswerBack>")
    public void enterOfficeTelecomsAnswerBack(@Named("answerBackRowIdentifier") String answerBackRowIdentifier,@Named("AnswerBack") String AnswerBack)
    {
        getEditOfficePage().enterOfficeTelecomsAnswerBack(answerBackRowIdentifier,AnswerBack);
    }
    @Then("the user should not see the office telecoms row in the locations office page")
    public void verifyOfficeTelecomsRowIsNotDisplayed() throws Exception {
        getEditOfficePage().verifyOfficeTelecomsRowIsNotDisplayed();
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

    @Then("the user should see the $officeaddress_rowIdentifier values in office location's section from lookup $lookup")
    public void verifyOfficeAddressTypesFromLookup(@Named("officeaddress_rowIdentifier") String officeaddress_rowIdentifier,@Named("lookup") String lookup) {
        getEditOfficePage().verifyOfficeAddressTypesFromLookup(officeaddress_rowIdentifier,lookup);
    }

    @Then("the user should see the error message $errorMsg for the office address type field")
    public void verifyOfficeAddressTypeErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_type_error_msg_xpath", errorMsg);

    }
/*
    @Then("the user verifies the office address line 1 maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthAddressLine1Text(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}


    @Then("the user verifies the office address line 2 maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthAddressLine2Text(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}


    @Then("the user verifies the office address line 3 maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthAddressLine3Text(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}

    @Then("the user verifies the office address line 4 maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthAddressLine4Text(@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}

*/
    @Then("the user verifies the $officeAddressField  maxlength is $maxSize for the $rowIdentifier")
    public void verifyMaxlengthOfficeAddressText(@Named("$officeAddressField") String officeAddressField,@Named("maxSize") String maxSize,@Named("rowIdentifier") String rowIdentifier){getEditOfficePage().verifyMaxlengthOfficeAddressText(maxSize,rowIdentifier);}

    @Then("the user should see office address line 1 text value as <AddressLine1> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAddressLine1ValueFromZeusDocumentAndUI(@Named("AddressLine1") String AddressLine1,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAddressLine1ValueFromZeusDocumentAndUI(AddressLine1,officeFid,source);
    }

    @Then("the user should see office address line 2 text value as <AddressLine2> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAddressLine2ValueFromZeusDocumentAndUI(@Named("AddressLine2") String AddressLine2,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAddressLine2ValueFromZeusDocumentAndUI(AddressLine2,officeFid,source);
    }

    @Then("the user should see office address line 3 text value as <AddressLine3> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAddressLine3ValueFromZeusDocumentAndUI(@Named("AddressLine3") String AddressLine3,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAddressLine3ValueFromZeusDocumentAndUI(AddressLine3,officeFid,source);
    }

    @Then("the user should see office address line 4 text value as <AddressLine4> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeAddressLine4ValueFromZeusDocumentAndUI(@Named("AddressLine4") String AddressLine4,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeAddressLine4ValueFromZeusDocumentAndUI(AddressLine4,officeFid,source);
    }

    @Then("the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in $source document and in zeus UI")
    public void getDocumentPrimaryFlag(@Named("primaryFlag") String primaryFlag,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyPrimaryFlagValuefromZeusDocumentAndUI(primaryFlag,officeFid,source);
    }

    @Then("the user should see office postal code value as <postalCode> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficePostalCodeValueFromZeusDocumentAndUI(@Named("postalCode") String postalCode,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficePostalCodeValueFromZeusDocumentAndUI(postalCode,officeFid,source);
    }
    @Then("the user should see office postal code suffix value as <postalCodeSuffix> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficepostalCodeSuffixValueFromZeusDocumentAndUI(@Named("postalCodeSuffix") String postalCodeSuffix,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficepostalCodeSuffixValueFromZeusDocumentAndUI(postalCodeSuffix,officeFid,source);
    }

    @Then("the user should see office locations info value as <Info> for fid <officeFid> in $source document and in zeus UI")
    public void verifyEditOfficeLocationsInfoValueFromZeusDocumentAndUI(@Named("Info") String Info,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeLocationsInfoValueFromZeusDocumentAndUI(Info,officeFid,source);
    }

    @Then("the user should see office country value as <Country> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeLocationsCountryValueFromZeusDocumentAndUI(@Named("Country") String Country,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeLocationsCountryValueFromZeusDocumentAndUI(Country, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should see office area value as <Area> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeLocationsAreaValueFromZeusDocumentAndUI(@Named("Area") String Area,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeLocationsAreaValueFromZeusDocumentAndUI(Area, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should see office area value as <SubArea> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeLocationsSubAreaValueFromZeusDocumentAndUI(@Named("SubArea") String SubArea,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeLocationsSubAreaValueFromZeusDocumentAndUI(SubArea, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should see office city value as <City> for fid <officeFid> in $source document and in UI")
    public void verifyEditOfficeLocationsCityValueFromZeusDocumentAndUI(@Named("City") String City,@Named("officeFid") String officeFid,@Named("source") String source) {
        getEditOfficePage().verifyEditOfficeLocationsCityValueFromZeusDocumentAndUI(City, "type", officeFid, source, "get office basic info");
    }

    @Then("the user should see the error message $errorMsg for the office country field")
    public void verifyOfficeCountryErrorMessage(@Named("errorMsg") String errorMsg) {
        getEditOfficePage().verifyOfficeErrorMessage("office_address_country_error_msg_xpath", errorMsg);

    }
}



