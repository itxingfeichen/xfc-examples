package com.github.xfc.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("push方法,键值put为null")
    void testHashMapNull() {
        final HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("123", 123);
        hashMap.put(null, null);
        Assertions.assertEquals(null, hashMap.get(null), "is not true");
    }


    @Test
    @DisplayName("push方法")
    void testHashMap() {
        final HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("123", 123);
        Assertions.assertEquals(null, hashMap.get(null), "is not true");
    }

    @Test
    @DisplayName("hash函数测试")
    void testHash() {
        String key = "123";
        final int h = key.hashCode();
        final int i1 = h >>> 16;
        final int hash = h ^ i1;
        System.out.println(((16 - 1) & hash));
        Assertions.assertTrue(((16 - 1) & hash) == 2);
    }

    @Test
    @DisplayName("HashMap构造器isNaN测试")
    void testHashConstructor() {
        final Float aFloat = new Float(0.0 / 0.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HashMap<>(1, aFloat));
    }

    @Test
    @DisplayName("HashMap构造器HashMap<Map>测试")
    void testHashConstructorMap2Map() {
        final HashMap<Object, Integer> hashMap = new HashMap<>(1);
        hashMap.put("123", 321);
        final HashMap<Object, Object> hashMapAdded = new HashMap<>(hashMap);
        Assertions.assertEquals(321, hashMapAdded.get("123"), "is not true");

    }

    @Test
    @DisplayName("HashMap覆盖老值测试")
    void testHashOverrideOldValue() {
        final HashMap<String, Integer> hashMap = new HashMap<>(2);
        hashMap.put("123", 456);
        Assertions.assertEquals(456, hashMap.get("123"), "is not true");

        hashMap.put("123", 4567);
        Assertions.assertEquals(4567, hashMap.get("123"), "is not true");

        // key不存在则put，如果存在则不覆盖，因此
        hashMap.putIfAbsent("123", 45678);
        Assertions.assertNotEquals(45678, hashMap.get("123"), "is not true");

        // null值测试
        hashMap.put("123", null);
        Assertions.assertNull(hashMap.get("123"), "is not true");

        // 如果key存在，但是value是null，则也会被覆盖
        hashMap.putIfAbsent("123", 456);
        Assertions.assertEquals(456, hashMap.get("123"), "is not true");

        // 源码为证
        // if (e != null) { // existing mapping for key
        // V oldValue = e.value;
        // if (!onlyIfAbsent || oldValue == null)
        // e.value = value;
        // afterNodeAccess(e);
        // return oldValue;
        // }
    }

    @Test
    @DisplayName("HashMap加载因子测试(100万数据测试)")
    void testLoadFactor() {
        // 待测试容量
        Integer capacity = 1000000;
        // 默认大小16 ，默认加载因子0.75测试
        HashMap<Integer, Integer> defaultLoadFactor = new HashMap<>();

        final HashMap<String, Long> defaultLoadFactorResult = testMap(defaultLoadFactor, capacity);
        System.out.printf("load factor is 0.75，defaultLoadFactor cost time is %d,conflict count is %d \n", defaultLoadFactorResult.get("costTime"), defaultLoadFactorResult.get("conflictCount"));
        // 默认大小16 ，默认加载因子0.1测试
        HashMap<Integer, Integer> map = new HashMap<>(16, 0.1f);
        final HashMap<String, Long> mapResult = testMap(map, capacity);
        System.out.printf("load factor is 0.1，map cost time is %d,conflict count is %d \n", mapResult.get("costTime"), mapResult.get("conflictCount"));

        // 默认大小16 ，默认加载因子0.5测试
        HashMap<Integer, Integer> map1 = new HashMap<>(16, 0.5f);
        final HashMap<String, Long> map1Result = testMap(map1, capacity);
        System.out.printf("load factor is 0.5，map1 cost time is %d,conflict count is %d \n", map1Result.get("costTime"), map1Result.get("conflictCount"));

        // 默认大小16 ，默认加载因子0.5测试
        HashMap<Integer, Integer> map2 = new HashMap<>(16, 1f);
        final HashMap<String, Long> map2Result = testMap(map2, capacity);
        System.out.printf("load factor is 1，map2 cost time is %d,conflict count is %d \n", map2Result.get("costTime"), map2Result.get("conflictCount"));
    }

    @Test
    @DisplayName("HashMap的tabSizeFor测试")
    void testTabSizeFor() {
        Assertions.assertEquals(1, HashMapTest.tableSizeFor(1));
        Assertions.assertEquals(2, HashMapTest.tableSizeFor(2));
        Assertions.assertEquals(4, HashMapTest.tableSizeFor(3));
        Assertions.assertEquals(4, HashMapTest.tableSizeFor(4));
        Assertions.assertEquals(8, HashMapTest.tableSizeFor(6));
        Assertions.assertEquals(32, HashMapTest.tableSizeFor(18));
    }

    @Test
    @DisplayName("Float.isNaN测试")
    void testFloatIsNaN() {
        Assertions.assertTrue(Float.isNaN(0.75f));
        // Expected :true
        // Actual   :false
        final Float aFloat = new Float(0.0 / 0.0);
        Assertions.assertTrue(aFloat.isNaN());
        // Expected :true
        // Actual   :true
    }

    @Test
    @DisplayName("binCount测试")
    void testBinCount() {
        for (int binCount = 0; ; ++binCount) {
            System.out.println(binCount);
            if (binCount == 7) {
                return;
            }
        }
    }

    @Test
    @DisplayName("hashCode执行流程测试")
    void processStr() {
        final String s = "00000000000000001011111000110010";
        System.out.println(s.length());
        final char[] chars = s.toCharArray();
        final StringBuffer stringBuffer = new StringBuffer();

        for (char aChar : chars) {
            stringBuffer.append(aChar).append(" ");
        }
        System.out.println(stringBuffer);
    }


    /**
     * 猜测0.75的加载因子主要基于性能考虑，因此测试指定map，指定容量的hash耗时
     *
     * @param map      目标map
     * @param capacity 容量
     * @return 耗时
     */
    private HashMap<String, Long> testMap(HashMap<Integer, Integer> map, Integer capacity) {
        Set<Integer> conflictSet = new HashSet<>();
        HashMap<String, Long> result = new HashMap<>(2);
        Long start = System.currentTimeMillis();
        Integer conflictCount = 0;
        for (Integer i = 0; i < capacity; i++) {
            final int index = hash(i) & (16 - 1);
            if (conflictSet.contains(index)) {
                conflictCount++;
            } else {
                conflictSet.add(index);
            }
            map.put(i, i);
        }
        final long costTime = System.currentTimeMillis() - start;
        result.put("costTime", costTime);
        result.put("conflictCount", Long.valueOf(conflictCount));
        return result;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
