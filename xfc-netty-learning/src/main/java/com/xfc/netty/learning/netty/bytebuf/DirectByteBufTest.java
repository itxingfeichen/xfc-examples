package com.xfc.netty.learning.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

/**
 * 堆缓冲区测试
 *
 * @author xf.chen
 * @date 2021/7/31 17:10
 * @since 1.0.0
 */
public class DirectByteBufTest {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.directBuffer();
        // 写缓存区
        byteBuf.writeBytes("xf.chen".getBytes(StandardCharsets.UTF_8));
        // 读缓存区
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        System.out.println(new String(bytes));
    }

}
