package com.accuity.zeus.aft.rest;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.xml.XmlDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

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

    public int putDocumentByID(String endpointWithID, HeraApi heraApi, String document, String url)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", String.valueOf(MediaType.APPLICATION_XML));
        headers.set("Accept", String.valueOf(MediaType.APPLICATION_XML));
        headers.set("source", "zeus");
        HttpEntity<?> requestEntity = new HttpEntity<Object> (document, headers);

        if (url.length()<=0) {
            url = utils.constructURLForHeaApi(heraApi.getScheme(), heraApi.getHost(), heraApi.getPort(), heraApi.getPath(), endpointWithID.replace("id/", ""));
        }

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(0);
        requestFactory.setReadTimeout(0);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getStatusCode().value();
    }

    public ResponseEntity getDocumentByID(String endpointWithID, HeraApi heraApi)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", String.valueOf(MediaType.APPLICATION_XML));
        headers.set("source", "zeus");
        HttpEntity<?> requestEntity = new HttpEntity<Object> (null, headers);

        String url = utils.constructURLForHeaApi(heraApi.getScheme(), heraApi.getHost(), heraApi.getPort(), heraApi.getPath(), endpointWithID.replace("id/",""));

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(0);
        requestFactory.setReadTimeout(0);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

    }

}

