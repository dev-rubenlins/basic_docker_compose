package com.basic.docker.compose.example.clean_arch.util;

public interface UseCase<T extends UseCaseRequest, V extends UseCaseResponse> {

    V execute(T request);

}
