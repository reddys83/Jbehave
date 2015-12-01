package com.accuity.zeus.aft.commons;

import com.accuity.zeus.aft.rest.uri.UriBuilder;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by soofis on 8/12/2015.
 */
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

    public String constructURL(String scheme, String host, int port){
        URIBuilder builder = new URIBuilder();

        try {
            return builder.setScheme(scheme).setHost(host).setPort(port).build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String constructURLWithParameter(String scheme, String host, int port, String path, String xquery, String fid ) {
        XqueryMap xqueryMap = new XqueryMap();
        URIBuilder builder = new URIBuilder();
        try {
           return builder.setScheme(scheme)
                         .setHost(host)
                         .setPort(port)
                         .setPath(path + xqueryMap.getXquery(xquery))
                         .addParameter( "fid", fid).build().toString();
         //  return builder.setScheme(scheme).setHost(host).setPort(port).addParameter("fid", fid).build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


}
