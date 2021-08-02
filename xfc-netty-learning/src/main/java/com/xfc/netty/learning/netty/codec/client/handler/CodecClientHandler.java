package com.xfc.netty.learning.netty.codec.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 服务端处理器
 *
 * @author xf.chen
 * @date 2021/8/1 21:46
 * @since 1.0.0
 */
public class CodecClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + ":" + s);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush("您好服务端");
    }
}