package com.xfc.netty.learning.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

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

                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                        nioServerSocketChannel.pipeline().addLast(null);
                    }
                })
                // 绑定端口并启动服务器
                .bind(6668).sync();
        System.out.println("服务器准备好了");

        // 监听关闭通道
        channelFuture.channel().closeFuture().sync();

    }
}
