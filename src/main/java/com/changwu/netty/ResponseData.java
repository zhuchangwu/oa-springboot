package com.changwu.netty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通过WebSocket交互数据的类型
 */
public class ResponseData {
    private static final long serialVersionUID = 123113123123123123L;
    // 0建立连接 ,1心跳, 2通知
    private Integer action;
    // 发送消息的用户用户
    private String username;
    // 接收者
    private List<String> acceptUser ;
    // 发送的内容
    private String content;


    public List<String> getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(List<String> acceptUser) {
        this.acceptUser = acceptUser;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
