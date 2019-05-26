package com.xfc.spring.cloud.service.controller;

import com.xfc.spring.cloud.service.api.UserService;
import com.xfc.spring.cloud.service.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author : chenxingfei
 * @date: 2019-05-26  14:54
 * @description:
 */
@RestController
public class UserApiController {


    private final UserService userService;


    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.save(user);

    }


    @GetMapping("/findAll")
    public Collection<User> findAll(){
        return userService.findAll();
    }
}
