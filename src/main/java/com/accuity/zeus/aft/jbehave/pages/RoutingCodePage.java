package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
            assertEquals(RoutingCodeSubtype,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype")).getText());
            assertEquals(ABACodeSource,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).getText());
            assertEquals(ForthcomingRetirementDate,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).getText());
            assertEquals(ConfirmedwithFed,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).getText());
            assertEquals(RegistrarFeeSFDCSubscription,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).getText());
            assertEquals(Comment,getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Comment")).getText());
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
        assertEquals(UseHeadOffice.toLowerCase(),getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_UseHeadOffice")).getText().toLowerCase());
        for (int i=0;i<AlternateCodeForms.size();i++)
        {
            assertEquals(AlternateCodeFormTypes.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getAttribute("title"));
            assertEquals(AlternateCodeForms.get(i),getDriver().findElements(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_AlternateCodeForm")).get(i).getText());
        }

    }

    public void verifyABAFieldsNotExist(){
        try {
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RoutingCodeSubtype")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ABACodeSource")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ForthcomingRetirementDate")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_ConfirmedwithFed")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_RegistrarFeeSFDCSubscription")).isDisplayed());
        assertFalse(getDriver().findElement(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_view_Comment")).isDisplayed());
        }

        catch(NoSuchElementException e){}
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








      /*  routingcodeComment").get(0);
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
*/
    }


}
