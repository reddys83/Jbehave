package com.accuity.zeus.xml;

import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.restlet.ext.xml.DomRepresentation;


public class XmlDocument {

    private Document document;

    public XmlDocument(){

    }

    public XmlDocument(Document document) {
        this.document = document;
    }

    public Document convertFromString(String s) {
        try {
            StringReader sr = new StringReader(s);
            StreamSource source = new StreamSource(sr);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            DOMResult result = new DOMResult();
            transformer.transform(source, result);
            Document doc = (Document) result.getNode();
            return doc;
        } catch (TransformerException e) {
            throw new RuntimeException("Error converting String to XmlDocument", e);
        }
    }

    public DomRepresentation convertToDomRepresentation(Document document) throws IOException {
        DomRepresentation domRep = new DomRepresentation();
        domRep.setDocument(document);
        return domRep;
    }

    @Override
    public String toString() {
        try {
            return convertToString();
        }
        catch (TransformerException e) {
            throw new RuntimeException("Error converting XmlDocument to String", e);
        }
    }

    private String convertToString() throws TransformerException {
        StringWriter sw = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(document), new StreamResult(sw));
        return sw.toString();
    }


  }
