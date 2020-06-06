package com.changwu.flowCenterTest;

import com.changwu.flowCenter.FlowProtos;
import com.changwu.flowCenter.FlowServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * Grpc-Server
 */
public class GrpcFlowCenterServerTests {
    // 服务器端处理请求的对象
    // 和spring整合，可以考虑将这个对象注入IOC
    static class FlowCentorImpl extends FlowServiceGrpc.FlowServiceImplBase {
        /**
         * @param request          客户端放松过来的请求对象
         * @param responseObserver 向客户端返回结果的对象
         */
        @Override
        public void createFlow(FlowProtos.Flow request, StreamObserver<FlowProtos.Response> responseObserver) {
            System.out.println("--------------------接收到客户端的信息--------------------");
            System.out.println("申请人： " + request.getApplicate());
            System.out.println("流程类型： " + request.getFlowType());
            System.out.println("角色信息： " + request.getRoleMapMap());
            System.out.println("部门ID： " + request.getDepartmentId());
            System.out.println("记录ID： " + request.getRecordId());
            System.out.println("--------------------接收到客户端的信息--------------------");

            //  responseObserver.onCompleted(); 仅能调用一次，当请求正常处理时调用
            //  responseObserver.onError(new Exception()); 当请求出现异常时调用
            //  responseObserver.onNext(); 表示接下来将要做什么事情
            FlowProtos.Response response = FlowProtos.Response.newBuilder().setFlowId(1).setResponseMsg("successfully create flow").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        /**
         * 服务端往客户端返回流式数据：相当于服务端通过迭代器不断的往客户端发送数据
         *
         * @param request
         * @param responseObserver
         */
        @Override
        public void createFlow2(FlowProtos.Flow request, StreamObserver<FlowProtos.Response> responseObserver) {
            // 接受数据
            System.out.println("--------------------接收到客户端的信息--------------------");
            System.out.println("申请人： " + request.getApplicate());
            System.out.println("流程类型： " + request.getFlowType());
            System.out.println("角色信息： " + request.getRoleMapMap());
            System.out.println("部门ID： " + request.getDepartmentId());
            System.out.println("记录ID： " + request.getRecordId());
            System.out.println("--------------------接收到客户端的信息--------------------");

            FlowProtos.Response response1 = FlowProtos.Response.newBuilder().setFlowId(1).setResponseMsg("successfully create flow").build();
            FlowProtos.Response response2 = FlowProtos.Response.newBuilder().setFlowId(2).setResponseMsg("successfully create flow").build();
            FlowProtos.Response response3 = FlowProtos.Response.newBuilder().setFlowId(3).setResponseMsg("successfully create flow").build();
            FlowProtos.Response response4 = FlowProtos.Response.newBuilder().setFlowId(4).setResponseMsg("successfully create flow").build();

            // 返回steeam
            responseObserver.onNext(response1);
            responseObserver.onNext(response2);
            responseObserver.onNext(response3);
            responseObserver.onNext(response4);
            responseObserver.onCompleted();
        }

        /**
         * 客户端往服务端发送stream，服务端返回obj
         *
         * @param responseObserver
         * @return
         */
        @Override
        public StreamObserver<FlowProtos.Flow> createFlow3(StreamObserver<FlowProtos.ResponseList> responseObserver) {
            return new StreamObserver<FlowProtos.Flow>() {
                /**
                 * 客户端的请求每到来一次，onNext被回调一次
                 * @param flow
                 */
                @Override
                public void onNext(FlowProtos.Flow flow) {
                    // 接受数据
                    System.out.println("--------------------接收到客户端的信息--------------------");
                    System.out.println("申请人： " + flow.getApplicate());
                    System.out.println("流程类型： " + flow.getFlowType());
                    System.out.println("角色信息： " + flow.getRoleMapMap());
                    System.out.println("部门ID： " + flow.getDepartmentId());
                    System.out.println("记录ID： " + flow.getRecordId());
                    System.out.println("--------------------接收到客户端的信息--------------------");
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println(throwable);
                }

                /**
                 * 客户端往服务端一个一个的发送数据，当server感知到client的数据全部发送完成了，回调onCompleted方法
                 */
                @Override
                public void onCompleted() {
                    FlowProtos.Response response1 = FlowProtos.Response.newBuilder().setFlowId(1).setResponseMsg("successfully create flow").build();
                    FlowProtos.Response response2 = FlowProtos.Response.newBuilder().setFlowId(2).setResponseMsg("successfully create flow").build();
                    FlowProtos.Response response3 = FlowProtos.Response.newBuilder().setFlowId(3).setResponseMsg("successfully create flow").build();
                    FlowProtos.Response response4 = FlowProtos.Response.newBuilder().setFlowId(4).setResponseMsg("successfully create flow").build();

                    FlowProtos.ResponseList responseList = FlowProtos.ResponseList.newBuilder()
                            .addResponseList(response1)
                            .addResponseList(response2)
                            .addResponseList(response3)
                            .addResponseList(response4)
                            .build();

                    // 往客户端返回结果
                    responseObserver.onNext(responseList);
                    responseObserver.onCompleted();
                }
            };
        }


        /**
         * 客户端和服务端之间交互stream
         *
         * @param responseObserver
         * @return
         */
        @Override
        public StreamObserver<FlowProtos.StreamRequest> createFlow4(StreamObserver<FlowProtos.StreamResponse> responseObserver) {
            return new StreamObserver<FlowProtos.StreamRequest>() {
                /**
                 * 向client返回数据
                 * @param request
                 */
                @Override
                public void onNext(FlowProtos.StreamRequest request) {
                    // 获取请求参数
                    System.out.println("request info: " + request.getRequestInfo());
                    // 响应
                    FlowProtos.StreamResponse response = FlowProtos.StreamResponse.newBuilder().setResponseInfo("successfully").build();
                    // 返回数据
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println(throwable);
                }

                /**
                 * 关闭连接，当客户端发送完数据后回调
                 */
                @Override
                public void onCompleted() {
                    System.out.println("server  onCompleted");
                    responseObserver.onCompleted();
                    System.out.println("server  onCompleted done");
                }
            };

        }
    }


    // 服务端
    static class GrpcServer {
        private Server server;

        private void start() throws IOException {
            System.out.println("prepare to start server");
            server = ServerBuilder.forPort(9999).addService(new FlowCentorImpl()).build().start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("add shutdown hook , call when jvm shutdown");
                this.server.shutdown();
            }));
            System.out.println("server started");

        }

        private void stop() {
            if (null != this.server) {
                this.server.shutdown();
            }
        }

        private void awaitTermination() throws InterruptedException {
            if (null != this.server) {
                this.server.awaitTermination();
            }
        }

        public static void main(String[] args) {
            GrpcServer grpcServer = new GrpcServer();
            try {
                grpcServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                grpcServer.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("server shutdown");
        }

    }

}
