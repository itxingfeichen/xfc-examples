package com.xfc.design.patterns.bridge;

/**
 * 通过车的抽象来模拟桥接模式
 *
 * @author xf
 * @date 2019/12/23 16:33
 */
public abstract class AbstractCar {

    protected Transmission transmission;

    /**
     * 抽象出车运行
     */
    public abstract void run();

    /**
     * 设置变速器
     *
     * @param transmission
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
