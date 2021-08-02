package com.xfc.netty.learning.netty.im.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.charset.StandardCharsets;

/**
 * 服务端handler
 *
 * @author xf.chen
 * @date 2021/7/31 23:42
 * @since 1.0.0
 */
public class ImServerHandler extends ChannelInboundHandlerAdapter {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final String currentClient = ctx.channel().remoteAddress().toString();
        System.out.println(currentClient + " 连接成功");
        final ByteBuf byteBuf = Unpooled.copiedBuffer((currentClient + " 已上线").getBytes(StandardCharsets.UTF_8));
        channels.writeAndFlush(byteBuf);
        // 将自己加入渠道中
        channels.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        ctx.channel().close();
        final String currentClient = ctx.channel().remoteAddress().toString();
        System.out.println(currentClient + " 断开连接");
        // 通知其他客户端，当前客户端下线
        String message = currentClient + " 下线了";
        System.out.println(message);
        final ByteBuf byteBuf = Unpooled.copiedBuffer(message.getBytes(StandardCharsets.UTF_8));
        channels.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        final String currentClient = ctx.channel().remoteAddress().toString();
        String message = currentClient + " 发送：" + new String(bytes);
        System.out.println(message);
        for (Channel channel : channels) {
            if (channel == ctx.channel()) {
                message = "我：" + new String(bytes);
            } else {
                message = currentClient + " 发送：" + new String(bytes);
            }
            final ByteBuf buffer = Unpooled.copiedBuffer(message.getBytes(StandardCharsets.UTF_8));
            channel.writeAndFlush(buffer);
        }
    }
}
