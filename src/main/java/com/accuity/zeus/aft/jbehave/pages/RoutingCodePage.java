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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collections;
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

    public void verifyRoutingCodeBasicInfoPage() {
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_link")).getAttribute("class").equals("selected"));
        assertTrue(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_label")).getText().equals("BASIC INFO"));
    }

    public void verifyRoutingCodeBasicInfoValuesFromTrustedDoc(String routingCode, String codeType) {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("source", "trusted"));
        nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
        nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode basic info", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String RoutingCodeType = getNodeValuesByTagName(document, "routingcodeType").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeType").get(0);
        String RoutingCodeTypeDescription = getNodeValuesByTagName(document, "routingcodeDescription").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeDescription").get(0);
        String RoutingCodeSubtype = getNodeValuesByTagName(document, "routingcodeSubtype").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeSubtype").get(0);
        String ABACodeSource = getNodeValuesByTagName(document, "ABACodeSource").size() == 0 ? "" : getNodeValuesByTagName(document, "ABACodeSource").get(0);
        String RoutingCode = getNodeValuesByTagName(document, "routingcodeValue").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeValue").get(0);
        String RoutingCodeCheckDigit = getNodeValuesByTagName(document, "routingcodeCheckDigit").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeCheckDigit").get(0);
        List AlternateCodeFormTypes = getNodeValuesByTagName(document, "alternateCodeFormType");
        List AlternateCodeForms = getNodeValuesByTagName(document, "alternateCodeForm");
        String Status = getNodeValuesByTagName(document, "routingcodeStatus").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeStatus").get(0);
        String AccountEligibility = getNodeValuesByTagName(document, "routingcodeaccountEligibility").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeaccountEligibility").get(0);
        String StartDate = getNodeValuesByTagName(document, "StartDate").size() == 0 ? "" : getNodeValuesByTagName(document, "StartDate").get(0);
        String EndDate = getNodeValuesByTagName(document, "EndDate").size() == 0 ? "" : getNodeValuesByTagName(document, "EndDate").get(0);
        String ForthcomingRetirementDate = getNodeValuesByTagName(document, "ForthcomingRetirementDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ForthcomingRetirementDate").get(0);
        String ConfirmedwithFed = getNodeValuesByTagName(document, "ConfirmedWithFedDate").size() == 0 ? "" : getNodeValuesByTagName(document, "ConfirmedWithFedDate").get(0);
        String AssignedInstitutionName = getNodeValuesByTagName(document, "routingcodeassignedInstitutionName").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeassignedInstitutionName").get(0);
        String RegistrarFeeSFDCSubscription = getNodeValuesByTagName(document, "routingcodeRegistrarFeeSFDCSubscription").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeRegistrarFeeSFDCSubscription").get(0);
        String InternalUseOnly = getNodeValuesByTagName(document, "routingcodeInternalUseOnly").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeInternalUseOnly").get(0);
        String UseHeadOffice = getNodeValuesByTagName(document, "routingcodeUseHeadOffice").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeUseHeadOffice").get(0);
        String Comment = getNodeValuesByTagName(document, "routingcodeComment").size() == 0 ? "" : getNodeValuesByTagName(document, "routingcodeComment").get(0);
        if (RoutingCodeType.equals("ABA")) {
            assertEquals(RoutingCodeSubtype, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype")).getText());
            assertEquals(ABACodeSource, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).getText());
            assertEquals(ForthcomingRetirementDate, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).getText());
            assertEquals(ConfirmedwithFed, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).getText());
            assertEquals(RegistrarFeeSFDCSubscription, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).getText());
            assertEquals(Comment, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Comment")).getText());
            assertEquals(RoutingCodeType, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeType")).getText());
            assertEquals(RoutingCodeTypeDescription, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeTypeDescription")).getText());
            assertEquals(RoutingCode, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCode")).getText());
            if (!RoutingCodeCheckDigit.equals("")) {
                assertEquals(RoutingCodeCheckDigit, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeCheckDigit")).getText());
            }
            assertEquals(Status.toLowerCase(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Status")).getText().toLowerCase());
            assertEquals(AccountEligibility.toLowerCase(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AccountEligibility")).getText().toLowerCase());
            assertEquals(StartDate, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_StartDate")).getText());
            assertEquals(EndDate, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_EndDate")).getText());
            assertEquals(AssignedInstitutionName, getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AssignedInstitutionName")).getText());
            assertEquals(InternalUseOnly.toLowerCase(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_InternalUseOnly")).getText().toLowerCase());
            assertEquals(UseHeadOffice.toLowerCase(), getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_UseHeadOffice")).getText().toLowerCase());
            for (int i = 0; i < AlternateCodeForms.size(); i++) {
                assertEquals(AlternateCodeFormTypes.get(i), getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getAttribute("title"));
                assertEquals(AlternateCodeForms.get(i), getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getText());
            }

        }
    }

    public void verifyABAFieldsNotExist() {
        try {
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype")).isDisplayed());
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).isDisplayed());
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).isDisplayed());
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).isDisplayed());
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).isDisplayed());
            assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Comment")).isDisplayed());
        } catch (NoSuchElementException e) {
        }
    }

    public LegalEntityPage clickonHeaderLink() {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_page_header_link"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LegalEntityPage(getDriver(), getUrlPrefix(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void clickOnUsagesLink() {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_usages_link"));
    }

    public OfficesPage clickOfficeLinkInUsages(String office) {
        getDriver().findElement(By.xpath(".//*[@id='usages']//td[a='"+office+"']/a")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } return new OfficesPage(getDriver(), getPageUrl(), getDatabase(), getApacheHttpClient(), getRestClient(), getHeraApi());
    }

    public void clickOnUsagesNameColumn() {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_usages_name_column_header_xpath"));
    }

    public void clickOnUsagesCityColumn() {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_usages_city_column_header_xpath"));
    }
    public void clickOnUsagesAreaColumn() {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_usages_area_column_header_xpath"));
    }

    public void verifyRoutingCodeUsagesInView(String routingCode, String codeType) {
        assertEquals(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_usages_header_text")).getText(), "OWNED RANK NAME CITY AREA DESCRIPTION ADDITIONAL INFO");
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", routingCode));
        nvPairs.add(new BasicNameValuePair("codeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode usages", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            for (int j = 1; j <= document.getFirstChild().getChildNodes().item(i).getChildNodes().getLength(); j++) {
                assertEquals(document.getFirstChild().getChildNodes().item(i).getChildNodes().item(j - 1).getTextContent(),getDriver().findElement(By.xpath(".//*[@id='usages']/tr[" + (i + 1) + "]/td[" + j + "]")).getText());
            }
        }
    }

    public void verifyRoutingCodeUsagesDescendingOrderByName(String routingCode, String codeType) {
        List<String> Name = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", routingCode));
        nvPairs.add(new BasicNameValuePair("codeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode usages", nvPairs);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Name.add(document.getElementsByTagName("name").item(i).getTextContent());
        }

        Name.remove(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_owning_usages_name_column_xpath")).getText());
        Collections.sort(Name, Collections.reverseOrder());
        List<WebElement> NameWithoutPrimary = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_NotOwing_usages_name_column_xpath"));

        for (int j=0;j<Name.size();j++)
        {
            assertEquals(Name.get(j),NameWithoutPrimary.get(j).getText());
        }
    }

    public void verifyRoutingCodeUsagesAscendingOrderByCity(String routingCode, String codeType) {
        List<String> City = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", routingCode));
        nvPairs.add(new BasicNameValuePair("codeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode usages", nvPairs);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            City.add(document.getElementsByTagName("city").item(i).getTextContent());
        }

        City.remove(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_owning_usages_city_column_xpath")).getText());
        Collections.sort(City);
        List<WebElement> CityWithoutPrimary = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_NotOwing_usages_city_column_xpath"));

        for(int j=0;j<City.size();j++){
            assertEquals(City.get(j),CityWithoutPrimary.get(j).getText());
        }
    }

    public void verifyRoutingCodeUsagesAscendingOrderByArea(String routingCode, String codeType){
        List<String> Area = new ArrayList<>();
        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("code", routingCode));
        nvPairs.add(new BasicNameValuePair("codeType", codeType));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode usages", nvPairs);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < document.getElementsByTagName("results").getLength(); i++) {
            Area.add(document.getElementsByTagName("area").item(i).getTextContent());
        }

        Area.remove(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_owning_usages_area_column_xpath")).getText());
        Collections.sort(Area);
        List<WebElement> AreaWithoutPrimary = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingCode_NotOwing_usages_area_column_xpath"));

        for(int j=0;j<Area.size();j++){
            assertEquals(Area.get(j),AreaWithoutPrimary.get(j).getText());
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

    public void clickonPaymentSystems()
    {
        attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_page_paymentsystems_link"));
    }

    public void verifyRoutingCodePaymentSystemValuesFromTrustedDoc(String source,String routingCode, String codeType) {

        List<NameValuePair> nvPairs = new ArrayList<>();
        nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
        nvPairs.add(new BasicNameValuePair("routingCodeType", codeType));
        nvPairs.add(new BasicNameValuePair("source", source));
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database, "get routingCode payment systems info", nvPairs);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NodeList paymentSystems=document.getElementsByTagName("paymentSystem");
       for (int i=0;i<paymentSystems.getLength();i++)
        {
            Node paymentSystem =paymentSystems.item(i);
            if(paymentSystem.getNodeType() == Node.ELEMENT_NODE){
                NodeList productNames = ((Element)paymentSystem).getElementsByTagName("productName");
                String ProductName=productNames.item(0).getTextContent();
                NodeList dateJoinedList = ((Element)paymentSystem).getElementsByTagName("dateJoined");
                String dateJoined=dateJoinedList.item(0).getTextContent();
                NodeList dateLeftList = ((Element)paymentSystem).getElementsByTagName("dateLeft");
                String dateLeft=dateLeftList.item(0).getTextContent();
                NodeList alternateFormTypeList = ((Element)paymentSystem).getElementsByTagName("useCodeForm");
                String alternateFormType=alternateFormTypeList.item(0).getTextContent();
                NodeList membershipList = ((Element)paymentSystem).getElementsByTagName("codeSystemMembership");
                String membership=membershipList.item(0).getTextContent();
                NodeList codeSystemStatusList = ((Element)paymentSystem).getElementsByTagName("codeSystemStatus");
                String codeSystemStatus=codeSystemStatusList.item(0).getTextContent();
                NodeList routeViaList = ((Element)paymentSystem).getElementsByTagName("routeVia");
                String routeVia=routeViaList.item(0).getTextContent();
                NodeList correspondentList = ((Element)paymentSystem).getElementsByTagName("codeValue");
                NodeList attributesList = ((Element)paymentSystem).getElementsByTagName("PaymentSystemAttribute");
                NodeList contactLocationsList = ((Element)paymentSystem).getElementsByTagName("ContactLocations");

                assertEquals(ProductName,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_productName")).get(i).getText());
                assertEquals(dateJoined,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_dateJoined")).get(i).getText());
                assertEquals(dateLeft,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_dateLeft")).get(i).getText());
                assertEquals(alternateFormType,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_alternateFormType")).get(i).getText());
                assertEquals(membership,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_membershipType")).get(i).getText());
                assertEquals(codeSystemStatus,getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_systemActivityStatus")).get(i).getText());
                if(codeType.equals("Swift BIC")||codeType.equals("SWIFT BIC")) {
                    assertEquals(routeVia, getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_routeVia")).get(i).getText());
                }
                for(int correspondentCount=0;correspondentCount<correspondentList.getLength();correspondentCount++)
                {
                    assertEquals(correspondentList.item(correspondentCount).getTextContent(),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_correspondents")).get(i).findElements(By.xpath("tr/td")).get(correspondentCount).getText());
                }
                for(int attributeCount=0;attributeCount<attributesList.getLength();attributeCount++)
                {
                    assertEquals(attributesList.item(attributeCount).getTextContent().replaceAll(" ",""),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_attributes")).get(i).findElements(By.xpath("tr")).get(attributeCount).getText().replaceAll(" ",""));
                }
                if(codeType.equals("ABA")) {
                for(int contactListCount=0;contactListCount<contactLocationsList.getLength();contactListCount++)
                {

                    String ContactLocationType=((Element)(contactLocationsList.item(contactListCount))).getElementsByTagName("ContactLocationType").item(0).getTextContent();
                    String ContactOffice=((Element)(contactLocationsList.item(contactListCount))).getElementsByTagName("ContactOffice").item(0).getTextContent().replaceAll(" ","");
                    String ContactLocationsSpecialInstructions=((Element)(contactLocationsList.item(contactListCount))).getElementsByTagName("ContactLocationsSpecialInstructions").item(0).getTextContent();
                    //assertEquals(contactLocationsList.item(contactListCount).getTextContent().ge);

                    String ContactLocationTypeFromUI=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_contactLocations")).get(i).findElements(By.xpath("tr")).get(contactListCount).findElements(By.xpath("td")).get(0).getText();
                    String ContactOfficeFromUI=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_contactLocations")).get(i).findElements(By.xpath("tr")).get(contactListCount).findElements(By.xpath("td")).get(1).getText().replaceAll(",","").replaceAll(" ","");
                    String ContactLocationsSpecialInstructionsFromUI=getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_contactLocations")).get(i).findElements(By.xpath("tr")).get(contactListCount).findElements(By.xpath("td")).get(2).getText();

                    assertEquals(ContactLocationType,ContactLocationTypeFromUI);
                    assertEquals(ContactOffice,ContactOfficeFromUI);
                    assertEquals(ContactLocationsSpecialInstructions,ContactLocationsSpecialInstructionsFromUI);
                }}
                else {
                    try {
                        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("paymentsystems_contactLocations")).findElement(By.xpath("tr")).isDisplayed());
                    }
                    catch(Exception e)
                    {

                    }
                }





            }
        }

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
    
    public void verifyHistoryEventColumnNames() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("TYPE", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_type_col"))
						.getText());
		assertEquals("DATE", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_date_col"))
						.getText());
		assertEquals("DESCRIPTION", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_description_col"))
						.getText());
		assertEquals("REPLACED BY CODE", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_replacedbycode_col"))
						.getText());
		assertEquals("DETAILS", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_details_col"))
						.getText());
	}

	public RoutingCodePage createRoutingCodePage() {
		RoutingCodePage ERP = null;
		try {
			ERP = new RoutingCodePage(getDriver(), getUrlPrefix(), database, apacheHttpClient, restClient, heraApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERP;
	}

	public void verifyHistoryUsageColumnNames() {
		try {
			Thread.sleep(2000L);
			assertEquals("NAME", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_name_col")).getText());
			assertEquals("ADDRESS", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_address_col")).getText());
			assertEquals("CITY", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_city_col")).getText());
			assertEquals("AREA", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_area_col")).getText());
			assertEquals("SUB AREA", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_subarea_col")).getText());
			assertEquals("COUNTRY", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_country_col")).getText());
			assertEquals("POSTAL CODE", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_postalcode_col")).getText());
			assertEquals("ADDITIONAL INFO", getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_history_usage_addinfo_col")).getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyHistoryValuesFromTrusted(String routingCode, String routingCodeType, String source) {
		try {
			List<String> historyEventType = new ArrayList<String>();
			List<String> historyEventDate = new ArrayList<String>();
			List<String> historyEventDescription = new ArrayList<String>();
			List<String> historyEventReplacedByCode = new ArrayList<String>();
			List<String> historyUsageName = new ArrayList<String>();
			List<String> historyUsageAddress = new ArrayList<String>();
			List<String> historyUsageCity = new ArrayList<String>();
			List<String> historyUsageArea = new ArrayList<String>();
			List<String> historyUsageSubArea = new ArrayList<String>();
			List<String> historyUsageCountry = new ArrayList<String>();
			List<String> historyUsagePostalCode = new ArrayList<String>();
			List<String> historyUsageAdditionalInfo = new ArrayList<String>();		
			
			List<WebElement> historyEventRows = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_history_event_table"));
			for (int index = 1; index < historyEventRows.size() ; index++) {
				List<WebElement> historyEventColumns = historyEventRows.get(index).findElements(By.tagName("td"));
				historyEventType.add(historyEventColumns.get(0).getText());
				historyEventDate.add(historyEventColumns.get(1).getText());
				historyEventDescription.add(historyEventColumns.get(2).getText());
				historyEventReplacedByCode.add(historyEventColumns.get(3).getText());
			}
			
			//opening all drawers
			List<WebElement> eyeIcons = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_eye_icon"));
			for (int index = 0; index < eyeIcons.size() ; index++) {			
				attemptClickTheWebElement(eyeIcons.get(index));
			}	
			
			List<WebElement> historyUsagesRows = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("view_history_usage_table"));
			for (int innerIndex = 0; innerIndex < historyUsagesRows.size(); innerIndex++) {
				List<WebElement> historyUsageTableColumns = historyUsagesRows.get(innerIndex).findElements(By.tagName("td"));
				historyUsageName.add(historyUsageTableColumns.get(0).getText());
				historyUsageAddress.add(historyUsageTableColumns.get(1).getText());
				historyUsageCity.add(historyUsageTableColumns.get(2).getText());
				historyUsageArea.add(historyUsageTableColumns.get(3).getText());
				historyUsageSubArea.add(historyUsageTableColumns.get(4).getText());
				historyUsageCountry.add(historyUsageTableColumns.get(5).getText());
				historyUsagePostalCode.add(historyUsageTableColumns.get(6).getText());
				historyUsageAdditionalInfo.add(historyUsageTableColumns.get(7).getText());					
			}
			
			//closing all opened drawers
			eyeIcons = getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_eye_icon"));
			for (int index = 0; index < eyeIcons.size() ; index++) {			
				attemptClickTheWebElement(eyeIcons.get(index));
			}	
			
			verifyHistoryValuesFromDB(routingCode, routingCodeType, source, historyEventType, historyEventDate,
					historyEventDescription, historyEventReplacedByCode, historyUsageName, historyUsageAddress,
					historyUsageCity, historyUsageArea, historyUsageSubArea, historyUsageCountry, historyUsagePostalCode,
					historyUsageAdditionalInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void verifyHistoryValuesFromDB(String routingCode, String routingCodeType, String source, List<String> historyEventType, List<String> historyEventDate, List<String> historyEventDescription,
			List<String> historyEventReplacedByCode, List<String> historyUsageName, List<String> historyUsageAddress, List<String> historyUsageCity, List<String> historyUsageArea, List<String> historyUsageSubArea,
			List<String> historyUsageCountry, List<String> historyUsagePostalCode, List<String> historyUsageAdditionalInfo) {
		
		String historyEventValue;
		String historyUsageValue;
		try {
			List<NameValuePair> nvPairs = new ArrayList<>();
			nvPairs.add(new BasicNameValuePair("routingCode", routingCode));
			nvPairs.add(new BasicNameValuePair("routingCodeType", routingCodeType));
			Thread.sleep(5000L);

			Document document = apacheHttpClient.executeDatabaseAdminQueryWithMultipleParameter(database,
					"get routing code history values", nvPairs);

			if (document != null) {
				for (int i = 0; i < document.getElementsByTagName("routingCodeHistory").item(0).getChildNodes()
						.getLength(); i++) {

					for (int childNode = 0; childNode < document.getElementsByTagName("routingCodeHistory").item(0)
							.getChildNodes().item(i).getChildNodes().getLength(); childNode++) {

						historyEventValue = document.getElementsByTagName("routingCodeHistory").item(0)
								.getChildNodes().item(i).getChildNodes().item(childNode).getTextContent();

						switch (document.getElementsByTagName("routingCodeHistory").item(0).getChildNodes().item(0)
								.getChildNodes().item(childNode).getNodeName()) {
						case "type": assertEquals(historyEventValue, historyEventType.get(i));
							break;
						case "date": assertEquals(historyEventValue, historyEventDate.get(i));
							break;
						case "description":	assertEquals(document.getElementsByTagName("routingCodeHistory").item(0).getChildNodes().item(i).
								getChildNodes().item(childNode).getTextContent(), historyEventDescription.get(i));
							break;
						case "replacedByCode": assertEquals(document.getElementsByTagName("routingCodeHistory").item(0).getChildNodes().
								item(i).getChildNodes().item(childNode).getTextContent(), historyEventReplacedByCode.get(i));
							break;
						}
					}				
					
					if(document.getElementsByTagName("officeDetails").item(i).getChildNodes().getLength()>0) {
						for (int childNodes = 0; childNodes < document.getElementsByTagName("officeDetails").item(0)
								.getChildNodes().item(0).getChildNodes().getLength(); childNodes++) {
							
							historyUsageValue = document.getElementsByTagName("officeDetails").item(i)
									.getChildNodes().item(0).getChildNodes().item(childNodes).getTextContent();
							
							switch (document.getElementsByTagName("officeDetails").item(0).getChildNodes().item(0)
									.getChildNodes().item(childNodes).getNodeName()) {
							case "name":
								assertEquals(historyUsageValue, historyUsageName.get(i));
								break;
							case "address":
								assertEquals(historyUsageValue, historyUsageAddress.get(i));
								break;
							case "city":
								assertEquals(historyUsageValue, historyUsageCity.get(i));
								break;
							case "area":
								assertEquals(historyUsageValue, historyUsageArea.get(i));
								break;
							case "subArea":
								assertEquals(historyUsageValue, historyUsageSubArea.get(i));
								break;
							case "country":
								assertEquals(historyUsageValue, historyUsageCountry.get(i));
								break;
							case "postalCode":
								assertEquals(historyUsageValue, historyUsagePostalCode.get(i));
								break;
							case "additionalInfo":
								assertEquals(historyUsageValue, historyUsageAdditionalInfo.get(i));
								break;
							}
						}						
					}					
				}
			}
			else
				assertTrue(source + "document is null", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
