package com.xfc.distributed.netty.tomcat.server;

import com.xfc.distributed.netty.tomcat.http.XfHttpRequest;
import com.xfc.distributed.netty.tomcat.http.XfHttpResponse;
import com.xfc.distributed.netty.tomcat.servlet.CustomServlet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:34
 * @description: tomcat处理器
 */
public class XfTomcatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            XfHttpRequest xfHttpRequest = new XfHttpRequest(ctx, request);
            XfHttpResponse xfHttpResponse = new XfHttpResponse(ctx, request);

            new CustomServlet().doGet(xfHttpRequest, xfHttpResponse);


        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
