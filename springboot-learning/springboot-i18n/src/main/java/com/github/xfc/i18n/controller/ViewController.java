package com.github.xfc.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return modelAndView;
    }
}

