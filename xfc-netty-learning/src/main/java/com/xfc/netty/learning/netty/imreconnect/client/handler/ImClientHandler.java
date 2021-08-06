package com.xfc.netty.learning.netty.imreconnect.client.handler;

import com.xfc.netty.learning.netty.imreconnect.client.ImClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 客户端handler
 *
 * @author xf.chen
 * @date 2021/7/31 23:43
 * @since 1.0.0
 */
public class ImClientHandler extends ChannelInboundHandlerAdapter {

    private ImClient client;

    public ImClientHandler(ImClient imClient) {
        this.client = imClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接成功:" + ctx.channel().remoteAddress().toString());
        final Scanner scanner = new Scanner(System.in);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("连接断开，准备重连。。。");
        client.connect();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 不再需要自己解析ByteBuf，已经使用了自定义编解码器
        // final ByteBuf byteBuf = (ByteBuf) msg;
        // byte[] bytes = new byte[byteBuf.readableBytes()];
        // byteBuf.readBytes(bytes);
        System.out.println("接收到：" + msg);

    }

    /**
     * Calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param evt
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                // 写空闲时发送心跳信息
                final ByteBuf byteBuf = Unpooled.copiedBuffer("ping".getBytes(StandardCharsets.UTF_8));

                ctx.writeAndFlush(byteBuf);
            }
        }
    }
}
