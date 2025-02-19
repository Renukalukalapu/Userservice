package com.userservice.user.Security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.userservice.user.models.Role;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;

    public CustomGrantedAuthority(Role role) {
        if (role != null) {
            this.authority = role.getValue();
        }
    }


    @Override
    public String getAuthority() {
        return "";
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
