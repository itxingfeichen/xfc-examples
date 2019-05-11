package com.xfc.distributed.rpc.framework.consumer.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author : cxf
 * @date: 2019/5/11  9:01
 * @description:
 **/
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {


    private Object result;


    public Object getResult() {
        return result;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
