package com.github.xfc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;

/**
 * nio编程
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        // 创建Selector
        Selector selector = Selector.open();

        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 为serverSocketChannel绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8000));

        // 设置serverSocketChannel为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 将serverSocketChannel注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 打印启动日志
        System.out.println("服务端启动成功");

        // 阻塞检测selector中的可用channel数量
        for (; ; ) {
            int select = selector.select();

            // 如果没有可用渠道，则继续循环
            if (select == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();

                // 移除的原因是因为，这里采用的是死循环，如果每次检测到同样的SelectionKey都向集合中添加，则会导致集合中的内容越来越大
                iterator.remove();

                // 根据就绪状态，调用对应方法处理的业务逻辑

            }

        }
    }

    /**
     * 处理接入事件
     */
    private void processAccept(ServerSocketChannel serverSocketChannel,Selector selector) throws IOException {
        // 如果是 接入事件，创建socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 将socketChannel设置为非阻塞工作模式
        socketChannel.configureBlocking(false);

        // 将channel注册到Selector上，监听可读事件
        serverSocketChannel.register(selector,SelectionKey.OP_READ);

        // 回复信息
        socketChannel.write(Charset.forName("UTF-8").encode("都是陌生人，请注意安全"));
    }

    /**
     * 处理读事件
     */
    private void processRead(SelectionKey selectionKey) {
        // 从选择器中获取到已经就绪的channel
        SelectableChannel channel = selectionKey.channel();
        // 创建buffer



    }
}
