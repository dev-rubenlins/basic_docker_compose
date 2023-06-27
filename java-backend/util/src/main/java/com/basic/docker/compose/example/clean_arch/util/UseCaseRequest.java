package com.basic.docker.compose.example.clean_arch.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public abstract class UseCaseRequest {

    private final UUID requestID;
    private final LocalDateTime datetime;

}
