package com.xfc.spring.cloud.consumer.controller;

import com.xfc.spring.cloud.consumer.service.UserConsumerService;
import com.xfc.spring.cloud.service.api.UserService;
import com.xfc.spring.cloud.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:28
 * @description: 用户信息控制器
 */
@RestController
public class UserController {

    public UserController(UserConsumerService userConsumerService) {
        this.userConsumerService = userConsumerService;
    }

    private final UserConsumerService userConsumerService;




    @PostMapping("/save")
    public boolean save(User user){
        return userConsumerService.save(user);

    }


    @GetMapping("findAll")
    public Collection<User> findAll(){
        return userConsumerService.findAll();
    }
}
