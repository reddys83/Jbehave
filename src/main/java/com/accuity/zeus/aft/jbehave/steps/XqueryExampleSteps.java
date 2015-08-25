package com.accuity.zeus.aft.jbehave.steps;

import com.accuity.zeus.aft.commons.XqueryMap;
import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 * Created by soofis on 8/25/2015.
 */
@Component
public class XqueryExampleSteps {

    @Autowired
    ApacheHttpClient apacheHttpClient;
    @Autowired
    Database database;


    @Value("${marklogic.admin.scheme}")
    private String scheme;
    @Value("${marklogic.admin.host}")
    private String host;
    @Value("${marklogic.admin.port}")
    private String port;
    @Value("${marklogic.admin.username}")
    private String username;
    @Value("${marklogic.admin.password}")
    private String password;



    @Then("the countries list matches the $xqueryName from the database")
    public void executeXquery(String xqueryName){
        ArrayList<String> myList = new ArrayList<>();
        XqueryMap xqueryMap = new XqueryMap();
        database.setScheme(scheme);
        database.setHost(host);
        database.setPort(port);
        database.setUsername(username);
        database.setPassword(password);
        Document document = apacheHttpClient.executeDatabaseAdminQueryWithResponse(database, xqueryMap.getXquery(xqueryName));
        for (int i=0;i<=document.getElementsByTagName("a").getLength();i++){
            //this prepares the list for comparision
            myList.add(document.getElementsByTagName("result").item(i).getTextContent());
            System.out.println("Added values in the list are: " + document.getElementsByTagName("result").item(i).getTextContent());
        }
    }
}
