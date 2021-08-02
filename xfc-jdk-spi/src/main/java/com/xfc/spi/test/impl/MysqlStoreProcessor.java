package com.xfc.spi.test.impl;

import com.xfc.spi.test.StoreProcessor;

/**
 * redis持久化
 *
 * @author xf.chen
 * @date 2021/8/1 16:08
 * @since 1.0.0
 */
public class MysqlStoreProcessor implements StoreProcessor {
    /**
     * 持久化
     */
    @Override
    public void store() {
        System.out.println("mysql store");
    }
}
