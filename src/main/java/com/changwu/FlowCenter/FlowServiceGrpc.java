package com.changwu.FlowCenter;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 服务：服务中有方法可以进行rpc过程
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: flow.proto")
public final class FlowServiceGrpc {

  private FlowServiceGrpc() {}

  public static final String SERVICE_NAME = "Flow.FlowService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.changwu.FlowCenter.FlowProtos.Flow,
      com.changwu.FlowCenter.FlowProtos.Response> getCreateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow",
      requestType = com.changwu.FlowCenter.FlowProtos.Flow.class,
      responseType = com.changwu.FlowCenter.FlowProtos.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.changwu.FlowCenter.FlowProtos.Flow,
      com.changwu.FlowCenter.FlowProtos.Response> getCreateFlowMethod() {
    io.grpc.MethodDescriptor<com.changwu.FlowCenter.FlowProtos.Flow, com.changwu.FlowCenter.FlowProtos.Response> getCreateFlowMethod;
    if ((getCreateFlowMethod = FlowServiceGrpc.getCreateFlowMethod) == null) {
      synchronized (FlowServiceGrpc.class) {
        if ((getCreateFlowMethod = FlowServiceGrpc.getCreateFlowMethod) == null) {
          FlowServiceGrpc.getCreateFlowMethod = getCreateFlowMethod =
              io.grpc.MethodDescriptor.<com.changwu.FlowCenter.FlowProtos.Flow, com.changwu.FlowCenter.FlowProtos.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.changwu.FlowCenter.FlowProtos.Flow.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.changwu.FlowCenter.FlowProtos.Response.getDefaultInstance()))
              .setSchemaDescriptor(new FlowServiceMethodDescriptorSupplier("CreateFlow"))
              .build();
        }
      }
    }
    return getCreateFlowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlowServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowServiceStub>() {
        @java.lang.Override
        public FlowServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowServiceStub(channel, callOptions);
        }
      };
    return FlowServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlowServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowServiceBlockingStub>() {
        @java.lang.Override
        public FlowServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowServiceBlockingStub(channel, callOptions);
        }
      };
    return FlowServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlowServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowServiceFutureStub>() {
        @java.lang.Override
        public FlowServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowServiceFutureStub(channel, callOptions);
        }
      };
    return FlowServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 服务：服务中有方法可以进行rpc过程
   * </pre>
   */
  public static abstract class FlowServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createFlow(com.changwu.FlowCenter.FlowProtos.Flow request,
        io.grpc.stub.StreamObserver<com.changwu.FlowCenter.FlowProtos.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFlowMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.changwu.FlowCenter.FlowProtos.Flow,
                com.changwu.FlowCenter.FlowProtos.Response>(
                  this, METHODID_CREATE_FLOW)))
          .build();
    }
  }

  /**
   * <pre>
   * 服务：服务中有方法可以进行rpc过程
   * </pre>
   */
  public static final class FlowServiceStub extends io.grpc.stub.AbstractAsyncStub<FlowServiceStub> {
    private FlowServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceStub(channel, callOptions);
    }

    /**
     */
    public void createFlow(com.changwu.FlowCenter.FlowProtos.Flow request,
        io.grpc.stub.StreamObserver<com.changwu.FlowCenter.FlowProtos.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 服务：服务中有方法可以进行rpc过程
   * </pre>
   */
  public static final class FlowServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FlowServiceBlockingStub> {
    private FlowServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.changwu.FlowCenter.FlowProtos.Response createFlow(com.changwu.FlowCenter.FlowProtos.Flow request) {
      return blockingUnaryCall(
          getChannel(), getCreateFlowMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 服务：服务中有方法可以进行rpc过程
   * </pre>
   */
  public static final class FlowServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FlowServiceFutureStub> {
    private FlowServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.changwu.FlowCenter.FlowProtos.Response> createFlow(
        com.changwu.FlowCenter.FlowProtos.Flow request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FLOW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlowServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlowServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FLOW:
          serviceImpl.createFlow((com.changwu.FlowCenter.FlowProtos.Flow) request,
              (io.grpc.stub.StreamObserver<com.changwu.FlowCenter.FlowProtos.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FlowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlowServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.changwu.FlowCenter.FlowProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlowService");
    }
  }

  private static final class FlowServiceFileDescriptorSupplier
      extends FlowServiceBaseDescriptorSupplier {
    FlowServiceFileDescriptorSupplier() {}
  }

  private static final class FlowServiceMethodDescriptorSupplier
      extends FlowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FlowServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlowServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlowServiceFileDescriptorSupplier())
              .addMethod(getCreateFlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
