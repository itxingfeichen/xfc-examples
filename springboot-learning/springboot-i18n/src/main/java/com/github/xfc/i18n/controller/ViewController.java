package com.github.xfc.i18n.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    @RequestMapping("/locale")
    public ModelAndView locale() {
        ModelAndView modelAndView = new ModelAndView("/locale");

        List<String> products = new ArrayList<>();

        products.add("P1");
        products.add("P2");
        products.add("P3");
//        products.add("P4");
        modelAndView.addObject("products",products);
        modelAndView.addObject("t","bbb");
        modelAndView.addObject("x","ccc");
        return modelAndView;
    }

    @RequestMapping("test")
    @ResponseBody
    public ResponseEntity<ResponseResult> test(){

        ResponseEntity<ResponseResult> ok = ResponseEntity.ok(ResponseResult.success());
        return ok;
    }


    @RequestMapping("test1")
    @ResponseBody
    public ResponseResult test1(){
        return ResponseResult.success();
    }


    @RequestMapping("test3")
    @ResponseBody
    public ResponseEntity<ResponseResult> test3(){

//        ResponseEntity<ResponseResult> ok = ResponseEntity.ok(ResponseResult.success());

        return ResponseEntity.notFound().header("errore1", "错误").build();
//        return ok;
    }

    @RequestMapping("test4")
    @ResponseBody
    public ResponseResult test4(){
        return ResponseResult.errCode("E00001",new Object[]{"用户名","密码"});
    }
}

