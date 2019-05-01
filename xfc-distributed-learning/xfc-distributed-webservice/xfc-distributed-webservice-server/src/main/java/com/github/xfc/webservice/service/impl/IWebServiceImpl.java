package com.github.xfc.webservice.service.impl;

import com.github.xfc.webservice.service.IWebService;

import javax.jws.WebService;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  21:30
 * @description:
 */
@WebService
public class IWebServiceImpl implements IWebService {
    @Override
    public String sayHelloWebService(String msg) {
        return "server: " + msg;
    }
}
