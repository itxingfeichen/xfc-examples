package com.github.xfc.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  21:29
 * @description: webservice服务接口
 */
@WebService
public interface IWebService {

    @WebMethod
    String sayHelloWebService(String msg);
}
