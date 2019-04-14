package com.github.xfc.factory.method;

import com.github.xfc.factory.common.MulOperate;
import com.github.xfc.factory.common.Operate;

import java.math.BigDecimal;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:07
 * @description: 加法工厂
 */
public class MulFactory extends MethodFactory {
    @Override
    public Operate createOperate() {
        return new MulOperate();
    }
}
