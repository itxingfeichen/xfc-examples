package com.github.xfc.factory.abstrac;

import com.github.xfc.factory.common.CarEngine;
import com.github.xfc.factory.common.Tire;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:49
 * @description: 抽象工厂（造车工厂）
 */
public interface AbstractCarFactory {

    /**
     * 创建轮胎
     *
     * @return
     */
    Tire createTire();

    /**
     * 创建引擎
     *
     * @return
     */
    CarEngine createCarEngine();


    Car getCar();

    //    /**
//     * 创造车
//     * 对于抽象工厂来说，创建车也是产品抽象类
//     *
//     * @return
//     */
//    Car getCar() {
//        Car car = new Car();
//        car.setTire(createTire());
//        car.setCarEngine(createCarEngine());
//        return car;
//    }


}
