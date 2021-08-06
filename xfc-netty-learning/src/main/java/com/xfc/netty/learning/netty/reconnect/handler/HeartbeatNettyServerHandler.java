package com.xfc.netty.learning.netty.reconnect.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

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
public class HeartbeatNettyServerHandler extends ChannelInboundHandlerAdapter { // (1)

    /**
     * 我们在这里覆盖了 channelRead() 事件处理程序方法。每当从客户端接收到新数据时，都会使用接收到的消息调用此方法。本例中，接收消息的类型为ByteBuf。
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        final ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        System.out.println(new String(bytes));

        final ByteBuf byteBuf = Unpooled.copiedBuffer((System.currentTimeMillis() + "").getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(byteBuf);
    }

    /**
     * 调用 exceptionCaught() 事件处理程序方法。在大多数情况下，应该记录捕获的异常并在此处关闭其关联的通道，
     * 尽管此方法的实现可能会有所不同，具体取决于您要做什么来处理异常情况。例如，您可能希望在关闭连接之前发送带有错误代码的响应消息。
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            switch (((IdleStateEvent) evt).state()) {
                case READER_IDLE:
                    System.out.println("读空闲");
                    break;
                case WRITER_IDLE:
                    System.out.println("写空闲");
                    break;
                case ALL_IDLE:
                    System.out.println("全部空闲");
                    break;
                default:
                    break;
            }

        }
    }
}
