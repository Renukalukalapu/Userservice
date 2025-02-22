package com.userservice.user.Security.repositories;

import java.util.Optional;

//import sample.jpa.entity.client.Client;

import com.userservice.user.Security.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}