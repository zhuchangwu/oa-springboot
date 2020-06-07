package com.changwu.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.channels.Channel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();

        // websocket基于http协议，故添加http编解码器
        pipeline.addLast(new HttpServerCodec());
        // 添加对大数据读写的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 对httpMessage进行聚合
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        // 添加心跳对支持
        pipeline.addLast(new IdleStateHandler(10,10,10));
        // 自定义空闲状态检测
        pipeline.addLast(new HearBeatHandler());

        // 添加对websocket的支持
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 添加自定义handler处理业务
        pipeline.addLast(new OABusinessHandler());
    }
}
