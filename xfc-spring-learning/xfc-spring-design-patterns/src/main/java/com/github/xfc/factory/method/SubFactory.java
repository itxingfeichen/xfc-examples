package com.github.xfc.factory.method;

import com.github.xfc.factory.common.Operate;
import com.github.xfc.factory.common.SubOperate;

import java.math.BigDecimal;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:07
 * @description: 加法工厂
 */
public class SubFactory extends MethodFactory {
    @Override
    public Operate createOperate() {
        return new SubOperate();
    }
}
