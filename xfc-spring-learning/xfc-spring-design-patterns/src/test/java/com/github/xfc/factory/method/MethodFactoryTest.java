package com.github.xfc.factory.method;

import com.github.xfc.factory.common.Operate;
import com.github.xfc.factory.common.OperateEnum;
import com.github.xfc.factory.simple.SimpleFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  14:11
 * @description:
 */
public class MethodFactoryTest {

    @Test
    public void testMethodFactory() {

        BigDecimal param1 = BigDecimal.valueOf(10);
        BigDecimal param2 = BigDecimal.valueOf(1.01);
        // 加法操作
        MethodFactory addFactory = new AddFactory();
        BigDecimal result1 = addFactory.createOperate().operate(param1, param2);
        // 减法操作
        MethodFactory subFactory = new SubFactory();
        BigDecimal result2 = subFactory.createOperate().operate(param1, param2);
        // 乘法操作
        MethodFactory mulFactory = new MulFactory();
        BigDecimal result3 = mulFactory.createOperate().operate(param1, param2);
        // 除法操作
        MethodFactory divideFactory = new DivideFactory();
        BigDecimal result4 = divideFactory.createOperate().operate(param1, param2);

        System.out.println("result1 = " + result1);

        System.out.println("result2 = " + result2);

        System.out.println("result3 = " + result3);

        System.out.println("result4 = " + result4);
    }
}