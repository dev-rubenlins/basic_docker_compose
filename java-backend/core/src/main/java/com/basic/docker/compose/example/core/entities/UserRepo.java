package com.basic.docker.compose.example.core.entities;

public interface UserRepo {

    boolean userExists(String email);

    void saveUser(User user);

}
