package com.xf.source.jvm.memory;

/**
 * 字符串测试
 *
 * @author xf.chen
 * @date 2020-09-13
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "1";

        String s3 = s1+s2;

        String s4 = "11";

        System.out.println(s3.intern() == s4);

//        test2();
    }

    public static void test1(){
        String s1 = "1";
    }

    public static void test2(){
        String s1 = new String("2");
        String s2 = new String("2");
    }
}
