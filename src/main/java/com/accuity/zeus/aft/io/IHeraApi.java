package com.accuity.zeus.aft.io;

/**
 * Created by tubatil on 2/1/2016.
 */
public interface IHeraApi {
    void setHeraApiQAScheme(String scheme);
    void setHeraApiQAHost(String host);
    void setHeraApiQAPort(String port);
    void setHeraApiQAPath(String path);
    String getScheme();

    String getHost();

    int getPort();

    public String getPath();

}
