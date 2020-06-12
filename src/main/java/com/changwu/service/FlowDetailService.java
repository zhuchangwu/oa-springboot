package com.changwu.service;

import com.changwu.bean.FlowDetail;
import com.changwu.repository.FlowDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowDetailService {
    @Autowired
    FlowDetailRepository repository;

    // 添加流程详情
    public FlowDetail createFlow(FlowDetail detail) {
        return repository.save(detail);
    }

    // 更新流程
    public FlowDetail updateFlow(FlowDetail detail) {
        return repository.save(detail);
    }
}
