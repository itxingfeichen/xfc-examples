package com.github.xfc.factory.method;

import com.github.xfc.factory.common.Operate;

import java.math.BigDecimal;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:05
 * @description: 定义方法工厂接口，用于定义一个工厂集合类，所有的子工厂都需要实现相应接口
 * 工厂方法说明
 * 1：解决了简单工厂违背开闭原则的问题
 * 2：每增加一个算法，需要增加一个工厂，并实现工厂方法类
 */
public abstract class MethodFactory {

    /**
     * 定义操作接口(工厂方法，提供给不同的子类工厂实现各自的操作)
     *
     * @return
     */
    abstract Operate createOperate();
}
