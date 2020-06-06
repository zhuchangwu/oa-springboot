package com.changwu.flowCenterProtobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> roleMap = new HashMap<>();
        roleMap.put("manager", "tom");
        roleMap.put("boss", "jerry");

        FlowProtos.Flow flow = FlowProtos.Flow.newBuilder()
                .setApplicate("zhuchangwu")
                .setDepartmentId(1024)
                .setFlowType("Reimbursement")
                .setRecordId(1)
                .putAllRoleMap(roleMap).build();

        // 模拟grpc收到数据x
        byte[] bytes = flow.toByteArray();

        try {
            FlowProtos.Flow flow1 = FlowProtos.Flow.parseFrom(bytes);
            System.out.println(flow1);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
