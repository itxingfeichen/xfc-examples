package com.xfc.spring.cloud.consumer.service;

import com.xfc.spring.cloud.service.api.UserService;
import com.xfc.spring.cloud.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:31
 * @description: 用户服务
 */
@Service
public class UserConsumerService {

    @Autowired
    private RestTemplate restTemplate;


    private static final String SERVER_PROVIDER_URL = "http://user-server-app";

    public boolean save(User user) {
        User user1 = restTemplate.postForObject(SERVER_PROVIDER_URL + "/save", user, User.class);
        return user1 != null;

    }

    public Collection<User> findAll() {
        return restTemplate.getForObject(SERVER_PROVIDER_URL+"/findAll",Collection.class);

    }


}
