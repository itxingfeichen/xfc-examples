package com.xfc.design.patterns.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动变速器
 *
 * @author xf
 * @date 2019/12/23 16:41
 */
public class AutoGear implements Transmission {
    /**
     * 变速
     */
    @Override
    public void gear() {
        System.out.println("i am a auto gear car");
    }
}
