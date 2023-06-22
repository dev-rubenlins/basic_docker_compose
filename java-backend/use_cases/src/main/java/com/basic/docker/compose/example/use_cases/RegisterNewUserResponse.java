package com.basic.docker.compose.example.use_cases;

import br.dev.rubenlins.clean_architecture.basics.OperationResult;
import br.dev.rubenlins.clean_architecture.basics.UseCaseResponse;

import java.util.UUID;

public class RegisterNewUserResponse extends UseCaseResponse {

    public RegisterNewUserResponse(UUID requestID, OperationResult operationResult) {
        super(requestID, operationResult);
    }

}
