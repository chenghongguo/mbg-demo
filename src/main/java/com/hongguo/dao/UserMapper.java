/*
*
* UserMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-04
*/
package com.hongguo.dao;

import com.hongguo.bean.User;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-12-04
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-12-04
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2018-12-04
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2018-12-04
     */
    User selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-12-04
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2018-12-04
     */
    int updateByPrimaryKey(User record);
}