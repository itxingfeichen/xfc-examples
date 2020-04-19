package com.xfc.interview.string;

import java.util.HashMap;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/2/22  11:05
 * @description:
 **/
public class MapTest {


    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>(16);


        map.put("1", "1");
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
