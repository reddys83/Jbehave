package com.accuity.zeus.aft.io;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tubatil on 1/29/2016.
 */

@Component
public class HeraApi implements IHeraApi {

    public String host;
    public String port;
    public String path;
    public String scheme;

    @Value("${marklogic.admin.scheme}")
    public void setHeraApiQAScheme(String scheme) { this.scheme = scheme; }

    @Value("${heraApi.QA.host}")
    public void setHeraApiQAHost(String host) { this.host = host; }

    @Value("${heraApi.QA.port}")
    public void setHeraApiQAPort(String port) {
        this.port = port;
    }

    @Value("${heraApi.QA.path}")
    public void setHeraApiQAPath(String path) {
        this.path = path;
    }

    public String getScheme(){return scheme; }

    public String getHost(){return host;}

    public int getPort(){return Integer.parseInt(port);}

    public String getPath() {return path;}

}
