package com.changwu.vo;

import lombok.Data;

import java.util.HashMap;

@Data
public class GrpcRuqestBody {
    private String DepartmentName;
    private Integer RecordId;
    private String applicate;
    private String flowType;
    private HashMap<String,String> map;

}
