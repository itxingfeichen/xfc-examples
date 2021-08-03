package com.xfc.netty.learning.netty.codec.client;

import com.xfc.netty.learning.netty.codec.client.handler.CodecClientHandler;
import com.xfc.netty.learning.netty.codec.client.handler.ObjectCodecClientHandler;
import com.xfc.netty.learning.netty.codec.model.User;
import com.xfc.netty.learning.netty.codec.mycodec.MyStringDecoder;
import com.xfc.netty.learning.netty.codec.mycodec.MyStringEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
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
                                    // 使用自定义的字符串编解码器
                                    //.addLast("encoder", new MyStringEncoder())
                                    //.addLast("decoder", new MyStringDecoder())
                                    // 使用Netty自带的字符串编解码器
                                    //.addLast("encoder", new StringEncoder())
                                    //.addLast("decoder", new StringDecoder())
                                    // 使用Netty自带的对象编解码器
                                    .addLast("encoder", new ObjectEncoder())
                                    .addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())))
                                    //.addLast(new CodecClientHandler());
                                    .addLast(new ObjectCodecClientHandler());
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
