package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {

    boolean userExists(String email);

    void save(User user);

    Optional<User> findById(UUID userId);

}
