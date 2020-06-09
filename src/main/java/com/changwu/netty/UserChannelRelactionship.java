package com.changwu.netty;

import io.netty.channel.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户和channel之间的关联
 */
public class UserChannelRelactionship {
    private static Map<String, Channel> hashMap = new ConcurrentHashMap<>();

    public static void put(String username,Channel channel){
        hashMap.put(username,channel);
    }

    public static Channel get(String username ){
       return hashMap.get(username);
    }
}
