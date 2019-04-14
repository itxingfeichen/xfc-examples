package com.github.xfc.factory.abstrac;

import com.github.xfc.factory.common.CarEngine;
import com.github.xfc.factory.common.NormalTire;
import com.github.xfc.factory.common.Tire;

import java.util.HashMap;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:57
 * @description: 造车工厂
 */
public class AudiQ5Factory implements AbstractCarFactory {
    @Override
    public Tire createTire() {
        return new NormalTire();
    }

    @Override
    public CarEngine createCarEngine() {
        return () -> System.out.println("高端引擎");
    }

    @Override
    public Car getCar() {
        Car car = new Car();
        car.setCarEngine(createCarEngine());
        car.setTire(createTire());
        return car;
    }
}
