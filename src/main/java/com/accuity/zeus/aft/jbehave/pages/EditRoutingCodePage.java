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
import org.openqa.selenium.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
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


	public void verifyEditRoutingCodeRelatedCodeValuesFromTrusted(String routingCode, String codeType) {

		    List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
			nvPairs.add(new BasicNameValuePair("source","trusted"));
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode relatedCodes", nvPairs);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i=0;i<document.getElementsByTagName("relatedCodes").getLength();i++)
			{
				assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(0).getTextContent(),
							getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_relatedcodes_table")).get(i).findElement(By.xpath("td[1]/select/option[@selected='selected']")).getText());
				assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(1).getTextContent(),
						getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_relatedcodes_table")).get(i).findElement(By.xpath("td[2]/input")).getAttribute("value"));
				assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(2).getTextContent(),
						getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_relatedcodes_table")).get(i).findElement(By.xpath("td[3]/input")).getAttribute("value"));
			}
		}

	public void verifyRoutingCodeBooleanFieldValuesInUI(String accountEligibilityValue, String internalUseOnlyValue, String useHeadOfficeValue) {
    	try {
			Thread.sleep(2000L);
			assertEquals(accountEligibilityValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AccountEligibility")).getText().toLowerCase());
			assertEquals(internalUseOnlyValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_InternalUseOnly")).getText().toLowerCase());
			assertEquals(useHeadOfficeValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String UseHeadOffice")).getText().toLowerCase());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	 
	 }
	 
	 public String getRoutingCodeBooleanFieldValuesFromDB(String source, String routingCode, String codeType) {
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
					String accountEligibilityTagValue = getNodeValuesByTagName(document, "routingcodeaccountEligibility").size() == 0 ? ""
							: getNodeValuesByTagName(document, "routingcodeaccountEligibility").get(0);
					String internalUseOnlyTagValue = getNodeValuesByTagName(document, "routingcodeInternalUseOnly").size() == 0 ? ""
							: getNodeValuesByTagName(document, "routingcodeInternalUseOnly").get(0);
					String useHeadOfficeTagValue = getNodeValuesByTagName(document, "routingcodeUseHeadOffice").size() == 0 ? ""
							: getNodeValuesByTagName(document, "routingcodeUseHeadOffice").get(0);
					
					tagValue = accountEligibilityTagValue + " " + internalUseOnlyTagValue + " " + useHeadOfficeTagValue;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return tagValue;
	 }
	 
	 public void verifyRoutingCodeBooleanFieldValuesFromZeusDB(String source, String routingCode, String codeType) {
		 String accountEligibilityValueInUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AccountEligibility")).getText().toLowerCase();
		 String internalUseOnlyValueInUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_InternalUseOnly")).getText().toLowerCase();
		 String useHeadOfficeValueInUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String UseHeadOffice")).getText().toLowerCase();
		 String booleanFieldValuesInUI = accountEligibilityValueInUI + " " + internalUseOnlyValueInUI + " " + useHeadOfficeValueInUI;
		 assertEquals(booleanFieldValuesInUI, getRoutingCodeBooleanFieldValuesFromDB(source, routingCode, codeType));
	 }
	 
	 public void verifyRoutingCodeBooleanFieldValuesFromTrustedDB(String source, String routingCode, String codeType) {
		try {			    
			    String accountEligibilityFlag = getSelectedRadioButtonOption(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_accountEligibility_radio"));
			    String internalUseOnlyFlag = getSelectedRadioButtonOption(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_internalUseOnly_radio"));
			    String useHeadOfficeFlag = getSelectedRadioButtonOption(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_useHeadOffice_radio"));				
				String booleanFieldValuesInUI = accountEligibilityFlag + " " + internalUseOnlyFlag + " " + useHeadOfficeFlag;				
				assertEquals(booleanFieldValuesInUI, getRoutingCodeBooleanFieldValuesFromDB(source, routingCode, codeType));
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public void enterFutureDateForStartDateAndConfirmedDate() throws ParseException {
    	Format formatter = new SimpleDateFormat("MMMM");
		String month = formatter.format(new Date());
		month = month.substring(0, 3);
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateDay"), getDayLaterThanToday(), 1);
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateDay"), getDayLaterThanToday(), 1);
		
		selectDropDownValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateMonth"), month, 1);
		selectDropDownValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateMonth"), month, 1);
		
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateYear"), String.valueOf(Calendar.getInstance().get(Calendar.YEAR)+1), 1);
		selectTexBoxValueFromRowNumber(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateYear"), String.valueOf(Calendar.getInstance().get(Calendar.YEAR)+1), 1);
    }

	public void verifyUpdatedDateFieldsInDB(String routingCode, String codeType, String startDate, String endDate, String forthcomingRetirementDate, String confirmedWithFedDate, String source) {
		try {
			Thread.sleep(1000L);
			List<NameValuePair> nvPairs = new ArrayList<>();
	        nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
	        nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
	        nvPairs.add(new BasicNameValuePair("source", source));	        
	        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);			
			String startDateDB=getNodeValuesByTagName(document, "StartDate").size() == 0 ? "" : getNodeValuesByTagName(document, "StartDate").get(0);
	        String endDateDB=getNodeValuesByTagName(document, "EndDate").size() == 0 ? "" : getNodeValuesByTagName(document, "EndDate").get(0);
	        String forthcomingRetirementDateDB=getNodeValuesByTagName(document, "ForthcomingRetirementDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ForthcomingRetirementDate").get(0);
	        String confirmedwithFedDB=getNodeValuesByTagName(document, "ConfirmedWithFedDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ConfirmedWithFedDate").get(0);
	        if(codeType.equals("ABA")) {
	        	assertEquals(forthcomingRetirementDate.trim(), forthcomingRetirementDateDB.replaceFirst("^0", ""));
		        assertEquals(confirmedWithFedDate.trim(), confirmedwithFedDB.replaceFirst("^0", ""));	
	        }
	        assertEquals(startDate.trim(), startDateDB.replaceFirst("^0", ""));
	        assertEquals(endDate.trim(), endDateDB.replaceFirst("^0", ""));	                
					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyUpdatedDateFieldsInUI(String codeType, String startDate, String endDate, String forthcomingRetirementDate, String confirmedWithFedDate) {
		try {
			 Thread.sleep(1000L);
			 if(codeType.equals("ABA")) {
				 assertEquals(forthcomingRetirementDate.trim(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).getText().replaceFirst("^0", ""));
		         assertEquals(confirmedWithFedDate.trim(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).getText().replaceFirst("^0", ""));							 
			 }
			 assertEquals(startDate.trim(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_StartDate")).getText().replaceFirst("^0", ""));
		     assertEquals(endDate.trim(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_EndDate")).getText().replaceFirst("^0", ""));		     
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	public void changeRoutingCodeStatus(String routingCode, String codeType, String status) {
		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
		nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
		nvPairs.add(new BasicNameValuePair("status", status));
		apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "change routing code status",
				nvPairs);
	}
	
	public void verifyEditRoutingCodeDateFieldsValuesFromTrusted(String routingCode, String codeType, String source) {
		try {
			Thread.sleep(1000L);
		 	List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
			nvPairs.add(new BasicNameValuePair("source", source));	        
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);			
			String startDateDB=getNodeValuesByTagName(document, "StartDate").size() == 0 ? "" : getNodeValuesByTagName(document, "StartDate").get(0);
			String endDateDB=getNodeValuesByTagName(document, "EndDate").size() == 0 ? "" : getNodeValuesByTagName(document, "EndDate").get(0);
			String forthcomingRetirementDateDB=getNodeValuesByTagName(document, "ForthcomingRetirementDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ForthcomingRetirementDate").get(0);
			String confirmedwithFedDB=getNodeValuesByTagName(document, "ConfirmedWithFedDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ConfirmedWithFedDate").get(0);
			if(codeType.equals("ABA")) {
				String forthcomingRetirementDateDayUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateDay")).getAttribute("value");
				String forthcomingRetirementDateMonthUI = getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateMonth"));
				String forthcomingRetirementDateYearUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ForthcomingRetirementDateYear")).getAttribute("value");
				assertEquals((forthcomingRetirementDateDayUI + " " + forthcomingRetirementDateMonthUI + " " + forthcomingRetirementDateYearUI).trim(), forthcomingRetirementDateDB.replaceFirst("^0", ""));
				
				String confirmedwithFedDayUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateDay")).getAttribute("value");
				String confirmedwithFedMonthUI = getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateMonth"));
				String confirmedwithFedYearUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ConfirmedWithFedDateYear")).getAttribute("value");
				assertEquals((confirmedwithFedDayUI + " " + confirmedwithFedMonthUI + " " + confirmedwithFedYearUI).trim(), confirmedwithFedDB.replaceFirst("^0", ""));
			}
			
			String startDateDayUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateDay")).getAttribute("value");
			String startDateMonthUI = getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateMonth"));
			String startDateYearUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_startDateYear")).getAttribute("value");
			assertEquals((startDateDayUI + " " + startDateMonthUI + " " + startDateYearUI).trim(), startDateDB.replaceFirst("^0", ""));
			
			String endDateDayUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateDay")).getAttribute("value");
			String endDateMonthUI = getSelectedDropdownText(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateMonth"));
			String endDateYearUI = getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_endDateYear")).getAttribute("value");
			assertEquals((endDateDayUI + " " + endDateMonthUI + " " + endDateYearUI).trim(), endDateDB.replaceFirst("^0", ""));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public void verifyDropDownFieldValuesFromTrustedDB(String source, String routingCode, String codeType) {
		String routingCodeSubtype = null;
		String ABACodeSource = null;
		List<WebElement> routingCodeSubtypeDropDown = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_routingcode_subtype_dropdown"));
		List<WebElement> ABACodeSourceDropDown = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ABA_CodeSource_dropdown"));

		if(routingCodeSubtypeDropDown.size() > 0 && ABACodeSourceDropDown.size() > 0) {
			routingCodeSubtype = getSelectedOptionInDropDownByIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_routingcode_subtype_dropdown"), 1);
			ABACodeSource = getSelectedOptionInDropDownByIndex(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_ABA_CodeSource_dropdown"), 1);
		} else {
			assertTrue("There is no value in the drop-down field", false);
		}
		verifyDropDownFieldValuesFromDB(source, routingCode, codeType, routingCodeSubtype, ABACodeSource);
	}

	public void verifyDropDownFieldValuesFromDB(String source, String routingCode, String routingCodeType, String routingCodeSubtype, String ABACodeSource) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("source", source));
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			Thread.sleep(3000L);
			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);
			String routingCodeSubtypeDB = getNodeValuesByTagName(document, "routingcodeSubtype").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeSubtype").get(0);
			String ABACodeSourceDB = getNodeValuesByTagName(document, "ABACodeSource").size() == 0 ? "" : getNodeValuesByTagName(document, "ABACodeSource").get(0);

			assertEquals("The Routing Code Subtype value in UI is not same as in " + source +" database", routingCodeSubtype, routingCodeSubtypeDB);
			assertEquals("The ABA Code Source value in UI is not same as in " + source +" database", ABACodeSource, ABACodeSourceDB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLookUpValuesForDropDownFields(By by, String xquery) {
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, xquery);
		List<WebElement> dropDownFieldList = getDriver().findElements(by);
		List<WebElement> options = dropDownFieldList.get(0).findElements(By.cssSelector("option"));
		for (int indexOfOption = 0; indexOfOption < options.size(); indexOfOption++) {
			assertEquals(document.getFirstChild().getChildNodes().item(indexOfOption).getTextContent(), options.get(indexOfOption).getText().trim());
		}
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


	public void verifyRoutingCodeRelatedCodeContextValuesFromLookup(){

		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("fid", "RELATED_CODE_CONTEXT"));
		List<String> dropdownValuesList = returnAllDropDownUnselectedValues(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_context_dropdown"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get related code context values from lookup", nvPairs);
		// finding the list of values from the taxonomy and subtracting the values which are selected in other dropdowns
		List resultList = ListUtils.subtract(getNodeValuesByTagName(document, "routingCodeContextType"), getAlreadySelectedContextTypes("edit_routingcode_page_relatedcodes_context_dropdown"));
		assertEquals(dropdownValuesList, resultList);

	}

	public List<String> getAlreadySelectedContextTypes(String identifier) {
		ArrayList<String> selectedValueList = new ArrayList();
		for (WebElement entityTypeDropDown : getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier(identifier))) {
			Select dropdown = new Select(entityTypeDropDown);
			String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
			selectedValueList.add(selectedValue);
		}
		return selectedValueList;
	}

	public void clickOnAddNewRelatedCode_Btn(){

		attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_add_new_relatedcodes_btn"));
	}

	public void selectRoutingCodeRelatedCodeContextType(String contextType){
		selectItemFromDropdownListByValue(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_context_dropdown"),contextType);
	}


	public void searchAndSelectRelatedCode(String searchCode, String relatedCode)
	{
	attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_link"));
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_input")).sendKeys(searchCode);
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_input")).sendKeys(Keys.RETURN);
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> dropDownOptions=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_dropdown"));
		for (WebElement option:dropDownOptions)
		{
			if (option.getText().equals(relatedCode)){
				option.click();
				break;
			}
		}
	}

	public void searchRelatedCode(String searchCode)
	{
		attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_link"));
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_input")).sendKeys(searchCode);
		getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_input")).sendKeys(Keys.RETURN);
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public void verifyRelatedRoutingcodesFromTrusted(String code)
	{ List<NameValuePair> nvPairs = new ArrayList<>();
		List<String> routingCodeListFromUI=new ArrayList<>();
		List<String> routingCodeListFromTrusted=new ArrayList<>();
		List<String> routingCodeTypeListFromTrusted=new ArrayList<>();
		List<String> routingCodeAndTypeListFromTrusted=new ArrayList<>();

		List<WebElement> dropDownOptions=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_chosen_Select_dropdown"));
		for (WebElement option:dropDownOptions)
		{
			routingCodeListFromUI.add(option.getText());
		}
		code=code.replaceAll("[^a-zA-Z0-9]+","");
		nvPairs.add(new BasicNameValuePair("code", code));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,"get routingCode results for dropdown",nvPairs);
		for(int i=0;i<document.getElementsByTagName("results").getLength();i++) {
			String routingCodeType = document.getElementsByTagName("Type").item(i).getTextContent();
			String routingCode = document.getElementsByTagName("Code").item(i).getTextContent();
			routingCodeListFromTrusted.add(routingCode);
			routingCodeTypeListFromTrusted.add(routingCodeType);

		}

		final Set<String> duplicatesList=findDuplicates(routingCodeListFromTrusted);
		for (int i=0;i<routingCodeListFromTrusted.size();i++)
		{
			if(duplicatesList.contains(routingCodeListFromTrusted.get(i)))
			{
				routingCodeAndTypeListFromTrusted.add(routingCodeListFromTrusted.get(i)+" - "+routingCodeTypeListFromTrusted.get(i));
			}
			else{
				routingCodeAndTypeListFromTrusted.add(routingCodeListFromTrusted.get(i));
			}
		}
		assertEquals(routingCodeListFromUI,routingCodeAndTypeListFromTrusted);
	}


	public Set<String> findDuplicates(List<String> listContainingDuplicates)
	{
		final Set<String> setToReturn = new HashSet();
		final Set<String> set1 = new HashSet();

		for (String str : listContainingDuplicates)
		{
			if (!set1.add(str))
			{
				setToReturn.add(str);
			}
		}
		return setToReturn;
	}



	public void verifyRelatedCodesCodeType(String CodeType){

		assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_new_relatedcodes_type")).getAttribute("value").equals(CodeType));
	}

	public void verifyEditRoutingCodeRelatedCodeValuesFromZeus(String routingCode,String codeType){

		List<NameValuePair> nvPairs = new ArrayList<>();
		nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
		nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
		nvPairs.add(new BasicNameValuePair("source","zeus"));
		Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode relatedCodes", nvPairs);
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i=0;i<document.getElementsByTagName("relatedCodes").getLength();i++)
		{
			for (int j=1;j<=document.getFirstChild().getChildNodes().item(i).getChildNodes().getLength();j++)
			{
				assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(j - 1).getTextContent(),
						getDriver().findElement(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr["+(i+1)+"]/td["+j+"]")).getText());
			}
		}
	}


	public void verifyRoutingCodeRelatedCodeValuesInZeusUI(String relatedCode,String contextType)
	{
		assertTrue(checkRoutingCodeRelatedCodeValuesInZeusUI(relatedCode,contextType));
	}


	public boolean checkRoutingCodeRelatedCodeValuesInZeusUI(String relatedCode,String contextType){

		int noOfRows=getDriver().findElements(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr")).size();
		boolean flag=false;
		for (int i=0;i<noOfRows;i++)
		{
			if(contextType.equals(getDriver().findElement(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr["+(i+1)+"]/td[1]")).getText()) &&
					relatedCode.split("-")[0].trim().equals(getDriver().findElement(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr["+(i+1)+"]/td[2]")).getText())&&
					relatedCode.split("-")[1].trim().equals(getDriver().findElement(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr["+(i+1)+"]/td[3]")).getText())){
				flag=true;
				break;
			}
		}
		return flag;
	}


	public void verifyRoutingCodeRelatedCodeValuesNotExistInZeusUI(String relatedCode,String contextType)
	{
		assertFalse(checkRoutingCodeRelatedCodeValuesInZeusUI(relatedCode,contextType));
	}

	public void clickOnDeleteRelatedCode_Btn(String delete_btn)
	{
		attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("first_row_existing_related_codes_delete_button"));
	}

	public void noResultsMsgForRoutingCode(String searchCode){

		assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_relatedcodes_no_searchResults_msg")).getText().equals("No results for \""+searchCode+"\""));
	}

	public void verifyRequiredMessageForRelatedCodes(By by){
		assertTrue(getDriver().findElement(by).getText().equals("Required"));
	}
	
	public void verifyFormerUsagesFieldValuesFromTrustedDB(String routingCode, String routingCodeType, String source) {
		if (getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_name_list")).size() > 0) {
			List<String> formerUsagesNames = new ArrayList<String>();
			List<String> formerUsagesCity = new ArrayList<String>();
			List<String> formerUsagesArea = new ArrayList<String>();
			List<String> formerUsagesAdditionalInfo = new ArrayList<String>();

			for (int index = 0; index < getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_name_list")).size(); index++) {
				formerUsagesNames.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_name_list")).get(index).getText());
				formerUsagesCity.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_city_list")).get(index).getText());
				formerUsagesArea.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_area_list")).get(index).getText());
				formerUsagesAdditionalInfo.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_former_usages_additional_info_list")).get(index).getText());
			}
			verifyFormerUsagesFieldValuesFromDB(routingCode, routingCodeType, source, formerUsagesNames,
					formerUsagesCity, formerUsagesArea, formerUsagesAdditionalInfo);
		} else {
			assertTrue("There is no existing values in Former Usages section", false);
		}
    }
	
	public void verifyFormerUsagesFieldValuesFromDB(String routingCode, String routingCodeType, String source, List<String> formerUsagesNames, List<String> formerUsagesCity, List<String> formerUsagesArea, List<String> formerUsagesAdditionalInfo) {
    	try {
    		String formerUsagesDBValue;
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get routing code former usages values", nvPairs);
			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("formerUsages").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("formerUsages").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {
						
						formerUsagesDBValue = document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(i)
								.getChildNodes().item(childNode).getTextContent();

						switch (document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "name":
							assertEquals(formerUsagesDBValue, formerUsagesNames.get(i));
							break;
						case "city":
							assertEquals(formerUsagesDBValue, formerUsagesCity.get(i));
							break;
						case "area":
							assertEquals(formerUsagesDBValue, formerUsagesArea.get(i));
							break;
						case "addInfo":
							assertEquals(formerUsagesDBValue, formerUsagesAdditionalInfo.get(i));
							break;
						}
					}
				}
			} else
				assertTrue(source+ "document is null",false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyFormerUsagesFieldValuesFromZeusDB(String routingCode, String routingCodeType, String source) {
		if (getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_list")).size() > 0) {
			List<String> formerUsagesNames = new ArrayList<String>();
			List<String> formerUsagesCity = new ArrayList<String>();
			List<String> formerUsagesArea = new ArrayList<String>();
			List<String> formerUsagesAdditionalInfo = new ArrayList<String>();

			for (int index = 0; index < getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_list")).size(); index++) {
				formerUsagesNames.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_list")).get(index).getText());
				formerUsagesCity.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_city_list")).get(index).getText());
				formerUsagesArea.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_area_list")).get(index).getText());
				formerUsagesAdditionalInfo.add(getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_additional_info_list")).get(index).getText());
			}
			verifyFormerUsagesFieldValuesFromDB(routingCode, routingCodeType, source, formerUsagesNames,
					formerUsagesCity, formerUsagesArea, formerUsagesAdditionalInfo);
		} else {
			assertTrue("There is no existing values in Former Usages section", false);
		}
    }
	
	public void verifyFormerUsagesValuesNotPresentInZeusDB(String routingCode, String routingCodeType, String source) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			nvPairs.add(new BasicNameValuePair("source", source));
			Thread.sleep(3000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get routing code former usages values", nvPairs);
			if (document != null) {
				assertNull(document.getElementsByTagName("name").item(0));
				assertNull(document.getElementsByTagName("city").item(0));
				assertNull(document.getElementsByTagName("area").item(0));
				assertNull(document.getElementsByTagName("addInfo").item(0));
			} else
				assert false : source + " document is null";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
