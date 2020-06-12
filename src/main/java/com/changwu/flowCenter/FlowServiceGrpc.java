package com.changwu.flowCenter;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

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
  private static volatile io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.Response> getCreateFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow",
      requestType = FlowProtos.Flow.class,
      responseType = FlowProtos.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.Response> getCreateFlowMethod() {
    io.grpc.MethodDescriptor<FlowProtos.Flow, FlowProtos.Response> getCreateFlowMethod;
    if ((getCreateFlowMethod = FlowServiceGrpc.getCreateFlowMethod) == null) {
      synchronized (FlowServiceGrpc.class) {
        if ((getCreateFlowMethod = FlowServiceGrpc.getCreateFlowMethod) == null) {
          FlowServiceGrpc.getCreateFlowMethod = getCreateFlowMethod =
              io.grpc.MethodDescriptor.<FlowProtos.Flow, FlowProtos.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.Flow.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.Response.getDefaultInstance()))
              .setSchemaDescriptor(new FlowServiceMethodDescriptorSupplier("CreateFlow"))
              .build();
        }
      }
    }
    return getCreateFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.Response> getCreateFlow2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow2",
      requestType = FlowProtos.Flow.class,
      responseType = FlowProtos.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.Response> getCreateFlow2Method() {
    io.grpc.MethodDescriptor<FlowProtos.Flow, FlowProtos.Response> getCreateFlow2Method;
    if ((getCreateFlow2Method = FlowServiceGrpc.getCreateFlow2Method) == null) {
      synchronized (FlowServiceGrpc.class) {
        if ((getCreateFlow2Method = FlowServiceGrpc.getCreateFlow2Method) == null) {
          FlowServiceGrpc.getCreateFlow2Method = getCreateFlow2Method =
              io.grpc.MethodDescriptor.<FlowProtos.Flow, FlowProtos.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.Flow.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.Response.getDefaultInstance()))
              .setSchemaDescriptor(new FlowServiceMethodDescriptorSupplier("CreateFlow2"))
              .build();
        }
      }
    }
    return getCreateFlow2Method;
  }

  private static volatile io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.ResponseList> getCreateFlow3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow3",
      requestType = FlowProtos.Flow.class,
      responseType = FlowProtos.ResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<FlowProtos.Flow,
      FlowProtos.ResponseList> getCreateFlow3Method() {
    io.grpc.MethodDescriptor<FlowProtos.Flow, FlowProtos.ResponseList> getCreateFlow3Method;
    if ((getCreateFlow3Method = FlowServiceGrpc.getCreateFlow3Method) == null) {
      synchronized (FlowServiceGrpc.class) {
        if ((getCreateFlow3Method = FlowServiceGrpc.getCreateFlow3Method) == null) {
          FlowServiceGrpc.getCreateFlow3Method = getCreateFlow3Method =
              io.grpc.MethodDescriptor.<FlowProtos.Flow, FlowProtos.ResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.Flow.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.ResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new FlowServiceMethodDescriptorSupplier("CreateFlow3"))
              .build();
        }
      }
    }
    return getCreateFlow3Method;
  }

  private static volatile io.grpc.MethodDescriptor<FlowProtos.StreamRequest,
      FlowProtos.StreamResponse> getCreateFlow4Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFlow4",
      requestType = FlowProtos.StreamRequest.class,
      responseType = FlowProtos.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<FlowProtos.StreamRequest,
      FlowProtos.StreamResponse> getCreateFlow4Method() {
    io.grpc.MethodDescriptor<FlowProtos.StreamRequest, FlowProtos.StreamResponse> getCreateFlow4Method;
    if ((getCreateFlow4Method = FlowServiceGrpc.getCreateFlow4Method) == null) {
      synchronized (FlowServiceGrpc.class) {
        if ((getCreateFlow4Method = FlowServiceGrpc.getCreateFlow4Method) == null) {
          FlowServiceGrpc.getCreateFlow4Method = getCreateFlow4Method =
              io.grpc.MethodDescriptor.<FlowProtos.StreamRequest, FlowProtos.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFlow4"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FlowProtos.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FlowServiceMethodDescriptorSupplier("CreateFlow4"))
              .build();
        }
      }
    }
    return getCreateFlow4Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlowServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowServiceStub>() {
        @Override
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
        @Override
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
        @Override
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
     * <pre>
     * 服务端返回obj
     * </pre>
     */
    public void createFlow(FlowProtos.Flow request,
                           io.grpc.stub.StreamObserver<FlowProtos.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFlowMethod(), responseObserver);
    }

    /**
     * <pre>
     * 服务端返回steam
     * </pre>
     */
    public void createFlow2(FlowProtos.Flow request,
                            io.grpc.stub.StreamObserver<FlowProtos.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFlow2Method(), responseObserver);
    }

    /**
     * <pre>
     * 客户端发送stream，服务端返回obj列表
     * </pre>
     */
    public io.grpc.stub.StreamObserver<FlowProtos.Flow> createFlow3(
        io.grpc.stub.StreamObserver<FlowProtos.ResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getCreateFlow3Method(), responseObserver);
    }

    /**
     * <pre>
     * client和server通过stream交互
     * </pre>
     */
    public io.grpc.stub.StreamObserver<FlowProtos.StreamRequest> createFlow4(
        io.grpc.stub.StreamObserver<FlowProtos.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCreateFlow4Method(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FlowProtos.Flow,
                FlowProtos.Response>(
                  this, METHODID_CREATE_FLOW)))
          .addMethod(
            getCreateFlow2Method(),
            asyncServerStreamingCall(
              new MethodHandlers<
                FlowProtos.Flow,
                FlowProtos.Response>(
                  this, METHODID_CREATE_FLOW2)))
          .addMethod(
            getCreateFlow3Method(),
            asyncClientStreamingCall(
              new MethodHandlers<
                FlowProtos.Flow,
                FlowProtos.ResponseList>(
                  this, METHODID_CREATE_FLOW3)))
          .addMethod(
            getCreateFlow4Method(),
            asyncClientStreamingCall(
              new MethodHandlers<
                FlowProtos.StreamRequest,
                FlowProtos.StreamResponse>(
                  this, METHODID_CREATE_FLOW4)))
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

    @Override
    protected FlowServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务端返回obj
     * </pre>
     */
    public void createFlow(FlowProtos.Flow request,
                           io.grpc.stub.StreamObserver<FlowProtos.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 服务端返回steam
     * </pre>
     */
    public void createFlow2(FlowProtos.Flow request,
                            io.grpc.stub.StreamObserver<FlowProtos.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCreateFlow2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端发送stream，服务端返回obj列表
     * </pre>
     */
    public io.grpc.stub.StreamObserver<FlowProtos.Flow> createFlow3(
        io.grpc.stub.StreamObserver<FlowProtos.ResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCreateFlow3Method(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * client和server通过stream交互
     * </pre>
     */
    public io.grpc.stub.StreamObserver<FlowProtos.StreamRequest> createFlow4(
        io.grpc.stub.StreamObserver<FlowProtos.StreamResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCreateFlow4Method(), getCallOptions()), responseObserver);
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

    @Override
    protected FlowServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务端返回obj
     * </pre>
     */
    public FlowProtos.Response createFlow(FlowProtos.Flow request) {
      return blockingUnaryCall(
          getChannel(), getCreateFlowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 服务端返回steam
     * </pre>
     */
    public java.util.Iterator<FlowProtos.Response> createFlow2(
        FlowProtos.Flow request) {
      return blockingServerStreamingCall(
          getChannel(), getCreateFlow2Method(), getCallOptions(), request);
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

    @Override
    protected FlowServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务端返回obj
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<FlowProtos.Response> createFlow(
        FlowProtos.Flow request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateFlowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FLOW = 0;
  private static final int METHODID_CREATE_FLOW2 = 1;
  private static final int METHODID_CREATE_FLOW3 = 2;
  private static final int METHODID_CREATE_FLOW4 = 3;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FLOW:
          serviceImpl.createFlow((FlowProtos.Flow) request,
              (io.grpc.stub.StreamObserver<FlowProtos.Response>) responseObserver);
          break;
        case METHODID_CREATE_FLOW2:
          serviceImpl.createFlow2((FlowProtos.Flow) request,
              (io.grpc.stub.StreamObserver<FlowProtos.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FLOW3:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createFlow3(
              (io.grpc.stub.StreamObserver<FlowProtos.ResponseList>) responseObserver);
        case METHODID_CREATE_FLOW4:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createFlow4(
              (io.grpc.stub.StreamObserver<FlowProtos.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FlowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlowServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return FlowProtos.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getCreateFlow2Method())
              .addMethod(getCreateFlow3Method())
              .addMethod(getCreateFlow4Method())
              .build();
        }
      }
    }
    return result;
  }
}
