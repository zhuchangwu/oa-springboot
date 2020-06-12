package com.changwu.controller;

import com.changwu.bean.FlowDetail;
import com.changwu.bean.Notice;
import com.changwu.bean.User;
import com.changwu.netty.UserChannelRelactionship;
import com.changwu.service.NoticeService;
import com.changwu.service.UserService;
import com.changwu.vo.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    static NoticeService noticeService;
    @Autowired
    static UserService userService;


    private static CopyOnWriteArrayList<Notice> taskList = new CopyOnWriteArrayList<>();

    static {
        try {
            new Thread(() -> {
                while (true) {

                    // 便利所有到任务
                    taskList.forEach(item -> {
                        // 如果任务结束了，更改状态，之久化
                        if (item.getEndTime().before(new Date())) {
                            item.setStatus("done");
                            noticeService.Save(item);
                            taskList.remove(item);
                        } else {
                            // 本部门接收，
                            if (item.getReciever().equals("1")) {
                                //List<User> userList = userService.findAllUserInSimpleDepartment(item);
//
                                //// 遍历UserList，看看他们是否在ChannelGroup中
                                //for (User user : userList) {
                                //    //
                                //    if (UserChannelRelactionship.get(user.getUsername()) != null) {
                                //        // 推送
                                //    }
//
                                //}


                            } else if (item.getReciever().equals("2")) {
                                // 全公司接收
                                // List<User> userList = userService.findAllUser(item);


                            }
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/create")
    public JSONResult createNotice(@RequestBody Notice notice) {
        // 加入到消息队列
        if (null != notice && notice.getReciever() != null && notice.getStartTime() != null && notice.getEndTime() != null && notice.getContent() != null && notice.getCreateUser() != null) {
            notice.setCreateTime(new Date());
            // 持久化任务
            Notice n = noticeService.Save(notice);
            if (null == n) {
                return new JSONResult(50008, "通知发布失败，请联系管理员", "");
            }
            // 更新Id
            notice.setId(n.getId());
            // 添加到任务队列
            taskList.add(notice);
            return new JSONResult(200, "", "");
        }

        return new JSONResult(50008, "请确保信息填写完成再发布通知", "");
    }
}
