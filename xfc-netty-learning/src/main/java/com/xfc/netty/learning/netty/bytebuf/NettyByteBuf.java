package com.xfc.netty.learning.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

/**
 * 堆缓冲区读取测试<br>
 * 创建byteBuf对象，该对象内部包含一个字节数组byte[10]
 * 通过readerindex和writerIndex和capacity，将buffer分成三个区域
 * 已经读取的区域：[0,readerindex)
 * 可读取的区域：[readerindex,writerIndex)
 * 可写的区域: [writerIndex,capacity)
 *
 * @author xf.chen
 * @date 2021/7/31 17:10
 * @since 1.0.0
 */
public class NettyByteBuf {
    public static void main(String[] args) {

        ByteBuf byteBuf = Unpooled.buffer(10);
        // (ridx: 0, widx: 0, cap: 10)
        System.out.println("current byteBuf is" + byteBuf);

        // 写数据 8 个数字
        for (int i = 0; i < 8; i++) {
            byteBuf.writeByte(i);
        }
        // (ridx: 0, widx: 8, cap: 10)
        System.out.println("current byteBuf is" + byteBuf);

        // 读取 5 个数据，get方法不会移动索引
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.getByte(i));
        }
        // (ridx: 0, widx: 8, cap: 10)
        System.out.println("current byteBuf is" + byteBuf);
        // 读取 5 个数据，get方法会移动索引，因此此处的readerIndex = 5
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.readByte());
        }
        // (ridx: 5, widx: 8, cap: 10)
        System.out.println("byteBuf=" + byteBuf);

        /*********************************************/
        //用Unpooled工具类创建ByteBuf，容量为64
        ByteBuf byteBuf2 = Unpooled.copiedBuffer("xf.chen", CharsetUtil.UTF_8);
        //使用相关的方法
        if (byteBuf2.hasArray()) {
            byte[] bytes = new byte[ byteBuf2.readableBytes()];
            byteBuf2.readBytes(bytes);
            // 正确读取的可读 readable 数据结果
            System.out.println(new String(bytes));
            System.out.println("current byteBuf2 is" + byteBuf2);

            byte[] content = byteBuf2.array();
            //将 content 转成字符串,这里会将不可读的剩余字节数据打印出来，因此array慎用,
            // 打印结果：xf.chen                                                         
            System.out.println(new String(content, CharsetUtil.UTF_8));
            // (ridx: 7, widx: 7, cap: 64)
            System.out.println("current byteBuf2 is" + byteBuf2);

            // 获取数组0这个位置的字符h的ascii码，x=120
            System.out.println(byteBuf2.getByte(0));
            //可读的字节数  上面已经读取完数据因此这里为0，这个方法可以用于判断可读数据长度，后面讲解拆包粘包会用到
            int len = byteBuf2.readableBytes();
            System.out.println("可读字节长度 =" + len);

            //使用for取出各个字节
            for (int i = 0; i < len; i++) {
                System.out.println((char) byteBuf2.getByte(i));
            }

            //范围读取
            System.out.println(byteBuf2.getCharSequence(0, 3, CharsetUtil.UTF_8));
            System.out.println(byteBuf2.getCharSequence(3, 7, CharsetUtil.UTF_8));
        }
    }


}