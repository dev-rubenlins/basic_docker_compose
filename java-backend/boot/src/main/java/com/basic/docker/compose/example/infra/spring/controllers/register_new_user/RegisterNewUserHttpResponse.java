package com.basic.docker.compose.example.infra.spring.controllers.register_new_user;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.use_cases.RegisterNewUserResponse;

import java.util.UUID;

public class RegisterNewUserHttpResponse extends RegisterNewUserResponse {

    public RegisterNewUserHttpResponse(UUID requestID, OperationResult operationResult) {
        super(requestID, operationResult);
    }

    public RegisterNewUserHttpResponse(RegisterNewUserResponse response) {
        super(response.getRequestID(), response.getOperationResult());
    }
}
