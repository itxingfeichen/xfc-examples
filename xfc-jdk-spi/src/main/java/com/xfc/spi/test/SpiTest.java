package com.xfc.spi.test;

import java.util.ServiceLoader;

/**
 * 测试
 *
 * @author xf.chen
 * @date 2021/8/1 16:10
 * @since 1.0.0
 */
public class SpiTest {

    public static void main(String[] args) {
        final ServiceLoader<StoreProcessor> serviceLoader = ServiceLoader.load(StoreProcessor.class);

        for (StoreProcessor storeProcessor : serviceLoader) {
            storeProcessor.store();
        }

    }
}
