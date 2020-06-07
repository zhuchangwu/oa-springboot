package com.changwu.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

import javax.persistence.Id;

public class HearBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        // 进行心跳检测
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            if (event.state() == IdleState.READER_IDLE) {//读空闲
                System.err.println("读空闲");
            } else if (event.state() == IdleState.WRITER_IDLE) { //写空闲
                System.err.println("写空闲");
            } else if (event.state() == IdleState.ALL_IDLE) { // 读写空闲
                System.err.println("读写空闲");
                /*
                * Channel channel = ctx.Channel()
                * channel.close()
                *
                * */
            }

        }
    }
}
