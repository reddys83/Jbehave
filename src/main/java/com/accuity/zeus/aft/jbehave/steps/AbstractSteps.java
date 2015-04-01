package com.accuity.zeus.aft.jbehave.steps;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.accuity.zeus.aft.web.driver.WebDriverState;

public abstract class AbstractSteps {
	
	private static final Logger log = Logger.getLogger(AbstractSteps.class);
	
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
		return buildUriString(null, null);
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

}
