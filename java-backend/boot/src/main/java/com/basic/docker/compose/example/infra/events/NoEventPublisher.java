package com.basic.docker.compose.example.infra.events;

import com.basic.docker.compose.example.clean_arch.util.Event;
import com.basic.docker.compose.example.clean_arch.util.EventPublisher;

public class NoEventPublisher implements EventPublisher {

    @Override
    public void publish(Event event) {
        //TODO this is a "do nothing" event publisher implementation
        //In the future, We'll have a Rabbit MQ Event Publisher implementation
    }

}
