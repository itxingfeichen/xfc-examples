package com.xfc.tools;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 数据去重
 *
 * @author xf.chen
 * @date 2021/7/14 11:27 上午
 * @since 1.0.0
 */
public class DataDeduplicationUtil {

    public static void main(String[] args) {

        String data = "11,1,1,1,1,3,4,5,4,5";

        final String[] split = data.split(",");
        final HashSet<String> strings = new HashSet<>(Arrays.asList(split));
        System.out.println(strings.size());

        System.out.println(Arrays.toString(strings.toArray()));
    }
}
