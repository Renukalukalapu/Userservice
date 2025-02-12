package com.userservice.user.controllers;


import com.userservice.user.dto.LoginRequestDto;
import com.userservice.user.dto.LogoutRequestDto;
import com.userservice.user.dto.SignupRequestDto;
import com.userservice.user.dto.UserDto;
import com.userservice.user.models.Token;
import com.userservice.user.models.User;
import com.userservice.user.services.Userservice;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto logindto){
        Token token = userservice.login(logindto.getEmail(),logindto.getPassword());
        return token;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutdto){
        userservice.logout(logoutdto.getValue());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/validate/{token}")
    public UserDto validate(@PathVariable("token") String token){
        User user = userservice.validate(token);
        return UserDto.fromUser(user);
    }



}
