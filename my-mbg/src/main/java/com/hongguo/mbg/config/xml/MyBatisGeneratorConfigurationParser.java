package com.hongguo.mbg.config.xml;

import com.hongguo.mbg.config.*;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Properties;

/**
 * @author hongguo_cheng
 * @date 2018-12-04
 * @description
 */
public class MyBatisGeneratorConfigurationParser {

    public Configuration parseConfiguration(Element rootNode) {
        Configuration configuration = new Configuration();
        NodeList childNodes = rootNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("context".equals(node.getNodeName())) {
                parseContext(configuration, node);
            }
        }
        return configuration;
    }

    private void parseContext(Configuration configuration, Node node) {
        Properties properties = parseProperties(node);
        Context context = new Context();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("jdbcConnection".equals(item.getNodeName())) {
                parseJdbcConnection(context, item);
            } else if ("javaModelGenerator".equals(item.getNodeName())) {
                parseJavaModelGenerator(context, item);
            } else if ("sqlMapGenerator".equals(item.getNodeName())) {
                parseSqlMapGenerator(context, item);
            } else if ("javaClientGenerator".equals(item.getNodeName())) {
                parseJavaClientGenerator(context, item);
            } else if ("table".equals(item.getNodeName())) {
                parseTable(context, item);
            }
        }
        configuration.addContext(context);
    }

    private void parseTable(Context context, Node node) {
        TableConfiguration tableConfiguration = new TableConfiguration();
        NamedNodeMap attributes = node.getAttributes();
        Node tableName = attributes.getNamedItem("tableName");
        Node domainObjectName = attributes.getNamedItem("domainObjectName");
        tableConfiguration.setDomainObjectName(domainObjectName.getNodeValue());
        tableConfiguration.setTableName(tableName.getNodeValue());
        context.addTableConfiguration(tableConfiguration);
    }

    private void parseJavaClientGenerator(Context context, Node node) {
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        NamedNodeMap attributes = node.getAttributes();
        Node targetPackage = attributes.getNamedItem("targetPackage");
        Node targetProject = attributes.getNamedItem("targetProject");
        javaClientGeneratorConfiguration.setTargetPackage(targetPackage.getNodeValue());
        javaClientGeneratorConfiguration.setTargetProject(targetProject.getNodeValue());
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
    }

    private void parseSqlMapGenerator(Context context, Node node) {
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        NamedNodeMap attributes = node.getAttributes();
        Node targetPackage = attributes.getNamedItem("targetPackage");
        Node targetProject = attributes.getNamedItem("targetProject");
        sqlMapGeneratorConfiguration.setTargetPackage(targetPackage.getNodeValue());
        sqlMapGeneratorConfiguration.setTargetProject(targetProject.getNodeValue());
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
    }

    private void parseJavaModelGenerator(Context context, Node node) {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        NamedNodeMap attributes = node.getAttributes();
        Node targetPackage = attributes.getNamedItem("targetPackage");
        Node targetProject = attributes.getNamedItem("targetProject");
        javaModelGeneratorConfiguration.setTargetPackage(targetPackage.getNodeValue());
        javaModelGeneratorConfiguration.setTargetProject(targetProject.getNodeValue());
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
    }

    private void parseJdbcConnection(Context context, Node node) {
        JDBCConnectionConfiguration connectionConfiguration = new JDBCConnectionConfiguration();
        NamedNodeMap attributes = node.getAttributes();
        Node driverClassNode = attributes.getNamedItem("driverClass");
        connectionConfiguration.setDriverClass(driverClassNode.getNodeValue());

        Node urlNode = attributes.getNamedItem("url");
        connectionConfiguration.setUrl(urlNode.getNodeValue());

        Node usernameNode = attributes.getNamedItem("username");
        connectionConfiguration.setUsername(usernameNode.getNodeValue());

        Node passwordNode = attributes.getNamedItem("password");
        connectionConfiguration.setPassword(passwordNode.getNodeValue());
        context.setJdbcConnectionConfiguration(connectionConfiguration);
    }

    private Properties parseProperties(Node node) {
        Properties properties = new Properties();
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            properties.put(item.getNodeName(), item.getNodeValue());
        }
        return properties;
    }
}
