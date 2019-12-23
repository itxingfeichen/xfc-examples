package com.xfc.design.patterns.bridge;

/**
 * 奔驰
 *
 * @author xf
 * @date 2019/12/23 16:44
 */
public class Benz extends AbstractCar {
    /**
     * 抽象出车运行
     */
    @Override
   public void run() {
        transmission.gear();
        System.out.println("i am benz");
    }
}
