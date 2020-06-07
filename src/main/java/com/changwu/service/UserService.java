package com.changwu.service;

import com.changwu.bean.Role;
import com.changwu.bean.User;
import com.changwu.repository.UserRepository;
import com.changwu.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    final
    AuthenticationManager manager;
    final
    PasswordEncoder passwordEncoder;
    final
    JwtTokenProvider jwtTokenProvider;
    final
    UserRepository userRepository;

    public UserService(AuthenticationManager manager, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.manager = manager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    // 登陆
    public String login(String username, String password) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userRepository.findUserByUsername(username);
        List<Role> list = new ArrayList<>();
        if (user.getRolesDto().equals("staff")) {
            list.add(Role.ROLE_STAFF);
        } else if (user.getRolesDto().equals("manager")) {
            list.add(Role.ROLE_MANAGER);
        } else if (user.getRolesDto().equals("boss")) {
            list.add(Role.ROLE_BOSS);
        }
        user.setRoles(list);
        return jwtTokenProvider.createToken(username, user.getRoles(), user.getId());
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
