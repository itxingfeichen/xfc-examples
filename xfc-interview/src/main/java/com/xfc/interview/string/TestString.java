package com.xfc.interview.string;

/**
 * string面试题
 *
 * @author jannik
 * @date 2020-02-21
 */
public class TestString {

    public static void main(String[] args) {
        // 创建两个对象 一个在常量池abc ，一个在堆内
        String s1 = new String("abc");

        // 不创建对象，直接只想s1已创建的abc
        String s2 = "abc";

        // 创建一个堆内对象，常量已包含abc对象，则不再创建
        String s3 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);

        System.out.println("===============");
        System.out.println(s1 == s1.intern());
        System.out.println(s2 == s2.intern());
        System.out.println(s1.intern() == s2.intern());
        System.out.println("===============");
        String s4 = "java";
        String s5 = "`ja";
        String s6 = "va";
        System.out.println(s4 == "java");
        System.out.println(s4 == (s5+s6));
        System.out.println(s4 == "ja"+s6);
    }
}
