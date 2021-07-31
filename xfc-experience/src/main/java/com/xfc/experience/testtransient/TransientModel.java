package com.xfc.experience.testtransient;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试model
 *
 * @author xf.chen
 * @date 2021/7/30 23:36 下午
 * @since 1.0.0
 */
@Data
public class TransientModel {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * 原子类
     */
    private final transient AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * 获取下一个ID
     *
     * @return id
     */
    public Integer nextId() {
        return atomicInteger.getAndIncrement();
    }
}
