package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.domain.legalEntity.LegalEntity;
import com.accuity.zeus.aft.jbehave.pages.DataPage;
import com.accuity.zeus.aft.jbehave.pages.ReportPage;
import com.accuity.zeus.aft.jbehave.pages.SearchPage;
import com.accuity.zeus.aft.result.ResultsPage;
import com.accuity.zeus.aft.service.legalEntity.LegalEntityDocumentService;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchSteps extends AbstractSteps {

	@Autowired
	private LegalEntityDocumentService legalEntityDocumentService;

	private SearchPage searchPage;
	public static ResultsPage resultsPage;
	public static DataPage dataPage;

	private Map<String, LegalEntity> expectedMap = new HashMap<String, LegalEntity>();

	@Given("a user is on the search page")
	public void givenUserIsOnSearchPage() {
		searchPage = new SearchPage(webDriverState.getWebDriver(), getDataManagementWebappUrl());
		searchPage.open();
	}
	
	@When("the user searches for an arbitrary <entity>")
	public void whenUserSearches(@Named("entity") String entity) {
		if (searchPage != null) {
			LegalEntity tempEntity = getExpectedLegalEntity(entity);
			resultsPage = searchPage.search(entity, "id", tempEntity.getId());
		}
	}

	@When("the user searches for <entity> with <field> equals <value>")
	public void whenUserSearches(@Named("entity") String entity, @Named("field") String field, @Named("value") String value) {
		if (searchPage != null) {
			//getExpectedLegalEntity(entity, field, value);
			resultsPage = searchPage.search(entity, field, value);
		}
	}

	@When("the user clicks on the report tab")
    public void whenUserClicksOnReportTab(){
        setReportPage(searchPage.clickOnReportsTab());
    }

	@When("the user clicks on the data tab in the search page")
	public void whenUserClicksOnDataTab(){
		setDataPage(searchPage.clickOnDataTab());
	}

    private LegalEntity getExpectedLegalEntity(String entity) {
        LegalEntity instance = legalEntityDocumentService.getArbitraryEntity(entity);
        if (instance != null) {
            expectedMap.put(instance.getFid(), instance);
        }
        return instance;
    }

    private LegalEntity getExpectedLegalEntity(String entity, String field, String value) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("entity", entity);
        if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(value)) {
            params.put("idType", field);
            params.put("id", value);
        }
        LegalEntity instance = legalEntityDocumentService.search(params);
        if (instance != null) {
            expectedMap.put(instance.getFid(), instance);
        }
        return instance;
    }

}