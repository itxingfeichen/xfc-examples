package com.github.xfc.proxy.cglib.mapper;

import com.github.xfc.proxy.common.User;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  20:56
 * @description: cglib数据查询mapper
 */
public interface CglibQueryMapper {


    User findUser(Long id);
}
