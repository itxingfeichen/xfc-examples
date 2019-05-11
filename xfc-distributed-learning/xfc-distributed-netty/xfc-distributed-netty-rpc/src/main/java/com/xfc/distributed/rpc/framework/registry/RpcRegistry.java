package com.xfc.distributed.rpc.framework.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.concurrent.ConcurrentHashMap;

public class RpcRegistry {




    private Integer port;

    /**
     * 通过构造方法初始化netty端口
     *
     * @param port
     */
    public RpcRegistry(Integer port) {
        this.port = port;
    }


    /**
     * 启动netty框架
     */
    public void start() {
        EventLoopGroup masterWork = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();


        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();


            serverBootstrap.channel(NioServerSocketChannel.class).group(masterWork, worker).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {

                    channel.pipeline()
                            // 处理拆包粘包的处理器
                            .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
                            .addLast(new LengthFieldPrepender(4))
                            .addLast("encoder", new ObjectEncoder())
                            .addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                            .addLast(new RegistryHandler());


                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("RPC registry started ");
            // 阻塞的
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            masterWork.shutdownGracefully();

            worker.shutdownGracefully();
        }

    }


    public static void main(String[] args) {

        new RpcRegistry(8080).start();
    }
}
