package com.github.xfc.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * HashMap测试类
 *
 * @author xf.chen
 * @date 2021/7/9 2:44 下午
 * @since 1.0.0
 */
@DisplayName("HashMap测试")
public class HashMapTest {

    @Test
    @DisplayName("push方法")
    void testHashMap() {
        final HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("12332", 123);

        Assertions.assertEquals(123, hashMap.get("123"), "is not true");
    }

    @Test
    @DisplayName("hash函数测试")
    void testHash(){
        String key =  "12332";
        final int h = key.hashCode();
        final int i1 = h >>> 16;
        final int hash = h ^ i1;
        System.out.println("position = " + ((16-1) & hash));
    }
}
