package com.github.xfc.factory.abstrac;

import com.github.xfc.factory.common.CarEngine;
import com.github.xfc.factory.common.NormalTire;
import com.github.xfc.factory.common.Tire;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:57
 * @description: 造车工厂
 */
public class LuckyFactory implements AbstractCarFactory {
    @Override
    public Tire createTire() {
        return () -> System.out.println("高端轮胎");
    }

    @Override
    public CarEngine createCarEngine() {
        return () -> System.out.println("低端引擎");
    }

    @Override
    public Car getCar() {
        Car car = new Car();
        car.setCarEngine(createCarEngine());
        car.setTire(createTire());
        return car;
    }
}
