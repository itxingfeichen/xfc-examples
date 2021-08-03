package com.xfc.netty.learning.netty.codec.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户对象
 *
 * @author xf.chen
 * @date 2021/8/3 22:53
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名字
     */
    private String name;


}
