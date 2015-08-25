package com.accuity.zeus.aft.io;

import com.accuity.zeus.aft.commons.Utils;
import com.accuity.zeus.aft.io.Database;
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

    public Document executeDatabaseAdminQueryWithResponse(Database database, String xquery) {
        Utils utils = new Utils();
        Document document = null;
        HttpClient client = new HttpClient();
        client.getState().setCredentials(new AuthScope(database.getHost(), database.getPort(), "public"), new UsernamePasswordCredentials(database.getUsername(), database.getPassword()));

        List<String> authPrefs = new ArrayList<>();
        authPrefs.add(AuthPolicy.DIGEST);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod method = new GetMethod(utils.constructURL(database.getScheme(), database.getHost(), database.getPort(), folderPath) + "/" + xquery);
        try {
            client.executeMethod(method);
            document = new XmlDocument().convertFromString(method.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();
        return document;
    }
}
