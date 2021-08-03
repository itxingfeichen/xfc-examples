package com.xfc.netty.learning.netty.codec.mycodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 自定义字符串编码器
 *
 * @author xf.chen
 * @date 2021/8/3 22:37
 * @since 1.0.0
 */
public class MyStringEncoder extends MessageToMessageEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, String s, List<Object> list) throws Exception {

        final ByteBuf byteBuf = Unpooled.copiedBuffer(s.getBytes(StandardCharsets.UTF_8));
        list.add(byteBuf);
        System.out.println("println编码完成：" + s);

    }
}
