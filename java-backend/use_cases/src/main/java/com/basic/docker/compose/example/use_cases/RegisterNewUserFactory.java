package com.basic.docker.compose.example.use_cases;

import com.basic.docker.compose.example.clean_arch.util.EventPublisher;
import com.basic.docker.compose.example.entities.UserFactory;
import com.basic.docker.compose.example.use_cases.internal.RegisterNewUserUseCase;

public class RegisterNewUserFactory {

    public RegisterNewUser registerNewUser(UserGateway userGateway,
                                           UserFactory userFactory,
                                           EventPublisher eventPublisher,
                                           RegisterNewUserPresenter userPresenter){
        return new RegisterNewUserUseCase(
                userGateway, userFactory,
                eventPublisher,userPresenter);
    }
}
