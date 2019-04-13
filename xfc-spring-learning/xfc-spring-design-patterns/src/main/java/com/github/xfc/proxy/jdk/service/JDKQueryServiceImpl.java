package com.github.xfc.proxy.jdk.service;

import com.github.xfc.proxy.jdk.mapper.JDKQueryMapper;
import com.github.xfc.proxy.jdk.model.User;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  14:29
 * @description: 查询用户服务实现类
 */
public class JDKQueryServiceImpl implements IJDKQueryService {

    private JDKQueryMapper jdkQueryMapper;

    public JDKQueryServiceImpl() {
        this.jdkQueryMapper = new JDKQueryMapper() {
            public User findUser(Long id) {
                return new User("张三", id, "xingfeichen@163.com");
            }
        };
    }

    public User findUser(Long id) {
        return jdkQueryMapper.findUser(id);
    }
}
