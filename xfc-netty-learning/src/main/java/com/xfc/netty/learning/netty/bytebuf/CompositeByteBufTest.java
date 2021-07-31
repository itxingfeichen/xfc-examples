package com.xfc.netty.learning.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

/**
 * 堆缓冲区测试
 *
 * @author xf.chen
 * @date 2021/7/31 17:10
 * @since 1.0.0
 */
public class CompositeByteBufTest {

    public static void main(String[] args) {
        final CompositeByteBuf compositeBuffer = Unpooled.compositeBuffer();

        ByteBuf directByteBuf = Unpooled.directBuffer();
        ByteBuf heapByteBuf = Unpooled.buffer();

        // 写缓存区
        directByteBuf.writeBytes("xf.chen".getBytes(StandardCharsets.UTF_8));
        heapByteBuf.writeBytes("xingyi".getBytes(StandardCharsets.UTF_8));

        // 组合缓冲区
        compositeBuffer.addComponents(true,heapByteBuf);
        compositeBuffer.addComponents(true,directByteBuf);

        // 读缓冲区
        byte[] bytes = new byte[compositeBuffer.readableBytes()];
        compositeBuffer.readBytes(bytes);
        System.out.println(new String(bytes));
    }

}
