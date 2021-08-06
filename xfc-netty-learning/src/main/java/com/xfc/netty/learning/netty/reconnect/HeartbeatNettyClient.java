package com.xfc.netty.learning.netty.reconnect;

import com.xfc.netty.learning.netty.reconnect.handler.HeartbeatNettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * netty服务端
 *
 * @author xf.chen
 * @date 2021/7/30 9:39 下午
 * @since 1.0.0
 */
public class HeartbeatNettyClient {

    private String host = "127.0.0.1";
    private int port = 8080;
    private Bootstrap b = new Bootstrap();

    public static void main(String[] args) throws Exception {
        Bootstrap b = new Bootstrap();
        final HeartbeatNettyClient nettyClient = new HeartbeatNettyClient();
        nettyClient.connect(nettyClient);
    }

    public void connect(HeartbeatNettyClient heartbeatNettyClient) throws InterruptedException {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // Bootstrap 类似于 ServerBootstrap，不同之处在于它用于非服务器通道，例如客户端或无连接通道。

        // 如果仅指定一个 EventLoopGroup，它将同时用作老板组和工人组。 但是，老板线程池不用于客户端。
        b.group(workerGroup);
        // 代替 NioServerSocketChannel，NioSocketChannel 用于创建客户端通道。
        b.channel(NioSocketChannel.class);
        // 请注意，与使用 ServerBootstrap 不同，我们在这里不使用 childOption()，因为客户端 SocketChannel 没有父级。
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline()
                        .addLast("heartbeat", new IdleStateHandler(0, 4, 0))
                        .addLast(new HeartbeatNettyClientHandler(heartbeatNettyClient));
            }
        });

        // Start the client.
        // 我们应该调用 connect() 方法而不是 bind() 方法。
        ChannelFuture f = connect();

        // Wait until the connection is closed.
        f.channel().closeFuture().sync();
    }

    public ChannelFuture connect() {
        final ChannelFuture channelFuture = b.connect(host, port);
        ChannelFuture f = channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (!future.isSuccess()) {
                    //
                    future.channel().eventLoop().schedule(() -> {
                        System.err.println("开始重连。。。");
                        connect();
                    }, 3, TimeUnit.SECONDS);
                }
            }
        });
        return f;
    }
}
