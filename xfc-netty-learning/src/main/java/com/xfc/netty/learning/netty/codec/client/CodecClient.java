package com.xfc.netty.learning.netty.codec.client;

import com.xfc.netty.learning.netty.codec.client.handler.CodecClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 编解码测试客户端
 *
 * @author xf.chen
 * @date 2021/8/1 21:46
 * @since 1.0.0
 */
public class CodecClient {


    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        try {
            final ChannelFuture channelFuture = bootstrap.group(workerGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("decoder", new StringDecoder())
                                    .addLast("encoder", new StringEncoder())
                                    .addLast(new CodecClientHandler());
                        }
                    }).connect("127.0.0.1", 8088).sync();

            final Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                final String nextLine = scanner.nextLine();
                final ByteBuf byteBuf = Unpooled.copiedBuffer(nextLine.getBytes(StandardCharsets.UTF_8));
                channelFuture.channel().writeAndFlush(byteBuf);
            }
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }
}
