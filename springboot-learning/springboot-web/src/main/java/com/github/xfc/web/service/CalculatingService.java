package com.github.xfc.web.service;

/**
 * @author : chenxingfei
 * @date: 2019-08-03  19:49
 * @description: 累加求和
 */
public interface CalculatingService {

    /**
     * 累加求和
     *
     * @param values
     * @return
     */
    Integer doSum(Integer... values);
}
