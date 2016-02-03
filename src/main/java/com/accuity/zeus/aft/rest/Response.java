package com.accuity.zeus.aft.rest;

import com.accuity.zeus.xml.XmlDocument;

/**
 * Created by tubatil on 2/2/2016.
 */
public class Response {

    protected XmlDocument xmlDocument;
    protected int statusCode;

    public Response(XmlDocument xmlDocument, int statusCode) {
        this.xmlDocument = xmlDocument;
        this.statusCode = statusCode;
    }

    public XmlDocument XmlDocumentToString() {
        return xmlDocument;
    }

    public XmlDocument getXmlDocument() {
        return xmlDocument;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
