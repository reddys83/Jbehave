package com.accuity.zeus.aft.io;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Database {

    public String host;
    public  String port;
    public String username;
    public String password;
    public String scheme;
    public String path;

    @Value("${marklogic.admin.host}")
    public void setHost(String host) {
        this.host = host;
    }

    @Value("${marklogic.admin.port}")
    public void setPort(String port) {
        this.port = port;
    }

    @Value("${marklogic.admin.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${marklogic.admin.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("${marklogic.admin.scheme}")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Value("${marklogic.admin.path}")
    public void setPath(String path) {
        this.path = path;
    }

    public String getHost(){return host;}

    public int getPort(){return Integer.parseInt(port);}

    public String getUsername(){return username;}

    public String getPassword(){return password;}

    public String getBaseUrl() {
        return String.format("%s://%s:%s", scheme, host, port);
    }

    public String getScheme() {return scheme;}

    public String getPath() {return path;}

}
