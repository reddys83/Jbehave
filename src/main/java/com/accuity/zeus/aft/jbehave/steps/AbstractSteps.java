package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.pages.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.aft.result.ResultsPage;
import com.accuity.zeus.aft.web.driver.WebDriverState;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class AbstractSteps {
	
	private static final Logger log = Logger.getLogger(AbstractSteps.class);
	private static ReportPage reportPage;
	private static SearchPage searchPage;
	private static ResultsPage resultsPage;
	private static ResetPasswordPage resetPasswordPage;
	private static LoginPage loginPage;
	private static DataPage dataPage;
	private static AdminPage adminPage;
	private static LegalEntityPage legalEntityPage;
	private static OfficesPage officesPage;
	private static CurrencyPage currencyPage;
	private static CountryPage countryPage;



	public static EditLegalEntityPage editLegalEntityPage;



	public static EditCityPage editCityPage;
	private static EditAreaPage editAreaPage;

    @Autowired
    ApacheHttpClient apacheHttpClient;

    @Autowired
    HeraApi heraApi;

    @Autowired
    RestClient restClient;

    @Autowired
    Database database;

	@Autowired
	protected WebDriverState webDriverState;

	@Value("${data.management.webapp.aft.scheme}")
	private String scheme;
	
	@Value("${data.management.webapp.aft.host}")
	private String host;
	
	@Value("${data.management.webapp.aft.port}")
	private Integer port;
	
	@Value("${data.management.webapp.aft.uri}")
	private String uri;


	public String getDataManagementWebappUrl() {
		//return buildUriString(null, null);
		return host;
	}

	public String getDataManagementWebappUrl(String path) {
		return buildUriString(path, null);
	}

	public String getDataManagementWebappUrl(Map<String, String> params) {
		return buildUriString(null, params);
	}
	
	public String getDataManagementWebappUrl(String path, Map<String, String> params) {
		return buildUriString(path, params);
	}
	
	private String buildUriString(String path, Map<String, String> params) {
		URI uri = buildUri(path, params);
		if (uri != null) {
			return uri.toString();
		}
		return StringUtils.EMPTY;
	}
	
	private URI buildUri(String path, Map<String, String> params) {

		URIBuilder builder = new URIBuilder();

		builder.setScheme(scheme);
		builder.setHost(host);
		builder.setPort(port);

		StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append(uri);
		if (StringUtils.isNotBlank(path)) {
			pathBuilder.append("/").append(path.trim());
		}
		builder.setPath(pathBuilder.toString());
		if (params != null) {
			for (Map.Entry<String, String> param : params.entrySet()) {
				builder.addParameter(param.getKey(), param.getValue());
			}
		}
		try {
			return builder.build();
		} catch (URISyntaxException e) {
			log.error(e.getLocalizedMessage());
			throw new RuntimeException(e);
		}
	}
    public static CurrencyPage getCurrencyPage() {
        return currencyPage;
    }

    public static void setCurrencyPage(CurrencyPage currencyPage) {
        AbstractSteps.currencyPage = currencyPage;
    }

    public CountryPage getCountryPage() {
        return countryPage;
    }
    public void setCountryPage(CountryPage countryPage) { this.countryPage = countryPage; }

   	public ReportPage getReportPage() {
		return reportPage;
	}

	public void setReportPage(ReportPage reportPage) {
		this.reportPage = reportPage;
	}

	public SearchPage getSearchPage() {
		return searchPage;
	}

	public void setSearchPage(SearchPage searchPage) {
		this.searchPage = searchPage;
	}

	public ResetPasswordPage getResetPasswordPage() {
		return resetPasswordPage;
	}

	public void setResetPasswordPage(ResetPasswordPage resetPasswordPage) {
		this.resetPasswordPage = resetPasswordPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	public ResultsPage getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(ResultsPage resultsPage) {
		this.resultsPage = resultsPage;
	}

	public DataPage getDataPage() {
		return dataPage;
	}

	public void setDataPage(DataPage dataPage) {
		this.dataPage = dataPage;

	}
	public AdminPage getAdminPage() {
		return adminPage;
	}

	public void setAdminPage(AdminPage adminPage) {
		this.adminPage = adminPage;
	}

	public LegalEntityPage getLegalEntityPage() {
		return legalEntityPage;
	}

	public void setLegalEntityPage(LegalEntityPage legalEntityPage) {
		this.legalEntityPage = legalEntityPage;
	}

	public OfficesPage getOfficesPage() {
		return officesPage;
	}

	public void setOfficesPage(OfficesPage officesPage) {
		this.officesPage = officesPage;
	}

	public static EditLegalEntityPage getEditLegalEntityPage() {
		return editLegalEntityPage;
	}

	public static void setEditLegalEntityPage(EditLegalEntityPage editLegalEntityPage) {
		AbstractSteps.editLegalEntityPage = editLegalEntityPage;
	}

	public static EditCityPage getEditCityPage() {
		return editCityPage;
	}

	public static void setEditCityPage(EditCityPage editCityPage) {
		AbstractSteps.editCityPage = editCityPage;
	}
	
	public static void setEditAreaPage(EditAreaPage editAreaPage) {
		AbstractSteps.editAreaPage = editAreaPage;
	}
	
	public static EditAreaPage getEditAreaPage() {
		return editAreaPage;
	}

}
