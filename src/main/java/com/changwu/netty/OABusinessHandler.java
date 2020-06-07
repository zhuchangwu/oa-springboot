package com.changwu.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * SimpleChannelInboundHandler: 会自动为我们释放入站方向消息所占的空间
 * TextWebSocketFrame: 专门用于处理消息文本的对象
 */
public class OABusinessHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    // 存放所有正常状态的websocket连接
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    // 客户端和服务端建立连接后回调
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.err.println(ctx.channel().id()+" 建立连接");
        channelGroup.add(ctx.channel());
    }

    // 连接被移除时回调
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.err.println(ctx.channel().id()+" 连接被移除");
        channelGroup.remove(ctx.channel());
    }

    // 出现异常回调
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(ctx.channel().id()+"  出现异常，信息如下：");
        cause.printStackTrace();
        System.err.println(ctx.channel().id()+"  连接移除");
        channelGroup.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        // 获取客户端的消息
        String content = textWebSocketFrame.text();

        System.out.println(content);

        // todo 将消息转换成对象


        //  关联Channel和user

        // 如果是心跳的话，直接返回给客户端响应


        // todo 公告～
    }
}
