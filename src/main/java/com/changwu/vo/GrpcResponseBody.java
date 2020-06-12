package com.changwu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GrpcResponseBody {
    private Integer flowId;
    private String resMsg;
}
