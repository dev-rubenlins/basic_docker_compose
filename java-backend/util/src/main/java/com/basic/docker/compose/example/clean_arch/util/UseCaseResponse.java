package com.basic.docker.compose.example.clean_arch.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class UseCaseResponse {

    private final UUID requestID;
    private final OperationResult operationResult;

}
