package com.basic.docker.compose.example.infra.spring.config;

import com.basic.docker.compose.example.clean_arch.util.EventPublisher;
import com.basic.docker.compose.example.infra.events.NoEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {

    @Bean
    public EventPublisher eventPublisher(){
        return new NoEventPublisher();
    }

}
