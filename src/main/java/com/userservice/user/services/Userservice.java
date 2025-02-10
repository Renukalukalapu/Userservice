package com.userservice.user.services;

import com.userservice.user.models.User;
import com.userservice.user.repositories.userrepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    public userrepository userrepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    //private User save;

    public Userservice(userrepository userrepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userrepository = userrepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User signup(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setHashedpassword(bCryptPasswordEncoder.encode(password));
        user.setIsemailverified(true);
        return userrepository.save(user);
    }
}
