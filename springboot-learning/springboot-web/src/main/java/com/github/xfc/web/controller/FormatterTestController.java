package com.github.xfc.web.controller;

import com.github.xfc.autoconfigure.formatter.Formatter;
import com.github.xfc.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:47
 * @description: test formatter auto configuration
 */
@RestController
@RequestMapping("formatter")
public class FormatterTestController {

    @Autowired
    private Formatter formatter;

    @RequestMapping("testDefaultFormatter")
    public String testDefaultFormatter(User user) {
        return formatter.format(user);
    }
}
