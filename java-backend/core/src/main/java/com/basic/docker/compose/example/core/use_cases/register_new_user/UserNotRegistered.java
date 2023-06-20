package com.basic.docker.compose.example.core.use_cases.register_new_user;

import br.dev.rubenlins.clean_architecture.basics.Event;
import br.dev.rubenlins.clean_architecture.basics.ResultType;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserNotRegistered extends Event {

    public UserNotRegistered(UUID requestID) {
        super(requestID, ResultType.FAIL);
    }

}
