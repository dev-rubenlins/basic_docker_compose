package com.basic.docker.compose.example.infra.spring.config;

import com.basic.docker.compose.example.clean_arch.util.EventPublisher;
import com.basic.docker.compose.example.entities.UserFactory;
import com.basic.docker.compose.example.infra.spring.controllers.register_new_user.RegisterNewUserHttpPresenter;
import com.basic.docker.compose.example.use_cases.RegisterNewUser;
import com.basic.docker.compose.example.use_cases.RegisterNewUserFactory;
import com.basic.docker.compose.example.use_cases.RegisterNewUserPresenter;
import com.basic.docker.compose.example.use_cases.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterNewUserConfig {

    private final EventPublisher eventPublisher;
    private final UserFactory userFactory;

    @Autowired
    public RegisterNewUserConfig(EventPublisher eventPublisher, UserFactory userFactory) {
        this.eventPublisher = eventPublisher;
        this.userFactory = userFactory;
    }

    @Bean
    public RegisterNewUserFactory registerNewUserFactory(){
        return new RegisterNewUserFactory();
    }

    @Bean
    public RegisterNewUserPresenter registerNewUserPresenter(){
        return new RegisterNewUserHttpPresenter();
    }

    @Bean
    public RegisterNewUser registerNewUser(UserGateway userGateway){
        return registerNewUserFactory()
                .registerNewUser(
                        userGateway,
                        userFactory,
                        eventPublisher,
                        registerNewUserPresenter());
    }

}
