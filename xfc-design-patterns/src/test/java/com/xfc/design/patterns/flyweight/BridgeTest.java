package com.xfc.design.patterns.flyweight;

import com.xfc.design.patterns.bridge.*;
import org.junit.jupiter.api.Test;

/**
 * 桥接模式测试
 *
 * @author xf
 * @date 2019/12/23 16:46
 */
public class BridgeTest {

    @Test
    public void testBridge() {
        AbstractCar benz = new Benz();
        benz.setTransmission(new AutoGear());
        benz.run();
        System.out.println("======================================");
        AbstractCar bwm = new BWM();
        bwm.setTransmission(new ManualGear());
        bwm.run();

    }
}
