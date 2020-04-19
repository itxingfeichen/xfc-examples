package com.github.xfc.controller;

import com.github.xfc.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019/4/8  10:52
 * @description: swagger2测试controller
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2测试接口", tags = "测试接口")
public class Swagger2TestController {


    @ApiOperation(value = "获取用户详细信息", notes = "根据用户的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "Integer")
    @GetMapping(value = "/findById")
    public User findById(@RequestParam(value = "id") int id) {
        return new User("张三", "12345");
    }
}
