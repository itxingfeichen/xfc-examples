package com.xfc.netty.learning.netty.simple;

import com.xfc.netty.learning.netty.simple.handler.NettyServerHandler;
import com.xfc.netty.learning.netty.simple.heartbeat.AcceptorIdleStateTrigger;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * netty服务端
 *
 * @author xf.chen
 * @date 2021/3/21
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        ChannelFuture channelFuture = bootstrap.group(boosGroup, workerGroup)
                // 使用NioServerSocketChannel作为通道实现
                .channel(NioServerSocketChannel.class)
                // 设置线程队列得到连接个数
                .option(ChannelOption.SO_BACKLOG, 128)
                // 让链接保持活跃状态
                .childOption(ChannelOption.SO_KEEPALIVE, true)

                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioServerSocketChannel) throws Exception {
                        nioServerSocketChannel.pipeline()
                                .addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS))
                                .addLast(new AcceptorIdleStateTrigger())
                                .addLast("decoder", new StringDecoder())
                                .addLast("encoder", new StringEncoder())
                                .addLast(new NettyServerHandler());
                    }
                })
                // 绑定端口并启动服务器
                .bind(6668).sync();
        System.out.println("服务器准备好了");

        // 监听关闭通道
        channelFuture.channel().closeFuture().sync();

    }
}
