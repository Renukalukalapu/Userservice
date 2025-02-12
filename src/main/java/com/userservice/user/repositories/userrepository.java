package com.userservice.user.repositories;

import com.userservice.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userrepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}
