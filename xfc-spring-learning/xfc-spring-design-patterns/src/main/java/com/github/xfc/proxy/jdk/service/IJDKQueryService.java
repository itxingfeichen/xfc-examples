package com.github.xfc.proxy.jdk.service;

import com.github.xfc.proxy.common.User;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  14:29
 * @description: 查询用户服务接口
 */
public interface IJDKQueryService {

    User findUser(Long id);
}