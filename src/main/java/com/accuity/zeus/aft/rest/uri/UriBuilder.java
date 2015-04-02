package com.accuity.zeus.aft.rest.uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

public class UriBuilder implements IUriBuilder {

    private static final Logger log = Logger.getLogger(UriBuilder.class);
    
    private static final String DEFAULT_SCHEME = "http";
    
    private String scheme;

    private String host;
    
    private Integer port;

    private String baseUri;
    
    public UriBuilder() { }
    
    public UriBuilder(String host, Integer port, String baseUri) {
    	this(DEFAULT_SCHEME, host, port, baseUri);
    }
    
    public UriBuilder(String scheme, String host, Integer port, String baseUri) {
    	this.scheme = scheme;
    	this.host = host;
    	this.port = port;
    	this.baseUri = baseUri;
    }

    @Override
	public URI buildUriString(String path, Map<String, String> params) {

        URIBuilder builder = new URIBuilder();

        builder.setScheme(scheme);
        builder.setHost(host);
        builder.setPort(port);

		StringBuilder tempPathBuilder = new StringBuilder();
		if (StringUtils.isNotBlank(baseUri)) {
			tempPathBuilder.append("/").append(baseUri);
		}
		if (StringUtils.isNotBlank(path)) {
			tempPathBuilder.append("/").append(path.trim());
		}
		builder.setPath(tempPathBuilder.toString());

        if (params != null) {
			for (Map.Entry<String, String> param : params.entrySet()) {
				builder.addParameter(param.getKey(), param.getValue());
			}
		}
		try {
			return builder.build();
		} catch (URISyntaxException e) {
			log.error(e);
			throw new RuntimeException(e);
		}
    }

}
