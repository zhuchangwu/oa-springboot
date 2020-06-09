package com.changwu.netty;

public enum ResponseActionEnum {
    connAction(0),heartAction(1), noticeAction(2);

    public Integer code;
    public String desc;

    ResponseActionEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
