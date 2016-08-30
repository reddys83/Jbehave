package com.accuity.zeus.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringReader;
import java.net.URI;

/**
 * Created by soofis on 7/8/2016.
 */
public class XmlDocumentLoader {

    public static XmlDocument loadDocumentFromFile(URI filePath) {

        return loadDocumentFromFile(new File(filePath));
    }

    public static Document getDocument(URI filePath){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));

            return document;

        } catch (Exception e) {
            throw new RuntimeException("Could not return document");
        }
    }

    public static XmlDocument loadDocumentFromFile(File xmlFile) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            return new XmlDocument(document);

        } catch (Exception e) {
            throw new RuntimeException("Could not create xml document for " + xmlFile.toString(), e);
        }
    }

}
