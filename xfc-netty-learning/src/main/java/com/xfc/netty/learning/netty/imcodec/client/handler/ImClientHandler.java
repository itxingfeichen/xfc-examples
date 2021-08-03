package com.xfc.netty.learning.netty.imcodec.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 客户端handler
 *
 * @author xf.chen
 * @date 2021/7/31 23:43
 * @since 1.0.0
 */
public class ImClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接成功:" + ctx.channel().remoteAddress().toString());


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 不再需要自己解析ByteBuf，已经使用了自定义编解码器
        // final ByteBuf byteBuf = (ByteBuf) msg;
        // byte[] bytes = new byte[byteBuf.readableBytes()];
        // byteBuf.readBytes(bytes);
        System.out.println(msg);
    }


}
