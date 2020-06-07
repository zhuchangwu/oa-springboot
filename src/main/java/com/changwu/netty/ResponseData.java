package com.changwu.netty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通过WebSocket交互数据的类型
 */
@Data
@AllArgsConstructor
public class ResponseData {
    private Integer action;
    private ResponseDataInfo info;

    public ResponseData(ResponseActionEnum actionEnum, ResponseDataInfo info){
        this.info = info;
        this.action = actionEnum.getCode();
    }
}
