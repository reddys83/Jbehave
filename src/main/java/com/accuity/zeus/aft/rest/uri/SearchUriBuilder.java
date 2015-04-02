package com.accuity.zeus.aft.rest.uri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SearchUriBuilder extends UriBuilder {

    public SearchUriBuilder() { }

    @Autowired
    public SearchUriBuilder(@Value("${data.api.search.host}") String host, @Value("${data.api.search.port}") Integer port, @Value("${data.api.search.uri}") String baseUri) { 
    	super(host, port, baseUri);
    }

}
