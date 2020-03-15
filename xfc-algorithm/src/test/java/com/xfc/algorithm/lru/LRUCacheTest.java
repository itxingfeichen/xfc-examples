package com.xfc.algorithm.lru;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testLRU() {

        LRUCache lruCache = new LRUCache(5);


        for (int i = 0; i < 6; i++) {
            lruCache.put("00"+i,"用户信息"+i);
        }

        String value = lruCache.get("000");
        String value1 = lruCache.get("002");

        lruCache.remove("003");
        System.out.println(value1);

    }

}