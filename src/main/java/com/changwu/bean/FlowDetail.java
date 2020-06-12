package com.changwu.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flowDetail")
public class FlowDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 流程创建者
    @Column(name = "username", nullable = false)
    private String username;


    // 流程名字～
    @Column(name = "flowName", nullable = false)
    private String flowName;

    // 流程的详细内容
    @Column(name = "content", nullable = false)
    private String content;

    // 创建时间
    @Column(name = "createTime", nullable = false)
    private Date createTime;

    // 在流程中心中的流程编号
    @Column(name = "flowId", nullable = false)
    private Integer flowId;

    // 在流程中心中的状态
    @Column(name = "flowStatus", nullable = false)
    private String flowStatus;

    @Transient
    private String flowNodes;

    public FlowDetail() {
    }

    public String getFlowNodes() {
        return flowNodes;
    }

    public void setFlowNodes(String flowNodes) {
        this.flowNodes = flowNodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }
}