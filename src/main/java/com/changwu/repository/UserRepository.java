package com.changwu.repository;


import com.changwu.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findUserByUsername(String username);

     User findUserByParentrole(String id);


}
