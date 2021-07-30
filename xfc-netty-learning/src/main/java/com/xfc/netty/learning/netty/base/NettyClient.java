package com.xfc.netty.learning.netty.base;

import com.xfc.netty.learning.netty.base.handler.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty服务端
 *
 * @author xf.chen
 * @date 2021/7/30 9:39 下午
 * @since 1.0.0
 */
public class NettyClient {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // Bootstrap 类似于 ServerBootstrap，不同之处在于它用于非服务器通道，例如客户端或无连接通道。
            Bootstrap b = new Bootstrap();
            // 如果仅指定一个 EventLoopGroup，它将同时用作老板组和工人组。 但是，老板线程池不用于客户端。
            b.group(workerGroup);
            // 代替 NioServerSocketChannel，NioSocketChannel 用于创建客户端通道。
            b.channel(NioSocketChannel.class);
            // 请注意，与使用 ServerBootstrap 不同，我们在这里不使用 childOption()，因为客户端 SocketChannel 没有父级。
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyClientHandler());
                }
            });

            // Start the client.
            // 我们应该调用 connect() 方法而不是 bind() 方法。
            ChannelFuture f = b.connect(host, port).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            // 关闭线程池
            workerGroup.shutdownGracefully();
        }
    }
}
