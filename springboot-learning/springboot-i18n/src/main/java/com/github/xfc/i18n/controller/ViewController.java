package com.github.xfc.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    @RequestMapping("/locale")
    public ModelAndView locale() {
        ModelAndView modelAndView = new ModelAndView("/locale");
        modelAndView.addObject("welcome.text","不好意思我们的key相同了");
        modelAndView.addObject("text11","不好意思2222");
        return modelAndView;
    }
}

