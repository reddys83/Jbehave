package com.accuity.zeus.aft.jbehave.steps;


import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.identifiers.RoutingCodeIdentifiers;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingCodeSteps extends AbstractSteps {

    private String selectedOffice;
    public String formerUsageOfficeName;

    @Then("the user should see the routing code basic info page")
    public void verifyRoutingCodeBasicInfoPage() {
        getRoutingCodePage().verifyRoutingCodeBasicInfoPage();
    }
    @Then("the user should see the routing code basic info values from trusted document for routing code <routingCode> with code type <codeType>")
            public void verifyRoutingCodeBasicInfoValuesFromTrustedDoc(@Named("routingCode") String routingCode,@Named("codeType") String codeType){

            getRoutingCodePage().verifyRoutingCodeBasicInfoValuesFromTrustedDoc(routingCode,codeType);
    }

    @Then("the user should see the routing code payment system values from $source document for routing code <routingCode> with code type <codeType>")
    public void verifyRoutingCodePaymentSystemValuesFromTrustedDoc(@Named("source") String source,@Named("routingCode") String routingCode,@Named("codeType") String codeType){

        getRoutingCodePage().verifyRoutingCodePaymentSystemValuesFromTrustedDoc(source,routingCode,codeType);
    }
    @Then("the user should not see ABA code type specific fields in the basic info page")
    public void verifyABAFieldsNotExist()
    {
        getRoutingCodePage().verifyABAFieldsNotExist();
    }


	@When("the user clicks on the routing code related codes link in the navigation bar")
	public void clickOnRelatedCodeLink() {
		getRoutingCodePage().clickOnRelatedCodeLink();
	}

	@Then("the user should see the related codes for routingCode <routingCode> and code type <codeType>")
	public void verifyRelatedCodesFromTrusted(@Named("routingCode") String routingCode, @Named("codeType") String codeType){
		getRoutingCodePage().verifyRelatedCodesFromTrusted(routingCode,codeType);
	}

	@Then("the user should not see related codes for routingCode <routingCode> and code type <codeType>")
	public void verifyNoRelatedCodesForRoutingCodes()
	{
		getRoutingCodePage().verifyNoRelatedCodesForRoutingCodes();
	}

	@When("the user clicks on the legal entity link in the routing code page header")
    public void clickonHeaderLink()
    {
		setLegalEntityPage(getRoutingCodePage().clickonHeaderLink());

    }

    @When("the user clicks on the routingCode usages link in the navigation bar")
    public void clickOnUsagesLink() {
        getRoutingCodePage().clickOnUsagesLink();
    }

    @When("the user click on office $office in the routingCode usages")
    public void clickOfficeLinkInUsages(String office){
        setOfficesPage(getRoutingCodePage().clickOfficeLinkInUsages(office));

    }

    @When("the user clicks on name column in the routingCode usages")
    public void clickOnUsagesNameColumn() {
        getRoutingCodePage().clickOnUsagesNameColumn();
    }

    @When("the user clicks on city column in the routingCode usages")
    public void clickOnUsagesCityColumn(){
        getRoutingCodePage().clickOnUsagesCityColumn();
    }

    @When("the user clicks on area column in the routingCode usages")
    public void clickOnUsagesAreaColumn() {
        getRoutingCodePage().clickOnUsagesAreaColumn();
    }

    @Then("the user should see the usages for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesInView(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesInView(routingCode,codeType);
    }

    @Then("the user should see the usages sort descending order by name for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesDescendingOrderByName(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesDescendingOrderByName(routingCode, codeType);
    }

    @Then("the user should see the usages sort ascending order by city for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesAscendingOrderByCity(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesAscendingOrderByCity(routingCode, codeType);
    }

    @Then("the user should see the usages sort ascending order by area for routingCode <routingCode> and code type <codeType>")
    public void verifyRoutingCodeUsagesAscendingOrderByArea(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
        getRoutingCodePage().verifyRoutingCodeUsagesAscendingOrderByArea(routingCode, codeType);
    }

	@When("the user clicks on the former usages link in the navigation bar")
	public void clickOnFormerUsageLink() {
		 getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_former_usages_navigation_link"));
	}

	@Then("the user should verify the column names in former usage page")
	public void verifyFormerUsageColumnNames() {
		getRoutingCodePage().verifyFormerUsageColumnNames();
	}

	@Then("the user verifies that values in $column column is in $order order")
	public void verifyFormerUsagesNameColumnInAlphabeticalOrder(@Named("column") String column, @Named("order") String order) {
		getRoutingCodePage().verifyFormerUsagesColumnInOrder(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_" + column + "_list"), column, order);
	}

	@When("the user clicks on sort button for name column")
	public void clickOnFormerUsagesNameSortButton() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_name_col"));
	}

	@When("the user clicks on sort button for city column")
	public void clickOnFormerUsagesCitySortButton() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_city_col"));
	}

	@When("the user clicks on sort button for area column")
	public void clickOnFormerUsagesAreaSortButton() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_area_col"));
	}

	@When("the user clicks on the office name link number <index>")
	public void clickOnFirstOfficeNameLink(@Named("index") int index) {
		formerUsageOfficeName = getRoutingCodePage().getOfficeNameLinkText(index);
		getDataPage().clickElementUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("view_routingcode_office_name_link"), index);
	}

	@Then("the user should see the office basic info page")
	public void verifyOfficeNameBasicInfoPage(@Named("routingCode") String routingCode, @Named("codeType") String codeType, @Named("index") int index) {
		getRoutingCodePage().verifyOfficeBasicInfoPage(routingCode, codeType, "trusted", index);
	}

	@Then("the user should see the former usages field values same as in $source document")
	@Alias("the user should see the former usages office name same as in $source document")
	public void verifyFormerUsagesFieldValuesFromTrustedDB(@Named("routingCode") String routingCode, @Named("codeType") String codeType, @Named("source") String source) {
		getRoutingCodePage().verifyFormerUsagesFieldValuesFromTrustedDB(routingCode, codeType, source);
	}

	@When("the user deletes the existing former usages values")
	public void deleteExistingFormerUsagesValues(@Named("routingCode") String routingCode, @Named("codeType") String codeType) {
		if (editRoutingCodePage == null) {
			editRoutingCodePage = getRoutingCodePage().createEditRoutingCodePage();
		}
		getRoutingCodePage().deleteExistingFormerUsagesValues(routingCode, codeType);
	}

	@When("the user inserts new former usages values")
	public void insertNewFormerUsagesValues(@Named("routingCode") String routingCode, @Named("codeType") String codeType) throws InterruptedException {
		getRoutingCodePage().insertNewFormerUsagesValues(routingCode, codeType);
		getDataPage().refreshThePage();
		Thread.sleep(5000L);
	}

    @When("the user clicks on payment systems section")
    public void clickOnPaymentSystems()
    {
        getRoutingCodePage().clickonPaymentSystems();
    }
    
    @Then("the user should see all the routing code menus in the sidebar")
	public void verifyRoutingCodeMenusInSidebar() {
		getDataPage().verifyElementIsDisplayed("ALL", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_all_link"));
		getDataPage().verifyElementIsDisplayed("BASIC INFO", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_basicInfo_link"));
		getDataPage().verifyElementIsDisplayed("PAYMENT SYSTEMS", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_payment_systems_link"));
		getDataPage().verifyElementIsDisplayed("RELATED CODES", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_related_codes_link"));
		getDataPage().verifyElementIsDisplayed("USAGES", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_usages_link"));
		getDataPage().verifyElementIsDisplayed("FORMER USAGES", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_former_usages_link"));
		getDataPage().verifyElementIsDisplayed("HISTORY", RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_link"));
	}
    
    @Then("the user should verify the column names in history page")
	public void verifyHistoryEventColumnNames() {
		getRoutingCodePage().verifyHistoryEventColumnNames();
	}

	@When("the user clicks on the history link in the navigation bar")
	public void clickOnRoutingCodeLink() {
		getDataPage().attemptClick(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_navigation_link"));
	}

	@When("the user clicks on the eye icon in first row to open the drawer")
	@Alias("the user clicks on the eye icon in first row to close the drawer")
	public void clickOnEyeIcon() {
		getDataPage().clickElementUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_eye_icon"), 1);
	}

	@Then("the user should verify the column names in history usage")
	public void verifyHistoryUsageColumnNames() {
		getRoutingCodePage().verifyHistoryUsageColumnNames();
		getDataPage().clickElementUsingIndex(RoutingCodeIdentifiers.getObjectIdentifier("routingcode_history_eye_icon"), 1);
	}

	@Then("the user should see the history field values same as in $source document")
	public void verifyHistoryValuesFromTrusted(@Named("routingCode") String routingCode,
			@Named("codeType") String codeType, @Named("source") String source) {
		getRoutingCodePage().verifyHistoryValuesFromTrusted(routingCode, codeType, source);
	}	
	
	@Then("the user should see N/A value under details column")
	public void verifyNAValueInDetailColumn() {
		getDataPage().verifyElementIsDisplayed("Details (N/A)", RoutingCodeIdentifiers.getObjectIdentifier("view_routing_code_history_details_N/A"));
	}
	
	@When("the user clicks on the delete history row button in the routing code history page")
	public void clickOnDeleteRoutingCodeHistoryRowButton() {
		getDataPage().attemptClick(
				RoutingCodeIdentifiers.getObjectIdentifier("edit_routingcode_page_delete_history_row_button"));
	}

	@Then("the user should see the history field values deleted from the history web page")
	public void verifyDeletedHistoryFieldsWebPage(@Named("historyDate") String historyDate,
			@Named("historyType") String historyType) {
		getRoutingCodePage().verifyDeletedHistoryFieldsWebPage(historyType, historyDate);
	}

	@Then("the user should see the history field values not deleted from the history web page")
	public void verifyHistoryFieldsNotDeletedWebPage(@Named("historyDate") String historyDate,
			@Named("historyType") String historyType) {
		getRoutingCodePage().verifyHistoryFieldsNotDeletedWebPage(historyType, historyDate);
	}

	@Then("the use should see the history field values are deleted from $source document")
	public void verifyDeletedHistoryValuesFromDB(@Named("routingCode") String routingCode,
			@Named("codeType") String codeType, @Named("historyDate") String historyDate,
			@Named("historyType") String historyType, @Named("source") String source) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getRoutingCodePage().verifyDeletedHistoryValuesFromDB(routingCode, codeType, historyType, historyDate, source);
	}

	@Then("the user should verify that delete button is enabled")
	public void verifyDeleteButtonEnabled() {
		getRoutingCodePage().verifyDeleteButtonEnabled();
	}

	@Then("the user should see the eye icon enabled")
	public void verifyEyeIconEnabled() {
		getRoutingCodePage().verifyEyeIconEnabled();
	}
}
