package com.changwu.repository;

import com.changwu.bean.Role;
import com.changwu.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findUserByUsername(String username);

}
