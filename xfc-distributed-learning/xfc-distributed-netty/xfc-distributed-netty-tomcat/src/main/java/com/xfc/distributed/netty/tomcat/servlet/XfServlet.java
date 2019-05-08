package com.xfc.distributed.netty.tomcat.servlet;

import com.xfc.distributed.netty.tomcat.http.XfHttpRequest;
import com.xfc.distributed.netty.tomcat.http.XfHttpResponse;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:45
 * @description: servlet
 */
public interface XfServlet {

    void doGet(XfHttpRequest request, XfHttpResponse response);


    void doPost(XfHttpRequest request, XfHttpResponse response);
}
