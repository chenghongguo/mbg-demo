package com.hongguo.mbg.config.xml;

import com.hongguo.mbg.config.Configuration;
import lombok.Data;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: chenghongguo
 * @date: 2018-12-04
 * @description:
 */
@Data
public class ConfigurationParser {

    public Configuration parseConfiguration(InputStream inputStream) {
        Configuration configuration = new Configuration();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            try {
                document = builder.parse(inputStream);
                Element rootNode = document.getDocumentElement();
                MyBatisGeneratorConfigurationParser myBatisGeneratorConfigurationParser = new MyBatisGeneratorConfigurationParser();
                configuration = myBatisGeneratorConfigurationParser.parseConfiguration(rootNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configuration;
    }
}
