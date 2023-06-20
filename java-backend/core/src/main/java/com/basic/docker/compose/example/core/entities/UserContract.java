package com.basic.docker.compose.example.core.entities;

import java.util.UUID;

public interface UserContract {

    UUID getId();
    void setId(UUID id);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    /*default <T extends UserContract> UserContract createNew(T userType){
        new T();
        return null;
    }*/
}
