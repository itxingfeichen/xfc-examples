package com.github.xfc.proxy.common;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  13:58
 * @description: 用户模型
 */
@Data
public class User {

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户年龄
     */
    private Long age;
    /**
     * 用户邮箱
     */
    private String email;

    public User(String userName, Long age, String email) {
        this.userName = userName;
        this.age = age;
        this.email = email;
    }
}
