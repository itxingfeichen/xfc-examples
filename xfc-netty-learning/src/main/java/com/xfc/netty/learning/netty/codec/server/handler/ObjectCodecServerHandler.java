package com.xfc.netty.learning.netty.codec.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务端处理器
 *
 * @author xf.chen
 * @date 2021/8/1 21:46
 * @since 1.0.0
 */
public class ObjectCodecServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object user) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + ":" + user);

        ctx.channel().writeAndFlush("您好：" + user);
    }
}
