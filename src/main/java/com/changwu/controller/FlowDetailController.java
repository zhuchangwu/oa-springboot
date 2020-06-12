package com.changwu.controller;

import com.changwu.bean.FlowDetail;
import com.changwu.flowCenter.FlowProtos;
import com.changwu.flowCenter.FlowServiceGrpc;
import com.changwu.security.JwtTokenProvider;
import com.changwu.service.FlowDetailService;
import com.changwu.service.UserService;
import com.changwu.vo.GrpcResponseBody;
import com.changwu.vo.GrpcRuqestBody;
import com.changwu.vo.JSONResult;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/flow")
public class FlowDetailController {

    @Autowired
    UserService userService;
    @Autowired
    public JwtTokenProvider provider;

    @Autowired
    public FlowDetailService flowDetailService;

    @PostMapping("/createFLow")
    public JSONResult getInfo(@RequestBody FlowDetail detail) {
        System.out.println(detail);

        // 持久化流程
        FlowDetail flow = flowDetailService.createFlow(detail);
        if (flow == null) {
            return JSONResult.build(200, "error , 持久化流程信息失败～", null);
        }

        // 构建 grpc 请求体
        GrpcRuqestBody req = buildGrpcRequestBody(detail);
        req.setRecordId(flow.getId());// 当前记录对应在数据库flowDetail表中的id

        // grpc 调用
        GrpcResponseBody response = creteFlow(req);
        if (response.getFlowId() < 0) {
            return JSONResult.build(200, "error , 创建流程失败～", null);
        }

        // 就流程ID更新进FlowDetail中
        detail.setFlowId(response.getFlowId());
        FlowDetail flowDetail = flowDetailService.updateFlow(detail);
        if (flowDetail == null) {
            return JSONResult.build(200, "error , 更新流程详情中的flowId失败～", null);
        }
        return JSONResult.build(200, "ok", null);
    }

    /**
     * 创建Grpc发送的请求体
     *
     * @param detail
     * @return
     */
    private GrpcRuqestBody buildGrpcRequestBody(FlowDetail detail) {
        GrpcRuqestBody req = new GrpcRuqestBody();
        // 查询部分ID
        String departmentName = userService.getDepartmentIdByUsername(detail.getUsername());
        // 查询当前用户所有的上级领导的账号
        // key:role value:username
        HashMap<String, String> leaderMap = userService.findLeadersByUsername(detail.getUsername());
        // 存放发送给flowCentor中用户信息的map
        HashMap<String, String> map = new HashMap();

        // 获取当前模版中要求的role信息
        String[] split = detail.getFlowNodes().split("&");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("=");
            if (split1[1] != null) {
                map.put(split1[1],leaderMap.get(split1[1]));
            }
        }

        // 封装将要返回的信息～
        req.setApplicate(detail.getUsername()); // 申请人
        req.setDepartmentName(departmentName); // 申请人部门名
        req.setFlowType(detail.getFlowName()); // 流程模版名
        req.setMap(map); // 具体的审批人
        return req;
    }

    /**
     * 创建流程
     *
     * @param requsest
     * @return
     */
    public GrpcResponseBody creteFlow(GrpcRuqestBody requsest) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext().build();
        // 创建client端stub
        FlowServiceGrpc.FlowServiceBlockingStub flowServiceBlockingStub = FlowServiceGrpc.newBlockingStub(channel);

        // 构建请求消息
        FlowProtos.Flow.Builder builder = FlowProtos.Flow.newBuilder()
                .setDepartmentName(requsest.getDepartmentName())
                .setRecordId(requsest.getRecordId())
                .setApplicate(requsest.getApplicate())
                .setFlowType(requsest.getFlowType());
        requsest.getMap().entrySet().forEach(item -> {
            builder.putRoleMap(item.getKey(), item.getValue());
        });
        FlowProtos.Flow flow = builder.build();

        // 发送请求
        FlowProtos.Response response = flowServiceBlockingStub.createFlow(flow);

        // 解析请求
        return new GrpcResponseBody(response.getFlowId(), response.getResponseMsg());
    }
}
