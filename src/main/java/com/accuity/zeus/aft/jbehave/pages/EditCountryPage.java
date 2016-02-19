package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.rest.RestClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by soofis on 2/12/2016.
 */
public class EditCountryPage extends AbstractPage {



    public EditCountryPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        super(driver, urlPrefix, database, apacheHttpClient, restClient, heraApi);
    }



    @Override
    public String getPageUrl() {
        return null;
    }



}
