package com.accuity.zeus.aft.rest;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.HeraApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

/**
 * Created by tubatil on 1/29/2016.
 */
@Component
public class RestClient implements IRestClient{

    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;

    @Autowired
    private HeraApi heraApi;

    @Override
    public void getResultForPatch(String endpoint, String ID)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("source", "zeus");
        HttpEntity<?> requestEntity = new HttpEntity<Object> (null, headers);
        String endpointWithID = endpoint+"/"+ID;

        String url = utils.constructURLForHeaApi(heraApi.getScheme(), heraApi.getHost(), heraApi.getPort(), heraApi.getPath(), endpointWithID);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, String.class);
        result.getStatusCode();
    }

    @Override
    public void put(String id, String endpointWithID)
    {

    }

}

