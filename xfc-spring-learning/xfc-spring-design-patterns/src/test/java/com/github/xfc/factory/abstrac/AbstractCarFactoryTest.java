package com.github.xfc.factory.abstrac;

import com.github.xfc.factory.common.CarEngine;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:04
 * @description:
 */
public class AbstractCarFactoryTest {


    /**
     * 有多个抽象产品类 ，具体工厂类能创建多个具体产品类的实例
     * CarEngine,
     */
    @Test
    public void testAbstractCarFactory() {
        AbstractCarFactory audiQ5Factory = new AudiQ5Factory();
//        Car car = audiQ5Factory.getCar();
//        car.getTire().normalTire();
//        car.getCarEngine().normalCarEngine();
        CarEngine carEngine = audiQ5Factory.createCarEngine();
        carEngine.normalCarEngine();
        audiQ5Factory.createTire().normalTire();

        AbstractCarFactory luckyFactory = new LuckyFactory();
        System.out.println("==================");
        luckyFactory.createCarEngine().normalCarEngine();
        luckyFactory.createTire().normalTire();
//        Car car1 = luckyFactory.getCar();
//        car1.getTire().normalTire();
//        car1.getCarEngine().normalCarEngine();
    }

}