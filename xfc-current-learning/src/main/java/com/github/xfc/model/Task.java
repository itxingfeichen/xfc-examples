package com.github.xfc.model;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-04-02  22:01
 * @description: 任务类
 */
@Data
public class Task implements Comparable {

    /**
     * 任务id
     */
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务属性
     */
    private String attribute;

    @Override
    public int compareTo(Object o) {
        Task target = (Task) o;
        return -Long.compare(this.id, target.getId());
    }
}
