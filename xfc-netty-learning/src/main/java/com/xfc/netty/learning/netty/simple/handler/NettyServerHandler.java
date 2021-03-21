package com.xfc.netty.learning.netty.simple.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * 自定义handler
 *
 * @author xf.chen
 * @date 2021/3/21
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);

        System.out.println("server ctx ="+ctx);

        ByteBuf byteBuf  = (ByteBuf) msg;

        System.out.println("客户端消息="+byteBuf.toString(StandardCharsets.UTF_8));
        System.out.println("客户端地址="+ctx.channel().remoteAddress());

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello"+ctx.channel().remoteAddress(),StandardCharsets.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
