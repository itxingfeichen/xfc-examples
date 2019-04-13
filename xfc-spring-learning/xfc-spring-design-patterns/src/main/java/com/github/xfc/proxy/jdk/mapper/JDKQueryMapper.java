package com.github.xfc.proxy.jdk.mapper;

import com.github.xfc.proxy.jdk.model.User;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  13:32
 * @description: 模拟数据查询mapper
 */
public interface JDKQueryMapper {


    User findUser(Long id);
}
