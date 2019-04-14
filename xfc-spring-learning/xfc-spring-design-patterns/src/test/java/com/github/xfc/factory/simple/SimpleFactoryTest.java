package com.github.xfc.factory.simple;

import com.github.xfc.factory.common.Operate;
import com.github.xfc.factory.common.OperateEnum;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  13:40
 * @description:
 */
public class SimpleFactoryTest {

    @Test
    public void testSimpleFactory() {
        BigDecimal param1 = BigDecimal.valueOf(10);
        BigDecimal param2 = BigDecimal.valueOf(1.01);
        // 加法操作
        Operate operate = SimpleFactory.getOperate(OperateEnum.ADD);
        BigDecimal result1 = operate.operate(param1, param2);
        // 减法操作
        Operate operate1 = SimpleFactory.getOperate(OperateEnum.SUBTRUT);
        BigDecimal result2 = operate1.operate(param1, param2);
        // 乘法操作
        Operate operate2 = SimpleFactory.getOperate(OperateEnum.MUTIPLY);
        BigDecimal result3 = operate2.operate(param1, param2);
        // 除法操作
        Operate operate3 = SimpleFactory.getOperate(OperateEnum.DIVIDE);
        BigDecimal result4 = operate3.operate(param1, param2);

        System.out.println("result1 = " + result1);

        System.out.println("result2 = " + result2);

        System.out.println("result3 = " + result3);

        System.out.println("result4 = " + result4);

    }
}