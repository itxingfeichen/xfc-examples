package com.github.xfc.webservice;

import com.github.xfc.webservice.service.impl.IWebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  21:28
 * @description: webService服务端
 */
public class WebServiceServer {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/webservice/test", new IWebServiceImpl());
        System.out.println("\"服务端启动\" = " + "服务端启动");
    }
}
