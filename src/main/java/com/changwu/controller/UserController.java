package com.changwu.controller;

import com.changwu.bean.Role;
import com.changwu.bean.User;
import com.changwu.security.JwtTokenProvider;
import com.changwu.service.UserService;
import com.changwu.vo.JSONResult;
import com.changwu.vo.UserFromInfo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final
    JwtTokenProvider provider;

    final
    UserService userService;

    public UserController(JwtTokenProvider provider, UserService userService) {
        this.provider = provider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public JSONResult login(@RequestBody UserFromInfo info) {
        String token = userService.login(info.getUsername(), info.getPassword());
        return JSONResult.responseToken(200, token);
    }

    @GetMapping("/getInfo")
    public JSONResult getInfo(HttpServletRequest request) {
        String token = provider.resolve(request);
        String username = provider.getUsername(token);
        User user = userService.findUserByUsername(username);
        List<Role> list = new ArrayList<>();
        if (user.getRolesDto().equals("staff")) {
            list.add(Role.ROLE_STAFF);
        } else if (user.getRolesDto().equals("manager")) {
            list.add(Role.ROLE_MANAGER);
        } else if (user.getRolesDto().equals("boss")) {
            list.add(Role.ROLE_BOSS);
        }
        user.setRoles(list);

        return JSONResult.build(200, "ok", user);
    }

}
