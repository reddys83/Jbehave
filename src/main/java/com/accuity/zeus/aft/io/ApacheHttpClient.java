package com.accuity.zeus.aft.io;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.jbehave.steps.SearchResultsSteps;
import com.accuity.zeus.xml.XmlDocument;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

/**
 * Created by soofis on 8/21/2015.
 */

@Component
public class ApacheHttpClient {

    @Value("${marklogic.modules.xquery.folderPath}")
    String folderPath;

    @Autowired
    Utils utils;

    public Document executeDatabaseAdminQueryWithResponse(Database database, String xquery) {
       // Utils utils = new Utils();
        Document document = null;
        HttpClient client = new HttpClient();
        client.getState().setCredentials(new AuthScope(database.getHost(), database.getPort(), "public"), new UsernamePasswordCredentials(database.getUsername(), database.getPassword()));

        List<String> authPrefs = new ArrayList<>();
        authPrefs.add(AuthPolicy.DIGEST);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod method = new GetMethod(utils.constructURL(database.getScheme(), database.getHost(), database.getPort(), database.getPath(), xquery));
        try {
            client.executeMethod(method);
            document = new XmlDocument().convertFromString(method.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return document;
    }

    public void executeDatabaseAdminQuery(Database database,String xquery, List<NameValuePair> nvPairs) {
       // Utils utils = new Utils();
        HttpClient client = new HttpClient();
        client.getState().setCredentials(new AuthScope(database.getHost(), database.getPort(), "public"), new UsernamePasswordCredentials(database.getUsername(), database.getPassword()));

        List<String> authPrefs = new ArrayList<>();
        authPrefs.add(AuthPolicy.DIGEST);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod method = new GetMethod(utils.constructURLWithMultipleParameters(database.getScheme(), database.getHost(), database.getPort(), database.getPath(), xquery, nvPairs));
        try {
            client.executeMethod(method);
            Thread.sleep(1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
    }

    public Document executeDatabaseAdminQueryWithParameter(Database database, String xquery, String param, String paramValue) {
      //  Utils utils = new Utils();
        Document document = null;
        HttpClient client = new HttpClient();
        client.getState().setCredentials(new AuthScope(database.getHost(), database.getPort(), "public"), new UsernamePasswordCredentials(database.getUsername(), database.getPassword()));

        List<String> authPrefs = new ArrayList<>();
        authPrefs.add(AuthPolicy.DIGEST);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod method = new GetMethod(utils.constructURLWithParameter(database.getScheme(), database.getHost(), database.getPort(), database.getPath(), xquery, param, paramValue));
        try {
            client.executeMethod(method);
            document = new XmlDocument().convertFromString(method.getResponseBodyAsString());
            Thread.sleep(1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return document;
    }

    public Document executeDatabaseAdminQueryWithMultipleParameter(Database database, String xquery, List<NameValuePair> nvPairs) {
     //   Utils utils = new Utils();
        Document document = null;
        HttpClient client = new HttpClient();
        client.getState().setCredentials(new AuthScope(database.getHost(), database.getPort(), "public"), new UsernamePasswordCredentials(database.getUsername(), database.getPassword()));

        List<String> authPrefs = new ArrayList<>();
        authPrefs.add(AuthPolicy.DIGEST);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod method = new GetMethod(utils.constructURLWithMultipleParameters(database.getScheme(), database.getHost(), database.getPort(), database.getPath(), xquery, nvPairs));
        try {
            client.executeMethod(method);
            document = new XmlDocument().convertFromString(method.getResponseBodyAsString());
            Thread.sleep(1000L);
            if(((GetMethod) method).getResponseContentLength()!=0) {
                document = new XmlDocument().convertFromString(method.getResponseBodyAsString());
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return document;
    }

}
