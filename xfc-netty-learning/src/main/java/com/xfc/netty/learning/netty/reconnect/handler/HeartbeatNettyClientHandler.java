package com.xfc.netty.learning.netty.reconnect.handler;

import com.xfc.netty.learning.netty.reconnect.HeartbeatNettyClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.netty.handler.codec.mqtt.MqttMessageBuilders.connect;

/**
 * Netty客户端
 *
 * @author xf.chen
 * @date 2021/7/30 9:47 下午
 * @since 1.0.0
 */
public class HeartbeatNettyClientHandler extends ChannelInboundHandlerAdapter {
    private HeartbeatNettyClient heartbeatNettyClient;
    public HeartbeatNettyClientHandler(HeartbeatNettyClient heartbeatNettyClient) {
        this.heartbeatNettyClient = heartbeatNettyClient;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Netty底层都通过ByteBuf进行数据交互，因此这里课强制转换为ByteBuf
        ByteBuf m = (ByteBuf) msg;
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println("收到服务端消息" + new Date(currentTimeMillis));
        } finally {
            m.release();
        }
    }

    /**
     * 异常情况关闭通道
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();


        ctx.close();
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
        //
        ctx.channel().eventLoop().schedule(() -> {
            System.err.println("开始重连。。。");
            heartbeatNettyClient.connect();
        }, 3, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

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

    /**
     * 连接事件触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端已连接");
        final ByteBuf byteBuf = Unpooled.copiedBuffer("你好".getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(byteBuf);
    }


}