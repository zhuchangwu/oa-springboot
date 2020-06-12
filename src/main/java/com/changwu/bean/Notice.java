package com.changwu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 创建者
    @Column(name = "createUser", unique = true, nullable = false)
    private String createUser;

    // 公告内容
    @Column(name = "content", nullable = false)
    private String content;

    // 创建时间
    @Column(name = "createTime", nullable = false)
    private Date createTime;

    // 开始时间
    @Column(name = "startTime", nullable = false)
    private Date startTime;

    // 结束时间
    @Column(name = "endTime", nullable = false)
    private Date endTime;

    // 假设公告已经过期了，接收公告的用户还没有上线，那些这个公告就作废了～
    // 是否已经推送完成
    @Column(name = "status", nullable = false)
    private String status;

    // 全公司员工
    // 指定部门
    @Column(name = "reciever", nullable = false)
    private String reciever;


}
