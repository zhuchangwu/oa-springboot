package com.changwu.repository;

import com.changwu.bean.Role;
import com.changwu.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    default User findUserByUsername(String username) {
        List<Role> list = new ArrayList<>();
        list.add(Role.ROLE_ADMIN);
        User user = new User("朱昌武",list);
        user.setId(1);
        return user;
    }

}
