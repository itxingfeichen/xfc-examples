package com.xfc.netty.learning.netty.imreconnect.client;

import com.xfc.netty.learning.netty.codec.mycodec.MyStringDecoder;
import com.xfc.netty.learning.netty.codec.mycodec.MyStringEncoder;
import com.xfc.netty.learning.netty.imreconnect.client.handler.ImClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 客户端
 *
 * @author xf.chen
 * @date 2021/7/31 9:51 上午
 * @since 1.0.0
 */
public class ImClient {

    Bootstrap bootstrap = new Bootstrap();

    ChannelFuture channelFuture;

    public static void main(String[] args) {
        ImClient imClient = new ImClient();
        imClient.clientInit(imClient);

    }

    public void clientInit(ImClient imClient) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        bootstrap.group(workerGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                // 新增心跳检测，写空闲监控
                                .addLast(new IdleStateHandler(0, 4, 0))
                                .addLast(new MyStringEncoder())
                                .addLast(new MyStringDecoder())
                                .addLast(new ImClientHandler(imClient));
                    }
                });
        try {
            connect();

            final Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                final String nextLine = scanner.nextLine();
                final ByteBuf byteBuf = Unpooled.copiedBuffer(nextLine.getBytes(StandardCharsets.UTF_8));
                channelFuture.channel().writeAndFlush(byteBuf);
            }

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 实现重连机制，这里不能同步等待
        // .sync();

        // 实现重连机制，线程池不能关闭
        //   finally {
        //   ßworkerGroup.shutdownGracefully();
        //   }
    }

    public void connect() throws InterruptedException {
        channelFuture = bootstrap.connect("127.0.0.1", 8088)
                // 添加连接监听器
                .addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            System.err.println("开始重连。。。");
                            future.channel().eventLoop().schedule(() -> {
                                try {
                                    connect();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }, 3, TimeUnit.SECONDS);
                        }
                    }
                });


    }
}
