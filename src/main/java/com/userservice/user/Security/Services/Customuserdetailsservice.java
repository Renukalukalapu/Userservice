package com.userservice.user.Security.Services;

import com.userservice.user.Security.models.customUserdetails;
import com.userservice.user.models.User;
import com.userservice.user.repositories.userrepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Customuserdetailsservice implements UserDetailsService {

   private userrepository userrepository;

    public Customuserdetailsservice(userrepository userrepository) {
        this.userrepository = userrepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userrepository.findByEmail(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("user not found");

        customUserdetails customuser = new customUserdetails(user.get());
        return customuser;
    }
}
