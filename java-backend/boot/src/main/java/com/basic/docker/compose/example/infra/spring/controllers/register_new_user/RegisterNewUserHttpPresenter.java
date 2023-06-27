package com.basic.docker.compose.example.infra.spring.controllers.register_new_user;

import com.basic.docker.compose.example.use_cases.RegisterNewUserPresenter;
import com.basic.docker.compose.example.use_cases.RegisterNewUserResponse;

public class RegisterNewUserHttpPresenter implements RegisterNewUserPresenter {
    @Override
    public RegisterNewUserResponse prepareSuccessView(RegisterNewUserResponse registerNewUserResponse) {
        //TODO no response personalization here yet
        return registerNewUserResponse;
    }

    @Override
    public RegisterNewUserResponse prepareFailView(RegisterNewUserResponse registerNewUserResponse) {
        //TODO no response personalization here yet
        return new RegisterNewUserHttpResponse(registerNewUserResponse);
    }
}
