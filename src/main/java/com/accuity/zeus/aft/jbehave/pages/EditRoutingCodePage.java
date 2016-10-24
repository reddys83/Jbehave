package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.commons.collections.ListUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EditRoutingCodePage extends AbstractPage {

    private String office_results_card_xpath = "//*[@id='results']//tr[td='";
    private By office_personnel_link_id = By.id("officePersonnel");
   
    public EditRoutingCodePage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
       super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }
    public void verifyEditRoutingCodeValuesFromTrusted(String routingCode, String codeType) {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
        nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String RoutingCodeType = getNodeValuesByTagName(document, "routingcodeType").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeType").get(0);
        String RoutingCodeTypeDescription =getNodeValuesByTagName(document, "routingcodeDescription").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeDescription").get(0);
        String RoutingCodeSubtype=getNodeValuesByTagName(document, "routingcodeSubtype").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeSubtype").get(0);
        String ABACodeSource=getNodeValuesByTagName(document, "ABACodeSource").size() == 0 ? "" : getNodeValuesByTagName(document, "ABACodeSource").get(0);
        String RoutingCode=getNodeValuesByTagName(document, "routingcodeValue").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeValue").get(0);
        String RoutingCodeCheckDigit=getNodeValuesByTagName(document, "routingcodeCheckDigit").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeCheckDigit").get(0);
        List AlternateCodeFormTypes=getNodeValuesByTagName(document, "alternateCodeFormType");
        List AlternateCodeForms=getNodeValuesByTagName(document, "alternateCodeForm");
        String Status=getNodeValuesByTagName(document, "routingcodeStatus").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeStatus").get(0);
        String AccountEligibility=getNodeValuesByTagName(document, "routingcodeaccountEligibility").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeaccountEligibility").get(0);
        String StartDate=getNodeValuesByTagName(document, "StartDate").size() == 0 ? "" : getNodeValuesByTagName(document, "StartDate").get(0);
        String EndDate=getNodeValuesByTagName(document, "EndDate").size() == 0 ? "" : getNodeValuesByTagName(document, "EndDate").get(0);
        String ForthcomingRetirementDate=getNodeValuesByTagName(document, "ForthcomingRetirementDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ForthcomingRetirementDate").get(0);
        String ConfirmedwithFed=getNodeValuesByTagName(document, "ConfirmedWithFedDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ConfirmedWithFedDate").get(0);
        String AssignedInstitutionName=getNodeValuesByTagName(document, "routingcodeassignedInstitutionName").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeassignedInstitutionName").get(0);
        String RegistrarFeeSFDCSubscription=getNodeValuesByTagName(document, "routingcodeRegistrarFeeSFDCSubscription").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeRegistrarFeeSFDCSubscription").get(0);
        String InternalUseOnly=getNodeValuesByTagName(document, "routingcodeInternalUseOnly").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeInternalUseOnly").get(0);
        String UseHeadOffice=getNodeValuesByTagName(document, "routingcodeUseHeadOffice").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeUseHeadOffice").get(0);
        String Comment=getNodeValuesByTagName(document, "routingcodeComment").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeComment").get(0);
        if(RoutingCodeType.equals("ABA")){
            //assertEquals(RoutingCodeSubtype,getSelectedDropdownValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_routingcode_subtype_dropdown")));
            assertEquals(ABACodeSource,getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ABA_CodeSource_dropdown")));
            assertEquals(ForthcomingRetirementDate.replaceFirst("^0+(?!$)", "").replaceAll(" ",""),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateDay")).getAttribute("value")
                    +getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateMonth"))
                    +getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateYear")).getAttribute("value"));
            assertEquals(ConfirmedwithFed.replaceFirst("^0+(?!$)", "").replaceAll(" ",""),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateDay")).getAttribute("value")
                    +getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateMonth"))
                    +getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateYear")).getAttribute("value"));
            assertEquals(RegistrarFeeSFDCSubscription,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_RegistrarFeeSFDCSubscription")).getAttribute("value"));
            assertEquals(Comment,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_RoutingCodeComment")).getAttribute("value"));
        }
        assertEquals(RoutingCodeType,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeType")).getText());
        assertEquals(RoutingCodeTypeDescription,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeTypeDescription")).getText());
        assertEquals(RoutingCode,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCode")).getText());
        if(!RoutingCodeCheckDigit.equals(""))
        {
        assertEquals(RoutingCodeCheckDigit,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeCheckDigit")).getText());
        }
        assertEquals(Status.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Status")).getText().toLowerCase());
        assertEquals(AccountEligibility.toLowerCase(),getSelectedRadioValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_accountEligibility_radio")).toLowerCase());
        assertEquals(StartDate.replaceFirst("^0+(?!$)", "").replaceAll(" ",""),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateDay")).getAttribute("value")
                +getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateMonth"))
                +getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateYear")).getAttribute("value"));
        assertEquals(EndDate.replaceFirst("^0+(?!$)", "").replaceAll(" ",""),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateDay")).getAttribute("value")
                +getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateMonth"))
                +getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateYear")).getAttribute("value"));
        assertEquals(AssignedInstitutionName,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AssignedInstitutionName")).getText());
        assertEquals(InternalUseOnly.toLowerCase(),getSelectedRadioValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_internalUseOnly_radio")).toLowerCase());
        assertEquals(UseHeadOffice.toLowerCase(),getSelectedRadioValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_useHeadOffice_radio")).toLowerCase());
        for (int i=0;i<AlternateCodeForms.size();i++)
        {
            assertEquals(AlternateCodeFormTypes.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_alternateCode_table")).get(i).findElement(By.xpath("td[1]")).getText());
            assertEquals(AlternateCodeForms.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_alternateCode_table")).get(i).findElement(By.xpath("td[2]")).getText());
        }

    }

	public void verifyRegistrarFeeAndRoutingCodeComment(String registrarFeeSFDCSubscription, String routingCodeComment) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(registrarFeeSFDCSubscription,
				getDriver()
						.findElement(RoutingCodeIdentifiers
								.getObjectIdentifier("edit_routingcode_registarFeeSFDCSubscription_afterSave_xpath"))
						.getText());
		assertEquals(routingCodeComment, getDriver().findElement(
				RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_afterSave_xpath"))
				.getText());

	}

	public String getRegisterFeeAndRoutingCodeFromDB(String source, String routingCode, String codeType) {
		String tagValue = null;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(2000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get routingCode basic info", nvPairs);
			if (document != null) {
				String routingCodeRegisterFeeTagValue = getNodeValuesByTagName(document,
						"routingcodeRegistrarFeeSFDCSubscription").size() == 0 ? ""
								: getNodeValuesByTagName(document, "routingcodeRegistrarFeeSFDCSubscription").get(0);
				String routingCodeCommentTagValue = getNodeValuesByTagName(document, "routingcodeComment").size() == 0
						? "" : getNodeValuesByTagName(document, "routingcodeComment").get(0);
				tagValue = routingCodeRegisterFeeTagValue + " " + routingCodeCommentTagValue;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return tagValue;
	}

	public void verifyRegisterFeeAndRoutingCodeFromZeusDB(String source, String routingCode, String codeType) {
		String registarFeeSFDCSubscriptionInUI = getDriver().findElement(RoutingCodeIdentifiers
				.getObjectIdentifier("edit_routingcode_registarFeeSFDCSubscription_afterSave_xpath")).getText();
		String routingCodeCommentInUI = getDriver().findElement(
				RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_afterSave_xpath"))
				.getText();
		String ResisterFeeAndRoutingCodeCommentInUI = registarFeeSFDCSubscriptionInUI + " " + routingCodeCommentInUI;
		assertEquals(ResisterFeeAndRoutingCodeCommentInUI,
				getRegisterFeeAndRoutingCodeFromDB(source, routingCode, codeType));
	}

	public void enterMaxCharactersInRegisterFeeSubscription() {
		createBigString(30);
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_RegistrarFeeSFDCSubscription"), bigString, 1);
	}

	public void verifyMaxLengthRegisterFeeSubscription(String maxLength) {
		assertEquals(getDriver()
				.findElement(RoutingCodeIdentifiers
						.getObjectIdentifier("edit_routingcode_page_RegistrarFeeSFDCSubscription"))
				.getAttribute("maxlength"), maxLength);
	}

	public void verifyMaximumTextInRegisterFeeSubscription() {
		assertEquals(bigString.subSequence(0, 30),
				getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_registarFeeSFDCSubscription_afterSave_xpath")).getText());
	}

	public void enterMaxCharactersInRoutingCodeComment() {
		createBigString(1000);
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_text_xpath"), bigString, 1);
		
	}

	public void verifyMaxLengthRoutingCodeComment(String maxLength) {
		assertEquals(getDriver()
				.findElement(
						RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_text_xpath"))
				.getAttribute("maxlength"), maxLength);
	}
	
	public void verifyMaximumTextInRoutingCodeComment() {
		assertEquals(bigString.subSequence(0, 1000),
				getDriver().findElement(RoutingCodeIdentifiers
						.getObjectIdentifier("edit_routingcode_routingCodeComment_afterSave_xpath")).getText());
	}
	
	public void verifyRegisterFeeAndRoutingCodeFromTrustedDB(String source, String routingCode, String codeType) {
		String registarFeeSFDCSubscriptionInUI = getDriver().findElement(RoutingCodeIdentifiers
				.getObjectIdentifier("edit_routingcode_registarFeeSFDCSubscription_text_xpath")).getAttribute("value");
		String routingCodeCommentInUI = getDriver().findElement(
				RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_routingCodeComment_afterSave_xpath"))
				.getText();
		String ResisterFeeAndRoutingCodeCommentInUI = registarFeeSFDCSubscriptionInUI + " " + routingCodeCommentInUI;
		assertEquals(ResisterFeeAndRoutingCodeCommentInUI,
				getRegisterFeeAndRoutingCodeFromDB(source, routingCode, codeType));
	}

	public void verifyEditStatusForAlternateCodeForms(){
	assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_existing_alternate_code_type")).isEnabled());
	assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_existing_alternate_code_value")).getAttribute("readonly").equals("true"));
	}
	public void clickOnAddNewAlternateCodeFormButton(){
		attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_add_new_alternate_code"));
	}
	public void selectAlternateCodeType(String value){
		selectItemFromDropdownListByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_new_alternate_code_type"),value);
	}
	public void enterAlternateCodeValue(String codeValue){
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_new_alternate_code_value")).sendKeys(codeValue);
	}


	public void verifyAlternateCodeFormsExistInUI(String alternateCodeType,String alternateCodeValue){

		assertTrue(IsAlternateCodeFormsInUI(alternateCodeType,alternateCodeValue));
	}

	public boolean IsAlternateCodeFormsInUI(String alternateCodeType,String alternateCodeValue){
		List<WebElement> alternateCode_rows_list=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm"));
		boolean flag=false;
		for(int count=0;count<alternateCode_rows_list.size();count++)
		{
			if((alternateCode_rows_list.get(count).getAttribute("title").equals(alternateCodeType)) && (alternateCode_rows_list.get(count).getText().equals(alternateCodeValue)))
			{
				flag=true;
			}
		}
		return flag;
	}

	public void verifyAlternateCodeFormsFromZeusDocument(String routingCode,String codeType)
	{try {
		Thread.sleep(5000L);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
		nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
		nvPairs.add(new BasicNameValuePair("source", "zeus"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List AlternateCodeFormTypes=getNodeValuesByTagName(document, "alternateCodeFormType");
		List AlternateCodeForms=getNodeValuesByTagName(document, "alternateCodeForm");

		for (int i=0;i<AlternateCodeForms.size();i++)
		{
			assertEquals(AlternateCodeFormTypes.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getAttribute("title"));
			assertEquals(AlternateCodeForms.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getText());
		}

	}

	public void checkDeleteButtonStatusForFractionalValue(){
		assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_delete_first_row_alternate_code")).isEnabled());
	}

	public void clickOnDeleteAlternateCodeForm()
	{
		attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_delete_second_row_alternate_code"));
	}

	public void checkForDeletedAlternateCodeFormInZeusApp(String alternateCodeType,String alternateCodeValue)
	{
		assertFalse(IsAlternateCodeFormsInUI(alternateCodeType,alternateCodeValue));
	}

	public void clickYesButtonInDeleteConfirmationModalForRoutingCode(){
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingCode_delete_yes_button_id_click")).click();
		}


	public void verifyRoutingCodeAlternateCodeTypesFromLookup(){

			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("fid", "ROUTING_CODE_ALTERNATE_FORM_TYPE"));
			List<String> dropdownValuesList = returnAllDropDownUnselectedValues(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_new_alternate_code_type"));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get RoutingCode Alternate Code Form Types From Lookup", nvPairs);
			// finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
			List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "routingCodeAlternateFormType"), getAlreadySelectedAlternateCodeTypes("edit_routingcode_alternate_code_type"));
			assertEquals(dropdownValuesList, resultList);

		}


	public List<String> getAlreadySelectedAlternateCodeTypes(String identifier) {
		ArrayList<String> selectedValueList = new ArrayList();
		for (WebElement entityTypeDropDown : getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier(identifier))) {
			Select dropdown = new Select(entityTypeDropDown);
			String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
			selectedValueList.add(selectedValue);
		}
		return selectedValueList;
	}

	public void verifyMaxLengthForAlternateCodeFormValue(String maxLength)
	{
		assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_new_alternate_code_value")).getAttribute("maxlength").equals("20"));
	}

	public void verifyErrorMsgRequiredForAlternateCodeType()
	{
		assertEquals("Required", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_alternate_code_type_error_msg_xpath")).getText());
	}

	public void verifyErrorMsgRequiredForAlternateCodeValue()
	{
		assertEquals("Enter up to 20 valid characters.", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_alternate_code_value_error_msg_xpath")).getText());
	}

}
