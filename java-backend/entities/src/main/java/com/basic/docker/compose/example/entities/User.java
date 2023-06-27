package com.basic.docker.compose.example.entities;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;

import java.util.UUID;

public interface User {

    UUID getId();
    String getEmail();
    String getPassword();

    OperationResult changePassword(String newPassword);

}
