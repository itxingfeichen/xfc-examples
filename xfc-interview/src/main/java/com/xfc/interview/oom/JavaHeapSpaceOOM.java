package com.xfc.interview.oom;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/2/25  20:26
 * @description:
 **/
public class JavaHeapSpaceOOM {

    public static void main(String[] args) {

        byte[] b = new byte[30 * 1024 * 1024];
    }
}
