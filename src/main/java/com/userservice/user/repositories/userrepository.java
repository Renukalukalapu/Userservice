package com.userservice.user.repositories;

import com.userservice.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends JpaRepository<User, Long> {


}
