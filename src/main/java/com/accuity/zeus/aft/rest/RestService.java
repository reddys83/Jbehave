package com.accuity.zeus.aft.rest;

import java.net.URI;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.accuity.domain.AbstractSerializable;

@Service
public class RestService implements IRestService {
	
	private static final Logger log = Logger.getLogger(RestService.class);

	private RestTemplate restTemplate;
	
	public Object fetchAndDeserializeXml(URI uri, Class<? extends AbstractSerializable> returnClass) {
		Object response = null;
		log.debug("Calling: " + uri.toString() + ". Expecting xml of type: " + returnClass.getName());
		try {
			response = getRestTemplate().getForObject(uri, returnClass);
		} catch (HttpClientErrorException e) {
			log.error(e);
			return null;
		}
		return response;
	}
	
	protected void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	protected RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}
}