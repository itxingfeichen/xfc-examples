package com.github.xfc.webservice.service.impl;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  22:12
 * @description:
 */
public class Demo {


    public static void main(String[] args) {

        IWebServiceImplService iWebServiceImplService = new IWebServiceImplService();

        IWebServiceImpl iWebServiceImplPort = iWebServiceImplService.getIWebServiceImplPort();
        System.out.println(iWebServiceImplPort.sayHelloWebService("chenxingfei"));
    }
}
