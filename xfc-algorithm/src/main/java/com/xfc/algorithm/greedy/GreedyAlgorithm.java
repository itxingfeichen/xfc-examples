package com.xfc.algorithm.greedy;

import java.util.*;

/**
 * 贪心算法
 *
 * @author jannik
 * @date 2020-02-04
 */
public class GreedyAlgorithm {

    /**
     * 贪心算法
     *
     * @return 结果
     */
    public String greedyAlgorithm() {
        // 所有的广播站
        Map<String, HashSet<String>> boardcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        boardcasts.put("K1", hashSet1);
        boardcasts.put("K2", hashSet2);
        boardcasts.put("K3", hashSet3);
        boardcasts.put("K4", hashSet4);
        boardcasts.put("K5", hashSet5);

        HashSet<String> allCities = new HashSet<>();
        allCities.add("北京");
        allCities.add("上海");
        allCities.add("天津");
        allCities.add("广州");
        allCities.add("深圳");
        allCities.add("成都");
        allCities.add("杭州");
        allCities.add("大连");

        HashSet<String> temp = new HashSet<>();

        List<String> selectedKeys = new ArrayList<>();

        // 当前长度最大的城市集合
        String maxKey = null;
        // 总的城市集合不等于0则持续进行遍历
        while (allCities.size() != 0) {
            maxKey = null;
            // 遍历所有的
            for (String key : boardcasts.keySet()) {
                temp.clear();
                HashSet<String> cities = boardcasts.get(key);
                temp.addAll(cities);
                temp.retainAll(allCities);
                if (temp.size() > 0 && maxKey == null) {
                    maxKey = key;
                } else if (temp.size() > 0 && temp.size() > boardcasts.get(maxKey).size()) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selectedKeys.add(maxKey);
                // 删除allCities中当前被选出来的集合
                allCities.removeAll(boardcasts.get(maxKey));
            }

        }

        return selectedKeys.toString();

    }

}
