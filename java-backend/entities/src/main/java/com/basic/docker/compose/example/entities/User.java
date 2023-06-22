package com.basic.docker.compose.example.entities;

import br.dev.rubenlins.clean_architecture.basics.OperationResult;

import java.util.UUID;

public interface User {

    UUID getId();
    String getEmail();
    String getPassword();

    OperationResult changePassword(String newPassword);

}
