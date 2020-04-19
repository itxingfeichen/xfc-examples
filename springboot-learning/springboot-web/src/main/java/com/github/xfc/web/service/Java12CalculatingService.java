package com.github.xfc.web.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author : chenxingfei
 * @date: 2019-08-03  20:06
 * @description: java12测试
 */
@Service
@Profile("java12")
public class Java12CalculatingService {


    /**
     * 计算
     *
     * @param values
     * @return
     */
    public Integer doSum(Integer... values) {
        System.out.println("java12");
        return Stream.of(values).reduce(0, Integer::sum);
    }

}
