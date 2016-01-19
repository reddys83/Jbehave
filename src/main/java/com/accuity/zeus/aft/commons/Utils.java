package com.accuity.zeus.aft.commons;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

public class Utils {

    public Properties readPropertyFile(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = this.getClass().getResourceAsStream("/environment.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public Set<String> findDuplicates(List<String> appList){
        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> setForComp = new HashSet<String>();

        for (String yourInt : appList) {
            if (!setForComp.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }

    public String constructURL(String scheme, String host, int port, String path, String xquery){
        URIBuilder builder = new URIBuilder();
        XqueryMap xqueryMap = new XqueryMap();
        try {
            return builder.setScheme(scheme)
                    .setHost(host)
                    .setPort(port)
                    .setPath(path + xqueryMap.getXquery(xquery)).build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String constructURLWithParameter(String scheme, String host, int port, String path, String xquery, String param, String paramValue) {
        XqueryMap xqueryMap = new XqueryMap();
        ParamMap paramMap = new ParamMap();
        URIBuilder builder = new URIBuilder();
        try {
           return builder.setScheme(scheme)
                         .setHost(host)
                         .setPort(port)
                         .setPath(path + xqueryMap.getXquery(xquery))
                         .addParameter(paramMap.getParam(param), paramValue).build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String constructURLWithMultipleParameters(String scheme, String host, int port, String path, String xquery, String param, List<NameValuePair> nvPairs)
    {
        XqueryMap xqueryMap = new XqueryMap();
        URIBuilder builder = new URIBuilder();
        try {
            return builder.setScheme(scheme)
                    .setHost(host)
                    .setPort(port)
                    .setPath(path + xqueryMap.getXquery(xquery))
                    .addParameters(nvPairs).build().toString();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }


    }



}
