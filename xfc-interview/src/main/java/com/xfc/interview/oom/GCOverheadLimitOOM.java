package com.xfc.interview.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/2/25  20:26
 * @description: Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 **/
public class GCOverheadLimitOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        int i =0;
        try {
            while (true){
                list.add(String.valueOf(i++));
            }
        } catch (Throwable e) {
            System.out.println("i == = ==============="+i);
            e.printStackTrace();
            throw e;
        }
    }
}
