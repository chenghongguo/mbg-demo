package com.hongguo.mbg.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chenghongguo
 * @date: 2018-12-04
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JDBCConnectionConfiguration {

    private String driverClass;

    private String url;

    private String username;

    private String password;
}
