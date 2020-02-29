package com.xfc.interview.string;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/2/25  14:40
 * @description:
 **/
public class WeakHashMapTest {

    public static void main(String[] args) throws InterruptedException {

        WeakHashMap<Integer,Integer> map = new WeakHashMap<>();

        Integer integer = new Integer(1);

        map.put(integer,1);

        System.out.println(map);
        integer = null;

        System.gc();

        TimeUnit.SECONDS.sleep(2);

        System.out.println(map);



        WeakReference weakReference = new WeakReference(integer);

        Object o = weakReference.get();
        System.out.println("o = " + o);


    }
}
