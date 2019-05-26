package com.xfc.spring.cloud.service.provider;

import com.xfc.spring.cloud.service.api.UserService;
import com.xfc.spring.cloud.service.model.User;
import com.xfc.spring.cloud.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:14
 * @description: 用户接口实现
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
