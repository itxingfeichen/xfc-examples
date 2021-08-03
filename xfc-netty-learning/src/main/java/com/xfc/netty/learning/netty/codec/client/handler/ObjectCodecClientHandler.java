package com.xfc.netty.learning.netty.codec.client.handler;

import com.xfc.netty.learning.netty.codec.model.User;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务端处理器
 *
 * @author xf.chen
 * @date 2021/8/1 21:46
 * @since 1.0.0
 */
public class ObjectCodecClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final User user = new User();
        user.setId(1);
        user.setName("xingyi");
        ctx.writeAndFlush(user);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object user) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + ":" + user);
    }
}