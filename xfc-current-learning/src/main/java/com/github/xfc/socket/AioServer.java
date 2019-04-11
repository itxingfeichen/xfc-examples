package com.github.xfc.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-04-09  23:19
 * @description: 异步非阻塞学习
 */
public class AioServer {

    AsynchronousChannelGroup asynchronousChannelGroup;

    AsynchronousServerSocketChannel open;

    /**
     * 初始化server
     *
     * @param port
     * @throws IOException
     */
    public AioServer(int port) throws IOException, InterruptedException {

        // 创建一个通道组
        asynchronousChannelGroup = AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 1);

        // 创建服务器通道
        open = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);

        // 绑定端口
        open.bind(new InetSocketAddress(port));

        System.out.println("server start " + port);

        // 阻塞
//        open.accept();
        open.accept(this, new CompletionHandler<AsynchronousSocketChannel, AioServer>() {
            @Override
            public void completed(AsynchronousSocketChannel result, AioServer attachment) {

            }

            @Override
            public void failed(Throwable exc, AioServer attachment) {
                System.out.println("failed...");
            }
        });
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);


    }

    public static void main(String[] args) {
        try {
            AioServer aioServer = new AioServer(9009);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
