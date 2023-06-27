package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.clean_arch.util.OperationResult;
import com.basic.docker.compose.example.clean_arch.util.UseCaseResponse;

import java.util.UUID;

public class RegisterNewUserResponse extends UseCaseResponse {

    public RegisterNewUserResponse(UUID requestID, OperationResult operationResult) {
        super(requestID, operationResult);
    }

}
