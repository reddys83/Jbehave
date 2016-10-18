package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoutingCodePage extends AbstractPage {

    private String office_results_card_xpath = "//*[@id='results']//tr[td='";
    private By office_personnel_link_id = By.id("officePersonnel");


    public RoutingCodePage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
       super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public void verifyRoutingCodeBasicInfoPage(){
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_link")).getAttribute("class").equals("selected"));
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_label")).getText().equals("BASIC INFO"));
    }

    public void verifyRoutingCodeBasicInfoValuesFromTrustedDoc(String routingCode, String codeType) {

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
            assertEquals(RoutingCodeSubtype,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ RoutingCodeSubtype")).getText());
            assertEquals(ABACodeSource,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).getText());
            assertEquals(ForthcomingRetirementDate,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).getText());
            assertEquals(ConfirmedwithFed,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).getText());
            assertEquals(RegistrarFeeSFDCSubscription,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).getText());
            assertEquals(Comment,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String Comment")).getText());
        }
        assertEquals(RoutingCodeType,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeType")).getText());
        assertEquals(RoutingCodeTypeDescription,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeTypeDescription")).getText());
        assertEquals(RoutingCode,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCode")).getText());
        if(!RoutingCodeCheckDigit.equals(""))
        {
        assertEquals(RoutingCodeCheckDigit,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeCheckDigit")).getText());
        }
        assertEquals(Status.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Status")).getText().toLowerCase());
        assertEquals(AccountEligibility.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AccountEligibility")).getText().toLowerCase());
        assertEquals(StartDate,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_StartDate")).getText());
        assertEquals(EndDate,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_EndDate")).getText());
        assertEquals(AssignedInstitutionName,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AssignedInstitutionName")).getText());
        assertEquals(InternalUseOnly.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_InternalUseOnly")).getText().toLowerCase());
        assertEquals(UseHeadOffice.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String UseHeadOffice")).getText().toLowerCase());
        for (int i=0;i<AlternateCodeForms.size();i++)
        {
            assertEquals(AlternateCodeFormTypes.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getAttribute("title"));
            assertEquals(AlternateCodeForms.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getText());
        }

    }

    public void verifyABAFieldsNotExist(){
        try {
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ RoutingCodeSubtype")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_String Comment")).isDisplayed());
        }catch(NoSuchElementException e){}
    }

    public void clickonHeaderLink(){
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_page_header_link"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public EditRoutingCodePage createEditRoutingCodePage() {
        EditRoutingCodePage ERP=null;
        try {
            ERP= new EditRoutingCodePage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
        }
        catch(Exception e)
        {e.printStackTrace();}
        return ERP;
    }
    
    public void verifyFormerUsageColumnNames() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("NAME", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_col")).getText());
		assertEquals("CITY", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_city_col")).getText());
		assertEquals("AREA", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_area_col")).getText());
		assertEquals("ADDITIONAL INFO",	getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_additional_info_col")).getText());	
	}
    
    public void verifyFormerUsagesColumnInOrder(By by, String column, String order) {
		List<WebElement> columnListFromUI = getDriver().findElements(by);
		for (int index = 0; index < (columnListFromUI.size() - 1); index++) {
			if (order.equals("ascending")) {
				if (columnListFromUI.get(index+1).getText().compareTo(columnListFromUI.get(index).getText()) < 0) {
					assertTrue("The " + column + " column is not in " + order + " order.", false);
				}
			} else {
				if (columnListFromUI.get(index+1).getText().compareTo(columnListFromUI.get(index).getText()) > 0) {
					assertTrue("The " + column + " column is not in " + order + " order.", false);
				}
			}
		}
    }
    
    public String getOfficeNameLinkText() {
    	return getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_first_office_name_link")).getText();
    }
    
    public void verifyOfficeNameBasicInfoPage(String formerUsageOfficeName) {
    	assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("officename_basicInfo_link")).getAttribute("class").equals("selected"));
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("officename_basicInfo_label")).getText().equals("BASIC INFO"));
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("officename_text_value")).getText().equals(formerUsageOfficeName));
    }
    
    public void verifyFormerUsagesFieldValuesFromTrustedDB(String routingCode, String routingCodeType, String source) {	
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
    
    public void verifyFormerUsagesFieldValuesFromDB(String routingCode, String routingCodeType, String source, List<String> formerUsagesNames, List<String> formerUsagesCity, List<String> formerUsagesArea, List<String> formerUsagesAdditionalInfo) {
    	try {
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

						switch (document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "name":
							assertEquals(document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), formerUsagesNames.get(i));
							break;
						case "city":
							assertEquals(document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), formerUsagesCity.get(i));
							break;
						case "area":
							assertEquals(document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), formerUsagesArea.get(i));
							break;
						case "addInfo":
							assertEquals(document.getElementsByTagName("formerUsages").item(0).getChildNodes().item(i)
									.getChildNodes().item(childNode).getTextContent(), formerUsagesAdditionalInfo.get(i));
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
    
    public void deleteExistingFormerUsagesValues(String routingCode, String routingCodeType) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			Thread.sleep(3000L);
			apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "delete routing code former usages values", nvPairs);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void insertNewFormerUsagesValues(String routingCode, String routingCodeType) {
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			Thread.sleep(3000L);
			apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "insert routing code former usages values", nvPairs);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void verifyRelatedCodesHeaders()
    {
        assertEquals("RELATED CODES",getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_header")).getText().toUpperCase());
        assertEquals("CONTEXT",getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_context_header")).getText().toUpperCase());
        assertEquals("CODE",getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_code_header")).getText().toUpperCase());
        assertEquals("TYPE",getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_type_header")).getText().toUpperCase());



    }

    public void verifyNoRelatedCodesForRoutingCodes()
    {
        verifyRelatedCodesHeaders();
        try {
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_context")).isDisplayed());

        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void verifyRelatedCodesFromTrusted(String routingCode, String codeType)
    {
        verifyRelatedCodesHeaders();
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
            for (int j=1;j<=document.getFirstChild().getChildNodes().item(i).getChildNodes().getLength();j++)
            {
                assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(j - 1).getTextContent(),
                        getDriver().findElement(By.xpath(".//*[@id='routingCodeRelatedCodes']//tbody/tr["+(i+1)+"]/td["+j+"]")).getText());
            }
        }
    }

    public void clickOnRelatedCodeLink()
    {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_relatedCodes_link"));
    }

}
