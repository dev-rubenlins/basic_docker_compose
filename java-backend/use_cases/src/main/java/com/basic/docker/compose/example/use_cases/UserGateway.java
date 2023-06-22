package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.entities.User;

public interface UserGateway {

    boolean userExists(String email);

    void save(User user);

}
