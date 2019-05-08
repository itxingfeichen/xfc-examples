package com.xfc.distributed.netty.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:47
 * @description: request
 */
public class XfHttpRequest {

    private ChannelHandlerContext ctx;
    private HttpRequest request;

    public XfHttpRequest(ChannelHandlerContext ctx, HttpRequest msg) {

        this.ctx=ctx;
        this.request=msg;
    }

    public String getUri(){

        return request.getUri();

    }


    public String getMethod(){

        return request.getMethod().name();

    }


    public Map<String, List<String>> getParameters(){

        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());

        return queryStringDecoder.parameters();

    }


    public String getParameter(String name){
        Map<String, List<String>> parameters = getParameters();
        List<String> strings = parameters.get(name);
        if (strings != null) {
            return strings.get(0);
        }
        return null;

    }




}
