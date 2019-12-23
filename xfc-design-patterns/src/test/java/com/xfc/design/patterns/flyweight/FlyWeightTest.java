package com.xfc.design.patterns.flyweight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 享元模式测试
 * 相同的状态下不同新产生实例对象，这就是享元模式的重要作用，解决了实例过多导致的性能下降问题
 * 并且可以通过外部状态改变相同实例的行为
 */
class FlyWeightTest {

    @Test
    void execute() {
        FlyWeight instance = FlyWeightFactory.getInstance("A");
        final Object resultA = instance.execute("A-state");
        FlyWeight instanceB = FlyWeightFactory.getInstance("B");
        final Object resultB = instanceB.execute("B-state");
        FlyWeight instanceA1 = FlyWeightFactory.getInstance("A");
        final Object resultA1 = instanceA1.execute("A-state-1");
        FlyWeight instanceB1 = FlyWeightFactory.getInstance("B");
        final Object resultB1 = instance.execute("B-state-1");
        System.out.println("resultA = " + resultA);
        System.out.println("resultB = " + resultB);
        System.out.println("resultA-1 = " + resultA1);
        System.out.println("resultB-1 = " + resultB1);
        // 相同的状态下不同新产生实例对象，这就是享元模式的重要作用，解决了实例过多导致的性能下降问题
        Assertions.assertAll("instances", () -> Assertions.assertEquals(instance, instanceA1), () -> Assertions.assertEquals(instanceB, instanceB1));
    }
}