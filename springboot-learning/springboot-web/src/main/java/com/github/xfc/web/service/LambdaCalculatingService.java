package com.github.xfc.web.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author : chenxingfei
 * @date: 2019-08-03  19:56
 * @description: lambda计算方式
 */
@Service
@Profile("java8")
public class LambdaCalculatingService implements CalculatingService {


    /**
     * 累加求和
     *
     * @param values
     * @return
     */
    @Override
    public Integer doSum(Integer... values) {
        System.out.println("java8 求和");
        return Stream.of(values).reduce(0, Integer::sum);
    }
}
