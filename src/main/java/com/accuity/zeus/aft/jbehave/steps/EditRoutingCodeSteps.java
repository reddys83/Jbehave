package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

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



