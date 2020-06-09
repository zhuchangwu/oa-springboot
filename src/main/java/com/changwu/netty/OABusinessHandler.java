package com.changwu.netty;

import com.changwu.utils.JsonUtils;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Date;


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
        System.err.println(ctx.channel().id() + " 建立连接");
        channelGroup.add(ctx.channel());
    }

    // 连接被移除时回调
    // todo 用户刷新浏览器的动作
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.err.println(ctx.channel().id() + " 连接被移除");
    }

    // 可能是用户刷新浏览器了～ 连接断开～
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开连接
        System.out.println("客户端断开连接：" + ctx.channel().id());
    }

    // 出现异常回调
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(ctx.channel().id() + "  出现异常，信息如下：");
        cause.printStackTrace();
        System.err.println(ctx.channel().id() + "  连接移除");
        channelGroup.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        // 获取客户端的消息
        String content = textWebSocketFrame.text();

        // 将消息转换成对象
        ResponseData responseData = JsonUtils.jsonToPojo(content, ResponseData.class);
        String username = responseData.getUsername();
        Channel channel = channelHandlerContext.channel();


        // 判断消息类型
        if (ResponseActionEnum.connAction.code == responseData.getAction()) {
            Channel oldChannel = UserChannelRelactionship.get(username);
            // 已经处于登陆的状态
            if (null != oldChannel && channelGroup.contains(oldChannel) && channel.compareTo(oldChannel) != 0) {
                // 往客户端写会消息～，告诉他有人登陆了，vue控制让用户下线
                oldChannel.writeAndFlush(new TextWebSocketFrame("logout"));
                // 移除
                oldChannel.close();
                channelGroup.remove(oldChannel);
            }
            // 维护username和新的channel
            UserChannelRelactionship.put(username, channel);
            channel.writeAndFlush(new TextWebSocketFrame("登陆成功了~"));
        }

        // 如果是心跳的话，直接返回给客户端响应
        if (ResponseActionEnum.heartAction.code == responseData.getAction()) {
            channel.writeAndFlush(new TextWebSocketFrame("ok"));
        }

        // todo 公告～
    }
}
