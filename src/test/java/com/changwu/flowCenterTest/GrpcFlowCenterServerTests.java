package com.changwu.flowCenterTest;

import com.changwu.flowCenter.FlowProtos;
import com.changwu.flowCenter.FlowServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
