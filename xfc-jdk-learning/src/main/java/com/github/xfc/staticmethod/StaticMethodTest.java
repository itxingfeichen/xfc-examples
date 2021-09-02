package com.github.xfc.staticmethod;


/**
 * 为什么静态方法不能调用非静态方法
 *
 * @author xf.chen
 * @date 2021/9/2 07:31
 * @since 1.0.0
 */
public class StaticMethodTest {

    /**
     * 非静态方法
     */
    public void normalMethod(String data) {
        // 非静态方法调用静态方法
        staticMethod(data);
    }

    /**
     * 静态方法
     */
    public static void staticMethod(String data) {
        System.out.println("static:" + data);
    }


    public static void main(String[] args) {
        // 静态方法调用
        StaticMethodTest.staticMethod("hello");
        // 实例化
        final StaticMethodTest palindrome = new StaticMethodTest();
        // 非静态方法调用
        palindrome.normalMethod("xf");
        // 通过实例对象调用非静态方法调用
        palindrome.staticMethod("chen");
    }

}
