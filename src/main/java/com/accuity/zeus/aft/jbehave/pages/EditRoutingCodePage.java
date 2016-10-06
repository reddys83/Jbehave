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
    
    public void verifyRoutingCodeBooleanFieldValuesInUI(String booleanFieldValue) {
    	try {
			Thread.sleep(2000L);
			assertEquals(booleanFieldValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AccountEligibility")).getText().toLowerCase());
			assertEquals(booleanFieldValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_InternalUseOnly")).getText().toLowerCase());
			assertEquals(booleanFieldValue, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String UseHeadOffice")).getText().toLowerCase());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	 
	 }
	 
	 public String verifyRoutingCodeBooleanFieldValuesFromDB(String source, String routingCode, String codeType) {
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
		 assertEquals(booleanFieldValuesInUI, verifyRoutingCodeBooleanFieldValuesFromDB(source, routingCode, codeType));
	 }
	 
	 public void verifyRoutingCodeBooleanFieldValuesFromTrustedDB(String source, String routingCode, String codeType) {
		try {
			    String accountEligibilityFlag = null;
			    String internalUseOnlyFlag = null;
			    String useHeadOfficeFlag = null;
			
				List<WebElement> accountEligibilityFlagOptions = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_accountEligibility_radio"));
				for (int flagIndex = 0; flagIndex < accountEligibilityFlagOptions.size(); flagIndex++) {
					if (accountEligibilityFlagOptions.get(flagIndex).isSelected()) {
						accountEligibilityFlag = accountEligibilityFlagOptions.get(flagIndex).getAttribute("value");
						break;
					}
				}
				
				List<WebElement> internalUseOnlyFlagOptions = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_internalUseOnly_radio"));
				for (int flagIndex = 0; flagIndex < internalUseOnlyFlagOptions.size(); flagIndex++) {
					if (internalUseOnlyFlagOptions.get(flagIndex).isSelected()) {
						internalUseOnlyFlag = internalUseOnlyFlagOptions.get(flagIndex).getAttribute("value");
						break;
					}
				}
				
				List<WebElement> useHeadOfficeFlagOptions = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_useHeadOffice_radio"));
				for (int flagIndex = 0; flagIndex < useHeadOfficeFlagOptions.size(); flagIndex++) {
					if (useHeadOfficeFlagOptions.get(flagIndex).isSelected()) {
						useHeadOfficeFlag = useHeadOfficeFlagOptions.get(flagIndex).getAttribute("value");
						break;
					}
				}
				
				String booleanFieldValuesInUI = accountEligibilityFlag + " " + internalUseOnlyFlag + " " + useHeadOfficeFlag;
				assertEquals(booleanFieldValuesInUI, verifyRoutingCodeBooleanFieldValuesFromDB(source, routingCode, codeType));
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }


}
