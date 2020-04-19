package com.xfc.distributed.netty.tomcat.servlet;

import com.xfc.distributed.netty.tomcat.http.XfHttpRequest;
import com.xfc.distributed.netty.tomcat.http.XfHttpResponse;

import java.io.UnsupportedEncodingException;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:49
 * @description: servlet
 */
public class CustomServlet implements XfServlet {
    @Override
    public void doGet(XfHttpRequest request, XfHttpResponse response) {
        try {
            response.write(request.getParameter("name"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(XfHttpRequest request, XfHttpResponse response) {

        doGet(request, response);
    }
}
