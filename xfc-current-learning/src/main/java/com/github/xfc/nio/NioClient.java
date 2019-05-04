package com.github.xfc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author : chenxingfei
 * @date: 2019/5/3  0:58
 * @description: 客户端
 */
public class NioClient {


    public void start(String nickname) throws IOException {
        // 启动客户端
        final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8000));

        final Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        final ClientAcceptMsgFromServer clientAcceptMsgFromServer = new ClientAcceptMsgFromServer(selector);
        new Thread(clientAcceptMsgFromServer).start();
        // 向服务端发送数据
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String nextLine = scanner.nextLine();
            if (nextLine != null && nextLine.length() > 0) {
                socketChannel.write(Charset.forName("UTF-8").encode(nickname+" : "+nextLine));
            }
        }
    }
}