package com.changwu.security;

import com.changwu.bean.Role;
import com.changwu.bean.User;
import com.changwu.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Changwu
 * @Date: 2019-12-30 17:18
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

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

        // 一旦在下面填充 username password  roles 一但出现了 null , SpringSecurity都会认为数据库中是没有这个人的记录的
        // 因此会在　DaoAuthenticationProvider中 抛出 InternalAuthenticationServiceException
        return org.springframework.security.core.userdetails.User//
                .withUsername(user.getUsername())//
                .password(user.getPassword())//
                .authorities(list)//
                .accountExpired(false)// 不过期
                .accountLocked(false)// 未锁定
                .credentialsExpired(false)// 资格证书未过期
                .disabled(false)// 有效
                .build();
    }
}

