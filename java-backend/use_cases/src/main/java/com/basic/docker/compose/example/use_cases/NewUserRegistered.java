package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.clean_arch.util.Event;
import com.basic.docker.compose.example.clean_arch.util.ResultType;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class NewUserRegistered extends Event {
    NewUserRegistered(UUID requestID) {
        super(requestID, ResultType.SUCCESS);
    }
}
