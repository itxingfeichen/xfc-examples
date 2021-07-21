package com.github.xfc.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 本地变量性能测试
 *
 * @author xf.chen
 * @date 2021/7/21 11:24 上午
 * @since 1.0.0
 */
@DisplayName("本地变量性能测试")
public class LocalVariablePerformanceTest {

    private Integer a;

    public LocalVariablePerformanceTest() {
        a = 10000000;
    }


    @Test
    @DisplayName("测试本地变量和实例变量")
    public void testLocalVariableAndInstanceVariable() {
        testInstanceVariable();
        testLocalVariable();
    }

    /**
     * 测试实例变量
     * ps:private修饰的方法无法使用javap查看字节码
     */
    public void testInstanceVariable() {
        final long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < a; i++) {
            count++;
        }
        System.out.printf("实例变量测试耗时 %d,count=%d\n", System.currentTimeMillis() - start, count);

    }

    /**
     * 测试本地变量
     * ps:private修饰的方法无法使用javap查看字节码
     */
    public void testLocalVariable() {
        final long start = System.currentTimeMillis();
        // 赋值为本地变量
        Integer a = this.a;
        int count = 0;
        for (int i = 0; i < a; i++) {
            count++;
        }
        System.out.printf("本地变量测试耗时 %d,count=%d\n", System.currentTimeMillis() - start, count);
    }
}
