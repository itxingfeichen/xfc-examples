package com.xfc.netty.learning.netty.codec.server;

import com.xfc.netty.learning.netty.codec.server.handler.CodecServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 编解码测试服务类
 *
 * @author xf.chen
 * @date 2021/8/1 21:45
 * @since 1.0.0
 */
public class CodecServer {

    public static void main(String[] args) {

        //  NioEventLoopGroup 是一个处理 I/O 操作的多线程事件循环。
        //  Netty 为不同类型的传输提供了各种 EventLoopGroup 实现。我们在这个例子中实现了一个服务器端应用程序，
        //  因此将使用两个 NioEventLoopGroup。第一个，通常称为“老板”，接受传入连接。
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //  第二个，通常称为“工人”，一旦老板接受连接并将接受的连接注册到工人，就会处理已接受连接的流量。
        //  使用多少线程以及它们如何映射到创建的通道取决于 EventLoopGroup 实现，甚至可以通过构造函数进行配置。
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            final ChannelFuture channelFuture = serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("encoder", new StringEncoder())
                                    .addLast("decoder", new StringDecoder())
                                    .addLast(new CodecServerHandler());
                        }
                    })
                    // option() 用于接受传入连接的 NioServerSocketChannel。 childOption() 用于父 ServerChannel 接受的 Channels，在本例中为 NioSocketChannel。
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 128).bind(8088).sync();
            System.out.println("服务端已启动。。。。。");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }

    }

}
