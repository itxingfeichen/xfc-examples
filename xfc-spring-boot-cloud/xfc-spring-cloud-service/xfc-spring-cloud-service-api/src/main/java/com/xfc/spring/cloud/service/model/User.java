package com.xfc.spring.cloud.service.model;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:05
 * @description: 用户模型
 */
public class User implements Serializable {

    private long id;

    private String username;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
