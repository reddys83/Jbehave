package com.accuity.zeus.aft.rest;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.HeraApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tubatil on 1/29/2016.
 */
@Component
public class RestClient{

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    Utils utils;

    public String getResultForPatch(String endpoint, String ID, HeraApi heraApi)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("source", "zeus");
        HttpEntity<?> requestEntity = new HttpEntity<Object> (null, headers);
        String endpointWithID = endpoint+"/"+ID;
        String url = utils.constructURLForHeaApi(heraApi.getScheme(), heraApi.getHost(), heraApi.getPort(), heraApi.getPath(), endpointWithID);

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(0);
        requestFactory.setReadTimeout(0);
        restTemplate.setRequestFactory(requestFactory);


        ResponseEntity result = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, String.class);
        String patchResponse = result.getStatusCode().toString();
        return patchResponse;
    }

    public void put(String id, String endpointWithID)
    {

    }

}

