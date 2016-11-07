package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.openqa.selenium.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	public void insertNewFormerUsagesValueForOneRow(String routingCode, String routingCodeType) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			Thread.sleep(3000L);
			apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "insert routing code former usages value one row", nvPairs);
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
	
	/*public void verifyFormerUsageColumnNames() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("NAME", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_name_col")).getText());
		assertEquals("CITY", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_city_col")).getText());
		assertEquals("AREA", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_area_col")).getText());
		assertEquals("ADDITIONAL INFO",	getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_additional_info_col")).getText());
	}*/
	
}
