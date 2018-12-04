/*
*
* User.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-04
*/
package com.hongguo.bean;

import java.util.Date;

public class User {
    /**
     * PRIMARY ID
     */
    private Long id;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private Boolean userGender;

    /**
     * 
     */
    private Long userSalary;

    /**
     * 
     */
    private Date userBirthday;

    /**
     * PRIMARY ID
     * @return id PRIMARY ID
     */
    public Long getId() {
        return id;
    }

    /**
     * PRIMARY ID
     * @param id PRIMARY ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return user_gender 
     */
    public Boolean getUserGender() {
        return userGender;
    }

    /**
     * 
     * @param userGender 
     */
    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    /**
     * 
     * @return user_salary 
     */
    public Long getUserSalary() {
        return userSalary;
    }

    /**
     * 
     * @param userSalary 
     */
    public void setUserSalary(Long userSalary) {
        this.userSalary = userSalary;
    }

    /**
     * 
     * @return user_birthday 
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 
     * @param userBirthday 
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}