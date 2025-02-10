package com.userservice.user.dto;

import com.userservice.user.models.Role;
import com.userservice.user.models.User;
import com.userservice.user.services.Userservice;

import java.util.List;

public class UserDto {
    private String username;
    private String email;
    private List<Role> roles;

    public static UserDto fromUser(User user){
        if(user == null) return null;
        UserDto dto = new UserDto();
        dto.username = user.getUsername();
        dto.email = user.getEmail();
        dto.roles = user.getRoles();
        return dto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
