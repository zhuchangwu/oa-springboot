package com.changwu.service;

import com.changwu.bean.Notice;
import com.changwu.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    NoticeRepository repository;

    public Notice Save(Notice notice) {
        return repository.save(notice);
    }
}
