package com.github.xfc.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ArrayList和LinkedList查找速度比较
 *
 * @author xf.chen
 * @date 2021/9/3 14:03
 * @since 1.0.0
 */
public class WhoIsFaster {

    public static void main(String[] args) {
        final ArrayList<Integer> arrayList = new ArrayList<>(10000000);
        final LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i <= 10000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 假设都查找10000000
        final long start = System.currentTimeMillis();
        for (Integer integer : arrayList) {
            if (integer == 10000000) {
                System.out.printf("查找结束，耗时：%d", System.currentTimeMillis() - start);
                System.out.println();
            }
        }

        // 假设都查找10000000
        final long startLink = System.currentTimeMillis();
        for (Integer integer : linkedList) {
            if (integer == 10000000) {
                System.out.printf("查找结束，耗时：%d", System.currentTimeMillis() - startLink);
                System.out.println();
            }
        }

    }
}
