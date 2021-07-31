package com.xfc.netty.learning.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

/**
 * 堆缓冲区字节读取测试
 *
 * @author xf.chen
 * @date 2021/7/31 17:10
 * @since 1.0.0
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(7);
        // 写缓存区
        byteBuf.writeBytes("xf.chen".getBytes(StandardCharsets.UTF_8));
        // 获取单个字节数据
        for (int i = 0; i < 7; i++) {
            System.out.println((char) byteBuf.getByte(i));
        }
    }

}
