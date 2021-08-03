package com.xfc.netty.learning.netty.codec.mycodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 自定义字符串编码器
 *
 * @author xf.chen
 * @date 2021/8/3 22:37
 * @since 1.0.0
 */
public class MyStringDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> list) throws Exception {
        final byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        final String decodeResult = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("println解码结果："+decodeResult);
        list.add(decodeResult);

    }
}
