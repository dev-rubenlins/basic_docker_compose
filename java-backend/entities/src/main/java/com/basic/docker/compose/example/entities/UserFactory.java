package com.basic.docker.compose.example.entities;

import com.basic.docker.compose.example.entities.internal.CommonUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserFactory {

    public User newUser(String email, String password) {
        return new CommonUser(email, password);
    }

    public User loadUser(@NotNull UUID id, @Email String email, @NotNull @Min(6) String password){
        return new CommonUser(id, email, password);
    }

}
