package com.accuity.zeus.aft.commons;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by tubatil on 2/1/2016.
 */
public interface IUtils {
    Properties readPropertyFile();
    Set<String> findDuplicates(List<String> appList);
    String constructURL(String scheme, String host, int port, String path, String xquery);
    String constructURLWithParameter(String scheme, String host, int port, String path, String xquery, String param, String paramValue);
    String constructURLWithMultipleParameters(String scheme, String host, int port, String path, String xquery, List<NameValuePair> nvPairs);
    String constructURLForHeaApi(String scheme, String host, int port, String path, String endpointWithID);
}
