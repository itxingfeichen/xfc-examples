package com.xfc.spring.cloud.service.api;

import com.xfc.spring.cloud.service.model.User;

import java.util.Collection;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:05
 * @description: 用户服务 {@link User}
 */
public interface UserService {

    User save(User user);

    Collection<User> findAll();
}
