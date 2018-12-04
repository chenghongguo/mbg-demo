package com.hongguo.mbg.test;

import com.alibaba.fastjson.JSONObject;
import com.hongguo.mbg.config.Configuration;
import com.hongguo.mbg.config.xml.ConfigurationParser;
import com.hongguo.mbg.generator.CodeGenerator;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author hongguo_cheng
 * @date 2018-12-04
 * @description
 */
public class CodeGeneratorTest {

    @Test
    public void test01() {
        ConfigurationParser parser = new ConfigurationParser();
        InputStream inputStream = CodeGenerator.class.getResourceAsStream("/config.xml");
        Configuration configuration = parser.parseConfiguration(inputStream);
        System.out.println(JSONObject.toJSONString(configuration));
    }
}
