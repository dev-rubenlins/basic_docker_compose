package com.basic.docker.compose.example.core.use_cases.register_new_user;


import br.dev.rubenlins.clean_architecture.basics.UseCaseRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class RegisterNewUserRequest extends UseCaseRequest {

    private final String email;
    private final String pasword;

    public RegisterNewUserRequest(@NotNull UUID requestID,
                                  @NotNull LocalDateTime datetime,
                                  @Email @NotNull String email,
                                  @Min(6) @NotNull String pasword) {
        super(requestID, datetime);
        this.email = email;
        this.pasword = pasword;
    }
}
