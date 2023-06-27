package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.clean_arch.util.UseCaseRequest;
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
