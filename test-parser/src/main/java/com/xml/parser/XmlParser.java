package com.xml.parser;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @author hongguo_cheng
 * @date 2018-12-04
 * @description
 */
public class XmlParser {

    public void xmlParser(File parseFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parse = builder.parse(parseFile);
            Element rootNode = parse.getDocumentElement();
            NodeList childNodes = rootNode.getChildNodes();

            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                NamedNodeMap attributes = node.getAttributes();
                Node namedItem = attributes.getNamedItem("id");
                System.out.println(namedItem.getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
