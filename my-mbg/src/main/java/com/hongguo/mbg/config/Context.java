package com.hongguo.mbg.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2018-12-04
 * @description:
 */
@Data
public class Context {

    private JDBCConnectionConfiguration jdbcConnectionConfiguration;

    private List<TableConfiguration> tableConfigurations;

    public Context() {
        tableConfigurations = new ArrayList<>();
    }

}
