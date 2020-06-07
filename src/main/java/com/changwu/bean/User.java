package com.changwu.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "department", unique = true, nullable = false)
    private String department;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    // 名称
    @Column(name = "name", columnDefinition = "varchar(64) default ''")
    private String name;

    // 状态
    // 0: 正常
    // 1: 禁用
    @Column(name = "status", columnDefinition = "int(1) default 0")
    private int status;

    // 角色列表
    @Column(name = "roles", columnDefinition = "varchar(64) default ''")
    private String rolesDto;

    @Transient
    private List<Role> roles;

    public User() {

    }
    public User(String name,List<Role> roles) {
        this.name=name;
        this.roles=roles;
    }

    public User(String username,String password,String name, int status) {
        this.username = username;
        this.password=password;
        this.name=name;
        this.status=status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRolesDto() {
        return rolesDto;
    }

    public void setRolesDto(String rolesDto) {
        this.rolesDto = rolesDto;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}