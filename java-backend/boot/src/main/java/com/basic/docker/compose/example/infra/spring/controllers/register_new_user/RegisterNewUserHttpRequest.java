package com.basic.docker.compose.example.infra.spring.controllers.register_new_user;

import com.basic.docker.compose.example.use_cases.RegisterNewUserRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true)
public class RegisterNewUserHttpRequest extends RegisterNewUserRequest {

    @JsonCreator
    public RegisterNewUserHttpRequest(@JsonDeserialize(using = UUIDDeserializer.class) UUID requestID, LocalDateTime datetime, String email, String password) {
        super(requestID, datetime, email, password);
    }

}
