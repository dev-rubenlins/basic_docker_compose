package com.basic.docker.compose.example.use_cases;

import br.dev.rubenlins.clean_architecture.basics.UseCaseRequest;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class RegisterNewUserRequest extends UseCaseRequest {

    private final String email;
    private final String password;

    public RegisterNewUserRequest(UUID requestID,
                                  LocalDateTime datetime,
                                  String email,
                                  String password) {
        super(requestID, datetime);
        this.email = email;
        this.password = password;
    }
}
