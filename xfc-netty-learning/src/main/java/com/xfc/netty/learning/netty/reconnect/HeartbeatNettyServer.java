package com.xfc.netty.learning.netty.reconnect;

import com.xfc.netty.learning.netty.reconnect.handler.HeartbeatNettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * netty服务端
 *
 * @author xf.chen
 * @date 2021/7/30 9:39 下午
 * @since 1.0.0
 */
public class HeartbeatNettyServer {

    private final int port;

    public HeartbeatNettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        //  NioEventLoopGroup 是一个处理 I/O 操作的多线程事件循环。
        //  Netty 为不同类型的传输提供了各种 EventLoopGroup 实现。我们在这个例子中实现了一个服务器端应用程序，
        //  因此将使用两个 NioEventLoopGroup。第一个，通常称为“老板”，接受传入连接。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //  第二个，通常称为“工人”，一旦老板接受连接并将接受的连接注册到工人，就会处理已接受连接的流量。
        //  使用多少线程以及它们如何映射到创建的通道取决于 EventLoopGroup 实现，甚至可以通过构造函数进行配置。
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //ServerBootstrap 是一个设置服务器的辅助类。您可以直接使用 Channel 设置服务器。
            // 但是，请注意，这是一个乏味的过程，在大多数情况下您不需要这样做。
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    // 我们指定使用 NioServerSocketChannel 类，该类用于实例化一个新的 Channel 以接受传入的连接。
                    // 此处指定的处理程序将始终由新接受的 Channel 评估。
                    .channel(NioServerSocketChannel.class)
                    //ChannelInitializer 是一个特殊的处理程序，旨在帮助用户配置新的 Channel。很可能您希望通过添加一些处理程序（例如 DiscardServerHandler）来配置新 Channel 的 ChannelPipeline 来实现您的网络应用程序。随着应用程序变得复杂，您可能会向管道添加更多处理程序，并最终将此匿名类提取到顶级类中。
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("heartbeat",new IdleStateHandler(5,0,0))
                                    .addLast(new HeartbeatNettyServerHandler());
                        }
                    })
                    //您还可以设置特定于 Channel 实现的参数。我们正在编写一个 TCP/IP 服务器，因此我们可以设置套接字选项，例如 tcpNoDelay 和 keepAlive。请参阅 ChannelOption 的 apidocs 和特定的 ChannelConfig 实现以获取有关支持的 ChannelOptions 的概述。
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //你注意到 option() 和 childOption() 了吗？ option() 用于接受传入连接的 NioServerSocketChannel。 childOption() 用于父 ServerChannel 接受的 Channels，在本例中为 NioSocketChannel。
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            //我们现在准备好了。剩下的就是绑定到端口并启动服务器。在这里，我们绑定到机器中所有网卡（网卡）的8080端口。您现在可以根据需要多次调用 bind() 方法（使用不同的绑定地址。）
            ChannelFuture f = b.bind(port).sync();

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new HeartbeatNettyServer(port).run();
    }
}
