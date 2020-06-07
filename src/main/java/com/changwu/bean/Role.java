package com.changwu.bean;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    ROLE_STAFF,ROLE_MANAGER, ROLE_BOSS;
    @Override
    public String getAuthority() {
        return name();
    }
}
