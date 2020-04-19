package com.github.xfc.factory.common;

import java.math.BigDecimal;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  13:29
 * @description: 操作接口
 */
public interface Operate {

    /**
     * 操作接口
     *
     * @param param1
     * @param param2
     * @return
     */
    BigDecimal operate(BigDecimal param1, BigDecimal param2);
}
