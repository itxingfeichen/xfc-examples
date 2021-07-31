package com.xfc.experience.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户对象
 *
 * @author xf.chen
 * @date 2021/7/31 7:47 上午
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private transient String name;

    /**
     * 年龄
     */
    private static Integer age = 19;

    /**
     * 邮箱
     */
    private static transient String email = "xingfeichen@163.com";




}
