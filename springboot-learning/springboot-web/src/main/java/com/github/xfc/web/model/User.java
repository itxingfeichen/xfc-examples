package com.github.xfc.web.model;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:48
 * @description: user model
 */
@Data
public class User {

    private String username;

    private Integer age;


    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
