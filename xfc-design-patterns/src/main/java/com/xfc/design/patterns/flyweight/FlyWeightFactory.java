package com.xfc.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author xf
 * @date 2019/12/23 15:40
 */
public class FlyWeightFactory {

    /**
     * 享元池
     */
    private final static Map<String, FlyWeight> flyWeightFactories = new HashMap<>();


    /**
     * 根据名称获取享元类
     *
     * @param name
     * @return
     */
    public static FlyWeight getInstance(String name) {
        // double check for thread security
        if (flyWeightFactories.get(name) == null) {
            synchronized (flyWeightFactories) {
                if (flyWeightFactories.get(name) == null) {
                    flyWeightFactories.put(name, new ConcreteFlyWeight(name));
                }

            }
        }
        return flyWeightFactories.get(name);
    }


}
