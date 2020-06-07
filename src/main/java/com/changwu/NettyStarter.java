package com.changwu;

import com.changwu.netty.NettyServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class NettyStarter implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            try {
                System.err.println("Netty-Server prepare start");
                NettyServer.getNettyServerInstance().start();
                System.err.println("Netty-Server started");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
