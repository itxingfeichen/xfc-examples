package com.github.xfc.web.model;

import java.lang.reflect.Field;

/**
 * @author xf.chen
 * @date 2021/9/10 14:12
 * @since 1.0.0
 */
public class APIDemo {

    public void test() {
        System.out.println("test???????????");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s1 = "abc";
        final Field declaredField = String.class.getDeclaredField("value");
        declaredField.setAccessible(true);
        final char[] value = (char[]) declaredField.get(s1);
        value[1] = 'f';
        System.out.println(s1);


    }
}
