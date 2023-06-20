package com.basic.docker.compose.example.core.use_cases.register_new_user;

import br.dev.rubenlins.clean_architecture.basics.OperationResult;
import br.dev.rubenlins.clean_architecture.basics.UseCaseResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class RegisterNewUserResponse extends UseCaseResponse {

    public RegisterNewUserResponse(@NotNull UUID requestID,
                                   @NotNull OperationResult operationResult) {
        super(requestID, operationResult);
    }

}
