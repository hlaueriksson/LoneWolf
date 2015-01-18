package com.hoffenkloffen.lonewolf.base.support;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestSupport {

    public static String readFile(String path) throws IOException {

        String base = new java.io.File(".").getCanonicalPath();

        return new Scanner( new File(base + path), "UTF-8" ).useDelimiter("\\A").next();
    }

    public static Document readXml(String path) throws Exception {

        String base = new java.io.File(".").getCanonicalPath();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(base + path));
    }

    public static File getFile(String path) throws IOException {

        String base = new java.io.File(".").getCanonicalPath();

        return new File(base + path);
    }

    public static Node getNode(Document document, String expression) throws XPathExpressionException {

        XPath xpath = XPathFactory.newInstance().newXPath();
        return (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
    }

    public static NodeList getNodes(Document document, String expression) throws XPathExpressionException {

        XPath xpath = XPathFactory.newInstance().newXPath();
        return (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
    }
}
