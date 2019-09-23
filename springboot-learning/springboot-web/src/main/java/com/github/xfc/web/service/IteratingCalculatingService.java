package com.github.xfc.web.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author : chenxingfei
 * @date: 2019-08-03  19:52
 * @description: java7方式求和
 */
@Service
@Profile("java7")
public class IteratingCalculatingService implements CalculatingService {
    /**
     * 累加求和
     *
     * @param values
     * @return
     */
    @Override
    public Integer doSum(Integer... values) {
        Integer sum = 0;
        for (Integer value : values) {

            sum += value;
        }
        System.out.println("java7 求和");
        return sum;
    }
}
