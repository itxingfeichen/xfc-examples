package com.github.xfc.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-07-18  07:53
 * @description: 测试
 */
@RestController
public class TestController {

    /**
     * servlet异步（错误示范）
     * @param request
     * @return
     */
    @GetMapping("asyncTest")
    public String asyncTest(HttpServletRequest request){

        AsyncContext asyncContext = request.getAsyncContext();

        asyncContext.start(()-> {
            try {
                asyncContext.getResponse().getWriter().write("hello async");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "???";
    }
}
