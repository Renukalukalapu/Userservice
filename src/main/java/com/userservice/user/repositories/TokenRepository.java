package com.userservice.user.repositories;

import com.userservice.user.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    Optional<Token> getByValueAndDeleted(String value, boolean b);

    Optional<Token> findByValueAndDeletedAndExpirydateGreaterThan(String token, boolean b, Date date);
}
