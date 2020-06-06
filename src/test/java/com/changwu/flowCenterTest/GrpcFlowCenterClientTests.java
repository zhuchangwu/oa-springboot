package com.changwu.flowCenterTest;

import com.changwu.flowCenter.FlowProtos;
import com.changwu.flowCenter.FlowServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

public class GrpcFlowCenterClientTests {
    public static void main(String[] args) {
        // TestCreateFlow();
        // TestCreateFlow1();
        // TestCreateFlow2();
        TestCreateFlow3();
    }

    /**
     * 测试 client和service之间交互obj
     */
    public static void TestCreateFlow() {
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

    /**
     * 测试 client往客户端发送obj，server返回stream
     */
    public static void TestCreateFlow1() {
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
        Iterator<FlowProtos.Response> iterator = flowServiceBlockingStub.createFlow2(request);

        while (iterator.hasNext()) {
            FlowProtos.Response response = iterator.next();
            // 解析请求
            System.out.println("------------- 收到Server Response -------------");
            System.out.println("response flowId:" + response.getFlowId());
            System.out.println("response msg:" + response.getResponseMsg());
            System.out.println("------------- 收到Server Response -------------");
        }
    }

    /**
     * 测试：client往service发送stream，server返回obj
     */
    public static void TestCreateFlow2() {
        // 创建用于连接客户端的通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext().build();

        // todo 客户端以流式端方式向server发送请求，用异步端方式 ，故、如果不加条件限制那client退出端速度可别把消息发送出去端速度块多了
        FlowServiceGrpc.FlowServiceStub stub = FlowServiceGrpc.newStub(channel);

        // 构建客户端接受服务端端响应observer
        // 这其实是一个回调
        StreamObserver<FlowProtos.ResponseList> responseListStreamObserver = new StreamObserver<FlowProtos.ResponseList>() {
            /**
             * 接收到server端响应后回调
             * @param responseList
             */
            @Override
            public void onNext(FlowProtos.ResponseList responseList) {
                responseList.getResponseListList().forEach(item -> {
                    System.out.println("------------- 收到Server Response -------------");
                    System.out.println("response flowId:" + item.getFlowId());
                    System.out.println("response msg:" + item.getResponseMsg());
                    System.out.println("------------- 收到Server Response -------------");
                });
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            /**
             *
             */
            @Override
            public void onCompleted() {
                System.out.println("onComplered");
            }
        };

        // 给client往服务端发送数据端方法添加回调
        StreamObserver<FlowProtos.Flow> streamObserver = stub.createFlow3(responseListStreamObserver);


        // 构建请求消息
        FlowProtos.Flow request1 = FlowProtos.Flow.newBuilder()
                .setDepartmentId(1)
                .setRecordId(2)
                .setApplicate("changwu")
                .setFlowType("create Reimbursement flow")
                .putRoleMap("manager", "tom")
                .putRoleMap("boss", "jerry")
                .build();

        // 构建请求消息
        FlowProtos.Flow request2 = FlowProtos.Flow.newBuilder()
                .setDepartmentId(1)
                .setRecordId(2)
                .setApplicate("changwu")
                .setFlowType("create Reimbursement flow")
                .putRoleMap("manager", "tom")
                .putRoleMap("boss", "jerry")
                .build();

        streamObserver.onNext(request1);
        streamObserver.onNext(request2);
        streamObserver.onCompleted();

        try {
            Thread.sleep(50000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试：client service 交互 stream
     */
    public static void TestCreateFlow3() {
        // 创建用于连接客户端的通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext().build();

        // todo 客户端以流式端方式向server发送请求，用异步端方式 ，故、如果不加条件限制那client退出端速度可别把消息发送出去端速度块多了
        FlowServiceGrpc.FlowServiceStub stub = FlowServiceGrpc.newStub(channel);

        // 构建客户端接受服务端端响应observer
        // 这其实是一个回调
        StreamObserver<FlowProtos.StreamResponse> responseListStreamObserver = new StreamObserver<FlowProtos.StreamResponse>() {

            @Override
            public void onNext(FlowProtos.StreamResponse response) {
                System.out.println("-----------------------**********收到服务端端响应信息***********------------------------");
                System.out.println(response.getResponseInfo());
                System.out.println("-----------------------**********收到服务端端响应信息***********------------------------");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            /**
             * 服务器complted之后，client端complted回调
             */
            @Override
            public void onCompleted() {

            }
        };

        // 给client往服务端发送数据端方法添加回调
        StreamObserver<FlowProtos.StreamRequest> requestStreamObserver = stub.createFlow4(responseListStreamObserver);


        for (int i = 0; i < 10; i++) {
            // 构建请求消息
            FlowProtos.StreamRequest request = FlowProtos.StreamRequest.newBuilder().setRequestInfo("hi i an client").build();
            // 发送消息
            requestStreamObserver.onNext(request);

        }


        try {
            Thread.sleep(50000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestStreamObserver.onCompleted();
    }
}
