package com.xfc.spring.cloud.service.repository;

import com.xfc.spring.cloud.service.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:15
 * @description: 用户信息持久层
 */
@Repository
public class UserRepository {

    private final ConcurrentHashMap<Long, User> repository = new ConcurrentHashMap<>(16);

    private final AtomicLong atomicLong = new AtomicLong(0);

    public User save(User user) {
        long id = atomicLong.incrementAndGet();
        user.setId(id);
        repository.putIfAbsent(id,user);
        return user;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
