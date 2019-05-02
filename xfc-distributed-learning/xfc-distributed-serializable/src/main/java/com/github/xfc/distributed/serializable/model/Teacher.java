package com.github.xfc.distributed.serializable.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  09:38
 * @description: 深度克隆测试
 */
@Data
public class Teacher implements Serializable {

    private String teacherName;

    private Integer teacherAge;
}
