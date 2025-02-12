package com.userservice.user.services;

import com.userservice.user.exceptions.Usernotfoundexception;
import com.userservice.user.models.Token;
import com.userservice.user.models.User;
import com.userservice.user.repositories.TokenRepository;
import com.userservice.user.repositories.userrepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class Userservice {
    public userrepository userrepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    public TokenRepository tokenRepository;
    //private User save;

    public Userservice(userrepository userrepository,BCryptPasswordEncoder bCryptPasswordEncoder,TokenRepository tokenRepository) {
        this.userrepository = userrepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository=tokenRepository;
    }
    public User signup(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setHashedpassword(bCryptPasswordEncoder.encode(password));
        user.setIsemailverified(true);
        return userrepository.save(user);
    }

    public Token login(String email, String password)  {
        Optional<User> Ouser = userrepository.findByEmail(email);
        if(Ouser==null){
           throw new Usernotfoundexception("user with give email"+ email+"not found.");
        }
        User user = Ouser.get();
        if(!bCryptPasswordEncoder.matches(password,user.getHashedpassword())){
            return null;
        }
        Token token = tokengenerate(user);
        Token savedtoken =tokenRepository.save(token);
        return token;
    }

    private Token tokengenerate(User user) {
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);

        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Token token = new Token();
        token.setExpirydate(expiryDate);
        token.setUser(user);

        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        return token;
    }

    public void logout(String value) {
        Optional<Token> optionaltoken = tokenRepository.getByValueAndDeleted(value,false);
        if(optionaltoken==null){
            return;
        }
        Token token = optionaltoken.get();
        token.setDeleted(true);
        tokenRepository.save(token);
    }

    public User validate(String token) {
        Optional<Token> otoken = tokenRepository.findByValueAndDeletedAndExpirydateGreaterThan(token,false,new Date());
        if(otoken.isEmpty()){
            throw new Usernotfoundexception("Unauthorized access");
        }
        Token token2 = otoken.get();
        return token2.getUser();
    }
}
