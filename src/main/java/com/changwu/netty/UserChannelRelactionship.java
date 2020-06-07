package com.changwu.netty;

import io.netty.channel.group.ChannelGroup;

import java.nio.channels.Channel;
import java.util.HashMap;

/**
 * 用户和channel之间的关联
 */
public class UserChannelRelactionship {
    private static HashMap<String, Channel> hashMap = new HashMap<>();

    public static void put(String username,Channel channel){
        hashMap.put(username,channel);
    }

    public static Channel get(String username ){
       return hashMap.get(username);
    }
}
