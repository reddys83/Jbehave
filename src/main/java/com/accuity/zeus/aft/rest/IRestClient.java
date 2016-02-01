package com.accuity.zeus.aft.rest;

/**
 * Created by tubatil on 2/1/2016.
 */
public interface IRestClient {
    void getResultForPatch(String endpoint, String ID);
    void put(String id, String endpointWithID);
}
