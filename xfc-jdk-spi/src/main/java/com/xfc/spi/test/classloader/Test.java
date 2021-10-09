package com.xfc.spi.test.classloader;

/**
 * 测试
 *
 * @author xf.chen
 * @date 2021/10/8 10:51
 * @since 1.0.0
 */
public class Test {

    private static String t = "tret";


    static {
        System.out.println("类加载了。。。。。。。。。。");
    }

    public Test() {
        System.out.println("构造器被调用了");
    }

    public static void test(){
        System.out.println("静态方法。。。。。。。。。。。");

    }
}
