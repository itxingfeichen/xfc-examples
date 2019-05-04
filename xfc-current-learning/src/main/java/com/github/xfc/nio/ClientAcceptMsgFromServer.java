package com.github.xfc.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : chenxingfei
 * @date: 2019/5/3  1:27
 * @description: 专用于接收服务端消息的线程
 */
public class ClientAcceptMsgFromServer implements Runnable {


    private Selector selector;

    public ClientAcceptMsgFromServer(Selector selector) {
        this.selector = selector;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (; ; ) {
            int select = 0;
            try {
                select = selector.select();
                // 如果没有可用渠道，则继续循环
                if (select == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    // 移除的原因是因为，这里采用的是死循环，如果每次检测到同样的SelectionKey都向集合中添加，则会导致集合中的内容越来越大
                    iterator.remove();

                    // 根据就绪状态，调用对应方法处理的业务逻
                    // 可读事件
                    if (selectionKey.isReadable()) {
                        processRead(selectionKey, selector);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * 处理读事件
     */
    private void processRead(SelectionKey selectionKey, Selector selector) throws IOException {

        // 从选择器中获取到已经就绪的channel
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        // 创建buffer(申请内存空间)
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环写入数据到buffer中

        StringBuffer requestData = new StringBuffer();
        if (channel.read(byteBuffer) > 0) {

            // 复位或者叫做转换为读模式
            byteBuffer.flip();
            requestData.append(Charset.forName("UTF-8").decode(byteBuffer));
        }
        // 读取数据结束，把channel重新注册到selector上
        channel.register(selector, SelectionKey.OP_READ);

        if (requestData.length() > 0) {
            // 开始广播给其他的客户端
            System.out.println(requestData.toString());
        }
    }
}
