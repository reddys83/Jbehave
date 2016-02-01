package com.accuity.zeus.aft.commons;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
@Component
public class Utils implements  IUtils {

    URIBuilder builder = new URIBuilder();
    XqueryMap xqueryMap = new XqueryMap();
    ParamMap paramMap = new ParamMap();

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

    public String constructURLWithMultipleParameters(String scheme, String host, int port, String path, String xquery, List<NameValuePair> nvPairs) {
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

    public String constructURLForHeaApi(String scheme, String host, int port, String path, String endpointWithID) {
      try {
          return builder.setScheme(scheme)
                        .setHost(host)
                        .setPort(port)
                        .setPath(path + endpointWithID).build().toString();
      }
      catch (URISyntaxException e) {
          e.printStackTrace();
          return null;
      }
    }



}
