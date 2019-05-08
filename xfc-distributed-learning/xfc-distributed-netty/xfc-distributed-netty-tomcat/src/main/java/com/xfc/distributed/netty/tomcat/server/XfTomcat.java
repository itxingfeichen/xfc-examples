package com.xfc.distributed.netty.tomcat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author : chenxingfei
 * @date: 2019-05-08  22:18
 * @description: tomcat演示
 */
public class XfTomcat {

    public void start(Integer port) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();

        server.group(bossGroup, workerGroup).
                // 主线程处理类
                        channel(NioServerSocketChannel.class)
                // 子线程处理类
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 业务逻辑
                        socketChannel.pipeline().addLast(new HttpResponseEncoder())
                                .addLast(new HttpRequestDecoder())
                                .addLast(new XfTomcatHandler());
                    }
                })
                // 主线程配置
                .option(ChannelOption.SO_BACKLOG, 128)
                // 子线程配置
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture channelFuture = null;
        try {
            channelFuture = server.bind(port).sync();
            System.out.println("tomcat已经启动");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) {

        new XfTomcat().start(8080);
    }
}
