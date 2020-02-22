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
        // false s1指向堆中的地址，s2指向常量池
        System.out.println(s1 == s2);
        // false s3指向堆中的地址，s2指向常量池
        System.out.println(s2 == s3);
        // false s1指向堆中的地址， s3指向堆中的地址
        System.out.println(s1 == s3);

        System.out.println("===============");
        // false s1指向堆中的地址，s1.intern()返回的是常量池的地址
        System.out.println(s1 == s1.intern());
        // true s2，s2.intern()均指向常量池的地址
        System.out.println(s2 == s2.intern());
        // true s1.intern()，s2.intern()均指向常量池的地址
        System.out.println(s1.intern() == s2.intern());
        System.out.println("===============");
        String s4 = "java";
        String s5 = "ja";
        String s6 = "va";

        // todo 基本原则  变量指向堆，常量指向pool of String
        // true s4,"java"均指向常量池的地址并且为同一个对象
        System.out.println(s4 == "java");
        // false s4指向常量池，s5+s6会创建新对象 java8和其他版本的加号操作不太一样，java8使用的是append，之前是使用的new String
        System.out.println(s4 == (s5+s6));
        // false s4指向常量池，"ja"+s6会创建新对象
        System.out.println(s4 == "ja"+s6);
    }
}
