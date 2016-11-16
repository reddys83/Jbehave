package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

import java.text.ParseException;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditRoutingCodeSteps extends AbstractSteps {

    @When("the user clicks on the routing code update link")
    public void clickOnUpdateRoutingCodeLink() {
        getDataPage().clickOnUpdateCurrencyLink();
        if(editRoutingCodePage==null){
            editRoutingCodePage = getRoutingCodePage().createEditRoutingCodePage();
        }}


	@Then("the user should see the edit routing code values from trusted document for routing code <routingCode> with code type <codeType>")
	public void verifyEditRoutingCodeValuesFromTrusted(@Named("routingCode") String routingCode,
			@Named("codeType") String codeType) {

		getEditRoutingCodePage().verifyEditRoutingCodeValuesFromTrusted(routingCode, codeType);
	}

	@When("the user enters the <registarFeeSFDCSubscription> in the routing code basic info page")
	public void enterTextInRegistarFeeSFDCSubscription(
			@Named("registarFeeSFDCSubscription") String registarFeeSFDCSubscription) {
		getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_RegistrarFeeSFDCSubscription"), registarFeeSFDCSubscription, 1);
	}

	@When("the user enters the <routingCodeComment> in the routing code basic info page")
	public void enterTextInRoutingCodeComment(@Named("routingCodeComment") String routingCodeComment) {
		getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_text_xpath"), routingCodeComment, 1);
	}

	@Then("the user should see the successful update message at top of the routing code page")
	public void verifySuccessfulUpdatedMessage() {
		setEditCityPage(getDataPage().createEditCityPage());
		getEditCityPage().verifySuccessfulUpdatedMessage();
	}

	@Then("the user should be able to verify the values are entered in the routing code basic info page")
	public void verifyRegistrarFeeAndRoutingCodeComment(@Named("routingCodeComment") String routingCodeComment,
			@Named("registarFeeSFDCSubscription") String registarFeeSFDCSubscription) {
		getEditRoutingCodePage().verifyRegistrarFeeAndRoutingCodeComment(registarFeeSFDCSubscription,
				routingCodeComment);
	}

	@Then("the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in $source document")
	public void verifyResisterFeeAndRoutingCodeCommentZeusDB(@Named("source") String source,
			@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
		getEditRoutingCodePage().verifyRegisterFeeAndRoutingCodeFromZeusDB(source, routingCode, codeType);
	}

	@When("the user gets the document with $xqueryName with the <routingCode> and <codeType> from the database")
	public void getDocumentByFid(@Named("xqueryName") String xqueryName, @Named("routingCode") String routingCode,
			@Named("codeType") String codeType) {
		getDataPage().getDocumentForRoutingCode(xqueryName, routingCode, codeType);
	}

	@When("the user enters 30 unicode characters in Registar Fee subscription field")
	public void enterInvalidCharactersInRegisterFeeSubscription() {
		getEditRoutingCodePage().enterMaxCharactersInRegisterFeeSubscription();
	}

	@Then("the user should see maximum length of Registar Fee subscription field is limited to $maxLength")
	public void verifyMaxLengthRegisterFeeSubscription(@Named("maxLength") String maxLength) {
		getEditRoutingCodePage().verifyMaxLengthRegisterFeeSubscription(maxLength);
	}

	@Then("the user should be able to verify the maximum values are entered in Registar Fee subscription field")
	public void verifyMaximumTextInRegisterFeeSubscription() {
		getEditRoutingCodePage().verifyMaximumTextInRegisterFeeSubscription();
	}

	@When("the user enters 1000 unicode characters in Routing Code Comment field")
	public void enterInvalidCharactersInRoutingCodeComment() {
		getEditRoutingCodePage().enterMaxCharactersInRoutingCodeComment();
	}

	@Then("the user should see maximum length of Routing Code Comment field is limited to $maxLength")
	public void verifyMaxLengthRoutingCodeComment(@Named("maxLength") String maxLength) {
		getEditRoutingCodePage().verifyMaxLengthRoutingCodeComment(maxLength);
	}

	@Then("the user should be able to verify the maximum values are entered in Routing Code Comment field")
	public void verifyMaximumTextInRoutingCodeComment() {
		getEditRoutingCodePage().verifyMaximumTextInRoutingCodeComment();
	}
	
	@Then("the user should see <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in $source document")
	public void verifyResisterFeeAndRoutingCodeCommentTrustedDB(@Named("source") String source,
			@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
		getEditRoutingCodePage().verifyRegisterFeeAndRoutingCodeFromTrustedDB(source, routingCode, codeType);
	}
	
	@When("the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field")
    public void enterRoutingCodeStartDateField(@Named("startDateDay") String startDateDay, @Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear) {
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateDay"), startDateDay, 1);
    	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateMonth"), startDateMonth);
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateYear"), startDateYear, 1);
    }

    @When("the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field")
    public void enterRoutingCodeEndDateField(@Named("endDateDay") String endDateDay, @Named("endDateMonth") String endDateMonth, @Named("endDateYear") String endDateYear) {
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateDay"), endDateDay, 1);
    	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateMonth"), endDateMonth);
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateYear"), endDateYear, 1);
    }

    @When("the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field")
    public void enterRoutingCodeForthcomingRetirementDateField(@Named("retirementDay") String retirementDay, @Named("retirementMonth") String retirementMonth, @Named("retirementYear") String retirementYear) {
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateDay"), retirementDay, 1);
    	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateMonth"), retirementMonth);
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateYear"), retirementYear, 1);
    }

    @When("the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field")
    public void enterRoutingCodeConfirmedWithFedField(@Named("fedDay") String fedDay, @Named("fedMonth") String fedMonth, @Named("fedYear") String fedYear) {
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateDay"), fedDay, 1);
    	getDataPage().selectItemFromDropdownListByText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateMonth"), fedMonth);
    	getDataPage().enterTextUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateYear"), fedYear, 1);
    }

    @Then("the user should see the error message <errorMessage> for routing code start date field")
    public void verifyErrorMessageForStartDateField(@Named("errorMessage") String errorMessage) {
    	getDataPage().verifyWebElementText("Routing Code Start Date", errorMessage, RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_StartDate_errorMessage"));
    }

    @Then("the user should see the error message <errorMessage> for routing code end date field")
    public void verifyErrorMessageForEndDateField(@Named("errorMessage") String errorMessage) {
    	getDataPage().verifyWebElementText("Routing Code End Date", errorMessage, RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_EndDate_errorMessage"));
    }

    @Then("the user should see the error message <errorMessage> for routing code forthcoming retirement date field")
    public void verifyErrorMessageForRetirementDateField(@Named("errorMessage") String errorMessage) {
    	getDataPage().verifyWebElementText("Routing Code Forthcoming Retirement Date", errorMessage, RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDate_errorMessage"));
    }

    @Then("the user should see the error message <errorMessage> for routing code confirmed with fed field")
    public void verifyErrorMessageForConfirmedWithFedField(@Named("errorMessage") String errorMessage) {
    	getDataPage().verifyWebElementText("Routing Code Confirmed With Fed", errorMessage, RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDate_errorMessage"));
    }
    
    @When("the user enters start date and confirmed with fed later than today")
    public void enterFutureDateForStartDateAndConfirmedDate() throws ParseException {
    	getEditRoutingCodePage().enterFutureDateForStartDateAndConfirmedDate();
    }
    
    @Then("the user should see that forthcoming retirement date and confirmed with fed fields does not exist")
    public void verifyRetirementDateAndConfirmedWithFedFieldsNotExistInUI() {
    	getDataPage().verifyElementNotExistInUI(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate"));
    	getDataPage().verifyElementNotExistInUI(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed"));
    }

	@Then("the user should see the date field values same as in $source document")
	public void verifyUpdatedDateFieldsInDB(@Named("routingCode") String routingCode, @Named("codeType") String codeType, @Named("startDateDay") String startDateDay, 
			@Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear, @Named("endDateDay") String endDateDay, @Named("endDateMonth") 
	        String endDateMonth, @Named("endDateYear") String endDateYear, @Named("retirementDay") String retirementDay, @Named("retirementMonth") String retirementMonth, 
	        @Named("retirementYear") String retirementYear, @Named("fedDay") String fedDay, @Named("fedMonth") String fedMonth, @Named("fedYear")
	        String fedYear, @Named("source") String source) {
		String startDateDB = startDateDay + " " + startDateMonth + " " + startDateYear;
		String endDateDB = endDateDay  + " " + endDateMonth  + " " + endDateYear;
		String forthcomingRetirementDateDB = retirementDay  + " " + retirementMonth  + " " + retirementYear;
		String confirmedwithFedDB=fedDay  + " " + fedMonth  + " " + fedYear;
        getEditRoutingCodePage().verifyUpdatedDateFieldsInDB(routingCode, codeType, startDateDB, endDateDB, forthcomingRetirementDateDB, confirmedwithFedDB, source);
	}
	
	@Then("the user should see the updated date field values in routing code basic info page")
	public void verifyUpdatedDateFieldsInUI(@Named("codeType") String codeType, @Named("startDateDay") String startDateDay, 
			@Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear, @Named("endDateDay") String endDateDay, @Named("endDateMonth") 
		    String endDateMonth, @Named("endDateYear") String endDateYear, @Named("retirementDay") String retirementDay, @Named("retirementMonth") String retirementMonth, 
		    @Named("retirementYear") String retirementYear, @Named("fedDay") String fedDay, @Named("fedMonth") String fedMonth, @Named("fedYear")
		    String fedYear) {
		String startDateDB = startDateDay + " " + startDateMonth + " " + startDateYear;
		String endDateDB = endDateDay  + " " + endDateMonth  + " " + endDateYear;
		String forthcomingRetirementDateDB = retirementDay  + " " + retirementMonth  + " " + retirementYear;
		String confirmedwithFedDB=fedDay  + " " + fedMonth  + " " + fedYear;
		getEditRoutingCodePage().verifyUpdatedDateFieldsInUI(codeType, startDateDB, endDateDB, forthcomingRetirementDateDB, confirmedwithFedDB);
	}
	
	@Then("the user should see the updated date field values in routing code basic info page for non ABA code type")
	public void verifyUpdatedDateFieldsInUIForNonABA(@Named("codeType") String codeType, @Named("startDateDay") String startDateDay, 
			@Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear, @Named("endDateDay") String endDateDay, @Named("endDateMonth") 
		    String endDateMonth, @Named("endDateYear") String endDateYear) {
		String startDateDB = startDateDay + " " + startDateMonth + " " + startDateYear;
		String endDateDB = endDateDay  + " " + endDateMonth  + " " + endDateYear;	
		getEditRoutingCodePage().verifyUpdatedDateFieldsInUI(codeType, startDateDB, endDateDB, null, null);
	}
	
	@When("the user changes the status for routing code <routingCode> and code type <codeType> to <status>")
	public void changeRoutingCodeStatus(@Named("routingCode") String routingCode, @Named("codeType") String codeType,
			@Named("status") String status) throws Exception {			
			if (editRoutingCodePage == null) {
				editRoutingCodePage = getRoutingCodePage().createEditRoutingCodePage();
			}
			getEditRoutingCodePage().changeRoutingCodeStatus(routingCode, codeType, status);
			getDataPage().refreshThePage();	
			Thread.sleep(5000L);
	}
	
	@Then("the user should see the edit routing code date field values from $source document for routing code <routingCode> with code type <codeType>")
	public void verifyEditRoutingCodeDateFieldsValuesFromTrusted(@Named("routingCode") String routingCode,
			@Named("codeType") String codeType, @Named("source") String source) {
		getEditRoutingCodePage().verifyEditRoutingCodeDateFieldsValuesFromTrusted(routingCode, codeType, source);
	}
	
	@Then("the user should see the date field values same as in $source document for non ABA code type")
	public void verifyUpdatedDateFieldsInDB(@Named("routingCode") String routingCode, @Named("codeType") String codeType, @Named("startDateDay") String startDateDay, 
			@Named("startDateMonth") String startDateMonth, @Named("startDateYear") String startDateYear, @Named("endDateDay") String endDateDay, @Named("endDateMonth") 
	        String endDateMonth, @Named("endDateYear") String endDateYear, @Named("source") String source) {
		String startDateDB = startDateDay + " " + startDateMonth + " " + startDateYear;
		String endDateDB = endDateDay  + " " + endDateMonth  + " " + endDateYear;
        getEditRoutingCodePage().verifyUpdatedDateFieldsInDB(routingCode, codeType, startDateDB, endDateDB, null, null, source);
	}
	
	@When("the user selects <accountEligibilityValue> for routing code account eligibility field")
    public void selectAccountEligibilityFieldAsFalse(@Named("accountEligibilityValue") String accountEligibilityValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_accountEligibility_radio"), accountEligibilityValue);
    }
    
    @When("the user selects <internalUseOnlyValue> for routing code internal use only field")
    public void selectInternalUseOnlyFieldAsFalse(@Named("internalUseOnlyValue") String internalUseOnlyValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_internalUseOnly_radio"), internalUseOnlyValue);
    }
    
    @When("the user selects <useHeadOfficeValue> for routing code use head office field")
    public void selectUseHeadOfficeFieldAsFalse(@Named("useHeadOfficeValue") String useHeadOfficeValue) {
    	getDataPage().selectRadioButtonByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_useHeadOffice_radio"), useHeadOfficeValue);
    }
    
    @Then("the user should be able to verify the boolean field values in routing code basic info page")
    public void verifyRoutingCodeBooleanFieldValuesInUI(@Named("accountEligibilityValue") String accountEligibilityValue, @Named("internalUseOnlyValue") String internalUseOnlyValue, @Named("useHeadOfficeValue") String useHeadOfficeValue) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesInUI(accountEligibilityValue, internalUseOnlyValue, useHeadOfficeValue);
    }
    
    @Then("the user should see the boolean field values same as in $source document")
    public void verifyRoutingCodeBooleanFieldValuesFromZeusDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesFromZeusDB(source, routingCode, codeType);
    }
    
    @Then("the user verifies the boolean field values same as in $source document")
    public void verifyRoutingCodeBooleanFieldValuesFromTrustedDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyRoutingCodeBooleanFieldValuesFromTrustedDB(source, routingCode, codeType);
    }

    @Then("the user verifies that the drop-down field values are same as in $source document")
    public void verifyDropDownFieldValuesFromTrustedDB(@Named("source") String source, @Named("routingCode") String routingCode, @Named("codeType") String codeType) {
    	getEditRoutingCodePage().verifyDropDownFieldValuesFromTrustedDB(source, routingCode, codeType);
    }

    @Then("the user should see the routing code subtype values from lookup ROUTING_CODE_SUBTYPE")
    public void verifyRoutingCodeSubtypeValuesFromLookup() {
    	getEditRoutingCodePage().verifyLookUpValuesForDropDownFields(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_routingcode_subtype_dropdown"), "get routing code subtype lookup");
    }

    @Then("the user should see the ABA code source values from lookup ROUTING_CODE_SOURCE")
    public void verifyABACodeSourceValuesFromLookup() {
    	getEditRoutingCodePage().verifyLookUpValuesForDropDownFields(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ABA_CodeSource_dropdown"), "get ABA code source lookup");
    }

    @When("the user selects the routing code subtype as <routingCodeSubtype> in the routing code basic info page")
    public void selectRoutingCodeSubtypeValue(@Named("routingCodeSubtype") String routingCodeSubtype) {
    	getDataPage().selectDropDownValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_routingcode_subtype_dropdown"), routingCodeSubtype, 1);
    }

    @When("the user selects the ABA code source as <ABACodeSource> in the routing code basic info page")
    public void selectABACodeSourceValue(@Named("ABACodeSource") String ABACodeSource) {
    	getDataPage().selectDropDownValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ABA_CodeSource_dropdown"), ABACodeSource, 1);
    }

    @Then("the user should be able to verify the drop-down field values in routing code basic info page")
    public void verifyDropDownFieldValuesInUI(@Named("routingCodeSubtype") String routingCodeSubtype, @Named("ABACodeSource") String ABACodeSource) throws InterruptedException {
    	Thread.sleep(3000L);
    	getDataPage().verifyWebElementText("Routing Code Subtype", routingCodeSubtype, RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype"));
    	getDataPage().verifyWebElementText("ABA Code Source", ABACodeSource, RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource"));
    }

    @Then("the user should see the drop-down field values same as in $source document")
	public void verifyDropDownFieldValuesFromZeusDB(@Named("source") String source,	@Named("routingCode") String routingCode, @Named("codeType") String codeType,
			@Named("routingCodeSubtype") String routingCodeSubtype, @Named("ABACodeSource") String ABACodeSource) {
		getEditRoutingCodePage().verifyDropDownFieldValuesFromDB(source, routingCode, codeType, routingCodeSubtype,	ABACodeSource);
	}

    @Then("the user should see that the routing code subtype and ABA code source fields does not exist")
    public void verifyDropDownFieldsNotInUI() {
    	getDataPage().verifyElementNotExistInUI(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype"));
    	getDataPage().verifyElementNotExistInUI(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource"));
    }



	@Then("the user verifies that the existing alternate code forms can not be edited")
	public void verifyEditStatusForAlternateCodeForms()
	{
		getEditRoutingCodePage().verifyEditStatusForAlternateCodeForms();
	}

	@Then("the user verifies that the fractional value can not be deleted")
	public void checkDeleteButtonStatusForFractionalValue()
	{
		getEditRoutingCodePage().checkDeleteButtonStatusForFractionalValue();
	}

	@When("the user clicks on the delete alternate code form button")
	public void clickOnDeleteAlternateCodeForm()
	{
		getEditRoutingCodePage().clickOnDeleteAlternateCodeForm();
	}

	@Then("the user should not see the alternate code form values <alternateCodeType> and <alternateCodeValue> in the routing code basic info page")
	public void checkForDeletedAlternateCodeFormInZeusApp(@Named("alternateCodeType") String alternateCodeType,@Named("alternateCodeValue") String alternateCodeValue)
	{
		getEditRoutingCodePage().checkForDeletedAlternateCodeFormInZeusApp(alternateCodeType,alternateCodeValue);
	}
	@When("the user click on add new alternate code form button")
	public void clickOnAddNewAlternateCodeFormButton(){
		getEditRoutingCodePage().clickOnAddNewAlternateCodeFormButton();
	}
	@When("the user selects alternate code form type as <alternateCodeType>")
	public void selectAlternateCodeType(@Named("alternateCodeType") String codeType){
		getEditRoutingCodePage().selectAlternateCodeType(codeType);
	}

	@When("the user enters the alternate code form value as <alternateCodeValue>")
	public void enterAlternateCodeValue(@Named("alternateCodeValue") String codeValue){
		getEditRoutingCodePage().enterAlternateCodeValue(codeValue);
	}

	@Then("the user should see the alternate code form values as <alternateCodeType> and <alternateCodeValue> in the routing code basic info page")
	public void verifyAlternateCodeFormsInUI(@Named("alternateCodeType") String alternateCodeType,@Named("alternateCodeValue") String alternateCodeValue)
	{
		getEditRoutingCodePage().verifyAlternateCodeFormsExistInUI(alternateCodeType,alternateCodeValue);
	}
	@Then("the user should see the alternate code form values same as in zeus document for routing code <routingCode> with code type <codeType>")
			public void verifyAlternateCodeFormsFromZeusDocument(@Named("routingCode") String routingCode,@Named("codeType") String codeType){
		getEditRoutingCodePage().verifyAlternateCodeFormsFromZeusDocument(routingCode,codeType);
	}

	@When("the user clicks on the Yes button to delete a row")
	public void clickYesButtonInDeleteConfirmationModalForRoutingCode() {
		getEditRoutingCodePage().clickYesButtonInDeleteConfirmationModalForRoutingCode();
	}

	@Then("the user should see the alternate code type values from lookup ROUTING_CODE_ALTERNATE_FORM_TYPE except the values that were selected already")
	public void verifyRoutingCodeAlternateCodeTypesFromLookup(){
		getEditRoutingCodePage().verifyRoutingCodeAlternateCodeTypesFromLookup();
	}

	@Then("the user verifies the alternate code form value maxlength is $maxLength characters")
	public void verifyMaxLengthForAlternateCodeFormValue(@Named("maxlength") String maxlength)
	{
		getEditRoutingCodePage().verifyMaxLengthForAlternateCodeFormValue(maxlength);
	}

	@Then("the user should see the error message for the required alternate code type field in the basic info routing code page")
	public void verifyErrorMsgRequiredForAlternateCodeType(){
		getEditRoutingCodePage().verifyErrorMsgRequiredForAlternateCodeType();
	}

	@Then("the user should see the error message for the required alternate code value field in the basic info routing code page")
	public void verifyErrorMsgRequiredForAlternateCodeValue(){
		getEditRoutingCodePage().verifyErrorMsgRequiredForAlternateCodeValue();
	}
}



