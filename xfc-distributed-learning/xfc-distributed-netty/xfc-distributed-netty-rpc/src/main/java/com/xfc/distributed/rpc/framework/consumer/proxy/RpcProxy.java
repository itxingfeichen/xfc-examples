package com.xfc.distributed.rpc.framework.consumer.proxy;

import com.xfc.distributed.rpc.framework.core.msg.InvokerMsg;
import com.xfc.distributed.rpc.framework.registry.RegistryHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : cxf
 * @date: 2019/5/11  8:41
 * @description: 微代理
 **/
public class RpcProxy {

    public static <T> T create(Class<T> clazz) {
        MethodProxy methodProxy = new MethodProxy(clazz);

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, methodProxy);

    }

    static class MethodProxy implements InvocationHandler {

        private Class<?> clazz;

        public MethodProxy(Class<?> clazz) {
            this.clazz = clazz;
        }

        /**
         * 代理调用，调用接口中的每一个方法，实际上就是发起一次网络请求
         *
         * @param proxy
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (proxy.getClass().equals(method.getDeclaringClass())) {
                return null;
            } else {
                return rpcInvoke(method, args);
            }
        }

        /**
         * 远程调用方法
         *
         * @param method
         * @param args
         */
        private Object rpcInvoke(Method method, Object[] args) {

            // 构造要调用的接口和相关的参数信息
            InvokerMsg invokerMsg = new InvokerMsg();
            invokerMsg.setServiceName(this.clazz.getName());
            invokerMsg.setMethodName(method.getName());
            invokerMsg.setParams(args);
            invokerMsg.setParamsList(method.getParameterTypes());
            EventLoopGroup group = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();

            final RpcProxyHandler rpcProxyHandler = new RpcProxyHandler();

            try {
                bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline()
                                        // 处理拆包粘包的处理器
                                        .addLast("client", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
                                        .addLast("clientName", new LengthFieldPrepender(4))
                                        .addLast("encoder", new ObjectEncoder())
                                        .addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                                        .addLast(rpcProxyHandler);
                            }
                        });
                ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
                channelFuture.channel().writeAndFlush(invokerMsg).sync();
                channelFuture.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
            return rpcProxyHandler.getResult();

        }
    }
}
