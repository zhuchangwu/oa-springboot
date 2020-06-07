package com.changwu.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {
    private NioEventLoopGroup bossGroup;
    private NioEventLoopGroup workerGroup;
    private ServerBootstrap serverBootstrap;
    private static volatile NettyServer instance = null;

    public static NettyServer getNettyServerInstance(){
        if (instance == null){
            synchronized (NettyServer.class){
                if (null==instance){
                    instance=new NettyServer();
                }
                return instance;
            }
        }
        return instance;
    }

    public NettyServer() {
        this.bossGroup = new NioEventLoopGroup();
        this.workerGroup = new NioEventLoopGroup();
        this.serverBootstrap = new ServerBootstrap();
        this.serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MyServerInitializer());
    }

    public void start() throws InterruptedException {
            this.serverBootstrap.bind(8084).sync();
    }

}
