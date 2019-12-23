package com.xfc.design.patterns.flyweight;

/**
 * 具体享元类，实现享元接口。该类的对象将被复用
 *
 * @author xf
 * @date 2019/12/23 15:34
 */
public class ConcreteFlyWeight implements FlyWeight {

    /**
     * 实例名称
     */
    private String name;

    public ConcreteFlyWeight(String name) {
        this.name = name;
    }

    /**
     * 享元模式中的方法
     *
     * @param externalState 外部状态
     * @return
     */
    @Override
    public Object execute(String externalState) {
        return this.name + " -> " + externalState + " -> " + this.hashCode();
    }
}
