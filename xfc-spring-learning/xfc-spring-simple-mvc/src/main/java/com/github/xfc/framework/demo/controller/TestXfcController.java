package com.github.xfc.framework.demo.controller;

import com.github.xfc.framework.annotation.XfcAutowired;
import com.github.xfc.framework.annotation.XfcController;
import com.github.xfc.framework.annotation.XfcRequestMapping;
import com.github.xfc.framework.annotation.XfcRequestParam;
import com.github.xfc.framework.demo.service.TestXfcService;
import com.github.xfc.framework.demo.service.impl.TestXfcWithNameServiceImpl;
import com.github.xfc.framework.servlet.XfcModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  18:34
 * @description: testController
 */
@XfcController
public class TestXfcController {

    @XfcAutowired
    private TestXfcService testXfcService;

    @XfcAutowired(value = "customName")
    private TestXfcWithNameServiceImpl testXfcWithNameService;

    @XfcRequestMapping("/test")
    public void testRequestUrl(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("test");
    }


    /**
     * 测试
     * @param request
     * @param response
     * @param name
     * @param addr
     * @return
     */
    @XfcRequestMapping("/addTest")
    public XfcModelAndView addTest(HttpServletRequest request, HttpServletResponse response,
                                   @XfcRequestParam("name") String name, @XfcRequestParam("addr") String addr) {
        XfcModelAndView xfcModelAndView = new XfcModelAndView("text.xfcml");
        Map<String, Object> model = xfcModelAndView.getModel();
        model.put("addr", addr);
        model.put("name", name);
        return xfcModelAndView;
    }
}
