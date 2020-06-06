package com.changwu.flowCenterTest;

import com.changwu.flowCenter.FlowProtos;
import com.changwu.flowCenter.FlowServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcFlowCenterClientTests {
    public static void main(String[] args) {

        // 创建用于连接客户端的通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext().build();

        // 创建client端stub
        FlowServiceGrpc.FlowServiceBlockingStub flowServiceBlockingStub = FlowServiceGrpc.newBlockingStub(channel);

        // 构建请求消息
        FlowProtos.Flow request = FlowProtos.Flow.newBuilder()
                .setDepartmentId(1)
                .setRecordId(2)
                .setApplicate("changwu")
                .setFlowType("create Reimbursement flow")
                .putRoleMap("manager", "tom")
                .putRoleMap("boss", "jerry")
                .build();

        // 发送请求
        FlowProtos.Response response = flowServiceBlockingStub.createFlow(request);

        // 解析请求
        System.out.println("------------- 收到Server Response -------------");
        System.out.println("response flowId:" + response.getFlowId());
        System.out.println("response msg:" + response.getResponseMsg());
        System.out.println("------------- 收到Server Response -------------");
    }
}
