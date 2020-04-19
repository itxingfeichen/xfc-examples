package com.github.xfc.factory.common;

import java.math.BigDecimal;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  13:26
 * @description: 除操作
 */
public class DivideOperate implements Operate {

    /**
     * 返回操作结果
     *
     * @param param1
     * @param param2
     * @return
     */
    @Override
    public BigDecimal operate(BigDecimal param1, BigDecimal param2) {
        return param1.divide(param2, 3, BigDecimal.ROUND_HALF_UP);
    }
}
