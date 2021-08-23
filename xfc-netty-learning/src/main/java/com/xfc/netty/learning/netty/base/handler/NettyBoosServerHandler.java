package com.xfc.netty.learning.netty.base.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;

import java.nio.charset.StandardCharsets;

/**
 * 服务端处理器
 * NettyServerHandler 扩展了 ChannelInboundHandlerAdapter，它是 ChannelInboundHandler 的一个实现。
 * io.netty.channel.ChannelInboundHandler 提供了各种可以覆盖的事件处理程序方法。
 * 目前，扩展 ChannelInboundHandlerAdapter 而不是自己实现处理程序接口就足够了。
 *
 * @author xf.chen
 * @date 2021/7/30 9:42 下午
 * @since 1.0.0
 */
public class NettyBoosServerHandler extends ChannelInboundHandlerAdapter { // (1)

    /**
     * Do nothing by default, sub-classes may override this method.
     *
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded被调用");
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelRegistered()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered注册回调");
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelActive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive被调用");
    }
}
