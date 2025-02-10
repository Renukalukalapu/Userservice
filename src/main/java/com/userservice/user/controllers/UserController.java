package com.userservice.user.controllers;


import com.userservice.user.dto.SignupRequestDto;
import com.userservice.user.dto.UserDto;
import com.userservice.user.models.User;
import com.userservice.user.services.Userservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    public Userservice userservice;
    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }
    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signdto) {
        User user = userservice.signup(signdto.getUsername(),signdto.getEmail(),signdto.getPassword());
        return UserDto.fromUser(user);
    }


}
