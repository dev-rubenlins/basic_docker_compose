package com.basic.docker.compose.example.infra.spring.config;

import com.basic.docker.compose.example.entities.UserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserFactory userFactory(){
        return new UserFactory();
    }

}
