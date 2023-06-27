package com.basic.docker.compose.example.clean_arch.util;

public interface UseCasePresenter<T extends UseCaseResponse> {

    T prepareSuccessView(T response);

    T prepareFailView(T response);

}
