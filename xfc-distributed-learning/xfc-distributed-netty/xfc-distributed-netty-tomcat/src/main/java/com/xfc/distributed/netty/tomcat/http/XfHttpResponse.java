package com.xfc.distributed.netty.tomcat.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:47
 * @description: response
 */
public class XfHttpResponse {

    private ChannelHandlerContext ctx;
    private HttpRequest request;


    public XfHttpResponse(ChannelHandlerContext ctx, HttpRequest msg) {
        this.ctx = ctx;

        this.request = msg;
    }

    public void write(String out) throws UnsupportedEncodingException {

        try {
            FullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(out.getBytes("utf-8")));

            defaultFullHttpResponse.headers()
                    .set(HttpHeaders.Names.CONTENT_TYPE, "text/json")
                    .set(HttpHeaders.Names.CONTENT_LENGTH, defaultFullHttpResponse.content().readableBytes())
                    .set(HttpHeaders.Names.EXPIRES, 0);
            // 如果是长连接
            if (HttpHeaders.isKeepAlive(request)) {
                defaultFullHttpResponse.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);

            }
            ctx.write(defaultFullHttpResponse);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            ctx.flush();

        }

    }
}
