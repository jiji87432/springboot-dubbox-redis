package cn.zhangxd.platform.system.provider.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.jboss.netty.bootstrap.ServerBootstrap;

/**
 * @author zhangyongji
 * @since 2018/8/6.
 */
public class HttpServer {

    public void bind(int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ServerBootstrap b = new ServerBootstrap();
//        b.group(bossGroup, workGroup)
//         .channel(NioServerSocketChannel.class)
//         .option(ChannelOption.SO_BACKLOG, 1024)
//         .childHandler(new HttpChannelInitService()).option(ChannelOption.SO_BACKLOG, 128)
//         .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//
//        ChannelFuture f = b.bind(port).sync();
//        f.channel().closeFuture().sync();
    }
}
