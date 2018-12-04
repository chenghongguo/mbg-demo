package com.xml.parser;

import java.io.File;
import java.net.URL;

/**
 * @author hongguo_cheng
 * @date 2018-12-04
 * @description
 */
public class Main {
    public static void main(String[] args) {
        URL resource = Main.class.getResource("/book.xml");
        File file = new File(resource.getFile());
        new XmlParser().xmlParser(file);
    }
}
