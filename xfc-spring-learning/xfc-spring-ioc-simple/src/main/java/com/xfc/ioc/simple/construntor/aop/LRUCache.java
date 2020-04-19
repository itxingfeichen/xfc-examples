package com.xfc.ioc.simple.construntor.aop;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/1  16:31
 * @description:
 **/
public class LRUCache {

    private volatile Map<String, String> lruMap;
    private int cacheSize;

    public LRUCache(int initSize) {
        this.cacheSize = initSize;
        this.lruMap = new LinkedHashMap<String, String>(initSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                //size()获取map中当前元素数量,和初始设置的值做比较
                //超过预设则删除 eldest(年龄最大的)
                return size() > LRUCache.this.cacheSize;
            }
        };
    }

    public String get(String inKey) {
        if (inKey.isEmpty() || this.lruMap.isEmpty()) {
            return null;
        }
        for (String key : lruMap.keySet()) {
            if (key.equals(inKey)) {
                return lruMap.get(key);
            }
        }
        return null;
    }

    public synchronized boolean put(String key, String value) {
        this.lruMap.put(key, value);
        return true;
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);

        for (int i = 0; i < 20; i++) {
            lruCache.put(i + "", i + "");

        }

    }
}
