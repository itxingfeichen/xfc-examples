package com.github.xfc.proxy.cglib.service;

import com.github.xfc.proxy.cglib.mapper.CglibQueryMapper;
import com.github.xfc.proxy.common.User;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  14:29
 * @description: 查询用户服务实现类
 */
public class CglibQueryServiceImpl implements ICglibQueryService {

    private CglibQueryMapper jdkQueryMapper;

    public CglibQueryServiceImpl() {
        this.jdkQueryMapper = new CglibQueryMapper() {
            @Override
            public User findUser(Long id) {
                return new User("李四", id, "xingfeichen@163.com");
            }
        };
    }

    @Override
    public User findUser(Long id) {
        return jdkQueryMapper.findUser(id);
    }
}
