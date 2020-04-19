package com.xfc.design.patterns.flyweight;

/**
 * 享元接口
 *
 * @author xf
 * @date 2019/12/23 15:32
 */
public interface FlyWeight {

    /**
     * 享元模式中的方法
     *
     * @param state
     * @return
     */
    Object execute(String state);
}
